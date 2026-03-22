package io.reactivex.internal.util;

import io.reactivex.g;
import io.reactivex.h;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public enum EmptyComponent implements io.reactivex.c<Object>, g<Object>, io.reactivex.d<Object>, h<Object>, io.reactivex.a, Subscription, io.reactivex.i.a {
    INSTANCE;

    public static <T> g<T> asObserver() {
        return INSTANCE;
    }

    public static <T> Subscriber<T> asSubscriber() {
        return INSTANCE;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // io.reactivex.i.a
    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        io.reactivex.n.a.b(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(Object obj) {
    }

    @Override // io.reactivex.g
    public void onSubscribe(io.reactivex.i.a aVar) {
        aVar.dispose();
    }

    public void onSuccess(Object obj) {
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        subscription.cancel();
    }
}
