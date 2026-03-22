package com.zte.iptvclient.android.mobile.e0.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.i;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;

/* compiled from: AdapterSeriesSeason.java */
/* loaded from: classes2.dex */
public class e extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Context f5811a;

    /* renamed from: b, reason: collision with root package name */
    private LayoutInflater f5812b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<com.zte.iptvclient.android.mobile.vod.entity.a> f5813c;

    /* compiled from: AdapterSeriesSeason.java */
    /* loaded from: classes2.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        TextView f5814a;

        /* renamed from: b, reason: collision with root package name */
        TextView f5815b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f5816c;

        /* renamed from: d, reason: collision with root package name */
        ImageView f5817d;

        a() {
        }
    }

    public e(Context context, ArrayList<com.zte.iptvclient.android.mobile.vod.entity.a> arrayList) {
        this.f5811a = context;
        this.f5812b = LayoutInflater.from(context);
        this.f5813c = arrayList;
    }

    public void a(int i) {
        for (int i2 = 0; i2 < this.f5813c.size(); i2++) {
            this.f5813c.get(i2).a(false);
        }
        this.f5813c.get(i).a(true);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<com.zte.iptvclient.android.mobile.vod.entity.a> arrayList = this.f5813c;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f5812b.inflate(R.layout.item_series_season, (ViewGroup) null);
            aVar = new a();
            aVar.f5814a = (TextView) view.findViewById(R.id.season_title_num_txt);
            aVar.f5815b = (TextView) view.findViewById(R.id.season_title_name_txt);
            aVar.f5816c = (ImageView) view.findViewById(R.id.iv_season_poster_thumb);
            aVar.f5817d = (ImageView) view.findViewById(R.id.ivi_logo_top);
            com.zte.iptvclient.common.uiframe.f.a(view);
            com.zte.iptvclient.common.uiframe.f.a(aVar.f5814a);
            com.zte.iptvclient.common.uiframe.f.a(aVar.f5815b);
            com.zte.iptvclient.common.uiframe.f.a(aVar.f5816c);
            com.zte.iptvclient.common.uiframe.f.a(aVar.f5817d);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.zte.iptvclient.android.mobile.vod.entity.a item = getItem(i);
        String e = item.e();
        if (!TextUtils.isEmpty(e) && !"0".equals(e)) {
            aVar.f5814a.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_season) + " " + e);
        } else {
            aVar.f5814a.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_season));
        }
        aVar.f5815b.setText(item.d());
        if (item.f()) {
            aVar.f5814a.setSelected(true);
            aVar.f5815b.setSelected(true);
        } else {
            aVar.f5814a.setSelected(false);
            aVar.f5815b.setSelected(false);
        }
        com.bumptech.glide.d<String> a2 = i.b(this.f5811a).a(com.zte.iptvclient.android.common.k.g.a(9, item.b()));
        a2.b(R.drawable.default_poster_thumb);
        a2.a(R.drawable.default_poster_thumb);
        a2.c(300);
        a2.a(aVar.f5816c);
        if (item.a().equals("ivi")) {
            aVar.f5817d.setVisibility(0);
            aVar.f5817d.setImageDrawable(this.f5811a.getResources().getDrawable(R.drawable.ivi_logo));
        } else if (item.a().equals("Megogo")) {
            aVar.f5817d.setVisibility(0);
            aVar.f5817d.setImageDrawable(this.f5811a.getResources().getDrawable(R.drawable.megogo_logo));
        } else {
            aVar.f5817d.setVisibility(8);
        }
        return view;
    }

    @Override // android.widget.Adapter
    public com.zte.iptvclient.android.mobile.vod.entity.a getItem(int i) {
        return this.f5813c.get(i);
    }
}
