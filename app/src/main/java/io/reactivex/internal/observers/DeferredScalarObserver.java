package io.reactivex.internal.observers;

import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements g<T> {
    private static final long serialVersionUID = -266195175408988651L;
    protected io.reactivex.i.a upstream;

    public DeferredScalarObserver(g<? super R> gVar) {
        super(gVar);
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.i.a
    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    @Override // io.reactivex.g
    public void onComplete() {
        T t = this.value;
        if (t != null) {
            this.value = null;
            complete(t);
        } else {
            complete();
        }
    }

    @Override // io.reactivex.g
    public void onError(Throwable th) {
        this.value = null;
        error(th);
    }

    @Override // io.reactivex.g
    public void onSubscribe(io.reactivex.i.a aVar) {
        if (DisposableHelper.validate(this.upstream, aVar)) {
            this.upstream = aVar;
            this.downstream.onSubscribe(this);
        }
    }
}
