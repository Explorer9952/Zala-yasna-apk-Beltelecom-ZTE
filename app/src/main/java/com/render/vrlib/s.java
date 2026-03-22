package com.render.vrlib;

import com.render.vrlib.MDVRLibrary;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: MDPickerManager.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2601a;

    /* renamed from: b, reason: collision with root package name */
    private com.render.vrlib.l.a.b f2602b;

    /* renamed from: c, reason: collision with root package name */
    private com.render.vrlib.l.e.o f2603c;

    /* renamed from: d, reason: collision with root package name */
    private com.render.vrlib.j.i f2604d;
    private MDVRLibrary.f e;
    private MDVRLibrary.l f;
    private c g;
    private f h;
    private e i;
    private d j;
    private b k;
    private final Object l;
    private MDVRLibrary.g m;

    /* compiled from: MDPickerManager.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private com.render.vrlib.l.a.b f2605a;

        /* renamed from: b, reason: collision with root package name */
        private com.render.vrlib.l.e.o f2606b;

        /* renamed from: c, reason: collision with root package name */
        private com.render.vrlib.j.i f2607c;

        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
        }

        public s a() {
            return new s(this, null);
        }

        public a a(com.render.vrlib.j.i iVar) {
            this.f2607c = iVar;
            return this;
        }

        public a a(com.render.vrlib.l.a.b bVar) {
            this.f2605a = bVar;
            return this;
        }

        public a a(com.render.vrlib.l.e.o oVar) {
            this.f2606b = oVar;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MDPickerManager.java */
    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        private com.render.vrlib.j.a.a f2610a;

        /* renamed from: b, reason: collision with root package name */
        private long f2611b;

        private c() {
        }

        void a(com.render.vrlib.j.a.a aVar, com.render.vrlib.w.o oVar, com.render.vrlib.w.i iVar) {
            a(aVar);
            com.render.vrlib.w.h c2 = com.render.vrlib.w.h.c();
            c2.a(aVar);
            c2.a(oVar);
            c2.a(this.f2611b);
            c2.a(iVar);
            com.render.vrlib.j.a.a aVar2 = this.f2610a;
            if (aVar2 != null) {
                aVar2.a(c2);
            }
            if (s.this.e != null) {
                s.this.e.a(c2);
            }
            com.render.vrlib.w.h.a(c2);
        }

        /* synthetic */ c(s sVar, t tVar) {
            this();
        }

        void a(com.render.vrlib.j.a.a aVar) {
            com.render.vrlib.j.a.a aVar2 = this.f2610a;
            if (aVar2 != aVar) {
                if (aVar2 != null) {
                    aVar2.a(this.f2611b);
                }
                this.f2611b = System.currentTimeMillis();
            }
            this.f2610a = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MDPickerManager.java */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (s.this.l) {
                s.this.a(s.this.k);
            }
        }

        /* synthetic */ d(s sVar, t tVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MDPickerManager.java */
    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        float f2614a;

        /* renamed from: b, reason: collision with root package name */
        float f2615b;

        private e() {
        }

        public void a(float f, float f2) {
            this.f2614a = f;
            this.f2615b = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (s.this.l) {
                s.this.a(this.f2614a, this.f2615b, s.this.k);
            }
        }

        /* synthetic */ e(s sVar, t tVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MDPickerManager.java */
    /* loaded from: classes.dex */
    public class f {
        private f() {
        }

        void a(com.render.vrlib.j.a.a aVar, com.render.vrlib.w.o oVar, com.render.vrlib.w.i iVar) {
            if (s.this.f != null) {
                com.render.vrlib.w.h c2 = com.render.vrlib.w.h.c();
                c2.a(aVar);
                c2.a(oVar);
                c2.a(System.currentTimeMillis());
                c2.a(iVar);
                s.this.f.a(c2);
                com.render.vrlib.w.h.a(c2);
            }
        }

        /* synthetic */ f(s sVar, t tVar) {
            this();
        }
    }

    /* synthetic */ s(a aVar, t tVar) {
        this(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MDPickerManager.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f2608a;

        /* renamed from: b, reason: collision with root package name */
        private ConcurrentLinkedQueue<com.render.vrlib.w.f> f2609b;

        private b() {
            this.f2609b = new ConcurrentLinkedQueue<>();
        }

        private void b(int i) {
            this.f2608a = i;
            while (this.f2609b.size() < i) {
                this.f2609b.add(new com.render.vrlib.w.f());
            }
        }

        public void a(ConcurrentLinkedQueue<com.render.vrlib.a> concurrentLinkedQueue) {
            com.render.vrlib.a.h.b("snapshot must in gl thread!");
            b(concurrentLinkedQueue.size());
            Iterator<com.render.vrlib.a> it2 = concurrentLinkedQueue.iterator();
            Iterator<com.render.vrlib.w.f> it3 = this.f2609b.iterator();
            while (it2.hasNext()) {
                it3.next().a(it2.next());
            }
        }

        /* synthetic */ b(t tVar) {
            this();
        }

        public com.render.vrlib.w.f a(int i) {
            if (i < this.f2608a) {
                return this.f2609b.peek();
            }
            return null;
        }
    }

    private s(a aVar) {
        t tVar = null;
        this.g = new c(this, tVar);
        this.h = new f(this, tVar);
        this.i = new e(this, tVar);
        this.j = new d(this, tVar);
        this.k = new b(tVar);
        this.l = new Object();
        this.m = new t(this);
        new u(this);
        this.f2602b = aVar.f2605a;
        this.f2603c = aVar.f2606b;
        this.f2604d = aVar.f2607c;
    }

    private com.render.vrlib.j.a.a b(com.render.vrlib.w.o oVar, int i) {
        com.render.vrlib.a.h.a("hitTest must in main thread");
        List<com.render.vrlib.j.c> a2 = this.f2604d.a();
        com.render.vrlib.w.i c2 = com.render.vrlib.w.i.c();
        com.render.vrlib.j.a.a aVar = null;
        for (Object obj : a2) {
            if (obj instanceof com.render.vrlib.j.a.a) {
                com.render.vrlib.j.a.a aVar2 = (com.render.vrlib.j.a.a) obj;
                com.render.vrlib.w.i a3 = aVar2.a(oVar);
                if (!a3.b() && a3.a(c2)) {
                    aVar = aVar2;
                    c2 = a3;
                }
            }
        }
        if (i != 1) {
            if (i == 2 && aVar != null && !c2.b()) {
                aVar.b(oVar);
                this.h.a(aVar, oVar, c2);
            }
        } else {
            this.g.a(aVar, oVar, c2);
        }
        return aVar;
    }

    public static a d() {
        return new a(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        c cVar = this.g;
        if (cVar != null) {
            cVar.a(null);
        }
    }

    public boolean a() {
        return this.f2601a;
    }

    public void a(boolean z) {
        this.f2601a = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2, float f3, b bVar) {
        com.render.vrlib.w.f a2;
        com.render.vrlib.w.f a3;
        int a4 = this.f2602b.a();
        if (a4 == 0 || (a2 = bVar.a(0)) == null) {
            return;
        }
        int c2 = (int) (f2 / ((int) a2.c()));
        if (c2 < a4 && (a3 = bVar.a(c2)) != null) {
            a(com.render.vrlib.a.h.a(f2 - (r1 * c2), f3, a3), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        com.render.vrlib.w.f a2 = bVar.a(0);
        if (a2 == null) {
            return;
        }
        a(com.render.vrlib.a.h.a(a2.c() / 2.0f, a2.d() / 2.0f, a2), 1);
    }

    public MDVRLibrary.g b() {
        return this.m;
    }

    private com.render.vrlib.j.a.a a(com.render.vrlib.w.o oVar, int i) {
        if (oVar == null) {
            return null;
        }
        return b(oVar, i);
    }

    public void a(MDVRLibrary.f fVar) {
        this.e = fVar;
    }

    public void a(MDVRLibrary.l lVar) {
        this.f = lVar;
    }
}
