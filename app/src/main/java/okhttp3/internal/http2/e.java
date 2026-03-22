package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http2.f;
import okio.ByteString;

/* compiled from: Http2Connection.java */
/* loaded from: classes2.dex */
public final class e implements Closeable {
    private static final ExecutorService u = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.c0.c.a("OkHttp Http2Connection", true));

    /* renamed from: a, reason: collision with root package name */
    final boolean f8408a;

    /* renamed from: b, reason: collision with root package name */
    final h f8409b;

    /* renamed from: d, reason: collision with root package name */
    final String f8411d;
    int e;
    int f;
    boolean g;
    private final ScheduledExecutorService h;
    private final ExecutorService i;
    final okhttp3.internal.http2.j j;
    private boolean k;
    long m;
    final Socket q;
    final okhttp3.internal.http2.h r;
    final j s;

    /* renamed from: c, reason: collision with root package name */
    final Map<Integer, okhttp3.internal.http2.g> f8410c = new LinkedHashMap();
    long l = 0;
    k n = new k();
    final k o = new k();
    boolean p = false;
    final Set<Integer> t = new LinkedHashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* loaded from: classes2.dex */
    public class a extends okhttp3.c0.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8412b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ErrorCode f8413c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, int i, ErrorCode errorCode) {
            super(str, objArr);
            this.f8412b = i;
            this.f8413c = errorCode;
        }

        @Override // okhttp3.c0.b
        public void b() {
            try {
                e.this.b(this.f8412b, this.f8413c);
            } catch (IOException unused) {
                e.this.n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* loaded from: classes2.dex */
    public class b extends okhttp3.c0.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8415b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f8416c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, int i, long j) {
            super(str, objArr);
            this.f8415b = i;
            this.f8416c = j;
        }

        @Override // okhttp3.c0.b
        public void b() {
            try {
                e.this.r.a(this.f8415b, this.f8416c);
            } catch (IOException unused) {
                e.this.n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* loaded from: classes2.dex */
    public class c extends okhttp3.c0.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8418b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f8419c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Object[] objArr, int i, List list) {
            super(str, objArr);
            this.f8418b = i;
            this.f8419c = list;
        }

        @Override // okhttp3.c0.b
        public void b() {
            if (e.this.j.a(this.f8418b, this.f8419c)) {
                try {
                    e.this.r.a(this.f8418b, ErrorCode.CANCEL);
                    synchronized (e.this) {
                        e.this.t.remove(Integer.valueOf(this.f8418b));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* loaded from: classes2.dex */
    public class d extends okhttp3.c0.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8421b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f8422c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f8423d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, int i, List list, boolean z) {
            super(str, objArr);
            this.f8421b = i;
            this.f8422c = list;
            this.f8423d = z;
        }

        @Override // okhttp3.c0.b
        public void b() {
            boolean a2 = e.this.j.a(this.f8421b, this.f8422c, this.f8423d);
            if (a2) {
                try {
                    e.this.r.a(this.f8421b, ErrorCode.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (a2 || this.f8423d) {
                synchronized (e.this) {
                    e.this.t.remove(Integer.valueOf(this.f8421b));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* renamed from: okhttp3.internal.http2.e$e, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0431e extends okhttp3.c0.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8424b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ okio.c f8425c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f8426d;
        final /* synthetic */ boolean e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0431e(String str, Object[] objArr, int i, okio.c cVar, int i2, boolean z) {
            super(str, objArr);
            this.f8424b = i;
            this.f8425c = cVar;
            this.f8426d = i2;
            this.e = z;
        }

        @Override // okhttp3.c0.b
        public void b() {
            try {
                boolean a2 = e.this.j.a(this.f8424b, this.f8425c, this.f8426d, this.e);
                if (a2) {
                    e.this.r.a(this.f8424b, ErrorCode.CANCEL);
                }
                if (a2 || this.e) {
                    synchronized (e.this) {
                        e.this.t.remove(Integer.valueOf(this.f8424b));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* loaded from: classes2.dex */
    public class f extends okhttp3.c0.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8427b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ErrorCode f8428c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, Object[] objArr, int i, ErrorCode errorCode) {
            super(str, objArr);
            this.f8427b = i;
            this.f8428c = errorCode;
        }

        @Override // okhttp3.c0.b
        public void b() {
            e.this.j.a(this.f8427b, this.f8428c);
            synchronized (e.this) {
                e.this.t.remove(Integer.valueOf(this.f8427b));
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* loaded from: classes.dex */
    public static abstract class h {

        /* renamed from: a, reason: collision with root package name */
        public static final h f8434a = new a();

        /* compiled from: Http2Connection.java */
        /* loaded from: classes2.dex */
        class a extends h {
            a() {
            }

            @Override // okhttp3.internal.http2.e.h
            public void a(okhttp3.internal.http2.g gVar) throws IOException {
                gVar.a(ErrorCode.REFUSED_STREAM);
            }
        }

        public void a(e eVar) {
        }

        public abstract void a(okhttp3.internal.http2.g gVar) throws IOException;
    }

    /* compiled from: Http2Connection.java */
    /* loaded from: classes2.dex */
    final class i extends okhttp3.c0.b {

        /* renamed from: b, reason: collision with root package name */
        final boolean f8435b;

        /* renamed from: c, reason: collision with root package name */
        final int f8436c;

        /* renamed from: d, reason: collision with root package name */
        final int f8437d;

        i(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", e.this.f8411d, Integer.valueOf(i), Integer.valueOf(i2));
            this.f8435b = z;
            this.f8436c = i;
            this.f8437d = i2;
        }

        @Override // okhttp3.c0.b
        public void b() {
            e.this.a(this.f8435b, this.f8436c, this.f8437d);
        }
    }

    e(g gVar) {
        this.j = gVar.f;
        boolean z = gVar.g;
        this.f8408a = z;
        this.f8409b = gVar.e;
        int i2 = z ? 1 : 2;
        this.f = i2;
        if (gVar.g) {
            this.f = i2 + 2;
        }
        if (gVar.g) {
            this.n.a(7, 16777216);
        }
        this.f8411d = gVar.f8431b;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, okhttp3.c0.c.a(okhttp3.c0.c.a("OkHttp %s Writer", this.f8411d), false));
        this.h = scheduledThreadPoolExecutor;
        if (gVar.h != 0) {
            i iVar = new i(false, 0, 0);
            int i3 = gVar.h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, i3, i3, TimeUnit.MILLISECONDS);
        }
        this.i = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), okhttp3.c0.c.a(okhttp3.c0.c.a("OkHttp %s Push Observer", this.f8411d), true));
        this.o.a(7, 65535);
        this.o.a(5, 16384);
        this.m = this.o.c();
        this.q = gVar.f8430a;
        this.r = new okhttp3.internal.http2.h(gVar.f8433d, this.f8408a);
        this.s = new j(new okhttp3.internal.http2.f(gVar.f8432c, this.f8408a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            a(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);
        } catch (IOException unused) {
        }
    }

    boolean b(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized okhttp3.internal.http2.g c(int i2) {
        okhttp3.internal.http2.g remove;
        remove = this.f8410c.remove(Integer.valueOf(i2));
        notifyAll();
        return remove;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void f(long j2) {
        long j3 = this.l + j2;
        this.l = j3;
        if (j3 >= this.n.c() / 2) {
            a(0, this.l);
            this.l = 0L;
        }
    }

    public void flush() throws IOException {
        this.r.flush();
    }

    public synchronized boolean g() {
        return this.g;
    }

    public synchronized int k() {
        return this.o.b(Integer.MAX_VALUE);
    }

    public void l() throws IOException {
        a(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0043 A[Catch: all -> 0x0075, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000e, B:9:0x0013, B:11:0x0017, B:13:0x002b, B:15:0x0033, B:19:0x003d, B:21:0x0043, B:22:0x004c, B:36:0x006f, B:37:0x0074), top: B:5:0x0007, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private okhttp3.internal.http2.g b(int r11, java.util.List<okhttp3.internal.http2.a> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            okhttp3.internal.http2.h r7 = r10.r
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L78
            int r0 = r10.f     // Catch: java.lang.Throwable -> L75
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L13
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch: java.lang.Throwable -> L75
            r10.a(r0)     // Catch: java.lang.Throwable -> L75
        L13:
            boolean r0 = r10.g     // Catch: java.lang.Throwable -> L75
            if (r0 != 0) goto L6f
            int r8 = r10.f     // Catch: java.lang.Throwable -> L75
            int r0 = r10.f     // Catch: java.lang.Throwable -> L75
            int r0 = r0 + 2
            r10.f = r0     // Catch: java.lang.Throwable -> L75
            okhttp3.internal.http2.g r9 = new okhttp3.internal.http2.g     // Catch: java.lang.Throwable -> L75
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L75
            if (r13 == 0) goto L3c
            long r0 = r10.m     // Catch: java.lang.Throwable -> L75
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L3c
            long r0 = r9.f8454b     // Catch: java.lang.Throwable -> L75
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L3a
            goto L3c
        L3a:
            r13 = 0
            goto L3d
        L3c:
            r13 = 1
        L3d:
            boolean r0 = r9.g()     // Catch: java.lang.Throwable -> L75
            if (r0 == 0) goto L4c
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.g> r0 = r10.f8410c     // Catch: java.lang.Throwable -> L75
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L75
            r0.put(r1, r9)     // Catch: java.lang.Throwable -> L75
        L4c:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L75
            if (r11 != 0) goto L55
            okhttp3.internal.http2.h r0 = r10.r     // Catch: java.lang.Throwable -> L78
            r0.a(r6, r8, r11, r12)     // Catch: java.lang.Throwable -> L78
            goto L5e
        L55:
            boolean r0 = r10.f8408a     // Catch: java.lang.Throwable -> L78
            if (r0 != 0) goto L67
            okhttp3.internal.http2.h r0 = r10.r     // Catch: java.lang.Throwable -> L78
            r0.a(r11, r8, r12)     // Catch: java.lang.Throwable -> L78
        L5e:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L78
            if (r13 == 0) goto L66
            okhttp3.internal.http2.h r11 = r10.r
            r11.flush()
        L66:
            return r9
        L67:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L78
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch: java.lang.Throwable -> L78
            throw r11     // Catch: java.lang.Throwable -> L78
        L6f:
            okhttp3.internal.http2.ConnectionShutdownException r11 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch: java.lang.Throwable -> L75
            r11.<init>()     // Catch: java.lang.Throwable -> L75
            throw r11     // Catch: java.lang.Throwable -> L75
        L75:
            r11 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L75
            throw r11     // Catch: java.lang.Throwable -> L78
        L78:
            r11 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L78
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.e.b(int, java.util.List, boolean):okhttp3.internal.http2.g");
    }

    synchronized okhttp3.internal.http2.g a(int i2) {
        return this.f8410c.get(Integer.valueOf(i2));
    }

    /* compiled from: Http2Connection.java */
    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        Socket f8430a;

        /* renamed from: b, reason: collision with root package name */
        String f8431b;

        /* renamed from: c, reason: collision with root package name */
        okio.e f8432c;

        /* renamed from: d, reason: collision with root package name */
        okio.d f8433d;
        h e = h.f8434a;
        okhttp3.internal.http2.j f = okhttp3.internal.http2.j.f8476a;
        boolean g;
        int h;

        public g(boolean z) {
            this.g = z;
        }

        public g a(Socket socket, String str, okio.e eVar, okio.d dVar) {
            this.f8430a = socket;
            this.f8431b = str;
            this.f8432c = eVar;
            this.f8433d = dVar;
            return this;
        }

        public g a(h hVar) {
            this.e = hVar;
            return this;
        }

        public g a(int i) {
            this.h = i;
            return this;
        }

        public e a() {
            return new e(this);
        }
    }

    public okhttp3.internal.http2.g a(List<okhttp3.internal.http2.a> list, boolean z) throws IOException {
        return b(0, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i2, ErrorCode errorCode) {
        try {
            this.h.execute(new a("OkHttp %s stream %d", new Object[]{this.f8411d, Integer.valueOf(i2)}, i2, errorCode));
        } catch (RejectedExecutionException unused) {
        }
    }

    public void a(int i2, boolean z, okio.c cVar, long j2) throws IOException {
        int min;
        long j3;
        if (j2 == 0) {
            this.r.a(z, i2, cVar, 0);
            return;
        }
        while (j2 > 0) {
            synchronized (this) {
                while (this.m <= 0) {
                    try {
                        if (this.f8410c.containsKey(Integer.valueOf(i2))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j2, this.m), this.r.k());
                j3 = min;
                this.m -= j3;
            }
            j2 -= j3;
            this.r.a(z && j2 == 0, i2, cVar, min);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* loaded from: classes2.dex */
    public class j extends okhttp3.c0.b implements f.b {

        /* renamed from: b, reason: collision with root package name */
        final okhttp3.internal.http2.f f8438b;

        /* compiled from: Http2Connection.java */
        /* loaded from: classes2.dex */
        class a extends okhttp3.c0.b {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ okhttp3.internal.http2.g f8440b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, Object[] objArr, okhttp3.internal.http2.g gVar) {
                super(str, objArr);
                this.f8440b = gVar;
            }

            @Override // okhttp3.c0.b
            public void b() {
                try {
                    e.this.f8409b.a(this.f8440b);
                } catch (IOException e) {
                    okhttp3.c0.h.f.c().a(4, "Http2Connection.Listener failure for " + e.this.f8411d, e);
                    try {
                        this.f8440b.a(ErrorCode.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* compiled from: Http2Connection.java */
        /* loaded from: classes2.dex */
        class b extends okhttp3.c0.b {
            b(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // okhttp3.c0.b
            public void b() {
                e eVar = e.this;
                eVar.f8409b.a(eVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Http2Connection.java */
        /* loaded from: classes2.dex */
        public class c extends okhttp3.c0.b {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ k f8443b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(String str, Object[] objArr, k kVar) {
                super(str, objArr);
                this.f8443b = kVar;
            }

            @Override // okhttp3.c0.b
            public void b() {
                try {
                    e.this.r.a(this.f8443b);
                } catch (IOException unused) {
                    e.this.n();
                }
            }
        }

        j(okhttp3.internal.http2.f fVar) {
            super("OkHttp %s", e.this.f8411d);
            this.f8438b = fVar;
        }

        @Override // okhttp3.internal.http2.f.b
        public void a() {
        }

        @Override // okhttp3.internal.http2.f.b
        public void a(int i, int i2, int i3, boolean z) {
        }

        @Override // okhttp3.internal.http2.f.b
        public void a(boolean z, int i, okio.e eVar, int i2) throws IOException {
            if (e.this.b(i)) {
                e.this.a(i, eVar, i2, z);
                return;
            }
            okhttp3.internal.http2.g a2 = e.this.a(i);
            if (a2 == null) {
                e.this.c(i, ErrorCode.PROTOCOL_ERROR);
                long j = i2;
                e.this.f(j);
                eVar.skip(j);
                return;
            }
            a2.a(eVar, i2);
            if (z) {
                a2.i();
            }
        }

        @Override // okhttp3.c0.b
        protected void b() {
            ErrorCode errorCode;
            e eVar;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    this.f8438b.a(this);
                    do {
                    } while (this.f8438b.a(false, (f.b) this));
                    errorCode = ErrorCode.NO_ERROR;
                } catch (IOException unused) {
                }
                try {
                    errorCode2 = ErrorCode.CANCEL;
                    eVar = e.this;
                } catch (IOException unused2) {
                    errorCode = ErrorCode.PROTOCOL_ERROR;
                    errorCode2 = ErrorCode.PROTOCOL_ERROR;
                    eVar = e.this;
                    eVar.a(errorCode, errorCode2);
                    okhttp3.c0.c.a(this.f8438b);
                }
            } catch (IOException unused3) {
            } catch (Throwable th2) {
                th = th2;
                errorCode = errorCode2;
                try {
                    e.this.a(errorCode, errorCode2);
                } catch (IOException unused4) {
                }
                okhttp3.c0.c.a(this.f8438b);
                throw th;
            }
            eVar.a(errorCode, errorCode2);
            okhttp3.c0.c.a(this.f8438b);
        }

        @Override // okhttp3.internal.http2.f.b
        public void a(boolean z, int i, int i2, List<okhttp3.internal.http2.a> list) {
            if (e.this.b(i)) {
                e.this.a(i, list, z);
                return;
            }
            synchronized (e.this) {
                okhttp3.internal.http2.g a2 = e.this.a(i);
                if (a2 == null) {
                    if (e.this.g) {
                        return;
                    }
                    if (i <= e.this.e) {
                        return;
                    }
                    if (i % 2 == e.this.f % 2) {
                        return;
                    }
                    okhttp3.internal.http2.g gVar = new okhttp3.internal.http2.g(i, e.this, false, z, okhttp3.c0.c.b(list));
                    e.this.e = i;
                    e.this.f8410c.put(Integer.valueOf(i), gVar);
                    e.u.execute(new a("OkHttp %s stream %d", new Object[]{e.this.f8411d, Integer.valueOf(i)}, gVar));
                    return;
                }
                a2.a(list);
                if (z) {
                    a2.i();
                }
            }
        }

        @Override // okhttp3.internal.http2.f.b
        public void a(int i, ErrorCode errorCode) {
            if (e.this.b(i)) {
                e.this.a(i, errorCode);
                return;
            }
            okhttp3.internal.http2.g c2 = e.this.c(i);
            if (c2 != null) {
                c2.c(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.f.b
        public void a(boolean z, k kVar) {
            okhttp3.internal.http2.g[] gVarArr;
            long j;
            int i;
            synchronized (e.this) {
                int c2 = e.this.o.c();
                if (z) {
                    e.this.o.a();
                }
                e.this.o.a(kVar);
                a(kVar);
                int c3 = e.this.o.c();
                gVarArr = null;
                if (c3 == -1 || c3 == c2) {
                    j = 0;
                } else {
                    j = c3 - c2;
                    if (!e.this.p) {
                        e.this.p = true;
                    }
                    if (!e.this.f8410c.isEmpty()) {
                        gVarArr = (okhttp3.internal.http2.g[]) e.this.f8410c.values().toArray(new okhttp3.internal.http2.g[e.this.f8410c.size()]);
                    }
                }
                e.u.execute(new b("OkHttp %s settings", e.this.f8411d));
            }
            if (gVarArr == null || j == 0) {
                return;
            }
            for (okhttp3.internal.http2.g gVar : gVarArr) {
                synchronized (gVar) {
                    gVar.a(j);
                }
            }
        }

        private void a(k kVar) {
            try {
                e.this.h.execute(new c("OkHttp %s ACK Settings", new Object[]{e.this.f8411d}, kVar));
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // okhttp3.internal.http2.f.b
        public void a(boolean z, int i, int i2) {
            if (!z) {
                try {
                    e.this.h.execute(new i(true, i, i2));
                } catch (RejectedExecutionException unused) {
                }
            } else {
                synchronized (e.this) {
                    e.this.k = false;
                    e.this.notifyAll();
                }
            }
        }

        @Override // okhttp3.internal.http2.f.b
        public void a(int i, ErrorCode errorCode, ByteString byteString) {
            okhttp3.internal.http2.g[] gVarArr;
            byteString.size();
            synchronized (e.this) {
                gVarArr = (okhttp3.internal.http2.g[]) e.this.f8410c.values().toArray(new okhttp3.internal.http2.g[e.this.f8410c.size()]);
                e.this.g = true;
            }
            for (okhttp3.internal.http2.g gVar : gVarArr) {
                if (gVar.c() > i && gVar.f()) {
                    gVar.c(ErrorCode.REFUSED_STREAM);
                    e.this.c(gVar.c());
                }
            }
        }

        @Override // okhttp3.internal.http2.f.b
        public void a(int i, long j) {
            if (i == 0) {
                synchronized (e.this) {
                    e.this.m += j;
                    e.this.notifyAll();
                }
                return;
            }
            okhttp3.internal.http2.g a2 = e.this.a(i);
            if (a2 != null) {
                synchronized (a2) {
                    a2.a(j);
                }
            }
        }

        @Override // okhttp3.internal.http2.f.b
        public void a(int i, int i2, List<okhttp3.internal.http2.a> list) {
            e.this.a(i2, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i2, long j2) {
        try {
            this.h.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f8411d, Integer.valueOf(i2)}, i2, j2));
        } catch (RejectedExecutionException unused) {
        }
    }

    void a(boolean z, int i2, int i3) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.k;
                this.k = true;
            }
            if (z2) {
                n();
                return;
            }
        }
        try {
            this.r.a(z, i2, i3);
        } catch (IOException unused) {
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i2, ErrorCode errorCode) throws IOException {
        this.r.a(i2, errorCode);
    }

    public void a(ErrorCode errorCode) throws IOException {
        synchronized (this.r) {
            synchronized (this) {
                if (this.g) {
                    return;
                }
                this.g = true;
                this.r.a(this.e, errorCode, okhttp3.c0.c.f8267a);
            }
        }
    }

    void a(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        okhttp3.internal.http2.g[] gVarArr = null;
        try {
            a(errorCode);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (!this.f8410c.isEmpty()) {
                gVarArr = (okhttp3.internal.http2.g[]) this.f8410c.values().toArray(new okhttp3.internal.http2.g[this.f8410c.size()]);
                this.f8410c.clear();
            }
        }
        if (gVarArr != null) {
            for (okhttp3.internal.http2.g gVar : gVarArr) {
                try {
                    gVar.a(errorCode2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        try {
            this.r.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.q.close();
        } catch (IOException e4) {
            e = e4;
        }
        this.h.shutdown();
        this.i.shutdown();
        if (e != null) {
            throw e;
        }
    }

    void a(boolean z) throws IOException {
        if (z) {
            this.r.g();
            this.r.b(this.n);
            if (this.n.c() != 65535) {
                this.r.a(0, r6 - 65535);
            }
        }
        new Thread(this.s).start();
    }

    void a(int i2, List<okhttp3.internal.http2.a> list) {
        synchronized (this) {
            if (this.t.contains(Integer.valueOf(i2))) {
                c(i2, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.t.add(Integer.valueOf(i2));
            try {
                a(new c("OkHttp %s Push Request[%s]", new Object[]{this.f8411d, Integer.valueOf(i2)}, i2, list));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    void a(int i2, List<okhttp3.internal.http2.a> list, boolean z) {
        try {
            a(new d("OkHttp %s Push Headers[%s]", new Object[]{this.f8411d, Integer.valueOf(i2)}, i2, list, z));
        } catch (RejectedExecutionException unused) {
        }
    }

    void a(int i2, okio.e eVar, int i3, boolean z) throws IOException {
        okio.c cVar = new okio.c();
        long j2 = i3;
        eVar.e(j2);
        eVar.b(cVar, j2);
        if (cVar.p() == j2) {
            a(new C0431e("OkHttp %s Push Data[%s]", new Object[]{this.f8411d, Integer.valueOf(i2)}, i2, cVar, i3, z));
            return;
        }
        throw new IOException(cVar.p() + " != " + i3);
    }

    void a(int i2, ErrorCode errorCode) {
        a(new f("OkHttp %s Push Reset[%s]", new Object[]{this.f8411d, Integer.valueOf(i2)}, i2, errorCode));
    }

    private synchronized void a(okhttp3.c0.b bVar) {
        if (!g()) {
            this.i.execute(bVar);
        }
    }
}
