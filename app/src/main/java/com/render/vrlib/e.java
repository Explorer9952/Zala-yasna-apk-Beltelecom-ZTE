package com.render.vrlib;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MDVRLibrary.java */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MDVRLibrary f2473a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MDVRLibrary mDVRLibrary) {
        this.f2473a = mDVRLibrary;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<a> it2 = this.f2473a.f2429d.f().iterator();
        while (it2.hasNext()) {
            it2.next().n();
        }
    }
}
