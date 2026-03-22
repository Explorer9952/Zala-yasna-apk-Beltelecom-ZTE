package com.render.vrlib;

import com.render.vrlib.MDVRLibrary;

/* compiled from: MDDirectorFilter.java */
/* loaded from: classes.dex */
public class p implements MDVRLibrary.e {

    /* renamed from: a, reason: collision with root package name */
    private MDVRLibrary.e f2598a;

    @Override // com.render.vrlib.MDVRLibrary.e
    public float a(float f) {
        MDVRLibrary.e eVar = this.f2598a;
        return eVar != null ? eVar.a(f) : f;
    }

    @Override // com.render.vrlib.MDVRLibrary.e
    public float b(float f) {
        MDVRLibrary.e eVar = this.f2598a;
        return eVar != null ? eVar.b(f) : f;
    }

    @Override // com.render.vrlib.MDVRLibrary.e
    public float c(float f) {
        MDVRLibrary.e eVar = this.f2598a;
        return eVar != null ? eVar.c(f) : f;
    }

    public void a(MDVRLibrary.e eVar) {
        this.f2598a = eVar;
    }
}
