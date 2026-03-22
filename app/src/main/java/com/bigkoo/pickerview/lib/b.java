package com.bigkoo.pickerview.lib;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: LoopViewGestureListener.java */
/* loaded from: classes.dex */
final class b extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    final WheelView f1905a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(WheelView wheelView) {
        this.f1905a = wheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f1905a.a(f2);
        return true;
    }
}
