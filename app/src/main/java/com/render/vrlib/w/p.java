package com.render.vrlib.w;

/* compiled from: MDVector3D.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private float[] f2667a;

    public p() {
        float[] fArr = new float[4];
        this.f2667a = fArr;
        fArr[3] = 1.0f;
    }

    public p a(float f) {
        this.f2667a[0] = f;
        return this;
    }

    public p b(float f) {
        this.f2667a[1] = f;
        return this;
    }

    public p c(float f) {
        this.f2667a[2] = f;
        return this;
    }

    public String toString() {
        return "MDVector3D{x=" + a() + ", y=" + b() + ", z=" + c() + '}';
    }

    public float a() {
        return this.f2667a[0];
    }

    public float b() {
        return this.f2667a[1];
    }

    public float c() {
        return this.f2667a[2];
    }

    public static float a(float f, float f2, float f3) {
        return (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
    }
}
