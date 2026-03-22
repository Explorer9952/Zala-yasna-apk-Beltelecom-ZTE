package com.bumptech.glide.load.h.s;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.h.l;
import com.bumptech.glide.load.h.m;
import java.io.File;

/* compiled from: FileDescriptorFileLoader.java */
/* loaded from: classes.dex */
public class a extends com.bumptech.glide.load.h.b<ParcelFileDescriptor> implements b<File> {

    /* compiled from: FileDescriptorFileLoader.java */
    /* renamed from: com.bumptech.glide.load.h.s.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0067a implements m<File, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.h.m
        public l<File, ParcelFileDescriptor> a(Context context, com.bumptech.glide.load.h.c cVar) {
            return new a(cVar.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.h.m
        public void a() {
        }
    }

    public a(l<Uri, ParcelFileDescriptor> lVar) {
        super(lVar);
    }
}
