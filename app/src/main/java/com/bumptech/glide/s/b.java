package com.bumptech.glide.s;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ContentLengthInputStream.java */
/* loaded from: classes.dex */
public final class b extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private final long f2338a;

    /* renamed from: b, reason: collision with root package name */
    private int f2339b;

    b(InputStream inputStream, long j) {
        super(inputStream);
        this.f2338a = j;
    }

    public static InputStream a(InputStream inputStream, long j) {
        return new b(inputStream, j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f2338a - this.f2339b, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        a(read);
        return read;
    }

    private int a(int i) throws IOException {
        if (i >= 0) {
            this.f2339b += i;
        } else if (this.f2338a - this.f2339b > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f2338a + ", but read: " + this.f2339b);
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int read;
        read = super.read(bArr, i, i2);
        a(read);
        return read;
    }
}
