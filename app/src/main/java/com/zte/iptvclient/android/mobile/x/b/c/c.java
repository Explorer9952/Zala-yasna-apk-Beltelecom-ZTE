package com.zte.iptvclient.android.mobile.x.b.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.sns.ISNSActionListener;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.zala.R;

/* compiled from: VideoShareDialog.java */
/* loaded from: classes2.dex */
public class c extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    private Activity f7780a;

    /* renamed from: b, reason: collision with root package name */
    private View f7781b;

    /* renamed from: c, reason: collision with root package name */
    private Button f7782c;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f7783d;
    private LinearLayout e;
    private LinearLayout f;
    private LinearLayout g;
    private LinearLayout h;
    private LinearLayout i;
    private LinearLayout j;
    private LinearLayout k;
    private LinearLayout l;
    private LinearLayout m;
    private String n;
    private String o;
    private String p;
    private String q;
    private Bitmap r;
    private String s;
    private LayoutInflater t;
    private com.zte.iptvclient.android.mobile.x.b.a u;
    private WebView v;
    private int w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoShareDialog.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoShareDialog.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
            c.this.w = 4;
            c.this.u.a(c.this.n, (String) null, c.this.r);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoShareDialog.java */
    /* renamed from: com.zte.iptvclient.android.mobile.x.b.c.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewOnClickListenerC0396c implements View.OnClickListener {
        ViewOnClickListenerC0396c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
            c.this.w = 0;
            c.this.u.a(c.this.q, c.this.n, c.this.r, c.this.o, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoShareDialog.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
            c.this.w = 1;
            c.this.u.b(c.this.q, c.this.n, c.this.r, c.this.o, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoShareDialog.java */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
            c.this.u.a(c.this.q, c.this.n, c.this.o, c.this.p, c.this.s);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoShareDialog.java */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
            c.this.u.a(c.this.s);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoShareDialog.java */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
            c.this.u.b(c.this.q, c.this.n, c.this.o, c.this.p, c.this.s);
        }
    }

    public c(Activity activity, String str, String str2, String str3, String str4, Bitmap bitmap, ISNSActionListener iSNSActionListener, String str5) {
        super(activity);
        WindowManager.LayoutParams attributes;
        this.f7780a = activity;
        Window window = activity.getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.alpha = 0.5f;
            window.setAttributes(attributes);
        }
        this.n = str;
        this.o = str2;
        this.p = str3;
        this.q = str4;
        this.r = bitmap;
        this.s = str5;
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
        this.t = layoutInflater;
        View inflate = layoutInflater.inflate(R.layout.video_popup_share, (ViewGroup) null);
        this.f7781b = inflate;
        setContentView(inflate);
        setWidth(-1);
        setHeight(-2);
        setBackgroundDrawable(new BitmapDrawable());
        setOutsideTouchable(true);
        setFocusable(true);
        setAnimationStyle(R.style.mypopwindow_anim_bottom_up);
        b();
        a();
        this.u = new com.zte.iptvclient.android.mobile.x.b.a(activity);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        WindowManager.LayoutParams attributes;
        Window window = this.f7780a.getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.alpha = 1.0f;
            window.setAttributes(attributes);
        }
        super.dismiss();
    }

    @SuppressLint({"JavascriptInterface"})
    private void b() {
        this.f7783d = (LinearLayout) this.f7781b.findViewById(R.id.ll_filter_container);
        this.e = (LinearLayout) this.f7781b.findViewById(R.id.ll_facebook_container);
        this.f7782c = (Button) this.f7781b.findViewById(R.id.btn_cancel);
        this.f = (LinearLayout) this.f7781b.findViewById(R.id.ll_wechat);
        this.g = (LinearLayout) this.f7781b.findViewById(R.id.ll_wechat_session);
        this.h = (LinearLayout) this.f7781b.findViewById(R.id.ll_qq);
        this.i = (LinearLayout) this.f7781b.findViewById(R.id.ll_qq_zone);
        this.j = (LinearLayout) this.f7781b.findViewById(R.id.ll_weibo);
        this.k = (LinearLayout) this.f7781b.findViewById(R.id.ll_facebook);
        this.l = (LinearLayout) this.f7781b.findViewById(R.id.ll_vk);
        this.m = (LinearLayout) this.f7781b.findViewById(R.id.ll_viber);
        com.zte.iptvclient.common.uiframe.f.a(this.f7782c);
        com.zte.iptvclient.common.uiframe.f.a(this.f);
        com.zte.iptvclient.common.uiframe.f.a(this.g);
        com.zte.iptvclient.common.uiframe.f.a(this.h);
        com.zte.iptvclient.common.uiframe.f.a(this.i);
        com.zte.iptvclient.common.uiframe.f.a(this.j);
        com.zte.iptvclient.common.uiframe.f.a(this.f7781b.findViewById(R.id.ll_filter_container));
        com.zte.iptvclient.common.uiframe.f.a(this.f7781b.findViewById(R.id.ll_facebook_container));
        com.zte.iptvclient.common.uiframe.f.a(this.f7781b.findViewById(R.id.img_wechat));
        com.zte.iptvclient.common.uiframe.f.a(this.f7781b.findViewById(R.id.txt_wechat));
        com.zte.iptvclient.common.uiframe.f.a(this.f7781b.findViewById(R.id.line_bottom));
        com.zte.iptvclient.common.uiframe.f.a(this.f7781b.findViewById(R.id.img_wechat_session));
        com.zte.iptvclient.common.uiframe.f.a(this.f7781b.findViewById(R.id.txt_wechat_session));
        com.zte.iptvclient.common.uiframe.f.a(this.f7781b.findViewById(R.id.img_qq));
        com.zte.iptvclient.common.uiframe.f.a(this.f7781b.findViewById(R.id.txt_qq));
        com.zte.iptvclient.common.uiframe.f.a(this.f7781b.findViewById(R.id.img_qq_zone));
        com.zte.iptvclient.common.uiframe.f.a(this.f7781b.findViewById(R.id.txt_qq_zone));
        com.zte.iptvclient.common.uiframe.f.a(this.f7781b.findViewById(R.id.img_weibo));
        com.zte.iptvclient.common.uiframe.f.a(this.f7781b.findViewById(R.id.txt_weibo));
        com.zte.iptvclient.common.uiframe.f.a(this.f7781b.findViewById(R.id.img_facebook));
        com.zte.iptvclient.common.uiframe.f.a(this.f7781b.findViewById(R.id.txt_facebook));
        TextView textView = (TextView) this.f7781b.findViewById(R.id.txt_vk);
        com.zte.iptvclient.common.uiframe.f.a(this.f7781b.findViewById(R.id.img_vk));
        com.zte.iptvclient.common.uiframe.f.a(textView);
        TextView textView2 = (TextView) this.f7781b.findViewById(R.id.txt_viber);
        com.zte.iptvclient.common.uiframe.f.a(this.f7781b.findViewById(R.id.img_viber));
        com.zte.iptvclient.common.uiframe.f.a(textView2);
        if (TextUtils.equals("0", ConfigMgr.readPropertie("SupportWeiboShare"))) {
            this.j.setVisibility(8);
        }
        if (TextUtils.equals("0", ConfigMgr.readPropertie("SupportQQShare"))) {
            this.h.setVisibility(8);
        }
        if (TextUtils.equals("0", ConfigMgr.readPropertie("SupportQZoneShare"))) {
            this.i.setVisibility(8);
        }
        if (TextUtils.equals("1", ConfigMgr.readPropertie("SupportFaceBook"))) {
            this.f7783d.setVisibility(8);
            this.e.setVisibility(0);
        } else {
            this.f7783d.setVisibility(0);
            this.e.setVisibility(8);
        }
        TextView textView3 = (TextView) this.f7781b.findViewById(R.id.txt_wechat);
        TextView textView4 = (TextView) this.f7781b.findViewById(R.id.txt_wechat_session);
        TextView textView5 = (TextView) this.f7781b.findViewById(R.id.txt_weibo);
        TextView textView6 = (TextView) this.f7781b.findViewById(R.id.txt_facebook);
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_wechat));
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_wechat_session));
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_weibo_session));
        textView6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_facebook));
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_vk));
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_viber));
        ((Button) this.f7781b.findViewById(R.id.btn_cancel)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel));
        TextView textView7 = (TextView) this.f7781b.findViewById(R.id.tv_program_title);
        com.zte.iptvclient.common.uiframe.f.a(textView7);
        textView7.setText(this.q);
        WebView webView = (WebView) this.f7781b.findViewById(R.id.WebView);
        this.v = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        String a2 = a(this.q, this.n, this.o, this.p);
        LogEx.d("VideoShareDialog", "webUrl = " + a2);
        this.v.loadUrl(a2);
    }

    private static String c() {
        String lowerCase = BaseApp.e().getResources().getConfiguration().locale.getLanguage().toLowerCase();
        LogEx.d("VideoShareDialog", "locale:" + lowerCase);
        return ("be" == lowerCase || "en" == lowerCase) ? lowerCase : LocaleUtil.RUSSIAN;
    }

    private void a() {
        this.f7782c.setOnClickListener(new a());
        this.j.setOnClickListener(new b());
        this.f.setOnClickListener(new ViewOnClickListenerC0396c());
        this.g.setOnClickListener(new d());
        this.k.setOnClickListener(new e());
        this.l.setOnClickListener(new f());
        this.m.setOnClickListener(new g());
    }

    public void a(View view) {
        WindowManager.LayoutParams attributes;
        setSoftInputMode(16);
        Window window = this.f7780a.getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            window.setAttributes(attributes);
        }
        if (this.f7780a.getResources().getConfiguration().orientation == 2) {
            this.f7781b.setSystemUiVisibility(3846);
        }
        showAtLocation(view, 80, 0, 0);
    }

    private String a(String str, String str2, String str3, String str4) {
        String str5;
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(str3)) {
            stringBuffer.append(str3);
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                stringBuffer.append("&vn=" + str);
            }
            if (!TextUtils.isEmpty(str4)) {
                stringBuffer.append("&pp=" + i.i());
                stringBuffer.append("&pf=" + str4);
            }
            stringBuffer.append("&lan=" + c());
            str5 = stringBuffer.toString();
        } catch (Exception e2) {
            LogEx.d("e=", e2.toString());
            str5 = "";
        }
        String replace = str5.replace("\"", "");
        LogEx.d("VideoShareDialog", "linUrl = " + replace);
        return replace;
    }
}
