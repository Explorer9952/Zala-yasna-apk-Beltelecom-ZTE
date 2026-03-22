package com.bumptech.glide.load.i.f;

import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.load.h.o;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamFileDataLoadProvider.java */
/* loaded from: classes.dex */
public class d implements com.bumptech.glide.p.b<InputStream, File> {

    /* renamed from: c, reason: collision with root package name */
    private static final b f2118c = new b();

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.d<File, File> f2119a = new com.bumptech.glide.load.i.f.a();

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.a<InputStream> f2120b = new o();

    /* compiled from: StreamFileDataLoadProvider.java */
    /* loaded from: classes.dex */
    private static class b implements com.bumptech.glide.load.d<InputStream, File> {
        private b() {
        }

        @Override // com.bumptech.glide.load.d
        public /* bridge */ /* synthetic */ j<File> a(InputStream inputStream, int i, int i2) throws IOException {
            a2(inputStream, i, i2);
            throw null;
        }

        @Override // com.bumptech.glide.load.d
        public String a() {
            return "";
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        public j<File> a2(InputStream inputStream, int i, int i2) {
            throw new Error("You cannot decode a File from an InputStream by default, try either #diskCacheStratey(DiskCacheStrategy.SOURCE) to avoid this call or #decoder(ResourceDecoder) to replace this Decoder");
        }
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.a<InputStream> a() {
        return this.f2120b;
    }

    @Override // com.bumptech.glide.p.b
    public e<File> c() {
        return com.bumptech.glide.load.i.b.b();
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.d<InputStream, File> d() {
        return f2118c;
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.d<File, File> e() {
        return this.f2119a;
    }
}
