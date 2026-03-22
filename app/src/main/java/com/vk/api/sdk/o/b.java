package com.vk.api.sdk.o;

import com.vk.api.sdk.utils.log.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChainCall.kt */
/* loaded from: classes.dex */
public abstract class b<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final com.vk.api.sdk.e f3947a;

    public b(@NotNull com.vk.api.sdk.e eVar) {
        kotlin.jvm.internal.f.b(eVar, "manager");
        this.f3947a = eVar;
    }

    @NotNull
    public final com.vk.api.sdk.e a() {
        return this.f3947a;
    }

    @Nullable
    public abstract T a(@NotNull a aVar) throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(@NotNull String str, @NotNull Throwable th) {
        kotlin.jvm.internal.f.b(str, "msg");
        kotlin.jvm.internal.f.b(th, "t");
        this.f3947a.a().j().a(Logger.LogLevel.WARNING, str, th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(@NotNull String str, @NotNull Throwable th) {
        kotlin.jvm.internal.f.b(str, "msg");
        kotlin.jvm.internal.f.b(th, "t");
        this.f3947a.a().j().a(Logger.LogLevel.DEBUG, str, th);
    }
}
