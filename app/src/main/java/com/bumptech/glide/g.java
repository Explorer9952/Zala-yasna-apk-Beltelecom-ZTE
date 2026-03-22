package com.bumptech.glide;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.InputStream;

/* compiled from: GifRequestBuilder.java */
/* loaded from: classes.dex */
public class g<ModelType> extends e<ModelType, InputStream, com.bumptech.glide.load.i.g.b, com.bumptech.glide.load.i.g.b> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.bumptech.glide.p.f<ModelType, InputStream, com.bumptech.glide.load.i.g.b, com.bumptech.glide.load.i.g.b> fVar, Class<com.bumptech.glide.load.i.g.b> cls, e<ModelType, ?, ?, ?> eVar) {
        super(fVar, cls, eVar);
    }

    @Override // com.bumptech.glide.e
    public /* bridge */ /* synthetic */ e a(com.bumptech.glide.load.d<InputStream, com.bumptech.glide.load.i.g.b> dVar) {
        a2(dVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    public /* bridge */ /* synthetic */ e b(int i, int i2) {
        b(i, i2);
        return this;
    }

    public g<ModelType> c() {
        a(this.f1914c.b());
        return this;
    }

    public g<ModelType> d() {
        super.a((com.bumptech.glide.q.i.d) new com.bumptech.glide.q.i.a());
        return this;
    }

    public g<ModelType> e() {
        a(this.f1914c.c());
        return this;
    }

    private com.bumptech.glide.load.i.g.e[] b(com.bumptech.glide.load.f<Bitmap>[] fVarArr) {
        com.bumptech.glide.load.i.g.e[] eVarArr = new com.bumptech.glide.load.i.g.e[fVarArr.length];
        for (int i = 0; i < fVarArr.length; i++) {
            eVarArr[i] = new com.bumptech.glide.load.i.g.e(fVarArr[i], this.f1914c.d());
        }
        return eVarArr;
    }

    @Override // com.bumptech.glide.e
    public /* bridge */ /* synthetic */ e a(DiskCacheStrategy diskCacheStrategy) {
        a(diskCacheStrategy);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    public /* bridge */ /* synthetic */ e a(Object obj) {
        a((g<ModelType>) obj);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: clone */
    public g<ModelType> mo3clone() {
        return (g) super.mo3clone();
    }

    @Override // com.bumptech.glide.e
    public /* bridge */ /* synthetic */ e a(com.bumptech.glide.load.b bVar) {
        a(bVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    public /* bridge */ /* synthetic */ e a(boolean z) {
        a(z);
        return this;
    }

    @Override // com.bumptech.glide.e
    public g<ModelType> b(int i, int i2) {
        super.b(i, i2);
        return this;
    }

    @Override // com.bumptech.glide.e
    public /* bridge */ /* synthetic */ e a(com.bumptech.glide.load.a<InputStream> aVar) {
        a2(aVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    void b() {
        e();
    }

    @Override // com.bumptech.glide.e
    public /* bridge */ /* synthetic */ e a(com.bumptech.glide.load.f<com.bumptech.glide.load.i.g.b>[] fVarArr) {
        a2(fVarArr);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    /* renamed from: a, reason: avoid collision after fix types in other method */
    public g<ModelType> a2(com.bumptech.glide.load.d<InputStream, com.bumptech.glide.load.i.g.b> dVar) {
        super.a((com.bumptech.glide.load.d) dVar);
        return this;
    }

    public g<ModelType> a(com.bumptech.glide.load.resource.bitmap.d... dVarArr) {
        a2((com.bumptech.glide.load.f<com.bumptech.glide.load.i.g.b>[]) b(dVarArr));
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    /* renamed from: a, reason: avoid collision after fix types in other method */
    public g<ModelType> a2(com.bumptech.glide.load.f<com.bumptech.glide.load.i.g.b>... fVarArr) {
        super.a((com.bumptech.glide.load.f[]) fVarArr);
        return this;
    }

    @Override // com.bumptech.glide.e
    public g<ModelType> a(boolean z) {
        super.a(z);
        return this;
    }

    @Override // com.bumptech.glide.e
    public g<ModelType> a(DiskCacheStrategy diskCacheStrategy) {
        super.a(diskCacheStrategy);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    /* renamed from: a, reason: avoid collision after fix types in other method */
    public g<ModelType> a2(com.bumptech.glide.load.a<InputStream> aVar) {
        super.a((com.bumptech.glide.load.a) aVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    public g<ModelType> a(com.bumptech.glide.load.b bVar) {
        super.a(bVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    public g<ModelType> a(ModelType modeltype) {
        super.a((g<ModelType>) modeltype);
        return this;
    }

    @Override // com.bumptech.glide.e
    void a() {
        c();
    }
}
