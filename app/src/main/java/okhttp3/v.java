package okhttp3;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.p;
import okhttp3.r;
import okhttp3.z;

/* compiled from: OkHttpClient.java */
/* loaded from: classes.dex */
public class v implements Cloneable {
    static final List<Protocol> C = okhttp3.c0.c.a(Protocol.HTTP_2, Protocol.HTTP_1_1);
    static final List<k> D = okhttp3.c0.c.a(k.g, k.h);
    final int A;
    final int B;

    /* renamed from: a, reason: collision with root package name */
    final n f8531a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    final Proxy f8532b;

    /* renamed from: c, reason: collision with root package name */
    final List<Protocol> f8533c;

    /* renamed from: d, reason: collision with root package name */
    final List<k> f8534d;
    final List<t> e;
    final List<t> f;
    final p.c g;
    final ProxySelector h;
    final m i;

    @Nullable
    final c j;

    @Nullable
    final okhttp3.c0.e.d k;
    final SocketFactory l;
    final SSLSocketFactory m;
    final okhttp3.c0.j.c n;
    final HostnameVerifier o;
    final g p;
    final okhttp3.b q;
    final okhttp3.b r;
    final j s;
    final o t;
    final boolean u;
    final boolean v;
    final boolean w;
    final int x;
    final int y;
    final int z;

    /* compiled from: OkHttpClient.java */
    /* loaded from: classes.dex */
    class a extends okhttp3.c0.a {
        a() {
        }

        @Override // okhttp3.c0.a
        public void a(r.a aVar, String str) {
            aVar.a(str);
        }

        @Override // okhttp3.c0.a
        public void b(j jVar, okhttp3.internal.connection.c cVar) {
            jVar.b(cVar);
        }

        @Override // okhttp3.c0.a
        public void a(r.a aVar, String str, String str2) {
            aVar.b(str, str2);
        }

        @Override // okhttp3.c0.a
        public boolean a(j jVar, okhttp3.internal.connection.c cVar) {
            return jVar.a(cVar);
        }

        @Override // okhttp3.c0.a
        public okhttp3.internal.connection.c a(j jVar, okhttp3.a aVar, okhttp3.internal.connection.f fVar, b0 b0Var) {
            return jVar.a(aVar, fVar, b0Var);
        }

        @Override // okhttp3.c0.a
        public boolean a(okhttp3.a aVar, okhttp3.a aVar2) {
            return aVar.a(aVar2);
        }

        @Override // okhttp3.c0.a
        public Socket a(j jVar, okhttp3.a aVar, okhttp3.internal.connection.f fVar) {
            return jVar.a(aVar, fVar);
        }

        @Override // okhttp3.c0.a
        public okhttp3.internal.connection.d a(j jVar) {
            return jVar.e;
        }

        @Override // okhttp3.c0.a
        public int a(z.a aVar) {
            return aVar.f8563c;
        }

        @Override // okhttp3.c0.a
        public void a(k kVar, SSLSocket sSLSocket, boolean z) {
            kVar.a(sSLSocket, z);
        }

        @Override // okhttp3.c0.a
        @Nullable
        public IOException a(e eVar, @Nullable IOException iOException) {
            return ((w) eVar).a(iOException);
        }
    }

    /* compiled from: OkHttpClient.java */
    /* loaded from: classes.dex */
    public static final class b {
        int A;
        int B;

        /* renamed from: a, reason: collision with root package name */
        n f8535a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        Proxy f8536b;

        /* renamed from: c, reason: collision with root package name */
        List<Protocol> f8537c;

        /* renamed from: d, reason: collision with root package name */
        List<k> f8538d;
        final List<t> e;
        final List<t> f;
        p.c g;
        ProxySelector h;
        m i;

        @Nullable
        c j;

        @Nullable
        okhttp3.c0.e.d k;
        SocketFactory l;

        @Nullable
        SSLSocketFactory m;

        @Nullable
        okhttp3.c0.j.c n;
        HostnameVerifier o;
        g p;
        okhttp3.b q;
        okhttp3.b r;
        j s;
        o t;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public b() {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.f8535a = new n();
            this.f8537c = v.C;
            this.f8538d = v.D;
            this.g = p.a(p.f8511a);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.h = proxySelector;
            if (proxySelector == null) {
                this.h = new okhttp3.c0.i.a();
            }
            this.i = m.f8505a;
            this.l = SocketFactory.getDefault();
            this.o = okhttp3.c0.j.d.f8342a;
            this.p = g.f8351c;
            okhttp3.b bVar = okhttp3.b.f8260a;
            this.q = bVar;
            this.r = bVar;
            this.s = new j();
            this.t = o.f8510a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 0;
            this.y = 10000;
            this.z = 10000;
            this.A = 10000;
            this.B = 0;
        }

        public b a(long j, TimeUnit timeUnit) {
            this.y = okhttp3.c0.c.a("timeout", j, timeUnit);
            return this;
        }

