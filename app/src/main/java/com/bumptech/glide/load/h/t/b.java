package com.bumptech.glide.load.h.t;

import android.content.Context;
import com.bumptech.glide.load.h.l;
import com.bumptech.glide.load.h.m;
import java.io.InputStream;

/* compiled from: StreamByteArrayLoader.java */
/* loaded from: classes.dex */
public class b implements d<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private final String f2109a;

    /* compiled from: StreamByteArrayLoader.java */
    /* loaded from: classes.dex */
    public static class a implements m<byte[], InputStream> {
        @Override // com.bumptech.glide.load.h.m
        public l<byte[], InputStream> a(Context context, com.bumptech.glide.load.h.c cVar) {
            return new b();
        }

        @Override // com.bumptech.glide.load.h.m
        public void a() {
        }
    }

    public b() {
        this("");
    }

    @Deprecated
    public b(String str) {
        this.f2109a = str;
    }

    @Override // com.bumptech.glide.load.h.l
    public com.bumptech.glide.load.g.c<InputStream> a(byte[] bArr, int i, int i2) {
        return new com.bumptech.glide.load.g.b(bArr, this.f2109a);
    }
}
