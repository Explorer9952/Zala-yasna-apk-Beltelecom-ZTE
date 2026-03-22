package com.render.vrlib.w;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;

/* compiled from: MDFlingConfig.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private TimeInterpolator f2650a = new DecelerateInterpolator();

    /* renamed from: b, reason: collision with root package name */
    private long f2651b = 400;

    /* renamed from: c, reason: collision with root package name */
    private float f2652c = 0.8f;

    public g a(float f) {
        this.f2652c = f;
        return this;
    }

    public long b() {
        return this.f2651b;
    }

    public float c() {
        return this.f2652c;
    }

    public TimeInterpolator a() {
        return this.f2650a;
    }
}
