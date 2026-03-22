package com.zte.iptvclient.android.common.javabean.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.video.androidsdk.common.http.HttpConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.ParamConst;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MultiDefinitionURLBean implements Parcelable {
    public static final Parcelable.Creator<MultiDefinitionURLBean> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f4748a;

    /* renamed from: b, reason: collision with root package name */
    private String f4749b;

    /* renamed from: c, reason: collision with root package name */
    private String f4750c;

    /* renamed from: d, reason: collision with root package name */
    private String f4751d;
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

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<MultiDefinitionURLBean> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MultiDefinitionURLBean createFromParcel(Parcel parcel) {
            return new MultiDefinitionURLBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MultiDefinitionURLBean[] newArray(int i) {
            return new MultiDefinitionURLBean[i];
        }
    }

    public MultiDefinitionURLBean() {
    }

    public String a() {
        return this.i;
    }

    public String b() {
        return this.l;
    }

    public String c() {
        return this.m;
    }

    public String d() {
        return this.h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.f4750c;
    }

    public void g(String str) {
        this.j = str;
    }

    public void h(String str) {
        this.k = str;
    }

    public String i() {
        if (SDKLoginMgr.getInstance().getEPGHome() == null) {
            return "";
        }
        if (SDKLoginMgr.getInstance().getEPGHome().startsWith(HttpConstant.PROTOCOL_HTTPS)) {
            return this.f4749b;
        }
        return this.f4748a;
    }

    public String j() {
        return this.e;
    }

    public String k() {
        return this.o;
    }

    public void l(String str) {
        this.g = str;
    }

    public void m(String str) {
        this.n = str;
    }

    public void n(String str) {
        this.f4748a = str;
    }

    public void o(String str) {
        this.f4751d = str;
    }

    public void p(String str) {
        this.e = str;
    }

    public void q(String str) {
        this.o = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4748a);
        parcel.writeString(this.f4749b);
        parcel.writeString(this.f4750c);
        parcel.writeString(this.f4751d);
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
    }

    protected MultiDefinitionURLBean(Parcel parcel) {
        this.f4748a = parcel.readString();
        this.f4749b = parcel.readString();
        this.f4750c = parcel.readString();
        this.f4751d = parcel.readString();
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
    }

    public void a(String str) {
        this.i = str;
    }

    public void b(String str) {
        this.l = str;
    }

    public void c(String str) {
        this.m = str;
    }

    public void d(String str) {
        this.h = str;
    }

    public void e(String str) {
        this.f = str;
    }

    public void f(String str) {
        this.f4750c = str;
    }

    public String g() {
        return this.p;
    }

    public String h() {
        return this.n;
    }

    public void j(String str) {
        this.p = str;
    }

    public void k(String str) {
        this.f4749b = str;
    }

    public void l() {
        LogEx.d("MultiDefinitionURLBean", "---setGenrelockByGenreidlist---");
        boolean a2 = com.zte.iptvclient.android.mobile.e0.f.c.a();
        LogEx.d("MultiDefinitionURLBean", "---setGenrelockByGenreidlist---isGenreLockByGenreIdList开关: " + a2);
        if (a2) {
            j("0");
            String str = this.q;
            if (str != null) {
                String[] split = str.split(";");
                LogEx.d("MultiDefinitionURLBean", "---setGenrelockByGenreidlist---genreids: " + Arrays.asList(split));
                ArrayList<String> b2 = com.zte.iptvclient.android.common.j.k.i().b();
                LogEx.d("MultiDefinitionURLBean", "---setGenrelockByGenreidlist---genre锁: " + b2);
                for (String str2 : split) {
                    if (b2.contains(str2)) {
                        LogEx.d("MultiDefinitionURLBean", "---setGenrelockByGenreidlist---成功设置genre锁by " + str2);
                        j("1");
                        return;
                    }
                }
            }
        }
    }

    public static MultiDefinitionURLBean a(JSONObject jSONObject) {
        MultiDefinitionURLBean multiDefinitionURLBean = new MultiDefinitionURLBean();
        try {
            multiDefinitionURLBean.n(jSONObject.optString("playurl"));
            multiDefinitionURLBean.k(jSONObject.optString("httpsplayurl"));
            multiDefinitionURLBean.f(jSONObject.optString("definition"));
            multiDefinitionURLBean.o(jSONObject.optString("programcode"));
            multiDefinitionURLBean.p(jSONObject.optString("programtype"));
            multiDefinitionURLBean.e(jSONObject.optString("contentcode"));
            multiDefinitionURLBean.l(jSONObject.optString("iplimitflag"));
            multiDefinitionURLBean.d(jSONObject.optString("columncode"));
            multiDefinitionURLBean.a(jSONObject.optString(ParamConst.VOD_MULTIPLE_URL_RSP_AUTH_RETURNCODE));
            multiDefinitionURLBean.g(jSONObject.optString(ParamConst.AUTH_RSP_EFFECTIVEDATE));
            multiDefinitionURLBean.h(jSONObject.optString("expiredtime"));
            multiDefinitionURLBean.b(jSONObject.optString("breakpoint"));
            multiDefinitionURLBean.c(jSONObject.optString("cmsid"));
            multiDefinitionURLBean.m(jSONObject.optString("physicalcontentid"));
            multiDefinitionURLBean.q(jSONObject.optString("systemlimitenable"));
            multiDefinitionURLBean.j(jSONObject.optString("genrelock"));
            multiDefinitionURLBean.i(jSONObject.optString("genreidlist"));
            multiDefinitionURLBean.l();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return multiDefinitionURLBean;
    }

    public void i(String str) {
        this.q = str;
    }
}
