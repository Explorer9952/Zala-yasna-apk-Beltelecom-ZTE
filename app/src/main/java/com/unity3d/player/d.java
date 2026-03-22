package com.unity3d.player;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import com.zte.ucs.tvcall.Commons;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class d implements b {
    private static boolean a(PackageItemInfo packageItemInfo) {
        try {
            return packageItemInfo.metaData.getBoolean("unityplayer.SkipPermissionsDialog");
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.unity3d.player.b
    public final void a(Activity activity, final Runnable runnable) {
        if (activity == null) {
            return;
        }
        PackageManager packageManager = activity.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(activity.getComponentName(), Commons.MSG_MCSP_INIT_SUCCESS);
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(activity.getPackageName(), Commons.MSG_MCSP_INIT_SUCCESS);
            if (a(activityInfo) || a(applicationInfo)) {
                runnable.run();
                return;
            }
        } catch (Exception unused) {
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 4096);
            if (packageInfo.requestedPermissions == null) {
                packageInfo.requestedPermissions = new String[0];
            }
            final LinkedList linkedList = new LinkedList();
            for (String str : packageInfo.requestedPermissions) {
                try {
                    if (packageManager.getPermissionInfo(str, Commons.MSG_MCSP_INIT_SUCCESS).protectionLevel == 1 && activity.checkCallingOrSelfPermission(str) != 0) {
                        linkedList.add(str);
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    c.Log(5, "Failed to get permission info for " + str + ", manifest likely missing custom permission declaration");
                    c.Log(5, "Permission " + str + " ignored");
                }
            }
            if (linkedList.isEmpty()) {
                runnable.run();
                return;
            }
            final FragmentManager fragmentManager = activity.getFragmentManager();
            Fragment fragment = new Fragment() { // from class: com.unity3d.player.d.1
                @Override // android.app.Fragment
                public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    if (i != 15881) {
                        return;
                    }
                    for (int i2 = 0; i2 < strArr.length && i2 < iArr.length; i2++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(strArr[i2]);
                        sb.append(iArr[i2] == 0 ? " granted" : " denied");
                        c.Log(4, sb.toString());
                    }
                    FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                    beginTransaction.remove(this);
                    beginTransaction.commit();
                    runnable.run();
                }

                @Override // android.app.Fragment
                public final void onStart() {
                    super.onStart();
                    requestPermissions((String[]) linkedList.toArray(new String[0]), 15881);
                }
            };
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(0, fragment);
            beginTransaction.commit();
        } catch (Exception e) {
            c.Log(6, "Unable to query for permission: " + e.getMessage());
        }
    }
}
