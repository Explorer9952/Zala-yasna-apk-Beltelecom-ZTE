package com.zte.iptvclient.android.mobile.user.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.config.ConfigMgr;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.u;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.zala.R;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: MyFragment.java */
/* loaded from: classes.dex */
public class m extends com.zte.fragmentlib.b {
    private RelativeLayout p;
    private RelativeLayout q;
    private RelativeLayout r;
    private RelativeLayout s;
    private TextView t;
    private RelativeLayout u;
    private RelativeLayout v;
    private RelativeLayout w;
    private com.zte.iptvclient.android.common.j.h x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyFragment.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
                u.g(((com.zte.fragmentlib.b) m.this).h);
            } else {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                t.a((Context) ((com.zte.fragmentlib.b) m.this).h, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyFragment.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
                if ("1".equals(ConfigMgr.readPropertie("IsTVHistory"))) {
                    m.this.a("history", (Bundle) null);
                    return;
                } else {
                    m.this.a("bookmark", (Bundle) null);
                    return;
                }
            }
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            t.a((Context) ((com.zte.fragmentlib.b) m.this).h, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyFragment.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
                m.this.a("favorite", (Bundle) null);
            } else {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                t.a((Context) ((com.zte.fragmentlib.b) m.this).h, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyFragment.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                t.a((Context) ((com.zte.fragmentlib.b) m.this).h, false);
                return;
            }
            m.this.a("ppv", (Bundle) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyFragment.java */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                t.a((Context) ((com.zte.fragmentlib.b) m.this).h, false);
                return;
            }
            m.this.a("productnew", (Bundle) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyFragment.java */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
                m.this.a("consumption_records", (Bundle) null);
            } else {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                t.a((Context) ((com.zte.fragmentlib.b) m.this).h, false);
            }
        }
    }

    private void I() {
        if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
            this.t.setText("");
            return;
        }
        if (this.x.c().equals("") && TextUtils.isEmpty(this.x.c())) {
            this.t.setText("");
            return;
        }
        this.t.setText(this.x.c() + " " + getResources().getString(R.string.money_unit_sign));
    }

    private void J() {
        this.p.setOnClickListener(new a());
        this.q.setOnClickListener(new b());
        this.r.setOnClickListener(new c());
        this.u.setOnClickListener(new d());
        this.v.setOnClickListener(new e());
        this.w.setOnClickListener(new f());
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.x = new com.zte.iptvclient.android.common.j.h(this.h);
        I();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.my_fragment_layout, (ViewGroup) null);
        d(inflate);
        J();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        I();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    private void d(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_title_layout);
        TextView textView = (TextView) view.findViewById(R.id.my_title);
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.my_txt));
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.view_devided));
        com.zte.iptvclient.common.uiframe.f.a(textView);
        TextView textView2 = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView2.setHeight(a2);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.recording_layout);
        this.p = relativeLayout2;
        ImageView imageView = (ImageView) relativeLayout2.findViewById(R.id.iv_mine_left);
        TextView textView3 = (TextView) this.p.findViewById(R.id.common_mine_txt);
        ImageView imageView2 = (ImageView) this.p.findViewById(R.id.common_mine_txt_arrow);
        View findViewById = this.p.findViewById(R.id.buttom_view_line);
        imageView.setImageDrawable(this.h.getResources().getDrawable(R.drawable.icon_my_recording));
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_my_recording));
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        com.zte.iptvclient.common.uiframe.f.a(textView3);
        com.zte.iptvclient.common.uiframe.f.a(imageView2);
        com.zte.iptvclient.common.uiframe.f.a(findViewById);
        RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.id.last_watch_layout);
        this.q = relativeLayout3;
        ImageView imageView3 = (ImageView) relativeLayout3.findViewById(R.id.iv_mine_left);
        TextView textView4 = (TextView) this.q.findViewById(R.id.common_mine_txt);
        ImageView imageView4 = (ImageView) this.q.findViewById(R.id.common_mine_txt_arrow);
        View findViewById2 = this.q.findViewById(R.id.buttom_view_line);
        imageView3.setImageDrawable(this.h.getResources().getDrawable(R.drawable.iv_mine_lately_watch));
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_bookmark));
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(imageView3);
        com.zte.iptvclient.common.uiframe.f.a(textView4);
        com.zte.iptvclient.common.uiframe.f.a(imageView4);
        com.zte.iptvclient.common.uiframe.f.a(findViewById2);
        RelativeLayout relativeLayout4 = (RelativeLayout) view.findViewById(R.id.favorites_layout);
        this.r = relativeLayout4;
        ImageView imageView5 = (ImageView) relativeLayout4.findViewById(R.id.iv_mine_left);
        TextView textView5 = (TextView) this.r.findViewById(R.id.common_mine_txt);
        ImageView imageView6 = (ImageView) this.r.findViewById(R.id.common_mine_txt_arrow);
        View findViewById3 = this.r.findViewById(R.id.buttom_view_line);
        imageView5.setImageDrawable(this.h.getResources().getDrawable(R.drawable.mine_my_favourite));
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_favorite));
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(imageView5);
        com.zte.iptvclient.common.uiframe.f.a(textView5);
        com.zte.iptvclient.common.uiframe.f.a(imageView6);
        com.zte.iptvclient.common.uiframe.f.a(findViewById3);
        this.s = (RelativeLayout) view.findViewById(R.id.rl_balance);
        ImageView imageView7 = (ImageView) view.findViewById(R.id.img_balance);
        TextView textView6 = (TextView) view.findViewById(R.id.txt_balance);
        textView6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.my_balance));
        this.t = (TextView) view.findViewById(R.id.txt_account_balance);
        View findViewById4 = view.findViewById(R.id.buttom_view_line);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(imageView7);
        com.zte.iptvclient.common.uiframe.f.a(textView6);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(findViewById4);
        RelativeLayout relativeLayout5 = (RelativeLayout) view.findViewById(R.id.ppv_layout);
        this.u = relativeLayout5;
        ImageView imageView8 = (ImageView) relativeLayout5.findViewById(R.id.iv_mine_left);
        TextView textView7 = (TextView) this.u.findViewById(R.id.common_mine_txt);
        ImageView imageView9 = (ImageView) this.u.findViewById(R.id.common_mine_txt_arrow);
        View findViewById5 = this.u.findViewById(R.id.buttom_view_line);
        imageView8.setImageDrawable(this.h.getResources().getDrawable(R.drawable.mine_my_order));
        textView7.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.ppv));
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(imageView8);
        com.zte.iptvclient.common.uiframe.f.a(textView7);
        com.zte.iptvclient.common.uiframe.f.a(imageView9);
        com.zte.iptvclient.common.uiframe.f.a(findViewById5);
        RelativeLayout relativeLayout6 = (RelativeLayout) view.findViewById(R.id.packages_layout);
        this.v = relativeLayout6;
        ImageView imageView10 = (ImageView) relativeLayout6.findViewById(R.id.iv_mine_left);
        TextView textView8 = (TextView) this.v.findViewById(R.id.common_mine_txt);
        ImageView imageView11 = (ImageView) this.v.findViewById(R.id.common_mine_txt_arrow);
        View findViewById6 = this.v.findViewById(R.id.buttom_view_line);
        imageView10.setImageDrawable(this.h.getResources().getDrawable(R.drawable.mine_my_product_package));
        textView8.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.product_package));
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(imageView10);
        com.zte.iptvclient.common.uiframe.f.a(textView8);
        com.zte.iptvclient.common.uiframe.f.a(imageView11);
        com.zte.iptvclient.common.uiframe.f.a(findViewById6);
        RelativeLayout relativeLayout7 = (RelativeLayout) view.findViewById(R.id.purchase_layout);
        this.w = relativeLayout7;
        ImageView imageView12 = (ImageView) relativeLayout7.findViewById(R.id.iv_mine_left);
        TextView textView9 = (TextView) this.w.findViewById(R.id.common_mine_txt);
        ImageView imageView13 = (ImageView) this.w.findViewById(R.id.common_mine_txt_arrow);
        View findViewById7 = this.w.findViewById(R.id.buttom_view_line);
        imageView12.setImageDrawable(this.h.getResources().getDrawable(R.drawable.iv_mine_lately_watch));
        textView9.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_order));
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(imageView12);
        com.zte.iptvclient.common.uiframe.f.a(textView9);
        com.zte.iptvclient.common.uiframe.f.a(imageView13);
        com.zte.iptvclient.common.uiframe.f.a(findViewById7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Intent intent = new Intent(getActivity(), (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", str);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
