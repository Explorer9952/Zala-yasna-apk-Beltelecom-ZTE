package com.zte.iptvclient.android.mobile.user.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChangePwdFragment.java */
/* loaded from: classes2.dex */
public class h extends com.zte.fragmentlib.b implements View.OnClickListener {
    private TextView A;
    private LinearLayout B;
    private TextView C;
    private TextView D;
    private TextView E;
    View.OnFocusChangeListener F = new a();
    private TextView p;
    private EditText q;
    private TextView r;
    private EditText s;
    private TextView t;
    private EditText u;
    private com.zte.iptvclient.android.common.j.h v;
    private LinearLayout w;
    private RelativeLayout x;
    private Button y;
    private TextView z;

    /* compiled from: ChangePwdFragment.java */
    /* loaded from: classes2.dex */
    class a implements View.OnFocusChangeListener {
        a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                h.this.K();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChangePwdFragment.java */
    /* loaded from: classes2.dex */
    public class b implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7446a;

        b(String str) {
            this.f7446a = str;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("ChangePwdFragment", "modifyLimitpassword:  onDataReturn,arg0= " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("returncode").equals("0")) {
                    h.this.v.p(this.f7446a);
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.modify_password_success);
                } else {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(jSONObject.getString("errormsg"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("ChangePwdFragment", "modifyLimitpassword onFailReturn,arg0= " + str + " ,arg1=" + i);
        }
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.w = (LinearLayout) view.findViewById(R.id.lock_linearLayout_header);
        this.x = (RelativeLayout) view.findViewById(R.id.lock_nomal);
        this.y = (Button) view.findViewById(R.id.btn_back);
        this.z = (TextView) view.findViewById(R.id.lock_nomal_title);
        this.A = (TextView) view.findViewById(R.id.lock_nomal_btn_edit);
        this.B = (LinearLayout) view.findViewById(R.id.lock_confrim);
        this.C = (TextView) view.findViewById(R.id.lock_confrim_cancel);
        this.D = (TextView) view.findViewById(R.id.lock_confirm_title);
        this.E = (TextView) view.findViewById(R.id.lock_confrim_ok);
        this.p = (TextView) view.findViewById(R.id.txt_old_password);
        this.q = (EditText) view.findViewById(R.id.lock_changepwd_item1_input);
        this.r = (TextView) view.findViewById(R.id.txt_new_password);
        this.s = (EditText) view.findViewById(R.id.lock_changepwd_item2_input);
        this.t = (TextView) view.findViewById(R.id.txt_confirm_password);
        this.u = (EditText) view.findViewById(R.id.lock_changepwd_item3_input);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        com.zte.iptvclient.common.uiframe.f.a(this.D);
        com.zte.iptvclient.common.uiframe.f.a(this.E);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        this.q.setOnFocusChangeListener(this.F);
        this.s.setOnFocusChangeListener(this.F);
        this.u.setOnFocusChangeListener(this.F);
        this.y.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.z.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.change_password));
        this.C.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.lock_cancel));
        this.D.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.change_password));
        this.E.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.lock_ok));
        this.p.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.old_password));
        this.q.setHint(com.zte.iptvclient.android.common.i.a.a.a(R.string.old_password_hint));
        this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.new_password));
        this.s.setHint(com.zte.iptvclient.android.common.i.a.a.a(R.string.new_password_hint));
        this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_new_password));
        this.u.setHint(com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_new_password_hint));
        this.A.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_edit));
        LogEx.d("ChangePwdFragment", "mComfirmPwd " + com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_new_password_hint));
        b(false);
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        if (getActivity() instanceof MainActivity) {
            F();
            return true;
        }
        if (!(getActivity() instanceof HostActivity)) {
            return true;
        }
        getActivity().finish();
        return true;
    }

    public void I() {
        this.q.setText("");
        this.s.setText("");
        this.u.setText("");
        this.q.setFocusable(false);
        this.s.setFocusable(false);
        this.u.setFocusable(false);
        this.q.setFocusable(true);
        this.q.setFocusableInTouchMode(true);
        this.s.setFocusable(true);
        this.s.setFocusableInTouchMode(true);
        this.u.setFocusable(true);
        this.u.setFocusableInTouchMode(true);
    }

    public String J() {
        LogEx.d("change password", this.s.getText().toString());
        return this.s.getText().toString();
    }

    public void K() {
        this.x.setVisibility(4);
        this.B.setVisibility(0);
    }

    public boolean L() {
        String trim = this.s.getText().toString().trim();
        String trim2 = this.u.getText().toString().trim();
        if (TextUtils.equals(this.q.getText().toString(), this.v.u())) {
            if (trim.length() == 4 && trim2.length() == 4) {
                if (TextUtils.equals(this.q.getText().toString(), this.s.getText().toString())) {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.password_compare));
                    I();
                    this.q.setFocusable(true);
                    this.q.setFocusableInTouchMode(true);
                    this.q.requestFocus();
                    return false;
                }
                if (TextUtils.equals(this.s.getText().toString(), this.u.getText().toString())) {
                    return true;
                }
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.password_confirm_error));
                I();
                return false;
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.password_rule_check);
            this.s.setFocusable(true);
            this.s.requestFocus();
            this.s.setText("");
            this.u.setText("");
            return false;
        }
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.old_password_error));
        I();
        return false;
    }

    public void b(boolean z) {
        if (z) {
            this.u.setFocusableInTouchMode(true);
            this.u.setFocusable(true);
            this.u.requestFocus();
            this.s.setFocusableInTouchMode(true);
            this.s.setFocusable(true);
            this.s.requestFocus();
            this.q.setFocusableInTouchMode(true);
            this.q.setFocusable(true);
            this.q.requestFocus();
            return;
        }
        this.q.setFocusable(false);
        this.q.setFocusableInTouchMode(false);
        this.s.setFocusable(false);
        this.s.setFocusableInTouchMode(false);
        this.u.setFocusable(false);
        this.u.setFocusableInTouchMode(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back /* 2131296427 */:
                D();
                return;
            case R.id.lock_confrim_cancel /* 2131297387 */:
                this.x.setVisibility(0);
                this.B.setVisibility(4);
                I();
                b(false);
                return;
            case R.id.lock_confrim_ok /* 2131297388 */:
                this.x.setVisibility(0);
                this.B.setVisibility(4);
                if (L()) {
                    s(J());
                    I();
                    b(false);
                    return;
                }
                return;
            case R.id.lock_nomal_btn_edit /* 2131297397 */:
                this.x.setVisibility(4);
                this.B.setVisibility(0);
                b(true);
                return;
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_change_pwd, viewGroup, false);
        d(inflate);
        this.v = new com.zte.iptvclient.android.common.j.h(getActivity());
        return inflate;
    }

    public void s(String str) {
        String replace = ("http://{epgdomain}:{port}/iptvepg/datasource/dochangeuserpwd.jsp?oldpassword=" + this.v.u() + "&newpassword=" + str + "&passwordtype=1").replace("http://{epgdomain}:{port}/iptvepg/", com.zte.iptvclient.android.common.f.b.i.a());
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.startRequest(replace, "GET", new b(str));
    }
}
