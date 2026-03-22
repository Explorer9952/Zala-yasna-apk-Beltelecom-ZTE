package com.tencent.stat.i;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* loaded from: classes.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    String f2875a;

    /* renamed from: b, reason: collision with root package name */
    String f2876b;

    /* renamed from: c, reason: collision with root package name */
    DisplayMetrics f2877c;

    /* renamed from: d, reason: collision with root package name */
    int f2878d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    int l;
    String m;
    Context n;
    private String o;
    private String p;
    private String q;
    private String r;

    private e(Context context) {
        this.f2876b = "1.6.2";
        this.f2878d = Build.VERSION.SDK_INT;
        this.e = Build.MODEL;
        this.f = Build.MANUFACTURER;
        this.g = Locale.getDefault().getLanguage();
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.n = context;
        this.f2877c = m.k(context);
        this.f2875a = m.u(context);
        this.h = com.tencent.stat.c.d(context);
        this.i = m.t(context);
        this.j = TimeZone.getDefault().getID();
        this.l = m.z(context);
        this.k = m.A(context);
        this.m = context.getPackageName();
        if (this.f2878d >= 14) {
            this.o = m.a(context);
        }
        this.p = m.G(context).toString();
        this.q = m.E(context);
        this.r = m.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        jSONObject.put("sr", this.f2877c.widthPixels + "*" + this.f2877c.heightPixels);
        m.a(jSONObject, "av", this.f2875a);
        m.a(jSONObject, "ch", this.h);
        m.a(jSONObject, "mf", this.f);
        m.a(jSONObject, "sv", this.f2876b);
        m.a(jSONObject, "ov", Integer.toString(this.f2878d));
        jSONObject.put("os", 1);
        m.a(jSONObject, "op", this.i);
        m.a(jSONObject, "lg", this.g);
        m.a(jSONObject, "md", this.e);
        m.a(jSONObject, "tz", this.j);
        int i = this.l;
        if (i != 0) {
            jSONObject.put("jb", i);
        }
        m.a(jSONObject, "sd", this.k);
        m.a(jSONObject, "apn", this.m);
        if (m.o(this.n)) {
            JSONObject jSONObject2 = new JSONObject();
            m.a(jSONObject2, "bs", m.c(this.n));
            m.a(jSONObject2, "ss", m.d(this.n));
            if (jSONObject2.length() > 0) {
                m.a(jSONObject, "wf", jSONObject2.toString());
            }
        }
        m.a(jSONObject, "sen", this.o);
        m.a(jSONObject, "cpu", this.p);
        m.a(jSONObject, "ram", this.q);
        m.a(jSONObject, "rom", this.r);
    }
}
