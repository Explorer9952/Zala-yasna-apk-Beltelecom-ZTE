package com.render.vrlib.l.e;

import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectionModeManager.java */
/* loaded from: classes.dex */
public class p extends com.render.vrlib.j.h {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ o f2571d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.f2571d = oVar;
    }

    @Override // com.render.vrlib.j.c
    public void a(int i, int i2) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        com.render.vrlib.w.d dVar;
        ConcurrentLinkedQueue concurrentLinkedQueue2;
        concurrentLinkedQueue = this.f2571d.j;
        if (concurrentLinkedQueue.size() > 0) {
            dVar = this.f2571d.k;
            concurrentLinkedQueue2 = this.f2571d.j;
            dVar.a(((com.render.vrlib.a) concurrentLinkedQueue2.peek()).k());
        }
    }
}
