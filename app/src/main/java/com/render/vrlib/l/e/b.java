package com.render.vrlib.l.e;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.Matrix;
import android.util.Log;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.render.vrlib.MDVRLibrary;
import com.render.vrlib.a;
import com.render.vrlib.i;

/* compiled from: BulletTimeProjection.java */
/* loaded from: classes.dex */
public class b extends com.render.vrlib.l.e.a {
    private static final com.render.vrlib.w.l h;

    /* renamed from: a, reason: collision with root package name */
    private i.c f2535a;

    /* renamed from: b, reason: collision with root package name */
    private c f2536b;

    /* renamed from: c, reason: collision with root package name */
    private int f2537c;

    /* renamed from: d, reason: collision with root package name */
    private int f2538d;
    private int f;
    private int e = 18;
    private int g = 0;

    /* compiled from: BulletTimeProjection.java */
    /* loaded from: classes.dex */
    private class a extends com.render.vrlib.a {
        private int A;
        private float B;
        private float C;
        private float D;
        private float E;
        private float F;
        private float G;
        private float H;
        private float I;
        private float J;
        private int K;
        private boolean L;
        private boolean M;
        private boolean N;
        private boolean O;
        private int P;
        private int Q;
        private boolean R;
        private float w;
        private float x;
        private float y;
        private float z;

        private void t() {
            this.z = 0.0f;
            this.A = 0;
            this.Q = 0;
            this.P = 0;
            this.R = true;
            this.t = true;
        }

        private void u() {
            if (this.L) {
                return;
            }
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 0.0f;
            this.A = 0;
            this.J = 1.0f;
            int i = b.this.g;
            int unused = b.this.e;
            int unused2 = b.this.g;
            int unused3 = b.this.f;
            this.F = ((1.0f / b.this.f2538d) * ((b.this.f2538d - (i % b.this.f2538d)) - 1)) - 0.5f;
            this.G = ((1.0f / b.this.f2538d) * (b.this.f2538d - (i % b.this.f2538d))) - 0.5f;
            this.I = ((1.0f / b.this.f2537c) * (i / b.this.f2538d)) - 0.5f;
            this.H = ((1.0f / b.this.f2537c) * ((i / b.this.f2538d) + 1)) - 0.5f;
            this.K = i;
            this.L = true;
            this.M = true;
            Log.d("BulletTimeProjection", "initProjection            " + this);
        }

        @Override // com.render.vrlib.a
        public void a(RectF rectF) {
            if (b.this.f2535a != null) {
                b.this.f2536b = new c(rectF);
                b.this.f2535a.a(b.this.f2536b);
            }
        }

        @Override // com.render.vrlib.a
        public void a(float[] fArr) {
        }

        @Override // com.render.vrlib.a
        public void b(float f) {
            if (this.L) {
                this.C = (this.y - f) * b.this.f2536b.a();
                this.y = f;
                this.t = true;
            }
        }

        @Override // com.render.vrlib.a
        public void c(float f) {
        }

        @Override // com.render.vrlib.a
        public int e() {
            return ((b.this.f2537c * b.this.f2538d) - 1) - this.K;
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
            Log.d("BulletTimeProjection", "getVideoWindow " + this.F + " " + this.G + " " + this.H + " " + this.I + "            " + this);
            return new Rect((int) (this.F * 1000.0f), (int) (this.H * 1000.0f), (int) (this.G * 1000.0f), (int) (this.I * 1000.0f));
        }

        @Override // com.render.vrlib.a
        public void o() {
            this.L = false;
            this.M = true;
            this.x = 0.0f;
            this.B = 0.0f;
            this.C = 0.0f;
            int unused = b.this.e;
            int unused2 = b.this.f2537c;
            int unused3 = b.this.f2538d;
            int unused4 = b.this.f;
            this.z = 0.0f;
            this.A = 0;
            this.K = (b.this.f2537c * b.this.f2538d) - 1;
            this.F = ((1.0f / b.this.f2538d) * ((b.this.f2538d - (this.K % b.this.f2538d)) - 1)) - 0.5f;
            this.G = ((1.0f / b.this.f2538d) * (b.this.f2538d - (this.K % b.this.f2538d))) - 0.5f;
            this.I = ((1.0f / b.this.f2537c) * (this.K / b.this.f2538d)) - 0.5f;
            this.H = ((1.0f / b.this.f2537c) * ((this.K / b.this.f2538d) + 1)) - 0.5f;
            this.J = 1.0f;
            this.t = true;
            this.O = false;
            Log.d("BulletTimeProjection", "reset BulletTimeProjection            " + this);
        }

