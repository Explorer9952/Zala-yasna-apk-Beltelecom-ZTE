package com.render.vrlib.n;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Surface;
import com.render.vrlib.MDVRLibrary;
import com.render.vrlib.a.g;
import com.render.vrlib.h;
import com.rendergl.google.android.apps.muzei.GLTextureView;
import java.util.ArrayList;

/* compiled from: MD360VideoTexture.java */
/* loaded from: classes.dex */
public class d extends c {
    private static final int[] m = {1};
    private Surface e;
    private SurfaceTexture f;
    private ArrayList<g> g;
    private MDVRLibrary.j h;
    private MDVRLibrary.k i;
    private int[] k;
    private float[] j = new float[16];
    private boolean l = true;

    private void d(int i) {
        if (this.f == null || d()) {
            this.f = new SurfaceTexture(i);
            Log.d("VideoTexture", "onCreateSurface : onSurfaceReady " + this.h);
            a(false);
            this.f.setOnFrameAvailableListener(new e(this));
            Surface surface = new Surface(this.f);
            this.e = surface;
            MDVRLibrary.j jVar = this.h;
            if (jVar != null) {
                jVar.onSurfaceReady(surface);
            }
        }
    }

    private void e(int i) {
        if (this.f == null || d()) {
            this.g = new ArrayList<>();
            for (int i2 = 0; i2 < i; i2++) {
                this.g.add(new g(new SurfaceTexture(this.k[i2]), this.k[i2]));
                this.g.get(i2).b().setOnFrameAvailableListener(new f(this));
            }
            this.f = this.g.get(0).b();
            a(false);
            MDVRLibrary.k kVar = this.i;
            if (kVar != null) {
                kVar.onSurfaceTexturesReady(this.g);
            }
        }
        Log.d("VideoTexture", "onCreateSurfaceTextures " + i);
    }

    private void k() {
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
    }

    public void a(MDVRLibrary.j jVar) {
        this.h = jVar;
    }

    @Override // com.render.vrlib.n.c
    public synchronized void b() {
        Log.d("VideoTexture", "destroy Texture");
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                this.g.get(i).c();
            }
            this.g = null;
        }
        if (this.f != null) {
            this.f.release();
            this.f = null;
        }
        if (this.e != null) {
            this.e.release();
            this.e = null;
        }
        i();
    }

    @Override // com.render.vrlib.n.c
    public synchronized void c() {
        this.h = null;
        b();
    }

    @Override // com.render.vrlib.n.c
    public void g() {
        int f = f();
        if (f <= 1) {
            super.g();
            int h = h();
            if (b(h)) {
                return;
            }
            d(h);
            return;
        }
        c(f);
        e(f);
    }

    public void i() {
        if (this.k != null) {
            GLES20.glFlush();
            int[] iArr = this.k;
            int i = 0;
            if (iArr.length <= 1) {
                GLES20.glDeleteTextures(1, iArr, 0);
            } else if (iArr != null) {
                while (true) {
                    int[] iArr2 = this.k;
                    if (i >= iArr2.length) {
                        break;
                    }
                    GLES20.glDeleteTextures(1, iArr2, i);
                    i++;
                }
            }
            GLES20.glFinish();
            com.render.vrlib.a.b.a("Texture delete");
            this.k = null;
        }
    }

    public g j() {
        int a2 = a();
        return new g(new SurfaceTexture(a2), a2);
    }

    public void a(MDVRLibrary.k kVar) {
        this.i = kVar;
    }

    public void a(g gVar) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, gVar.a());
        SurfaceTexture b2 = gVar.b();
        this.f = b2;
        GLTextureView.a aVar = this.f2590c;
        if (aVar != null) {
            aVar.a(b2);
        }
        Log.d("VideoTexture", " setBindTextureId " + gVar.a());
    }

    protected void c(int i) {
        if (this.k != null) {
            i();
        }
        this.k = new int[i];
        GLES20.glActiveTexture(33984);
        GLES20.glGenTextures(i, this.k, 0);
        com.render.vrlib.a.b.a("Texture generate");
        for (int i2 = 0; i2 < i; i2++) {
        }
        GLES20.glBindTexture(36197, this.k[0]);
        com.render.vrlib.a.b.a("Texture bind");
        k();
    }

    @Override // com.render.vrlib.n.c
    protected int a() {
        if (this.k != null) {
            i();
        }
        this.k = new int[1];
        GLES20.glActiveTexture(33984);
        GLES20.glGenTextures(1, this.k, 0);
        com.render.vrlib.a.b.a("Texture generate");
        GLES20.glBindTexture(36197, this.k[0]);
        com.render.vrlib.a.b.a("Texture bind");
        k();
        return this.k[0];
    }

    public void b(boolean z) {
        Log.d("VideoTexture", "setUpdateEnabled " + z);
        this.l = z;
    }

    @Override // com.render.vrlib.n.c
    public synchronized boolean a(h hVar) {
        if (this.f == null) {
            return false;
        }
        if (this.l && this.f != null) {
            this.f.updateTexImage();
        }
        if (this.f != null) {
            this.f.getTransformMatrix(this.j);
        }
        GLES20.glUniform1iv(hVar.g(), 1, m, 0);
        GLES20.glUniformMatrix4fv(hVar.f(), 1, false, this.j, 0);
        return true;
    }
}
