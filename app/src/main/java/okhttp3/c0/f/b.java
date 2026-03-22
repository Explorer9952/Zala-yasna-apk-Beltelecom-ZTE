package okhttp3.c0.f;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.t;
import okhttp3.x;
import okhttp3.z;
import okio.q;

/* compiled from: CallServerInterceptor.java */
/* loaded from: classes2.dex */
public final class b implements t {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f8285a;

    /* compiled from: CallServerInterceptor.java */
    /* loaded from: classes2.dex */
    static final class a extends okio.f {

        /* renamed from: b, reason: collision with root package name */
        long f8286b;

        a(q qVar) {
            super(qVar);
        }

        @Override // okio.f, okio.q
        public void a(okio.c cVar, long j) throws IOException {
            super.a(cVar, j);
            this.f8286b += j;
        }
    }

    public b(boolean z) {
        this.f8285a = z;
    }

    @Override // okhttp3.t
    public z a(t.a aVar) throws IOException {
        z a2;
        g gVar = (g) aVar;
        c h = gVar.h();
        okhttp3.internal.connection.f i = gVar.i();
        okhttp3.internal.connection.c cVar = (okhttp3.internal.connection.c) gVar.c();
        x e = gVar.e();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.g().d(gVar.f());
        h.a(e);
        gVar.g().a(gVar.f(), e);
        z.a aVar2 = null;
        if (f.b(e.e()) && e.a() != null) {
            if ("100-continue".equalsIgnoreCase(e.a("Expect"))) {
                h.b();
                gVar.g().f(gVar.f());
                aVar2 = h.a(true);
            }
            if (aVar2 == null) {
                gVar.g().c(gVar.f());
                a aVar3 = new a(h.a(e, e.a().a()));
                okio.d a3 = okio.k.a(aVar3);
                e.a().a(a3);
                a3.close();
                gVar.g().a(gVar.f(), aVar3.f8286b);
            } else if (!cVar.d()) {
                i.e();
            }
        }
        h.a();
        if (aVar2 == null) {
            gVar.g().f(gVar.f());
            aVar2 = h.a(false);
        }
        aVar2.a(e);
        aVar2.a(i.c().c());
        aVar2.b(currentTimeMillis);
        aVar2.a(System.currentTimeMillis());
        z a4 = aVar2.a();
        int l = a4.l();
        if (l == 100) {
            z.a a5 = h.a(false);
            a5.a(e);
            a5.a(i.c().c());
            a5.b(currentTimeMillis);
            a5.a(System.currentTimeMillis());
            a4 = a5.a();
            l = a4.l();
        }
        gVar.g().a(gVar.f(), a4);
        if (this.f8285a && l == 101) {
            z.a p = a4.p();
            p.a(okhttp3.c0.c.f8269c);
            a2 = p.a();
        } else {
            z.a p2 = a4.p();
            p2.a(h.a(a4));
            a2 = p2.a();
        }
        if ("close".equalsIgnoreCase(a2.s().a("Connection")) || "close".equalsIgnoreCase(a2.b("Connection"))) {
            i.e();
        }
        if ((l != 204 && l != 205) || a2.g().k() <= 0) {
            return a2;
        }
        throw new ProtocolException("HTTP " + l + " had non-zero Content-Length: " + a2.g().k());
    }
}
