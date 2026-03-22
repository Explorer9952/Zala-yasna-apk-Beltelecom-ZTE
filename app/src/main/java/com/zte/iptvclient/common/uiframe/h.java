package com.zte.iptvclient.common.uiframe;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.Util;
import com.video.androidsdk.common.BaseObject;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilePermission;
import java.io.IOException;
import java.util.Properties;

/* compiled from: PropertiesMgr.java */
/* loaded from: classes2.dex */
public final class h extends BaseObject {

    /* renamed from: a, reason: collision with root package name */
    private static String f7915a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f7916b = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f7917c = "iptvclientsys.ini";

    public static int a(Context context) {
        if (context == null) {
            LogEx.e("PropertiesMgr", "ctx is null!");
            return -1;
        }
        b(context);
        try {
            if (checkConfigFile(context) == 0) {
                return 0;
            }
            LogEx.e("PropertiesMgr", "check config file error!");
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    private static void b(Context context) {
        if (context == null) {
            LogEx.w("PropertiesMgr", "ctx is null!");
            return;
        }
        if (hasExternalStorage()) {
            f7916b = Environment.getExternalStorageDirectory().getAbsolutePath() + "/zxct/";
        } else {
            f7916b = context.getFilesDir().getAbsolutePath() + "/";
        }
        LogEx.i("PropertiesMgr", "mstrSDCardCachePath=" + f7916b);
        f7915a = context.getFilesDir().getAbsolutePath() + "/";
        LogEx.i("PropertiesMgr", "mstrConfigPath=" + f7915a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.Properties] */
    private static int checkConfigFile(Context context) throws IOException {
        File file = new File(f7915a + f7917c);
        if (file.exists()) {
            ?? r0 = 0;
            r0 = 0;
            String readPropertie = readPropertie(ConfigMgr.INIPropertieKey.VersionCode, null);
            LogEx.d("PropertiesMgr", "ini file oldVersion:" + readPropertie);
            ?? properties = new Properties();
            try {
                try {
                    try {
                        r0 = context.getAssets().open(f7917c);
                        properties.load(r0);
                    } catch (IOException e) {
                        e.printStackTrace();
                        if (r0 != 0) {
                            r0.close();
                        }
                    }
                    if (r0 != 0) {
                        r0.close();
                    }
                } catch (Throwable th) {
                    if (r0 != 0) {
                        try {
                            r0.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            String property = properties.getProperty(ConfigMgr.INIPropertieKey.VersionCode);
            LogEx.d("PropertiesMgr", "ini file newVersion:" + property);
            r0 = TextUtils.equals(readPropertie, property);
            if (r0 == 0) {
                LogEx.d("PropertiesMgr", "need update ini file");
                a(file.getAbsolutePath(), "delete");
                file.delete();
                return a(context, f7915a, f7917c);
            }
            LogEx.d("PropertiesMgr", "not need update ini file");
            return 0;
        }
        LogEx.d("PropertiesMgr", "ini file not exit start copy form asset");
        return a(context, f7915a, f7917c);
    }

    private static boolean hasExternalStorage() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x003d -> B:15:0x0052). Please report as a decompilation issue!!! */
    public static String readPropertie(String str, String str2) {
        FileInputStream fileInputStream;
        if (str == null) {
            LogEx.w("PropertiesMgr", "strKey is null!");
            return str2;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(f7915a + f7917c);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            Properties properties = new Properties();
            properties.load(new BufferedInputStream(fileInputStream));
            String property = properties.getProperty(str);
            if (property != null) {
                str2 = property;
            }
            fileInputStream.close();
        } catch (Exception e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return str2;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        return str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Object, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.io.InputStream] */
    private static int a(Context context, String str, String str2) {
        LogEx.d("PropertiesMgr", "start copy config file. file name is " + str2 + ",strFileDstPath:" + str);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                context = context.getAssets().open(str2);
                try {
                    if (context == 0) {
                        LogEx.w("PropertiesMgr", "inputStreamConfig is null!");
                        if (context != 0) {
                            try {
                                context.close();
                            } catch (Exception unused) {
                                LogEx.e("PropertiesMgr", "close config file error. file name is " + str2);
                            }
                        }
                        return -1;
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(str + str2);
                    try {
                        byte[] bArr = new byte[Util.BYTE_OF_KB];
                        a(context.toString(), "read");
                        while (true) {
                            int read = context.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            a(fileOutputStream2.toString(), "write");
                            fileOutputStream2.write(bArr, 0, read);
                        }
                        fileOutputStream2.flush();
                        try {
                            fileOutputStream2.close();
                            if (context != 0) {
                                context.close();
                            }
                        } catch (Exception unused2) {
                            LogEx.e("PropertiesMgr", "close config file error. file name is " + str2);
                        }
                        return 0;
                    } catch (Exception unused3) {
                        fileOutputStream = fileOutputStream2;
                        LogEx.e("PropertiesMgr", "copy config file error. file name is " + str2);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception unused4) {
                                LogEx.e("PropertiesMgr", "close config file error. file name is " + str2);
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
                            } catch (Exception unused5) {
                                LogEx.e("PropertiesMgr", "close config file error. file name is " + str2);
                                throw th;
                            }
                        }
                        if (context != 0) {
                            context.close();
                        }
                        throw th;
                    }
                } catch (Exception unused6) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused7) {
            context = 0;
        } catch (Throwable th3) {
            th = th3;
            context = 0;
        }
    }

    public static String readPropertie(String str) {
        return readPropertie(str, "");
    }

    private static void a(String str, String str2) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new FilePermission(str, str2));
        }
    }
}
