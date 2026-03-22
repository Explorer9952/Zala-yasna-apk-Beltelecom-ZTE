package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FlowableGroupBy.java */
/* loaded from: classes2.dex */
public final class b<T, K> extends BasicIntQueueSubscription<T> implements Publisher<T> {
    private static final long serialVersionUID = -3852313036005250360L;

    /* renamed from: a, reason: collision with root package name */
    final K f8128a;

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.internal.queue.a<T> f8129b;

    /* renamed from: c, reason: collision with root package name */
    final FlowableGroupBy$GroupBySubscriber<?, K, T> f8130c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f8131d;
    volatile boolean f;
    Throwable g;
    boolean k;
    final AtomicLong e = new AtomicLong();
    final AtomicBoolean h = new AtomicBoolean();
    final AtomicReference<Subscriber<? super T>> i = new AtomicReference<>();
    final AtomicBoolean j = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, FlowableGroupBy$GroupBySubscriber<?, K, T> flowableGroupBy$GroupBySubscriber, K k, boolean z) {
        this.f8129b = new io.reactivex.internal.queue.a<>(i);
        this.f8130c = flowableGroupBy$GroupBySubscriber;
        this.f8128a = k;
        this.f8131d = z;
    }

    boolean a(boolean z, boolean z2, Subscriber<? super T> subscriber, boolean z3) {
        if (this.h.get()) {
            this.f8129b.a();
            return true;
        }
        if (!z) {
            return false;
        }
        if (z3) {
            if (!z2) {
                return false;
            }
            Throwable th = this.g;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onComplete();
            }
            return true;
        }
        Throwable th2 = this.g;
        if (th2 != null) {
            this.f8129b.a();
            subscriber.onError(th2);
            return true;
        }
        if (!z2) {
            return false;
        }
        subscriber.onComplete();
        return true;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.h.compareAndSet(false, true)) {
            this.f8130c.cancel(this.f8128a);
        }
    }

    void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        if (this.k) {
            drainFused();
        } else {
            drainNormal();
        }
    }

    void drainFused() {
        Throwable th;
        io.reactivex.internal.queue.a<T> aVar = this.f8129b;
        Subscriber<? super T> subscriber = this.i.get();
        int i = 1;
        while (true) {
            if (subscriber != null) {
                if (this.h.get()) {
                    aVar.a();
                    return;
                }
                boolean z = this.f;
                if (z && !this.f8131d && (th = this.g) != null) {
                    aVar.a();
                    subscriber.onError(th);
                    return;
                }
                subscriber.onNext(null);
                if (z) {
                    Throwable th2 = this.g;
                    if (th2 != null) {
                        subscriber.onError(th2);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            if (subscriber == null) {
                subscriber = this.i.get();
            }
        }
    }

    void drainNormal() {
        io.reactivex.internal.queue.a<T> aVar = this.f8129b;
        boolean z = this.f8131d;
        Subscriber<? super T> subscriber = this.i.get();
        int i = 1;
        while (true) {
            if (subscriber != null) {
                long j = this.e.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z2 = this.f;
                    T c2 = aVar.c();
                    boolean z3 = c2 == null;
                    if (a(z2, z3, subscriber, z)) {
                        return;
                    }
                    if (z3) {
                        break;
                    }
                    subscriber.onNext(c2);
                    j2++;
                }
                if (j2 == j && a(this.f, aVar.b(), subscriber, z)) {
                    return;
                }
                if (j2 != 0) {
                    if (j != Long.MAX_VALUE) {
                        this.e.addAndGet(-j2);
                    }
                    this.f8130c.upstream.request(j2);
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            if (subscriber == null) {
                subscriber = this.i.get();
            }
        }
    }

    public void onComplete() {
        this.f = true;
        drain();
    }

    public void onError(Throwable th) {
        this.g = th;
        this.f = true;
        drain();
    }

    public void onNext(T t) {
        this.f8129b.a((io.reactivex.internal.queue.a<T>) t);
        drain();
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            io.reactivex.internal.util.a.a(this.e, j);
            drain();
        }
    }

    @Override // io.reactivex.l.b.b
    public int requestFusion(int i) {
        if ((i & 2) == 0) {
            return 0;
        }
        this.k = true;
        return 2;
    }

    @Override // org.reactivestreams.Publisher
    public void subscribe(Subscriber<? super T> subscriber) {
        if (this.j.compareAndSet(false, true)) {
            subscriber.onSubscribe(this);
            this.i.lazySet(subscriber);
            drain();
            return;
        }
        EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), subscriber);
    }
}
