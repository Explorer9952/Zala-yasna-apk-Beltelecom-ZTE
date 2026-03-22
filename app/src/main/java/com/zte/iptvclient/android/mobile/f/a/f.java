package com.zte.iptvclient.android.mobile.f.a;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.SDKUserMgr;
import com.video.androidsdk.service.bean.UserSwitchReq;
import com.zte.iptvclient.android.common.customview.a.a.e.f;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import org.greenrobot.eventbus.EventBus;

/* compiled from: OrderPinFragment.java */
/* loaded from: classes.dex */
public class f extends com.zte.fragmentlib.b implements View.OnClickListener {
    private RelativeLayout A;
    private TextView B;
    private ImageView C;
    private boolean D = false;
    private h p;
    private RelativeLayout q;
    private Button r;
    private TextView s;
    private LinearLayout t;
    private RelativeLayout u;
    private TextView v;
    private ToggleButton w;
    private RelativeLayout x;
    private TextView y;
    private ImageView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OrderPinFragment.java */
    /* loaded from: classes.dex */
    public class a implements f.c {
        a() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void a() {
            f.this.D = false;
            f.this.J();
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void b() {
            f.this.D = true;
            f.this.J();
            f.this.w.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OrderPinFragment.java */
    /* loaded from: classes.dex */
    public class b implements f.c {
        b() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void a() {
            f.this.D = true;
            f.this.J();
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void b() {
            f.this.D = false;
            f.this.J();
            f.this.w.setChecked(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OrderPinFragment.java */
    /* loaded from: classes.dex */
    public class c implements SDKUserMgr.OnChangeUserSwitchReturnListener {
        c() {
        }

        @Override // com.video.androidsdk.service.SDKUserMgr.OnChangeUserSwitchReturnListener
        public void onChangeUserSwitchReturn(String str, String str2) {
            if ("0".equals(str)) {
                if (f.this.p.A()) {
                    f.this.p.n(false);
                } else {
                    f.this.p.n(true);
                }
                f.this.b(true);
                return;
            }
            f.this.b(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        UserSwitchReq userSwitchReq = new UserSwitchReq(this.D ? "0" : "1", 3);
        userSwitchReq.setPassword(this.p.B());
        new SDKUserMgr().changeUserSwitch(userSwitchReq, new c());
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.q = (RelativeLayout) view.findViewById(R.id.lock_nomal);
        this.r = (Button) view.findViewById(R.id.btn_back);
        this.s = (TextView) view.findViewById(R.id.lock_nomal_title);
        this.t = (LinearLayout) view.findViewById(R.id.order_lock_item);
        this.u = (RelativeLayout) view.findViewById(R.id.rl_order_lock);
        this.v = (TextView) view.findViewById(R.id.txt_order_lock);
        this.w = (ToggleButton) view.findViewById(R.id.tb_order_lock);
        this.x = (RelativeLayout) view.findViewById(R.id.rl_order_lock_introduction);
        this.y = (TextView) view.findViewById(R.id.txt_order_lock_introduction);
        this.z = (ImageView) view.findViewById(R.id.divider);
        this.A = (RelativeLayout) view.findViewById(R.id.rl_pwd_change);
        this.B = (TextView) view.findViewById(R.id.change_pwd_text);
        this.C = (ImageView) view.findViewById(R.id.img_change_password);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.order_pin));
        this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.purchase_password));
        this.y.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.purchase_hint));
        this.B.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.change_password));
        this.r.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.w.setOnClickListener(this);
        h hVar = this.p;
        if (hVar != null) {
            this.w.setChecked(hVar.A());
        }
    }

    public void I() {
        if (this.w.isChecked()) {
            com.zte.iptvclient.android.common.customview.a.a.e.f fVar = new com.zte.iptvclient.android.common.customview.a.a.e.f(this.h, R.drawable.custom_dialog_title_img, R.string.purchase_confirm, R.drawable.custom_dialog_button_blue, R.string.common_ok, 0, R.drawable.custom_dialog_button_blue, R.string.common_cancel, 0, new a());
            fVar.a();
            fVar.setCancelable(false);
            fVar.setCanceledOnTouchOutside(false);
            return;
        }
        com.zte.iptvclient.android.common.customview.a.a.e.f fVar2 = new com.zte.iptvclient.android.common.customview.a.a.e.f(this.h, R.drawable.custom_dialog_title_img, R.string.unpurchase_confirm, R.drawable.custom_dialog_button_blue, R.string.common_ok, 0, R.drawable.custom_dialog_button_blue, R.string.common_cancel, 0, new b());
        fVar2.a();
        fVar2.setCancelable(false);
        fVar2.setCanceledOnTouchOutside(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.btn_back) {
            if (id == R.id.rl_pwd_change) {
                c(new com.zte.iptvclient.android.mobile.f.a.c());
                return;
            } else {
                if (id != R.id.tb_order_lock) {
                    return;
                }
                I();
                return;
            }
        }
        if (getActivity() instanceof MainActivity) {
            F();
        } else if (getActivity() instanceof HostActivity) {
            getActivity().finish();
        }
        Log.d("99999", "此时订购锁的状态=" + new h(this.h).A());
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogEx.d("OrderPinFragment", "OrderPinFragment onCreate");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LogEx.d("OrderPinFragment", "OrderPinFragment onCreateView");
        View inflate = layoutInflater.inflate(R.layout.order_pin_fragment, viewGroup, false);
        this.p = new h(getActivity());
        d(inflate);
        return inflate;
    }

    private void c(com.zte.fragmentlib.b bVar) {
        com.zte.iptvclient.android.common.e.x.d dVar = new com.zte.iptvclient.android.common.e.x.d();
        dVar.a(bVar);
        EventBus.getDefault().post(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.change_limit_level_success));
        } else {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.network_exception_please_try_later));
        }
    }
}
