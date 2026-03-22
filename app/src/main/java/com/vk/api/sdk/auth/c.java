package com.vk.api.sdk.auth;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.vk.api.sdk.i;
import com.vk.api.sdk.r.g;
import com.vk.api.sdk.ui.VKWebViewAuthActivity;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VKAuthManager.kt */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final i f3891a;

    /* compiled from: VKAuthManager.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.d dVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    public c(@NotNull i iVar) {
        f.b(iVar, "keyValueStorage");
        this.f3891a = iVar;
    }

    private final void b(Activity activity, d dVar) {
        VKWebViewAuthActivity.e.a(activity, dVar, 282);
    }

    public final void a(@NotNull Activity activity, @NotNull Collection<? extends VKScope> collection) {
        f.b(activity, "activity");
        f.b(collection, "scopes");
        d dVar = new d(com.vk.api.sdk.a.a(activity), null, collection, 2, null);
        if (g.a(activity, "com.vkontakte.android") && g.b(activity, "com.vkontakte.android.action.SDK_AUTH")) {
            a(activity, dVar);
        } else {
            b(activity, dVar);
        }
    }

    public final boolean c() {
        com.vk.api.sdk.auth.a b2 = b();
        return b2 != null && b2.c();
    }

    @Nullable
    public final com.vk.api.sdk.auth.a b() {
        return com.vk.api.sdk.auth.a.k.b(this.f3891a);
    }

    private final void a(Activity activity, d dVar) {
        Intent intent = new Intent("com.vkontakte.android.action.SDK_AUTH", (Uri) null);
        intent.setPackage("com.vkontakte.android");
        intent.putExtras(dVar.e());
        activity.startActivityForResult(intent, 282);
    }

    public final boolean a(int i, int i2, @Nullable Intent intent, @NotNull b bVar) {
        f.b(bVar, "callback");
        if (i != 282) {
            return false;
        }
        if (intent == null) {
            bVar.a(1);
            return true;
        }
        e a2 = a(intent);
        if (i2 == -1 && a2 != null && !a2.b()) {
            com.vk.api.sdk.auth.a a3 = a2.a();
            if (a3 != null) {
                a3.a(this.f3891a);
                com.vk.api.sdk.a.f.a().a(a2.a().a(), a2.a().b());
                bVar.a(a2.a());
            } else {
                f.a();
                throw null;
            }
        } else {
            bVar.a(1);
        }
        return true;
    }

    private final e a(Intent intent) {
        Map<String, String> map;
        if (intent.hasExtra("extra-token-data")) {
            map = g.a(intent.getStringExtra("extra-token-data"));
        } else {
            if (intent.getExtras() == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Bundle extras = intent.getExtras();
            if (extras == null) {
                f.a();
                throw null;
            }
            for (String str : extras.keySet()) {
                f.a((Object) str, "key");
                Bundle extras2 = intent.getExtras();
                if (extras2 == null) {
                    f.a();
                    throw null;
                }
                hashMap.put(str, String.valueOf(extras2.get(str)));
            }
            map = hashMap;
        }
        if (map == null || map.get("error") != null) {
            return null;
        }
        try {
            return new e(new com.vk.api.sdk.auth.a(map), 0, 2, null);
        } catch (Exception e) {
            Log.e(c.class.getSimpleName(), "Failed to get VK token", e);
            return null;
        }
    }

    public final void a() {
        com.vk.api.sdk.auth.a.k.a(this.f3891a);
    }
}
