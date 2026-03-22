package com.zte.iptvclient.android.mobile.user.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.zte.iptvclient.android.mobile.user.fragment.TerminalBindList;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class GetBindDeviceListEntity implements Parcelable {
    public static final Parcelable.Creator<GetBindDeviceListEntity> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f7403a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<TerminalBindList> f7404b;

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<GetBindDeviceListEntity> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetBindDeviceListEntity createFromParcel(Parcel parcel) {
            return new GetBindDeviceListEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetBindDeviceListEntity[] newArray(int i) {
            return new GetBindDeviceListEntity[i];
        }
    }

    public GetBindDeviceListEntity() {
        this.f7404b = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7403a);
        parcel.writeTypedList(this.f7404b);
    }

    protected GetBindDeviceListEntity(Parcel parcel) {
        this.f7404b = new ArrayList<>();
        this.f7403a = parcel.readInt();
        this.f7404b = parcel.createTypedArrayList(TerminalBindList.CREATOR);
    }
}
