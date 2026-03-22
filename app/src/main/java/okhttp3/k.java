package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpec.java */
/* loaded from: classes.dex */
public final class k {
    private static final h[] e = {h.q, h.r, h.s, h.t, h.u, h.k, h.m, h.l, h.n, h.p, h.o};
    private static final h[] f = {h.q, h.r, h.s, h.t, h.u, h.k, h.m, h.l, h.n, h.p, h.o, h.i, h.j, h.g, h.h, h.e, h.f, h.f8361d};
    public static final k g;
    public static final k h;

    /* renamed from: a, reason: collision with root package name */
    final boolean f8488a;

    /* renamed from: b, reason: collision with root package name */
    final boolean f8489b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    final String[] f8490c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    final String[] f8491d;

    static {
        a aVar = new a(true);
        aVar.a(e);
        aVar.a(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2);
        aVar.a(true);
        aVar.a();
        a aVar2 = new a(true);
        aVar2.a(f);
        aVar2.a(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0);
        aVar2.a(true);
        g = aVar2.a();
        a aVar3 = new a(true);
        aVar3.a(f);
        aVar3.a(TlsVersion.TLS_1_0);
        aVar3.a(true);
        aVar3.a();
        h = new a(false).a();
    }

    k(a aVar) {
        this.f8488a = aVar.f8492a;
        this.f8490c = aVar.f8493b;
        this.f8491d = aVar.f8494c;
        this.f8489b = aVar.f8495d;
    }

    @Nullable
    public List<h> a() {
        String[] strArr = this.f8490c;
        if (strArr != null) {
            return h.a(strArr);
        }
        return null;
    }

    public boolean b() {
        return this.f8488a;
    }

    public boolean c() {
        return this.f8489b;
    }

    @Nullable
    public List<TlsVersion> d() {
        String[] strArr = this.f8491d;
        if (strArr != null) {
            return TlsVersion.forJavaNames(strArr);
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        k kVar = (k) obj;
        boolean z = this.f8488a;
        if (z != kVar.f8488a) {
            return false;
        }
        return !z || (Arrays.equals(this.f8490c, kVar.f8490c) && Arrays.equals(this.f8491d, kVar.f8491d) && this.f8489b == kVar.f8489b);
    }

    public int hashCode() {
        if (this.f8488a) {
            return ((((527 + Arrays.hashCode(this.f8490c)) * 31) + Arrays.hashCode(this.f8491d)) * 31) + (!this.f8489b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f8488a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f8490c != null ? a().toString() : "[all enabled]") + ", tlsVersions=" + (this.f8491d != null ? d().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f8489b + ")";
    }

    /* compiled from: ConnectionSpec.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f8492a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        String[] f8493b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        String[] f8494c;

        /* renamed from: d, reason: collision with root package name */
        boolean f8495d;

        a(boolean z) {
            this.f8492a = z;
        }

        public a a(h... hVarArr) {
            if (this.f8492a) {
                String[] strArr = new String[hVarArr.length];
                for (int i = 0; i < hVarArr.length; i++) {
                    strArr[i] = hVarArr[i].f8362a;
                }
                a(strArr);
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a b(String... strArr) {
            if (this.f8492a) {
                if (strArr.length != 0) {
                    this.f8494c = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a(k kVar) {
            this.f8492a = kVar.f8488a;
            this.f8493b = kVar.f8490c;
            this.f8494c = kVar.f8491d;
            this.f8495d = kVar.f8489b;
        }

        public a a(String... strArr) {
            if (this.f8492a) {
                if (strArr.length != 0) {
                    this.f8493b = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a a(TlsVersion... tlsVersionArr) {
            if (this.f8492a) {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i = 0; i < tlsVersionArr.length; i++) {
                    strArr[i] = tlsVersionArr[i].javaName;
                }
                b(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a a(boolean z) {
            if (this.f8492a) {
                this.f8495d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public k a() {
            return new k(this);
        }
    }

    private k b(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f8490c != null) {
            enabledCipherSuites = okhttp3.c0.c.a(h.f8359b, sSLSocket.getEnabledCipherSuites(), this.f8490c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f8491d != null) {
            enabledProtocols = okhttp3.c0.c.a(okhttp3.c0.c.o, sSLSocket.getEnabledProtocols(), this.f8491d);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a2 = okhttp3.c0.c.a(h.f8359b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && a2 != -1) {
            enabledCipherSuites = okhttp3.c0.c.a(enabledCipherSuites, supportedCipherSuites[a2]);
        }
        a aVar = new a(this);
        aVar.a(enabledCipherSuites);
        aVar.b(enabledProtocols);
        return aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SSLSocket sSLSocket, boolean z) {
        k b2 = b(sSLSocket, z);
        String[] strArr = b2.f8491d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b2.f8490c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean a(SSLSocket sSLSocket) {
        if (!this.f8488a) {
            return false;
        }
        String[] strArr = this.f8491d;
        if (strArr != null && !okhttp3.c0.c.b(okhttp3.c0.c.o, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f8490c;
        return strArr2 == null || okhttp3.c0.c.b(h.f8359b, strArr2, sSLSocket.getEnabledCipherSuites());
    }
}
