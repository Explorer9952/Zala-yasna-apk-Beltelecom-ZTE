package com.bumptech.glide.load.i.g;

/* compiled from: GifDrawableResource.java */
/* loaded from: classes.dex */
public class d extends com.bumptech.glide.load.i.e.a<b> {
    public d(b bVar) {
        super(bVar);
    }

    @Override // com.bumptech.glide.load.engine.j
    public void a() {
        ((b) this.f2114a).stop();
        ((b) this.f2114a).f();
    }

    @Override // com.bumptech.glide.load.engine.j
    public int getSize() {
        return ((b) this.f2114a).b().length + com.bumptech.glide.s.h.a(((b) this.f2114a).c());
    }
}
