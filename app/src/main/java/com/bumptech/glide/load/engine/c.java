package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.load.engine.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* compiled from: EngineJob.java */
/* loaded from: classes.dex */
class c implements h.a {
    private static final b q = new b();
    private static final Handler r = new Handler(Looper.getMainLooper(), new C0063c());

    /* renamed from: a, reason: collision with root package name */
    private final List<com.bumptech.glide.q.g> f1985a;

    /* renamed from: b, reason: collision with root package name */
    private final b f1986b;

    /* renamed from: c, reason: collision with root package name */
    private final d f1987c;

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.b f1988d;
    private final ExecutorService e;
    private final ExecutorService f;
    private final boolean g;
    private boolean h;
    private j<?> i;
    private boolean j;
    private Exception k;
    private boolean l;
    private Set<com.bumptech.glide.q.g> m;
    private h n;
    private g<?> o;
    private volatile Future<?> p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public static class b {
        b() {
        }

        public <R> g<R> a(j<R> jVar, boolean z) {
            return new g<>(jVar, z);
        }
    }

    /* compiled from: EngineJob.java */
    /* renamed from: com.bumptech.glide.load.engine.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0063c implements Handler.Callback {
        private C0063c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (1 != i && 2 != i) {
                return false;
            }
            c cVar = (c) message.obj;
            if (1 == message.what) {
                cVar.c();
            } else {
                cVar.b();
            }
            return true;
        }
    }

    public c(com.bumptech.glide.load.b bVar, ExecutorService executorService, ExecutorService executorService2, boolean z, d dVar) {
        this(bVar, executorService, executorService2, z, dVar, q);
    }

    private void c(com.bumptech.glide.q.g gVar) {
        if (this.m == null) {
            this.m = new HashSet();
        }
        this.m.add(gVar);
    }

    private boolean d(com.bumptech.glide.q.g gVar) {
        Set<com.bumptech.glide.q.g> set = this.m;
        return set != null && set.contains(gVar);
    }

    @Override // com.bumptech.glide.q.g
    public void onException(Exception exc) {
        this.k = exc;
        r.obtainMessage(2, this).sendToTarget();
    }

    public c(com.bumptech.glide.load.b bVar, ExecutorService executorService, ExecutorService executorService2, boolean z, d dVar, b bVar2) {
        this.f1985a = new ArrayList();
        this.f1988d = bVar;
        this.e = executorService;
        this.f = executorService2;
        this.g = z;
        this.f1987c = dVar;
        this.f1986b = bVar2;
    }

    @Override // com.bumptech.glide.load.engine.h.a
    public void a(h hVar) {
        this.p = this.f.submit(hVar);
    }

    public void b(h hVar) {
        this.n = hVar;
        this.p = this.e.submit(hVar);
    }

    public void a(com.bumptech.glide.q.g gVar) {
        com.bumptech.glide.s.h.b();
        if (this.j) {
            gVar.a(this.o);
        } else if (this.l) {
            gVar.onException(this.k);
        } else {
            this.f1985a.add(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.h) {
            this.i.a();
            return;
        }
        if (!this.f1985a.isEmpty()) {
            g<?> a2 = this.f1986b.a(this.i, this.g);
            this.o = a2;
            this.j = true;
            a2.b();
            this.f1987c.a(this.f1988d, this.o);
            for (com.bumptech.glide.q.g gVar : this.f1985a) {
                if (!d(gVar)) {
                    this.o.b();
                    gVar.a(this.o);
                }
            }
            this.o.d();
            return;
        }
        throw new IllegalStateException("Received a resource without any callbacks to notify");
    }

    public void b(com.bumptech.glide.q.g gVar) {
        com.bumptech.glide.s.h.b();
        if (!this.j && !this.l) {
            this.f1985a.remove(gVar);
            if (this.f1985a.isEmpty()) {
                a();
                return;
            }
            return;
        }
        c(gVar);
    }

    void a() {
        if (this.l || this.j || this.h) {
            return;
        }
        this.n.b();
        Future<?> future = this.p;
        if (future != null) {
            future.cancel(true);
        }
        this.h = true;
        this.f1987c.a(this, this.f1988d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.h) {
            return;
        }
        if (!this.f1985a.isEmpty()) {
            this.l = true;
            this.f1987c.a(this.f1988d, (g<?>) null);
            for (com.bumptech.glide.q.g gVar : this.f1985a) {
                if (!d(gVar)) {
                    gVar.onException(this.k);
                }
            }
            return;
        }
        throw new IllegalStateException("Received an exception without any callbacks to notify");
    }

    @Override // com.bumptech.glide.q.g
    public void a(j<?> jVar) {
        this.i = jVar;
        r.obtainMessage(1, this).sendToTarget();
    }
}
