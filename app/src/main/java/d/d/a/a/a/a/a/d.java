package d.d.a.a.a.a.a;

/* compiled from: OrientationEKF.java */
/* loaded from: classes.dex */
public class d {
    private c C;
    private c D;
    private c E;
    private c F;
    private c G;
    private c H;
    private c I;
    private g J;
    private g K;
    private g L;
    private c M;
    private c N;
    private c O;
    private boolean P;
    private e Q;
    private long r;
    private float v;
    private int x;

    /* renamed from: a, reason: collision with root package name */
    private double[] f8013a = new double[16];

    /* renamed from: b, reason: collision with root package name */
    private c f8014b = new c();

    /* renamed from: c, reason: collision with root package name */
    private c f8015c = new c();

    /* renamed from: d, reason: collision with root package name */
    private c f8016d = new c();
    private c e = new c();
    private c f = new c();
    private c g = new c();
    private c h = new c();
    private c i = new c();
    private c j = new c();
    private g k = new g();
    private g l = new g();
    private g m = new g();
    private g n = new g();
    private g o = new g();
    private g p = new g();
    private g q = new g();
    private final g s = new g();
    private double t = 0.0d;
    private double u = 0.0d;
    private boolean w = false;
    private boolean y = true;
    private c z = new c();
    private c A = new c();
    private g B = new g();

    static {
        d.class.desiredAssertionStatus();
    }

    public d() {
        new c();
        this.C = new c();
        this.D = new c();
        this.E = new c();
        this.F = new c();
        this.G = new c();
        this.H = new c();
        this.I = new c();
        this.J = new g();
        this.K = new g();
        this.L = new g();
        new g();
        new g();
        new g();
        new g();
        new g();
        new c();
        new c();
        new c();
        new c();
        new c();
        this.M = new c();
        this.N = new c();
        this.O = new c();
        new c();
        this.Q = new e();
        a();
    }

    private void c() {
        this.f8015c.d(this.M);
        c.b(this.f8016d, this.M, this.N);
        c.b(this.f8015c, this.N, this.f8016d);
        this.f8015c.b();
    }

    public synchronized void a() {
        this.r = 0L;
        this.f8014b.b();
        this.f8015c.b();
        this.f8016d.a();
        this.f8016d.a(25.0d);
        this.e.a();
        this.e.a(1.0d);
        this.f.a();
        this.f.a(0.0625d);
        this.g.a();
        this.g.a(0.5625d);
        this.h.a();
        this.i.a();
        this.j.a();
        this.k.a();
        this.l.a();
        this.m.a();
        this.n.a();
        this.o.a();
        this.p.a(0.0d, 0.0d, 9.81d);
        this.q.a(0.0d, 1.0d, 0.0d);
        this.P = false;
    }

    public boolean b() {
        return this.P;
    }

    private void b(double d2) {
        double abs = Math.abs(d2 - this.t);
        this.t = d2;
        double d3 = (abs * 0.5d) + (this.u * 0.5d);
        this.u = d3;
        double min = Math.min(7.0d, ((d3 / 0.15d) * 6.25d) + 0.75d);
        this.g.a(min * min);
    }

    public synchronized void b(g gVar, long j) {
        this.l.a(gVar);
        b(this.l.c());
        if (this.P) {
            a(this.f8014b, this.k);
            for (int i = 0; i < 3; i++) {
                g gVar2 = this.L;
                gVar2.a();
                gVar2.a(i, 1.0E-7d);
                f.a(gVar2, this.E);
                c.b(this.E, this.f8014b, this.F);
                a(this.F, this.J);
                g.b(this.k, this.J, this.K);
                this.K.a(1.0E7d);
                this.i.a(i, this.K);
            }
            this.i.d(this.G);
            c.b(this.f8016d, this.G, this.H);
            c.b(this.i, this.H, this.I);
            c.a(this.I, this.g, this.h);
            this.h.e(this.G);
            this.i.d(this.H);
            c.b(this.H, this.G, this.I);
            c.b(this.f8016d, this.I, this.j);
            c.a(this.j, this.k, this.o);
            c.b(this.j, this.i, this.G);
            this.H.b();
            this.H.c(this.G);
            c.b(this.H, this.f8016d, this.G);
            this.f8016d.a(this.G);
            f.a(this.o, this.f8015c);
            c.b(this.f8015c, this.f8014b, this.f8014b);
            c();
        } else {
            this.Q.a(this.p, this.l, this.f8014b);
            this.P = true;
        }
    }

    public double[] a(double d2) {
        g gVar = this.B;
        gVar.a(this.s);
        gVar.a(-d2);
        c cVar = this.z;
        f.a(gVar, cVar);
        c cVar2 = this.A;
        c.b(cVar, this.f8014b, cVar2);
        return a(cVar2);
    }

    public synchronized void a(g gVar, long j) {
        if (this.r != 0) {
            float f = ((float) (j - this.r)) * 1.0E-9f;
            if (f > 0.04f) {
                f = this.y ? this.v : 0.01f;
            } else {
                a(f);
            }
            this.n.a(gVar);
            this.n.a(-f);
            f.a(this.n, this.f8015c);
            this.C.a(this.f8014b);
            c.b(this.f8015c, this.f8014b, this.C);
            this.f8014b.a(this.C);
            c();
            this.D.a(this.e);
            this.D.b(f * f);
            this.f8016d.b(this.D);
        }
        this.r = j;
        this.s.a(gVar);
    }

    private double[] a(c cVar) {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.f8013a[(i2 * 4) + i] = cVar.a(i, i2);
            }
        }
        double[] dArr = this.f8013a;
        dArr[11] = 0.0d;
        dArr[7] = 0.0d;
        dArr[3] = 0.0d;
        dArr[14] = 0.0d;
        dArr[13] = 0.0d;
        dArr[12] = 0.0d;
        dArr[15] = 1.0d;
        return dArr;
    }

    private void a(float f) {
        if (!this.w) {
            this.v = f;
            this.x = 1;
            this.w = true;
        } else {
            this.v = (this.v * 0.95f) + (f * 0.050000012f);
            int i = this.x + 1;
            this.x = i;
            if (i > 10.0f) {
                this.y = true;
            }
        }
    }

    private void a(c cVar, g gVar) {
        c.a(cVar, this.p, this.m);
        this.Q.a(this.m, this.l, this.O);
        this.Q.a(this.O, gVar);
    }
}
