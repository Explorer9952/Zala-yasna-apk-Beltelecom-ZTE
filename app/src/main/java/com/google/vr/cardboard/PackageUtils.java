package com.google.vr.cardboard;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.zte.ucs.tvcall.Commons;

/* loaded from: classes.dex */
public class PackageUtils {
    private static final String GOOGLE_PACKAGE_PREFIX = "com.google.";

    public static boolean isGooglePackage(String str) {
        return str != null && str.startsWith(GOOGLE_PACKAGE_PREFIX);
    }

    public static boolean isSystemPackage(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            int i = applicationInfo != null ? applicationInfo.flags : 0;
            return ((i & 1) == 0 && (i & Commons.MSG_MCSP_INIT_SUCCESS) == 0) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
