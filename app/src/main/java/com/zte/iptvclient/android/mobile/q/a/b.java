package com.zte.iptvclient.android.mobile.q.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.i;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.k.w;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.mobile.order.bean.OrderRecordBean;
import com.zte.iptvclient.android.mobile.q.c.d;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.List;

/* compiled from: AdapterSubscriptionForBe.java */
/* loaded from: classes.dex */
public class b extends BaseExpandableListAdapter {

    /* renamed from: a, reason: collision with root package name */
    private List<String> f7049a;

    /* renamed from: b, reason: collision with root package name */
    private List<List<OrderRecordBean>> f7050b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f7051c;

    /* renamed from: d, reason: collision with root package name */
    private Context f7052d;

    /* compiled from: AdapterSubscriptionForBe.java */
    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        public TextView f7053a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f7054b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f7055c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f7056d;
        public TextView e;

        a() {
        }
    }

    /* compiled from: AdapterSubscriptionForBe.java */
    /* renamed from: com.zte.iptvclient.android.mobile.q.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0334b {

        /* renamed from: a, reason: collision with root package name */
        public TextView f7057a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f7058b;

        /* renamed from: c, reason: collision with root package name */
        private RelativeLayout f7059c;

        C0334b() {
        }
    }

    public b(Context context, d dVar, List<String> list, List<List<OrderRecordBean>> list2) {
        this.f7051c = LayoutInflater.from(context);
        this.f7049a = list;
        this.f7050b = list2;
        this.f7052d = context;
    }

    public void a(List<List<OrderRecordBean>> list) {
        this.f7050b = list;
    }

    public void b(List<String> list) {
        this.f7049a = list;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return this.f7050b.get(i).get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f7051c.inflate(R.layout.recycleritem_ppv, (ViewGroup) null);
            aVar = new a();
            aVar.f7053a = (TextView) view.findViewById(R.id.package_name);
            aVar.f7054b = (ImageView) view.findViewById(R.id.img_poster);
            aVar.f7055c = (TextView) view.findViewById(R.id.purchase_time);
            aVar.f7056d = (TextView) view.findViewById(R.id.effective_time);
            aVar.e = (TextView) view.findViewById(R.id.price);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        OrderRecordBean orderRecordBean = (OrderRecordBean) getChild(i, i2);
        com.bumptech.glide.d<String> a2 = i.b(this.f7052d).a(orderRecordBean.getPosterpath());
        a2.b(R.drawable.default_poster_thumb);
        a2.a(aVar.f7054b);
        aVar.f7053a.setText(orderRecordBean.getContentname());
        String str = com.zte.iptvclient.android.common.i.a.a.a(R.string.package_purchase_time) + x.c(orderRecordBean.getBegintime());
        String str2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.package_available_unit) + x.c(orderRecordBean.getEndtime());
        aVar.f7055c.setText(str);
        aVar.f7056d.setText(str2);
        aVar.e.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_price));
        if (!TextUtils.isEmpty(orderRecordBean.getFeecost())) {
            String a3 = com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_price);
            try {
                Double valueOf = Double.valueOf(orderRecordBean.getFeecost());
                if (valueOf.doubleValue() >= 0.0d) {
                    aVar.e.setText(a3 + " " + w.b(valueOf.doubleValue()) + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.money_unit_sign));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        LogEx.d("AdapterSubscription", "programCode = " + orderRecordBean.getProgramcode() + ", columncode = " + orderRecordBean.getColumncode());
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        List<List<OrderRecordBean>> list = this.f7050b;
        if (list == null || list.get(i) == null) {
            return 0;
        }
        return this.f7050b.get(i).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.f7049a.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        List<String> list = this.f7049a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        C0334b c0334b;
        if (view == null) {
            view = this.f7051c.inflate(R.layout.contact_buddy_list_group, (ViewGroup) null);
            c0334b = new C0334b();
            c0334b.f7057a = (TextView) view.findViewById(R.id.tv_subscription_time);
            c0334b.f7058b = (ImageView) view.findViewById(R.id.img_arrow_down);
            c0334b.f7059c = (RelativeLayout) view.findViewById(R.id.rl_subscription_time);
            f.a(c0334b.f7059c);
            f.a(c0334b.f7057a);
            f.a(c0334b.f7058b);
            view.setTag(c0334b);
        } else {
            c0334b = (C0334b) view.getTag();
        }
        c0334b.f7057a.setText(String.valueOf(getGroup(i)));
        if (z) {
            c0334b.f7058b.setImageResource(R.drawable.btn_arrowup);
        } else {
            c0334b.f7058b.setImageResource(R.drawable.btn_arrowdown);
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }
}
