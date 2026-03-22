package com.zte.iptvclient.android.mobile.f.a;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChangeOrderPwdFragment.java */
/* loaded from: classes.dex */
public class c extends com.zte.fragmentlib.b implements View.OnClickListener {
    private String A;
    private String B;
    private String C;
    private String E;
    private h p;
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
    private String D = "3";
    private long F = System.currentTimeMillis();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChangeOrderPwdFragment.java */
    /* loaded from: classes.dex */
    public class a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6168a;

        a(String str) {
            this.f6168a = str;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("ChangeOrderPwdFragment", "modifyOrderpassword onDataReturn, arg0= " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("returncode").equals("0")) {
                    if ("1".equals(c.this.D)) {
                        c.this.p.p(this.f6168a);
                    } else {
                        c.this.p.w(this.f6168a);
                    }
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.modify_password_success));
                    return;
                }
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(jSONObject.getString("errormsg"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("ChangeOrderPwdFragment", "modifyOrderpassword onFailReturn, arg0= " + str + " ,arg1= " + i);
        }
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
        this.q = (RelativeLayout) view.findViewById(R.id.title_rlayout);
        this.r = (Button) view.findViewById(R.id.btn_back);
        if (BaseApp.a(this.h)) {
            this.r.setVisibility(8);
        } else {
            this.r.setVisibility(0);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.title_txt);
        this.s = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.change_password));
        this.t = (TextView) view.findViewById(R.id.txt_old_password);
        this.u = (EditText) view.findViewById(R.id.edit_old_password);
        this.v = (TextView) view.findViewById(R.id.txt_new_password);
        this.w = (EditText) view.findViewById(R.id.edit_new_password);
        this.x = (TextView) view.findViewById(R.id.txt_confirm_password);
        this.y = (EditText) view.findViewById(R.id.edit_confirm_password);
        this.z = (Button) view.findViewById(R.id.btn_confirm);
        ImageView imageView = (ImageView) view.findViewById(R.id.header_bottom_line);
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        if (BaseApp.a(this.h)) {
            imageView.setVisibility(0);
            com.zte.iptvclient.android.common.k.g.a(imageView, this.h);
        }
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.change_password));
        this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.old_password));
        this.u.setHint(com.zte.iptvclient.android.common.i.a.a.a(R.string.old_password_hint));
        this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.new_password));
        this.w.setHint(com.zte.iptvclient.android.common.i.a.a.a(R.string.new_password_hint));
        this.w.setHint(com.zte.iptvclient.android.common.i.a.a.a(R.string.new_password_hint));
        this.x.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_new_password));
        this.y.setHint(com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_new_password_hint));
        this.z.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.order_confirm));
        this.u.setTypeface(Typeface.DEFAULT);
        this.u.setTransformationMethod(new PasswordTransformationMethod());
        this.w.setTypeface(Typeface.DEFAULT);
        this.w.setTransformationMethod(new PasswordTransformationMethod());
        this.y.setTypeface(Typeface.DEFAULT);
        this.y.setTransformationMethod(new PasswordTransformationMethod());
        this.u.setInputType(3);
        this.w.setInputType(3);
        this.y.setInputType(3);
        this.r.setOnClickListener(this);
        this.z.setOnClickListener(this);
        L();
    }

    public void I() {
        this.u.setText("");
        this.w.setText("");
        this.y.setText("");
        this.u.setFocusable(false);
        this.w.setFocusable(false);
        this.y.setFocusable(false);
        this.u.setFocusable(true);
        this.u.setFocusableInTouchMode(true);
        this.w.setFocusable(true);
        this.w.setFocusableInTouchMode(true);
        this.y.setFocusable(true);
        this.y.setFocusableInTouchMode(true);
    }

    public String J() {
        LogEx.d("change password", this.B);
        return this.B;
    }

    public boolean K() {
        if (TextUtils.equals(this.A, this.E)) {
            if (this.B.length() == 4 && this.C.length() == 4) {
                if (TextUtils.equals(this.A, this.B)) {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.password_compare));
                    I();
                    L();
                    return false;
                }
                if (TextUtils.equals(this.B, this.C)) {
                    return true;
                }
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.password_confirm_error));
                I();
                L();
                return false;
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.password_rule_check));
            this.w.setFocusable(true);
            this.w.requestFocus();
            this.w.setText("");
            this.y.setText("");
            return false;
        }
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.old_password_error));
        I();
        L();
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_back) {
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
        }
        if (id != R.id.btn_confirm) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.F <= 500) {
            return;
        }
        this.F = currentTimeMillis;
        A();
        this.A = this.u.getText().toString().trim();
        this.B = this.w.getText().toString().trim();
        this.C = this.y.getText().toString().trim();
        if (K()) {
            s(J());
            I();
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.D = arguments.getString(ParamConst.USER_PWD_MODIGY_REQ_PASSWORDTYPE, "3");
        }
        LogEx.d("ChangeOrderPwdFragment", "ChangeOrderPwdFragment onCreate");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LogEx.d("ChangeOrderPwdFragment", "ChangeOrderPwdFragment onCreateView");
        View inflate = layoutInflater.inflate(R.layout.change_order_pwd_fragment, viewGroup, false);
        this.p = new h(getActivity());
        if ("1".equals(this.D)) {
            this.E = this.p.u();
        } else {
            this.E = this.p.B();
        }
        d(inflate);
        return inflate;
    }

    public void s(String str) {
        String replace = ("http://{epgdomain}:{port}/iptvepg/datasource/dochangeuserpwd.jsp?oldpassword=" + this.E + "&newpassword=" + str + "&passwordtype=" + this.D).replace("http://{epgdomain}:{port}", i.b());
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", i.h());
        sDKNetHTTPRequest.startRequest(replace, "GET", new a(str));
    }
}
