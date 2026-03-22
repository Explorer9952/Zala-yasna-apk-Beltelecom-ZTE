package com.bumptech.glide.load.h;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: ImageVideoWrapperEncoder.java */
/* loaded from: classes.dex */
public class h implements com.bumptech.glide.load.a<g> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.a<InputStream> f2086a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.a<ParcelFileDescriptor> f2087b;

    /* renamed from: c, reason: collision with root package name */
    private String f2088c;

    public h(com.bumptech.glide.load.a<InputStream> aVar, com.bumptech.glide.load.a<ParcelFileDescriptor> aVar2) {
        this.f2086a = aVar;
        this.f2087b = aVar2;
    }

    @Override // com.bumptech.glide.load.a
    public boolean a(g gVar, OutputStream outputStream) {
        if (gVar.b() != null) {
            return this.f2086a.a(gVar.b(), outputStream);
        }
        return this.f2087b.a(gVar.a(), outputStream);
    }

    @Override // com.bumptech.glide.load.a
    public String a() {
        if (this.f2088c == null) {
            this.f2088c = this.f2086a.a() + this.f2087b.a();
        }
        return this.f2088c;
    }
}
