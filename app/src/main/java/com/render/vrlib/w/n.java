package com.render.vrlib.w;

/* compiled from: MDQuaternion.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f2664a = new float[4];

    public n() {
        a();
    }

    private void a(float f, float f2, float f3, float f4) {
        float[] fArr = this.f2664a;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
    }

    public void b(float[] fArr) {
        a(false, fArr[0], fArr[1], fArr[2], fArr[4], fArr[5], fArr[6], fArr[8], fArr[9], fArr[10]);
    }

    public float c() {
        float[] fArr = this.f2664a;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        int b2 = b();
        if (b2 == 0) {
            return com.render.vrlib.a.f.a(((f * f4) + (f3 * f2)) * 2.0f, 1.0f - (((f2 * f2) + (f4 * f4)) * 2.0f));
        }
        return b2 * 2.0f * com.render.vrlib.a.f.a(f3, f);
    }

    public float d() {
        return c() * 57.295776f;
    }

    public float e() {
        float[] fArr = this.f2664a;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        int b2 = b();
        return b2 == 0 ? (float) Math.asin(com.render.vrlib.a.f.a(((f * f2) - (f4 * f3)) * 2.0f, -1.0f, 1.0f)) : b2 * 3.1415927f * 0.5f;
    }

    public float f() {
        return e() * 57.295776f;
    }

    public float g() {
        float[] fArr = this.f2664a;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        if (b() == 0) {
            return com.render.vrlib.a.f.a(((f * f3) + (f4 * f2)) * 2.0f, 1.0f - (((f3 * f3) + (f2 * f2)) * 2.0f));
        }
        return 0.0f;
    }

    public float h() {
        return g() * 57.295776f;
    }

    public String toString() {
        return String.format("MDQuaternion w=%f x=%f, y=%f, z=%f", Float.valueOf(this.f2664a[0]), Float.valueOf(this.f2664a[1]), Float.valueOf(this.f2664a[2]), Float.valueOf(this.f2664a[3]));
    }

    public void b(float f, float f2, float f3) {
        double d2 = f3 * 0.5f;
        float sin = (float) Math.sin(d2);
        float cos = (float) Math.cos(d2);
        double d3 = f * 0.5f;
        float sin2 = (float) Math.sin(d3);
        float cos2 = (float) Math.cos(d3);
        double d4 = f2 * 0.5f;
        float sin3 = (float) Math.sin(d4);
        float cos3 = (float) Math.cos(d4);
        float f4 = cos3 * sin2;
        float f5 = sin3 * cos2;
        float f6 = cos3 * cos2;
        float f7 = sin3 * sin2;
        float[] fArr = this.f2664a;
        fArr[0] = (f6 * cos) + (f7 * sin);
        fArr[1] = (f4 * cos) + (f5 * sin);
        fArr[2] = (f5 * cos) - (f4 * sin);
        fArr[3] = (f6 * sin) - (f7 * cos);
    }

    public void a() {
        a(1.0f, 0.0f, 0.0f, 0.0f);
    }

    public void a(float[] fArr) {
        float[] fArr2 = this.f2664a;
        float f = fArr2[1] * fArr2[1];
        float f2 = fArr2[1] * fArr2[2];
        float f3 = fArr2[1] * fArr2[3];
        float f4 = fArr2[1] * fArr2[0];
        float f5 = fArr2[2] * fArr2[2];
        float f6 = fArr2[2] * fArr2[3];
        float f7 = fArr2[2] * fArr2[0];
        float f8 = fArr2[3] * fArr2[3];
        float f9 = fArr2[3] * fArr2[0];
        fArr[0] = 1.0f - ((f5 + f8) * 2.0f);
        fArr[1] = (f2 - f9) * 2.0f;
        fArr[2] = (f3 + f7) * 2.0f;
        fArr[4] = (f2 + f9) * 2.0f;
        fArr[5] = 1.0f - ((f8 + f) * 2.0f);
        fArr[6] = (f6 - f4) * 2.0f;
        fArr[8] = (f3 - f7) * 2.0f;
        fArr[9] = (f6 + f4) * 2.0f;
        fArr[10] = 1.0f - ((f + f5) * 2.0f);
        fArr[14] = 0.0f;
        fArr[13] = 0.0f;
        fArr[12] = 0.0f;
        fArr[11] = 0.0f;
        fArr[7] = 0.0f;
        fArr[3] = 0.0f;
        fArr[15] = 1.0f;
    }

    public int b() {
        float[] fArr = this.f2664a;
        float f = fArr[0];
        float f2 = (fArr[2] * fArr[1]) + (fArr[3] * f);
        if (f2 > 0.499f) {
            return 1;
        }
        return f2 < -0.499f ? -1 : 0;
    }

    private void a(boolean z, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        if (z) {
            float a2 = 1.0f / p.a(f, f2, f3);
            float a3 = 1.0f / p.a(f4, f5, f6);
            float a4 = 1.0f / p.a(f7, f8, f9);
            f *= a2;
            f2 *= a2;
            f3 *= a2;
            f4 *= a3;
            f5 *= a3;
            f6 *= a3;
            f7 *= a4;
            f8 *= a4;
            f9 *= a4;
        }
        if (f + f5 + f9 >= 0.0f) {
            float sqrt = (float) Math.sqrt(r6 + 1.0f);
            f14 = sqrt * 0.5f;
            float f15 = 0.5f / sqrt;
            f12 = (f8 - f6) * f15;
            f10 = (f3 - f7) * f15;
            f13 = (f4 - f2) * f15;
        } else {
            if (f > f5 && f > f9) {
                double d2 = f;
                Double.isNaN(d2);
                double d3 = f5;
                Double.isNaN(d3);
                double d4 = (d2 + 1.0d) - d3;
                double d5 = f9;
                Double.isNaN(d5);
                float sqrt2 = (float) Math.sqrt(d4 - d5);
                float f16 = sqrt2 * 0.5f;
                float f17 = 0.5f / sqrt2;
                float f18 = (f4 + f2) * f17;
                f13 = (f3 + f7) * f17;
                f11 = (f8 - f6) * f17;
                f10 = f18;
                f12 = f16;
            } else if (f5 > f9) {
                double d6 = f5;
                Double.isNaN(d6);
                double d7 = f;
                Double.isNaN(d7);
                double d8 = (d6 + 1.0d) - d7;
                double d9 = f9;
                Double.isNaN(d9);
                float sqrt3 = (float) Math.sqrt(d8 - d9);
                float f19 = sqrt3 * 0.5f;
                float f20 = 0.5f / sqrt3;
                float f21 = (f4 + f2) * f20;
                f13 = (f8 + f6) * f20;
                f11 = (f3 - f7) * f20;
                f12 = f21;
                f10 = f19;
            } else {
                double d10 = f9;
                Double.isNaN(d10);
                double d11 = f;
                Double.isNaN(d11);
                double d12 = (d10 + 1.0d) - d11;
                double d13 = f5;
                Double.isNaN(d13);
                float sqrt4 = (float) Math.sqrt(d12 - d13);
                float f22 = sqrt4 * 0.5f;
                float f23 = 0.5f / sqrt4;
                float f24 = (f3 + f7) * f23;
                f10 = (f8 + f6) * f23;
                f11 = (f4 - f2) * f23;
                f12 = f24;
                f13 = f22;
            }
            f14 = f11;
        }
        a(f14, f12, f10, f13);
    }

    public void a(float f, float f2, float f3) {
        b(f * 0.017453292f, f2 * 0.017453292f, f3 * 0.017453292f);
    }
}
