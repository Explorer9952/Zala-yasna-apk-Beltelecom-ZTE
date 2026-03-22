package com.bumptech.glide.load.g;

import com.bumptech.glide.Priority;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* compiled from: ByteArrayFetcher.java */
/* loaded from: classes.dex */
public class b implements c<InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f2060a;

    /* renamed from: b, reason: collision with root package name */
    private final String f2061b;

    public b(byte[] bArr, String str) {
        this.f2060a = bArr;
        this.f2061b = str;
    }

    @Override // com.bumptech.glide.load.g.c
    public void b() {
    }

    @Override // com.bumptech.glide.load.g.c
    public void cancel() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.g.c
    public InputStream a(Priority priority) {
        return new ByteArrayInputStream(this.f2060a);
    }

    @Override // com.bumptech.glide.load.g.c
    public String a() {
        return this.f2061b;
    }
}
