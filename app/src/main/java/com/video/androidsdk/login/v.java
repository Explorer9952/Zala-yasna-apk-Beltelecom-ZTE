package com.video.androidsdk.login;

import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.impl.b;
import java.util.HashMap;

/* compiled from: SDKLoginMgr.java */
/* loaded from: classes.dex */
class v implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr.OnEncryTokenReturnListener f3221a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr f3222b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SDKLoginMgr sDKLoginMgr, SDKLoginMgr.OnEncryTokenReturnListener onEncryTokenReturnListener) {
        this.f3222b = sDKLoginMgr;
        this.f3221a = onEncryTokenReturnListener;
    }

    @Override // com.video.androidsdk.login.impl.b.a
    public void a(String str, String str2, HashMap<String, String> hashMap) {
        m.a().putAll(hashMap);
        SDKLoginMgr.OnEncryTokenReturnListener onEncryTokenReturnListener = this.f3221a;
        if (onEncryTokenReturnListener != null) {
            onEncryTokenReturnListener.onEncryTokenReturn(String.valueOf(str), str2, hashMap);
        }
    }
}
