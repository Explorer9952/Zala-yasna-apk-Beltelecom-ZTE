package com.render.vrlib.l.e;

import android.content.Context;
import android.graphics.RectF;
import com.render.vrlib.i;

/* compiled from: DomeProjection.java */
/* loaded from: classes.dex */
public class h extends a {

    /* renamed from: a, reason: collision with root package name */
    i.b f2550a;

    /* renamed from: b, reason: collision with root package name */
    private float f2551b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2552c;

    /* renamed from: d, reason: collision with root package name */
    private RectF f2553d;

    public h(RectF rectF, float f, boolean z) {
        this.f2553d = rectF;
        this.f2551b = f;
        this.f2552c = z;
    }

    @Override // com.render.vrlib.l.b
    public void a(Context context) {
        i.g gVar = new i.g(this.f2553d, this.f2551b, this.f2552c);
        this.f2550a = gVar;
        i.C0079i.a(context, gVar);
    }

    @Override // com.render.vrlib.l.e.k
    public i.b b() {
        return this.f2550a;
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
