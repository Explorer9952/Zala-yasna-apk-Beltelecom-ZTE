package com.render.vrlib;

import android.view.MotionEvent;
import com.render.vrlib.MDVRLibrary;
import com.render.vrlib.s;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MDPickerManager.java */
/* loaded from: classes.dex */
public class t implements MDVRLibrary.g {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f2618a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.f2618a = sVar;
    }

    @Override // com.render.vrlib.MDVRLibrary.g
    public void onClick(MotionEvent motionEvent) {
        s.e eVar;
        s.e eVar2;
        eVar = this.f2618a.i;
        eVar.a(motionEvent.getX(), motionEvent.getY());
        eVar2 = this.f2618a.i;
        eVar2.run();
    }
}
