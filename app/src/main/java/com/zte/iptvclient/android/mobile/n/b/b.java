package com.zte.iptvclient.android.mobile.n.b;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.ParamConst;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.login.activity.LoginActivity;
import com.zte.iptvclient.android.zala.R;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: AtLoginFragment.java */
/* loaded from: classes.dex */
public class b extends com.zte.fragmentlib.b {
    private com.zte.iptvclient.android.common.j.h A;
    private String B;
    private String C;
    private String D;
    private RelativeLayout E;
    private RelativeLayout F;
    private com.zte.iptvclient.android.mobile.n.c.b N;
    private View O;
    private Button q;
    private Button r;
    private LinearLayout s;
    private LinearLayout t;
    private EditText u;
    private EditText v;
    private ImageView w;
    private ImageView x;
    private TextView y;
    private TextView z;
    private long p = 0;
    private String G = "80106002";
    private String J = "80106202";
    private String K = "70116202";
    private String L = "70116204";
    private String M = "70116104";
    private String P = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
    private Handler Q = new g();
    View.OnTouchListener R = new f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtLoginFragment.java */
    /* loaded from: classes.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.v.isFocusable()) {
                return false;
            }
            b.this.v.setFocusableInTouchMode(true);
            b.this.v.setFocusable(true);
            if (b.this.v.isFocused()) {
                return false;
            }
            b.this.v.requestFocus();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtLoginFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.n.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0308b implements TextWatcher {
        C0308b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                b.this.x.setVisibility(0);
            } else {
                b.this.x.setVisibility(8);
            }
            b.this.I();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtLoginFragment.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.v.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtLoginFragment.java */
    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.a.a f6788a;

