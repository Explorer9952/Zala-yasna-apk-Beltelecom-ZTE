package com.bumptech.glide.load.i.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.m.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: GifResourceDecoder.java */
/* loaded from: classes.dex */
public class i implements com.bumptech.glide.load.d<InputStream, com.bumptech.glide.load.i.g.b> {
    private static final b f = new b();
    private static final a g = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Context f2145a;

    /* renamed from: b, reason: collision with root package name */
    private final b f2146b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.l.c f2147c;

    /* renamed from: d, reason: collision with root package name */
    private final a f2148d;
    private final com.bumptech.glide.load.i.g.a e;

    public i(Context context, com.bumptech.glide.load.engine.l.c cVar) {
        this(context, cVar, f, g);
    }

    @Override // com.bumptech.glide.load.d
    public String a() {
        return "";
    }

    i(Context context, com.bumptech.glide.load.engine.l.c cVar, b bVar, a aVar) {
        this.f2145a = context;
        this.f2147c = cVar;
        this.f2148d = aVar;
        this.e = new com.bumptech.glide.load.i.g.a(cVar);
        this.f2146b = bVar;
    }

    @Override // com.bumptech.glide.load.d
    public d a(InputStream inputStream, int i, int i2) {
        byte[] a2 = a(inputStream);
        com.bumptech.glide.m.d a3 = this.f2146b.a(a2);
        com.bumptech.glide.m.a a4 = this.f2148d.a(this.e);
        try {
            return a(a2, i, i2, a3, a4);
        } finally {
            this.f2146b.a(a3);
            this.f2148d.a(a4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifResourceDecoder.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Queue<com.bumptech.glide.m.a> f2149a = com.bumptech.glide.s.h.a(0);

        a() {
        }

        public synchronized com.bumptech.glide.m.a a(a.InterfaceC0069a interfaceC0069a) {
            com.bumptech.glide.m.a poll;
            poll = this.f2149a.poll();
            if (poll == null) {
                poll = new com.bumptech.glide.m.a(interfaceC0069a);
            }
            return poll;
        }

        public synchronized void a(com.bumptech.glide.m.a aVar) {
            aVar.b();
            this.f2149a.offer(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifResourceDecoder.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Queue<com.bumptech.glide.m.d> f2150a = com.bumptech.glide.s.h.a(0);

        b() {
        }

        public synchronized com.bumptech.glide.m.d a(byte[] bArr) {
            com.bumptech.glide.m.d poll;
            poll = this.f2150a.poll();
            if (poll == null) {
                poll = new com.bumptech.glide.m.d();
            }
            poll.a(bArr);
            return poll;
        }

        public synchronized void a(com.bumptech.glide.m.d dVar) {
            dVar.a();
            this.f2150a.offer(dVar);
        }
    }

    private d a(byte[] bArr, int i, int i2, com.bumptech.glide.m.d dVar, com.bumptech.glide.m.a aVar) {
        Bitmap a2;
        com.bumptech.glide.m.c b2 = dVar.b();
        if (b2.a() <= 0 || b2.b() != 0 || (a2 = a(aVar, b2, bArr)) == null) {
            return null;
        }
        return new d(new com.bumptech.glide.load.i.g.b(this.f2145a, this.e, this.f2147c, com.bumptech.glide.load.i.d.b(), i, i2, b2, bArr, a2));
    }

    private Bitmap a(com.bumptech.glide.m.a aVar, com.bumptech.glide.m.c cVar, byte[] bArr) {
        aVar.a(cVar, bArr);
        aVar.a();
        return aVar.g();
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
        } catch (IOException e) {
            Log.w("GifResourceDecoder", "Error reading data from stream", e);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
