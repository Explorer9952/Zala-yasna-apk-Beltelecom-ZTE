package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.a0;
import okhttp3.r;
import okhttp3.t;
import okhttp3.v;
import okhttp3.x;
import okhttp3.z;
import okio.ByteString;
import okio.q;
import okio.r;

/* compiled from: Http2Codec.java */
/* loaded from: classes2.dex */
public final class d implements okhttp3.c0.f.c {
    private static final List<String> f = okhttp3.c0.c.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");
    private static final List<String> g = okhttp3.c0.c.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a, reason: collision with root package name */
    private final t.a f8401a;

    /* renamed from: b, reason: collision with root package name */
    final okhttp3.internal.connection.f f8402b;

    /* renamed from: c, reason: collision with root package name */
    private final e f8403c;

    /* renamed from: d, reason: collision with root package name */
    private g f8404d;
    private final Protocol e;

    /* compiled from: Http2Codec.java */
    /* loaded from: classes2.dex */
    class a extends okio.g {

        /* renamed from: b, reason: collision with root package name */
        boolean f8405b;

        /* renamed from: c, reason: collision with root package name */
        long f8406c;

        a(r rVar) {
            super(rVar);
            this.f8405b = false;
            this.f8406c = 0L;
        }

        private void a(IOException iOException) {
            if (this.f8405b) {
                return;
            }
            this.f8405b = true;
            d dVar = d.this;
            dVar.f8402b.a(false, dVar, this.f8406c, iOException);
        }

        @Override // okio.r
        public long b(okio.c cVar, long j) throws IOException {
            try {
                long b2 = g().b(cVar, j);
                if (b2 > 0) {
                    this.f8406c += b2;
                }
                return b2;
            } catch (IOException e) {
                a(e);
                throw e;
            }
        }

        @Override // okio.g, okio.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            a(null);
        }
    }

    public d(v vVar, t.a aVar, okhttp3.internal.connection.f fVar, e eVar) {
        Protocol protocol;
        this.f8401a = aVar;
        this.f8402b = fVar;
        this.f8403c = eVar;
        if (vVar.u().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        } else {
            protocol = Protocol.HTTP_2;
        }
        this.e = protocol;
    }

    @Override // okhttp3.c0.f.c
    public q a(x xVar, long j) {
        return this.f8404d.d();
    }

    @Override // okhttp3.c0.f.c
    public void b() throws IOException {
        this.f8403c.flush();
    }

    @Override // okhttp3.c0.f.c
    public void cancel() {
        g gVar = this.f8404d;
        if (gVar != null) {
            gVar.b(ErrorCode.CANCEL);
        }
    }

    public static List<okhttp3.internal.http2.a> b(x xVar) {
        okhttp3.r c2 = xVar.c();
        ArrayList arrayList = new ArrayList(c2.b() + 4);
        arrayList.add(new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f, xVar.e()));
        arrayList.add(new okhttp3.internal.http2.a(okhttp3.internal.http2.a.g, okhttp3.c0.f.i.a(xVar.g())));
        String a2 = xVar.a("Host");
        if (a2 != null) {
            arrayList.add(new okhttp3.internal.http2.a(okhttp3.internal.http2.a.i, a2));
        }
        arrayList.add(new okhttp3.internal.http2.a(okhttp3.internal.http2.a.h, xVar.g().m()));
        int b2 = c2.b();
        for (int i = 0; i < b2; i++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(c2.a(i).toLowerCase(Locale.US));
            if (!f.contains(encodeUtf8.utf8())) {
                arrayList.add(new okhttp3.internal.http2.a(encodeUtf8, c2.b(i)));
            }
        }
        return arrayList;
    }

    @Override // okhttp3.c0.f.c
    public void a(x xVar) throws IOException {
        if (this.f8404d != null) {
            return;
        }
        g a2 = this.f8403c.a(b(xVar), xVar.a() != null);
        this.f8404d = a2;
        a2.h().a(this.f8401a.a(), TimeUnit.MILLISECONDS);
        this.f8404d.l().a(this.f8401a.b(), TimeUnit.MILLISECONDS);
    }

    @Override // okhttp3.c0.f.c
    public void a() throws IOException {
        this.f8404d.d().close();
    }

    @Override // okhttp3.c0.f.c
    public z.a a(boolean z) throws IOException {
        z.a a2 = a(this.f8404d.j(), this.e);
        if (z && okhttp3.c0.a.f8265a.a(a2) == 100) {
            return null;
        }
        return a2;
    }

    public static z.a a(okhttp3.r rVar, Protocol protocol) throws IOException {
        r.a aVar = new r.a();
        int b2 = rVar.b();
        okhttp3.c0.f.k kVar = null;
        for (int i = 0; i < b2; i++) {
            String a2 = rVar.a(i);
            String b3 = rVar.b(i);
            if (a2.equals(":status")) {
                kVar = okhttp3.c0.f.k.a("HTTP/1.1 " + b3);
            } else if (!g.contains(a2)) {
                okhttp3.c0.a.f8265a.a(aVar, a2, b3);
            }
        }
        if (kVar != null) {
            z.a aVar2 = new z.a();
            aVar2.a(protocol);
            aVar2.a(kVar.f8302b);
            aVar2.a(kVar.f8303c);
            aVar2.a(aVar.a());
            return aVar2;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // okhttp3.c0.f.c
    public a0 a(z zVar) throws IOException {
        okhttp3.internal.connection.f fVar = this.f8402b;
        fVar.f.e(fVar.e);
        return new okhttp3.c0.f.h(zVar.b("Content-Type"), okhttp3.c0.f.e.a(zVar), okio.k.a(new a(this.f8404d.e())));
    }
}
