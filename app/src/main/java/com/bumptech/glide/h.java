package com.bumptech.glide;

import com.bumptech.glide.k;
import com.bumptech.glide.load.h.l;
import java.io.InputStream;

/* compiled from: GifTypeRequest.java */
/* loaded from: classes.dex */
public class h<ModelType> extends g<ModelType> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e<ModelType, ?, ?, ?> eVar, l<ModelType, InputStream> lVar, k.d dVar) {
        super(a(eVar.f1914c, lVar, com.bumptech.glide.load.i.g.b.class, (com.bumptech.glide.load.i.i.c) null), com.bumptech.glide.load.i.g.b.class, eVar);
        d();
    }

    private static <A, R> com.bumptech.glide.p.e<A, InputStream, com.bumptech.glide.load.i.g.b, R> a(i iVar, l<A, InputStream> lVar, Class<R> cls, com.bumptech.glide.load.i.i.c<com.bumptech.glide.load.i.g.b, R> cVar) {
        if (lVar == null) {
            return null;
        }
        if (cVar == null) {
            cVar = iVar.b(com.bumptech.glide.load.i.g.b.class, cls);
        }
        return new com.bumptech.glide.p.e<>(lVar, cVar, iVar.a(InputStream.class, com.bumptech.glide.load.i.g.b.class));
    }
}
