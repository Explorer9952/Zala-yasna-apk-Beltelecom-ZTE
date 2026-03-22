package com.vk.api.sdk.o;

import org.jetbrains.annotations.NotNull;

/* compiled from: RetryChainCall.kt */
/* loaded from: classes.dex */
public abstract class f<T> extends b<T> {

    /* renamed from: b, reason: collision with root package name */
    private final int f3954b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull com.vk.api.sdk.e eVar, int i) {
        super(eVar);
        kotlin.jvm.internal.f.b(eVar, "manager");
        this.f3954b = i;
        if (i < 0) {
            throw new IllegalArgumentException("retryLimit must be >= 0");
        }
    }

    public final int b() {
        return this.f3954b;
    }
}
