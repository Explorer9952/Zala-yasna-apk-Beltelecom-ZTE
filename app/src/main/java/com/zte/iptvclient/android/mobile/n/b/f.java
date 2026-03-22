package com.zte.iptvclient.android.mobile.n.b;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.video.androidsdk.common.AES;
import com.video.androidsdk.common.ParamConst;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.bean.SMSCodeReq;
import com.video.androidsdk.service.bean.UserLoginInfoReq;
import com.zte.iptvclient.android.common.f.a;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.n.b.d;
import com.zte.iptvclient.android.mobile.n.c.a;
import com.zte.iptvclient.android.zala.R;
import java.net.URLDecoder;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: LoginFragment.java */
/* loaded from: classes.dex */
public class f extends com.zte.fragmentlib.b implements a.InterfaceC0127a, d.l {
    private LinearLayout A;
    private ToggleButton B;
    private EditText C;
    private EditText D;
    private ImageView E;
    private ImageView F;
    private TextView G;
    private com.zte.iptvclient.android.common.j.h J;
    private String K;
    private String L;
    private String M;
    private TextView N;
    private TextView O;
    private TextView P;
    private TextView Q;
    private String T;
    private LinearLayout U;
    private LinearLayout V;
    private LinearLayout W;
    private RelativeLayout X;
    private RelativeLayout Y;
    private com.zte.iptvclient.android.mobile.n.c.b c0;
    private com.zte.iptvclient.android.common.f.a d0;
    private View e0;
    private Button q;
    private Button r;
    private ArrayList<String> s;
    private ArrayList<String> t;
    private ListView u;
    private com.zte.iptvclient.android.mobile.n.a.a v;
    private Button x;
    private Button y;
    private Button z;
    private long p = 0;
    private String w = "";
    private String R = "http://120.210.203.98:9342";
    private String S = "";
    private boolean Z = false;
    private boolean a0 = true;
    private boolean b0 = false;
    private boolean f0 = false;
    private boolean g0 = false;
    private boolean h0 = false;
    private Handler i0 = new k();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a(f fVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    public class b implements View.OnFocusChangeListener {
        b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                if (!f.this.b0) {
                    f.this.I();
                }
                if (!StringUtil.isEmptyString(f.this.C.getText().toString())) {
                    f.this.E.setVisibility(0);
                }
                f.this.C.requestFocus();
                f.this.C.setSelection(f.this.C.getText().toString().length());
                return;
            }
            f.this.E.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    public class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                f.this.E.setVisibility(0);
            } else {
                f.this.E.setVisibility(8);
            }
            f fVar = f.this;
            fVar.s(fVar.C.getText().toString());
            if (f.this.b0) {
                return;
            }
            f.this.I();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.C.setText("");
            f.this.C.requestFocus();
            f fVar = f.this;
            fVar.c(fVar.C);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.d0.start();
            if (TextUtils.equals(ConfigMgr.readPropertie("IsSupportZTESmsCodeLogin"), "1")) {
                f.this.a0();
            } else {
                f.this.U();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.n.b.f$f, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnFocusChangeListenerC0313f implements View.OnFocusChangeListener {
        ViewOnFocusChangeListenerC0313f() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                f.this.F.setVisibility(8);
            } else {
                if (StringUtil.isEmptyString(f.this.D.getText().toString())) {
                    return;
                }
                f.this.F.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    public class g implements View.OnTouchListener {
        g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (f.this.u.getVisibility() == 0) {
                f.this.A();
                f.this.u.setVisibility(8);
            }
            if (f.this.D.isFocusable()) {
                return false;
            }
            f.this.D.setFocusableInTouchMode(true);
            f.this.D.setFocusable(true);
            if (f.this.D.isFocused()) {
                return false;
            }
            f.this.D.requestFocus();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    public class h implements TextWatcher {
        h() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                f.this.F.setVisibility(0);
            } else {
                f.this.F.setVisibility(8);
            }
            f.this.J();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.D.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    public class j implements a.b {
        j() {
        }

        @Override // com.zte.iptvclient.android.mobile.n.c.a.b
        public void a(String str, String str2, String str3, String str4) {
            if (!"0".equals(str)) {
                f.this.O();
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.authcode_is_error));
                LogEx.w("LoginFragment", "OnLoginInfoReturn=" + str + "for error ifo=" + str2);
                return;
            }
            LogEx.d("LoginFragment", "queryLoginInfo success (get password success)!！!");
            try {
                String a2 = com.zte.iptvclient.android.common.k.a.a(URLDecoder.decode(str4, "UTF-8"), AES.getEncryptKey("impkey").getBytes());
                if (TextUtils.isEmpty(str3)) {
                    str3 = f.this.C.getText().toString();
                }
                f.this.e(str3, a2);
            } catch (Exception e) {
                f.this.O();
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.login_faild_for_sdk);
                LogEx.d("LoginFragment", "OnLoginInfoReturn pares pasWordd or useId aesDecryptByBase64=" + e.getMessage());
            }
        }
    }

    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    class k extends Handler {
        k() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (f.this.i0 == null) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                f.this.Y();
            } else if (i == 1) {
                f.this.X();
            } else if (i == 2) {
                ((com.zte.fragmentlib.b) f.this).h.q();
            } else if (i == 3) {
                ((com.zte.fragmentlib.b) f.this).h.d();
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    public class l implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.a.a f6830a;

        l(com.zte.iptvclient.android.common.customview.a.a.a.a aVar) {
            this.f6830a = aVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f6830a.dismiss();
            Intent intent = new Intent(((com.zte.fragmentlib.b) f.this).h, (Class<?>) MainActivity.class);
            intent.setFlags(268468224);
            f.this.startActivity(intent);
            f.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    public class m implements Runnable {
        m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.O();
            if (f.this.h0) {
                return;
            }
            if (f.this.g0) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.b("2"));
            }
            f.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    public class n implements View.OnTouchListener {
        n() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || f.this.C.getId() == view.getId()) {
                return false;
            }
            f.this.A();
            f.this.u.setVisibility(8);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    public class o implements com.zte.iptvclient.android.common.g.b {
        o() {
        }

        @Override // com.zte.iptvclient.android.common.g.b
        public boolean a(int i) {
            return false;
        }

        @Override // com.zte.iptvclient.android.common.g.b
        public void b(int i) {
            LogEx.d("LoginFragment", "onDelete @=" + i);
            if (i < f.this.t.size()) {
                if (f.this.s.contains(f.this.t.get(i))) {
                    LogEx.d("LoginFragment", "remove=" + ((String) f.this.t.get(i)));
                    f.this.s.remove(f.this.t.get(i));
                }
                f fVar = f.this;
                fVar.s(fVar.C.getText().toString());
                f.this.W();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    public class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    public class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.t.size() > 0) {
                f.this.u.setVisibility(0);
            } else {
                f.this.u.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    public class r implements AdapterView.OnItemClickListener {
        r() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (f.this.T()) {
                return;
            }
            if (i < f.this.t.size() && !TextUtils.isEmpty((CharSequence) f.this.t.get(i))) {
                f.this.C.setText((CharSequence) f.this.t.get(i));
                f.this.C.clearFocus();
                f.this.A();
            }
            f.this.u.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    public class s implements View.OnClickListener {
        s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.f("play"));
            f.this.A();
            if (f.this.g0) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.b("2"));
            }
            f.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    public class t implements View.OnClickListener {
        t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.T() || f.this.f0) {
                return;
            }
            f.this.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    public class u implements View.OnClickListener {
        u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar = f.this;
            fVar.K = fVar.C.getText().toString();
            f fVar2 = f.this;
            fVar2.L = fVar2.D.getText().toString();
            if (!TextUtils.equals(f.this.K, "18888888888") && !TextUtils.equals(f.this.K, "19999999999")) {
                f.this.A();
                f fVar3 = f.this;
                fVar3.M = fVar3.D.getText().toString();
                if (!TextUtils.isEmpty(f.this.M)) {
                    if (f.this.T()) {
                        return;
                    }
                    f.this.Z();
                    return;
                }
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(f.this.getString(R.string.authcode_is_empty_hint));
                return;
            }
            f fVar4 = f.this;
            fVar4.e(fVar4.K, f.this.L);
        }
    }

    static {
        String.valueOf(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    private void M() {
        if (TextUtils.isEmpty(this.C.getText().toString())) {
            this.x.setEnabled(false);
            this.x.setBackground(c.a.a.a.d.b.d().d(R.drawable.indetifi_code_disable));
            this.h.a(this.x, "background", R.drawable.indetifi_code_disable);
        } else {
            this.x.setEnabled(true);
            this.x.setBackground(c.a.a.a.d.b.d().d(R.drawable.indetifi_code));
            this.h.a(this.x, "background", R.drawable.indetifi_code);
        }
    }

    private boolean N() {
        String obj = this.C.getText().toString();
        this.K = obj;
        if (!StringUtil.isEmptyString(obj) && this.K.matches("^[0-9]*$") && this.K.length() == 11) {
            if ("1".equalsIgnoreCase(this.K.substring(0, 1))) {
                this.G.setVisibility(8);
                LogEx.d("LoginFragment", "checkPhoneNumber is OK !");
                return true;
            }
            LogEx.d("LoginFragment", "checkPhoneNumber isnot start by 1");
        }
        LogEx.d("LoginFragment", "checkPhoneNumber is faild !");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        Handler handler = this.i0;
        if (handler != null) {
            handler.sendEmptyMessage(3);
        }
    }

    private void P() {
        String b2 = this.J.b();
        this.w = b2;
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        String[] split = this.w.split(",");
        if (split.length > 0) {
            this.s.clear();
            for (String str : split) {
                this.s.add(str);
            }
            LogEx.d("LoginFragment", "mAccountHistoryListget=" + this.s.size());
        }
    }

    private void Q() {
        this.J.j(true);
        this.B.setChecked(this.J.r());
        if (!this.a0) {
            this.q.setVisibility(8);
            this.r.setVisibility(0);
        }
        if (this.Z) {
            if (this.J.r() && !TextUtils.isEmpty(this.J.z()) && !this.T.equals(this.J.z())) {
                this.C.setText(this.J.z());
            }
        } else if (this.J.r() && !StringUtil.isEmptyString(this.J.z()) && !this.T.equals(this.J.z())) {
            this.C.setText(this.J.z());
        }
        if (TextUtils.isEmpty(this.C.getText().toString())) {
            this.C.requestFocus();
        } else {
            this.u.setVisibility(8);
            this.C.clearFocus();
            this.D.requestFocus();
        }
        M();
    }

    private void R() {
        this.e0.setOnTouchListener(new n());
        this.v.a(new o());
        this.q.setOnClickListener(new p());
        this.C.setOnClickListener(new q());
        this.u.setOnItemClickListener(new r());
        this.r.setOnClickListener(new s());
        this.A.setOnClickListener(new t());
        this.z.setOnClickListener(new u());
        this.y.setOnClickListener(new a(this));
        this.C.setOnFocusChangeListener(new b());
        this.C.addTextChangedListener(new c());
        this.E.setOnClickListener(new d());
        this.x.setOnClickListener(new e());
        this.D.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0313f());
        this.D.setOnTouchListener(new g());
        this.D.addTextChangedListener(new h());
        this.F.setOnClickListener(new i());
    }

    private void S() {
        this.J = new com.zte.iptvclient.android.common.j.h(this.h);
        this.c0 = com.zte.iptvclient.android.mobile.n.c.b.k();
        this.T = ConfigMgr.readPropertie("GuestName");
        this.S = ConfigMgr.readPropertie("IMP_Password");
        this.s = new ArrayList<>();
        this.t = new ArrayList<>();
        com.zte.iptvclient.android.mobile.n.a.a aVar = new com.zte.iptvclient.android.mobile.n.a.a(this.h, this.t);
        this.v = aVar;
        this.u.setAdapter((ListAdapter) aVar);
        P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean T() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.p <= 2000) {
            LogEx.w("UseeTv", "Operate limit,less than 2000(ms)!");
            return true;
        }
        this.p = currentTimeMillis;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        this.K = this.C.getText().toString();
    }

    private void V() {
        this.J.j(this.B.isChecked());
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        this.w = "";
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            stringBuffer.append(this.s.get(i2));
            if (i2 != this.s.size() - 1) {
                stringBuffer.append(",");
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        this.w = stringBuffer2;
        this.J.b(stringBuffer2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        this.G.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.validate_code_faild));
        this.G.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        this.G.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.send_validate_code));
        this.G.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        this.K = this.C.getText().toString();
        String obj = this.D.getText().toString();
        this.M = obj;
        UserLoginInfoReq userLoginInfoReq = new UserLoginInfoReq(this.K, "2", obj);
        com.zte.iptvclient.android.mobile.n.c.a aVar = new com.zte.iptvclient.android.mobile.n.c.a(a(this.K, this.S, this.M));
        if (!TextUtils.isEmpty(SDKLoginMgr.getInstance().getPropertiesInfo("IMP_Server"))) {
            this.R = SDKLoginMgr.getInstance().getPropertiesInfo("IMP_Server");
        } else if (!TextUtils.isEmpty(this.J.i())) {
            this.R = this.J.i();
        }
        String c2 = com.zte.iptvclient.android.common.k.o.j().c();
        LogEx.d("LoginFragment", "onClick: getauthcode domain=" + c2);
        aVar.a(c2, userLoginInfoReq, new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        this.K = this.C.getText().toString();
        if (!TextUtils.isEmpty(SDKLoginMgr.getInstance().getPropertiesInfo("IMP_Server"))) {
            this.R = SDKLoginMgr.getInstance().getPropertiesInfo("IMP_Server");
        } else if (!TextUtils.isEmpty(this.J.i())) {
            this.R = this.J.i();
        }
        new SMSCodeReq(this.K, "2").setPassword(this.S);
        LogEx.d("LoginFragment", "onClick: getauthcode domain=" + this.R);
    }

    protected void J() {
        this.K = this.C.getText().toString();
        this.L = this.D.getText().toString();
        if (!TextUtils.isEmpty(this.K) && !TextUtils.isEmpty(this.L)) {
            if (N() && this.L.length() > 0) {
                this.G.setVisibility(8);
                this.z.setEnabled(true);
                this.z.setBackground(c.a.a.a.d.b.d().d(R.drawable.btnbg_login_foc));
                this.h.a(this.z, "background", R.drawable.btnbg_login_foc);
                return;
            }
            this.G.setVisibility(8);
            this.z.setEnabled(false);
            this.z.setBackground(c.a.a.a.d.b.d().d(R.drawable.account_btn_disable));
            this.h.a(this.z, "background", R.drawable.account_btn_disable);
            return;
        }
        LogEx.w("LoginFragment", "mBtnLogin.setEnabled(false)!");
        this.z.setEnabled(false);
        this.z.setTextColor(this.h.getResources().getColor(R.color.white));
    }

    protected void K() {
        if (com.zte.iptvclient.common.uiframe.a.d("isFirstLoginFlag") != null && com.zte.iptvclient.common.uiframe.a.d("isFirstLoginFlag").equals("0")) {
            O();
            com.zte.iptvclient.android.common.customview.a.a.a.a aVar = new com.zte.iptvclient.android.common.customview.a.a.a.a(this.h);
            aVar.setTitle("");
            String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.first_login_hint);
            StringBuilder sb = new StringBuilder(com.zte.iptvclient.common.uiframe.a.d("UserID"));
            sb.replace(3, 7, "****");
            aVar.a(String.format(a2, sb, com.zte.iptvclient.common.uiframe.a.d(ParamConst.LOGIN_BMS_TRANSACTIONTOKEN)));
            aVar.b(R.string.common_ok, new l(aVar));
            aVar.show();
            return;
        }
        if (!this.a0) {
            this.e0.postDelayed(new m(), 1000L);
            return;
        }
        O();
        if (isAdded()) {
            Intent intent = new Intent(this.h, (Class<?>) MainActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
            L();
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        S();
        R();
        Q();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.Z = arguments.getBoolean("IsInitLogin", false);
            this.a0 = arguments.getBoolean("isSideMenu", false);
            this.g0 = arguments.getBoolean("isFromMulti", false);
        }
        EventBus.getDefault().register(this);
        if (this.d0 == null) {
            this.d0 = com.zte.iptvclient.android.common.f.a.a();
        }
        this.d0.a(this);
        if (ConfigMgr.readPropertie("Msg_login").equals("0")) {
            com.zte.iptvclient.android.mobile.n.b.d dVar = new com.zte.iptvclient.android.mobile.n.b.d();
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("IsInitLogin", this.Z);
            bundle2.putBoolean("isSideMenu", this.a0);
            dVar.setArguments(bundle2);
            dVar.a((d.l) this);
            a(R.id.common_layout, dVar);
        }
        this.f0 = TextUtils.equals(ConfigMgr.readPropertie("IsSupportAliAuthLogin"), "1");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.login_layout, (ViewGroup) null);
        d(inflate);
        this.e0 = inflate;
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.i0.removeMessages(0);
        this.i0 = null;
        LogEx.d("LoginFragment", "LoginFragment onDestroy!!!");
        EventBus.getDefault().unregister(this);
        this.d0.a(null);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        LogEx.d("LoginFragment", "recv LoginReturnEvent event");
        if (ConfigMgr.readPropertie("Msg_login").equals("0")) {
            return;
        }
        this.c0.a(com.zte.iptvclient.android.common.c.e.a.f4112a);
        if (cVar.a().equals("0")) {
            if (this.f0) {
                A();
                if (this.g0) {
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.b("2"));
                    this.h.finish();
                }
                L();
                return;
            }
            if (this.Z || !this.T.equals(this.J.V())) {
                LogEx.d("LoginFragment", "my login return user ");
                V();
                return;
            }
            return;
        }
        O();
        this.x.setEnabled(true);
        if ("70116206".equals(cVar.a())) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.c.a.getString(com.zte.iptvclient.android.common.i.a.a.a(R.string.password_error), Integer.parseInt(cVar.a())));
        } else if ("70116101".equals(cVar.a())) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.c.a.getString(com.zte.iptvclient.android.common.i.a.a.a(R.string.no_such_account), Integer.parseInt(cVar.a())));
        } else {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.c.a.getString(com.zte.iptvclient.android.common.i.a.a.a(R.string.login_failed), Integer.parseInt(cVar.a())));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.h0 = false;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.h0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        this.t.clear();
        this.v.a(this.t);
        if (TextUtils.isEmpty(str)) {
            this.t.addAll(this.s);
        } else {
            for (int i2 = 0; i2 < this.s.size(); i2++) {
                if (this.s.get(i2).startsWith(str)) {
                    this.t.add(this.s.get(i2));
                }
            }
        }
        if (this.t.size() == 0) {
            this.u.setVisibility(8);
        } else {
            this.u.setVisibility(0);
        }
        LogEx.d("LoginFragment", "mCurrentAccountsList=" + this.t);
        this.v.a(this.t);
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.f("play"));
        if (this.g0) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.b("2"));
            L();
        }
        return super.D();
    }

    protected void I() {
        String obj = this.C.getText().toString();
        this.K = obj;
        if (TextUtils.isEmpty(obj)) {
            LogEx.w("LoginFragment", "mBtnLogin.setEnabled(false)!");
            this.x.setEnabled(false);
            this.x.setBackground(c.a.a.a.d.b.d().d(R.drawable.indetifi_code_disable));
            this.h.a(this.x, "background", R.drawable.indetifi_code_disable);
            return;
        }
        if (N()) {
            this.x.setEnabled(true);
            this.x.setBackground(c.a.a.a.d.b.d().d(R.drawable.indetifi_code));
            this.h.a(this.x, "background", R.drawable.indetifi_code);
        } else {
            this.x.setEnabled(false);
            this.x.setBackground(c.a.a.a.d.b.d().d(R.drawable.indetifi_code_disable));
            this.h.a(this.x, "background", R.drawable.indetifi_code_disable);
        }
    }

    public void e(String str, String str2) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.h.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            LogEx.d("LoginImp", "The network is available.");
            this.h.q();
            this.c0.a(str, str2);
        } else {
            LogEx.e("LoginImp", "The network is not available.");
            O();
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.server_connect_fail);
        }
    }

    @Override // com.zte.iptvclient.android.mobile.n.b.d.l
    public void m() {
        if (this.g0) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.b("2"));
        }
        L();
    }

    @Override // com.zte.iptvclient.android.common.f.a.InterfaceC0127a
    public void r() {
        this.b0 = false;
        this.G.setVisibility(8);
        LogEx.d("LoginFragment", "TimeCount is onFinish !");
        this.x.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.login_get_validatecode));
        this.x.setEnabled(true);
        this.x.setBackground(c.a.a.a.d.b.d().d(R.drawable.indetifi_code));
        this.h.a(this.x, "background", R.drawable.indetifi_code);
        this.x.setTextColor(c.a.a.a.d.b.d().b(R.color.white));
        this.h.a(this.x, "textColor", R.color.white);
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.U = (LinearLayout) view.findViewById(R.id.ll_login);
        if (ConfigMgr.readPropertie("Msg_login").equals("0")) {
            this.U.setVisibility(8);
        }
        this.q = (Button) view.findViewById(R.id.btnSideMenu);
        this.r = (Button) view.findViewById(R.id.btn_back);
        this.C = (EditText) view.findViewById(R.id.edtLoginUsername);
        this.D = (EditText) view.findViewById(R.id.edtLoginPassword);
        this.u = (ListView) view.findViewById(R.id.accpunt_history_lv);
        com.zte.iptvclient.android.common.customview.a.b.a.a(this.h.getApplicationContext(), this.D);
        this.E = (ImageView) view.findViewById(R.id.img_username_clear);
        this.F = (ImageView) view.findViewById(R.id.img_password_clear);
        Button button = (Button) view.findViewById(R.id.button_request);
        this.x = button;
        button.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.login_get_validatecode));
        this.G = (TextView) view.findViewById(R.id.txt_input_check_result);
        this.W = (LinearLayout) view.findViewById(R.id.ll_show_login_style);
        Button button2 = (Button) view.findViewById(R.id.btnRegister);
        this.y = button2;
        button2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.account_register));
        Button button3 = (Button) view.findViewById(R.id.btnLogin_show);
        this.z = button3;
        button3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.login_btnlogin));
        this.A = (LinearLayout) view.findViewById(R.id.ll_quck_login);
        this.x.setEnabled(false);
        this.z.setEnabled(false);
        this.B = (ToggleButton) view.findViewById(R.id.tg_remember);
        this.y.setVisibility(8);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.D);
        com.zte.iptvclient.common.uiframe.f.a(this.E);
        com.zte.iptvclient.common.uiframe.f.a(this.F);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        com.zte.iptvclient.common.uiframe.f.a(this.G);
        com.zte.iptvclient.common.uiframe.f.a(this.W);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        TextView textView2 = (TextView) view.findViewById(R.id.title_txt);
        this.N = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.account_title));
        TextView textView3 = (TextView) view.findViewById(R.id.txt_mobile_number);
        this.O = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.mobile_phone_number));
        TextView textView4 = (TextView) view.findViewById(R.id.txt_auto_login);
        this.P = textView4;
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.auto_login));
        TextView textView5 = (TextView) view.findViewById(R.id.txt_remember);
        this.Q = textView5;
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.account_remember));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_txt));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_bottom_line));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_login));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_logo));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_button));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.account_edit_img));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.login_guide_img));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_mobile_number));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_auto_login));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_pw_lock));
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_username);
        this.X = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.rl_password);
        this.Y = relativeLayout2;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout2);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_remember);
        this.V = linearLayout;
        com.zte.iptvclient.common.uiframe.f.a(linearLayout);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_remember));
        if (this.Z) {
            view.findViewById(R.id.title_rlayout).setVisibility(8);
        }
        this.C.setInputType(3);
    }

    @Override // com.zte.iptvclient.android.common.f.a.InterfaceC0127a
    public void b(long j2) {
        LogEx.d("LoginFragment", "TimeCount is ticking !");
        this.b0 = true;
        Button button = this.x;
        if (button != null) {
            button.setEnabled(false);
            this.x.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.count_down_clock_tip), Long.valueOf(j2 / 1000)));
            this.x.setBackground(c.a.a.a.d.b.d().d(R.drawable.indetifi_code_disable));
            this.h.a(this.x, "background", R.drawable.indetifi_code_disable);
            this.x.setTextColor(c.a.a.a.d.b.d().b(R.color.white));
            this.h.a(this.x, "textColor", R.color.white);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            java.lang.String r9 = "$$"
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            java.util.Calendar r2 = java.util.Calendar.getInstance()
            r3 = 11
            r4 = 1
            r2.add(r3, r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            long r4 = r2.getTimeInMillis()
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 / r6
            java.lang.String r2 = java.lang.Long.toHexString(r4)
            r3.append(r2)
            r3.append(r9)
            java.lang.String r2 = r3.toString()
            boolean r3 = android.text.TextUtils.isEmpty(r10)
            if (r3 != 0) goto L4f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r10)
            r3.append(r9)
            java.lang.String r2 = r3.toString()
        L4f:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r10 = 10
            java.lang.String r10 = com.zte.iptvclient.android.common.k.a.a(r10)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r1)
            r11.append(r2)
            r11.append(r9)
            r11.append(r10)
            java.lang.String r9 = r11.toString()
            byte[] r9 = r9.getBytes()
            java.lang.String r10 = "impkey"
            java.lang.String r10 = com.video.androidsdk.common.AES.getEncryptKey(r10)
            byte[] r10 = r10.getBytes()     // Catch: java.lang.Exception -> L94
            java.lang.String r9 = com.zte.iptvclient.android.common.k.a.c(r9, r10)     // Catch: java.lang.Exception -> L94
            java.lang.String r10 = "UTF-8"
            java.lang.String r9 = java.net.URLEncoder.encode(r9, r10)     // Catch: java.lang.Exception -> L92
            goto L99
        L92:
            r10 = move-exception
            goto L96
        L94:
            r10 = move-exception
            r9 = r0
        L96:
            r10.printStackTrace()
        L99:
            if (r9 != 0) goto L9c
            goto L9d
        L9c:
            r0 = r9
        L9d:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "encriptStr: "
            r9.append(r10)
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            java.lang.String r10 = "encryptionAES"
            com.video.androidsdk.log.LogEx.d(r10, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.n.b.f.a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }
}
