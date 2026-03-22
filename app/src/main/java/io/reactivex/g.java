package io.reactivex;

/* compiled from: Observer.java */
/* loaded from: classes2.dex */
public interface g<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(io.reactivex.i.a aVar);
}
