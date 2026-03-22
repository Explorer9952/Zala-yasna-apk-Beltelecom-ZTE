package com.vk.api.sdk.o;

import com.vk.api.sdk.exceptions.VKApiException;
import com.vk.api.sdk.exceptions.VKApiExecutionException;
import com.vk.api.sdk.g;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.FunctionReference;
import kotlin.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ValidationHandlerChainCall.kt */
/* loaded from: classes.dex */
public final class h<T> extends f<T> {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final com.vk.api.sdk.o.b<T> f3958c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ValidationHandlerChainCall.kt */
    /* loaded from: classes.dex */
    public static final /* synthetic */ class a extends FunctionReference implements q<com.vk.api.sdk.g, String, g.a<String>, l> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3959a = new a();

        a() {
            super(3);
        }

        public final void a(@NotNull com.vk.api.sdk.g gVar, @NotNull String str, @NotNull g.a<String> aVar) {
            kotlin.jvm.internal.f.b(gVar, "p1");
            kotlin.jvm.internal.f.b(str, "p2");
            kotlin.jvm.internal.f.b(aVar, "p3");
            gVar.c(str, aVar);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getName() {
            return "handleCaptcha";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final kotlin.reflect.d getOwner() {
            return kotlin.jvm.internal.h.a(com.vk.api.sdk.g.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "handleCaptcha(Ljava/lang/String;Lcom/vk/api/sdk/VKApiValidationHandler$Callback;)V";
        }

        @Override // kotlin.jvm.b.q
        public /* bridge */ /* synthetic */ l invoke(com.vk.api.sdk.g gVar, String str, g.a<String> aVar) {
            a(gVar, str, aVar);
            return l.f8186a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ValidationHandlerChainCall.kt */
    /* loaded from: classes.dex */
    public static final /* synthetic */ class b extends FunctionReference implements q<com.vk.api.sdk.g, String, g.a<Boolean>, l> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f3960a = new b();

        b() {
            super(3);
        }

        public final void a(@NotNull com.vk.api.sdk.g gVar, @NotNull String str, @NotNull g.a<Boolean> aVar) {
            kotlin.jvm.internal.f.b(gVar, "p1");
            kotlin.jvm.internal.f.b(str, "p2");
            kotlin.jvm.internal.f.b(aVar, "p3");
            gVar.b(str, aVar);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getName() {
            return "handleConfirm";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final kotlin.reflect.d getOwner() {
            return kotlin.jvm.internal.h.a(com.vk.api.sdk.g.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "handleConfirm(Ljava/lang/String;Lcom/vk/api/sdk/VKApiValidationHandler$Callback;)V";
        }

        @Override // kotlin.jvm.b.q
        public /* bridge */ /* synthetic */ l invoke(com.vk.api.sdk.g gVar, String str, g.a<Boolean> aVar) {
            a(gVar, str, aVar);
            return l.f8186a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ValidationHandlerChainCall.kt */
    /* loaded from: classes.dex */
    public static final /* synthetic */ class c extends FunctionReference implements q<com.vk.api.sdk.g, String, g.a<g.b>, l> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f3961a = new c();

        c() {
            super(3);
        }

        public final void a(@NotNull com.vk.api.sdk.g gVar, @NotNull String str, @NotNull g.a<g.b> aVar) {
            kotlin.jvm.internal.f.b(gVar, "p1");
            kotlin.jvm.internal.f.b(str, "p2");
            kotlin.jvm.internal.f.b(aVar, "p3");
            gVar.a(str, aVar);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getName() {
            return "handleValidation";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final kotlin.reflect.d getOwner() {
            return kotlin.jvm.internal.h.a(com.vk.api.sdk.g.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "handleValidation(Ljava/lang/String;Lcom/vk/api/sdk/VKApiValidationHandler$Callback;)V";
        }

        @Override // kotlin.jvm.b.q
        public /* bridge */ /* synthetic */ l invoke(com.vk.api.sdk.g gVar, String str, g.a<g.b> aVar) {
            a(gVar, str, aVar);
            return l.f8186a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public h(@NotNull com.vk.api.sdk.e eVar, int i, @NotNull com.vk.api.sdk.o.b<? extends T> bVar) {
        super(eVar, i);
        kotlin.jvm.internal.f.b(eVar, "manager");
        kotlin.jvm.internal.f.b(bVar, "chain");
        this.f3958c = bVar;
    }

    private final void b(VKApiExecutionException vKApiExecutionException, com.vk.api.sdk.o.a aVar) throws Exception {
        if (vKApiExecutionException.isCaptchaError()) {
            a(vKApiExecutionException, aVar);
            return;
        }
        if (vKApiExecutionException.isValidationRequired()) {
            a(vKApiExecutionException);
            return;
        }
        if (vKApiExecutionException.isUserConfirmRequired()) {
            c(vKApiExecutionException, aVar);
            return;
        }
        com.vk.api.sdk.g d2 = a().d();
        if (d2 == null) {
            throw vKApiExecutionException;
        }
        d2.a(vKApiExecutionException, a());
    }

    private final void c(VKApiExecutionException vKApiExecutionException, com.vk.api.sdk.o.a aVar) {
        Boolean bool = (Boolean) a(vKApiExecutionException.getUserConfirmText(), a().d(), b.f3960a);
        if (bool != null) {
            if (!kotlin.jvm.internal.f.a((Object) bool, (Object) false)) {
                aVar.a(bool.booleanValue());
                return;
            }
            throw vKApiExecutionException;
        }
        throw vKApiExecutionException;
    }

    @Override // com.vk.api.sdk.o.b
    @Nullable
    public T a(@NotNull com.vk.api.sdk.o.a aVar) throws Exception {
        kotlin.jvm.internal.f.b(aVar, "args");
        int b2 = b();
        if (b2 >= 0) {
            int i = 0;
            while (true) {
                try {
                    return this.f3958c.a(aVar);
                } catch (VKApiExecutionException e) {
                    b(e, aVar);
                    if (i == b2) {
                        break;
                    }
                    i++;
                }
            }
        }
        throw new VKApiException("Can't confirm validation due to retry limit!");
    }

    private final void a(VKApiExecutionException vKApiExecutionException) {
        a((g.b) a(vKApiExecutionException.getValidationUrl(), a().d(), c.f3961a), vKApiExecutionException);
    }

    protected final void a(@Nullable g.b bVar, @NotNull VKApiExecutionException vKApiExecutionException) {
        kotlin.jvm.internal.f.b(vKApiExecutionException, "ex");
        if (bVar != null) {
            if (!bVar.c()) {
                throw vKApiExecutionException;
            }
            com.vk.api.sdk.e a2 = a();
            String b2 = bVar.b();
            if (b2 != null) {
                a2.a(b2, bVar.a());
                return;
            } else {
                kotlin.jvm.internal.f.a();
                throw null;
            }
        }
        throw vKApiExecutionException;
    }

    private final void a(VKApiExecutionException vKApiExecutionException, com.vk.api.sdk.o.a aVar) {
        String str = (String) a(vKApiExecutionException.getCaptchaImg(), a().d(), a.f3959a);
        if (str != null) {
            aVar.b(vKApiExecutionException.getCaptchaSid());
            aVar.a(str);
            return;
        }
        throw vKApiExecutionException;
    }

    @Nullable
    protected final <T, H> T a(@NotNull String str, @Nullable H h, @NotNull q<? super H, ? super String, ? super g.a<T>, l> qVar) {
        kotlin.jvm.internal.f.b(str, "extra");
        kotlin.jvm.internal.f.b(qVar, "handlerMethod");
        if (h == null) {
            return null;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        g.a aVar = new g.a(countDownLatch);
        qVar.invoke(h, str, aVar);
        countDownLatch.await();
        return (T) aVar.b();
    }
}
