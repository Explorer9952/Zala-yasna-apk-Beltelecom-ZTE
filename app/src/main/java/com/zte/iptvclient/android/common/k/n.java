package com.zte.iptvclient.android.common.k;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.video.androidsdk.log.LogEx;

/* compiled from: PackageUtil.java */
/* loaded from: classes.dex */
public class n {
    public static boolean a(Context context, String str) {
        for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(1)) {
            LogEx.d("packageName", packageInfo.packageName);
            if (str != null && packageInfo.packageName.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
