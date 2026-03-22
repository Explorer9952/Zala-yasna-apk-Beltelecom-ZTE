package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import java.io.IOException;

/* compiled from: FileDescriptorBitmapDecoder.java */
/* loaded from: classes.dex */
public class h implements com.bumptech.glide.load.d<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final q f2199a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.l.c f2200b;

    /* renamed from: c, reason: collision with root package name */
    private DecodeFormat f2201c;

    public h(com.bumptech.glide.load.engine.l.c cVar, DecodeFormat decodeFormat) {
        this(new q(), cVar, decodeFormat);
    }

    @Override // com.bumptech.glide.load.d
    public String a() {
        return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
    }

    public h(q qVar, com.bumptech.glide.load.engine.l.c cVar, DecodeFormat decodeFormat) {
        this.f2199a = qVar;
        this.f2200b = cVar;
        this.f2201c = decodeFormat;
    }

    @Override // com.bumptech.glide.load.d
    public com.bumptech.glide.load.engine.j<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i, int i2) throws IOException {
        return c.a(this.f2199a.a(parcelFileDescriptor, this.f2200b, i, i2, this.f2201c), this.f2200b);
    }
}
