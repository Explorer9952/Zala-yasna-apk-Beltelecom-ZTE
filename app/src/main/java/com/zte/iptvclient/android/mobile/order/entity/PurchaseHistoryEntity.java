package com.zte.iptvclient.android.mobile.order.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.iptvclient.android.common.k.x;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PurchaseHistoryEntity implements Parcelable, Comparable<PurchaseHistoryEntity> {
    public static final Parcelable.Creator<PurchaseHistoryEntity> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6941a;

    /* renamed from: b, reason: collision with root package name */
    private String f6942b;

    /* renamed from: c, reason: collision with root package name */
    private String f6943c;

    /* renamed from: d, reason: collision with root package name */
    private String f6944d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private boolean k;
    private ArrayList<PurchaseHistoryEntity> l;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<PurchaseHistoryEntity> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PurchaseHistoryEntity createFromParcel(Parcel parcel) {
            return new PurchaseHistoryEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PurchaseHistoryEntity[] newArray(int i) {
            return new PurchaseHistoryEntity[i];
        }
    }

    public PurchaseHistoryEntity() {
        this.l = new ArrayList<>();
    }

    public String a() {
        return this.f6942b;
    }

    public String b() {
        return this.i;
    }

    public String c() {
        return this.f6941a;
    }

    public String d() {
        return this.h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f6943c;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof PurchaseHistoryEntity) && compareTo((PurchaseHistoryEntity) obj) == 0;
    }

    public String f() {
        return this.f6944d;
    }

    public void g(String str) {
        this.e = str;
    }

    public String h() {
        return this.e;
    }

    public int hashCode() {
        if (TextUtils.isEmpty(this.f6942b)) {
            return super.hashCode();
        }
        return this.f6942b.intern().hashCode();
    }

    public void i(String str) {
        this.f = str;
    }

    public String j() {
        return this.f;
    }

    public String k() {
        return this.j;
    }

    public boolean l() {
        return this.k;
    }

    public String toString() {
        return "PurchaseHistoryEntity{contentname='" + this.f6941a + "', begintime='" + this.f6942b + "', endtime='" + this.f6943c + "', feecost='" + this.f6944d + "', posterpath='" + this.e + "', showDate='" + this.j + "', isExpand=" + this.k + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6941a);
        parcel.writeString(this.f6942b);
        parcel.writeString(this.f6943c);
        parcel.writeString(this.f6944d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.l);
    }

    public void a(String str) {
        this.f6942b = str;
    }

    public void b(String str) {
        this.i = str;
    }

    public void c(String str) {
        this.f6941a = str;
    }

    public void d(String str) {
        this.h = str;
    }

    public void e(String str) {
        this.f6943c = str;
    }

    public void f(String str) {
        this.f6944d = str;
    }

    public ArrayList<PurchaseHistoryEntity> g() {
        return this.l;
    }

    public void h(String str) {
        this.g = str;
    }

    public String i() {
        return this.g;
    }

    public void j(String str) {
        this.j = str;
    }

    protected PurchaseHistoryEntity(Parcel parcel) {
        this.l = new ArrayList<>();
        this.f6941a = parcel.readString();
        this.f6942b = parcel.readString();
        this.f6943c = parcel.readString();
        this.f6944d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readByte() != 0;
        this.l = parcel.createTypedArrayList(CREATOR);
    }

    public void a(boolean z) {
        this.k = z;
    }

    public static final PurchaseHistoryEntity a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        PurchaseHistoryEntity purchaseHistoryEntity = new PurchaseHistoryEntity();
        try {
            purchaseHistoryEntity.c(jSONObject.optString("contentname"));
            purchaseHistoryEntity.a(jSONObject.optString("begintime"));
            purchaseHistoryEntity.e(jSONObject.optString("endtime"));
            purchaseHistoryEntity.f(jSONObject.optString(ParamConst.ORDERED_PPV_HISTORY_QUERY_RSP_FEECOST));
            purchaseHistoryEntity.g(jSONObject.optString("posterpath"));
            purchaseHistoryEntity.i(jSONObject.optString("programtype"));
            purchaseHistoryEntity.h(jSONObject.optString("programcode"));
            purchaseHistoryEntity.d(jSONObject.optString("cpcode"));
            purchaseHistoryEntity.b(jSONObject.optString("contentcode"));
        } catch (Exception e) {
            e.printStackTrace();
            LogEx.e("PurchaseHistoryEntity", e.getMessage());
        }
        return purchaseHistoryEntity;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(PurchaseHistoryEntity purchaseHistoryEntity) {
        if (TextUtils.isEmpty(purchaseHistoryEntity.a()) || TextUtils.isEmpty(a())) {
            return 0;
        }
        return x.f(purchaseHistoryEntity.a()).compareTo(x.f(a()));
    }
}
