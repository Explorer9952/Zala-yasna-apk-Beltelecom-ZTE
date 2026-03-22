package com.zte.iptvclient.android.common.javabean.models;

import com.video.androidsdk.common.http.HttpConstant;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.ParamConst;
import org.json.JSONObject;

/* compiled from: PlayChannelBean.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f4767a;

    /* renamed from: b, reason: collision with root package name */
    private String f4768b;

    /* renamed from: c, reason: collision with root package name */
    private String f4769c;

    /* renamed from: d, reason: collision with root package name */
    private String f4770d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;

    public String a() {
        return this.f4769c;
    }

    public void b(String str) {
        this.s = str;
    }

    public String c() {
        return this.p;
    }

    public String d() {
        return this.f4767a;
    }

    public void d(String str) {
    }

    public String e() {
        return this.f4768b;
    }

    public void e(String str) {
    }

    public void f(String str) {
        this.f4767a = str;
    }

    public void g(String str) {
        this.f4768b = str;
    }

    public String h() {
        return this.e;
    }

    public String i() {
        return this.g;
    }

    public String j() {
        if (SDKLoginMgr.getInstance().getEPGHome() == null) {
            return "";
        }
        if (SDKLoginMgr.getInstance().getEPGHome().startsWith(HttpConstant.PROTOCOL_HTTPS)) {
            return this.j;
        }
        return this.i;
    }

    public void j(String str) {
    }

    public String k() {
        return this.h;
    }

    public String l() {
        return this.o;
    }

    public void l(String str) {
    }

    public void m(String str) {
        this.e = str;
    }

    public String n() {
        return this.f;
    }

    public String o() {
        return this.r;
    }

    public String p() {
        return this.f4770d;
    }

    public String q() {
        return this.m;
    }

    public String r() {
        return this.n;
    }

    public void s(String str) {
        this.f = str;
    }

    public void t(String str) {
        this.r = str;
    }

    public void u(String str) {
        this.f4770d = str;
    }

    public void v(String str) {
        this.m = str;
    }

    public void w(String str) {
        this.n = str;
    }

    public void x(String str) {
    }

    public void y(String str) {
    }

    public void a(String str) {
        this.f4769c = str;
    }

    public String b() {
        return this.s;
    }

    public void c(String str) {
        this.p = str;
    }

    public String f() {
        return this.k;
    }

    public String g() {
        return this.l;
    }

    public void h(String str) {
        this.k = str;
    }

    public void i(String str) {
        this.l = str;
    }

    public void k(String str) {
        this.j = str;
    }

    public String m() {
        return this.q;
    }

    public void n(String str) {
        this.g = str;
    }

    public void o(String str) {
        this.i = str;
    }

    public void p(String str) {
        this.h = str;
    }

    public void q(String str) {
        this.o = str;
    }

    public void r(String str) {
        this.q = str;
    }

    public static c a(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.f(jSONObject.optString("channelcode"));
            cVar.g(jSONObject.optString("channelname"));
            cVar.n(jSONObject.optString("mixno"));
            cVar.p(jSONObject.optString("posterimage"));
            cVar.o(jSONObject.optString("playurl"));
            cVar.k(jSONObject.optString("httpsplayurl"));
            cVar.a(jSONObject.optString("advertisecontent"));
            cVar.u(jSONObject.optString("telecomcode"));
            cVar.m(jSONObject.optString("isprotection"));
            cVar.s(jSONObject.optString("ratingid"));
            cVar.h(jSONObject.optString("columncode"));
            cVar.i(jSONObject.optString("definition"));
            cVar.v(jSONObject.optString(ParamConst.CHANNEL_INFO_RSP_TIMESHIFTENABLE));
            cVar.w(jSONObject.optString(ParamConst.CHANNEL_INFO_RSP_TSAVAILABLE));
            cVar.l(jSONObject.optString("isfavourite"));
            cVar.q(jSONObject.optString("prevuename"));
            cVar.d(jSONObject.optString("begintime"));
            cVar.j(jSONObject.optString("endtime"));
            cVar.x(jSONObject.optString(ParamConst.CHANNEL_PREVUE_INFO_RSP_UTCBEGINTIME));
            cVar.y(jSONObject.optString("utcendtime"));
            cVar.c(jSONObject.optString(ParamConst.VOD_MULTIPLE_URL_RSP_AUTH_RETURNCODE));
            cVar.e(jSONObject.optString("cast"));
            cVar.t(jSONObject.optString("systemlimitenable"));
            cVar.b(jSONObject.optString("allownettype"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cVar;
    }
}
