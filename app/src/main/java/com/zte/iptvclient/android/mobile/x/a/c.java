package com.zte.iptvclient.android.mobile.x.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.zala.R;

/* compiled from: ShareFragment.java */
/* loaded from: classes2.dex */
public class c extends com.zte.fragmentlib.b {
    private Bitmap A;
    private long B = 0;
    private LinearLayout p;
    private LinearLayout q;
    private LinearLayout r;
    private LinearLayout s;
    private LinearLayout t;
    private LinearLayout u;
    private LinearLayout v;
    private LinearLayout w;
    private Button x;
    private String y;
    private com.zte.iptvclient.android.mobile.x.b.a z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShareFragment.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.getActivity() instanceof HostActivity) {
                c.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShareFragment.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (c.this.K()) {
                return;
            }
            String c2 = com.zte.iptvclient.common.uiframe.a.c("APP_Share_URL");
            if (TextUtils.isEmpty(c2)) {
                str = null;
            } else {
                str = c2 + "?pcode=,0,,&ptype=0";
            }
            c.this.z.b(com.zte.iptvclient.android.common.i.a.a.a(R.string.share_content_title) + com.zte.iptvclient.android.common.i.a.a.a(R.string.app_name), c.this.y, c.this.A, str, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShareFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.x.a.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewOnClickListenerC0391c implements View.OnClickListener {
        ViewOnClickListenerC0391c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (c.this.K()) {
                return;
            }
            String c2 = com.zte.iptvclient.common.uiframe.a.c("APP_Share_URL");
            if (TextUtils.isEmpty(c2)) {
                str = null;
            } else {
                str = c2 + "?pcode=,0,,&ptype=0";
            }
            c.this.z.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.share_content_title) + com.zte.iptvclient.android.common.i.a.a.a(R.string.app_name), c.this.y, c.this.A, str, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShareFragment.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.K()) {
                return;
            }
            c.this.z.a(c.this.y, c.this.A, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShareFragment.java */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e(c cVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShareFragment.java */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        f(c cVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShareFragment.java */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.K()) {
                return;
            }
            c.this.z.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.app_name), c.this.y, (String) null);
        }
    }

    private void I() {
        this.x.setOnClickListener(new a());
        this.t.setOnClickListener(new b());
        this.s.setOnClickListener(new ViewOnClickListenerC0391c());
        this.u.setOnClickListener(new d());
        this.v.setOnClickListener(new e(this));
        this.w.setOnClickListener(new f(this));
        this.r.setOnClickListener(new g());
    }

    private void J() {
        this.z = new com.zte.iptvclient.android.mobile.x.b.a(getActivity());
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Share_App_Title");
        this.y = c2;
        if (TextUtils.isEmpty(c2)) {
            this.y = getString(R.string.share_app_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.B <= 1000) {
            LogEx.w("UseeTv", "Operate limit,less than 1000(ms)!");
            return true;
        }
        this.B = currentTimeMillis;
        return false;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        I();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        J();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.share_fragment, (ViewGroup) null);
        d(inflate);
        return inflate;
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        Button button = (Button) view.findViewById(R.id.btn_back);
        this.x = button;
        if (this.o) {
            button.setVisibility(0);
        }
        this.r = (LinearLayout) view.findViewById(R.id.ll_facebook);
        this.p = (LinearLayout) view.findViewById(R.id.ll_filter_container);
        this.q = (LinearLayout) view.findViewById(R.id.ll_facebook_container);
        this.s = (LinearLayout) view.findViewById(R.id.ll_wechat);
        this.t = (LinearLayout) view.findViewById(R.id.ll_wechat_session);
        this.v = (LinearLayout) view.findViewById(R.id.ll_qq);
        this.w = (LinearLayout) view.findViewById(R.id.ll_qq_zone);
        this.u = (LinearLayout) view.findViewById(R.id.ll_sina_weibo);
        this.A = BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.share_img);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        TextView textView2 = (TextView) view.findViewById(R.id.title_txt);
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.share_title));
        com.zte.iptvclient.common.uiframe.f.a(textView2);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_filter_container));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_wechat_session));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_wechat_session));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_wechat));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_wechat));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_qq));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_qq));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_qq_zone));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_qq_zone));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_sina_weibo));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_sina_weibo));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_facebook));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_facebook));
        if (TextUtils.equals("0", ConfigMgr.readPropertie("SupportWeiboShare"))) {
            this.u.setVisibility(8);
        }
        if (TextUtils.equals("0", ConfigMgr.readPropertie("SupportQQShare"))) {
            this.v.setVisibility(8);
        }
        if (TextUtils.equals("0", ConfigMgr.readPropertie("SupportQZoneShare"))) {
            this.w.setVisibility(8);
        }
        if (TextUtils.equals("1", ConfigMgr.readPropertie("SupportFaceBook"))) {
            this.p.setVisibility(8);
            this.q.setVisibility(0);
        } else {
            this.p.setVisibility(0);
            this.q.setVisibility(8);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.header_bottom_line);
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        if (BaseApp.a(this.h)) {
            com.zte.iptvclient.android.common.k.g.a(imageView, this.h);
        }
        TextView textView3 = (TextView) view.findViewById(R.id.txt_wechat);
        TextView textView4 = (TextView) view.findViewById(R.id.txt_wechat_session);
        TextView textView5 = (TextView) view.findViewById(R.id.txt_sina_weibo);
        TextView textView6 = (TextView) view.findViewById(R.id.txt_facebook);
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_wechat));
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_wechat_session));
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_weibo_session));
        textView6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_facebook));
    }
}
