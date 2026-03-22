package com.vk.api.sdk;

import java.util.concurrent.TimeUnit;
import okhttp3.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: VKOkHttpProvider.kt */
/* loaded from: classes.dex */
public abstract class k {

    /* compiled from: VKOkHttpProvider.kt */
    /* loaded from: classes.dex */
    public interface a {
        @NotNull
        v.b a(@NotNull v.b bVar);
    }

    @NotNull
    public abstract v a();

    public abstract void a(@NotNull a aVar);

    /* compiled from: VKOkHttpProvider.kt */
    /* loaded from: classes.dex */
    public static final class b extends k {

        /* renamed from: a, reason: collision with root package name */
        private volatile v f3935a;

        @Override // com.vk.api.sdk.k
        @NotNull
        public v a() {
            if (this.f3935a == null) {
                v.b s = new v().s();
                s.a(20L, TimeUnit.SECONDS);
                s.b(30L, TimeUnit.SECONDS);
                s.c(20L, TimeUnit.SECONDS);
                s.a(true);
                s.b(true);
                this.f3935a = s.a();
            }
            v vVar = this.f3935a;
            if (vVar != null) {
                return vVar;
            }
            kotlin.jvm.internal.f.a();
            throw null;
        }

        @Override // com.vk.api.sdk.k
        public void a(@NotNull a aVar) {
            kotlin.jvm.internal.f.b(aVar, "f");
            v.b s = a().s();
            kotlin.jvm.internal.f.a((Object) s, "getClient().newBuilder()");
            this.f3935a = aVar.a(s).a();
        }
    }
}
