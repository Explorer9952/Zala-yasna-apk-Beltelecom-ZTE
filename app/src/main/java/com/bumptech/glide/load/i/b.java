package com.bumptech.glide.load.i;

import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.j;
import java.io.OutputStream;

/* compiled from: NullResourceEncoder.java */
/* loaded from: classes.dex */
public class b<T> implements e<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final b<?> f2111a = new b<>();

    public static <T> b<T> b() {
        return (b<T>) f2111a;
    }

    @Override // com.bumptech.glide.load.a
    public String a() {
        return "";
    }

    @Override // com.bumptech.glide.load.a
    public boolean a(j<T> jVar, OutputStream outputStream) {
        return false;
    }
}
