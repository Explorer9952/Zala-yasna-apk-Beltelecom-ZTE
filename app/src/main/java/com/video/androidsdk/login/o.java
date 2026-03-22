package com.video.androidsdk.login;

import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.impl.b;
import java.util.Properties;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SDKLoginMgr.java */
/* loaded from: classes.dex */
public class o implements b.InterfaceC0095b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr.OnPortalAuthReturnListener f3206a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr f3207b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(SDKLoginMgr sDKLoginMgr, SDKLoginMgr.OnPortalAuthReturnListener onPortalAuthReturnListener) {
        this.f3207b = sDKLoginMgr;
        this.f3206a = onPortalAuthReturnListener;
    }

    @Override // com.video.androidsdk.login.impl.b.InterfaceC0095b
    public void a(String str, String str2, Properties properties) {
        if ("0".equals(str)) {
            m.a(properties);
            SDKLoginMgr.OnPortalAuthReturnListener onPortalAuthReturnListener = this.f3206a;
            if (onPortalAuthReturnListener != null) {
                onPortalAuthReturnListener.onPortalAuthReturn(m.a().get("ReturnCode"), m.a().get("ErrorMsg"), m.a());
                return;
            }
            return;
        }
        SDKLoginMgr.OnPortalAuthReturnListener onPortalAuthReturnListener2 = this.f3206a;
        if (onPortalAuthReturnListener2 != null) {
            onPortalAuthReturnListener2.onPortalAuthReturn(str, str2, null);
        }
    }
}
