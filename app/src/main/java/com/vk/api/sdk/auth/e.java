package com.vk.api.sdk.auth;

import org.jetbrains.annotations.Nullable;

/* compiled from: VKAuthResult.kt */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final a f3896a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3897b;

    public e(@Nullable a aVar, int i) {
        this.f3896a = aVar;
        this.f3897b = i;
    }

    @Nullable
    public final a a() {
        return this.f3896a;
    }

    public final boolean b() {
        return this.f3897b != 0;
    }

    public /* synthetic */ e(a aVar, int i, int i2, kotlin.jvm.internal.d dVar) {
        this(aVar, (i2 & 2) != 0 ? 0 : i);
    }
}
