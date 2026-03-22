package com.rendergl.google.android.apps.muzei;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import com.render.vrlib.MDVRLibrary;
import com.render.vrlib.a.d;
import com.render.vrlib.i;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: a, reason: collision with root package name */
    private GLSurfaceView.Renderer f2671a;

    /* renamed from: b, reason: collision with root package name */
    private SurfaceTexture f2672b;

    /* renamed from: c, reason: collision with root package name */
    private EGLDisplay f2673c;

    /* renamed from: d, reason: collision with root package name */
    private EGLSurface f2674d;
    private EGLContext e;
    private EGL10 f;
    private EGLConfig g;
    private GL10 h;
    private int i;
    private int j;
    private int k;
    public boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private d r;
    private b s;
    private boolean t;
    private int u;
    private MDVRLibrary.i v;
    private a w;
    private boolean x;

    /* loaded from: classes.dex */
    public interface a {
        void a(SurfaceTexture surfaceTexture);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Log.d("RenderThread", "RenderThread start");
            GLTextureView gLTextureView = GLTextureView.this;
            gLTextureView.l = true;
            if (gLTextureView.j()) {
                GLTextureView.this.i();
                long currentTimeMillis = System.currentTimeMillis();
                while (GLTextureView.this.l) {
                    while (GLTextureView.this.f2671a == null) {
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException unused) {
                        }
                    }
                    if (GLTextureView.this.q) {
                        Log.d("RenderThread", "render changed " + GLTextureView.this.s);
                        GLTextureView gLTextureView2 = GLTextureView.this;
                        gLTextureView2.b(gLTextureView2.f2671a);
                        GLTextureView.this.q = false;
                        GLTextureView.this.w = new com.rendergl.google.android.apps.muzei.b(this);
                        if (GLTextureView.this.f2671a instanceof i) {
                            ((i) GLTextureView.this.f2671a).a(GLTextureView.this.w);
                        }
                    }
                    if (!GLTextureView.this.e() && GLTextureView.this.l) {
                        currentTimeMillis = System.currentTimeMillis();
                        GLTextureView.this.f();
                        if (GLTextureView.this.r != null) {
                            GLTextureView.this.r.a();
                        }
                    }
                    try {
                        if (GLTextureView.this.e()) {
                            Thread.sleep(100L);
                        } else {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            try {
                                Thread.sleep(Math.max(10L, GLTextureView.this.i - (currentTimeMillis2 - currentTimeMillis)));
                            } catch (InterruptedException unused2) {
                            }
                            currentTimeMillis = currentTimeMillis2;
                        }
                    } catch (InterruptedException unused3) {
                    }
                }
                return;
            }
            Log.e("RenderThread", "initGL failed, RenderThread exit.");
        }
    }

    public GLTextureView(Context context) {
        super(context);
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = null;
        this.t = false;
        a(context);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Log.d("RenderThread", "onSurfaceTextureAvailable " + surfaceTexture);
        this.n = true;
        if (this.o) {
            Log.i("RenderThread", "VRLibrary is released, not to create render thread!");
            return;
        }
        this.f2672b = surfaceTexture;
        this.t = false;
        a(surfaceTexture, i, i2, this.u);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Log.d("RenderThread", "gl onSurfaceTextureDestroyed");
        MDVRLibrary.i iVar = this.v;
        if (iVar != null) {
            iVar.onSurfaceDestroy();
        }
        this.n = false;
        c();
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Log.d("RenderThread", "onSurfaceTextureSizeChanged " + i + " " + i2);
        a(i, i2);
        GLSurfaceView.Renderer renderer = this.f2671a;
        if (renderer != null) {
            renderer.onSurfaceChanged(this.h, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    private void d() {
        synchronized (this) {
            if (!this.p) {
                Log.d("RenderThread", "gl not init, no need to release.");
                return;
            }
            Log.d("RenderThread", this.s + "gl Stopping eglMakeCurrent " + this.f.eglMakeCurrent(this.f2673c, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT));
            try {
                boolean eglDestroySurface = this.f.eglDestroySurface(this.f2673c, this.f2674d);
                this.f2674d = null;
                Log.d("RenderThread", this.s + "gl Stopping eglDestroySurface " + eglDestroySurface);
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("RenderThread", this.s + "eglDestroySurface failed");
            }
            h();
            try {
                boolean eglDestroyContext = this.f.eglDestroyContext(this.f2673c, this.e);
                this.e = null;
                Log.d("RenderThread", this.s + "gl Stopping eglDestroyContext " + eglDestroyContext);
            } catch (Exception e2) {
                e2.printStackTrace();
                Log.e("RenderThread", this.s + "eglDestroyContext failed");
            }
            h();
            try {
                boolean eglTerminate = this.f.eglTerminate(this.f2673c);
                this.f2673c = null;
                Log.d("RenderThread", this.s + "gl Stopping eglTerminate " + eglTerminate);
            } catch (Exception e3) {
                e3.printStackTrace();
                Log.e("RenderThread", this.s + "eglTerminate failed");
            }
            h();
            if (this.f2672b != null) {
                Log.d("RenderThread", this.s + "gl Stopping mSurfaceTexture.release() " + this.f2672b);
                this.f2672b.release();
                this.f2672b = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        return a() || this.f2671a == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        g();
        if (this.f2671a != null) {
            if (!this.t) {
                Log.d("RenderThread", "reset Render tid=" + this.s);
                if (this.f2671a instanceof i) {
                    ((i) this.f2671a).a();
                }
            }
            this.f2671a.onDrawFrame(this.h);
            this.t = true;
        }
        i();
        if (!this.f.eglSwapBuffers(this.f2673c, this.f2674d)) {
            Log.e("RenderThread", "cannot swap buffers!");
        }
    }

    private void g() {
        if (this.e.equals(this.f.eglGetCurrentContext()) && this.f2674d.equals(this.f.eglGetCurrentSurface(12377))) {
            return;
        }
        h();
        EGL10 egl10 = this.f;
        EGLDisplay eGLDisplay = this.f2673c;
        EGLSurface eGLSurface = this.f2674d;
        if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.e)) {
            h();
            return;
        }
        throw new RuntimeException("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.f.eglGetError()));
    }

    private void h() {
        int eglGetError = this.f.eglGetError();
        if (eglGetError != 12288) {
            Log.e("RenderThread", "EGL error = 0x" + Integer.toHexString(eglGetError) + " " + GLUtils.getEGLErrorString(this.f.eglGetError()) + " tid=" + this.s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        int glGetError = this.h.glGetError();
        if (glGetError != 0) {
            Log.e("RenderThread", "GL error = 0x" + Integer.toHexString(glGetError) + " tid=" + this.s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        synchronized (this) {
            if (this.o) {
                Log.i("RenderThread", "when initiating egl, interrupt to release egl");
                return false;
            }
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f2673c = eglGetDisplay;
            if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed " + GLUtils.getEGLErrorString(this.f.eglGetError()));
            }
            if (this.f.eglInitialize(eglGetDisplay, new int[2])) {
                Log.d("RenderThread", "init eglGetDisplay " + this.f2673c + " tid=" + this.s);
                int[] iArr = new int[1];
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                int[] iArr2 = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
                this.g = null;
                if (this.f.eglChooseConfig(this.f2673c, iArr2, eGLConfigArr, 1, iArr)) {
                    if (iArr[0] > 0) {
                        this.g = eGLConfigArr[0];
                    }
                    Log.d("RenderThread", "init eglChooseConfig " + this.g + " tid=" + this.s);
                    if (this.g != null) {
                        this.e = this.f.eglCreateContext(this.f2673c, this.g, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                        h();
                        Log.d("RenderThread", "init eglCreateContext" + this.e + " tid=" + this.s);
                        this.f2674d = this.f.eglCreateWindowSurface(this.f2673c, this.g, this.f2672b, null);
                        h();
                        Log.d("RenderThread", "init eglCreateWindowSurface" + this.f2674d + " tid=" + this.s);
                        if (this.f2674d != null && this.f2674d != EGL10.EGL_NO_SURFACE) {
                            if (this.f.eglMakeCurrent(this.f2673c, this.f2674d, this.f2674d, this.e)) {
                                Log.d("RenderThread", "init eglMakeCurrent tid=" + this.s);
                                h();
                                this.h = (GL10) this.e.getGL();
                                h();
                                this.p = true;
                                return true;
                            }
                            throw new RuntimeException("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.f.eglGetError()));
                        }
                        int eglGetError = this.f.eglGetError();
                        if (eglGetError == 12299) {
                            Log.e("RenderThread", "eglCreateWindowSurface returned EGL10.EGL_BAD_NATIVE_WINDOW");
                            return false;
                        }
                        throw new RuntimeException("eglCreateWindowSurface failed " + GLUtils.getEGLErrorString(eglGetError));
                    }
                    throw new RuntimeException("eglConfig not initialized");
                }
                throw new IllegalArgumentException("eglChooseConfig failed " + GLUtils.getEGLErrorString(this.f.eglGetError()));
            }
            throw new RuntimeException("eglInitialize failed " + GLUtils.getEGLErrorString(this.f.eglGetError()));
        }
    }

    public void c() {
        if (this.s != null) {
            Log.d("RenderThread", this.s + " Stopping and joining GLTextureView");
            a(true);
            d();
            this.l = false;
            try {
                this.s.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.s = null;
        }
    }

    public void b() {
        Log.d("RenderThread", "GLTextureView onDestroy");
        this.o = true;
        a(true);
        if (this.n) {
            return;
        }
        c();
    }

    public synchronized void a(GLSurfaceView.Renderer renderer) {
        this.f2671a = renderer;
        this.q = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(GLSurfaceView.Renderer renderer) {
        if (renderer != null) {
            if (this.l) {
                renderer.onSurfaceCreated(this.h, this.g);
                renderer.onSurfaceChanged(this.h, this.k, this.j);
            }
        }
    }

    public void a(d dVar) {
        this.r = dVar;
    }

    private void a(Context context) {
        this.u = 55;
        setSurfaceTextureListener(this);
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = null;
        this.t = false;
        a(context);
    }

    public void a(MDVRLibrary.i iVar) {
        this.v = iVar;
    }

    public void a(SurfaceTexture surfaceTexture, int i, int i2, float f) {
        this.s = new b();
        Log.d("RenderThread", this.s + " Starting GLTextureView thread");
        this.f2672b = surfaceTexture;
        a(false);
        a(i, i2);
        this.i = (int) ((1.0f / f) * 1000.0f);
        this.s.start();
    }

    public synchronized void a(boolean z) {
        Log.d("RenderThread", String.format("Setting GLTextureView paused to %s", Boolean.valueOf(z)));
        this.m = z;
    }

    public GLTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = null;
        this.t = false;
        a(context);
    }

    public synchronized boolean a() {
        return this.m;
    }

    public void a(int i, int i2) {
        this.k = i;
        this.j = i2;
    }
}
