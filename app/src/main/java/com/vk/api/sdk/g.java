package com.vk.api.sdk;

import com.vk.api.sdk.exceptions.VKApiExecutionException;
import java.util.concurrent.CountDownLatch;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VKApiValidationHandler.kt */
/* loaded from: classes.dex */
public interface g {

    /* compiled from: VKApiValidationHandler.kt */
    /* loaded from: classes.dex */
    public static class a<T> {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private volatile T f3913a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final CountDownLatch f3914b;

        public a(@NotNull CountDownLatch countDownLatch) {
            kotlin.jvm.internal.f.b(countDownLatch, "latch");
            this.f3914b = countDownLatch;
        }

        public void a() {
            this.f3914b.countDown();
        }

        @Nullable
        public final T b() {
            return this.f3913a;
        }

        public void a(T t) {
            this.f3913a = t;
            this.f3914b.countDown();
        }
    }

    /* compiled from: VKApiValidationHandler.kt */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f3915a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final String f3916b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private final String f3917c;

        public b(@Nullable String str, @Nullable String str2, @Nullable Integer num) {
            boolean z;
            boolean a2;
            this.f3916b = str;
            this.f3917c = str2;
            if (str2 != null) {
                a2 = u.a(str2);
                if (!a2) {
                    z = false;
                    this.f3915a = true ^ z;
                }
            }
            z = true;
            this.f3915a = true ^ z;
        }

        @Nullable
        public final String a() {
            return this.f3916b;
        }

        @Nullable
        public final String b() {
            return this.f3917c;
        }

        public final boolean c() {
            return this.f3915a;
        }
    }

    /* compiled from: VKApiValidationHandler.kt */
    /* loaded from: classes.dex */
    public static final class c {
        public static void a(g gVar, @NotNull VKApiExecutionException vKApiExecutionException, @NotNull e eVar) throws VKApiExecutionException {
            kotlin.jvm.internal.f.b(vKApiExecutionException, "ex");
            kotlin.jvm.internal.f.b(eVar, "apiManager");
            throw vKApiExecutionException;
        }
    }

    void a(@NotNull VKApiExecutionException vKApiExecutionException, @NotNull e eVar) throws VKApiExecutionException;

    void a(@NotNull String str, @NotNull a<b> aVar);

    void b(@NotNull String str, @NotNull a<Boolean> aVar);

    void c(@NotNull String str, @NotNull a<String> aVar);
}
