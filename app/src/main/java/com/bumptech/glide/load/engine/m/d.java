package com.bumptech.glide.load.engine.m;

import com.bumptech.glide.load.engine.m.a;
import java.io.File;

/* compiled from: DiskLruCacheFactory.java */
/* loaded from: classes.dex */
public class d implements a.InterfaceC0065a {

    /* renamed from: a, reason: collision with root package name */
    private final int f2043a;

    /* renamed from: b, reason: collision with root package name */
    private final a f2044b;

    /* compiled from: DiskLruCacheFactory.java */
    /* loaded from: classes.dex */
    public interface a {
        File a();
    }

    public d(a aVar, int i) {
        this.f2043a = i;
        this.f2044b = aVar;
    }

    @Override // com.bumptech.glide.load.engine.m.a.InterfaceC0065a
    public com.bumptech.glide.load.engine.m.a build() {
        File a2 = this.f2044b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return e.a(a2, this.f2043a);
        }
        return null;
    }
}
