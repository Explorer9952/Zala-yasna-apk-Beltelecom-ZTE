package io.reactivex.internal.subscribers;

import com.google.android.exoplayer2.C;
import io.reactivex.c;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements c<T>, Subscription {
    static final long COMPLETE_MASK = Long.MIN_VALUE;
    static final long REQUEST_MASK = Long.MAX_VALUE;
    private static final long serialVersionUID = 7917814472626990048L;
    protected final Subscriber<? super R> downstream;
    protected long produced;
    protected Subscription upstream;
    protected R value;

    public SinglePostCompleteSubscriber(Subscriber<? super R> subscriber) {
        this.downstream = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.upstream.cancel();
    }

    protected final void complete(R r) {
        long j = this.produced;
        if (j != 0) {
            io.reactivex.internal.util.a.b(this, j);
        }
        while (true) {
            long j2 = get();
            if ((j2 & Long.MIN_VALUE) != 0) {
                onDrop(r);
                return;
            }
            if ((j2 & Long.MAX_VALUE) != 0) {
                lazySet(C.TIME_UNSET);
                this.downstream.onNext(r);
                this.downstream.onComplete();
                return;
            } else {
                this.value = r;
                if (compareAndSet(0L, Long.MIN_VALUE)) {
                    return;
                } else {
                    this.value = null;
                }
            }
        }
    }

    protected void onDrop(R r) {
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        long j2;
        if (!SubscriptionHelper.validate(j)) {
            return;
        }
        do {
            j2 = get();
            if ((j2 & Long.MIN_VALUE) != 0) {
                if (compareAndSet(Long.MIN_VALUE, C.TIME_UNSET)) {
                    this.downstream.onNext(this.value);
                    this.downstream.onComplete();
                    return;
                }
                return;
            }
        } while (!compareAndSet(j2, io.reactivex.internal.util.a.a(j2, j)));
        this.upstream.request(j);
    }
}
