package okhttp3;

import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: CacheControl.java */
/* loaded from: classes.dex */
public final class d {
    public static final d n;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f8343a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f8344b;

    /* renamed from: c, reason: collision with root package name */
    private final int f8345c;

    /* renamed from: d, reason: collision with root package name */
    private final int f8346d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final int h;
    private final int i;
    private final boolean j;
    private final boolean k;
    private final boolean l;

    @Nullable
    String m;

    static {
        a aVar = new a();
        aVar.b();
        n = aVar.a();
        a aVar2 = new a();
        aVar2.c();
        aVar2.a(Integer.MAX_VALUE, TimeUnit.SECONDS);
        aVar2.a();
    }

    private d(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        this.f8343a = z;
        this.f8344b = z2;
        this.f8345c = i;
        this.f8346d = i2;
        this.e = z3;
        this.f = z4;
        this.g = z5;
        this.h = i3;
        this.i = i4;
        this.j = z6;
        this.k = z7;
        this.l = z8;
        this.m = str;
    }

    private String j() {
        StringBuilder sb = new StringBuilder();
        if (this.f8343a) {
            sb.append("no-cache, ");
        }
        if (this.f8344b) {
            sb.append("no-store, ");
        }
        if (this.f8345c != -1) {
            sb.append("max-age=");
            sb.append(this.f8345c);
            sb.append(", ");
        }
        if (this.f8346d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f8346d);
            sb.append(", ");
        }
        if (this.e) {
            sb.append("private, ");
        }
        if (this.f) {
            sb.append("public, ");
        }
        if (this.g) {
            sb.append("must-revalidate, ");
        }
        if (this.h != -1) {
            sb.append("max-stale=");
            sb.append(this.h);
            sb.append(", ");
        }
        if (this.i != -1) {
            sb.append("min-fresh=");
            sb.append(this.i);
            sb.append(", ");
        }
        if (this.j) {
            sb.append("only-if-cached, ");
        }
        if (this.k) {
            sb.append("no-transform, ");
        }
        if (this.l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean a() {
        return this.e;
    }

    public boolean b() {
        return this.f;
    }

    public int c() {
        return this.f8345c;
    }

    public int d() {
        return this.h;
    }

    public int e() {
        return this.i;
    }

    public boolean f() {
        return this.g;
    }

    public boolean g() {
        return this.f8343a;
    }

    public boolean h() {
        return this.f8344b;
    }

    public boolean i() {
        return this.j;
    }

    public String toString() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        String j = j();
        this.m = j;
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static okhttp3.d a(okhttp3.r r22) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.d.a(okhttp3.r):okhttp3.d");
    }

    /* compiled from: CacheControl.java */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f8347a;

        /* renamed from: b, reason: collision with root package name */
        boolean f8348b;

        /* renamed from: c, reason: collision with root package name */
        int f8349c = -1;

        /* renamed from: d, reason: collision with root package name */
        int f8350d = -1;
        int e = -1;
        boolean f;
        boolean g;
        boolean h;

        public a a(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds(i);
                this.f8350d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }

        public a b() {
            this.f8347a = true;
            return this;
        }

        public a c() {
            this.f = true;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    d(a aVar) {
        this.f8343a = aVar.f8347a;
        this.f8344b = aVar.f8348b;
        this.f8345c = aVar.f8349c;
        this.f8346d = -1;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = aVar.f8350d;
        this.i = aVar.e;
        this.j = aVar.f;
        this.k = aVar.g;
        this.l = aVar.h;
    }
}
