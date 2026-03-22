package com.bumptech.glide.s;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MarkEnforcingInputStream.java */
/* loaded from: classes.dex */
public class f extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private int f2347a;

    public f(InputStream inputStream) {
        super(inputStream);
        this.f2347a = Integer.MIN_VALUE;
    }

    private long f(long j) {
        int i = this.f2347a;
        if (i == 0) {
            return -1L;
        }
        return (i == Integer.MIN_VALUE || j <= ((long) i)) ? j : i;
    }

    private void g(long j) {
        int i = this.f2347a;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.f2347a = (int) (i - j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i = this.f2347a;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        super.mark(i);
        this.f2347a = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (f(1L) == -1) {
            return -1;
        }
        int read = super.read();
        g(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        this.f2347a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long f = f(j);
        if (f == -1) {
            return -1L;
        }
        long skip = super.skip(f);
        g(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int f = (int) f(i2);
        if (f == -1) {
            return -1;
        }
        int read = super.read(bArr, i, f);
        g(read);
        return read;
    }
}
