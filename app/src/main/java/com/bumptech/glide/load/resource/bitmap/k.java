package com.bumptech.glide.load.resource.bitmap;

/* compiled from: GlideBitmapDrawableResource.java */
/* loaded from: classes.dex */
public class k extends com.bumptech.glide.load.i.e.a<j> {

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.l.c f2210b;

    public k(j jVar, com.bumptech.glide.load.engine.l.c cVar) {
        super(jVar);
        this.f2210b = cVar;
    }

    @Override // com.bumptech.glide.load.engine.j
    public void a() {
        this.f2210b.a(((j) this.f2114a).b());
    }

    @Override // com.bumptech.glide.load.engine.j
    public int getSize() {
        return com.bumptech.glide.s.h.a(((j) this.f2114a).b());
    }
}
