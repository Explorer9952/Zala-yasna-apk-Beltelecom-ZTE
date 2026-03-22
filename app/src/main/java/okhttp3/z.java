package okhttp3;

import java.io.Closeable;
import javax.annotation.Nullable;
import okhttp3.r;

/* compiled from: Response.java */
/* loaded from: classes.dex */
public final class z implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    final x f8557a;

    /* renamed from: b, reason: collision with root package name */
    final Protocol f8558b;

    /* renamed from: c, reason: collision with root package name */
    final int f8559c;

    /* renamed from: d, reason: collision with root package name */
    final String f8560d;

    @Nullable
    final q e;
    final r f;

    @Nullable
    final a0 g;

    @Nullable
    final z h;

    @Nullable
    final z i;

    @Nullable
    final z j;
    final long k;
    final long l;

    @Nullable
    private volatile d m;

    /* compiled from: Response.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        x f8561a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        Protocol f8562b;

        /* renamed from: c, reason: collision with root package name */
        int f8563c;

        /* renamed from: d, reason: collision with root package name */
        String f8564d;

        @Nullable
        q e;
        r.a f;

        @Nullable
        a0 g;

        @Nullable
        z h;

        @Nullable
        z i;

        @Nullable
        z j;
        long k;
        long l;

        public a() {
            this.f8563c = -1;
            this.f = new r.a();
        }

        private void d(z zVar) {
            if (zVar.g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(x xVar) {
            this.f8561a = xVar;
            return this;
        }

        public a b(String str, String str2) {
            this.f.c(str, str2);
            return this;
        }

        public a c(@Nullable z zVar) {
            if (zVar != null) {
                d(zVar);
            }
            this.j = zVar;
            return this;
        }

        public a a(Protocol protocol) {
            this.f8562b = protocol;
            return this;
        }

        public a b(@Nullable z zVar) {
            if (zVar != null) {
                a("networkResponse", zVar);
            }
            this.h = zVar;
            return this;
        }

        public a a(int i) {
            this.f8563c = i;
            return this;
        }

        a(z zVar) {
            this.f8563c = -1;
            this.f8561a = zVar.f8557a;
            this.f8562b = zVar.f8558b;
            this.f8563c = zVar.f8559c;
            this.f8564d = zVar.f8560d;
            this.e = zVar.e;
            this.f = zVar.f.a();
            this.g = zVar.g;
            this.h = zVar.h;
            this.i = zVar.i;
            this.j = zVar.j;
            this.k = zVar.k;
            this.l = zVar.l;
        }

        public a a(String str) {
            this.f8564d = str;
            return this;
        }

        public a b(long j) {
            this.k = j;
            return this;
        }

        public a a(@Nullable q qVar) {
            this.e = qVar;
            return this;
        }

        public a a(String str, String str2) {
            this.f.a(str, str2);
            return this;
        }

        public a a(r rVar) {
            this.f = rVar.a();
            return this;
        }

        public a a(@Nullable a0 a0Var) {
            this.g = a0Var;
            return this;
        }

        public a a(@Nullable z zVar) {
            if (zVar != null) {
                a("cacheResponse", zVar);
            }
            this.i = zVar;
            return this;
        }

        private void a(String str, z zVar) {
            if (zVar.g == null) {
                if (zVar.h == null) {
                    if (zVar.i == null) {
                        if (zVar.j == null) {
                            return;
                        }
                        throw new IllegalArgumentException(str + ".priorResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".cacheResponse != null");
                }
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            throw new IllegalArgumentException(str + ".body != null");
        }

        public a a(long j) {
            this.l = j;
            return this;
        }

        public z a() {
            if (this.f8561a != null) {
                if (this.f8562b != null) {
                    if (this.f8563c >= 0) {
                        if (this.f8564d != null) {
                            return new z(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.f8563c);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }
    }

    z(a aVar) {
        this.f8557a = aVar.f8561a;
        this.f8558b = aVar.f8562b;
        this.f8559c = aVar.f8563c;
        this.f8560d = aVar.f8564d;
        this.e = aVar.e;
        this.f = aVar.f.a();
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    @Nullable
    public String a(String str, @Nullable String str2) {
        String a2 = this.f.a(str);
        return a2 != null ? a2 : str2;
    }

    @Nullable
    public String b(String str) {
        return a(str, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a0 a0Var = this.g;
        if (a0Var != null) {
            a0Var.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    @Nullable
    public a0 g() {
        return this.g;
    }

    public d k() {
        d dVar = this.m;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.f);
        this.m = a2;
        return a2;
    }

    public int l() {
        return this.f8559c;
    }

    @Nullable
    public q m() {
        return this.e;
    }

    public r n() {
        return this.f;
    }

    public String o() {
        return this.f8560d;
    }

    public a p() {
        return new a(this);
    }

    @Nullable
    public z q() {
        return this.j;
    }

    public long r() {
        return this.l;
    }

    public x s() {
        return this.f8557a;
    }

    public long t() {
        return this.k;
    }

    public String toString() {
        return "Response{protocol=" + this.f8558b + ", code=" + this.f8559c + ", message=" + this.f8560d + ", url=" + this.f8557a.g() + '}';
    }
}
