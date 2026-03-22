package com.tencent.mm.algorithm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class MD5 {
    private MD5() {
    }

    public static String getMD5(File file) {
        return getMD5(file, 102400);
    }

    public static String getMD5(File file, int i) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file != null && i > 0 && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                long j = i;
                try {
                    if (j > file.length()) {
                        j = file.length();
                    }
                    String md5 = getMD5(fileInputStream, (int) j);
                    fileInputStream.close();
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    return md5;
                } catch (Exception unused2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused5) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    public static String getMD5(File file, int i, int i2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file != null && file.exists() && i >= 0 && i2 > 0) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    String md5 = getMD5(fileInputStream, 102400, i, i2);
                    fileInputStream.close();
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    return md5;
                } catch (Exception unused2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused5) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    public static final String getMD5(FileInputStream fileInputStream, int i) {
        int i2;
        if (fileInputStream != null && i > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                StringBuilder sb = new StringBuilder(32);
                byte[] bArr = new byte[i];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                for (byte b2 : messageDigest.digest()) {
                    sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
                }
                return sb.toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static final String getMD5(FileInputStream fileInputStream, int i, int i2, int i3) {
        if (fileInputStream != null && i > 0 && i2 >= 0 && i3 > 0) {
            long j = i2;
            try {
                if (fileInputStream.skip(j) < j) {
                    return null;
                }
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                StringBuilder sb = new StringBuilder(32);
                byte[] bArr = new byte[i];
                int i4 = 0;
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1 || i4 >= i3) {
                        break;
                    }
                    int i5 = i4 + read;
                    if (i5 <= i3) {
                        messageDigest.update(bArr, 0, read);
                        i4 = i5;
                    } else {
                        messageDigest.update(bArr, 0, i3 - i4);
                        i4 = i3;
                    }
                }
                for (byte b2 : messageDigest.digest()) {
                    sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
                }
                return sb.toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String getMD5(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            return getMD5(file, 102400);
        }
        return null;
    }

    public static String getMD5(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            return getMD5(file, i, i2);
        }
        return null;
    }

    public static final String getMessageDigest(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i = 0;
            for (byte b2 : digest) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b2 >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b2 & 15];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final byte[] getRawDigest(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }
}
