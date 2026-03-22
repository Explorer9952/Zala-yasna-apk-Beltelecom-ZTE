package com.vk.api.sdk;

import com.facebook.internal.ServerProtocol;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VKMethodCall.kt */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f3927a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f3928b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Map<String, String> f3929c;

    /* renamed from: d, reason: collision with root package name */
    private final int f3930d;
    private final boolean e;

    /* compiled from: VKMethodCall.kt */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private String f3931a = "";

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private String f3932b = "";

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        private Map<String, String> f3933c = new LinkedHashMap();

        /* renamed from: d, reason: collision with root package name */
        private int f3934d = 4;
        private boolean e;

        @NotNull
        public a a(@NotNull String str) {
            kotlin.jvm.internal.f.b(str, "method");
            this.f3931a = str;
            return this;
        }

        @NotNull
        public final Map<String, String> b() {
            return this.f3933c;
        }

        @NotNull
        public final String c() {
            return this.f3931a;
        }

        public final int d() {
            return this.f3934d;
        }

        public final boolean e() {
            return this.e;
        }

        @NotNull
        public final String f() {
            return this.f3932b;
        }

        @NotNull
        public a a(@NotNull Map<String, String> map) {
            kotlin.jvm.internal.f.b(map, "args");
            this.f3933c.putAll(map);
            return this;
        }

        @NotNull
        public a b(@NotNull String str) {
            kotlin.jvm.internal.f.b(str, ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
            this.f3932b = str;
            return this;
        }

        @NotNull
        public a a(@NotNull String str, @NotNull String str2) {
            kotlin.jvm.internal.f.b(str, "key");
            kotlin.jvm.internal.f.b(str2, "value");
            this.f3933c.put(str, str2);
            return this;
        }

        @NotNull
        public a a(@NotNull String str, @NotNull Object obj) {
            kotlin.jvm.internal.f.b(str, "key");
            kotlin.jvm.internal.f.b(obj, "value");
            this.f3933c.put(str, obj.toString());
            return this;
        }

        @NotNull
        public j a() {
            return new j(this);
        }
    }

    /* compiled from: VKMethodCall.kt */
    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.d dVar) {
            this();
        }
    }

    static {
        new b(null);
    }

    protected j(@NotNull a aVar) {
        boolean a2;
        boolean a3;
        kotlin.jvm.internal.f.b(aVar, "b");
        a2 = u.a(aVar.c());
        if (!a2) {
            a3 = u.a(aVar.f());
            if (!a3) {
                this.f3927a = aVar.c();
                this.f3928b = aVar.f();
                this.f3929c = aVar.b();
                this.f3930d = aVar.d();
                this.e = aVar.e();
                return;
            }
            throw new IllegalArgumentException("version is null or empty");
        }
        throw new IllegalArgumentException("method is null or empty");
    }

    @NotNull
    public final Map<String, String> a() {
        return this.f3929c;
    }

    @NotNull
    public final String b() {
        return this.f3927a;
    }

    public final int c() {
        return this.f3930d;
    }

    public final boolean d() {
        return this.e;
    }

    @NotNull
    public final String e() {
        return this.f3928b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!kotlin.jvm.internal.f.a(j.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            j jVar = (j) obj;
            return ((kotlin.jvm.internal.f.a((Object) this.f3927a, (Object) jVar.f3927a) ^ true) || (kotlin.jvm.internal.f.a(this.f3929c, jVar.f3929c) ^ true)) ? false : true;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.vk.api.sdk.VKMethodCall");
    }

    public int hashCode() {
        return (this.f3927a.hashCode() * 31) + this.f3929c.hashCode();
    }

    @NotNull
    public String toString() {
        return "VKMethodCall(method='" + this.f3927a + "', args=" + this.f3929c + ')';
    }
}
