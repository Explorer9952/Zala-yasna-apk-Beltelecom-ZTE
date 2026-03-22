package com.zte.iptvclient.android.mobile.e0.e;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.javabean.column.ColumnBean;
import com.zte.iptvclient.android.common.k.r;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.HashMap;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.e.c.e.a;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: VideoNoColumnFragment.java */
/* loaded from: classes.dex */
public class n extends com.zte.fragmentlib.b {
    private ArrayList<String> A;
    private ViewStub C;
    private TextView D;
    private com.zte.iptvclient.android.mobile.l.b.a p;
    private ViewPager q;
    private MagicIndicator r;
    private net.lucode.hackware.magicindicator.e.c.a s;
    private ArrayList<ColumnBean> u;
    private ArrayList<ColumnBean> v;
    private ArrayList<com.zte.iptvclient.android.mobile.e0.e.c> w;
    private c x;
    private ArrayList<ColumnBean> t = new ArrayList<>();
    private String y = "";
    private HashMap<String, String> z = new HashMap<>();
    private int B = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoNoColumnFragment.java */
    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f6102a;

        a(View view) {
            this.f6102a = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            LogEx.d("VideoNoColumnFragment", " onGlobalLayout回调了");
            n.this.I();
            this.f6102a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoNoColumnFragment.java */
    /* loaded from: classes2.dex */
    public class b extends net.lucode.hackware.magicindicator.e.c.b.a {

        /* compiled from: VideoNoColumnFragment.java */
        /* loaded from: classes2.dex */
        class a implements a.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f6105a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ TextView f6106b;

            a(int i, TextView textView) {
                this.f6105a = i;
                this.f6106b = textView;
            }

            @Override // net.lucode.hackware.magicindicator.e.c.e.a.b
            public void a(int i, int i2) {
                this.f6106b.setTextColor(c.a.a.a.d.b.d().b(R.color.vod_viewpager_unselectd_textcolor));
                ((com.zte.fragmentlib.b) n.this).h.a(this.f6106b, "textColor", R.color.viewpager_title_normal_color);
            }

            @Override // net.lucode.hackware.magicindicator.e.c.e.a.b
            public void a(int i, int i2, float f, boolean z) {
            }

            @Override // net.lucode.hackware.magicindicator.e.c.e.a.b
            public void b(int i, int i2) {
                if (n.this.B == this.f6105a) {
                    return;
                }
                LogEx.d("VideoNoColumnFragment", "setOnPagerTitleChangeListener onSelected=" + i);
                this.f6106b.setTextColor(c.a.a.a.d.b.d().b(R.color.viewpager_title_selected_color));
                ((com.zte.fragmentlib.b) n.this).h.a(this.f6106b, "textColor", R.color.viewpager_title_selected_color);
                n.this.d(this.f6105a);
                n.this.B = this.f6105a;
                n.this.P();
            }

            @Override // net.lucode.hackware.magicindicator.e.c.e.a.b
            public void b(int i, int i2, float f, boolean z) {
            }
        }

        /* compiled from: VideoNoColumnFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.e0.e.n$b$b, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class ViewOnClickListenerC0242b implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f6108a;

            ViewOnClickListenerC0242b(int i) {
                this.f6108a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.f6108a >= n.this.A.size() || n.this.B == this.f6108a) {
                    return;
                }
                n.this.q.a(this.f6108a, false);
            }
        }

        b() {
        }

        @Override // net.lucode.hackware.magicindicator.e.c.b.a
        public int a() {
            if (n.this.A == null) {
                return 0;
            }
            return n.this.A.size();
        }

        @Override // net.lucode.hackware.magicindicator.e.c.b.a
        public net.lucode.hackware.magicindicator.e.c.b.d a(Context context, int i) {
            if (i >= n.this.A.size()) {
                return null;
            }
            net.lucode.hackware.magicindicator.e.c.e.a aVar = new net.lucode.hackware.magicindicator.e.c.e.a(context);
            aVar.a(R.layout.simple_pager_title_layout);
            aVar.findViewById(R.id.view).setBackgroundResource(R.color.search_column_text_deselected);
            TextView textView = (TextView) aVar.findViewById(R.id.txt_simple_title);
            com.zte.iptvclient.common.uiframe.f.a(textView);
            textView.setText((CharSequence) n.this.A.get(i));
            aVar.a(new a(i, textView));
            aVar.setOnClickListener(new ViewOnClickListenerC0242b(i));
            return aVar;
        }

        @Override // net.lucode.hackware.magicindicator.e.c.b.a
        public net.lucode.hackware.magicindicator.e.c.b.c a(Context context) {
            if ("1".equals(ConfigMgr.readPropertie("isShow"))) {
                net.lucode.hackware.magicindicator.e.c.c.a aVar = new net.lucode.hackware.magicindicator.e.c.c.a(context);
                aVar.a(net.lucode.hackware.magicindicator.e.b.a(context, context.getResources().getDimension(R.dimen.vod_viewpager_magicIndicator_height)));
                aVar.b(0.0f);
                aVar.d(0.0f);
                aVar.a(Integer.valueOf(((com.zte.fragmentlib.b) n.this).h.getResources().getColor(R.color.vod_pagerindicator_contentcolor)));
                return aVar;
            }
            net.lucode.hackware.magicindicator.e.c.c.a aVar2 = new net.lucode.hackware.magicindicator.e.c.c.a(context);
            if (TextUtils.equals(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b, "black.skin")) {
                aVar2.a(Integer.valueOf(((com.zte.fragmentlib.b) n.this).h.getResources().getColor(R.color.line_pagerindicator_dark)));
            } else {
                aVar2.a(Integer.valueOf(((com.zte.fragmentlib.b) n.this).h.getResources().getColor(R.color.viewpager_title_selected_color)));
            }
            aVar2.a(7.0f);
            aVar2.c(1);
            aVar2.c(com.zte.iptvclient.android.common.k.g.a(context, 7.0f));
            return aVar2;
        }
    }

    /* compiled from: VideoNoColumnFragment.java */
    /* loaded from: classes2.dex */
    public static class c extends androidx.fragment.app.n {
        ArrayList<com.zte.iptvclient.android.mobile.e0.e.c> h;

        public c(FragmentManager fragmentManager, ArrayList<com.zte.iptvclient.android.mobile.e0.e.c> arrayList) {
            super(fragmentManager);
            this.h = arrayList;
        }

        @Override // androidx.viewpager.widget.a
        public int a() {
            return this.h.size();
        }

        @Override // androidx.viewpager.widget.a
        public int a(Object obj) {
            return -2;
        }

        @Override // androidx.fragment.app.n
        public Fragment c(int i) {
            return this.h.get(i);
        }

        @Override // androidx.fragment.app.n
        public long d(int i) {
            return this.h.get(i).hashCode();
        }
    }

    private void K() {
        this.w = new ArrayList<>();
    }

    private void L() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Movie_Search_Default_Keyword_With_Column");
        String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.search_default);
        if (a2 != null) {
            this.y = com.zte.iptvclient.android.common.k.o.j().b(a2);
        }
        if (TextUtils.isEmpty(c2) || this.y == null) {
            return;
        }
        LogEx.d("VideoNoColumnFragment", "keyWords=" + c2 + "  " + c2);
        String[] split = c2.split(";");
        if (split != null) {
            for (int i = 0; i < split.length; i++) {
                if (TextUtils.isEmpty(split[i])) {
                    this.z.put(MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY, this.y);
                } else {
                    LogEx.d("VideoNoColumnFragment", " keyWordsList[i]" + split[i]);
                    String[] split2 = split[i].split(",");
                    if (split2.length != 2) {
                        this.z.put(MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY, split[i]);
                    } else {
                        LogEx.d("VideoNoColumnFragment", " mKeyWords[0].toString() " + split2[0] + "  " + split2[1]);
                        this.z.put(split2[0], split2[1]);
                    }
                }
            }
        }
    }

    private void M() {
        ArrayList<com.zte.iptvclient.android.mobile.e0.e.c> arrayList = this.w;
        if (arrayList != null && arrayList.size() > 0) {
            this.w.clear();
        }
        ArrayList<String> arrayList2 = this.A;
        if (arrayList2 == null) {
            this.A = new ArrayList<>();
        } else {
            arrayList2.clear();
        }
        if (this.t != null) {
            for (int i = 0; i < this.t.size(); i++) {
                if (!TextUtils.isEmpty(this.t.get(i).getColumnName()) && !TextUtils.isEmpty(this.t.get(i).getColumnCode())) {
                    this.A.add(this.t.get(i).getColumnName());
                    p pVar = new p();
                    Bundle bundle = new Bundle();
                    bundle.putString("Columncode", this.t.get(i).getColumnCode());
                    if (i == 0) {
                        bundle.putBoolean("AutoLoadData", true);
                    } else {
                        bundle.putBoolean("AutoLoadData", false);
                    }
                    pVar.setArguments(bundle);
                    ArrayList<com.zte.iptvclient.android.mobile.e0.e.c> arrayList3 = this.w;
                    if (arrayList3 != null) {
                        arrayList3.add(pVar);
                    }
                }
            }
        }
        if (this.w != null) {
            this.q.removeAllViewsInLayout();
            c cVar = this.x;
            if (cVar == null) {
                c cVar2 = new c(getChildFragmentManager(), this.w);
                this.x = cVar2;
                this.q.a(cVar2);
            } else {
                cVar.b();
            }
            this.q.e(this.w.size());
        }
        net.lucode.hackware.magicindicator.e.c.a aVar = new net.lucode.hackware.magicindicator.e.c.a(this.h);
        this.s = aVar;
        aVar.a(0.35f);
        this.s.b(true);
        this.r.a(this.s);
        net.lucode.hackware.magicindicator.c.a(this.r, this.q);
        O();
    }

    private void N() {
        LogEx.d("VideoNoColumnFragment", "queryData");
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            LogEx.d("VideoNoColumnFragment", "---Child Mode---");
            this.v = com.zte.iptvclient.android.mobile.e0.f.f.e();
        } else {
            LogEx.d("VideoNoColumnFragment", "---Main Mode---");
            this.v = com.zte.iptvclient.android.mobile.e0.f.g.b();
        }
        this.t.clear();
        ArrayList<ColumnBean> c2 = com.zte.iptvclient.android.common.j.k.i().c();
        this.u = c2;
        if (c2 != null && this.v != null) {
            for (int i = 0; i < this.v.size(); i++) {
                for (int i2 = 0; i2 < this.u.size(); i2++) {
                    if (TextUtils.equals(this.u.get(i2).getColumnCode(), this.v.get(i).getColumnCode())) {
                        this.t.add(this.v.get(i));
                    }
                }
            }
        }
        LogEx.d("VideoNoColumnFragment", "mVideoColumnList.size = " + this.t.size());
        M();
        L();
    }

    private void O() {
        this.s.a(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        LogEx.d("VideoNoColumnFragment", "--showCurrentSelectColumnView--");
        ArrayList<ColumnBean> arrayList = this.t;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Q();
    }

    private void Q() {
        if (TextUtils.isEmpty(this.t.get(this.B).getColumnCode()) || this.B >= this.q.b().a() || this.w.get(this.B) == null) {
            return;
        }
        e(this.B);
    }

    public void I() {
        LogEx.d("VideoNoColumnFragment", " lazyInflate() method is called");
        if (this.p == null) {
            LogEx.d("VideoNoColumnFragment", " lazyInflate() execute");
            View inflate = this.C.inflate();
            com.zte.iptvclient.android.mobile.l.b.a aVar = new com.zte.iptvclient.android.mobile.l.b.a();
            this.p = aVar;
            aVar.d(2);
            a(R.id.frame_top_navbar, (com.zte.fragmentlib.b) this.p, false);
            this.D = (TextView) inflate.findViewById(R.id.top_navbar_title_txt);
            if (BaseApp.f()) {
                FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.frame_top_navbar);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = r.a(getContext()) / 2;
                    frameLayout.setLayoutParams(layoutParams);
                }
                this.D.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.vod_title_hd));
                if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
                    layoutParams2.removeRule(0);
                    layoutParams2.removeRule(16);
                    layoutParams2.removeRule(9);
                    layoutParams2.removeRule(20);
                    layoutParams2.addRule(14);
                    this.D.setLayoutParams(layoutParams2);
                }
            }
            this.q = (ViewPager) inflate.findViewById(R.id.video_view_vpager);
            this.r = (MagicIndicator) inflate.findViewById(R.id.magic_indicator);
            com.zte.iptvclient.common.uiframe.f.a(this.q);
            com.zte.iptvclient.common.uiframe.f.a(this.r);
            N();
        }
    }

    public void J() {
        ArrayList<ColumnBean> arrayList = this.t;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("ColumnCode", this.t.get(this.B).getColumnCode());
        bundle.putString("mColumnName", this.t.get(this.B).getColumnName());
        Intent intent = new Intent(getActivity(), (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "filter");
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        K();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.video_no_column_fragment, viewGroup, false);
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.n.e eVar) {
        if (eVar.a().equalsIgnoreCase("VideoNewFragmentFilter")) {
            J();
        }
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.C = (ViewStub) view.findViewById(R.id.view_stub_video);
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            view.findViewById(R.id.ll_video_no_column_container).setBackgroundResource(R.drawable.bg_child);
        } else {
            view.findViewById(R.id.ll_video_no_column_container).setBackgroundResource(BaseApp.f() ? R.drawable.bg_pad : R.drawable.bg_phone);
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new a(view));
    }

    private void e(int i) {
        if (this.z.containsKey(this.t.get(i).getColumnCode())) {
            if (this.p != null) {
                LogEx.d("VideoNoColumnFragment", this.t.get(i).getColumnCode() + "  " + this.t.get(i).getColumnName());
                this.p.s(this.z.get(this.t.get(i).getColumnCode()));
                return;
            }
            return;
        }
        com.zte.iptvclient.android.mobile.l.b.a aVar = this.p;
        if (aVar != null) {
            aVar.s(this.y);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        LogEx.d("VideoNoColumnFragment", "onEventMainThread(LoginReturnEvent event): " + cVar);
        if (TextUtils.equals(cVar.a(), "0")) {
            if (this.B != 0) {
                this.B = 0;
                this.q.a(0, false);
            }
            N();
        }
    }

    public void d(int i) {
        if (i >= this.q.b().a() || this.w.get(i) == null) {
            return;
        }
        this.w.get(this.B).I();
        this.w.get(i).J();
    }
}
