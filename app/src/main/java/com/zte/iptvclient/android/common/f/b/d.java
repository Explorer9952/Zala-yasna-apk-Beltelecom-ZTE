package com.zte.iptvclient.android.common.f.b;

import android.content.Context;
import android.os.Environment;
import com.video.androidsdk.log.LogEx;
import java.io.File;
import java.math.BigDecimal;

/* compiled from: CacheDateMgr.java */
/* loaded from: classes.dex */
public class d {
    public static String a(double d2) {
        double d3 = d2 / 1024.0d;
        if (d3 < 1.0d) {
            return "0MB";
        }
        return new BigDecimal(Double.toString(d3 / 1024.0d)).setScale(2, 4).toPlainString() + "MB";
    }

    public static long b(File file) throws Exception {
        long length;
        long j = 0;
        try {
            File[] listFiles = file.listFiles();
            LogEx.d("CacheDateMgr", "getFolderSizeFrom=" + file);
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isDirectory()) {
                        length = b(listFiles[i]);
                    } else {
                        length = listFiles[i].length();
                    }
                    j += length;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogEx.d("CacheDateMgr", "getFolder=" + file + "Size=" + j);
        return j;
    }

    public static void a(Context context) {
        a(context.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            a(context.getExternalCacheDir());
        }
    }

    public static boolean a(File file) {
        String[] list;
        if (file != null && file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        if (file == null) {
            return false;
        }
        com.zte.iptvclient.android.common.k.g.b(file.getAbsolutePath(), "delete");
        return file.delete();
    }

    public static String b(Context context) throws Exception {
        File externalCacheDir;
        if (context == null) {
            return "";
        }
        long b2 = b(context.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted") && (externalCacheDir = context.getExternalCacheDir()) != null) {
            b2 += b(externalCacheDir);
        }
        return a(b2);
    }
}
