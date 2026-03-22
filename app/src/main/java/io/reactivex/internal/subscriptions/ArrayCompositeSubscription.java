package io.reactivex.internal.subscriptions;

import io.reactivex.i.a;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ArrayCompositeSubscription extends AtomicReferenceArray<Subscription> implements a {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int i) {
        super(i);
    }

    @Override // io.reactivex.i.a
    public void dispose() {
        Subscription andSet;
        if (get(0) != SubscriptionHelper.CANCELLED) {
            int length = length();
            for (int i = 0; i < length; i++) {
                Subscription subscription = get(i);
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (subscription != subscriptionHelper && (andSet = getAndSet(i, subscriptionHelper)) != SubscriptionHelper.CANCELLED && andSet != null) {
                    andSet.cancel();
                }
            }
        }
    }

    public boolean isDisposed() {
        return get(0) == SubscriptionHelper.CANCELLED;
    }

    public Subscription replaceResource(int i, Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = get(i);
            if (subscription2 == SubscriptionHelper.CANCELLED) {
                if (subscription == null) {
                    return null;
                }
                subscription.cancel();
                return null;
            }
        } while (!compareAndSet(i, subscription2, subscription));
        return subscription2;
    }

    public boolean setResource(int i, Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = get(i);
            if (subscription2 == SubscriptionHelper.CANCELLED) {
                if (subscription == null) {
                    return false;
                }
                subscription.cancel();
                return false;
            }
        } while (!compareAndSet(i, subscription2, subscription));
        if (subscription2 == null) {
            return true;
        }
        subscription2.cancel();
        return true;
    }
}
