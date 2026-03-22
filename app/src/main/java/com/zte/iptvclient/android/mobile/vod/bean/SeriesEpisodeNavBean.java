package com.zte.iptvclient.android.mobile.vod.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class SeriesEpisodeNavBean implements Parcelable {
    public static final Parcelable.Creator<SeriesEpisodeNavBean> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f7627a;

    /* renamed from: b, reason: collision with root package name */
    private int f7628b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<String> f7629c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<String> f7630d;
    private int e;

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<SeriesEpisodeNavBean> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SeriesEpisodeNavBean createFromParcel(Parcel parcel) {
            return new SeriesEpisodeNavBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SeriesEpisodeNavBean[] newArray(int i) {
            return new SeriesEpisodeNavBean[i];
        }
    }

    public SeriesEpisodeNavBean() {
    }

    public int a() {
        return this.f7628b;
    }

    public void b(int i) {
        this.f7627a = i;
    }

    public ArrayList<String> c() {
        return this.f7630d;
    }

    public int d() {
        return this.f7627a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.e;
    }

    public String toString() {
        return "SeriesEpisodeNavBean{seriesAllNum=" + this.f7627a + ", breakpoint=" + this.f7628b + ", episodeNavList=" + this.f7629c + ", episodePadList=" + this.f7630d + ", mCurNavPosition=" + this.e + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7627a);
        parcel.writeInt(this.f7628b);
        parcel.writeStringList(this.f7629c);
        parcel.writeStringList(this.f7630d);
        parcel.writeInt(this.e);
    }

    protected SeriesEpisodeNavBean(Parcel parcel) {
        this.f7627a = parcel.readInt();
        this.f7628b = parcel.readInt();
        this.f7629c = parcel.createStringArrayList();
        this.f7630d = parcel.createStringArrayList();
        this.e = parcel.readInt();
    }

    public void a(int i) {
        this.f7628b = i;
    }

    public ArrayList<String> b() {
        return this.f7629c;
    }

    public void c(int i) {
        this.e = i;
    }

    public void a(ArrayList<String> arrayList) {
        this.f7629c = arrayList;
    }

    public void b(ArrayList<String> arrayList) {
        this.f7630d = arrayList;
    }
}
