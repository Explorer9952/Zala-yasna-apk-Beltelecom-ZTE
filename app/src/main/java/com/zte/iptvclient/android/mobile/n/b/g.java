package com.zte.iptvclient.android.mobile.n.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.fragment.app.r;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.Splashscreen;
import com.zte.iptvclient.android.common.k.l;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RegisterNewAccountFirstFragment.java */
/* loaded from: classes.dex */
public class g extends com.zte.fragmentlib.b {
    private EditText A;
    private ImageView B;
    private TextView C;
    private TextView D;
    private TextView E;
    private EditText F;
    private EditText G;
    private ImageView J;
    private ImageView K;
    private String L;
    private String M;
    private String N;
    private ToggleButton O;
    private Activity Q;
    private TextView R;
    private TextView S;
    private TextView T;
    private com.zte.iptvclient.android.common.j.h q;
    private LinearLayout r;
    private LinearLayout s;
    private RelativeLayout t;
    private Button u;
    private Button v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;
    private String p = "RegisterNewAccountFirstFragment";
    private long P = System.currentTimeMillis();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RegisterNewAccountFirstFragment.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.F.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RegisterNewAccountFirstFragment.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.G.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RegisterNewAccountFirstFragment.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RegisterNewAccountFirstFragment.java */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.Q.getPackageName().equals("com.sdgd.phonetv")) {
                return;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
            }
            g.this.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RegisterNewAccountFirstFragment.java */
    /* loaded from: classes.dex */
    public class e implements View.OnFocusChangeListener {
        e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                if (StringUtil.isEmptyString(g.this.A.getText().toString())) {
                    return;
                }
                g.this.B.setVisibility(0);
                return;
            }
            g.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RegisterNewAccountFirstFragment.java */
    /* loaded from: classes.dex */
    public class f implements TextWatcher {
        f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                g.this.B.setVisibility(0);
            } else {
                g.this.B.setVisibility(8);
            }
            g.this.I();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RegisterNewAccountFirstFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.n.b.g$g, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0314g implements View.OnClickListener {
        ViewOnClickListenerC0314g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.A.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RegisterNewAccountFirstFragment.java */
    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
            }
            g.this.getFragmentManager().F();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RegisterNewAccountFirstFragment.java */
    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {

        /* compiled from: RegisterNewAccountFirstFragment.java */
        /* loaded from: classes.dex */
        class a implements l.b {

            /* compiled from: RegisterNewAccountFirstFragment.java */
            /* renamed from: com.zte.iptvclient.android.mobile.n.b.g$i$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class DialogInterfaceOnClickListenerC0315a implements DialogInterface.OnClickListener {
                DialogInterfaceOnClickListenerC0315a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    g gVar = g.this;
                    gVar.f(gVar.N, g.this.L);
                }
            }

            /* compiled from: RegisterNewAccountFirstFragment.java */
            /* loaded from: classes.dex */
            class b implements DialogInterface.OnClickListener {
                b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    g gVar = g.this;
                    gVar.e(gVar.N, g.this.L);
                }
            }

            a() {
            }

            @Override // com.zte.iptvclient.android.common.k.l.b
            public void onDataReturn(String str) {
                try {
                    String string = new JSONObject(str).getString("returncode");
                    if ("0".equals(string)) {
                        com.zte.iptvclient.android.common.customview.a.a.a.a aVar = new com.zte.iptvclient.android.common.customview.a.a.a.a(g.this.getActivity());
                        aVar.a(R.string.register_face_info);
                        aVar.b(R.string.common_yes, new DialogInterfaceOnClickListenerC0315a());
                        aVar.a(R.string.common_no, new b());
                        aVar.show();
                    } else if (!"1".equals(string)) {
                        LogEx.w(g.this.p, str);
                    } else {
                        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.account_existed);
                        g.this.A.setFocusable(true);
                        g.this.A.setFocusableInTouchMode(true);
                        g.this.A.requestFocus();
                        LogEx.w(g.this.p, "user exists");
                    }
                } catch (JSONException e) {
                    LogEx.e(g.this.p, e.getMessage());
                }
            }

            @Override // com.zte.iptvclient.android.common.k.l.b
            public void onFailReturn(int i, String str) {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.register_failed) + "," + com.zte.iptvclient.android.common.c.a.getString(str, i));
                LogEx.d(g.this.p, "resultCode:" + i + "errormsg:" + str);
            }
        }

        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - g.this.P <= 500) {
                return;
            }
            g.this.P = currentTimeMillis;
            if (g.this.L() && g.this.K() && g.this.J() && g.this.O.isChecked()) {
                InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
                if (inputMethodManager.isActive()) {
                    inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
                }
                if ("2".equals(com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_INNOVATIVE_SERVICE_FLAG))) {
                    com.zte.iptvclient.android.common.k.l.a().a(g.this.N, g.this.L, new a());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RegisterNewAccountFirstFragment.java */
    /* loaded from: classes.dex */
    public class j implements View.OnFocusChangeListener {
        j() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                return;
            }
            g.this.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RegisterNewAccountFirstFragment.java */
    /* loaded from: classes.dex */
    public class k implements TextWatcher {
        k() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                g.this.J.setVisibility(0);
            } else {
                g.this.J.setVisibility(8);
            }
            g.this.D.setVisibility(8);
            g.this.I();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RegisterNewAccountFirstFragment.java */
    /* loaded from: classes.dex */
    public class l implements View.OnFocusChangeListener {
        l() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                return;
            }
            g.this.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RegisterNewAccountFirstFragment.java */
    /* loaded from: classes.dex */
    public class m implements TextWatcher {
        m() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                g.this.K.setVisibility(0);
            } else {
                g.this.K.setVisibility(8);
            }
            g.this.E.setVisibility(8);
            g.this.I();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J() {
        if (!StringUtil.isEmptyString(this.M)) {
            if (this.M.matches("^[a-zA-Z0-9_]*$")) {
                if (this.M.length() >= 6 && this.M.length() <= 16) {
                    if (this.M.equals(this.L)) {
                        this.E.setVisibility(8);
                        return true;
                    }
                    this.E.setVisibility(0);
                    this.E.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.password_unmatch));
                } else {
                    this.E.setVisibility(0);
                    this.E.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.password_tip));
                }
            } else {
                this.E.setVisibility(0);
                this.E.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.password_invalid));
            }
        } else {
            this.E.setVisibility(0);
            this.E.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.password_empty));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K() {
        if (!StringUtil.isEmptyString(this.L)) {
            if (this.L.matches("^[a-zA-Z0-9_]*$")) {
                if (this.L.length() >= 6 && this.L.length() <= 16) {
                    this.D.setVisibility(8);
                    return true;
                }
                this.D.setVisibility(0);
                this.D.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.password_tip));
            } else {
                this.D.setVisibility(0);
                this.D.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.password_invalid));
            }
        } else {
            this.D.setVisibility(0);
            this.D.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.password_empty));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L() {
        if (!StringUtil.isEmptyString(this.N)) {
            if (this.N.matches("^[a-zA-Z0-9_]*$")) {
                if (this.N.length() >= 6 && this.N.length() <= 16) {
                    this.C.setVisibility(8);
                    return true;
                }
                this.C.setVisibility(0);
                this.C.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.username_tip));
            } else {
                this.C.setVisibility(0);
                this.C.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.username_invalid));
            }
        } else {
            this.C.setVisibility(0);
            this.C.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.username_empty));
        }
        return false;
    }

    private void M() {
        this.v.setBackground(getResources().getDrawable(R.drawable.input_bg_grey));
        this.v.setTextColor(getResources().getColor(R.color.regist_hint_textcolor));
        this.v.setEnabled(false);
    }

    private void N() {
        this.A.setOnFocusChangeListener(new e());
        this.A.addTextChangedListener(new f());
        this.B.setOnClickListener(new ViewOnClickListenerC0314g());
        this.u.setOnClickListener(new h());
        this.v.setOnClickListener(new i());
        this.F.setOnFocusChangeListener(new j());
        this.F.addTextChangedListener(new k());
        this.G.setOnFocusChangeListener(new l());
        this.G.addTextChangedListener(new m());
        this.J.setOnClickListener(new a());
        this.K.setOnClickListener(new b());
        this.O.setOnClickListener(new c());
        this.z.setOnClickListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        com.zte.iptvclient.android.mobile.f0.a.b bVar = new com.zte.iptvclient.android.mobile.f0.a.b();
        Bundle bundle = new Bundle();
        bundle.putString("FragmentType", "ServiceAgreementFragment");
        bVar.setArguments(bundle);
        r b2 = getFragmentManager().b();
        b2.a(getId(), bVar, "webFragment");
        b2.a((String) null);
        b2.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, String str2) {
    }

    protected void I() {
        this.L = this.F.getText().toString().trim();
        this.M = this.G.getText().toString().trim();
        this.N = this.A.getText().toString().trim();
        if (this.L.length() >= 6 && this.L.length() <= 16 && this.M.length() >= 6 && this.M.length() <= 16 && !StringUtil.isEmptyString(this.N) && this.O.isChecked()) {
            this.v.setEnabled(true);
            this.v.setTextColor(getResources().getColor(R.color.white));
            this.v.setBackground(this.Q.getResources().getDrawable(R.drawable.account_btn_normal));
        } else {
            this.v.setEnabled(false);
            this.v.setTextColor(getResources().getColor(R.color.regist_hint_textcolor));
            this.v.setBackground(getResources().getDrawable(R.drawable.input_bg_grey));
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        M();
        N();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.Q = activity;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.q = new com.zte.iptvclient.android.common.j.h(getActivity());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.regist_new_account_fragment, (ViewGroup) null);
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    private void d(View view) {
        this.t = (RelativeLayout) view.findViewById(R.id.title_rlayout);
        this.u = (Button) view.findViewById(R.id.btn_back);
        this.w = (TextView) view.findViewById(R.id.title_txt);
        this.r = (LinearLayout) view.findViewById(R.id.ll_registaccount);
        this.y = (TextView) view.findViewById(R.id.txt_phonenumhead);
        TextView textView = (TextView) view.findViewById(R.id.txt_phonenum);
        this.x = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.account_login_username));
        EditText editText = (EditText) view.findViewById(R.id.edt_phonenum);
        this.A = editText;
        editText.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.account_password_limit));
        this.B = (ImageView) view.findViewById(R.id.img_phonenum_clear);
        Button button = (Button) view.findViewById(R.id.btnNext);
        this.v = button;
        button.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.account_register));
        EditText editText2 = (EditText) view.findViewById(R.id.edt_new_password);
        this.F = editText2;
        editText2.setHint(com.zte.iptvclient.android.common.i.a.a.a(R.string.account_password_limit));
        EditText editText3 = (EditText) view.findViewById(R.id.edt_confirm_new_password);
        this.G = editText3;
        editText3.setHint(com.zte.iptvclient.android.common.i.a.a.a(R.string.account_password_limit));
        this.F.setTransformationMethod(new PasswordTransformationMethod());
        this.G.setTransformationMethod(new PasswordTransformationMethod());
        this.J = (ImageView) view.findViewById(R.id.img_new_password_clear);
        this.K = (ImageView) view.findViewById(R.id.img_confirm_new_password_clear);
        TextView textView2 = (TextView) view.findViewById(R.id.txt_check_phonenum_result);
        this.C = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.username_error));
        TextView textView3 = (TextView) view.findViewById(R.id.txt_check_newpassword_result);
        this.D = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.password_tip));
        TextView textView4 = (TextView) view.findViewById(R.id.txt_check_confirm_newpassword_result);
        this.E = textView4;
        textView4.setText(R.string.password_tip);
        this.O = (ToggleButton) view.findViewById(R.id.tg_remember);
        TextView textView5 = (TextView) view.findViewById(R.id.txt_terms);
        this.z = textView5;
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.terms_and_policy));
        TextView textView6 = (TextView) view.findViewById(R.id.txt_newpassword);
        this.R = textView6;
        textView6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.account_register_password));
        TextView textView7 = (TextView) view.findViewById(R.id.txt_confirm_newpassword);
        this.S = textView7;
        textView7.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.account_register_confirm_password));
        TextView textView8 = (TextView) view.findViewById(R.id.txt_agreement);
        this.T = textView8;
        textView8.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.i_have_already_read_and_agree));
        this.T.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.i_have_already_read_and_agree));
        com.zte.iptvclient.common.uiframe.f.a(this.O);
        com.zte.iptvclient.common.uiframe.f.a(this.D);
        com.zte.iptvclient.common.uiframe.f.a(this.E);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.F);
        com.zte.iptvclient.common.uiframe.f.a(this.G);
        com.zte.iptvclient.common.uiframe.f.a(this.J);
        com.zte.iptvclient.common.uiframe.f.a(this.K);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_password));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_confirm_password));
        com.zte.iptvclient.common.uiframe.f.a(this.R);
        com.zte.iptvclient.common.uiframe.f.a(this.S);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_remember);
        this.s = linearLayout;
        com.zte.iptvclient.common.uiframe.f.a(linearLayout);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.T);
        this.w.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.regist));
        this.O.setChecked(true);
        this.A.setInputType(1);
        this.z.setText(Html.fromHtml("<u>" + com.zte.iptvclient.android.common.i.a.a.a(R.string.terms_and_policy) + "</u>"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, String str2) {
        if (!StringUtil.isEmptyString(str)) {
            this.q.j(true);
            this.q.K(str);
            this.q.x(str2);
        }
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.regist_sucess_welcome);
        com.zte.iptvclient.common.uiframe.b.c().a(0);
        startActivity(new Intent(this.Q, (Class<?>) Splashscreen.class));
        this.Q.finish();
    }
}
