package com.vk.api.sdk.o;

import com.vk.api.sdk.exceptions.VKApiException;
import com.vk.api.sdk.exceptions.VKApiExecutionException;
import com.vk.api.sdk.exceptions.VKApiIllegalResponseException;
import com.vk.api.sdk.exceptions.VKInternalServerErrorException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InternalErrorRetryChainCall.kt */
/* loaded from: classes.dex */
public final class c<T> extends f<T> {

    /* renamed from: c, reason: collision with root package name */
    private final com.vk.api.sdk.r.b f3948c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final b<T> f3949d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull com.vk.api.sdk.e eVar, int i, @NotNull b<? extends T> bVar) {
        super(eVar, i);
        kotlin.jvm.internal.f.b(eVar, "manager");
        kotlin.jvm.internal.f.b(bVar, "chain");
        this.f3949d = bVar;
        this.f3948c = new com.vk.api.sdk.r.b(1000L, 60000L, 1.5f, 0.0f, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Throwable, com.vk.api.sdk.exceptions.VKInternalServerErrorException] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Throwable, com.vk.api.sdk.exceptions.VKApiIllegalResponseException] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Throwable, com.vk.api.sdk.exceptions.VKApiExecutionException] */
    @Override // com.vk.api.sdk.o.b
    @Nullable
    public T a(@NotNull a aVar) throws Exception {
        kotlin.jvm.internal.f.b(aVar, "args");
        ?? e = 0;
        while (true) {
            if (b() >= 0 && this.f3948c.b() > b()) {
                if (e == 0) {
                    throw new VKApiException("api-call failed due to retry limits, but no exception has tracked");
                }
                throw e;
            }
            if (this.f3948c.f()) {
                Thread.sleep(this.f3948c.a());
            }
            try {
                return this.f3949d.a(aVar);
            } catch (VKApiExecutionException e2) {
                e = e2;
                if (!e.isInternalServerError()) {
                    throw e;
                }
                b("", e);
                this.f3948c.d();
            } catch (VKApiIllegalResponseException e3) {
                e = e3;
                b("", e);
                this.f3948c.d();
            } catch (VKInternalServerErrorException e4) {
                e = e4;
                b("", e);
                this.f3948c.d();
            }
        }
    }
}
