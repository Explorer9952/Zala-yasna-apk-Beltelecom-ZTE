package com.bumptech.glide.load.h.t;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.h.l;
import com.bumptech.glide.load.h.m;
import com.bumptech.glide.load.h.p;
import java.io.InputStream;

/* compiled from: StreamStringLoader.java */
/* loaded from: classes.dex */
public class f extends p<InputStream> implements d<String> {

    /* compiled from: StreamStringLoader.java */
    /* loaded from: classes.dex */
    public static class a implements m<String, InputStream> {
        @Override // com.bumptech.glide.load.h.m
        public l<String, InputStream> a(Context context, com.bumptech.glide.load.h.c cVar) {
            return new f(cVar.a(Uri.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.h.m
        public void a() {
        }
    }

    public f(l<Uri, InputStream> lVar) {
        super(lVar);
    }
}
