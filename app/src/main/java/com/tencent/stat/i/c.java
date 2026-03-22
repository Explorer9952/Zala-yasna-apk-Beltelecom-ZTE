package com.tencent.stat.i;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    static e f2871c;

    /* renamed from: d, reason: collision with root package name */
    private static b f2872d = m.b();
    private static JSONObject e = null;

    /* renamed from: a, reason: collision with root package name */
    Integer f2873a;

    /* renamed from: b, reason: collision with root package name */
    String f2874b;

    public c(Context context) {
        this.f2873a = null;
        this.f2874b = null;
        try {
            a(context);
            this.f2873a = m.x(context.getApplicationContext());
            this.f2874b = m.w(context);
        } catch (Throwable th) {
            f2872d.c(th);
        }
    }

    static synchronized e a(Context context) {
        e eVar;
        synchronized (c.class) {
            if (f2871c == null) {
                f2871c = new e(context.getApplicationContext());
            }
            eVar = f2871c;
        }
        return eVar;
    }

    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (f2871c != null) {
                f2871c.a(jSONObject2);
            }
            m.a(jSONObject2, "cn", this.f2874b);
            if (this.f2873a != null) {
                jSONObject2.put("tn", this.f2873a);
            }
            jSONObject.put("ev", jSONObject2);
            if (e == null || e.length() <= 0) {
                return;
            }
            jSONObject.put("eva", e);
        } catch (Throwable th) {
            f2872d.c(th);
        }
    }
}
