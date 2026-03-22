package com.vk.api.sdk.auth;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.k;
import kotlin.collections.r;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VKAuthParams.kt */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: d, reason: collision with root package name */
    public static final a f3892d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Set<VKScope> f3893a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3894b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f3895c;

    /* compiled from: VKAuthParams.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        @Nullable
        public final d a(@Nullable Bundle bundle) {
            Collection a2;
            int a3;
            if (bundle == null) {
                return null;
            }
            int i = bundle.getInt("vk_app_id");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("vk_app_scope");
            if (stringArrayList != null) {
                a3 = k.a(stringArrayList, 10);
                a2 = new ArrayList(a3);
                for (String str : stringArrayList) {
                    f.a((Object) str, LocaleUtil.ITALIAN);
                    a2.add(VKScope.valueOf(str));
                }
            } else {
                a2 = c0.a();
            }
            String string = bundle.getString("vk_app_redirect_url", "https://oauth.vk.com/blank.html");
            f.a((Object) string, "redirectUrl");
            return new d(i, string, a2);
        }

        public /* synthetic */ a(kotlin.jvm.internal.d dVar) {
            this();
        }
    }

    public d(int i, @NotNull String str, @NotNull Collection<? extends VKScope> collection) {
        f.b(str, "redirectUrl");
        f.b(collection, "scope");
        this.f3894b = i;
        this.f3895c = str;
        if (i != 0) {
            this.f3893a = new HashSet(collection);
            return;
        }
        throw new IllegalStateException("AppId is empty! Find out how to get your appId at https://vk.com/dev/access_token");
    }

    public final int a() {
        return this.f3894b;
    }

    @NotNull
    public final String b() {
        return this.f3895c;
    }

    @NotNull
    public final String c() {
        String a2;
        a2 = r.a(this.f3893a, ",", null, null, 0, null, null, 62, null);
        return a2;
    }

    @NotNull
    public final Bundle d() {
        int a2;
        Bundle bundle = new Bundle();
        bundle.putInt("vk_app_id", this.f3894b);
        Set<VKScope> set = this.f3893a;
        a2 = k.a(set, 10);
        ArrayList arrayList = new ArrayList(a2);
        Iterator<T> it2 = set.iterator();
        while (it2.hasNext()) {
            arrayList.add(((VKScope) it2.next()).name());
        }
        bundle.putStringArrayList("vk_app_scope", new ArrayList<>(arrayList));
        bundle.putString("vk_app_redirect_url", this.f3895c);
        return bundle;
    }

    @NotNull
    public final Bundle e() {
        String a2;
        Bundle bundle = new Bundle();
        bundle.putInt("client_id", this.f3894b);
        bundle.putBoolean("revoke", true);
        a2 = r.a(this.f3893a, ",", null, null, 0, null, null, 62, null);
        bundle.putString("scope", a2);
        bundle.putString("redirect_url", this.f3895c);
        return bundle;
    }

    public /* synthetic */ d(int i, String str, Collection collection, int i2, kotlin.jvm.internal.d dVar) {
        this(i, (i2 & 2) != 0 ? "https://oauth.vk.com/blank.html" : str, (i2 & 4) != 0 ? c0.a() : collection);
    }
}
