package com.render.vrlib.l;

import android.content.Context;

/* compiled from: ModeManager.java */
/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f2581a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f2582b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar, b bVar, Context context) {
        this.f2581a = bVar;
        this.f2582b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2581a.e(this.f2582b);
    }
}
