package com.bumptech.glide.load.i;

import java.io.OutputStream;

/* compiled from: NullEncoder.java */
/* loaded from: classes.dex */
public class a<T> implements com.bumptech.glide.load.a<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final a<?> f2110a = new a<>();

    public static <T> com.bumptech.glide.load.a<T> b() {
        return f2110a;
    }

    @Override // com.bumptech.glide.load.a
    public String a() {
        return "";
    }

    @Override // com.bumptech.glide.load.a
    public boolean a(T t, OutputStream outputStream) {
        return false;
    }
}
