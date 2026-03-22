package com.zte.iptvclient.android.common.javabean;

import com.video.androidsdk.service.comm.ParamConst;
import org.json.JSONObject;

/* compiled from: ProductBean.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private String f4736a;

    /* renamed from: b, reason: collision with root package name */
    private String f4737b;

    /* renamed from: c, reason: collision with root package name */
    private String f4738c;

    /* renamed from: d, reason: collision with root package name */
    private String f4739d;
    private String e;
    private String f;
    private int g = 0;

    public String a() {
        return this.f;
    }

    public void a(String str) {
    }

    public String b() {
        return this.e;
    }

    public void b(String str) {
    }

    public String c() {
        return this.f4738c;
    }

    public String d() {
        return this.f4736a;
    }

    public String e() {
        return this.f4737b;
    }

    public int f() {
        return this.g;
    }

    public void f(String str) {
    }

    public void g(String str) {
        this.f4736a = str;
    }

    public void h(String str) {
    }

    public void i(String str) {
        this.f4737b = str;
    }

    public void j(String str) {
    }

    public void k(String str) {
    }

    public void l(String str) {
        this.f4739d = str;
    }

    public void m(String str) {
    }

    public void n(String str) {
    }

    public void a(int i) {
        this.g = i;
    }

    public void c(String str) {
        this.f = str;
    }

    public void d(String str) {
        this.e = str;
    }

    public void e(String str) {
        this.f4738c = str;
    }

    public String g() {
        return this.f4739d;
    }

    public static g a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        g gVar = new g();
        try {
            gVar.g(jSONObject.optString("productcode"));
            gVar.i(jSONObject.optString("productname"));
            gVar.j(jSONObject.optString("producttype"));
            gVar.e(jSONObject.optString("fee"));
            gVar.h(jSONObject.optString(ParamConst.AUTH_RSP_PRODUCTDESC));
            gVar.f(jSONObject.optString(ParamConst.AUTH_RSP_LISTPRICE));
            gVar.l(jSONObject.optString("rentalunit"));
            gVar.k(jSONObject.optString("rentalterm"));
            gVar.a(jSONObject.optString(ParamConst.AUTH_RSP_AUTOCONTINUEOPTION));
            gVar.b(jSONObject.optString("featurecode"));
            gVar.n(jSONObject.optString("valuetype"));
            gVar.d(jSONObject.optString("featurevalue"));
            gVar.m(jSONObject.optString("terminalflags"));
            gVar.c(jSONObject.optString("featuretype"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gVar;
    }
}
