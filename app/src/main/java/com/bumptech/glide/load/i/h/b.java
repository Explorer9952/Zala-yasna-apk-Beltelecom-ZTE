package com.bumptech.glide.load.i.h;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.j;

/* compiled from: GifBitmapWrapperResource.java */
/* loaded from: classes.dex */
public class b implements j<a> {

    /* renamed from: a, reason: collision with root package name */
    private final a f2157a;

    public b(a aVar) {
        if (aVar != null) {
            this.f2157a = aVar;
            return;
        }
        throw new NullPointerException("Data must not be null");
    }

    @Override // com.bumptech.glide.load.engine.j
    public void a() {
        j<Bitmap> a2 = this.f2157a.a();
        if (a2 != null) {
            a2.a();
        }
        j<com.bumptech.glide.load.i.g.b> b2 = this.f2157a.b();
        if (b2 != null) {
            b2.a();
        }
    }

    @Override // com.bumptech.glide.load.engine.j
    public int getSize() {
        return this.f2157a.c();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.engine.j
    public a get() {
        return this.f2157a;
    }
}
