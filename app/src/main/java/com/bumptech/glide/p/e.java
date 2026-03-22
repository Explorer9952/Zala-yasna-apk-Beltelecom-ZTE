package com.bumptech.glide.p;

import com.bumptech.glide.load.h.l;
import java.io.File;

/* compiled from: FixedLoadProvider.java */
/* loaded from: classes.dex */
public class e<A, T, Z, R> implements f<A, T, Z, R> {

    /* renamed from: a, reason: collision with root package name */
    private final l<A, T> f2287a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.i.i.c<Z, R> f2288b;

    /* renamed from: c, reason: collision with root package name */
    private final b<T, Z> f2289c;

    public e(l<A, T> lVar, com.bumptech.glide.load.i.i.c<Z, R> cVar, b<T, Z> bVar) {
        if (lVar != null) {
            this.f2287a = lVar;
            if (cVar != null) {
                this.f2288b = cVar;
                if (bVar != null) {
                    this.f2289c = bVar;
                    return;
                }
                throw new NullPointerException("DataLoadProvider must not be null");
            }
            throw new NullPointerException("Transcoder must not be null");
        }
        throw new NullPointerException("ModelLoader must not be null");
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.a<T> a() {
        return this.f2289c.a();
    }

    @Override // com.bumptech.glide.p.f
    public com.bumptech.glide.load.i.i.c<Z, R> b() {
        return this.f2288b;
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.e<Z> c() {
        return this.f2289c.c();
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.d<T, Z> d() {
        return this.f2289c.d();
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.d<File, Z> e() {
        return this.f2289c.e();
    }

    @Override // com.bumptech.glide.p.f
    public l<A, T> f() {
        return this.f2287a;
    }
}