        public b b(long j, TimeUnit timeUnit) {
            this.z = okhttp3.c0.c.a("timeout", j, timeUnit);
            return this;
        }

        public b c(long j, TimeUnit timeUnit) {
            this.A = okhttp3.c0.c.a("timeout", j, timeUnit);
            return this;
        }

        public b a(boolean z) {
            this.v = z;
            return this;
        }

        public b b(boolean z) {
            this.u = z;
            return this;
        }

        public b a(t tVar) {
            if (tVar != null) {
                this.e.add(tVar);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public v a() {
            return new v(this);
        }

        b(v vVar) {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.f8535a = vVar.f8531a;
            this.f8536b = vVar.f8532b;
            this.f8537c = vVar.f8533c;
            this.f8538d = vVar.f8534d;
            this.e.addAll(vVar.e);
            this.f.addAll(vVar.f);
            this.g = vVar.g;
            this.h = vVar.h;
            this.i = vVar.i;
            this.k = vVar.k;
            this.j = vVar.j;
            this.l = vVar.l;
            this.m = vVar.m;
            this.n = vVar.n;
            this.o = vVar.o;
            this.p = vVar.p;
            this.q = vVar.q;
            this.r = vVar.r;
            this.s = vVar.s;
            this.t = vVar.t;
            this.u = vVar.u;
            this.v = vVar.v;
            this.w = vVar.w;
            this.x = vVar.x;
            this.y = vVar.y;
            this.z = vVar.z;
            this.A = vVar.A;
            this.B = vVar.B;
        }
    }

    static {
        okhttp3.c0.a.f8265a = new a();
    }

    public v() {
        this(new b());
    }

    private static SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext a2 = okhttp3.c0.h.f.c().a();
            a2.init(null, new TrustManager[]{x509TrustManager}, null);
            return a2.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw okhttp3.c0.c.a("No System TLS", (Exception) e);
        }
    }

    public SocketFactory A() {
        return this.l;
    }

    public SSLSocketFactory B() {
        return this.m;
    }

    public int C() {
        return this.A;
    }

    @Nullable
    public c b() {
        return this.j;
    }

    public int c() {
        return this.x;
    }

    public g d() {
        return this.p;
    }

    public int e() {
        return this.y;
    }

    public j f() {
        return this.s;
    }

    public List<k> h() {
        return this.f8534d;
    }

    public m i() {
        return this.i;
    }

    public n j() {
        return this.f8531a;
    }

    public o k() {
        return this.t;
    }

    public p.c l() {
        return this.g;
    }

    public boolean m() {
        return this.v;
    }

    public boolean n() {
        return this.u;
    }

    public HostnameVerifier o() {
        return this.o;
    }

    public List<t> p() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public okhttp3.c0.e.d q() {
        c cVar = this.j;
        return cVar != null ? cVar.f8264a : this.k;
    }

    public List<t> r() {
        return this.f;
    }

    public b s() {
        return new b(this);
    }

    public int t() {
        return this.B;
    }

    public List<Protocol> u() {
        return this.f8533c;
    }

    @Nullable
    public Proxy v() {
        return this.f8532b;
    }

    public okhttp3.b w() {
        return this.q;
    }

    public ProxySelector x() {
        return this.h;
    }

    public int y() {
        return this.z;
    }

    public boolean z() {
        return this.w;
    }

    v(b bVar) {
        boolean z;
        this.f8531a = bVar.f8535a;
        this.f8532b = bVar.f8536b;
        this.f8533c = bVar.f8537c;
        this.f8534d = bVar.f8538d;
        this.e = okhttp3.c0.c.a(bVar.e);
        this.f = okhttp3.c0.c.a(bVar.f);
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
        Iterator<k> it2 = this.f8534d.iterator();
        loop0: while (true) {
            while (it2.hasNext()) {
                z = z || it2.next().b();
            }
        }
        if (bVar.m == null && z) {
            X509TrustManager a2 = okhttp3.c0.c.a();
            this.m = a(a2);
            this.n = okhttp3.c0.j.c.a(a2);
        } else {
            this.m = bVar.m;
            this.n = bVar.n;
        }
        if (this.m != null) {
            okhttp3.c0.h.f.c().a(this.m);
        }
        this.o = bVar.o;
        this.p = bVar.p.a(this.n);
        this.q = bVar.q;
        this.r = bVar.r;
        this.s = bVar.s;
        this.t = bVar.t;
        this.u = bVar.u;
        this.v = bVar.v;
        this.w = bVar.w;
        this.x = bVar.x;
        this.y = bVar.y;
        this.z = bVar.z;
        this.A = bVar.A;
        this.B = bVar.B;
        if (!this.e.contains(null)) {
            if (this.f.contains(null)) {
                throw new IllegalStateException("Null network interceptor: " + this.f);
            }
            return;
        }
        throw new IllegalStateException("Null interceptor: " + this.e);
    }

    public okhttp3.b a() {
        return this.r;
    }

    public e a(x xVar) {
        return w.a(this, xVar, false);
    }
}
