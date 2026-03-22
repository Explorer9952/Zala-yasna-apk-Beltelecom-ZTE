package com.render.vrlib.w;

/* compiled from: MDHitPoint.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: b, reason: collision with root package name */
    private static final i f2657b = new a();

    /* renamed from: a, reason: collision with root package name */
    private float f2658a;

    /* compiled from: MDHitPoint.java */
    /* loaded from: classes.dex */
    private static class a extends i {
        private a() {
        }
    }

    public i() {
        a();
    }

    public static i c() {
        return f2657b;
    }

    public void a() {
        this.f2658a = Float.MAX_VALUE;
    }

    public boolean b() {
        return this.f2658a == Float.MAX_VALUE;
    }

    public boolean a(i iVar) {
        return this.f2658a <= iVar.f2658a;
    }
}
