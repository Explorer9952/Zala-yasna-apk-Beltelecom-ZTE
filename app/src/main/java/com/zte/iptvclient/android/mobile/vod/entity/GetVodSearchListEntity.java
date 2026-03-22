package com.zte.iptvclient.android.mobile.vod.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.zte.iptvclient.android.common.javabean.column.VideoThirdColumnBean;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class GetVodSearchListEntity implements Parcelable {
    public static final Parcelable.Creator<GetVodSearchListEntity> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f7645a;

    /* renamed from: b, reason: collision with root package name */
    public int f7646b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7647c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7648d;
    public ArrayList<VideoThirdColumnBean> e;
    public ArrayList<CommonVideoBean> f;

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<GetVodSearchListEntity> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetVodSearchListEntity createFromParcel(Parcel parcel) {
            return new GetVodSearchListEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetVodSearchListEntity[] newArray(int i) {
            return new GetVodSearchListEntity[i];
        }
    }

    public GetVodSearchListEntity() {
        this.e = new ArrayList<>();
        this.f = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7645a);
        parcel.writeInt(this.f7646b);
        parcel.writeByte(this.f7647c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7648d ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.e);
        parcel.writeTypedList(this.f);
    }

    protected GetVodSearchListEntity(Parcel parcel) {
        this.e = new ArrayList<>();
        this.f = new ArrayList<>();
        this.f7645a = parcel.readInt();
        this.f7646b = parcel.readInt();
        this.f7647c = parcel.readByte() != 0;
        this.f7648d = parcel.readByte() != 0;
        this.e = parcel.createTypedArrayList(VideoThirdColumnBean.CREATOR);
        this.f = parcel.createTypedArrayList(CommonVideoBean.CREATOR);
    }
}
