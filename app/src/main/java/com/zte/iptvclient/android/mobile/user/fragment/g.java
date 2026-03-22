package com.zte.iptvclient.android.mobile.user.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.SDKUserMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.f.a;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.zala.R;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChangeContactFragment.java */
/* loaded from: classes2.dex */
public class g extends com.zte.fragmentlib.b implements View.OnClickListener, a.InterfaceC0127a, com.zte.iptvclient.android.common.b.c<JSONObject> {
    private static final String K = g.class.getName();
    private EditText A;
    private Button B;
    private Button C;
    private com.zte.iptvclient.android.common.f.a D;
    com.zte.iptvclient.android.common.b.d F;
    private String p;
    private String q;
    private String r;
    private TextView s;
    private Button t;
    private TextView u;
    private TextView v;
    private ImageView w;
    private RelativeLayout x;
    private TextView y;
    private TextView z;
    private String E = "";
    String G = "";
    View.OnTouchListener J = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChangeContactFragment.java */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                g.this.w.setVisibility(0);
            } else {
                g.this.w.setVisibility(8);
            }
            g.this.J();
            if (TextUtils.equals(g.this.p, "phone")) {
                g.this.v.setVisibility(0);
                g.this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_notice_format_phone));
                g.this.A.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
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
    /* compiled from: ChangeContactFragment.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.A.setText("");
            g.this.v.setVisibility(8);
        }
    }

    /* compiled from: ChangeContactFragment.java */
    /* loaded from: classes2.dex */
    class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            LogEx.d(g.K, "onTouch");
            if (motionEvent.getAction() != 0 || g.this.A.getId() == view.getId()) {
                return false;
            }
            g.this.A();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChangeContactFragment.java */
    /* loaded from: classes2.dex */
    public class d implements SDKUserMgr.OnUpdateUserInfoCommonReturnListener {
        d() {
        }

        @Override // com.video.androidsdk.service.SDKUserMgr.OnUpdateUserInfoCommonReturnListener
        public void onUpdateUserInfoCommonReturn(String str, String str2, String str3) {
            LogEx.d(g.K, "s" + str + "---s1" + str2 + "---s2" + str3);
            if (!TextUtils.equals("0", str)) {
                g.this.v.setVisibility(0);
                if (TextUtils.isEmpty(g.this.E)) {
                    g.this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_change_updataphone_error));
                    return;
                } else {
                    g.this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_change_updataemail_error));
                    return;
                }
            }
            EventBus.getDefault().post(new f());
            if (BaseApp.a(((com.zte.fragmentlib.b) g.this).h)) {
                g.this.F();
            } else if (g.this.getActivity() instanceof HostActivity) {
                g.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        String obj = this.A.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            LogEx.w(K, "mBtnLogin.setEnabled(false)!");
            this.C.setEnabled(false);
            this.C.setTextColor(c.a.a.a.d.b.d().b(R.color.login_hint_textcolor));
            this.C.setBackground(c.a.a.a.d.b.d().d(R.drawable.btn_change_disable));
            SupportActivity supportActivity = this.h;
            if (supportActivity != null) {
                supportActivity.a(this.C, "textColor", R.color.login_hint_textcolor);
                this.h.a(this.C, "background", R.drawable.btn_change_disable);
                return;
            }
            return;
        }
        if (obj.length() > 0) {
            this.C.setEnabled(true);
            this.C.setBackground(c.a.a.a.d.b.d().d(R.drawable.btn_change));
            SupportActivity supportActivity2 = this.h;
            if (supportActivity2 != null) {
                supportActivity2.a(this.C, "background", R.drawable.btn_change);
                return;
            }
            return;
        }
        this.C.setEnabled(false);
        this.C.setBackground(c.a.a.a.d.b.d().d(R.drawable.findpw_btn_disable));
        SupportActivity supportActivity3 = this.h;
        if (supportActivity3 != null) {
            supportActivity3.a(this.C, "background", R.drawable.findpw_btn_disable);
        }
    }

    private void K() {
        this.A.addTextChangedListener(new a());
        this.w.setOnClickListener(new b());
    }

    private void L() {
        if (TextUtils.equals(this.p, "phone")) {
            if (!t(this.A.getText().toString().trim())) {
                return;
            } else {
                e(this.A.getText().toString().trim(), this.q);
            }
        }
        if (!TextUtils.equals(this.p, "email") || TextUtils.isEmpty(this.E)) {
            return;
        }
        b(this.A.getText().toString().trim(), this.G, this.E);
    }

    private boolean s(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        Matcher matcher = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*").matcher(str);
        LogEx.d(K, "checkEmail" + matcher.matches());
        return matcher.matches();
    }

    private static boolean t(String str) {
        if (str.length() == 10 && Pattern.compile("[0-9]*").matcher(str).matches()) {
            String substring = str.substring(0, 2);
            if (TextUtils.equals(substring, "05") || TextUtils.equals(substring, "06") || TextUtils.equals(substring, "07")) {
                return true;
            }
        }
        return false;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_back) {
            if (BaseApp.a(this.h)) {
                F();
                return;
            } else {
                if (getActivity() instanceof HostActivity) {
                    getActivity().finish();
                    return;
                }
                return;
            }
        }
        if (id != R.id.change_contact_confirm_button) {
            if (id != R.id.change_contact_send_button) {
                return;
            }
            LogEx.d(K, "send email code ");
            String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_change_message);
            String a3 = com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_change_message);
            com.zte.iptvclient.android.common.b.d dVar = new com.zte.iptvclient.android.common.b.d(this, new com.zte.iptvclient.android.common.b.e());
            this.F = dVar;
            dVar.b(com.zte.iptvclient.common.uiframe.a.d("UserID"), this.E, 10, a2, a3);
            this.D.start();
            return;
        }
        if (TextUtils.equals(this.E, "") && TextUtils.equals(this.p, "email")) {
            if (!s(this.A.getText().toString().trim())) {
                this.v.setVisibility(0);
                this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_notice_format_email));
                return;
            }
            this.E = this.A.getText().toString().trim();
            this.y.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_email_title_next));
            this.z.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_email_prompt_next));
            this.B.setVisibility(0);
            this.C.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_confirm_next));
            this.A.setText("");
            this.v.setVisibility(8);
            return;
        }
        if (TextUtils.equals(this.p, "phone")) {
            L();
        } else {
            if (TextUtils.isEmpty(this.E) || !TextUtils.equals(this.p, "email")) {
                return;
            }
            L();
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogEx.d(K, "onCreate");
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.p = arguments.getString("changeType");
            this.q = arguments.getString("email");
            this.r = arguments.getString(ParamConst.GET_REGISTER_REQ_MOBILENO);
            LogEx.d(K, "changeType" + this.p + "---email" + this.q + "---" + ParamConst.GET_REGISTER_REQ_MOBILENO + this.r);
        }
        com.zte.iptvclient.android.common.f.a a2 = com.zte.iptvclient.android.common.f.a.a();
        this.D = a2;
        a2.a(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.change_contact_fragment, (ViewGroup) null);
        d(inflate);
        K();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.zte.iptvclient.android.common.f.a.InterfaceC0127a
    public void r() {
        LogEx.d(K, "TimeCount is onFinish !");
        this.B.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_send));
        this.B.setEnabled(true);
        this.B.setBackground(c.a.a.a.d.b.d().d(R.drawable.btn_change));
        this.h.a(this.B, "background", R.drawable.btn_change);
        this.B.setTextColor(c.a.a.a.d.b.d().b(R.color.white));
        this.h.a(this.B, "textColor", R.color.white);
    }

    private void d(View view) {
        this.s = (TextView) view.findViewById(R.id.change_contact_top);
        this.t = (Button) view.findViewById(R.id.btn_back);
        this.u = (TextView) view.findViewById(R.id.title_txt);
        this.x = (RelativeLayout) view.findViewById(R.id.title_rlayout);
        this.y = (TextView) view.findViewById(R.id.change_contact_prompt);
        this.z = (TextView) view.findViewById(R.id.change_contact_prompt_title);
        this.A = (EditText) view.findViewById(R.id.change_contact_edittext);
        this.B = (Button) view.findViewById(R.id.change_contact_send_button);
        this.C = (Button) view.findViewById(R.id.change_contact_confirm_button);
        this.w = (ImageView) view.findViewById(R.id.change_contact_img);
        this.v = (TextView) view.findViewById(R.id.change_contact_notice);
        this.y.setText("Send validate code to the New Email,Please enter the validate code to modify");
        this.z.setText("Validate Code");
        this.B.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_send));
        this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_notice_format_phone));
        this.C.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_confirm));
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        this.s.setHeight(a2);
        this.t.setVisibility(0);
        if (TextUtils.equals(this.p, "phone")) {
            a(com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_phone), com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_phone_title), com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_phone_prompt));
        }
        if (TextUtils.equals(this.p, "email")) {
            a(com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_email), com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_email_title), com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_email_prompt));
        }
        this.t.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.C.setOnClickListener(this);
        view.setOnTouchListener(this.J);
    }

    private void e(String str, String str2) {
        SDKUserMgr sDKUserMgr = new SDKUserMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("opttype", "1");
        hashMap.put(ParamConst.GET_REGISTER_REQ_MOBILENO, str);
        hashMap.put("email", str2);
        LogEx.d(K, "phoneParams" + hashMap.toString());
        sDKUserMgr.updateUserInfoCommon(hashMap, new d());
    }

    @Override // com.zte.iptvclient.android.common.b.c
    public void f(String str) {
        LogEx.d(K, "showAuthcodeFailed" + str);
        this.v.setVisibility(0);
        this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_change_email_sendcode_error));
    }

    private void a(String str, String str2, String str3) {
        this.u.setText(str);
        this.u.setTextColor(getResources().getColor(R.color.findpw_title_textcolor));
        this.y.setText(str2);
        this.z.setText(str3);
        this.B.setVisibility(8);
        this.C.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_confirm));
    }

    private void b(String str, String str2, String str3) {
        if (str != null && str.length() > 0) {
            this.F.a(com.zte.iptvclient.common.uiframe.a.d("UserID"), str3, 10, str, str2);
        } else {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a("Please Enter OTP!");
        }
    }

    @Override // com.zte.iptvclient.android.common.f.a.InterfaceC0127a
    public void b(long j) {
        LogEx.d(K, "TimeCount is ticking !");
        Button button = this.B;
        if (button != null) {
            button.setEnabled(true);
            this.B.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.count_down_clock_tip), Long.valueOf(j / 1000)));
            this.B.setBackground(c.a.a.a.d.b.d().d(R.drawable.btn_change_disable));
            this.h.a(this.B, "background", R.drawable.btn_change_disable);
            this.B.setTextColor(c.a.a.a.d.b.d().b(R.color.white));
            this.h.a(this.B, "textColor", R.color.white);
        }
    }

    @Override // com.zte.iptvclient.android.common.b.c
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void b(JSONObject jSONObject) {
        try {
            LogEx.d(K, "showAuthcodeSuccess" + jSONObject.getString(ParamConst.SUBSCRIBE_RES_TRANSACTIONID));
            this.G = jSONObject.getString(ParamConst.SUBSCRIBE_RES_TRANSACTIONID);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.zte.iptvclient.android.common.b.c
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void a(JSONObject jSONObject) {
        LogEx.d(K, "showCheckAuthcodeSuccess" + jSONObject.toString());
        try {
            if (TextUtils.equals(jSONObject.getString("returncode"), "0")) {
                e(this.r, this.E);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.zte.iptvclient.android.common.b.c
    public void d(String str) {
        LogEx.d(K, "showCheckAuthcodeFailed" + str);
        this.v.setVisibility(0);
        this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.changecontact_change_email_checkcode_error));
    }
}
