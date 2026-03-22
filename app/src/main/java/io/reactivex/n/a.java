package io.reactivex.n;

import io.reactivex.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.k.c;
import io.reactivex.k.e;
import org.reactivestreams.Subscriber;

/* compiled from: RxJavaPlugins.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    static volatile e<? super Throwable> f8151a;

    /* renamed from: b, reason: collision with root package name */
    static volatile c<? super b, ? super Subscriber, ? extends Subscriber> f8152b;

    static boolean a(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    public static void b(Throwable th) {
        e<? super Throwable> eVar = f8151a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!a(th)) {
            th = new UndeliverableException(th);
        }
        if (eVar != null) {
            try {
                eVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                c(th2);
            }
        }
        th.printStackTrace();
        c(th);
    }

    static void c(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static <T> Subscriber<? super T> a(b<T> bVar, Subscriber<? super T> subscriber) {
        c<? super b, ? super Subscriber, ? extends Subscriber> cVar = f8152b;
        return cVar != null ? (Subscriber) a(cVar, bVar, subscriber) : subscriber;
    }

    static <T, U, R> R a(c<T, U, R> cVar, T t, U u) {
        try {
            return cVar.apply(t, u);
        } catch (Throwable th) {
            throw io.reactivex.internal.util.b.a(th);
        }
    }
}
