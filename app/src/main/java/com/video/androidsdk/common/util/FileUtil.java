package com.video.androidsdk.common.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.video.androidsdk.common.http.HttpConstant;
import com.video.androidsdk.log.LogEx;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class FileUtil {
    public static final int FILE_UTIL_STATUS_CONTENT_NULL = 3;
    public static final int FILE_UTIL_STATUS_FILENAME_NULL = 2;
    public static final int FILE_UTIL_STATUS_FILEOBJECT_NULL = 4;
    public static final int FILE_UTIL_STATUS_FILE_CREATE_FAIL = 5;
    public static final int FILE_UTIL_STATUS_FILE_EXIST = 1;
    public static final int FILE_UTIL_STATUS_FILE_NOT_EXIST = 8;
    public static final int FILE_UTIL_STATUS_OTHER_EXCEPTION = 10;
    public static final int FILE_UTIL_STATUS_SUCCESS = 0;
    public static final String LOG_TAG = "FileUtil";
    public static final String STR_TAG_LOCALIMG = "file://";
    public static final String STR_TAG_LOCALIMG_ASSET = "file:///android_asset/";
    public static final String STR_TAG_LOCALIMG_MNT = "/data/";
    public static final String STR_TAG_LOCALIMG_RAW = "file:///android_raw/";
    public static final String STR_TAG_LOCALIMG_RES = "file:///android_res/";

    private FileUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.FileOutputStream] */
    public static int append2File(String str, String str2) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        FileOutputStream fileOutputStream3;
        DataOutputStream dataOutputStream;
        if (TextUtils.isEmpty(str)) {
            return 2;
        }
        if (TextUtils.isEmpty(str2)) {
            return 3;
        }
        DataOutputStream dataOutputStream2 = null;
        int i = 0;
        try {
            try {
                try {
                    File file = new File(str);
                    if (!file.exists()) {
                        File parentFile = file.getParentFile();
                        if (parentFile != null && !parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        SecurityUtil.securityCheck(file.getAbsolutePath(), "createNewFile");
                        file.createNewFile();
                    }
                    fileOutputStream3 = new FileOutputStream(file, true);
                    try {
                        dataOutputStream = new DataOutputStream(fileOutputStream3);
                    } catch (FileNotFoundException e) {
                        e = e;
                    } catch (IOException e2) {
                        e = e2;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    SecurityUtil.securityCheck(dataOutputStream.toString(), "writeUTF");
                    dataOutputStream.writeUTF(str2);
                    try {
                        dataOutputStream.close();
                        fileOutputStream3.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return 0;
                } catch (FileNotFoundException e4) {
                    e = e4;
                    dataOutputStream2 = dataOutputStream;
                    FileNotFoundException fileNotFoundException = e;
                    fileOutputStream2 = fileOutputStream3;
                    e = fileNotFoundException;
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    int length = stackTrace.length;
                    while (i < length) {
                        Log.d("Common_FileUtil", "FileNotFoundException : " + stackTrace[i].toString());
                        i++;
                    }
                    if (dataOutputStream2 != null) {
                        dataOutputStream2.close();
                    }
                    if (fileOutputStream2 == null) {
                        return 10;
                    }
                    fileOutputStream2.close();
                    return 10;
                } catch (IOException e5) {
                    e = e5;
                    dataOutputStream2 = dataOutputStream;
                    IOException iOException = e;
                    fileOutputStream = fileOutputStream3;
                    e = iOException;
                    StackTraceElement[] stackTrace2 = e.getStackTrace();
                    int length2 = stackTrace2.length;
                    while (i < length2) {
                        Log.d("Common_FileUtil", "FileNotFoundException : " + stackTrace2[i].toString());
                        i++;
                    }
                    if (dataOutputStream2 != null) {
                        dataOutputStream2.close();
                    }
                    if (fileOutputStream == null) {
                        return 10;
                    }
                    fileOutputStream.close();
                    return 10;
                } catch (Throwable th3) {
                    th = th3;
                    dataOutputStream2 = dataOutputStream;
                    Throwable th4 = th;
                    str2 = fileOutputStream3;
                    th = th4;
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            throw th;
                        }
                    }
                    if (str2 != 0) {
                        str2.close();
                    }
                    throw th;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                fileOutputStream2 = null;
            } catch (IOException e8) {
                e = e8;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                str2 = 0;
            }
        } catch (IOException e9) {
            e9.printStackTrace();
            return 10;
        }
    }

    public static int appendContent2File(String str, String str2) throws IOException {
        return appendContent2File(str, str2, (String) null);
    }

    public static int checkFileExist(String str) {
        return (!TextUtils.isEmpty(str) && new File(str).exists()) ? 0 : 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.lang.Object, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.InputStream] */
    public static int copyFileFromAssets(Context context, String str, String str2, String str3) {
        LogEx.d(LOG_TAG, "start copy file from assets. file name is " + str + ",strFileDstPath:" + str2);
        if (!isAssetFileExist(context, str)) {
            return -1;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                context = context.getAssets().open(str);
                try {
                    if (context == 0) {
                        LogEx.w(LOG_TAG, "inputStreamConfig is null!");
                        if (context != 0) {
                            try {
                                context.close();
                            } catch (Exception unused) {
                                LogEx.e(LOG_TAG, "close config file error. file name is " + str);
                            }
                        }
                        return -1;
                    }
                    if (TextUtils.isEmpty(str3)) {
                        str3 = str;
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(str2 + "/" + str3);
                    try {
                        byte[] bArr = new byte[Util.BYTE_OF_KB];
                        SecurityUtil.securityCheck(context.toString(), "read");
                        while (true) {
                            int read = context.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        }
                        fileOutputStream2.flush();
                        try {
                            fileOutputStream2.close();
                            if (context != 0) {
                                context.close();
                            }
                        } catch (Exception unused2) {
                            LogEx.e(LOG_TAG, "close config file error. file name is " + str);
                        }
                        return 0;
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        LogEx.e(LOG_TAG, "copy config file error. file name is " + str);
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception unused3) {
                                LogEx.e(LOG_TAG, "close config file error. file name is " + str);
                                return -1;
                            }
                        }
                        if (context != 0) {
                            context.close();
                        }
                        return -1;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception unused4) {
                                LogEx.e(LOG_TAG, "close config file error. file name is " + str);
                                throw th;
                            }
                        }
                        if (context != 0) {
                            context.close();
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
            context = 0;
        } catch (Throwable th3) {
            th = th3;
            context = 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.FileOutputStream] */
    public static boolean copyfile(File file, File file2, Boolean bool) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        FileInputStream fileInputStream;
        if (!file.exists()) {
            LogEx.w(LOG_TAG, "fromFile is not exits");
            return false;
        }
        if (!file.isFile()) {
            LogEx.w(LOG_TAG, "fromFile is not a file");
            return false;
        }
        if (!file.canRead()) {
            LogEx.w(LOG_TAG, "fromFile can't read");
            return false;
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            LogEx.w(LOG_TAG, "toFile not read");
            parentFile.mkdirs();
        }
        if (file2.exists() && bool.booleanValue()) {
            SecurityUtil.securityCheck(file2.getAbsolutePath(), "delete");
            file2.delete();
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream((File) file);
                try {
                    file = new FileOutputStream(file2);
                } catch (FileNotFoundException e) {
                    e = e;
                    file = 0;
                } catch (IOException e2) {
                    e = e2;
                    file = 0;
                } catch (Throwable th) {
                    th = th;
                    file = 0;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                byte[] bArr = new byte[Util.BYTE_OF_KB];
                SecurityUtil.securityCheck(fileInputStream.toString(), "read");
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    file.write(bArr, 0, read);
                }
                file.flush();
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                try {
                    file.close();
                    return true;
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return true;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                fileInputStream2 = fileInputStream;
                fileOutputStream2 = file;
                e.printStackTrace();
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                return false;
            } catch (IOException e8) {
                e = e8;
                fileInputStream2 = fileInputStream;
                fileOutputStream = file;
                e.printStackTrace();
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
                if (file == 0) {
                    throw th;
                }
                try {
                    file.close();
                    throw th;
                } catch (IOException e12) {
                    e12.printStackTrace();
                    throw th;
                }
            }
        } catch (FileNotFoundException e13) {
            e = e13;
            fileOutputStream2 = null;
        } catch (IOException e14) {
            e = e14;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            file = 0;
        }
    }

    public static boolean createFile(String str, boolean z) {
        if (TextUtils.isEmpty(str) || !z) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        file.mkdirs();
        return true;
    }

    public static int deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return 8;
        }
        File file = new File(str);
        SecurityUtil.securityCheck(file.getAbsolutePath(), "delete");
        return file.delete() ? 0 : 10;
    }

    public static double getFileSize(File file) {
        double d2 = 0.0d;
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        d2 += getFileSize(file2);
                    }
                }
                return d2;
            }
            return file.length();
        }
        Log.w(LOG_TAG, "File not exist:" + file.getAbsolutePath());
        return 0.0d;
    }

    public static boolean isAssetFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(STR_TAG_LOCALIMG_ASSET);
    }

    private static boolean isAssetFileExist(Context context, String str) {
        try {
            for (String str2 : context.getAssets().list("")) {
                if (str2.equals(str.trim())) {
                    LogEx.d(LOG_TAG, str + "  exist");
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            LogEx.d(LOG_TAG, str + "does not exist");
        }
        LogEx.d(LOG_TAG, str + "  does not exist");
        return false;
    }

    public static boolean isFileExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean isFileValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.length() > 0;
    }

    public static boolean isLocalFile(String str) {
        if (str == null || !str.startsWith(STR_TAG_LOCALIMG)) {
            return (str == null || str.startsWith("http://") || str.startsWith("https://") || str.startsWith(HttpConstant.PROTOCOL_HTTP)) ? false : true;
        }
        return true;
    }

    public static void recursionDeleteFile(File file) {
        if (file == null) {
            LogEx.w(LOG_TAG, "file is null!");
            return;
        }
        if (file.isFile()) {
            SecurityUtil.securityCheck(file.getAbsolutePath(), "delete");
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    recursionDeleteFile(file2);
                }
                file.delete();
                return;
            }
            file.delete();
        }
    }

    public static boolean write2File(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        if (str == null || bArr == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Throwable th) {
                th = th;
            }
            try {
                SecurityUtil.securityCheck(fileOutputStream.toString(), "write");
                fileOutputStream.write(bArr);
                try {
                    fileOutputStream.close();
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return true;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return false;
            } catch (IOException e4) {
                e = e4;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
        } catch (IOException e8) {
            e = e8;
        }
    }

    public static int appendContent2File(String str, String str2, String str3) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return 2;
        }
        if (TextUtils.isEmpty(str2)) {
            return 3;
        }
        return appendContent2File(new File(str), str2, str3);
    }

    public static int appendContent2File(File file, String str) throws IOException {
        return appendContent2File(file, str, (String) null);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:7|(3:9|(1:13)|14)|15|(10:51|52|(1:19)|20|21|23|24|25|26|27)|17|(0)|20|21|23|24|25|26|27) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
    
        r2 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0059, code lost:
    
        r0 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005e, code lost:
    
        r2.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:
    
        if (r0 != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0055, code lost:
    
        r2 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0056, code lost:
    
        r0 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006d, code lost:
    
        if (r0 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0077, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006f, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0073, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0074, code lost:
    
        r3.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x005d, code lost:
    
        r2 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int appendContent2File(java.io.File r2, java.lang.String r3, java.lang.String r4) throws java.io.IOException {
        /*
            if (r2 != 0) goto L4
            r2 = 4
            return r2
        L4:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto Lc
            r2 = 3
            return r2
        Lc:
            boolean r0 = r2.exists()
            if (r0 != 0) goto L2d
            java.io.File r0 = r2.getParentFile()
            if (r0 == 0) goto L21
            boolean r1 = r0.exists()
            if (r1 != 0) goto L21
            r0.mkdirs()
        L21:
            java.lang.String r0 = r2.getAbsolutePath()
            java.lang.String r1 = "createNewFile"
            com.video.androidsdk.common.util.SecurityUtil.securityCheck(r0, r1)
            r2.createNewFile()
        L2d:
            r0 = 0
            if (r4 == 0) goto L41
            byte[] r4 = r3.getBytes(r4)     // Catch: java.io.UnsupportedEncodingException -> L35
            goto L42
        L35:
            java.lang.String r4 = "utf-8"
            byte[] r4 = r3.getBytes(r4)     // Catch: java.io.UnsupportedEncodingException -> L3d
            goto L42
        L3d:
            r4 = move-exception
            r4.printStackTrace()
        L41:
            r4 = r0
        L42:
            if (r4 != 0) goto L48
            byte[] r4 = r3.getBytes()
        L48:
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            r1 = 1
            r3.<init>(r2, r1)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            r3.write(r4)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L58
            r3.close()     // Catch: java.io.IOException -> L67
            goto L6b
        L55:
            r2 = move-exception
            r0 = r3
            goto L6d
        L58:
            r2 = move-exception
            r0 = r3
            goto L5e
        L5b:
            r2 = move-exception
            goto L6d
        L5d:
            r2 = move-exception
        L5e:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L5b
            if (r0 == 0) goto L6b
            r0.close()     // Catch: java.io.IOException -> L67
            goto L6b
        L67:
            r2 = move-exception
            r2.printStackTrace()
        L6b:
            r2 = 0
            return r2
        L6d:
            if (r0 == 0) goto L77
            r0.close()     // Catch: java.io.IOException -> L73
            goto L77
        L73:
            r3 = move-exception
            r3.printStackTrace()
        L77:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.util.FileUtil.appendContent2File(java.io.File, java.lang.String, java.lang.String):int");
    }

    public static void recursionDeleteFile(String str) {
        recursionDeleteFile(new File(str));
    }

    public static int append2File(File file, String str) throws IOException {
        return append2File(file, str, null);
    }

    public static int append2File(File file, String str, String str2) throws IOException {
        if (file == null) {
            return 4;
        }
        if (TextUtils.isEmpty(str)) {
            return 3;
        }
        if (file.exists()) {
            return 1;
        }
        appendContent2File(file, str, str2);
        return 0;
    }
}
