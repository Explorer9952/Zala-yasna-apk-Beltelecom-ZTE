package com.bumptech.glide;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.o;

/* compiled from: BitmapRequestBuilder.java */
/* loaded from: classes.dex */
public class a<ModelType, TranscodeType> extends e<ModelType, com.bumptech.glide.load.h.g, Bitmap, TranscodeType> {
    private final com.bumptech.glide.load.engine.l.c D;
    private DecodeFormat E;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.bumptech.glide.p.f<ModelType, com.bumptech.glide.load.h.g, Bitmap, TranscodeType> fVar, Class<TranscodeType> cls, e<ModelType, ?, ?, ?> eVar) {
        super(fVar, cls, eVar);
        com.bumptech.glide.load.resource.bitmap.f fVar2 = com.bumptech.glide.load.resource.bitmap.f.f2194c;
        this.D = eVar.f1914c.d();
        DecodeFormat e = eVar.f1914c.e();
        this.E = e;
        new o(this.D, e);
        new com.bumptech.glide.load.resource.bitmap.h(this.D, this.E);
    }

    @Override // com.bumptech.glide.e
    public /* bridge */ /* synthetic */ e a(com.bumptech.glide.load.d<com.bumptech.glide.load.h.g, Bitmap> dVar) {
        a(dVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    public /* bridge */ /* synthetic */ e b(int i, int i2) {
        b(i, i2);
        return this;
    }

    public a<ModelType, TranscodeType> c() {
        a(this.f1914c.b());
        return this;
    }

    public a<ModelType, TranscodeType> d() {
        a(this.f1914c.c());
        return this;
    }

    @Override // com.bumptech.glide.e
    public /* bridge */ /* synthetic */ e a(DiskCacheStrategy diskCacheStrategy) {
        a(diskCacheStrategy);
        return this;
    }

    @Override // com.bumptech.glide.e
    public a<ModelType, TranscodeType> b(int i, int i2) {
        super.b(i, i2);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    public /* bridge */ /* synthetic */ e a(Object obj) {
        a((a<ModelType, TranscodeType>) obj);
        return this;
    }

    @Override // com.bumptech.glide.e
    void b() {
        d();
    }

    @Override // com.bumptech.glide.e
    /* renamed from: clone */
    public a<ModelType, TranscodeType> mo3clone() {
        return (a) super.mo3clone();
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
    public /* bridge */ /* synthetic */ e a(com.bumptech.glide.load.a<com.bumptech.glide.load.h.g> aVar) {
        a(aVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    public /* bridge */ /* synthetic */ e a(com.bumptech.glide.load.f<Bitmap>[] fVarArr) {
        a(fVarArr);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    public a<ModelType, TranscodeType> a(com.bumptech.glide.load.d<com.bumptech.glide.load.h.g, Bitmap> dVar) {
        super.a((com.bumptech.glide.load.d) dVar);
        return this;
    }

    public a<ModelType, TranscodeType> a(com.bumptech.glide.load.resource.bitmap.d... dVarArr) {
        super.a((com.bumptech.glide.load.f[]) dVarArr);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    public a<ModelType, TranscodeType> a(com.bumptech.glide.load.f<Bitmap>... fVarArr) {
        super.a((com.bumptech.glide.load.f[]) fVarArr);
        return this;
    }

    @Override // com.bumptech.glide.e
    public a<ModelType, TranscodeType> a(com.bumptech.glide.q.f<? super ModelType, TranscodeType> fVar) {
        super.a((com.bumptech.glide.q.f) fVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    public a<ModelType, TranscodeType> a(boolean z) {
        super.a(z);
        return this;
    }

    @Override // com.bumptech.glide.e
    public a<ModelType, TranscodeType> a(DiskCacheStrategy diskCacheStrategy) {
        super.a(diskCacheStrategy);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    public a<ModelType, TranscodeType> a(com.bumptech.glide.load.a<com.bumptech.glide.load.h.g> aVar) {
        super.a((com.bumptech.glide.load.a) aVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    public a<ModelType, TranscodeType> a(com.bumptech.glide.load.b bVar) {
        super.a(bVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    public a<ModelType, TranscodeType> a(ModelType modeltype) {
        super.a((a<ModelType, TranscodeType>) modeltype);
        return this;
    }

    @Override // com.bumptech.glide.e
    public com.bumptech.glide.q.j.j<TranscodeType> a(ImageView imageView) {
        return super.a(imageView);
    }

    @Override // com.bumptech.glide.e
    void a() {
        c();
    }
}
