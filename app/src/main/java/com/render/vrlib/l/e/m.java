package com.render.vrlib.l.e;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.Matrix;
import android.util.Log;
import com.render.vrlib.a;
import com.render.vrlib.i;

/* compiled from: PlaneProjection.java */
/* loaded from: classes.dex */
public class m extends com.render.vrlib.l.e.a {

    /* renamed from: c, reason: collision with root package name */
    private static final com.render.vrlib.w.l f2558c;

    /* renamed from: a, reason: collision with root package name */
    private i.k f2559a;

    /* renamed from: b, reason: collision with root package name */
    private c f2560b;

    /* compiled from: PlaneProjection.java */
    /* loaded from: classes.dex */
    private class a extends com.render.vrlib.a {
        private float A;
        private float B;
        private float C;
        private float D;
        private float E;
        private float F;
        private float G;
        private float H;
        private float I;
        private float J;
        private float K;
        private float L;
        private float M;
        private float N;
        private float O;
        private boolean P;
        private boolean Q;
        private float w;
        private float x;
        private float y;
        private float z;

        private int t() {
            if (this.P) {
                return 0;
            }
            this.Q = false;
            this.A = 0.0f;
            this.B = 0.0f;
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 0.0f;
            this.P = true;
            this.Q = true;
            this.I = this.w / b();
            Log.d("planeProjection", "initProjection");
            return 1;
        }

        @Override // com.render.vrlib.a
        public void a(int i) {
        }

        @Override // com.render.vrlib.a
        public void a(RectF rectF) {
            if (m.this.f2559a != null) {
                m mVar = m.this;
                mVar.f2560b = new c(mVar.f2560b.f2564c, rectF);
                m.this.f2559a.a(m.this.f2560b);
            }
        }

        @Override // com.render.vrlib.a
        public void a(float[] fArr) {
        }

        @Override // com.render.vrlib.a
        public void b(float f) {
            if (this.Q) {
                this.B = (this.y - f) * m.this.f2560b.a();
                this.y = f;
                this.t = true;
            }
        }

        @Override // com.render.vrlib.a
        public void c(float f) {
            this.z = f;
        }

        @Override // com.render.vrlib.a
        public float f() {
            return this.x;
        }

        @Override // com.render.vrlib.a
        public float g() {
            return this.y;
        }

        @Override // com.render.vrlib.a
        public Rect i() {
            Log.d("planeProjection", "getVideoWindow " + this.E + " " + this.F + " " + this.G + " " + this.H);
            return new Rect((int) (this.E * 1000.0f), (int) (this.G * 1000.0f), (int) (this.F * 1000.0f), (int) (this.H * 1000.0f));
        }

        @Override // com.render.vrlib.a
        public void o() {
            this.Q = true;
        }

        @Override // com.render.vrlib.a
        public void p() {
            this.x = 0.0f;
            this.y = 0.0f;
        }

        @Override // com.render.vrlib.a
        public void q() {
            this.x = 0.0f;
            this.y = 0.0f;
        }

        @Override // com.render.vrlib.a
        public void r() {
            this.Q = true;
        }

        private a(a.C0077a c0077a) {
            super(c0077a);
            this.w = 0.0f;
            this.C = 0.0f;
            this.D = 0.0f;
            this.E = -0.5f;
            this.F = 0.5f;
            this.G = 0.5f;
            this.H = -0.5f;
            this.I = 1.0f;
            this.J = -0.5f;
            this.K = 0.5f;
            this.L = 0.5f;
            this.M = -0.5f;
            this.N = 1.0f;
            this.O = 1.0f;
            this.P = false;
            this.Q = false;
            if (b() != 0.0f || this.w == 0.0f) {
                this.w = b();
            }
        }

        @Override // com.render.vrlib.a
        public void a(float f) {
            if (this.Q) {
                this.A = this.x - f;
                this.x = f;
                this.t = true;
            }
        }

        @Override // com.render.vrlib.a
        public void a(float f, float f2) {
            if (f == -1.0f || f2 == -1.0f) {
                return;
            }
            float f3 = this.E;
            this.C = f3 + ((this.F - f3) * f);
            float f4 = this.G;
            this.D = f4 - ((f4 - this.H) * f2);
        }

        @Override // com.render.vrlib.a
        public void a(Rect rect) {
            if (rect == null) {
                return;
            }
            int i = rect.right;
            int i2 = -rect.left;
            rect.right = i2;
            int i3 = -i;
            rect.left = i3;
            this.E = i3 / 1000.0f;
            this.F = i2 / 1000.0f;
            this.G = rect.top / 1000.0f;
            this.H = rect.bottom / 1000.0f;
            this.P = false;
            this.Q = false;
            this.t = true;
            Log.d("planeProjection", "setVideoWindow " + this.E + " " + this.F + " " + this.G + " " + this.H);
        }

