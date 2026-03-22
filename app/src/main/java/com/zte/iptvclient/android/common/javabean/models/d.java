package com.zte.iptvclient.android.common.javabean.models;

import android.text.TextUtils;
import com.video.androidsdk.common.http.HttpConstant;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.ParamConst;
import org.json.JSONObject;

/* compiled from: PrevueDetailBean.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private String f4771a;

    /* renamed from: b, reason: collision with root package name */
    private String f4772b;

    /* renamed from: c, reason: collision with root package name */
    private String f4773c;

    /* renamed from: d, reason: collision with root package name */
    private String f4774d;
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

    public void A(String str) {
        this.k = str;
    }

    public void B(String str) {
        this.f = str;
    }

    public void C(String str) {
        this.g = str;
    }

    public String a() {
        return this.o;
    }

    public void a(String str) {
    }

    public String b() {
        if (!TextUtils.isEmpty(this.f4774d)) {
            return this.f4774d;
        }
        return this.f;
    }

    public String c() {
        return this.f4773c;
    }

    public void d(String str) {
        this.f4773c = str;
    }

    public String e() {
        return this.j;
    }

    public void f(String str) {
        this.j = str;
    }

    public String g() {
        if (!TextUtils.isEmpty(this.e)) {
            return this.e;
        }
        return this.g;
    }

    public String h() {
        return this.l;
    }

    public void h(String str) {
    }

    public void i(String str) {
        this.e = str;
    }

    public void j(String str) {
        this.i = str;
    }

    public String k() {
        if (SDKLoginMgr.getInstance().getEPGHome() == null) {
            return "";
        }
        if (SDKLoginMgr.getInstance().getEPGHome().startsWith(HttpConstant.PROTOCOL_HTTPS)) {
            return this.i;
        }
        return this.h;
    }

    public void k(String str) {
    }

    public String l() {
        return this.f4771a;
    }

    public String m() {
        return this.f4772b;
    }

    public void m(String str) {
    }

    public void n(String str) {
        this.p = str;
    }

    public String o() {
        return this.n;
    }

    public void o(String str) {
    }

    public String p() {
        return this.k;
    }

    public String q() {
        return this.f;
    }

    public void r(String str) {
        this.f4771a = str;
    }

    public void s(String str) {
    }

    public void t(String str) {
        this.f4772b = str;
    }

    public void u(String str) {
        this.q = str;
    }

    public void v(String str) {
    }

    public void w(String str) {
        this.n = str;
    }

    public void x(String str) {
    }

    public void y(String str) {
    }

    public void z(String str) {
    }

    public static d a(JSONObject jSONObject) {
        d dVar = new d();
        try {
            dVar.r(jSONObject.optString("prevuecode"));
            dVar.t(jSONObject.optString("prevuename"));
            dVar.d(jSONObject.optString("channelcode"));
            dVar.c(jSONObject.optString("begintime"));
            dVar.i(jSONObject.optString("endtime"));
            dVar.B(jSONObject.optString(ParamConst.CHANNEL_PREVUE_INFO_RSP_UTCBEGINTIME));
            dVar.C(jSONObject.optString("utcendtime"));
            dVar.z(jSONObject.optString("status"));
            dVar.q(jSONObject.optString("playurl"));
            dVar.j(jSONObject.optString("httpsplayurl"));
            dVar.f(jSONObject.optString("columncode"));
            dVar.A(jSONObject.optString("telecomcode"));
            dVar.g(jSONObject.optString("definition"));
            dVar.l(jSONObject.optString("isprotection"));
            dVar.w(jSONObject.optString("ratingid"));
            dVar.y(jSONObject.optString("seriesheadid"));
            dVar.b(jSONObject.optString(ParamConst.VOD_MULTIPLE_URL_RSP_AUTH_RETURNCODE));
            dVar.h(jSONObject.optString("description"));
            dVar.s(jSONObject.optString("prevueid"));
            dVar.m(jSONObject.optString("mediaservice"));
            dVar.v(jSONObject.optString("programid"));
            dVar.n(jSONObject.optString("mixno"));
            dVar.x(jSONObject.optString("resultMessage"));
            dVar.k(jSONObject.optString("isdrm"));
            dVar.o(jSONObject.optString("needlogin"));
            dVar.e(jSONObject.optString("chcmsid"));
            dVar.p(jSONObject.optString("chphysicalcontentid"));
            dVar.a(jSONObject.optString("allownettype"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dVar;
    }

    public void c(String str) {
        this.f4774d = str;
    }

    public String d() {
        return this.r;
    }

    public void e(String str) {
        this.r = str;
    }

    public String f() {
        return this.m;
    }

    public String i() {
        return this.p;
    }

    public String j() {
        return this.s;
    }

    public void l(String str) {
        this.l = str;
    }

    public String n() {
        return this.q;
    }

    public void p(String str) {
        this.s = str;
    }

    public void q(String str) {
        this.h = str;
    }

    public String r() {
        return this.g;
    }

    public void b(String str) {
        this.o = str;
    }

    public void g(String str) {
        this.m = str;
    }
}
