package com.zte.iptvclient.android.mobile.l.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.a.h;
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.mobile.home.ui.columnview.HomeCustomTVColumnView;
import com.zte.iptvclient.android.mobile.home.ui.columnview.HomeHorizontalCustomView;
import com.zte.iptvclient.android.mobile.home.ui.layout.linearLayout.FootNoMoreView;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: HomeWonderfulFragment.java */
/* loaded from: classes.dex */
public class f extends com.zte.fragmentlib.b {
    private SmartRefreshLayout p;
    private LinearLayout q;
    private HomeCustomTVColumnView r;
    private ArrayList<HomeHorizontalCustomView> t;
    private FootNoMoreView x;
    private View y;
    private boolean s = false;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeWonderfulFragment.java */
    /* loaded from: classes.dex */
    public class a implements com.scwang.smartrefresh.layout.d.c {
        a() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(h hVar) {
            f.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeWonderfulFragment.java */
    /* loaded from: classes.dex */
    public class b implements HomeCustomTVColumnView.d {
        b() {
        }

        @Override // com.zte.iptvclient.android.mobile.home.ui.columnview.HomeCustomTVColumnView.d
        public void a() {
            LogEx.d("HomeWonderfulFragment", "---onLoadFinish---isTvFinished");
            f.this.s = true;
            f.this.P();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeWonderfulFragment.java */
    /* loaded from: classes.dex */
    public class c implements HomeHorizontalCustomView.g {
        c() {
        }

        @Override // com.zte.iptvclient.android.mobile.home.ui.columnview.HomeHorizontalCustomView.g
        public void a(int i) {
            LogEx.d("HomeWonderfulFragment", "---HomeHorizontalCustomView-onDataReturn---type: " + i);
            if (i == 1) {
                f.this.u = true;
            } else if (i == 2) {
                f.this.v = true;
            } else if (i == 3) {
                f.this.w = true;
            }
            f.this.P();
        }
    }

    private void I() {
        if (this.t == null) {
            this.t = new ArrayList<>(3);
        } else {
            for (int i = 0; i < this.t.size(); i++) {
                this.q.removeView(this.t.get(i));
            }
            this.t.clear();
        }
        a(!TextUtils.isEmpty(com.zte.iptvclient.android.mobile.home.tab.helper.b.h()) ? com.zte.iptvclient.android.mobile.home.tab.helper.b.h() : com.zte.iptvclient.android.common.i.a.a.a(R.string.home_column_new_hint), 1);
        a(com.zte.iptvclient.android.common.i.a.a.a(R.string.home_column_for_you_hint), 2);
        a(com.zte.iptvclient.android.common.i.a.a.a(R.string.home_column_top_hint), 3);
    }

    private void J() {
        LogEx.d("HomeWonderfulFragment", "---addCustomTvChannelsLayouat---");
        HomeCustomTVColumnView homeCustomTVColumnView = new HomeCustomTVColumnView(this.h, new b());
        this.r = homeCustomTVColumnView;
        homeCustomTVColumnView.setVisibility(8);
        this.q.addView(this.r);
        this.r.a();
    }

    private void K() {
        LogEx.d("HomeWonderfulFragment", "loadAllDataToView");
        this.q.removeAllViews();
        J();
        I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        LogEx.d("HomeWonderfulFragment", "---refreshData---");
        LogEx.d("HomeWonderfulFragment", "---refreshData---1");
        this.x.setVisibility(0);
        if (this.t != null) {
            I();
        }
        HomeCustomTVColumnView homeCustomTVColumnView = this.r;
        if (homeCustomTVColumnView != null) {
            homeCustomTVColumnView.a();
        }
    }

    private void M() {
        ArrayList<HomeHorizontalCustomView> arrayList = this.t;
        if (arrayList != null) {
            arrayList.clear();
            this.t = null;
        }
        LinearLayout linearLayout = this.q;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
    }

    private void N() {
        this.u = false;
        this.v = false;
        this.w = false;
        this.s = false;
    }

    private void O() {
        this.p.a(new a());
        this.p.b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        if (this.s && this.u && this.v && this.w) {
            this.q.removeView(this.x);
            this.q.addView(this.x);
            N();
        }
        SmartRefreshLayout smartRefreshLayout = this.p;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.a();
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        EventBus.getDefault().register(this);
        K();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.y == null) {
            View inflate = layoutInflater.inflate(R.layout.home_wonderful_fragment_layout, viewGroup, false);
            this.y = inflate;
            d(inflate);
            O();
        }
        return this.y;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        M();
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        LogEx.d("HomeWonderfulFragment", "recv LoginReturnEvent event");
        if (cVar.a().equals("0")) {
            LogEx.d("HomeWonderfulFragment", "recv LoginReturnEvent event---1");
            K();
        }
    }

    private void d(View view) {
        this.p = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.home_content);
        this.q = linearLayout;
        com.zte.iptvclient.common.uiframe.f.a(linearLayout);
        this.x = new FootNoMoreView(this.h);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_no_more));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_no_more));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_no_more));
        this.p.a(new DefaultRefreshHeader(this.h));
        this.p.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.p;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.p;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.p.c(false);
    }

    private void a(String str, int i) {
        LogEx.d("HomeWonderfulFragment", "---addConcreteCustomColumnViewLayout---columnname: " + str);
        HomeHorizontalCustomView homeHorizontalCustomView = new HomeHorizontalCustomView(this.h, str, i, new c());
        homeHorizontalCustomView.setVisibility(8);
        if (this.q != null) {
            this.t.add(homeHorizontalCustomView);
            this.q.addView(homeHorizontalCustomView);
        }
        homeHorizontalCustomView.a();
    }
}
