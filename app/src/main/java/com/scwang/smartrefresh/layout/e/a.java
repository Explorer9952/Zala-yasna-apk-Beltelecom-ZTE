package com.scwang.smartrefresh.layout.e;

import android.content.res.Resources;

/* compiled from: DensityUtil.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    float f2752a = Resources.getSystem().getDisplayMetrics().density;

    public static int b(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static float c(float f) {
        return f / Resources.getSystem().getDisplayMetrics().density;
    }

    public int a(float f) {
        return (int) ((f * this.f2752a) + 0.5f);
    }
}