        @Override // com.render.vrlib.a
        public void p() {
            this.K = 0;
            t();
        }

        @Override // com.render.vrlib.a
        public void q() {
            this.K = (b.this.f2537c * b.this.f2538d) - 1;
            t();
        }

        @Override // com.render.vrlib.a
        public void r() {
            this.M = true;
            this.z = 0.0f;
            this.A = 0;
        }

        private a(a.C0077a c0077a) {
            super(c0077a);
            this.w = 0.0f;
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 0.0f;
            this.A = 0;
            this.D = 0.5f;
            this.E = 0.5f;
            this.F = -0.5f;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = -0.5f;
            this.J = 1.0f;
            this.K = (b.this.f2537c * b.this.f2538d) - 1;
            this.L = false;
            this.M = false;
            this.N = false;
            this.O = false;
            this.P = 1;
            this.Q = 0;
            this.R = false;
            if (b() != 0.0f || this.w == 0.0f) {
                this.w = b();
            }
            b.this.g = (b.this.f2537c * b.this.f2538d) - this.r;
            if (this.r > 1) {
                this.P = 0;
            }
            if (b.this.g == 0) {
                this.Q = 1;
            }
        }

        private int e(float f) {
            int i;
            if (f != 1.0f || this.J != f) {
                return -1;
            }
            if (!this.M) {
                return 0;
            }
            int i2 = this.K;
            if (this.R) {
                this.R = false;
            } else {
                float abs = Math.abs(this.z);
                int i3 = this.A;
                if (abs - i3 > 100.0f) {
                    this.A = i3 + DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS;
                    float f2 = this.z;
                    if (f2 > 0.0f) {
                        i2--;
                    } else if (f2 < 0.0f) {
                        i2++;
                    }
                }
                return 0;
            }
            if (i2 < b.this.f2537c * b.this.f2538d && (this.K >= i2 || i2 != (b.this.f2537c * b.this.f2538d) - 1)) {
                if (i2 >= 0 && (this.K <= i2 || i2 != 0)) {
                    int i4 = this.K;
                    if (i4 < i2) {
                        this.Q = 0;
                    } else if (i4 > i2) {
                        this.P = 0;
                    }
                    i = 0;
                } else {
                    this.Q++;
                    Log.d("BulletTimeProjection", "Normal: right ---> reach_bound_times " + this.Q);
                    i = 2;
                }
            } else {
                this.P++;
                Log.d("BulletTimeProjection", "Normal: left <--- reach_bound_times " + this.P);
                i = 1;
            }
            int max = Math.max(Math.min(i2, (b.this.f2537c * b.this.f2538d) - 1), 0);
            int unused = b.this.e;
            int unused2 = b.this.f;
            int i5 = b.this.e / 2;
            this.K = max;
            this.F = ((1.0f / b.this.f2538d) * ((b.this.f2538d - (max % b.this.f2538d)) - 1)) - 0.5f;
            this.G = ((1.0f / b.this.f2538d) * (b.this.f2538d - (max % b.this.f2538d))) - 0.5f;
            this.I = ((1.0f / b.this.f2537c) * (max / b.this.f2538d)) - 0.5f;
            this.H = ((1.0f / b.this.f2537c) * ((max / b.this.f2538d) + 1)) - 0.5f;
            return i;
        }

