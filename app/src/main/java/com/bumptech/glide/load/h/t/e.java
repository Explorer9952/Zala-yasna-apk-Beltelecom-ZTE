package com.bumptech.glide.load.h.t;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.h.l;
import com.bumptech.glide.load.h.m;
import com.bumptech.glide.load.h.n;
import java.io.InputStream;

/* compiled from: StreamResourceLoader.java */
/* loaded from: classes.dex */
public class e extends n<InputStream> implements d<Integer> {

    /* compiled from: StreamResourceLoader.java */
    /* loaded from: classes.dex */
    public static class a implements m<Integer, InputStream> {
        @Override // com.bumptech.glide.load.h.m
        public l<Integer, InputStream> a(Context context, com.bumptech.glide.load.h.c cVar) {
            return new e(context, cVar.a(Uri.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.h.m
        public void a() {
        }
    }

    public e(Context context, l<Uri, InputStream> lVar) {
        super(context, lVar);
    }
}
