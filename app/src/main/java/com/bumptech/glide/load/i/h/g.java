package com.bumptech.glide.load.i.h;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;

/* compiled from: ImageVideoGifDrawableLoadProvider.java */
/* loaded from: classes.dex */
public class g implements com.bumptech.glide.p.b<com.bumptech.glide.load.h.g, a> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.d<File, a> f2168a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.d<com.bumptech.glide.load.h.g, a> f2169b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.e<a> f2170c;

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.a<com.bumptech.glide.load.h.g> f2171d;

    public g(com.bumptech.glide.p.b<com.bumptech.glide.load.h.g, Bitmap> bVar, com.bumptech.glide.p.b<InputStream, com.bumptech.glide.load.i.g.b> bVar2, com.bumptech.glide.load.engine.l.c cVar) {
        c cVar2 = new c(bVar.d(), bVar2.d(), cVar);
        this.f2168a = new com.bumptech.glide.load.i.f.c(new e(cVar2));
        this.f2169b = cVar2;
        this.f2170c = new d(bVar.c(), bVar2.c());
        this.f2171d = bVar.a();
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.a<com.bumptech.glide.load.h.g> a() {
        return this.f2171d;
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.e<a> c() {
        return this.f2170c;
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.d<com.bumptech.glide.load.h.g, a> d() {
        return this.f2169b;
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.d<File, a> e() {
        return this.f2168a;
    }
}
