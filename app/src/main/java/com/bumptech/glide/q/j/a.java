package com.bumptech.glide.q.j;

import android.graphics.drawable.Drawable;

/* compiled from: BaseTarget.java */
/* loaded from: classes.dex */
public abstract class a<Z> implements j<Z> {

    /* renamed from: a, reason: collision with root package name */
    private com.bumptech.glide.q.c f2317a;

    @Override // com.bumptech.glide.q.j.j
    public void a(com.bumptech.glide.q.c cVar) {
        this.f2317a = cVar;
    }

    @Override // com.bumptech.glide.q.j.j
    public void a(Exception exc, Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.h
    public void b() {
    }

    @Override // com.bumptech.glide.q.j.j
    public void b(Drawable drawable) {
    }

    @Override // com.bumptech.glide.q.j.j
    public void c(Drawable drawable) {
    }

    @Override // com.bumptech.glide.q.j.j
    public com.bumptech.glide.q.c d() {
        return this.f2317a;
    }

    @Override // com.bumptech.glide.manager.h
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.h
    public void onStop() {
    }
}
