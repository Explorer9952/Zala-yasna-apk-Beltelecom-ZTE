package com.video.androidsdk.login;

import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.impl.b;
import java.util.Properties;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SDKLoginMgr.java */
/* loaded from: classes.dex */
public class q implements b.InterfaceC0095b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3211a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr.ISDKProfileLoginReturnListener f3212b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr f3213c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(SDKLoginMgr sDKLoginMgr, String str, SDKLoginMgr.ISDKProfileLoginReturnListener iSDKProfileLoginReturnListener) {
        this.f3213c = sDKLoginMgr;
        this.f3211a = str;
        this.f3212b = iSDKProfileLoginReturnListener;
    }

    @Override // com.video.androidsdk.login.impl.b.InterfaceC0095b
    public void a(String str, String str2, Properties properties) {
        if ("0".equals(str)) {
            m.a().put("StypeUrl", this.f3211a);
            LogEx.d("SDKLoginMgr", "framecode is === " + m.a().get("StypeUrl"));
            m.a(properties);
        }
        SDKLoginMgr.ISDKProfileLoginReturnListener iSDKProfileLoginReturnListener = this.f3212b;
        if (iSDKProfileLoginReturnListener != null) {
            iSDKProfileLoginReturnListener.onProfileLoginReturn(str, str2);
        }
    }
}
