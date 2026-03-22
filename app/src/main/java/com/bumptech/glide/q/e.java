package com.bumptech.glide.q;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: RequestFutureTarget.java */
/* loaded from: classes.dex */
public class e<T, R> implements com.bumptech.glide.q.a<R>, Runnable {
    private static final a l = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Handler f2298a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2299b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2300c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f2301d;
    private final a e;
    private R f;
    private c g;
    private boolean h;
    private Exception i;
    private boolean j;
    private boolean k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestFutureTarget.java */
    /* loaded from: classes.dex */
    public static class a {
        a() {
        }

        public void a(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }

        public void a(Object obj) {
            obj.notifyAll();
        }
    }

    public e(Handler handler, int i, int i2) {
        this(handler, i, i2, true, l);
    }

    @Override // com.bumptech.glide.q.j.j
    public void a(com.bumptech.glide.q.j.h hVar) {
        hVar.a(this.f2299b, this.f2300c);
    }

    @Override // com.bumptech.glide.manager.h
    public void b() {
    }

    @Override // com.bumptech.glide.q.j.j
    public void b(Drawable drawable) {
    }

    @Override // com.bumptech.glide.q.j.j
    public void c(Drawable drawable) {
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        if (this.h) {
            return true;
        }
        boolean z2 = !isDone();
        if (z2) {
            this.h = true;
            if (z) {
                a();
            }
            this.e.a(this);
        }
        return z2;
    }

    @Override // com.bumptech.glide.q.j.j
    public c d() {
        return this.g;
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        try {
            return a((Long) null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.h;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.h) {
            z = this.j;
        }
        return z;
    }

    @Override // com.bumptech.glide.manager.h
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.h
    public void onStop() {
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar = this.g;
        if (cVar != null) {
            cVar.clear();
            cancel(false);
        }
    }

    e(Handler handler, int i, int i2, boolean z, a aVar) {
        this.f2298a = handler;
        this.f2299b = i;
        this.f2300c = i2;
        this.f2301d = z;
        this.e = aVar;
    }

    @Override // com.bumptech.glide.q.j.j
    public void a(c cVar) {
        this.g = cVar;
    }

    @Override // com.bumptech.glide.q.j.j
    public synchronized void a(Exception exc, Drawable drawable) {
        this.k = true;
        this.i = exc;
        this.e.a(this);
    }

    @Override // java.util.concurrent.Future
    public R get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(Long.valueOf(timeUnit.toMillis(j)));
    }

    @Override // com.bumptech.glide.q.j.j
    public synchronized void a(R r, com.bumptech.glide.q.i.c<? super R> cVar) {
        this.j = true;
        this.f = r;
        this.e.a(this);
    }

    private synchronized R a(Long l2) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f2301d) {
            com.bumptech.glide.s.h.a();
        }
        if (!this.h) {
            if (!this.k) {
                if (this.j) {
                    return this.f;
                }
                if (l2 == null) {
                    this.e.a(this, 0L);
                } else if (l2.longValue() > 0) {
                    this.e.a(this, l2.longValue());
                }
                if (!Thread.interrupted()) {
                    if (!this.k) {
                        if (!this.h) {
                            if (this.j) {
                                return this.f;
                            }
                            throw new TimeoutException();
                        }
                        throw new CancellationException();
                    }
                    throw new ExecutionException(this.i);
                }
                throw new InterruptedException();
            }
            throw new ExecutionException(this.i);
        }
        throw new CancellationException();
    }

    public void a() {
        this.f2298a.post(this);
    }
}
