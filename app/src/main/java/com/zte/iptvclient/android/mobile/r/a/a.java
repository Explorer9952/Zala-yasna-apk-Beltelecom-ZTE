package com.zte.iptvclient.android.mobile.r.a;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.d;
import com.bumptech.glide.i;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.w;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.mobile.order.bean.OrderRecordBean;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.List;

/* compiled from: AdapterMyPpv.java */
/* loaded from: classes.dex */
public class a extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Context f7090a;

    /* renamed from: b, reason: collision with root package name */
    private List<OrderRecordBean> f7091b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f7092c;

    /* compiled from: AdapterMyPpv.java */
    /* renamed from: com.zte.iptvclient.android.mobile.r.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0340a {

        /* renamed from: a, reason: collision with root package name */
        public TextView f7093a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f7094b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f7095c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f7096d;
        public ImageView e;
        private LinearLayout f;
        public TextView g;

        C0340a() {
        }
    }

    public a(Context context, List<OrderRecordBean> list) {
        this.f7090a = context;
        this.f7091b = list;
        this.f7092c = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<OrderRecordBean> list = this.f7091b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f7091b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0340a c0340a;
        if (view == null) {
            view = this.f7092c.inflate(R.layout.recycleritem_ppv, (ViewGroup) null);
            c0340a = new C0340a();
            c0340a.f7093a = (TextView) view.findViewById(R.id.package_name);
            c0340a.f7094b = (TextView) view.findViewById(R.id.purchase_time);
            c0340a.f7095c = (TextView) view.findViewById(R.id.price);
            c0340a.f7096d = (ImageView) view.findViewById(R.id.img_poster);
            c0340a.e = (ImageView) view.findViewById(R.id.ivi_logo_top);
            c0340a.f = (LinearLayout) view.findViewById(R.id.item_layout);
            c0340a.g = (TextView) view.findViewById(R.id.effective_time);
            f.a(c0340a.f7096d);
            f.a(c0340a.e);
            f.a(c0340a.f);
            f.a(c0340a.f7093a);
            f.a(c0340a.f7094b);
            f.a(c0340a.f7095c);
            f.a(c0340a.g);
            view.setTag(c0340a);
        } else {
            c0340a = (C0340a) view.getTag();
        }
        OrderRecordBean orderRecordBean = this.f7091b.get(i);
        c0340a.f7093a.setText(orderRecordBean.getContentname());
        String str = com.zte.iptvclient.android.common.i.a.a.a(R.string.package_purchase_time) + x.c(orderRecordBean.getBegintime());
        String str2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.package_available_unit) + x.c(orderRecordBean.getEndtime());
        c0340a.f7094b.setText(str);
        c0340a.g.setText(str2);
        c0340a.f7095c.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_price) + w.b(orderRecordBean.getPrice().doubleValue()) + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.money_unit_sign));
        if (orderRecordBean.getCpcode().equals("ivi")) {
            c0340a.e.setVisibility(0);
            c0340a.e.setImageDrawable(this.f7090a.getResources().getDrawable(R.drawable.ivi_logo));
        } else if (orderRecordBean.getCpcode().equals("Megogo")) {
            c0340a.e.setVisibility(0);
            c0340a.e.setImageDrawable(this.f7090a.getResources().getDrawable(R.drawable.megogo_logo));
        } else {
            c0340a.e.setVisibility(8);
        }
        int i2 = BaseApp.a(this.f7090a) ? 9 : 3;
        Log.d("PPV-T", "PosterfileList:" + orderRecordBean.getPosterfilelist());
        d<String> a2 = i.b(this.f7090a).a(g.a(i2, orderRecordBean.getPosterfilelist()));
        a2.b(R.drawable.default_poster_thumb);
        a2.a(R.drawable.default_poster_thumb);
        a2.c(300);
        a2.a(c0340a.f7096d);
        return view;
    }
}
