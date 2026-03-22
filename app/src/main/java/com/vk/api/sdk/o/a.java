package com.vk.api.sdk.o;

import org.jetbrains.annotations.NotNull;

/* compiled from: ChainArgs.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private String f3944a = "";

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private String f3945b = "";

    /* renamed from: c, reason: collision with root package name */
    private boolean f3946c;

    @NotNull
    public final String a() {
        return this.f3945b;
    }

    @NotNull
    public final String b() {
        return this.f3944a;
    }

    public final boolean c() {
        return this.f3946c;
    }

    public final boolean d() {
        if (this.f3944a.length() > 0) {
            if (this.f3945b.length() > 0) {
                return true;
            }
        }
        return false;
    }

    public final void a(@NotNull String str) {
        kotlin.jvm.internal.f.b(str, "<set-?>");
        this.f3945b = str;
    }

    public final void b(@NotNull String str) {
        kotlin.jvm.internal.f.b(str, "<set-?>");
        this.f3944a = str;
    }

    public final void a(boolean z) {
        this.f3946c = z;
    }
}
