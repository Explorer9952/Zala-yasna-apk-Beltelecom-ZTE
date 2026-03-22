package com.zte.iptvclient.android.mobile.x.b.c;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.sns.ISNSActionListener;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: FullScreenShareDialog.java */
/* loaded from: classes2.dex */
public class a extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    private Activity f7765a;

    /* renamed from: b, reason: collision with root package name */
    private View f7766b;

    /* renamed from: c, reason: collision with root package name */
    private Button f7767c;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f7768d;
    private LinearLayout e;
    private LinearLayout f;
    private LinearLayout g;
    private LinearLayout h;
    private LinearLayout i;
    private LinearLayout j;
    private LinearLayout k;
    private String l;
    private String m;
    private String n;
    private Bitmap o;
    private LayoutInflater p;
    private com.zte.iptvclient.android.mobile.x.b.a q;
    private int r;
    TextView s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FullScreenShareDialog.java */
    /* renamed from: com.zte.iptvclient.android.mobile.x.b.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewOnClickListenerC0394a implements View.OnClickListener {
        ViewOnClickListenerC0394a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FullScreenShareDialog.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            a.this.r = 4;
            a.this.q.a(a.this.l, (String) null, a.this.o);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FullScreenShareDialog.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            a.this.r = 0;
            a.this.q.a(a.this.n, a.this.l, a.this.o, a.this.m, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FullScreenShareDialog.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            a.this.r = 1;
            a.this.q.b(a.this.n, a.this.l, a.this.o, a.this.m, false);
        }
    }

    public a(Activity activity, String str, String str2, String str3, String str4, Bitmap bitmap, ISNSActionListener iSNSActionListener) {
        super(activity);
        this.f7765a = activity;
        this.l = str;
        this.m = str2;
        this.n = str4;
        this.o = bitmap;
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
        this.p = layoutInflater;
        View inflate = layoutInflater.inflate(R.layout.full_screen_popup_share, (ViewGroup) null);
        this.f7766b = inflate;
        setContentView(inflate);
        setWidth(-1);
        setHeight(-2);
        setBackgroundDrawable(new BitmapDrawable());
        setOutsideTouchable(true);
        setFocusable(true);
        setAnimationStyle(R.style.mypopwindow_anim_bottom_up);
        b();
        a();
        this.q = new com.zte.iptvclient.android.mobile.x.b.a(activity);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
    }

    private void b() {
        this.f7768d = (LinearLayout) this.f7766b.findViewById(R.id.ll_filter_container);
        this.e = (LinearLayout) this.f7766b.findViewById(R.id.ll_facebook_container);
        Button button = (Button) this.f7766b.findViewById(R.id.btn_cancel);
        this.f7767c = button;
        button.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel));
        this.f = (LinearLayout) this.f7766b.findViewById(R.id.ll_wechat);
        this.g = (LinearLayout) this.f7766b.findViewById(R.id.ll_wechat_session);
        this.h = (LinearLayout) this.f7766b.findViewById(R.id.ll_qq);
        this.i = (LinearLayout) this.f7766b.findViewById(R.id.ll_qq_zone);
        this.j = (LinearLayout) this.f7766b.findViewById(R.id.ll_weibo);
        this.k = (LinearLayout) this.f7766b.findViewById(R.id.ll_facebook);
        TextView textView = (TextView) this.f7766b.findViewById(R.id.full_screen_program_tv);
        this.s = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.share_to));
        TextView textView2 = (TextView) this.f7766b.findViewById(R.id.txt_wechat);
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_wechat));
        TextView textView3 = (TextView) this.f7766b.findViewById(R.id.txt_wechat_session);
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_wechat_session));
        TextView textView4 = (TextView) this.f7766b.findViewById(R.id.txt_qq);
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_qq));
        TextView textView5 = (TextView) this.f7766b.findViewById(R.id.txt_qq_zone);
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_qq_zone));
        TextView textView6 = (TextView) this.f7766b.findViewById(R.id.txt_weibo);
        textView6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_weibo));
        TextView textView7 = (TextView) this.f7766b.findViewById(R.id.txt_facebook);
        textView7.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_facebook));
        f.a(this.f7767c);
        f.a(this.s);
        f.a(this.f);
        f.a(this.g);
        f.a(this.h);
        f.a(this.i);
        f.a(this.j);
        f.a(this.f7766b.findViewById(R.id.ll_filter_container));
        f.a(this.f7766b.findViewById(R.id.ll_facebook_container));
        f.a(this.f7766b.findViewById(R.id.img_wechat));
        f.a(textView2);
        f.a(this.f7766b.findViewById(R.id.line_bottom));
        f.a(this.f7766b.findViewById(R.id.img_wechat_session));
        f.a(textView3);
        f.a(this.f7766b.findViewById(R.id.img_qq));
        f.a(textView4);
        f.a(this.f7766b.findViewById(R.id.img_qq_zone));
        f.a(textView5);
        f.a(this.f7766b.findViewById(R.id.img_weibo));
        f.a(textView6);
        f.a(this.f7766b.findViewById(R.id.img_facebook));
        f.a(textView7);
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
            this.f7768d.setVisibility(8);
            this.e.setVisibility(0);
        } else {
            this.f7768d.setVisibility(0);
            this.e.setVisibility(8);
        }
    }

    private void a() {
        this.f7767c.setOnClickListener(new ViewOnClickListenerC0394a());
        this.j.setOnClickListener(new b());
        this.f.setOnClickListener(new c());
        this.g.setOnClickListener(new d());
    }

    public void a(View view) {
        setSoftInputMode(16);
        if (this.f7765a.getResources().getConfiguration().orientation == 2) {
            this.f7766b.setSystemUiVisibility(3846);
        }
        showAtLocation(view, 80, 0, 0);
    }
}
