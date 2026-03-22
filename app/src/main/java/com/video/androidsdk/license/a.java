package com.video.androidsdk.license;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.common.AndroidUniqueCode;
import com.video.androidsdk.common.util.FileUtil;
import com.video.androidsdk.log.LogEx;
import java.io.File;

/* compiled from: SDKLicenseMgr.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f3129a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f3130b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f3131c = false;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f3132d = false;
    public static boolean e = false;
    public static boolean f = false;
    public static boolean g = false;
    public static boolean h = false;
    public static boolean i = false;
    private static InterfaceC0094a j;
    private static boolean k;
    private static boolean l;
    private static boolean m;
    private static Context n;
    private static Handler o = new Handler();

    /* compiled from: SDKLicenseMgr.java */
    /* renamed from: com.video.androidsdk.license.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0094a {
        void a(String str, String str2);
    }

    static {
        System.loadLibrary("qcslicense");
        System.loadLibrary("licensejni");
    }

    private static void d(String str) {
        if (!new File(n.getFilesDir().getAbsolutePath() + "/mutilsdk.lic").exists()) {
            LogEx.e("SDKLicenseMgr", "mutilsdk.lic not found");
            f3129a = false;
            f3130b = false;
            f3131c = false;
            f3132d = false;
            e = false;
            f = false;
            g = false;
            h = false;
            InterfaceC0094a interfaceC0094a = j;
            if (interfaceC0094a != null) {
                interfaceC0094a.a(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "mutilsdk.lic not found");
                return;
            }
            return;
        }
        int LicInit = str != null ? LicenseNativeSDK.LicInit(str.trim(), n.getFilesDir().getAbsolutePath(), n.getPackageName(), Build.MODEL, "2", "8", AndroidUniqueCode.getAndroidId(n)) : -1;
        LogEx.d("SDKLicenseMgr", "start init license returncode:" + LicInit);
        if (LicInit != 0) {
            f3129a = false;
            f3130b = false;
            f3131c = false;
            f3132d = false;
            e = false;
            f = false;
            g = false;
            h = false;
            InterfaceC0094a interfaceC0094a2 = j;
            if (interfaceC0094a2 != null) {
                interfaceC0094a2.a(String.valueOf(LicInit), "LicInit fail");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(String str) {
        if (str.contains("101")) {
            f3129a = true;
        }
        if (str.contains("102")) {
            e = true;
        }
        if (str.contains("103")) {
            f3132d = true;
        }
        if (str.contains("104")) {
            g = true;
        }
        if (str.contains("201")) {
            f3130b = true;
        }
        if (str.contains("301")) {
            f = true;
        }
        if (str.contains("401")) {
            f3131c = true;
        }
        if (str.contains("105")) {
            i = true;
        }
        h = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(String str) {
        if (m) {
            m = false;
            String serialNum = AndroidUniqueCode.getSerialNum();
            if (!TextUtils.isEmpty(serialNum)) {
                LogEx.d("SDKLicenseMgr", " mbIsSN is true");
                l = true;
            } else {
                serialNum = AndroidUniqueCode.getANDROIDID(n);
                if (!TextUtils.isEmpty(serialNum)) {
                    LogEx.d("SDKLicenseMgr", " mbIsIMEI is true");
                    k = true;
                }
            }
            if (!TextUtils.isEmpty(serialNum)) {
                LogEx.d("SDKLicenseMgr", " initLicense");
                d(serialNum);
                return;
            }
            LogEx.d("SDKLicenseMgr", " onSDKInitReturn");
            InterfaceC0094a interfaceC0094a = j;
            if (interfaceC0094a != null) {
                interfaceC0094a.a(str, "LicInit fail");
                return;
            }
            return;
        }
        if (l) {
            l = false;
            String androidid = AndroidUniqueCode.getANDROIDID(n);
            if (!TextUtils.isEmpty(androidid)) {
                k = true;
                LogEx.d("SDKLicenseMgr", " initLicense");
                d(androidid);
                return;
            } else {
                LogEx.d("SDKLicenseMgr", " onSDKInitReturn");
                InterfaceC0094a interfaceC0094a2 = j;
                if (interfaceC0094a2 != null) {
                    interfaceC0094a2.a(str, "LicInit fail");
                    return;
                }
                return;
            }
        }
        LogEx.d("SDKLicenseMgr", " onSDKInitReturn");
        InterfaceC0094a interfaceC0094a3 = j;
        if (interfaceC0094a3 != null) {
            interfaceC0094a3.a(str, "LicInit fail");
        }
    }

    public static void a(Context context, InterfaceC0094a interfaceC0094a) {
        LogEx.d("SDKLicenseMgr", "start init license");
        LogEx.d("SDKLicenseMgr", "mainthread is " + Thread.currentThread());
        n = context;
        j = interfaceC0094a;
        LogEx.d("SDKLicenseMgr", "copyFiles");
        b();
        c();
    }

    private static void b() {
        Context context = n;
        FileUtil.copyFileFromAssets(context, "mutilsdk.lic", context.getFilesDir().getAbsolutePath(), null);
        Context context2 = n;
        FileUtil.copyFileFromAssets(context2, "keystore.cfg", context2.getFilesDir().getAbsolutePath(), null);
        Context context3 = n;
        FileUtil.copyFileFromAssets(context3, "Key.data", context3.getFilesDir().getAbsolutePath(), null);
        if (new File(n.getFilesDir().getAbsolutePath() + "/keystore.cfg").exists()) {
            LicenseNativeSDK.SetKeycfgFilePath(n.getFilesDir().getAbsolutePath() + "/keystore.cfg");
        }
    }

    private static void c() {
        String deviceMacAddress = AndroidUniqueCode.getDeviceMacAddress(n);
        if (!TextUtils.isEmpty(deviceMacAddress)) {
            LogEx.d("SDKLicenseMgr", " mbIsMac is true");
            m = true;
        } else {
            deviceMacAddress = AndroidUniqueCode.getSerialNum();
            if (!TextUtils.isEmpty(deviceMacAddress)) {
                LogEx.d("SDKLicenseMgr", " mbIsSN is true");
                l = true;
            } else {
                deviceMacAddress = AndroidUniqueCode.getANDROIDID(n);
                if (!TextUtils.isEmpty(deviceMacAddress)) {
                    LogEx.d("SDKLicenseMgr", " mbIsIMEI is true");
                    k = true;
                }
            }
        }
        if (!TextUtils.isEmpty(deviceMacAddress)) {
            LogEx.d("SDKLicenseMgr", " initLicense");
            d(deviceMacAddress);
        } else {
            InterfaceC0094a interfaceC0094a = j;
            if (interfaceC0094a != null) {
                interfaceC0094a.a(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "LicInit fail");
            }
        }
    }

    public static void a(int i2, String str, String str2) {
        LogEx.d("SDKLicenseMgr", "init license callback-->returncode:" + i2 + "\nencryptinfo:" + str + "\nfunlist" + str2);
        StringBuilder sb = new StringBuilder();
        sb.append("currentthread is ");
        sb.append(Thread.currentThread());
        LogEx.d("SDKLicenseMgr", sb.toString());
        f3129a = false;
        f3130b = false;
        f3131c = false;
        f3132d = false;
        e = false;
        f = false;
        g = false;
        h = false;
        i = false;
        o.post(new b(i2, str2));
    }

    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            LogEx.e("SDKLicenseMgr", "key is empty!");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            LogEx.e("SDKLicenseMgr", "input param is empty!");
            return "";
        }
        String encodeStringByKey = LicenseNativeSDK.getEncodeStringByKey(str, str2);
        LogEx.d("SDKLicenseMgr", "strEncode is ==== " + encodeStringByKey);
        return encodeStringByKey;
    }

    public static String c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            LogEx.e("SDKLicenseMgr", "keyversion is empty!");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            LogEx.e("SDKLicenseMgr", "input param is empty!");
            return "";
        }
        return LicenseNativeSDK.getDecodeString(str, str2);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            LogEx.e("SDKLicenseMgr", "input param is empty!");
            return "";
        }
        return LicenseNativeSDK.GetEncryptKey(str);
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            LogEx.e("SDKLicenseMgr", "keyversion is empty!");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            LogEx.e("SDKLicenseMgr", "input param is empty!");
            return "";
        }
        String encodeString = LicenseNativeSDK.getEncodeString(str, str2);
        LogEx.d("SDKLicenseMgr", "strEncode is ==== " + encodeString);
        return encodeString;
    }
}
