package io.reactivex.internal.operators.maybe;

import io.reactivex.e;
import io.reactivex.k.f;
import org.reactivestreams.Publisher;

/* loaded from: classes2.dex */
public enum MaybeToPublisher implements f<e<Object>, Publisher<Object>> {
    INSTANCE;

    public static <T> f<e<T>, Publisher<T>> instance() {
        return INSTANCE;
    }

    @Override // io.reactivex.k.f
    public Publisher<Object> apply(e<Object> eVar) throws Exception {
        return new a(eVar);
    }
}
