package com.vk.api.sdk.p;

import com.facebook.internal.ServerProtocol;
import com.vk.api.sdk.j;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OkHttpMethodCall.kt */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f3977a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f3978b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Map<String, String> f3979c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final e f3980d;

    /* compiled from: OkHttpMethodCall.kt */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private String f3981a = "";

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private String f3982b = "";

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        private Map<String, String> f3983c = new HashMap();

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private e f3984d;

        @NotNull
        public a a(@NotNull Map<String, String> map) {
            f.b(map, "args");
            this.f3983c.putAll(map);
            return this;
        }

        @NotNull
        public final Map<String, String> b() {
            return this.f3983c;
        }

        @NotNull
        public final String c() {
            return this.f3981a;
        }

        @Nullable
        public final e d() {
            return this.f3984d;
        }

        @NotNull
        public final String e() {
            return this.f3982b;
        }

        @NotNull
        public a a(@NotNull String str, @NotNull String str2) {
            f.b(str, "key");
            f.b(str2, "value");
            this.f3983c.put(str, str2);
            return this;
        }

        @NotNull
        public a b(@NotNull String str) {
            f.b(str, "method");
            this.f3981a = str;
            return this;
        }

        @NotNull
        public a c(@NotNull String str) {
            f.b(str, ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
            this.f3982b = str;
            return this;
        }

        @Nullable
        public final String a(@NotNull String str) {
            f.b(str, "key");
            return this.f3983c.get(str);
        }

        @NotNull
        public a a(@NotNull j jVar) {
            f.b(jVar, "call");
            b(jVar.b());
            c(jVar.e());
            a(jVar.a());
            return this;
        }

        @NotNull
        public d a() {
            return new d(this);
        }
    }

    protected d(@NotNull a aVar) {
        boolean a2;
        boolean a3;
        f.b(aVar, "b");
        a2 = u.a(aVar.c());
        if (!a2) {
            a3 = u.a(aVar.e());
            if (!a3) {
                this.f3977a = aVar.c();
                this.f3978b = aVar.e();
                this.f3979c = aVar.b();
                this.f3980d = aVar.d();
                return;
            }
            throw new IllegalArgumentException("version is null or empty");
        }
        throw new IllegalArgumentException("method is null or empty");
    }

    @NotNull
    public final Map<String, String> a() {
        return this.f3979c;
    }

    @NotNull
    public final String b() {
        return this.f3977a;
    }

    @Nullable
    public final e c() {
        return this.f3980d;
    }

    @NotNull
    public final String d() {
        return this.f3978b;
    }
}
