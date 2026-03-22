package io.reactivex.internal.operators.observable;

import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObserverResourceWrapper<T> extends AtomicReference<io.reactivex.i.a> implements g<T>, io.reactivex.i.a {
    private static final long serialVersionUID = -8612022020200669122L;
    final g<? super T> downstream;
    final AtomicReference<io.reactivex.i.a> upstream = new AtomicReference<>();

    public ObserverResourceWrapper(g<? super T> gVar) {
        this.downstream = gVar;
    }

    @Override // io.reactivex.i.a
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return this.upstream.get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.g
    public void onComplete() {
        dispose();
        this.downstream.onComplete();
    }

    @Override // io.reactivex.g
    public void onError(Throwable th) {
        dispose();
        this.downstream.onError(th);
    }

    @Override // io.reactivex.g
    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    @Override // io.reactivex.g
    public void onSubscribe(io.reactivex.i.a aVar) {
        if (DisposableHelper.setOnce(this.upstream, aVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void setResource(io.reactivex.i.a aVar) {
        DisposableHelper.set(this, aVar);
    }
}
