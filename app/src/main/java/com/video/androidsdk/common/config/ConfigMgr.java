package com.video.androidsdk.common.config;

import android.content.Context;
import android.os.Environment;
import com.video.androidsdk.a.d;
import com.video.androidsdk.common.BaseObject;
import com.video.androidsdk.log.LogEx;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/* loaded from: classes.dex */
public final class ConfigMgr extends BaseObject {
    private static final int FAILURE = -1;
    private static final int FAILURE_CHECK_CONFIG_FILE = -2;
    private static final String KEY_START_DEBUG_LOG = "$startdebug";
    private static final String KEY_STOP_DEBUG_LOG = "$stopdebug";
    public static final String LOG_TAG = "ConfigMgr";
    private static final int SUCCESS = 0;
    private static boolean mbProxyEnable = false;
    private static int miBatteryLevel = 0;
    private static int miHeightPixels = 0;
    private static int miProxyType = 0;
    private static int miWidthPixels = 0;
    private static String mstrConfigFile = "iptvclientsys.ini";
    private static String mstrConfigPath = null;
    private static String mstrDebugLogFilePath = "logex";
    private static String mstrDlnaLogFilePath = "dlnalogex";
    private static String mstrExceptionsLogPath = "exceptions";
    private static String mstrFileNamePref = "homePagePref";
    private static String mstrImageCachePath = ".images";
    private static String mstrProxyFile = "cbtproxy.xml";
    private static String mstrSDCardCachePath;

    /* loaded from: classes.dex */
    public interface INIPropertieKey {
        public static final String VersionCode = "VersionCode";
    }

