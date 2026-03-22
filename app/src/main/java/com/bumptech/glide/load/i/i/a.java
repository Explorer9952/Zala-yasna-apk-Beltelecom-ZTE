package com.bumptech.glide.load.i.i;

import android.graphics.Bitmap;
import com.bumptech.glide.load.resource.bitmap.j;

/* compiled from: GifBitmapWrapperDrawableTranscoder.java */
/* loaded from: classes.dex */
public class a implements c<com.bumptech.glide.load.i.h.a, com.bumptech.glide.load.i.e.b> {

    /* renamed from: a, reason: collision with root package name */
    private final c<Bitmap, j> f2172a;

    public a(c<Bitmap, j> cVar) {
        this.f2172a = cVar;
    }

    @Override // com.bumptech.glide.load.i.i.c
    public com.bumptech.glide.load.engine.j<com.bumptech.glide.load.i.e.b> a(com.bumptech.glide.load.engine.j<com.bumptech.glide.load.i.h.a> jVar) {
        com.bumptech.glide.load.i.h.a aVar = jVar.get();
        com.bumptech.glide.load.engine.j<Bitmap> a2 = aVar.a();
        if (a2 != null) {
            return this.f2172a.a(a2);
        }
        return aVar.b();
    }

    @Override // com.bumptech.glide.load.i.i.c
    public String a() {
        return "GifBitmapWrapperDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
