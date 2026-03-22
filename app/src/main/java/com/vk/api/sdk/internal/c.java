package com.vk.api.sdk.internal;

import com.facebook.internal.ServerProtocol;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: QueryStringGenerator.kt */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ j[] f3920a;

    /* renamed from: b, reason: collision with root package name */
    private static final com.vk.api.sdk.r.c f3921b;

    /* renamed from: c, reason: collision with root package name */
    public static final c f3922c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QueryStringGenerator.kt */
    /* loaded from: classes.dex */
    public static final class a extends Lambda implements l<Byte, String> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3923a = new a();

        a() {
            super(1);
        }

        @NotNull
        public final String a(byte b2) {
            kotlin.jvm.internal.j jVar = kotlin.jvm.internal.j.f8184a;
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b2)}, 1));
            f.a((Object) format, "java.lang.String.format(format, *args)");
            return format;
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ String invoke(Byte b2) {
            return a(b2.byteValue());
        }
    }

    /* compiled from: QueryStringGenerator.kt */
    /* loaded from: classes.dex */
    static final class b extends Lambda implements kotlin.jvm.b.a<StringBuilder> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f3924a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.b.a
        @NotNull
        public final StringBuilder invoke() {
            return new StringBuilder();
        }
    }

    static {
        PropertyReference1Impl propertyReference1Impl = new PropertyReference1Impl(h.a(c.class), "strBuilder", "getStrBuilder()Ljava/lang/StringBuilder;");
        h.a(propertyReference1Impl);
        f3920a = new j[]{propertyReference1Impl};
        f3922c = new c();
        f3921b = com.vk.api.sdk.r.e.a(b.f3924a);
    }

    private c() {
    }

    private final StringBuilder a() {
        return (StringBuilder) com.vk.api.sdk.r.e.a(f3921b, this, f3920a[0]);
    }

    @NotNull
    public final String a(@Nullable String str, @Nullable String str2, int i, @NotNull com.vk.api.sdk.p.d dVar) {
        f.b(dVar, "call");
        return a(str, str2, i, dVar.b(), dVar.d(), dVar.a());
    }

    @NotNull
    public final String a(@Nullable String str, @Nullable String str2, int i, @NotNull String str3, @NotNull String str4, @NotNull Map<String, String> map) {
        f.b(str3, "method");
        f.b(str4, ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
        f.b(map, "args");
        if (str2 == null || str2.length() == 0) {
            return a(str4, map, str, i, true);
        }
        String a2 = a("/method/" + str3 + '?' + a(str4, map, str, i, false) + str2);
        return a(str4, map, str, i, true) + "&sig=" + a2;
    }

    private final String a(String str, Map<String, String> map, String str2, int i, boolean z) {
        a(a());
        StringBuilder a2 = a();
        a(a2, "v=");
        a(a2, str);
        a(a2, "&https=1&");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if ((!f.a((Object) key, (Object) "v")) && (!f.a((Object) key, (Object) "access_token")) && (true ^ f.a((Object) key, (Object) "api_id"))) {
                a(a2, key);
                a(a2, "=");
                a(a2, a(value, z));
                a(a2, "&");
            }
        }
        if (!(str2 == null || str2.length() == 0)) {
            a(a2, "access_token=");
            a(a2, str2);
            a(a2, "&");
        } else if (i != 0) {
            a(a2, "api_id=");
            a(a2, String.valueOf(i));
            a(a2, "&");
        } else {
            a(a2, "&");
        }
        a2.setLength(a2.length() - 1);
        String sb = a2.toString();
        f.a((Object) sb, "sb.toString()");
        return sb;
    }

    private final String a(@NotNull String str, boolean z) {
        if (!z) {
            return str;
        }
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            f.a((Object) encode, "URLEncoder.encode(this, \"UTF-8\")");
            return encode;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private final StringBuilder a(@NotNull StringBuilder sb, String str) {
        f.b(sb, "$this$plus");
        sb.append(str);
        f.a((Object) sb, "this.append(str)");
        return sb;
    }

    private final void a(@NotNull StringBuilder sb) {
        sb.setLength(0);
    }

    private final String a(String str) {
        String a2;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        Charset charset = kotlin.text.c.f8213a;
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            f.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            byte[] digest = messageDigest.digest(bytes);
            f.a((Object) digest, "digested");
            a2 = kotlin.collections.f.a(digest, "", null, null, 0, null, a.f3923a, 30, null);
            return a2;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
