package com.zte.iptvclient.android.mobile.user.fragment;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class TerminalBindList implements Parcelable {
    public static final Parcelable.Creator<TerminalBindList> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    String f7405a;

    /* renamed from: b, reason: collision with root package name */
    String f7406b;

    /* renamed from: c, reason: collision with root package name */
    String f7407c;

    /* renamed from: d, reason: collision with root package name */
    String f7408d;
    String e;
    String f;
    boolean g;

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<TerminalBindList> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TerminalBindList createFromParcel(Parcel parcel) {
            return new TerminalBindList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TerminalBindList[] newArray(int i) {
            return new TerminalBindList[i];
        }
    }

    public TerminalBindList() {
    }

    public String a() {
        return this.f7405a;
    }

    public String b() {
        return this.f7406b;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.f7408d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f7407c;
    }

    public void f(String str) {
        this.e = str;
    }

    public String toString() {
        return "TerminalBindList{binddeviceid='" + this.f7405a + "', bindterminaltype='" + this.f7406b + "', stbmac='" + this.f7407c + "', stbcode='" + this.f7408d + "', updatetime='" + this.e + "', deviceinfo='" + this.f + "', isMasterProfile=" + this.g + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7405a);
        parcel.writeString(this.f7406b);
        parcel.writeString(this.f7407c);
        parcel.writeString(this.f7408d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
    }

    protected TerminalBindList(Parcel parcel) {
        this.f7405a = parcel.readString();
        this.f7406b = parcel.readString();
        this.f7407c = parcel.readString();
        this.f7408d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readByte() != 0;
    }

    public void a(String str) {
        this.f7405a = str;
    }

    public void b(String str) {
        this.f7406b = str;
    }

    public void c(String str) {
        this.f = str;
    }

    public void d(String str) {
        this.f7408d = str;
    }

    public void e(String str) {
        this.f7407c = str;
    }

    public void a(boolean z) {
        this.g = z;
    }
}
