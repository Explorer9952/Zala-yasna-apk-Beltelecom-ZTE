package io.reactivex.internal.operators.flowable;

import io.reactivex.k.e;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public enum FlowableInternalHelper$RequestMax implements e<Subscription> {
    INSTANCE;

    @Override // io.reactivex.k.e
    public void accept(Subscription subscription) throws Exception {
        subscription.request(Long.MAX_VALUE);
    }
}