        d(com.zte.iptvclient.android.common.customview.a.a.a.a aVar) {
            this.f6788a = aVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f6788a.dismiss();
            Intent intent = new Intent(((com.zte.fragmentlib.b) b.this).h, (Class<?>) MainActivity.class);
            intent.setFlags(268468224);
            b.this.startActivity(intent);
            b.this.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtLoginFragment.java */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.L();
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.f("play"));
            b.this.K();
        }
    }

    /* compiled from: AtLoginFragment.java */
    /* loaded from: classes.dex */
    class f implements View.OnTouchListener {
        f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            LogEx.d("AtLoginFragment", "onTouch");
            if (motionEvent.getAction() != 0 || b.this.u.getId() == view.getId()) {
                return false;
            }
            b.this.A();
            return false;
        }
    }

    /* compiled from: AtLoginFragment.java */
    /* loaded from: classes.dex */
    class g extends Handler {
        g() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.this.Q == null) {
                return;
            }
            int i = message.what;
            if (i == 2) {
                ((com.zte.fragmentlib.b) b.this).h.q();
            } else if (i == 3) {
                ((com.zte.fragmentlib.b) b.this).h.d();
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtLoginFragment.java */
    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BaseApp.a(((com.zte.fragmentlib.b) b.this).h)) {
                b.this.a(new com.zte.iptvclient.android.mobile.n.b.e());
            } else {
                b.this.a("findpw", (Bundle) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtLoginFragment.java */
    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String c2 = com.zte.iptvclient.common.uiframe.a.c("Regist_Address");
            if (TextUtils.isEmpty(c2)) {
                c2 = "http://zala.by/internettv";
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(c2));
            ((com.zte.fragmentlib.b) b.this).h.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtLoginFragment.java */
    /* loaded from: classes.dex */
    public class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.f("play"));
            b.this.A();
            b.this.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtLoginFragment.java */
    /* loaded from: classes.dex */
    public class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.O()) {
                return;
            }
            b.this.A();
            b bVar = b.this;
            bVar.B = bVar.u.getText().toString().trim();
            b bVar2 = b.this;
            bVar2.C = bVar2.v.getText().toString().trim();
            b bVar3 = b.this;
            bVar3.e(bVar3.B, b.this.C);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtLoginFragment.java */
    /* loaded from: classes.dex */
    public class l implements View.OnFocusChangeListener {
        l() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                b.this.w.setVisibility(8);
                return;
            }
            if (!StringUtil.isEmptyString(b.this.u.getText().toString())) {
                b.this.w.setVisibility(0);
            }
            b.this.u.requestFocus();
            b.this.u.setSelection(b.this.u.getText().toString().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtLoginFragment.java */
    /* loaded from: classes.dex */
    public class m implements TextWatcher {
        m() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                b.this.w.setVisibility(0);
            } else {
                b.this.w.setVisibility(8);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtLoginFragment.java */
    /* loaded from: classes.dex */
    public class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.u.setText("");
            b.this.u.requestFocus();
            b bVar = b.this;
            bVar.c(bVar.u);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtLoginFragment.java */
    /* loaded from: classes.dex */
    public class o implements View.OnFocusChangeListener {
        o() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                b.this.x.setVisibility(8);
            } else {
                if (StringUtil.isEmptyString(b.this.v.getText().toString())) {
                    return;
                }
                b.this.x.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (getActivity() == null || !(getActivity() instanceof LoginActivity)) {
            return;
        }
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        Handler handler = this.Q;
        if (handler != null) {
            handler.sendEmptyMessage(3);
        }
    }

    private void M() {
        this.A.j(true);
        if (!TextUtils.isEmpty(this.A.z()) && !TextUtils.equals(this.D, this.A.z())) {
            this.u.setText(this.A.z());
        }
        if (TextUtils.isEmpty(this.u.getText().toString())) {
            this.u.requestFocus();
        } else {
            this.u.clearFocus();
            this.v.requestFocus();
        }
        if ("1".equals(ConfigMgr.readPropertie("isShow"))) {
            this.y.setVisibility(8);
        } else {
            this.y.setVisibility(0);
            this.z.setVisibility(0);
        }
    }

    private void N() {
        this.A = new com.zte.iptvclient.android.common.j.h(this.h);
        this.N = com.zte.iptvclient.android.mobile.n.c.b.k();
        this.D = ConfigMgr.readPropertie("GuestName");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean O() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.p <= 2000) {
            LogEx.w("UseeTv", "Operate limit,less than 2000(ms)!");
            return true;
        }
        this.p = currentTimeMillis;
        return false;
    }

    private void P() {
        this.A.j(true);
        J();
    }

    private boolean s(String str) {
        return !Pattern.compile(this.P).matcher(str.trim()).find();
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.f("play"));
        return super.D();
    }

    protected void I() {
        this.B = this.u.getText().toString().trim();
        this.C = this.v.getText().toString().trim();
        if (!TextUtils.isEmpty(this.B) && !TextUtils.isEmpty(this.C)) {
            if (s(this.B) && s(this.C)) {
                this.r.setEnabled(true);
                this.r.setBackground(c.a.a.a.d.b.d().d(R.drawable.login_btn_press));
                this.h.a(this.r, "background", R.drawable.login_btn_press);
                return;
            } else {
                LogEx.w("AtLoginFragment", "mBtnLogin.setEnabled(false)!");
                this.r.setEnabled(false);
                this.r.setBackground(c.a.a.a.d.b.d().d(R.drawable.login_btn_disable));
                this.h.a(this.r, "background", R.drawable.login_btn_disable);
                return;
            }
        }
        LogEx.w("AtLoginFragment", "mBtnLogin.setEnabled(false)!");
        this.r.setEnabled(false);
        this.r.setBackground(c.a.a.a.d.b.d().d(R.drawable.login_btn_disable));
        this.h.a(this.r, "background", R.drawable.login_btn_disable);
    }

    protected void J() {
        if (com.zte.iptvclient.common.uiframe.a.d("isFirstLoginFlag") != null && "0".equals(com.zte.iptvclient.common.uiframe.a.d("isFirstLoginFlag"))) {
            L();
            com.zte.iptvclient.android.common.customview.a.a.a.a aVar = new com.zte.iptvclient.android.common.customview.a.a.a.a(this.h);
            aVar.setTitle("");
            String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.first_login_hint);
            StringBuilder sb = new StringBuilder(com.zte.iptvclient.common.uiframe.a.d("UserID"));
            sb.replace(3, 7, "****");
            aVar.a(String.format(a2, sb, com.zte.iptvclient.common.uiframe.a.d(ParamConst.LOGIN_BMS_TRANSACTIONTOKEN)));
            aVar.b(R.string.common_ok, new d(aVar));
            aVar.show();
            return;
        }
        this.O.postDelayed(new e(), 1000L);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        N();
        M();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Window window = this.h.getWindow();
        if (window != null) {
            window.setSoftInputMode(32);
        }
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.at_login_fragment, (ViewGroup) null);
        e(inflate);
        this.O = inflate;
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.Q.removeCallbacksAndMessages(null);
        this.Q = null;
        LogEx.d("AtLoginFragment", "AtLoginFragment onDestroy!!!");
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        LogEx.d("AtLoginFragment", "recv LoginReturnEvent event");
        if (cVar.a().equals("0")) {
            if (TextUtils.equals(this.D, this.A.V())) {
                return;
            }
            LogEx.d("AtLoginFragment", "my login return user ");
            P();
            return;
        }
        L();
        if ("70116206".equals(cVar.a())) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(this.h.getResources().getString(R.string.login_password_error) + "(" + cVar.a() + ")");
            return;
        }
        if ("70116101".equals(cVar.a())) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(this.h.getResources().getString(R.string.no_such_account) + "(" + cVar.a() + ")");
            return;
        }
        if ("70116109".equals(cVar.a())) {
            com.zte.iptvclient.android.common.customview.a.a.e.k kVar = new com.zte.iptvclient.android.common.customview.a.a.e.k(this.h, R.style.dialog_order);
            kVar.dismiss();
            kVar.show();
            return;
        }
        if (!TextUtils.equals(this.G, cVar.a()) && !TextUtils.equals(this.J, cVar.a()) && !TextUtils.equals(this.K, cVar.a())) {
            if (TextUtils.equals(this.L, cVar.a())) {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(this.h.getResources().getString(R.string.logged_out_failed_new) + "(" + cVar.a() + ")");
                return;
            }
            if (TextUtils.equals(this.M, cVar.a())) {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(this.h.getResources().getString(R.string.error_blacklist) + "(" + cVar.a() + ")");
                return;
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(this.h.getResources().getString(R.string.login_faild_for_sdk) + "(" + cVar.a() + ")");
            return;
        }
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(this.h.getResources().getString(R.string.online_loging_concurrency_max) + "(" + cVar.a() + ")");
    }

    private void d(View view) {
        if (view.findViewById(R.id.img_logo) != null) {
            view.findViewById(R.id.img_logo).setOnTouchListener(this.R);
        }
        if (view.findViewById(R.id.ll_login_content) != null) {
            view.findViewById(R.id.ll_login_content).setOnTouchListener(this.R);
        }
        this.O.setOnTouchListener(this.R);
        this.s.setOnTouchListener(this.R);
        this.t.setOnTouchListener(this.R);
        this.y.setOnClickListener(new h());
        this.z.setOnClickListener(new i());
        this.q.setOnClickListener(new j());
        this.r.setOnClickListener(new k());
        this.u.setOnFocusChangeListener(new l());
        this.u.addTextChangedListener(new m());
        this.w.setOnClickListener(new n());
        this.v.setOnFocusChangeListener(new o());
        this.v.setOnTouchListener(new a());
        this.v.addTextChangedListener(new C0308b());
        this.x.setOnClickListener(new c());
    }

    private void e(View view) {
        this.q = (Button) view.findViewById(R.id.view_btn_back);
        if (BaseApp.a(this.h)) {
            TextView textView = (TextView) view.findViewById(R.id.top);
            int a2 = v.a();
            if (a2 <= 0) {
                a2 = 60;
            }
            textView.setHeight(a2);
            TextView textView2 = (TextView) view.findViewById(R.id.txt_title);
            textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.profile_select_login));
            com.zte.iptvclient.common.uiframe.f.a(textView2);
            if (getActivity() instanceof LoginActivity) {
                this.q.setVisibility(0);
            } else {
                this.q.setVisibility(8);
            }
            com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_login_title));
        } else {
            this.q.setVisibility(0);
            com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
            com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_txt));
            com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_bottom_line));
        }
        this.s = (LinearLayout) view.findViewById(R.id.account_layout);
        this.t = (LinearLayout) view.findViewById(R.id.pasd_layout);
        TextView textView3 = (TextView) this.s.findViewById(R.id.top_txt);
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.profile_login_account));
        TextView textView4 = (TextView) this.t.findViewById(R.id.top_txt);
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.profile_login_password));
        EditText editText = (EditText) this.s.findViewById(R.id.below_edit);
        this.u = editText;
        editText.setHint(com.zte.iptvclient.android.common.i.a.a.a(R.string.account));
        this.u.setImeOptions(5);
        EditText editText2 = (EditText) this.t.findViewById(R.id.below_edit);
        this.v = editText2;
        editText2.setHint(com.zte.iptvclient.android.common.i.a.a.a(R.string.login_enter_password_config));
        this.u.setImeOptions(6);
        this.v.setTransformationMethod(new PasswordTransformationMethod());
        com.zte.iptvclient.android.common.customview.a.b.a.a(this.h.getApplicationContext(), this.v);
        this.w = (ImageView) this.s.findViewById(R.id.img_edit_clear);
        this.x = (ImageView) this.t.findViewById(R.id.img_edit_clear);
        TextView textView5 = (TextView) view.findViewById(R.id.txt_forget_psd);
        this.y = textView5;
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.at_forget_psd_txt));
        TextView textView6 = (TextView) view.findViewById(R.id.txt_register_account);
        this.z = textView6;
        textView6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.account_register));
        Button button = (Button) view.findViewById(R.id.btnLogin);
        this.r = button;
        button.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.login_btnlogin));
        this.r.setEnabled(false);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_login_option));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_logo));
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(textView3);
        com.zte.iptvclient.common.uiframe.f.a(textView4);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        RelativeLayout relativeLayout = (RelativeLayout) this.s.findViewById(R.id.rl_edit);
        this.E = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.t.findViewById(R.id.rl_edit);
        this.F = relativeLayout2;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout2);
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

    public void e(String str, String str2) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.h.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            LogEx.d("LoginImp", "The network is available.");
            this.h.q();
            this.N.a(str, str2);
        } else {
            LogEx.e("LoginImp", "The network is not available.");
            L();
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.server_connect_fail);
        }
    }
}
