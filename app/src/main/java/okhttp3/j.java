package okhttp3;

import com.google.android.exoplayer2.C;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.connection.f;

/* compiled from: ConnectionPool.java */
/* loaded from: classes.dex */
public final class j {
    private static final Executor g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.c0.c.a("OkHttp ConnectionPool", true));

    /* renamed from: a, reason: collision with root package name */
    private final int f8483a;

    /* renamed from: b, reason: collision with root package name */
    private final long f8484b;

    /* renamed from: c, reason: collision with root package name */
    private final Runnable f8485c;

    /* renamed from: d, reason: collision with root package name */
    private final Deque<okhttp3.internal.connection.c> f8486d;
    final okhttp3.internal.connection.d e;
    boolean f;

    /* compiled from: ConnectionPool.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                long a2 = j.this.a(System.nanoTime());
                if (a2 == -1) {
                    return;
                }
                if (a2 > 0) {
                    long j = a2 / C.MICROS_PER_SECOND;
                    long j2 = a2 - (C.MICROS_PER_SECOND * j);
                    synchronized (j.this) {
                        try {
                            j.this.wait(j, (int) j2);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    public j() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public okhttp3.internal.connection.c a(okhttp3.a aVar, okhttp3.internal.connection.f fVar, b0 b0Var) {
        for (okhttp3.internal.connection.c cVar : this.f8486d) {
            if (cVar.a(aVar, b0Var)) {
                fVar.a(cVar, true);
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(okhttp3.internal.connection.c cVar) {
        if (!this.f) {
            this.f = true;
            g.execute(this.f8485c);
        }
        this.f8486d.add(cVar);
    }

    public j(int i, long j, TimeUnit timeUnit) {
        this.f8485c = new a();
        this.f8486d = new ArrayDeque();
        this.e = new okhttp3.internal.connection.d();
        this.f8483a = i;
        this.f8484b = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Socket a(okhttp3.a aVar, okhttp3.internal.connection.f fVar) {
        for (okhttp3.internal.connection.c cVar : this.f8486d) {
            if (cVar.a(aVar, null) && cVar.d() && cVar != fVar.c()) {
                return fVar.a(cVar);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(okhttp3.internal.connection.c cVar) {
        if (!cVar.k && this.f8483a != 0) {
            notifyAll();
            return false;
        }
        this.f8486d.remove(cVar);
        return true;
    }

    long a(long j) {
        synchronized (this) {
            okhttp3.internal.connection.c cVar = null;
            long j2 = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (okhttp3.internal.connection.c cVar2 : this.f8486d) {
                if (a(cVar2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - cVar2.o;
                    if (j3 > j2) {
                        cVar = cVar2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f8484b && i <= this.f8483a) {
                if (i > 0) {
                    return this.f8484b - j2;
                }
                if (i2 > 0) {
                    return this.f8484b;
                }
                this.f = false;
                return -1L;
            }
            this.f8486d.remove(cVar);
            okhttp3.c0.c.a(cVar.f());
            return 0L;
        }
    }

    private int a(okhttp3.internal.connection.c cVar, long j) {
        List<Reference<okhttp3.internal.connection.f>> list = cVar.n;
        int i = 0;
        while (i < list.size()) {
            Reference<okhttp3.internal.connection.f> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                okhttp3.c0.h.f.c().a("A connection to " + cVar.e().a().k() + " was leaked. Did you forget to close a response body?", ((f.a) reference).f8382a);
                list.remove(i);
                cVar.k = true;
                if (list.isEmpty()) {
                    cVar.o = j - this.f8484b;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
