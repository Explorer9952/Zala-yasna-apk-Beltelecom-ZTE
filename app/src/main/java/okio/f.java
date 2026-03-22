package okio;

import java.io.IOException;

/* compiled from: ForwardingSink.java */
/* loaded from: classes2.dex */
public abstract class f implements q {

    /* renamed from: a, reason: collision with root package name */
    private final q f8574a;

    public f(q qVar) {
        if (qVar != null) {
            this.f8574a = qVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // okio.q
    public void a(c cVar, long j) throws IOException {
        this.f8574a.a(cVar, j);
    }

    @Override // okio.q
    public s b() {
        return this.f8574a.b();
    }

    @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f8574a.close();
    }

    @Override // okio.q, java.io.Flushable
    public void flush() throws IOException {
        this.f8574a.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f8574a.toString() + ")";
    }
}
