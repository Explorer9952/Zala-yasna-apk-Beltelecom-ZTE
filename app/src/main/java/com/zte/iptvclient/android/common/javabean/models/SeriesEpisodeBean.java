package com.zte.iptvclient.android.common.javabean.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.video.androidsdk.service.comm.ParamConst;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SeriesEpisodeBean implements Parcelable {
    public static final Parcelable.Creator<SeriesEpisodeBean> CREATOR = new a();
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;
    private String O;
    private String P;
    private String Q;
    private String R;

    /* renamed from: a, reason: collision with root package name */
    private String f4752a;

    /* renamed from: b, reason: collision with root package name */
    private String f4753b;

    /* renamed from: c, reason: collision with root package name */
    private String f4754c;

    /* renamed from: d, reason: collision with root package name */
    private String f4755d;
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
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<SeriesEpisodeBean> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SeriesEpisodeBean createFromParcel(Parcel parcel) {
            return new SeriesEpisodeBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SeriesEpisodeBean[] newArray(int i) {
            return new SeriesEpisodeBean[i];
        }
    }

    public SeriesEpisodeBean() {
    }

    public void A(String str) {
        this.f4752a = str;
    }

    public void B(String str) {
        this.f4753b = str;
    }

    public void C(String str) {
        this.f4754c = str;
    }

    public void D(String str) {
        this.f = str;
    }

    public void E(String str) {
        this.G = str;
    }

    public void F(String str) {
        this.J = str;
    }

    public void G(String str) {
        this.o = str;
    }

    public void H(String str) {
        this.w = str;
    }

    public void I(String str) {
        this.z = str;
    }

    public void J(String str) {
        this.A = str;
    }

    public void K(String str) {
        this.g = str;
    }

    public void L(String str) {
        this.C = str;
    }

    public void M(String str) {
        this.y = str;
    }

    public void N(String str) {
        this.l = str;
    }

    public void O(String str) {
        this.m = str;
    }

    public void P(String str) {
        this.n = str;
    }

    public String a() {
        return this.u;
    }

    public void b(String str) {
        this.R = str;
    }

    public String c() {
        return this.M;
    }

    public String d() {
        return this.Q;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.t;
    }

    public String f() {
        return this.f4755d;
    }

    public String g() {
        return this.N;
    }

    public void h(String str) {
        this.f4755d = str;
    }

    public String i() {
        return this.O;
    }

    public String j() {
        return this.f4752a;
    }

    public String k() {
        return this.f4753b;
    }

    public String l() {
        return this.f4754c;
    }

    public void m(String str) {
        this.N = str;
    }

    public String n() {
        return this.o;
    }

    public String o() {
        return this.l;
    }

    public void p(String str) {
        this.s = str;
    }

    public void q(String str) {
        this.K = str;
    }

    public void r(String str) {
        this.k = str;
    }

    public void s(String str) {
        this.D = str;
    }

    public void t(String str) {
        this.e = str;
    }

    public void u(String str) {
        this.i = str;
    }

    public void v(String str) {
        this.P = str;
    }

    public void w(String str) {
        this.p = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4752a);
        parcel.writeString(this.f4753b);
        parcel.writeString(this.f4754c);
        parcel.writeString(this.f4755d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeString(this.t);
        parcel.writeString(this.u);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        parcel.writeString(this.x);
        parcel.writeString(this.y);
        parcel.writeString(this.z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeString(this.L);
        parcel.writeString(this.M);
        parcel.writeString(this.N);
        parcel.writeString(this.O);
        parcel.writeString(this.P);
        parcel.writeString(this.Q);
        parcel.writeString(this.R);
    }

    public void x(String str) {
        this.q = str;
    }

    public void y(String str) {
        this.O = str;
    }

    public void z(String str) {
        this.h = str;
    }

    protected SeriesEpisodeBean(Parcel parcel) {
        this.f4752a = parcel.readString();
        this.f4753b = parcel.readString();
        this.f4754c = parcel.readString();
        this.f4755d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readString();
        this.t = parcel.readString();
        this.u = parcel.readString();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.x = parcel.readString();
        this.y = parcel.readString();
        this.z = parcel.readString();
        this.A = parcel.readString();
        this.B = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readString();
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.L = parcel.readString();
        this.M = parcel.readString();
        this.N = parcel.readString();
        this.O = parcel.readString();
        this.P = parcel.readString();
        this.Q = parcel.readString();
        this.R = parcel.readString();
    }

    public void a(String str) {
        this.u = str;
    }

    public String b() {
        return this.R;
    }

    public void c(String str) {
        this.M = str;
    }

    public void d(String str) {
        this.Q = str;
    }

    public void e(String str) {
        this.F = str;
    }

    public void f(String str) {
        this.L = str;
    }

    public void g(String str) {
        this.t = str;
    }

    public String h() {
        return this.K;
    }

    public void i(String str) {
        this.j = str;
    }

    public void j(String str) {
        this.r = str;
    }

    public void k(String str) {
        this.v = str;
    }

    public void l(String str) {
        this.B = str;
    }

    public String m() {
        return this.f;
    }

    public void n(String str) {
        this.E = str;
    }

    public void o(String str) {
        this.x = str;
    }

    public static SeriesEpisodeBean a(JSONObject jSONObject) {
        SeriesEpisodeBean seriesEpisodeBean = new SeriesEpisodeBean();
        try {
            seriesEpisodeBean.A(jSONObject.optString("programcode"));
            seriesEpisodeBean.B(jSONObject.optString("programname"));
            seriesEpisodeBean.C(jSONObject.optString("programtype"));
            seriesEpisodeBean.h(jSONObject.optString("contentcode"));
            seriesEpisodeBean.t(jSONObject.optString("mediaservices"));
            seriesEpisodeBean.D(jSONObject.optString("ratingid"));
            seriesEpisodeBean.K(jSONObject.optString("sortnum"));
            seriesEpisodeBean.z(jSONObject.optString("price"));
            seriesEpisodeBean.u(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_OFFLINETIME));
            seriesEpisodeBean.i(jSONObject.optString("countryname"));
            seriesEpisodeBean.r(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_ISSIMPLETRAILER));
            seriesEpisodeBean.N(jSONObject.optString("telecomcode"));
            seriesEpisodeBean.O(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_TRAILERBEGINTIME));
            seriesEpisodeBean.P(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_TRAILERENDTIME));
            seriesEpisodeBean.G(jSONObject.optString("seriesnum"));
            seriesEpisodeBean.w(jSONObject.optString("posterfilelist"));
            seriesEpisodeBean.c(jSONObject.optString("beginduration"));
            seriesEpisodeBean.m(jSONObject.optString("endduration"));
            seriesEpisodeBean.y(jSONObject.optString("preduration"));
            seriesEpisodeBean.x(jSONObject.optString("posterpath"));
            seriesEpisodeBean.j(jSONObject.optString("description"));
            seriesEpisodeBean.p(jSONObject.optString("iplimitflag"));
            seriesEpisodeBean.g(jSONObject.optString("columncode"));
            seriesEpisodeBean.a(jSONObject.optString("advertisecontent"));
            seriesEpisodeBean.k(jSONObject.optString("detaildescribed"));
            seriesEpisodeBean.H(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_SERIESSEASON));
            seriesEpisodeBean.o(jSONObject.optString("genre"));
            seriesEpisodeBean.M(jSONObject.optString("subgenre"));
            seriesEpisodeBean.I(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_SHORTDESC));
            seriesEpisodeBean.J(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_SHORTTITLE));
            seriesEpisodeBean.l(jSONObject.optString("elapsedtime"));
            seriesEpisodeBean.L(jSONObject.optString("starlevel"));
            seriesEpisodeBean.s(jSONObject.optString("language"));
            seriesEpisodeBean.n(jSONObject.optString("episodetitle"));
            seriesEpisodeBean.e(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_CATALOGTYPE));
            seriesEpisodeBean.E(jSONObject.optString("ratingnum"));
            seriesEpisodeBean.F(jSONObject.optString("ratingsum"));
            seriesEpisodeBean.q(jSONObject.optString("isprotection"));
            seriesEpisodeBean.f(jSONObject.optString("cmsid"));
            seriesEpisodeBean.v(jSONObject.optString("physicalcontentid"));
            seriesEpisodeBean.b(jSONObject.optString("allownettype"));
            seriesEpisodeBean.d(jSONObject.optString("breakpoint"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seriesEpisodeBean;
    }
}
