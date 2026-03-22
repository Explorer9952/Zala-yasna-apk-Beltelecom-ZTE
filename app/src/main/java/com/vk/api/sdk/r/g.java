package com.vk.api.sdk.r;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.r;
import kotlin.text.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VKUtils.kt */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f3995a = new g();

    private g() {
    }

    public static final boolean a(@NotNull Context context, @NotNull String str) {
        kotlin.jvm.internal.f.b(context, "context");
        kotlin.jvm.internal.f.b(str, "packageName");
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static final boolean b(@NotNull Context context, @NotNull String str) {
        List<ResolveInfo> queryIntentActivities;
        boolean a2;
        kotlin.jvm.internal.f.b(context, "context");
        kotlin.jvm.internal.f.b(str, "action");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null || (queryIntentActivities = packageManager.queryIntentActivities(new Intent(str), 65536)) == null) {
            return false;
        }
        a2 = r.a((Iterable) queryIntentActivities);
        return a2;
    }

    @Nullable
    public static final Map<String, String> a(@Nullable String str) {
        List a2;
        List a3;
        if (str == null) {
            return null;
        }
        a2 = v.a((CharSequence) str, new String[]{"&"}, false, 0, 6, (Object) null);
        HashMap hashMap = new HashMap(a2.size());
        Iterator it2 = a2.iterator();
        while (it2.hasNext()) {
            a3 = v.a((CharSequence) it2.next(), new String[]{"="}, false, 0, 6, (Object) null);
            if (a3.size() > 1) {
                hashMap.put(a3.get(0), a3.get(1));
            }
        }
        return hashMap;
    }

    @NotNull
    public final DisplayMetrics b() {
        Resources system = Resources.getSystem();
        kotlin.jvm.internal.f.a((Object) system, "Resources.getSystem()");
        DisplayMetrics displayMetrics = system.getDisplayMetrics();
        kotlin.jvm.internal.f.a((Object) displayMetrics, "Resources.getSystem().displayMetrics");
        return displayMetrics;
    }

    public final int a(int i) {
        return (int) Math.ceil(i * a());
    }

    public final float a() {
        return b().density;
    }
}
