package com.bumptech.glide.load.i.h;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.j;

/* compiled from: GifBitmapWrapperTransformation.java */
/* loaded from: classes.dex */
public class f implements com.bumptech.glide.load.f<a> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.f<Bitmap> f2166a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.f<com.bumptech.glide.load.i.g.b> f2167b;

    public f(com.bumptech.glide.load.engine.l.c cVar, com.bumptech.glide.load.f<Bitmap> fVar) {
        this(fVar, new com.bumptech.glide.load.i.g.e(fVar, cVar));
    }

    @Override // com.bumptech.glide.load.f
    public j<a> a(j<a> jVar, int i, int i2) {
        com.bumptech.glide.load.f<com.bumptech.glide.load.i.g.b> fVar;
        com.bumptech.glide.load.f<Bitmap> fVar2;
        j<Bitmap> a2 = jVar.get().a();
        j<com.bumptech.glide.load.i.g.b> b2 = jVar.get().b();
        if (a2 != null && (fVar2 = this.f2166a) != null) {
            j<Bitmap> a3 = fVar2.a(a2, i, i2);
            return !a2.equals(a3) ? new b(new a(a3, jVar.get().b())) : jVar;
        }
        if (b2 == null || (fVar = this.f2167b) == null) {
            return jVar;
        }
        j<com.bumptech.glide.load.i.g.b> a4 = fVar.a(b2, i, i2);
        return !b2.equals(a4) ? new b(new a(jVar.get().a(), a4)) : jVar;
    }

    f(com.bumptech.glide.load.f<Bitmap> fVar, com.bumptech.glide.load.f<com.bumptech.glide.load.i.g.b> fVar2) {
        this.f2166a = fVar;
        this.f2167b = fVar2;
    }

    @Override // com.bumptech.glide.load.f
    public String a() {
        return this.f2166a.a();
    }
}
