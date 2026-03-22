package com.zte.iptvclient.android.mobile.u.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.facebook.internal.ServerProtocol;
import com.video.androidsdk.cast.bean.DLNAEvent;
import com.video.androidsdk.cast.bean.Device;
import com.video.androidsdk.common.AES;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.a.a.e.l;
import com.zte.iptvclient.android.common.javabean.models.Feature;
import com.zte.iptvclient.android.common.k.o;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RemoteControlFragment.java */
/* loaded from: classes.dex */
public class a extends com.zte.fragmentlib.b implements View.OnLayoutChangeListener {
    public static boolean a0 = false;
    private static l.h b0;
    private com.zte.iptvclient.android.common.j.h A;
    private ViewPager B;
    private l C;
    private ArrayList<View> D;
    private com.zte.iptvclient.android.mobile.u.b.b.b E;
    private com.zte.iptvclient.android.mobile.u.b.b.a F;
    private com.zte.iptvclient.android.mobile.u.b.a.a G;
    private com.zte.iptvclient.android.mobile.u.b.b.c J;
    private com.zte.iptvclient.android.mobile.n.c.b K;
    private boolean O;
    private AlertDialog P;
    private TextView Q;
    private Button R;
    private TextView S;
    private TextView T;
    private TextView U;
    private TextView V;
    private TextView W;
    private TextView X;
    private FrameLayout Y;
    private com.zte.iptvclient.android.common.customview.a.a.e.j Z;
    private RelativeLayout q;
    private Button r;
    private TextView s;
    private Button t;
    private ImageView u;
    private ImageView v;
    private ImageView w;
    private com.zte.iptvclient.android.common.customview.a.a.e.l x;
    private int p = 0;
    private ProgressDialog y = null;
    private boolean z = false;
    private String L = "";
    private String M = "";
    private String N = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteControlFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.u.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0358a implements t.e {
        C0358a() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void a() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void b() {
            a aVar = a.this;
            aVar.e(aVar.L, a.this.N);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteControlFragment.java */
    /* loaded from: classes2.dex */
    public class b implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        b() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            ((com.zte.fragmentlib.b) a.this).h.d();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("returncode", "");
                String optString2 = jSONObject.optString("errormsg", "");
                if (!optString.equals("0") && !optString.equals("74144054")) {
                    if (optString.equals("74144053")) {
                        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.connect_iptv_account_fail_for_too_many) + " (" + optString + ")");
                        LogEx.d("RemoteControlFragment", "bind iptvaccount resultCode=" + optString + "errormsg=" + optString2);
                        return;
                    }
                    if (optString.equals("74144052")) {
                        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.connect_iptv_account_not_exsit) + " (" + optString + ")");
                        LogEx.d("RemoteControlFragment", "bind iptvaccount resultCode=" + optString + "errormsg=" + optString2);
                        return;
                    }
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.connect_iptv_account_fail) + " (" + optString + ")");
                    LogEx.d("RemoteControlFragment", "bind iptvaccount resultCode=" + optString + "errormsg=" + optString2);
                    return;
                }
                if (!StringUtil.isEmptyString(a.this.M)) {
                    a.this.A.B(a.this.M);
                }
                a.this.A.C("");
                a.this.f(a.this.A.V(), a.this.A.D());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            ((com.zte.fragmentlib.b) a.this).h.d();
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.connect_iptv_account_fail) + " (" + i + ")");
            LogEx.d("RemoteControlFragment", "bind iptvaccount resultCode=" + i + "errormsg=" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteControlFragment.java */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.x.isShowing()) {
                return;
            }
            a.this.Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteControlFragment.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnTouchListener {
        d(a aVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteControlFragment.java */
    /* loaded from: classes2.dex */
    public class e implements l.h {
        e() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.l.h
        public void c() {
            Device b2 = com.zte.iptvclient.android.mobile.h.a.a.g().b();
            if (b2 == null) {
                a.this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.toast_nostb));
                return;
            }
            String macAddress = b2.getMacAddress();
            String friendlyName = b2.getFriendlyName();
            if (friendlyName != null) {
                macAddress = friendlyName;
            }
            String udn = b2.getUDN();
            if (macAddress != null) {
                macAddress = ((com.zte.fragmentlib.b) a.this).h.getSharedPreferences("stbcachefile", 0).getString(udn, macAddress);
            }
            a.this.s.setText(macAddress);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteControlFragment.java */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.a(((com.zte.fragmentlib.b) a.this).h, view)) {
                a.this.A();
            } else {
                a.this.F();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteControlFragment.java */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.O = true;
            if (a.this.A.s()) {
                a.this.A.k(false);
                a.this.K();
            } else {
                a.this.A.k(true);
                a.this.L();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteControlFragment.java */
    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!a.this.J()) {
                a.this.Q();
            } else {
                a.this.M();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteControlFragment.java */
    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {
        i() {
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
    /* compiled from: RemoteControlFragment.java */
    /* loaded from: classes2.dex */
    public class j implements ViewPager.i {
        j() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void b(int i) {
            int size = i % a.this.D.size();
            a.this.p = size;
            if (a.this.p == 2) {
                if (a.this.E.b()) {
                    a.this.E.d();
                    a aVar = a.this;
                    aVar.a(aVar.E.b(), (String) null);
                }
            } else {
                a.this.E.c();
                a.this.a(false, (String) null);
                a.this.E.a(false);
            }
            if (size == 0) {
                a.this.u.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.remote_page_dot_nor));
                ((com.zte.fragmentlib.b) a.this).h.a(a.this.u, "src", R.drawable.remote_page_dot_nor);
                a.this.v.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.remote_page_dot_press));
                ((com.zte.fragmentlib.b) a.this).h.a(a.this.v, "src", R.drawable.remote_page_dot_press);
                a.this.w.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.remote_page_dot_press));
                ((com.zte.fragmentlib.b) a.this).h.a(a.this.w, "src", R.drawable.remote_page_dot_press);
                return;
            }
            if (size == 1) {
                a.this.u.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.remote_page_dot_press));
                ((com.zte.fragmentlib.b) a.this).h.a(a.this.u, "src", R.drawable.remote_page_dot_press);
                a.this.v.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.remote_page_dot_nor));
                ((com.zte.fragmentlib.b) a.this).h.a(a.this.v, "src", R.drawable.remote_page_dot_nor);
                a.this.w.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.remote_page_dot_press));
                ((com.zte.fragmentlib.b) a.this).h.a(a.this.w, "src", R.drawable.remote_page_dot_press);
                return;
            }
            if (size != 2) {
                return;
            }
            a.this.u.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.remote_page_dot_press));
            ((com.zte.fragmentlib.b) a.this).h.a(a.this.u, "src", R.drawable.remote_page_dot_press);
            a.this.v.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.remote_page_dot_press));
            ((com.zte.fragmentlib.b) a.this).h.a(a.this.v, "src", R.drawable.remote_page_dot_press);
            a.this.w.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.remote_page_dot_nor));
            ((com.zte.fragmentlib.b) a.this).h.a(a.this.w, "src", R.drawable.remote_page_dot_nor);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteControlFragment.java */
    /* loaded from: classes2.dex */
    public class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.P.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RemoteControlFragment.java */
    /* loaded from: classes2.dex */
    public class l extends androidx.viewpager.widget.a {
        private l() {
        }

        @Override // androidx.viewpager.widget.a
        public int a() {
            if (a.this.D != null && a.this.D.size() > 2) {
                return Integer.MAX_VALUE;
            }
            if (a.this.D != null) {
                return a.this.D.size();
            }
            return 0;
        }

        /* synthetic */ l(a aVar, c cVar) {
            this();
        }

        @Override // androidx.viewpager.widget.a
        public boolean a(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // androidx.viewpager.widget.a
        public Object a(ViewGroup viewGroup, int i) {
            if (a.this.D == null || a.this.D.size() <= 2) {
                if (a.this.D == null) {
                    return "";
                }
                viewGroup.addView((View) a.this.D.get(i), 0);
                return a.this.D.get(i);
            }
            int size = i % a.this.D.size();
            viewGroup.removeView((View) a.this.D.get(size));
            viewGroup.addView((View) a.this.D.get(size), 0);
            return a.this.D.get(size);
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i, Object obj) {
            if (a.this.D == null || a.this.D.size() > 2) {
                return;
            }
            viewGroup.removeView((View) a.this.D.get(i));
        }
    }

    public a() {
        new c();
    }

    private void O() {
        e eVar = new e();
        b0 = eVar;
        this.x.a(eVar);
        this.r.setOnClickListener(new f());
        this.t.setOnClickListener(new g());
        this.s.setOnClickListener(new h());
        this.R.setOnClickListener(new i());
        this.B.d(new j());
    }

    private void P() {
        new Handler();
        this.x = new com.zte.iptvclient.android.common.customview.a.a.e.l(this.h, true);
        ProgressDialog progressDialog = new ProgressDialog(this.h);
        this.y = progressDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        this.y.setMessage(com.zte.iptvclient.android.common.i.a.a.a(R.string.waiting));
        this.y.setCancelable(true);
        Device b2 = com.zte.iptvclient.android.mobile.h.a.a.g().b();
        LogEx.d("RemoteControlFragment", "dmr = " + b2);
        if (b2 == null) {
            this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.toast_nostb));
            return;
        }
        String macAddress = b2.getMacAddress();
        String friendlyName = b2.getFriendlyName();
        if (friendlyName != null) {
            macAddress = friendlyName;
        }
        String udn = b2.getUDN();
        if (macAddress != null) {
            macAddress = this.h.getSharedPreferences("stbcachefile", 0).getString(udn, macAddress);
        }
        this.s.setText(macAddress);
        this.z = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        this.x.a(b0);
        this.x.show();
        this.x.a();
    }

    public int I() {
        return this.q.getBottom();
    }

    public boolean J() {
        return false;
    }

    public void K() {
        if (TextUtils.equals("1", ConfigMgr.readPropertie("isShow"))) {
            this.s.setTextColor(-1);
        }
        this.t.setBackground(c.a.a.a.d.b.d().d(R.drawable.night));
        this.h.a(this.t, "background", R.drawable.night);
        this.F.b();
        this.G.a();
        this.E.e();
    }

    public void L() {
        this.s.setTextColor(getResources().getColor(R.color.remote_title_textcolor));
        this.t.setBackground(c.a.a.a.d.b.d().d(R.drawable.sun));
        this.h.a(this.t, "background", R.drawable.sun);
        this.F.c();
        this.G.b();
        this.J.b();
        this.E.f();
    }

    public void M() {
        WindowManager.LayoutParams attributes;
        this.P = new AlertDialog.Builder(this.h).create();
        View inflate = View.inflate(this.h, R.layout.remote_bind_iptv_dialog, null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.img_close);
        this.S = (TextView) inflate.findViewById(R.id.text_title);
        this.T = (TextView) inflate.findViewById(R.id.text_scan_bind);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.fl_scan);
        this.U = (TextView) inflate.findViewById(R.id.txt_scan);
        this.V = (TextView) inflate.findViewById(R.id.text_step_tip);
        this.W = (TextView) inflate.findViewById(R.id.txt_step1_content);
        this.X = (TextView) inflate.findViewById(R.id.txt_step2_content);
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.rl_dialog));
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        com.zte.iptvclient.common.uiframe.f.a(this.S);
        com.zte.iptvclient.common.uiframe.f.a(this.T);
        com.zte.iptvclient.common.uiframe.f.a(frameLayout);
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.rl_scan));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.img_scan));
        com.zte.iptvclient.common.uiframe.f.a(this.U);
        com.zte.iptvclient.common.uiframe.f.a(this.V);
        com.zte.iptvclient.common.uiframe.f.a(this.W);
        com.zte.iptvclient.common.uiframe.f.a(this.X);
        this.S.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.not_bind_stb));
        this.T.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.scan_to_bind));
        this.U.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.remote_scan));
        this.V.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.scan_stb_step));
        this.W.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.remote_scan_step1));
        this.X.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.remote_scan_step2));
        imageView.setOnClickListener(new k());
        this.P.show();
        this.P.setContentView(inflate);
        this.P.setCanceledOnTouchOutside(false);
        Window window = this.P.getWindow();
        if (window == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        double width = this.h.getWindowManager().getDefaultDisplay().getWidth();
        Double.isNaN(width);
        attributes.width = (int) (width * 0.75d);
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    public void N() {
        this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.toast_nostb));
        Q();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        O();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Window window;
        super.onCreate(bundle);
        this.Z = new com.zte.iptvclient.android.common.customview.a.a.e.j(this.h, R.style.dialog_order);
        Bundle arguments = getArguments();
        if (arguments != null) {
            a0 = arguments.getBoolean("IsPlayToRemote", false);
        }
        this.K = com.zte.iptvclient.android.mobile.n.c.b.k();
        this.A = new com.zte.iptvclient.android.common.j.h(this.h);
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(48);
        }
        if (EventBus.getDefault().isRegistered(this)) {
            return;
        }
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.remote_control_fragment, viewGroup, false);
        inflate.setLayoutDirection(0);
        d(inflate);
        e(inflate);
        P();
        if (a0) {
            this.r.setVisibility(0);
        }
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        Window window;
        LogEx.d("RemoteControlFragment", "onDestroy");
        EventBus.getDefault().unregister(this);
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(32);
        }
        com.zte.iptvclient.android.mobile.u.b.b.b bVar = this.E;
        if (bVar != null) {
            bVar.c();
        }
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.l.b bVar) {
        if (bVar == null) {
            return;
        }
        LogEx.d("RemoteControlFragment", "dlna event [" + bVar.a() + "]");
        String a2 = bVar.a();
        if (DLNAEvent.EVENT_DEVICE_ONLINE.equals(a2) || DLNAEvent.EVENT_DEVICE_OFFLINE.equals(a2)) {
            Device b2 = com.zte.iptvclient.android.mobile.h.a.a.g().b();
            if (b2 == null) {
                this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.toast_nostb));
                return;
            }
            Iterator<Device> it2 = com.zte.iptvclient.android.mobile.h.a.a.g().a().iterator();
            while (it2.hasNext()) {
                Device next = it2.next();
                if (next != null && next.getUDN().equals(b2.getUDN())) {
                    String macAddress = next.getMacAddress();
                    String friendlyName = next.getFriendlyName();
                    if (friendlyName != null) {
                        macAddress = friendlyName;
                    }
                    String udn = next.getUDN();
                    if (macAddress != null) {
                        macAddress = this.h.getSharedPreferences("stbcachefile", 0).getString(udn, macAddress);
                    }
                    this.s.setText(macAddress);
                    if (this.z) {
                        return;
                    }
                    this.x.dismiss();
                    this.z = true;
                    return;
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            return;
        }
        com.zte.iptvclient.android.common.player.k.c t = ((MainActivity) this.h).t();
        if (t != null) {
            t.F1();
        }
        ArrayList<Feature> d2 = com.zte.iptvclient.android.common.j.c.e().d();
        if (d2 != null && d2.size() > 0) {
            this.Y.setVisibility(8);
            this.A.p(true);
            this.s.setEnabled(true);
        } else {
            this.Y.setVisibility(0);
            this.A.p(false);
            this.s.setEnabled(false);
            this.Z.dismiss();
            this.Z.a();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
    }

    private void d(View view) {
        this.Y = (FrameLayout) view.findViewById(R.id.remote_feature);
        this.s = (TextView) view.findViewById(R.id.title_txts);
        this.R = (Button) view.findViewById(R.id.btn_back);
        TextView textView = (TextView) view.findViewById(R.id.title_txt);
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.remoter));
        ImageView imageView = (ImageView) view.findViewById(R.id.header_bottom_line);
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        if (BaseApp.a(this.h)) {
            imageView.setVisibility(0);
            com.zte.iptvclient.android.common.k.g.a(imageView, this.h);
        }
        if (BaseApp.a(this.h)) {
            this.R.setVisibility(8);
        } else {
            this.R.setVisibility(0);
        }
        if (!BaseApp.f()) {
            ArrayList<Feature> d2 = com.zte.iptvclient.android.common.j.c.e().d();
            if (d2 != null && d2.size() > 0) {
                this.Y.setVisibility(8);
                this.A.p(true);
                this.s.setEnabled(true);
            } else {
                this.Y.setVisibility(0);
                this.A.p(false);
                this.s.setEnabled(false);
                this.Z.dismiss();
                this.Z.a();
            }
        } else {
            ArrayList<Feature> d3 = com.zte.iptvclient.android.common.j.c.e().d();
            if (d3 != null && d3.size() > 0) {
                this.Y.setVisibility(8);
                this.A.p(true);
                this.s.setEnabled(true);
            } else {
                this.Y.setVisibility(0);
                this.A.p(false);
                this.s.setEnabled(false);
            }
        }
        TextView textView2 = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView2.setHeight(a2);
        this.r = (Button) view.findViewById(R.id.btn_close);
        this.Q = (TextView) view.findViewById(R.id.tv_play_control_title);
        this.t = (Button) view.findViewById(R.id.btn_sun_change);
        this.u = (ImageView) view.findViewById(R.id.imgvew_dot1);
        this.v = (ImageView) view.findViewById(R.id.imgvew_dot2);
        this.w = (ImageView) view.findViewById(R.id.imgvew_dot3);
        this.q = (RelativeLayout) view.findViewById(R.id.title_rlayouts);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.llayout_dot));
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.Q);
        com.zte.iptvclient.common.uiframe.f.a(this.R);
        com.zte.iptvclient.common.uiframe.f.a(textView);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.fl_num_show));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_remote_nums1));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_remote_nums2));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_remote_nums3));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
        this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.account_title));
        this.Y.setOnTouchListener(new d(this));
    }

    private void e(View view) {
        this.B = (ViewPager) view.findViewById(R.id.vewpager_contrainer);
        this.D = new ArrayList<>();
        this.C = new l(this, null);
        this.E = new com.zte.iptvclient.android.mobile.u.b.b.b(this.h, this);
        this.F = new com.zte.iptvclient.android.mobile.u.b.b.a(this.h, this);
        this.G = new com.zte.iptvclient.android.mobile.u.b.a.a(this.h, this);
        this.J = new com.zte.iptvclient.android.mobile.u.b.b.c(this.h, this);
        this.D.add(this.F);
        this.D.add(this.G);
        this.D.add(this.J);
        this.B.a(this.C);
        if (this.D.size() > 2) {
            this.B.d(this.D.size() * 100);
        }
    }

    private String g(String str, String str2) {
        String str3;
        String str4 = str + "$$";
        Calendar calendar = Calendar.getInstance();
        calendar.add(11, 1);
        try {
            str3 = com.zte.iptvclient.android.common.k.a.c((str4 + (Long.toHexString(calendar.getTimeInMillis() / 1000) + "$$") + (str2 + "$$") + com.zte.iptvclient.android.common.k.a.a(10)).getBytes(), AES.getEncryptKey("impkey").getBytes());
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = "";
        }
        String str5 = str3 != null ? str3 : "";
        LogEx.d("encryptionAES", "encriptStr: " + str5);
        return str5;
    }

    protected void f(String str, String str2) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.h.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            LogEx.d("LoginImp", "The network is not available.");
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.network_not_available));
        }
        this.K.a(str, str2);
    }

    public void a(boolean z, String str) {
        if (this.p == 2 && z) {
            this.s.setVisibility(4);
            this.s.setEnabled(false);
            this.Q.setVisibility(0);
            if (str != null) {
                this.Q.setText(str);
                return;
            }
            return;
        }
        this.s.setVisibility(0);
        if (this.A.I()) {
            this.s.setEnabled(true);
        } else {
            this.s.setEnabled(false);
        }
        this.Q.setVisibility(4);
        if (str != null) {
            this.Q.setText(str);
        }
    }

    public void a(int i2, Intent intent) {
        if (intent == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.get_iptv_userID_failed));
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(extras.getString("result"));
            this.L = jSONObject.getString("userid");
            this.M = jSONObject.getString("deviceid");
            this.N = jSONObject.getString("cpid");
        } catch (JSONException e2) {
            LogEx.d("RemoteControlFragment", "result JSONObject exception=" + e2.getMessage());
        }
        if (!StringUtil.isEmptyString(this.L) && !StringUtil.isEmptyString(this.M)) {
            t.a(this.h, com.zte.iptvclient.android.common.i.a.a.a(R.string.account_bind_stb_for_sure), new C0358a());
        } else {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.warn_qrcode_notexpected));
        }
    }

    public void e(String str, String str2) {
        this.h.q();
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setCharset("gbk");
        sDKNetHTTPRequest.setParam(ParamConst.BIND_IPTV_REQ_IPTVUSERID, str);
        sDKNetHTTPRequest.setParam("cpid", str2);
        sDKNetHTTPRequest.setParam("ottuserid", com.zte.iptvclient.common.uiframe.a.d("UserID"));
        sDKNetHTTPRequest.setParam(ParamConst.BIND_IPTV_REQ_ACTIONTYPE, "1");
        sDKNetHTTPRequest.setParam(ParamConst.BIND_IPTV_REQ_CHECKWORD, "");
        sDKNetHTTPRequest.setParam("userToken", com.zte.iptvclient.common.uiframe.a.d("UserToken"));
        sDKNetHTTPRequest.setParam("authinfo", g(com.zte.iptvclient.common.uiframe.a.d("UserID"), "1"));
        sDKNetHTTPRequest.startRequest(String.format("%s/ottuserbind", o.j().c()), HttpRequest.METHOD_POST, new b());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.u.b bVar) {
        if (bVar == null) {
            return;
        }
        a(bVar.b(), bVar.a());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.k kVar) {
        if (a0) {
            return;
        }
        com.zte.iptvclient.android.common.eventbus.multi.f fVar = new com.zte.iptvclient.android.common.eventbus.multi.f();
        fVar.a(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        EventBus.getDefault().post(fVar);
    }

    public static boolean a(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (!inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0)) {
            return false;
        }
        inputMethodManager.showSoftInput(view, 0);
        return true;
    }
}
