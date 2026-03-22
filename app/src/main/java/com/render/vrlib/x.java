package com.render.vrlib;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.render.vrlib.MDVRLibrary;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MDTouchHelper.java */
/* loaded from: classes.dex */
public class x extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f2668a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar) {
        this.f2668a = vVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        boolean z;
        i = this.f2668a.f2623d;
        if (i == 1) {
            return false;
        }
        z = this.f2668a.m;
        if (!z) {
            return false;
        }
        this.f2668a.a(f, f2);
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        MDVRLibrary.c cVar;
        boolean z;
        float f3;
        float g;
        MDVRLibrary.c cVar2;
        float g2;
        float g3;
        float f4;
        i = this.f2668a.f2623d;
        if (i == 1) {
            return false;
        }
        cVar = this.f2668a.f2620a;
        if (cVar != null) {
            z = this.f2668a.o;
            if (z) {
                v vVar = this.f2668a;
                f3 = vVar.q;
                g = this.f2668a.g(f);
                vVar.q = f3 + g;
                cVar2 = this.f2668a.f2620a;
                g2 = this.f2668a.g(f);
                g3 = this.f2668a.g(f2);
                f4 = this.f2668a.q;
                cVar2.a(g2, g3, f4);
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        int i;
        List list;
        i = this.f2668a.f2623d;
        if (i == 1) {
            return false;
        }
        list = this.f2668a.f2621b;
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ((MDVRLibrary.g) it2.next()).onClick(motionEvent);
        }
        return false;
    }
}
