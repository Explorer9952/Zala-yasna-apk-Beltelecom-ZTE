package com.zte.iptvclient.android.mobile.user.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.a.a.e.f;
import com.zte.iptvclient.android.common.customview.view.textview.BadgerView;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.login.activity.LoginActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: MineFragment.java */
/* loaded from: classes.dex */
public class k extends com.zte.fragmentlib.b implements View.OnClickListener {
    private LinearLayout A;
    private TextView B;
    private TextView C;
    private TextView D;
    private ImageView E;
    private TextView F;
    private com.zte.iptvclient.android.common.f.b.j G;
    private int J = 0;
    private BadgerView K;
    private ScrollView L;
    private RelativeLayout M;
    private TextView N;
    private ImageView O;
    private float P;
    private TextView Q;
    private RelativeLayout R;
    private TextView S;
    private RelativeLayout T;
    private View U;
    private boolean V;
    private com.zte.iptvclient.android.common.j.h p;
    private com.zte.iptvclient.android.mobile.n.c.b q;
    private RelativeLayout r;
    private RelativeLayout s;
    private RelativeLayout t;
    private RelativeLayout u;
    private RelativeLayout v;
    private RelativeLayout w;
    private RelativeLayout x;
    private Button y;
    private RelativeLayout z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MineFragment.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnScrollChangeListener {
        a() {
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i, int i2, int i3, int i4) {
            k.this.N.setText(k.this.B.getText());
            LogEx.d("MineFragment", "onScrollChange y = " + i2 + ",,,mIUserDetailHeight = " + k.this.P);
            float f = (float) i2;
            if (f - (k.this.P / 2.0f) >= 0.0f && f <= k.this.P) {
                float f2 = (f - (k.this.P / 2.0f)) / (k.this.P / 2.0f);
                LogEx.d("MineFragment", "percent = " + f2);
                k.this.r.setAlpha(1.0f - f2);
                k.this.M.setVisibility(0);
                k.this.M.setAlpha(f2);
                k.this.T.setVisibility(0);
                k.this.T.setAlpha(f2);
            } else if (f - (k.this.P / 2.0f) < 0.0f) {
                k.this.r.setAlpha(1.0f);
                k.this.M.setVisibility(8);
                k.this.T.setVisibility(8);
            } else {
                k.this.M.setAlpha(1.0f);
                k.this.T.setAlpha(1.0f);
            }
            if (k.this.P >= f) {
                float f3 = f / k.this.P;
                LogEx.d("MineFragment", "percent = " + f3);
                k.this.r.setAlpha(1.0f - f3);
                k.this.M.setAlpha(f3);
                k.this.T.setAlpha(f3);
                if (i2 == 0) {
                    k.this.M.setAlpha(0.0f);
                    k.this.M.setVisibility(8);
                    k.this.T.setAlpha(0.0f);
                    k.this.T.setVisibility(8);
                    return;
                }
                k.this.M.setVisibility(0);
                k.this.M.setAlpha(f3);
                k.this.T.setVisibility(0);
                k.this.T.setAlpha(f3);
                return;
            }
            k.this.M.setAlpha(1.0f);
            k.this.T.setAlpha(1.0f);
            k.this.r.setAlpha(0.0f);
        }
    }

