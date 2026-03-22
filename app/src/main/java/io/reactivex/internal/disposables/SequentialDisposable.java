package io.reactivex.internal.disposables;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class SequentialDisposable extends AtomicReference<io.reactivex.i.a> implements io.reactivex.i.a {
    private static final long serialVersionUID = -754898800686245608L;

    public SequentialDisposable() {
    }

    @Override // io.reactivex.i.a
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public boolean replace(io.reactivex.i.a aVar) {
        return DisposableHelper.replace(this, aVar);
    }

    public boolean update(io.reactivex.i.a aVar) {
        return DisposableHelper.set(this, aVar);
    }

    public SequentialDisposable(io.reactivex.i.a aVar) {
        lazySet(aVar);
    }
}
