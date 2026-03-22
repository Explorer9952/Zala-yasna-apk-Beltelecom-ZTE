package com.bumptech.glide.load.engine.m;

import android.annotation.SuppressLint;
import com.bumptech.glide.load.engine.m.h;

/* compiled from: LruResourceCache.java */
/* loaded from: classes.dex */
public class g extends com.bumptech.glide.s.e<com.bumptech.glide.load.b, com.bumptech.glide.load.engine.j<?>> implements h {

    /* renamed from: d, reason: collision with root package name */
    private h.a f2051d;

    public g(int i) {
        super(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.engine.m.h
    public /* bridge */ /* synthetic */ com.bumptech.glide.load.engine.j a(com.bumptech.glide.load.b bVar, com.bumptech.glide.load.engine.j jVar) {
        return (com.bumptech.glide.load.engine.j) super.b((g) bVar, (com.bumptech.glide.load.b) jVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.s.e
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(com.bumptech.glide.load.b bVar, com.bumptech.glide.load.engine.j<?> jVar) {
        h.a aVar = this.f2051d;
        if (aVar != null) {
            aVar.a(jVar);
        }
    }

    @Override // com.bumptech.glide.load.engine.m.h
    public /* bridge */ /* synthetic */ com.bumptech.glide.load.engine.j a(com.bumptech.glide.load.b bVar) {
        return (com.bumptech.glide.load.engine.j) super.c(bVar);
    }

    @Override // com.bumptech.glide.load.engine.m.h
    public void a(h.a aVar) {
        this.f2051d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.s.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int b(com.bumptech.glide.load.engine.j<?> jVar) {
        return jVar.getSize();
    }

    @Override // com.bumptech.glide.load.engine.m.h
    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (i >= 60) {
            a();
        } else if (i >= 40) {
            b(b() / 2);
        }
    }
}
