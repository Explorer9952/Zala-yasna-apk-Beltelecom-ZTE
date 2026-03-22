package io.reactivex.internal.observers;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k.e;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class CallbackCompletableObserver extends AtomicReference<io.reactivex.i.a> implements io.reactivex.a, io.reactivex.i.a, e<Throwable> {
    private static final long serialVersionUID = -4361286194466301354L;
    final io.reactivex.k.a onComplete;
    final e<? super Throwable> onError;

    public CallbackCompletableObserver(io.reactivex.k.a aVar) {
        this.onError = this;
        this.onComplete = aVar;
    }

    @Override // io.reactivex.i.a
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != this;
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.a
    public void onComplete() {
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            io.reactivex.n.a.b(th);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.a
    public void onError(Throwable th) {
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.a(th2);
            io.reactivex.n.a.b(th2);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.a
    public void onSubscribe(io.reactivex.i.a aVar) {
        DisposableHelper.setOnce(this, aVar);
    }

    @Override // io.reactivex.k.e
    public void accept(Throwable th) {
        io.reactivex.n.a.b(new OnErrorNotImplementedException(th));
    }

    public CallbackCompletableObserver(e<? super Throwable> eVar, io.reactivex.k.a aVar) {
        this.onError = eVar;
        this.onComplete = aVar;
    }
}
