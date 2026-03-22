package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;
import java.io.InputStream;

/* compiled from: StreamBitmapDataLoadProvider.java */
/* loaded from: classes.dex */
public class n implements com.bumptech.glide.p.b<InputStream, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final o f2217a;

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.i.f.c<Bitmap> f2220d;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.h.o f2219c = new com.bumptech.glide.load.h.o();

    /* renamed from: b, reason: collision with root package name */
    private final b f2218b = new b();

    public n(com.bumptech.glide.load.engine.l.c cVar, DecodeFormat decodeFormat) {
        this.f2217a = new o(cVar, decodeFormat);
        this.f2220d = new com.bumptech.glide.load.i.f.c<>(this.f2217a);
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.a<InputStream> a() {
        return this.f2219c;
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.e<Bitmap> c() {
        return this.f2218b;
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.d<InputStream, Bitmap> d() {
        return this.f2217a;
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.d<File, Bitmap> e() {
        return this.f2220d;
    }
}
