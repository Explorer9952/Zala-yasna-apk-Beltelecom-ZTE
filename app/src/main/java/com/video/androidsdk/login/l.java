package com.video.androidsdk.login;

import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.impl.IIPTVLogin;

/* compiled from: IPTVLogin.java */
/* loaded from: classes.dex */
class l implements com.video.androidsdk.login.impl.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f3201a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f3201a = kVar;
    }

    @Override // com.video.androidsdk.login.impl.a
    public void a() {
        String str;
        com.video.androidsdk.login.impl.a aVar;
        com.video.androidsdk.login.impl.a aVar2;
        str = a.f3141a;
        LogEx.d(str, "relogin success");
        aVar = this.f3201a.f3200a.f3143c;
        if (aVar != null) {
            aVar2 = this.f3201a.f3200a.f3143c;
            aVar2.a(IIPTVLogin.RESPONSE_HEARTBEAT, "0", "relogin success");
        }
    }

    @Override // com.video.androidsdk.login.impl.a
    public void a(int i, String str, String str2) {
    }

    @Override // com.video.androidsdk.login.impl.a
    public void a(String str, String str2) {
    }

    @Override // com.video.androidsdk.login.impl.a
    public void b(String str, String str2) {
        String str3;
        com.video.androidsdk.login.impl.a aVar;
        com.video.androidsdk.login.impl.a aVar2;
        str3 = a.f3141a;
        LogEx.w(str3, "relogin failed");
        aVar = this.f3201a.f3200a.f3143c;
        if (aVar != null) {
            aVar2 = this.f3201a.f3200a.f3143c;
            aVar2.a(IIPTVLogin.RESPONSE_HEARTBEAT, str, str2);
        }
    }
}
