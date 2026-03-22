package com.bumptech.glide.load.i;

import com.bumptech.glide.load.engine.j;

/* compiled from: SimpleResource.java */
/* loaded from: classes.dex */
public class c<T> implements j<T> {

    /* renamed from: a, reason: collision with root package name */
    protected final T f2112a;

    public c(T t) {
        if (t != null) {
            this.f2112a = t;
            return;
        }
        throw new NullPointerException("Data must not be null");
    }

    @Override // com.bumptech.glide.load.engine.j
    public void a() {
    }

    @Override // com.bumptech.glide.load.engine.j
    public final T get() {
        return this.f2112a;
    }

    @Override // com.bumptech.glide.load.engine.j
    public final int getSize() {
        return 1;
    }
}
