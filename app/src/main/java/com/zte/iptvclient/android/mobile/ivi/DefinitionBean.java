package com.zte.iptvclient.android.mobile.ivi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class DefinitionBean implements Parcelable {
    public static final Parcelable.Creator<DefinitionBean> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6588a;

    /* renamed from: b, reason: collision with root package name */
    private String f6589b;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<DefinitionBean> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefinitionBean createFromParcel(Parcel parcel) {
            DefinitionBean definitionBean = new DefinitionBean();
            definitionBean.a(parcel.readString());
            definitionBean.b(parcel.readString());
            return definitionBean;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefinitionBean[] newArray(int i) {
            return new DefinitionBean[i];
        }
    }

    public String a() {
        return this.f6588a;
    }

    public String b() {
        return this.f6589b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6588a);
        parcel.writeString(this.f6589b);
    }

    public void a(String str) {
        this.f6588a = str;
    }

    public void b(String str) {
        this.f6589b = str;
    }
}
