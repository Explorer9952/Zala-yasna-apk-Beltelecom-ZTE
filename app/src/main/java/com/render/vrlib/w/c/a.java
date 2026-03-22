package com.render.vrlib.w.c;

import com.render.vrlib.a.f;

/* compiled from: PicoG2Orientation.java */
/* loaded from: classes.dex */
public class a extends b {
    public a(float f, float f2, float f3) {
        super(f, f2, f3);
    }

    private void c() {
        float b2 = f.b(this.f2636a);
        float a2 = f.a(this.f2636a);
        float b3 = f.b(this.f2637b);
        float a3 = f.a(this.f2637b);
        float b4 = f.b(this.f2638c);
        float a4 = f.a(this.f2638c);
        float[] fArr = this.e;
        float f = a2 * a3;
        fArr[0] = (b3 * b4) + (f * a4);
        fArr[1] = ((-b3) * a4) + (f * b4);
        fArr[2] = b2 * a3;
        fArr[4] = b2 * a4;
        fArr[5] = b2 * b4;
        fArr[6] = -a2;
        float f2 = a2 * b3;
        fArr[8] = ((-a3) * b4) + (f2 * a4);
        fArr[9] = (a3 * a4) + (f2 * b4);
        fArr[10] = b2 * b3;
        fArr[14] = 0.0f;
        fArr[13] = 0.0f;
        fArr[12] = 0.0f;
        fArr[11] = 0.0f;
        fArr[7] = 0.0f;
        fArr[3] = 0.0f;
        fArr[15] = 1.0f;
    }

    private void d() {
        float[] fArr = this.f2639d;
        float f = fArr[1] * fArr[1];
        float f2 = fArr[1] * fArr[2];
        float f3 = fArr[1] * fArr[3];
        float f4 = fArr[1] * fArr[0];
        float f5 = fArr[2] * fArr[2];
        float f6 = fArr[2] * fArr[3];
        float f7 = fArr[2] * fArr[0];
        float f8 = fArr[3] * fArr[3];
        float f9 = fArr[3] * fArr[0];
        float[] fArr2 = this.e;
        fArr2[0] = 1.0f - ((f5 + f8) * 2.0f);
        fArr2[1] = (f2 - f9) * 2.0f;
        fArr2[2] = (f3 + f7) * 2.0f;
        fArr2[4] = (f2 + f9) * 2.0f;
        fArr2[5] = 1.0f - ((f8 + f) * 2.0f);
        fArr2[6] = (f6 - f4) * 2.0f;
        fArr2[8] = (f3 - f7) * 2.0f;
        fArr2[9] = (f6 + f4) * 2.0f;
        fArr2[10] = 1.0f - ((f + f5) * 2.0f);
        fArr2[14] = 0.0f;
        fArr2[13] = 0.0f;
        fArr2[12] = 0.0f;
        fArr2[11] = 0.0f;
        fArr2[7] = 0.0f;
        fArr2[3] = 0.0f;
        fArr2[15] = 1.0f;
    }

    private void e() {
        float[] fArr = this.e;
        fArr[0] = -fArr[0];
        fArr[2] = -fArr[2];
        fArr[4] = -fArr[4];
        fArr[6] = -fArr[6];
        fArr[8] = -fArr[8];
        fArr[10] = -fArr[10];
    }

    private void f() {
        double d2 = this.f2638c * 0.5f;
        float sin = (float) Math.sin(d2);
        float cos = (float) Math.cos(d2);
        double d3 = this.f2636a * 0.5f;
        float sin2 = (float) Math.sin(d3);
        float cos2 = (float) Math.cos(d3);
        double d4 = this.f2637b * 0.5f;
        float sin3 = (float) Math.sin(d4);
        float cos3 = (float) Math.cos(d4);
        float f = cos3 * sin2;
        float f2 = sin3 * cos2;
        float f3 = cos3 * cos2;
        float f4 = sin3 * sin2;
        float[] fArr = this.f2639d;
        fArr[0] = (f3 * cos) + (f4 * sin);
        fArr[1] = (f * cos) + (f2 * sin);
        fArr[2] = (f2 * cos) - (f * sin);
        fArr[3] = (f3 * sin) - (f4 * cos);
    }

    @Override // com.render.vrlib.w.c.b
    public void a() {
        this.f2637b = -this.f2637b;
        int i = this.f;
        if (i == 1) {
            c();
            e();
        } else if (i == 0) {
            d();
        } else if (i == 2) {
            f();
            d();
        }
    }
}
