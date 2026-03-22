package io.reactivex.internal.operators.observable;

import io.reactivex.g;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ObservableGroupBy.java */
/* loaded from: classes2.dex */
public final class b<T, K> extends AtomicInteger implements io.reactivex.i.a {
    private static final long serialVersionUID = -3852313036005250360L;

    /* renamed from: a, reason: collision with root package name */
    final K f8135a;

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.internal.queue.a<T> f8136b;

    /* renamed from: c, reason: collision with root package name */
    final ObservableGroupBy$GroupByObserver<?, K, T> f8137c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f8138d;
    volatile boolean e;
    Throwable f;
    final AtomicBoolean g = new AtomicBoolean();
    final AtomicReference<g<? super T>> h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, ObservableGroupBy$GroupByObserver<?, K, T> observableGroupBy$GroupByObserver, K k, boolean z) {
        new AtomicBoolean();
        this.h = new AtomicReference<>();
        this.f8136b = new io.reactivex.internal.queue.a<>(i);
        this.f8137c = observableGroupBy$GroupByObserver;
        this.f8135a = k;
        this.f8138d = z;
    }

    public void a(T t) {
        this.f8136b.a((io.reactivex.internal.queue.a<T>) t);
        a();
    }

    public void b() {
        this.e = true;
        a();
    }

    @Override // io.reactivex.i.a
    public void dispose() {
        if (this.g.compareAndSet(false, true) && getAndIncrement() == 0) {
            this.h.lazySet(null);
            this.f8137c.cancel(this.f8135a);
        }
    }

    public void a(Throwable th) {
        this.f = th;
        this.e = true;
        a();
    }

    void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        io.reactivex.internal.queue.a<T> aVar = this.f8136b;
        boolean z = this.f8138d;
        g<? super T> gVar = this.h.get();
        int i = 1;
        while (true) {
            if (gVar != null) {
                while (true) {
                    boolean z2 = this.e;
                    T c2 = aVar.c();
                    boolean z3 = c2 == null;
                    if (a(z2, z3, gVar, z)) {
                        return;
                    }
                    if (z3) {
                        break;
                    } else {
                        gVar.onNext(c2);
                    }
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            if (gVar == null) {
                gVar = this.h.get();
            }
        }
    }

    boolean a(boolean z, boolean z2, g<? super T> gVar, boolean z3) {
        if (this.g.get()) {
            this.f8136b.a();
            this.f8137c.cancel(this.f8135a);
            this.h.lazySet(null);
            return true;
        }
        if (!z) {
            return false;
        }
        if (z3) {
            if (!z2) {
                return false;
            }
            Throwable th = this.f;
            this.h.lazySet(null);
            if (th != null) {
                gVar.onError(th);
            } else {
                gVar.onComplete();
            }
            return true;
        }
        Throwable th2 = this.f;
        if (th2 != null) {
            this.f8136b.a();
            this.h.lazySet(null);
            gVar.onError(th2);
            return true;
        }
        if (!z2) {
            return false;
        }
        this.h.lazySet(null);
        gVar.onComplete();
        return true;
    }
}
