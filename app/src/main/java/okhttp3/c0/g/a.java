package okhttp3.c0.g;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.a0;
import okhttp3.c0.f.i;
import okhttp3.r;
import okhttp3.v;
import okhttp3.x;
import okhttp3.z;
import okio.h;
import okio.k;
import okio.q;
import okio.r;
import okio.s;

/* compiled from: Http1Codec.java */
/* loaded from: classes2.dex */
public final class a implements okhttp3.c0.f.c {

    /* renamed from: a, reason: collision with root package name */
    final v f8304a;

    /* renamed from: b, reason: collision with root package name */
    final okhttp3.internal.connection.f f8305b;

    /* renamed from: c, reason: collision with root package name */
    final okio.e f8306c;

    /* renamed from: d, reason: collision with root package name */
    final okio.d f8307d;
    int e = 0;
    private long f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: classes2.dex */
    public abstract class b implements r {

        /* renamed from: a, reason: collision with root package name */
        protected final h f8308a;

        /* renamed from: b, reason: collision with root package name */
        protected boolean f8309b;

        /* renamed from: c, reason: collision with root package name */
        protected long f8310c;

        private b() {
            this.f8308a = new h(a.this.f8306c.b());
            this.f8310c = 0L;
        }

        protected final void a(boolean z, IOException iOException) throws IOException {
            a aVar = a.this;
            int i = aVar.e;
            if (i == 6) {
                return;
            }
            if (i == 5) {
                aVar.a(this.f8308a);
                a aVar2 = a.this;
                aVar2.e = 6;
                okhttp3.internal.connection.f fVar = aVar2.f8305b;
                if (fVar != null) {
                    fVar.a(!z, aVar2, this.f8310c, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + a.this.e);
        }

        @Override // okio.r
        public s b() {
            return this.f8308a;
        }

        @Override // okio.r
        public long b(okio.c cVar, long j) throws IOException {
            try {
                long b2 = a.this.f8306c.b(cVar, j);
                if (b2 > 0) {
                    this.f8310c += b2;
                }
                return b2;
            } catch (IOException e) {
                a(false, e);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: classes2.dex */
    public final class c implements q {

        /* renamed from: a, reason: collision with root package name */
        private final h f8312a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f8313b;

        c() {
            this.f8312a = new h(a.this.f8307d.b());
        }

        @Override // okio.q
        public void a(okio.c cVar, long j) throws IOException {
            if (this.f8313b) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            a.this.f8307d.c(j);
            a.this.f8307d.a("\r\n");
            a.this.f8307d.a(cVar, j);
            a.this.f8307d.a("\r\n");
        }

        @Override // okio.q
        public s b() {
            return this.f8312a;
        }

        @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.f8313b) {
                return;
            }
            this.f8313b = true;
            a.this.f8307d.a("0\r\n\r\n");
            a.this.a(this.f8312a);
            a.this.e = 3;
        }

        @Override // okio.q, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.f8313b) {
                return;
            }
            a.this.f8307d.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: classes2.dex */
    public class d extends b {
        private final okhttp3.s e;
        private long f;
        private boolean g;

        d(okhttp3.s sVar) {
            super();
            this.f = -1L;
            this.g = true;
            this.e = sVar;
        }

        private void g() throws IOException {
            if (this.f != -1) {
                a.this.f8306c.f();
            }
            try {
                this.f = a.this.f8306c.j();
                String trim = a.this.f8306c.f().trim();
                if (this.f < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f + trim + "\"");
                }
                if (this.f == 0) {
                    this.g = false;
                    okhttp3.c0.f.e.a(a.this.f8304a.i(), this.e, a.this.e());
                    a(true, null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // okhttp3.c0.g.a.b, okio.r
        public long b(okio.c cVar, long j) throws IOException {
            if (j >= 0) {
                if (!this.f8309b) {
                    if (!this.g) {
                        return -1L;
                    }
                    long j2 = this.f;
                    if (j2 == 0 || j2 == -1) {
                        g();
                        if (!this.g) {
                            return -1L;
                        }
                    }
                    long b2 = super.b(cVar, Math.min(j, this.f));
                    if (b2 != -1) {
                        this.f -= b2;
                        return b2;
                    }
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    a(false, protocolException);
                    throw protocolException;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f8309b) {
                return;
            }
            if (this.g && !okhttp3.c0.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f8309b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: classes2.dex */
    public final class e implements q {

        /* renamed from: a, reason: collision with root package name */
        private final h f8315a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f8316b;

        /* renamed from: c, reason: collision with root package name */
        private long f8317c;

        e(long j) {
            this.f8315a = new h(a.this.f8307d.b());
            this.f8317c = j;
        }

        @Override // okio.q
        public void a(okio.c cVar, long j) throws IOException {
            if (!this.f8316b) {
                okhttp3.c0.c.a(cVar.p(), 0L, j);
                if (j <= this.f8317c) {
                    a.this.f8307d.a(cVar, j);
                    this.f8317c -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.f8317c + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }

        @Override // okio.q
        public s b() {
            return this.f8315a;
        }

        @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f8316b) {
                return;
            }
            this.f8316b = true;
            if (this.f8317c <= 0) {
                a.this.a(this.f8315a);
                a.this.e = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // okio.q, java.io.Flushable
        public void flush() throws IOException {
            if (this.f8316b) {
                return;
            }
            a.this.f8307d.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: classes2.dex */
    public class f extends b {
        private long e;

        f(a aVar, long j) throws IOException {
            super();
            this.e = j;
            if (j == 0) {
                a(true, null);
            }
        }

        @Override // okhttp3.c0.g.a.b, okio.r
        public long b(okio.c cVar, long j) throws IOException {
            if (j >= 0) {
                if (!this.f8309b) {
                    long j2 = this.e;
                    if (j2 == 0) {
                        return -1L;
                    }
                    long b2 = super.b(cVar, Math.min(j2, j));
                    if (b2 != -1) {
                        long j3 = this.e - b2;
                        this.e = j3;
                        if (j3 == 0) {
                            a(true, null);
                        }
                        return b2;
                    }
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    a(false, protocolException);
                    throw protocolException;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f8309b) {
                return;
            }
            if (this.e != 0 && !okhttp3.c0.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f8309b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: classes2.dex */
    public class g extends b {
        private boolean e;

        g(a aVar) {
            super();
        }

        @Override // okhttp3.c0.g.a.b, okio.r
        public long b(okio.c cVar, long j) throws IOException {
            if (j >= 0) {
                if (!this.f8309b) {
                    if (this.e) {
                        return -1L;
                    }
                    long b2 = super.b(cVar, j);
                    if (b2 != -1) {
                        return b2;
                    }
                    this.e = true;
                    a(true, null);
                    return -1L;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f8309b) {
                return;
            }
            if (!this.e) {
                a(false, null);
            }
            this.f8309b = true;
        }
    }

    public a(v vVar, okhttp3.internal.connection.f fVar, okio.e eVar, okio.d dVar) {
        this.f8304a = vVar;
        this.f8305b = fVar;
        this.f8306c = eVar;
        this.f8307d = dVar;
    }

    private String f() throws IOException {
        String b2 = this.f8306c.b(this.f);
        this.f -= b2.length();
        return b2;
    }

    @Override // okhttp3.c0.f.c
    public q a(x xVar, long j) {
        if ("chunked".equalsIgnoreCase(xVar.a("Transfer-Encoding"))) {
            return c();
        }
        if (j != -1) {
            return a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.c0.f.c
    public void b() throws IOException {
        this.f8307d.flush();
    }

    public q c() {
        if (this.e == 1) {
            this.e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.e);
    }

    @Override // okhttp3.c0.f.c
    public void cancel() {
        okhttp3.internal.connection.c c2 = this.f8305b.c();
        if (c2 != null) {
            c2.b();
        }
    }

    public r d() throws IOException {
        if (this.e == 4) {
            okhttp3.internal.connection.f fVar = this.f8305b;
            if (fVar != null) {
                this.e = 5;
                fVar.e();
                return new g(this);
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.e);
    }

    public okhttp3.r e() throws IOException {
        r.a aVar = new r.a();
        while (true) {
            String f2 = f();
            if (f2.length() != 0) {
                okhttp3.c0.a.f8265a.a(aVar, f2);
            } else {
                return aVar.a();
            }
        }
    }

    public okio.r b(long j) throws IOException {
        if (this.e == 4) {
            this.e = 5;
            return new f(this, j);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    @Override // okhttp3.c0.f.c
    public void a(x xVar) throws IOException {
        a(xVar.c(), i.a(xVar, this.f8305b.c().e().b().type()));
    }

    @Override // okhttp3.c0.f.c
    public a0 a(z zVar) throws IOException {
        okhttp3.internal.connection.f fVar = this.f8305b;
        fVar.f.e(fVar.e);
        String b2 = zVar.b("Content-Type");
        if (!okhttp3.c0.f.e.b(zVar)) {
            return new okhttp3.c0.f.h(b2, 0L, k.a(b(0L)));
        }
        if ("chunked".equalsIgnoreCase(zVar.b("Transfer-Encoding"))) {
            return new okhttp3.c0.f.h(b2, -1L, k.a(a(zVar.s().g())));
        }
        long a2 = okhttp3.c0.f.e.a(zVar);
        if (a2 != -1) {
            return new okhttp3.c0.f.h(b2, a2, k.a(b(a2)));
        }
        return new okhttp3.c0.f.h(b2, -1L, k.a(d()));
    }

    @Override // okhttp3.c0.f.c
    public void a() throws IOException {
        this.f8307d.flush();
    }

    public void a(okhttp3.r rVar, String str) throws IOException {
        if (this.e == 0) {
            this.f8307d.a(str).a("\r\n");
            int b2 = rVar.b();
            for (int i = 0; i < b2; i++) {
                this.f8307d.a(rVar.a(i)).a(": ").a(rVar.b(i)).a("\r\n");
            }
            this.f8307d.a("\r\n");
            this.e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.e);
    }

    @Override // okhttp3.c0.f.c
    public z.a a(boolean z) throws IOException {
        int i = this.e;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.e);
        }
        try {
            okhttp3.c0.f.k a2 = okhttp3.c0.f.k.a(f());
            z.a aVar = new z.a();
            aVar.a(a2.f8301a);
            aVar.a(a2.f8302b);
            aVar.a(a2.f8303c);
            aVar.a(e());
            if (z && a2.f8302b == 100) {
                return null;
            }
            if (a2.f8302b == 100) {
                this.e = 3;
                return aVar;
            }
            this.e = 4;
            return aVar;
        } catch (EOFException e2) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f8305b);
            iOException.initCause(e2);
            throw iOException;
        }
    }

    public q a(long j) {
        if (this.e == 1) {
            this.e = 2;
            return new e(j);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    public okio.r a(okhttp3.s sVar) throws IOException {
        if (this.e == 4) {
            this.e = 5;
            return new d(sVar);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    void a(h hVar) {
        s g2 = hVar.g();
        hVar.a(s.f8603d);
        g2.a();
        g2.b();
    }
}
