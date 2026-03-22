package com.zte.iptvclient.android.mobile.user.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.ChangePasswordReq;
import com.video.androidsdk.service.SDKUserMgr;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.EventBus;

/* compiled from: SingleUserChangePwdFragment.java */
/* loaded from: classes2.dex */
public class n extends com.zte.fragmentlib.b implements View.OnClickListener {
    private String A;
    private String B;
    private String C;
    private String D;
    private FrameLayout J;
    private ImageView K;
    private FrameLayout M;
    private ImageView N;
    private FrameLayout P;
    private ImageView Q;
    private com.zte.iptvclient.android.common.j.h p;
    private RelativeLayout q;
    private Button r;
    private TextView s;
    private TextView t;
    private EditText u;
    private TextView v;
    private EditText w;
    private TextView x;
    private EditText y;
    private Button z;
    private String E = "^[\\w@]+$";
    private String F = "";
    private long G = System.currentTimeMillis();
    private boolean L = false;
    private boolean O = false;
    private boolean R = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleUserChangePwdFragment.java */
    /* loaded from: classes2.dex */
    public class a implements SDKUserMgr.OnChangePasswordReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.service.SDKUserMgr.OnChangePasswordReturnListener
        public void onChangePasswordReturn(String str, String str2) {
            if ("0".equals(str)) {
                n.this.J();
            } else {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.profile_pcb_modifyfail));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (this.p.r()) {
            this.p.n(this.B);
            if (TextUtils.equals(this.F, "0")) {
                this.p.x(this.B);
            } else {
                this.p.p(this.B);
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.profile_pcb_modifysuccess));
        }
    }

    private void K() {
        ChangePasswordReq changePasswordReq = new ChangePasswordReq();
        SDKUserMgr sDKUserMgr = new SDKUserMgr();
        changePasswordReq.newpwd = this.B;
        if ("0".equals(this.F)) {
            changePasswordReq.pwdtype = "0";
            changePasswordReq.oldpwd = this.A;
        } else if ("1".equals(this.F)) {
            changePasswordReq.pwdtype = "1";
            changePasswordReq.oldpwd = this.p.u();
        }
        sDKUserMgr.changePassword(changePasswordReq, new a());
    }

    private void L() {
        this.u.setFocusable(true);
        this.u.setFocusableInTouchMode(true);
        this.u.requestFocus();
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
        this.t = (TextView) view.findViewById(R.id.txt_old_password);
        this.u = (EditText) view.findViewById(R.id.edit_old_password);
        this.v = (TextView) view.findViewById(R.id.txt_new_password);
        this.w = (EditText) view.findViewById(R.id.edit_new_password);
        this.x = (TextView) view.findViewById(R.id.txt_confirm_password);
        this.y = (EditText) view.findViewById(R.id.edit_confirm_password);
        this.z = (Button) view.findViewById(R.id.btn_confirm);
        this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.change_password));
        this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.old_password));
        this.u.setHint(com.zte.iptvclient.android.common.i.a.a.a(R.string.old_password_hint));
        this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.new_password));
        this.w.setHint(com.zte.iptvclient.android.common.i.a.a.a(R.string.new_password_hint));
        this.x.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_new_password));
        this.y.setHint(com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_new_password_hint));
        this.z.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.order_confirm));
        e(view);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.header_bottom_line));
        this.u.setTypeface(Typeface.DEFAULT);
        this.u.setTransformationMethod(new PasswordTransformationMethod());
        this.w.setTypeface(Typeface.DEFAULT);
        this.w.setTransformationMethod(new PasswordTransformationMethod());
        this.y.setTypeface(Typeface.DEFAULT);
        this.y.setTransformationMethod(new PasswordTransformationMethod());
        this.r.setOnClickListener(this);
        this.z.setOnClickListener(this);
        L();
    }

    private void e(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_eye_container_old);
        this.J = frameLayout;
        this.K = (ImageView) frameLayout.findViewById(R.id.iv_eye_old);
        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_eye_container_new);
        this.M = frameLayout2;
        this.N = (ImageView) frameLayout2.findViewById(R.id.iv_eye_new);
        FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.fl_eye_container_confirm);
        this.P = frameLayout3;
        this.Q = (ImageView) frameLayout3.findViewById(R.id.iv_eye_confirm);
        this.J.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.P.setOnClickListener(this);
    }

    private boolean s(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (!Pattern.matches(this.E, str)) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.at_forget_psd_valid_characters));
            return false;
        }
        if (str.contains("@") && str.length() > 13) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.at_forget_psd_13_limit_length));
            return false;
        }
        if (str.contains("@") || str.length() <= 28) {
            return true;
        }
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.at_forget_psd_29_limit_length));
        return false;
    }

    public boolean I() {
        if (TextUtils.equals(this.F, "1")) {
            if (TextUtils.isEmpty(this.B) || TextUtils.isEmpty(this.C)) {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.change_password_empty));
                return false;
            }
        } else if (TextUtils.isEmpty(this.A) || TextUtils.isEmpty(this.B) || TextUtils.isEmpty(this.C)) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.change_password_empty));
            return false;
        }
        if (TextUtils.equals(this.A, this.D)) {
            if (s(this.B) && s(this.C)) {
                if (TextUtils.equals(this.A, this.B)) {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.password_compare));
                    L();
                    return false;
                }
                if (TextUtils.equals(this.B, this.C)) {
                    return true;
                }
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_not_same));
                this.w.setText("");
                this.y.setText("");
                L();
                return false;
            }
            this.w.setFocusable(true);
            this.w.requestFocus();
            this.w.setText("");
            this.y.setText("");
            return false;
        }
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.old_password_error));
        L();
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_back) {
            if (getActivity() instanceof MainActivity) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.z.a("parentcontral", true));
                return;
            } else {
                if (getActivity() instanceof HostActivity) {
                    getActivity().finish();
                    return;
                }
                return;
            }
        }
        if (id != R.id.btn_confirm) {
            switch (id) {
                case R.id.fl_eye_container_confirm /* 2131296768 */:
                    a(this.R, this.y, this.Q);
                    this.R = !this.R;
                    return;
                case R.id.fl_eye_container_new /* 2131296769 */:
                    a(this.O, this.w, this.N);
                    this.O = !this.O;
                    return;
                case R.id.fl_eye_container_old /* 2131296770 */:
                    a(this.L, this.u, this.K);
                    this.L = !this.L;
                    return;
                default:
                    return;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.G <= 500) {
            return;
        }
        this.G = currentTimeMillis;
        A();
        this.A = this.u.getText().toString().trim();
        this.B = this.w.getText().toString().trim();
        this.C = this.y.getText().toString().trim();
        LogEx.d("SingleUserChangePwdFragment", "mstrOldPassword:" + this.A + ",,,mstrNewPassword:" + this.B + ",,,mstrConfirmNewPassword:" + this.C);
        if (I()) {
            K();
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.F = arguments.getString("from", WeiboAuthException.DEFAULT_AUTH_ERROR_CODE);
        }
        LogEx.d("SingleUserChangePwdFragment", "ChangeOrderPwdFragment onCreate mstrFragmentFrom:" + this.F);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.change_singleuser_pwd_fragment, viewGroup, false);
        this.p = new com.zte.iptvclient.android.common.j.h(this.h);
        if ("1".equals(this.F)) {
            this.D = this.p.u();
        } else {
            this.D = this.p.D();
        }
        LogEx.d("SingleUserChangePwdFragment", "ChangeOrderPwdFragment onCreateView mstrOldPasswordLocal:" + this.D);
        d(inflate);
        return inflate;
    }

    private void a(boolean z, EditText editText, ImageView imageView) {
        editText.setTransformationMethod(z ? PasswordTransformationMethod.getInstance() : HideReturnsTransformationMethod.getInstance());
        Editable text = editText.getText();
        Selection.setSelection(text, text.length());
        imageView.setImageDrawable(androidx.core.content.a.c(this.h.getApplicationContext(), z ? R.drawable.icon_eye_close : R.drawable.icon_eyey_open));
    }
}
