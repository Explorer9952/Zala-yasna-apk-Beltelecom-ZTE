package com.vk.api.sdk.p;

import android.net.Uri;
import android.os.Looper;
import com.google.vr.cardboard.TransitionView;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants;
import com.vk.api.sdk.exceptions.VKApiException;
import com.vk.api.sdk.exceptions.VKApiExecutionException;
import com.vk.api.sdk.exceptions.VKInternalServerErrorException;
import com.vk.api.sdk.exceptions.VKLargeEntityException;
import com.vk.api.sdk.k;
import com.vk.api.sdk.utils.log.Logger;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import okhttp3.a0;
import okhttp3.u;
import okhttp3.v;
import okhttp3.x;
import okhttp3.y;
import okhttp3.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OkHttpExecutor.kt */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f3970a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f3971b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.d f3972c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final String f3973d;

    @NotNull
    private volatile String e;

    @Nullable
    private volatile String f;
    private final b.b.d<v> g;

    @NotNull
    private final com.vk.api.sdk.p.c h;

    /* compiled from: OkHttpExecutor.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.d dVar) {
            this();
        }
    }

    /* compiled from: OkHttpExecutor.kt */
    /* renamed from: com.vk.api.sdk.p.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0103b extends Lambda implements kotlin.jvm.b.a<k> {
        C0103b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.b.a
        @NotNull
        public final k invoke() {
            if (!f.a(Looper.getMainLooper(), Looper.myLooper())) {
                b bVar = b.this;
                bVar.a(bVar.a().h());
                return b.this.a().h();
            }
            throw new IllegalStateException("UI thread");
        }
    }

    /* compiled from: OkHttpExecutor.kt */
    /* loaded from: classes.dex */
    public static final class c implements k.a {
        c() {
        }

        @Override // com.vk.api.sdk.k.a
        @NotNull
        public v.b a(@NotNull v.b bVar) {
            f.b(bVar, "builder");
            if (Logger.LogLevel.NONE != b.this.a().g().a().getValue()) {
                bVar.a(new com.vk.api.sdk.p.a(b.this.a().f(), b.this.a().g()));
            }
            return bVar;
        }
    }

    static {
        new a(null);
    }

    public b(@NotNull com.vk.api.sdk.p.c cVar) {
        kotlin.d a2;
        f.b(cVar, "config");
        this.h = cVar;
        this.f3970a = TransitionView.TRANSITION_ANIMATION_DURATION_MS;
        cVar.c();
        this.f3971b = new Object();
        a2 = kotlin.f.a(new C0103b());
        this.f3972c = a2;
        this.f3973d = this.h.e();
        this.e = this.h.a();
        this.f = this.h.i();
        this.g = new b.b.d<>();
    }

    private final k d() {
        return (k) this.f3972c.getValue();
    }

    @Nullable
    protected String b(@NotNull d dVar) {
        f.b(dVar, "call");
        return this.e;
    }

    @Nullable
    protected String c(@NotNull d dVar) {
        f.b(dVar, "call");
        return this.f;
    }

    private final v b(long j) {
        v.b s = d().a().s();
        s.b(j, TimeUnit.MILLISECONDS);
        s.a(j, TimeUnit.MILLISECONDS);
        v a2 = s.a();
        b.b.d<v> dVar = this.g;
        f.a((Object) a2, "client");
        com.vk.api.sdk.r.a.a(dVar, j, a2);
        return a2;
    }

    private final v c() {
        long d2 = this.h.d();
        v c2 = c(d2);
        return c2 != null ? c2 : b(d2);
    }

    @NotNull
    protected final com.vk.api.sdk.p.c a() {
        return this.h;
    }

    public final void a(@NotNull String str, @Nullable String str2) {
        f.b(str, MMPluginProviderConstants.OAuth.ACCESS_TOKEN);
        com.vk.api.sdk.internal.e.f3926a.a(str);
        this.e = str;
        this.f = str2;
    }

    private final v c(long j) {
        return this.g.a(j);
    }

    @Nullable
    public String a(@NotNull d dVar) throws InterruptedException, IOException, VKApiException {
        f.b(dVar, "call");
        String a2 = com.vk.api.sdk.internal.c.f3922c.a(b(dVar), c(dVar), this.h.b(), dVar);
        u b2 = u.b("application/x-www-form-urlencoded; charset=utf-8");
        a(dVar, a2);
        y a3 = y.a(b2, a2);
        x.a aVar = new x.a();
        aVar.a(a3);
        aVar.b("https://" + this.f3973d + "/method/" + dVar.b());
        aVar.a(okhttp3.d.n);
        e c2 = dVar.c();
        if (c2 == null) {
            aVar.a((Class<? super Class>) Map.class, (Class) null);
            x a4 = aVar.a();
            f.a((Object) a4, "request");
            return a(a(a4));
        }
        c2.a();
        throw null;
    }

    private final void b() {
        this.g.a();
    }

    @NotNull
    protected final String a(@NotNull d dVar, @NotNull String str) throws VKApiException {
        boolean a2;
        f.b(dVar, "call");
        f.b(str, "paramsString");
        a2 = kotlin.text.u.a(dVar.b(), "execute.", false, 2, null);
        if (a2) {
            Uri parse = Uri.parse("https://vk.com/?" + str);
            if (parse.getQueryParameters("method").contains("execute")) {
                List<String> queryParameters = parse.getQueryParameters("code");
                if (!(queryParameters == null || queryParameters.isEmpty())) {
                    throw new VKApiExecutionException(15, dVar.b(), false, "Hey dude don't execute your hacky code ;)", null, null, null, 112, null);
                }
            }
        }
        return str;
    }

    @NotNull
    protected final z a(@NotNull x xVar) {
        f.b(xVar, "request");
        return a(xVar, this.h.d());
    }

    @NotNull
    protected final z a(@NotNull x xVar, long j) throws InterruptedException, IOException {
        f.b(xVar, "request");
        z g = a(j).a(xVar).g();
        f.a((Object) g, "clientWithTimeOut(timeou…ewCall(request).execute()");
        return g;
    }

    @Nullable
    protected final String a(@NotNull z zVar) {
        f.b(zVar, "response");
        if (zVar.l() != 413) {
            a0 g = zVar.g();
            String str = null;
            if (g != null) {
                try {
                    String n = g.n();
                    kotlin.io.a.a(g, null);
                    str = n;
                } finally {
                }
            }
            int l = zVar.l();
            if (500 > l || 599 < l) {
                return str;
            }
            int l2 = zVar.l();
            if (str == null) {
                str = "null";
            }
            throw new VKInternalServerErrorException(l2, str);
        }
        String o = zVar.o();
        f.a((Object) o, "response.message()");
        throw new VKLargeEntityException(o);
    }

    private final v a(long j) {
        v c2;
        synchronized (this.f3971b) {
            if (!a(d().a(), c())) {
                b();
            }
            long j2 = j + this.f3970a;
            c2 = c(j2);
            if (c2 == null) {
                c2 = b(j2);
            }
        }
        return c2;
    }

    private final boolean a(v vVar, v vVar2) {
        return vVar.e() == vVar2.e() && vVar.y() == vVar2.y() && vVar.C() == vVar2.C() && vVar.t() == vVar2.t() && f.a(vVar.v(), vVar2.v()) && f.a(vVar.x(), vVar2.x()) && f.a(vVar.i(), vVar2.i()) && f.a(vVar.b(), vVar2.b()) && f.a(vVar.k(), vVar2.k()) && f.a(vVar.A(), vVar2.A()) && f.a(vVar.B(), vVar2.B()) && f.a(vVar.B(), vVar2.B()) && f.a(vVar.o(), vVar2.o()) && f.a(vVar.d(), vVar2.d()) && f.a(vVar.a(), vVar2.a()) && f.a(vVar.w(), vVar2.w()) && f.a(vVar.f(), vVar2.f()) && vVar.n() == vVar2.n() && vVar.m() == vVar2.m() && vVar.z() == vVar2.z() && f.a(vVar.j(), vVar2.j()) && f.a(vVar.u(), vVar2.u()) && f.a(vVar.h(), vVar2.h()) && f.a(vVar.p(), vVar2.p()) && f.a(vVar.r(), vVar2.r());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(k kVar) {
        kVar.a(new c());
    }
}
