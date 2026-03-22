package okhttp3.c0.f;

import com.video.androidsdk.common.ErrCode;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.p;
import okhttp3.s;
import okhttp3.t;
import okhttp3.v;
import okhttp3.x;
import okhttp3.y;
import okhttp3.z;

/* compiled from: RetryAndFollowUpInterceptor.java */
/* loaded from: classes2.dex */
public final class j implements t {

    /* renamed from: a, reason: collision with root package name */
    private final v f8297a;

    /* renamed from: b, reason: collision with root package name */
    private volatile okhttp3.internal.connection.f f8298b;

    /* renamed from: c, reason: collision with root package name */
    private Object f8299c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f8300d;

    public j(v vVar, boolean z) {
        this.f8297a = vVar;
    }

    public void a() {
        this.f8300d = true;
        okhttp3.internal.connection.f fVar = this.f8298b;
        if (fVar != null) {
            fVar.a();
        }
    }

    public boolean b() {
        return this.f8300d;
    }

    public void a(Object obj) {
        this.f8299c = obj;
    }

    @Override // okhttp3.t
    public z a(t.a aVar) throws IOException {
        z a2;
        x a3;
        x e = aVar.e();
        g gVar = (g) aVar;
        okhttp3.e f = gVar.f();
        p g = gVar.g();
        okhttp3.internal.connection.f fVar = new okhttp3.internal.connection.f(this.f8297a.f(), a(e.g()), f, g, this.f8299c);
        this.f8298b = fVar;
        z zVar = null;
        int i = 0;
        while (!this.f8300d) {
            try {
                try {
                    a2 = gVar.a(e, fVar, null, null);
                    if (zVar != null) {
                        z.a p = a2.p();
                        z.a p2 = zVar.p();
                        p2.a((a0) null);
                        p.c(p2.a());
                        a2 = p.a();
                    }
                    try {
                        a3 = a(a2, fVar.g());
                    } catch (IOException e2) {
                        fVar.f();
                        throw e2;
                    }
                } catch (Throwable th) {
                    fVar.a((IOException) null);
                    fVar.f();
                    throw th;
                }
            } catch (IOException e3) {
                if (!a(e3, fVar, !(e3 instanceof ConnectionShutdownException), e)) {
                    throw e3;
                }
            } catch (RouteException e4) {
                if (!a(e4.getLastConnectException(), fVar, false, e)) {
                    throw e4.getFirstConnectException();
                }
            }
            if (a3 == null) {
                fVar.f();
                return a2;
            }
            okhttp3.c0.c.a(a2.g());
            int i2 = i + 1;
            if (i2 <= 20) {
                a3.a();
                if (!a(a2, a3.g())) {
                    fVar.f();
                    fVar = new okhttp3.internal.connection.f(this.f8297a.f(), a(a3.g()), f, g, this.f8299c);
                    this.f8298b = fVar;
                } else if (fVar.b() != null) {
                    throw new IllegalStateException("Closing the body of " + a2 + " didn't close its backing stream. Bad interceptor?");
                }
                zVar = a2;
                e = a3;
                i = i2;
            } else {
                fVar.f();
                throw new ProtocolException("Too many follow-up requests: " + i2);
            }
        }
        fVar.f();
        throw new IOException("Canceled");
    }

    private okhttp3.a a(s sVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        okhttp3.g gVar;
        if (sVar.h()) {
            SSLSocketFactory B = this.f8297a.B();
            hostnameVerifier = this.f8297a.o();
            sSLSocketFactory = B;
            gVar = this.f8297a.d();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            gVar = null;
        }
        return new okhttp3.a(sVar.g(), sVar.j(), this.f8297a.k(), this.f8297a.A(), sSLSocketFactory, hostnameVerifier, gVar, this.f8297a.w(), this.f8297a.v(), this.f8297a.u(), this.f8297a.h(), this.f8297a.x());
    }

    private boolean a(IOException iOException, okhttp3.internal.connection.f fVar, boolean z, x xVar) {
        fVar.a(iOException);
        if (!this.f8297a.z()) {
            return false;
        }
        if (z) {
            xVar.a();
        }
        return a(iOException, z) && fVar.d();
    }

    private boolean a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private x a(z zVar, b0 b0Var) throws IOException {
        String b2;
        s b3;
        Proxy v;
        if (zVar != null) {
            int l = zVar.l();
            String e = zVar.s().e();
            if (l == 307 || l == 308) {
                if (!e.equals("GET") && !e.equals("HEAD")) {
                    return null;
                }
            } else {
                if (l == 401) {
                    return this.f8297a.a().a(b0Var, zVar);
                }
                if (l == 503) {
                    if ((zVar.q() == null || zVar.q().l() != 503) && a(zVar, Integer.MAX_VALUE) == 0) {
                        return zVar.s();
                    }
                    return null;
                }
                if (l == 407) {
                    if (b0Var != null) {
                        v = b0Var.b();
                    } else {
                        v = this.f8297a.v();
                    }
                    if (v.type() == Proxy.Type.HTTP) {
                        return this.f8297a.w().a(b0Var, zVar);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                if (l == 408) {
                    if (!this.f8297a.z()) {
                        return null;
                    }
                    zVar.s().a();
                    if ((zVar.q() == null || zVar.q().l() != 408) && a(zVar, 0) <= 0) {
                        return zVar.s();
                    }
                    return null;
                }
                switch (l) {
                    case 300:
                    case 301:
                    case ErrCode.ERRCODE_HTTP_MOVED_TEMP /* 302 */:
                    case 303:
                        break;
                    default:
                        return null;
                }
            }
            if (!this.f8297a.m() || (b2 = zVar.b("Location")) == null || (b3 = zVar.s().g().b(b2)) == null) {
                return null;
            }
            if (!b3.m().equals(zVar.s().g().m()) && !this.f8297a.n()) {
                return null;
            }
            x.a f = zVar.s().f();
            if (f.b(e)) {
                boolean d2 = f.d(e);
                if (f.c(e)) {
                    f.a("GET", (y) null);
                } else {
                    f.a(e, d2 ? zVar.s().a() : null);
                }
                if (!d2) {
                    f.a("Transfer-Encoding");
                    f.a("Content-Length");
                    f.a("Content-Type");
                }
            }
            if (!a(zVar, b3)) {
                f.a("Authorization");
            }
            f.a(b3);
            return f.a();
        }
        throw new IllegalStateException();
    }

    private int a(z zVar, int i) {
        String b2 = zVar.b("Retry-After");
        if (b2 == null) {
            return i;
        }
        if (b2.matches("\\d+")) {
            return Integer.valueOf(b2).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean a(z zVar, s sVar) {
        s g = zVar.s().g();
        return g.g().equals(sVar.g()) && g.j() == sVar.j() && g.m().equals(sVar.m());
    }
}
