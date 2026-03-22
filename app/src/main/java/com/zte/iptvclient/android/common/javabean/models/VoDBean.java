package com.zte.iptvclient.android.common.javabean.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.video.androidsdk.service.comm.ParamConst;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class VoDBean implements Parcelable {
    public static final Parcelable.Creator<VoDBean> CREATOR = new a();
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
    private String S;
    private String T;
    private String U;
    private String V;
    private String W;
    private String X;
    private String Y;
    private String Z;

    /* renamed from: a, reason: collision with root package name */
    private String f4757a;
    private String a0;

    /* renamed from: b, reason: collision with root package name */
    private String f4758b;

    /* renamed from: c, reason: collision with root package name */
    private String f4759c;

    /* renamed from: d, reason: collision with root package name */
    private String f4760d;
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
    static class a implements Parcelable.Creator<VoDBean> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VoDBean createFromParcel(Parcel parcel) {
            return new VoDBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VoDBean[] newArray(int i) {
            return new VoDBean[i];
        }
    }

    protected VoDBean(Parcel parcel) {
        this.f4757a = parcel.readString();
        this.f4758b = parcel.readString();
        this.f4759c = parcel.readString();
        this.f4760d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.a0 = parcel.readString();
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
        this.S = parcel.readString();
        this.T = parcel.readString();
        this.U = parcel.readString();
        this.V = parcel.readString();
        this.W = parcel.readString();
        this.X = parcel.readString();
        this.Y = parcel.readString();
        this.Z = parcel.readString();
    }

    public void A(String str) {
        this.o = str;
    }

    public void B(String str) {
        this.g = str;
    }

    public void C(String str) {
        this.h = str;
    }

    public void D(String str) {
        this.i = str;
    }

    public void E(String str) {
        this.m = str;
    }

    public void F(String str) {
        this.V = str;
    }

    public void G(String str) {
        this.W = str;
    }

    public void H(String str) {
        this.F = str;
    }

    public void I(String str) {
        this.Y = str;
    }

    public void J(String str) {
        this.v = str;
    }

    public void K(String str) {
        this.k = str;
    }

    public void L(String str) {
        this.L = str;
    }

    public void M(String str) {
        this.O = str;
    }

    public void N(String str) {
        this.P = str;
    }

    public void O(String str) {
        this.n = str;
    }

    public void P(String str) {
        this.R = str;
    }

    public void Q(String str) {
        this.N = str;
    }

    public void R(String str) {
        this.K = str;
    }

    public void S(String str) {
        this.s = str;
    }

    public void T(String str) {
        this.t = str;
    }

    public void U(String str) {
        this.u = str;
    }

    public void V(String str) {
        this.Z = str;
    }

    public void W(String str) {
        this.X = str;
    }

    public void X(String str) {
        this.G = str;
    }

    public String a() {
        return this.e;
    }

    public String b() {
        return this.f4757a;
    }

    public String c() {
        return this.D;
    }

    public void d(String str) {
        this.e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.a0;
    }

    public String f() {
        return this.f;
    }

    public void g(String str) {
        this.j = str;
    }

    public String h() {
        return this.g;
    }

    public void i(String str) {
        this.a0 = str;
    }

    public String j() {
        return this.i;
    }

    public String k() {
        return this.m;
    }

    public void l(String str) {
        this.A = str;
    }

    public void m(String str) {
        this.Q = str;
    }

    public String n() {
        return this.Z;
    }

    public void o(String str) {
        this.f4760d = str;
    }

    public void p(String str) {
        this.U = str;
    }

    public void q(String str) {
        this.f = str;
    }

    public void r(String str) {
        this.M = str;
    }

    public void s(String str) {
        this.C = str;
    }

    public void t(String str) {
        this.S = str;
    }

    public void u(String str) {
        this.r = str;
    }

    public void v(String str) {
        this.T = str;
    }

    public void w(String str) {
        this.l = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4757a);
        parcel.writeString(this.f4758b);
        parcel.writeString(this.f4759c);
        parcel.writeString(this.f4760d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.a0);
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
        parcel.writeString(this.S);
        parcel.writeString(this.T);
        parcel.writeString(this.U);
        parcel.writeString(this.V);
        parcel.writeString(this.W);
        parcel.writeString(this.X);
        parcel.writeString(this.Y);
        parcel.writeString(this.Z);
    }

    public void x(String str) {
        this.p = str;
    }

    public void y(String str) {
        this.w = str;
    }

    public void z(String str) {
        this.x = str;
    }

    public void a(String str) {
        this.B = str;
    }

    public void b(String str) {
        this.E = str;
    }

    public void c(String str) {
        this.J = str;
    }

    public String d() {
        return this.j;
    }

    public void e(String str) {
        this.f4757a = str;
    }

    public void f(String str) {
        this.D = str;
    }

    public String g() {
        return this.w;
    }

    public void h(String str) {
        this.q = str;
    }

    public String i() {
        return this.h;
    }

    public void j(String str) {
        this.y = str;
    }

    public void k(String str) {
        this.z = str;
    }

    public String l() {
        return this.Y;
    }

    public String m() {
        return this.R;
    }

    public void n(String str) {
        this.f4759c = str;
    }

    public String o() {
        return this.X;
    }

    public static VoDBean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        VoDBean voDBean = new VoDBean();
        try {
            voDBean.e(jSONObject.optString("breakpoint"));
            voDBean.n(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_EPISODEBREAKPOINT));
            voDBean.o(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_EPISODEPROGRAMNAME));
            voDBean.d(jSONObject.optString("bookmarktype"));
            voDBean.q(jSONObject.optString("favoritetype"));
            voDBean.B(jSONObject.optString("programcode"));
            voDBean.C(jSONObject.optString("programname"));
            voDBean.D(jSONObject.optString("programtype"));
            voDBean.g(jSONObject.optString("contentcode"));
            voDBean.K(jSONObject.optString("seriesprogramcode"));
            voDBean.w(jSONObject.optString("mediaservices"));
            voDBean.E(jSONObject.optString("ratingid"));
            voDBean.O(jSONObject.optString("sortnum"));
            voDBean.A(jSONObject.optString("price"));
            voDBean.x(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_OFFLINETIME));
            voDBean.h(jSONObject.optString("countryname"));
            voDBean.u(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_ISSIMPLETRAILER));
            voDBean.S(jSONObject.optString("telecomcode"));
            voDBean.T(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_TRAILERBEGINTIME));
            voDBean.U(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_TRAILERENDTIME));
            voDBean.J(jSONObject.optString("seriesnum"));
            voDBean.y(jSONObject.optString("posterfilelist"));
            voDBean.z(jSONObject.optString("posterpath"));
            voDBean.j(jSONObject.optString("description"));
            voDBean.k(jSONObject.optString("detaildescribed"));
            voDBean.l(jSONObject.optString("director"));
            voDBean.a(jSONObject.optString("actor"));
            voDBean.s(jSONObject.optString("iplimitflag"));
            voDBean.f(jSONObject.optString("columncode"));
            voDBean.b(jSONObject.optString("advertisecontent"));
            voDBean.H(jSONObject.optString("releasedate"));
            voDBean.X(jSONObject.optString("writer"));
            voDBean.c(jSONObject.optString("audiolang"));
            voDBean.R(jSONObject.optString("subtitlelang"));
            voDBean.L(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_SERIESSEASON));
            voDBean.r(jSONObject.optString("genre"));
            voDBean.Q(jSONObject.optString("subgenre"));
            voDBean.M(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_SHORTDESC));
            voDBean.N(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_SHORTTITLE));
            voDBean.m(jSONObject.optString("elapsedtime"));
            voDBean.P(jSONObject.optString("starlevel"));
            voDBean.t(jSONObject.optString("isprotection"));
            voDBean.v(jSONObject.optString("language"));
            voDBean.p(jSONObject.optString("episodetitle"));
            voDBean.F(jSONObject.optString("ratingnum"));
            voDBean.G(jSONObject.optString("ratingsum"));
            voDBean.W(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_WGKEYWORDS));
            voDBean.I(jSONObject.optString("savetime"));
            voDBean.i(jSONObject.optString("cpcode"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return voDBean;
    }

    public VoDBean() {
    }

    public VoDBean(VideoDetailBean videoDetailBean) {
        this.f = videoDetailBean.getProgramtype();
        this.j = videoDetailBean.getContentcode();
        this.h = videoDetailBean.getProgramname();
        this.a0 = videoDetailBean.getCpcode();
        this.D = videoDetailBean.getColumncode();
        this.m = videoDetailBean.getRatingid();
        this.w = videoDetailBean.getPosterfilelist();
        this.f4758b = videoDetailBean.getIsfavourite();
    }

    public VoDBean(SeriesHeadBean seriesHeadBean) {
        this.f = seriesHeadBean.getProgramtype();
        this.j = seriesHeadBean.getContentcode();
        this.h = seriesHeadBean.getProgramname();
        this.a0 = seriesHeadBean.getCpcode();
        this.D = seriesHeadBean.getColumncode();
        this.m = seriesHeadBean.getRatingid();
        this.w = seriesHeadBean.getPosterfilelist();
        this.k = seriesHeadBean.getSeriesprogramcode();
        this.f4758b = seriesHeadBean.getIsfavorite();
    }
}
