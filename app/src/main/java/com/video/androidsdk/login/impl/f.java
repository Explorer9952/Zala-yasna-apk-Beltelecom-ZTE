package com.video.androidsdk.login.impl;

import com.video.androidsdk.log.LogEx;

/* compiled from: PublicLoginMethod.java */
/* loaded from: classes.dex */
class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f3195a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f3195a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        str = b.f3181a;
        LogEx.d(str, "sendHeartBeatRequest");
        e eVar = this.f3195a;
        eVar.f3194c.a(eVar.f3193b, eVar.f3192a);
    }
}
