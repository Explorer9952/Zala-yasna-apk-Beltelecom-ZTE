package com.zte.fragmentlib.helper;

import android.view.animation.Animation;

/* compiled from: DebounceAnimListener.java */
/* loaded from: classes.dex */
public class b implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    private com.zte.fragmentlib.b f4069a;

    public b(com.zte.fragmentlib.b bVar) {
        this.f4069a = bVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f4069a.C();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
