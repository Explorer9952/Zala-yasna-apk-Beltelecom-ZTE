package com.render.vrlib.l.e;

import android.content.Context;
import com.render.vrlib.i;

/* compiled from: SphereProjection3D.java */
/* loaded from: classes.dex */
public class r extends a {

    /* renamed from: a, reason: collision with root package name */
    private int f2573a;

    /* renamed from: b, reason: collision with root package name */
    private i.b f2574b;

    public r(int i) {
        this.f2573a = 0;
        this.f2573a = i;
    }

    @Override // com.render.vrlib.l.b
    public void a(Context context) {
        int i = this.f2573a;
        if (i == 0) {
            this.f2574b = new i.n();
        } else if (i == 1) {
            this.f2574b = new i.m();
        } else {
            this.f2574b = new i.l();
        }
        i.C0079i.a(context, this.f2574b);
    }

    @Override // com.render.vrlib.l.e.k
    public i.b b() {
        return this.f2574b;
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