    /* compiled from: MineFragment.java */
    /* loaded from: classes2.dex */
    class b implements f.c {
        b() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void a() {
            k.this.I();
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MineFragment.java */
    /* loaded from: classes2.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EditText f7461a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.a.b f7462b;

        c(EditText editText, com.zte.iptvclient.android.common.customview.a.a.a.b bVar) {
            this.f7461a = editText;
            this.f7462b = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (TextUtils.equals(this.f7461a.getText().toString(), k.this.p.u())) {
                k.this.a("parentcontral", (Bundle) null);
                this.f7462b.dismiss();
            } else if ("2".equals(com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_INNOVATIVE_SERVICE_FLAG))) {
                this.f7462b.dismiss();
            } else if (this.f7461a.getText() != null && !TextUtils.isEmpty(this.f7461a.getText())) {
                this.f7461a.setText("");
                this.f7462b.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.limitpwd_is_wrong));
            } else {
                this.f7462b.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.profile_select_empty));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MineFragment.java */
    /* loaded from: classes2.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.a.b f7464a;

        d(k kVar, com.zte.iptvclient.android.common.customview.a.a.a.b bVar) {
            this.f7464a = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f7464a.dismiss();
        }
    }

    private void J() {
        this.p = new com.zte.iptvclient.android.common.j.h(this.h);
        this.G = com.zte.iptvclient.android.common.f.b.j.e();
    }

    private void K() {
        com.zte.iptvclient.android.common.f.b.j jVar = this.G;
        if (jVar == null) {
            this.K.a();
            return;
        }
        int d2 = jVar.d();
        this.J = d2;
        String num = Integer.toString(d2);
        int i = this.J;
        if (i != 0 && i > 0) {
            this.K.setText(num);
            this.K.b();
        } else {
            this.K.a();
        }
    }

    private void L() {
        this.M.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.C.setOnClickListener(this);
    }

    private void M() {
        if (TextUtils.equals(ConfigMgr.readPropertie("IsShowChildLock"), "1")) {
            if (TextUtils.equals(ConfigMgr.readPropertie("EuropeLogin"), "0")) {
                if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
                    if (TextUtils.equals(this.p.H(), "0")) {
                        b(true);
                        return;
                    } else {
                        b(false);
                        return;
                    }
                }
                b(false);
                return;
            }
            b(true);
            return;
        }
        b(false);
    }

    private void N() {
        if (this.V) {
            this.r.invalidate();
        }
    }

    private void O() {
        if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
            this.y.setVisibility(8);
        } else {
            this.y.setVisibility(0);
        }
        M();
        this.B.setVisibility(0);
        if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
            LogEx.d("MineFragment", "数据===" + this.p.V() + "," + this.p.y());
            if (!TextUtils.isEmpty(this.p.V())) {
                this.B.setText(this.p.V());
                this.N.setText(this.p.V());
            }
            this.A.setVisibility(0);
            if (!TextUtils.isEmpty(this.p.y())) {
                this.D.setText(this.p.y());
            } else {
                this.A.setVisibility(8);
            }
            this.C.setVisibility(8);
            return;
        }
        if (com.zte.iptvclient.android.common.k.c.a()) {
            return;
        }
        this.B.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.mine_guest_account_nsername));
        this.N.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.mine_guest_account_nsername));
        this.E.setVisibility(8);
        this.C.setVisibility(0);
        this.A.setVisibility(8);
        this.O.setVisibility(8);
    }

    private void P() {
        if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
            this.A.setVisibility(0);
            if (!TextUtils.isEmpty(this.p.y())) {
                this.D.setText(this.p.y());
                return;
            } else {
                this.A.setVisibility(8);
                return;
            }
        }
        if (com.zte.iptvclient.android.common.k.c.a()) {
            return;
        }
        this.A.setVisibility(8);
    }

    public void I() {
        this.q.a(com.zte.iptvclient.android.common.c.e.a.f4112a);
        com.zte.iptvclient.android.common.f.a.a().cancel();
        this.q.h();
        this.y.setVisibility(8);
        this.B.setVisibility(0);
        this.B.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.mine_guest_account_nsername));
        this.N.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.mine_guest_account_nsername));
        this.E.setVisibility(8);
        this.C.setVisibility(0);
        this.A.setVisibility(8);
        this.O.setVisibility(8);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        L();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_loginout /* 2131296461 */:
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                com.zte.iptvclient.android.common.customview.a.a.e.f fVar = new com.zte.iptvclient.android.common.customview.a.a.e.f(this.h, -1, R.string.logout_confirm, R.drawable.lock_dialog_rightbg, R.string.common_confirm, 0, R.drawable.lock_dialog_leftbg, R.string.common_cancel, 0, new b());
                fVar.a();
                fVar.setCanceledOnTouchOutside(false);
                return;
            case R.id.rl_Remote /* 2131297721 */:
                if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                    if (com.zte.iptvclient.android.common.k.c.a()) {
                        return;
                    }
                    t.a((Context) this.h, false);
                    return;
                } else {
                    if (com.zte.iptvclient.android.common.k.c.a()) {
                        return;
                    }
                    a("fragment_remote", (Bundle) null);
                    return;
                }
            case R.id.rl_lineup /* 2131297795 */:
                if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                    if (com.zte.iptvclient.android.common.k.c.a()) {
                        return;
                    }
                    t.a((Context) this.h, false);
                    return;
                } else {
                    if (com.zte.iptvclient.android.common.k.c.a()) {
                        return;
                    }
                    a("channellineup", (Bundle) null);
                    return;
                }
            case R.id.rl_mine_help_feedback /* 2131297804 */:
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                a("help", (Bundle) null);
                return;
            case R.id.rl_mine_message /* 2131297805 */:
                a("messagecenter", (Bundle) null);
                return;
            case R.id.rl_my_childlock /* 2131297812 */:
                if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
                    com.zte.iptvclient.android.common.j.h hVar = this.p;
                    if (hVar != null && hVar.C()) {
                        a(this.h);
                        return;
                    } else {
                        a("parentcontral", (Bundle) null);
                        return;
                    }
                }
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                t.a((Context) this.h, false);
                return;
            case R.id.rl_my_share /* 2131297813 */:
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                a("scan_share", (Bundle) null);
                return;
            case R.id.rl_settings /* 2131297862 */:
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                a("setting", (Bundle) null);
                return;
            case R.id.rl_terminal_binding /* 2131297874 */:
                if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
                    if (com.zte.iptvclient.android.common.k.c.a()) {
                        return;
                    }
                    a("terminalbindingbt", (Bundle) null);
                    return;
                } else {
                    if (com.zte.iptvclient.android.common.k.c.a()) {
                        return;
                    }
                    t.a((Context) this.h, false);
                    return;
                }
            case R.id.tv_login_top /* 2131298258 */:
            case R.id.tv_mine_login_and_register /* 2131298263 */:
                startActivity(new Intent(getActivity(), (Class<?>) LoginActivity.class));
                return;
            default:
                return;
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        if (this.U == null) {
            this.U = layoutInflater.inflate(R.layout.mine_fragment_grid, viewGroup, false);
            this.q = com.zte.iptvclient.android.mobile.n.c.b.k();
            J();
            d(this.U);
            this.P = com.zte.iptvclient.android.common.k.g.a(this.h, 130.0f);
        }
        return this.U;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        if (cVar.a().equals("0")) {
            O();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        LogEx.d("MineFragment", "---onResume---");
        super.onResume();
        N();
        this.V = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        LogEx.d("MineFragment", "---onStop---");
        super.onStop();
        this.V = true;
    }

    private void b(boolean z) {
        if (z) {
            RelativeLayout relativeLayout = this.z;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
                return;
            }
            return;
        }
        RelativeLayout relativeLayout2 = this.z;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
    }

    private void d(View view) {
        this.Q = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        this.Q.setHeight(a2);
        if (!BaseApp.a(this.h)) {
            this.T = (RelativeLayout) view.findViewById(R.id.rl_user_hint_status_top);
            TextView textView = (TextView) view.findViewById(R.id.user_hint_status_top);
            this.S = textView;
            textView.setHeight(a2);
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_status_top);
            this.R = relativeLayout;
            com.zte.iptvclient.common.uiframe.f.a(relativeLayout);
            com.zte.iptvclient.common.uiframe.f.a(this.T);
            com.zte.iptvclient.common.uiframe.f.a(this.S);
        }
        this.L = (ScrollView) view.findViewById(R.id.scrollview);
        if (Build.VERSION.SDK_INT >= 23 && "1".equals(ConfigMgr.readPropertie("isSupportUserTop"))) {
            this.L.setOnScrollChangeListener(new a());
        }
        e(view);
        if (TextUtils.equals(ConfigMgr.readPropertie("IsShowChildLock"), "1")) {
            this.z.setVisibility(0);
        } else {
            this.z.setVisibility(8);
        }
        BadgerView badgerView = new BadgerView(getActivity(), this.F);
        this.K = badgerView;
        badgerView.b(this.F.getGravity());
        this.K.setTextColor(-1);
        this.K.a(-65536);
        int d2 = this.G.d();
        this.J = d2;
        String num = Integer.toString(d2);
        int i = this.J;
        if (i != 0 && i > 0) {
            this.K.setText(num);
            this.K.b();
        } else {
            this.K.a();
        }
        com.zte.iptvclient.common.uiframe.f.a(this.F);
        com.zte.iptvclient.common.uiframe.f.a(this.K);
        O();
        this.B.setVisibility(0);
    }

    private void e(View view) {
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.top_navbar_logo_img));
        this.M = (RelativeLayout) view.findViewById(R.id.rl_user_hint);
        this.N = (TextView) view.findViewById(R.id.txt_username_top);
        this.O = (ImageView) view.findViewById(R.id.img_back_top);
        com.zte.iptvclient.common.uiframe.f.a(this.N);
        com.zte.iptvclient.common.uiframe.f.a(this.M);
        com.zte.iptvclient.common.uiframe.f.a(this.O);
        this.r = (RelativeLayout) view.findViewById(R.id.rl_my_account_details);
        this.s = (RelativeLayout) view.findViewById(R.id.rl_Remote);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        this.t = (RelativeLayout) view.findViewById(R.id.rl_lineup);
        this.u = (RelativeLayout) view.findViewById(R.id.rl_terminal_binding);
        this.v = (RelativeLayout) view.findViewById(R.id.rl_mine_help_feedback);
        this.w = (RelativeLayout) view.findViewById(R.id.rl_my_share);
        Button button = (Button) view.findViewById(R.id.btn_loginout);
        this.y = button;
        button.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.account_logout));
        this.z = (RelativeLayout) view.findViewById(R.id.rl_my_childlock);
        this.x = (RelativeLayout) view.findViewById(R.id.rl_settings);
        this.A = (LinearLayout) view.findViewById(R.id.ll_user_nickname);
        this.B = (TextView) view.findViewById(R.id.tv_mine_account_username);
        TextView textView = (TextView) view.findViewById(R.id.tv_mine_login_and_register);
        this.C = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.mine_login_or_register));
        this.D = (TextView) view.findViewById(R.id.tv_user_nickname);
        this.F = (TextView) view.findViewById(R.id.new_number);
        this.E = (ImageView) view.findViewById(R.id.iv_mine_account_back);
        com.zte.iptvclient.common.uiframe.f.a(this.D);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.iv_mine_help_feedback));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.iv_mine_my_share));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.iv_mine_my_childlock));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.iv_mine_account_icon));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_container));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.iv_mine_my_remote));
        TextView textView2 = (TextView) view.findViewById(R.id.txt_remote);
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.remoter));
        com.zte.iptvclient.common.uiframe.f.a(textView2);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.iv_mine_my_remote_arrow));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.iv_mine_my_lineup));
        TextView textView3 = (TextView) view.findViewById(R.id.txt_lineup);
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_lineup));
        com.zte.iptvclient.common.uiframe.f.a(textView3);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.iv_minge_right_arrow_lineup));
        TextView textView4 = (TextView) view.findViewById(R.id.tv_mine_my_childlock);
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.parental_control));
        com.zte.iptvclient.common.uiframe.f.a(textView4);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.iv_mine_my_childlock_arrow));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_terminal_binding));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.text_terminal_binding));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_terminal_binding_arrow));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_settings));
        TextView textView5 = (TextView) view.findViewById(R.id.tv_settings);
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.setting_title));
        com.zte.iptvclient.common.uiframe.f.a(textView5);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_settings_arrow));
        TextView textView6 = (TextView) view.findViewById(R.id.tv_mine_my_share);
        textView6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_share));
        com.zte.iptvclient.common.uiframe.f.a(textView6);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.iv_mine_my_share_arrow));
        TextView textView7 = (TextView) view.findViewById(R.id.tv_mine_help_feedback);
        textView7.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.help_feedbook));
        com.zte.iptvclient.common.uiframe.f.a(textView7);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.iv_mine_help_feedback_arrow));
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.y.a aVar) {
        O();
        P();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.p.a aVar) {
        K();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.d dVar) {
        O();
    }

    protected void a(Context context) {
        com.zte.iptvclient.android.common.customview.a.a.a.b bVar = new com.zte.iptvclient.android.common.customview.a.a.a.b(context);
        bVar.setTitle(com.zte.iptvclient.android.common.i.a.a.a(R.string.please_enter_parental_lock_password));
        bVar.b(R.string.common_confirm, new c(bVar.a(), bVar));
        bVar.a(R.string.common_cancel, new d(this, bVar));
        bVar.setCancelable(true);
        bVar.setCanceledOnTouchOutside(true);
        bVar.show();
    }
}
