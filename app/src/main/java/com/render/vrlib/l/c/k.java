package com.render.vrlib.l.c;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MotionStrategy.java */
/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f2530a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.f2530a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean z2;
        Object obj;
        float[] fArr;
        z = this.f2530a.f;
        if (z) {
            z2 = this.f2530a.i;
            if (z2) {
                obj = this.f2530a.h;
                synchronized (obj) {
                    Iterator<com.render.vrlib.a> it2 = this.f2530a.d().iterator();
                    while (it2.hasNext()) {
                        com.render.vrlib.a next = it2.next();
                        fArr = this.f2530a.e;
                        next.a(fArr);
                    }
                }
            }
        }
    }
}
