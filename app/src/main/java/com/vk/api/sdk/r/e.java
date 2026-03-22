package com.vk.api.sdk.r;

import kotlin.reflect.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ThreadLocalDelegate.kt */
/* loaded from: classes.dex */
public final class e {
    @NotNull
    public static final <T> c<T> a(@NotNull kotlin.jvm.b.a<? extends T> aVar) {
        kotlin.jvm.internal.f.b(aVar, "factory");
        return new d(aVar);
    }

    public static final <T> T a(@NotNull c<T> cVar, @Nullable Object obj, @NotNull j<?> jVar) {
        kotlin.jvm.internal.f.b(cVar, "$this$getValue");
        kotlin.jvm.internal.f.b(jVar, "property");
        return cVar.get();
    }
}
