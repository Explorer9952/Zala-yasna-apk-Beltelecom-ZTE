package com.bumptech.glide.load.i.g;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.m.a;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: GifResourceEncoder.java */
/* loaded from: classes.dex */
public class j implements com.bumptech.glide.load.e<b> {

    /* renamed from: d, reason: collision with root package name */
    private static final a f2151d = new a();

    /* renamed from: a, reason: collision with root package name */
    private final a.InterfaceC0069a f2152a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.l.c f2153b;

    /* renamed from: c, reason: collision with root package name */
    private final a f2154c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifResourceEncoder.java */
    /* loaded from: classes.dex */
    public static class a {
        a() {
        }

        public com.bumptech.glide.m.a a(a.InterfaceC0069a interfaceC0069a) {
            return new com.bumptech.glide.m.a(interfaceC0069a);
        }

        public com.bumptech.glide.m.d b() {
            return new com.bumptech.glide.m.d();
        }

        public com.bumptech.glide.n.a a() {
            return new com.bumptech.glide.n.a();
        }

        public com.bumptech.glide.load.engine.j<Bitmap> a(Bitmap bitmap, com.bumptech.glide.load.engine.l.c cVar) {
            return new com.bumptech.glide.load.resource.bitmap.c(bitmap, cVar);
        }
    }

    public j(com.bumptech.glide.load.engine.l.c cVar) {
        this(cVar, f2151d);
    }

    @Override // com.bumptech.glide.load.a
    public String a() {
        return "";
    }

    j(com.bumptech.glide.load.engine.l.c cVar, a aVar) {
        this.f2153b = cVar;
        this.f2152a = new com.bumptech.glide.load.i.g.a(cVar);
        this.f2154c = aVar;
    }

    @Override // com.bumptech.glide.load.a
    public boolean a(com.bumptech.glide.load.engine.j<b> jVar, OutputStream outputStream) {
        long a2 = com.bumptech.glide.s.d.a();
        b bVar = jVar.get();
        com.bumptech.glide.load.f<Bitmap> e = bVar.e();
        if (e instanceof com.bumptech.glide.load.i.d) {
            return a(bVar.b(), outputStream);
        }
        com.bumptech.glide.m.a a3 = a(bVar.b());
        com.bumptech.glide.n.a a4 = this.f2154c.a();
        if (!a4.a(outputStream)) {
            return false;
        }
        for (int i = 0; i < a3.d(); i++) {
            com.bumptech.glide.load.engine.j<Bitmap> a5 = a(a3.g(), e, bVar);
            try {
                if (!a4.a(a5.get())) {
                    return false;
                }
                a4.a(a3.a(a3.c()));
                a3.a();
                a5.a();
            } finally {
                a5.a();
            }
        }
        boolean a6 = a4.a();
        if (Log.isLoggable("GifEncoder", 2)) {
            Log.v("GifEncoder", "Encoded gif with " + a3.d() + " frames and " + bVar.b().length + " bytes in " + com.bumptech.glide.s.d.a(a2) + " ms");
        }
        return a6;
    }

    private boolean a(byte[] bArr, OutputStream outputStream) {
        try {
            outputStream.write(bArr);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable("GifEncoder", 3)) {
                Log.d("GifEncoder", "Failed to write data to output stream in GifResourceEncoder", e);
            }
            return false;
        }
    }

    private com.bumptech.glide.m.a a(byte[] bArr) {
        com.bumptech.glide.m.d b2 = this.f2154c.b();
        b2.a(bArr);
        com.bumptech.glide.m.c b3 = b2.b();
        com.bumptech.glide.m.a a2 = this.f2154c.a(this.f2152a);
        a2.a(b3, bArr);
        a2.a();
        return a2;
    }

    private com.bumptech.glide.load.engine.j<Bitmap> a(Bitmap bitmap, com.bumptech.glide.load.f<Bitmap> fVar, b bVar) {
        com.bumptech.glide.load.engine.j<Bitmap> a2 = this.f2154c.a(bitmap, this.f2153b);
        com.bumptech.glide.load.engine.j<Bitmap> a3 = fVar.a(a2, bVar.getIntrinsicWidth(), bVar.getIntrinsicHeight());
        if (!a2.equals(a3)) {
            a2.a();
        }
        return a3;
    }
}
