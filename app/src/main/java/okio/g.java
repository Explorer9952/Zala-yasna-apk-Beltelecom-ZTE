package okio;

import java.io.IOException;

/* compiled from: ForwardingSource.java */
/* loaded from: classes2.dex */
public abstract class g implements r {

    /* renamed from: a, reason: collision with root package name */
    private final r f8575a;

    public g(r rVar) {
        if (rVar != null) {
            this.f8575a = rVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // okio.r
    public s b() {
        return this.f8575a.b();
    }

    @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f8575a.close();
    }

    public final r g() {
        return this.f8575a;
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f8575a.toString() + ")";
    }
}
