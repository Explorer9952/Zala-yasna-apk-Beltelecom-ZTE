package com.zte.iptvclient.android.common.javabean.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.video.androidsdk.service.comm.ParamConst;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CommonVideoBean implements Parcelable {
    public static final Parcelable.Creator<CommonVideoBean> CREATOR = new a();
    private String A;
    private String B;
    private String C;
    private String D;
    private boolean E;
    private String F;
    private String G;

    /* renamed from: a, reason: collision with root package name */
    private String f4744a;

    /* renamed from: b, reason: collision with root package name */
    private String f4745b;

    /* renamed from: c, reason: collision with root package name */
    private String f4746c;

    /* renamed from: d, reason: collision with root package name */
    private String f4747d;
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
    static class a implements Parcelable.Creator<CommonVideoBean> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommonVideoBean createFromParcel(Parcel parcel) {
            return new CommonVideoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommonVideoBean[] newArray(int i) {
            return new CommonVideoBean[i];
        }
    }

    public CommonVideoBean() {
    }

    public void A(String str) {
        this.w = str;
    }

    public void B(String str) {
        this.x = str;
    }

    public void C(String str) {
        this.A = str;
    }

    public void D(String str) {
        this.B = str;
    }

    public void E(String str) {
        this.t = str;
    }

    public void a(String str) {
        this.f4747d = str;
    }

    public String b() {
        return this.G;
    }

    public String c() {
        return this.k;
    }

    public String d() {
        return this.f4744a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f4745b;
    }

    public String f() {
        return this.f4746c;
    }

    public void g(String str) {
        this.j = str;
    }

    public String h() {
        return this.y;
    }

    public void i(String str) {
        this.h = str;
    }

    public void j(String str) {
        this.s = str;
    }

    public void k(String str) {
        this.f = str;
    }

    public void l(String str) {
        this.k = str;
    }

    public void m(String str) {
        this.C = str;
    }

    public void n(String str) {
        this.l = str;
    }

    public void o(String str) {
        this.f4744a = str;
    }

    public void p(String str) {
        this.f4745b = str;
    }

    public void q(String str) {
        this.f4746c = str;
    }

    public void r(String str) {
        this.o = str;
    }

    public void s(String str) {
        this.q = str;
    }

    public void t(String str) {
        this.r = str;
    }

    public String toString() {
        return "CommonVideoBean{programcode='" + this.f4744a + "', programname='" + this.f4745b + "', cpcode='" + this.G + "', programtype='" + this.f4746c + "', actor='" + this.f4747d + "', director='" + this.e + "', language='" + this.f + "', countryname='" + this.g + "', genre='" + this.h + "', columncode='" + this.i + "', elapsedtime='" + this.j + "', posterfilelist='" + this.k + "', posterpath='" + this.l + "', sortnum='" + this.m + "', releasedate='" + this.n + "', ratingid='" + this.o + "', starlevel='" + this.p + "', ratingnum='" + this.q + "', ratingsum='" + this.r + "', isprotection='" + this.s + "', wgkeywords='" + this.t + "', shorttitle='" + this.u + "', contentcode='" + this.v + "', telcomcode='" + this.w + "', updatenum='" + this.x + "', seriesnum='" + this.y + "', description='" + this.z + "', vrflag='" + this.A + "', vrtype='" + this.B + "', posterimage='" + this.C + "', favoritetype='" + this.D + "', isBigBanner=" + this.E + ", seriesprogramcode='" + this.F + "'}";
    }

    public void u(String str) {
        this.n = str;
    }

    public void v(String str) {
        this.y = str;
    }

    public void w(String str) {
        this.F = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4744a);
        parcel.writeString(this.f4745b);
        parcel.writeString(this.G);
        parcel.writeString(this.f4746c);
        parcel.writeString(this.f4747d);
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
        parcel.writeByte(this.E ? (byte) 1 : (byte) 0);
        parcel.writeString(this.F);
    }

    public void x(String str) {
        this.u = str;
    }

    public void y(String str) {
        this.m = str;
    }

    public void z(String str) {
        this.p = str;
    }

    protected CommonVideoBean(Parcel parcel) {
        this.f4744a = parcel.readString();
        this.f4745b = parcel.readString();
        this.G = parcel.readString();
        this.f4746c = parcel.readString();
        this.f4747d = parcel.readString();
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
        this.E = parcel.readByte() != 0;
        this.F = parcel.readString();
    }

    public String a() {
        return this.i;
    }

    public void b(String str) {
        this.i = str;
    }

    public void c(String str) {
        this.v = str;
    }

    public void d(String str) {
        this.g = str;
    }

    public void e(String str) {
        this.G = str;
    }

    public void f(String str) {
        this.e = str;
    }

    public String g() {
        return this.o;
    }

    public void h(String str) {
        this.D = str;
    }

    public String i() {
        return this.F;
    }

    public String j() {
        return this.u;
    }

    public String k() {
        return this.p;
    }

    public String l() {
        return this.t;
    }

    public static CommonVideoBean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        CommonVideoBean commonVideoBean = new CommonVideoBean();
        try {
            commonVideoBean.o(jSONObject.optString("programcode"));
            commonVideoBean.p(jSONObject.optString("programname"));
            commonVideoBean.e(jSONObject.optString("cpcode"));
            if (jSONObject.has("programtype")) {
                commonVideoBean.q(jSONObject.optString("programtype"));
            } else if (jSONObject.has("contenttype")) {
                commonVideoBean.q(jSONObject.optString("contenttype"));
            }
            commonVideoBean.j(jSONObject.optString("isprotection"));
            commonVideoBean.r(jSONObject.optString("ratingid"));
            commonVideoBean.u(jSONObject.optString("releasedate"));
            commonVideoBean.a(jSONObject.optString("actor"));
            commonVideoBean.f(jSONObject.optString("director"));
            commonVideoBean.k(jSONObject.optString("language"));
            commonVideoBean.d(jSONObject.optString("countryname"));
            commonVideoBean.i(jSONObject.optString("genre"));
            commonVideoBean.b(jSONObject.optString("columncode"));
            commonVideoBean.l(jSONObject.optString("posterfilelist"));
            commonVideoBean.n(jSONObject.optString("posterpath"));
            commonVideoBean.y(jSONObject.optString("sortnum"));
            commonVideoBean.g(jSONObject.optString("elapsedtime"));
            commonVideoBean.E(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_WGKEYWORDS));
            commonVideoBean.x(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_SHORTTITLE));
            commonVideoBean.t(jSONObject.optString("ratingsum"));
            commonVideoBean.s(jSONObject.optString("ratingnum"));
            commonVideoBean.z(jSONObject.optString("starlevel"));
            commonVideoBean.b(jSONObject.optString("columncode"));
            commonVideoBean.A(jSONObject.optString("telcomcode"));
            commonVideoBean.B(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_UPDATENNUM));
            commonVideoBean.v(jSONObject.optString("seriesnum"));
            commonVideoBean.C(jSONObject.optString("vrflag"));
            commonVideoBean.D(jSONObject.optString("vrtype"));
            commonVideoBean.m(jSONObject.optString("posterimage"));
            commonVideoBean.h(jSONObject.optString("favoritetype"));
            commonVideoBean.w(jSONObject.optString("seriesprogramcode"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commonVideoBean;
    }
}