        private int f(float f) {
            float f2;
            int i;
            int i2 = 0;
            if (!this.N) {
                if (!this.M) {
                    return -1;
                }
            } else {
                this.N = false;
            }
            float f3 = this.B;
            float f4 = this.C;
            float f5 = f / this.J;
            if (f5 != 1.0f) {
                f3 = 0.0f;
                f4 = 0.0f;
            }
            int i3 = this.K;
            float f6 = ((1.0f / b.this.f2538d) * ((b.this.f2538d - (i3 % b.this.f2538d)) - 1)) - 0.5f;
            float f7 = ((1.0f / b.this.f2538d) * (b.this.f2538d - (i3 % b.this.f2538d))) - 0.5f;
            float f8 = ((1.0f / b.this.f2537c) * (i3 / b.this.f2538d)) - 0.5f;
            float f9 = ((1.0f / b.this.f2537c) * ((i3 / b.this.f2538d) + 1)) - 0.5f;
            float f10 = this.F * f5;
            float f11 = this.D;
            float f12 = 1.0f - f5;
            float f13 = f3 / 1000.0f;
            float f14 = (f10 + (f11 * f12)) - f13;
            float f15 = ((this.G * f5) + (f11 * f12)) - f13;
            float f16 = this.I * f5;
            float f17 = this.E;
            float f18 = f4 / 1000.0f;
            float f19 = f16 + (f17 * f12) + f18;
            float f20 = (this.H * f5) + (f17 * f12) + f18;
            if (f14 < f6) {
                if (this.O && i3 != (b.this.f2537c * b.this.f2538d) - 1) {
                    this.O = false;
                } else {
                    i3++;
                    this.O = true;
                }
            } else if (f15 > f7) {
                if (this.O && i3 != 0) {
                    this.O = false;
                } else {
                    i3--;
                    this.O = true;
                }
            }
            if (this.K < i3 && i3 % b.this.f2538d == 0) {
                if (i3 != b.this.f2538d * b.this.f2537c) {
                    f19 += 1.0f / b.this.f2537c;
                    f6 = 0.5f - (f15 - f14);
                    f9 = f20 + (1.0f / b.this.f2537c);
                    i = 0;
                    f2 = 0.5f;
                } else {
                    this.P++;
                    this.Q = 0;
                    this.M = false;
                    Log.d("BulletTimeProjection", "Zoom: left <--- reach_bound_times" + this.P);
                    f9 = f20;
                    f2 = ((f * 1.0f) / b.this.f2538d) + f6;
                    i = 1;
                }
            } else {
                int i4 = this.K;
                if (i4 <= i3 || i4 % b.this.f2537c != 0) {
                    if (f20 > f9) {
                        f8 = f9 - ((f * 1.0f) / b.this.f2537c);
                    } else if (f19 < f8) {
                        f9 = f8 + ((f * 1.0f) / b.this.f2537c);
                    } else {
                        f8 = f19;
                        f9 = f20;
                    }
                    if (f14 < f6) {
                        f2 = f6 + ((f * 1.0f) / b.this.f2538d);
                        this.Q = 0;
                    } else if (f15 > f7) {
                        f6 = f7 - ((f * 1.0f) / b.this.f2538d);
                        this.P = 0;
                        f2 = f7;
                    } else {
                        f2 = f15;
                        f19 = f8;
                        f6 = f14;
                    }
                    f19 = f8;
                } else if (i3 != -1) {
                    f19 -= 1.0f / b.this.f2537c;
                    f6 = -0.5f;
                    f9 = f20 - (1.0f / b.this.f2537c);
                    f2 = (f15 - f14) - 0.5f;
                } else {
                    i = 2;
                    this.Q++;
                    f6 = f7 - ((f * 1.0f) / b.this.f2538d);
                    this.P = 0;
                    this.M = false;
                    Log.d("BulletTimeProjection", "Zoom: right ---> reach_bound_times " + this.Q);
                    f9 = f20;
                    f2 = f7;
                }
                i = 0;
            }
            this.F = f6;
            this.G = f2;
            this.H = f9;
            this.I = f19;
            if (i3 >= b.this.f2537c * b.this.f2538d) {
                i2 = (b.this.f2537c * b.this.f2538d) - 1;
            } else if (i3 >= 0) {
                i2 = i3;
            }
            this.K = i2;
            return i;
        }

        @Override // com.render.vrlib.a
        public void a(int i) {
            int i2 = (b.this.f2537c * b.this.f2538d) - i;
            this.K = i2;
            if (i2 >= b.this.f2537c * b.this.f2538d) {
                this.K = (b.this.f2537c * b.this.f2538d) - 1;
            } else if (this.K < 0) {
                this.K = 0;
            }
            t();
            Log.d("BulletTimeProjection", "setBulletIndex :" + i);
        }

        @Override // com.render.vrlib.a
        public void a(float f) {
            if (this.L && this.M) {
                if (this.B * (this.x - f) < 0.0f) {
                    this.z = 0.0f;
                    this.A = 0;
                }
                float f2 = this.x - f;
                this.B = f2;
                this.x = f;
                this.t = true;
                this.z += f2;
            }
        }

