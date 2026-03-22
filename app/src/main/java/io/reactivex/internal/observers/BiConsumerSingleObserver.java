package io.reactivex.internal.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k.b;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class BiConsumerSingleObserver<T> extends AtomicReference<io.reactivex.i.a> implements h<T>, io.reactivex.i.a {
    private static final long serialVersionUID = 4943102778943297569L;
    final b<? super T, ? super Throwable> onCallback;

    public BiConsumerSingleObserver(b<? super T, ? super Throwable> bVar) {
        this.onCallback = bVar;
    }

    @Override // io.reactivex.i.a
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.h
    public void onError(Throwable th) {
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.onCallback.a(null, th);
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
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.onCallback.a(t, null);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            io.reactivex.n.a.b(th);
        }
    }
}
