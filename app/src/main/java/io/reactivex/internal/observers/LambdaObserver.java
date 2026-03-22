package io.reactivex.internal.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k.e;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class LambdaObserver<T> extends AtomicReference<io.reactivex.i.a> implements g<T>, io.reactivex.i.a {
    private static final long serialVersionUID = -7251123623727029452L;
    final io.reactivex.k.a onComplete;
    final e<? super Throwable> onError;
    final e<? super T> onNext;
    final e<? super io.reactivex.i.a> onSubscribe;

    public LambdaObserver(e<? super T> eVar, e<? super Throwable> eVar2, io.reactivex.k.a aVar, e<? super io.reactivex.i.a> eVar3) {
        this.onNext = eVar;
        this.onError = eVar2;
        this.onComplete = aVar;
        this.onSubscribe = eVar3;
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

    @Override // io.reactivex.g
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            io.reactivex.n.a.b(th);
        }
    }

    @Override // io.reactivex.g
    public void onError(Throwable th) {
        if (!isDisposed()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.onError.accept(th);
                return;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.a(th2);
                io.reactivex.n.a.b(new CompositeException(th, th2));
                return;
            }
        }
        io.reactivex.n.a.b(th);
    }

    @Override // io.reactivex.g
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            get().dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.g
    public void onSubscribe(io.reactivex.i.a aVar) {
        if (DisposableHelper.setOnce(this, aVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.a(th);
                aVar.dispose();
                onError(th);
            }
        }
    }
}
