package com.zte.iptvclient.android.mobile.npvr.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class GetNpvrPlayUrlEntity implements Parcelable {
    public static final Parcelable.Creator<GetNpvrPlayUrlEntity> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f6885a;

    /* renamed from: b, reason: collision with root package name */
    public String f6886b;

    /* renamed from: c, reason: collision with root package name */
    public int f6887c;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<GetNpvrPlayUrlEntity> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetNpvrPlayUrlEntity createFromParcel(Parcel parcel) {
            return new GetNpvrPlayUrlEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetNpvrPlayUrlEntity[] newArray(int i) {
            return new GetNpvrPlayUrlEntity[i];
        }
    }

    public GetNpvrPlayUrlEntity() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6885a);
        parcel.writeString(this.f6886b);
        parcel.writeInt(this.f6887c);
    }

    protected GetNpvrPlayUrlEntity(Parcel parcel) {
        this.f6885a = parcel.readString();
        this.f6886b = parcel.readString();
        this.f6887c = parcel.readInt();
    }
}
