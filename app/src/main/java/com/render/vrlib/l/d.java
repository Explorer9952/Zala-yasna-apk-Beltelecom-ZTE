package com.render.vrlib.l;

import android.content.Context;
import com.render.vrlib.MDVRLibrary;
import com.render.vrlib.a.e;
import com.render.vrlib.l.b;

/* compiled from: ModeManager.java */
/* loaded from: classes.dex */
public abstract class d<T extends b> {

    /* renamed from: a, reason: collision with root package name */
    private int f2531a;

    /* renamed from: b, reason: collision with root package name */
    private T f2532b;

    /* renamed from: c, reason: collision with root package name */
    private MDVRLibrary.h f2533c;

    /* renamed from: d, reason: collision with root package name */
    private com.render.vrlib.a.d f2534d;

    public d(int i, com.render.vrlib.a.d dVar) {
        this.f2534d = dVar;
        this.f2531a = i;
    }

    private void b(Context context, int i) {
        if (this.f2532b != null) {
            c(context);
        }
        T a2 = a(i);
        this.f2532b = a2;
        if (!a2.f(context)) {
            e.b().post(new f(this, i));
        } else {
            a(context);
        }
    }

    protected abstract T a(int i);

    public void c(Context context) {
        com.render.vrlib.a.h.a("strategy off must call from main thread!");
        T t = this.f2532b;
        if (t.f(context)) {
            g().a(new h(this, t, context));
        }
    }

    public int d() {
        return this.f2531a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T e() {
        return this.f2532b;
    }

    public com.render.vrlib.a.d g() {
        return this.f2534d;
    }

    public void a(Context context, MDVRLibrary.h hVar) {
        this.f2533c = hVar;
        b(context, this.f2531a);
    }

    public void a(Context context, int i) {
        if (i == d()) {
            return;
        }
        this.f2531a = i;
        b(context, i);
    }

    public void a(Context context) {
        com.render.vrlib.a.h.a("strategy on must call from main thread!");
        T t = this.f2532b;
        if (t.f(context)) {
            g().a(new g(this, t, context));
        }
    }
}
