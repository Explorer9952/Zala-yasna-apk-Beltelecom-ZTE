package com.bumptech.glide.load.h.s;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.h.l;
import com.bumptech.glide.load.h.m;
import com.bumptech.glide.load.h.p;

/* compiled from: FileDescriptorStringLoader.java */
/* loaded from: classes.dex */
public class d extends p<ParcelFileDescriptor> implements b<String> {

    /* compiled from: FileDescriptorStringLoader.java */
    /* loaded from: classes.dex */
    public static class a implements m<String, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.h.m
        public l<String, ParcelFileDescriptor> a(Context context, com.bumptech.glide.load.h.c cVar) {
            return new d(cVar.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.h.m
        public void a() {
        }
    }

    public d(l<Uri, ParcelFileDescriptor> lVar) {
        super(lVar);
    }
}
