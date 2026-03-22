package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SegmentedByteString.java */
/* loaded from: classes2.dex */
public final class p extends ByteString {

    /* renamed from: a, reason: collision with root package name */
    final transient byte[][] f8601a;

    /* renamed from: b, reason: collision with root package name */
    final transient int[] f8602b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(c cVar, int i) {
        super(null);
        t.a(cVar.f8573b, 0L, i);
        n nVar = cVar.f8572a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = nVar.f8597c;
            int i6 = nVar.f8596b;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                nVar = nVar.f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f8601a = new byte[i4];
        this.f8602b = new int[i4 * 2];
        n nVar2 = cVar.f8572a;
        int i7 = 0;
        while (i2 < i) {
            this.f8601a[i7] = nVar2.f8595a;
            i2 += nVar2.f8597c - nVar2.f8596b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.f8602b;
            iArr[i7] = i2;
            iArr[this.f8601a.length + i7] = nVar2.f8596b;
            nVar2.f8598d = true;
            i7++;
            nVar2 = nVar2.f;
        }
    }

    private int a(int i) {
        int binarySearch = Arrays.binarySearch(this.f8602b, 0, this.f8601a.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ (-1);
    }

    private Object writeReplace() {
        return a();
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // okio.ByteString
    public String base64() {
        return a().base64();
    }

    @Override // okio.ByteString
    public String base64Url() {
        return a().base64Url();
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public byte getByte(int i) {
        t.a(this.f8602b[this.f8601a.length - 1], i, 1L);
        int a2 = a(i);
        int i2 = a2 == 0 ? 0 : this.f8602b[a2 - 1];
        int[] iArr = this.f8602b;
        byte[][] bArr = this.f8601a;
        return bArr[a2][(i - i2) + iArr[bArr.length + a2]];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int length = this.f8601a.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.f8601a[i2];
            int[] iArr = this.f8602b;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.hashCode = i4;
        return i4;
    }

    @Override // okio.ByteString
    public String hex() {
        return a().hex();
    }

    @Override // okio.ByteString
    public ByteString hmacSha1(ByteString byteString) {
        return a().hmacSha1(byteString);
    }

    @Override // okio.ByteString
    public ByteString hmacSha256(ByteString byteString) {
        return a().hmacSha256(byteString);
    }

    @Override // okio.ByteString
    public int indexOf(byte[] bArr, int i) {
        return a().indexOf(bArr, i);
    }

    @Override // okio.ByteString
    byte[] internalArray() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] bArr, int i) {
        return a().lastIndexOf(bArr, i);
    }

    @Override // okio.ByteString
    public ByteString md5() {
        return a().md5();
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        if (i < 0 || i > size() - i3) {
            return false;
        }
        int a2 = a(i);
        while (i3 > 0) {
            int i4 = a2 == 0 ? 0 : this.f8602b[a2 - 1];
            int min = Math.min(i3, ((this.f8602b[a2] - i4) + i4) - i);
            int[] iArr = this.f8602b;
            byte[][] bArr = this.f8601a;
            if (!byteString.rangeEquals(i2, bArr[a2], (i - i4) + iArr[bArr.length + a2], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            a2++;
        }
        return true;
    }

    @Override // okio.ByteString
    public ByteString sha1() {
        return a().sha1();
    }

    @Override // okio.ByteString
    public ByteString sha256() {
        return a().sha256();
    }

    @Override // okio.ByteString
    public int size() {
        return this.f8602b[this.f8601a.length - 1];
    }

    @Override // okio.ByteString
    public String string(Charset charset) {
        return a().string(charset);
    }

    @Override // okio.ByteString
    public ByteString substring(int i) {
        return a().substring(i);
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        return a().toAsciiLowercase();
    }

    @Override // okio.ByteString
    public ByteString toAsciiUppercase() {
        return a().toAsciiUppercase();
    }

    @Override // okio.ByteString
    public byte[] toByteArray() {
        int[] iArr = this.f8602b;
        byte[][] bArr = this.f8601a;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.f8602b;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f8601a[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // okio.ByteString
    public String toString() {
        return a().toString();
    }

    @Override // okio.ByteString
    public String utf8() {
        return a().utf8();
    }

    @Override // okio.ByteString
    public void write(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            int length = this.f8601a.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int[] iArr = this.f8602b;
                int i3 = iArr[length + i];
                int i4 = iArr[i];
                outputStream.write(this.f8601a[i], i3, i4 - i2);
                i++;
                i2 = i4;
            }
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    private ByteString a() {
        return new ByteString(toByteArray());
    }

    @Override // okio.ByteString
    public ByteString substring(int i, int i2) {
        return a().substring(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // okio.ByteString
    public void write(c cVar) {
        int length = this.f8601a.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f8602b;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            n nVar = new n(this.f8601a[i], i3, (i3 + i4) - i2, true, false);
            n nVar2 = cVar.f8572a;
            if (nVar2 == null) {
                nVar.g = nVar;
                nVar.f = nVar;
                cVar.f8572a = nVar;
            } else {
                nVar2.g.a(nVar);
            }
            i++;
            i2 = i4;
        }
        cVar.f8573b += i2;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int a2 = a(i);
        while (i3 > 0) {
            int i4 = a2 == 0 ? 0 : this.f8602b[a2 - 1];
            int min = Math.min(i3, ((this.f8602b[a2] - i4) + i4) - i);
            int[] iArr = this.f8602b;
            byte[][] bArr2 = this.f8601a;
            if (!t.a(bArr2[a2], (i - i4) + iArr[bArr2.length + a2], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            a2++;
        }
        return true;
    }
}
