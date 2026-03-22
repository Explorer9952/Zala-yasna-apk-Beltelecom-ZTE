package io.reactivex.internal.operators.observable;

/* compiled from: ObservableGroupBy.java */
/* loaded from: classes2.dex */
final class a<K, T> extends io.reactivex.m.a<K, T> {

    /* renamed from: b, reason: collision with root package name */
    final b<T, K> f8134b;

    protected a(K k, b<T, K> bVar) {
        super(k);
        this.f8134b = bVar;
    }

    public static <T, K> a<K, T> a(K k, int i, ObservableGroupBy$GroupByObserver<?, K, T> observableGroupBy$GroupByObserver, boolean z) {
        return new a<>(k, new b(i, observableGroupBy$GroupByObserver, k, z));
    }

    public void a(T t) {
        this.f8134b.a((b<T, K>) t);
    }

    public void a(Throwable th) {
        this.f8134b.a(th);
    }

    public void a() {
        this.f8134b.b();
    }
}
