package okhttp3.internal.connection;

import com.facebook.appevents.integrity.IntegrityManager;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okhttp3.b0;
import okhttp3.g;
import okhttp3.i;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.e;
import okhttp3.j;
import okhttp3.p;
import okhttp3.q;
import okhttp3.s;
import okhttp3.t;
import okhttp3.v;
import okhttp3.x;
import okhttp3.y;
import okhttp3.z;
import okio.k;
import okio.r;

/* compiled from: RealConnection.java */
/* loaded from: classes.dex */
public final class c extends e.h implements i {

    /* renamed from: b, reason: collision with root package name */
    private final j f8368b;

    /* renamed from: c, reason: collision with root package name */
    private final b0 f8369c;

    /* renamed from: d, reason: collision with root package name */
    private Socket f8370d;
    private Socket e;
    private q f;
    private Protocol g;
    private okhttp3.internal.http2.e h;
    private okio.e i;
    private okio.d j;
    public boolean k;
    public int l;
    public int m = 1;
    public final List<Reference<f>> n = new ArrayList();
    public long o = Long.MAX_VALUE;

    public c(j jVar, b0 b0Var) {
        this.f8368b = jVar;
        this.f8369c = b0Var;
    }

    private x g() throws IOException {
        x.a aVar = new x.a();
        aVar.a(this.f8369c.a().k());
        aVar.a("CONNECT", (y) null);
        aVar.a("Host", okhttp3.c0.c.a(this.f8369c.a().k(), true));
        aVar.a("Proxy-Connection", "Keep-Alive");
        aVar.a("User-Agent", okhttp3.c0.d.a());
        x a2 = aVar.a();
        z.a aVar2 = new z.a();
        aVar2.a(a2);
        aVar2.a(Protocol.HTTP_1_1);
        aVar2.a(407);
        aVar2.a("Preemptive Authenticate");
        aVar2.a(okhttp3.c0.c.f8269c);
        aVar2.b(-1L);
        aVar2.a(-1L);
        aVar2.b("Proxy-Authenticate", "OkHttp-Preemptive");
        x a3 = this.f8369c.a().g().a(this.f8369c, aVar2.a());
        return a3 != null ? a3 : a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f4 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r17, int r18, int r19, int r20, boolean r21, okhttp3.e r22, okhttp3.p r23) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.c.a(int, int, int, int, boolean, okhttp3.e, okhttp3.p):void");
    }

    public void b() {
        okhttp3.c0.c.a(this.f8370d);
    }

    public q c() {
        return this.f;
    }

    public boolean d() {
        return this.h != null;
    }

    public b0 e() {
        return this.f8369c;
    }

    public Socket f() {
        return this.e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f8369c.a().k().g());
        sb.append(":");
        sb.append(this.f8369c.a().k().j());
        sb.append(", proxy=");
        sb.append(this.f8369c.b());
        sb.append(" hostAddress=");
        sb.append(this.f8369c.d());
        sb.append(" cipherSuite=");
        q qVar = this.f;
        sb.append(qVar != null ? qVar.a() : IntegrityManager.INTEGRITY_TYPE_NONE);
        sb.append(" protocol=");
        sb.append(this.g);
        sb.append('}');
        return sb.toString();
    }

    private void a(int i, int i2, int i3, okhttp3.e eVar, p pVar) throws IOException {
        x g = g();
        s g2 = g.g();
        for (int i4 = 0; i4 < 21; i4++) {
            a(i, i2, eVar, pVar);
            g = a(i2, i3, g, g2);
            if (g == null) {
                return;
            }
            okhttp3.c0.c.a(this.f8370d);
            this.f8370d = null;
            this.j = null;
            this.i = null;
            pVar.a(eVar, this.f8369c.d(), this.f8369c.b(), null);
        }
    }

    private void a(int i, int i2, okhttp3.e eVar, p pVar) throws IOException {
        Socket createSocket;
        Proxy b2 = this.f8369c.b();
        okhttp3.a a2 = this.f8369c.a();
        if (b2.type() != Proxy.Type.DIRECT && b2.type() != Proxy.Type.HTTP) {
            createSocket = new Socket(b2);
        } else {
            createSocket = a2.i().createSocket();
        }
        this.f8370d = createSocket;
        pVar.a(eVar, this.f8369c.d(), b2);
        this.f8370d.setSoTimeout(i2);
        try {
            okhttp3.c0.h.f.c().a(this.f8370d, this.f8369c.d(), i);
            try {
                this.i = k.a(k.b(this.f8370d));
                this.j = k.a(k.a(this.f8370d));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f8369c.d());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void a(b bVar, int i, okhttp3.e eVar, p pVar) throws IOException {
        if (this.f8369c.a().j() == null) {
            if (this.f8369c.a().e().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
                this.e = this.f8370d;
                this.g = Protocol.H2_PRIOR_KNOWLEDGE;
                a(i);
                return;
            } else {
                this.e = this.f8370d;
                this.g = Protocol.HTTP_1_1;
                return;
            }
        }
        pVar.g(eVar);
        a(bVar);
        pVar.a(eVar, this.f);
        if (this.g == Protocol.HTTP_2) {
            a(i);
        }
    }

    private void a(int i) throws IOException {
        this.e.setSoTimeout(0);
        e.g gVar = new e.g(true);
        gVar.a(this.e, this.f8369c.a().k().g(), this.i, this.j);
        gVar.a(this);
        gVar.a(i);
        okhttp3.internal.http2.e a2 = gVar.a();
        this.h = a2;
        a2.l();
    }

    private void a(b bVar) throws IOException {
        SSLSocket sSLSocket;
        Protocol protocol;
        okhttp3.a a2 = this.f8369c.a();
        SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (SSLSocket) a2.j().createSocket(this.f8370d, a2.k().g(), a2.k().j(), true);
            } catch (AssertionError e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            okhttp3.k a3 = bVar.a(sSLSocket);
            if (a3.c()) {
                okhttp3.c0.h.f.c().a(sSLSocket, a2.k().g(), a2.e());
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            q a4 = q.a(session);
            if (a2.d().verify(a2.k().g(), session)) {
                a2.a().a(a2.k().g(), a4.b());
                String b2 = a3.c() ? okhttp3.c0.h.f.c().b(sSLSocket) : null;
                this.e = sSLSocket;
                this.i = k.a(k.b(sSLSocket));
                this.j = k.a(k.a(this.e));
                this.f = a4;
                if (b2 != null) {
                    protocol = Protocol.get(b2);
                } else {
                    protocol = Protocol.HTTP_1_1;
                }
                this.g = protocol;
                if (sSLSocket != null) {
                    okhttp3.c0.h.f.c().a(sSLSocket);
                    return;
                }
                return;
            }
            X509Certificate x509Certificate = (X509Certificate) a4.b().get(0);
            throw new SSLPeerUnverifiedException("Hostname " + a2.k().g() + " not verified:\n    certificate: " + g.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + okhttp3.c0.j.d.a(x509Certificate));
        } catch (AssertionError e2) {
            e = e2;
            if (!okhttp3.c0.c.a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                okhttp3.c0.h.f.c().a(sSLSocket2);
            }
            okhttp3.c0.c.a((Socket) sSLSocket2);
            throw th;
        }
    }

    private x a(int i, int i2, x xVar, s sVar) throws IOException {
        String str = "CONNECT " + okhttp3.c0.c.a(sVar, true) + " HTTP/1.1";
        while (true) {
            okhttp3.c0.g.a aVar = new okhttp3.c0.g.a(null, null, this.i, this.j);
            this.i.b().a(i, TimeUnit.MILLISECONDS);
            this.j.b().a(i2, TimeUnit.MILLISECONDS);
            aVar.a(xVar.c(), str);
            aVar.a();
            z.a a2 = aVar.a(false);
            a2.a(xVar);
            z a3 = a2.a();
            long a4 = okhttp3.c0.f.e.a(a3);
            if (a4 == -1) {
                a4 = 0;
            }
            r b2 = aVar.b(a4);
            okhttp3.c0.c.b(b2, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            b2.close();
            int l = a3.l();
            if (l == 200) {
                if (this.i.a().d() && this.j.a().d()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (l == 407) {
                x a5 = this.f8369c.a().g().a(this.f8369c, a3);
                if (a5 != null) {
                    if ("close".equalsIgnoreCase(a3.b("Connection"))) {
                        return a5;
                    }
                    xVar = a5;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + a3.l());
            }
        }
    }

    public boolean a(okhttp3.a aVar, @Nullable b0 b0Var) {
        if (this.n.size() >= this.m || this.k || !okhttp3.c0.a.f8265a.a(this.f8369c.a(), aVar)) {
            return false;
        }
        if (aVar.k().g().equals(e().a().k().g())) {
            return true;
        }
        if (this.h == null || b0Var == null || b0Var.b().type() != Proxy.Type.DIRECT || this.f8369c.b().type() != Proxy.Type.DIRECT || !this.f8369c.d().equals(b0Var.d()) || b0Var.a().d() != okhttp3.c0.j.d.f8342a || !a(aVar.k())) {
            return false;
        }
        try {
            aVar.a().a(aVar.k().g(), c().b());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean a(s sVar) {
        if (sVar.j() != this.f8369c.a().k().j()) {
            return false;
        }
        if (sVar.g().equals(this.f8369c.a().k().g())) {
            return true;
        }
        return this.f != null && okhttp3.c0.j.d.f8342a.a(sVar.g(), (X509Certificate) this.f.b().get(0));
    }

    public okhttp3.c0.f.c a(v vVar, t.a aVar, f fVar) throws SocketException {
        if (this.h != null) {
            return new okhttp3.internal.http2.d(vVar, aVar, fVar, this.h);
        }
        this.e.setSoTimeout(aVar.a());
        this.i.b().a(aVar.a(), TimeUnit.MILLISECONDS);
        this.j.b().a(aVar.b(), TimeUnit.MILLISECONDS);
        return new okhttp3.c0.g.a(vVar, fVar, this.i, this.j);
    }

    public boolean a(boolean z) {
        if (this.e.isClosed() || this.e.isInputShutdown() || this.e.isOutputShutdown()) {
            return false;
        }
        if (this.h != null) {
            return !r0.g();
        }
        if (z) {
            try {
                int soTimeout = this.e.getSoTimeout();
                try {
                    this.e.setSoTimeout(1);
                    return !this.i.d();
                } finally {
                    this.e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // okhttp3.internal.http2.e.h
    public void a(okhttp3.internal.http2.g gVar) throws IOException {
        gVar.a(ErrorCode.REFUSED_STREAM);
    }

    @Override // okhttp3.internal.http2.e.h
    public void a(okhttp3.internal.http2.e eVar) {
        synchronized (this.f8368b) {
            this.m = eVar.k();
        }
    }

    @Override // okhttp3.i
    public Protocol a() {
        return this.g;
    }
}
