package com.render.vrlib.n;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.render.vrlib.MDVRLibrary;
import com.render.vrlib.h;
import java.lang.ref.SoftReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: MD360BitmapTexture.java */
/* loaded from: classes.dex */
public class a extends c {
    private MDVRLibrary.d e;
    private boolean f;
    private C0081a g;
    private AtomicBoolean h = new AtomicBoolean(false);

    /* compiled from: MD360BitmapTexture.java */
    /* loaded from: classes.dex */
    public interface b {
        int a();

        void a(Bitmap bitmap);
    }

    public a(MDVRLibrary.d dVar) {
        this.e = dVar;
    }

    private void j() {
        C0081a c0081a = this.g;
        if (c0081a != null) {
            c0081a.d();
            this.g = null;
        }
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(3379, iArr, 0);
        C0081a c0081a2 = new C0081a(iArr[0]);
        this.g = c0081a2;
        com.render.vrlib.a.e.b().post(new com.render.vrlib.n.b(this, c0081a2));
    }

    @Override // com.render.vrlib.n.c
    public void b() {
        C0081a c0081a = this.g;
        if (c0081a != null) {
            c0081a.d();
            this.g = null;
        }
    }

    @Override // com.render.vrlib.n.c
    public void c() {
    }

    public boolean i() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MD360BitmapTexture.java */
    /* renamed from: com.render.vrlib.n.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0081a implements b {

        /* renamed from: a, reason: collision with root package name */
        private SoftReference<Bitmap> f2584a;

        /* renamed from: b, reason: collision with root package name */
        private int f2585b;

        public C0081a(int i) {
            this.f2585b = i;
        }

        @Override // com.render.vrlib.n.a.b
        public void a(Bitmap bitmap) {
            d();
            this.f2584a = new SoftReference<>(bitmap);
        }

        public Bitmap b() {
            SoftReference<Bitmap> softReference = this.f2584a;
            if (softReference != null) {
                return softReference.get();
            }
            return null;
        }

        public boolean c() {
            SoftReference<Bitmap> softReference = this.f2584a;
            return (softReference == null || softReference.get() == null) ? false : true;
        }

        public void d() {
            SoftReference<Bitmap> softReference = this.f2584a;
            if (softReference != null) {
                softReference.clear();
            }
            this.f2584a = null;
        }

        @Override // com.render.vrlib.n.a.b
        public int a() {
            return this.f2585b;
        }
    }

    @Override // com.render.vrlib.n.c
    protected int a() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        j();
        return i;
    }

    @Override // com.render.vrlib.n.c
    public boolean a(h hVar) {
        if (this.h.get()) {
            j();
            this.h.set(false);
        }
        C0081a c0081a = this.g;
        int h = h();
        if (c0081a != null && c0081a.c()) {
            a(h, hVar, c0081a.b());
            c0081a.d();
            this.f = true;
        }
        if (i() && h != 0) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, h);
            GLES20.glUniform1i(hVar.d(), 0);
        }
        return true;
    }

    private void a(int i, h hVar, Bitmap bitmap) {
        com.render.vrlib.a.h.a(bitmap, "bitmap can't be null!");
        if (b(i)) {
            return;
        }
        GLES20.glActiveTexture(33984);
        com.render.vrlib.a.b.a("MD360BitmapTexture glActiveTexture");
        GLES20.glBindTexture(3553, i);
        com.render.vrlib.a.b.a("MD360BitmapTexture glBindTexture");
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        com.render.vrlib.a.b.a("MD360BitmapTexture texImage2D");
        GLES20.glUniform1i(hVar.d(), 0);
        com.render.vrlib.a.b.a("MD360BitmapTexture textureInThread");
    }
}
