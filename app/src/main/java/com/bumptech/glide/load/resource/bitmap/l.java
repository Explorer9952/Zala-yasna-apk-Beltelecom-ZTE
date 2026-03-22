package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ImageVideoBitmapDecoder.java */
/* loaded from: classes.dex */
public class l implements com.bumptech.glide.load.d<com.bumptech.glide.load.h.g, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.d<InputStream, Bitmap> f2211a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.d<ParcelFileDescriptor, Bitmap> f2212b;

    public l(com.bumptech.glide.load.d<InputStream, Bitmap> dVar, com.bumptech.glide.load.d<ParcelFileDescriptor, Bitmap> dVar2) {
        this.f2211a = dVar;
        this.f2212b = dVar2;
    }

    @Override // com.bumptech.glide.load.d
    public String a() {
        return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }

    @Override // com.bumptech.glide.load.d
    public com.bumptech.glide.load.engine.j<Bitmap> a(com.bumptech.glide.load.h.g gVar, int i, int i2) throws IOException {
        com.bumptech.glide.load.engine.j<Bitmap> a2;
        ParcelFileDescriptor a3;
        InputStream b2 = gVar.b();
        if (b2 != null) {
            try {
                a2 = this.f2211a.a(b2, i, i2);
            } catch (IOException e) {
                if (Log.isLoggable("ImageVideoDecoder", 2)) {
                    Log.v("ImageVideoDecoder", "Failed to load image from stream, trying FileDescriptor", e);
                }
            }
            return (a2 != null || (a3 = gVar.a()) == null) ? a2 : this.f2212b.a(a3, i, i2);
        }
        a2 = null;
        if (a2 != null) {
            return a2;
        }
    }
}
