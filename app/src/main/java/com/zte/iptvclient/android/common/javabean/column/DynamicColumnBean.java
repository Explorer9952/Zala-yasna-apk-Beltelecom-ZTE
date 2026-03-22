package com.zte.iptvclient.android.common.javabean.column;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DynamicColumnBean implements Parcelable {
    public static final Parcelable.Creator<DynamicColumnBean> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f4720a;

    /* renamed from: b, reason: collision with root package name */
    private String f4721b;

    /* renamed from: c, reason: collision with root package name */
    private String f4722c;

    /* renamed from: d, reason: collision with root package name */
    private String f4723d;
    private String e;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<DynamicColumnBean> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DynamicColumnBean createFromParcel(Parcel parcel) {
            return new DynamicColumnBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DynamicColumnBean[] newArray(int i) {
            return new DynamicColumnBean[i];
        }
    }

    public DynamicColumnBean() {
    }

    public void a(String str) {
        this.f4720a = str;
    }

    public void b(String str) {
        this.f4721b = str;
    }

    public void c(String str) {
        this.f4722c = str;
    }

    public void d(String str) {
        this.e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(String str) {
        this.f4723d = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4720a);
        parcel.writeString(this.f4721b);
        parcel.writeString(this.f4722c);
        parcel.writeString(this.f4723d);
        parcel.writeString(this.e);
    }

    protected DynamicColumnBean(Parcel parcel) {
        this.f4720a = parcel.readString();
        this.f4721b = parcel.readString();
        this.f4722c = parcel.readString();
        this.f4723d = parcel.readString();
        this.e = parcel.readString();
    }

    public static DynamicColumnBean a(JSONObject jSONObject) {
        DynamicColumnBean dynamicColumnBean = new DynamicColumnBean();
        if (jSONObject == null || TextUtils.isEmpty(jSONObject.optString("columncode")) || TextUtils.isEmpty(jSONObject.optString("columnname"))) {
            return null;
        }
        dynamicColumnBean.a(jSONObject.optString("columncode"));
        dynamicColumnBean.b(jSONObject.optString("columnname"));
        dynamicColumnBean.c(jSONObject.optString("operationname"));
        dynamicColumnBean.d(jSONObject.optString("operationtype"));
        dynamicColumnBean.e(jSONObject.optString("operationvalue"));
        return dynamicColumnBean;
    }
}
