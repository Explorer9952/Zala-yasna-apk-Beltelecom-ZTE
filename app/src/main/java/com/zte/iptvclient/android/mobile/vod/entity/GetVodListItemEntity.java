package com.zte.iptvclient.android.mobile.vod.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.video.androidsdk.service.comm.ParamConst;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class GetVodListItemEntity implements Parcelable {
    public static final Parcelable.Creator<GetVodListItemEntity> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public boolean f7639a;

    /* renamed from: b, reason: collision with root package name */
    public String f7640b;

    /* renamed from: c, reason: collision with root package name */
    public String f7641c;

    /* renamed from: d, reason: collision with root package name */
    public String f7642d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public int q;

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<GetVodListItemEntity> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetVodListItemEntity createFromParcel(Parcel parcel) {
            return new GetVodListItemEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetVodListItemEntity[] newArray(int i) {
            return new GetVodListItemEntity[i];
        }
    }

    public GetVodListItemEntity() {
    }

    public static final GetVodListItemEntity a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        GetVodListItemEntity getVodListItemEntity = new GetVodListItemEntity();
        getVodListItemEntity.e = jSONObject.optString("programcode");
        getVodListItemEntity.f = jSONObject.optString("programname");
        getVodListItemEntity.p = jSONObject.optString("cpcode");
        getVodListItemEntity.g = jSONObject.optString("programtype");
        getVodListItemEntity.h = jSONObject.optString("contentcode");
        getVodListItemEntity.i = jSONObject.optString("seriesprogramcode");
        getVodListItemEntity.j = jSONObject.optString("seriesnum");
        getVodListItemEntity.k = jSONObject.optString("posterfilelist");
        getVodListItemEntity.l = jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_UPDATENNUM);
        getVodListItemEntity.m = jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_SHORTTITLE);
        getVodListItemEntity.n = jSONObject.optString("ratingid");
        getVodListItemEntity.o = jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_WGKEYWORDS);
        getVodListItemEntity.f7641c = jSONObject.optString("columncode");
        return getVodListItemEntity;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f7639a ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7640b);
        parcel.writeString(this.f7641c);
        parcel.writeString(this.f7642d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.p);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeInt(this.q);
    }

    protected GetVodListItemEntity(Parcel parcel) {
        this.f7639a = parcel.readByte() != 0;
        this.f7640b = parcel.readString();
        this.f7641c = parcel.readString();
        this.f7642d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.p = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.q = parcel.readInt();
    }

    public static final ArrayList<GetVodListItemEntity> a(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return null;
        }
        GetVodListItemEntity getVodListItemEntity = new GetVodListItemEntity();
        getVodListItemEntity.f7639a = true;
        getVodListItemEntity.f7640b = jSONObject.optString("columnname");
        getVodListItemEntity.f7641c = jSONObject.optString("columncode");
        getVodListItemEntity.f7642d = jSONObject.optString(ParamConst.COLUMN_INFO_RSP_PARENTCODE);
        getVodListItemEntity.q = -1;
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray == null) {
            return null;
        }
        int length = optJSONArray.length();
        ArrayList<GetVodListItemEntity> arrayList = new ArrayList<>(length + 1);
        arrayList.add(getVodListItemEntity);
        int i = z ? 16 : 6;
        for (int i2 = 0; i2 < length && i2 < i; i2++) {
            GetVodListItemEntity a2 = a(optJSONArray.optJSONObject(i2));
            if (a2 != null) {
                a2.q = i2;
                arrayList.add(a2);
            }
        }
        return arrayList;
    }
}
