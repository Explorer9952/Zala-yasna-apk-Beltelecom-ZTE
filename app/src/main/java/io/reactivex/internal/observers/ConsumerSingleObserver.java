package io.reactivex.internal.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k.e;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ConsumerSingleObserver<T> extends AtomicReference<io.reactivex.i.a> implements h<T>, io.reactivex.i.a {
    private static final long serialVersionUID = -7012088219455310787L;
    final e<? super Throwable> onError;
    final e<? super T> onSuccess;

    public ConsumerSingleObserver(e<? super T> eVar, e<? super Throwable> eVar2) {
        this.onSuccess = eVar;
        this.onError = eVar2;
    }

    @Override // io.reactivex.i.a
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != io.reactivex.l.a.a.f8149b;
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.h
    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.a(th2);
            io.reactivex.n.a.b(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.h
    public void onSubscribe(io.reactivex.i.a aVar) {
        DisposableHelper.setOnce(this, aVar);
    }

    public void onSuccess(T t) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onSuccess.accept(t);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            io.reactivex.n.a.b(th);
        }
    }
}
