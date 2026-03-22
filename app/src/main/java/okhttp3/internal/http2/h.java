package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.b;

/* compiled from: Http2Writer.java */
/* loaded from: classes2.dex */
final class h implements Closeable {
    private static final Logger g = Logger.getLogger(c.class.getName());

    /* renamed from: a, reason: collision with root package name */
    private final okio.d f8465a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f8466b;

    /* renamed from: c, reason: collision with root package name */
    private final okio.c f8467c;

    /* renamed from: d, reason: collision with root package name */
    private int f8468d;
    private boolean e;
    final b.C0430b f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(okio.d dVar, boolean z) {
        this.f8465a = dVar;
        this.f8466b = z;
        okio.c cVar = new okio.c();
        this.f8467c = cVar;
        this.f = new b.C0430b(cVar);
        this.f8468d = 16384;
    }

    public synchronized void a(k kVar) throws IOException {
        if (!this.e) {
            this.f8468d = kVar.c(this.f8468d);
            if (kVar.b() != -1) {
                this.f.a(kVar.b());
            }
            a(0, 0, (byte) 4, (byte) 1);
            this.f8465a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void b(k kVar) throws IOException {
        if (!this.e) {
            int i = 0;
            a(0, kVar.d() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (kVar.d(i)) {
                    this.f8465a.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.f8465a.writeInt(kVar.a(i));
                }
                i++;
            }
            this.f8465a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.e = true;
        this.f8465a.close();
    }

    public synchronized void flush() throws IOException {
        if (!this.e) {
            this.f8465a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void g() throws IOException {
        if (!this.e) {
            if (this.f8466b) {
                if (g.isLoggable(Level.FINE)) {
                    g.fine(okhttp3.c0.c.a(">> CONNECTION %s", c.f8397a.hex()));
                }
                this.f8465a.write(c.f8397a.toByteArray());
                this.f8465a.flush();
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public int k() {
        return this.f8468d;
    }

    public synchronized void a(int i, int i2, List<a> list) throws IOException {
        if (!this.e) {
            this.f.a(list);
            long p = this.f8467c.p();
            int min = (int) Math.min(this.f8468d - 4, p);
            long j = min;
            a(i, min + 4, (byte) 5, p == j ? (byte) 4 : (byte) 0);
            this.f8465a.writeInt(i2 & Integer.MAX_VALUE);
            this.f8465a.a(this.f8467c, j);
            if (p > j) {
                b(i, p - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    private void b(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min(this.f8468d, j);
            long j2 = min;
            j -= j2;
            a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.f8465a.a(this.f8467c, j2);
        }
    }

    public synchronized void a(boolean z, int i, int i2, List<a> list) throws IOException {
        if (!this.e) {
            a(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i, ErrorCode errorCode) throws IOException {
        if (!this.e) {
            if (errorCode.httpCode != -1) {
                a(i, 4, (byte) 3, (byte) 0);
                this.f8465a.writeInt(errorCode.httpCode);
                this.f8465a.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z, int i, okio.c cVar, int i2) throws IOException {
        if (!this.e) {
            a(i, z ? (byte) 1 : (byte) 0, cVar, i2);
        } else {
            throw new IOException("closed");
        }
    }

    void a(int i, byte b2, okio.c cVar, int i2) throws IOException {
        a(i, i2, (byte) 0, b2);
        if (i2 > 0) {
            this.f8465a.a(cVar, i2);
        }
    }

    public synchronized void a(boolean z, int i, int i2) throws IOException {
        if (!this.e) {
            a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.f8465a.writeInt(i);
            this.f8465a.writeInt(i2);
            this.f8465a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (!this.e) {
            if (errorCode.httpCode != -1) {
                a(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f8465a.writeInt(i);
                this.f8465a.writeInt(errorCode.httpCode);
                if (bArr.length > 0) {
                    this.f8465a.write(bArr);
                }
                this.f8465a.flush();
            } else {
                c.a("errorCode.httpCode == -1", new Object[0]);
                throw null;
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i, long j) throws IOException {
        if (this.e) {
            throw new IOException("closed");
        }
        if (j != 0 && j <= 2147483647L) {
            a(i, 4, (byte) 8, (byte) 0);
            this.f8465a.writeInt((int) j);
            this.f8465a.flush();
        } else {
            c.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            throw null;
        }
    }

    public void a(int i, int i2, byte b2, byte b3) throws IOException {
        if (g.isLoggable(Level.FINE)) {
            g.fine(c.a(false, i, i2, b2, b3));
        }
        int i3 = this.f8468d;
        if (i2 > i3) {
            c.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
            throw null;
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            c.a("reserved bit set: %s", Integer.valueOf(i));
            throw null;
        }
        a(this.f8465a, i2);
        this.f8465a.writeByte(b2 & 255);
        this.f8465a.writeByte(b3 & 255);
        this.f8465a.writeInt(i & Integer.MAX_VALUE);
    }

    private static void a(okio.d dVar, int i) throws IOException {
        dVar.writeByte((i >>> 16) & 255);
        dVar.writeByte((i >>> 8) & 255);
        dVar.writeByte(i & 255);
    }

    void a(boolean z, int i, List<a> list) throws IOException {
        if (!this.e) {
            this.f.a(list);
            long p = this.f8467c.p();
            int min = (int) Math.min(this.f8468d, p);
            long j = min;
            byte b2 = p == j ? (byte) 4 : (byte) 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            a(i, min, (byte) 1, b2);
            this.f8465a.a(this.f8467c, j);
            if (p > j) {
                b(i, p - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
