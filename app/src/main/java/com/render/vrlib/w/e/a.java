package com.render.vrlib.w.e;

import android.opengl.Matrix;
import com.render.vrlib.w.l;

/* compiled from: MDMutablePosition.java */
/* loaded from: classes.dex */
public class a extends l {

    /* renamed from: b, reason: collision with root package name */
    private float[] f2643b = null;

    /* renamed from: c, reason: collision with root package name */
    private float[] f2644c = null;

    /* renamed from: d, reason: collision with root package name */
    private final float[] f2645d = new float[16];
    private float g = 0.0f;
    private float f = 0.0f;
    private float e = 0.0f;
    private float j = 0.0f;
    private float i = 0.0f;
    private float h = 0.0f;
    private float m = 0.0f;
    private float l = 0.0f;
    private float k = 0.0f;
    private boolean n = true;

    private a() {
    }

    public static a m() {
        return new a();
    }

    private void n() {
        if (this.f2643b == null) {
            float[] fArr = new float[16];
            this.f2643b = fArr;
            Matrix.setIdentityM(fArr, 0);
        }
        if (this.n) {
            Matrix.setIdentityM(this.f2643b, 0);
            Matrix.rotateM(this.f2643b, 0, j(), 1.0f, 0.0f, 0.0f);
            Matrix.rotateM(this.f2643b, 0, k(), 0.0f, 1.0f, 0.0f);
            Matrix.rotateM(this.f2643b, 0, l(), 0.0f, 0.0f, 1.0f);
            Matrix.translateM(this.f2643b, 0, g(), h(), i());
            Matrix.rotateM(this.f2643b, 0, e(), 1.0f, 0.0f, 0.0f);
            Matrix.rotateM(this.f2643b, 0, d(), 0.0f, 1.0f, 0.0f);
            Matrix.rotateM(this.f2643b, 0, f(), 0.0f, 0.0f, 1.0f);
            float[] fArr2 = this.f2644c;
            if (fArr2 != null) {
                Matrix.multiplyMM(this.f2645d, 0, fArr2, 0, this.f2643b, 0);
                System.arraycopy(this.f2645d, 0, this.f2643b, 0, 16);
            }
            this.n = false;
        }
    }

    public a a(float f) {
        this.n |= this.k != f;
        this.k = f;
        return this;
    }

    public a b(float f) {
        this.n |= this.l != f;
        this.l = f;
        return this;
    }

    public a c(float f) {
        this.n |= this.m != f;
        this.m = f;
        return this;
    }

    public float d() {
        return this.k;
    }

    public float e() {
        return this.l;
    }

    public float f() {
        return this.m;
    }

    public float g() {
        return this.e;
    }

    public float h() {
        return this.f;
    }

    public float i() {
        return this.g;
    }

    public float j() {
        return this.h;
    }

    public float k() {
        return this.i;
    }

    public float l() {
        return this.j;
    }

    public String toString() {
        return "MDPosition{mX=" + this.e + ", mY=" + this.f + ", mZ=" + this.g + ", mAngleX=" + this.h + ", mAngleY=" + this.i + ", mAngleZ=" + this.j + ", mPitch=" + this.k + ", mYaw=" + this.l + ", mRoll=" + this.m + '}';
    }

    public a d(float f) {
        this.n |= this.g != f;
        this.g = f;
        return this;
    }

    @Override // com.render.vrlib.w.l
    public float[] a() {
        n();
        return this.f2643b;
    }
}
