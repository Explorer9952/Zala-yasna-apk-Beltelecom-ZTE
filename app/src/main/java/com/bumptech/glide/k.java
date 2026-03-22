package com.bumptech.glide;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.manager.c;
import com.bumptech.glide.manager.l;

/* compiled from: RequestManager.java */
/* loaded from: classes.dex */
public class k implements com.bumptech.glide.manager.h {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1927a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.manager.g f1928b;

    /* renamed from: c, reason: collision with root package name */
    private final l f1929c;

    /* renamed from: d, reason: collision with root package name */
    private final i f1930d;
    private final d e;
    private b f;

    /* compiled from: RequestManager.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.manager.g f1931a;

        a(com.bumptech.glide.manager.g gVar) {
            this.f1931a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1931a.a(k.this);
        }
    }

    /* compiled from: RequestManager.java */
    /* loaded from: classes.dex */
    public interface b {
        <T> void a(com.bumptech.glide.e<T, ?, ?, ?> eVar);
    }

    /* compiled from: RequestManager.java */
    /* loaded from: classes.dex */
    public final class c<A, T> {

        /* renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.h.l<A, T> f1933a;

        /* renamed from: b, reason: collision with root package name */
        private final Class<T> f1934b;

        /* compiled from: RequestManager.java */
        /* loaded from: classes.dex */
        public final class a {

            /* renamed from: a, reason: collision with root package name */
            private final A f1936a;

            /* renamed from: b, reason: collision with root package name */
            private final Class<A> f1937b;

            /* renamed from: c, reason: collision with root package name */
            private final boolean f1938c = true;

            a(A a2) {
                this.f1936a = a2;
                this.f1937b = k.c(a2);
            }

            public <Z> f<A, T, Z> a(Class<Z> cls) {
                d dVar = k.this.e;
                f<A, T, Z> fVar = new f<>(k.this.f1927a, k.this.f1930d, this.f1937b, c.this.f1933a, c.this.f1934b, cls, k.this.f1929c, k.this.f1928b, k.this.e);
                dVar.a(fVar);
                f<A, T, Z> fVar2 = fVar;
                if (this.f1938c) {
                    fVar2.a((f<A, T, Z>) this.f1936a);
                }
                return fVar2;
            }
        }

        c(com.bumptech.glide.load.h.l<A, T> lVar, Class<T> cls) {
            this.f1933a = lVar;
            this.f1934b = cls;
        }

        public c<A, T>.a a(A a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestManager.java */
    /* loaded from: classes.dex */
    public class d {
        d() {
        }

        public <A, X extends com.bumptech.glide.e<A, ?, ?, ?>> X a(X x) {
            if (k.this.f != null) {
                k.this.f.a(x);
            }
            return x;
        }
    }

    /* compiled from: RequestManager.java */
    /* loaded from: classes.dex */
    private static class e implements c.a {

        /* renamed from: a, reason: collision with root package name */
        private final l f1941a;

        public e(l lVar) {
            this.f1941a = lVar;
        }

        @Override // com.bumptech.glide.manager.c.a
        public void a(boolean z) {
            if (z) {
                this.f1941a.c();
            }
        }
    }

    public k(Context context, com.bumptech.glide.manager.g gVar, com.bumptech.glide.manager.k kVar) {
        this(context, gVar, kVar, new l(), new com.bumptech.glide.manager.d());
    }

    public void g() {
        com.bumptech.glide.s.h.b();
        this.f1929c.d();
    }

    @Override // com.bumptech.glide.manager.h
    public void onDestroy() {
        this.f1929c.a();
    }

    @Override // com.bumptech.glide.manager.h
    public void onStop() {
        f();
    }

    k(Context context, com.bumptech.glide.manager.g gVar, com.bumptech.glide.manager.k kVar, l lVar, com.bumptech.glide.manager.d dVar) {
        this.f1927a = context.getApplicationContext();
        this.f1928b = gVar;
        this.f1929c = lVar;
        this.f1930d = i.a(context);
        this.e = new d();
        com.bumptech.glide.manager.c a2 = dVar.a(context, new e(lVar));
        if (com.bumptech.glide.s.h.c()) {
            new Handler(Looper.getMainLooper()).post(new a(gVar));
        } else {
            gVar.a(this);
        }
        gVar.a(a2);
    }

    public void a(int i) {
        this.f1930d.a(i);
    }

    public com.bumptech.glide.d<String> c() {
        return a(String.class);
    }

    public void e() {
        this.f1930d.a();
    }

    public void f() {
        com.bumptech.glide.s.h.b();
        this.f1929c.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> Class<T> c(T t) {
        if (t != null) {
            return (Class<T>) t.getClass();
        }
        return null;
    }

    public <A, T> c<A, T> a(com.bumptech.glide.load.h.l<A, T> lVar, Class<T> cls) {
        return new c<>(lVar, cls);
    }

    @Override // com.bumptech.glide.manager.h
    public void b() {
        g();
    }

    public com.bumptech.glide.d<String> a(String str) {
        com.bumptech.glide.d<String> c2 = c();
        c2.a((com.bumptech.glide.d<String>) str);
        return c2;
    }

    public com.bumptech.glide.d<Integer> a(Integer num) {
        com.bumptech.glide.d<Integer> a2 = a();
        a2.a((com.bumptech.glide.d<Integer>) num);
        return a2;
    }

    public com.bumptech.glide.d<Integer> a() {
        com.bumptech.glide.d<Integer> a2 = a(Integer.class);
        a2.a(com.bumptech.glide.r.a.a(this.f1927a));
        return a2;
    }

    public <T> com.bumptech.glide.d<T> a(T t) {
        com.bumptech.glide.d<T> a2 = a((Class) c(t));
        a2.a((com.bumptech.glide.d<T>) t);
        return a2;
    }

    private <T> com.bumptech.glide.d<T> a(Class<T> cls) {
        com.bumptech.glide.load.h.l b2 = i.b(cls, this.f1927a);
        com.bumptech.glide.load.h.l a2 = i.a(cls, this.f1927a);
        if (cls != null && b2 == null && a2 == null) {
            throw new IllegalArgumentException("Unknown type " + cls + ". You must provide a Model of a type for which there is a registered ModelLoader, if you are using a custom model, you must first call Glide#register with a ModelLoaderFactory for your custom model class");
        }
        d dVar = this.e;
        com.bumptech.glide.d<T> dVar2 = new com.bumptech.glide.d<>(cls, b2, a2, this.f1927a, this.f1930d, this.f1929c, this.f1928b, dVar);
        dVar.a(dVar2);
        return dVar2;
    }
}
