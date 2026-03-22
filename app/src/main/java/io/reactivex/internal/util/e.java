package io.reactivex.internal.util;

import io.reactivex.internal.queue.SpscArrayQueue;
import org.reactivestreams.Subscription;

/* compiled from: QueueDrainHelper.java */
/* loaded from: classes2.dex */
public final class e {
    public static <T> io.reactivex.l.b.e<T> a(int i) {
        if (i < 0) {
            return new io.reactivex.internal.queue.a(-i);
        }
        return new SpscArrayQueue(i);
    }

    public static void a(Subscription subscription, int i) {
        subscription.request(i < 0 ? Long.MAX_VALUE : i);
    }
}
