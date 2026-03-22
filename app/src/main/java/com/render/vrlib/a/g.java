package com.render.vrlib.a;

import android.graphics.SurfaceTexture;

/* compiled from: SurfaceTextureWrapper.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private SurfaceTexture f2463a;

    /* renamed from: b, reason: collision with root package name */
    private int f2464b;

    public g(SurfaceTexture surfaceTexture, int i) {
        this.f2463a = surfaceTexture;
        this.f2464b = i;
    }

    public int a() {
        return this.f2464b;
    }

    public SurfaceTexture b() {
        return this.f2463a;
    }

    public void c() {
        SurfaceTexture surfaceTexture = this.f2463a;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f2463a = null;
        }
        this.f2464b = 0;
    }
}
