package com.vk.api.sdk;

import com.tencent.mm.sdk.plugin.MMPluginProviderConstants;
import com.vk.api.sdk.exceptions.VKApiException;
import com.vk.api.sdk.p.d;
import java.io.IOException;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VKApiManager.kt */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final g f3908a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.d f3909b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private volatile d f3910c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final c f3911d;

    /* compiled from: VKApiManager.kt */
    /* loaded from: classes.dex */
    static final class a extends Lambda implements kotlin.jvm.b.a<com.vk.api.sdk.p.b> {
        a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.b.a
        @NotNull
        public final com.vk.api.sdk.p.b invoke() {
            return new com.vk.api.sdk.p.b(new com.vk.api.sdk.p.c(e.this.a()));
        }
    }

    public e(@NotNull c cVar) {
        kotlin.d a2;
        kotlin.jvm.internal.f.b(cVar, "config");
        this.f3911d = cVar;
        this.f3908a = cVar.m();
        a2 = kotlin.f.a(new a());
        this.f3909b = a2;
    }

    @NotNull
    public final c a() {
        return this.f3911d;
    }

    @NotNull
    public com.vk.api.sdk.p.b b() {
        return (com.vk.api.sdk.p.b) this.f3909b.getValue();
    }

    public final <T> T b(@NotNull j jVar, @Nullable f<T> fVar) throws InterruptedException, IOException, VKApiException {
        kotlin.jvm.internal.f.b(jVar, "call");
        return (T) a(a(jVar, a(jVar, fVar)));
    }

    @Nullable
    public final d c() {
        return this.f3910c;
    }

    @Nullable
    public final g d() {
        return this.f3908a;
    }

    public final void a(@NotNull String str, @Nullable String str2) {
        kotlin.jvm.internal.f.b(str, MMPluginProviderConstants.OAuth.ACCESS_TOKEN);
        b().a(str, str2);
    }

    @NotNull
    protected <T> com.vk.api.sdk.o.b<T> a(@NotNull j jVar, @NotNull com.vk.api.sdk.o.b<? extends T> bVar) {
        kotlin.jvm.internal.f.b(jVar, "call");
        kotlin.jvm.internal.f.b(bVar, "chainCall");
        if (!jVar.d()) {
            bVar = a(jVar.c(), bVar);
        }
        com.vk.api.sdk.o.g gVar = new com.vk.api.sdk.o.g(this, jVar.c(), new com.vk.api.sdk.o.d(this, bVar));
        return jVar.c() > 0 ? new com.vk.api.sdk.o.c(this, jVar.c(), gVar) : gVar;
    }

    private final <T> com.vk.api.sdk.o.h<T> a(int i, com.vk.api.sdk.o.b<? extends T> bVar) {
        return new com.vk.api.sdk.o.h<>(this, i, bVar);
    }

    protected <T> T a(@NotNull com.vk.api.sdk.o.b<? extends T> bVar) throws InterruptedException, IOException, VKApiException {
        kotlin.jvm.internal.f.b(bVar, "cc");
        T a2 = bVar.a(new com.vk.api.sdk.o.a());
        if (a2 != null) {
            return a2;
        }
        kotlin.jvm.internal.f.a();
        throw null;
    }

    @NotNull
    protected <T> com.vk.api.sdk.o.b<T> a(@NotNull j jVar, @Nullable f<T> fVar) {
        kotlin.jvm.internal.f.b(jVar, "call");
        com.vk.api.sdk.p.b b2 = b();
        d.a aVar = new d.a();
        aVar.a(jVar);
        return new com.vk.api.sdk.o.e(this, b2, aVar, this.f3911d.e().getValue(), this.f3911d.h(), fVar);
    }
}
