package com.video.androidsdk.login;

import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.bean.PortalAuthReq;
import com.video.androidsdk.login.impl.b;
import java.util.HashMap;

/* compiled from: SDKLoginMgr.java */
/* loaded from: classes.dex */
class y implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr.OnPortalAuthReturnListener f3226a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ PortalAuthReq f3227b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr f3228c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SDKLoginMgr sDKLoginMgr, SDKLoginMgr.OnPortalAuthReturnListener onPortalAuthReturnListener, PortalAuthReq portalAuthReq) {
        this.f3228c = sDKLoginMgr;
        this.f3226a = onPortalAuthReturnListener;
        this.f3227b = portalAuthReq;
    }

    @Override // com.video.androidsdk.login.impl.b.a
    public void a(String str, String str2, HashMap<String, String> hashMap) {
        boolean z;
        m.a().putAll(hashMap);
        if (!"0".equals(str)) {
            SDKLoginMgr.OnPortalAuthReturnListener onPortalAuthReturnListener = this.f3226a;
            if (onPortalAuthReturnListener != null) {
                onPortalAuthReturnListener.onPortalAuthReturn(String.valueOf(str), str2, null);
                return;
            }
            return;
        }
        this.f3228c.a(this.f3226a, this.f3227b.getDomain());
        z = this.f3228c.t;
        if (z) {
            this.f3228c.f3136a.a();
        }
    }
}