    private ConfigMgr() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int checkConfigFile(android.content.Context r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.video.androidsdk.common.config.ConfigMgr.mstrConfigPath
            r0.append(r1)
            java.lang.String r1 = com.video.androidsdk.common.config.ConfigMgr.mstrConfigFile
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            boolean r0 = r1.exists()
            r2 = 0
            java.lang.String r3 = "ConfigMgr"
            if (r0 == 0) goto Lbf
            java.lang.String r0 = "VersionCode"
            java.lang.String r4 = readPropertie(r0, r2)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "ini file oldVersion:"
            r5.append(r6)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            com.video.androidsdk.log.LogEx.d(r3, r5)
            java.util.Properties r5 = new java.util.Properties
            r5.<init>()
            android.content.res.AssetManager r6 = r8.getAssets()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            java.lang.String r7 = com.video.androidsdk.common.config.ConfigMgr.mstrConfigFile     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            java.io.InputStream r6 = r6.open(r7)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r5.load(r6)     // Catch: java.io.IOException -> L53 java.lang.Throwable -> Lb2
            if (r6 == 0) goto L66
            r6.close()     // Catch: java.io.IOException -> L62
            goto L66
        L53:
            r7 = move-exception
            goto L59
        L55:
            r8 = move-exception
            goto Lb4
        L57:
            r7 = move-exception
            r6 = r2
        L59:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> Lb2
            if (r6 == 0) goto L66
            r6.close()     // Catch: java.io.IOException -> L62
            goto L66
        L62:
            r6 = move-exception
            r6.printStackTrace()
        L66:
            java.lang.String r0 = r5.getProperty(r0)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "ini file newVersion:"
            r5.append(r6)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            com.video.androidsdk.log.LogEx.d(r3, r5)
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L98
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 != 0) goto L98
            boolean r0 = android.text.TextUtils.equals(r4, r0)
            if (r0 != 0) goto L91
            goto L98
        L91:
            java.lang.String r8 = "not need update ini file"
            com.video.androidsdk.log.LogEx.d(r3, r8)
            r8 = 0
            goto Lcc
        L98:
            java.lang.String r0 = "need update ini file"
            com.video.androidsdk.log.LogEx.d(r3, r0)
            java.lang.String r0 = r1.getAbsolutePath()
            java.lang.String r3 = "delete"
            com.video.androidsdk.common.util.SecurityUtil.securityCheck(r0, r3)
            r1.delete()
            java.lang.String r0 = com.video.androidsdk.common.config.ConfigMgr.mstrConfigFile
            java.lang.String r1 = com.video.androidsdk.common.config.ConfigMgr.mstrConfigPath
            int r8 = com.video.androidsdk.common.util.FileUtil.copyFileFromAssets(r8, r0, r1, r2)
            goto Lcc
        Lb2:
            r8 = move-exception
            r2 = r6
        Lb4:
            if (r2 == 0) goto Lbe
            r2.close()     // Catch: java.io.IOException -> Lba
            goto Lbe
        Lba:
            r0 = move-exception
            r0.printStackTrace()
        Lbe:
            throw r8
        Lbf:
            java.lang.String r0 = "ini file not exit start copy form asset"
            com.video.androidsdk.log.LogEx.d(r3, r0)
            java.lang.String r0 = com.video.androidsdk.common.config.ConfigMgr.mstrConfigFile
            java.lang.String r1 = com.video.androidsdk.common.config.ConfigMgr.mstrConfigPath
            int r8 = com.video.androidsdk.common.util.FileUtil.copyFileFromAssets(r8, r0, r1, r2)
        Lcc:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.config.ConfigMgr.checkConfigFile(android.content.Context):int");
    }

    public static String getApplicationExceptionFilePath() {
        String str = mstrSDCardCachePath + mstrExceptionsLogPath + "/";
        LogEx.i(LOG_TAG, "strFilePath=" + str);
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static int getBatteryLevel() {
        return miBatteryLevel;
    }

    public static String getConfigRootPath() {
        return mstrConfigPath;
    }

    public static String getDebugLogFilePath() {
        String str = mstrSDCardCachePath + mstrDebugLogFilePath + "/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static int getDisplayMetricsHeightPix() {
        return miHeightPixels;
    }

    public static int getDisplayMetricsWidthPix() {
        return miWidthPixels;
    }

    public static String getDlnaLogFilePath() {
        String str = mstrSDCardCachePath + mstrDlnaLogFilePath + "/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String getSDCardCachePath() {
        return mstrSDCardCachePath;
    }

    private static boolean hasExternalStorage() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static void initConfig(Context context) {
        if (context == null) {
            LogEx.w(LOG_TAG, "ctx is null!");
            return;
        }
        mstrConfigPath = context.getFilesDir().getAbsolutePath() + "/";
        LogEx.i(LOG_TAG, "mstrConfigPath=" + mstrConfigPath);
        mstrSDCardCachePath = d.a(context, "zxct").getAbsolutePath() + "/";
        LogEx.i(LOG_TAG, "mstrSDCardCachePath=" + mstrSDCardCachePath);
    }

    public static boolean isDebugVersion() {
        return LogEx.getLogLevel() == LogEx.LogLevelType.TYPE_LOG_LEVEL_DEBUG;
    }

    public static int prepareConfig(Context context) {
        if (context == null) {
            LogEx.e(LOG_TAG, "ctx is null!");
            return 3;
        }
        initConfig(context);
        checkConfigFile(context);
        String readPropertie = readPropertie("RequestConfigClass");
        if (readPropertie == null) {
            readPropertie = "com.video.androidsdk.common.config.RequestConfigDefaultClass";
        }
        try {
            Class<?> cls = Class.forName(readPropertie);
            if (Class.forName("com.video.androidsdk.common.config.RequestConfigGenerator").isAssignableFrom(cls)) {
                RequestConfigParser.getInstance().parseRequestConfig((InputStream) cls.getDeclaredMethod("getXMLStream", new Class[0]).invoke(cls.newInstance(), new Object[0]));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (InstantiationException e4) {
            e4.printStackTrace();
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
        }
        NativeConfig.getInstance().configure();
        return 0;
    }

    public static int processCommand(Context context, String str) {
        if (KEY_START_DEBUG_LOG.equalsIgnoreCase(str)) {
            LogEx.setLogLevel(LogEx.LogLevelType.TYPE_LOG_LEVEL_DEBUG);
            LogEx.i(LOG_TAG, "Log level set to DEBUG.");
            return 0;
        }
        if (KEY_STOP_DEBUG_LOG.equalsIgnoreCase(str)) {
            LogEx.setLogLevel(LogEx.LogLevelType.TYPE_LOG_LEVEL_ERROR);
            LogEx.i(LOG_TAG, "Log level set to ERROR.");
            return 0;
        }
        LogEx.w(LOG_TAG, "Unknown command:" + str);
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x005c -> B:18:0x0071). Please report as a decompilation issue!!! */
    public static String readPropertie(String str, String str2) {
        FileInputStream fileInputStream;
        if (str == null) {
            LogEx.w(LOG_TAG, "strKey is null!");
            return str2;
        }
        if (!new File(mstrConfigPath + mstrConfigFile).exists()) {
            return str2;
        }
        FileInputStream fileInputStream2 = null;
        FileInputStream fileInputStream3 = null;
        fileInputStream2 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(mstrConfigPath + mstrConfigFile);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            fileInputStream2 = fileInputStream2;
        }
        try {
            Properties properties = new Properties();
            properties.load(new BufferedInputStream(fileInputStream));
            String property = properties.getProperty(str);
            if (property != null) {
                str2 = property;
            }
            fileInputStream.close();
            fileInputStream2 = properties;
        } catch (Exception e3) {
            e = e3;
            fileInputStream3 = fileInputStream;
            e.printStackTrace();
            fileInputStream2 = fileInputStream3;
            if (fileInputStream3 != null) {
                fileInputStream3.close();
                fileInputStream2 = fileInputStream3;
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

    public static void setBatteryLevel(int i) {
        LogEx.i(LOG_TAG, "set Battery Level： " + i);
        miBatteryLevel = i;
    }

    public static void setDisplayMetrics(int i, int i2) {
        LogEx.i(LOG_TAG, "set Display Metrics： " + i + " * " + i2);
        miWidthPixels = i;
        miHeightPixels = i2;
    }

    public static void setLogLevel(LogEx.LogLevelType logLevelType) {
        LogEx.i(LOG_TAG, "typeNew=" + logLevelType);
        LogEx.setLogLevel(logLevelType);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x00bc -> B:20:0x00bf). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void writeProperties(java.lang.String r5, java.lang.String r6) {
        /*
            boolean r0 = com.video.androidsdk.common.util.StringUtil.isEmptyString(r5)
            java.lang.String r1 = "ConfigMgr"
            if (r0 == 0) goto Le
            java.lang.String r5 = "strKey is empty!"
            com.video.androidsdk.log.LogEx.e(r1, r5)
            return
        Le:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = com.video.androidsdk.common.config.ConfigMgr.mstrConfigPath
            r2.append(r3)
            java.lang.String r3 = com.video.androidsdk.common.config.ConfigMgr.mstrConfigFile
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            boolean r0 = r0.exists()
            if (r0 != 0) goto L2d
            return
        L2d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r2 = "="
            r0.append(r2)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            com.video.androidsdk.log.LogEx.d(r1, r0)
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La6
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La6
            r3.<init>()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La6
            java.lang.String r4 = com.video.androidsdk.common.config.ConfigMgr.mstrConfigPath     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La6
            r3.append(r4)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La6
            java.lang.String r4 = com.video.androidsdk.common.config.ConfigMgr.mstrConfigFile     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La6
            r3.append(r4)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La6
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La6
            r2.<init>(r3)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La6
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9f
            r0.load(r3)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9f
            r0.setProperty(r5, r6)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9f
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9f
            r6.<init>()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9f
            java.lang.String r3 = com.video.androidsdk.common.config.ConfigMgr.mstrConfigPath     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9f
            r6.append(r3)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9f
            java.lang.String r3 = com.video.androidsdk.common.config.ConfigMgr.mstrConfigFile     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9f
            r6.append(r3)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9f
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9f
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9f
            r0.store(r5, r1)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L99
            r5.flush()     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L99
            r2.close()     // Catch: java.io.IOException -> L8f
            goto L93
        L8f:
            r6 = move-exception
            r6.printStackTrace()
        L93:
            r5.close()     // Catch: java.io.IOException -> Lbb
            goto Lbf
        L97:
            r6 = move-exception
            goto L9d
        L99:
            r6 = move-exception
            goto La1
        L9b:
            r6 = move-exception
            r5 = r1
        L9d:
            r1 = r2
            goto Lc1
        L9f:
            r6 = move-exception
            r5 = r1
        La1:
            r1 = r2
            goto La8
        La3:
            r6 = move-exception
            r5 = r1
            goto Lc1
        La6:
            r6 = move-exception
            r5 = r1
        La8:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> Lc0
            if (r1 == 0) goto Lb5
            r1.close()     // Catch: java.io.IOException -> Lb1
            goto Lb5
        Lb1:
            r6 = move-exception
            r6.printStackTrace()
        Lb5:
            if (r5 == 0) goto Lbf
            r5.close()     // Catch: java.io.IOException -> Lbb
            goto Lbf
        Lbb:
            r5 = move-exception
            r5.printStackTrace()
        Lbf:
            return
        Lc0:
            r6 = move-exception
        Lc1:
            if (r1 == 0) goto Lcb
            r1.close()     // Catch: java.io.IOException -> Lc7
            goto Lcb
        Lc7:
            r0 = move-exception
            r0.printStackTrace()
        Lcb:
            if (r5 == 0) goto Ld5
            r5.close()     // Catch: java.io.IOException -> Ld1
            goto Ld5
        Ld1:
            r5 = move-exception
            r5.printStackTrace()
        Ld5:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.config.ConfigMgr.writeProperties(java.lang.String, java.lang.String):void");
    }

    public static String readPropertie(String str) {
        return readPropertie(str, null);
    }
}
