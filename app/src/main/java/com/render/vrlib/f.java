package com.render.vrlib;

import com.render.vrlib.MDVRLibrary;

/* compiled from: MDVRLibrary.java */
/* loaded from: classes.dex */
/* synthetic */ class f {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f2474a;

    static {
        int[] iArr = new int[MDVRLibrary.BulletTimeMode.values().length];
        f2474a = iArr;
        try {
            iArr[MDVRLibrary.BulletTimeMode.MODE_TO_RIGHT_ONLY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f2474a[MDVRLibrary.BulletTimeMode.MODE_TO_LEFT_ONLY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f2474a[MDVRLibrary.BulletTimeMode.MODE_FIRST_RIGHT_THEN_LEFT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f2474a[MDVRLibrary.BulletTimeMode.MODE_FIRST_LEFT_THEN_RIGHT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
