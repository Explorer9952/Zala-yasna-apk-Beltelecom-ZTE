package com.zte.iptvclient.android.mobile.n.b;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.ResetUserPasswordReq;
import com.video.androidsdk.service.SDKUserMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.a.a.e.f;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.zala.R;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ForgetPasswordFragment.java */
/* loaded from: classes.dex */
public class e extends com.zte.fragmentlib.b implements View.OnClickListener {
    private String q;
    private EditText r;
    private Button s;
    private ImageView t;
    private JSONObject u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private String p = e.class.getName();
    View.OnTouchListener z = new ViewOnTouchListenerC0312e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ForgetPasswordFragment.java */
    /* loaded from: classes.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                e.this.t.setVisibility(0);
            } else {
                e.this.t.setVisibility(8);
            }
            e.this.I();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ForgetPasswordFragment.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.r.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ForgetPasswordFragment.java */
    /* loaded from: classes.dex */
    public class c implements SDKUserMgr.OnResetUserPasswordReturnListener {
        c() {
        }

        @Override // com.video.androidsdk.service.SDKUserMgr.OnResetUserPasswordReturnListener
        public void onResetUserPasswordReturn(String str, String str2, String str3) {
            LogEx.d(e.this.p, "strErrorCode = " + str + " strErrorMsg = " + str2 + " rsp = " + str3);
            try {
                e.this.u = new JSONObject(str3);
                e.this.J();
                try {
                    e.this.a(e.this.u, str2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (Exception unused) {
                LogEx.d(e.this.p, "JSON is error！");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ForgetPasswordFragment.java */
    /* loaded from: classes.dex */
    public class d implements f.c {
        d(e eVar) {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void a() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void b() {
        }
    }

    /* compiled from: ForgetPasswordFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.n.b.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ViewOnTouchListenerC0312e implements View.OnTouchListener {
        ViewOnTouchListenerC0312e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            LogEx.d(e.this.p, "onTouch");
            if (motionEvent.getAction() != 0 || e.this.r.getId() == view.getId()) {
                return false;
            }
            e.this.A();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        String obj = this.r.getText().toString();
        this.q = obj;
        if (TextUtils.isEmpty(obj)) {
            LogEx.w(this.p, "mBtnLogin.setEnabled(false)!");
            this.s.setEnabled(false);
            this.s.setTextColor(c.a.a.a.d.b.d().b(R.color.login_hint_textcolor));
            this.s.setBackground(c.a.a.a.d.b.d().d(R.drawable.findpw_btn_disable));
            SupportActivity supportActivity = this.h;
            if (supportActivity != null) {
                supportActivity.a(this.s, "textColor", R.color.login_hint_textcolor);
                this.h.a(this.s, "background", R.drawable.findpw_btn_disable);
                return;
            }
            return;
        }
        if (this.q.length() > 0) {
            this.s.setEnabled(true);
            this.s.setBackground(c.a.a.a.d.b.d().d(R.drawable.findpw_btn_press));
            SupportActivity supportActivity2 = this.h;
            if (supportActivity2 != null) {
                supportActivity2.a(this.s, "background", R.drawable.findpw_btn_press);
                return;
            }
            return;
        }
        this.s.setEnabled(false);
        this.s.setBackground(c.a.a.a.d.b.d().d(R.drawable.findpw_btn_disable));
        SupportActivity supportActivity3 = this.h;
        if (supportActivity3 != null) {
            supportActivity3.a(this.s, "background", R.drawable.findpw_btn_disable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.h.d();
    }

    private void K() {
        this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.forgetpassword));
        this.v.setTextColor(getResources().getColor(R.color.findpw_title_textcolor));
        this.w.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.please_enter_you_account_name));
        this.x.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.forgetpassword_account));
        this.y.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.forgetpassword_tv));
        this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_ok));
        this.r.setHint(com.zte.iptvclient.android.common.i.a.a.a(R.string.account));
    }

    private void L() {
        this.r.addTextChangedListener(new a());
        this.t.setOnClickListener(new b());
    }

    private void M() {
        if (TextUtils.equals("", this.r.getText().toString())) {
            LogEx.d(this.p, "username is null");
        } else {
            s(this.q);
        }
    }

    private void s(String str) {
        if (getActivity() != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) getActivity().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                LogEx.d("LoginImp", "The network is available.");
            } else {
                LogEx.e("LoginImp", "The network is not available.");
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.server_connect_fail));
                return;
            }
        }
        this.h.q();
        SDKUserMgr sDKUserMgr = new SDKUserMgr();
        ResetUserPasswordReq resetUserPasswordReq = new ResetUserPasswordReq();
        resetUserPasswordReq.activetype = "1";
        resetUserPasswordReq.username = str;
        sDKUserMgr.resetUserPassword(resetUserPasswordReq, new c());
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        L();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.btn_back) {
            if (id != R.id.forget_password_bt) {
                return;
            }
            M();
        } else if (BaseApp.a(this.h)) {
            F();
        } else if (getActivity() instanceof HostActivity) {
            getActivity().finish();
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.forget_password_fragment, (ViewGroup) null);
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.fragment_forgetpassword_shedules_top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.w = (TextView) view.findViewById(R.id.please_enter_your_account_name);
        this.x = (TextView) view.findViewById(R.id.forget_password_account);
        this.y = (TextView) view.findViewById(R.id.forget_password_describe);
        Button button = (Button) view.findViewById(R.id.btn_back);
        this.v = (TextView) view.findViewById(R.id.title_txt);
        this.r = (EditText) view.findViewById(R.id.forget_password_account_et);
        this.s = (Button) view.findViewById(R.id.forget_password_bt);
        this.r.setInputType(1);
        button.setOnClickListener(this);
        this.s.setOnClickListener(this);
        view.setOnTouchListener(this.z);
        this.t = (ImageView) view.findViewById(R.id.forget_password_clear_img);
        com.zte.iptvclient.common.uiframe.f.a(button);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        button.setVisibility(0);
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, String str) throws JSONException {
        char c2;
        String format;
        String obj = jSONObject.get("returncode").toString();
        int hashCode = obj.hashCode();
        if (hashCode != 48) {
            if (hashCode == 1747680 && obj.equals("9207")) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (obj.equals("0")) {
                c2 = 0;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            format = c2 != 1 ? str : com.zte.iptvclient.android.common.i.a.a.a(R.string.forgetpassword_return9207);
        } else {
            format = String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.forgetpassword_dialog_text), jSONObject.get("mailorphone").toString());
        }
        com.zte.iptvclient.android.common.customview.a.a.e.f fVar = new com.zte.iptvclient.android.common.customview.a.a.e.f(this.h, 0, 0, R.drawable.findpw_btn_dialog, R.string.common_ok, 0, 0, 0, 0, new d(this));
        fVar.a(format);
        fVar.a();
        fVar.setCancelable(false);
        fVar.setCanceledOnTouchOutside(false);
    }
}
