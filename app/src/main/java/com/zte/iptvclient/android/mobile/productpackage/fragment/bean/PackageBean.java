package com.zte.iptvclient.android.mobile.productpackage.fragment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class PackageBean implements Parcelable {
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;

    /* renamed from: a, reason: collision with root package name */
    private String f7037a;

    /* renamed from: b, reason: collision with root package name */
    private String f7038b;

    /* renamed from: c, reason: collision with root package name */
    private String f7039c;

    /* renamed from: d, reason: collision with root package name */
    private String f7040d;
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
    private static String F = PackageBean.class.getSimpleName();
    public static final Parcelable.Creator<PackageBean> CREATOR = new a();

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<PackageBean> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PackageBean createFromParcel(Parcel parcel) {
            return new PackageBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PackageBean[] newArray(int i) {
            return new PackageBean[i];
        }
    }

    public PackageBean() {
    }

    public void A(String str) {
        this.y = str;
    }

    public void B(String str) {
        this.x = str;
    }

    public void C(String str) {
        this.r = str;
    }

    public void D(String str) {
        this.n = str;
    }

    public void E(String str) {
        this.E = str;
    }

    public String a() {
        return this.o;
    }

    public String b() {
        return this.p;
    }

    public void c(String str) {
        this.B = str;
    }

    public void d(String str) {
        this.t = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(String str) {
        this.w = str;
    }

    public String f() {
        return this.q;
    }

    public void g(String str) {
        this.z = str;
    }

    public void h(String str) {
        this.f7038b = str;
    }

    public String i() {
        return this.g;
    }

    public void j(String str) {
        this.h = str;
    }

    public String k() {
        return this.f7039c;
    }

    public void l(String str) {
        this.q = str;
    }

    public void m(String str) {
        this.f = str;
    }

    public void n(String str) {
        this.C = str;
    }

    public String o() {
        return this.E;
    }

    public void p(String str) {
        this.g = str;
    }

    public void q(String str) {
        this.i = str;
    }

    public void r(String str) {
        this.D = str;
    }

    public void s(String str) {
        this.m = str;
    }

    public void t(String str) {
        this.A = str;
    }

    public String toString() {
        return "PackageBean{productcode='" + this.f7037a + "', createtime='" + this.f7038b + "', price='" + this.f7039c + "', detaildesc='" + this.f7040d + "', iscontinue='" + this.e + "', epgorder='" + this.f + "', issubscribe='" + this.g + "', cycunit='" + this.h + "', limittimes='" + this.i + "', cycparam='" + this.j + "', producttype='" + this.k + "', productname='" + this.l + "', posterfilelist='" + this.m + "', totalcount='" + this.n + "', autocontinue='" + this.o + "', begintime='" + this.p + "', endtime='" + this.q + "', status='" + this.r + "', contentname='" + this.s + "', columncode='" + this.t + "', programcode='" + this.u + "', programtype='" + this.v + "', contentcode='" + this.w + "', seriesprogramcode='" + this.x + "', seriesnum='" + this.y + "', contentprodtype='" + this.z + "', posterpath='" + this.A + "', cdrtype='" + this.B + "', feecost='" + this.C + "', paytype='" + this.D + "'}";
    }

    public void u(String str) {
        this.f7039c = str;
    }

    public void v(String str) {
        this.f7037a = str;
    }

    public void w(String str) {
        this.l = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7037a);
        parcel.writeString(this.f7038b);
        parcel.writeString(this.f7039c);
        parcel.writeString(this.f7040d);
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
    }

    public void x(String str) {
        this.k = str;
    }

    public void y(String str) {
        this.u = str;
    }

    public void z(String str) {
        this.v = str;
    }

    protected PackageBean(Parcel parcel) {
        this.f7037a = parcel.readString();
        this.f7038b = parcel.readString();
        this.f7039c = parcel.readString();
        this.f7040d = parcel.readString();
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
    }

    public void a(String str) {
        this.o = str;
    }

    public void b(String str) {
        this.p = str;
    }

    public String c() {
        return this.s;
    }

    public String d() {
        return this.h;
    }

    public String e() {
        return this.f7040d;
    }

    public void f(String str) {
        this.s = str;
    }

    public String g() {
        return this.f;
    }

    public String h() {
        return this.e;
    }

    public void i(String str) {
        this.j = str;
    }

    public String j() {
        return this.m;
    }

    public void k(String str) {
        this.f7040d = str;
    }

    public String l() {
        return this.f7037a;
    }

    public String m() {
        return this.l;
    }

    public String n() {
        return this.k;
    }

    public void o(String str) {
        this.e = str;
    }

    public static PackageBean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        PackageBean packageBean = new PackageBean();
        try {
            packageBean.v(jSONObject.optString("productcode"));
            packageBean.h(jSONObject.optString("createtime"));
            packageBean.u(jSONObject.optString("price"));
            packageBean.k(jSONObject.optString(ParamConst.ORDERED_PRODUCT_QUERY_RSP_DETAILDESC));
            packageBean.o(jSONObject.optString(ParamConst.ORDERED_PRODUCT_QUERY_RSP_ISCONTINUE));
            packageBean.m(jSONObject.optString(ParamConst.ORDERED_PRODUCT_QUERY_RSP_IF_EPGORDER));
            packageBean.p(jSONObject.optString(ParamConst.ORDERED_PRODUCT_QUERY_RSP_ISSUBSCIBE));
            packageBean.j(jSONObject.optString(ParamConst.ORDERED_PRODUCT_QUERY_RSP_CYCUNIT));
            packageBean.q(jSONObject.optString("limittimes"));
            packageBean.i(jSONObject.optString(ParamConst.ORDERED_PRODUCT_QUERY_RSP_CYCPARAM));
            packageBean.x(jSONObject.optString("producttype"));
            packageBean.w(jSONObject.optString("productname"));
            packageBean.s(jSONObject.optString("posterfilelist"));
            packageBean.D(jSONObject.optString("totalcount"));
            packageBean.a(jSONObject.optString(ParamConst.ORDERED_SVOD_HISTORY_QUERY_RSP_AUTOCONTINUE));
            packageBean.b(jSONObject.optString("begintime"));
            packageBean.l(jSONObject.optString("endtime"));
            packageBean.C(jSONObject.optString("status"));
            packageBean.f(jSONObject.optString("contentname"));
            packageBean.d(jSONObject.optString("columncode"));
            packageBean.y(jSONObject.optString("programcode"));
            packageBean.z(jSONObject.optString("programtype"));
            packageBean.e(jSONObject.optString("contentcode"));
            packageBean.B(jSONObject.optString("seriesprogramcode"));
            packageBean.A(jSONObject.optString("seriesnum"));
            packageBean.g(jSONObject.optString("contentprodtype"));
            packageBean.t(jSONObject.optString("posterpath"));
            packageBean.E(jSONObject.optString("unsubvalidday"));
            packageBean.c(jSONObject.optString("cdrtype"));
            packageBean.n(jSONObject.optString(ParamConst.ORDERED_PPV_HISTORY_QUERY_RSP_FEECOST));
            packageBean.r(jSONObject.optString("paytype"));
        } catch (Exception e) {
            LogEx.e(F, e.getMessage());
        }
        return packageBean;
    }
}
