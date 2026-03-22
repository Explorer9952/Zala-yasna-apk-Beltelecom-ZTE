package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealBufferedSource.java */
/* loaded from: classes2.dex */
public final class m implements e {

    /* renamed from: a, reason: collision with root package name */
    public final c f8592a = new c();

    /* renamed from: b, reason: collision with root package name */
    public final r f8593b;

    /* renamed from: c, reason: collision with root package name */
    boolean f8594c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(r rVar) {
        if (rVar != null) {
            this.f8593b = rVar;
            return;
        }
        throw new NullPointerException("source == null");
    }

    @Override // okio.e, okio.d
    public c a() {
        return this.f8592a;
    }

    @Override // okio.r
    public long b(c cVar, long j) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j >= 0) {
            if (!this.f8594c) {
                c cVar2 = this.f8592a;
                if (cVar2.f8573b == 0 && this.f8593b.b(cVar2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1L;
                }
                return this.f8592a.b(cVar, Math.min(j, this.f8592a.f8573b));
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // okio.e
    public byte[] c() throws IOException {
        this.f8592a.a(this.f8593b);
        return this.f8592a.c();
    }

    @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f8594c) {
            return;
        }
        this.f8594c = true;
        this.f8593b.close();
        this.f8592a.k();
    }

    @Override // okio.e
    public boolean d() throws IOException {
        if (this.f8594c) {
            throw new IllegalStateException("closed");
        }
        return this.f8592a.d() && this.f8593b.b(this.f8592a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
    }

    @Override // okio.e
    public void e(long j) throws IOException {
        if (!request(j)) {
            throw new EOFException();
        }
    }

    @Override // okio.e
    public String f() throws IOException {
        return b(Long.MAX_VALUE);
    }

    @Override // okio.e
    public int h() throws IOException {
        e(4L);
        return this.f8592a.h();
    }

    @Override // okio.e
    public short i() throws IOException {
        e(2L);
        return this.f8592a.i();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f8594c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // okio.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long j() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.e(r0)
            r0 = 0
            r1 = 0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.request(r3)
            if (r3 == 0) goto L4a
            okio.c r3 = r6.f8592a
            long r4 = (long) r1
            byte r3 = r3.f(r4)
            r4 = 48
            if (r3 < r4) goto L1f
            r4 = 57
            if (r3 <= r4) goto L30
        L1f:
            r4 = 97
            if (r3 < r4) goto L27
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L30
        L27:
            r4 = 65
            if (r3 < r4) goto L32
            r4 = 70
            if (r3 <= r4) goto L30
            goto L32
        L30:
            r1 = r2
            goto L7
        L32:
            if (r1 == 0) goto L35
            goto L4a
        L35:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L4a:
            okio.c r0 = r6.f8592a
            long r0 = r0.j()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.m.j():long");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        c cVar = this.f8592a;
        if (cVar.f8573b == 0 && this.f8593b.b(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.f8592a.read(byteBuffer);
    }

    @Override // okio.e
    public byte readByte() throws IOException {
        e(1L);
        return this.f8592a.readByte();
    }

    @Override // okio.e
    public void readFully(byte[] bArr) throws IOException {
        try {
            e(bArr.length);
            this.f8592a.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                c cVar = this.f8592a;
                long j = cVar.f8573b;
                if (j <= 0) {
                    throw e;
                }
                int read = cVar.read(bArr, i, (int) j);
                if (read == -1) {
                    throw new AssertionError();
                }
                i += read;
            }
        }
    }

    @Override // okio.e
    public int readInt() throws IOException {
        e(4L);
        return this.f8592a.readInt();
    }

    @Override // okio.e
    public short readShort() throws IOException {
        e(2L);
        return this.f8592a.readShort();
    }

    @Override // okio.e
    public boolean request(long j) throws IOException {
        c cVar;
        if (j >= 0) {
            if (this.f8594c) {
                throw new IllegalStateException("closed");
            }
            do {
                cVar = this.f8592a;
                if (cVar.f8573b >= j) {
                    return true;
                }
            } while (this.f8593b.b(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
            return false;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // okio.e
    public void skip(long j) throws IOException {
        if (this.f8594c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            c cVar = this.f8592a;
            if (cVar.f8573b == 0 && this.f8593b.b(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f8592a.p());
            this.f8592a.skip(min);
            j -= min;
        }
    }

    public String toString() {
        return "buffer(" + this.f8593b + ")";
    }

    @Override // okio.e
    public ByteString a(long j) throws IOException {
        e(j);
        return this.f8592a.a(j);
    }

    @Override // okio.e
    public String a(Charset charset) throws IOException {
        if (charset != null) {
            this.f8592a.a(this.f8593b);
            return this.f8592a.a(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // okio.e
    public byte[] d(long j) throws IOException {
        e(j);
        return this.f8592a.d(j);
    }

    @Override // okio.e
    public long a(byte b2) throws IOException {
        return a(b2, 0L, Long.MAX_VALUE);
    }

    public long a(byte b2, long j, long j2) throws IOException {
        if (this.f8594c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long a2 = this.f8592a.a(b2, j, j2);
            if (a2 == -1) {
                c cVar = this.f8592a;
                long j3 = cVar.f8573b;
                if (j3 >= j2 || this.f8593b.b(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    break;
                }
                j = Math.max(j, j3);
            } else {
                return a2;
            }
        }
        return -1L;
    }

    @Override // okio.e
    public String b(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long a2 = a((byte) 10, 0L, j2);
            if (a2 != -1) {
                return this.f8592a.h(a2);
            }
            if (j2 < Long.MAX_VALUE && request(j2) && this.f8592a.f(j2 - 1) == 13 && request(1 + j2) && this.f8592a.f(j2) == 10) {
                return this.f8592a.h(j2);
            }
            c cVar = new c();
            c cVar2 = this.f8592a;
            cVar2.a(cVar, 0L, Math.min(32L, cVar2.p()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f8592a.p(), j) + " content=" + cVar.m().hex() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    @Override // okio.e
    public boolean a(long j, ByteString byteString) throws IOException {
        return a(j, byteString, 0, byteString.size());
    }

    public boolean a(long j, ByteString byteString, int i, int i2) throws IOException {
        if (!this.f8594c) {
            if (j < 0 || i < 0 || i2 < 0 || byteString.size() - i < i2) {
                return false;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = i3 + j;
                if (!request(1 + j2) || this.f8592a.f(j2) != byteString.getByte(i + i3)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.r
    public s b() {
        return this.f8593b.b();
    }
}
