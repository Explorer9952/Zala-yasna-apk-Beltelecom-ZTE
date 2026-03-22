package com.zte.iptvclient.android.mobile.bookmark.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.video.androidsdk.service.comm.ParamConst;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ViewHistoryEntity implements Parcelable {
    public static final Parcelable.Creator<ViewHistoryEntity> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f5587a;

    /* renamed from: b, reason: collision with root package name */
    private String f5588b;

    /* renamed from: c, reason: collision with root package name */
    private String f5589c;

    /* renamed from: d, reason: collision with root package name */
    private String f5590d;
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

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<ViewHistoryEntity> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ViewHistoryEntity createFromParcel(Parcel parcel) {
            return new ViewHistoryEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ViewHistoryEntity[] newArray(int i) {
            return new ViewHistoryEntity[i];
        }
    }

    public ViewHistoryEntity() {
    }

    public String a() {
        return this.k;
    }

    public String b() {
        return this.f5590d;
    }

    public String c() {
        return this.p;
    }

    public void d(String str) {
        this.p = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f5587a;
    }

    public String f() {
        return this.f5588b;
    }

    public String g() {
        return this.f5589c;
    }

    public void h(String str) {
        this.f5587a = str;
    }

    public void i(String str) {
        this.f5588b = str;
    }

    public void j(String str) {
        this.f5589c = str;
    }

    public void k(String str) {
        this.g = str;
    }

    public void l(String str) {
        this.h = str;
    }

    public void m(String str) {
        this.e = str;
    }

    public void n(String str) {
        this.m = str;
    }

    public void o(String str) {
        this.n = str;
    }

    public void p(String str) {
        this.o = str;
    }

    public String toString() {
        return "ViewHistoryEntity{programcode='" + this.f5587a + "', programname='" + this.f5588b + "', cpcode='" + this.p + "', programtype='" + this.f5589c + "', contentcode='" + this.f5590d + "', seriesprogramcode='" + this.e + "', mediaservices='" + this.f + "', ratingid='" + this.g + "', seriesnum='" + this.h + "', posterfilelist='" + this.i + "', posterpath='" + this.j + "', columncode='" + this.k + "', advertisecontent='" + this.l + "', seriesseason='" + this.m + "', viewingtime='" + this.n + "', weekOrEarly='" + this.o + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5587a);
        parcel.writeString(this.f5588b);
        parcel.writeString(this.p);
        parcel.writeString(this.f5589c);
        parcel.writeString(this.f5590d);
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
    }

    protected ViewHistoryEntity(Parcel parcel) {
        this.f5587a = parcel.readString();
        this.f5588b = parcel.readString();
        this.p = parcel.readString();
        this.f5589c = parcel.readString();
        this.f5590d = parcel.readString();
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
    }

    public void a(String str) {
        this.l = str;
    }

    public void b(String str) {
        this.k = str;
    }

    public void c(String str) {
        this.f5590d = str;
    }

    public String d() {
        return this.i;
    }

    public void e(String str) {
        this.f = str;
    }

    public void f(String str) {
        this.i = str;
    }

    public void g(String str) {
        this.j = str;
    }

    public String h() {
        return this.g;
    }

    public String i() {
        return this.h;
    }

    public String j() {
        return this.e;
    }

    public String k() {
        return this.n;
    }

    public String l() {
        return this.o;
    }

    public static ViewHistoryEntity a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ViewHistoryEntity viewHistoryEntity = new ViewHistoryEntity();
        try {
            viewHistoryEntity.h(jSONObject.optString("programcode"));
            viewHistoryEntity.i(jSONObject.optString("programname"));
            viewHistoryEntity.d(jSONObject.optString("cpcode"));
            viewHistoryEntity.j(jSONObject.optString("programtype"));
            viewHistoryEntity.c(jSONObject.optString("contentcode"));
            viewHistoryEntity.m(jSONObject.optString("seriesprogramcode"));
            viewHistoryEntity.e(jSONObject.optString("mediaservices"));
            viewHistoryEntity.k(jSONObject.optString("ratingid"));
            viewHistoryEntity.l(jSONObject.optString("seriesnum"));
            viewHistoryEntity.f(jSONObject.optString("posterfilelist"));
            viewHistoryEntity.g(jSONObject.optString("posterpath"));
            viewHistoryEntity.b(jSONObject.optString("columncode"));
            viewHistoryEntity.a(jSONObject.optString("advertisecontent"));
            viewHistoryEntity.n(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_SERIESSEASON));
            viewHistoryEntity.o(jSONObject.optString("viewingtime"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return viewHistoryEntity;
    }
}
