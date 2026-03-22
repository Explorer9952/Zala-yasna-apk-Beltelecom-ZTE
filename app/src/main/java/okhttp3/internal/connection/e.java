package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.b0;
import okhttp3.p;
import okhttp3.s;

/* compiled from: RouteSelector.java */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final okhttp3.a f8372a;

    /* renamed from: b, reason: collision with root package name */
    private final d f8373b;

    /* renamed from: c, reason: collision with root package name */
    private final okhttp3.e f8374c;

    /* renamed from: d, reason: collision with root package name */
    private final p f8375d;
    private int f;
    private List<Proxy> e = Collections.emptyList();
    private List<InetSocketAddress> g = Collections.emptyList();
    private final List<b0> h = new ArrayList();

    /* compiled from: RouteSelector.java */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<b0> f8376a;

        /* renamed from: b, reason: collision with root package name */
        private int f8377b = 0;

        a(List<b0> list) {
            this.f8376a = list;
        }

        public List<b0> a() {
            return new ArrayList(this.f8376a);
        }

        public boolean b() {
            return this.f8377b < this.f8376a.size();
        }

        public b0 c() {
            if (b()) {
                List<b0> list = this.f8376a;
                int i = this.f8377b;
                this.f8377b = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    public e(okhttp3.a aVar, d dVar, okhttp3.e eVar, p pVar) {
        this.f8372a = aVar;
        this.f8373b = dVar;
        this.f8374c = eVar;
        this.f8375d = pVar;
        a(aVar.k(), aVar.f());
    }

    private boolean c() {
        return this.f < this.e.size();
    }

    private Proxy d() throws IOException {
        if (c()) {
            List<Proxy> list = this.e;
            int i = this.f;
            this.f = i + 1;
            Proxy proxy = list.get(i);
            a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f8372a.k().g() + "; exhausted proxy configurations: " + this.e);
    }

    public boolean a() {
        return c() || !this.h.isEmpty();
    }

    public a b() throws IOException {
        if (a()) {
            ArrayList arrayList = new ArrayList();
            while (c()) {
                Proxy d2 = d();
                int size = this.g.size();
                for (int i = 0; i < size; i++) {
                    b0 b0Var = new b0(this.f8372a, d2, this.g.get(i));
                    if (this.f8373b.c(b0Var)) {
                        this.h.add(b0Var);
                    } else {
                        arrayList.add(b0Var);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.h);
                this.h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }

    public void a(b0 b0Var, IOException iOException) {
        if (b0Var.b().type() != Proxy.Type.DIRECT && this.f8372a.h() != null) {
            this.f8372a.h().connectFailed(this.f8372a.k().n(), b0Var.b().address(), iOException);
        }
        this.f8373b.b(b0Var);
    }

    private void a(s sVar, Proxy proxy) {
        if (proxy != null) {
            this.e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f8372a.h().select(sVar.n());
            this.e = (select == null || select.isEmpty()) ? okhttp3.c0.c.a(Proxy.NO_PROXY) : okhttp3.c0.c.a(select);
        }
        this.f = 0;
    }

    private void a(Proxy proxy) throws IOException {
        String g;
        int j;
        this.g = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                g = a(inetSocketAddress);
                j = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        } else {
            g = this.f8372a.k().g();
            j = this.f8372a.k().j();
        }
        if (j >= 1 && j <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.g.add(InetSocketAddress.createUnresolved(g, j));
                return;
            }
            this.f8375d.a(this.f8374c, g);
            List<InetAddress> a2 = this.f8372a.c().a(g);
            if (!a2.isEmpty()) {
                this.f8375d.a(this.f8374c, g, a2);
                int size = a2.size();
                for (int i = 0; i < size; i++) {
                    this.g.add(new InetSocketAddress(a2.get(i), j));
                }
                return;
            }
            throw new UnknownHostException(this.f8372a.c() + " returned no addresses for " + g);
        }
        throw new SocketException("No route to " + g + ":" + j + "; port is out of range");
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
