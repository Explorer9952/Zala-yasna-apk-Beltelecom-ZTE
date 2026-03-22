package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.OutputStream;

/* compiled from: BitmapEncoder.java */
/* loaded from: classes.dex */
public class b implements com.bumptech.glide.load.e<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap.CompressFormat f2187a;

    /* renamed from: b, reason: collision with root package name */
    private int f2188b;

    public b() {
        this(null, 90);
    }

    @Override // com.bumptech.glide.load.a
    public String a() {
        return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
    }

    public b(Bitmap.CompressFormat compressFormat, int i) {
        this.f2187a = compressFormat;
        this.f2188b = i;
    }

    @Override // com.bumptech.glide.load.a
    public boolean a(com.bumptech.glide.load.engine.j<Bitmap> jVar, OutputStream outputStream) {
        Bitmap bitmap = jVar.get();
        long a2 = com.bumptech.glide.s.d.a();
        Bitmap.CompressFormat a3 = a(bitmap);
        bitmap.compress(a3, this.f2188b, outputStream);
        if (!Log.isLoggable("BitmapEncoder", 2)) {
            return true;
        }
        Log.v("BitmapEncoder", "Compressed with type: " + a3 + " of size " + com.bumptech.glide.s.h.a(bitmap) + " in " + com.bumptech.glide.s.d.a(a2));
        return true;
    }

    private Bitmap.CompressFormat a(Bitmap bitmap) {
        Bitmap.CompressFormat compressFormat = this.f2187a;
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }
}