        @Override // com.render.vrlib.a
        protected void a() {
            float f;
            float f2;
            int i;
            if (t() != 0 || this.Q) {
                m.this.f2560b.a(d());
                m.this.f2560b.b();
                float b2 = this.w / b();
                float f3 = b2 / this.I;
                this.I = b2;
                if (f3 != 1.0f) {
                    this.A = 0.0f;
                    this.B = 0.0f;
                }
                float f4 = this.E * f3;
                float f5 = this.C;
                float f6 = 1.0f - f3;
                float f7 = this.A;
                float f8 = f4 + (f5 * f6) + (f7 / 100.0f);
                float f9 = (this.F * f3) + (f5 * f6) + (f7 / 100.0f);
                float f10 = this.H * f3;
                float f11 = this.D;
                float f12 = this.B;
                float f13 = (f10 + (f11 * f6)) - (f12 / 100.0f);
                float f14 = ((this.G * f3) + (f11 * f6)) - (f12 / 100.0f);
                float f15 = this.J;
                if (f8 < f15) {
                    i = 1;
                    f = f15;
                    f2 = f15 + (this.N * b2 * this.O);
                } else {
                    float f16 = this.K;
                    if (f9 > f16) {
                        f = f16 - ((this.N * b2) * this.O);
                        f2 = f16;
                        i = 2;
                    } else {
                        f = f8;
                        f2 = f9;
                        i = -1;
                    }
                }
                float f17 = this.L;
                if (f14 > f17) {
                    f13 = f17 - (b2 * this.O);
                    i = 3;
                    f14 = f17;
                } else {
                    float f18 = this.M;
                    if (f13 < f18) {
                        f14 = f18 + (b2 * this.O);
                        i = 4;
                        f13 = f18;
                    }
                }
                this.E = f;
                this.F = f2;
                this.G = f14;
                this.H = f13;
                Matrix.orthoM(h(), 0, f, f2, f13, f14, 1.0f, 500.0f);
                if (com.render.vrlib.a.u == null || i == -1 || f3 != 1.0f || Math.abs(this.z) <= 30.0f) {
                    return;
                }
                com.render.vrlib.a.u.onStateChanged(i);
                this.Q = false;
            }
        }
    }

    /* compiled from: PlaneProjection.java */
    /* loaded from: classes.dex */
    private class b extends com.render.vrlib.b {
        private b() {
        }

        @Override // com.render.vrlib.b
        public com.render.vrlib.a createDirector(int i) {
            return new a(new a.C0077a());
        }
    }

    /* compiled from: PlaneProjection.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private RectF f2562a;

        /* renamed from: b, reason: collision with root package name */
        private float f2563b;

        /* renamed from: c, reason: collision with root package name */
        private int f2564c;

        /* renamed from: d, reason: collision with root package name */
        private float f2565d = 1.0f;
        private float e = 1.0f;

        public c(int i, RectF rectF) {
            this.f2564c = i;
            this.f2562a = rectF;
        }

        public void b() {
            float f = this.f2563b;
            float a2 = a();
            int i = this.f2564c;
            if (i == 207) {
                if (f > a2) {
                    this.f2565d = a2 * 1.0f;
                    this.e = 1.0f;
                    return;
                } else {
                    this.f2565d = 1.0f;
                    this.e = 1.0f / a2;
                    return;
                }
            }
            if (i != 208) {
                this.e = 1.0f;
                this.f2565d = 1.0f;
            } else if (a2 > f) {
                this.f2565d = a2 * 1.0f;
                this.e = 1.0f;
            } else {
                this.f2565d = 1.0f;
                this.e = 1.0f / a2;
            }
        }

        public float c() {
            return this.f2565d;
        }

        public float d() {
            return this.e;
        }

        public float a() {
            return this.f2562a.width() / this.f2562a.height();
        }

        public void a(float f) {
            this.f2563b = f;
        }
    }

    static {
        com.render.vrlib.w.e.a c2 = com.render.vrlib.w.l.c();
        c2.d(-2.0f);
        f2558c = c2;
    }

    private m(c cVar) {
        this.f2560b = cVar;
    }

    @Override // com.render.vrlib.l.e.k
    public com.render.vrlib.w.l c() {
        return f2558c;
    }

    @Override // com.render.vrlib.l.b
    public void e(Context context) {
    }

    @Override // com.render.vrlib.l.b
    public boolean f(Context context) {
        return true;
    }

    @Override // com.render.vrlib.l.e.k
    public i.b b() {
        return this.f2559a;
    }

    @Override // com.render.vrlib.l.b
    public void a(Context context) {
        i.k kVar = new i.k(this.f2560b);
        this.f2559a = kVar;
        i.C0079i.a(context, kVar);
    }

    @Override // com.render.vrlib.l.e.a
    public com.render.vrlib.j.c a(com.render.vrlib.w.k kVar) {
        return new com.render.vrlib.j.g(kVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.render.vrlib.l.e.a
    public com.render.vrlib.b a() {
        return new b();
    }

    public static m a(int i, RectF rectF) {
        return new m(new c(i, rectF));
    }
}
