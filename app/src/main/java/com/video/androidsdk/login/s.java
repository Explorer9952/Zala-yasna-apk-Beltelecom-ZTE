package com.video.androidsdk.login;

import com.video.androidsdk.login.SDKLoginMgr;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SDKLoginMgr.java */
/* loaded from: classes.dex */
public class s implements com.video.androidsdk.login.impl.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr f3216a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(SDKLoginMgr sDKLoginMgr) {
        this.f3216a = sDKLoginMgr;
    }

    @Override // com.video.androidsdk.login.impl.a
    public void a() {
    }

    @Override // com.video.androidsdk.login.impl.a
    public void a(int i, String str, String str2) {
    }

    @Override // com.video.androidsdk.login.impl.a
    public void a(String str, String str2) {
        SDKLoginMgr.ISDKLoginReturnListener iSDKLoginReturnListener;
        m.b();
        iSDKLoginReturnListener = this.f3216a.f3137c;
        iSDKLoginReturnListener.onLogoutReturn(str, str2);
    }

    @Override // com.video.androidsdk.login.impl.a
    public void b(String str, String str2) {
    }
}
