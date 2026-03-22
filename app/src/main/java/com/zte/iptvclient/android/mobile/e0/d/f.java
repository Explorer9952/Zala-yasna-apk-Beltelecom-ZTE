package com.zte.iptvclient.android.mobile.e0.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.i;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;

/* compiled from: AdapterSeriesSeasonPhone.java */
/* loaded from: classes2.dex */
public class f extends com.zte.iptvclient.common.uiframe.c {

    /* renamed from: d, reason: collision with root package name */
    private Context f5818d;
    private ArrayList<com.zte.iptvclient.android.mobile.vod.entity.a> e;
    private LayoutInflater f;

    /* compiled from: AdapterSeriesSeasonPhone.java */
    /* loaded from: classes2.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        TextView f5819a;

        /* renamed from: b, reason: collision with root package name */
        TextView f5820b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f5821c;

        a() {
        }
    }

    public f(Context context, ArrayList<com.zte.iptvclient.android.mobile.vod.entity.a> arrayList) {
        super(context);
        this.f5818d = context;
        this.e = arrayList;
        this.f = LayoutInflater.from(context);
    }

    public void a(int i) {
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            this.e.get(i2).a(false);
        }
        this.e.get(i).a(true);
        a();
    }

    @Override // com.zte.iptvclient.common.uiframe.c, android.widget.Adapter
    public int getCount() {
        ArrayList<com.zte.iptvclient.android.mobile.vod.entity.a> arrayList = this.e;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // com.zte.iptvclient.common.uiframe.c, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f.inflate(R.layout.item_series_season_phone, (ViewGroup) null);
            aVar = new a();
            aVar.f5819a = (TextView) view.findViewById(R.id.season_title_num_txt);
            aVar.f5820b = (TextView) view.findViewById(R.id.season_title_name_txt);
            aVar.f5821c = (ImageView) view.findViewById(R.id.iv_season_poster_thumb);
            com.zte.iptvclient.common.uiframe.f.a(view);
            com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_item_season_container));
            com.zte.iptvclient.common.uiframe.f.a(aVar.f5819a);
            com.zte.iptvclient.common.uiframe.f.a(aVar.f5820b);
            com.zte.iptvclient.common.uiframe.f.a(aVar.f5821c);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.zte.iptvclient.android.mobile.vod.entity.a item = getItem(i);
        String e = item.e();
        if (!TextUtils.isEmpty(e) && !"0".equals(e)) {
            aVar.f5819a.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_season) + " " + e);
        } else {
            aVar.f5819a.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_season));
        }
        aVar.f5820b.setText(item.d());
        if (item.f()) {
            aVar.f5819a.setSelected(true);
            aVar.f5820b.setSelected(true);
        } else {
            aVar.f5819a.setSelected(false);
            aVar.f5820b.setSelected(false);
        }
        com.bumptech.glide.d<String> a2 = i.b(this.f5818d).a(com.zte.iptvclient.android.common.k.g.a(3, item.b()));
        a2.b(R.drawable.default_poster_thumb);
        a2.a(R.drawable.default_poster_thumb);
        a2.c(300);
        a2.a(aVar.f5821c);
        return view;
    }

    @Override // com.zte.iptvclient.common.uiframe.c, android.widget.Adapter
    public com.zte.iptvclient.android.mobile.vod.entity.a getItem(int i) {
        return this.e.get(i);
    }
}
