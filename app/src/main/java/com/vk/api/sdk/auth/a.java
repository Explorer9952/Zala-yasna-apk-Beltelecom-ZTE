package com.vk.api.sdk.auth;

import com.facebook.AccessToken;
import com.facebook.internal.NativeProtocol;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants;
import com.vk.api.sdk.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.j;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VKAccessToken.kt */
/* loaded from: classes.dex */
public final class a {

    @NotNull
    private static final List<String> j;
    public static final C0099a k = new C0099a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f3886a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f3887b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final String f3888c;

    /* renamed from: d, reason: collision with root package name */
    private final long f3889d;

    @Nullable
    private final String e;

    @Nullable
    private final String f;

    @Nullable
    private final String g;
    private final boolean h;
    private final long i;

    /* compiled from: VKAccessToken.kt */
    /* renamed from: com.vk.api.sdk.auth.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0099a {
        private C0099a() {
        }

        @NotNull
        public final List<String> a() {
            return a.j;
        }

        @Nullable
        public final a b(@NotNull i iVar) {
            f.b(iVar, "keyValueStorage");
            HashMap hashMap = new HashMap(a().size());
            for (String str : a()) {
                String a2 = iVar.a(str);
                if (a2 != null) {
                    hashMap.put(str, a2);
                }
            }
            if (hashMap.containsKey("access_token") && hashMap.containsKey(AccessToken.USER_ID_KEY)) {
                return new a(hashMap);
            }
            return null;
        }

        public /* synthetic */ C0099a(kotlin.jvm.internal.d dVar) {
            this();
        }

        public final void a(@NotNull i iVar) {
            f.b(iVar, "keyValueStorage");
            Iterator<T> it2 = a().iterator();
            while (it2.hasNext()) {
                iVar.remove((String) it2.next());
            }
        }
    }

    static {
        List<String> a2;
        a2 = j.a((Object[]) new String[]{"access_token", "expires_in", AccessToken.USER_ID_KEY, MMPluginProviderConstants.OAuth.SECRET, "https_required", "created", "vk_access_token", "email", "phone", "phone_access_key"});
        j = a2;
    }

    public a(@NotNull Map<String, String> map) {
        long currentTimeMillis;
        long j2;
        f.b(map, NativeProtocol.WEB_DIALOG_PARAMS);
        String str = map.get(AccessToken.USER_ID_KEY);
        Integer valueOf = str != null ? Integer.valueOf(Integer.parseInt(str)) : null;
        if (valueOf != null) {
            this.f3886a = valueOf.intValue();
            String str2 = map.get("access_token");
            if (str2 != null) {
                this.f3887b = str2;
                this.f3888c = map.get(MMPluginProviderConstants.OAuth.SECRET);
                this.h = f.a((Object) "1", (Object) map.get("https_required"));
                if (map.containsKey("created")) {
                    String str3 = map.get("created");
                    if (str3 == null) {
                        f.a();
                        throw null;
                    }
                    currentTimeMillis = Long.parseLong(str3);
                } else {
                    currentTimeMillis = System.currentTimeMillis();
                }
                this.f3889d = currentTimeMillis;
                if (map.containsKey("expires_in")) {
                    String str4 = map.get("expires_in");
                    if (str4 == null) {
                        f.a();
                        throw null;
                    }
                    j2 = Long.parseLong(str4);
                } else {
                    j2 = -1;
                }
                this.i = j2;
                this.e = map.containsKey("email") ? map.get("email") : null;
                this.f = map.containsKey("phone") ? map.get("phone") : null;
                this.g = map.containsKey("phone_access_key") ? map.get("phone_access_key") : null;
                return;
            }
            f.a();
            throw null;
        }
        f.a();
        throw null;
    }

    private final Map<String, String> e() {
        HashMap hashMap = new HashMap();
        hashMap.put("access_token", this.f3887b);
        hashMap.put(MMPluginProviderConstants.OAuth.SECRET, this.f3888c);
        hashMap.put("https_required", this.h ? "1" : "0");
        hashMap.put("created", String.valueOf(this.f3889d));
        hashMap.put("expires_in", String.valueOf(this.i));
        hashMap.put(AccessToken.USER_ID_KEY, String.valueOf(this.f3886a));
        hashMap.put("email", this.e);
        hashMap.put("phone", this.f);
        hashMap.put("phone_access_key", this.g);
        return hashMap;
    }

    @NotNull
    public final String a() {
        return this.f3887b;
    }

    @Nullable
    public final String b() {
        return this.f3888c;
    }

    public final boolean c() {
        long j2 = this.i;
        return j2 <= 0 || this.f3889d + (j2 * ((long) 1000)) > System.currentTimeMillis();
    }

    public final void a(@NotNull i iVar) {
        f.b(iVar, "storage");
        for (Map.Entry<String, String> entry : e().entrySet()) {
            iVar.b(entry.getKey(), entry.getValue());
        }
    }
}
