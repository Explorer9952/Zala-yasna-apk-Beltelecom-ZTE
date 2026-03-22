package com.render.vrlib.n;

import com.render.vrlib.MDVRLibrary;
import com.render.vrlib.n.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MD360BitmapTexture.java */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a.C0081a f2586a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f2587b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, a.C0081a c0081a) {
        this.f2587b = aVar;
        this.f2586a = c0081a;
    }

    @Override // java.lang.Runnable
    public void run() {
        MDVRLibrary.d dVar;
        dVar = this.f2587b.e;
        dVar.onProvideBitmap(this.f2586a);
    }
}
