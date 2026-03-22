package com.bumptech.glide.load.i.g;

import android.content.Context;
import com.bumptech.glide.load.h.o;
import java.io.File;
import java.io.InputStream;

/* compiled from: GifDrawableLoadProvider.java */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.p.b<InputStream, b> {

    /* renamed from: a, reason: collision with root package name */
    private final i f2130a;

    /* renamed from: b, reason: collision with root package name */
    private final j f2131b;

    /* renamed from: c, reason: collision with root package name */
    private final o f2132c = new o();

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.i.f.c<b> f2133d;

    public c(Context context, com.bumptech.glide.load.engine.l.c cVar) {
        this.f2130a = new i(context, cVar);
        this.f2133d = new com.bumptech.glide.load.i.f.c<>(this.f2130a);
        this.f2131b = new j(cVar);
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.a<InputStream> a() {
        return this.f2132c;
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.e<b> c() {
        return this.f2131b;
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.d<InputStream, b> d() {
        return this.f2130a;
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.d<File, b> e() {
        return this.f2133d;
    }
}
