package com.zte.iptvclient.android.common.i.c;

import android.text.TextUtils;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.k.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.w3c.dom.Element;

/* compiled from: CommonFun.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4651a = "a";

    private static void a(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    g.b(file.getAbsolutePath(), "delete");
                    if (!file.delete()) {
                        throw new RuntimeException("delete failed");
                    }
                }
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        a(file2);
                    }
                }
            }
            g.b(file.getAbsolutePath(), "delete");
            if (!file.delete()) {
                throw new RuntimeException("delete failed");
            }
        }
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            LogEx.d(f4651a, "path is empty");
            return;
        }
        LogEx.d(f4651a, "strFilePath: " + str);
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        if (file.getParentFile() != null && !file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            LogEx.d(f4651a, "create file failed!");
            return;
        }
        try {
            g.b(file.getAbsolutePath(), "createNewFile");
            if (file.createNewFile()) {
                return;
            }
            LogEx.d(f4651a, "createNewFile Failed!");
        } catch (Exception e) {
            LogEx.d(f4651a, "createFile e=" + e.getMessage());
        }
    }

    public static void c(String str) {
        a(new File(str));
    }

    public static InputStream d(String str) {
        if (TextUtils.isEmpty(str)) {
            LogEx.d(f4651a, "strFileURI is null");
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            LogEx.d(f4651a, "Not Exist File,strFileURI: " + str);
            return null;
        }
        try {
            return new FileInputStream(file);
        } catch (Exception e) {
            e.printStackTrace();
            LogEx.d(f4651a, "Inavlid strFileURI: " + str);
            return null;
        }
    }

    public static String a(Element element) {
        return (element == null || element.getFirstChild() == null) ? "" : element.getFirstChild().getNodeValue();
    }

    public static boolean a(String str) {
        String a2 = b.b().a();
        if (TextUtils.isEmpty(a2)) {
            a2 = "";
        }
        LogEx.d(f4651a, "serverVersion=" + str + ",localVersion=" + a2);
        return a(str, a2);
    }

    private static boolean a(String str, String str2) {
        String trim = str.trim();
        String trim2 = str2.trim();
        if (trim.equals(trim2)) {
            return false;
        }
        String[] split = trim.split("\\.");
        String[] split2 = trim2.split("\\.");
        int length = split.length - 1;
        int i = length;
        int i2 = 0;
        while (i >= 0) {
            String str3 = f4651a;
            StringBuilder sb = new StringBuilder();
            sb.append("aa:");
            sb.append(split[i]);
            sb.append("*");
            double d2 = (length - i) * 2;
            String[] strArr = split;
            sb.append(Math.pow(10.0d, d2));
            LogEx.d(str3, sb.toString());
            double d3 = i2;
            double intValue = Integer.valueOf(strArr[i]).intValue();
            double pow = Math.pow(10.0d, d2);
            Double.isNaN(intValue);
            Double.isNaN(d3);
            i2 = (int) (d3 + (intValue * pow));
            i--;
            split = strArr;
        }
        int i3 = 0;
        for (int length2 = split.length - 1; length2 >= 0; length2--) {
            double d4 = i3;
            double intValue2 = Integer.valueOf(split2[length2]).intValue();
            double pow2 = Math.pow(10.0d, (r3 - length2) * 2);
            Double.isNaN(intValue2);
            Double.isNaN(d4);
            i3 = (int) (d4 + (intValue2 * pow2));
        }
        LogEx.d(f4651a, "strServerVersion:" + trim + " ;strLocalVersion:" + trim2);
        LogEx.d(f4651a, "serverVersion:" + i2 + " ;localVersion:" + i3);
        return i2 > i3;
    }
}
