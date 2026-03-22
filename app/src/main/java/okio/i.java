package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: GzipSource.java */
/* loaded from: classes2.dex */
public final class i implements r {

    /* renamed from: b, reason: collision with root package name */
    private final e f8577b;

    /* renamed from: c, reason: collision with root package name */
    private final Inflater f8578c;

    /* renamed from: d, reason: collision with root package name */
    private final j f8579d;

    /* renamed from: a, reason: collision with root package name */
    private int f8576a = 0;
    private final CRC32 e = new CRC32();

    public i(r rVar) {
        if (rVar != null) {
            this.f8578c = new Inflater(true);
            e a2 = k.a(rVar);
            this.f8577b = a2;
            this.f8579d = new j(a2, this.f8578c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void a(c cVar, long j, long j2) {
        n nVar = cVar.f8572a;
        while (true) {
            int i = nVar.f8597c;
            int i2 = nVar.f8596b;
            if (j < i - i2) {
                break;
            }
            j -= i - i2;
            nVar = nVar.f;
        }
        while (j2 > 0) {
            int min = (int) Math.min(nVar.f8597c - r7, j2);
            this.e.update(nVar.f8595a, (int) (nVar.f8596b + j), min);
            j2 -= min;
            nVar = nVar.f;
            j = 0;
        }
    }

    private void g() throws IOException {
        this.f8577b.e(10L);
        byte f = this.f8577b.a().f(3L);
        boolean z = ((f >> 1) & 1) == 1;
        if (z) {
            a(this.f8577b.a(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.f8577b.readShort());
        this.f8577b.skip(8L);
        if (((f >> 2) & 1) == 1) {
            this.f8577b.e(2L);
            if (z) {
                a(this.f8577b.a(), 0L, 2L);
            }
            long i = this.f8577b.a().i();
            this.f8577b.e(i);
            if (z) {
                a(this.f8577b.a(), 0L, i);
            }
            this.f8577b.skip(i);
        }
        if (((f >> 3) & 1) == 1) {
            long a2 = this.f8577b.a((byte) 0);
            if (a2 != -1) {
                if (z) {
                    a(this.f8577b.a(), 0L, a2 + 1);
                }
                this.f8577b.skip(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((f >> 4) & 1) == 1) {
            long a3 = this.f8577b.a((byte) 0);
            if (a3 != -1) {
                if (z) {
                    a(this.f8577b.a(), 0L, a3 + 1);
                }
                this.f8577b.skip(a3 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            a("FHCRC", this.f8577b.i(), (short) this.e.getValue());
            this.e.reset();
        }
    }

    private void k() throws IOException {
        a("CRC", this.f8577b.h(), (int) this.e.getValue());
        a("ISIZE", this.f8577b.h(), (int) this.f8578c.getBytesWritten());
    }

    @Override // okio.r
    public long b(c cVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        if (this.f8576a == 0) {
            g();
            this.f8576a = 1;
        }
        if (this.f8576a == 1) {
            long j2 = cVar.f8573b;
            long b2 = this.f8579d.b(cVar, j);
            if (b2 != -1) {
                a(cVar, j2, b2);
                return b2;
            }
            this.f8576a = 2;
        }
        if (this.f8576a == 2) {
            k();
            this.f8576a = 3;
            if (!this.f8577b.d()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f8579d.close();
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    @Override // okio.r
    public s b() {
        return this.f8577b.b();
    }
}
