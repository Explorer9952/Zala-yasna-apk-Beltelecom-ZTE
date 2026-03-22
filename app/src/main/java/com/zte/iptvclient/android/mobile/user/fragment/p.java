package com.zte.iptvclient.android.mobile.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.common.AndroidUniqueCode;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.impl.IIPTVLogin;
import com.video.androidsdk.service.SDKUserMgr4CELLC;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.user.entity.GetBindDeviceListEntity;
import com.zte.iptvclient.android.zala.R;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TerminalBindingFragment.java */
/* loaded from: classes.dex */
public class p extends com.zte.fragmentlib.b implements View.OnClickListener {
    private String A;
    private TextView B;
    private d C;
    private Button p;
    private TextView q;
    private RecyclerView r;
    private RelativeLayout s;
    private com.zte.iptvclient.android.common.j.h v;
    private b w;
    private SmartRefreshLayout x;
    private e y;
    private String z;
    private SDKUserMgr4CELLC t = new SDKUserMgr4CELLC();
    private ArrayList<TerminalBindList> u = new ArrayList<>();
    private c D = new c(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TerminalBindingFragment.java */
    /* loaded from: classes2.dex */
    public class a implements com.scwang.smartrefresh.layout.d.c {
        a() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            p.this.L();
        }
    }

    /* compiled from: TerminalBindingFragment.java */
    /* loaded from: classes.dex */
    public interface b {
        void b(int i);
    }

    /* compiled from: TerminalBindingFragment.java */
    /* loaded from: classes2.dex */
    private static final class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<p> f7474a;

