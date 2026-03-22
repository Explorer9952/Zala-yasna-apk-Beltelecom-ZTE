package com.zte.iptvclient.android.mobile.tv.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* compiled from: WeeklyTitleView.java */
/* loaded from: classes2.dex */
public class c extends FrameLayout implements net.lucode.hackware.magicindicator.e.c.b.b {

    /* renamed from: a, reason: collision with root package name */
    private b f7312a;

    /* renamed from: b, reason: collision with root package name */
    private a f7313b;

    /* compiled from: WeeklyTitleView.java */
    /* loaded from: classes2.dex */
    public interface a {
        int a();

        int b();

        int c();

        int d();
    }

    /* compiled from: WeeklyTitleView.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(int i, int i2);

        void a(int i, int i2, float f, boolean z);

        void b(int i, int i2);

        void b(int i, int i2, float f, boolean z);
    }

    public c(Context context) {
        super(context);
    }

    @Override // net.lucode.hackware.magicindicator.e.c.b.d
    public void a(int i, int i2) {
        b bVar = this.f7312a;
        if (bVar != null) {
            bVar.a(i, i2);
        }
    }

    @Override // net.lucode.hackware.magicindicator.e.c.b.d
    public void b(int i, int i2) {
        b bVar = this.f7312a;
        if (bVar != null) {
            bVar.b(i, i2);
        }
    }

    @Override // net.lucode.hackware.magicindicator.e.c.b.b
    public int c() {
        a aVar = this.f7313b;
        if (aVar != null) {
            return aVar.c();
        }
        return getLeft();
    }

    @Override // net.lucode.hackware.magicindicator.e.c.b.b
    public int d() {
        a aVar = this.f7313b;
        if (aVar != null) {
            return aVar.d();
        }
        return getRight();
    }

    @Override // net.lucode.hackware.magicindicator.e.c.b.d
    public void a(int i, int i2, float f, boolean z) {
        b bVar = this.f7312a;
        if (bVar != null) {
            bVar.a(i, i2, f, z);
        }
    }

    @Override // net.lucode.hackware.magicindicator.e.c.b.d
    public void b(int i, int i2, float f, boolean z) {
        b bVar = this.f7312a;
        if (bVar != null) {
            bVar.b(i, i2, f, z);
        }
    }

    @Override // net.lucode.hackware.magicindicator.e.c.b.b
    public int a() {
        a aVar = this.f7313b;
        if (aVar != null) {
            return aVar.a();
        }
        return getTop();
    }

    @Override // net.lucode.hackware.magicindicator.e.c.b.b
    public int b() {
        a aVar = this.f7313b;
        if (aVar != null) {
            return aVar.b();
        }
        return getBottom();
    }

    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        removeAllViews();
        if (view != null) {
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            addView(view, layoutParams);
        }
    }

    public void a(int i) {
        a(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null), (FrameLayout.LayoutParams) null);
    }

    public void a(b bVar) {
        this.f7312a = bVar;
    }
}
