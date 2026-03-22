package io.reactivex.internal.disposables;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes2.dex */
public final class ArrayCompositeDisposable extends AtomicReferenceArray<io.reactivex.i.a> implements io.reactivex.i.a {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeDisposable(int i) {
        super(i);
    }

    @Override // io.reactivex.i.a
    public void dispose() {
        io.reactivex.i.a andSet;
        if (get(0) != DisposableHelper.DISPOSED) {
            int length = length();
            for (int i = 0; i < length; i++) {
                io.reactivex.i.a aVar = get(i);
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (aVar != disposableHelper && (andSet = getAndSet(i, disposableHelper)) != DisposableHelper.DISPOSED && andSet != null) {
                    andSet.dispose();
                }
            }
        }
    }

    public boolean isDisposed() {
        return get(0) == DisposableHelper.DISPOSED;
    }

    public io.reactivex.i.a replaceResource(int i, io.reactivex.i.a aVar) {
        io.reactivex.i.a aVar2;
        do {
            aVar2 = get(i);
            if (aVar2 == DisposableHelper.DISPOSED) {
                aVar.dispose();
                return null;
            }
        } while (!compareAndSet(i, aVar2, aVar));
        return aVar2;
    }

    public boolean setResource(int i, io.reactivex.i.a aVar) {
        io.reactivex.i.a aVar2;
        do {
            aVar2 = get(i);
            if (aVar2 == DisposableHelper.DISPOSED) {
                aVar.dispose();
                return false;
            }
        } while (!compareAndSet(i, aVar2, aVar));
        if (aVar2 == null) {
            return true;
        }
        aVar2.dispose();
        return true;
    }
}
