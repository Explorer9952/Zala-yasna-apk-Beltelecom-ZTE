package io.reactivex.internal.subscriptions;

import io.reactivex.i.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class AsyncSubscription extends AtomicLong implements Subscription, a {
    private static final long serialVersionUID = 7028635084060361255L;
    final AtomicReference<Subscription> actual;
    final AtomicReference<a> resource;

    public AsyncSubscription() {
        this.resource = new AtomicReference<>();
        this.actual = new AtomicReference<>();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        dispose();
    }

    @Override // io.reactivex.i.a
    public void dispose() {
        SubscriptionHelper.cancel(this.actual);
        DisposableHelper.dispose(this.resource);
    }

    public boolean isDisposed() {
        return this.actual.get() == SubscriptionHelper.CANCELLED;
    }

    public boolean replaceResource(a aVar) {
        return DisposableHelper.replace(this.resource, aVar);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.actual, this, j);
    }

    public boolean setResource(a aVar) {
        return DisposableHelper.set(this.resource, aVar);
    }

    public void setSubscription(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.actual, this, subscription);
    }

    public AsyncSubscription(a aVar) {
        this();
        this.resource.lazySet(aVar);
    }
}
