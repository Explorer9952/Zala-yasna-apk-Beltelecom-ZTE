package com.vk.api.sdk.o;

import com.vk.api.sdk.exceptions.VKApiException;
import com.vk.api.sdk.exceptions.VKApiExecutionException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TooManyRequestRetryChainCall.kt */
/* loaded from: classes.dex */
public final class g<T> extends f<T> {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final b<T> f3955c;

    /* compiled from: TooManyRequestRetryChainCall.kt */
    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: b, reason: collision with root package name */
        public static final a f3957b = new a();

        /* renamed from: a, reason: collision with root package name */
        private static final com.vk.api.sdk.r.b f3956a = new com.vk.api.sdk.r.b(1000, 8000, 1.2f, 0.0f, 8, null);

        private a() {
        }

        public final synchronized void a() {
            f3956a.d();
        }

        public final synchronized long b() {
            return f3956a.a();
        }

        public final synchronized void c() {
            f3956a.e();
        }

        public final synchronized boolean d() {
            return f3956a.f();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull com.vk.api.sdk.e eVar, int i, @NotNull b<? extends T> bVar) {
        super(eVar, i);
        kotlin.jvm.internal.f.b(eVar, "manager");
        kotlin.jvm.internal.f.b(bVar, "chain");
        this.f3955c = bVar;
    }

    @Override // com.vk.api.sdk.o.b
    @Nullable
    public T a(@NotNull com.vk.api.sdk.o.a aVar) throws Exception {
        kotlin.jvm.internal.f.b(aVar, "args");
        int b2 = b();
        if (b2 >= 0) {
            int i = 0;
            while (true) {
                if (a.f3957b.d()) {
                    Thread.sleep(a.f3957b.b());
                }
                try {
                    T a2 = this.f3955c.a(aVar);
                    a.f3957b.c();
                    return a2;
                } catch (VKApiExecutionException e) {
                    if (e.isTooManyRequestsError()) {
                        a("Too many requests", e);
                        a.f3957b.a();
                        if (i == b2) {
                            break;
                        }
                        i++;
                    } else {
                        throw e;
                    }
                }
            }
        }
        throw new VKApiException("Can't handle too many requests due to retry limit! (retryLimit=" + b() + ')');
    }
}
