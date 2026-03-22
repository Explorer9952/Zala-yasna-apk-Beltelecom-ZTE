package com.render.vrlib.w;

/* compiled from: MDDirectorSnapshot.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private float[] f2646a = new float[16];

    /* renamed from: b, reason: collision with root package name */
    private float[] f2647b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    private float f2648c;

    /* renamed from: d, reason: collision with root package name */
    private float f2649d;

    public float[] a() {
        return this.f2646a;
    }

    public float[] b() {
        return this.f2647b;
    }

    public float c() {
        return this.f2648c;
    }

    public float d() {
        return this.f2649d;
    }

    public void a(com.render.vrlib.a aVar) {
        this.f2648c = aVar.m();
        this.f2649d = aVar.l();
        System.arraycopy(aVar.j(), 0, this.f2646a, 0, 16);
        System.arraycopy(aVar.h(), 0, this.f2647b, 0, 16);
    }
}
