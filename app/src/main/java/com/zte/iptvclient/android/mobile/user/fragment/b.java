package com.zte.iptvclient.android.mobile.user.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.a.a.e.f;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.login.activity.LoginActivity;
import com.zte.iptvclient.android.zala.R;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: AtAccountFragment.java */
/* loaded from: classes.dex */
public class b extends com.zte.fragmentlib.b {
    private static String F = "AtAccountFragment";
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private TextView E;
    private LinearLayout p;
    private Button q;
    private RelativeLayout r;
    private RelativeLayout s;
    private Button t;
    private com.zte.iptvclient.android.mobile.n.c.b u;
    private com.zte.iptvclient.android.common.j.h v;
    private RelativeLayout w;
    private RelativeLayout x;
    private RelativeLayout y;
    private TextView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtAccountFragment.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.getActivity() instanceof MainActivity) {
                b.this.F();
            } else if (b.this.getActivity() instanceof HostActivity) {
                b.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtAccountFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.user.fragment.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewOnClickListenerC0365b implements View.OnClickListener {

        /* compiled from: AtAccountFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.user.fragment.b$b$a */
        /* loaded from: classes2.dex */
        class a implements f.c {
            a() {
            }

            @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
            public void a() {
                b.this.I();
            }

            @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
            public void b() {
            }
        }

        ViewOnClickListenerC0365b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            com.zte.iptvclient.android.common.customview.a.a.e.f fVar = new com.zte.iptvclient.android.common.customview.a.a.e.f(((com.zte.fragmentlib.b) b.this).h, -1, R.string.logout_confirm, R.drawable.lock_dialog_rightbg, R.string.common_ok, 0, R.drawable.lock_dialog_rightbg, R.string.common_cancel, 0, new a());
            fVar.a();
            fVar.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtAccountFragment.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isSideMenu", false);
            if (!BaseApp.a(((com.zte.fragmentlib.b) b.this).h)) {
                b.this.a("at_balance", bundle);
                return;
            }
            com.zte.iptvclient.android.mobile.user.fragment.d dVar = new com.zte.iptvclient.android.mobile.user.fragment.d();
            dVar.setArguments(bundle);
            b.this.a(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtAccountFragment.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isSideMenu", false);
            if (!BaseApp.a(((com.zte.fragmentlib.b) b.this).h)) {
                b.this.a("at_recharge", bundle);
                return;
            }
            com.zte.iptvclient.android.mobile.user.fragment.c cVar = new com.zte.iptvclient.android.mobile.user.fragment.c();
            cVar.setArguments(bundle);
            b.this.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtAccountFragment.java */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isSideMenu", false);
            bundle.putString("from", "0");
            if (!BaseApp.a(((com.zte.fragmentlib.b) b.this).h)) {
                b.this.a("fragment_singleuser_changepwd", bundle);
                return;
            }
            n nVar = new n();
            nVar.setArguments(bundle);
            b.this.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtAccountFragment.java */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isSideMenu", false);
            if (!BaseApp.a(((com.zte.fragmentlib.b) b.this).h)) {
                b.this.a("terminalbindingbt", bundle);
                return;
            }
            p pVar = new p();
            pVar.setArguments(bundle);
            b.this.a(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtAccountFragment.java */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isSideMenu", false);
            if (!BaseApp.a(((com.zte.fragmentlib.b) b.this).h)) {
                b.this.a("modifypersonalinfo", bundle);
                return;
            }
            l lVar = new l();
            lVar.setArguments(bundle);
            b.this.a(lVar);
        }
    }

    private void J() {
        this.q.setOnClickListener(new a());
        this.t.setOnClickListener(new ViewOnClickListenerC0365b());
        this.r.setOnClickListener(new c());
        this.s.setOnClickListener(new d());
        this.w.setOnClickListener(new e());
        this.x.setOnClickListener(new f());
        this.y.setOnClickListener(new g());
    }

    public void I() {
        this.h.q();
        this.u.a(com.zte.iptvclient.android.common.c.e.a.f4112a);
        com.zte.iptvclient.android.common.f.a.a().cancel();
        this.u.h();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.u = com.zte.iptvclient.android.mobile.n.c.b.k();
        super.onActivityCreated(bundle);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.at_account_fragment, (ViewGroup) null);
        d(inflate);
        J();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.d dVar) {
        LogEx.d(F, "liuyang recv LogoutReturnEvent event");
        this.h.d();
        this.v.q("guest");
        if (BaseApp.a(this.h)) {
            return;
        }
        startActivity(new Intent(getActivity(), (Class<?>) LoginActivity.class));
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    private void d(View view) {
        this.p = (LinearLayout) view.findViewById(R.id.img_logo);
        this.q = (Button) view.findViewById(R.id.btn_back);
        this.r = (RelativeLayout) view.findViewById(R.id.rl_balance);
        this.s = (RelativeLayout) view.findViewById(R.id.rl_recharge);
        this.t = (Button) view.findViewById(R.id.btn_loginout);
        this.w = (RelativeLayout) view.findViewById(R.id.rl_change_password);
        this.x = (RelativeLayout) view.findViewById(R.id.rl_terminal_binding);
        this.y = (RelativeLayout) view.findViewById(R.id.at_rl_modify_personal_info);
        if (!BaseApp.a(this.h)) {
            this.z = (TextView) view.findViewById(R.id.at_txt_my_account);
            this.A = (TextView) view.findViewById(R.id.at_txt_change_password);
            this.B = (TextView) view.findViewById(R.id.at_txt_validity_date);
            this.C = (TextView) view.findViewById(R.id.at_txt_recharge);
            this.D = (TextView) view.findViewById(R.id.at_txt_terminal_binding);
            this.z.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_account));
            this.A.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.account_change_password));
            this.B.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.validity_date));
            this.C.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recharge));
            this.D.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.terminal_binding));
        }
        this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.account_logout));
        if (BaseApp.a(this.h)) {
            TextView textView = (TextView) view.findViewById(R.id.top);
            int a2 = v.a();
            if (a2 <= 0) {
                a2 = 60;
            }
            textView.setHeight(a2);
            this.q.setVisibility(8);
            TextView textView2 = (TextView) view.findViewById(R.id.txt_title);
            this.E = textView2;
            textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_btn_logout));
            com.zte.iptvclient.common.uiframe.f.a(this.E);
            ((TextView) view.findViewById(R.id.txt_personal)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_account));
            ((TextView) view.findViewById(R.id.txt_password)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.account_change_password));
            ((TextView) view.findViewById(R.id.txt_validity)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.validity_date));
            ((TextView) view.findViewById(R.id.txt_recharge)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recharge));
            ((TextView) view.findViewById(R.id.txt_binding)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.terminal_binding));
        }
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        this.v = new com.zte.iptvclient.android.common.j.h(this.h);
        if (!"1".equals(ConfigMgr.readPropertie("isBt"))) {
            this.x.setVisibility(8);
        }
        if ("1".equals(ConfigMgr.readPropertie("isShowRecharge"))) {
            return;
        }
        this.s.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Intent intent = new Intent(getActivity(), (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", str);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
