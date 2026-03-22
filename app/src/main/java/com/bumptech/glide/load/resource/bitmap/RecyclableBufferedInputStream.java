package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private volatile byte[] f2183a;

    /* renamed from: b, reason: collision with root package name */
    private int f2184b;

    /* renamed from: c, reason: collision with root package name */
    private int f2185c;

    /* renamed from: d, reason: collision with root package name */
    private int f2186d;
    private int e;

    /* loaded from: classes.dex */
    public static class InvalidMarkException extends RuntimeException {
        private static final long serialVersionUID = -4338378848813561757L;

        public InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        this.f2186d = -1;
        if (bArr != null && bArr.length != 0) {
            this.f2183a = bArr;
            return;
        }
        throw new IllegalArgumentException("buffer is null or empty");
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.f2186d;
        if (i != -1) {
            int i2 = this.e - i;
            int i3 = this.f2185c;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.f2184b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    if (Log.isLoggable("BufferedIs", 3)) {
                        Log.d("BufferedIs", "allocate buffer of length: " + i3);
                    }
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f2183a = bArr2;
                    bArr = bArr2;
                } else {
                    int i4 = this.f2186d;
                    if (i4 > 0) {
                        System.arraycopy(bArr, i4, bArr, 0, bArr.length - i4);
                    }
                }
                int i5 = this.e - this.f2186d;
                this.e = i5;
                this.f2186d = 0;
                this.f2184b = 0;
                int read = inputStream.read(bArr, i5, bArr.length - i5);
                int i6 = this.e;
                if (read > 0) {
                    i6 += read;
                }
                this.f2184b = i6;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f2186d = -1;
            this.e = 0;
            this.f2184b = read2;
        }
        return read2;
    }

    private static IOException k() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f2183a != null && inputStream != null) {
        } else {
            k();
            throw null;
        }
        return (this.f2184b - this.e) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f2183a = null;
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void g() {
        this.f2185c = this.f2183a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.f2185c = Math.max(this.f2185c, i);
        this.f2186d = this.e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f2183a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr != null && inputStream != null) {
            if (this.e >= this.f2184b && a(inputStream, bArr) == -1) {
                return -1;
            }
            if (bArr != this.f2183a && (bArr = this.f2183a) == null) {
                k();
                throw null;
            }
            if (this.f2184b - this.e <= 0) {
                return -1;
            }
            int i = this.e;
            this.e = i + 1;
            return bArr[i] & 255;
        }
        k();
        throw null;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f2183a != null) {
            if (-1 != this.f2186d) {
                this.e = this.f2186d;
            } else {
                throw new InvalidMarkException("Mark has been invalidated");
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        byte[] bArr = this.f2183a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null) {
            k();
            throw null;
        }
        if (j < 1) {
            return 0L;
        }
        if (inputStream == null) {
            k();
            throw null;
        }
        if (this.f2184b - this.e >= j) {
            this.e = (int) (this.e + j);
            return j;
        }
        long j2 = this.f2184b - this.e;
        this.e = this.f2184b;
        if (this.f2186d != -1 && j <= this.f2185c) {
            if (a(inputStream, bArr) == -1) {
                return j2;
            }
            long j3 = j - j2;
            if (this.f2184b - this.e >= j3) {
                this.e = (int) (this.e + j3);
                return j;
            }
            long j4 = (j2 + this.f2184b) - this.e;
            this.e = this.f2184b;
            return j4;
        }
        return j2 + inputStream.skip(j - j2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        byte[] bArr2 = this.f2183a;
        if (bArr2 == null) {
            k();
            throw null;
        }
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            if (this.e < this.f2184b) {
                int i5 = this.f2184b - this.e >= i2 ? i2 : this.f2184b - this.e;
                System.arraycopy(bArr2, this.e, bArr, i, i5);
                this.e += i5;
                if (i5 == i2 || inputStream.available() == 0) {
                    return i5;
                }
                i += i5;
                i3 = i2 - i5;
            } else {
                i3 = i2;
            }
            while (true) {
                if (this.f2186d == -1 && i3 >= bArr2.length) {
                    i4 = inputStream.read(bArr, i, i3);
                    if (i4 == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    }
                    if (bArr2 != this.f2183a && (bArr2 = this.f2183a) == null) {
                        k();
                        throw null;
                    }
                    i4 = this.f2184b - this.e >= i3 ? i3 : this.f2184b - this.e;
                    System.arraycopy(bArr2, this.e, bArr, i, i4);
                    this.e += i4;
                }
                i3 -= i4;
                if (i3 == 0) {
                    return i2;
                }
                if (inputStream.available() == 0) {
                    return i2 - i3;
                }
                i += i4;
            }
        } else {
            k();
            throw null;
        }
    }
}
