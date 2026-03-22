package com.render.vrlib.l.e;

import android.content.Context;
import com.render.vrlib.i;

/* compiled from: SphereProjection.java */
/* loaded from: classes.dex */
public class q extends a {

    /* renamed from: a, reason: collision with root package name */
    private i.b f2572a;

    @Override // com.render.vrlib.l.b
    public void a(Context context) {
        i.l lVar = new i.l();
        this.f2572a = lVar;
        i.C0079i.a(context, lVar);
    }

    @Override // com.render.vrlib.l.e.k
    public i.b b() {
        return this.f2572a;
    }

    @Override // com.render.vrlib.l.e.k
    public com.render.vrlib.w.l c() {
        return com.render.vrlib.w.l.b();
    }

    @Override // com.render.vrlib.l.b
    public void e(Context context) {
    }

    @Override // com.render.vrlib.l.b
    public boolean f(Context context) {
        return true;
    }

    @Override // com.render.vrlib.l.e.a
    public com.render.vrlib.j.c a(com.render.vrlib.w.k kVar) {
        return new com.render.vrlib.j.g(kVar);
    }
}
