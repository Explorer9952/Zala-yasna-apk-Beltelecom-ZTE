package com.zte.iptvclient.android.mobile.order.phone;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.video.androidsdk.common.AndroidUniqueCode;
import com.video.androidsdk.common.ClientNetworkInfo;
import com.video.androidsdk.login.SDKLoginMgr;
import com.zte.iptvclient.android.mobile.order.phone.d;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import java.net.SocketException;

/* loaded from: classes.dex */
public class OrderDialogActivity extends Activity {
    public static f u;

    /* renamed from: a, reason: collision with root package name */
    private TextView f6979a;

    /* renamed from: b, reason: collision with root package name */
    private Button f6980b;

    /* renamed from: c, reason: collision with root package name */
    private EditText f6981c;

    /* renamed from: d, reason: collision with root package name */
    private EditText f6982d;
    private LinearLayout e;
    private LinearLayout f;
    private LinearLayout g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private com.zte.iptvclient.android.mobile.order.phone.d l;
    private com.zte.iptvclient.android.mobile.order.phone.c m;
    private String n;
    private String o;
    private int p;
    private String q;
    private int r = 0;
    private Handler s = new a();
    private View.OnClickListener t = new c();

    /* loaded from: classes.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (OrderDialogActivity.this.isFinishing()) {
                return;
            }
            OrderDialogActivity.b(OrderDialogActivity.this);
            if (OrderDialogActivity.this.r == 0) {
                OrderDialogActivity.this.f6980b.setText("获取手机验证码");
                OrderDialogActivity.this.f6980b.setEnabled(true);
            } else {
                OrderDialogActivity.this.f6980b.setText(String.format("%s秒后重新发送", Integer.valueOf(OrderDialogActivity.this.r)));
                OrderDialogActivity.this.s.sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                OrderDialogActivity.this.findViewById(R.id.btn_start_order).setEnabled(true);
            } else {
                OrderDialogActivity.this.findViewById(R.id.btn_start_order).setEnabled(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.btn_get_validate) {
                OrderDialogActivity.this.a();
                return;
            }
            if (id == R.id.btn_start_order) {
                OrderDialogActivity.this.b();
                return;
            }
            if (id == R.id.btn_order_final) {
                OrderDialogActivity.this.finish();
                f fVar = OrderDialogActivity.u;
                if (fVar != null) {
                    fVar.a(OrderDialogActivity.this.p, OrderDialogActivity.this.q);
                    OrderDialogActivity.u = null;
                    return;
                }
                return;
            }
            if (id == R.id.btn_edittext_clear) {
                OrderDialogActivity.this.f6981c.setText("");
                return;
            }
            if (id == R.id.btn_close) {
                OrderDialogActivity.this.finish();
                f fVar2 = OrderDialogActivity.u;
                if (fVar2 != null) {
                    fVar2.a(-1, "cancel order");
                    OrderDialogActivity.u = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements d.InterfaceC0329d {
        d() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.phone.d.InterfaceC0329d
        public void a(int i, String str, String str2) {
            if (i == 0) {
                OrderDialogActivity.this.o = str2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements d.e {
        e() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.phone.d.e
        public void a(int i, String str) {
            if (OrderDialogActivity.this.isFinishing()) {
                return;
            }
            OrderDialogActivity.this.p = i;
            OrderDialogActivity.this.q = str;
            if (i == 0) {
                OrderDialogActivity.this.k.setText("成功购买" + OrderDialogActivity.this.m.f6992a);
            } else {
                OrderDialogActivity.this.i.setText("话费支付失败");
                OrderDialogActivity.this.j.setText("请您尝试其他支付方式，");
                OrderDialogActivity.this.k.setText("或稍后重试！");
                ((ImageView) OrderDialogActivity.this.findViewById(R.id.order_result_icon)).setImageResource(R.drawable.icon_vip_unsuccessful);
            }
            OrderDialogActivity.this.f.setVisibility(8);
            OrderDialogActivity.this.g.setVisibility(0);
        }
    }

    static /* synthetic */ int b(OrderDialogActivity orderDialogActivity) {
        int i = orderDialogActivity.r;
        orderDialogActivity.r = i - 1;
        return i;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        setContentView(R.layout.activity_order_dialog);
        c();
        com.zte.iptvclient.android.mobile.order.phone.d dVar = new com.zte.iptvclient.android.mobile.order.phone.d();
        this.l = dVar;
        dVar.f6996a = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_THIRDPLATFORM_PHONEPAY_APP_SERVER);
        if (getIntent() != null && (extras = getIntent().getExtras()) != null) {
            this.m = com.zte.iptvclient.android.mobile.order.phone.c.a(extras);
        }
        if (this.m == null) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        u = null;
    }

    private void c() {
        TextView textView = (TextView) findViewById(R.id.common_confirm_dlg_title);
        this.f6979a = textView;
        textView.setText("通过手机短信验证码确认支付");
        this.e = (LinearLayout) findViewById(R.id.step_one_layout);
        this.f = (LinearLayout) findViewById(R.id.step_two_layout);
        this.g = (LinearLayout) findViewById(R.id.step_three_layout);
        TextView textView2 = (TextView) findViewById(R.id.txt_paying);
        this.h = textView2;
        textView2.setText("支付中，请稍等...");
        TextView textView3 = (TextView) findViewById(R.id.tv_order_result_title);
        this.i = textView3;
        textView3.setText("话费支付成功");
        TextView textView4 = (TextView) findViewById(R.id.tv_order_result_desc1);
        this.j = textView4;
        textView4.setText("你已通过话费支付");
        TextView textView5 = (TextView) findViewById(R.id.tv_order_result_desc2);
        this.k = textView5;
        textView5.setText("成功购买包月VIP服务");
        Button button = (Button) findViewById(R.id.btn_get_validate);
        this.f6980b = button;
        button.setText("获取手机验证码");
        this.f6980b.setOnClickListener(this.t);
        this.f6981c = (EditText) findViewById(R.id.et_phone_num);
        EditText editText = (EditText) findViewById(R.id.et_auth_code);
        this.f6982d = editText;
        editText.setHint("请输入验证码");
        this.f6981c.setText(SDKLoginMgr.getInstance().getUserID());
        this.f6982d.addTextChangedListener(new b());
        Button button2 = (Button) findViewById(R.id.btn_start_order);
        button2.setText("确认支付");
        button2.setOnClickListener(this.t);
        Button button3 = (Button) findViewById(R.id.btn_order_final);
        button3.setText("确定");
        button3.setOnClickListener(this.t);
        findViewById(R.id.btn_edittext_clear).setOnClickListener(this.t);
        findViewById(R.id.btn_close).setOnClickListener(this.t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (!TextUtils.isEmpty(this.f6982d.getText().toString())) {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
            }
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            com.zte.iptvclient.android.mobile.order.phone.e eVar = new com.zte.iptvclient.android.mobile.order.phone.e();
            eVar.f7002d = this.n;
            eVar.f7001c = this.o;
            eVar.a(this.f6982d.getText().toString());
            this.l.a(eVar, new e());
            return;
        }
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.toast_v_code));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        String obj = this.f6981c.getText().toString();
        this.n = obj;
        if (a(obj)) {
            this.f6980b.setEnabled(false);
            this.r = 60;
            this.f6980b.setText(String.format("%s秒后重新发送", 60));
            this.s.sendEmptyMessageDelayed(0, 1000L);
            if (TextUtils.isEmpty(this.o)) {
                com.zte.iptvclient.android.mobile.order.phone.b bVar = new com.zte.iptvclient.android.mobile.order.phone.b(this.m);
                bVar.r = this.n;
                bVar.g = AndroidUniqueCode.getAndroidId(this);
                try {
                    bVar.h = new ClientNetworkInfo().getLocalIPAddress();
                } catch (SocketException e2) {
                    e2.printStackTrace();
                }
                this.l.a(bVar, new d());
                return;
            }
            g gVar = new g();
            gVar.f7006d = this.n;
            gVar.f7004b = this.o;
            this.l.a(gVar);
            return;
        }
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.toast_input_phone_number));
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[1][34578]\\d{9}");
    }
}
