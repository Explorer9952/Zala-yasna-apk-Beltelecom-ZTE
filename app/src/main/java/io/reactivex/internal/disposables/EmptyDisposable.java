package io.reactivex.internal.disposables;

import io.reactivex.d;
import io.reactivex.g;
import io.reactivex.h;

/* loaded from: classes2.dex */
public enum EmptyDisposable implements io.reactivex.l.b.a<Object> {
    INSTANCE,
    NEVER;

    public static void complete(g<?> gVar) {
        gVar.onSubscribe(INSTANCE);
        gVar.onComplete();
    }

    public static void error(Throwable th, g<?> gVar) {
        gVar.onSubscribe(INSTANCE);
        gVar.onError(th);
    }

    public void clear() {
    }

    @Override // io.reactivex.i.a
    public void dispose() {
    }

    public boolean isDisposed() {
        return this == INSTANCE;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public Object poll() throws Exception {
        return null;
    }

    @Override // io.reactivex.l.b.b
    public int requestFusion(int i) {
        return i & 2;
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void complete(d<?> dVar) {
        dVar.onSubscribe(INSTANCE);
        dVar.onComplete();
    }

    public static void error(Throwable th, io.reactivex.a aVar) {
        aVar.onSubscribe(INSTANCE);
        aVar.onError(th);
    }

    public static void complete(io.reactivex.a aVar) {
        aVar.onSubscribe(INSTANCE);
        aVar.onComplete();
    }

    public static void error(Throwable th, h<?> hVar) {
        hVar.onSubscribe(INSTANCE);
        hVar.onError(th);
    }

    public static void error(Throwable th, d<?> dVar) {
        dVar.onSubscribe(INSTANCE);
        dVar.onError(th);
    }
}
