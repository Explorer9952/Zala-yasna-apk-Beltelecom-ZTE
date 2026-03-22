package com.zte.iptvclient.android.common.javabean.column;

import android.os.Parcel;
import android.os.Parcelable;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VideoThirdColumnBean implements Parcelable {
    public static final Parcelable.Creator<VideoThirdColumnBean> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f4724a;

    /* renamed from: b, reason: collision with root package name */
    private String f4725b;

    /* renamed from: c, reason: collision with root package name */
    private String f4726c;

    /* renamed from: d, reason: collision with root package name */
    private String f4727d;
    private String e;
    private String f;
    private String g;
    private String h;
    private boolean i;
    private ArrayList<CommonVideoBean> j;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<VideoThirdColumnBean> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoThirdColumnBean createFromParcel(Parcel parcel) {
            return new VideoThirdColumnBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoThirdColumnBean[] newArray(int i) {
            return new VideoThirdColumnBean[i];
        }
    }

    public VideoThirdColumnBean() {
        this.i = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "VideoThirdColumnBean{columnname='" + this.f4724a + "', columncode='" + this.f4725b + "', telecomcode='" + this.f4726c + "', parentcode='" + this.f4727d + "', columntype='" + this.e + "', subexist='" + this.f + "', sortnum='" + this.g + "', systemlimitenable='" + this.h + "', isUnlock=" + this.i + ", subeVideoList=" + this.j + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4724a);
        parcel.writeString(this.f4725b);
        parcel.writeString(this.f4726c);
        parcel.writeString(this.f4727d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.j);
    }

    protected VideoThirdColumnBean(Parcel parcel) {
        this.i = false;
        this.f4724a = parcel.readString();
        this.f4725b = parcel.readString();
        this.f4726c = parcel.readString();
        this.f4727d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readByte() != 0;
        this.j = parcel.createTypedArrayList(CommonVideoBean.CREATOR);
    }
}
