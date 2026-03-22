package com.tencent.stat.a;

import android.content.Context;
import com.tencent.stat.i.m;
import com.tencent.stat.t;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected String f2829a;

    /* renamed from: b, reason: collision with root package name */
    protected long f2830b = System.currentTimeMillis() / 1000;

    /* renamed from: c, reason: collision with root package name */
    protected int f2831c;

    /* renamed from: d, reason: collision with root package name */
    protected com.tencent.stat.a f2832d;
    protected int e;
    protected String f;
    protected String g;
    protected String h;
    protected Context i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, int i) {
        this.f2829a = null;
        this.f2832d = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = context;
        this.f2831c = i;
        this.f2829a = com.tencent.stat.c.a(context);
        this.f = com.tencent.stat.c.b(context);
        this.f2832d = t.b(context).a(context);
        this.e = m.D(context).intValue();
        this.h = m.u(context);
        this.g = com.tencent.stat.c.d(context);
    }

    public abstract f a();

    public abstract boolean a(JSONObject jSONObject);

    public long b() {
        return this.f2830b;
    }

    public boolean b(JSONObject jSONObject) {
        try {
            m.a(jSONObject, "ky", this.f2829a);
            jSONObject.put("et", a().a());
            if (this.f2832d != null) {
                jSONObject.put("ui", this.f2832d.d());
                m.a(jSONObject, "mc", this.f2832d.e());
                jSONObject.put("ut", this.f2832d.g());
            }
            m.a(jSONObject, "cui", this.f);
            if (a() != f.SESSION_ENV) {
                m.a(jSONObject, "av", this.h);
                m.a(jSONObject, "ch", this.g);
            }
            m.a(jSONObject, "mid", com.tencent.stat.c.e(this.i));
            jSONObject.put("idx", this.e);
            jSONObject.put("si", this.f2831c);
            jSONObject.put("ts", this.f2830b);
            if (this.f2832d.g() == 0 && m.e(this.i) == 1) {
                jSONObject.put("ia", 1);
            }
            return a(jSONObject);
        } catch (Throwable unused) {
            return false;
        }
    }

    public Context c() {
        return this.i;
    }

    public String d() {
        try {
            JSONObject jSONObject = new JSONObject();
            b(jSONObject);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
