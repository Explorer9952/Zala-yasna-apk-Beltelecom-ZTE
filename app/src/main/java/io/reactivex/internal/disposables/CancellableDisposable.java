package io.reactivex.internal.disposables;

import io.reactivex.k.d;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class CancellableDisposable extends AtomicReference<d> implements io.reactivex.i.a {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(d dVar) {
        super(dVar);
    }

    @Override // io.reactivex.i.a
    public void dispose() {
        d andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (Exception e) {
            io.reactivex.exceptions.a.a(e);
            io.reactivex.n.a.b(e);
        }
    }

    public boolean isDisposed() {
        return get() == null;
    }
}
