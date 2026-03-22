package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

/* compiled from: Route.java */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    final a f8261a;

    /* renamed from: b, reason: collision with root package name */
    final Proxy f8262b;

    /* renamed from: c, reason: collision with root package name */
    final InetSocketAddress f8263c;

    public b0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress != null) {
            this.f8261a = aVar;
            this.f8262b = proxy;
            this.f8263c = inetSocketAddress;
            return;
        }
        throw new NullPointerException("inetSocketAddress == null");
    }

    public a a() {
        return this.f8261a;
    }

    public Proxy b() {
        return this.f8262b;
    }

    public boolean c() {
        return this.f8261a.i != null && this.f8262b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.f8263c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof b0) {
            b0 b0Var = (b0) obj;
            if (b0Var.f8261a.equals(this.f8261a) && b0Var.f8262b.equals(this.f8262b) && b0Var.f8263c.equals(this.f8263c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f8261a.hashCode()) * 31) + this.f8262b.hashCode()) * 31) + this.f8263c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f8263c + "}";
    }
}
