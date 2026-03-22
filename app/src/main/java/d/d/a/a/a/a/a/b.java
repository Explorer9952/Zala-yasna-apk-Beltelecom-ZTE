package d.d.a.a.a.a.a;

import java.util.concurrent.TimeUnit;

/* compiled from: LowPassFilter.java */
/* loaded from: classes.dex */
public class b {
    private static final double f;

    /* renamed from: a, reason: collision with root package name */
    private final double f8008a;

    /* renamed from: c, reason: collision with root package name */
    private long f8010c;

    /* renamed from: d, reason: collision with root package name */
    private int f8011d;

    /* renamed from: b, reason: collision with root package name */
    private final g f8009b = new g();
    private final g e = new g();

    static {
        double convert = TimeUnit.NANOSECONDS.convert(1L, TimeUnit.SECONDS);
        Double.isNaN(convert);
        f = 1.0d / convert;
    }

    public b(double d2) {
        this.f8008a = 1.0d / (d2 * 6.283185307179586d);
    }

    public int a() {
        return this.f8011d;
    }

    public g b() {
        return this.f8009b;
    }

    public void a(g gVar, long j) {
        a(gVar, j, 1.0d);
    }

    public void a(g gVar, long j, double d2) {
        int i = this.f8011d + 1;
        this.f8011d = i;
        if (i == 1) {
            this.f8009b.a(gVar);
            this.f8010c = j;
            return;
        }
        double d3 = j - this.f8010c;
        Double.isNaN(d3);
        double d4 = d2 * d3 * f;
        double d5 = d4 / (this.f8008a + d4);
        this.f8009b.a(1.0d - d5);
        this.e.a(gVar);
        this.e.a(d5);
        g gVar2 = this.e;
        g gVar3 = this.f8009b;
        g.a(gVar2, gVar3, gVar3);
        this.f8010c = j;
    }
}
