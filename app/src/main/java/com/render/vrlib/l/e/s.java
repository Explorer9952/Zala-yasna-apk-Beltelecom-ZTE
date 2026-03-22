package com.render.vrlib.l.e;

import android.content.Context;
import com.render.vrlib.i;

/* compiled from: StereoSphereProjection.java */
/* loaded from: classes.dex */
public class s extends com.render.vrlib.l.e.a {

    /* renamed from: a, reason: collision with root package name */
    private com.render.vrlib.a.c f2575a;

    /* renamed from: b, reason: collision with root package name */
    private i.b f2576b;

    /* compiled from: StereoSphereProjection.java */
    /* loaded from: classes.dex */
    private static class a extends com.render.vrlib.b {
        private a() {
        }

        @Override // com.render.vrlib.b
        public com.render.vrlib.a createDirector(int i) {
            return com.render.vrlib.a.s().a();
        }
    }

    public s(com.render.vrlib.a.c cVar) {
        this.f2575a = cVar;
    }

    @Override // com.render.vrlib.l.b
    public void a(Context context) {
        i.o oVar = new i.o(this.f2575a);
        this.f2576b = oVar;
        i.C0079i.a(context, oVar);
    }

    @Override // com.render.vrlib.l.e.k
    public i.b b() {
        return this.f2576b;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.render.vrlib.l.e.a
    public com.render.vrlib.b a() {
        return new a();
    }

    @Override // com.render.vrlib.l.e.a
    public com.render.vrlib.j.c a(com.render.vrlib.w.k kVar) {
        return new com.render.vrlib.j.g(kVar);
    }
}
