package okhttp3.c0.e;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.a0;
import okhttp3.c0.e.c;
import okhttp3.c0.f.e;
import okhttp3.c0.f.f;
import okhttp3.c0.f.h;
import okhttp3.r;
import okhttp3.t;
import okhttp3.x;
import okhttp3.z;
import okio.k;
import okio.q;
import okio.r;
import okio.s;

/* compiled from: CacheInterceptor.java */
/* loaded from: classes2.dex */
public final class a implements t {

    /* renamed from: a, reason: collision with root package name */
    final d f8273a;

    public a(d dVar) {
        this.f8273a = dVar;
    }

    static boolean b(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    @Override // okhttp3.t
    public z a(t.a aVar) throws IOException {
        d dVar = this.f8273a;
        z b2 = dVar != null ? dVar.b(aVar.e()) : null;
        c a2 = new c.a(System.currentTimeMillis(), aVar.e(), b2).a();
        x xVar = a2.f8278a;
        z zVar = a2.f8279b;
        d dVar2 = this.f8273a;
        if (dVar2 != null) {
            dVar2.a(a2);
        }
        if (b2 != null && zVar == null) {
            okhttp3.c0.c.a(b2.g());
        }
        if (xVar == null && zVar == null) {
            z.a aVar2 = new z.a();
            aVar2.a(aVar.e());
            aVar2.a(Protocol.HTTP_1_1);
            aVar2.a(504);
            aVar2.a("Unsatisfiable Request (only-if-cached)");
            aVar2.a(okhttp3.c0.c.f8269c);
            aVar2.b(-1L);
            aVar2.a(System.currentTimeMillis());
            return aVar2.a();
        }
        if (xVar == null) {
            z.a p = zVar.p();
            p.a(a(zVar));
            return p.a();
        }
        try {
            z a3 = aVar.a(xVar);
            if (a3 == null && b2 != null) {
            }
            if (zVar != null) {
                if (a3.l() == 304) {
                    z.a p2 = zVar.p();
                    p2.a(a(zVar.n(), a3.n()));
                    p2.b(a3.t());
                    p2.a(a3.r());
                    p2.a(a(zVar));
                    p2.b(a(a3));
                    z a4 = p2.a();
                    a3.g().close();
                    this.f8273a.a();
                    this.f8273a.a(zVar, a4);
                    return a4;
                }
                okhttp3.c0.c.a(zVar.g());
            }
            z.a p3 = a3.p();
            p3.a(a(zVar));
            p3.b(a(a3));
            z a5 = p3.a();
            if (this.f8273a != null) {
                if (e.b(a5) && c.a(a5, xVar)) {
                    return a(this.f8273a.a(a5), a5);
                }
                if (f.a(xVar.e())) {
                    try {
                        this.f8273a.a(xVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return a5;
        } finally {
            if (b2 != null) {
                okhttp3.c0.c.a(b2.g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CacheInterceptor.java */
    /* renamed from: okhttp3.c0.e.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0426a implements r {

        /* renamed from: a, reason: collision with root package name */
        boolean f8274a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ okio.e f8275b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f8276c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ okio.d f8277d;

        C0426a(a aVar, okio.e eVar, b bVar, okio.d dVar) {
            this.f8275b = eVar;
            this.f8276c = bVar;
            this.f8277d = dVar;
        }

        @Override // okio.r
        public long b(okio.c cVar, long j) throws IOException {
            try {
                long b2 = this.f8275b.b(cVar, j);
                if (b2 == -1) {
                    if (!this.f8274a) {
                        this.f8274a = true;
                        this.f8277d.close();
                    }
                    return -1L;
                }
                cVar.a(this.f8277d.a(), cVar.p() - b2, b2);
                this.f8277d.e();
                return b2;
            } catch (IOException e) {
                if (!this.f8274a) {
                    this.f8274a = true;
                    this.f8276c.a();
                }
                throw e;
            }
        }

        @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f8274a && !okhttp3.c0.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                this.f8274a = true;
                this.f8276c.a();
            }
            this.f8275b.close();
        }

        @Override // okio.r
        public s b() {
            return this.f8275b.b();
        }
    }

    private static z a(z zVar) {
        if (zVar == null || zVar.g() == null) {
            return zVar;
        }
        z.a p = zVar.p();
        p.a((a0) null);
        return p.a();
    }

    private z a(b bVar, z zVar) throws IOException {
        q b2;
        if (bVar == null || (b2 = bVar.b()) == null) {
            return zVar;
        }
        C0426a c0426a = new C0426a(this, zVar.g().m(), bVar, k.a(b2));
        String b3 = zVar.b("Content-Type");
        long k = zVar.g().k();
        z.a p = zVar.p();
        p.a(new h(b3, k, k.a(c0426a)));
        return p.a();
    }

    private static okhttp3.r a(okhttp3.r rVar, okhttp3.r rVar2) {
        r.a aVar = new r.a();
        int b2 = rVar.b();
        for (int i = 0; i < b2; i++) {
            String a2 = rVar.a(i);
            String b3 = rVar.b(i);
            if ((!"Warning".equalsIgnoreCase(a2) || !b3.startsWith("1")) && (a(a2) || !b(a2) || rVar2.a(a2) == null)) {
                okhttp3.c0.a.f8265a.a(aVar, a2, b3);
            }
        }
        int b4 = rVar2.b();
        for (int i2 = 0; i2 < b4; i2++) {
            String a3 = rVar2.a(i2);
            if (!a(a3) && b(a3)) {
                okhttp3.c0.a.f8265a.a(aVar, a3, rVar2.b(i2));
            }
        }
        return aVar.a();
    }

    static boolean a(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }
}
