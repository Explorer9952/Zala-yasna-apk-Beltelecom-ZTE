package com.render.vrlib.l.c;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CardboardMotionStrategy.java */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f2515a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.f2515a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean z2;
        Object obj;
        float[] fArr;
        z = this.f2515a.f2511c;
        if (z) {
            z2 = this.f2515a.i;
            if (z2) {
                obj = this.f2515a.f;
                synchronized (obj) {
                    Iterator<com.render.vrlib.a> it2 = this.f2515a.d().iterator();
                    while (it2.hasNext()) {
                        com.render.vrlib.a next = it2.next();
                        fArr = this.f2515a.e;
                        next.a(fArr);
                    }
                }
            }
        }
    }
}
