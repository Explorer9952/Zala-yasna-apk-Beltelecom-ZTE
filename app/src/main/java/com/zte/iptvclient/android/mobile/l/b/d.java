package com.zte.iptvclient.android.mobile.l.b;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.f.b.a;
import com.zte.iptvclient.android.common.javabean.models.Feature;
import com.zte.iptvclient.android.common.k.r;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: HomeFragment.java */
/* loaded from: classes.dex */
public class d extends com.zte.fragmentlib.b {
    private static String s = d.class.getSimpleName();
    private View p;
    private com.zte.iptvclient.android.common.f.b.a q;
    private TextView r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeFragment.java */
    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            LogEx.d(d.s, "onGlobalLayout invoke.");
            d.this.N();
            d.this.p.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeFragment.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeFragment.java */
    /* loaded from: classes.dex */
    public class c implements t.d {
        c(d dVar) {
        }

        @Override // com.zte.iptvclient.android.common.k.t.d
        public void onDismiss() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.l.b.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0302d implements t.e {
        C0302d() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void a() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void b() {
            d.this.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeFragment.java */
    /* loaded from: classes.dex */
    public class e implements com.zte.iptvclient.android.mobile.order.helper.c {
        e() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.helper.c
        public void a(int i, String str) {
            LogEx.d("HomeFragment", "AuthManager payCallback returnCode=" + i + ",returnMsg=" + str);
            d.this.d(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeFragment.java */
    /* loaded from: classes.dex */
    public class f implements a.h {
        f(d dVar) {
        }
    }

    /* compiled from: HomeFragment.java */
    /* loaded from: classes.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        com.zte.iptvclient.android.common.f.b.a aVar = new com.zte.iptvclient.android.common.f.b.a(this.h, new com.zte.iptvclient.android.common.javabean.b(), new e(), new f(this));
        this.q = aVar;
        aVar.a(this.p);
        this.q.b();
    }

    private void L() {
        com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a(true);
        D();
        Intent intent = new Intent(getActivity(), (Class<?>) MainActivity.class);
        intent.putExtra("ChildMode", true);
        getActivity().startActivity(intent);
    }

    private void M() {
        View view = this.p;
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        b(R.id.home_viewpager, new com.zte.iptvclient.android.mobile.l.b.f());
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_nav_bar));
        if (BaseApp.f()) {
            ((TextView) view.findViewById(R.id.top_navbar_title_txt)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_home));
            this.r = (TextView) view.findViewById(R.id.tv_child_entrance);
            String c2 = com.zte.iptvclient.common.uiframe.a.c("Is_Show_Child");
            ViewGroup.LayoutParams layoutParams = this.r.getLayoutParams();
            if (!TextUtils.isEmpty(c2) && c2.equals("1")) {
                layoutParams.width = -2;
                this.r.setLayoutParams(layoutParams);
                this.r.setVisibility(0);
            } else {
                layoutParams.width = 1;
                this.r.setLayoutParams(layoutParams);
                this.r.setVisibility(4);
            }
            this.r.setOnClickListener(new b());
        }
    }

    public void I() {
        LogEx.d(s, "---childModeEntranceOper---");
        if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            t.a(this.h, new c(this));
        } else {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            A();
            if (TextUtils.equals(com.zte.iptvclient.common.uiframe.a.c("Is_ChildMode_Allow_Guest"), "1")) {
                L();
                return;
            }
            ArrayList<Feature> a2 = com.zte.iptvclient.android.common.j.c.e().a();
            if (a2 != null && a2.size() > 0) {
                L();
            } else {
                t.a(this.h, com.zte.iptvclient.android.common.i.a.a.a(R.string.switch_childe_mode_to_order_tip), new C0302d());
            }
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        LogEx.d("HomeFragment", "home onActivityCreated");
        M();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LogEx.d("HomeFragment", "home onCreateView");
        if (this.p == null) {
            View inflate = layoutInflater.inflate(R.layout.home_fragment, viewGroup, false);
            this.p = inflate;
            d(inflate);
            a(R.id.frame_top_navbar, (com.zte.fragmentlib.b) new com.zte.iptvclient.android.mobile.l.b.a(), false);
            EventBus.getDefault().register(this);
            if (BaseApp.a(this.h)) {
                FrameLayout frameLayout = (FrameLayout) this.p.findViewById(R.id.frame_top_navbar);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = r.a(getContext()) / 2;
                    frameLayout.setLayoutParams(layoutParams);
                }
            }
        }
        return this.p;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        if (BaseApp.f()) {
            String c2 = com.zte.iptvclient.common.uiframe.a.c("Is_Show_Child");
            ViewGroup.LayoutParams layoutParams = this.r.getLayoutParams();
            if (!TextUtils.isEmpty(c2) && c2.equals("1")) {
                layoutParams.width = -2;
                this.r.setLayoutParams(layoutParams);
                this.r.setVisibility(0);
            } else {
                layoutParams.width = 1;
                this.r.setLayoutParams(layoutParams);
                this.r.setVisibility(4);
            }
            this.r.setOnClickListener(new g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (i == 0) {
            com.zte.iptvclient.android.mobile.n.c.b.k().c();
            L();
        }
    }
}
