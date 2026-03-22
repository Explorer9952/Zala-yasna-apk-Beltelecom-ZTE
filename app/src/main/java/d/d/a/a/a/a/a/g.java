package d.d.a.a.a.a.a;

/* compiled from: Vector3d.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public double f8021a;

    /* renamed from: b, reason: collision with root package name */
    public double f8022b;

    /* renamed from: c, reason: collision with root package name */
    public double f8023c;

    public void a(double d2, double d3, double d4) {
        this.f8021a = d2;
        this.f8022b = d3;
        this.f8023c = d4;
    }

    public void b() {
        double c2 = c();
        if (c2 != 0.0d) {
            a(1.0d / c2);
        }
    }

    public double c() {
        double d2 = this.f8021a;
        double d3 = this.f8022b;
        double d4 = (d2 * d2) + (d3 * d3);
        double d5 = this.f8023c;
        return Math.sqrt(d4 + (d5 * d5));
    }

    public String toString() {
        return "{ " + Double.toString(this.f8021a) + ", " + Double.toString(this.f8022b) + ", " + Double.toString(this.f8023c) + " }";
    }

    public static void c(g gVar, g gVar2, g gVar3) {
        double d2 = gVar.f8022b;
        double d3 = gVar2.f8023c;
        double d4 = gVar.f8023c;
        double d5 = gVar2.f8022b;
        double d6 = gVar2.f8021a;
        double d7 = gVar.f8021a;
        gVar3.a((d2 * d3) - (d4 * d5), (d4 * d6) - (d3 * d7), (d7 * d5) - (d2 * d6));
    }

    public static void b(g gVar, g gVar2, g gVar3) {
        gVar3.a(gVar.f8021a - gVar2.f8021a, gVar.f8022b - gVar2.f8022b, gVar.f8023c - gVar2.f8023c);
    }

    public static void b(g gVar, g gVar2) {
        int b2 = b(gVar) - 1;
        if (b2 < 0) {
            b2 = 2;
        }
        gVar2.a();
        gVar2.a(b2, 1.0d);
        c(gVar, gVar2, gVar2);
        gVar2.b();
    }

    public void a(int i, double d2) {
        if (i == 0) {
            this.f8021a = d2;
        } else if (i == 1) {
            this.f8022b = d2;
        } else {
            this.f8023c = d2;
        }
    }

    public void a() {
        this.f8023c = 0.0d;
        this.f8022b = 0.0d;
        this.f8021a = 0.0d;
    }

    public static int b(g gVar) {
        double abs = Math.abs(gVar.f8021a);
        double abs2 = Math.abs(gVar.f8022b);
        double abs3 = Math.abs(gVar.f8023c);
        return abs > abs2 ? abs > abs3 ? 0 : 2 : abs2 > abs3 ? 1 : 2;
    }

    public void a(g gVar) {
        this.f8021a = gVar.f8021a;
        this.f8022b = gVar.f8022b;
        this.f8023c = gVar.f8023c;
    }

    public void a(double d2) {
        this.f8021a *= d2;
        this.f8022b *= d2;
        this.f8023c *= d2;
    }

    public static double a(g gVar, g gVar2) {
        return (gVar.f8021a * gVar2.f8021a) + (gVar.f8022b * gVar2.f8022b) + (gVar.f8023c * gVar2.f8023c);
    }

    public static void a(g gVar, g gVar2, g gVar3) {
        gVar3.a(gVar.f8021a + gVar2.f8021a, gVar.f8022b + gVar2.f8022b, gVar.f8023c + gVar2.f8023c);
    }
}
