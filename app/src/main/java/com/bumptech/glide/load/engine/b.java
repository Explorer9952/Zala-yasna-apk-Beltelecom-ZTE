package com.bumptech.glide.load.engine;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.a;
import com.bumptech.glide.load.engine.g;
import com.bumptech.glide.load.engine.m.a;
import com.bumptech.glide.load.engine.m.h;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* compiled from: Engine.java */
/* loaded from: classes.dex */
public class b implements com.bumptech.glide.load.engine.d, h.a, g.a {

    /* renamed from: a, reason: collision with root package name */
    private final Map<com.bumptech.glide.load.b, com.bumptech.glide.load.engine.c> f1971a;

    /* renamed from: b, reason: collision with root package name */
    private final f f1972b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.m.h f1973c;

    /* renamed from: d, reason: collision with root package name */
    private final a f1974d;
    private final Map<com.bumptech.glide.load.b, WeakReference<g<?>>> e;
    private final k f;
    private final C0062b g;
    private ReferenceQueue<g<?>> h;

    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private final ExecutorService f1975a;

        /* renamed from: b, reason: collision with root package name */
        private final ExecutorService f1976b;

        /* renamed from: c, reason: collision with root package name */
        private final com.bumptech.glide.load.engine.d f1977c;

        public a(ExecutorService executorService, ExecutorService executorService2, com.bumptech.glide.load.engine.d dVar) {
            this.f1975a = executorService;
            this.f1976b = executorService2;
            this.f1977c = dVar;
        }

