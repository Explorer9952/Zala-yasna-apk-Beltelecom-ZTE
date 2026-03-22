package com.render.vrlib.a;

import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: MDGLHandler.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2457a;

    /* renamed from: b, reason: collision with root package name */
    private Queue<Runnable> f2458b = new LinkedBlockingQueue();

    /* renamed from: c, reason: collision with root package name */
    private Queue<Runnable> f2459c = new LinkedBlockingQueue();

    /* renamed from: d, reason: collision with root package name */
    private final Object f2460d = new Object();

    public void a(Runnable runnable) {
        if (this.f2457a || runnable == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            synchronized (this.f2460d) {
                this.f2458b.remove(runnable);
                this.f2458b.offer(runnable);
            }
            return;
        }
        runnable.run();
    }

    public void b() {
        this.f2457a = true;
    }

    public void a() {
        synchronized (this.f2460d) {
            this.f2459c.addAll(this.f2458b);
            this.f2458b.clear();
        }
        while (this.f2459c.size() > 0) {
            this.f2459c.poll().run();
        }
    }
}
