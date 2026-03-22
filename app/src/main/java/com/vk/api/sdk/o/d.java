package com.vk.api.sdk.o;

import com.vk.api.sdk.exceptions.VKApiExecutionException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InvalidCredentialsObserverChainCall.kt */
/* loaded from: classes.dex */
public final class d<T> extends b<T> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final b<T> f3950b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull com.vk.api.sdk.e eVar, @NotNull b<? extends T> bVar) {
        super(eVar);
        kotlin.jvm.internal.f.b(eVar, "manager");
        kotlin.jvm.internal.f.b(bVar, "chain");
        this.f3950b = bVar;
    }

    @Override // com.vk.api.sdk.o.b
    @Nullable
    public T a(@NotNull a aVar) throws Exception {
        com.vk.api.sdk.d c2;
        kotlin.jvm.internal.f.b(aVar, "args");
        try {
            return this.f3950b.a(aVar);
        } catch (VKApiExecutionException e) {
            if (e.isInvalidCredentialsError() && (c2 = a().c()) != null) {
                c2.a(e.getApiMethod(), e.getUserBanInfo());
            }
            throw e;
        }
    }
}
