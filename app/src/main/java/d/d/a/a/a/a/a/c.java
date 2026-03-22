package d.d.a.a.a.a.a;

/* compiled from: Matrix3x3d.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public double[] f8012a = new double[9];

    public void a(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        double[] dArr = this.f8012a;
        dArr[0] = d2;
        dArr[1] = d3;
        dArr[2] = d4;
        dArr[3] = d5;
        dArr[4] = d6;
        dArr[5] = d7;
        dArr[6] = d8;
        dArr[7] = d9;
        dArr[8] = d10;
    }

    public void b() {
        double[] dArr = this.f8012a;
        dArr[0] = 1.0d;
        dArr[1] = 0.0d;
        dArr[2] = 0.0d;
        dArr[3] = 0.0d;
        dArr[4] = 1.0d;
        dArr[5] = 0.0d;
        dArr[6] = 0.0d;
        dArr[7] = 0.0d;
        dArr[8] = 1.0d;
    }

    public void c(c cVar) {
        for (int i = 0; i < 9; i++) {
            double[] dArr = this.f8012a;
            dArr[i] = dArr[i] - cVar.f8012a[i];
        }
    }

    public void d(c cVar) {
        double[] dArr = this.f8012a;
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[5];
        double[] dArr2 = cVar.f8012a;
        dArr2[0] = dArr[0];
        dArr2[1] = dArr[3];
        dArr2[2] = dArr[6];
        dArr2[3] = d2;
        dArr2[4] = dArr[4];
        dArr2[5] = dArr[7];
        dArr2[6] = d3;
        dArr2[7] = d4;
        dArr2[8] = dArr[8];
    }

    public boolean e(c cVar) {
        double d2 = d();
        if (d2 == 0.0d) {
            return false;
        }
        double d3 = 1.0d / d2;
        double[] dArr = this.f8012a;
        cVar.a(((dArr[4] * dArr[8]) - (dArr[7] * dArr[5])) * d3, (-((dArr[1] * dArr[8]) - (dArr[2] * dArr[7]))) * d3, ((dArr[1] * dArr[5]) - (dArr[2] * dArr[4])) * d3, (-((dArr[3] * dArr[8]) - (dArr[5] * dArr[6]))) * d3, ((dArr[0] * dArr[8]) - (dArr[2] * dArr[6])) * d3, (-((dArr[0] * dArr[5]) - (dArr[3] * dArr[2]))) * d3, ((dArr[3] * dArr[7]) - (dArr[6] * dArr[4])) * d3, (-((dArr[0] * dArr[7]) - (dArr[6] * dArr[1]))) * d3, ((dArr[0] * dArr[4]) - (dArr[3] * dArr[1])) * d3);
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (int i = 0; i < 9; i++) {
            sb.append(Double.toString(this.f8012a[i]));
            if (i < 8) {
                sb.append(", ");
            }
        }
        sb.append(" }");
        return sb.toString();
    }

    public void c() {
        double[] dArr = this.f8012a;
        double d2 = dArr[1];
        dArr[1] = dArr[3];
        dArr[3] = d2;
        double d3 = dArr[2];
        dArr[2] = dArr[6];
        dArr[6] = d3;
        double d4 = dArr[5];
        dArr[5] = dArr[7];
        dArr[7] = d4;
    }

    public void a(c cVar) {
        double[] dArr = this.f8012a;
        double[] dArr2 = cVar.f8012a;
        dArr[0] = dArr2[0];
        dArr[1] = dArr2[1];
        dArr[2] = dArr2[2];
        dArr[3] = dArr2[3];
        dArr[4] = dArr2[4];
        dArr[5] = dArr2[5];
        dArr[6] = dArr2[6];
        dArr[7] = dArr2[7];
        dArr[8] = dArr2[8];
    }

    public void b(double d2) {
        for (int i = 0; i < 9; i++) {
            double[] dArr = this.f8012a;
            dArr[i] = dArr[i] * d2;
        }
    }

    public void b(c cVar) {
        for (int i = 0; i < 9; i++) {
            double[] dArr = this.f8012a;
            dArr[i] = dArr[i] + cVar.f8012a[i];
        }
    }

    public static void b(c cVar, c cVar2, c cVar3) {
        double[] dArr = cVar.f8012a;
        double d2 = dArr[0];
        double[] dArr2 = cVar2.f8012a;
        cVar3.a((d2 * dArr2[0]) + (dArr[1] * dArr2[3]) + (dArr[2] * dArr2[6]), (dArr[0] * dArr2[1]) + (dArr[1] * dArr2[4]) + (dArr[2] * dArr2[7]), (dArr[0] * dArr2[2]) + (dArr[1] * dArr2[5]) + (dArr[2] * dArr2[8]), (dArr[3] * dArr2[0]) + (dArr[4] * dArr2[3]) + (dArr[5] * dArr2[6]), (dArr[3] * dArr2[1]) + (dArr[4] * dArr2[4]) + (dArr[5] * dArr2[7]), (dArr[3] * dArr2[2]) + (dArr[4] * dArr2[5]) + (dArr[5] * dArr2[8]), (dArr[6] * dArr2[0]) + (dArr[7] * dArr2[3]) + (dArr[8] * dArr2[6]), (dArr[6] * dArr2[1]) + (dArr[7] * dArr2[4]) + (dArr[8] * dArr2[7]), (dArr[6] * dArr2[2]) + (dArr[7] * dArr2[5]) + (dArr[8] * dArr2[8]));
    }

    public double d() {
        return ((a(0, 0) * ((a(1, 1) * a(2, 2)) - (a(2, 1) * a(1, 2)))) - (a(0, 1) * ((a(1, 0) * a(2, 2)) - (a(1, 2) * a(2, 0))))) + (a(0, 2) * ((a(1, 0) * a(2, 1)) - (a(1, 1) * a(2, 0))));
    }

    public void a() {
        double[] dArr = this.f8012a;
        dArr[0] = 0.0d;
        dArr[1] = 0.0d;
        dArr[2] = 0.0d;
        dArr[3] = 0.0d;
        dArr[4] = 0.0d;
        dArr[5] = 0.0d;
        dArr[6] = 0.0d;
        dArr[7] = 0.0d;
        dArr[8] = 0.0d;
    }

    public void a(double d2) {
        double[] dArr = this.f8012a;
        dArr[0] = d2;
        dArr[4] = d2;
        dArr[8] = d2;
    }

    public double a(int i, int i2) {
        return this.f8012a[(i * 3) + i2];
    }

    public void a(int i, int i2, double d2) {
        this.f8012a[(i * 3) + i2] = d2;
    }

    public void a(int i, g gVar) {
        double[] dArr = this.f8012a;
        dArr[i] = gVar.f8021a;
        dArr[i + 3] = gVar.f8022b;
        dArr[i + 6] = gVar.f8023c;
    }

    public static void a(c cVar, c cVar2, c cVar3) {
        double[] dArr = cVar3.f8012a;
        double[] dArr2 = cVar.f8012a;
        double d2 = dArr2[0];
        double[] dArr3 = cVar2.f8012a;
        dArr[0] = d2 + dArr3[0];
        dArr[1] = dArr2[1] + dArr3[1];
        dArr[2] = dArr2[2] + dArr3[2];
        dArr[3] = dArr2[3] + dArr3[3];
        dArr[4] = dArr2[4] + dArr3[4];
        dArr[5] = dArr2[5] + dArr3[5];
        dArr[6] = dArr2[6] + dArr3[6];
        dArr[7] = dArr2[7] + dArr3[7];
        dArr[8] = dArr2[8] + dArr3[8];
    }

    public static void a(c cVar, g gVar, g gVar2) {
        double[] dArr = cVar.f8012a;
        double d2 = dArr[0];
        double d3 = gVar.f8021a;
        double d4 = dArr[1];
        double d5 = gVar.f8022b;
        double d6 = (d2 * d3) + (d4 * d5);
        double d7 = dArr[2];
        double d8 = gVar.f8023c;
        double d9 = d6 + (d7 * d8);
        double d10 = (dArr[3] * d3) + (dArr[4] * d5) + (dArr[5] * d8);
        double d11 = (dArr[6] * d3) + (dArr[7] * d5) + (dArr[8] * d8);
        gVar2.f8021a = d9;
        gVar2.f8022b = d10;
        gVar2.f8023c = d11;
    }
}
