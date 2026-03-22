package com.bumptech.glide.load.h.s;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.h.l;
import com.bumptech.glide.load.h.m;
import com.bumptech.glide.load.h.q;

/* compiled from: FileDescriptorUriLoader.java */
/* loaded from: classes.dex */
public class e extends q<ParcelFileDescriptor> implements b<Uri> {

    /* compiled from: FileDescriptorUriLoader.java */
    /* loaded from: classes.dex */
    public static class a implements m<Uri, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.h.m
        public l<Uri, ParcelFileDescriptor> a(Context context, com.bumptech.glide.load.h.c cVar) {
            return new e(context, cVar.a(com.bumptech.glide.load.h.d.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.h.m
        public void a() {
        }
    }

    public e(Context context, l<com.bumptech.glide.load.h.d, ParcelFileDescriptor> lVar) {
        super(context, lVar);
    }

    @Override // com.bumptech.glide.load.h.q
    protected com.bumptech.glide.load.g.c<ParcelFileDescriptor> a(Context context, Uri uri) {
        return new com.bumptech.glide.load.g.e(context, uri);
    }

    @Override // com.bumptech.glide.load.h.q
    protected com.bumptech.glide.load.g.c<ParcelFileDescriptor> a(Context context, String str) {
        return new com.bumptech.glide.load.g.d(context.getApplicationContext().getAssets(), str);
    }
}
