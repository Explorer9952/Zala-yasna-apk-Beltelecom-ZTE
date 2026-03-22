package com.render.vrlib.l.c;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InteractiveModeManager.java */
/* loaded from: classes.dex */
public class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f2524a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ g f2525b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, Context context) {
        this.f2525b = gVar;
        this.f2524a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.render.vrlib.l.b e;
        e = this.f2525b.e();
        ((a) e).b(this.f2524a);
    }
}
