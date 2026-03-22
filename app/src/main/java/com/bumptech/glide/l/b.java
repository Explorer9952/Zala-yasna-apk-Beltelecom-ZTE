package com.bumptech.glide.l;

import com.facebook.internal.Utility;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StrictLineReader.java */
/* loaded from: classes.dex */
public class b implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f1956a;

    /* renamed from: b, reason: collision with root package name */
    private final Charset f1957b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f1958c;

    /* renamed from: d, reason: collision with root package name */
    private int f1959d;
    private int e;

    /* compiled from: StrictLineReader.java */
    /* loaded from: classes.dex */
    class a extends ByteArrayOutputStream {
        a(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i = ((ByteArrayOutputStream) this).count;
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, (i <= 0 || ((ByteArrayOutputStream) this).buf[i + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i - 1, b.this.f1957b.name());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, Utility.DEFAULT_STREAM_BUFFER_SIZE, charset);
    }

    private void l() throws IOException {
        InputStream inputStream = this.f1956a;
        byte[] bArr = this.f1958c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f1959d = 0;
            this.e = read;
            return;
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f1956a) {
            if (this.f1958c != null) {
                this.f1958c = null;
                this.f1956a.close();
            }
        }
    }

    public boolean g() {
        return this.e == -1;
    }

    public String k() throws IOException {
        int i;
        int i2;
        synchronized (this.f1956a) {
            if (this.f1958c != null) {
                if (this.f1959d >= this.e) {
                    l();
                }
                for (int i3 = this.f1959d; i3 != this.e; i3++) {
                    if (this.f1958c[i3] == 10) {
                        if (i3 != this.f1959d) {
                            i2 = i3 - 1;
                            if (this.f1958c[i2] == 13) {
                                String str = new String(this.f1958c, this.f1959d, i2 - this.f1959d, this.f1957b.name());
                                this.f1959d = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f1958c, this.f1959d, i2 - this.f1959d, this.f1957b.name());
                        this.f1959d = i3 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.e - this.f1959d) + 80);
                loop1: while (true) {
                    aVar.write(this.f1958c, this.f1959d, this.e - this.f1959d);
                    this.e = -1;
                    l();
                    i = this.f1959d;
                    while (i != this.e) {
                        if (this.f1958c[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                if (i != this.f1959d) {
                    aVar.write(this.f1958c, this.f1959d, i - this.f1959d);
                }
                this.f1959d = i + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i >= 0) {
            if (charset.equals(c.f1961a)) {
                this.f1956a = inputStream;
                this.f1957b = charset;
                this.f1958c = new byte[i];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
