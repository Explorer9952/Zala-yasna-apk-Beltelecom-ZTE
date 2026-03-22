package io.reactivex.internal.subscribers;

import io.reactivex.c;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.l.b.e;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class InnerQueuedSubscriber<T> extends AtomicReference<Subscription> implements c<T>, Subscription {
    private static final long serialVersionUID = 22876611072430776L;
    volatile boolean done;
    int fusionMode;
    final int limit;
    final a<T> parent;
    final int prefetch;
    long produced;
    volatile e<T> queue;

    public InnerQueuedSubscriber(a<T> aVar, int i) {
        this.parent = aVar;
        this.prefetch = i;
        this.limit = i - (i >> 2);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.parent.a(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.parent.a((InnerQueuedSubscriber) this, th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.a((InnerQueuedSubscriber<InnerQueuedSubscriber<T>>) this, (InnerQueuedSubscriber<T>) t);
        } else {
            this.parent.a();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            if (subscription instanceof io.reactivex.l.b.c) {
                io.reactivex.l.b.c cVar = (io.reactivex.l.b.c) subscription;
                int requestFusion = cVar.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = cVar;
                    this.done = true;
                    this.parent.a(this);
                    return;
                }
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = cVar;
                    io.reactivex.internal.util.e.a(subscription, this.prefetch);
                    return;
                }
            }
            this.queue = io.reactivex.internal.util.e.a(this.prefetch);
            io.reactivex.internal.util.e.a(subscription, this.prefetch);
        }
    }

    public e<T> queue() {
        return this.queue;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        if (this.fusionMode != 1) {
            long j2 = this.produced + j;
            if (j2 >= this.limit) {
                this.produced = 0L;
                get().request(j2);
            } else {
                this.produced = j2;
            }
        }
    }

    public void requestOne() {
        if (this.fusionMode != 1) {
            long j = this.produced + 1;
            if (j == this.limit) {
                this.produced = 0L;
                get().request(j);
            } else {
                this.produced = j;
            }
        }
    }

    public void setDone() {
        this.done = true;
    }
}
