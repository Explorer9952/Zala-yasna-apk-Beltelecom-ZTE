package com.bumptech.glide.load.i.i;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.bumptech.glide.load.resource.bitmap.j;
import com.bumptech.glide.load.resource.bitmap.k;

/* compiled from: GlideBitmapDrawableTranscoder.java */
/* loaded from: classes.dex */
public class b implements c<Bitmap, j> {

    /* renamed from: a, reason: collision with root package name */
    private final Resources f2173a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.l.c f2174b;

    public b(Resources resources, com.bumptech.glide.load.engine.l.c cVar) {
        this.f2173a = resources;
        this.f2174b = cVar;
    }

    @Override // com.bumptech.glide.load.i.i.c
    public com.bumptech.glide.load.engine.j<j> a(com.bumptech.glide.load.engine.j<Bitmap> jVar) {
        return new k(new j(this.f2173a, jVar.get()), this.f2174b);
    }

    @Override // com.bumptech.glide.load.i.i.c
    public String a() {
        return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
