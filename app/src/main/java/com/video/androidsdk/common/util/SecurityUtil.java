package com.video.androidsdk.common.util;

import java.io.FilePermission;

/* loaded from: classes.dex */
public class SecurityUtil {
    private static final SecurityManager security = System.getSecurityManager();

    public static void securityCheck(String str, String str2) {
        SecurityManager securityManager = security;
        if (securityManager != null) {
            securityManager.checkPermission(new FilePermission(str, str2));
        }
    }
}
