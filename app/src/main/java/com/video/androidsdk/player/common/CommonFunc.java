package com.video.androidsdk.player.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.telephony.TelephonyManager;
import com.video.androidsdk.common.util.SecurityUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.IBasePlayer;
import com.visualon.OSMPPlayer.VOOSMPVerificationInfo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes.dex */
public class CommonFunc {
    public static SharedPreferences.Editor m_editor;
    public static SharedPreferences m_spMain;
    public static IBasePlayer player;

    private static String a(String str, String str2) throws IOException {
        String canonicalPath = new File(str).getCanonicalPath();
        if (canonicalPath.endsWith(new File(str2).getCanonicalPath())) {
            return canonicalPath;
        }
        throw new IllegalStateException("File is outside extraction target directory");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b8 A[Catch: all -> 0x00c9, IOException -> 0x00cb, TryCatch #8 {IOException -> 0x00cb, blocks: (B:27:0x00af, B:29:0x00b8, B:30:0x00bd), top: B:26:0x00af, outer: #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void addStringToFile(java.lang.String r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.player.common.CommonFunc.addStringToFile(java.lang.String, java.lang.String):void");
    }

    public static String bitrateToString(int i) {
        int i2 = i / 1000;
        if (i2 < 1000) {
            return Integer.toString(i2) + "kbps";
        }
        String f = Float.toString(i2 / 1000.0f);
        int indexOf = f.indexOf(46);
        if (indexOf >= 0 && indexOf < f.length() - 2) {
            f = f.substring(0, indexOf + 2);
        }
        return f + "Mbps";
    }

    public static boolean checkSDCard() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0083 -> B:15:0x0086). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void copyfile(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 0
            android.content.res.AssetManager r1 = r3.getAssets()     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d
            java.io.InputStream r4 = r1.open(r4)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L66
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L66
            r2.<init>()     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L66
            java.lang.String r3 = getUserPath(r3)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L66
            r2.append(r3)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L66
            java.lang.String r3 = "/"
            r2.append(r3)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L66
            r2.append(r5)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L66
            java.lang.String r3 = r2.toString()     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L66
            java.lang.String r5 = ".xml"
            java.lang.String r3 = a(r3, r5)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L66
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L66
            java.lang.String r3 = r1.getAbsolutePath()     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L66
            java.lang.String r5 = "createNewFile"
            com.video.androidsdk.common.util.SecurityUtil.securityCheck(r3, r5)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L66
            r1.createNewFile()     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L66
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L66
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L66
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
        L41:
            int r0 = r4.read(r5)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            r1 = -1
            if (r0 == r1) goto L4d
            r1 = 0
            r3.write(r5, r1, r0)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            goto L41
        L4d:
            r3.flush()     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L60
            if (r4 == 0) goto L5a
            r4.close()     // Catch: java.io.IOException -> L56
            goto L5a
        L56:
            r4 = move-exception
            r4.printStackTrace()
        L5a:
            r3.close()     // Catch: java.io.IOException -> L82
            goto L86
        L5e:
            r5 = move-exception
            goto L64
        L60:
            r5 = move-exception
            goto L68
        L62:
            r5 = move-exception
            r3 = r0
        L64:
            r0 = r4
            goto L88
        L66:
            r5 = move-exception
            r3 = r0
        L68:
            r0 = r4
            goto L6f
        L6a:
            r5 = move-exception
            r3 = r0
            goto L88
        L6d:
            r5 = move-exception
            r3 = r0
        L6f:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L87
            if (r0 == 0) goto L7c
            r0.close()     // Catch: java.io.IOException -> L78
            goto L7c
        L78:
            r4 = move-exception
            r4.printStackTrace()
        L7c:
            if (r3 == 0) goto L86
            r3.close()     // Catch: java.io.IOException -> L82
            goto L86
        L82:
            r3 = move-exception
            r3.printStackTrace()
        L86:
            return
        L87:
            r5 = move-exception
        L88:
            if (r0 == 0) goto L92
            r0.close()     // Catch: java.io.IOException -> L8e
            goto L92
        L8e:
            r4 = move-exception
            r4.printStackTrace()
        L92:
            if (r3 == 0) goto L9c
            r3.close()     // Catch: java.io.IOException -> L98
            goto L9c
        L98:
            r3 = move-exception
            r3.printStackTrace()
        L9c:
            goto L9e
        L9d:
            throw r5
        L9e:
            goto L9d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.player.common.CommonFunc.copyfile(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0069 -> B:16:0x006c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void copyfileTo(android.content.Context r2, java.lang.String r3, java.lang.String r4) {
        /*
            r0 = 0
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L53
            java.io.InputStream r2 = r2.open(r3)     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L53
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4c
            java.lang.String r3 = a(r4, r3)     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4c
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4c
            java.lang.String r3 = r1.getAbsolutePath()     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4c
            java.lang.String r4 = "createNewFile"
            com.video.androidsdk.common.util.SecurityUtil.securityCheck(r3, r4)     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4c
            r1.createNewFile()     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4c
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4c
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4c
            r4 = 4096(0x1000, float:5.74E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
        L27:
            int r0 = r2.read(r4)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            r1 = -1
            if (r0 == r1) goto L33
            r1 = 0
            r3.write(r4, r1, r0)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            goto L27
        L33:
            r3.flush()     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            if (r2 == 0) goto L40
            r2.close()     // Catch: java.io.IOException -> L3c
            goto L40
        L3c:
            r2 = move-exception
            r2.printStackTrace()
        L40:
            r3.close()     // Catch: java.io.IOException -> L68
            goto L6c
        L44:
            r4 = move-exception
            goto L4a
        L46:
            r4 = move-exception
            goto L4e
        L48:
            r4 = move-exception
            r3 = r0
        L4a:
            r0 = r2
            goto L6e
        L4c:
            r4 = move-exception
            r3 = r0
        L4e:
            r0 = r2
            goto L55
        L50:
            r4 = move-exception
            r3 = r0
            goto L6e
        L53:
            r4 = move-exception
            r3 = r0
        L55:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L6d
            if (r0 == 0) goto L62
            r0.close()     // Catch: java.io.IOException -> L5e
            goto L62
        L5e:
            r2 = move-exception
            r2.printStackTrace()
        L62:
            if (r3 == 0) goto L6c
            r3.close()     // Catch: java.io.IOException -> L68
            goto L6c
        L68:
            r2 = move-exception
            r2.printStackTrace()
        L6c:
            return
        L6d:
            r4 = move-exception
        L6e:
            if (r0 == 0) goto L78
            r0.close()     // Catch: java.io.IOException -> L74
            goto L78
        L74:
            r2 = move-exception
            r2.printStackTrace()
        L78:
            if (r3 == 0) goto L82
            r3.close()     // Catch: java.io.IOException -> L7e
            goto L82
        L7e:
            r2 = move-exception
            r2.printStackTrace()
        L82:
            goto L84
        L83:
            throw r4
        L84:
            goto L83
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.player.common.CommonFunc.copyfileTo(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static VOOSMPVerificationInfo creatVerificationInfo(String str) {
        VOOSMPVerificationInfo vOOSMPVerificationInfo = new VOOSMPVerificationInfo();
        vOOSMPVerificationInfo.setDataFlag(1);
        vOOSMPVerificationInfo.setVerificationString(str);
        return vOOSMPVerificationInfo;
    }

    public static String formatTime(long j) {
        long j2 = j / 60;
        return String.format(Locale.US, "%02d:%02d:%02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60), Long.valueOf(j % 60));
    }

    public static String getApkPath(Context context) {
        return "/data/data/" + context.getPackageName() + "/lib/";
    }

    public static SharedPreferences getApplicationSharedPreference() {
        return m_spMain;
    }

    public static String getDeviceIMEI(Context context) {
        String str;
        if (context == null) {
            return "";
        }
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (SecurityException e) {
            e.printStackTrace();
            str = null;
        }
        LogEx.d("CommonFunc", "strDeviceId=" + str);
        return str == null ? "" : str;
    }

    public static void getDownloadFiles(ArrayList<String> arrayList, String str) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null) {
            return;
        }
        try {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    File[] listFiles2 = file.listFiles();
                    if (listFiles2 == null) {
                        return;
                    }
                    boolean z = false;
                    for (File file2 : listFiles2) {
                        if (file2.getPath().contains(".manifest")) {
                            arrayList.add(file2.getPath());
                        }
                        if (file2.getPath().contains("Master.m3u8")) {
                            arrayList.add(file2.getPath());
                            z = true;
                        }
                    }
                    if (!z) {
                        for (File file3 : listFiles2) {
                            if (file3.getPath().contains("Video.m3u8")) {
                                arrayList.add(file3.getPath());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getLocalFiles(ArrayList<String> arrayList, String str) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null) {
            return;
        }
        try {
            for (File file : listFiles) {
                if (!file.isDirectory()) {
                    arrayList.add(file.getPath());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static IBasePlayer getPlayer() {
        return player;
    }

    public static String getStringPreferenceValue(String str) {
        SharedPreferences sharedPreferences = m_spMain;
        return sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
    }

    public static String getUserNativeLibPath(Context context) {
        String packageName = context.getPackageName();
        String str = "/data/data/" + packageName + "/lib/";
        try {
            str = context.getPackageManager().getPackageInfo(packageName, 0).applicationInfo.dataDir + "/lib/";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        try {
            str = a(str, "/lib/");
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        File file = new File(str);
        if (file.exists() && file.listFiles() != null) {
            return str;
        }
        try {
            return context.getPackageManager().getPackageInfo(packageName, 0).applicationInfo.nativeLibraryDir + "/";
        } catch (PackageManager.NameNotFoundException e3) {
            e3.printStackTrace();
            return str;
        }
    }

    public static String getUserPath(Context context) {
        String packageName = context.getPackageName();
        String str = "/data/data/" + packageName;
        try {
            return context.getPackageManager().getPackageInfo(packageName, 0).applicationInfo.dataDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static byte[] readAsset(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[16384];
                SecurityUtil.securityCheck(open.toString(), "read");
                while (true) {
                    int read = open.read(bArr, 0, 16384);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        return byteArray;
                    }
                }
            } finally {
                open.close();
            }
        } catch (Exception unused) {
            throw new RuntimeException("Could not load asset: " + str);
        }
    }

    public static void saveStringPreferenceValue(String str, String str2) {
        SharedPreferences.Editor editor = m_editor;
        if (editor != null) {
            editor.putString(str, str2);
            m_editor.commit();
        }
    }

    public static void setApplicationSharedPreference(SharedPreferences sharedPreferences) {
        m_spMain = sharedPreferences;
        m_editor = sharedPreferences.edit();
    }

    public static void setPlayer(IBasePlayer iBasePlayer) {
        player = iBasePlayer;
    }
}
