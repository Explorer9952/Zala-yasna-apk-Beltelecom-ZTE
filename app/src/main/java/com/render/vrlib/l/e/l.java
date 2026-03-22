package com.render.vrlib.l.e;

/* compiled from: MultiFishEyeProjection.java */
/* loaded from: classes.dex */
public class l extends q {

    /* renamed from: b, reason: collision with root package name */
    private float f2556b;

    /* renamed from: c, reason: collision with root package name */
    private com.render.vrlib.a.c f2557c;

    public l(float f, com.render.vrlib.a.c cVar) {
        this.f2556b = f;
        this.f2557c = cVar;
    }

    @Override // com.render.vrlib.l.e.q, com.render.vrlib.l.e.a
    public com.render.vrlib.j.c a(com.render.vrlib.w.k kVar) {
        return new com.render.vrlib.j.f(kVar, this.f2556b, this.f2557c);
    }
}
