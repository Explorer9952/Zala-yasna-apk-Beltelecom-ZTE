package com.bumptech.glide.s;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: ExceptionCatchingInputStream.java */
/* loaded from: classes.dex */
public class c extends InputStream {

    /* renamed from: c, reason: collision with root package name */
    private static final Queue<c> f2340c = h.a(0);

    /* renamed from: a, reason: collision with root package name */
    private InputStream f2341a;

    /* renamed from: b, reason: collision with root package name */
    private IOException f2342b;

    c() {
    }

    public static c b(InputStream inputStream) {
        c poll;
        synchronized (f2340c) {
            poll = f2340c.poll();
        }
        if (poll == null) {
            poll = new c();
        }
        poll.a(inputStream);
        return poll;
    }

    void a(InputStream inputStream) {
        this.f2341a = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f2341a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f2341a.close();
    }

    public IOException g() {
        return this.f2342b;
    }

    public void k() {
        this.f2342b = null;
        this.f2341a = null;
        synchronized (f2340c) {
            f2340c.offer(this);
        }
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f2341a.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f2341a.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.f2341a.read(bArr);
        } catch (IOException e) {
            this.f2342b = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f2341a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        try {
            return this.f2341a.skip(j);
        } catch (IOException e) {
            this.f2342b = e;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            return this.f2341a.read(bArr, i, i2);
        } catch (IOException e) {
            this.f2342b = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.f2341a.read();
        } catch (IOException e) {
            this.f2342b = e;
            return -1;
        }
    }
}
