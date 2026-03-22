package com.zte.iptvclient.android.mobile.n.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.video.androidsdk.common.ParamConst;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: CommonLoginFragment.java */
/* loaded from: classes.dex */
public class d extends com.zte.fragmentlib.b {
    private LinearLayout A;
    private LinearLayout B;
    private RelativeLayout C;
    private RelativeLayout D;
    private Activity E;
    private com.zte.iptvclient.android.mobile.n.c.b F;
    private View G;
    private boolean J = false;
    private boolean K = true;
    private l L;
    private EditText p;
    private EditText q;
    private ImageView r;
    private ImageView s;
    private Button t;
    private Button u;
    private ToggleButton v;
    private com.zte.iptvclient.android.common.j.h w;
    private String x;
    private String y;
    private String z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonLoginFragment.java */
    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.a.a f6804a;

        a(com.zte.iptvclient.android.common.customview.a.a.a.a aVar) {
            this.f6804a = aVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f6804a.dismiss();
            Intent intent = new Intent(d.this.E, (Class<?>) MainActivity.class);
            intent.setFlags(268468224);
            d.this.startActivity(intent);
            d.this.E.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonLoginFragment.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.J();
            if (d.this.L != null) {
                d.this.L.m();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonLoginFragment.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = d.this;
            dVar.x = dVar.p.getText().toString();
            d dVar2 = d.this;
            dVar2.y = dVar2.q.getText().toString();
            d.this.A();
            LogEx.d("LoginFragment", "before requestLogin" + d.this.x + d.this.y);
            d dVar3 = d.this;
            dVar3.e(dVar3.x, d.this.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonLoginFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.n.b.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0311d implements View.OnClickListener {
        ViewOnClickListenerC0311d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonLoginFragment.java */
    /* loaded from: classes.dex */
    public class e implements View.OnFocusChangeListener {
        e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                if (TextUtils.isEmpty(d.this.p.getText().toString())) {
                    return;
                }
                d.this.r.setVisibility(0);
                return;
            }
            d.this.r.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonLoginFragment.java */
    /* loaded from: classes.dex */
    public class f implements TextWatcher {
        f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                d.this.r.setVisibility(0);
            } else {
                d.this.r.setVisibility(8);
            }
            d.this.I();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonLoginFragment.java */
    /* loaded from: classes.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.p.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonLoginFragment.java */
    /* loaded from: classes.dex */
    public class h implements View.OnFocusChangeListener {
        h() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                d.this.s.setVisibility(8);
            } else {
                if (TextUtils.isEmpty(d.this.q.getText().toString())) {
                    return;
                }
                d.this.s.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonLoginFragment.java */
    /* loaded from: classes.dex */
    public class i implements View.OnTouchListener {
        i() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.q.isFocusable()) {
                return false;
            }
            d.this.q.setFocusableInTouchMode(true);
            d.this.q.setFocusable(true);
            if (d.this.q.isFocused()) {
                return false;
            }
            d.this.q.requestFocus();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonLoginFragment.java */
    /* loaded from: classes.dex */
    public class j implements TextWatcher {
        j() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                d.this.s.setVisibility(0);
            } else {
                d.this.s.setVisibility(8);
            }
            d.this.I();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonLoginFragment.java */
    /* loaded from: classes.dex */
    public class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.q.setText("");
        }
    }

    /* compiled from: CommonLoginFragment.java */
    /* loaded from: classes.dex */
    public interface l {
        void m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.h.d();
    }

    private void K() {
        this.w.j(true);
        this.v.setChecked(this.w.r());
        String readPropertie = ConfigMgr.readPropertie("GuestName");
        if (this.w.r() && !TextUtils.isEmpty(this.w.z()) && !readPropertie.equals(this.w.z())) {
            this.p.setText(this.w.z());
        }
        if (TextUtils.isEmpty(this.p.getText().toString())) {
            this.p.requestFocus();
        } else {
            this.q.requestFocus();
        }
    }

    private void L() {
        this.u.setOnClickListener(new c());
        this.t.setOnClickListener(new ViewOnClickListenerC0311d());
        this.p.setOnFocusChangeListener(new e());
        this.p.addTextChangedListener(new f());
        this.r.setOnClickListener(new g());
        this.q.setOnFocusChangeListener(new h());
        this.q.setOnTouchListener(new i());
        this.q.addTextChangedListener(new j());
        this.s.setOnClickListener(new k());
    }

    private void M() {
        this.w = new com.zte.iptvclient.android.common.j.h(this.E);
        this.F = com.zte.iptvclient.android.mobile.n.c.b.k();
        this.z = ConfigMgr.readPropertie("GuestName");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        com.zte.iptvclient.android.common.e.x.d dVar = new com.zte.iptvclient.android.common.e.x.d();
        dVar.a(new com.zte.iptvclient.android.mobile.n.b.g());
        EventBus.getDefault().post(dVar);
    }

    private void O() {
        this.w.j(this.v.isChecked());
        s(this.x);
    }

    protected void I() {
        this.x = this.p.getText().toString();
        this.y = this.q.getText().toString();
        if (!TextUtils.isEmpty(this.x) && !TextUtils.isEmpty(this.y)) {
            if (this.x.length() > 0 && this.y.length() > 0) {
                this.u.setEnabled(true);
                this.u.setBackground(c.a.a.a.d.b.d().d(R.drawable.btnbg_login_foc));
                SupportActivity supportActivity = this.h;
                if (supportActivity != null) {
                    supportActivity.a(this.u, "background", R.drawable.btnbg_login_foc);
                    return;
                }
                return;
            }
            this.u.setEnabled(false);
            this.u.setBackground(c.a.a.a.d.b.d().d(R.drawable.account_btn_disable));
            SupportActivity supportActivity2 = this.h;
            if (supportActivity2 != null) {
                supportActivity2.a(this.u, "background", R.drawable.account_btn_disable);
                return;
            }
            return;
        }
        LogEx.w("LoginFragment", "mBtnLogin.setEnabled(false)!");
        this.u.setEnabled(false);
        this.u.setTextColor(c.a.a.a.d.b.d().b(R.color.login_hint_textcolor));
        this.u.setBackground(c.a.a.a.d.b.d().d(R.drawable.account_btn_disable));
        SupportActivity supportActivity3 = this.h;
        if (supportActivity3 != null) {
            supportActivity3.a(this.u, "textColor", R.color.login_hint_textcolor);
            this.h.a(this.u, "background", R.drawable.account_btn_disable);
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        L();
        K();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.E = activity;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.J = arguments.getBoolean("IsInitLogin", false);
            this.K = arguments.getBoolean("isSideMenu", true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.common_login_layout, (ViewGroup) null);
        M();
        d(inflate);
        this.G = inflate;
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        LogEx.d("LoginFragment", "LoginFragment onDestroy!!!");
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        LogEx.d("LoginFragment", "recv LoginReturnEvent event");
        this.F.a(com.zte.iptvclient.android.common.c.e.a.f4112a);
        if (cVar.a().equals("0")) {
            if (this.J || !this.z.equals(this.w.V())) {
                LogEx.d("LoginFragment", "my login return user ");
                O();
                return;
            }
            return;
        }
        J();
        if ("70116206".equals(cVar.a())) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.c.a.getString(com.zte.iptvclient.android.common.i.a.a.a(R.string.password_error), Integer.parseInt(cVar.a())));
        } else if ("70116101".equals(cVar.a())) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.c.a.getString(com.zte.iptvclient.android.common.i.a.a.a(R.string.no_such_account), Integer.parseInt(cVar.a())));
        } else {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.c.a.getString(com.zte.iptvclient.android.common.i.a.a.a(R.string.login_failed), Integer.parseInt(cVar.a())));
        }
    }

    protected void s(String str) {
        if (com.zte.iptvclient.common.uiframe.a.d("isFirstLoginFlag") != null && com.zte.iptvclient.common.uiframe.a.d("isFirstLoginFlag").equals("0")) {
            J();
            com.zte.iptvclient.android.common.customview.a.a.a.a aVar = new com.zte.iptvclient.android.common.customview.a.a.a.a(this.E);
            aVar.setTitle("");
            String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.first_login_hint);
            StringBuilder sb = new StringBuilder(com.zte.iptvclient.common.uiframe.a.d("UserID"));
            sb.replace(3, 7, "****");
            aVar.a(String.format(a2, sb, com.zte.iptvclient.common.uiframe.a.d(ParamConst.LOGIN_BMS_TRANSACTIONTOKEN)));
            aVar.b(R.string.common_ok, new a(aVar));
            aVar.show();
            return;
        }
        if (!this.K) {
            this.G.postDelayed(new b(), 1000L);
            return;
        }
        J();
        if (isAdded()) {
            Intent intent = new Intent(this.E, (Class<?>) MainActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
            this.E.finish();
        }
    }

    private void d(View view) {
        EditText editText = (EditText) view.findViewById(R.id.edtLoginUsername);
        this.p = editText;
        editText.setHint(com.zte.iptvclient.android.common.i.a.a.a(R.string.login_enter_username_config));
        EditText editText2 = (EditText) view.findViewById(R.id.edtLoginPassword);
        this.q = editText2;
        editText2.setHint(com.zte.iptvclient.android.common.i.a.a.a(R.string.login_enter_password_config));
        com.zte.iptvclient.android.common.customview.a.b.a.a(this.E.getApplicationContext(), this.q);
        this.r = (ImageView) view.findViewById(R.id.img_username_clear);
        this.s = (ImageView) view.findViewById(R.id.img_password_clear);
        this.B = (LinearLayout) view.findViewById(R.id.ll_show_login_style);
        Button button = (Button) view.findViewById(R.id.btnRegister);
        this.t = button;
        button.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.account_register));
        Button button2 = (Button) view.findViewById(R.id.btnLogin_show);
        this.u = button2;
        button2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.login_btnlogin));
        this.u.setEnabled(false);
        this.v = (ToggleButton) view.findViewById(R.id.tg_remember);
        if ("0".equals(ConfigMgr.readPropertie("ForbiddenRegisterFunction", "1"))) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
        }
        this.t.setTextColor(c.a.a.a.d.b.d().b(R.color.login_hint_textcolor));
        SupportActivity supportActivity = this.h;
        if (supportActivity != null) {
            supportActivity.a(this.t, "textColor", R.color.login_hint_textcolor);
        }
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_txt));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_bottom_line));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_login));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_logo));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_button));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.account_edit_img));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_pw_lock));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.login_guide_img));
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_username);
        this.C = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.rl_password);
        this.D = relativeLayout2;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout2);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_remember);
        this.A = linearLayout;
        com.zte.iptvclient.common.uiframe.f.a(linearLayout);
        TextView textView = (TextView) view.findViewById(R.id.txt_remember);
        com.zte.iptvclient.common.uiframe.f.a(textView);
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.account_remember));
        this.q.setTransformationMethod(new PasswordTransformationMethod());
    }

    public void e(String str, String str2) {
        if (getActivity() != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) getActivity().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                LogEx.d("LoginImp", "The network is available.");
            } else {
                LogEx.e("LoginImp", "The network is not available.");
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.server_connect_fail);
                return;
            }
        }
        this.h.q();
        this.F.a(str, str2);
    }

    public void a(l lVar) {
        this.L = lVar;
    }
}
