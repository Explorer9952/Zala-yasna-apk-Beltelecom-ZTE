package com.bumptech.glide.load.h;

import java.net.URL;

/* compiled from: UrlLoader.java */
/* loaded from: classes.dex */
public class r<T> implements l<URL, T> {

    /* renamed from: a, reason: collision with root package name */
    private final l<d, T> f2106a;

    public r(l<d, T> lVar) {
        this.f2106a = lVar;
    }

    @Override // com.bumptech.glide.load.h.l
    public com.bumptech.glide.load.g.c<T> a(URL url, int i, int i2) {
        return this.f2106a.a(new d(url), i, i2);
    }
}
