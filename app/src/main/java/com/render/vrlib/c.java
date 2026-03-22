package com.render.vrlib;

import com.render.vrlib.MDVRLibrary;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MDVRLibrary.java */
/* loaded from: classes.dex */
public class c implements MDVRLibrary.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MDVRLibrary.s f2469a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MDVRLibrary.r f2470b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ MDVRLibrary f2471c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MDVRLibrary mDVRLibrary, MDVRLibrary.s sVar, MDVRLibrary.r rVar) {
        this.f2471c = mDVRLibrary;
        this.f2469a = sVar;
        this.f2470b = rVar;
    }

    @Override // com.render.vrlib.MDVRLibrary.c
    public void a(float f, float f2, float f3) {
        float f4 = 0.0f;
        if (this.f2471c.f2429d.d() <= 150) {
            f2 = 0.0f;
        }
        if (Math.abs(f) < Math.abs(f2)) {
            f4 = f2;
            f = 0.0f;
        }
        this.f2471c.f2427b.a(f, f4, f3);
    }

    @Override // com.render.vrlib.MDVRLibrary.c
    public void a(float f) {
        com.render.vrlib.a.d dVar;
        this.f2469a.a(f);
        dVar = this.f2471c.j;
        dVar.a(this.f2469a);
    }

    @Override // com.render.vrlib.MDVRLibrary.c
    public void a(float f, float f2) {
        q qVar;
        q qVar2;
        com.render.vrlib.a.d dVar;
        MDVRLibrary.r rVar = this.f2470b;
        qVar = this.f2471c.g;
        float width = f / qVar.a().getWidth();
        qVar2 = this.f2471c.g;
        rVar.a(width, f2 / qVar2.a().getHeight());
        dVar = this.f2471c.j;
        dVar.a(this.f2470b);
    }

    @Override // com.render.vrlib.MDVRLibrary.c
    public void a() {
        Iterator<a> it2 = this.f2471c.f2429d.f().iterator();
        while (it2.hasNext()) {
            it2.next().r();
        }
    }
}
