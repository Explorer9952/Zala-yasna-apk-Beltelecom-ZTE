package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.InputStream;

/* compiled from: ImageVideoDataLoadProvider.java */
/* loaded from: classes.dex */
public class m implements com.bumptech.glide.p.b<com.bumptech.glide.load.h.g, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final l f2213a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.d<File, Bitmap> f2214b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.e<Bitmap> f2215c;

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.h.h f2216d;

    public m(com.bumptech.glide.p.b<InputStream, Bitmap> bVar, com.bumptech.glide.p.b<ParcelFileDescriptor, Bitmap> bVar2) {
        this.f2215c = bVar.c();
        this.f2216d = new com.bumptech.glide.load.h.h(bVar.a(), bVar2.a());
        this.f2214b = bVar.e();
        this.f2213a = new l(bVar.d(), bVar2.d());
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.a<com.bumptech.glide.load.h.g> a() {
        return this.f2216d;
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.e<Bitmap> c() {
        return this.f2215c;
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.d<com.bumptech.glide.load.h.g, Bitmap> d() {
        return this.f2213a;
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.d<File, Bitmap> e() {
        return this.f2214b;
    }
}
