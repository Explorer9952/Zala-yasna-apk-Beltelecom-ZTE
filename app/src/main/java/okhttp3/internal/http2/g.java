package okhttp3.internal.http2;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.http2.a;
import okhttp3.r;
import okio.q;
import okio.s;

/* compiled from: Http2Stream.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    long f8454b;

    /* renamed from: c, reason: collision with root package name */
    final int f8455c;

    /* renamed from: d, reason: collision with root package name */
    final e f8456d;
    private a.InterfaceC0429a f;
    private boolean g;
    private final b h;
    final a i;

    /* renamed from: a, reason: collision with root package name */
    long f8453a = 0;
    private final Deque<r> e = new ArrayDeque();
    final c j = new c();
    final c k = new c();
    ErrorCode l = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Stream.java */
    /* loaded from: classes2.dex */
    public class c extends okio.a {
        c() {
        }

        @Override // okio.a
        protected IOException b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.a
        protected void i() {
            g.this.b(ErrorCode.CANCEL);
        }

        public void k() throws IOException {
            if (h()) {
                throw b((IOException) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(int i, e eVar, boolean z, boolean z2, @Nullable r rVar) {
        if (eVar != null) {
            this.f8455c = i;
            this.f8456d = eVar;
            this.f8454b = eVar.o.c();
            this.h = new b(eVar.n.c());
            a aVar = new a();
            this.i = aVar;
            this.h.e = z2;
            aVar.f8459c = z;
            if (rVar != null) {
                this.e.add(rVar);
            }
            if (f() && rVar != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            if (!f() && rVar == null) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
            return;
        }
        throw new NullPointerException("connection == null");
    }

    public int c() {
        return this.f8455c;
    }

    public q d() {
        synchronized (this) {
            if (!this.g && !f()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.i;
    }

    public okio.r e() {
        return this.h;
    }

    public boolean f() {
        return this.f8456d.f8408a == ((this.f8455c & 1) == 1);
    }

    public synchronized boolean g() {
        if (this.l != null) {
            return false;
        }
        if ((this.h.e || this.h.f8464d) && (this.i.f8459c || this.i.f8458b)) {
            if (this.g) {
                return false;
            }
        }
        return true;
    }

    public s h() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        boolean g;
        synchronized (this) {
            this.h.e = true;
            g = g();
            notifyAll();
        }
        if (g) {
            return;
        }
        this.f8456d.c(this.f8455c);
    }

    public synchronized r j() throws IOException {
        this.j.g();
        while (this.e.isEmpty() && this.l == null) {
            try {
                k();
            } catch (Throwable th) {
                this.j.k();
                throw th;
            }
        }
        this.j.k();
        if (!this.e.isEmpty()) {
        } else {
            throw new StreamResetException(this.l);
        }
        return this.e.removeFirst();
    }

    void k() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public s l() {
        return this.k;
    }

    public void a(ErrorCode errorCode) throws IOException {
        if (d(errorCode)) {
            this.f8456d.b(this.f8455c, errorCode);
        }
    }

    public void b(ErrorCode errorCode) {
        if (d(errorCode)) {
            this.f8456d.c(this.f8455c, errorCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c(ErrorCode errorCode) {
        if (this.l == null) {
            this.l = errorCode;
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Stream.java */
    /* loaded from: classes2.dex */
    public final class a implements q {

        /* renamed from: a, reason: collision with root package name */
        private final okio.c f8457a = new okio.c();

        /* renamed from: b, reason: collision with root package name */
        boolean f8458b;

        /* renamed from: c, reason: collision with root package name */
        boolean f8459c;

        a() {
        }

        @Override // okio.q
        public void a(okio.c cVar, long j) throws IOException {
            this.f8457a.a(cVar, j);
            while (this.f8457a.p() >= PlaybackStateCompat.ACTION_PREPARE) {
                a(false);
            }
        }

        @Override // okio.q
        public s b() {
            return g.this.k;
        }

        @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (g.this) {
                if (this.f8458b) {
                    return;
                }
                if (!g.this.i.f8459c) {
                    if (this.f8457a.p() > 0) {
                        while (this.f8457a.p() > 0) {
                            a(true);
                        }
                    } else {
                        g gVar = g.this;
                        gVar.f8456d.a(gVar.f8455c, true, (okio.c) null, 0L);
                    }
                }
                synchronized (g.this) {
                    this.f8458b = true;
                }
                g.this.f8456d.flush();
                g.this.a();
            }
        }

        @Override // okio.q, java.io.Flushable
        public void flush() throws IOException {
            synchronized (g.this) {
                g.this.b();
            }
            while (this.f8457a.p() > 0) {
                a(false);
                g.this.f8456d.flush();
            }
        }

        private void a(boolean z) throws IOException {
            long min;
            synchronized (g.this) {
                g.this.k.g();
                while (g.this.f8454b <= 0 && !this.f8459c && !this.f8458b && g.this.l == null) {
                    try {
                        g.this.k();
                    } finally {
                    }
                }
                g.this.k.k();
                g.this.b();
                min = Math.min(g.this.f8454b, this.f8457a.p());
                g.this.f8454b -= min;
            }
            g.this.k.g();
            try {
                g.this.f8456d.a(g.this.f8455c, z && min == this.f8457a.p(), this.f8457a, min);
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<okhttp3.internal.http2.a> list) {
        boolean g;
        synchronized (this) {
            this.g = true;
            this.e.add(okhttp3.c0.c.b(list));
            g = g();
            notifyAll();
        }
        if (g) {
            return;
        }
        this.f8456d.c(this.f8455c);
    }

    void b() throws IOException {
        a aVar = this.i;
        if (!aVar.f8458b) {
            if (!aVar.f8459c) {
                if (this.l != null) {
                    throw new StreamResetException(this.l);
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    private boolean d(ErrorCode errorCode) {
        synchronized (this) {
            if (this.l != null) {
                return false;
            }
            if (this.h.e && this.i.f8459c) {
                return false;
            }
            this.l = errorCode;
            notifyAll();
            this.f8456d.c(this.f8455c);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(okio.e eVar, int i) throws IOException {
        this.h.a(eVar, i);
    }

    void a() throws IOException {
        boolean z;
        boolean g;
        synchronized (this) {
            z = !this.h.e && this.h.f8464d && (this.i.f8459c || this.i.f8458b);
            g = g();
        }
        if (z) {
            a(ErrorCode.CANCEL);
        } else {
            if (g) {
                return;
            }
            this.f8456d.c(this.f8455c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.f8454b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http2Stream.java */
    /* loaded from: classes2.dex */
    public final class b implements okio.r {

        /* renamed from: a, reason: collision with root package name */
        private final okio.c f8461a = new okio.c();

        /* renamed from: b, reason: collision with root package name */
        private final okio.c f8462b = new okio.c();

        /* renamed from: c, reason: collision with root package name */
        private final long f8463c;

        /* renamed from: d, reason: collision with root package name */
        boolean f8464d;
        boolean e;

        b(long j) {
            this.f8463c = j;
        }

        private void f(long j) {
            g.this.f8456d.f(j);
        }

        void a(okio.e eVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (g.this) {
                    z = this.e;
                    z2 = true;
                    z3 = this.f8462b.p() + j > this.f8463c;
                }
                if (z3) {
                    eVar.skip(j);
                    g.this.b(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    eVar.skip(j);
                    return;
                }
                long b2 = eVar.b(this.f8461a, j);
                if (b2 != -1) {
                    j -= b2;
                    synchronized (g.this) {
                        if (this.f8462b.p() != 0) {
                            z2 = false;
                        }
                        this.f8462b.a(this.f8461a);
                        if (z2) {
                            g.this.notifyAll();
                        }
                    }
                } else {
                    throw new EOFException();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x00cb, code lost:
        
            if (r11 == (-1)) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00cd, code lost:
        
            f(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00d0, code lost:
        
            return r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00d1, code lost:
        
            if (r0 != null) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00d3, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00d9, code lost:
        
            throw new okhttp3.internal.http2.StreamResetException(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00e1, code lost:
        
            throw new java.io.IOException("stream closed");
         */
        @Override // okio.r
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long b(okio.c r18, long r19) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 263
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.g.b.b(okio.c, long):long");
        }

        @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long p;
            a.InterfaceC0429a interfaceC0429a;
            ArrayList arrayList;
            synchronized (g.this) {
                this.f8464d = true;
                p = this.f8462b.p();
                this.f8462b.k();
                interfaceC0429a = null;
                if (g.this.e.isEmpty() || g.this.f == null) {
                    arrayList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList(g.this.e);
                    g.this.e.clear();
                    interfaceC0429a = g.this.f;
                    arrayList = arrayList2;
                }
                g.this.notifyAll();
            }
            if (p > 0) {
                f(p);
            }
            g.this.a();
            if (interfaceC0429a != null) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    interfaceC0429a.a((r) it2.next());
                }
            }
        }

        @Override // okio.r
        public s b() {
            return g.this.j;
        }
    }
}
