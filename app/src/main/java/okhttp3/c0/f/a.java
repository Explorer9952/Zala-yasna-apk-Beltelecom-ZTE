package okhttp3.c0.f;

import java.io.IOException;
import java.util.List;
import okhttp3.l;
import okhttp3.m;
import okhttp3.r;
import okhttp3.t;
import okhttp3.u;
import okhttp3.x;
import okhttp3.y;
import okhttp3.z;

/* compiled from: BridgeInterceptor.java */
/* loaded from: classes2.dex */
public final class a implements t {

    /* renamed from: a, reason: collision with root package name */
    private final m f8284a;

    public a(m mVar) {
        this.f8284a = mVar;
    }

    @Override // okhttp3.t
    public z a(t.a aVar) throws IOException {
        x e = aVar.e();
        x.a f = e.f();
        y a2 = e.a();
        if (a2 != null) {
            u b2 = a2.b();
            if (b2 != null) {
                f.a("Content-Type", b2.toString());
            }
            long a3 = a2.a();
            if (a3 != -1) {
                f.a("Content-Length", Long.toString(a3));
                f.a("Transfer-Encoding");
            } else {
                f.a("Transfer-Encoding", "chunked");
                f.a("Content-Length");
            }
        }
        boolean z = false;
        if (e.a("Host") == null) {
            f.a("Host", okhttp3.c0.c.a(e.g(), false));
        }
        if (e.a("Connection") == null) {
            f.a("Connection", "Keep-Alive");
        }
        if (e.a("Accept-Encoding") == null && e.a("Range") == null) {
            z = true;
            f.a("Accept-Encoding", "gzip");
        }
        List<l> a4 = this.f8284a.a(e.g());
        if (!a4.isEmpty()) {
            f.a("Cookie", a(a4));
        }
        if (e.a("User-Agent") == null) {
            f.a("User-Agent", okhttp3.c0.d.a());
        }
        z a5 = aVar.a(f.a());
        e.a(this.f8284a, e.g(), a5.n());
        z.a p = a5.p();
        p.a(e);
        if (z && "gzip".equalsIgnoreCase(a5.b("Content-Encoding")) && e.b(a5)) {
            okio.i iVar = new okio.i(a5.g().m());
            r.a a6 = a5.n().a();
            a6.b("Content-Encoding");
            a6.b("Content-Length");
            p.a(a6.a());
            p.a(new h(a5.b("Content-Type"), -1L, okio.k.a(iVar)));
        }
        return p.a();
    }

    private String a(List<l> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            l lVar = list.get(i);
            sb.append(lVar.a());
            sb.append('=');
            sb.append(lVar.b());
        }
        return sb.toString();
    }
}
