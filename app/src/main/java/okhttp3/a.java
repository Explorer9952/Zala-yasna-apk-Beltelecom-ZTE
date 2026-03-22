package okhttp3;

import com.video.androidsdk.common.http.HttpConstant;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.s;

/* compiled from: Address.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    final s f8253a;

    /* renamed from: b, reason: collision with root package name */
    final o f8254b;

    /* renamed from: c, reason: collision with root package name */
    final SocketFactory f8255c;

    /* renamed from: d, reason: collision with root package name */
    final b f8256d;
    final List<Protocol> e;
    final List<k> f;
    final ProxySelector g;

    @Nullable
    final Proxy h;

    @Nullable
    final SSLSocketFactory i;

    @Nullable
    final HostnameVerifier j;

    @Nullable
    final g k;

    public a(String str, int i, o oVar, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable g gVar, b bVar, @Nullable Proxy proxy, List<Protocol> list, List<k> list2, ProxySelector proxySelector) {
        s.a aVar = new s.a();
        aVar.d(sSLSocketFactory != null ? HttpConstant.PROTOCOL_HTTPS : HttpConstant.PROTOCOL_HTTP);
        aVar.b(str);
        aVar.a(i);
        this.f8253a = aVar.a();
        if (oVar != null) {
            this.f8254b = oVar;
            if (socketFactory != null) {
                this.f8255c = socketFactory;
                if (bVar != null) {
                    this.f8256d = bVar;
                    if (list != null) {
                        this.e = okhttp3.c0.c.a(list);
                        if (list2 != null) {
                            this.f = okhttp3.c0.c.a(list2);
                            if (proxySelector != null) {
                                this.g = proxySelector;
                                this.h = proxy;
                                this.i = sSLSocketFactory;
                                this.j = hostnameVerifier;
                                this.k = gVar;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    @Nullable
    public g a() {
        return this.k;
    }

    public List<k> b() {
        return this.f;
    }

    public o c() {
        return this.f8254b;
    }

    @Nullable
    public HostnameVerifier d() {
        return this.j;
    }

    public List<Protocol> e() {
        return this.e;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f8253a.equals(aVar.f8253a) && a(aVar)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public Proxy f() {
        return this.h;
    }

    public b g() {
        return this.f8256d;
    }

    public ProxySelector h() {
        return this.g;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f8253a.hashCode()) * 31) + this.f8254b.hashCode()) * 31) + this.f8256d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        Proxy proxy = this.h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        g gVar = this.k;
        return hashCode4 + (gVar != null ? gVar.hashCode() : 0);
    }

    public SocketFactory i() {
        return this.f8255c;
    }

    @Nullable
    public SSLSocketFactory j() {
        return this.i;
    }

    public s k() {
        return this.f8253a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f8253a.g());
        sb.append(":");
        sb.append(this.f8253a.j());
        if (this.h != null) {
            sb.append(", proxy=");
            sb.append(this.h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.g);
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(a aVar) {
        return this.f8254b.equals(aVar.f8254b) && this.f8256d.equals(aVar.f8256d) && this.e.equals(aVar.e) && this.f.equals(aVar.f) && this.g.equals(aVar.g) && okhttp3.c0.c.a(this.h, aVar.h) && okhttp3.c0.c.a(this.i, aVar.i) && okhttp3.c0.c.a(this.j, aVar.j) && okhttp3.c0.c.a(this.k, aVar.k) && k().j() == aVar.k().j();
    }
}
