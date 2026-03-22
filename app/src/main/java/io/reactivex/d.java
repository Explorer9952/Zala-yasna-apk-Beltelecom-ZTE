package io.reactivex;

/* compiled from: MaybeObserver.java */
/* loaded from: classes2.dex */
public interface d<T> {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(io.reactivex.i.a aVar);
}