        public com.bumptech.glide.load.engine.c a(com.bumptech.glide.load.b bVar, boolean z) {
            return new com.bumptech.glide.load.engine.c(bVar, this.f1975a, this.f1976b, z, this.f1977c);
        }
    }

    /* compiled from: Engine.java */
    /* renamed from: com.bumptech.glide.load.engine.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0062b implements a.InterfaceC0061a {

        /* renamed from: a, reason: collision with root package name */
        private final a.InterfaceC0065a f1978a;

        /* renamed from: b, reason: collision with root package name */
        private volatile com.bumptech.glide.load.engine.m.a f1979b;

        public C0062b(a.InterfaceC0065a interfaceC0065a) {
            this.f1978a = interfaceC0065a;
        }

        @Override // com.bumptech.glide.load.engine.a.InterfaceC0061a
        public com.bumptech.glide.load.engine.m.a a() {
            if (this.f1979b == null) {
                synchronized (this) {
                    if (this.f1979b == null) {
                        this.f1979b = this.f1978a.build();
                    }
                    if (this.f1979b == null) {
                        this.f1979b = new com.bumptech.glide.load.engine.m.b();
                    }
                }
            }
            return this.f1979b;
        }
    }

    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.engine.c f1980a;

        /* renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.q.g f1981b;

        public c(com.bumptech.glide.q.g gVar, com.bumptech.glide.load.engine.c cVar) {
            this.f1981b = gVar;
            this.f1980a = cVar;
        }

        public void a() {
            this.f1980a.b(this.f1981b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    public static class d implements MessageQueue.IdleHandler {

        /* renamed from: a, reason: collision with root package name */
        private final Map<com.bumptech.glide.load.b, WeakReference<g<?>>> f1982a;

        /* renamed from: b, reason: collision with root package name */
        private final ReferenceQueue<g<?>> f1983b;

        public d(Map<com.bumptech.glide.load.b, WeakReference<g<?>>> map, ReferenceQueue<g<?>> referenceQueue) {
            this.f1982a = map;
            this.f1983b = referenceQueue;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            e eVar = (e) this.f1983b.poll();
            if (eVar == null) {
                return true;
            }
            this.f1982a.remove(eVar.f1984a);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    public static class e extends WeakReference<g<?>> {

        /* renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.b f1984a;

        public e(com.bumptech.glide.load.b bVar, g<?> gVar, ReferenceQueue<? super g<?>> referenceQueue) {
            super(gVar, referenceQueue);
            this.f1984a = bVar;
        }
    }

    public b(com.bumptech.glide.load.engine.m.h hVar, a.InterfaceC0065a interfaceC0065a, ExecutorService executorService, ExecutorService executorService2) {
        this(hVar, interfaceC0065a, executorService, executorService2, null, null, null, null, null);
    }

    private g<?> b(com.bumptech.glide.load.b bVar, boolean z) {
        if (!z) {
            return null;
        }
        g<?> a2 = a(bVar);
        if (a2 != null) {
            a2.b();
            this.e.put(bVar, new e(bVar, a2, a()));
        }
        return a2;
    }

    public <T, Z, R> c a(com.bumptech.glide.load.b bVar, int i, int i2, com.bumptech.glide.load.g.c<T> cVar, com.bumptech.glide.p.b<T, Z> bVar2, com.bumptech.glide.load.f<Z> fVar, com.bumptech.glide.load.i.i.c<Z, R> cVar2, Priority priority, boolean z, DiskCacheStrategy diskCacheStrategy, com.bumptech.glide.q.g gVar) {
        com.bumptech.glide.s.h.b();
        long a2 = com.bumptech.glide.s.d.a();
        com.bumptech.glide.load.engine.e a3 = this.f1972b.a(cVar.a(), bVar, i, i2, bVar2.e(), bVar2.d(), fVar, bVar2.c(), cVar2, bVar2.a());
        g<?> b2 = b(a3, z);
        if (b2 != null) {
            gVar.a(b2);
            if (Log.isLoggable("Engine", 2)) {
                a("Loaded resource from cache", a2, a3);
            }
            return null;
        }
        g<?> a4 = a(a3, z);
        if (a4 != null) {
            gVar.a(a4);
            if (Log.isLoggable("Engine", 2)) {
                a("Loaded resource from active resources", a2, a3);
            }
            return null;
        }
        com.bumptech.glide.load.engine.c cVar3 = this.f1971a.get(a3);
        if (cVar3 != null) {
            cVar3.a(gVar);
            if (Log.isLoggable("Engine", 2)) {
                a("Added to existing load", a2, a3);
            }
            return new c(gVar, cVar3);
        }
        com.bumptech.glide.load.engine.c a5 = this.f1974d.a(a3, z);
        h hVar = new h(a5, new com.bumptech.glide.load.engine.a(a3, i, i2, cVar, bVar2, fVar, cVar2, this.g, diskCacheStrategy, priority), priority);
        this.f1971a.put(a3, a5);
        a5.a(gVar);
        a5.b(hVar);
        if (Log.isLoggable("Engine", 2)) {
            a("Started new load", a2, a3);
        }
        return new c(gVar, a5);
    }

    b(com.bumptech.glide.load.engine.m.h hVar, a.InterfaceC0065a interfaceC0065a, ExecutorService executorService, ExecutorService executorService2, Map<com.bumptech.glide.load.b, com.bumptech.glide.load.engine.c> map, f fVar, Map<com.bumptech.glide.load.b, WeakReference<g<?>>> map2, a aVar, k kVar) {
        this.f1973c = hVar;
        this.g = new C0062b(interfaceC0065a);
        this.e = map2 == null ? new HashMap<>() : map2;
        this.f1972b = fVar == null ? new f() : fVar;
        this.f1971a = map == null ? new HashMap<>() : map;
        this.f1974d = aVar == null ? new a(executorService, executorService2, this) : aVar;
        this.f = kVar == null ? new k() : kVar;
        hVar.a(this);
    }

    public void b(j jVar) {
        com.bumptech.glide.s.h.b();
        if (jVar instanceof g) {
            ((g) jVar).d();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @Override // com.bumptech.glide.load.engine.g.a
    public void b(com.bumptech.glide.load.b bVar, g gVar) {
        com.bumptech.glide.s.h.b();
        this.e.remove(bVar);
        if (gVar.c()) {
            this.f1973c.a(bVar, gVar);
        } else {
            this.f.a(gVar);
        }
    }

    private static void a(String str, long j, com.bumptech.glide.load.b bVar) {
        Log.v("Engine", str + " in " + com.bumptech.glide.s.d.a(j) + "ms, key: " + bVar);
    }

    private g<?> a(com.bumptech.glide.load.b bVar, boolean z) {
        g<?> gVar = null;
        if (!z) {
            return null;
        }
        WeakReference<g<?>> weakReference = this.e.get(bVar);
        if (weakReference != null) {
            gVar = weakReference.get();
            if (gVar != null) {
                gVar.b();
            } else {
                this.e.remove(bVar);
            }
        }
        return gVar;
    }

    private g<?> a(com.bumptech.glide.load.b bVar) {
        j<?> a2 = this.f1973c.a(bVar);
        if (a2 == null) {
            return null;
        }
        if (a2 instanceof g) {
            return (g) a2;
        }
        return new g<>(a2, true);
    }

    @Override // com.bumptech.glide.load.engine.d
    public void a(com.bumptech.glide.load.b bVar, g<?> gVar) {
        com.bumptech.glide.s.h.b();
        if (gVar != null) {
            gVar.a(bVar, this);
            if (gVar.c()) {
                this.e.put(bVar, new e(bVar, gVar, a()));
            }
        }
        this.f1971a.remove(bVar);
    }

    @Override // com.bumptech.glide.load.engine.d
    public void a(com.bumptech.glide.load.engine.c cVar, com.bumptech.glide.load.b bVar) {
        com.bumptech.glide.s.h.b();
        if (cVar.equals(this.f1971a.get(bVar))) {
            this.f1971a.remove(bVar);
        }
    }

    @Override // com.bumptech.glide.load.engine.m.h.a
    public void a(j<?> jVar) {
        com.bumptech.glide.s.h.b();
        this.f.a(jVar);
    }

    private ReferenceQueue<g<?>> a() {
        if (this.h == null) {
            this.h = new ReferenceQueue<>();
            Looper.myQueue().addIdleHandler(new d(this.e, this.h));
        }
        return this.h;
    }
}
