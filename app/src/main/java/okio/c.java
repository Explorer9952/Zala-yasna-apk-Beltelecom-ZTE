package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.zte.ucs.tvcall.Commons;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* compiled from: Buffer.java */
/* loaded from: classes.dex */
public final class c implements e, d, Cloneable, ByteChannel {

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f8571c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    n f8572a;

    /* renamed from: b, reason: collision with root package name */
    long f8573b;

    @Override // okio.e, okio.d
    public c a() {
        return this;
    }

    @Override // okio.d
    public /* bridge */ /* synthetic */ d a(String str) throws IOException {
        a(str);
        return this;
    }

    @Override // okio.e
    public String b(long j) throws EOFException {
        if (j >= 0) {
            long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
            long a2 = a((byte) 10, 0L, j2);
            if (a2 != -1) {
                return h(a2);
            }
            if (j2 < p() && f(j2 - 1) == 13 && f(j2) == 10) {
                return h(j2);
            }
            c cVar = new c();
            a(cVar, 0L, Math.min(32L, p()));
            throw new EOFException("\\n not found: limit=" + Math.min(p(), j) + " content=" + cVar.m().hex() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    @Override // okio.d
    public /* bridge */ /* synthetic */ d c(long j) throws IOException {
        c(j);
        return this;
    }

    @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.e
    public boolean d() {
        return this.f8573b == 0;
    }

    @Override // okio.d
    public c e() {
        return this;
    }

    @Override // okio.d
    public /* bridge */ /* synthetic */ d e() throws IOException {
        e();
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        long j = this.f8573b;
        if (j != cVar.f8573b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        n nVar = this.f8572a;
        n nVar2 = cVar.f8572a;
        int i = nVar.f8596b;
        int i2 = nVar2.f8596b;
        while (j2 < this.f8573b) {
            long min = Math.min(nVar.f8597c - i, nVar2.f8597c - i2);
            int i3 = 0;
            while (i3 < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (nVar.f8595a[i] != nVar2.f8595a[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == nVar.f8597c) {
                nVar = nVar.f;
                i = nVar.f8596b;
            }
            if (i2 == nVar2.f8597c) {
                nVar2 = nVar2.f;
                i2 = nVar2.f8596b;
            }
            j2 += min;
        }
        return true;
    }

    public final byte f(long j) {
        int i;
        t.a(this.f8573b, j, 1L);
        long j2 = this.f8573b;
        if (j2 - j > j) {
            n nVar = this.f8572a;
            while (true) {
                int i2 = nVar.f8597c;
                int i3 = nVar.f8596b;
                long j3 = i2 - i3;
                if (j < j3) {
                    return nVar.f8595a[i3 + ((int) j)];
                }
                j -= j3;
                nVar = nVar.f;
            }
        } else {
            long j4 = j - j2;
            n nVar2 = this.f8572a;
            do {
                nVar2 = nVar2.g;
                int i4 = nVar2.f8597c;
                i = nVar2.f8596b;
                j4 += i4 - i;
            } while (j4 < 0);
            return nVar2.f8595a[i + ((int) j4)];
        }
    }

    @Override // okio.d, okio.q, java.io.Flushable
    public void flush() {
    }

    public String g(long j) throws EOFException {
        return a(j, t.f8607a);
    }

    @Override // okio.e
    public int h() {
        return t.a(readInt());
    }

    public int hashCode() {
        n nVar = this.f8572a;
        if (nVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = nVar.f8597c;
            for (int i3 = nVar.f8596b; i3 < i2; i3++) {
                i = (i * 31) + nVar.f8595a[i3];
            }
            nVar = nVar.f;
        } while (nVar != this.f8572a);
        return i;
    }

    @Override // okio.e
    public short i() {
        return t.a(readShort());
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a3 A[EDGE_INSN: B:41:0x00a3->B:38:0x00a3 BREAK  A[LOOP:0: B:4:0x000b->B:40:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009b  */
    @Override // okio.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long j() {
        /*
            r15 = this;
            long r0 = r15.f8573b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Laa
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            okio.n r6 = r15.f8572a
            byte[] r7 = r6.f8595a
            int r8 = r6.f8596b
            int r9 = r6.f8597c
        L13:
            if (r8 >= r9) goto L8f
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3a
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
        L2c:
            int r11 = r11 + 10
            goto L3a
        L2f:
            r11 = 65
            if (r10 < r11) goto L70
            r11 = 70
            if (r10 > r11) goto L70
            int r11 = r10 + (-65)
            goto L2c
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L4a:
            okio.c r0 = new okio.c
            r0.<init>()
            r0.c(r4)
            r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.n()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L70:
            if (r0 == 0) goto L74
            r1 = 1
            goto L8f
        L74:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L8f:
            if (r8 != r9) goto L9b
            okio.n r7 = r6.b()
            r15.f8572a = r7
            okio.o.a(r6)
            goto L9d
        L9b:
            r6.f8596b = r8
        L9d:
            if (r1 != 0) goto La3
            okio.n r6 = r15.f8572a
            if (r6 != 0) goto Lb
        La3:
            long r1 = r15.f8573b
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.f8573b = r1
            return r4
        Laa:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            goto Lb3
        Lb2:
            throw r0
        Lb3:
            goto Lb2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.c.j():long");
    }

    public final void k() {
        try {
            skip(this.f8573b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final long l() {
        long j = this.f8573b;
        if (j == 0) {
            return 0L;
        }
        n nVar = this.f8572a.g;
        return (nVar.f8597c >= 8192 || !nVar.e) ? j : j - (r3 - nVar.f8596b);
    }

    public ByteString m() {
        return new ByteString(c());
    }

    public String n() {
        try {
            return a(this.f8573b, t.f8607a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public int o() throws EOFException {
        int i;
        int i2;
        int i3;
        if (this.f8573b != 0) {
            byte f = f(0L);
            if ((f & 128) == 0) {
                i = f & Byte.MAX_VALUE;
                i2 = 1;
                i3 = 0;
            } else if ((f & 224) == 192) {
                i = f & 31;
                i2 = 2;
                i3 = Commons.MSG_MCSP_INIT_SUCCESS;
            } else if ((f & 240) == 224) {
                i = f & 15;
                i2 = 3;
                i3 = LVBuffer.MAX_STRING_LENGTH;
            } else {
                if ((f & 248) != 240) {
                    skip(1L);
                    return 65533;
                }
                i = f & 7;
                i2 = 4;
                i3 = 65536;
            }
            long j = i2;
            if (this.f8573b >= j) {
                for (int i4 = 1; i4 < i2; i4++) {
                    long j2 = i4;
                    byte f2 = f(j2);
                    if ((f2 & 192) != 128) {
                        skip(j2);
                        return 65533;
                    }
                    i = (i << 6) | (f2 & 63);
                }
                skip(j);
                if (i > 1114111) {
                    return 65533;
                }
                if ((i < 55296 || i > 57343) && i >= i3) {
                    return i;
                }
                return 65533;
            }
            throw new EOFException("size < " + i2 + ": " + this.f8573b + " (to read code point prefixed 0x" + Integer.toHexString(f) + ")");
        }
        throw new EOFException();
    }

    public final long p() {
        return this.f8573b;
    }

    public final ByteString q() {
        long j = this.f8573b;
        if (j <= 2147483647L) {
            return a((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f8573b);
    }

    public int read(byte[] bArr, int i, int i2) {
        t.a(bArr.length, i, i2);
        n nVar = this.f8572a;
        if (nVar == null) {
            return -1;
        }
        int min = Math.min(i2, nVar.f8597c - nVar.f8596b);
        System.arraycopy(nVar.f8595a, nVar.f8596b, bArr, i, min);
        int i3 = nVar.f8596b + min;
        nVar.f8596b = i3;
        this.f8573b -= min;
        if (i3 == nVar.f8597c) {
            this.f8572a = nVar.b();
            o.a(nVar);
        }
        return min;
    }

    @Override // okio.e
    public byte readByte() {
        long j = this.f8573b;
        if (j != 0) {
            n nVar = this.f8572a;
            int i = nVar.f8596b;
            int i2 = nVar.f8597c;
            int i3 = i + 1;
            byte b2 = nVar.f8595a[i];
            this.f8573b = j - 1;
            if (i3 == i2) {
                this.f8572a = nVar.b();
                o.a(nVar);
            } else {
                nVar.f8596b = i3;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // okio.e
    public void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read == -1) {
                throw new EOFException();
            }
            i += read;
        }
    }

    @Override // okio.e
    public int readInt() {
        long j = this.f8573b;
        if (j >= 4) {
            n nVar = this.f8572a;
            int i = nVar.f8596b;
            int i2 = nVar.f8597c;
            if (i2 - i < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = nVar.f8595a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i6 = i4 + 1;
            int i7 = i5 | ((bArr[i4] & 255) << 8);
            int i8 = i6 + 1;
            int i9 = i7 | (bArr[i6] & 255);
            this.f8573b = j - 4;
            if (i8 == i2) {
                this.f8572a = nVar.b();
                o.a(nVar);
            } else {
                nVar.f8596b = i8;
            }
            return i9;
        }
        throw new IllegalStateException("size < 4: " + this.f8573b);
    }

    @Override // okio.e
    public short readShort() {
        long j = this.f8573b;
        if (j >= 2) {
            n nVar = this.f8572a;
            int i = nVar.f8596b;
            int i2 = nVar.f8597c;
            if (i2 - i < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = nVar.f8595a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.f8573b = j - 2;
            if (i4 == i2) {
                this.f8572a = nVar.b();
                o.a(nVar);
            } else {
                nVar.f8596b = i4;
            }
            return (short) i5;
        }
        throw new IllegalStateException("size < 2: " + this.f8573b);
    }

    @Override // okio.e
    public boolean request(long j) {
        return this.f8573b >= j;
    }

    @Override // okio.e
    public void skip(long j) throws EOFException {
        while (j > 0) {
            if (this.f8572a != null) {
                int min = (int) Math.min(j, r0.f8597c - r0.f8596b);
                long j2 = min;
                this.f8573b -= j2;
                j -= j2;
                n nVar = this.f8572a;
                int i = nVar.f8596b + min;
                nVar.f8596b = i;
                if (i == nVar.f8597c) {
                    this.f8572a = nVar.b();
                    o.a(nVar);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public String toString() {
        return q().toString();
    }

    @Override // okio.d
    public /* bridge */ /* synthetic */ d write(byte[] bArr) throws IOException {
        write(bArr);
        return this;
    }

    @Override // okio.d
    public /* bridge */ /* synthetic */ d writeByte(int i) throws IOException {
        writeByte(i);
        return this;
    }

    @Override // okio.d
    public /* bridge */ /* synthetic */ d writeInt(int i) throws IOException {
        writeInt(i);
        return this;
    }

    @Override // okio.d
    public /* bridge */ /* synthetic */ d writeShort(int i) throws IOException {
        writeShort(i);
        return this;
    }

    public final c a(c cVar, long j, long j2) {
        if (cVar != null) {
            t.a(this.f8573b, j, j2);
            if (j2 == 0) {
                return this;
            }
            cVar.f8573b += j2;
            n nVar = this.f8572a;
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
                n c2 = nVar.c();
                int i3 = (int) (c2.f8596b + j);
                c2.f8596b = i3;
                c2.f8597c = Math.min(i3 + ((int) j2), c2.f8597c);
                n nVar2 = cVar.f8572a;
                if (nVar2 == null) {
                    c2.g = c2;
                    c2.f = c2;
                    cVar.f8572a = c2;
                } else {
                    nVar2.g.a(c2);
                }
                j2 -= c2.f8597c - c2.f8596b;
                nVar = nVar.f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // okio.e
    public byte[] c() {
        try {
            return d(this.f8573b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public c clone() {
        c cVar = new c();
        if (this.f8573b == 0) {
            return cVar;
        }
        n c2 = this.f8572a.c();
        cVar.f8572a = c2;
        c2.g = c2;
        c2.f = c2;
        n nVar = this.f8572a;
        while (true) {
            nVar = nVar.f;
            if (nVar != this.f8572a) {
                cVar.f8572a.g.a(nVar.c());
            } else {
                cVar.f8573b = this.f8573b;
                return cVar;
            }
        }
    }

    @Override // okio.e
    public byte[] d(long j) throws EOFException {
        t.a(this.f8573b, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // okio.e
    public void e(long j) throws EOFException {
        if (this.f8573b < j) {
            throw new EOFException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (f(j2) == 13) {
                String g = g(j2);
                skip(2L);
                return g;
            }
        }
        String g2 = g(j);
        skip(1L);
        return g2;
    }

    @Override // okio.d
    public /* bridge */ /* synthetic */ d write(byte[] bArr, int i, int i2) throws IOException {
        write(bArr, i, i2);
        return this;
    }

    @Override // okio.d
    public c writeByte(int i) {
        n b2 = b(1);
        byte[] bArr = b2.f8595a;
        int i2 = b2.f8597c;
        b2.f8597c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f8573b++;
        return this;
    }

    @Override // okio.d
    public c writeInt(int i) {
        n b2 = b(4);
        byte[] bArr = b2.f8595a;
        int i2 = b2.f8597c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        b2.f8597c = i5 + 1;
        this.f8573b += 4;
        return this;
    }

    @Override // okio.d
    public c writeShort(int i) {
        n b2 = b(2);
        byte[] bArr = b2.f8595a;
        int i2 = b2.f8597c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        b2.f8597c = i3 + 1;
        this.f8573b += 2;
        return this;
    }

    @Override // okio.d
    public c write(byte[] bArr) {
        if (bArr != null) {
            write(bArr, 0, bArr.length);
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public c c(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            writeByte((i >> 6) | PsExtractor.AUDIO_STREAM);
            writeByte((i & 63) | Commons.MSG_MCSP_INIT_SUCCESS);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                writeByte(63);
            } else {
                writeByte((i >> 12) | 224);
                writeByte(((i >> 6) & 63) | Commons.MSG_MCSP_INIT_SUCCESS);
                writeByte((i & 63) | Commons.MSG_MCSP_INIT_SUCCESS);
            }
        } else if (i <= 1114111) {
            writeByte((i >> 18) | PsExtractor.VIDEO_STREAM_MASK);
            writeByte(((i >> 12) & 63) | Commons.MSG_MCSP_INIT_SUCCESS);
            writeByte(((i >> 6) & 63) | Commons.MSG_MCSP_INIT_SUCCESS);
            writeByte((i & 63) | Commons.MSG_MCSP_INIT_SUCCESS);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    @Override // okio.d
    public c write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            t.a(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                n b2 = b(1);
                int min = Math.min(i3 - i, 8192 - b2.f8597c);
                System.arraycopy(bArr, i, b2.f8595a, b2.f8597c, min);
                i += min;
                b2.f8597c += min;
            }
            this.f8573b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // okio.e
    public String f() throws EOFException {
        return b(Long.MAX_VALUE);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        n nVar = this.f8572a;
        if (nVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), nVar.f8597c - nVar.f8596b);
        byteBuffer.put(nVar.f8595a, nVar.f8596b, min);
        int i = nVar.f8596b + min;
        nVar.f8596b = i;
        this.f8573b -= min;
        if (i == nVar.f8597c) {
            this.f8572a = nVar.b();
            o.a(nVar);
        }
        return min;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n b(int i) {
        if (i >= 1 && i <= 8192) {
            n nVar = this.f8572a;
            if (nVar == null) {
                n a2 = o.a();
                this.f8572a = a2;
                a2.g = a2;
                a2.f = a2;
                return a2;
            }
            n nVar2 = nVar.g;
            if (nVar2.f8597c + i <= 8192 && nVar2.e) {
                return nVar2;
            }
            n a3 = o.a();
            nVar2.a(a3);
            return a3;
        }
        throw new IllegalArgumentException();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                n b2 = b(1);
                int min = Math.min(i, 8192 - b2.f8597c);
                byteBuffer.get(b2.f8595a, b2.f8597c, min);
                i -= min;
                b2.f8597c += min;
            }
            this.f8573b += remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // okio.e
    public ByteString a(long j) throws EOFException {
        return new ByteString(d(j));
    }

    @Override // okio.e
    public String a(Charset charset) {
        try {
            return a(this.f8573b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.d
    public c c(long j) {
        if (j == 0) {
            writeByte(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        n b2 = b(numberOfTrailingZeros);
        byte[] bArr = b2.f8595a;
        int i = b2.f8597c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f8571c[(int) (15 & j)];
            j >>>= 4;
        }
        b2.f8597c += numberOfTrailingZeros;
        this.f8573b += numberOfTrailingZeros;
        return this;
    }

    public String a(long j, Charset charset) throws EOFException {
        t.a(this.f8573b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        n nVar = this.f8572a;
        if (nVar.f8596b + j > nVar.f8597c) {
            return new String(d(j), charset);
        }
        String str = new String(nVar.f8595a, nVar.f8596b, (int) j, charset);
        int i = (int) (nVar.f8596b + j);
        nVar.f8596b = i;
        this.f8573b -= j;
        if (i == nVar.f8597c) {
            this.f8572a = nVar.b();
            o.a(nVar);
        }
        return str;
    }

    @Override // okio.r
    public long b(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j >= 0) {
            long j2 = this.f8573b;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            cVar.a(this, j);
            return j;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // okio.r
    public s b() {
        return s.f8603d;
    }

    public c a(ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // okio.d
    public c a(String str) {
        a(str, 0, str.length());
        return this;
    }

    public c a(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            }
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    n b2 = b(1);
                    byte[] bArr = b2.f8595a;
                    int i3 = b2.f8597c - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt;
                    while (i4 < min) {
                        char charAt2 = str.charAt(i4);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i4 + i3] = (byte) charAt2;
                        i4++;
                    }
                    int i5 = b2.f8597c;
                    int i6 = (i3 + i4) - i5;
                    b2.f8597c = i5 + i6;
                    this.f8573b += i6;
                    i = i4;
                } else {
                    if (charAt < 2048) {
                        writeByte((charAt >> 6) | PsExtractor.AUDIO_STREAM);
                        writeByte((charAt & '?') | Commons.MSG_MCSP_INIT_SUCCESS);
                    } else if (charAt >= 55296 && charAt <= 57343) {
                        int i7 = i + 1;
                        char charAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                        if (charAt <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                            int i8 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                            writeByte((i8 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                            writeByte(((i8 >> 12) & 63) | Commons.MSG_MCSP_INIT_SUCCESS);
                            writeByte(((i8 >> 6) & 63) | Commons.MSG_MCSP_INIT_SUCCESS);
                            writeByte((i8 & 63) | Commons.MSG_MCSP_INIT_SUCCESS);
                            i += 2;
                        } else {
                            writeByte(63);
                            i = i7;
                        }
                    } else {
                        writeByte((charAt >> '\f') | 224);
                        writeByte(((charAt >> 6) & 63) | Commons.MSG_MCSP_INIT_SUCCESS);
                        writeByte((charAt & '?') | Commons.MSG_MCSP_INIT_SUCCESS);
                    }
                    i++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }

    public c a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            }
            if (charset != null) {
                if (charset.equals(t.f8607a)) {
                    a(str, i, i2);
                    return this;
                }
                byte[] bytes = str.substring(i, i2).getBytes(charset);
                write(bytes, 0, bytes.length);
                return this;
            }
            throw new IllegalArgumentException("charset == null");
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }

    public long a(r rVar) throws IOException {
        if (rVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b2 = rVar.b(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (b2 == -1) {
                return j;
            }
            j += b2;
        }
    }

    @Override // okio.q
    public void a(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar != this) {
            t.a(cVar.f8573b, 0L, j);
            while (j > 0) {
                n nVar = cVar.f8572a;
                if (j < nVar.f8597c - nVar.f8596b) {
                    n nVar2 = this.f8572a;
                    n nVar3 = nVar2 != null ? nVar2.g : null;
                    if (nVar3 != null && nVar3.e) {
                        if ((nVar3.f8597c + j) - (nVar3.f8598d ? 0 : nVar3.f8596b) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            cVar.f8572a.a(nVar3, (int) j);
                            cVar.f8573b -= j;
                            this.f8573b += j;
                            return;
                        }
                    }
                    cVar.f8572a = cVar.f8572a.a((int) j);
                }
                n nVar4 = cVar.f8572a;
                long j2 = nVar4.f8597c - nVar4.f8596b;
                cVar.f8572a = nVar4.b();
                n nVar5 = this.f8572a;
                if (nVar5 == null) {
                    this.f8572a = nVar4;
                    nVar4.g = nVar4;
                    nVar4.f = nVar4;
                } else {
                    nVar5.g.a(nVar4);
                    nVar4.a();
                }
                cVar.f8573b -= j2;
                this.f8573b += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    @Override // okio.e
    public long a(byte b2) {
        return a(b2, 0L, Long.MAX_VALUE);
    }

    public long a(byte b2, long j, long j2) {
        n nVar;
        long j3 = 0;
        if (j >= 0 && j2 >= j) {
            long j4 = this.f8573b;
            if (j2 <= j4) {
                j4 = j2;
            }
            if (j == j4 || (nVar = this.f8572a) == null) {
                return -1L;
            }
            long j5 = this.f8573b;
            if (j5 - j < j) {
                while (j5 > j) {
                    nVar = nVar.g;
                    j5 -= nVar.f8597c - nVar.f8596b;
                }
            } else {
                while (true) {
                    long j6 = (nVar.f8597c - nVar.f8596b) + j3;
                    if (j6 >= j) {
                        break;
                    }
                    nVar = nVar.f;
                    j3 = j6;
                }
                j5 = j3;
            }
            long j7 = j;
            while (j5 < j4) {
                byte[] bArr = nVar.f8595a;
                int min = (int) Math.min(nVar.f8597c, (nVar.f8596b + j4) - j5);
                for (int i = (int) ((nVar.f8596b + j7) - j5); i < min; i++) {
                    if (bArr[i] == b2) {
                        return (i - nVar.f8596b) + j5;
                    }
                }
                j5 += nVar.f8597c - nVar.f8596b;
                nVar = nVar.f;
                j7 = j5;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f8573b), Long.valueOf(j), Long.valueOf(j2)));
    }

    @Override // okio.e
    public boolean a(long j, ByteString byteString) {
        return a(j, byteString, 0, byteString.size());
    }

    public boolean a(long j, ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.f8573b - j < i2 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (f(i3 + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public final ByteString a(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        return new p(this, i);
    }
}
