package com.scwang.smartrefresh.layout.e;

import android.view.animation.Interpolator;

/* compiled from: ViscousFluidInterpolator.java */
/* loaded from: classes.dex */
public class c implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private static final float f2753a;

    /* renamed from: b, reason: collision with root package name */
    private static final float f2754b;

    static {
        float a2 = 1.0f / a(1.0f);
        f2753a = a2;
        f2754b = 1.0f - (a2 * a(1.0f));
    }

    private static float a(float f) {
        float f2 = f * 8.0f;
        if (f2 < 1.0f) {
            return f2 - (1.0f - ((float) Math.exp(-f2)));
        }
        return ((1.0f - ((float) Math.exp(1.0f - f2))) * 0.63212055f) + 0.36787945f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float a2 = f2753a * a(f);
        return a2 > 0.0f ? a2 + f2754b : a2;
    }
}
