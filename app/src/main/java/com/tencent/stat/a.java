package com.tencent.stat;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    private static com.tencent.stat.i.b h = com.tencent.stat.i.m.b();

    /* renamed from: a, reason: collision with root package name */
    private String f2825a;

    /* renamed from: b, reason: collision with root package name */
    private String f2826b;

    /* renamed from: c, reason: collision with root package name */
    private String f2827c;

    /* renamed from: d, reason: collision with root package name */
    private String f2828d;
    private int e;
    private int f;
    private long g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        this.f2825a = null;
        this.f2826b = null;
        this.f2827c = null;
        this.f2828d = "0";
        this.f = 0;
        this.g = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, String str2, int i) {
        this.f2825a = null;
        this.f2826b = null;
        this.f2827c = null;
        this.f2828d = "0";
        this.f = 0;
        this.g = 0L;
        this.f2825a = str;
        this.f2826b = str2;
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a e(String str) {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("ui")) {
                aVar.c(jSONObject.getString("ui"));
            }
            if (!jSONObject.isNull("mc")) {
                aVar.d(jSONObject.getString("mc"));
            }
            if (!jSONObject.isNull("mid")) {
                aVar.b(jSONObject.getString("mid"));
            }
            if (!jSONObject.isNull("aid")) {
                aVar.a(jSONObject.getString("aid"));
            }
            if (!jSONObject.isNull("ts")) {
                aVar.a(jSONObject.getLong("ts"));
            }
            if (!jSONObject.isNull("ver")) {
                aVar.a(jSONObject.getInt("ver"));
            }
        } catch (JSONException e) {
            h.a((Exception) e);
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(a aVar) {
        if (aVar == null) {
            return 1;
        }
        String f = f();
        String f2 = aVar.f();
        if (f != null && f2 != null && f.equals(f2)) {
            return 0;
        }
        int a2 = a();
        int a3 = aVar.a();
        if (a2 > a3) {
            return 1;
        }
        if (a2 == a3) {
            long b2 = b();
            long b3 = aVar.b();
            if (b2 > b3) {
                return 1;
            }
            if (b2 == b3) {
                return 0;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.f = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.g = j;
    }

    void a(String str) {
        this.f2827c = str;
    }

    long b() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        this.f2828d = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.tencent.stat.i.m.a(jSONObject, "ui", this.f2825a);
            com.tencent.stat.i.m.a(jSONObject, "mc", this.f2826b);
            com.tencent.stat.i.m.a(jSONObject, "mid", this.f2828d);
            com.tencent.stat.i.m.a(jSONObject, "aid", this.f2827c);
            jSONObject.put("ts", this.g);
            jSONObject.put("ver", this.f);
        } catch (JSONException e) {
            h.a((Exception) e);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str) {
        this.f2825a = str;
    }

    public String d() {
        return this.f2825a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        this.f2826b = str;
    }

    public String e() {
        return this.f2826b;
    }

    public String f() {
        return this.f2828d;
    }

    public int g() {
        return this.e;
    }

    public String toString() {
        return c().toString();
    }
}
