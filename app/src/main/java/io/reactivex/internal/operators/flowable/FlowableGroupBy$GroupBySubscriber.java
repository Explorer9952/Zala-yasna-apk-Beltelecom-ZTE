package io.reactivex.internal.operators.flowable;

import io.reactivex.c;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k.f;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableGroupBy$GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<io.reactivex.j.a<K, V>> implements c<T> {
    static final Object NULL_KEY = new Object();
    private static final long serialVersionUID = -3688291656102519502L;
    final int bufferSize;
    final boolean delayError;
    boolean done;
    final Subscriber<? super io.reactivex.j.a<K, V>> downstream;
    Throwable error;
    final Queue<a<K, V>> evictedGroups;
    volatile boolean finished;
    final Map<Object, a<K, V>> groups;
    final f<? super T, ? extends K> keySelector;
    boolean outputFused;
    final io.reactivex.internal.queue.a<io.reactivex.j.a<K, V>> queue;
    Subscription upstream;
    final f<? super T, ? extends V> valueSelector;
    final AtomicBoolean cancelled = new AtomicBoolean();
    final AtomicLong requested = new AtomicLong();
    final AtomicInteger groupCount = new AtomicInteger(1);

    public FlowableGroupBy$GroupBySubscriber(Subscriber<? super io.reactivex.j.a<K, V>> subscriber, f<? super T, ? extends K> fVar, f<? super T, ? extends V> fVar2, int i, boolean z, Map<Object, a<K, V>> map, Queue<a<K, V>> queue) {
        this.downstream = subscriber;
        this.keySelector = fVar;
        this.valueSelector = fVar2;
        this.bufferSize = i;
        this.delayError = z;
        this.groups = map;
        this.evictedGroups = queue;
        this.queue = new io.reactivex.internal.queue.a<>(i);
    }

    private void completeEvictions() {
        if (this.evictedGroups != null) {
            int i = 0;
            while (true) {
                a<K, V> poll = this.evictedGroups.poll();
                if (poll == null) {
                    break;
                }
                poll.a();
                i++;
            }
            if (i != 0) {
                this.groupCount.addAndGet(-i);
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.cancelled.compareAndSet(false, true)) {
            completeEvictions();
            if (this.groupCount.decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }
    }

    boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, io.reactivex.internal.queue.a<?> aVar) {
        if (this.cancelled.get()) {
            aVar.a();
            return true;
        }
        if (this.delayError) {
            if (!z || !z2) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onComplete();
            }
            return true;
        }
        if (!z) {
            return false;
        }
        Throwable th2 = this.error;
        if (th2 != null) {
            aVar.a();
            subscriber.onError(th2);
            return true;
        }
        if (!z2) {
            return false;
        }
        subscriber.onComplete();
        return true;
    }

    public void clear() {
        this.queue.a();
    }

    void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        if (this.outputFused) {
            drainFused();
        } else {
            drainNormal();
        }
    }

    void drainFused() {
        Throwable th;
        io.reactivex.internal.queue.a<io.reactivex.j.a<K, V>> aVar = this.queue;
        Subscriber<? super io.reactivex.j.a<K, V>> subscriber = this.downstream;
        int i = 1;
        while (!this.cancelled.get()) {
            boolean z = this.finished;
            if (z && !this.delayError && (th = this.error) != null) {
                aVar.a();
                subscriber.onError(th);
                return;
            }
            subscriber.onNext(null);
            if (z) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    subscriber.onError(th2);
                    return;
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        aVar.a();
    }

    void drainNormal() {
        io.reactivex.internal.queue.a<io.reactivex.j.a<K, V>> aVar = this.queue;
        Subscriber<? super io.reactivex.j.a<K, V>> subscriber = this.downstream;
        int i = 1;
        do {
            long j = this.requested.get();
            long j2 = 0;
            while (j2 != j) {
                boolean z = this.finished;
                io.reactivex.j.a<K, V> c2 = aVar.c();
                boolean z2 = c2 == null;
                if (checkTerminated(z, z2, subscriber, aVar)) {
                    return;
                }
                if (z2) {
                    break;
                }
                subscriber.onNext(c2);
                j2++;
            }
            if (j2 == j && checkTerminated(this.finished, aVar.b(), subscriber, aVar)) {
                return;
            }
            if (j2 != 0) {
                if (j != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                this.upstream.request(j2);
            }
            i = addAndGet(-i);
        } while (i != 0);
    }

    public boolean isEmpty() {
        return this.queue.b();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done) {
            return;
        }
        Iterator<a<K, V>> it2 = this.groups.values().iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
        this.groups.clear();
        Queue<a<K, V>> queue = this.evictedGroups;
        if (queue != null) {
            queue.clear();
        }
        this.done = true;
        this.finished = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.done) {
            io.reactivex.n.a.b(th);
            return;
        }
        this.done = true;
        Iterator<a<K, V>> it2 = this.groups.values().iterator();
        while (it2.hasNext()) {
            it2.next().a(th);
        }
        this.groups.clear();
        Queue<a<K, V>> queue = this.evictedGroups;
        if (queue != null) {
            queue.clear();
        }
        this.error = th;
        this.finished = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        io.reactivex.internal.queue.a<io.reactivex.j.a<K, V>> aVar = this.queue;
        try {
            K apply = this.keySelector.apply(t);
            boolean z = false;
            Object obj = apply != null ? apply : NULL_KEY;
            a<K, V> aVar2 = this.groups.get(obj);
            if (aVar2 == null) {
                if (this.cancelled.get()) {
                    return;
                }
                aVar2 = a.a(apply, this.bufferSize, this, this.delayError);
                this.groups.put(obj, aVar2);
                this.groupCount.getAndIncrement();
                z = true;
            }
            try {
                V apply2 = this.valueSelector.apply(t);
                io.reactivex.l.a.b.a(apply2, "The valueSelector returned null");
                aVar2.a((a<K, V>) apply2);
                completeEvictions();
                if (z) {
                    aVar.a((io.reactivex.internal.queue.a<io.reactivex.j.a<K, V>>) aVar2);
                    drain();
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.a(th);
                this.upstream.cancel();
                onError(th);
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.a(th2);
            this.upstream.cancel();
            onError(th2);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            subscription.request(this.bufferSize);
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            io.reactivex.internal.util.a.a(this.requested, j);
            drain();
        }
    }

    @Override // io.reactivex.l.b.b
    public int requestFusion(int i) {
        if ((i & 2) == 0) {
            return 0;
        }
        this.outputFused = true;
        return 2;
    }

    /* renamed from: poll, reason: merged with bridge method [inline-methods] */
    public io.reactivex.j.a<K, V> m17poll() {
        return this.queue.c();
    }

    public void cancel(K k) {
        if (k == null) {
            k = (K) NULL_KEY;
        }
        this.groups.remove(k);
        if (this.groupCount.decrementAndGet() == 0) {
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.queue.a();
            }
        }
    }
}
