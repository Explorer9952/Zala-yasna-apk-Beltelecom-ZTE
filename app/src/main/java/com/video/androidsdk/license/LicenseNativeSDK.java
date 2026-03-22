package com.video.androidsdk.license;

/* loaded from: classes.dex */
public class LicenseNativeSDK {
    public static native String GetEncryptKey(String str);

    public static native int LicInit(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    public static native int SetKeycfgFilePath(String str);

    public static native String getDecodeString(String str, String str2);

    public static native String getEncodeString(String str, String str2);

    public static native String getEncodeStringByKey(String str, String str2);

    public void licCallback(int i, String str, String str2, String str3) {
        a.a(i, str, str2);
    }
}
