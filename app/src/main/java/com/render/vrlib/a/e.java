package com.render.vrlib.a;

import android.os.Handler;
import android.os.Looper;

/* compiled from: MDMainHandler.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static Handler f2461a;

    public static void a() {
        if (f2461a == null) {
            f2461a = new Handler(Looper.getMainLooper());
        }
    }

    public static Handler b() {
        return f2461a;
    }
}
