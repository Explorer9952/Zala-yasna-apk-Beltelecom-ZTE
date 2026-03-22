package okhttp3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealCall.java */
/* loaded from: classes.dex */
public final class w implements e {

    /* renamed from: a, reason: collision with root package name */
    final v f8539a;

    /* renamed from: b, reason: collision with root package name */
    final okhttp3.c0.f.j f8540b;

    /* renamed from: c, reason: collision with root package name */
    final okio.a f8541c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private p f8542d;
    final x e;
    final boolean f;
    private boolean g;

    /* compiled from: RealCall.java */
    /* loaded from: classes2.dex */
    class a extends okio.a {
        a() {
        }

        @Override // okio.a
        protected void i() {
            w.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RealCall.java */
    /* loaded from: classes2.dex */
    public final class b extends okhttp3.c0.b {

        /* renamed from: b, reason: collision with root package name */
        private final f f8543b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ w f8544c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    this.f8544c.f8542d.a(this.f8544c, interruptedIOException);
                    this.f8543b.a(this.f8544c, interruptedIOException);
                    this.f8544c.f8539a.j().a(this);
                }
            } catch (Throwable th) {
                this.f8544c.f8539a.j().a(this);
                throw th;
            }
        }

        @Override // okhttp3.c0.b
        protected void b() {
            IOException e;
            z b2;
            this.f8544c.f8541c.g();
            boolean z = true;
            try {
                try {
                    b2 = this.f8544c.b();
                } catch (IOException e2) {
                    e = e2;
                    z = false;
                }
                try {
                    if (this.f8544c.f8540b.b()) {
                        this.f8543b.a(this.f8544c, new IOException("Canceled"));
                    } else {
                        this.f8543b.a(this.f8544c, b2);
                    }
                } catch (IOException e3) {
                    e = e3;
                    IOException a2 = this.f8544c.a(e);
                    if (!z) {
                        this.f8544c.f8542d.a(this.f8544c, a2);
                        this.f8543b.a(this.f8544c, a2);
                    } else {
                        okhttp3.c0.h.f.c().a(4, "Callback failure for " + this.f8544c.e(), a2);
                    }
                }
            } finally {
                this.f8544c.f8539a.j().a(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public w c() {
            return this.f8544c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String d() {
            return this.f8544c.e.g().g();
        }
    }

    private w(v vVar, x xVar, boolean z) {
        this.f8539a = vVar;
        this.e = xVar;
        this.f = z;
        this.f8540b = new okhttp3.c0.f.j(vVar, z);
        a aVar = new a();
        this.f8541c = aVar;
        aVar.a(vVar.c(), TimeUnit.MILLISECONDS);
    }

    private void f() {
        this.f8540b.a(okhttp3.c0.h.f.c().a("response.body().close()"));
    }

    z b() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f8539a.p());
        arrayList.add(this.f8540b);
        arrayList.add(new okhttp3.c0.f.a(this.f8539a.i()));
        arrayList.add(new okhttp3.c0.e.a(this.f8539a.q()));
        arrayList.add(new okhttp3.internal.connection.a(this.f8539a));
        if (!this.f) {
            arrayList.addAll(this.f8539a.r());
        }
        arrayList.add(new okhttp3.c0.f.b(this.f));
        return new okhttp3.c0.f.g(arrayList, null, null, null, 0, this.e, this, this.f8542d, this.f8539a.e(), this.f8539a.y(), this.f8539a.C()).a(this.e);
    }

    public boolean c() {
        return this.f8540b.b();
    }

    String d() {
        return this.e.g().l();
    }

    String e() {
        StringBuilder sb = new StringBuilder();
        sb.append(c() ? "canceled " : "");
        sb.append(this.f ? "web socket" : "call");
        sb.append(" to ");
        sb.append(d());
        return sb.toString();
    }

    @Override // okhttp3.e
    public z g() throws IOException {
        synchronized (this) {
            if (!this.g) {
                this.g = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        f();
        this.f8541c.g();
        this.f8542d.b(this);
        try {
            try {
                this.f8539a.j().a(this);
                z b2 = b();
                if (b2 != null) {
                    return b2;
                }
                throw new IOException("Canceled");
            } catch (IOException e) {
                IOException a2 = a(e);
                this.f8542d.a(this, a2);
                throw a2;
            }
        } finally {
            this.f8539a.j().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static w a(v vVar, x xVar, boolean z) {
        w wVar = new w(vVar, xVar, z);
        wVar.f8542d = vVar.l().a(wVar);
        return wVar;
    }

    public w clone() {
        return a(this.f8539a, this.e, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public IOException a(@Nullable IOException iOException) {
        if (!this.f8541c.h()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void a() {
        this.f8540b.a();
    }
}
