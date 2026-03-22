package d.d.a.a.a.a.a;

/* compiled from: GyroscopeBiasEstimator.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private b f8002a;

    /* renamed from: b, reason: collision with root package name */
    private b f8003b;

    /* renamed from: c, reason: collision with root package name */
    private b f8004c;

    /* renamed from: d, reason: collision with root package name */
    private g f8005d;
    private g e;
    private C0410a f;
    private C0410a g;

    public a() {
        a();
    }

    private void c(g gVar, long j) {
        if (gVar.c() < 0.3499999940395355d) {
            double max = Math.max(0.0d, 1.0d - (gVar.c() / 0.3499999940395355d));
            this.f8004c.a(this.f8003b.b(), j, max * max);
        }
    }

    public void a() {
        this.f8005d = new g();
        this.e = new g();
        this.f8002a = new b(1.0d);
        this.f8003b = new b(10.0d);
        this.f8004c = new b(0.15000000596046448d);
        this.f = new C0410a(10);
        this.g = new C0410a(10);
    }

    public void b(g gVar, long j) {
        this.f8002a.a(gVar, j);
        g.b(gVar, this.f8002a.b(), this.e);
        this.f.a(this.e.c() < 0.5d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GyroscopeBiasEstimator.java */
    /* renamed from: d.d.a.a.a.a.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0410a {

        /* renamed from: a, reason: collision with root package name */
        private final int f8006a;

        /* renamed from: b, reason: collision with root package name */
        private int f8007b;

        C0410a(int i) {
            this.f8006a = i;
        }

        void a(boolean z) {
            if (!z) {
                this.f8007b = 0;
            } else {
                this.f8007b++;
            }
        }

        boolean a() {
            return this.f8007b >= this.f8006a;
        }
    }

    public void a(g gVar, long j) {
        this.f8003b.a(gVar, j);
        g.b(gVar, this.f8003b.b(), this.f8005d);
        this.g.a(this.f8005d.c() < 0.00800000037997961d);
        if (this.g.a() && this.f.a()) {
            c(gVar, j);
        }
    }

    public void a(g gVar) {
        if (this.f8004c.a() < 30) {
            gVar.a();
            return;
        }
        gVar.a(this.f8004c.b());
        double a2 = this.f8004c.a() - 30;
        Double.isNaN(a2);
        gVar.a(Math.min(1.0d, a2 / 100.0d));
    }
}
