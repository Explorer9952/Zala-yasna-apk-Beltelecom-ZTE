package com.render.vrlib.l.e;

import android.content.Context;
import android.graphics.RectF;
import android.opengl.Matrix;
import com.render.vrlib.a;
import com.render.vrlib.i;

/* compiled from: CylinderProjection.java */
/* loaded from: classes.dex */
public class f extends com.render.vrlib.l.e.a {

    /* renamed from: a, reason: collision with root package name */
    private i.f f2545a;

    /* renamed from: b, reason: collision with root package name */
    private c f2546b;

    /* compiled from: CylinderProjection.java */
    /* loaded from: classes.dex */
    private class a extends com.render.vrlib.a {
        private final float w;

        @Override // com.render.vrlib.a
        public void a(float f) {
            i.f unused = f.this.f2545a;
            float f2 = 15;
            if (f > f2) {
                i.f unused2 = f.this.f2545a;
            } else {
                i.f unused3 = f.this.f2545a;
                f2 = -15;
                if (f < f2) {
                    i.f unused4 = f.this.f2545a;
                }
                this.p = f;
                this.s = true;
            }
            f = f2;
            this.p = f;
            this.s = true;
        }

        @Override // com.render.vrlib.a
        public void b(float f) {
        }

        private a(a.C0077a c0077a) {
            super(c0077a);
            this.w = b();
        }

        @Override // com.render.vrlib.a
        protected void a() {
            f.this.f2546b.a(d());
            f.this.f2546b.a();
            float b2 = this.w / b();
            float f = -f.this.f2546b.b();
            i.f unused = f.this.f2545a;
            float f2 = f * 5.432489f * 0.8f * b2;
            float b3 = f.this.f2546b.b();
            i.f unused2 = f.this.f2545a;
            float f3 = b3 * 5.432489f * 0.8f * b2;
            float f4 = -f.this.f2546b.c();
            i.f unused3 = f.this.f2545a;
            float f5 = ((f4 * 8.0f) / 2.0f) * 0.8f * b2;
            float c2 = f.this.f2546b.c();
            i.f unused4 = f.this.f2545a;
            Matrix.orthoM(h(), 0, f2, f3, f5, ((c2 * 8.0f) / 2.0f) * 0.8f * b2, 1.0f, 500.0f);
        }
    }

    /* compiled from: CylinderProjection.java */
    /* loaded from: classes.dex */
    private class b extends com.render.vrlib.b {
        private b() {
        }

        @Override // com.render.vrlib.b
        public com.render.vrlib.a createDirector(int i) {
            return new a(new a.C0077a());
        }
    }

    /* compiled from: CylinderProjection.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private float f2548a = 1.0f;

        /* renamed from: b, reason: collision with root package name */
        private float f2549b = 1.0f;

        public c(int i, RectF rectF) {
        }

        public void a() {
            this.f2549b = 1.0f;
            this.f2548a = 1.0f;
        }

        public void a(float f) {
        }

        public float b() {
            return this.f2548a;
        }

        public float c() {
            return this.f2549b;
        }
    }

    private f(c cVar) {
        this.f2546b = cVar;
    }

    @Override // com.render.vrlib.l.e.k
    public com.render.vrlib.w.l c() {
        return com.render.vrlib.w.l.b();
    }

    @Override // com.render.vrlib.l.b
    public void e(Context context) {
    }

    @Override // com.render.vrlib.l.b
    public boolean f(Context context) {
        return true;
    }

    @Override // com.render.vrlib.l.b
    public void a(Context context) {
        i.f fVar = new i.f();
        this.f2545a = fVar;
        i.C0079i.a(context, fVar);
    }

    @Override // com.render.vrlib.l.e.k
    public i.b b() {
        return this.f2545a;
    }

    @Override // com.render.vrlib.l.e.a
    public com.render.vrlib.j.c a(com.render.vrlib.w.k kVar) {
        return new com.render.vrlib.j.g(kVar);
    }

    public static f a(int i, RectF rectF) {
        return new f(new c(i, rectF));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.render.vrlib.l.e.a
    public com.render.vrlib.b a() {
        return new b();
    }
}
