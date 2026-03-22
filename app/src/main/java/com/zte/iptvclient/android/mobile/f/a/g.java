package com.zte.iptvclient.android.mobile.f.a;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.SDKUserMgr;
import com.video.androidsdk.service.bean.UserSwitchReq;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.a.a.e.f;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.user.fragment.n;
import com.zte.iptvclient.android.zala.R;

/* compiled from: ParentalControlFragmentNew.java */
/* loaded from: classes.dex */
public class g extends com.zte.fragmentlib.b implements View.OnClickListener {
    private ImageView A;
    private RelativeLayout B;
    private TextView C;
    private ImageView D;
    private RelativeLayout E;
    private TextView F;
    private ImageView G;
    private RelativeLayout J;
    private ImageView K;
    private ImageView L;
    private ImageView M;
    private ImageView N;
    private h O;
    private boolean P = false;
    private Button p;
    private RelativeLayout q;
    private TextView r;
    private LinearLayout s;
    private RelativeLayout t;
    private TextView u;
    private ToggleButton v;
    private RelativeLayout w;
    private TextView x;
    private RelativeLayout y;
    private TextView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParentalControlFragmentNew.java */
    /* loaded from: classes.dex */
    public class a implements f.c {
        a() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void a() {
            g.this.P = false;
            g.this.J();
            g.this.v.setChecked(true);
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void b() {
            g.this.P = true;
            g.this.J();
            g.this.v.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParentalControlFragmentNew.java */
    /* loaded from: classes.dex */
    public class b implements f.c {
        b() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void a() {
            g.this.P = true;
            g.this.J();
            g.this.v.setChecked(false);
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void b() {
            g.this.P = false;
            g.this.J();
            g.this.v.setChecked(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParentalControlFragmentNew.java */
    /* loaded from: classes.dex */
    public class c implements SDKUserMgr.OnChangeUserSwitchReturnListener {
        c() {
        }

        @Override // com.video.androidsdk.service.SDKUserMgr.OnChangeUserSwitchReturnListener
        public void onChangeUserSwitchReturn(String str, String str2) {
            if (TextUtils.equals(str, "0")) {
                if (g.this.P) {
                    g.this.O.n(true);
                } else {
                    g.this.O.n(false);
                }
                g.this.b(true);
                return;
            }
            g.this.b(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        UserSwitchReq userSwitchReq = new UserSwitchReq(this.P ? "1" : "0", 3);
        userSwitchReq.setPassword(this.O.u());
        new SDKUserMgr().changeUserSwitch(userSwitchReq, new c());
    }

    public void I() {
        if (this.v.isChecked()) {
            com.zte.iptvclient.android.common.customview.a.a.e.f fVar = new com.zte.iptvclient.android.common.customview.a.a.e.f(this.h, R.drawable.custom_dialog_title_img, R.string.lock_confirm, R.drawable.custom_dialog_button_blue, R.string.common_ok, 0, R.drawable.custom_dialog_button_blue, R.string.common_cancel, 0, new a());
            fVar.a();
            fVar.setCancelable(false);
            fVar.setCanceledOnTouchOutside(false);
            return;
        }
        com.zte.iptvclient.android.common.customview.a.a.e.f fVar2 = new com.zte.iptvclient.android.common.customview.a.a.e.f(this.h, R.drawable.custom_dialog_title_img, R.string.unlock_confirm, R.drawable.custom_dialog_button_blue, R.string.common_ok, 0, R.drawable.custom_dialog_button_blue, R.string.common_cancel, 0, new b());
        fVar2.a();
        fVar2.setCancelable(false);
        fVar2.setCanceledOnTouchOutside(false);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back /* 2131296427 */:
                if (getActivity() instanceof MainActivity) {
                    F();
                    return;
                } else {
                    if (getActivity() instanceof HostActivity) {
                        getActivity().finish();
                        return;
                    }
                    return;
                }
            case R.id.child_mode_item /* 2131296536 */:
                if (BaseApp.a(this.h)) {
                    a(new d());
                    return;
                } else {
                    a("fragment_child_mode", (Bundle) null);
                    return;
                }
            case R.id.lock_first_item /* 2131297393 */:
                if (BaseApp.a(this.h)) {
                    a(new com.zte.iptvclient.android.mobile.f.a.b());
                    return;
                } else {
                    a("lock_channels_at", (Bundle) null);
                    return;
                }
            case R.id.lock_second_item /* 2131297399 */:
                if (BaseApp.a(this.h)) {
                    if ("1".equals(ConfigMgr.readPropertie("isShow"))) {
                        a(new com.zte.iptvclient.android.mobile.f.a.a());
                        return;
                    } else {
                        a(new e());
                        return;
                    }
                }
                a("level_modification", (Bundle) null);
                return;
            case R.id.lock_third_item /* 2131297400 */:
                if ("1".equals(ConfigMgr.readPropertie("isShow"))) {
                    Bundle bundle = new Bundle();
                    bundle.putString(ParamConst.USER_PWD_MODIGY_REQ_PASSWORDTYPE, "1");
                    bundle.putString("from", "1");
                    if (BaseApp.a(this.h)) {
                        n nVar = new n();
                        nVar.setArguments(bundle);
                        a(nVar);
                        return;
                    }
                    a("fragment_singleuser_changepwd", bundle);
                    return;
                }
                if (BaseApp.a(this.h)) {
                    a(new com.zte.iptvclient.android.mobile.user.fragment.h());
                    return;
                } else {
                    a("change_pwd", (Bundle) null);
                    return;
                }
            case R.id.tb_order_lock /* 2131298119 */:
                I();
                return;
            default:
                return;
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogEx.d("ParentalControlFragmentNew", "ParentalControlFragmentNew onCreate");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LogEx.d("ParentalControlFragmentNew", "ParentalControlFragmentNew onCreateView");
        View inflate = layoutInflater.inflate(R.layout.parental_control_fragment, viewGroup, false);
        this.O = new h(getActivity());
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
        this.q = (RelativeLayout) view.findViewById(R.id.lock_nomal);
        this.p = (Button) view.findViewById(R.id.btn_back);
        this.r = (TextView) view.findViewById(R.id.lock_nomal_title);
        this.s = (LinearLayout) view.findViewById(R.id.parental_control_item);
        this.t = (RelativeLayout) view.findViewById(R.id.rl_order_lock);
        this.u = (TextView) view.findViewById(R.id.txt_order_lock);
        this.v = (ToggleButton) view.findViewById(R.id.tb_order_lock);
        this.w = (RelativeLayout) view.findViewById(R.id.rl_order_lock_introduction);
        this.x = (TextView) view.findViewById(R.id.txt_order_lock_introduction);
        this.K = (ImageView) view.findViewById(R.id.divider);
        this.y = (RelativeLayout) view.findViewById(R.id.lock_first_item);
        this.z = (TextView) view.findViewById(R.id.tv_channel_text);
        this.A = (ImageView) view.findViewById(R.id.img_channel_lock);
        this.L = (ImageView) view.findViewById(R.id.divider2);
        this.B = (RelativeLayout) view.findViewById(R.id.lock_second_item);
        this.C = (TextView) view.findViewById(R.id.Level_mod_text);
        this.D = (ImageView) view.findViewById(R.id.img_level_lock);
        this.M = (ImageView) view.findViewById(R.id.divider3);
        this.E = (RelativeLayout) view.findViewById(R.id.lock_third_item);
        this.F = (TextView) view.findViewById(R.id.change_pwd_text);
        this.G = (ImageView) view.findViewById(R.id.img_change_password);
        this.N = (ImageView) view.findViewById(R.id.divider4);
        this.J = (RelativeLayout) view.findViewById(R.id.child_mode_item);
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Is_Show_Child");
        if (!TextUtils.isEmpty(c2) && c2.equals("1")) {
            this.J.setVisibility(0);
        } else {
            this.J.setVisibility(8);
        }
        ((TextView) view.findViewById(R.id.childe_mode_text)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.chilld_mode_txt));
        ImageView imageView = (ImageView) view.findViewById(R.id.img_childe_mode_lock);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.divider_line);
        com.zte.iptvclient.common.uiframe.f.a(this.J);
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        com.zte.iptvclient.common.uiframe.f.a(imageView2);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.K);
        com.zte.iptvclient.common.uiframe.f.a(this.E);
        com.zte.iptvclient.common.uiframe.f.a(this.G);
        com.zte.iptvclient.common.uiframe.f.a(this.L);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        com.zte.iptvclient.common.uiframe.f.a(this.D);
        com.zte.iptvclient.common.uiframe.f.a(this.M);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.N);
        this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.parental_control));
        this.u.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.cancel_purchase_password));
        this.x.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.lock_hint));
        this.F.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.change_password));
        this.C.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.profile_pd_rating));
        this.z.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.profile_pcb_title));
        this.t.setVisibility(8);
        this.w.setVisibility(8);
        this.p.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.J.setOnClickListener(this);
        if (this.O != null) {
            this.v.setChecked(!r0.A());
        }
        if ("0".equals(ConfigMgr.readPropertie("EuropeLogin"))) {
            this.B.setVisibility(8);
            this.M.setVisibility(8);
            this.y.setVisibility(8);
            this.N.setVisibility(8);
        } else {
            this.B.setVisibility(0);
            this.M.setVisibility(0);
            this.y.setVisibility(0);
            this.N.setVisibility(0);
        }
        ImageView imageView3 = (ImageView) view.findViewById(R.id.parental_control_line);
        com.zte.iptvclient.common.uiframe.f.a(imageView3);
        if (BaseApp.a(this.h)) {
            com.zte.iptvclient.android.common.k.g.a(imageView3, this.h);
        }
    }

    private void a(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Intent intent = new Intent(getActivity(), (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", str);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.change_limit_level_success);
        } else {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.network_exception_please_try_later);
        }
    }
}
