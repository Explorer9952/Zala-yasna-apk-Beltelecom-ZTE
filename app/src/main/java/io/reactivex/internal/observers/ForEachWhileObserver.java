package io.reactivex.internal.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k.e;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ForEachWhileObserver<T> extends AtomicReference<io.reactivex.i.a> implements g<T>, io.reactivex.i.a {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final io.reactivex.k.a onComplete;
    final e<? super Throwable> onError;
    final io.reactivex.k.g<? super T> onNext;

    public ForEachWhileObserver(io.reactivex.k.g<? super T> gVar, e<? super Throwable> eVar, io.reactivex.k.a aVar) {
        this.onNext = gVar;
        this.onError = eVar;
        this.onComplete = aVar;
    }

    @Override // io.reactivex.i.a
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.g
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            io.reactivex.n.a.b(th);
        }
    }

    @Override // io.reactivex.g
    public void onError(Throwable th) {
        if (this.done) {
            io.reactivex.n.a.b(th);
            return;
        }
        this.done = true;
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.a(th2);
            io.reactivex.n.a.b(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.g
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        try {
            if (this.onNext.a(t)) {
                return;
            }
            dispose();
            onComplete();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.g
    public void onSubscribe(io.reactivex.i.a aVar) {
        DisposableHelper.setOnce(this, aVar);
    }
}
