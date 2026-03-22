package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;

/* compiled from: FileDescriptorBitmapDataLoadProvider.java */
/* loaded from: classes.dex */
public class g implements com.bumptech.glide.p.b<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.d<File, Bitmap> f2195a;

    /* renamed from: b, reason: collision with root package name */
    private final h f2196b;

    /* renamed from: c, reason: collision with root package name */
    private final b f2197c = new b();

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.a<ParcelFileDescriptor> f2198d = com.bumptech.glide.load.i.a.b();

    public g(com.bumptech.glide.load.engine.l.c cVar, DecodeFormat decodeFormat) {
        this.f2195a = new com.bumptech.glide.load.i.f.c(new o(cVar, decodeFormat));
        this.f2196b = new h(cVar, decodeFormat);
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.a<ParcelFileDescriptor> a() {
        return this.f2198d;
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.e<Bitmap> c() {
        return this.f2197c;
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.d<ParcelFileDescriptor, Bitmap> d() {
        return this.f2196b;
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.d<File, Bitmap> e() {
        return this.f2195a;
    }
}
