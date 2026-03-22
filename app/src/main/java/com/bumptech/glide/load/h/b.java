package com.bumptech.glide.load.h;

import android.net.Uri;
import java.io.File;

/* compiled from: FileLoader.java */
/* loaded from: classes.dex */
public class b<T> implements l<File, T> {

    /* renamed from: a, reason: collision with root package name */
    private final l<Uri, T> f2070a;

    public b(l<Uri, T> lVar) {
        this.f2070a = lVar;
    }

    @Override // com.bumptech.glide.load.h.l
    public com.bumptech.glide.load.g.c<T> a(File file, int i, int i2) {
        return this.f2070a.a(Uri.fromFile(file), i, i2);
    }
}
