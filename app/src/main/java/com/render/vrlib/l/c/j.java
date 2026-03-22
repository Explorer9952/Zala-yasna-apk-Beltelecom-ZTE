package com.render.vrlib.l.c;

import android.content.Context;

/* compiled from: MotionStrategy.java */
/* loaded from: classes.dex */
class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f2528a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ i f2529b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, Context context) {
        this.f2529b = iVar;
        this.f2528a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2529b.h(this.f2528a);
    }
}
