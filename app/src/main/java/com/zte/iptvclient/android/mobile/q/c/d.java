package com.zte.iptvclient.android.mobile.q.c;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.vr.cardboard.TransitionView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.a.h;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.auth.SDKSubscribeMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.mobile.order.bean.OrderRecordBean;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SubscriptionFragment.java */
/* loaded from: classes.dex */
public class d extends com.zte.fragmentlib.b {
    private RelativeLayout A;
    private TextView C;
    private Button p;
    private ExpandableListView q;
    private com.zte.iptvclient.android.mobile.q.a.b r;
    private List<String> s;
    private List<List<OrderRecordBean>> t;
    private List<OrderRecordBean> u;
    private List<OrderRecordBean> v;
    private List<OrderRecordBean> w;
    private SmartRefreshLayout z;
    private boolean x = false;
    private boolean y = false;
    private int B = TransitionView.TRANSITION_ANIMATION_DURATION_MS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SubscriptionFragment.java */
    /* loaded from: classes.dex */
    public class a implements SDKSubscribeMgr.OnUserConsumeListReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.service.auth.SDKSubscribeMgr.OnUserConsumeListReturnListener
        public void onUserConsumeListReturn(String str, String str2, String str3) {
            LogEx.d("SubscriptionFragment", "queryConsumeList returncode : " + str + ", data : " + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        d.this.u.add(OrderRecordBean.getOrderRecordBeanFromJSon(jSONArray.getJSONObject(i)));
                    }
                    if (d.this.u != null) {
                        d.this.w.addAll(d.this.u);
                    }
                } catch (Exception e) {
                    LogEx.e("SubscriptionFragment", e.getMessage());
                }
            }
            d.this.y = true;
            d.this.J();
            d.this.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SubscriptionFragment.java */
    /* loaded from: classes.dex */
    public class b implements SDKSubscribeMgr.OnUserOrderListReturnListener {
        b() {
        }

        @Override // com.video.androidsdk.service.auth.SDKSubscribeMgr.OnUserOrderListReturnListener
        public void onUserOrderListReturn(String str, String str2, String str3) {
            LogEx.d("SubscriptionFragment", "queryOrderList returncode : " + str + ", data : " + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        OrderRecordBean orderRecordBeanFromJSon = OrderRecordBean.getOrderRecordBeanFromJSon(jSONArray.getJSONObject(i));
                        if ("1".equals(ConfigMgr.readPropertie("UseXingTVOrder", "0"))) {
                            if (orderRecordBeanFromJSon != null) {
                                d.this.v.add(orderRecordBeanFromJSon);
                            }
                        } else if (orderRecordBeanFromJSon != null) {
                            d.this.v.add(orderRecordBeanFromJSon);
                        }
                    }
                    if (d.this.v != null) {
                        d.this.w.addAll(d.this.v);
                    }
                } catch (Exception e) {
                    LogEx.e("SubscriptionFragment", e.getMessage());
                }
            }
            d.this.x = true;
            d.this.J();
            d.this.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SubscriptionFragment.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.getActivity() != null) {
                d.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SubscriptionFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.q.c.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0339d implements com.scwang.smartrefresh.layout.d.c {
        C0339d() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(h hVar) {
            d.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SubscriptionFragment.java */
    /* loaded from: classes.dex */
    public class e implements ExpandableListView.OnGroupClickListener {
        e(d dVar) {
        }

        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            if (expandableListView.isGroupExpanded(i)) {
                expandableListView.collapseGroup(i);
                return true;
            }
            expandableListView.expandGroup(i, false);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        LogEx.d("SubscriptionFragment", "convertListToGroup()");
        List<String> list = this.s;
        if (list == null) {
            this.s = new ArrayList();
        } else {
            list.clear();
        }
        List<List<OrderRecordBean>> list2 = this.t;
        if (list2 == null) {
            this.t = new ArrayList();
        } else {
            list2.clear();
        }
        Collections.sort(this.w);
        a(this.w);
        N();
        this.r.a(this.t);
        this.r.b(this.s);
        this.r.notifyDataSetChanged();
    }

    private void K() {
        this.y = false;
        if (this.u.size() > 0) {
            this.u.clear();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pageno", "1");
        hashMap.put("numperpage", String.valueOf(this.B));
        hashMap.put("cdrtime", "3");
        hashMap.put("contenttype", "100");
        hashMap.put("cdrtype", "100");
        hashMap.put("ordertype", "21");
        hashMap.put("filtertype", "0");
        new SDKSubscribeMgr().getUserConsumeList(hashMap, new a());
    }

    private void L() {
        this.x = false;
        List<OrderRecordBean> list = this.v;
        if (list != null) {
            list.clear();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pageno", "1");
        hashMap.put("numperpage", String.valueOf(this.B));
        hashMap.put("producttype", "");
        new SDKSubscribeMgr().getUserOrderList(hashMap, new b());
    }

    private void M() {
        this.p.setOnClickListener(new c());
        this.z.a(new C0339d());
        this.q.setOnGroupClickListener(new e(this));
    }

    private void N() {
        for (int i = 0; i < this.s.size(); i++) {
            String str = this.s.get(i);
            String format = TimeUtil.format(TimeUtil.getNow(), "dd/MM/yyyy HH:mm:ss");
            if (str != null && format != null && TextUtils.equals(str, x.g(format))) {
                this.s.set(i, (String) this.h.getResources().getText(R.string.order_month));
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        if (this.x || this.y) {
            this.z.a();
            if (this.w.size() == 0) {
                this.A.setVisibility(0);
                this.q.setVisibility(8);
            } else {
                this.A.setVisibility(8);
                this.q.setVisibility(0);
            }
            if (this.q.getCount() > 0) {
                this.q.expandGroup(0);
            }
        }
    }

    public void I() {
        List<OrderRecordBean> list = this.u;
        if (list == null) {
            this.u = new ArrayList();
        } else {
            list.clear();
        }
        List<OrderRecordBean> list2 = this.v;
        if (list2 == null) {
            this.v = new ArrayList();
        } else {
            list2.clear();
        }
        List<OrderRecordBean> list3 = this.w;
        if (list3 == null) {
            this.w = new ArrayList();
        } else {
            list3.clear();
        }
        this.y = true;
        if (getArguments().getBoolean("consumption_records", false)) {
            K();
        } else {
            L();
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        M();
        com.zte.iptvclient.android.mobile.q.a.b bVar = new com.zte.iptvclient.android.mobile.q.a.b(this.h, this, this.s, this.t);
        this.r = bVar;
        this.q.setAdapter(bVar);
        I();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_subscription, (ViewGroup) null);
        d(inflate);
        return inflate;
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        Button button = (Button) view.findViewById(R.id.btn_back);
        this.p = button;
        if (this.o) {
            button.setVisibility(0);
        }
        this.q = (ExpandableListView) view.findViewById(R.id.expandableHListView_subscription);
        TextView textView2 = (TextView) view.findViewById(R.id.title_txt);
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_order));
        ImageView imageView = (ImageView) view.findViewById(R.id.header_bottom_line);
        f.a(view.findViewById(R.id.title_rlayout));
        f.a(textView2);
        f.a(imageView);
        f.a(this.p);
        f.a(this.q);
        this.z = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.A = relativeLayout;
        f.a(relativeLayout.findViewById(R.id.ll_pullrefresh));
        f.a(this.A.findViewById(R.id.img_pullrefresh_icon));
        f.a(this.A.findViewById(R.id.txt_pullrefresh));
        f.a(this.A.findViewById(R.id.refresh_image));
        this.A.setVisibility(8);
        TextView textView3 = (TextView) this.A.findViewById(R.id.txt_pullrefresh);
        this.C = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.there_is_no_order_yet));
        this.z.a(new DefaultRefreshHeader(this.h));
        this.z.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.z;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.z;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.z.a(true);
        if (BaseApp.a(this.h)) {
            g.a(imageView, this.h);
        }
    }

    private void a(List<OrderRecordBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            OrderRecordBean orderRecordBean = list.get(i);
            String g = x.g(orderRecordBean.getBegintime());
            if (!StringUtil.isEmptyString(g) && !this.s.contains(g)) {
                this.s.add(g);
                ArrayList arrayList = new ArrayList();
                arrayList.add(orderRecordBean);
                for (int i2 = i + 1; i2 < list.size(); i2++) {
                    OrderRecordBean orderRecordBean2 = list.get(i2);
                    if (TextUtils.equals(g, x.g(orderRecordBean2.getBegintime()))) {
                        arrayList.add(orderRecordBean2);
                    }
                }
                this.t.add(arrayList);
            }
        }
    }
}
