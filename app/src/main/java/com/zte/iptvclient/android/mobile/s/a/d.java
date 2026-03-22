package com.zte.iptvclient.android.mobile.s.a;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.vr.cardboard.TransitionView;
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
import com.zte.iptvclient.android.mobile.productpackage.fragment.bean.PackageBean;
import com.zte.iptvclient.android.mobile.s.a.g.a;
import com.zte.iptvclient.android.zala.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PackageFragment.java */
/* loaded from: classes.dex */
public class d extends com.zte.fragmentlib.b {
    private TextView A;
    private f B;
    private ListView p;
    private com.zte.iptvclient.android.mobile.s.a.g.a q;
    private List<PackageBean> r;
    private List<PackageBean> s;
    private List<PackageBean> t;
    private SmartRefreshLayout u;
    private RelativeLayout v;
    private TextView x;
    private RelativeLayout y;
    private Button z;
    private int w = TransitionView.TRANSITION_ANIMATION_DURATION_MS;
    private e C = new e(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PackageFragment.java */
    /* loaded from: classes2.dex */
    public class a implements com.zte.fragmentlib.helper.c {
        a() {
        }

        @Override // com.zte.fragmentlib.helper.c
        public void a() {
            d.this.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PackageFragment.java */
    /* loaded from: classes2.dex */
    public class b implements com.scwang.smartrefresh.layout.d.c {
        b() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(h hVar) {
            d.this.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PackageFragment.java */
    /* loaded from: classes2.dex */
    public class c implements a.h {
        c(d dVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PackageFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.s.a.d$d, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewOnClickListenerC0341d implements View.OnClickListener {
        ViewOnClickListenerC0341d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.getActivity() instanceof MainActivity) {
                d.this.F();
            } else if (d.this.getActivity() instanceof HostActivity) {
                d.this.getActivity().finish();
            }
        }
    }

    /* compiled from: PackageFragment.java */
    /* loaded from: classes2.dex */
    private static final class e extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<d> f7102a;

        public e(d dVar) {
            this.f7102a = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            d dVar = this.f7102a.get();
            if (dVar != null && message.what == 61953) {
                dVar.L();
                List list = (List) message.obj;
                if (list != null) {
                    if (dVar.t != null) {
                        dVar.t.addAll(list);
                    }
                    if (dVar.s != null && dVar.t != null) {
                        dVar.s.clear();
                        dVar.s.addAll(dVar.t);
                    }
                    if (dVar.q != null) {
                        dVar.q.notifyDataSetChanged();
                    }
                }
                if (dVar.s != null) {
                    dVar.N();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PackageFragment.java */
    /* loaded from: classes2.dex */
    public class f extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private String f7103a;

        /* renamed from: b, reason: collision with root package name */
        private String f7104b;

        /* renamed from: c, reason: collision with root package name */
        private String f7105c;

        /* renamed from: d, reason: collision with root package name */
        private SDKSubscribeMgr f7106d;
        private boolean e;

        /* compiled from: PackageFragment.java */
        /* loaded from: classes2.dex */
        class a implements SDKSubscribeMgr.OnUserOrderListReturnListener {
            a() {
            }

            @Override // com.video.androidsdk.service.auth.SDKSubscribeMgr.OnUserOrderListReturnListener
            public void onUserOrderListReturn(String str, String str2, String str3) {
                if (f.this.e) {
                    return;
                }
                LogEx.d("MyPackageFragment", "queryOrderList data : " + str3);
                Message obtain = Message.obtain();
                obtain.what = 61953;
                if (TextUtils.equals(str, "0")) {
                    try {
                        JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            PackageBean a2 = PackageBean.a(jSONArray.getJSONObject(i));
                            Log.d("package-T", "packageBean: " + a2);
                            if (a2 != null && !"3".equals(a2.n()) && !DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT.equals(a2.n())) {
                                a2.p("1");
                                arrayList.add(a2);
                            }
                        }
                        obtain.obj = arrayList;
                    } catch (Exception e) {
                        LogEx.e("MyPackageFragment", e.getMessage());
                    }
                }
                d.this.C.sendMessage(obtain);
            }
        }

        public f(String str, String str2, String str3) {
            this.f7103a = str;
            this.f7104b = str2;
            this.f7105c = str3;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            if (this.e) {
                return;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("pageno", this.f7103a);
            hashMap.put("numperpage", this.f7104b);
            hashMap.put("producttype", this.f7105c);
            SDKSubscribeMgr sDKSubscribeMgr = new SDKSubscribeMgr();
            this.f7106d = sDKSubscribeMgr;
            sDKSubscribeMgr.getUserOrderList(hashMap, new a());
        }

        public void a() {
            this.e = true;
            SDKSubscribeMgr sDKSubscribeMgr = this.f7106d;
            if (sDKSubscribeMgr != null) {
                sDKSubscribeMgr.cancelRequest();
            }
        }
    }

    private void J() {
        a(new a());
        this.u.a(new b());
        this.q.a(new c(this));
    }

    private void K() {
        f fVar = this.B;
        if (fVar != null) {
            fVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        this.u.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        ArrayList arrayList = new ArrayList();
        this.t = arrayList;
        if (arrayList != null) {
            arrayList.clear();
        }
        f fVar = new f("1", String.valueOf(this.w), "");
        this.B = fVar;
        fVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        this.u.a();
        if (this.s.size() == 0) {
            this.v.setVisibility(0);
            this.p.setVisibility(8);
        } else {
            this.v.setVisibility(8);
            this.p.setVisibility(0);
        }
    }

    public void I() {
        this.z.setOnClickListener(new ViewOnClickListenerC0341d());
        List<PackageBean> list = this.r;
        if (list == null) {
            this.r = new ArrayList();
        } else {
            list.clear();
        }
        List<PackageBean> list2 = this.s;
        if (list2 == null) {
            this.s = new ArrayList();
        } else {
            list2.clear();
        }
        M();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        I();
        com.zte.iptvclient.android.mobile.s.a.g.a aVar = new com.zte.iptvclient.android.mobile.s.a.g.a(this.h, this.s);
        this.q = aVar;
        this.p.setAdapter((ListAdapter) aVar);
        J();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.package_mobile_layout, (ViewGroup) null);
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        List<PackageBean> list = this.s;
        if (list != null) {
            list.clear();
        }
        EventBus.getDefault().unregister(this);
        K();
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.c cVar) {
        if (getActivity() instanceof MainActivity) {
            F();
        } else if (getActivity() instanceof HostActivity) {
            getActivity().finish();
        }
    }

    private void d(View view) {
        g.a(this.h, view, R.id.title_bottom_line);
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.y = (RelativeLayout) view.findViewById(R.id.title_rlayout);
        this.z = (Button) view.findViewById(R.id.btn_back);
        this.A = (TextView) view.findViewById(R.id.title_txt);
        this.p = (ListView) view.findViewById(R.id.expandableHListView_subscription);
        this.u = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        this.v = (RelativeLayout) view.findViewById(R.id.rl_empty);
        ImageView imageView = (ImageView) view.findViewById(R.id.title_bottom_line);
        com.zte.iptvclient.common.uiframe.f.a(this.v.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.v.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.v.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.v.findViewById(R.id.refresh_image));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.favorite_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        this.v.setVisibility(8);
        TextView textView2 = (TextView) this.v.findViewById(R.id.txt_pullrefresh);
        this.x = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.there_is_no_order_yet));
        this.u.a(new DefaultRefreshHeader(this.h));
        this.u.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.u;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.u;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.u.a(true);
        this.u.c(false);
        this.A.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.product_package));
        if (BaseApp.a(this.h)) {
            g.a(imageView, this.h);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.mobile.s.a.a aVar) {
        M();
    }
}
