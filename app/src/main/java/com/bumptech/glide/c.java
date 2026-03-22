package com.bumptech.glide;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.manager.l;

/* compiled from: DrawableRequestBuilder.java */
/* loaded from: classes.dex */
public class c<ModelType> extends e<ModelType, com.bumptech.glide.load.h.g, com.bumptech.glide.load.i.h.a, com.bumptech.glide.load.i.e.b> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, Class<ModelType> cls, com.bumptech.glide.p.f<ModelType, com.bumptech.glide.load.h.g, com.bumptech.glide.load.i.h.a, com.bumptech.glide.load.i.e.b> fVar, i iVar, l lVar, com.bumptech.glide.manager.g gVar) {
        super(context, cls, fVar, com.bumptech.glide.load.i.e.b.class, iVar, lVar, gVar);
        d();
    }

    @Override // com.bumptech.glide.e
    public /* bridge */ /* synthetic */ e a(com.bumptech.glide.load.d<com.bumptech.glide.load.h.g, com.bumptech.glide.load.i.h.a> dVar) {
        a(dVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    public /* bridge */ /* synthetic */ e b(int i, int i2) {
        b(i, i2);
        return this;
    }

    public c<ModelType> c() {
        a(this.f1914c.f());
        return this;
    }

    public final c<ModelType> d() {
        super.a((com.bumptech.glide.q.i.d) new com.bumptech.glide.q.i.a());
        return this;
    }

    public c<ModelType> e() {
        a(this.f1914c.g());
        return this;
    }

    @Override // com.bumptech.glide.e
    public /* bridge */ /* synthetic */ e a(DiskCacheStrategy diskCacheStrategy) {
        a(diskCacheStrategy);
        return this;
    }

    @Override // com.bumptech.glide.e
    public c<ModelType> b(int i) {
        super.b(i);
        return this;
    }

    public c<ModelType> c(int i) {
        super.a((com.bumptech.glide.q.i.d) new com.bumptech.glide.q.i.a(i));
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    public /* bridge */ /* synthetic */ e a(Object obj) {
        a((c<ModelType>) obj);
        return this;
    }

    @Override // com.bumptech.glide.e
    public c<ModelType> b(int i, int i2) {
        super.b(i, i2);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: clone */
    public c<ModelType> mo3clone() {
        return (c) super.mo3clone();
    }

    @Override // com.bumptech.glide.e
    public /* bridge */ /* synthetic */ e a(com.bumptech.glide.load.b bVar) {
        a(bVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    void b() {
        e();
    }

    @Override // com.bumptech.glide.e
    public /* bridge */ /* synthetic */ e a(boolean z) {
        a(z);
        return this;
    }

    @Override // com.bumptech.glide.e
    public /* bridge */ /* synthetic */ e a(com.bumptech.glide.load.a<com.bumptech.glide.load.h.g> aVar) {
        a(aVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    public /* bridge */ /* synthetic */ e a(com.bumptech.glide.load.f<com.bumptech.glide.load.i.h.a>[] fVarArr) {
        a(fVarArr);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    public c<ModelType> a(com.bumptech.glide.load.d<com.bumptech.glide.load.h.g, com.bumptech.glide.load.i.h.a> dVar) {
        super.a((com.bumptech.glide.load.d) dVar);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    public c<ModelType> a(com.bumptech.glide.load.f<com.bumptech.glide.load.i.h.a>... fVarArr) {
        super.a((com.bumptech.glide.load.f[]) fVarArr);
        return this;
    }

    @Override // com.bumptech.glide.e
    public c<ModelType> a(int i) {
        super.a(i);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    public c<ModelType> a(com.bumptech.glide.q.f<? super ModelType, com.bumptech.glide.load.i.e.b> fVar) {
        super.a((com.bumptech.glide.q.f) fVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    public c<ModelType> a(DiskCacheStrategy diskCacheStrategy) {
        super.a(diskCacheStrategy);
        return this;
    }

    @Override // com.bumptech.glide.e
    public c<ModelType> a(boolean z) {
        super.a(z);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    public c<ModelType> a(com.bumptech.glide.load.a<com.bumptech.glide.load.h.g> aVar) {
        super.a((com.bumptech.glide.load.a) aVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    public c<ModelType> a(com.bumptech.glide.load.b bVar) {
        super.a(bVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    public c<ModelType> a(ModelType modeltype) {
        super.a((c<ModelType>) modeltype);
        return this;
    }

    @Override // com.bumptech.glide.e
    public com.bumptech.glide.q.j.j<com.bumptech.glide.load.i.e.b> a(ImageView imageView) {
        return super.a(imageView);
    }

    @Override // com.bumptech.glide.e
    void a() {
        c();
    }
}
