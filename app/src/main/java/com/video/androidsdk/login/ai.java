package com.video.androidsdk.login;

import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.impl.IIPTVLogin;

/* compiled from: ThirdAppAuthIPTVLogin.java */
/* loaded from: classes.dex */
class ai implements com.video.androidsdk.login.impl.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ah f3163a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.f3163a = ahVar;
    }

    @Override // com.video.androidsdk.login.impl.a
    public void a() {
        String str;
        com.video.androidsdk.login.impl.a aVar;
        com.video.androidsdk.login.impl.a aVar2;
        str = ab.f3150b;
        LogEx.d(str, "relogin success");
        aVar = this.f3163a.f3162a.f3152c;
        if (aVar != null) {
            aVar2 = this.f3163a.f3162a.f3152c;
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
        str3 = ab.f3150b;
        LogEx.w(str3, "relogin failed");
        aVar = this.f3163a.f3162a.f3152c;
        if (aVar != null) {
            aVar2 = this.f3163a.f3162a.f3152c;
            aVar2.a(IIPTVLogin.RESPONSE_HEARTBEAT, str, str2);
        }
    }
}
