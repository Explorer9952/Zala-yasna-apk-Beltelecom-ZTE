package io.reactivex.internal.observers;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class EmptyCompletableObserver extends AtomicReference<io.reactivex.i.a> implements io.reactivex.a, io.reactivex.i.a {
    private static final long serialVersionUID = -7545121636549663526L;

    @Override // io.reactivex.i.a
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return false;
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.a
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.a
    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        io.reactivex.n.a.b(new OnErrorNotImplementedException(th));
    }

    @Override // io.reactivex.a
    public void onSubscribe(io.reactivex.i.a aVar) {
        DisposableHelper.setOnce(this, aVar);
    }
}
