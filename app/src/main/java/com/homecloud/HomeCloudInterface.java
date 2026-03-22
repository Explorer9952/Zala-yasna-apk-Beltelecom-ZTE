package com.homecloud;

/* loaded from: classes.dex */
public class HomeCloudInterface {

    /* renamed from: a, reason: collision with root package name */
    private a f2387a;

    /* loaded from: classes.dex */
    public interface a {
        void CallBackInfo(int i, String str);
    }

    static {
        System.loadLibrary("homecloudSDK");
    }

    public void CallBackInfo(int i, byte[] bArr) {
        if (this.f2387a != null) {
            try {
                this.f2387a.CallBackInfo(i, new String(bArr, "UTF-8"));
                return;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ClientObject byte[] to string null");
                return;
            }
        }
        System.out.println("ClientObject is null");
    }

    public native void FileUpload(int i, String str);

    public native void HCDeviceBind(String str, String str2, String str3, int i);

    public native void HCDeviceLogin(String str);

    public native void HCDeviceLoginByDeviceCode(String str);

    public native void HCDeviceSTBLogin2UnknownSTB(String str, String str2, String str3, int i);

    public native void HCDeviceSeek();

    public native void HCEnvInit(String str, String str2, String str3, String str4, String str5, int i);

    public native void HCLogSetOpt(String str, int i);

    public native void HCLogStartWrite();

    public native void HCLogStopWrite();

    public native void HCPlatFormGetSmsCode(String str);

    public native void HCPlatFormLogin(String str, String str2);

    public native void HCPlatFormLoginBySms(String str, String str2);

    public native void HCPlatFormLogout();

    public native void HCPlatFormModifyPwd(String str, String str2, String str3);

    public native void HCPlatFormRegister(String str, String str2, String str3);

    public native void HCPlatFormResetPwd(String str, String str2, String str3);

    public native void HCPlatformRemoveBinding(String str);

    public native void HCPlatformUpdateAllBindings(String str, String str2, String str3);

    public native int LocalLogin(int i);

    public native int LoginByAddr(String str, int i);

    public native void NotifyNetworkState(int i, int i2, String str);

    public native void RemoteAccess(int i, String str);

    public native void SendMessage(int i, String str);

    public native void SetLogLevel(int i);

    public native void SetSDKCfg(int i, String str);

    public void setCallBackObject(a aVar) {
        System.out.println("setCallBackObject");
        this.f2387a = aVar;
    }
}
