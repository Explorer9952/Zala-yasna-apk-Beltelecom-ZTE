package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* compiled from: HalfSerializer.java */
/* loaded from: classes2.dex */
public final class c {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(Subscriber<? super T> subscriber, T t, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            subscriber.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable terminate = atomicThrowable.terminate();
                if (terminate != null) {
                    subscriber.onError(terminate);
                } else {
                    subscriber.onComplete();
                }
            }
        }
    }

    public static void a(Subscriber<?> subscriber, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.addThrowable(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                subscriber.onError(atomicThrowable.terminate());
                return;
            }
            return;
        }
        io.reactivex.n.a.b(th);
    }

    public static void a(Subscriber<?> subscriber, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable terminate = atomicThrowable.terminate();
            if (terminate != null) {
                subscriber.onError(terminate);
            } else {
                subscriber.onComplete();
            }
        }
    }
}
