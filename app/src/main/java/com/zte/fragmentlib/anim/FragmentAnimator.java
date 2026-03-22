package com.zte.fragmentlib.anim;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class FragmentAnimator implements Parcelable {
    public static final Parcelable.Creator<FragmentAnimator> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    protected int f4050a;

    /* renamed from: b, reason: collision with root package name */
    protected int f4051b;

    /* renamed from: c, reason: collision with root package name */
    protected int f4052c;

    /* renamed from: d, reason: collision with root package name */
    protected int f4053d;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<FragmentAnimator> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FragmentAnimator createFromParcel(Parcel parcel) {
            return new FragmentAnimator(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FragmentAnimator[] newArray(int i) {
            return new FragmentAnimator[i];
        }
    }

    public FragmentAnimator() {
    }

    public int a() {
        return this.f4050a;
    }

    public int b() {
        return this.f4051b;
    }

    public int c() {
        return this.f4052c;
    }

    public int d() {
        return this.f4053d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4050a);
        parcel.writeInt(this.f4051b);
        parcel.writeInt(this.f4052c);
        parcel.writeInt(this.f4053d);
    }

    public FragmentAnimator(int i, int i2, int i3, int i4) {
        this.f4050a = i;
        this.f4051b = i2;
        this.f4052c = i3;
        this.f4053d = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentAnimator(Parcel parcel) {
        this.f4050a = parcel.readInt();
        this.f4051b = parcel.readInt();
        this.f4052c = parcel.readInt();
        this.f4053d = parcel.readInt();
    }
}
