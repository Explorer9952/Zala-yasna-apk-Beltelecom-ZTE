package io.reactivex.internal.disposables;

import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.l.a.b;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public enum DisposableHelper implements io.reactivex.i.a {
    DISPOSED;

    public static boolean dispose(AtomicReference<io.reactivex.i.a> atomicReference) {
        io.reactivex.i.a andSet;
        io.reactivex.i.a aVar = atomicReference.get();
        DisposableHelper disposableHelper = DISPOSED;
        if (aVar == disposableHelper || (andSet = atomicReference.getAndSet(disposableHelper)) == disposableHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static boolean isDisposed(io.reactivex.i.a aVar) {
        return aVar == DISPOSED;
    }

    public static boolean replace(AtomicReference<io.reactivex.i.a> atomicReference, io.reactivex.i.a aVar) {
        io.reactivex.i.a aVar2;
        do {
            aVar2 = atomicReference.get();
            if (aVar2 == DISPOSED) {
                if (aVar == null) {
                    return false;
                }
                aVar.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(aVar2, aVar));
        return true;
    }

    public static void reportDisposableSet() {
        io.reactivex.n.a.b(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean set(AtomicReference<io.reactivex.i.a> atomicReference, io.reactivex.i.a aVar) {
        io.reactivex.i.a aVar2;
        do {
            aVar2 = atomicReference.get();
            if (aVar2 == DISPOSED) {
                if (aVar == null) {
                    return false;
                }
                aVar.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(aVar2, aVar));
        if (aVar2 == null) {
            return true;
        }
        aVar2.dispose();
        return true;
    }

    public static boolean setOnce(AtomicReference<io.reactivex.i.a> atomicReference, io.reactivex.i.a aVar) {
        b.a(aVar, "d is null");
        if (atomicReference.compareAndSet(null, aVar)) {
            return true;
        }
        aVar.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        reportDisposableSet();
        return false;
    }

    public static boolean trySet(AtomicReference<io.reactivex.i.a> atomicReference, io.reactivex.i.a aVar) {
        if (atomicReference.compareAndSet(null, aVar)) {
            return true;
        }
        if (atomicReference.get() != DISPOSED) {
            return false;
        }
        aVar.dispose();
        return false;
    }

    public static boolean validate(io.reactivex.i.a aVar, io.reactivex.i.a aVar2) {
        if (aVar2 == null) {
            io.reactivex.n.a.b(new NullPointerException("next is null"));
            return false;
        }
        if (aVar == null) {
            return true;
        }
        aVar2.dispose();
        reportDisposableSet();
        return false;
    }

    @Override // io.reactivex.i.a
    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }
}
