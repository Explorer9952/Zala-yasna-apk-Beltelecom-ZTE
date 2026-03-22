package com.zte.iptvclient.android.mobile.vod.entity;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class GetUserStarRatingEntity implements Parcelable {
    public static final Parcelable.Creator<GetUserStarRatingEntity> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f7631a;

    /* renamed from: b, reason: collision with root package name */
    public String f7632b;

    /* renamed from: c, reason: collision with root package name */
    public String f7633c;

    /* renamed from: d, reason: collision with root package name */
    public String f7634d;

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<GetUserStarRatingEntity> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetUserStarRatingEntity createFromParcel(Parcel parcel) {
            return new GetUserStarRatingEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetUserStarRatingEntity[] newArray(int i) {
            return new GetUserStarRatingEntity[i];
        }
    }

    public GetUserStarRatingEntity() {
    }

    public static GetUserStarRatingEntity a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        GetUserStarRatingEntity getUserStarRatingEntity = new GetUserStarRatingEntity();
        getUserStarRatingEntity.f7631a = jSONObject.optString("ratingsum");
        getUserStarRatingEntity.f7632b = jSONObject.optString("ratingnum");
        getUserStarRatingEntity.f7633c = jSONObject.optString("ratingkinopoisk");
        getUserStarRatingEntity.f7634d = jSONObject.optString("ratingimdb");
        return getUserStarRatingEntity;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7631a);
        parcel.writeString(this.f7632b);
        parcel.writeString(this.f7633c);
        parcel.writeString(this.f7634d);
    }

    protected GetUserStarRatingEntity(Parcel parcel) {
        this.f7631a = parcel.readString();
        this.f7632b = parcel.readString();
        this.f7633c = parcel.readString();
        this.f7634d = parcel.readString();
    }
}
