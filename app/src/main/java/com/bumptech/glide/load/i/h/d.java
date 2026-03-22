package com.bumptech.glide.load.i.h;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.j;
import java.io.OutputStream;

/* compiled from: GifBitmapWrapperResourceEncoder.java */
/* loaded from: classes.dex */
public class d implements com.bumptech.glide.load.e<a> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.e<Bitmap> f2162a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.e<com.bumptech.glide.load.i.g.b> f2163b;

    /* renamed from: c, reason: collision with root package name */
    private String f2164c;

    public d(com.bumptech.glide.load.e<Bitmap> eVar, com.bumptech.glide.load.e<com.bumptech.glide.load.i.g.b> eVar2) {
        this.f2162a = eVar;
        this.f2163b = eVar2;
    }

    @Override // com.bumptech.glide.load.a
    public boolean a(j<a> jVar, OutputStream outputStream) {
        a aVar = jVar.get();
        j<Bitmap> a2 = aVar.a();
        if (a2 != null) {
            return this.f2162a.a(a2, outputStream);
        }
        return this.f2163b.a(aVar.b(), outputStream);
    }

    @Override // com.bumptech.glide.load.a
    public String a() {
        if (this.f2164c == null) {
            this.f2164c = this.f2162a.a() + this.f2163b.a();
        }
        return this.f2164c;
    }
}
