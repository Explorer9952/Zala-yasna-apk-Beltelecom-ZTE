package com.render.vrlib.l;

import com.render.vrlib.MDVRLibrary;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ModeManager.java */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f2577a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f2578b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, int i) {
        this.f2578b = dVar;
        this.f2577a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        MDVRLibrary.h hVar;
        MDVRLibrary.h hVar2;
        hVar = this.f2578b.f2533c;
        if (hVar != null) {
            hVar2 = this.f2578b.f2533c;
            hVar2.onNotSupport(this.f2577a);
        }
    }
}
