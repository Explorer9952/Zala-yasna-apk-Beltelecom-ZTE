package com.render.vrlib.l.c;

import android.os.Handler;
import android.os.Looper;
import com.render.vrlib.l.c.g;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: AbsInteractiveStrategy.java */
/* loaded from: classes.dex */
public abstract class a implements com.render.vrlib.l.b, f {

    /* renamed from: a, reason: collision with root package name */
    private g.a f2509a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f2510b = null;

    public a(g.a aVar) {
        this.f2509a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Runnable runnable) {
        b().post(runnable);
    }

    protected Handler b() {
        if (this.f2510b == null) {
            synchronized (this) {
                if (this.f2510b == null) {
                    this.f2510b = new Handler(Looper.getMainLooper());
                }
            }
        }
        return this.f2510b;
    }

    public g.a c() {
        return this.f2509a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized ConcurrentLinkedQueue<com.render.vrlib.a> d() {
        return this.f2509a.f2518c.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.render.vrlib.j.c e() {
        return this.f2509a.f2518c.a();
    }
}
