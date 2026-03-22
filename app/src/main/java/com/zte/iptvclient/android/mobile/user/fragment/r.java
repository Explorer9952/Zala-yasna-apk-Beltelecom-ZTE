package com.zte.iptvclient.android.mobile.user.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.auth.FeatureAuthAndOrderListReq;
import com.video.androidsdk.service.auth.SDKAuthMgr;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.user.fragment.p;
import com.zte.iptvclient.android.zala.R;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TerminalConcurrency.java */
/* loaded from: classes.dex */
public class r extends com.zte.fragmentlib.b implements p.b {
    private static String J = "TerminalConcurrency";
    private TextView A;
    private com.zte.iptvclient.android.common.j.h B;
    private ExecutorService D;
    private RelativeLayout q;
    private Button r;
    private TextView s;
    private ListView t;
    private TextView u;
    private String v;
    private String w;
    private List<com.zte.iptvclient.android.common.javabean.g> x;
    private com.zte.iptvclient.android.mobile.user.fragment.a y;
    private List<String> z;
    public int p = 0;
    private int C = 0;
    private Handler E = new a();
    Runnable F = new c();
    Runnable G = new e();

    /* compiled from: TerminalConcurrency.java */
    /* loaded from: classes2.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            super.dispatchMessage(message);
            int i = message.what;
            if (i == 0) {
                LogEx.d(r.J, "notifyDataSetChanged");
                r.this.u.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.terminal_concurrency_total), String.valueOf(r.this.C)));
                if (r.this.y != null) {
                    r.this.y.notifyDataSetChanged();
                    return;
                }
                return;
            }
            if ((i == 1 || i == 2) && r.this.y != null) {
                r.this.y.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TerminalConcurrency.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r.this.getActivity() != null) {
                r.this.getActivity().finish();
            }
        }
    }

    /* compiled from: TerminalConcurrency.java */
    /* loaded from: classes2.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TerminalConcurrency.java */
    /* loaded from: classes2.dex */
    public class d implements SDKAuthMgr.OnFeatureAuthAndOrderListReturnListener {
        d() {
        }

