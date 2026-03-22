package com.vk.api.sdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.vk.api.sdk.auth.VKScope;
import com.vk.api.sdk.exceptions.VKApiException;
import com.vk.api.sdk.exceptions.VKApiExecutionException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VK.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static c f3876a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static e f3877b;

    /* renamed from: c, reason: collision with root package name */
    private static com.vk.api.sdk.auth.c f3878c;
    private static int e;
    public static final a f = new a();

    /* renamed from: d, reason: collision with root package name */
    private static final ArrayList<n> f3879d = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VK.kt */
    /* renamed from: com.vk.api.sdk.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class RunnableC0097a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.vk.api.sdk.internal.a f3880a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.vk.api.sdk.b f3881b;

        /* compiled from: VK.kt */
        /* renamed from: com.vk.api.sdk.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class RunnableC0098a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Object f3883b;

            RunnableC0098a(Object obj) {
                this.f3883b = obj;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.vk.api.sdk.b bVar = RunnableC0097a.this.f3881b;
                if (bVar != null) {
                    bVar.a((com.vk.api.sdk.b) this.f3883b);
                }
            }
        }

        /* compiled from: VK.kt */
        /* renamed from: com.vk.api.sdk.a$a$b */
        /* loaded from: classes.dex */
        static final class b implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Exception f3885b;

            b(Exception exc) {
                this.f3885b = exc;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Exception exc = this.f3885b;
                if ((exc instanceof VKApiExecutionException) && ((VKApiExecutionException) exc).isInvalidCredentialsError()) {
                    a.f.b();
                }
                com.vk.api.sdk.b bVar = RunnableC0097a.this.f3881b;
                if (bVar != null) {
                    bVar.a(this.f3885b);
                }
            }
        }

        RunnableC0097a(com.vk.api.sdk.internal.a aVar, com.vk.api.sdk.b bVar) {
            this.f3880a = aVar;
            this.f3881b = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                m.a(new RunnableC0098a(a.a(this.f3880a)), 0L, 2, null);
            } catch (Exception e) {
                m.a(new b(e), 0L, 2, null);
            }
        }
    }

    private a() {
    }

    @NotNull
    public static final String c() {
        c cVar = f3876a;
        if (cVar != null) {
            return cVar.n();
        }
        kotlin.jvm.internal.f.d("config");
        throw null;
    }

    public static final boolean d() {
        com.vk.api.sdk.auth.c cVar = f3878c;
        if (cVar != null) {
            return cVar.c();
        }
        kotlin.jvm.internal.f.d("authManager");
        throw null;
    }

    private final void e() {
        a(new com.vk.api.sdk.q.a("stats.trackVisitor"), (b) null, 2, (Object) null);
    }

    @NotNull
    public final e a() {
        e eVar = f3877b;
        if (eVar != null) {
            return eVar;
        }
        kotlin.jvm.internal.f.d("apiManager");
        throw null;
    }

    public final void b() {
        com.vk.api.sdk.auth.c cVar = f3878c;
        if (cVar != null) {
            cVar.a();
            Iterator<T> it2 = f3879d.iterator();
            while (it2.hasNext()) {
                ((n) it2.next()).a();
            }
            return;
        }
        kotlin.jvm.internal.f.d("authManager");
        throw null;
    }

    public static final void a(@NotNull c cVar) {
        kotlin.jvm.internal.f.b(cVar, "config");
        f3876a = cVar;
        f3877b = new e(cVar);
        com.vk.api.sdk.auth.c cVar2 = new com.vk.api.sdk.auth.c(cVar.g());
        f3878c = cVar2;
        if (cVar2 != null) {
            com.vk.api.sdk.auth.a b2 = cVar2.b();
            if (b2 != null) {
                e eVar = f3877b;
                if (eVar != null) {
                    eVar.a(b2.a(), b2.b());
                    return;
                } else {
                    kotlin.jvm.internal.f.d("apiManager");
                    throw null;
                }
            }
            return;
        }
        kotlin.jvm.internal.f.d("authManager");
        throw null;
    }

    public static final void b(@NotNull Context context) {
        kotlin.jvm.internal.f.b(context, "context");
        a(new c(context, a(context), new h(context), null, null, null, 0L, 0L, null, null, null, false, null, 0, null, null, null, 131064, null));
        if (d()) {
            f.e();
        }
    }

    public static final void a(@NotNull Activity activity, @NotNull Collection<? extends VKScope> collection) {
        kotlin.jvm.internal.f.b(activity, "activity");
        kotlin.jvm.internal.f.b(collection, "scopes");
        com.vk.api.sdk.auth.c cVar = f3878c;
        if (cVar != null) {
            cVar.a(activity, collection);
        } else {
            kotlin.jvm.internal.f.d("authManager");
            throw null;
        }
    }

    public static final boolean a(int i, int i2, @Nullable Intent intent, @NotNull com.vk.api.sdk.auth.b bVar) {
        kotlin.jvm.internal.f.b(bVar, "callback");
        com.vk.api.sdk.auth.c cVar = f3878c;
        if (cVar != null) {
            boolean a2 = cVar.a(i, i2, intent, bVar);
            if (a2 && d()) {
                f.e();
            }
            return a2;
        }
        kotlin.jvm.internal.f.d("authManager");
        throw null;
    }

    public static final void a(@NotNull n nVar) {
        kotlin.jvm.internal.f.b(nVar, "handler");
        f3879d.add(nVar);
    }

    public static final <T> T a(@NotNull com.vk.api.sdk.internal.a<T> aVar) throws InterruptedException, IOException, VKApiException {
        kotlin.jvm.internal.f.b(aVar, "cmd");
        e eVar = f3877b;
        if (eVar != null) {
            return aVar.a(eVar);
        }
        kotlin.jvm.internal.f.d("apiManager");
        throw null;
    }

    public static /* synthetic */ void a(com.vk.api.sdk.internal.a aVar, b bVar, int i, Object obj) {
        if ((i & 2) != 0) {
            bVar = null;
        }
        a(aVar, bVar);
    }

    public static final <T> void a(@NotNull com.vk.api.sdk.internal.a<T> aVar, @Nullable b<? super T> bVar) {
        kotlin.jvm.internal.f.b(aVar, "request");
        m.f3940d.a().submit(new RunnableC0097a(aVar, bVar));
    }

    public static final int a(@NotNull Context context) {
        int i;
        kotlin.jvm.internal.f.b(context, "context");
        int i2 = e;
        if (i2 != 0) {
            return i2;
        }
        try {
            i = context.getResources().getInteger(context.getResources().getIdentifier("com_vk_sdk_AppId", "integer", context.getPackageName()));
        } catch (Exception unused) {
            i = 0;
        }
        e = i;
        if (i != 0) {
            return i;
        }
        throw new RuntimeException("<integer name=\"com_vk_sdk_AppId\">your_app_id</integer> is not found in your resources.xml");
    }
}
