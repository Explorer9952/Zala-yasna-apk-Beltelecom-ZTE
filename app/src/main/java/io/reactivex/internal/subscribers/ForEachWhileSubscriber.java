package io.reactivex.internal.subscribers;

import io.reactivex.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k.e;
import io.reactivex.k.g;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ForEachWhileSubscriber<T> extends AtomicReference<Subscription> implements c<T>, io.reactivex.i.a {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final io.reactivex.k.a onComplete;
    final e<? super Throwable> onError;
    final g<? super T> onNext;

    public ForEachWhileSubscriber(g<? super T> gVar, e<? super Throwable> eVar, io.reactivex.k.a aVar) {
        this.onNext = gVar;
        this.onError = eVar;
        this.onComplete = aVar;
    }

    @Override // io.reactivex.i.a
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            io.reactivex.n.a.b(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.done) {
            io.reactivex.n.a.b(th);
            return;
        }
        this.done = true;
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.a(th2);
            io.reactivex.n.a.b(new CompositeException(th, th2));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        try {
            if (this.onNext.a(t)) {
                return;
            }
            dispose();
            onComplete();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            dispose();
            onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }
}
