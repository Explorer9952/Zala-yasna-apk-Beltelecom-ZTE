package io.reactivex.internal.subscribers;

import io.reactivex.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k.e;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class BoundedSubscriber<T> extends AtomicReference<Subscription> implements c<T>, Subscription, io.reactivex.i.a {
    private static final long serialVersionUID = -7251123623727029452L;
    final int bufferSize;
    int consumed;
    final int limit;
    final io.reactivex.k.a onComplete;
    final e<? super Throwable> onError;
    final e<? super T> onNext;
    final e<? super Subscription> onSubscribe;

    public BoundedSubscriber(e<? super T> eVar, e<? super Throwable> eVar2, io.reactivex.k.a aVar, e<? super Subscription> eVar3, int i) {
        this.onNext = eVar;
        this.onError = eVar2;
        this.onComplete = aVar;
        this.onSubscribe = eVar3;
        this.bufferSize = i;
        this.limit = i - (i >> 2);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.i.a
    public void dispose() {
        cancel();
    }

    public boolean hasCustomOnError() {
        return this.onError != io.reactivex.l.a.a.f8149b;
    }

    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Subscription subscription = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (subscription != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.a(th);
                io.reactivex.n.a.b(th);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        Subscription subscription = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (subscription != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.onError.accept(th);
                return;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.a(th2);
                io.reactivex.n.a.b(new CompositeException(th, th2));
                return;
            }
        }
        io.reactivex.n.a.b(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t);
            int i = this.consumed + 1;
            if (i == this.limit) {
                this.consumed = 0;
                get().request(this.limit);
            } else {
                this.consumed = i;
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            get().cancel();
            onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.a(th);
                subscription.cancel();
                onError(th);
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        get().request(j);
    }
}
