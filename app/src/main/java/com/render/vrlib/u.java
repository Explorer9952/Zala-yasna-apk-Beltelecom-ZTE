package com.render.vrlib;

import android.os.Handler;
import com.render.vrlib.s;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MDPickerManager.java */
/* loaded from: classes.dex */
public class u extends com.render.vrlib.j.h {

    /* renamed from: d, reason: collision with root package name */
    private long f2619d;
    final /* synthetic */ s e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.e = sVar;
    }

    @Override // com.render.vrlib.j.c
    public void a(int i, int i2) {
        com.render.vrlib.l.e.o oVar;
        s.d dVar;
        synchronized (this.e.l) {
            s.b bVar = this.e.k;
            oVar = this.e.f2603c;
            bVar.a(oVar.f());
        }
        if (this.e.a()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f2619d > 100) {
                Handler b2 = com.render.vrlib.a.e.b();
                dVar = this.e.j;
                b2.post(dVar);
                this.f2619d = currentTimeMillis;
            }
        }
    }
}
