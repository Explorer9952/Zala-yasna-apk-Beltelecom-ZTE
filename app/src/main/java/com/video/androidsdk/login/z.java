package com.video.androidsdk.login;

import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.impl.b;
import java.util.HashMap;

/* compiled from: SDKLoginMgr.java */
/* loaded from: classes.dex */
class z implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr.OnLoadBalanceReturnListener f3229a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr f3230b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SDKLoginMgr sDKLoginMgr, SDKLoginMgr.OnLoadBalanceReturnListener onLoadBalanceReturnListener) {
        this.f3230b = sDKLoginMgr;
        this.f3229a = onLoadBalanceReturnListener;
    }

    @Override // com.video.androidsdk.login.impl.b.a
    public void a(String str, String str2, HashMap<String, String> hashMap) {
        m.a().putAll(hashMap);
        SDKLoginMgr.OnLoadBalanceReturnListener onLoadBalanceReturnListener = this.f3229a;
        if (onLoadBalanceReturnListener != null) {
            onLoadBalanceReturnListener.onLoadBalanceReturn(String.valueOf(str), str2, hashMap);
        }
    }
}
