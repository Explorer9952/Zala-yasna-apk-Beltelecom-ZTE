package com.render.vrlib.l.c;

import android.content.Context;

/* compiled from: CardboardMotionStrategy.java */
/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f2513a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c f2514b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, Context context) {
        this.f2514b = cVar;
        this.f2513a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2514b.h(this.f2513a);
    }
}
