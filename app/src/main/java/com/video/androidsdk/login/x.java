package com.video.androidsdk.login;

import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.impl.b;

/* compiled from: SDKLoginMgr.java */
/* loaded from: classes.dex */
class x implements b.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr f3225a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SDKLoginMgr sDKLoginMgr) {
        this.f3225a = sDKLoginMgr;
    }

    @Override // com.video.androidsdk.login.impl.b.c
    public void a(String str, String str2) {
        SDKLoginMgr.ISDKLoginReturnListener iSDKLoginReturnListener;
        SDKLoginMgr.ISDKLoginReturnListener iSDKLoginReturnListener2;
        iSDKLoginReturnListener = this.f3225a.f3137c;
        if (iSDKLoginReturnListener != null) {
            iSDKLoginReturnListener2 = this.f3225a.f3137c;
            iSDKLoginReturnListener2.onHeartbeatReturn(String.valueOf(str), str2);
        }
    }
}
