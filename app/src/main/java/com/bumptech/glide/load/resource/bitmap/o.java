package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import java.io.InputStream;

/* compiled from: StreamBitmapDecoder.java */
/* loaded from: classes.dex */
public class o implements com.bumptech.glide.load.d<InputStream, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final f f2221a;

    /* renamed from: b, reason: collision with root package name */
    private com.bumptech.glide.load.engine.l.c f2222b;

    /* renamed from: c, reason: collision with root package name */
    private DecodeFormat f2223c;

    /* renamed from: d, reason: collision with root package name */
    private String f2224d;

    public o(com.bumptech.glide.load.engine.l.c cVar, DecodeFormat decodeFormat) {
        this(f.f2194c, cVar, decodeFormat);
    }

    public o(f fVar, com.bumptech.glide.load.engine.l.c cVar, DecodeFormat decodeFormat) {
        this.f2221a = fVar;
        this.f2222b = cVar;
        this.f2223c = decodeFormat;
    }

    @Override // com.bumptech.glide.load.d
    public com.bumptech.glide.load.engine.j<Bitmap> a(InputStream inputStream, int i, int i2) {
        return c.a(this.f2221a.a(inputStream, this.f2222b, i, i2, this.f2223c), this.f2222b);
    }

    @Override // com.bumptech.glide.load.d
    public String a() {
        if (this.f2224d == null) {
            this.f2224d = "StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap" + this.f2221a.a() + this.f2223c.name();
        }
        return this.f2224d;
    }
}
