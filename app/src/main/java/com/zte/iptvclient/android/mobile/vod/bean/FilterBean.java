package com.zte.iptvclient.android.mobile.vod.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class FilterBean implements Parcelable {
    public static final Parcelable.Creator<FilterBean> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f7625a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f7626b;

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<FilterBean> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FilterBean createFromParcel(Parcel parcel) {
            return new FilterBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FilterBean[] newArray(int i) {
            return new FilterBean[i];
        }
    }

    protected FilterBean(Parcel parcel) {
        this.f7625a = parcel.readString();
        this.f7626b = parcel.readByte() != 0;
    }

    public String a() {
        return this.f7625a;
    }

    public boolean b() {
        return this.f7626b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7625a);
        parcel.writeByte(this.f7626b ? (byte) 1 : (byte) 0);
    }

    public void a(boolean z) {
        this.f7626b = z;
    }

    public FilterBean() {
    }

    public FilterBean(String str) {
        this.f7625a = str;
    }
}
