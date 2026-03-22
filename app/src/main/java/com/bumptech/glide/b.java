package com.bumptech.glide;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.k;
import com.bumptech.glide.load.h.l;
import java.io.InputStream;

/* compiled from: BitmapTypeRequest.java */
/* loaded from: classes.dex */
public class b<ModelType> extends a<ModelType, Bitmap> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(e<ModelType, ?, ?, ?> eVar, l<ModelType, InputStream> lVar, l<ModelType, ParcelFileDescriptor> lVar2, k.d dVar) {
        super(a(eVar.f1914c, lVar, lVar2, Bitmap.class, null), Bitmap.class, eVar);
        i iVar = eVar.f1914c;
    }

    private static <A, R> com.bumptech.glide.p.e<A, com.bumptech.glide.load.h.g, Bitmap, R> a(i iVar, l<A, InputStream> lVar, l<A, ParcelFileDescriptor> lVar2, Class<R> cls, com.bumptech.glide.load.i.i.c<Bitmap, R> cVar) {
        if (lVar == null && lVar2 == null) {
            return null;
        }
        if (cVar == null) {
            cVar = iVar.b(Bitmap.class, cls);
        }
        return new com.bumptech.glide.p.e<>(new com.bumptech.glide.load.h.f(lVar, lVar2), cVar, iVar.a(com.bumptech.glide.load.h.g.class, Bitmap.class));
    }
}
