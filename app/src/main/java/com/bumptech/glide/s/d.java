package com.bumptech.glide.s;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;

/* compiled from: LogTime.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final double f2343a;

    static {
        f2343a = 17 <= Build.VERSION.SDK_INT ? 1.0d / Math.pow(10.0d, 6.0d) : 1.0d;
    }

    @TargetApi(17)
    public static long a() {
        if (17 <= Build.VERSION.SDK_INT) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return System.currentTimeMillis();
    }

    public static double a(long j) {
        double a2 = a() - j;
        double d2 = f2343a;
        Double.isNaN(a2);
        return a2 * d2;
    }
}
