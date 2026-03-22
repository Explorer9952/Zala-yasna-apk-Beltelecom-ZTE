package com.zte.iptvclient.android.mobile.e0.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import com.zte.iptvclient.android.common.k.u;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;

/* compiled from: AdapterRecycleColumnVideoMore.java */
/* loaded from: classes2.dex */
public class b extends RecyclerView.g<RecyclerView.b0> {

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<CommonVideoBean> f5799c;

    /* renamed from: d, reason: collision with root package name */
    private Context f5800d;
    private boolean e = false;

    /* compiled from: AdapterRecycleColumnVideoMore.java */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.b0 {
        private TextView A;
        private boolean B;
        private ImageView t;
        private ImageView u;
        private TextView v;
        private RelativeLayout w;
        private LinearLayout x;
        private TextView y;
        private ImageView z;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AdapterRecycleColumnVideoMore.java */
        /* renamed from: com.zte.iptvclient.android.mobile.e0.d.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class ViewOnClickListenerC0218a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CommonVideoBean f5801a;

            ViewOnClickListenerC0218a(CommonVideoBean commonVideoBean) {
                this.f5801a = commonVideoBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                String f = this.f5801a.f();
                if (TextUtils.isEmpty(f)) {
                    return;
                }
                if (f.equals("1")) {
                    u.c((Activity) b.this.f5800d, this.f5801a.d(), this.f5801a.a());
                    return;
                }
                if (f.equals("14")) {
                    u.a((Activity) b.this.f5800d, this.f5801a.d(), this.f5801a.a());
                } else if ("10".equals(f)) {
                    u.a((Activity) b.this.f5800d, this.f5801a.i(), this.f5801a.a(), this.f5801a.h());
                }
            }
        }

        public a(View view) {
            super(view);
            this.B = "1".equals(ConfigMgr.readPropertie("IsShowBlockTitle"));
            this.x = (LinearLayout) view.findViewById(R.id.ll_poster);
            this.w = (RelativeLayout) view.findViewById(R.id.img_rlayout);
            this.t = (ImageView) view.findViewById(R.id.poster_img);
            this.u = (ImageView) view.findViewById(R.id.ivi_logo_top);
            this.v = (TextView) view.findViewById(R.id.title_txt);
            this.y = (TextView) view.findViewById(R.id.series_lastupdate_txt);
            this.z = (ImageView) view.findViewById(R.id.img_pay_free);
            this.A = (TextView) view.findViewById(R.id.short_title);
            com.zte.iptvclient.common.uiframe.f.a(this.x);
            com.zte.iptvclient.common.uiframe.f.a(this.w);
            com.zte.iptvclient.common.uiframe.f.a(this.t);
            com.zte.iptvclient.common.uiframe.f.a(this.v);
            com.zte.iptvclient.common.uiframe.f.a(this.y);
            com.zte.iptvclient.common.uiframe.f.a(this.z);
            com.zte.iptvclient.common.uiframe.f.a(this.A);
            com.zte.iptvclient.common.uiframe.f.a(this.u);
            com.zte.iptvclient.android.mobile.e0.f.g.a(this.A);
        }

        public void a(CommonVideoBean commonVideoBean, boolean z) {
            if (commonVideoBean != null) {
                if (commonVideoBean.b().equals("ivi")) {
                    this.u.setVisibility(0);
                    this.u.setImageDrawable(b.this.f5800d.getResources().getDrawable(R.drawable.ivi_logo));
                } else if (commonVideoBean.b().equals("Megogo")) {
                    this.u.setVisibility(0);
                    this.u.setImageDrawable(b.this.f5800d.getResources().getDrawable(R.drawable.megogo_logo));
                } else {
                    this.u.setVisibility(8);
                }
                String a2 = com.zte.iptvclient.android.common.k.g.a(BaseApp.a(b.this.f5800d) ? 9 : 3, commonVideoBean.c());
                if (!TextUtils.isEmpty(a2) && a2.contains("/image")) {
                    a2 = i.g() + a2.substring(a2.indexOf("/image", 1));
                }
                if (b.this.f5800d != null && !((Activity) b.this.f5800d).isFinishing()) {
                    com.bumptech.glide.d<String> a3 = com.bumptech.glide.i.b(b.this.f5800d).a(a2);
                    a3.b(164, 235);
                    a3.b(R.drawable.default_poster_thumb);
                    a3.a(R.drawable.default_poster_thumb);
                    a3.c(150);
                    a3.a(this.t);
                }
                if (this.B && b.this.f5800d != null && com.zte.iptvclient.android.mobile.f.b.a.a(commonVideoBean.g(), b.this.f5800d)) {
                    this.v.setText(R.string.common_blocktitle);
                    LogEx.d("txtTitle.setText=", "R.string.common_blocktitle");
                } else {
                    this.v.setText(commonVideoBean.e());
                    LogEx.d("txtTitle.setText=", commonVideoBean.e());
                }
                this.A.setText(commonVideoBean.j());
                this.y.setVisibility(4);
                int b2 = com.zte.iptvclient.android.common.k.g.b(commonVideoBean.l());
                if (b2 == 1) {
                    this.z.setVisibility(0);
                    this.z.setImageResource(R.drawable.free);
                } else if (b2 == 2) {
                    this.z.setVisibility(0);
                    if (z) {
                        this.z.setImageResource(R.drawable.vip_pay);
                    } else {
                        this.z.setImageResource(R.drawable.pay);
                    }
                } else {
                    this.z.setVisibility(8);
                }
                this.x.setOnClickListener(new ViewOnClickListenerC0218a(commonVideoBean));
            }
        }
    }

    public b(Context context, ArrayList<CommonVideoBean> arrayList) {
        this.f5799c = arrayList;
        this.f5800d = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.b0 b(ViewGroup viewGroup, int i) {
        if (i == 2) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.no_content_layout, (ViewGroup) null));
        }
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_poster_item, (ViewGroup) null));
    }

    public void b(boolean z) {
    }

    public void c(boolean z) {
        this.e = z;
    }

    public boolean e(int i) {
        return i == a() - 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        return this.f5799c.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void b(RecyclerView.b0 b0Var, int i) {
        if (e(i)) {
            return;
        }
        ((a) b0Var).a(this.f5799c.get(i), this.e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int b(int i) {
        return e(i) ? 2 : 1;
    }
}
