package com.tencent.stat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import java.lang.Thread;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static Handler f2855a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile long f2856b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile long f2857c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile int f2858d;
    private static volatile String e;
    private static volatile String f;
    private static Map<String, Long> g;
    private static com.tencent.stat.i.b h;
    private static Thread.UncaughtExceptionHandler i;
    private static volatile boolean j;

    static {
        new ConcurrentHashMap();
        f2856b = 0L;
        f2857c = 0L;
        f2858d = 0;
        e = "";
        f = "";
        g = new ConcurrentHashMap();
        h = com.tencent.stat.i.m.b();
        i = null;
        j = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Context context, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = z && currentTimeMillis - f2856b >= ((long) c.o());
        f2856b = currentTimeMillis;
        if (f2857c == 0) {
            f2857c = com.tencent.stat.i.m.c();
        }
        if (currentTimeMillis >= f2857c) {
            f2857c = com.tencent.stat.i.m.c();
            if (t.b(context).a(context).g() != 1) {
                t.b(context).a(context).b(1);
            }
            c.b(0);
            d.a(context);
            z2 = true;
        }
        if (j ? true : z2) {
            if (c.e() < c.h()) {
                com.tencent.stat.i.m.f(context);
                d(context);
            } else {
                h.c("Exceed StatConfig.getMaxDaySessionNumbers().");
            }
        }
        if (j) {
            com.tencent.stat.i.h.b(context);
            h(context);
            e(context);
            j = false;
        }
        return f2858d;
    }

    static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (c.f2848c.f2866d != 0) {
                jSONObject2.put("v", c.f2848c.f2866d);
            }
            jSONObject.put(Integer.toString(c.f2848c.f2863a), jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            if (c.f2847b.f2866d != 0) {
                jSONObject3.put("v", c.f2847b.f2866d);
            }
            jSONObject.put(Integer.toString(c.f2847b.f2863a), jSONObject3);
        } catch (JSONException e2) {
            h.a((Exception) e2);
        }
        return jSONObject;
    }

    static synchronized void a(Context context) {
        synchronized (e.class) {
            if (context == null) {
                return;
            }
            if (f2855a == null) {
                if (!b(context)) {
                    return;
                }
                if (!com.tencent.stat.i.h.a(context)) {
                    h.c("ooh, Compatibility problem was found in this device!");
                    h.c("If you are on debug mode, please delete apk and try again.");
                    c.a(false);
                    return;
                }
                HandlerThread handlerThread = new HandlerThread("StatService");
                handlerThread.start();
                f2855a = new Handler(handlerThread.getLooper());
                t.b(context);
                j.a(context);
                j.b();
                c.c(context);
                i = Thread.getDefaultUncaughtExceptionHandler();
                if (c.r()) {
                    Thread.setDefaultUncaughtExceptionHandler(new m(context.getApplicationContext()));
                } else {
                    h.h("MTA SDK AutoExceptionCaught is disable");
                }
                if (c.q() == StatReportStrategy.APP_LAUNCH && com.tencent.stat.i.m.o(context)) {
                    t.b(context).a(-1);
                }
                h.a("Init MTA StatService success.");
            }
        }
    }

    public static void a(Context context, String str) {
        if (c.u()) {
            if (context == null || str == null || str.length() == 0) {
                h.d("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
                return;
            }
            try {
                synchronized (g) {
                    if (g.size() >= c.i()) {
                        h.d("The number of page events exceeds the maximum value " + Integer.toString(c.i()));
                        return;
                    }
                    e = str;
                    if (!g.containsKey(e)) {
                        g.put(e, Long.valueOf(System.currentTimeMillis()));
                        a(context, true);
                        return;
                    }
                    h.c("Duplicate PageID : " + e + ", onResume() repeated?");
                }
            } catch (Throwable th) {
                h.c(th);
                a(context, th);
            }
        }
    }

    static void a(Context context, Throwable th) {
        try {
            if (c.u()) {
                if (context == null) {
                    h.d("The Context of StatService.reportSdkSelfException() can not be null!");
                    return;
                }
                com.tencent.stat.a.a aVar = new com.tencent.stat.a.a(context, a(context, false), 99, th);
                if (c(context) != null) {
                    c(context).post(new q(aVar));
                }
            }
        } catch (Throwable th2) {
            h.c("reportSdkSelfException error: " + th2);
        }
    }

    public static void b(Context context, String str) {
        Long remove;
        if (c.u()) {
            if (context == null || str == null || str.length() == 0) {
                h.d("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
                return;
            }
            try {
                synchronized (g) {
                    remove = g.remove(str);
                }
                if (remove == null) {
                    h.c("Starttime for PageID:" + str + " not found, lost onResume()?");
                    return;
                }
                Long valueOf = Long.valueOf((System.currentTimeMillis() - remove.longValue()) / 1000);
                if (valueOf.longValue() <= 0) {
                    valueOf = 1L;
                }
                Long l = valueOf;
                String str2 = f;
                if (str2 != null && str2.equals(str)) {
                    str2 = "-";
                }
                String str3 = str2;
                if (c(context) != null) {
                    com.tencent.stat.a.d dVar = new com.tencent.stat.a.d(context, str3, str, a(context, false), l);
                    if (!str.equals(e)) {
                        h.h("Invalid invocation since previous onResume on diff page.");
                    }
                    c(context).post(new q(dVar));
                }
                f = str;
            } catch (Throwable th) {
                h.c(th);
                a(context, th);
            }
        }
    }

    static boolean b(Context context) {
        if (com.tencent.stat.i.m.b("1.6.2") > com.tencent.stat.i.q.a(context, c.k, 0L)) {
            return true;
        }
        c.a(false);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Handler c(Context context) {
        if (f2855a == null) {
            a(context);
        }
        return f2855a;
    }

    static void d(Context context) {
        if (c(context) != null) {
            h.a("start new session.");
            f2858d = com.tencent.stat.i.m.a();
            c.a(0);
            c.d();
            c(context).post(new q(new com.tencent.stat.a.e(context, f2858d, a())));
        }
    }

    static void e(Context context) {
        if (c.u()) {
            if (context == null) {
                h.d("The Context of StatService.reportNativeCrash() can not be null!");
                return;
            }
            try {
                if (c(context) != null) {
                    c(context).post(new o(context));
                }
            } catch (Throwable th) {
                h.c(th);
                a(context, th);
            }
        }
    }

    public static void f(Context context) {
        if (c.u()) {
            if (context == null) {
                h.d("The Context of StatService.onPause() can not be null!");
            } else {
                b(context, com.tencent.stat.i.m.r(context));
            }
        }
    }

    public static void g(Context context) {
        if (c.u()) {
            if (context == null) {
                h.d("The Context of StatService.onResume() can not be null!");
            } else {
                a(context, com.tencent.stat.i.m.r(context));
            }
        }
    }

    public static void h(Context context) {
        if (c.u()) {
            if (context == null) {
                h.d("The Context of StatService.testSpeed() can not be null!");
                return;
            }
            try {
                if (c(context) != null) {
                    c(context).post(new p(context, null));
                }
            } catch (Throwable th) {
                h.c(th);
                a(context, th);
            }
        }
    }
}
