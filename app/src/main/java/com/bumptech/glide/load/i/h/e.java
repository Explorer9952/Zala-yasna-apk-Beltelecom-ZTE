package com.bumptech.glide.load.i.h;

import com.bumptech.glide.load.engine.j;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: GifBitmapWrapperStreamResourceDecoder.java */
/* loaded from: classes.dex */
public class e implements com.bumptech.glide.load.d<InputStream, a> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.d<com.bumptech.glide.load.h.g, a> f2165a;

    public e(com.bumptech.glide.load.d<com.bumptech.glide.load.h.g, a> dVar) {
        this.f2165a = dVar;
    }

    @Override // com.bumptech.glide.load.d
    public j<a> a(InputStream inputStream, int i, int i2) throws IOException {
        return this.f2165a.a(new com.bumptech.glide.load.h.g(inputStream, null), i, i2);
    }

    @Override // com.bumptech.glide.load.d
    public String a() {
        return this.f2165a.a();
    }
}
