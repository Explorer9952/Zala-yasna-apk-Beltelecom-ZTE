package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* compiled from: ResponseBody.java */
/* loaded from: classes.dex */
public abstract class a0 implements Closeable {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResponseBody.java */
    /* loaded from: classes.dex */
    public class a extends a0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f8257a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f8258b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ okio.e f8259c;

        a(u uVar, long j, okio.e eVar) {
            this.f8257a = uVar;
            this.f8258b = j;
            this.f8259c = eVar;
        }

        @Override // okhttp3.a0
        public long k() {
            return this.f8258b;
        }

        @Override // okhttp3.a0
        @Nullable
        public u l() {
            return this.f8257a;
        }

        @Override // okhttp3.a0
        public okio.e m() {
            return this.f8259c;
        }
    }

    public static a0 a(@Nullable u uVar, byte[] bArr) {
        okio.c cVar = new okio.c();
        cVar.write(bArr);
        return a(uVar, bArr.length, cVar);
    }

    private Charset o() {
        u l = l();
        return l != null ? l.a(okhttp3.c0.c.i) : okhttp3.c0.c.i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        okhttp3.c0.c.a(m());
    }

    public final byte[] g() throws IOException {
        long k = k();
        if (k <= 2147483647L) {
            okio.e m = m();
            try {
                byte[] c2 = m.c();
                okhttp3.c0.c.a(m);
                if (k == -1 || k == c2.length) {
                    return c2;
                }
                throw new IOException("Content-Length (" + k + ") and stream length (" + c2.length + ") disagree");
            } catch (Throwable th) {
                okhttp3.c0.c.a(m);
                throw th;
            }
        }
        throw new IOException("Cannot buffer entire body for content length: " + k);
    }

    public abstract long k();

    @Nullable
    public abstract u l();

    public abstract okio.e m();

    public final String n() throws IOException {
        okio.e m = m();
        try {
            return m.a(okhttp3.c0.c.a(m, o()));
        } finally {
            okhttp3.c0.c.a(m);
        }
    }

    public static a0 a(@Nullable u uVar, long j, okio.e eVar) {
        if (eVar != null) {
            return new a(uVar, j, eVar);
        }
        throw new NullPointerException("source == null");
    }
}
