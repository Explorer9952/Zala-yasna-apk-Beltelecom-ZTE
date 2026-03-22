package com.zte.iptvclient.android.mobile.download.helper.c;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.zala.R;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

/* compiled from: DownloadPathUtil.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static DecimalFormat f5766a = new DecimalFormat("#0");

    /* renamed from: b, reason: collision with root package name */
    private static DecimalFormat f5767b = new DecimalFormat("#0.#");

    public static String a(Context context, int i) {
        if (i == 0) {
            return context.getFilesDir().getAbsolutePath() + "/IPTV/Download/";
        }
        if (i != 1) {
            return i != 3 ? com.zte.iptvclient.android.common.i.a.a.a(R.string.wrong_store_path) : "/storage/udisk0/OTT_Download";
        }
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/IPTV/Download/";
    }

    public static long b(Context context) {
        try {
            String a2 = a(context, true);
            if (a2 == null) {
                return 0L;
            }
            StatFs statFs = new StatFs(new File(a2).getPath());
            long blockSize = statFs.getBlockSize();
            long blockCount = statFs.getBlockCount();
            StringBuilder sb = new StringBuilder();
            sb.append("getPhoneOutSDCardFreeSize=");
            long j = blockCount * blockSize;
            sb.append(j);
            LogEx.d("DownloadPathUtil", sb.toString());
            return j;
        } catch (Exception unused) {
            LogEx.e("DownloadPathUtil", "getPhoneOutSDCardSize=" + com.zte.iptvclient.android.common.i.a.a.a(R.string.wrong_store_path));
            return 0L;
        }
    }

    public static String c(File file) {
        double round = Math.round((b(file) / 1024.0f) * 100.0f);
        Double.isNaN(round);
        return ((float) (round / 100.0d)) + "MB";
    }

    public static String d() {
        return a(c());
    }

    public static long e() {
        return c(Environment.getDataDirectory().getPath());
    }

    public static String f() {
        return a(e());
    }

    public static long g() {
        return d(Environment.getDataDirectory().getPath());
    }

    public static String h() {
        return a(g());
    }

    public static long i() {
        return b(Environment.getExternalStorageDirectory().getPath());
    }

    public static long j() {
        return c(Environment.getExternalStorageDirectory().getPath());
    }

    public static long k() {
        return d(Environment.getExternalStorageDirectory().getPath());
    }

    public static String l() {
        return a(i());
    }

    public static String m() {
        return a(j());
    }

    public static String n() {
        return a(k());
    }

    public static Boolean o() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return true;
        }
        return false;
    }

    private static long d(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        StatFs statFs = new StatFs(str);
        return (((statFs.getBlockCount() - statFs.getAvailableBlocks()) * statFs.getBlockSize()) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    public static String a(Context context, boolean z) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = cls.getMethod("getPath", new Class[0]);
            Method method3 = cls.getMethod("isRemovable", new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i = 0; i < length; i++) {
                Object obj = Array.get(invoke, i);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (z == ((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    LogEx.w("DownloadPathUtil", "getPhoneOutSDCardPath=" + str);
                    return str;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
        LogEx.w("DownloadPathUtil", "getPhoneOutSDCardPath=null!");
        return null;
    }

    public static long c() {
        return b(Environment.getDataDirectory().getPath());
    }

    private static long c(String str) {
        if (str == null || TextUtils.equals(str, "")) {
            return 0L;
        }
        StatFs statFs = new StatFs(str);
        return ((statFs.getBlockCount() * statFs.getBlockSize()) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    public static long b() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return 0L;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        LogEx.d("DownloadPathUtil", "getPhoneSelfSDCardPath=" + externalStorageDirectory.getAbsolutePath());
        StatFs statFs = new StatFs(externalStorageDirectory.getPath());
        long blockSize = (long) statFs.getBlockSize();
        long blockCount = (long) statFs.getBlockCount();
        StringBuilder sb = new StringBuilder();
        sb.append("getPhoneSelfSDCardSize=");
        long j = blockCount * blockSize;
        sb.append(j);
        LogEx.d("DownloadPathUtil", sb.toString());
        return j;
    }

    private static float b(File file) {
        return ((float) a(file)) / 1024.0f;
    }

    private static long b(String str) {
        if (str == null || TextUtils.equals(str, "")) {
            return 0L;
        }
        StatFs statFs = new StatFs(str);
        return ((statFs.getFreeBlocks() * statFs.getBlockSize()) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    public static long a(Context context) {
        try {
            String a2 = a(context, true);
            if (a2 == null) {
                return 0L;
            }
            StatFs statFs = new StatFs(new File(a2).getPath());
            long blockSize = statFs.getBlockSize();
            long availableBlocks = statFs.getAvailableBlocks();
            StringBuilder sb = new StringBuilder();
            sb.append("getPhoneOutSDCardFreeSize=");
            long j = availableBlocks * blockSize;
            sb.append(j);
            LogEx.d("DownloadPathUtil", sb.toString());
            return j;
        } catch (Exception unused) {
            LogEx.e("DownloadPathUtil", "getPhoneOutSDCardFreeSize=" + com.zte.iptvclient.android.common.i.a.a.a(R.string.wrong_store_path));
            return 0L;
        }
    }

    public static long a() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return 0L;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        LogEx.d("DownloadPathUtil", "getPhoneSelfSDCardFreePath=" + externalStorageDirectory.getAbsolutePath());
        StatFs statFs = new StatFs(externalStorageDirectory.getPath());
        long blockSize = (long) statFs.getBlockSize();
        long availableBlocks = (long) statFs.getAvailableBlocks();
        StringBuilder sb = new StringBuilder();
        sb.append("getPhoneSelfSDCardFreeSize=");
        long j = availableBlocks * blockSize;
        sb.append(j);
        LogEx.d("DownloadPathUtil", sb.toString());
        return j;
    }

    public static String a(long j, boolean z) {
        DecimalFormat decimalFormat = z ? f5766a : f5767b;
        if (j < 1073741824) {
            StringBuilder sb = new StringBuilder();
            double d2 = j;
            Double.isNaN(d2);
            sb.append(decimalFormat.format(d2 / 1048576.0d));
            sb.append("MB");
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        double d3 = j;
        Double.isNaN(d3);
        sb2.append(decimalFormat.format(d3 / 1.073741824E9d));
        sb2.append("GB");
        return sb2.toString();
    }

    public static void a(String str) {
        File file = new File(str);
        if (file.exists() || file.isDirectory()) {
            return;
        }
        file.mkdirs();
    }

    private static long a(File file) {
        long a2;
        long j = 0;
        if (file == null || !file.isDirectory()) {
            return 0L;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    a2 = file2.length();
                } else if (file2.isDirectory()) {
                    j += file2.length();
                    a2 = a(file2);
                }
                j += a2;
            }
        }
        return j;
    }

    public static String a(long j) {
        double round = Math.round((((float) j) / 1024.0f) * 100.0f);
        Double.isNaN(round);
        return String.valueOf((float) (round / 100.0d)) + "GB";
    }
}
