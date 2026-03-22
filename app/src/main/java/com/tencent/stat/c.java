package com.tencent.stat;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {
    private static String m;
    private static String n;

    /* renamed from: a, reason: collision with root package name */
    private static com.tencent.stat.i.b f2846a = com.tencent.stat.i.m.b();

    /* renamed from: b, reason: collision with root package name */
    static g f2847b = new g(2);

    /* renamed from: c, reason: collision with root package name */
    static g f2848c = new g(1);

    /* renamed from: d, reason: collision with root package name */
    private static StatReportStrategy f2849d = StatReportStrategy.APP_LAUNCH;
    private static boolean e = true;
    private static int f = 30000;
    private static int g = Util.BYTE_OF_KB;
    private static int h = 30;
    private static int i = 3;
    private static int j = 30;
    static String k = "__HIBERNATE__";
    private static String l = null;
    private static int o = 1440;
    private static int p = Util.BYTE_OF_KB;
    private static boolean q = true;
    public static boolean r = true;
    private static String s = "http://pingma.qq.com:80/mstat/report";
    private static int t = 0;
    private static volatile int u = 0;
    private static int v = 20;
    private static int w = 0;
    private static int x = 4096;
    private static boolean y = false;
    private static String z = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        return h;
    }

    public static synchronized String a(Context context) {
        synchronized (c.class) {
            if (m != null) {
                return m;
            }
            if (context != null && m == null) {
                m = com.tencent.stat.i.m.p(context);
            }
            if (m == null || m.trim().length() == 0) {
                f2846a.d("AppKey can not be null or empty, please read Developer's Guide first!");
            }
            return m;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2) {
        String string;
        try {
            string = f2848c.f2864b.getString(str);
        } catch (Throwable th) {
            f2846a.g(th);
        }
        return string != null ? string : str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void a(int i2) {
        synchronized (c.class) {
            u = i2;
        }
    }

    public static void a(StatReportStrategy statReportStrategy) {
        f2849d = statReportStrategy;
        f2846a.a("Change to statSendStrategy: " + statReportStrategy);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar) {
        int i2 = gVar.f2863a;
        if (i2 == f2848c.f2863a) {
            f2848c = gVar;
            b(gVar.f2864b);
        } else if (i2 == f2847b.f2863a) {
            f2847b = gVar;
        }
    }

    static void a(g gVar, JSONObject jSONObject) {
        boolean z2 = false;
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase("v")) {
                    int i2 = jSONObject.getInt(next);
                    if (gVar.f2866d != i2) {
                        z2 = true;
                    }
                    gVar.f2866d = i2;
                } else if (next.equalsIgnoreCase("c")) {
                    String string = jSONObject.getString("c");
                    if (string.length() > 0) {
                        gVar.f2864b = new JSONObject(string);
                    }
                } else if (next.equalsIgnoreCase("m")) {
                    gVar.f2865c = jSONObject.getString("m");
                }
            }
            if (z2) {
                t b2 = t.b(j.a());
                if (b2 != null) {
                    b2.a(gVar);
                }
                if (gVar.f2863a == f2848c.f2863a) {
                    b(gVar.f2864b);
                    c(gVar.f2864b);
                }
            }
        } catch (JSONException e2) {
            f2846a.a((Exception) e2);
        } catch (Throwable th) {
            f2846a.c(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        g gVar;
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase(Integer.toString(f2848c.f2863a))) {
                    jSONObject2 = jSONObject.getJSONObject(next);
                    gVar = f2848c;
                } else if (next.equalsIgnoreCase(Integer.toString(f2847b.f2863a))) {
                    jSONObject2 = jSONObject.getJSONObject(next);
                    gVar = f2847b;
                } else {
                    if (!next.equalsIgnoreCase("rs")) {
                        return;
                    }
                    StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt(next));
                    if (statReportStrategy != null) {
                        f2849d = statReportStrategy;
                        f2846a.a("Change to ReportStrategy:" + statReportStrategy.name());
                    }
                }
                a(gVar, jSONObject2);
            }
        } catch (JSONException e2) {
            f2846a.a((Exception) e2);
        }
    }

    public static void a(boolean z2) {
        e = z2;
        if (z2) {
            return;
        }
        f2846a.h("!!!!!!MTA StatService has been disabled!!!!!!");
    }

    public static String b(Context context) {
        if (context == null) {
            f2846a.d("Context for getCustomUid is null.");
            return null;
        }
        if (z == null) {
            z = com.tencent.stat.i.q.a(context, "MTA_CUSTOM_UID", "");
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HttpHost b() {
        String str = l;
        if (str == null || str.length() <= 0) {
            return null;
        }
        String str2 = l;
        String[] split = str2.split(":");
        int i2 = 80;
        if (split.length == 2) {
            str2 = split[0];
            i2 = Integer.parseInt(split[1]);
        }
        return new HttpHost(str2, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(int i2) {
        if (i2 < 0) {
            return;
        }
        w = i2;
    }

    static void b(JSONObject jSONObject) {
        try {
            StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt("rs"));
            if (statReportStrategy != null) {
                a(statReportStrategy);
            }
        } catch (JSONException unused) {
            f2846a.a("rs not found.");
        }
    }

    public static a c(Context context) {
        return d.b(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c() {
        synchronized (c.class) {
            u++;
        }
    }

    static void c(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString(k);
            f2846a.a("hibernateVer:" + string + ", current version:1.6.2");
            long b2 = com.tencent.stat.i.m.b(string);
            if (com.tencent.stat.i.m.b("1.6.2") <= b2) {
                com.tencent.stat.i.q.b(j.a(), k, b2);
                a(false);
                f2846a.h("MTA has disable for SDK version of " + string + " or lower.");
            }
        } catch (JSONException unused) {
            f2846a.a("__HIBERNATE__ not found.");
        }
    }

    public static synchronized String d(Context context) {
        synchronized (c.class) {
            if (n != null) {
                return n;
            }
            String q2 = com.tencent.stat.i.m.q(context);
            n = q2;
            if (q2 == null || q2.trim().length() == 0) {
                f2846a.g("installChannel can not be null or empty, please read Developer's Guide first!");
            }
            return n;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d() {
        w++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e() {
        return w;
    }

    public static String e(Context context) {
        return d.c(context);
    }

    public static int f() {
        return u;
    }

    public static int g() {
        return j;
    }

    public static int h() {
        return v;
    }

    public static int i() {
        return p;
    }

    public static int j() {
        return x;
    }

    public static int k() {
        return i;
    }

    public static int l() {
        return t;
    }

    public static int m() {
        return g;
    }

    public static int n() {
        return o;
    }

    public static int o() {
        return f;
    }

    public static String p() {
        return s;
    }

    public static StatReportStrategy q() {
        return f2849d;
    }

    public static boolean r() {
        return r;
    }

    public static boolean s() {
        return y;
    }

    public static boolean t() {
        return q;
    }

    public static boolean u() {
        return e;
    }
}
