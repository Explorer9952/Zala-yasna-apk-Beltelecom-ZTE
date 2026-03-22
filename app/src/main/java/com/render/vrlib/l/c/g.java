package com.render.vrlib.l.c;

import android.content.Context;
import android.hardware.SensorEventListener;
import com.render.vrlib.l.e.o;

/* compiled from: InteractiveModeManager.java */
/* loaded from: classes.dex */
public class g extends com.render.vrlib.l.d<com.render.vrlib.l.c.a> implements f {
    private boolean e;
    private a f;
    private b g;

    /* compiled from: InteractiveModeManager.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f2516a;

        /* renamed from: b, reason: collision with root package name */
        public SensorEventListener f2517b;

        /* renamed from: c, reason: collision with root package name */
        public o f2518c;

        /* renamed from: d, reason: collision with root package name */
        public com.render.vrlib.a.d f2519d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: InteractiveModeManager.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private float f2520a;

        /* renamed from: b, reason: collision with root package name */
        private float f2521b;

        /* renamed from: c, reason: collision with root package name */
        private float f2522c;

        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((com.render.vrlib.l.c.a) g.this.e()).a(this.f2520a, this.f2521b, this.f2522c);
            try {
                Thread.sleep(10L);
            } catch (InterruptedException unused) {
            }
        }

        /* synthetic */ b(g gVar, h hVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(float f, float f2, float f3) {
            this.f2520a = f;
            this.f2521b = f2;
            this.f2522c = f3;
        }
    }

    public g(int i, com.render.vrlib.a.d dVar, a aVar) {
        super(i, dVar);
        this.g = new b(this, null);
        this.f = aVar;
        aVar.f2519d = g();
    }

    public void d(Context context) {
        this.e = true;
        if (e().f(context)) {
            e().c(context);
        }
    }

    public void e(Context context) {
        this.e = false;
        if (e().f(context)) {
            e().d(context);
        }
    }

    @Override // com.render.vrlib.l.c.f
    public void f() {
        e().f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.render.vrlib.l.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.render.vrlib.l.c.a a(int i) {
        if (i == 1) {
            return new i(this.f);
        }
        if (i == 3) {
            return new l(this.f);
        }
        if (i == 4) {
            return new c(this.f);
        }
        if (i != 5) {
            return new m(this.f);
        }
        return new com.render.vrlib.l.c.b(this.f);
    }

    @Override // com.render.vrlib.l.c.f
    public boolean a(float f, float f2, float f3) {
        this.g.a(f, f2, f3);
        g().a(this.g);
        return false;
    }

    @Override // com.render.vrlib.l.c.f
    public void a() {
        e().a();
    }

    @Override // com.render.vrlib.l.d
    public void a(Context context) {
        super.a(context);
        if (this.e) {
            d(context);
        }
    }

    @Override // com.render.vrlib.l.c.f
    public void b(Context context) {
        g().a(new h(this, context));
    }
}
