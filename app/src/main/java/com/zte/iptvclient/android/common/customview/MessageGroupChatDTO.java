package com.zte.iptvclient.android.common.customview;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class MessageGroupChatDTO implements Parcelable {
    public static final Parcelable.Creator<MessageGroupChatDTO> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f4129a;

    /* renamed from: b, reason: collision with root package name */
    private String f4130b;

    /* renamed from: c, reason: collision with root package name */
    private String f4131c;

    /* renamed from: d, reason: collision with root package name */
    private String f4132d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;
    private int l;
    private int m;
    private String n;
    private String o;
    private String p;
    private int q;
    private int r;
    private int s;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<MessageGroupChatDTO> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageGroupChatDTO createFromParcel(Parcel parcel) {
            return new MessageGroupChatDTO(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageGroupChatDTO[] newArray(int i) {
            return new MessageGroupChatDTO[i];
        }
    }

    public MessageGroupChatDTO() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4129a);
        parcel.writeString(this.f4130b);
        parcel.writeString(this.f4131c);
        parcel.writeString(this.f4132d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.g);
        parcel.writeInt(this.q);
        parcel.writeInt(this.r);
        parcel.writeInt(this.s);
    }

    public MessageGroupChatDTO(Parcel parcel) {
        this.f4129a = parcel.readString();
        this.f4130b = parcel.readString();
        this.f4131c = parcel.readString();
        this.f4132d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.g = parcel.readString();
        this.q = parcel.readInt();
        this.r = parcel.readInt();
        this.s = parcel.readInt();
    }
}
