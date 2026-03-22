package com.zte.iptvclient.android.mobile.vod.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class GetVodSearchArrayEntity implements Parcelable {
    public static final Parcelable.Creator<GetVodSearchArrayEntity> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f7643a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<CommonVideoBean> f7644b;

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<GetVodSearchArrayEntity> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetVodSearchArrayEntity createFromParcel(Parcel parcel) {
            return new GetVodSearchArrayEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetVodSearchArrayEntity[] newArray(int i) {
            return new GetVodSearchArrayEntity[i];
        }
    }

    public GetVodSearchArrayEntity() {
        this.f7644b = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7643a);
        parcel.writeTypedList(this.f7644b);
    }

    protected GetVodSearchArrayEntity(Parcel parcel) {
        this.f7644b = new ArrayList<>();
        this.f7643a = parcel.readInt();
        this.f7644b = parcel.createTypedArrayList(CommonVideoBean.CREATOR);
    }
}
