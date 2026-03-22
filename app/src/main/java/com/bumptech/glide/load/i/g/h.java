package com.bumptech.glide.load.i.g;

import android.graphics.Bitmap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GifFrameResourceDecoder.java */
/* loaded from: classes.dex */
public class h implements com.bumptech.glide.load.d<com.bumptech.glide.m.a, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.l.c f2144a;

    public h(com.bumptech.glide.load.engine.l.c cVar) {
        this.f2144a = cVar;
    }

    @Override // com.bumptech.glide.load.d
    public String a() {
        return "GifFrameResourceDecoder.com.bumptech.glide.load.resource.gif";
    }

    @Override // com.bumptech.glide.load.d
    public com.bumptech.glide.load.engine.j<Bitmap> a(com.bumptech.glide.m.a aVar, int i, int i2) {
        return com.bumptech.glide.load.resource.bitmap.c.a(aVar.g(), this.f2144a);
    }
}
