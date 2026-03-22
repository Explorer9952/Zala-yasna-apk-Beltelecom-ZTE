package com.vk.api.sdk;

import android.content.Context;
import com.facebook.internal.ServerProtocol;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants;
import com.vk.api.sdk.utils.log.Logger;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VKApiConfig.kt */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f3898a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3899b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final com.vk.api.sdk.g f3900c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.d<String> f3901d;

    @NotNull
    private final String e;

    @NotNull
    private final k f;
    private final long g;
    private final long h;

    @NotNull
    private final Logger i;

    @NotNull
    private final kotlin.d<String> j;

    @NotNull
    private final kotlin.d<String> k;
    private final boolean l;

    @NotNull
    private final kotlin.d<Boolean> m;
    private final int n;

    @NotNull
    private final kotlin.d<String> o;

    @NotNull
    private final String p;

    @NotNull
    private final i q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VKApiConfig.kt */
    /* loaded from: classes.dex */
    public static final class a extends Lambda implements kotlin.jvm.b.a<String> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3902a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.b.a
        @NotNull
        public final String invoke() {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VKApiConfig.kt */
    /* loaded from: classes.dex */
    public static final class b extends Lambda implements kotlin.jvm.b.a<Logger.LogLevel> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f3903a = new b();

        b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.b.a
        @NotNull
        public final Logger.LogLevel invoke() {
            return Logger.LogLevel.NONE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VKApiConfig.kt */
    /* renamed from: com.vk.api.sdk.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0100c extends Lambda implements kotlin.jvm.b.a<String> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0100c f3904a = new C0100c();

        C0100c() {
            super(0);
        }

        @Override // kotlin.jvm.b.a
        @NotNull
        public final String invoke() {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VKApiConfig.kt */
    /* loaded from: classes.dex */
    public static final class d extends Lambda implements kotlin.jvm.b.a {

        /* renamed from: a, reason: collision with root package name */
        public static final d f3905a = new d();

        d() {
            super(0);
        }

        @Override // kotlin.jvm.b.a
        @Nullable
        public final Void invoke() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VKApiConfig.kt */
    /* loaded from: classes.dex */
    public static final class e extends Lambda implements kotlin.jvm.b.a<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final e f3906a = new e();

        e() {
            super(0);
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VKApiConfig.kt */
    /* loaded from: classes.dex */
    public static final class f extends Lambda implements kotlin.jvm.b.a<String> {

        /* renamed from: a, reason: collision with root package name */
        public static final f f3907a = new f();

        f() {
            super(0);
        }

        @Override // kotlin.jvm.b.a
        @NotNull
        public final String invoke() {
            return "api.vk.com";
        }
    }

    /* compiled from: VKApiConfig.kt */
    /* loaded from: classes.dex */
    public static final class g {
        private g() {
        }

        public /* synthetic */ g(kotlin.jvm.internal.d dVar) {
            this();
        }
    }

    static {
        new g(null);
    }

    public c(@NotNull Context context, int i, @Nullable com.vk.api.sdk.g gVar, @NotNull kotlin.d<String> dVar, @NotNull String str, @NotNull k kVar, long j, long j2, @NotNull Logger logger, @NotNull kotlin.d<String> dVar2, @NotNull kotlin.d<String> dVar3, boolean z, @NotNull kotlin.d<Boolean> dVar4, int i2, @NotNull kotlin.d<String> dVar5, @NotNull String str2, @NotNull i iVar) {
        kotlin.jvm.internal.f.b(context, "context");
        kotlin.jvm.internal.f.b(dVar, "deviceId");
        kotlin.jvm.internal.f.b(str, ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
        kotlin.jvm.internal.f.b(kVar, "okHttpProvider");
        kotlin.jvm.internal.f.b(logger, "logger");
        kotlin.jvm.internal.f.b(dVar2, MMPluginProviderConstants.OAuth.ACCESS_TOKEN);
        kotlin.jvm.internal.f.b(dVar3, MMPluginProviderConstants.OAuth.SECRET);
        kotlin.jvm.internal.f.b(dVar4, "debugCycleCalls");
        kotlin.jvm.internal.f.b(dVar5, "httpApiHost");
        kotlin.jvm.internal.f.b(str2, "lang");
        kotlin.jvm.internal.f.b(iVar, "keyValueStorage");
        this.f3898a = context;
        this.f3899b = i;
        this.f3900c = gVar;
        this.f3901d = dVar;
        this.e = str;
        this.f = kVar;
        this.g = j;
        this.h = j2;
        this.i = logger;
        this.j = dVar2;
        this.k = dVar3;
        this.l = z;
        this.m = dVar4;
        this.n = i2;
        this.o = dVar5;
        this.p = str2;
        this.q = iVar;
    }

    @NotNull
    public final kotlin.d<String> a() {
        return this.j;
    }

    public final int b() {
        return this.f3899b;
    }

    @NotNull
    public final Context c() {
        return this.f3898a;
    }

    public final long d() {
        return this.g;
    }

    @NotNull
    public final kotlin.d<String> e() {
        return this.f3901d;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return kotlin.jvm.internal.f.a(this.f3898a, cVar.f3898a) && this.f3899b == cVar.f3899b && kotlin.jvm.internal.f.a(this.f3900c, cVar.f3900c) && kotlin.jvm.internal.f.a(this.f3901d, cVar.f3901d) && kotlin.jvm.internal.f.a((Object) this.e, (Object) cVar.e) && kotlin.jvm.internal.f.a(this.f, cVar.f) && this.g == cVar.g && this.h == cVar.h && kotlin.jvm.internal.f.a(this.i, cVar.i) && kotlin.jvm.internal.f.a(this.j, cVar.j) && kotlin.jvm.internal.f.a(this.k, cVar.k) && this.l == cVar.l && kotlin.jvm.internal.f.a(this.m, cVar.m) && this.n == cVar.n && kotlin.jvm.internal.f.a(this.o, cVar.o) && kotlin.jvm.internal.f.a((Object) this.p, (Object) cVar.p) && kotlin.jvm.internal.f.a(this.q, cVar.q);
    }

    @NotNull
    public final kotlin.d<String> f() {
        return this.o;
    }

    @NotNull
    public final i g() {
        return this.q;
    }

    @NotNull
    public final String h() {
        return this.p;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Context context = this.f3898a;
        int hashCode = (((context != null ? context.hashCode() : 0) * 31) + this.f3899b) * 31;
        com.vk.api.sdk.g gVar = this.f3900c;
        int hashCode2 = (hashCode + (gVar != null ? gVar.hashCode() : 0)) * 31;
        kotlin.d<String> dVar = this.f3901d;
        int hashCode3 = (hashCode2 + (dVar != null ? dVar.hashCode() : 0)) * 31;
        String str = this.e;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        k kVar = this.f;
        int hashCode5 = (hashCode4 + (kVar != null ? kVar.hashCode() : 0)) * 31;
        long j = this.g;
        int i = (hashCode5 + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.h;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        Logger logger = this.i;
        int hashCode6 = (i2 + (logger != null ? logger.hashCode() : 0)) * 31;
        kotlin.d<String> dVar2 = this.j;
        int hashCode7 = (hashCode6 + (dVar2 != null ? dVar2.hashCode() : 0)) * 31;
        kotlin.d<String> dVar3 = this.k;
        int hashCode8 = (hashCode7 + (dVar3 != null ? dVar3.hashCode() : 0)) * 31;
        boolean z = this.l;
        int i3 = z;
        if (z != 0) {
            i3 = 1;
        }
        int i4 = (hashCode8 + i3) * 31;
        kotlin.d<Boolean> dVar4 = this.m;
        int hashCode9 = (((i4 + (dVar4 != null ? dVar4.hashCode() : 0)) * 31) + this.n) * 31;
        kotlin.d<String> dVar5 = this.o;
        int hashCode10 = (hashCode9 + (dVar5 != null ? dVar5.hashCode() : 0)) * 31;
        String str2 = this.p;
        int hashCode11 = (hashCode10 + (str2 != null ? str2.hashCode() : 0)) * 31;
        i iVar = this.q;
        return hashCode11 + (iVar != null ? iVar.hashCode() : 0);
    }

    public final boolean i() {
        return this.l;
    }

    @NotNull
    public final Logger j() {
        return this.i;
    }

    @NotNull
    public final k k() {
        return this.f;
    }

    @NotNull
    public final kotlin.d<String> l() {
        return this.k;
    }

    @Nullable
    public final com.vk.api.sdk.g m() {
        return this.f3900c;
    }

    @NotNull
    public final String n() {
        return this.e;
    }

    @NotNull
    public String toString() {
        return "VKApiConfig(context=" + this.f3898a + ", appId=" + this.f3899b + ", validationHandler=" + this.f3900c + ", deviceId=" + this.f3901d + ", version=" + this.e + ", okHttpProvider=" + this.f + ", defaultTimeoutMs=" + this.g + ", postRequestsTimeout=" + this.h + ", logger=" + this.i + ", accessToken=" + this.j + ", secret=" + this.k + ", logFilterCredentials=" + this.l + ", debugCycleCalls=" + this.m + ", callsPerSecondLimit=" + this.n + ", httpApiHost=" + this.o + ", lang=" + this.p + ", keyValueStorage=" + this.q + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ c(android.content.Context r23, int r24, com.vk.api.sdk.g r25, kotlin.d r26, java.lang.String r27, com.vk.api.sdk.k r28, long r29, long r31, com.vk.api.sdk.utils.log.Logger r33, kotlin.d r34, kotlin.d r35, boolean r36, kotlin.d r37, int r38, kotlin.d r39, java.lang.String r40, com.vk.api.sdk.i r41, int r42, kotlin.jvm.internal.d r43) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vk.api.sdk.c.<init>(android.content.Context, int, com.vk.api.sdk.g, kotlin.d, java.lang.String, com.vk.api.sdk.k, long, long, com.vk.api.sdk.utils.log.Logger, kotlin.d, kotlin.d, boolean, kotlin.d, int, kotlin.d, java.lang.String, com.vk.api.sdk.i, int, kotlin.jvm.internal.d):void");
    }
}
