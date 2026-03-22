package io.reactivex.internal.operators.maybe;

import io.reactivex.d;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k.e;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class MaybeCallbackObserver<T> extends AtomicReference<io.reactivex.i.a> implements d<T>, io.reactivex.i.a {
    private static final long serialVersionUID = -6076952298809384986L;
    final io.reactivex.k.a onComplete;
    final e<? super Throwable> onError;
    final e<? super T> onSuccess;

    public MaybeCallbackObserver(e<? super T> eVar, e<? super Throwable> eVar2, io.reactivex.k.a aVar) {
        this.onSuccess = eVar;
        this.onError = eVar2;
        this.onComplete = aVar;
    }

    @Override // io.reactivex.i.a
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != io.reactivex.l.a.a.f8149b;
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.d
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            io.reactivex.n.a.b(th);
        }
    }

    @Override // io.reactivex.d
    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.a(th2);
            io.reactivex.n.a.b(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.d
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
