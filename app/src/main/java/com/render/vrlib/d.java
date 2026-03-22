package com.render.vrlib;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MDVRLibrary.java */
/* loaded from: classes.dex */
public class d implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MDVRLibrary f2472a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MDVRLibrary mDVRLibrary) {
        this.f2472a = mDVRLibrary;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        v vVar;
        vVar = this.f2472a.h;
        return vVar.a(motionEvent);
    }
}
