package io.reactivex.internal.operators.observable;

import io.reactivex.g;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ObservableScalarXMap$ScalarDisposable<T> extends AtomicInteger implements io.reactivex.l.b.a<T>, Runnable {
    static final int FUSED = 1;
    static final int ON_COMPLETE = 3;
    static final int ON_NEXT = 2;
    static final int START = 0;
    private static final long serialVersionUID = 3880992722410194083L;
    final g<? super T> observer;
    final T value;

    public ObservableScalarXMap$ScalarDisposable(g<? super T> gVar, T t) {
        this.observer = gVar;
        this.value = t;
    }

    public void clear() {
        lazySet(3);
    }

    @Override // io.reactivex.i.a
    public void dispose() {
        set(3);
    }

    public boolean isDisposed() {
        return get() == 3;
    }

    public boolean isEmpty() {
        return get() != 1;
    }

    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public T poll() throws Exception {
        if (get() != 1) {
            return null;
        }
        lazySet(3);
        return this.value;
    }

    @Override // io.reactivex.l.b.b
    public int requestFusion(int i) {
        if ((i & 1) == 0) {
            return 0;
        }
        lazySet(1);
        return 1;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (get() == 0 && compareAndSet(0, 2)) {
            this.observer.onNext(this.value);
            if (get() == 2) {
                lazySet(3);
                this.observer.onComplete();
            }
        }
    }

    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