        public c(p pVar) {
            this.f7474a = new WeakReference<>(pVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            p pVar = this.f7474a.get();
            if (pVar == null) {
                return;
            }
            switch (message.what) {
                case 32769:
                    GetBindDeviceListEntity getBindDeviceListEntity = (GetBindDeviceListEntity) message.obj;
                    if (getBindDeviceListEntity != null) {
                        for (int i = 0; i < getBindDeviceListEntity.f7404b.size(); i++) {
                            TerminalBindList terminalBindList = getBindDeviceListEntity.f7404b.get(i);
                            if (pVar.K()) {
                                terminalBindList.a(true);
                            } else {
                                terminalBindList.a(false);
                            }
                        }
                        pVar.u.addAll(getBindDeviceListEntity.f7404b);
                        pVar.M();
                        pVar.y.d();
                        if (pVar.w != null) {
                            pVar.w.b(getBindDeviceListEntity.f7403a);
                        }
                    }
                    pVar.x.a();
                    pVar.N();
                    return;
                case 32770:
                    pVar.x.a();
                    pVar.N();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TerminalBindingFragment.java */
    /* loaded from: classes2.dex */
    public class d extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private boolean f7475a;

        /* compiled from: TerminalBindingFragment.java */
        /* loaded from: classes2.dex */
        class a implements SDKUserMgr4CELLC.OnBindDeviceListReturnListener {
            a() {
            }

            @Override // com.video.androidsdk.service.SDKUserMgr4CELLC.OnBindDeviceListReturnListener
            public void onBindDeviceListReturn(String str, String str2, String str3) {
                if (d.this.f7475a) {
                    return;
                }
                LogEx.d("TerminalBindingFragment", "strErrorCode =" + str + "rsp = " + str3);
                if (!"0".equals(str)) {
                    p.this.D.sendEmptyMessage(32770);
                    return;
                }
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    GetBindDeviceListEntity getBindDeviceListEntity = new GetBindDeviceListEntity();
                    int length = jSONArray.length();
                    getBindDeviceListEntity.f7403a = length;
                    LogEx.d("TerminalBindingFragment", "terminalBindingCount:" + length);
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                        if (jSONObject != null) {
                            TerminalBindList terminalBindList = new TerminalBindList();
                            terminalBindList.a(jSONObject.optString("binddeviceid"));
                            terminalBindList.b(jSONObject.optString("bindterminaltype"));
                            terminalBindList.d(jSONObject.optString(IIPTVLogin.LOGIN_PARAM_STBCODE));
                            terminalBindList.e(jSONObject.optString("stbmac"));
                            terminalBindList.f("updatetime");
                            try {
                                terminalBindList.c(URLDecoder.decode((String) jSONObject.get("deviceinfo"), "UTF-8"));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            getBindDeviceListEntity.f7404b.add(terminalBindList);
                        }
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 32769;
                    obtain.obj = getBindDeviceListEntity;
                    p.this.D.sendMessage(obtain);
                } catch (JSONException e2) {
                    LogEx.e("TerminalBindingFragment", e2.getMessage());
                    p.this.D.sendEmptyMessage(32770);
                }
            }
        }

        public d() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            if (this.f7475a) {
                return;
            }
            p.this.t.getBindDeviceList(new a());
        }

        public void a() {
            this.f7475a = true;
        }
    }

    private void I() {
        LogEx.d("TerminalBindingFragment", "TerminalBindingFragment onCreateView");
        this.x.a(new a());
    }

    private void J() {
        d dVar = this.C;
        if (dVar != null) {
            dVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K() {
        if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
            return false;
        }
        String H = this.v.H();
        LogEx.d("TerminalBindingFragment", "isMasterProfile profileRoleId:" + H);
        return H.equals("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        this.u.clear();
        d dVar = new d();
        this.C = dVar;
        dVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        int i = 0;
        while (true) {
            if (i >= this.u.size()) {
                i = 0;
                break;
            }
            TerminalBindList terminalBindList = this.u.get(i);
            String d2 = terminalBindList.d();
            String e = terminalBindList.e();
            Log.d("Account-DeviceBinding", "strStbMac: " + this.A + " --- " + e);
            if (d2.equals(this.z) || e.equals(this.A)) {
                break;
            } else {
                i++;
            }
        }
        if (i > 0) {
            TerminalBindList terminalBindList2 = this.u.get(i);
            this.u.remove(i);
            this.u.add(0, terminalBindList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (this.u.size() == 0) {
            this.r.setVisibility(8);
            this.s.setVisibility(0);
        } else {
            this.r.setVisibility(0);
            this.s.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.btn_back) {
            return;
        }
        if (getActivity() instanceof MainActivity) {
            LogEx.d("TerminalBindingFragment", "back button onclick MainActivity");
            F();
        } else if (getActivity() instanceof HostActivity) {
            LogEx.d("TerminalBindingFragment", "back button onclick HostActivity");
            getActivity().finish();
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.v = new com.zte.iptvclient.android.common.j.h(this.h);
        EventBus.getDefault().register(this);
        LogEx.d("TerminalBindingFragment", "TerminalBindingFragment onCreate");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LogEx.d("TerminalBindingFragment", "TerminalBindingFragment onCreateView");
        View inflate = layoutInflater.inflate(R.layout.terminal_binding_ott, (ViewGroup) null);
        d(inflate);
        I();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        J();
    }

    @Subscribe
    public void onEventMainThread(o oVar) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    public static String a(Context context) {
        return AndroidUniqueCode.getAndroidId(context);
    }

    private void d(View view) {
        com.zte.iptvclient.android.common.k.g.a(this.h, view, R.id.header_bottom_line);
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.y = new e(this.h, this.u);
        LogEx.d("TerminalBindingFragment", "TerminalBindingFragment onCreateView");
        this.p = (Button) view.findViewById(R.id.btn_back);
        if (BaseApp.a(this.h)) {
            this.p.setVisibility(8);
        } else {
            this.p.setVisibility(0);
        }
        this.p.setOnClickListener(this);
        TextView textView2 = (TextView) view.findViewById(R.id.title_txt);
        this.q = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.terminal_binding));
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.terminal_home_recycle_view);
        this.r = recyclerView;
        recyclerView.a(new LinearLayoutManager(this.h));
        RecyclerView recyclerView2 = this.r;
        SupportActivity supportActivity = this.h;
        recyclerView2.a(new com.zte.iptvclient.android.common.customview.b.a.a(supportActivity, 0, com.zte.iptvclient.android.common.k.g.a(supportActivity, 20.0f), 0, R.drawable.line_divider));
        this.x = (SmartRefreshLayout) view.findViewById(R.id.refresh_layout);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.s = relativeLayout;
        TextView textView3 = (TextView) relativeLayout.findViewById(R.id.txt_pullrefresh);
        this.B = textView3;
        textView3.setText(this.h.getString(R.string.there_is_no_collection));
        L();
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
        this.x.a(new DefaultRefreshHeader(this.h));
        this.x.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.x;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout.e(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.x;
        SupportActivity supportActivity3 = this.h;
        smartRefreshLayout2.f(com.zte.iptvclient.android.common.k.g.a(supportActivity3, supportActivity3.getResources().getDimension(R.dimen.refresh_header_height)));
        this.x.a(true);
        this.x.c(false);
        this.x.b(false);
        this.r.a(this.y);
        this.z = a(getContext());
        this.A = AndroidUniqueCode.getDeviceMacAddress(getContext());
        ImageView imageView = (ImageView) view.findViewById(R.id.header_bottom_line);
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        if (BaseApp.a(this.h)) {
            imageView.setVisibility(0);
            com.zte.iptvclient.android.common.k.g.a(imageView, this.h);
            view.findViewById(R.id.ll_termingal_page_container).setBackgroundResource(R.drawable.bg_pad);
        }
    }

    public void a(r rVar) {
        this.w = rVar;
    }
}
