package io.reactivex.internal.operators.observable;

import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ObservableGroupBy$GroupByObserver<T, K, V> extends AtomicInteger implements g<T>, io.reactivex.i.a {
    static final Object NULL_KEY = new Object();
    private static final long serialVersionUID = -3688291656102519502L;
    final int bufferSize;
    final boolean delayError;
    final g<? super io.reactivex.m.a<K, V>> downstream;
    final f<? super T, ? extends K> keySelector;
    io.reactivex.i.a upstream;
    final f<? super T, ? extends V> valueSelector;
    final AtomicBoolean cancelled = new AtomicBoolean();
    final Map<Object, a<K, V>> groups = new ConcurrentHashMap();

    public ObservableGroupBy$GroupByObserver(g<? super io.reactivex.m.a<K, V>> gVar, f<? super T, ? extends K> fVar, f<? super T, ? extends V> fVar2, int i, boolean z) {
        this.downstream = gVar;
        this.keySelector = fVar;
        this.valueSelector = fVar2;
        this.bufferSize = i;
        this.delayError = z;
        lazySet(1);
    }

    public void cancel(K k) {
        if (k == null) {
            k = (K) NULL_KEY;
        }
        this.groups.remove(k);
        if (decrementAndGet() == 0) {
            this.upstream.dispose();
        }
    }

    @Override // io.reactivex.i.a
    public void dispose() {
        if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
            this.upstream.dispose();
        }
    }

    public boolean isDisposed() {
        return this.cancelled.get();
    }

    @Override // io.reactivex.g
    public void onComplete() {
        ArrayList arrayList = new ArrayList(this.groups.values());
        this.groups.clear();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((a) it2.next()).a();
        }
        this.downstream.onComplete();
    }

    @Override // io.reactivex.g
    public void onError(Throwable th) {
        ArrayList arrayList = new ArrayList(this.groups.values());
        this.groups.clear();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((a) it2.next()).a(th);
        }
        this.downstream.onError(th);
    }

    @Override // io.reactivex.g
    public void onNext(T t) {
        try {
            K apply = this.keySelector.apply(t);
            Object obj = apply != null ? apply : NULL_KEY;
            a<K, V> aVar = this.groups.get(obj);
            if (aVar == null) {
                if (this.cancelled.get()) {
                    return;
                }
                aVar = a.a(apply, this.bufferSize, this, this.delayError);
                this.groups.put(obj, aVar);
                getAndIncrement();
                this.downstream.onNext(aVar);
            }
            try {
                V apply2 = this.valueSelector.apply(t);
                io.reactivex.l.a.b.a(apply2, "The value supplied is null");
                aVar.a((a<K, V>) apply2);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.a(th);
                this.upstream.dispose();
                onError(th);
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.a(th2);
            this.upstream.dispose();
            onError(th2);
        }
    }

    @Override // io.reactivex.g
    public void onSubscribe(io.reactivex.i.a aVar) {
        if (DisposableHelper.validate(this.upstream, aVar)) {
            this.upstream = aVar;
            this.downstream.onSubscribe(this);
        }
    }
}
