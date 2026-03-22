package com.bumptech.glide.load.h.s;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.h.l;
import com.bumptech.glide.load.h.m;
import com.bumptech.glide.load.h.n;

/* compiled from: FileDescriptorResourceLoader.java */
/* loaded from: classes.dex */
public class c extends n<ParcelFileDescriptor> implements b<Integer> {

    /* compiled from: FileDescriptorResourceLoader.java */
    /* loaded from: classes.dex */
    public static class a implements m<Integer, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.h.m
        public l<Integer, ParcelFileDescriptor> a(Context context, com.bumptech.glide.load.h.c cVar) {
            return new c(context, cVar.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.h.m
        public void a() {
        }
    }

    public c(Context context, l<Uri, ParcelFileDescriptor> lVar) {
        super(context, lVar);
    }
}
