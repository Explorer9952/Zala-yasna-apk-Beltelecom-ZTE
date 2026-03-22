package com.zte.iptvclient.android.mobile.c0.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.c0.c.b;
import com.zte.iptvclient.android.mobile.home.tab.helper.TabHostManager;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: MyMenuFragmentHD.java */
/* loaded from: classes.dex */
public class e extends com.zte.fragmentlib.b {
    TextView p;
    private View q;
    private RecyclerView r;
    private com.zte.iptvclient.android.mobile.c0.c.b s;
    private List<com.zte.iptvclient.android.mobile.l.c.a.b> t;
    private h u;
    private String v = "recordings";
    private String w = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyMenuFragmentHD.java */
    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f5639a;

        a(e eVar, View view) {
            this.f5639a = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            RelativeLayout relativeLayout = (RelativeLayout) this.f5639a.findViewById(R.id.top_container);
            int measuredWidth = relativeLayout.getMeasuredWidth();
            int measuredHeight = relativeLayout.getMeasuredHeight();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = measuredWidth;
                layoutParams.height = measuredHeight;
                relativeLayout.setLayoutParams(layoutParams);
            }
            relativeLayout.setBackgroundResource(R.drawable.bg_account_left_top_cornor);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyMenuFragmentHD.java */
    /* loaded from: classes2.dex */
    public class b implements b.c {
        b() {
        }

        @Override // com.zte.iptvclient.android.mobile.c0.c.b.c
        public void a(View view, int i) {
            if (((com.zte.iptvclient.android.mobile.l.c.a.b) e.this.t.get(i)).f6762a == TabHostManager.TabName.BALANCE) {
                return;
            }
            e eVar = e.this;
            eVar.v = ((com.zte.iptvclient.android.mobile.l.c.a.b) eVar.t.get(i)).f6764c;
            if ((((com.zte.iptvclient.android.mobile.l.c.a.b) e.this.t.get(i)).f6762a == TabHostManager.TabName.FAVORITE || ((com.zte.iptvclient.android.mobile.l.c.a.b) e.this.t.get(i)).f6762a == TabHostManager.TabName.RECORDING || ((com.zte.iptvclient.android.mobile.l.c.a.b) e.this.t.get(i)).f6762a == TabHostManager.TabName.REMINDER || ((com.zte.iptvclient.android.mobile.l.c.a.b) e.this.t.get(i)).f6762a == TabHostManager.TabName.BOOKMARK || ((com.zte.iptvclient.android.mobile.l.c.a.b) e.this.t.get(i)).f6762a == TabHostManager.TabName.PARENTAL || ((com.zte.iptvclient.android.mobile.l.c.a.b) e.this.t.get(i)).f6762a == TabHostManager.TabName.PPV || ((com.zte.iptvclient.android.mobile.l.c.a.b) e.this.t.get(i)).f6762a == TabHostManager.TabName.BINDING || ((com.zte.iptvclient.android.mobile.l.c.a.b) e.this.t.get(i)).f6762a == TabHostManager.TabName.CONSUMPTIONRECORDS || ((com.zte.iptvclient.android.mobile.l.c.a.b) e.this.t.get(i)).f6762a == TabHostManager.TabName.PACKAGE || ((com.zte.iptvclient.android.mobile.l.c.a.b) e.this.t.get(i)).f6762a == TabHostManager.TabName.FEATUREPACKAGE || ((com.zte.iptvclient.android.mobile.l.c.a.b) e.this.t.get(i)).f6762a == TabHostManager.TabName.CHANNELLINEUP || ((com.zte.iptvclient.android.mobile.l.c.a.b) e.this.t.get(i)).f6762a == TabHostManager.TabName.ORDER) && !com.zte.iptvclient.android.mobile.n.c.b.t()) {
                t.a((Context) ((com.zte.fragmentlib.b) e.this).h, false);
                return;
            }
            String str = ((com.zte.iptvclient.android.mobile.l.c.a.b) e.this.t.get(i)).f6764c;
            Bundle bundle = new Bundle();
            bundle.putBoolean("isSideMenu", false);
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.z.b(str, bundle));
            e.this.s.e(i);
            e.this.s.d();
        }
    }

    private void I() {
        this.u = new h(this.h);
        ArrayList arrayList = new ArrayList();
        this.t = arrayList;
        arrayList.addAll(TabHostManager.g().c());
        this.s = new com.zte.iptvclient.android.mobile.c0.c.b(this.h, this.t, this.w);
        this.r.a(new LinearLayoutManager(this.h));
        this.r.a(this.s);
        if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
            this.s.e(0);
            this.s.d();
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.z.b("recordings", null));
        }
    }

    private void J() {
        this.s.a(new b());
    }

    private void d(View view) {
        this.p = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        this.p.setHeight(a2);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_menu);
        this.r = recyclerView;
        f.a(recyclerView);
        f.a(view.findViewById(R.id.ll_my_account));
        f.a(view.findViewById(R.id.ll_root));
        f.a(view.findViewById(R.id.top_navbar_logo_img));
        view.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, view));
    }

    private int s(String str) {
        List<com.zte.iptvclient.android.mobile.l.c.a.b> list = this.t;
        int i = -1;
        if (list != null) {
            Iterator<com.zte.iptvclient.android.mobile.l.c.a.b> it2 = list.iterator();
            while (it2.hasNext()) {
                i++;
                if (TextUtils.equals(it2.next().f6764c, str)) {
                    break;
                }
            }
        }
        return i;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        I();
        J();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        this.q = layoutInflater.inflate(R.layout.my_fragment_menu_hd, viewGroup, false);
        h hVar = new h(this.h);
        this.u = hVar;
        this.w = hVar.c();
        d(this.q);
        return this.q;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        if ("0".equals(cVar.a())) {
            if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
                LogEx.d("MyMenuFragmentHD", "mStrBalance=" + this.w);
                this.w = this.u.c();
                this.t.clear();
                this.t.addAll(TabHostManager.g().c());
                this.s.a(this.t, this.w);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isSideMenu", false);
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.z.b(this.v, bundle));
                this.s.e(s(this.v));
                this.s.d();
                return;
            }
            this.w = "";
            this.t.clear();
            this.t.addAll(TabHostManager.g().c());
            this.s.a(this.t, this.w);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.d dVar) {
        this.s.e(-1);
        this.s.d();
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.z.b("login", null));
    }
}
