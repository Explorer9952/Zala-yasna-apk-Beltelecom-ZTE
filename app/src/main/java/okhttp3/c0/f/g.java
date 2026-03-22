package okhttp3.c0.f;

import java.io.IOException;
import java.util.List;
import okhttp3.p;
import okhttp3.t;
import okhttp3.x;
import okhttp3.z;

/* compiled from: RealInterceptorChain.java */
/* loaded from: classes2.dex */
public final class g implements t.a {

    /* renamed from: a, reason: collision with root package name */
    private final List<t> f8290a;

    /* renamed from: b, reason: collision with root package name */
    private final okhttp3.internal.connection.f f8291b;

    /* renamed from: c, reason: collision with root package name */
    private final c f8292c;

    /* renamed from: d, reason: collision with root package name */
    private final okhttp3.internal.connection.c f8293d;
    private final int e;
    private final x f;
    private final okhttp3.e g;
    private final p h;
    private final int i;
    private final int j;
    private final int k;
    private int l;

    public g(List<t> list, okhttp3.internal.connection.f fVar, c cVar, okhttp3.internal.connection.c cVar2, int i, x xVar, okhttp3.e eVar, p pVar, int i2, int i3, int i4) {
        this.f8290a = list;
        this.f8293d = cVar2;
        this.f8291b = fVar;
        this.f8292c = cVar;
        this.e = i;
        this.f = xVar;
        this.g = eVar;
        this.h = pVar;
        this.i = i2;
        this.j = i3;
        this.k = i4;
    }

    @Override // okhttp3.t.a
    public int a() {
        return this.j;
    }

    @Override // okhttp3.t.a
    public int b() {
        return this.k;
    }

    @Override // okhttp3.t.a
    public okhttp3.i c() {
        return this.f8293d;
    }

    @Override // okhttp3.t.a
    public int d() {
        return this.i;
    }

    @Override // okhttp3.t.a
    public x e() {
        return this.f;
    }

    public okhttp3.e f() {
        return this.g;
    }

    public p g() {
        return this.h;
    }

    public c h() {
        return this.f8292c;
    }

    public okhttp3.internal.connection.f i() {
        return this.f8291b;
    }

    @Override // okhttp3.t.a
    public z a(x xVar) throws IOException {
        return a(xVar, this.f8291b, this.f8292c, this.f8293d);
    }

    public z a(x xVar, okhttp3.internal.connection.f fVar, c cVar, okhttp3.internal.connection.c cVar2) throws IOException {
        if (this.e < this.f8290a.size()) {
            this.l++;
            if (this.f8292c != null && !this.f8293d.a(xVar.g())) {
                throw new IllegalStateException("network interceptor " + this.f8290a.get(this.e - 1) + " must retain the same host and port");
            }
            if (this.f8292c != null && this.l > 1) {
                throw new IllegalStateException("network interceptor " + this.f8290a.get(this.e - 1) + " must call proceed() exactly once");
            }
            g gVar = new g(this.f8290a, fVar, cVar, cVar2, this.e + 1, xVar, this.g, this.h, this.i, this.j, this.k);
            t tVar = this.f8290a.get(this.e);
            z a2 = tVar.a(gVar);
            if (cVar != null && this.e + 1 < this.f8290a.size() && gVar.l != 1) {
                throw new IllegalStateException("network interceptor " + tVar + " must call proceed() exactly once");
            }
            if (a2 != null) {
                if (a2.g() != null) {
                    return a2;
                }
                throw new IllegalStateException("interceptor " + tVar + " returned a response with no body");
            }
            throw new NullPointerException("interceptor " + tVar + " returned null");
        }
        throw new AssertionError();
    }
}
