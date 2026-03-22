package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ResourceRecycler.java */
/* loaded from: classes.dex */
class k {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2011a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f2012b = new Handler(Looper.getMainLooper(), new b());

    /* compiled from: ResourceRecycler.java */
    /* loaded from: classes.dex */
    private static class b implements Handler.Callback {
        private b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((j) message.obj).a();
            return true;
        }
    }

    public void a(j<?> jVar) {
        com.bumptech.glide.s.h.b();
        if (this.f2011a) {
            this.f2012b.obtainMessage(1, jVar).sendToTarget();
            return;
        }
        this.f2011a = true;
        jVar.a();
        this.f2011a = false;
    }
}
