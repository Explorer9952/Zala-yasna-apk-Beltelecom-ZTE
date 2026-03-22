package com.video.androidsdk.cast;

/* loaded from: classes.dex */
public class DlnaNativeSDK {
    public static native int JNI_DlnaInit(String str, int i, String str2, int i2, String str3, String str4, String str5, int i3, boolean z, boolean z2, String str6);

    public static native int JNI_DlnaUninit();

    public static native String JNI_GetDeviceInfoXML(int i);

    public static native int JNI_RefreshDevList();

    public static native long JNI_SendAction(int i, int i2, String str);

    public static native void JNI_SetLogOption(int i, String str);

    public static native void JNI_StartLogWrite();

    public static native void JNI_StopLogWrite();

    public static native void JNI_XMPPLogin(String str, String str2);

    public void dlnaNotify(int i, String str, String str2) {
        a.a().a(i, str, str2);
    }
}
