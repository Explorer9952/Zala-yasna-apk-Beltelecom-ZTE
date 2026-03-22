package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.k;
import com.bumptech.glide.load.h.l;

/* compiled from: GenericTranscodeRequest.java */
/* loaded from: classes.dex */
public class f<ModelType, DataType, ResourceType> extends e<ModelType, DataType, ResourceType, ResourceType> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context, i iVar, Class<ModelType> cls, l<ModelType, DataType> lVar, Class<DataType> cls2, Class<ResourceType> cls3, com.bumptech.glide.manager.l lVar2, com.bumptech.glide.manager.g gVar, k.d dVar) {
        super(context, cls, a(iVar, lVar, cls2, cls3, com.bumptech.glide.load.i.i.e.b()), cls3, iVar, lVar2, gVar);
    }

    private static <A, T, Z, R> com.bumptech.glide.p.f<A, T, Z, R> a(i iVar, l<A, T> lVar, Class<T> cls, Class<Z> cls2, com.bumptech.glide.load.i.i.c<Z, R> cVar) {
        return new com.bumptech.glide.p.e(lVar, cVar, iVar.a(cls, cls2));
    }
}
