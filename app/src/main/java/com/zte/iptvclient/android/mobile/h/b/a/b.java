package com.zte.iptvclient.android.mobile.h.b.a;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.r;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.cast.bean.DLNAEvent;
import com.video.androidsdk.cast.bean.Device;
import com.video.androidsdk.common.AndroidUniqueCode;
import com.video.androidsdk.common.ParamConst;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.download.Linstener.SDKDownloadLoginSTBListener;
import com.video.androidsdk.download.SDKDownloadMgr;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.QRCodeScanGuideActivity;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.mobile.h.b.a.a;
import com.zte.iptvclient.android.mobile.h.b.b.a;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: STBMgrFragment.java */
/* loaded from: classes.dex */
public class b extends com.zte.fragmentlib.b implements a.c, a.f {
    private Button p;
    private ListView q;
    private FrameLayout r;
    private List<Device> t;
    private h u;
    private Activity x;
    private SmartRefreshLayout y;
    private RelativeLayout z;
    private com.zte.iptvclient.android.common.j.h s = null;
    Timer v = null;
    private boolean w = false;

    /* compiled from: STBMgrFragment.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f6370a;

        a(ArrayList arrayList) {
            this.f6370a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.y.a();
            b.this.t = this.f6370a;
            b.this.u.notifyDataSetChanged();
            if (b.this.t.size() == 0) {
                b.this.z.setVisibility(0);
                b.this.q.setVisibility(8);
            } else {
                b.this.z.setVisibility(8);
                b.this.q.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: STBMgrFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.h.b.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0269b implements View.OnClickListener {
        ViewOnClickListenerC0269b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: STBMgrFragment.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(b.this.getActivity(), (Class<?>) QRCodeScanGuideActivity.class);
            intent.putExtra("purpose", "bindstb");
            b.this.startActivityForResult(intent, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: STBMgrFragment.java */
    /* loaded from: classes.dex */
    public class d implements com.scwang.smartrefresh.layout.d.c {
        d() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            b.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: STBMgrFragment.java */
    /* loaded from: classes.dex */
    public class e implements AdapterView.OnItemClickListener {

        /* compiled from: STBMgrFragment.java */
        /* loaded from: classes.dex */
        class a implements SDKDownloadLoginSTBListener {
            a(e eVar) {
            }

            @Override // com.video.androidsdk.download.Linstener.SDKDownloadLoginSTBListener
            public void onLoginSTBReturn(int i) {
                com.zte.iptvclient.android.mobile.download.helper.c.c.a(i == 0);
                LogEx.d("STBMgrFragment", "result = " + i);
            }
        }

        e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int i2;
            if (b.this.t.size() != 0 && (i2 = (int) j) >= 0) {
                Device device = (Device) b.this.t.get(i2);
                if (device != null) {
                    LogEx.d("STBMgrFragment", "dmr mac = " + device.getMacAddress() + ",udn = " + device.getUDN());
                    if ("1".equals(ConfigMgr.readPropertie("SupportRemoteDownload", "0"))) {
                        if (!TextUtils.isEmpty(device.getHCAbility()) && device.getHCAbility().equals("1")) {
                            LogEx.d("STBMgrFragment", "current select stb is HC100 stb");
                            if (!StringUtil.isEmptyString(device.getHCDownloadPort()) && !StringUtil.isEmptyString(device.getSTBAddr())) {
                                LogEx.d("STBMgrFragment", "HC100 login stbaddr = " + device.getSTBAddr() + ",stbport=" + device.getHCDownloadPort());
                                SDKDownloadMgr.getInstance().loginSTB(device.getSTBAddr(), Integer.valueOf(device.getHCDownloadPort()).intValue(), new a(this));
                            } else {
                                LogEx.e("STBMgrFragment", "HC100 stbaddr or downloadport is empty");
                            }
                        } else {
                            LogEx.d("STBMgrFragment", "current select stb is non-HC100 stb");
                        }
                    }
                    b.this.a(device);
                }
                LogEx.d("STBMgrFragment", "sendUerNameAndDeviceIdToStb start");
                com.zte.iptvclient.android.mobile.h.a.a.g().a(SDKLoginMgr.getInstance().getUserID(), AndroidUniqueCode.getAndroidId(b.this.x), b.this.s.U());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: STBMgrFragment.java */
    /* loaded from: classes.dex */
    public class f extends TimerTask {

        /* compiled from: STBMgrFragment.java */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.u.notifyDataSetChanged();
                if (b.this.t.size() == 0) {
                    b.this.z.setVisibility(0);
                    b.this.q.setVisibility(8);
                } else {
                    b.this.z.setVisibility(8);
                    b.this.q.setVisibility(0);
                }
                b.this.y.a();
            }
        }

