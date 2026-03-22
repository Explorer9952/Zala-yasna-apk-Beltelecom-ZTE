package com.video.androidsdk.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes.dex */
public class ZipUtil {
    private String validateFileName(String str, String str2) throws IOException {
        String canonicalPath = new File(str).getCanonicalPath();
        if (canonicalPath.startsWith(new File(str2).getCanonicalPath())) {
            return canonicalPath;
        }
        throw new IllegalStateException("File is outside extraction target directory");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x004a -> B:11:0x004d). Please report as a decompilation issue!!! */
    public static void zip(String str, String str2) throws IOException {
        File file;
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2 = null;
        try {
            try {
                try {
                    File file2 = new File(str2);
                    file = new File(str);
                    zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (file.isFile()) {
                zipFileOrDirectory(zipOutputStream, file, "");
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        zipFileOrDirectory(zipOutputStream, file3, "");
                    }
                }
            }
            zipOutputStream.close();
        } catch (IOException e3) {
            e = e3;
            zipOutputStream2 = zipOutputStream;
            e.printStackTrace();
            if (zipOutputStream2 != null) {
                zipOutputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream2 = zipOutputStream;
            if (zipOutputStream2 != null) {
                try {
                    zipOutputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static void zipFileOrDirectory(ZipOutputStream zipOutputStream, File file, String str) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    if (!file.isDirectory()) {
                        byte[] bArr = new byte[4096];
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry(str + file.getName()));
                            SecurityUtil.securityCheck(fileInputStream2.toString(), "read");
                            while (true) {
                                int read = fileInputStream2.read(bArr);
                                if (read == -1) {
                                    break;
                                } else {
                                    zipOutputStream.write(bArr, 0, read);
                                }
                            }
                            zipOutputStream.closeEntry();
                            fileInputStream = fileInputStream2;
                        } catch (IOException e) {
                            e = e;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } else {
                        File[] listFiles = file.listFiles();
                        if (listFiles != null) {
                            for (File file2 : listFiles) {
                                zipFileOrDirectory(zipOutputStream, file2, str + file.getName() + "/");
                            }
                        }
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return;
                }
            } catch (IOException e4) {
                e = e4;
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0148 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[Catch: all -> 0x015a, IOException -> 0x015d, SYNTHETIC, TRY_LEAVE, TryCatch #12 {all -> 0x015a, blocks: (B:6:0x0009, B:7:0x0015, B:9:0x001b, B:26:0x00f9, B:17:0x0103, B:22:0x0109, B:29:0x00fe, B:68:0x013e, B:58:0x0148, B:64:0x0150, B:63:0x014d, B:71:0x0143), top: B:5:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void unzip(java.lang.String r12, java.lang.String r13) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.util.ZipUtil.unzip(java.lang.String, java.lang.String):void");
    }
}
