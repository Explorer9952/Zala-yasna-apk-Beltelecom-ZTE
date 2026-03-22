package com.vk.api.sdk;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: VKScheduler.kt */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    private static final kotlin.d f3938b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final kotlin.d f3939c;

    /* renamed from: d, reason: collision with root package name */
    public static final m f3940d = new m();

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f3937a = new AtomicInteger();

    /* compiled from: VKScheduler.kt */
    /* loaded from: classes.dex */
    static final class a extends Lambda implements kotlin.jvm.b.a<Handler> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3941a = new a();

        a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.b.a
        @NotNull
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    }

    /* compiled from: VKScheduler.kt */
    /* loaded from: classes.dex */
    static final class b extends Lambda implements kotlin.jvm.b.a<ExecutorService> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f3942a = new b();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: VKScheduler.kt */
        /* loaded from: classes.dex */
        public static final class a implements ThreadFactory {

            /* renamed from: a, reason: collision with root package name */
            public static final a f3943a = new a();

            a() {
            }

            @Override // java.util.concurrent.ThreadFactory
            @NotNull
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "vk-api-network-thread-" + m.a(m.f3940d).getAndIncrement());
            }
        }

        b() {
            super(0);
        }

        @Override // kotlin.jvm.b.a
        public final ExecutorService invoke() {
            return Executors.newFixedThreadPool(32, a.f3943a);
        }
    }

    static {
        kotlin.d a2;
        kotlin.d a3;
        a2 = kotlin.f.a(a.f3941a);
        f3938b = a2;
        a3 = kotlin.f.a(b.f3942a);
        f3939c = a3;
    }

    private m() {
    }

    public static final /* synthetic */ AtomicInteger a(m mVar) {
        return f3937a;
    }

    private final Handler b() {
        return (Handler) f3938b.getValue();
    }

    @NotNull
    public final ExecutorService a() {
        return (ExecutorService) f3939c.getValue();
    }

    public static /* synthetic */ void a(Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        a(runnable, j);
    }

    public static final void a(@NotNull Runnable runnable, long j) {
        kotlin.jvm.internal.f.b(runnable, "runnable");
        if (kotlin.jvm.internal.f.a(Looper.myLooper(), Looper.getMainLooper()) && j == 0) {
            runnable.run();
        } else {
            f3940d.b().postDelayed(runnable, j);
        }
    }
}
