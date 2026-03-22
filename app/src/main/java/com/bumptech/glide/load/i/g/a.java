package com.bumptech.glide.load.i.g;

import android.graphics.Bitmap;
import com.bumptech.glide.m.a;

/* compiled from: GifBitmapProvider.java */
/* loaded from: classes.dex */
class a implements a.InterfaceC0069a {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.l.c f2121a;

    public a(com.bumptech.glide.load.engine.l.c cVar) {
        this.f2121a = cVar;
    }

    @Override // com.bumptech.glide.m.a.InterfaceC0069a
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.f2121a.b(i, i2, config);
    }

    @Override // com.bumptech.glide.m.a.InterfaceC0069a
    public void a(Bitmap bitmap) {
        if (this.f2121a.a(bitmap)) {
            return;
        }
        bitmap.recycle();
    }
}
