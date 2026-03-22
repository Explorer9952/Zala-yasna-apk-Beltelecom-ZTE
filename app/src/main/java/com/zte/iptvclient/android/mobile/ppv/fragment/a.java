package com.zte.iptvclient.android.mobile.ppv.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.a.h;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.auth.SDKSubscribeMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.order.bean.OrderRecordBean;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MyPpvFragment.java */
/* loaded from: classes.dex */
public class a extends com.zte.fragmentlib.b {
    private ListView p;
    private SmartRefreshLayout q;
    private RelativeLayout r;
    private TextView s;
    private RelativeLayout t;
    private Button u;
    private TextView v;
    private com.zte.iptvclient.android.mobile.r.a.a w;
    private List<OrderRecordBean> x;
    private d y;
    private c z = new c(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyPpvFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.ppv.fragment.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0331a implements View.OnClickListener {
        ViewOnClickListenerC0331a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.getActivity() instanceof MainActivity) {
                a.this.F();
            } else if (a.this.getActivity() instanceof HostActivity) {
                a.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyPpvFragment.java */
    /* loaded from: classes.dex */
    public class b implements com.scwang.smartrefresh.layout.d.c {
        b() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(h hVar) {
            a.this.L();
        }
    }

    /* compiled from: MyPpvFragment.java */
    /* loaded from: classes.dex */
    private static final class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<a> f7022a;

        public c(a aVar) {
            this.f7022a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            a aVar = this.f7022a.get();
            if (aVar == null) {
                return;
            }
            switch (message.what) {
                case 1007617:
                    aVar.x.addAll((ArrayList) message.obj);
                    aVar.w.notifyDataSetChanged();
                    aVar.M();
                    return;
                case 1007618:
                    aVar.M();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MyPpvFragment.java */
    /* loaded from: classes.dex */
    public class d extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private String f7023a;

        /* renamed from: b, reason: collision with root package name */
        private String f7024b;

        /* renamed from: c, reason: collision with root package name */
        private SDKSubscribeMgr f7025c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f7026d;

        /* compiled from: MyPpvFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.ppv.fragment.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0332a implements SDKSubscribeMgr.OnUserOrderListReturnListener {
            C0332a() {
            }

            @Override // com.video.androidsdk.service.auth.SDKSubscribeMgr.OnUserOrderListReturnListener
            public void onUserOrderListReturn(String str, String str2, String str3) {
                if (d.this.f7026d) {
                    return;
                }
                LogEx.d("MyPpvFragment", "queryUserVodOrderList data : " + str3);
                if (!TextUtils.equals(str, "0")) {
                    a.this.z.sendEmptyMessage(1007618);
                    return;
                }
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        OrderRecordBean orderRecordBeanFromJSon = OrderRecordBean.getOrderRecordBeanFromJSon(jSONArray.getJSONObject(i));
                        if (orderRecordBeanFromJSon != null && ("3".equals(orderRecordBeanFromJSon.getProducttype()) || DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT.equals(orderRecordBeanFromJSon.getProducttype()))) {
                            arrayList.add(orderRecordBeanFromJSon);
                        }
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 1007617;
                    obtain.obj = arrayList;
                    a.this.z.sendMessage(obtain);
                } catch (Exception e) {
                    LogEx.e("MyPpvFragment", e.getMessage());
                    a.this.z.sendEmptyMessage(1007618);
                }
            }
        }

        public d(String str, String str2) {
            this.f7023a = str;
            this.f7024b = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            if (this.f7026d) {
                return;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("pageno", this.f7023a);
            hashMap.put("numperpage", this.f7024b);
            SDKSubscribeMgr sDKSubscribeMgr = new SDKSubscribeMgr();
            this.f7025c = sDKSubscribeMgr;
            sDKSubscribeMgr.getUserOrderList(hashMap, new C0332a());
        }

        public void a() {
            this.f7026d = true;
            SDKSubscribeMgr sDKSubscribeMgr = this.f7025c;
            if (sDKSubscribeMgr != null) {
                sDKSubscribeMgr.cancelRequest();
            }
        }
    }

    private void I() {
        this.u.setOnClickListener(new ViewOnClickListenerC0331a());
        this.q.a(new b());
    }

    private void J() {
        d dVar = this.y;
        if (dVar != null) {
            dVar.a();
        }
    }

    private void K() {
        d dVar = new d("1", "100");
        this.y = dVar;
        dVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        List<OrderRecordBean> list = this.x;
        if (list == null) {
            this.x = new ArrayList();
        } else {
            list.clear();
        }
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        this.q.a();
        if (this.x.size() == 0) {
            this.r.setVisibility(0);
            this.p.setVisibility(8);
        } else {
            this.r.setVisibility(8);
            this.p.setVisibility(0);
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        L();
        com.zte.iptvclient.android.mobile.r.a.a aVar = new com.zte.iptvclient.android.mobile.r.a.a(this.h, this.x);
        this.w = aVar;
        this.p.setAdapter((ListAdapter) aVar);
        I();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.package_mobile_layout, (ViewGroup) null);
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        J();
        super.onDestroy();
    }

    private void d(View view) {
        g.a(this.h, view, R.id.title_bottom_line);
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.t = (RelativeLayout) view.findViewById(R.id.title_rlayout);
        this.u = (Button) view.findViewById(R.id.btn_back);
        this.v = (TextView) view.findViewById(R.id.title_txt);
        this.p = (ListView) view.findViewById(R.id.expandableHListView_subscription);
        this.q = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        this.r = (RelativeLayout) view.findViewById(R.id.rl_empty);
        ImageView imageView = (ImageView) view.findViewById(R.id.title_bottom_line);
        f.a(this.r.findViewById(R.id.ll_pullrefresh));
        f.a(this.r.findViewById(R.id.img_pullrefresh_icon));
        f.a(this.r.findViewById(R.id.txt_pullrefresh));
        f.a(this.r.findViewById(R.id.refresh_image));
        f.a(view.findViewById(R.id.favorite_rlayout));
        f.a(imageView);
        f.a(this.t);
        f.a(this.u);
        f.a(this.v);
        this.r.setVisibility(8);
        TextView textView2 = (TextView) this.r.findViewById(R.id.txt_pullrefresh);
        this.s = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.there_is_no_order_yet));
        this.q.a(new DefaultRefreshHeader(this.h));
        this.q.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.q;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.q;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.q.a(true);
        this.q.c(false);
        this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.ppv));
        if (BaseApp.a(this.h)) {
            g.a(imageView, this.h);
        }
    }
}
