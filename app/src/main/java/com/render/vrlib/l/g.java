package com.render.vrlib.l;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ModeManager.java */
/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f2579a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f2580b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar, b bVar, Context context) {
        this.f2579a = bVar;
        this.f2580b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2579a.a(this.f2580b);
    }
}
