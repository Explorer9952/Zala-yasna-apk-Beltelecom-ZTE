package com.zte.iptvclient.android.mobile.user.fragment;

import android.graphics.drawable.GradientDrawable;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.customview.a.a.e.i;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AtRechargeFragment.java */
/* loaded from: classes2.dex */
public class c extends com.zte.fragmentlib.b {
    private TextView B;
    private Button q;
    private TextView r;
    private RelativeLayout s;
    private EditText t;
    private ImageView u;
    private Button v;
    private com.zte.iptvclient.android.common.j.h w;
    private String x;
    private String y;
    private final String p = c.class.getSimpleName();
    private boolean z = false;
    private long A = System.currentTimeMillis();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtRechargeFragment.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnFocusChangeListener {
        a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                c.this.u.setVisibility(8);
            } else {
                if (StringUtil.isEmptyString(c.this.t.getText().toString())) {
                    return;
                }
                c.this.u.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtRechargeFragment.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.t.isFocusable()) {
                return false;
            }
            c.this.t.setFocusableInTouchMode(true);
            c.this.t.setFocusable(true);
            if (c.this.t.isFocused()) {
                return false;
            }
            c.this.t.requestFocus();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtRechargeFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.user.fragment.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0366c implements TextWatcher {
        C0366c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                c.this.u.setVisibility(0);
                ((GradientDrawable) c.this.v.getBackground()).setColor(c.this.getResources().getColor(R.color.confirm_bg));
                c.this.v.setEnabled(true);
            } else {
                c.this.u.setVisibility(8);
                ((GradientDrawable) c.this.v.getBackground()).setColor(c.this.getResources().getColor(R.color.login_normal_txt));
                c.this.v.setEnabled(false);
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
    /* compiled from: AtRechargeFragment.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.t.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtRechargeFragment.java */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtRechargeFragment.java */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((com.zte.fragmentlib.b) c.this).h.q();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c.this.A <= 500) {
                return;
            }
            c.this.A = currentTimeMillis;
            c.this.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtRechargeFragment.java */
    /* loaded from: classes2.dex */
    public class g implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        g() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            ((com.zte.fragmentlib.b) c.this).h.d();
            LogEx.d(c.this.p, "onDataReturn s=" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("returncode").equals("0")) {
                    c.this.x = jSONObject.getString("expiredtime");
                    if (!TextUtils.isEmpty(c.this.x)) {
                        try {
                            Date parse = new SimpleDateFormat("yyyyMMddhhmmss").parse(c.this.x);
                            c.this.x = new SimpleDateFormat("yyyy.MM.dd").format(parse);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    c.this.z = true;
                    if (((com.zte.fragmentlib.b) c.this).h.isFinishing()) {
                        return;
                    }
                    c.this.e(c.this.x, "");
                    return;
                }
                if (!TextUtils.isEmpty(jSONObject.getString("errormsg"))) {
                    c.this.y = jSONObject.getString("errormsg");
                }
                c.this.z = false;
                if (jSONObject.getString("returncode").equals("1001")) {
                    c.this.y = com.zte.iptvclient.android.common.i.a.a.a(R.string.users_do_not_recharge);
                } else {
                    if (!jSONObject.getString("returncode").equals("2001") && !jSONObject.getString("returncode").equals("4001")) {
                        if (jSONObject.getString("returncode").equals("3001")) {
                            c.this.y = com.zte.iptvclient.android.common.i.a.a.a(R.string.failure_of_recharge);
                        } else {
                            c.this.y = com.zte.iptvclient.android.common.i.a.a.a(R.string.operation_failed);
                        }
                    }
                    c.this.y = com.zte.iptvclient.android.common.i.a.a.a(R.string.query_balance_failed);
                }
                if (((com.zte.fragmentlib.b) c.this).h.isFinishing()) {
                    return;
                }
                c.this.e(c.this.x, c.this.y);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            ((com.zte.fragmentlib.b) c.this).h.d();
            LogEx.d(c.this.p, "onFailReturn s=" + str + "i=" + i);
            c.this.z = false;
            c.this.x = com.zte.iptvclient.android.common.i.a.a.a(R.string.operation_failed);
            c.this.y = com.zte.iptvclient.android.common.i.a.a.a(R.string.operation_failed);
            if (((com.zte.fragmentlib.b) c.this).h.isFinishing()) {
                return;
            }
            c cVar = c.this;
            cVar.e("", cVar.x);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtRechargeFragment.java */
    /* loaded from: classes2.dex */
    public class h implements i.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.e.i f7430a;

        h(com.zte.iptvclient.android.common.customview.a.a.e.i iVar) {
            this.f7430a = iVar;
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.i.b
        public void a() {
            this.f7430a.dismiss();
            if (c.this.z) {
                c.this.I();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.t.a(this.z));
        if (getActivity() instanceof MainActivity) {
            F();
        } else if (getActivity() instanceof HostActivity) {
            getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        String c2 = com.zte.iptvclient.android.common.k.o.j().c();
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        String d2 = com.zte.iptvclient.common.uiframe.a.d("UserID");
        String s = s(d2);
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.setCharset("UTF-8");
        sDKNetHTTPRequest.setBody("usercode=" + d2 + "&bossusercode=" + this.w.d() + "&authinfo=" + s);
        sDKNetHTTPRequest.startRequest(c2 + "/uservcrecharge", "POST", new g());
    }

    private void K() {
        this.t.setOnFocusChangeListener(new a());
        this.t.setOnTouchListener(new b());
        this.t.addTextChangedListener(new C0366c());
        this.u.setOnClickListener(new d());
        this.q.setOnClickListener(new e());
        this.v.setOnClickListener(new f());
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        I();
        return true;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.at_recharge_fragment, (ViewGroup) null);
        d(inflate);
        K();
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String s(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = ""
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.widget.EditText r2 = r10.t
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r2 = "$$"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "IMP_Password"
            java.lang.String r3 = com.video.androidsdk.common.config.ConfigMgr.readPropertie(r3)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r11)
            r4.append(r2)
            java.lang.String r11 = r4.toString()
            java.util.Calendar r4 = java.util.Calendar.getInstance()
            r5 = 11
            r6 = 1
            r4.add(r5, r6)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            long r6 = r4.getTimeInMillis()
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 / r8
            java.lang.String r4 = java.lang.Long.toHexString(r6)
            r5.append(r4)
            r5.append(r2)
            java.lang.String r4 = r5.toString()
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            if (r5 != 0) goto L6e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            r5.append(r3)
            r5.append(r2)
            java.lang.String r4 = r5.toString()
        L6e:
            r2 = 10
            java.lang.String r2 = com.zte.iptvclient.android.common.k.a.a(r2)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r11)
            r3.append(r4)
            r3.append(r1)
            r3.append(r2)
            java.lang.String r11 = r3.toString()
            byte[] r11 = r11.getBytes()
            java.lang.String r1 = "impkey"
            java.lang.String r1 = com.video.androidsdk.common.AES.getEncryptKey(r1)
            byte[] r1 = r1.getBytes()     // Catch: java.lang.Exception -> La4
            java.lang.String r11 = com.zte.iptvclient.android.common.k.a.c(r11, r1)     // Catch: java.lang.Exception -> La4
            java.lang.String r1 = "UTF-8"
            java.lang.String r11 = java.net.URLEncoder.encode(r11, r1)     // Catch: java.lang.Exception -> La2
            goto La9
        La2:
            r1 = move-exception
            goto La6
        La4:
            r1 = move-exception
            r11 = r0
        La6:
            r1.printStackTrace()
        La9:
            if (r11 != 0) goto Lac
            goto Lad
        Lac:
            r0 = r11
        Lad:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = "encriptStr: "
            r11.append(r1)
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            java.lang.String r1 = "encryptionAES"
            com.video.androidsdk.log.LogEx.d(r1, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.user.fragment.c.s(java.lang.String):java.lang.String");
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.q = (Button) view.findViewById(R.id.btn_back);
        this.r = (TextView) view.findViewById(R.id.title_txt);
        this.s = (RelativeLayout) view.findViewById(R.id.rl_password);
        this.t = (EditText) view.findViewById(R.id.edtLoginPassword);
        this.u = (ImageView) view.findViewById(R.id.img_password_clear);
        this.v = (Button) view.findViewById(R.id.btn_confirm);
        TextView textView2 = (TextView) view.findViewById(R.id.txt_voucher_card);
        this.B = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.voucher_card));
        this.t.setHint(com.zte.iptvclient.android.common.i.a.a.a(R.string.recharge_voucher_no));
        this.v.setHint(com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm));
        this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recharge));
        this.q.setVisibility(0);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
        this.w = new com.zte.iptvclient.android.common.j.h(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, String str2) {
        com.zte.iptvclient.android.common.customview.a.a.e.i iVar = new com.zte.iptvclient.android.common.customview.a.a.e.i(this.h, R.style.dialog_order, str, this.z, str2);
        iVar.a(new h(iVar));
        iVar.a();
    }
}
