package com.video.androidsdk.login.impl;

import com.video.androidsdk.common.TimerMgr;
import com.video.androidsdk.login.impl.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PublicLoginMethod.java */
/* loaded from: classes.dex */
public class d implements TimerMgr.ITimerMgr {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3189a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b.c f3190b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ b f3191c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, String str, b.c cVar) {
        this.f3191c = bVar;
        this.f3189a = str;
        this.f3190b = cVar;
    }

    @Override // com.video.androidsdk.common.TimerMgr.ITimerMgr
    public void onTimer(String str) {
        this.f3191c.a(this.f3189a, this.f3190b);
    }
}
