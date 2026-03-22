package com.render.vrlib.j;

import android.content.Context;

/* compiled from: MDAbsLinePipe.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2495a;

    /* renamed from: b, reason: collision with root package name */
    private long f2496b;

    public abstract void a(int i, int i2, int i3);

    protected abstract void a(Context context);

    public abstract void b(int i, int i2, int i3);

    public final void b(Context context) {
        long id = Thread.currentThread().getId();
        if (this.f2496b != id) {
            this.f2496b = id;
            this.f2495a = false;
        }
        if (this.f2495a) {
            return;
        }
        a(context);
        this.f2495a = true;
    }
}
