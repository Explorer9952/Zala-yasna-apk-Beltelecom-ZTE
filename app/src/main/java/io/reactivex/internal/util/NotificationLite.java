package io.reactivex.internal.util;

import io.reactivex.g;
import java.io.Serializable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public enum NotificationLite {
    COMPLETE;

    /* loaded from: classes2.dex */
    static final class a implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.i.a f8143a;

        a(io.reactivex.i.a aVar) {
            this.f8143a = aVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.f8143a + "]";
        }
    }

    /* loaded from: classes2.dex */
    static final class b implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: a, reason: collision with root package name */
        final Throwable f8144a;

        b(Throwable th) {
            this.f8144a = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return io.reactivex.l.a.b.a(this.f8144a, ((b) obj).f8144a);
            }
            return false;
        }

        public int hashCode() {
            return this.f8144a.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f8144a + "]";
        }
    }

    /* loaded from: classes2.dex */
    static final class c implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;

        /* renamed from: a, reason: collision with root package name */
        final Subscription f8145a;

        c(Subscription subscription) {
            this.f8145a = subscription;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.f8145a + "]";
        }
    }

    public static <T> boolean accept(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        }
        if (obj instanceof b) {
            subscriber.onError(((b) obj).f8144a);
            return true;
        }
        subscriber.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        }
        if (obj instanceof b) {
            subscriber.onError(((b) obj).f8144a);
            return true;
        }
        if (obj instanceof c) {
            subscriber.onSubscribe(((c) obj).f8145a);
            return false;
        }
        subscriber.onNext(obj);
        return false;
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(io.reactivex.i.a aVar) {
        return new a(aVar);
    }

    public static Object error(Throwable th) {
        return new b(th);
    }

    public static io.reactivex.i.a getDisposable(Object obj) {
        return ((a) obj).f8143a;
    }

    public static Throwable getError(Object obj) {
        return ((b) obj).f8144a;
    }

    public static Subscription getSubscription(Object obj) {
        return ((c) obj).f8145a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof a;
    }

    public static boolean isError(Object obj) {
        return obj instanceof b;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof c;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public static Object subscription(Subscription subscription) {
        return new c(subscription);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean accept(Object obj, g<? super T> gVar) {
        if (obj == COMPLETE) {
            gVar.onComplete();
            return true;
        }
        if (obj instanceof b) {
            gVar.onError(((b) obj).f8144a);
            return true;
        }
        gVar.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, g<? super T> gVar) {
        if (obj == COMPLETE) {
            gVar.onComplete();
            return true;
        }
        if (obj instanceof b) {
            gVar.onError(((b) obj).f8144a);
            return true;
        }
        if (obj instanceof a) {
            gVar.onSubscribe(((a) obj).f8143a);
            return false;
        }
        gVar.onNext(obj);
        return false;
    }
}
