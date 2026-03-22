package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.b0;
import okhttp3.internal.connection.e;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.j;
import okhttp3.p;
import okhttp3.t;
import okhttp3.v;

/* compiled from: StreamAllocation.java */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final okhttp3.a f8378a;

    /* renamed from: b, reason: collision with root package name */
    private e.a f8379b;

    /* renamed from: c, reason: collision with root package name */
    private b0 f8380c;

    /* renamed from: d, reason: collision with root package name */
    private final j f8381d;
    public final okhttp3.e e;
    public final p f;
    private final Object g;
    private final e h;
    private int i;
    private c j;
    private boolean k;
    private boolean l;
    private boolean m;
    private okhttp3.c0.f.c n;

    /* compiled from: StreamAllocation.java */
    /* loaded from: classes2.dex */
    public static final class a extends WeakReference<f> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f8382a;

        a(f fVar, Object obj) {
            super(fVar);
            this.f8382a = obj;
        }
    }

    public f(j jVar, okhttp3.a aVar, okhttp3.e eVar, p pVar, Object obj) {
        this.f8381d = jVar;
        this.f8378a = aVar;
        this.e = eVar;
        this.f = pVar;
        this.h = new e(aVar, i(), eVar, pVar);
        this.g = obj;
    }

    private Socket h() {
        c cVar = this.j;
        if (cVar == null || !cVar.k) {
            return null;
        }
        return a(false, false, true);
    }

    private d i() {
        return okhttp3.c0.a.f8265a.a(this.f8381d);
    }

    public okhttp3.c0.f.c a(v vVar, t.a aVar, boolean z) {
        try {
            okhttp3.c0.f.c a2 = a(aVar.d(), aVar.a(), aVar.b(), vVar.t(), vVar.z(), z).a(vVar, aVar, this);
            synchronized (this.f8381d) {
                this.n = a2;
            }
            return a2;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    public okhttp3.c0.f.c b() {
        okhttp3.c0.f.c cVar;
        synchronized (this.f8381d) {
            cVar = this.n;
        }
        return cVar;
    }

    public synchronized c c() {
        return this.j;
    }

    public boolean d() {
        e.a aVar;
        return this.f8380c != null || ((aVar = this.f8379b) != null && aVar.b()) || this.h.a();
    }

    public void e() {
        c cVar;
        Socket a2;
        synchronized (this.f8381d) {
            cVar = this.j;
            a2 = a(true, false, false);
            if (this.j != null) {
                cVar = null;
            }
        }
        okhttp3.c0.c.a(a2);
        if (cVar != null) {
            this.f.b(this.e, cVar);
        }
    }

    public void f() {
        c cVar;
        Socket a2;
        synchronized (this.f8381d) {
            cVar = this.j;
            a2 = a(false, true, false);
            if (this.j != null) {
                cVar = null;
            }
        }
        okhttp3.c0.c.a(a2);
        if (cVar != null) {
            okhttp3.c0.a.f8265a.a(this.e, (IOException) null);
            this.f.b(this.e, cVar);
            this.f.a(this.e);
        }
    }

    public b0 g() {
        return this.f8380c;
    }

    public String toString() {
        c c2 = c();
        return c2 != null ? c2.toString() : this.f8378a.toString();
    }

    private void b(c cVar) {
        int size = cVar.n.size();
        for (int i = 0; i < size; i++) {
            if (cVar.n.get(i).get() == this) {
                cVar.n.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private c a(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            c a2 = a(i, i2, i3, i4, z);
            synchronized (this.f8381d) {
                if (a2.l == 0) {
                    return a2;
                }
                if (a2.a(z2)) {
                    return a2;
                }
                e();
            }
        }
    }

    private c a(int i, int i2, int i3, int i4, boolean z) throws IOException {
        Socket h;
        Socket socket;
        c cVar;
        c cVar2;
        b0 b0Var;
        boolean z2;
        boolean z3;
        e.a aVar;
        synchronized (this.f8381d) {
            if (!this.l) {
                if (this.n == null) {
                    if (!this.m) {
                        c cVar3 = this.j;
                        h = h();
                        socket = null;
                        if (this.j != null) {
                            cVar2 = this.j;
                            cVar = null;
                        } else {
                            cVar = cVar3;
                            cVar2 = null;
                        }
                        if (!this.k) {
                            cVar = null;
                        }
                        if (cVar2 == null) {
                            okhttp3.c0.a.f8265a.a(this.f8381d, this.f8378a, this, null);
                            if (this.j != null) {
                                cVar2 = this.j;
                                b0Var = null;
                                z2 = true;
                            } else {
                                b0Var = this.f8380c;
                            }
                        } else {
                            b0Var = null;
                        }
                        z2 = false;
                    } else {
                        throw new IOException("Canceled");
                    }
                } else {
                    throw new IllegalStateException("codec != null");
                }
            } else {
                throw new IllegalStateException("released");
            }
        }
        okhttp3.c0.c.a(h);
        if (cVar != null) {
            this.f.b(this.e, cVar);
        }
        if (z2) {
            this.f.a(this.e, cVar2);
        }
        if (cVar2 != null) {
            return cVar2;
        }
        if (b0Var != null || ((aVar = this.f8379b) != null && aVar.b())) {
            z3 = false;
        } else {
            this.f8379b = this.h.b();
            z3 = true;
        }
        synchronized (this.f8381d) {
            if (this.m) {
                throw new IOException("Canceled");
            }
            if (z3) {
                List<b0> a2 = this.f8379b.a();
                int size = a2.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    }
                    b0 b0Var2 = a2.get(i5);
                    okhttp3.c0.a.f8265a.a(this.f8381d, this.f8378a, this, b0Var2);
                    if (this.j != null) {
                        cVar2 = this.j;
                        this.f8380c = b0Var2;
                        z2 = true;
                        break;
                    }
                    i5++;
                }
            }
            if (!z2) {
                if (b0Var == null) {
                    b0Var = this.f8379b.c();
                }
                this.f8380c = b0Var;
                this.i = 0;
                cVar2 = new c(this.f8381d, b0Var);
                a(cVar2, false);
            }
        }
        if (z2) {
            this.f.a(this.e, cVar2);
            return cVar2;
        }
        cVar2.a(i, i2, i3, i4, z, this.e, this.f);
        i().a(cVar2.e());
        synchronized (this.f8381d) {
            this.k = true;
            okhttp3.c0.a.f8265a.b(this.f8381d, cVar2);
            if (cVar2.d()) {
                socket = okhttp3.c0.a.f8265a.a(this.f8381d, this.f8378a, this);
                cVar2 = this.j;
            }
        }
        okhttp3.c0.c.a(socket);
        this.f.a(this.e, cVar2);
        return cVar2;
    }

    public void a(boolean z, okhttp3.c0.f.c cVar, long j, IOException iOException) {
        c cVar2;
        Socket a2;
        boolean z2;
        this.f.b(this.e, j);
        synchronized (this.f8381d) {
            if (cVar != null) {
                if (cVar == this.n) {
                    if (!z) {
                        this.j.l++;
                    }
                    cVar2 = this.j;
                    a2 = a(z, false, true);
                    if (this.j != null) {
                        cVar2 = null;
                    }
                    z2 = this.l;
                }
            }
            throw new IllegalStateException("expected " + this.n + " but was " + cVar);
        }
        okhttp3.c0.c.a(a2);
        if (cVar2 != null) {
            this.f.b(this.e, cVar2);
        }
        if (iOException != null) {
            this.f.a(this.e, okhttp3.c0.a.f8265a.a(this.e, iOException));
        } else if (z2) {
            okhttp3.c0.a.f8265a.a(this.e, (IOException) null);
            this.f.a(this.e);
        }
    }

    private Socket a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (z3) {
            this.n = null;
        }
        if (z2) {
            this.l = true;
        }
        c cVar = this.j;
        if (cVar == null) {
            return null;
        }
        if (z) {
            cVar.k = true;
        }
        if (this.n != null) {
            return null;
        }
        if (!this.l && !this.j.k) {
            return null;
        }
        b(this.j);
        if (this.j.n.isEmpty()) {
            this.j.o = System.nanoTime();
            if (okhttp3.c0.a.f8265a.a(this.f8381d, this.j)) {
                socket = this.j.f();
                this.j = null;
                return socket;
            }
        }
        socket = null;
        this.j = null;
        return socket;
    }

    public void a() {
        okhttp3.c0.f.c cVar;
        c cVar2;
        synchronized (this.f8381d) {
            this.m = true;
            cVar = this.n;
            cVar2 = this.j;
        }
        if (cVar != null) {
            cVar.cancel();
        } else if (cVar2 != null) {
            cVar2.b();
        }
    }

    public void a(IOException iOException) {
        c cVar;
        boolean z;
        Socket a2;
        synchronized (this.f8381d) {
            cVar = null;
            if (iOException instanceof StreamResetException) {
                ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                if (errorCode == ErrorCode.REFUSED_STREAM) {
                    int i = this.i + 1;
                    this.i = i;
                    if (i > 1) {
                        this.f8380c = null;
                        z = true;
                    }
                    z = false;
                } else {
                    if (errorCode != ErrorCode.CANCEL) {
                        this.f8380c = null;
                        z = true;
                    }
                    z = false;
                }
            } else {
                if (this.j != null && (!this.j.d() || (iOException instanceof ConnectionShutdownException))) {
                    if (this.j.l == 0) {
                        if (this.f8380c != null && iOException != null) {
                            this.h.a(this.f8380c, iOException);
                        }
                        this.f8380c = null;
                    }
                    z = true;
                }
                z = false;
            }
            c cVar2 = this.j;
            a2 = a(z, false, true);
            if (this.j == null && this.k) {
                cVar = cVar2;
            }
        }
        okhttp3.c0.c.a(a2);
        if (cVar != null) {
            this.f.b(this.e, cVar);
        }
    }

    public void a(c cVar, boolean z) {
        if (this.j == null) {
            this.j = cVar;
            this.k = z;
            cVar.n.add(new a(this, this.g));
            return;
        }
        throw new IllegalStateException();
    }

    public Socket a(c cVar) {
        if (this.n == null && this.j.n.size() == 1) {
            Reference<f> reference = this.j.n.get(0);
            Socket a2 = a(true, false, false);
            this.j = cVar;
            cVar.n.add(reference);
            return a2;
        }
        throw new IllegalStateException();
    }
}
