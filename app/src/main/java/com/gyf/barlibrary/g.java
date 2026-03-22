package com.gyf.barlibrary;

import android.text.TextUtils;

/* compiled from: OSUtils.java */
/* loaded from: classes.dex */
public class g {
    public static String a() {
        return e() ? a("ro.build.version.emui", "") : "";
    }

    private static String b() {
        return a("ro.build.display.id", "");
    }

    public static String c() {
        return i() ? a("ro.build.display.id", "") : "";
    }

    public static String d() {
        return k() ? a("ro.miui.ui.version.name", "") : "";
    }

    public static boolean e() {
        return !TextUtils.isEmpty(a("ro.build.version.emui", ""));
    }

    public static boolean f() {
        return a().contains("EmotionUI_3.0");
    }

    public static boolean g() {
        String a2 = a();
        return "EmotionUI 3".equals(a2) || a2.contains("EmotionUI_3.1");
    }

    public static boolean h() {
        return f() || g();
    }

    public static boolean i() {
        return b().toLowerCase().contains("flyme");
    }

    public static boolean j() {
        int intValue;
        String c2 = c();
        if (c2.isEmpty()) {
            return false;
        }
        try {
            if (c2.toLowerCase().contains("os")) {
                intValue = Integer.valueOf(c2.substring(9, 10)).intValue();
            } else {
                intValue = Integer.valueOf(c2.substring(6, 7)).intValue();
            }
            return intValue >= 4;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean k() {
        return !TextUtils.isEmpty(a("ro.miui.ui.version.name", ""));
    }

    public static boolean l() {
        String d2 = d();
        if (d2.isEmpty()) {
            return false;
        }
        try {
            return Integer.valueOf(d2.substring(1)).intValue() >= 6;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    private static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }
}