        @Override // com.video.androidsdk.service.auth.SDKAuthMgr.OnFeatureAuthAndOrderListReturnListener
        public void onFeatureAuthAndOrderListReturn(String str, String str2, String str3) {
            LogEx.d(r.J, "returncode：" + str + "\nerrormsg：" + str2 + "\ndata：" + str3);
            if (TextUtils.equals("0", str) || TextUtils.equals(DownloadConstant.REPORT_MSGTYPE_ADD, str) || TextUtils.equals("98", str)) {
                try {
                    JSONObject optJSONObject = new JSONObject(str3).optJSONObject("data");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("productinfo");
                    if (r.this.p == 3) {
                        String format = String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.terminal_concurrency_total), optJSONObject2.optString("featurevalue"));
                        String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.terminal_binding_haveused_total);
                        r.this.v = format;
                        r.this.w = a2;
                    } else if (r.this.p == 1) {
                        r.this.u.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.terminal_concurrency_total), optJSONObject2.optString("featurevalue")));
                    } else if (r.this.p == 0) {
                        try {
                            r.this.u.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.terminal_concurrency_total), new DecimalFormat(".00").format(Double.parseDouble(optJSONObject2.optString("featurevalue")) / 1024.0d)));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    JSONArray optJSONArray = optJSONObject.optJSONArray("productlist");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            r.this.x.add(com.zte.iptvclient.android.common.javabean.g.a(optJSONArray.getJSONObject(i)));
                        }
                    }
                    if (r.this.D != null) {
                        r.this.D.submit(r.this.G);
                    }
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("orderproductlist");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            r.this.z.add(optJSONArray2.getJSONObject(i2).optString("productcode"));
                        }
                    }
                    if (r.this.D != null && r.this.p == 2) {
                        r.this.D.submit(r.this.F);
                    }
                    if (r.this.p == 1) {
                        r.this.N();
                    }
                    if (r.this.x == null || r.this.x.size() <= 0) {
                        return;
                    }
                    r.this.y.notifyDataSetChanged();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* compiled from: TerminalConcurrency.java */
    /* loaded from: classes2.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.C = 0;
        for (int i = 0; i < this.x.size(); i++) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.z.size(); i3++) {
                if (TextUtils.equals(this.x.get(i).d(), this.z.get(i3))) {
                    i2++;
                    this.C++;
                }
            }
            this.x.get(i).a(i2);
        }
        Handler handler = this.E;
        if (handler != null) {
            handler.sendEmptyMessage(0);
        }
    }

    private void K() {
        this.x = new ArrayList();
        this.z = new ArrayList();
        com.zte.iptvclient.android.mobile.user.fragment.a aVar = new com.zte.iptvclient.android.mobile.user.fragment.a(this.h, this.x);
        this.y = aVar;
        this.t.setAdapter((ListAdapter) aVar);
        this.B = new com.zte.iptvclient.android.common.j.h(this.h);
        this.D = Executors.newSingleThreadExecutor();
        int i = this.p;
        if (i == 1) {
            this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.terminal_playback_concurrency_title));
            return;
        }
        if (i == 2) {
            this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.terminal_online_concurrency_title));
            return;
        }
        if (i == 0) {
            this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.cloud_dvr_space_title));
        } else if (i == 3) {
            this.q.setVisibility(8);
            this.A.setVisibility(8);
        }
    }

    private void L() {
        this.r.setOnClickListener(new b());
    }

    private void M() {
        SDKAuthMgr sDKAuthMgr = new SDKAuthMgr();
        FeatureAuthAndOrderListReq featureAuthAndOrderListReq = new FeatureAuthAndOrderListReq();
        featureAuthAndOrderListReq.authandorderlist = "3";
        int i = this.p;
        if (i == 3) {
            featureAuthAndOrderListReq.featurecode = "ottdevice";
            featureAuthAndOrderListReq.orderfeaturecode = "ottdevice";
        } else if (i == 2) {
            featureAuthAndOrderListReq.featurecode = "mixdevice";
            featureAuthAndOrderListReq.orderfeaturecode = "mixdevice";
        } else if (i == 0) {
            featureAuthAndOrderListReq.featurecode = "clouddvr";
            featureAuthAndOrderListReq.orderfeaturecode = "clouddvr";
        } else {
            featureAuthAndOrderListReq.featurecode = "mixplayback";
            featureAuthAndOrderListReq.orderfeaturecode = "onlinedevice";
        }
        featureAuthAndOrderListReq.profilecode = this.B.F();
        sDKAuthMgr.doFeatureAuthAndOrderList(featureAuthAndOrderListReq, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        for (int i = 0; i < this.x.size(); i++) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.z.size(); i3++) {
                if (TextUtils.equals(this.x.get(i).d(), this.z.get(i3))) {
                    i2++;
                }
            }
            this.x.get(i).a(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        for (int i = 0; i < this.x.size(); i++) {
            if (!TextUtils.isEmpty(this.x.get(i).d())) {
                for (int i2 = i + 1; i2 < this.x.size(); i2++) {
                    if (!TextUtils.isEmpty(this.x.get(i2).d()) && TextUtils.equals(this.x.get(i).d(), this.x.get(i2).d())) {
                        this.x.remove(i2);
                    }
                }
            }
        }
        Handler handler = this.E;
        if (handler != null) {
            handler.sendEmptyMessage(1);
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        K();
        M();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.p = arguments.getInt("type", 1);
        }
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_playback_concurrency, (ViewGroup) null);
        d(inflate);
        L();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.E;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.E = null;
        }
        ExecutorService executorService = this.D;
        if (executorService != null) {
            executorService.shutdownNow();
        }
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(o oVar) {
    }

    private void d(View view) {
        this.A = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        this.A.setHeight(a2);
        this.q = (RelativeLayout) view.findViewById(R.id.title_rlayout);
        this.r = (Button) view.findViewById(R.id.btn_back);
        TextView textView = (TextView) view.findViewById(R.id.title_txt);
        this.s = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.product_package));
        this.t = (ListView) view.findViewById(R.id.lst_porduct);
        this.u = (TextView) view.findViewById(R.id.txt_total);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
    }

    @Override // com.zte.iptvclient.android.mobile.user.fragment.p.b
    public void b(int i) {
        LogEx.d(J, ",,,count:" + i);
        String str = this.w;
        if (str != null) {
            this.w = String.format(str, "" + i);
        }
        this.u.setText(this.w + "/" + this.v);
    }
}
