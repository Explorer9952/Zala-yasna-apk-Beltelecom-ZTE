package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout.java */
/* loaded from: classes2.dex */
public class h extends s {
    private s e;

    public h(s sVar) {
        if (sVar != null) {
            this.e = sVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final h a(s sVar) {
        if (sVar != null) {
            this.e = sVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // okio.s
    public s b() {
        return this.e.b();
    }

    @Override // okio.s
    public long c() {
        return this.e.c();
    }

    @Override // okio.s
    public boolean d() {
        return this.e.d();
    }

    @Override // okio.s
    public void e() throws IOException {
        this.e.e();
    }

    @Override // okio.s
    public long f() {
        return this.e.f();
    }

    public final s g() {
        return this.e;
    }

    @Override // okio.s
    public s a(long j, TimeUnit timeUnit) {
        return this.e.a(j, timeUnit);
    }

    @Override // okio.s
    public s a(long j) {
        return this.e.a(j);
    }

    @Override // okio.s
    public s a() {
        return this.e.a();
    }
}
