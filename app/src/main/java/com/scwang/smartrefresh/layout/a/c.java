package com.scwang.smartrefresh.layout.a;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;

/* compiled from: RefreshContent.java */
/* loaded from: classes.dex */
public interface c {
    ValueAnimator.AnimatorUpdateListener a(g gVar, int i, int i2, Interpolator interpolator, int i3);

    View a();

    void a(int i);

    void a(int i, int i2);

    void a(int i, int i2, int i3, int i4);

    void a(MotionEvent motionEvent);

    void a(g gVar, View view, View view2);

    void b(int i, int i2);

    boolean b(MotionEvent motionEvent);

    boolean c();

    boolean d();

    ViewGroup.LayoutParams e();

    int f();

    void g();

    boolean h();

    boolean i();

    int j();

    View k();
}
