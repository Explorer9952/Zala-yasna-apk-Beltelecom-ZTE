package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;

/* compiled from: FitCenter.java */
/* loaded from: classes.dex */
public class i extends d {
    public i(com.bumptech.glide.load.engine.l.c cVar) {
        super(cVar);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.d
    protected Bitmap a(com.bumptech.glide.load.engine.l.c cVar, Bitmap bitmap, int i, int i2) {
        return p.a(bitmap, cVar, i, i2);
    }

    @Override // com.bumptech.glide.load.f
    public String a() {
        return "FitCenter.com.bumptech.glide.load.resource.bitmap";
    }
}
