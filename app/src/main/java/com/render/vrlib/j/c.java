package com.render.vrlib.j;

import android.content.Context;
import com.render.vrlib.a;
import com.render.vrlib.w.l;

/* compiled from: MDAbsPlugin.java */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2497a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2498b = false;

    /* renamed from: c, reason: collision with root package name */
    private long f2499c;

    public c() {
        l.b();
    }

    public abstract void a(int i, int i2);

    public abstract void a(int i, int i2, int i3, a aVar);

    public final void a(Context context) {
        long id = Thread.currentThread().getId();
        if (id != this.f2499c) {
            this.f2499c = id;
            this.f2497a = false;
        }
        if (this.f2497a) {
            return;
        }
        a(context, this.f2498b);
        this.f2497a = true;
        this.f2498b = false;
    }

    protected abstract void a(Context context, boolean z);

    public abstract void b();

    public void a() {
        this.f2497a = false;
        this.f2498b = true;
    }
}
