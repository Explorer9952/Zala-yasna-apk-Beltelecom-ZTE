package com.zte.iptvclient.android.common.javabean;

import org.json.JSONObject;

/* compiled from: SubscribeBean.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private String f4740a;

    /* renamed from: b, reason: collision with root package name */
    private String f4741b;

    /* renamed from: c, reason: collision with root package name */
    private String f4742c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4743d;

    public String a() {
        return this.f4740a;
    }

    public void a(String str) {
    }

    public void b(String str) {
        this.f4740a = str;
    }

    public String c() {
        return this.f4742c;
    }

    public void c(String str) {
    }

    public void d(String str) {
    }

    public boolean d() {
        return this.f4743d;
    }

    public void e(String str) {
    }

    public void f(String str) {
    }

    public void g(String str) {
    }

    public void h(String str) {
    }

    public void i(String str) {
        this.f4741b = str;
    }

    public void j(String str) {
    }

    public void k(String str) {
    }

    public void l(String str) {
        this.f4742c = str;
    }

    public void a(boolean z) {
        this.f4743d = z;
    }

    public String b() {
        return this.f4741b;
    }

    public static j a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        j jVar = new j();
        try {
            jVar.b(jSONObject.optString("contentcode"));
            jVar.c(jSONObject.optString("createtime"));
            jVar.d(jSONObject.optString("description"));
            jVar.h(jSONObject.optString("programcode"));
            jVar.i(jSONObject.optString("programname"));
            jVar.a(jSONObject.optString("columncode"));
            jVar.g(jSONObject.optString("posterimage"));
            jVar.f(jSONObject.optString("posterfilelist"));
            jVar.e(jSONObject.optString("elapsedtime"));
            jVar.j(jSONObject.optString("programtype"));
            jVar.l(jSONObject.optString("releasedate"));
            jVar.k(jSONObject.optString("ratingid"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jVar;
    }
}
