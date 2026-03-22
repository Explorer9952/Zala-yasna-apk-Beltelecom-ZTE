package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Timeout.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: d, reason: collision with root package name */
    public static final s f8603d = new a();

    /* renamed from: a, reason: collision with root package name */
    private boolean f8604a;

    /* renamed from: b, reason: collision with root package name */
    private long f8605b;

    /* renamed from: c, reason: collision with root package name */
    private long f8606c;

    /* compiled from: Timeout.java */
    /* loaded from: classes2.dex */
    final class a extends s {
        a() {
        }

        @Override // okio.s
        public s a(long j) {
            return this;
        }

        @Override // okio.s
        public s a(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // okio.s
        public void e() throws IOException {
        }
    }

    public s a(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit != null) {
                this.f8606c = timeUnit.toNanos(j);
                return this;
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    public s b() {
        this.f8606c = 0L;
        return this;
    }

    public long c() {
        if (this.f8604a) {
            return this.f8605b;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean d() {
        return this.f8604a;
    }

    public void e() throws IOException {
        if (!Thread.interrupted()) {
            if (this.f8604a && this.f8605b - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }

    public long f() {
        return this.f8606c;
    }

    public s a(long j) {
        this.f8604a = true;
        this.f8605b = j;
        return this;
    }

    public s a() {
        this.f8604a = false;
        return this;
    }
}
