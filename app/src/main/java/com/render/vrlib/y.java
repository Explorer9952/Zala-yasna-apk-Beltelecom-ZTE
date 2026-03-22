package com.render.vrlib;

import android.animation.ValueAnimator;
import com.render.vrlib.MDVRLibrary;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MDTouchHelper.java */
/* loaded from: classes.dex */
public class y implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    private long f2669a = 0;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ v f2670b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(v vVar) {
        this.f2670b = vVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        com.render.vrlib.w.g gVar;
        com.render.vrlib.w.g gVar2;
        MDVRLibrary.c cVar;
        boolean z;
        MDVRLibrary.c cVar2;
        float g;
        float g2;
        float f;
        long currentPlayTime = valueAnimator.getCurrentPlayTime();
        float f2 = (float) (currentPlayTime - this.f2669a);
        float floatValue = (((Float) valueAnimator.getAnimatedValue("vx")).floatValue() * f2) / (-1000.0f);
        gVar = this.f2670b.n;
        float c2 = floatValue * gVar.c();
        float floatValue2 = (((Float) valueAnimator.getAnimatedValue("vy")).floatValue() * f2) / (-1000.0f);
        gVar2 = this.f2670b.n;
        float c3 = floatValue2 * gVar2.c();
        this.f2669a = currentPlayTime;
        cVar = this.f2670b.f2620a;
        if (cVar != null) {
            z = this.f2670b.o;
            if (z) {
                cVar2 = this.f2670b.f2620a;
                g = this.f2670b.g(c2);
                g2 = this.f2670b.g(c3);
                f = this.f2670b.q;
                cVar2.a(g, g2, f);
            }
        }
    }
}
