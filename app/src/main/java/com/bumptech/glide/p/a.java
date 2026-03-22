package com.bumptech.glide.p;

import com.bumptech.glide.load.h.l;
import java.io.File;

/* compiled from: ChildLoadProvider.java */
/* loaded from: classes.dex */
public class a<A, T, Z, R> implements f<A, T, Z, R>, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private final f<A, T, Z, R> f2280a;

    /* renamed from: b, reason: collision with root package name */
    private com.bumptech.glide.load.d<File, Z> f2281b;

    /* renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.load.d<T, Z> f2282c;

    /* renamed from: d, reason: collision with root package name */
    private com.bumptech.glide.load.e<Z> f2283d;
    private com.bumptech.glide.load.i.i.c<Z, R> e;
    private com.bumptech.glide.load.a<T> f;

    public a(f<A, T, Z, R> fVar) {
        this.f2280a = fVar;
    }

    public void a(com.bumptech.glide.load.d<T, Z> dVar) {
        this.f2282c = dVar;
    }

    @Override // com.bumptech.glide.p.f
    public com.bumptech.glide.load.i.i.c<Z, R> b() {
        com.bumptech.glide.load.i.i.c<Z, R> cVar = this.e;
        return cVar != null ? cVar : this.f2280a.b();
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.e<Z> c() {
        com.bumptech.glide.load.e<Z> eVar = this.f2283d;
        return eVar != null ? eVar : this.f2280a.c();
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.d<T, Z> d() {
        com.bumptech.glide.load.d<T, Z> dVar = this.f2282c;
        return dVar != null ? dVar : this.f2280a.d();
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.d<File, Z> e() {
        com.bumptech.glide.load.d<File, Z> dVar = this.f2281b;
        return dVar != null ? dVar : this.f2280a.e();
    }

    @Override // com.bumptech.glide.p.f
    public l<A, T> f() {
        return this.f2280a.f();
    }

    public void a(com.bumptech.glide.load.a<T> aVar) {
        this.f = aVar;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public a<A, T, Z, R> m4clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.bumptech.glide.p.b
    public com.bumptech.glide.load.a<T> a() {
        com.bumptech.glide.load.a<T> aVar = this.f;
        return aVar != null ? aVar : this.f2280a.a();
    }
}
