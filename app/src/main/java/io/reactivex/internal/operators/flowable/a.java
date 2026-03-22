package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FlowableGroupBy.java */
/* loaded from: classes2.dex */
public final class a<K, T> extends io.reactivex.j.a<K, T> {

    /* renamed from: b, reason: collision with root package name */
    final b<T, K> f8127b;

    protected a(K k, b<T, K> bVar) {
        super(k);
        this.f8127b = bVar;
    }

    public static <T, K> a<K, T> a(K k, int i, FlowableGroupBy$GroupBySubscriber<?, K, T> flowableGroupBy$GroupBySubscriber, boolean z) {
        return new a<>(k, new b(i, flowableGroupBy$GroupBySubscriber, k, z));
    }

    @Override // io.reactivex.b
    protected void a(Subscriber<? super T> subscriber) {
        this.f8127b.subscribe(subscriber);
    }

    public void a(T t) {
        this.f8127b.onNext(t);
    }

    public void a(Throwable th) {
        this.f8127b.onError(th);
    }

    public void a() {
        this.f8127b.onComplete();
    }
}
