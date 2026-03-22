package com.zte.iptvclient.android.mobile.history.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.video.androidsdk.service.comm.ParamConst;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class WatchHistoryEntity implements Parcelable {
    public static final Parcelable.Creator<WatchHistoryEntity> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6393a;

    /* renamed from: b, reason: collision with root package name */
    private String f6394b;

    /* renamed from: c, reason: collision with root package name */
    private String f6395c;

    /* renamed from: d, reason: collision with root package name */
    private String f6396d;
    private String e;
    private String f;
    private String g;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<WatchHistoryEntity> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WatchHistoryEntity createFromParcel(Parcel parcel) {
            return new WatchHistoryEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WatchHistoryEntity[] newArray(int i) {
            return new WatchHistoryEntity[i];
        }
    }

    public WatchHistoryEntity() {
    }

    public String a() {
        return this.f6393a;
    }

    public String b() {
        return this.f6394b;
    }

    public String c() {
        return this.f6395c;
    }

    public String d() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.f6396d;
    }

    public String g() {
        return this.f;
    }

    public String toString() {
        return "WatchHistoryEntity{contentcode='" + this.f6393a + "', contentname='" + this.f6394b + "', contenttype='" + this.f6395c + "', playtime='" + this.f6396d + "', duration='" + this.e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6393a);
        parcel.writeString(this.f6394b);
        parcel.writeString(this.f6395c);
        parcel.writeString(this.f6396d);
        parcel.writeString(this.e);
    }

    protected WatchHistoryEntity(Parcel parcel) {
        this.f6393a = parcel.readString();
        this.f6394b = parcel.readString();
        this.f6395c = parcel.readString();
        this.f6396d = parcel.readString();
        this.e = parcel.readString();
    }

    public void a(String str) {
        this.f6393a = str;
    }

    public void b(String str) {
        this.f6394b = str;
    }

    public void c(String str) {
        this.f6395c = str;
    }

    public void d(String str) {
        this.g = str;
    }

    public void e(String str) {
        this.e = str;
    }

    public void f(String str) {
        this.f6396d = str;
    }

    public void g(String str) {
        this.f = str;
    }

    public static WatchHistoryEntity a(JSONObject jSONObject) {
        WatchHistoryEntity watchHistoryEntity = new WatchHistoryEntity();
        watchHistoryEntity.a(jSONObject.optString("contentcode"));
        watchHistoryEntity.b(jSONObject.optString("contentname"));
        watchHistoryEntity.c(jSONObject.optString("contenttype"));
        watchHistoryEntity.f(jSONObject.optString("playtime"));
        watchHistoryEntity.e(jSONObject.optString(ParamConst.NPVR_QUERY_RSP_DURATION));
        return watchHistoryEntity;
    }
}
