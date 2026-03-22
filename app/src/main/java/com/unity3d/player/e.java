package com.unity3d.player;

import android.os.Build;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    static final boolean f2999a;

    /* renamed from: b, reason: collision with root package name */
    static final boolean f3000b;

    /* renamed from: c, reason: collision with root package name */
    static final b f3001c;

    static {
        f2999a = Build.VERSION.SDK_INT >= 21;
        boolean z = Build.VERSION.SDK_INT >= 23;
        f3000b = z;
        f3001c = z ? new d() : null;
    }
}
