package com.render.vrlib;

/* compiled from: MDDirectorCamera.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2594a;
    private boolean i;
    private boolean n;

    /* renamed from: b, reason: collision with root package name */
    private float f2595b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    private float f2596c = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f2597d = 0.0f;
    private float e = 0.0f;
    private float f = 0.0f;
    private float g = -1.0f;
    private double h = 0.0d;
    private float j = 1.0f;
    private float k = 1.5f;
    private int l = 2;
    private int m = 1;
    private final com.render.vrlib.w.e.a o = com.render.vrlib.w.e.a.m();

    /* JADX INFO: Access modifiers changed from: package-private */
    public o a(float f) {
        this.e = f;
        this.f2594a = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o b(float f) {
        this.f = f;
        this.f2594a = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o c(float f) {
        this.g = f;
        this.f2594a = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o d(float f) {
        this.f2595b = f;
        this.f2594a = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o e(float f) {
        this.f2596c = f;
        this.f2594a = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o f(float f) {
        this.f2597d = f;
        this.f2594a = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double g() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float h() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o i(float f) {
        this.o.a(f);
        this.n = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o j(float f) {
        this.o.b(f);
        this.n = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float k() {
        return this.o.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float l() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        return this.n;
    }

    public boolean p() {
        return this.f2594a;
    }

    public boolean q() {
        return this.i;
    }

    public void r() {
        this.f2594a = false;
    }

    public void s() {
        this.i = false;
    }

    public void t() {
        this.n = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o g(float f) {
        this.j = f;
        this.i = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o h(float f) {
        this.o.c(f);
        this.n = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o a(double d2) {
        this.h = d2;
        this.f2594a = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.f2596c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f2597d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        return this.o.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.o.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a() {
        return this.f2595b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o a(int i, int i2) {
        this.l = i;
        this.m = i2;
        this.k = (i * 1.0f) / i2;
        this.i = true;
        return this;
    }
}
