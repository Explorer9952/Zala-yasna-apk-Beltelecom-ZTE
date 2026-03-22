package com.render.vrlib;

import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import com.render.vrlib.MDVRLibrary;
import com.render.vrlib.w.l;
import com.render.vrlib.w.n;

/* compiled from: MD360Director.java */
/* loaded from: classes.dex */
public class a {
    protected static MDVRLibrary.q u;
    protected static MDVRLibrary.n v;
    private final o k;
    private p o;
    protected float p;
    protected float q;

    /* renamed from: a, reason: collision with root package name */
    private float[] f2448a = new float[16];

    /* renamed from: b, reason: collision with root package name */
    private float[] f2449b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    private float[] f2450c = new float[16];

    /* renamed from: d, reason: collision with root package name */
    private float[] f2451d = new float[16];
    private float[] e = new float[16];
    private float[] f = new float[16];
    private float[] g = new float[16];
    private float[] h = new float[16];
    private float[] i = new float[16];
    private float[] j = new float[16];
    private final m l = new m();
    private final com.render.vrlib.w.e.a m = com.render.vrlib.w.e.a.m();
    private final n n = new n();
    protected int r = 1;
    protected boolean s = true;
    protected boolean t = true;

    /* compiled from: MD360Director.java */
    /* renamed from: com.render.vrlib.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0077a {

        /* renamed from: a, reason: collision with root package name */
        private o f2452a = new o();

        private o b() {
            return this.f2452a;
        }

        public C0077a a(float f) {
            b().i(f);
            return this;
        }

        public a a() {
            return new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(C0077a c0077a) {
        this.k = c0077a.f2452a;
        t();
    }

    public static C0077a s() {
        return new C0077a();
    }

    private void t() {
        Matrix.setIdentityM(this.f2448a, 0);
        Matrix.setIdentityM(this.h, 0);
        this.n.b(this.f2448a);
    }

    private void u() {
        boolean z = true;
        boolean z2 = this.k.p() || this.l.m();
        if (!this.s && !this.k.o() && !this.l.l()) {
            z = false;
        }
        if (z2) {
            x();
            this.k.r();
            this.l.o();
        }
        if (z) {
            this.m.a(this.k.i() + this.l.i());
            this.m.c(this.k.k() + this.l.k());
            this.m.b(this.k.j() + this.l.j());
            y();
            this.s = false;
            this.k.t();
            this.l.q();
        }
        if (z2 || z) {
            Matrix.multiplyMM(this.f2448a, 0, this.j, 0, this.e, 0);
            v();
        }
    }

    private void v() {
        if (this.o == null) {
            return;
        }
        this.n.b(this.f2448a);
        float f = this.n.f();
        float h = this.n.h();
        float d2 = this.n.d();
        float b2 = this.o.b(f);
        float a2 = this.o.a(h);
        float c2 = this.o.c(d2);
        if (f == b2 && h == a2 && d2 == c2) {
            return;
        }
        this.n.a(b2, a2, c2);
        this.n.a(this.f2448a);
    }

    private void w() {
        if (this.k.q() || this.l.n() || this.t) {
            a();
            this.k.s();
            this.l.p();
            this.t = false;
        }
    }

    private void x() {
        float a2 = this.k.a() + this.l.a();
        float b2 = this.k.b() + this.l.b();
        float c2 = this.k.c() + this.l.c();
        float d2 = this.k.d() + this.l.d();
        float e = this.k.e() + this.l.e();
        float f = this.l.f();
        float cos = ((float) Math.cos(this.l.g())) * 1.0f;
        float sin = ((float) Math.sin(this.l.g())) * (-1.0f);
        Matrix.setIdentityM(this.j, 0);
        Matrix.setLookAtM(this.j, 0, a2, b2, c2, d2, e, f, 0.0f, cos, sin);
    }

    private void y() {
        Matrix.setIdentityM(this.e, 0);
        Matrix.rotateM(this.e, 0, -this.q, 1.0f, 0.0f, 0.0f);
        Matrix.setIdentityM(this.g, 0);
        Matrix.rotateM(this.g, 0, -this.p, 0.0f, 1.0f, 0.0f);
        Matrix.setIdentityM(this.i, 0);
        Matrix.multiplyMM(this.i, 0, this.g, 0, this.m.a(), 0);
        Matrix.multiplyMM(this.g, 0, this.h, 0, this.i, 0);
        Matrix.multiplyMM(this.i, 0, this.e, 0, this.g, 0);
        System.arraycopy(this.i, 0, this.e, 0, 16);
        if (com.render.vrlib.a.h.a(this.f, this.e)) {
            return;
        }
        Matrix.setIdentityM(this.f, 0);
    }

    public void a(float f) {
        this.p = f;
        this.s = true;
    }

    public void a(float f, float f2) {
    }

    public void a(int i) {
    }

    public void a(Rect rect) {
    }

    public void a(RectF rectF) {
    }

    public void b(float f) {
        this.q = f;
        this.s = true;
    }

    public void c() {
        w();
        u();
    }

    public void c(float f) {
    }

    public void d(float f) {
        this.k.g(f);
    }

    public int e() {
        return -1;
    }

    public float f() {
        return this.p;
    }

    public float g() {
        return this.q;
    }

    public float[] h() {
        return this.f2449b;
    }

    public Rect i() {
        return null;
    }

    public float[] j() {
        return this.f2448a;
    }

    public n k() {
        return this.n;
    }

    public int l() {
        return this.k.n();
    }

    public int m() {
        return this.k.m();
    }

    public void n() {
        this.q = 0.0f;
        this.p = 0.0f;
        Matrix.setIdentityM(this.h, 0);
        this.s = true;
    }

    public void o() {
    }

    public void p() {
    }

    public void q() {
    }

    public void r() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float d() {
        return this.k.l();
    }

    public void a(MDVRLibrary.q qVar) {
        Log.d("MD360Director", "setOnStateListener " + qVar);
        u = qVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float b() {
        return (this.k.h() + this.l.h()) * 0.7f;
    }

    public void a(MDVRLibrary.n nVar) {
        Log.d("MD360Director", "setOnBulletIndexChangedListener " + nVar);
        v = nVar;
    }

    public void a(h hVar, l lVar) {
        Matrix.multiplyMM(this.f2450c, 0, this.f2448a, 0, lVar.a(), 0);
        Matrix.multiplyMM(this.f2451d, 0, this.f2449b, 0, this.f2450c, 0);
        GLES20.glUniformMatrix4fv(hVar.c(), 1, false, this.f2450c, 0);
        GLES20.glUniformMatrix4fv(hVar.b(), 1, false, this.f2451d, 0);
    }

    public void a(int i, int i2) {
        this.k.a(i, i2);
    }

    protected void a() {
        Matrix.frustumM(h(), 0, (-this.k.l()) / 2.0f, this.k.l() / 2.0f, -0.5f, 0.5f, b(), 500.0f);
    }

    public void a(float[] fArr) {
        if (fArr == null || fArr.length != 16 || Float.isNaN(fArr[0]) || Float.isNaN(fArr[1])) {
            return;
        }
        System.arraycopy(fArr, 0, this.h, 0, 16);
        this.s = true;
    }

    public void a(m mVar) {
        this.l.a(mVar);
    }

    public void a(p pVar) {
        this.o = pVar;
    }
}
