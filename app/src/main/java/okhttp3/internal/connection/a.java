package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.c0.f.g;
import okhttp3.t;
import okhttp3.v;
import okhttp3.x;
import okhttp3.z;

/* compiled from: ConnectInterceptor.java */
/* loaded from: classes2.dex */
public final class a implements t {

    /* renamed from: a, reason: collision with root package name */
    public final v f8363a;

    public a(v vVar) {
        this.f8363a = vVar;
    }

    @Override // okhttp3.t
    public z a(t.a aVar) throws IOException {
        g gVar = (g) aVar;
        x e = gVar.e();
        f i = gVar.i();
        return gVar.a(e, i, i.a(this.f8363a, aVar, !e.e().equals("GET")), i.c());
    }
}
