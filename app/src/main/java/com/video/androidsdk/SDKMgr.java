package com.video.androidsdk;

import android.content.Context;
import android.os.Handler;
import com.video.androidsdk.a.d;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.http.DataDownload;
import com.video.androidsdk.log.LogEx;

/* loaded from: classes.dex */
public class SDKMgr {

    /* renamed from: a, reason: collision with root package name */
    public static Handler f3018a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f3019b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f3020c = false;

    /* renamed from: d, reason: collision with root package name */
    private static String f3021d = "V5.02.09-20210716";
    private static Context e = null;
    private static boolean f = false;
    private static String g = "UTF-8";
    private static boolean h = false;

    /* loaded from: classes.dex */
    public interface OnSDKInitReturnListener {
        void onSDKInitReturn(String str, String str2);
    }

    public static Context getApplicationContext() {
        return e;
    }

    public static String getEPGCharset() {
        return g;
    }

    public static String getEPGHome() {
        return f3019b;
    }

    public static String getVersion() {
        return f3021d;
    }

    public static void initSDK(Context context, OnSDKInitReturnListener onSDKInitReturnListener) {
        if (context == null) {
            return;
        }
        if (f) {
            LogEx.e("SDKMgr", "SDK already inited");
            if (!h || onSDKInitReturnListener == null) {
                return;
            }
            onSDKInitReturnListener.onSDKInitReturn("0", "");
            return;
        }
        f = true;
        LogEx.i("SDKMgr", "SDK VersionName:" + f3021d);
        LogEx.i("SDKMgr", "init sdk begin.");
        f3018a = new Handler();
        Context applicationContext = context.getApplicationContext();
        e = applicationContext;
        ConfigMgr.prepareConfig(applicationContext);
        d.a(e);
        b.a().a(e);
        DataDownload.getInstance().init(e);
        com.video.androidsdk.license.a.a(e, new a(onSDKInitReturnListener));
        LogEx.i("SDKMgr", "init sdk end.");
    }

    public static void setEPGCharset(String str) {
        g = str;
    }

    public static void setEPGHome(String str) {
        f3019b = str;
    }

    public static void setLogLevel(LogEx.LogLevelType logLevelType) {
        LogEx.i("SDKMgr", "Set log level to " + logLevelType + ".");
        LogEx.setLogLevel(logLevelType);
    }
}
