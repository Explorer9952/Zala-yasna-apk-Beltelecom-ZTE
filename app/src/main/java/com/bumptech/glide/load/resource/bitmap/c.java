package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;

/* compiled from: BitmapResource.java */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.load.engine.j<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final Bitmap f2189a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.l.c f2190b;

    public c(Bitmap bitmap, com.bumptech.glide.load.engine.l.c cVar) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        }
        if (cVar != null) {
            this.f2189a = bitmap;
            this.f2190b = cVar;
            return;
        }
        throw new NullPointerException("BitmapPool must not be null");
    }

    public static c a(Bitmap bitmap, com.bumptech.glide.load.engine.l.c cVar) {
        if (bitmap == null) {
            return null;
        }
        return new c(bitmap, cVar);
    }

    @Override // com.bumptech.glide.load.engine.j
    public int getSize() {
        return com.bumptech.glide.s.h.a(this.f2189a);
    }

    @Override // com.bumptech.glide.load.engine.j
    public void a() {
        if (this.f2190b.a(this.f2189a)) {
            return;
        }
        this.f2189a.recycle();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.engine.j
    public Bitmap get() {
        return this.f2189a;
    }
}
