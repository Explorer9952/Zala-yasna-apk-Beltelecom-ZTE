package com.bumptech.glide;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.k;
import com.bumptech.glide.load.h.l;
import java.io.InputStream;

/* compiled from: DrawableTypeRequest.java */
/* loaded from: classes.dex */
public class d<ModelType> extends c<ModelType> {
    private final l<ModelType, InputStream> D;
    private final l<ModelType, ParcelFileDescriptor> E;
    private final k.d F;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Class<ModelType> cls, l<ModelType, InputStream> lVar, l<ModelType, ParcelFileDescriptor> lVar2, Context context, i iVar, com.bumptech.glide.manager.l lVar3, com.bumptech.glide.manager.g gVar, k.d dVar) {
        super(context, cls, a(iVar, lVar, lVar2, com.bumptech.glide.load.i.h.a.class, com.bumptech.glide.load.i.e.b.class, null), iVar, lVar3, gVar);
        this.D = lVar;
        this.E = lVar2;
        this.F = dVar;
    }

    private static <A, Z, R> com.bumptech.glide.p.e<A, com.bumptech.glide.load.h.g, Z, R> a(i iVar, l<A, InputStream> lVar, l<A, ParcelFileDescriptor> lVar2, Class<Z> cls, Class<R> cls2, com.bumptech.glide.load.i.i.c<Z, R> cVar) {
        if (lVar == null && lVar2 == null) {
            return null;
        }
        if (cVar == null) {
            cVar = iVar.b(cls, cls2);
        }
        return new com.bumptech.glide.p.e<>(new com.bumptech.glide.load.h.f(lVar, lVar2), cVar, iVar.a(com.bumptech.glide.load.h.g.class, cls));
    }

    public b<ModelType> f() {
        k.d dVar = this.F;
        b<ModelType> bVar = new b<>(this, this.D, this.E, dVar);
        dVar.a(bVar);
        return bVar;
    }

    public h<ModelType> h() {
        k.d dVar = this.F;
        h<ModelType> hVar = new h<>(this, this.D, dVar);
        dVar.a(hVar);
        return hVar;
    }
}
