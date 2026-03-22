package com.zte.iptvclient.android.common.k;

import java.util.Locale;

/* compiled from: StringUtils.java */
/* loaded from: classes.dex */
public class w {
    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        String[] split = str.split("\\.");
        for (int i = 0; i < split.length; i++) {
            while (split[i].length() < 3) {
                split[i] = "0" + split[i];
            }
            if (i != split.length - 1) {
                split[i] = split[i] + ".";
            }
        }
        for (String str2 : split) {
            sb.append(str2);
        }
        return sb.toString();
    }

    public static String b(double d2) {
        return String.format(Locale.ENGLISH, "%.2f", Double.valueOf(d2));
    }

    public static String c(double d2) {
        double a2 = com.zte.iptvclient.android.mobile.e0.f.j.a();
        Double.isNaN(a2);
        return b(d2 / a2);
    }

    public static String b(String str) {
        try {
            Double valueOf = Double.valueOf(str);
            return valueOf.doubleValue() >= 0.0d ? a(valueOf.doubleValue()) : "--";
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "--";
        }
    }

    public static String a(double d2) {
        String format = String.format(Locale.ENGLISH, "%.2f", Double.valueOf(d2));
        return format.substring(0, format.length() - 1);
    }

    public static String a(float f) {
        String format = String.format(Locale.ENGLISH, "%.2f", Float.valueOf(f));
        return format.substring(0, format.length() - 1);
    }
}
