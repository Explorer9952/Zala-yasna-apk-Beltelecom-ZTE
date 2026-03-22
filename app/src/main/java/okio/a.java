package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: AsyncTimeout.java */
/* loaded from: classes.dex */
public class a extends s {
    private static final long h = TimeUnit.SECONDS.toMillis(60);
    private static final long i = TimeUnit.MILLISECONDS.toNanos(h);

    @Nullable
    static a j;
    private boolean e;

    @Nullable
    private a f;
    private long g;

    /* compiled from: AsyncTimeout.java */
    /* renamed from: okio.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0433a implements q {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f8565a;

        C0433a(q qVar) {
            this.f8565a = qVar;
        }

        @Override // okio.q
        public void a(okio.c cVar, long j) throws IOException {
            t.a(cVar.f8573b, 0L, j);
            while (true) {
                long j2 = 0;
                if (j <= 0) {
                    return;
                }
                n nVar = cVar.f8572a;
                while (true) {
                    if (j2 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                        break;
                    }
                    j2 += nVar.f8597c - nVar.f8596b;
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    }
                    nVar = nVar.f;
                }
                a.this.g();
                try {
                    try {
                        this.f8565a.a(cVar, j2);
                        j -= j2;
                        a.this.a(true);
                    } catch (IOException e) {
                        throw a.this.a(e);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }
        }

        @Override // okio.q
        public s b() {
            return a.this;
        }

        @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a.this.g();
            try {
                try {
                    this.f8565a.close();
                    a.this.a(true);
                } catch (IOException e) {
                    throw a.this.a(e);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // okio.q, java.io.Flushable
        public void flush() throws IOException {
            a.this.g();
            try {
                try {
                    this.f8565a.flush();
                    a.this.a(true);
                } catch (IOException e) {
                    throw a.this.a(e);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f8565a + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AsyncTimeout.java */
    /* loaded from: classes2.dex */
    public static final class c extends Thread {
        c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0015, code lost:
        
            r1.i();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<okio.a> r0 = okio.a.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                okio.a r1 = okio.a.j()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                okio.a r2 = okio.a.j     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                okio.a.j = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.i()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L1d
            L1c:
                throw r1
            L1d:
                goto L1c
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.a.c.run():void");
        }
    }

    private static synchronized void a(a aVar, long j2, boolean z) {
        synchronized (a.class) {
            if (j == null) {
                j = new a();
                new c().start();
            }
            long nanoTime = System.nanoTime();
            if (j2 != 0 && z) {
                aVar.g = Math.min(j2, aVar.c() - nanoTime) + nanoTime;
            } else if (j2 != 0) {
                aVar.g = j2 + nanoTime;
            } else if (z) {
                aVar.g = aVar.c();
            } else {
                throw new AssertionError();
            }
            long b2 = aVar.b(nanoTime);
            a aVar2 = j;
            while (aVar2.f != null && b2 >= aVar2.f.b(nanoTime)) {
                aVar2 = aVar2.f;
            }
            aVar.f = aVar2.f;
            aVar2.f = aVar;
            if (aVar2 == j) {
                a.class.notify();
            }
        }
    }

    private long b(long j2) {
        return this.g - j2;
    }

    @Nullable
    static a j() throws InterruptedException {
        a aVar = j.f;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            a.class.wait(h);
            if (j.f != null || System.nanoTime() - nanoTime < i) {
                return null;
            }
            return j;
        }
        long b2 = aVar.b(System.nanoTime());
        if (b2 > 0) {
            long j2 = b2 / C.MICROS_PER_SECOND;
            a.class.wait(j2, (int) (b2 - (C.MICROS_PER_SECOND * j2)));
            return null;
        }
        j.f = aVar.f;
        aVar.f = null;
        return aVar;
    }

    public final void g() {
        if (!this.e) {
            long f = f();
            boolean d2 = d();
            if (f != 0 || d2) {
                this.e = true;
                a(this, f, d2);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final boolean h() {
        if (!this.e) {
            return false;
        }
        this.e = false;
        return a(this);
    }

    protected void i() {
    }

    protected IOException b(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* compiled from: AsyncTimeout.java */
    /* loaded from: classes2.dex */
    class b implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f8567a;

        b(r rVar) {
            this.f8567a = rVar;
        }

        @Override // okio.r
        public long b(okio.c cVar, long j) throws IOException {
            a.this.g();
            try {
                try {
                    long b2 = this.f8567a.b(cVar, j);
                    a.this.a(true);
                    return b2;
                } catch (IOException e) {
                    throw a.this.a(e);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                try {
                    this.f8567a.close();
                    a.this.a(true);
                } catch (IOException e) {
                    throw a.this.a(e);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f8567a + ")";
        }

        @Override // okio.r
        public s b() {
            return a.this;
        }
    }

    private static synchronized boolean a(a aVar) {
        synchronized (a.class) {
            for (a aVar2 = j; aVar2 != null; aVar2 = aVar2.f) {
                if (aVar2.f == aVar) {
                    aVar2.f = aVar.f;
                    aVar.f = null;
                    return false;
                }
            }
            return true;
        }
    }

    public final q a(q qVar) {
        return new C0433a(qVar);
    }

    public final r a(r rVar) {
        return new b(rVar);
    }

    final void a(boolean z) throws IOException {
        if (h() && z) {
            throw b((IOException) null);
        }
    }

    final IOException a(IOException iOException) throws IOException {
        return !h() ? iOException : b(iOException);
    }
}
