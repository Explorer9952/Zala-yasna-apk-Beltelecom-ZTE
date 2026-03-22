package com.tencent.stat.i;

import java.io.File;

/* loaded from: classes.dex */
class p {

    /* renamed from: a, reason: collision with root package name */
    private static int f2892a = -1;

    public static boolean a() {
        int i = f2892a;
        if (i == 1) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        String[] strArr = {"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i2 = 0; i2 < 6; i2++) {
            try {
                if (new File(strArr[i2] + "su").exists()) {
                    f2892a = 1;
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        f2892a = 0;
        return false;
    }
}
