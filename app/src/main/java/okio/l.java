package okio;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealBufferedSink.java */
/* loaded from: classes2.dex */
public final class l implements d {

    /* renamed from: a, reason: collision with root package name */
    public final c f8589a = new c();

    /* renamed from: b, reason: collision with root package name */
    public final q f8590b;

    /* renamed from: c, reason: collision with root package name */
    boolean f8591c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(q qVar) {
        if (qVar != null) {
            this.f8590b = qVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    @Override // okio.d
    public c a() {
        return this.f8589a;
    }

    @Override // okio.q
    public s b() {
        return this.f8590b.b();
    }

    @Override // okio.d
    public d c(long j) throws IOException {
        if (!this.f8591c) {
            this.f8589a.c(j);
            return e();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f8591c) {
            return;
        }
        try {
            if (this.f8589a.f8573b > 0) {
                this.f8590b.a(this.f8589a, this.f8589a.f8573b);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f8590b.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f8591c = true;
        if (th == null) {
            return;
        }
        t.a(th);
        throw null;
    }

    @Override // okio.d
    public d e() throws IOException {
        if (!this.f8591c) {
            long l = this.f8589a.l();
            if (l > 0) {
                this.f8590b.a(this.f8589a, l);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.d, okio.q, java.io.Flushable
    public void flush() throws IOException {
        if (!this.f8591c) {
            c cVar = this.f8589a;
            long j = cVar.f8573b;
            if (j > 0) {
                this.f8590b.a(cVar, j);
            }
            this.f8590b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f8591c;
    }

    public String toString() {
        return "buffer(" + this.f8590b + ")";
    }

    @Override // okio.d
    public d write(byte[] bArr) throws IOException {
        if (!this.f8591c) {
            this.f8589a.write(bArr);
            e();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.d
    public d writeByte(int i) throws IOException {
        if (!this.f8591c) {
            this.f8589a.writeByte(i);
            return e();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.d
    public d writeInt(int i) throws IOException {
        if (!this.f8591c) {
            this.f8589a.writeInt(i);
            return e();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.d
    public d writeShort(int i) throws IOException {
        if (!this.f8591c) {
            this.f8589a.writeShort(i);
            e();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.q
    public void a(c cVar, long j) throws IOException {
        if (!this.f8591c) {
            this.f8589a.a(cVar, j);
            e();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.d
    public d write(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f8591c) {
            this.f8589a.write(bArr, i, i2);
            e();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.d
    public d a(String str) throws IOException {
        if (!this.f8591c) {
            this.f8589a.a(str);
            return e();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f8591c) {
            int write = this.f8589a.write(byteBuffer);
            e();
            return write;
        }
        throw new IllegalStateException("closed");
    }
}
