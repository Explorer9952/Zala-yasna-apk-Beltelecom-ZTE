package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;

/* compiled from: CenterCrop.java */
/* loaded from: classes.dex */
public class e extends d {
    public e(com.bumptech.glide.load.engine.l.c cVar) {
        super(cVar);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.d
    protected Bitmap a(com.bumptech.glide.load.engine.l.c cVar, Bitmap bitmap, int i, int i2) {
        Bitmap a2 = cVar.a(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        Bitmap a3 = p.a(a2, bitmap, i, i2);
        if (a2 != null && a2 != a3 && !cVar.a(a2)) {
            a2.recycle();
        }
        return a3;
    }

    @Override // com.bumptech.glide.load.f
    public String a() {
        return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
    }
}
