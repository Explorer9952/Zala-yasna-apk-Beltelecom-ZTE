package com.video.androidsdk.login;

import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.impl.b;
import java.util.HashMap;

/* compiled from: SDKLoginMgr.java */
/* loaded from: classes.dex */
class u implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr.OnLoginCheckReturnListener f3219a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr f3220b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SDKLoginMgr sDKLoginMgr, SDKLoginMgr.OnLoginCheckReturnListener onLoginCheckReturnListener) {
        this.f3220b = sDKLoginMgr;
        this.f3219a = onLoginCheckReturnListener;
    }

    @Override // com.video.androidsdk.login.impl.b.a
    public void a(String str, String str2, HashMap<String, String> hashMap) {
        m.a().putAll(hashMap);
        SDKLoginMgr.OnLoginCheckReturnListener onLoginCheckReturnListener = this.f3219a;
        if (onLoginCheckReturnListener != null) {
            onLoginCheckReturnListener.onLoginCheckReturn(String.valueOf(str), str2, hashMap);
        }
    }
}
