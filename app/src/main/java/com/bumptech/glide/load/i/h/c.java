package com.bumptech.glide.load.i.h;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: GifBitmapWrapperResourceDecoder.java */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.load.d<com.bumptech.glide.load.h.g, com.bumptech.glide.load.i.h.a> {
    private static final b g = new b();
    private static final a h = new a();

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.d<com.bumptech.glide.load.h.g, Bitmap> f2158a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.d<InputStream, com.bumptech.glide.load.i.g.b> f2159b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.l.c f2160c;

    /* renamed from: d, reason: collision with root package name */
    private final b f2161d;
    private final a e;
    private String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifBitmapWrapperResourceDecoder.java */
    /* loaded from: classes.dex */
    public static class a {
        a() {
        }

        public InputStream a(InputStream inputStream, byte[] bArr) {
            return new RecyclableBufferedInputStream(inputStream, bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifBitmapWrapperResourceDecoder.java */
    /* loaded from: classes.dex */
    public static class b {
        b() {
        }

        public ImageHeaderParser.ImageType a(InputStream inputStream) throws IOException {
            return new ImageHeaderParser(inputStream).b();
        }
    }

    public c(com.bumptech.glide.load.d<com.bumptech.glide.load.h.g, Bitmap> dVar, com.bumptech.glide.load.d<InputStream, com.bumptech.glide.load.i.g.b> dVar2, com.bumptech.glide.load.engine.l.c cVar) {
        this(dVar, dVar2, cVar, g, h);
    }

    private com.bumptech.glide.load.i.h.a b(com.bumptech.glide.load.h.g gVar, int i, int i2, byte[] bArr) throws IOException {
        InputStream a2 = this.e.a(gVar.b(), bArr);
        a2.mark(LVBuffer.MAX_STRING_LENGTH);
        ImageHeaderParser.ImageType a3 = this.f2161d.a(a2);
        a2.reset();
        com.bumptech.glide.load.i.h.a a4 = a3 == ImageHeaderParser.ImageType.GIF ? a(a2, i, i2) : null;
        return a4 == null ? b(new com.bumptech.glide.load.h.g(a2, gVar.a()), i, i2) : a4;
    }

    c(com.bumptech.glide.load.d<com.bumptech.glide.load.h.g, Bitmap> dVar, com.bumptech.glide.load.d<InputStream, com.bumptech.glide.load.i.g.b> dVar2, com.bumptech.glide.load.engine.l.c cVar, b bVar, a aVar) {
        this.f2158a = dVar;
        this.f2159b = dVar2;
        this.f2160c = cVar;
        this.f2161d = bVar;
        this.e = aVar;
    }

    @Override // com.bumptech.glide.load.d
    public j<com.bumptech.glide.load.i.h.a> a(com.bumptech.glide.load.h.g gVar, int i, int i2) throws IOException {
        com.bumptech.glide.s.a b2 = com.bumptech.glide.s.a.b();
        byte[] a2 = b2.a();
        try {
            com.bumptech.glide.load.i.h.a a3 = a(gVar, i, i2, a2);
            if (a3 != null) {
                return new com.bumptech.glide.load.i.h.b(a3);
            }
            return null;
        } finally {
            b2.a(a2);
        }
    }

    private com.bumptech.glide.load.i.h.a a(com.bumptech.glide.load.h.g gVar, int i, int i2, byte[] bArr) throws IOException {
        if (gVar.b() != null) {
            return b(gVar, i, i2, bArr);
        }
        return b(gVar, i, i2);
    }

    private com.bumptech.glide.load.i.h.a b(com.bumptech.glide.load.h.g gVar, int i, int i2) throws IOException {
        j<Bitmap> a2 = this.f2158a.a(gVar, i, i2);
        if (a2 != null) {
            return new com.bumptech.glide.load.i.h.a(a2, null);
        }
        return null;
    }

    private com.bumptech.glide.load.i.h.a a(InputStream inputStream, int i, int i2) throws IOException {
        com.bumptech.glide.load.i.h.a aVar;
        j<com.bumptech.glide.load.i.g.b> a2 = this.f2159b.a(inputStream, i, i2);
        if (a2 == null) {
            return null;
        }
        com.bumptech.glide.load.i.g.b bVar = a2.get();
        if (bVar.d() > 1) {
            aVar = new com.bumptech.glide.load.i.h.a(null, a2);
        } else {
            aVar = new com.bumptech.glide.load.i.h.a(new com.bumptech.glide.load.resource.bitmap.c(bVar.c(), this.f2160c), null);
        }
        return aVar;
    }

    @Override // com.bumptech.glide.load.d
    public String a() {
        if (this.f == null) {
            this.f = this.f2159b.a() + this.f2158a.a();
        }
        return this.f;
    }
}
