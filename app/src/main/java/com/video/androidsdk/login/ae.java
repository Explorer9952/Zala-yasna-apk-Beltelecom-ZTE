package com.video.androidsdk.login;

import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.impl.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThirdAppAuthIPTVLogin.java */
/* loaded from: classes.dex */
public class ae implements b.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ab f3158a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar) {
        this.f3158a = abVar;
    }

    @Override // com.video.androidsdk.login.impl.b.c
    public void a(String str, String str2) {
        String str3;
        str3 = ab.f3150b;
        LogEx.d(str3, "heartbeat failed, relogin");
        this.f3158a.a(new af(this));
    }
}
