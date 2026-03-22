package com.video.androidsdk.login;

import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.impl.b;
import java.util.HashMap;

/* compiled from: SDKLoginMgr.java */
/* loaded from: classes.dex */
class w implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr.OnUserTokenReturnListener f3223a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr f3224b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(SDKLoginMgr sDKLoginMgr, SDKLoginMgr.OnUserTokenReturnListener onUserTokenReturnListener) {
        this.f3224b = sDKLoginMgr;
        this.f3223a = onUserTokenReturnListener;
    }

    @Override // com.video.androidsdk.login.impl.b.a
    public void a(String str, String str2, HashMap<String, String> hashMap) {
        m.a().putAll(hashMap);
        SDKLoginMgr.OnUserTokenReturnListener onUserTokenReturnListener = this.f3223a;
        if (onUserTokenReturnListener != null) {
            onUserTokenReturnListener.onUserTokenReturn(String.valueOf(str), str2, hashMap);
        }
    }
}
