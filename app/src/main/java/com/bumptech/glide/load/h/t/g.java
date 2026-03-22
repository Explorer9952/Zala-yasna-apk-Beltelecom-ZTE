package com.bumptech.glide.load.h.t;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.g.i;
import com.bumptech.glide.load.h.l;
import com.bumptech.glide.load.h.m;
import com.bumptech.glide.load.h.q;
import java.io.InputStream;

/* compiled from: StreamUriLoader.java */
/* loaded from: classes.dex */
public class g extends q<InputStream> implements d<Uri> {

    /* compiled from: StreamUriLoader.java */
    /* loaded from: classes.dex */
    public static class a implements m<Uri, InputStream> {
        @Override // com.bumptech.glide.load.h.m
        public l<Uri, InputStream> a(Context context, com.bumptech.glide.load.h.c cVar) {
            return new g(context, cVar.a(com.bumptech.glide.load.h.d.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.h.m
        public void a() {
        }
    }

    public g(Context context, l<com.bumptech.glide.load.h.d, InputStream> lVar) {
        super(context, lVar);
    }

    @Override // com.bumptech.glide.load.h.q
    protected com.bumptech.glide.load.g.c<InputStream> a(Context context, Uri uri) {
        return new i(context, uri);
    }

    @Override // com.bumptech.glide.load.h.q
    protected com.bumptech.glide.load.g.c<InputStream> a(Context context, String str) {
        return new com.bumptech.glide.load.g.h(context.getApplicationContext().getAssets(), str);
    }
}
