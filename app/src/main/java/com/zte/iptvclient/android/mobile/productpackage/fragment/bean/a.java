package com.zte.iptvclient.android.mobile.productpackage.fragment.bean;

import org.json.JSONObject;

/* compiled from: PackageDetailsBean.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f7041a;

    /* renamed from: b, reason: collision with root package name */
    private String f7042b;

    /* renamed from: c, reason: collision with root package name */
    private String f7043c;

    /* renamed from: d, reason: collision with root package name */
    private String f7044d;
    private String e;
    private String f;
    private String g;

    public String a() {
        return this.f7042b;
    }

    public String b() {
        return this.g;
    }

    public String c() {
        return this.f7041a;
    }

    public String d() {
        return this.f;
    }

    public void d(String str) {
    }

    public String e() {
        return this.f7043c;
    }

    public void e(String str) {
    }

    public String f() {
        return this.f7044d;
    }

    public void g(String str) {
        this.f7043c = str;
    }

    public void h(String str) {
        this.f7044d = str;
    }

    public void i(String str) {
        this.e = str;
    }

    public void j(String str) {
    }

    public void a(String str) {
        this.f7042b = str;
    }

    public void b(String str) {
        this.g = str;
    }

    public void c(String str) {
        this.f7041a = str;
    }

    public void f(String str) {
        this.f = str;
    }

    public String g() {
        return this.e;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.c(jSONObject.optString("contentname"));
        aVar.a(jSONObject.optString("columncode"));
        aVar.g(jSONObject.optString("programcode"));
        aVar.h(jSONObject.optString("programname"));
        aVar.i(jSONObject.optString("programtype"));
        aVar.f(jSONObject.optString("posterfilelist"));
        aVar.b(jSONObject.optString("contentcode"));
        aVar.d(jSONObject.optString("maincontentcode"));
        aVar.j(jSONObject.optString("seriesprogramcode"));
        aVar.e(jSONObject.optString("mediaservices  "));
        return aVar;
    }
}
