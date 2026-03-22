package io.reactivex.l.a;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.Comparator;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscription;

/* compiled from: Functions.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Runnable f8148a;

    /* renamed from: b, reason: collision with root package name */
    public static final io.reactivex.k.e<Throwable> f8149b;

    /* compiled from: Functions.java */
    /* renamed from: io.reactivex.l.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0415a implements io.reactivex.k.a {
        C0415a() {
        }

        @Override // io.reactivex.k.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class b implements io.reactivex.k.e<Object> {
        b() {
        }

        @Override // io.reactivex.k.e
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class c {
        c() {
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class e implements io.reactivex.k.e<Throwable> {
        e() {
        }

        @Override // io.reactivex.k.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            io.reactivex.n.a.b(th);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class f implements io.reactivex.k.g<Object> {
        f() {
        }

        @Override // io.reactivex.k.g
        public boolean a(Object obj) {
            return false;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class g implements io.reactivex.k.f<Object, Object> {
        g() {
        }

        @Override // io.reactivex.k.f
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class h implements io.reactivex.k.e<Subscription> {
        h() {
        }

        @Override // io.reactivex.k.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Subscription subscription) throws Exception {
            subscription.request(Long.MAX_VALUE);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class i implements Comparator<Object> {
        i() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class j implements Callable<Object> {
        j() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class k implements io.reactivex.k.e<Throwable> {
        k() {
        }

        @Override // io.reactivex.k.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            io.reactivex.n.a.b(new OnErrorNotImplementedException(th));
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class l implements io.reactivex.k.g<Object> {
        l() {
        }

        @Override // io.reactivex.k.g
        public boolean a(Object obj) {
            return true;
        }
    }

    static {
        new g();
        f8148a = new d();
        new C0415a();
        new b();
        new e();
        f8149b = new k();
        new c();
        new l();
        new f();
        new j();
        new i();
        new h();
    }
}
