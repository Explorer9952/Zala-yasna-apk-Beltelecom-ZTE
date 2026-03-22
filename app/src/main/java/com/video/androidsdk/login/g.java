package com.video.androidsdk.login;

import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.impl.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IPTVLogin.java */
/* loaded from: classes.dex */
public class g implements b.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3177a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.f3177a = aVar;
    }

    @Override // com.video.androidsdk.login.impl.b.c
    public void a(String str, String str2) {
        String str3;
        str3 = a.f3141a;
        LogEx.d(str3, "heartbeat failed, relogin");
        this.f3177a.a(new h(this));
    }
}
