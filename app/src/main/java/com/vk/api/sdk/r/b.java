package com.vk.api.sdk.r;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/* compiled from: ExponentialBackoff.kt */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Random f3987a;

    /* renamed from: b, reason: collision with root package name */
    private volatile long f3988b;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f3989c;

    /* renamed from: d, reason: collision with root package name */
    private final long f3990d;
    private final long e;
    private final float f;
    private final float g;

    /* compiled from: ExponentialBackoff.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.d dVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    public b(long j, long j2, float f, float f2) {
        this.f3990d = j;
        this.e = j2;
        this.f = f;
        this.g = f2;
        this.f3987a = new Random(System.currentTimeMillis());
        this.f3988b = this.f3990d;
    }

    public final long a() {
        return this.f3988b;
    }

    public final int b() {
        return this.f3989c;
    }

    public final void c() {
        this.f3988b = Math.min(((float) this.f3988b) * this.f, (float) this.e);
        this.f3988b += a(((float) this.f3988b) * this.g);
        this.f3989c++;
    }

    public final void d() {
        c();
    }

    public final void e() {
        this.f3988b = this.f3990d;
        this.f3989c = 0;
    }

    public final boolean f() {
        return this.f3989c > 0;
    }

    private final long a(float f) {
        double nextGaussian = this.f3987a.nextGaussian();
        double d2 = f;
        Double.isNaN(d2);
        return (long) (nextGaussian * d2);
    }

    public /* synthetic */ b(long j, long j2, float f, float f2, int i, kotlin.jvm.internal.d dVar) {
        this((i & 1) != 0 ? TimeUnit.MILLISECONDS.toMillis(100L) : j, (i & 2) != 0 ? TimeUnit.MINUTES.toMillis(5L) : j2, (i & 4) != 0 ? 2.0f : f, (i & 8) != 0 ? 0.1f : f2);
    }
}
