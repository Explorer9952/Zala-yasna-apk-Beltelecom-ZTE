package com.video.androidsdk.mes;

/* loaded from: classes.dex */
public class MesMsgNativeSDK {
    static {
        System.loadLibrary("threadutil");
        System.loadLibrary("ixml");
        System.loadLibrary("upnp");
        System.loadLibrary("qcsdlna");
        System.loadLibrary("dlnajni");
        System.loadLibrary("mesjni");
    }

    public static native int InitMESClient(String str, int i, String str2, String str3, String str4, String str5, String str6);

    public static native int QueryMsgInfo(String str, String str2);

    public static native int QueryMsgInfoAfterTimestamp(String str);

    public static native int ReportPlaystatus(String str, String str2);

    public static native int UninitMESClient();

    public void onNotify(int i, String str) {
        SDKCloudMsgMgr.getInstance().onMESNotify(i, str);
    }
}
