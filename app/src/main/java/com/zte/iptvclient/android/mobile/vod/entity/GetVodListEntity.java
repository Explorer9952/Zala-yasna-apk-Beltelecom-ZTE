package com.zte.iptvclient.android.mobile.vod.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class GetVodListEntity implements Parcelable {
    public static final Parcelable.Creator<GetVodListEntity> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f7635a;

    /* renamed from: b, reason: collision with root package name */
    public int f7636b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7637c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7638d;
    public ArrayList<GetVodListItemEntity> e;

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<GetVodListEntity> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetVodListEntity createFromParcel(Parcel parcel) {
            return new GetVodListEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetVodListEntity[] newArray(int i) {
            return new GetVodListEntity[i];
        }
    }

    public GetVodListEntity() {
        this.e = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7635a);
        parcel.writeInt(this.f7636b);
        parcel.writeByte(this.f7637c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7638d ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.e);
    }

    protected GetVodListEntity(Parcel parcel) {
        this.e = new ArrayList<>();
        this.f7635a = parcel.readInt();
        this.f7636b = parcel.readInt();
        this.f7637c = parcel.readByte() != 0;
        this.f7638d = parcel.readByte() != 0;
        this.e = parcel.createTypedArrayList(GetVodListItemEntity.CREATOR);
    }
}
