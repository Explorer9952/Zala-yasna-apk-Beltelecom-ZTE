package com.render.vrlib.n;

import android.util.Log;
import com.render.vrlib.h;
import com.rendergl.google.android.apps.muzei.GLTextureView;

/* compiled from: MD360Texture.java */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: c, reason: collision with root package name */
    protected GLTextureView.a f2590c;

    /* renamed from: a, reason: collision with root package name */
    private int f2588a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f2589b = 1;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2591d = false;

    protected abstract int a();

    public void a(boolean z) {
        this.f2591d = z;
    }

    public abstract boolean a(h hVar);

    public abstract void b();

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b(int i) {
        return i == 0;
    }

    public abstract void c();

    public boolean d() {
        return this.f2591d;
    }

    public void e() {
        GLTextureView.a aVar = this.f2590c;
        if (aVar != null) {
            aVar.a(null);
        }
    }

    public int f() {
        return this.f2589b;
    }

    public void g() {
        int a2 = a();
        if (a2 != 0) {
            this.f2588a = a2;
        }
    }

    public int h() {
        return this.f2588a;
    }

    public void a(GLTextureView.a aVar) {
        this.f2590c = aVar;
    }

    public void a(int i) {
        this.f2589b = i;
        Log.d("VideoTexture", "setTextureCounts " + i);
    }
}
