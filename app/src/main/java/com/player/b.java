package com.player;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.SurfaceHolder;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GLEnvironment.java */
/* loaded from: classes.dex */
public class b implements SurfaceHolder.Callback2 {
    private static final j l = new j();

    /* renamed from: a, reason: collision with root package name */
    public Object f2397a;

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<b> f2398b = new WeakReference<>(this);

    /* renamed from: c, reason: collision with root package name */
    private i f2399c;

    /* renamed from: d, reason: collision with root package name */
    private GLSurfaceView.Renderer f2400d;
    private boolean e;
    private e f;
    private f g;
    private g h;
    private int i;
    private int j;
    private boolean k;

    /* compiled from: GLEnvironment.java */
    /* loaded from: classes.dex */
    private abstract class a implements e {

        /* renamed from: a, reason: collision with root package name */
        protected int[] f2401a;

        public a(int[] iArr) {
            this.f2401a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (b.this.j != 2 && b.this.j != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            if (b.this.j == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        @Override // com.player.b.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f2401a, null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.f2401a, eGLConfigArr, i, iArr)) {
                        EGLConfig a2 = a(egl10, eGLDisplay, eGLConfigArr);
                        if (a2 != null) {
                            return a2;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
    }

    /* compiled from: GLEnvironment.java */
    /* loaded from: classes.dex */
    private class c implements f {

        /* renamed from: a, reason: collision with root package name */
        private int f2405a;

        private c() {
            this.f2405a = 12440;
        }

        @Override // com.player.b.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.f2405a, b.this.j, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (b.this.j == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.player.b.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            h.b("eglDestroyContex", egl10.eglGetError());
            throw null;
        }
    }

    /* compiled from: GLEnvironment.java */
    /* loaded from: classes.dex */
    private static class d implements g {
        private d() {
        }

        @Override // com.player.b.g
        public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLSurfaceView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.player.b.g
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* compiled from: GLEnvironment.java */
    /* loaded from: classes.dex */
    public interface e {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* compiled from: GLEnvironment.java */
    /* loaded from: classes.dex */
    public interface f {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* compiled from: GLEnvironment.java */
    /* loaded from: classes.dex */
    public interface g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GLEnvironment.java */
    /* loaded from: classes.dex */
    public static class i extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private boolean f2411a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f2412b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f2413c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f2414d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean q;
        private h t;
        private WeakReference<b> u;
        private ArrayList<Runnable> r = new ArrayList<>();
        private boolean s = true;
        private int l = 0;
        private int m = 0;
        private boolean o = true;
        private int n = 1;
        private boolean p = false;

        i(WeakReference<b> weakReference) {
            this.u = weakReference;
        }

        /* JADX WARN: Removed duplicated region for block: B:171:0x0204 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void g() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 529
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.player.b.i.g():void");
        }

        private boolean h() {
            return !this.f2414d && this.e && !this.f && this.l > 0 && this.m > 0 && (this.o || this.n == 1);
        }

        private void i() {
            if (this.h) {
                this.t.d();
                this.h = false;
                b.l.a(this);
            }
        }

        private void j() {
            if (this.i) {
                this.i = false;
                this.t.c();
            }
        }

        public int b() {
            int i;
            synchronized (b.l) {
                i = this.n;
            }
            return i;
        }

        public void c() {
            synchronized (b.l) {
                this.f2411a = true;
                b.l.notifyAll();
                while (!this.f2412b) {
                    try {
                        b.l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void d() {
            synchronized (b.l) {
                if (Thread.currentThread() == this) {
                    return;
                }
                this.p = true;
                this.o = true;
                this.q = false;
                b.l.notifyAll();
                while (!this.f2412b && !this.f2414d && !this.q && a()) {
                    try {
                        b.l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void e() {
            synchronized (b.l) {
                this.e = true;
                this.j = false;
                b.l.notifyAll();
                while (this.g && !this.j && !this.f2412b) {
                    try {
                        b.l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void f() {
            synchronized (b.l) {
                this.e = false;
                b.l.notifyAll();
                while (!this.g && !this.f2412b) {
                    try {
                        b.l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                g();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                b.l.b(this);
                throw th;
            }
            b.l.b(this);
        }

        public boolean a() {
            return this.h && this.i && h();
        }

        public void a(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (b.l) {
                    this.n = i;
                    b.l.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public void a(int i, int i2) {
            synchronized (b.l) {
                this.l = i;
                this.m = i2;
                this.s = true;
                this.o = true;
                this.q = false;
                if (Thread.currentThread() == this) {
                    return;
                }
                b.l.notifyAll();
                while (!this.f2412b && !this.f2414d && !this.q && a()) {
                    try {
                        b.l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GLEnvironment.java */
    /* loaded from: classes.dex */
    public static class j {
        private j() {
        }

        public void a(i iVar) {
            notifyAll();
        }

        public synchronized void b(i iVar) {
            iVar.f2412b = true;
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GLEnvironment.java */
    /* loaded from: classes.dex */
    public static class k extends Writer {

        /* renamed from: a, reason: collision with root package name */
        private StringBuilder f2415a = new StringBuilder();

        k() {
        }

        private void g() {
            if (this.f2415a.length() > 0) {
                Log.v("GLSurfaceView", this.f2415a.toString());
                StringBuilder sb = this.f2415a;
                sb.delete(0, sb.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            g();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            g();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c2 = cArr[i + i3];
                if (c2 == '\n') {
                    g();
                } else {
                    this.f2415a.append(c2);
                }
            }
        }
    }

    /* compiled from: GLEnvironment.java */
    /* loaded from: classes.dex */
    private class l extends C0076b {
        public l(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    public b(Context context) {
        e();
    }

    private void e() {
    }

    protected void finalize() throws Throwable {
        try {
            if (this.f2399c != null) {
                this.f2399c.c();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.f2399c.a(i3, i4);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f2399c.e();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f2399c.f();
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        i iVar = this.f2399c;
        if (iVar != null) {
            iVar.d();
        }
    }

    private void d() {
        if (this.f2399c != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public void a(boolean z) {
        this.k = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        i iVar = this.f2399c;
        if (iVar != null) {
            iVar.c();
        }
        this.e = true;
    }

    public void a(GLSurfaceView.Renderer renderer) {
        d();
        if (this.f == null) {
            this.f = new l(true);
        }
        if (this.g == null) {
            this.g = new c();
        }
        if (this.h == null) {
            this.h = new d();
        }
        this.f2400d = renderer;
        i iVar = new i(this.f2398b);
        this.f2399c = iVar;
        iVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GLEnvironment.java */
    /* loaded from: classes.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<b> f2407a;

        /* renamed from: b, reason: collision with root package name */
        EGL10 f2408b;

        /* renamed from: c, reason: collision with root package name */
        EGLDisplay f2409c;

        /* renamed from: d, reason: collision with root package name */
        EGLSurface f2410d;
        EGLConfig e;
        EGLContext f;

        public h(WeakReference<b> weakReference) {
            this.f2407a = weakReference;
        }

        private void g() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.f2410d;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.f2408b.eglMakeCurrent(this.f2409c, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            b bVar = this.f2407a.get();
            if (bVar != null) {
                bVar.h.destroySurface(this.f2408b, this.f2409c, this.f2410d);
            }
            this.f2410d = null;
        }

        GL a() {
            GL gl = this.f.getGL();
            b bVar = this.f2407a.get();
            if (bVar == null || (bVar.i & 3) == 0) {
                return gl;
            }
            return GLDebugHelper.wrap(gl, (bVar.i & 1) != 0 ? 1 : 0, (bVar.i & 2) != 0 ? new k() : null);
        }

        public boolean b() {
            if (this.f2408b != null) {
                if (this.f2409c != null) {
                    if (this.e != null) {
                        g();
                        b bVar = this.f2407a.get();
                        if (bVar != null) {
                            this.f2410d = bVar.h.a(this.f2408b, this.f2409c, this.e, bVar.f2397a);
                        } else {
                            this.f2410d = null;
                        }
                        EGLSurface eGLSurface = this.f2410d;
                        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                            if (this.f2408b.eglMakeCurrent(this.f2409c, eGLSurface, eGLSurface, this.f)) {
                                return true;
                            }
                            a("EGLHelper", "eglMakeCurrent", this.f2408b.eglGetError());
                            return false;
                        }
                        if (this.f2408b.eglGetError() == 12299) {
                            Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                        }
                        return false;
                    }
                    throw new RuntimeException("mEglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            throw new RuntimeException("egl not initialized");
        }

        public void c() {
            g();
        }

        public void d() {
            if (this.f != null) {
                b bVar = this.f2407a.get();
                if (bVar != null) {
                    bVar.g.destroyContext(this.f2408b, this.f2409c, this.f);
                }
                this.f = null;
            }
            EGLDisplay eGLDisplay = this.f2409c;
            if (eGLDisplay != null) {
                this.f2408b.eglTerminate(eGLDisplay);
                this.f2409c = null;
            }
        }

        public void e() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f2408b = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f2409c = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.f2408b.eglInitialize(eglGetDisplay, new int[2])) {
                    b bVar = this.f2407a.get();
                    if (bVar != null) {
                        this.e = bVar.f.chooseConfig(this.f2408b, this.f2409c);
                        this.f = bVar.g.createContext(this.f2408b, this.f2409c, this.e);
                    } else {
                        this.e = null;
                        this.f = null;
                    }
                    EGLContext eGLContext = this.f;
                    if (eGLContext != null && eGLContext != EGL10.EGL_NO_CONTEXT) {
                        this.f2410d = null;
                        return;
                    } else {
                        this.f = null;
                        a("createContext");
                        throw null;
                    }
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public int f() {
            if (this.f2408b.eglSwapBuffers(this.f2409c, this.f2410d)) {
                return 12288;
            }
            return this.f2408b.eglGetError();
        }

        private void a(String str) {
            b(str, this.f2408b.eglGetError());
            throw null;
        }

        public static void a(String str, String str2, int i) {
            Log.w(str, a(str2, i));
        }

        public static String a(String str, int i) {
            return str + " failed: " + i;
        }

        public static void b(String str, int i) {
            throw new RuntimeException(a(str, i));
        }
    }

    /* compiled from: GLEnvironment.java */
    /* renamed from: com.player.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0076b extends a {

        /* renamed from: c, reason: collision with root package name */
        private int[] f2403c;

        /* renamed from: d, reason: collision with root package name */
        protected int f2404d;
        protected int e;
        protected int f;
        protected int g;
        protected int h;
        protected int i;

        public C0076b(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.f2403c = new int[1];
            this.f2404d = i;
            this.e = i2;
            this.f = i3;
            this.g = i4;
            this.h = i5;
            this.i = i6;
        }

        @Override // com.player.b.a
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a3 = a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a2 >= this.h && a3 >= this.i) {
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int a7 = a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a4 == this.f2404d && a5 == this.e && a6 == this.f && a7 == this.g) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.f2403c) ? this.f2403c[0] : i2;
        }
    }

    public void a(g gVar) {
        d();
        this.h = gVar;
    }

    public void a(e eVar) {
        d();
        this.f = eVar;
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7) {
        a(new C0076b(i2, i3, i4, i5, i6, i7));
    }

    public void a(int i2) {
        d();
        this.j = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        if (this.e && this.f2400d != null) {
            i iVar = this.f2399c;
            int b2 = iVar != null ? iVar.b() : 1;
            i iVar2 = new i(this.f2398b);
            this.f2399c = iVar2;
            if (b2 != 1) {
                iVar2.a(b2);
            }
            this.f2399c.start();
        }
        this.e = false;
    }
}
