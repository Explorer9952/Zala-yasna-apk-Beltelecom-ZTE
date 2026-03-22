package com.video.androidsdk.cast.a;

import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DLNASoImpl.java */
/* loaded from: classes.dex */
public class b extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3053a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3053a = aVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f3053a.n = false;
    }
}