        @Override // com.render.vrlib.a
        public void a(float f, float f2) {
            if (f == -1.0f || f2 == -1.0f) {
                return;
            }
            float f3 = this.F;
            this.D = f3 + ((this.G - f3) * f);
            float f4 = this.H;
            this.E = f4 - ((f4 - this.I) * f2);
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
            float f = i3 / 1000.0f;
            this.F = f;
            float f2 = i2 / 1000.0f;
            this.G = f2;
            this.H = rect.top / 1000.0f;
            this.I = rect.bottom / 1000.0f;
            if (f2 > 0.0f) {
                this.P = 0;
                this.Q = 1;
            } else if (f < 0.0f) {
                this.P = 1;
                this.Q = 0;
            }
            float f3 = this.H;
            float f4 = this.I;
            float f5 = f3 - f4;
            if (f4 < 0.0f) {
                float f6 = ((f4 + 0.5f) + 0.5f) - (1.0f / b.this.f2537c);
                this.I = f6;
                this.H = f6 + f5;
                int unused = b.this.e;
                int unused2 = b.this.f2537c;
                int unused3 = b.this.f2538d;
                int unused4 = b.this.f;
                this.K = (b.this.f2537c * b.this.f2538d) - 1;
            } else {
                float f7 = (-(0.5f - f3)) + ((1.0f / b.this.f2537c) - 0.5f);
                this.H = f7;
                this.I = f7 - f5;
                int unused5 = b.this.f;
                this.K = 0;
            }
            this.t = true;
            this.N = true;
            this.M = false;
            this.L = true;
            this.J = this.w / b();
            MDVRLibrary.n nVar = com.render.vrlib.a.v;
            if (nVar != null) {
                nVar.OnBulletIndexChanged(((b.this.f2537c * b.this.f2538d) - 1) - this.K);
            }
            Log.d("BulletTimeProjection", "setVideoWindow " + this.F + " " + this.G + " " + this.H + " " + this.I + "            " + this);
        }

        @Override // com.render.vrlib.a
        protected void a() {
            u();
            int i = this.K;
            b.this.f2536b.b();
            float b2 = this.w / b();
            float f = this.J;
            float f2 = b2 / f;
            if (b2 != f) {
                this.P = 0;
                this.Q = 0;
                this.B = 0.0f;
                this.C = 0.0f;
            }
            int e = e(b2);
            if (e != -1 || (e = f(b2)) >= 0) {
                this.J = b2;
                MDVRLibrary.n nVar = com.render.vrlib.a.v;
                if (nVar != null && i != this.K) {
                    nVar.OnBulletIndexChanged(((b.this.f2537c * b.this.f2538d) - 1) - this.K);
                }
                Matrix.orthoM(h(), 0, this.F, this.G, this.I, this.H, 1.0f, 500.0f);
                if (com.render.vrlib.a.u == null || e <= 0) {
                    return;
                }
                if ((this.P > 1 || this.Q > 1) && f2 == 1.0f) {
                    com.render.vrlib.a.u.onStateChanged(e);
                }
            }
        }
    }

    /* compiled from: BulletTimeProjection.java */
    /* renamed from: com.render.vrlib.l.e.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0080b extends com.render.vrlib.b {
        private C0080b() {
        }

        @Override // com.render.vrlib.b
        public com.render.vrlib.a createDirector(int i) {
            return new a(new a.C0077a());
        }
    }

    /* compiled from: BulletTimeProjection.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private RectF f2540a;

        /* renamed from: b, reason: collision with root package name */
        private float f2541b = 1.0f;

        /* renamed from: c, reason: collision with root package name */
        private float f2542c = 1.0f;

        public c(RectF rectF) {
            this.f2540a = rectF;
        }

        public float a() {
            return this.f2540a.width() / this.f2540a.height();
        }

        public void b() {
            this.f2542c = 1.0f;
            this.f2541b = 1.0f;
        }

        public float c() {
            return this.f2541b;
        }

        public float d() {
            return this.f2542c;
        }
    }

    static {
        com.render.vrlib.w.e.a c2 = com.render.vrlib.w.l.c();
        c2.d(-2.0f);
        h = c2;
    }

    private b(c cVar, int i, int i2) {
        this.f2537c = 1;
        this.f2538d = 1;
        this.f = 18 / 2;
        this.f2536b = cVar;
        this.f2537c = i;
        this.f2538d = i2;
        this.f = ((i * i2) * 18) / 2;
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
        return this.f2535a;
    }

    @Override // com.render.vrlib.l.e.k
    public com.render.vrlib.w.l c() {
        return h;
    }

    @Override // com.render.vrlib.l.b
    public void a(Context context) {
        i.c cVar = new i.c(this.f2536b);
        this.f2535a = cVar;
        i.C0079i.a(context, cVar);
    }

    @Override // com.render.vrlib.l.e.a
    public com.render.vrlib.j.c a(com.render.vrlib.w.k kVar) {
        return new com.render.vrlib.j.g(kVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.render.vrlib.l.e.a
    public com.render.vrlib.b a() {
        return new C0080b();
    }

    public static b a(RectF rectF, int i, int i2) {
        return new b(new c(rectF), i, i2);
    }
}
