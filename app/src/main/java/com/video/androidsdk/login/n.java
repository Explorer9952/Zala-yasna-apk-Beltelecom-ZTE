package com.video.androidsdk.login;

import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.impl.IIPTVLogin;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SDKLoginMgr.java */
/* loaded from: classes.dex */
public class n implements com.video.androidsdk.login.impl.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3204a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr f3205b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SDKLoginMgr sDKLoginMgr, String str) {
        this.f3205b = sDKLoginMgr;
        this.f3204a = str;
    }

    @Override // com.video.androidsdk.login.impl.a
    public void a(String str, String str2) {
        SDKLoginMgr.ISDKLoginReturnListener iSDKLoginReturnListener;
        iSDKLoginReturnListener = this.f3205b.f3137c;
        iSDKLoginReturnListener.onLogoutReturn(str, str2);
    }

    @Override // com.video.androidsdk.login.impl.a
    public void b(String str, String str2) {
        SDKLoginMgr.ISDKLoginReturnListener iSDKLoginReturnListener;
        iSDKLoginReturnListener = this.f3205b.f3137c;
        iSDKLoginReturnListener.onLoginReturn(str, str2);
    }

    @Override // com.video.androidsdk.login.impl.a
    public void a() {
        SDKLoginMgr.ISDKLoginReturnListener iSDKLoginReturnListener;
        com.video.androidsdk.login.a.b.a().b();
        iSDKLoginReturnListener = this.f3205b.f3137c;
        iSDKLoginReturnListener.onLoginReturn(Integer.toString(0), this.f3204a + " logined.");
        if (com.video.androidsdk.a.d.a()) {
            com.video.androidsdk.a.d.a(IIPTVLogin.LOGIN_EXTRAPARAM_EPGHOST, SDKLoginMgr.getInstance().getEPGHost());
            com.video.androidsdk.a.d.a(IIPTVLogin.LOGIN_EXTRAPARAM_EPGPORT, SDKLoginMgr.getInstance().getEPGPort());
            com.video.androidsdk.a.d.a("FrameHome", SDKLoginMgr.getInstance().getFrameHome());
        }
    }

    @Override // com.video.androidsdk.login.impl.a
    public void a(int i, String str, String str2) {
        SDKLoginMgr.ISDKLoginReturnListener iSDKLoginReturnListener;
        SDKLoginMgr.ISDKLoginReturnListener iSDKLoginReturnListener2;
        if (1300 != i) {
            iSDKLoginReturnListener = this.f3205b.f3137c;
            iSDKLoginReturnListener.onOtherRecvReturn(i, str, str2);
            return;
        }
        LogEx.d("SDKLoginMgr", "heartbeat response, result code is " + str + " , msg is " + str2);
        iSDKLoginReturnListener2 = this.f3205b.f3137c;
        iSDKLoginReturnListener2.onHeartbeatReturn(str, str2);
    }
}
