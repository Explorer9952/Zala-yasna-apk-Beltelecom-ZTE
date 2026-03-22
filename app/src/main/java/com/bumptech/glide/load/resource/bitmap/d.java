package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;

/* compiled from: BitmapTransformation.java */
/* loaded from: classes.dex */
public abstract class d implements com.bumptech.glide.load.f<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private com.bumptech.glide.load.engine.l.c f2191a;

    public d(com.bumptech.glide.load.engine.l.c cVar) {
        this.f2191a = cVar;
    }

    protected abstract Bitmap a(com.bumptech.glide.load.engine.l.c cVar, Bitmap bitmap, int i, int i2);

    @Override // com.bumptech.glide.load.f
    public final com.bumptech.glide.load.engine.j<Bitmap> a(com.bumptech.glide.load.engine.j<Bitmap> jVar, int i, int i2) {
        if (com.bumptech.glide.s.h.a(i, i2)) {
            Bitmap bitmap = jVar.get();
            if (i == Integer.MIN_VALUE) {
                i = bitmap.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getHeight();
            }
            Bitmap a2 = a(this.f2191a, bitmap, i, i2);
            return bitmap.equals(a2) ? jVar : c.a(a2, this.f2191a);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
