package com.zte.iptvclient.android.mobile.vod.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class QueryStarRatingEntity implements Parcelable {
    public static final Parcelable.Creator<QueryStarRatingEntity> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f7649a;

    /* renamed from: b, reason: collision with root package name */
    public String f7650b;

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<QueryStarRatingEntity> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QueryStarRatingEntity createFromParcel(Parcel parcel) {
            return new QueryStarRatingEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QueryStarRatingEntity[] newArray(int i) {
            return new QueryStarRatingEntity[i];
        }
    }

    public QueryStarRatingEntity() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7649a);
        parcel.writeString(this.f7650b);
    }

    protected QueryStarRatingEntity(Parcel parcel) {
        this.f7649a = parcel.readString();
        this.f7650b = parcel.readString();
    }
}
