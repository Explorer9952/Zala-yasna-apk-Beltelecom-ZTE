package okhttp3.c0.e;

import com.tencent.mm.sdk.platformtools.Util;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.c0.f.e;
import okhttp3.r;
import okhttp3.x;
import okhttp3.z;

/* compiled from: CacheStrategy.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final x f8278a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final z f8279b;

    c(x xVar, z zVar) {
        this.f8278a = xVar;
        this.f8279b = zVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.k().a() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(okhttp3.z r3, okhttp3.x r4) {
        /*
            int r0 = r3.l()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.b(r0)
            if (r0 != 0) goto L5a
            okhttp3.d r0 = r3.k()
            int r0 = r0.c()
            r1 = -1
            if (r0 != r1) goto L5a
            okhttp3.d r0 = r3.k()
            boolean r0 = r0.b()
            if (r0 != 0) goto L5a
            okhttp3.d r0 = r3.k()
            boolean r0 = r0.a()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            okhttp3.d r3 = r3.k()
            boolean r3 = r3.h()
            if (r3 != 0) goto L6f
            okhttp3.d r3 = r4.b()
            boolean r3 = r3.h()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.c0.e.c.a(okhttp3.z, okhttp3.x):boolean");
    }

    /* compiled from: CacheStrategy.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final long f8280a;

        /* renamed from: b, reason: collision with root package name */
        final x f8281b;

        /* renamed from: c, reason: collision with root package name */
        final z f8282c;

        /* renamed from: d, reason: collision with root package name */
        private Date f8283d;
        private String e;
        private Date f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l;

        public a(long j, x xVar, z zVar) {
            this.l = -1;
            this.f8280a = j;
            this.f8281b = xVar;
            this.f8282c = zVar;
            if (zVar != null) {
                this.i = zVar.t();
                this.j = zVar.r();
                r n = zVar.n();
                int b2 = n.b();
                for (int i = 0; i < b2; i++) {
                    String a2 = n.a(i);
                    String b3 = n.b(i);
                    if ("Date".equalsIgnoreCase(a2)) {
                        this.f8283d = okhttp3.c0.f.d.a(b3);
                        this.e = b3;
                    } else if ("Expires".equalsIgnoreCase(a2)) {
                        this.h = okhttp3.c0.f.d.a(b3);
                    } else if ("Last-Modified".equalsIgnoreCase(a2)) {
                        this.f = okhttp3.c0.f.d.a(b3);
                        this.g = b3;
                    } else if ("ETag".equalsIgnoreCase(a2)) {
                        this.k = b3;
                    } else if ("Age".equalsIgnoreCase(a2)) {
                        this.l = e.a(b3, -1);
                    }
                }
            }
        }

        private long b() {
            Date date = this.f8283d;
            long max = date != null ? Math.max(0L, this.j - date.getTime()) : 0L;
            int i = this.l;
            if (i != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.j;
            return max + (j - this.i) + (this.f8280a - j);
        }

        private long c() {
            long j;
            long j2;
            if (this.f8282c.k().c() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.c());
            }
            if (this.h != null) {
                Date date = this.f8283d;
                if (date != null) {
                    j2 = date.getTime();
                } else {
                    j2 = this.j;
                }
                long time = this.h.getTime() - j2;
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f == null || this.f8282c.s().g().k() != null) {
                return 0L;
            }
            Date date2 = this.f8283d;
            if (date2 != null) {
                j = date2.getTime();
            } else {
                j = this.i;
            }
            long time2 = j - this.f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        private c d() {
            if (this.f8282c == null) {
                return new c(this.f8281b, null);
            }
            if (this.f8281b.d() && this.f8282c.m() == null) {
                return new c(this.f8281b, null);
            }
            if (!c.a(this.f8282c, this.f8281b)) {
                return new c(this.f8281b, null);
            }
            okhttp3.d b2 = this.f8281b.b();
            if (!b2.g() && !a(this.f8281b)) {
                okhttp3.d k = this.f8282c.k();
                long b3 = b();
                long c2 = c();
                if (b2.c() != -1) {
                    c2 = Math.min(c2, TimeUnit.SECONDS.toMillis(b2.c()));
                }
                long j = 0;
                long millis = b2.e() != -1 ? TimeUnit.SECONDS.toMillis(b2.e()) : 0L;
                if (!k.f() && b2.d() != -1) {
                    j = TimeUnit.SECONDS.toMillis(b2.d());
                }
                if (!k.g()) {
                    long j2 = millis + b3;
                    if (j2 < j + c2) {
                        z.a p = this.f8282c.p();
                        if (j2 >= c2) {
                            p.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (b3 > Util.MILLSECONDS_OF_DAY && e()) {
                            p.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new c(null, p.a());
                    }
                }
                String str = this.k;
                String str2 = "If-Modified-Since";
                if (str != null) {
                    str2 = "If-None-Match";
                } else if (this.f != null) {
                    str = this.g;
                } else if (this.f8283d != null) {
                    str = this.e;
                } else {
                    return new c(this.f8281b, null);
                }
                r.a a2 = this.f8281b.c().a();
                okhttp3.c0.a.f8265a.a(a2, str2, str);
                x.a f = this.f8281b.f();
                f.a(a2.a());
                return new c(f.a(), this.f8282c);
            }
            return new c(this.f8281b, null);
        }

        private boolean e() {
            return this.f8282c.k().c() == -1 && this.h == null;
        }

        public c a() {
            c d2 = d();
            return (d2.f8278a == null || !this.f8281b.b().i()) ? d2 : new c(null, null);
        }

        private static boolean a(x xVar) {
            return (xVar.a("If-Modified-Since") == null && xVar.a("If-None-Match") == null) ? false : true;
        }
    }
}
