package com.tencent.stat;

import android.content.Context;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static com.tencent.stat.i.b f2850a = com.tencent.stat.i.m.b();

    /* renamed from: b, reason: collision with root package name */
    private static a f2851b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized a a(Context context) {
        synchronized (d.class) {
            try {
                f a2 = f.a(context);
                a a3 = a(a2.d("__MTA_DEVICE_INFO__", null));
                f2850a.a("get device info from internal storage:" + a3);
                a a4 = a(a2.f("__MTA_DEVICE_INFO__", null));
                f2850a.a("get device info from setting.system:" + a4);
                a a5 = a(a2.b("__MTA_DEVICE_INFO__", null));
                f2850a.a("get device info from SharedPreference:" + a5);
                a a6 = a(a5, a4, a3);
                f2851b = a6;
                if (a6 == null) {
                    f2851b = new a();
                }
                a a7 = t.b(context).a(context);
                if (a7 != null) {
                    f2851b.c(a7.d());
                    f2851b.d(a7.e());
                    f2851b.b(a7.g());
                }
            } finally {
                return f2851b;
            }
        }
        return f2851b;
    }

    static a a(a aVar, a aVar2) {
        if (aVar != null && aVar2 != null) {
            return aVar.a(aVar2) >= 0 ? aVar : aVar2;
        }
        if (aVar != null) {
            return aVar;
        }
        if (aVar2 != null) {
            return aVar2;
        }
        return null;
    }

    static a a(a aVar, a aVar2, a aVar3) {
        return a(a(aVar, aVar2), a(aVar2, aVar3));
    }

    private static a a(String str) {
        if (str != null) {
            return a.e(com.tencent.stat.i.m.d(str));
        }
        return null;
    }

    public static void a(Context context, String str) {
        try {
            b(context);
            f2851b.b(str);
            f2851b.a(f2851b.a() + 1);
            f2851b.a(System.currentTimeMillis());
            String jSONObject = f2851b.c().toString();
            f2850a.a("save DeviceInfo:" + jSONObject);
            String replace = com.tencent.stat.i.m.c(jSONObject).replace("\n", "");
            f a2 = f.a(context);
            a2.c("__MTA_DEVICE_INFO__", replace);
            a2.e("__MTA_DEVICE_INFO__", replace);
            a2.a("__MTA_DEVICE_INFO__", replace);
        } catch (Throwable th) {
            f2850a.c(th);
        }
    }

    public static a b(Context context) {
        if (context == null) {
            f2850a.d("Context for StatConfig.getDeviceInfo is null.");
            return null;
        }
        if (f2851b == null) {
            a(context);
        }
        return f2851b;
    }

    public static String c(Context context) {
        if (f2851b == null) {
            b(context);
        }
        return f2851b.f();
    }
}
