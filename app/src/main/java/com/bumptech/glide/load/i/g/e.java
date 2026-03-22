package com.bumptech.glide.load.i.g;

import android.graphics.Bitmap;

/* compiled from: GifDrawableTransformation.java */
/* loaded from: classes.dex */
public class e implements com.bumptech.glide.load.f<b> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.f<Bitmap> f2134a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.l.c f2135b;

    public e(com.bumptech.glide.load.f<Bitmap> fVar, com.bumptech.glide.load.engine.l.c cVar) {
        this.f2134a = fVar;
        this.f2135b = cVar;
    }

    @Override // com.bumptech.glide.load.f
    public com.bumptech.glide.load.engine.j<b> a(com.bumptech.glide.load.engine.j<b> jVar, int i, int i2) {
        b bVar = jVar.get();
        Bitmap c2 = jVar.get().c();
        Bitmap bitmap = this.f2134a.a(new com.bumptech.glide.load.resource.bitmap.c(c2, this.f2135b), i, i2).get();
        return !bitmap.equals(c2) ? new d(new b(bVar, bitmap, this.f2134a)) : jVar;
    }

    @Override // com.bumptech.glide.load.f
    public String a() {
        return this.f2134a.a();
    }
}
