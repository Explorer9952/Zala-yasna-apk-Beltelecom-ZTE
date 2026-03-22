package com.render.vrlib.w.c;

import android.util.Log;

/* compiled from: ZteOrientation.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected float f2636a;

    /* renamed from: b, reason: collision with root package name */
    protected float f2637b;

    /* renamed from: c, reason: collision with root package name */
    protected float f2638c;

    /* renamed from: d, reason: collision with root package name */
    protected final float[] f2639d = new float[4];
    protected float[] e = new float[16];
    protected int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(float f, float f2, float f3) {
        this.f = 0;
        this.f = 1;
        a(f, f2, f3);
    }

    protected abstract void a();

    public void a(float f, float f2, float f3) {
        if (this.f != 1) {
            Log.d("ZteOrientation", "Orientation has been initiated to EulerAngle.\n Please enter eulerAngle !");
            return;
        }
        this.f2636a = f * 0.017453292f;
        this.f2637b = f2 * 0.017453292f;
        this.f2638c = f3 * 0.017453292f;
        a();
    }

    public float[] b() {
        return this.e;
    }

    public String toString() {
        return String.format("Quaternion w=%f x=%f, y=%f, z=%f\nAngle pitch=%f yaw=%f roll=%f\n[%f %f %f %f\n %f %f %f %f\n %f %f %f %f\n %f %f %f %f\n", Float.valueOf(this.f2639d[0]), Float.valueOf(this.f2639d[1]), Float.valueOf(this.f2639d[2]), Float.valueOf(this.f2639d[3]), Float.valueOf(this.f2636a), Float.valueOf(this.f2637b), Float.valueOf(this.f2638c), Float.valueOf(this.e[0]), Float.valueOf(this.e[1]), Float.valueOf(this.e[2]), Float.valueOf(this.e[3]), Float.valueOf(this.e[4]), Float.valueOf(this.e[5]), Float.valueOf(this.e[6]), Float.valueOf(this.e[7]), Float.valueOf(this.e[8]), Float.valueOf(this.e[9]), Float.valueOf(this.e[10]), Float.valueOf(this.e[11]), Float.valueOf(this.e[12]), Float.valueOf(this.e[13]), Float.valueOf(this.e[14]), Float.valueOf(this.e[15]));
    }
}