        f() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            b.this.w = false;
            b.this.q.post(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: STBMgrFragment.java */
    /* loaded from: classes.dex */
    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Intent f6378a;

        g(Intent intent) {
            this.f6378a = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            String stringExtra = this.f6378a.getStringExtra("userid");
            new com.zte.iptvclient.android.mobile.h.b.b.a(b.this.x, this.f6378a.getStringExtra("deviceid"), stringExtra, b.this).a(b.this.getView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: STBMgrFragment.java */
    /* loaded from: classes.dex */
    public class h extends BaseAdapter {

        /* compiled from: STBMgrFragment.java */
        /* loaded from: classes.dex */
        class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ C0270b f6381a;

            a(C0270b c0270b) {
                this.f6381a = c0270b;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag();
                if (str != null) {
                    com.zte.iptvclient.android.mobile.h.b.a.a aVar = new com.zte.iptvclient.android.mobile.h.b.a.a();
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence(ParamConst.DLNA_GETLIST_RSP_STBNAME, this.f6381a.f6383a.getText());
                    bundle.putString("STBUdn", str);
                    aVar.setArguments(bundle);
                    aVar.setTargetFragment(b.this, 0);
                    r b2 = b.this.getFragmentManager().b();
                    b2.c(b.this);
                    b2.a(b.this.getId(), aVar, "STBChangeNameFragment");
                    b2.a((String) null);
                    b2.a();
                }
            }
        }

        /* compiled from: STBMgrFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.h.b.a.b$h$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private class C0270b {

            /* renamed from: a, reason: collision with root package name */
            TextView f6383a;

            /* renamed from: b, reason: collision with root package name */
            TextView f6384b;

            /* renamed from: c, reason: collision with root package name */
            TextView f6385c;

            /* renamed from: d, reason: collision with root package name */
            ImageView f6386d;

            private C0270b(h hVar) {
            }

            /* synthetic */ C0270b(h hVar, a aVar) {
                this(hVar);
            }
        }

        private h() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (b.this.t == null) {
                return 0;
            }
            return b.this.t.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (b.this.t == null) {
                return null;
            }
            return b.this.t.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            C0270b c0270b;
            SharedPreferences sharedPreferences = b.this.x.getSharedPreferences("stbcachefile", 0);
            Device device = (Device) b.this.t.get(i);
            a aVar = null;
            if (device == null) {
                return null;
            }
            if (view == null) {
                c0270b = new C0270b(this, aVar);
                view2 = LayoutInflater.from(b.this.x).inflate(R.layout.stbmgr_list_item, (ViewGroup) null);
                c0270b.f6383a = (TextView) view2.findViewById(R.id.stblist_item_name);
                c0270b.f6384b = (TextView) view2.findViewById(R.id.stblist_item_state_online);
                c0270b.f6385c = (TextView) view2.findViewById(R.id.stblist_item_state_linked);
                c0270b.f6386d = (ImageView) view2.findViewById(R.id.stblist_item_edit);
                com.zte.iptvclient.common.uiframe.f.a(c0270b.f6383a);
                com.zte.iptvclient.common.uiframe.f.a(c0270b.f6384b);
                com.zte.iptvclient.common.uiframe.f.a(c0270b.f6385c);
                com.zte.iptvclient.common.uiframe.f.a(c0270b.f6386d);
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.ll_item_frame));
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.ll_item));
                view2.setTag(c0270b);
            } else {
                view2 = view;
                c0270b = (C0270b) view.getTag();
            }
            String friendlyName = device.getFriendlyName();
            String udn = device.getUDN();
            c0270b.f6386d.setTag(udn);
            c0270b.f6383a.setText(sharedPreferences.getString(udn, friendlyName));
            c0270b.f6384b.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.stb_state_online));
            c0270b.f6385c.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.stb_state_linked));
            Device b2 = com.zte.iptvclient.android.mobile.h.a.a.g().b();
            if (b2 != null && b2.getUDN().equals(device.getUDN())) {
                c0270b.f6385c.setVisibility(0);
                c0270b.f6384b.setVisibility(8);
            } else {
                c0270b.f6385c.setVisibility(8);
                c0270b.f6384b.setVisibility(0);
            }
            c0270b.f6386d.setOnClickListener(new a(c0270b));
            return view2;
        }

        /* synthetic */ h(b bVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        this.t.clear();
        this.u.notifyDataSetChanged();
        if (this.w) {
            return;
        }
        this.w = true;
        LogEx.d("STBMgrFragment", "STBMgrFragment scanDevices");
        com.zte.iptvclient.android.mobile.h.a.a.g().c();
        Timer timer = this.v;
        if (timer != null) {
            timer.cancel();
            this.v.purge();
            this.v = null;
        }
        Timer timer2 = new Timer();
        this.v = timer2;
        timer2.schedule(new f(), 12000L);
    }

    private void J() {
        this.p.setOnClickListener(new ViewOnClickListenerC0269b());
        this.r.setOnClickListener(new c());
        this.y.a(new d());
        this.q.setOnItemClickListener(new e());
    }

    @Override // com.zte.iptvclient.android.mobile.h.b.a.a.f
    public void n() {
        this.u.notifyDataSetChanged();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        J();
        this.t = com.zte.iptvclient.android.mobile.h.a.a.g().a();
        h hVar = new h(this, null);
        this.u = hVar;
        this.q.setAdapter((ListAdapter) hVar);
        this.u.notifyDataSetChanged();
        if (this.t.size() == 0) {
            this.z.setVisibility(0);
            this.q.setVisibility(8);
        } else {
            this.z.setVisibility(8);
            this.q.setVisibility(0);
        }
        LogEx.d("STBMgrFragment", "STBMgrFragment scanDevices");
        com.zte.iptvclient.android.mobile.h.a.a.g().c();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.x = activity;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s = new com.zte.iptvclient.android.common.j.h(this.x);
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.stbmgr_fragment, viewGroup, false);
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        LogEx.d("STBMgrFragment", "STBMgrFragment scanDevices");
        com.zte.iptvclient.android.mobile.h.a.a.g().c();
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.l.b bVar) {
        if (bVar == null) {
            return;
        }
        this.w = false;
        Timer timer = this.v;
        if (timer != null) {
            timer.cancel();
            this.v.purge();
            this.v = null;
        }
        LogEx.d("STBMgrFragment", "dlna event [" + bVar.a() + "]");
        this.t.clear();
        this.u.notifyDataSetChanged();
        String a2 = bVar.a();
        if (DLNAEvent.EVENT_DEVICE_ONLINE.equals(a2) || DLNAEvent.EVENT_DEVICE_OFFLINE.equals(a2)) {
            ArrayList arrayList = new ArrayList();
            ArrayList<Device> a3 = com.zte.iptvclient.android.mobile.h.a.a.g().a();
            LogEx.d("STBMgrFragment", " dmrlist size = " + a3.size());
            for (Device device : a3) {
                if (device != null) {
                    arrayList.add(device);
                }
            }
            this.q.postDelayed(new a(arrayList), 500L);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Timer timer = this.v;
        if (timer != null) {
            timer.cancel();
            this.v = null;
        }
        super.onStop();
    }

    @Override // com.zte.iptvclient.android.mobile.h.b.b.a.c
    public void p(String str) {
        com.zte.iptvclient.android.mobile.h.a.a.g().a(str);
    }

    private void d(View view) {
        Button button = (Button) view.findViewById(R.id.btn_back);
        this.p = button;
        if (this.o) {
            button.setVisibility(0);
        }
        this.q = (ListView) view.findViewById(R.id.lv_stblist);
        this.r = (FrameLayout) view.findViewById(R.id.pair_mybox_flayout);
        ((TextView) view.findViewById(R.id.title_txt)).setText(R.string.stb_title);
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        TextView textView = (TextView) view.findViewById(R.id.txt_pare_my_box);
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.qrscanguide_hint_stbbind));
        ((TextView) view.findViewById(R.id.txt_nofind_tip)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.stb_not_found));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_txt));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_bottom_line));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_bottom_line1));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.pair_mybox_llayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_pare_my_box));
        com.zte.iptvclient.common.uiframe.f.a(textView);
        this.y = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.z = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.z.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.z.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.z.findViewById(R.id.refresh_image));
        this.z.setVisibility(8);
        this.y.a(new DefaultRefreshHeader(this.h));
        this.y.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.y;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.y;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.y.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Device device) {
        this.s.C(device.getUDN());
        com.zte.iptvclient.android.mobile.h.a.a.g().a(device);
        this.u.notifyDataSetChanged();
    }

    public void a(int i, Intent intent) {
        new Handler().post(new g(intent));
    }
}
