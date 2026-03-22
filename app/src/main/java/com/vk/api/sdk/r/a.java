package com.vk.api.sdk.r;

import com.vk.api.sdk.exceptions.VKApiException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ApiExt.kt */
/* loaded from: classes.dex */
public final class a {
    public static final boolean a(@NotNull String str, @Nullable int[] iArr) {
        kotlin.jvm.internal.f.b(str, "$this$hasExecuteError");
        return com.vk.api.sdk.internal.d.f3925a.a(str, iArr);
    }

    public static final boolean a(@NotNull String str) {
        kotlin.jvm.internal.f.b(str, "$this$hasSimpleError");
        return com.vk.api.sdk.internal.d.f3925a.a(str);
    }

    @NotNull
    public static final VKApiException a(@NotNull String str, @Nullable String str2) {
        kotlin.jvm.internal.f.b(str, "$this$toSimpleError");
        return com.vk.api.sdk.internal.d.f3925a.a(str, str2);
    }

    @NotNull
    public static final VKApiException a(@NotNull String str, @NotNull String str2, @Nullable int[] iArr) {
        kotlin.jvm.internal.f.b(str, "$this$toExecuteError");
        kotlin.jvm.internal.f.b(str2, "method");
        return com.vk.api.sdk.internal.d.f3925a.a(str, str2, iArr);
    }

    public static final <E> void a(@NotNull b.b.d<E> dVar, long j, E e) {
        kotlin.jvm.internal.f.b(dVar, "$this$set");
        dVar.c(j, e);
    }
}
