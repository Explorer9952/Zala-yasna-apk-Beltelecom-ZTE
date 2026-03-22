package com.render.vrlib.a;

import java.util.Random;

/* compiled from: MathUtils.java */
/* loaded from: classes.dex */
public final class f {

    /* compiled from: MathUtils.java */
    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        static final float[] f2462a = new float[16384];

        static {
            for (int i = 0; i < 16384; i++) {
                f2462a[i] = (float) Math.sin(((i + 0.5f) / 16384.0f) * 6.2831855f);
            }
            for (int i2 = 0; i2 < 360; i2 += 90) {
                f2462a[((int) (45.511112f * i2)) & 16383] = (float) Math.sin(r2 * 0.017453292f);
            }
        }
    }

    static {
        new Random();
    }

    public static float a(float f) {
        return a.f2462a[((int) (f * 2607.5945f)) & 16383];
    }

    public static float a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    public static float b(float f) {
        return a.f2462a[((int) ((f + 1.5707964f) * 2607.5945f)) & 16383];
    }

    public static float a(float f, float f2) {
        if (f2 == 0.0f) {
            if (f > 0.0f) {
                return 1.5707964f;
            }
            return f == 0.0f ? 0.0f : -1.5707964f;
        }
        float f3 = f / f2;
        if (Math.abs(f3) >= 1.0f) {
            float f4 = 1.5707964f - (f3 / ((f3 * f3) + 0.28f));
            return f < 0.0f ? f4 - 3.1415927f : f4;
        }
        float f5 = f3 / (((0.28f * f3) * f3) + 1.0f);
        if (f2 < 0.0f) {
            return f5 + (f < 0.0f ? -3.1415927f : 3.1415927f);
        }
        return f5;
    }
}
