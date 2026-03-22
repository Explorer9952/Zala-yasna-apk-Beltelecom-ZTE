package com.bumptech.glide.load.i.h;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.j;

/* compiled from: GifBitmapWrapper.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final j<com.bumptech.glide.load.i.g.b> f2155a;

    /* renamed from: b, reason: collision with root package name */
    private final j<Bitmap> f2156b;

    public a(j<Bitmap> jVar, j<com.bumptech.glide.load.i.g.b> jVar2) {
        if (jVar != null && jVar2 != null) {
            throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
        }
        if (jVar == null && jVar2 == null) {
            throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
        }
        this.f2156b = jVar;
        this.f2155a = jVar2;
    }

    public j<Bitmap> a() {
        return this.f2156b;
    }

    public j<com.bumptech.glide.load.i.g.b> b() {
        return this.f2155a;
    }

    public int c() {
        j<Bitmap> jVar = this.f2156b;
        if (jVar != null) {
            return jVar.getSize();
        }
        return this.f2155a.getSize();
    }
}
