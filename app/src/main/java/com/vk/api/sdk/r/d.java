package com.vk.api.sdk.r;

import org.jetbrains.annotations.NotNull;

/* compiled from: ThreadLocalDelegate.kt */
/* loaded from: classes.dex */
public final class d<T> implements c<T> {

    /* renamed from: a, reason: collision with root package name */
    private final ThreadLocal<T> f3991a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.jvm.b.a<T> f3992b;

    /* compiled from: ThreadLocalDelegate.kt */
    /* loaded from: classes.dex */
    public static final class a extends ThreadLocal<T> {
        a() {
        }

        @Override // java.lang.ThreadLocal
        protected T initialValue() {
            return d.this.a().invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull kotlin.jvm.b.a<? extends T> aVar) {
        kotlin.jvm.internal.f.b(aVar, "factory");
        this.f3992b = aVar;
        this.f3991a = new a();
    }

    @NotNull
    public final kotlin.jvm.b.a<T> a() {
        return this.f3992b;
    }

    @Override // com.vk.api.sdk.r.c
    public T get() {
        T t = this.f3991a.get();
        if (t != null) {
            return t;
        }
        kotlin.jvm.internal.f.a();
        throw null;
    }
}
