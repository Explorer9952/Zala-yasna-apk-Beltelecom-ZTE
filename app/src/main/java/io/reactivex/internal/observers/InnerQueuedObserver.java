package io.reactivex.internal.observers;

import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.l.b.e;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class InnerQueuedObserver<T> extends AtomicReference<io.reactivex.i.a> implements g<T>, io.reactivex.i.a {
    private static final long serialVersionUID = -5417183359794346637L;
    volatile boolean done;
    int fusionMode;
    final a<T> parent;
    final int prefetch;
    e<T> queue;

    public InnerQueuedObserver(a<T> aVar, int i) {
        this.parent = aVar;
        this.prefetch = i;
    }

    @Override // io.reactivex.i.a
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public int fusionMode() {
        return this.fusionMode;
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // io.reactivex.g
    public void onComplete() {
        this.parent.a(this);
    }

    @Override // io.reactivex.g
    public void onError(Throwable th) {
        this.parent.a((InnerQueuedObserver) this, th);
    }

    @Override // io.reactivex.g
    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.a((InnerQueuedObserver<InnerQueuedObserver<T>>) this, (InnerQueuedObserver<T>) t);
        } else {
            this.parent.a();
        }
    }

    @Override // io.reactivex.g
    public void onSubscribe(io.reactivex.i.a aVar) {
        if (DisposableHelper.setOnce(this, aVar)) {
            if (aVar instanceof io.reactivex.l.b.a) {
                io.reactivex.l.b.a aVar2 = (io.reactivex.l.b.a) aVar;
                int requestFusion = aVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = aVar2;
                    this.done = true;
                    this.parent.a(this);
                    return;
                }
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = aVar2;
                    return;
                }
            }
            this.queue = io.reactivex.internal.util.e.a(-this.prefetch);
        }
    }

    public e<T> queue() {
        return this.queue;
    }

    public void setDone() {
        this.done = true;
    }
}
