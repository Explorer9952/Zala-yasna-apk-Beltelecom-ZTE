package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: InflaterSource.java */
/* loaded from: classes2.dex */
public final class j implements r {

    /* renamed from: a, reason: collision with root package name */
    private final e f8580a;

    /* renamed from: b, reason: collision with root package name */
    private final Inflater f8581b;

    /* renamed from: c, reason: collision with root package name */
    private int f8582c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f8583d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.f8580a = eVar;
            this.f8581b = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    private void k() throws IOException {
        int i = this.f8582c;
        if (i == 0) {
            return;
        }
        int remaining = i - this.f8581b.getRemaining();
        this.f8582c -= remaining;
        this.f8580a.skip(remaining);
    }

    @Override // okio.r
    public long b(c cVar, long j) throws IOException {
        boolean g;
        if (j >= 0) {
            if (this.f8583d) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return 0L;
            }
            do {
                g = g();
                try {
                    n b2 = cVar.b(1);
                    int inflate = this.f8581b.inflate(b2.f8595a, b2.f8597c, (int) Math.min(j, 8192 - b2.f8597c));
                    if (inflate > 0) {
                        b2.f8597c += inflate;
                        long j2 = inflate;
                        cVar.f8573b += j2;
                        return j2;
                    }
                    if (!this.f8581b.finished() && !this.f8581b.needsDictionary()) {
                    }
                    k();
                    if (b2.f8596b != b2.f8597c) {
                        return -1L;
                    }
                    cVar.f8572a = b2.b();
                    o.a(b2);
                    return -1L;
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            } while (!g);
            throw new EOFException("source exhausted prematurely");
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f8583d) {
            return;
        }
        this.f8581b.end();
        this.f8583d = true;
        this.f8580a.close();
    }

    public final boolean g() throws IOException {
        if (!this.f8581b.needsInput()) {
            return false;
        }
        k();
        if (this.f8581b.getRemaining() == 0) {
            if (this.f8580a.d()) {
                return true;
            }
            n nVar = this.f8580a.a().f8572a;
            int i = nVar.f8597c;
            int i2 = nVar.f8596b;
            int i3 = i - i2;
            this.f8582c = i3;
            this.f8581b.setInput(nVar.f8595a, i2, i3);
            return false;
        }
        throw new IllegalStateException("?");
    }

    @Override // okio.r
    public s b() {
        return this.f8580a.b();
    }
}
