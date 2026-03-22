package d.d.a.a.a.a.a;

/* compiled from: So3Helper.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private g f8017a = new g();

    /* renamed from: b, reason: collision with root package name */
    private g f8018b = new g();

    /* renamed from: c, reason: collision with root package name */
    private g f8019c = new g();

    /* renamed from: d, reason: collision with root package name */
    private g f8020d = new g();
    private g e = new g();
    private c f = new c();
    private c g = new c();
    private g h = new g();
    private g i = new g();

    public void a(g gVar, g gVar2, c cVar) {
        g.c(gVar, gVar2, this.f8018b);
        if (this.f8018b.c() == 0.0d) {
            if (g.a(gVar, gVar2) >= 0.0d) {
                cVar.b();
                return;
            } else {
                g.b(gVar, this.e);
                a(this.e, cVar);
                return;
            }
        }
        this.f8019c.a(gVar);
        this.f8020d.a(gVar2);
        this.f8018b.b();
        this.f8019c.b();
        this.f8020d.b();
        c cVar2 = this.f;
        cVar2.a(0, this.f8019c);
        cVar2.a(1, this.f8018b);
        g.c(this.f8018b, this.f8019c, this.f8017a);
        cVar2.a(2, this.f8017a);
        c cVar3 = this.g;
        cVar3.a(0, this.f8020d);
        cVar3.a(1, this.f8018b);
        g.c(this.f8018b, this.f8020d, this.f8017a);
        cVar3.a(2, this.f8017a);
        cVar2.c();
        c.b(cVar3, cVar2, cVar);
    }

    private void a(g gVar, c cVar) {
        this.i.a(gVar);
        g gVar2 = this.i;
        gVar2.a(3.141592653589793d / gVar2.c());
        a(this.i, 0.0d, 0.20264236728467558d, cVar);
    }

    public void a(c cVar, g gVar) {
        double a2 = (((cVar.a(0, 0) + cVar.a(1, 1)) + cVar.a(2, 2)) - 1.0d) * 0.5d;
        gVar.a((cVar.a(2, 1) - cVar.a(1, 2)) / 2.0d, (cVar.a(0, 2) - cVar.a(2, 0)) / 2.0d, (cVar.a(1, 0) - cVar.a(0, 1)) / 2.0d);
        double c2 = gVar.c();
        if (a2 > 0.7071067811865476d) {
            if (c2 > 0.0d) {
                gVar.a(Math.asin(c2) / c2);
            }
        } else if (a2 > -0.7071067811865476d) {
            gVar.a(Math.acos(a2) / c2);
        } else {
            double asin = 3.141592653589793d - Math.asin(c2);
            double a3 = cVar.a(0, 0) - a2;
            double a4 = cVar.a(1, 1) - a2;
            double a5 = cVar.a(2, 2) - a2;
            g gVar2 = this.h;
            double d2 = a3 * a3;
            double d3 = a4 * a4;
            if (d2 > d3 && d2 > a5 * a5) {
                gVar2.a(a3, (cVar.a(1, 0) + cVar.a(0, 1)) / 2.0d, (cVar.a(0, 2) + cVar.a(2, 0)) / 2.0d);
            } else if (d3 > a5 * a5) {
                gVar2.a((cVar.a(1, 0) + cVar.a(0, 1)) / 2.0d, a4, (cVar.a(2, 1) + cVar.a(1, 2)) / 2.0d);
            } else {
                gVar2.a((cVar.a(0, 2) + cVar.a(2, 0)) / 2.0d, (cVar.a(2, 1) + cVar.a(1, 2)) / 2.0d, a5);
            }
            if (g.a(gVar2, gVar) < 0.0d) {
                gVar2.a(-1.0d);
            }
            gVar2.b();
            gVar2.a(asin);
            gVar.a(gVar2);
        }
    }

    private static void a(g gVar, double d2, double d3, c cVar) {
        double d4 = gVar.f8021a;
        double d5 = d4 * d4;
        double d6 = gVar.f8022b;
        double d7 = d6 * d6;
        double d8 = gVar.f8023c;
        double d9 = d8 * d8;
        cVar.a(0, 0, 1.0d - ((d7 + d9) * d3));
        cVar.a(1, 1, 1.0d - ((d9 + d5) * d3));
        cVar.a(2, 2, 1.0d - ((d5 + d7) * d3));
        double d10 = gVar.f8023c * d2;
        double d11 = gVar.f8021a * gVar.f8022b * d3;
        cVar.a(0, 1, d11 - d10);
        cVar.a(1, 0, d11 + d10);
        double d12 = gVar.f8022b * d2;
        double d13 = gVar.f8021a * gVar.f8023c * d3;
        cVar.a(0, 2, d13 + d12);
        cVar.a(2, 0, d13 - d12);
        double d14 = gVar.f8021a * d2;
        double d15 = gVar.f8022b * gVar.f8023c * d3;
        cVar.a(1, 2, d15 - d14);
        cVar.a(2, 1, d15 + d14);
    }
}
