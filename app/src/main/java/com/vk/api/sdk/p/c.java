package com.vk.api.sdk.p;

import android.content.Context;
import com.vk.api.sdk.k;
import com.vk.api.sdk.utils.log.Logger;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OkHttpExecutorConfig.kt */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final com.vk.api.sdk.c f3976a;

    public c(@NotNull com.vk.api.sdk.c cVar) {
        f.b(cVar, "apiConfig");
        this.f3976a = cVar;
        com.vk.api.sdk.internal.e.f3926a.a(c());
        com.vk.api.sdk.internal.e.f3926a.b(e());
        com.vk.api.sdk.internal.e.f3926a.a(a());
    }

    @NotNull
    public final String a() {
        return this.f3976a.a().getValue();
    }

    public final int b() {
        return this.f3976a.b();
    }

    @NotNull
    public final Context c() {
        return this.f3976a.c();
    }

    public final long d() {
        return this.f3976a.d();
    }

    @NotNull
    public final String e() {
        return this.f3976a.f().getValue();
    }

    public final boolean f() {
        return this.f3976a.i();
    }

    @NotNull
    public final Logger g() {
        return this.f3976a.j();
    }

    @NotNull
    public final k h() {
        return this.f3976a.k();
    }

    @Nullable
    public final String i() {
        return this.f3976a.l().getValue();
    }

    @NotNull
    public String toString() {
        return "OkHttpExecutorConfig(host='" + e() + "', accessToken='" + a() + "', secret='" + i() + "', logFilterCredentials=" + f() + ')';
    }
}
