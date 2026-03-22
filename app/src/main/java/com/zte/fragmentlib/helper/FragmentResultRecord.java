package com.zte.fragmentlib.helper;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class FragmentResultRecord implements Parcelable {
    public static final Parcelable.Creator<FragmentResultRecord> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f4062a;

    /* renamed from: b, reason: collision with root package name */
    public int f4063b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f4064c;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<FragmentResultRecord> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FragmentResultRecord createFromParcel(Parcel parcel) {
            return new FragmentResultRecord(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FragmentResultRecord[] newArray(int i) {
            return new FragmentResultRecord[i];
        }
    }

    public FragmentResultRecord() {
        this.f4063b = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4062a);
        parcel.writeInt(this.f4063b);
        parcel.writeBundle(this.f4064c);
    }

    protected FragmentResultRecord(Parcel parcel) {
        this.f4063b = 0;
        this.f4062a = parcel.readInt();
        this.f4063b = parcel.readInt();
        this.f4064c = parcel.readBundle();
    }
}
