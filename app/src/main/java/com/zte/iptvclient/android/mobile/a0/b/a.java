package com.zte.iptvclient.android.mobile.a0.b;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.customview.viewgroup.scrollview.HorizontalScrollViewEx;
import com.zte.iptvclient.android.common.e.x.n;
import com.zte.iptvclient.android.common.e.x.r;
import com.zte.iptvclient.android.common.eventbus.multi.i;
import com.zte.iptvclient.android.common.j.j;
import com.zte.iptvclient.android.common.javabean.column.ColumnBean;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.k.m;
import com.zte.iptvclient.android.common.k.o;
import com.zte.iptvclient.android.common.k.s;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.common.player.activity.VOPlayerActivity;
import com.zte.iptvclient.android.common.player.multiplay.activity.MultiPlayActivity;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: LiveTVChildFragment.java */
/* loaded from: classes.dex */
public class a extends com.zte.fragmentlib.b {
    private ArrayList<ColumnBean> A;
    private ArrayList<Channel> B;
    private ColumnBean C;
    private ColumnBean D;
    private ColumnBean E;
    private ColumnBean F;
    private HashMap<ColumnBean, ArrayList<Channel>> G;
    private com.zte.iptvclient.android.mobile.a0.a.e.a J;
    private Channel K;
    private List<com.zte.iptvclient.android.mobile.a0.b.h> L;
    private View M;
    private LinearLayout N;
    private LinearLayout O;
    private GridView P;
    private TextView Q;
    private LinearLayout R;
    private ImageView S;
    private TextView T;
    private ArrayList<com.zte.iptvclient.android.common.javabean.f> U;
    private boolean V;
    public com.zte.iptvclient.android.common.player.i.a W;
    private GridLayoutManager X;
    private boolean Y;
    private int Z;
    private String a0;
    private LinearLayout b0;
    private LinearLayout c0;
    private TextView d0;
    private ImageView e0;
    private LinearLayout f0;
    private TextView g0;
    private TextView h0;
    private ImageView i0;
    private RelativeLayout j0;
    private ProgressBar k0;
    private HorizontalScrollViewEx r;
    private LinearLayout s;
    private RecyclerView t;
    private ArrayList<String> u;
    private String v;
    private ArrayList<Channel> y;
    private ArrayList<Channel> z;
    private String p = a.class.getSimpleName();
    private int q = 0;
    private int w = 0;
    private int x = 3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVChildFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.a0.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewTreeObserverOnGlobalLayoutListenerC0172a implements ViewTreeObserver.OnGlobalLayoutListener {
        ViewTreeObserverOnGlobalLayoutListenerC0172a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            a.this.P.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            a.this.W = new com.zte.iptvclient.android.common.player.i.a(((com.zte.fragmentlib.b) a.this).h, a.this.U, a.this.q);
            a.this.P.setAdapter((ListAdapter) a.this.W);
            a.this.W.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVChildFragment.java */
    /* loaded from: classes2.dex */
    public class b implements HorizontalScrollViewEx.a {
        b() {
        }

        @Override // com.zte.iptvclient.android.common.customview.viewgroup.scrollview.HorizontalScrollViewEx.a
        public void a(int i) {
            if (i < a.this.A.size()) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.f());
                a aVar = a.this;
                aVar.D = (ColumnBean) aVar.A.get(i);
                a aVar2 = a.this;
                aVar2.a(aVar2.D);
                a.this.x = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVChildFragment.java */
    /* loaded from: classes2.dex */
    public class c implements t.d {
        c(a aVar) {
        }

        @Override // com.zte.iptvclient.android.common.k.t.d
        public void onDismiss() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVChildFragment.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zte.iptvclient.android.mobile.v.b.a aVar = new com.zte.iptvclient.android.mobile.v.b.a();
            Bundle bundle = new Bundle();
            bundle.putBoolean("MulitScreenEdit", true);
            if (((com.zte.fragmentlib.b) a.this).h.getResources().getConfiguration().orientation == 1) {
                if (((com.zte.fragmentlib.b) a.this).h instanceof MainActivity) {
                    ((MainActivity) a.this.getActivity()).u().setVisibility(8);
                }
                bundle.putBoolean("DarkTheme", false);
                if (((com.zte.fragmentlib.b) a.this).h instanceof MultiPlayActivity) {
                    aVar.setArguments(bundle);
                    n nVar = new n();
                    nVar.a(aVar);
                    EventBus.getDefault().post(nVar);
                    return;
                }
                bundle.putBoolean("IsFullScreen", true);
                bundle.putString("InitCondition", o.j().b(com.zte.iptvclient.android.common.i.a.a.a(R.string.search_default)));
                a.this.a("search", bundle);
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.d(1));
                return;
            }
            bundle.putBoolean("DarkTheme", true);
            aVar.setArguments(bundle);
            Fragment parentFragment = a.this.getParentFragment();
            if (parentFragment != null && (parentFragment instanceof com.zte.iptvclient.android.common.player.k.c)) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.v.a());
                return;
            }
            if (parentFragment != null && (parentFragment instanceof com.zte.iptvclient.android.common.player.k.d)) {
                n nVar2 = new n();
                nVar2.a(aVar);
                EventBus.getDefault().post(nVar2);
                return;
            }
            a.this.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVChildFragment.java */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.U.size() <= 1) {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.multiscreen_program_too_less);
                return;
            }
            int i = 0;
            if (a.this.I()) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.a());
            } else {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.c(false));
            }
            if (!(((com.zte.fragmentlib.b) a.this).h instanceof MultiPlayActivity)) {
                if (((com.zte.fragmentlib.b) a.this).h instanceof VOPlayerActivity) {
                    boolean a2 = m.a(((com.zte.fragmentlib.b) a.this).h, MultiPlayActivity.class.getSimpleName());
                    Intent intent = new Intent();
                    intent.setClass(((com.zte.fragmentlib.b) a.this).h, MultiPlayActivity.class);
                    if (!a2) {
                        if (((com.zte.fragmentlib.b) a.this).h.getRequestedOrientation() == 0) {
                            intent.putExtra("IsLandScape", true);
                        }
                        ((com.zte.fragmentlib.b) a.this).h.startActivity(intent);
                        return;
                    }
                    Fragment parentFragment = a.this.getParentFragment();
                    if (parentFragment != null && (parentFragment instanceof com.zte.iptvclient.android.common.player.k.c)) {
                        while (true) {
                            if (i >= a.this.U.size()) {
                                break;
                            }
                            com.zte.iptvclient.android.common.javabean.f fVar = (com.zte.iptvclient.android.common.javabean.f) a.this.U.get(i);
                            com.zte.iptvclient.android.common.player.k.c cVar = (com.zte.iptvclient.android.common.player.k.c) parentFragment;
                            if (TextUtils.equals(fVar.d(), cVar.L1())) {
                                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.i.c(fVar.d(), cVar.O1()));
                                break;
                            }
                            i++;
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(a.this.U);
                    EventBus.getDefault().post(new i(arrayList));
                    ((com.zte.fragmentlib.b) a.this).h.finish();
                    return;
                }
                Fragment parentFragment2 = a.this.getParentFragment();
                com.zte.iptvclient.android.common.player.k.c cVar2 = null;
                if (parentFragment2 != null) {
                    if (parentFragment2 instanceof com.zte.iptvclient.android.common.player.k.c) {
                        cVar2 = (com.zte.iptvclient.android.common.player.k.c) parentFragment2;
                        a.this.a(cVar2);
                        EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.a());
                    } else if (parentFragment2 instanceof com.zte.iptvclient.android.mobile.e0.e.d) {
                        cVar2 = ((com.zte.iptvclient.android.mobile.e0.e.d) parentFragment2).J();
                        if (cVar2 != null) {
                            a.this.a(cVar2);
                        }
                    } else if (parentFragment2 instanceof com.zte.iptvclient.android.mobile.e0.e.i) {
                        cVar2 = ((com.zte.iptvclient.android.mobile.e0.e.i) parentFragment2).J();
                        if (cVar2 != null) {
                            a.this.a(cVar2);
                        }
                    } else if (parentFragment2 instanceof com.zte.iptvclient.android.mobile.a0.b.g) {
                        cVar2 = ((com.zte.iptvclient.android.mobile.a0.b.g) parentFragment2).I();
                    }
                }
                if (cVar2 != null) {
                    cVar2.G1();
                }
                Intent intent2 = new Intent(((com.zte.fragmentlib.b) a.this).h, (Class<?>) MultiPlayActivity.class);
                if (((com.zte.fragmentlib.b) a.this).h.getRequestedOrientation() == 0) {
                    intent2.putExtra("IsLandScape", true);
                }
                a.this.startActivity(intent2);
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.d(1));
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(a.this.U);
            EventBus.getDefault().post(new i(arrayList2));
        }
    }

    /* compiled from: LiveTVChildFragment.java */
    /* loaded from: classes.dex */
    public interface f {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVChildFragment.java */
    /* loaded from: classes2.dex */
    public class g extends RecyclerView.s {
        g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, int i, int i2) {
            super.a(recyclerView, i, i2);
            if (a.this.Y) {
                a.this.Y = false;
                int G = a.this.Z - a.this.X.G();
                if (G < 0 || G >= a.this.t.getChildCount()) {
                    return;
                }
                a.this.t.scrollBy(0, a.this.t.getChildAt(G).getTop());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LiveTVChildFragment.java */
    /* loaded from: classes2.dex */
    public static class h extends androidx.viewpager.widget.a {

        /* renamed from: c, reason: collision with root package name */
        private List<com.zte.iptvclient.android.mobile.a0.b.h> f5344c;

        /* synthetic */ h(List list, ViewTreeObserverOnGlobalLayoutListenerC0172a viewTreeObserverOnGlobalLayoutListenerC0172a) {
            this(list);
        }

        @Override // androidx.viewpager.widget.a
        public void a(Parcelable parcelable, ClassLoader classLoader) {
        }

        @Override // androidx.viewpager.widget.a
        public void a(View view) {
        }

        @Override // androidx.viewpager.widget.a
        public void a(View view, int i, Object obj) {
            if (view instanceof ViewPager) {
                List<com.zte.iptvclient.android.mobile.a0.b.h> list = this.f5344c;
                ((ViewPager) view).removeView(list.get(i % list.size()));
            }
        }

        @Override // androidx.viewpager.widget.a
        public void b(View view) {
        }

        @Override // androidx.viewpager.widget.a
        public Parcelable c() {
            return null;
        }

        private h(List<com.zte.iptvclient.android.mobile.a0.b.h> list) {
            this.f5344c = list;
        }

        @Override // androidx.viewpager.widget.a
        public int a() {
            List<com.zte.iptvclient.android.mobile.a0.b.h> list = this.f5344c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.viewpager.widget.a
        public Object a(View view, int i) {
            int size = i % this.f5344c.size();
            if (view instanceof ViewPager) {
                ((ViewPager) view).addView(this.f5344c.get(size), 0);
                return this.f5344c.get(size);
            }
            super.a(view, i);
            throw null;
        }

        @Override // androidx.viewpager.widget.a
        public boolean a(View view, Object obj) {
            return view.equals(obj);
        }
    }

    public a() {
        new ArrayList();
        this.V = false;
        this.Y = false;
        this.Z = 0;
    }

    private void N() {
        this.R.setOnClickListener(new d());
        this.Q.setOnClickListener(new e());
    }

    private void O() {
        if (this.K != null && !this.V) {
            LogEx.d(this.p, "send PlayLiveTVQueryEvent");
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(true, this.K.getChannelcode(), this.K.getColumncode()));
        } else {
            LogEx.d(this.p, "defaultToPlay mCurSelectedChannel is null!");
        }
    }

    private void P() {
        if (this.u == null) {
            return;
        }
        if (TextUtils.isEmpty(this.v)) {
            try {
                this.v = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(TimeUtil.getNow());
            } catch (Exception e2) {
                LogEx.e(this.p, e2.getMessage());
            }
            LogEx.d(this.p, "mStrCurrentDate=" + this.v);
        }
        int i = 0;
        while (true) {
            if (i >= this.u.size()) {
                break;
            }
            if (TextUtils.equals(this.v, this.u.get(i))) {
                this.w = i;
                LogEx.d(this.p, "mstrCurrentDate=" + this.v + " selectedDateIndex=" + this.w);
                break;
            }
            i++;
        }
        if (this.w >= this.u.size()) {
            this.w = 0;
            LogEx.w(this.p, "selectedDate=" + this.w);
        }
    }

    private void Q() {
        HorizontalScrollViewEx horizontalScrollViewEx;
        ViewGroup.LayoutParams layoutParams;
        ArrayList<ColumnBean> arrayList = this.A;
        if (arrayList == null || arrayList.size() <= 1 || (horizontalScrollViewEx = this.r) == null) {
            return;
        }
        if (this.V && (layoutParams = horizontalScrollViewEx.getLayoutParams()) != null) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(layoutParams);
            layoutParams2.setMargins(0, 0, 0, 0);
            this.r.setLayoutParams(layoutParams2);
        }
        this.r.a(this.q, this.A, this.x, new b());
    }

    private void R() {
        this.a0 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL);
        this.U = com.zte.iptvclient.android.common.player.multiplay.a.c().a();
        Executors.newCachedThreadPool();
        new h(this.L, null);
        this.P.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0172a());
    }

    private void S() {
        int i;
        ArrayList<String> arrayList = new ArrayList<>();
        String c2 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_PREVIEW_DAYOFTV);
        String c3 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_AFTER_DAYOFTV);
        int i2 = 7;
        try {
            i = Integer.parseInt(c2);
        } catch (NumberFormatException unused) {
            i = 7;
        }
        if (i < 0) {
            i *= -1;
        }
        try {
            i2 = Integer.parseInt(c3);
        } catch (NumberFormatException unused2) {
        }
        if (i2 < 0) {
            i2 *= -1;
        }
        Date b2 = s.b();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        for (int i3 = -i; i3 <= i2; i3++) {
            try {
                arrayList.add(simpleDateFormat.format(TimeUtil.addOffset(b2, 5, i3)));
            } catch (Exception unused3) {
                LogEx.e(this.p, "translate time Failed.......");
            }
        }
        LogEx.d(this.p, "listDays=" + arrayList);
        ArrayList<String> arrayList2 = this.u;
        if (arrayList2 != null) {
            if (arrayList2.size() > 0 && arrayList.size() > 0 && !TextUtils.equals(arrayList.get(0), this.u.get(0))) {
                this.u = arrayList;
                this.L = null;
            }
        } else {
            this.u = arrayList;
        }
        P();
    }

    private void T() {
        ArrayList<ColumnBean> arrayList = this.A;
        if (arrayList == null) {
            this.A = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        this.A.addAll(j.e().a());
        ArrayList<ColumnBean> arrayList2 = this.A;
        if (arrayList2 != null && arrayList2.size() > 1) {
            if (this.K == null) {
                if ("1".equals(ConfigMgr.readPropertie("isShowSub"))) {
                    this.x = 3;
                } else {
                    this.x = 1;
                }
                this.C = this.A.get(this.x);
            } else {
                int i = 0;
                while (true) {
                    if (i >= this.A.size()) {
                        break;
                    }
                    if (TextUtils.equals(this.A.get(i).getColumnCode(), this.K.getColumncode())) {
                        this.x = i;
                        this.C = this.A.get(i);
                        break;
                    }
                    i++;
                }
            }
            this.E = this.A.get(0);
            ArrayList<ColumnBean> arrayList3 = this.A;
            this.F = arrayList3.get(arrayList3.size() - 1);
            this.D = this.C;
            Q();
            return;
        }
        LogEx.e(this.p, "getColumnBeanList() is null !!!");
    }

    private void U() {
        T();
        J();
    }

    private void V() {
        ColumnBean columnBean = this.D;
        if (columnBean != null && this.E != null && TextUtils.equals(columnBean.getColumnName(), this.E.getColumnName())) {
            ArrayList<Channel> arrayList = this.B;
            if (arrayList != null && arrayList.size() != 0) {
                this.t.setVisibility(0);
                return;
            } else {
                this.t.setVisibility(8);
                return;
            }
        }
        this.t.setVisibility(0);
    }

    private void W() {
        ColumnBean columnBean;
        LogEx.d(this.p, "updateCurrentChannelBySelectedColumn");
        HashMap<ColumnBean, ArrayList<Channel>> hashMap = this.G;
        if (hashMap != null && hashMap.size() > 0 && (columnBean = this.D) != null) {
            ArrayList<Channel> arrayList = this.G.get(columnBean);
            this.B = arrayList;
            if (arrayList == null) {
                LogEx.e(this.p, "mListCurrentChannel is null");
                return;
            }
            if (TextUtils.equals(this.D.getColumnCode(), this.a0)) {
                com.zte.iptvclient.android.common.j.b.e().a(this.B);
                this.B = com.zte.iptvclient.android.common.j.b.e().a();
                LogEx.d(this.p, "mListCurrentChannel=" + this.B.size() + "; >" + this.D.getColumnName());
            }
            com.zte.iptvclient.android.mobile.a0.a.e.a aVar = this.J;
            if (aVar == null) {
                Fragment parentFragment = getParentFragment();
                this.J = new com.zte.iptvclient.android.mobile.a0.a.e.a(this.h, this.B, this.q, parentFragment != null && (parentFragment instanceof com.zte.iptvclient.android.mobile.a0.b.g));
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this.h, 4);
                this.X = gridLayoutManager;
                this.t.a(gridLayoutManager);
                this.t.c(new g());
                this.t.a(new com.zte.iptvclient.android.mobile.d0.b(30, 30, 30));
                this.t.a(this.J);
                this.J.d();
                this.J.b(this.V);
            } else if (this.B != aVar.e()) {
                this.J.a(this.B);
            }
            ArrayList<Channel> arrayList2 = this.B;
            if (arrayList2 != null && arrayList2.size() > 0) {
                if (this.K == null) {
                    this.K = this.B.get(0);
                }
                LogEx.d(this.p, "swicth current Channel=" + this.K.getChannelname() + "selectedChnnelcode " + this.K.getChannelcode());
                this.Z = 0;
                d(0);
            } else {
                LogEx.d(this.p, "swicth current Channel= nullselectedChnnelcode is null");
                this.K = null;
            }
            Channel channel = this.K;
            if (channel != null && this.D != null && !TextUtils.equals(channel.getChannelname(), this.D.getColumnName())) {
                a(this.K);
            }
            this.C = this.D;
        }
        V();
    }

    public boolean I() {
        return getResources().getConfiguration().orientation == 2;
    }

    public void J() {
        ArrayList<ColumnBean> arrayList = this.A;
        if (arrayList != null && arrayList.size() >= 1) {
            ArrayList<Channel> arrayList2 = this.y;
            if (arrayList2 == null) {
                this.y = new ArrayList<>();
            } else {
                arrayList2.clear();
            }
            ArrayList<Channel> arrayList3 = this.z;
            if (arrayList3 == null) {
                this.z = new ArrayList<>();
            } else {
                arrayList3.clear();
            }
            this.z.addAll(com.zte.iptvclient.android.common.j.i.d().a());
            this.y.addAll(com.zte.iptvclient.android.common.j.i.d().b());
            ArrayList<Channel> arrayList4 = this.y;
            if (arrayList4 != null && arrayList4.size() > 0) {
                this.G = new HashMap<>();
                Iterator<ColumnBean> it2 = this.A.iterator();
                while (it2.hasNext()) {
                    ColumnBean next = it2.next();
                    ArrayList<Channel> arrayList5 = new ArrayList<>();
                    Iterator<Channel> it3 = this.y.iterator();
                    while (it3.hasNext()) {
                        Channel next2 = it3.next();
                        if (TextUtils.equals(next.getColumnCode(), next2.getColumncode())) {
                            arrayList5.add(next2);
                        }
                    }
                    LogEx.d(this.p, "sort columnName=" + next.getColumnName() + "; " + next.getColumnCode() + ">>>" + arrayList5.size());
                    this.G.put(next, arrayList5);
                }
                this.G.put(this.F, this.z);
                W();
                O();
                return;
            }
            LogEx.e(this.p, "getTVALLChannelList() is null !!!");
            return;
        }
        LogEx.d(this.p, " mListColumn  is null!");
    }

    public void K() {
        R();
        U();
        S();
        M();
    }

    public void L() {
        if (this.K != null) {
            String str = this.a0;
            ColumnBean columnBean = this.D;
            if (columnBean != null && !TextUtils.equals(str, columnBean.getColumnCode())) {
                str = this.D.getColumnCode();
            }
            LogEx.d(this.p, "current selectedChnnelcode=" + this.K.getChannelcode());
            e(str, this.K.getChannelcode());
            O();
        }
    }

    public void M() {
        if (this.B == null || this.J == null) {
            return;
        }
        for (int i = 0; i < this.B.size(); i++) {
            this.B.get(i).setIsChannelLock("0");
            this.B.get(i).setAfterChannelLock("0");
        }
        for (int i2 = 0; i2 < this.B.size(); i2++) {
            if (com.zte.iptvclient.android.mobile.f.b.a.b(this.B.get(i2).getRatingid(), this.h)) {
                this.B.get(i2).setIsChannelLock("1");
                this.B.get(i2).setAfterChannelLock("1");
            }
        }
        this.J.d();
    }

    public void a(f fVar) {
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        N();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.V = arguments.getBoolean("isMultiScreenMode", false);
            this.q = arguments.getInt("themetype", 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        if (this.M == null) {
            View inflate = layoutInflater.inflate(R.layout.live_tv_child_fragment, (ViewGroup) null);
            this.M = inflate;
            d(inflate);
        }
        return this.M;
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
    public void onEventMainThread(r rVar) {
        LogEx.d(this.p, "TvDataQueryFinishedEvent get AllChannel and ColumnList!");
        ArrayList<ColumnBean> arrayList = this.A;
        if (arrayList == null || this.y == null || arrayList.size() <= 0 || this.y.size() <= 0) {
            U();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.zte.iptvclient.android.common.player.i.a aVar = this.W;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    private void d(View view) {
        this.f0 = (LinearLayout) view.findViewById(R.id.ll_now_playing);
        this.b0 = (LinearLayout) view.findViewById(R.id.ll_play_now);
        this.c0 = (LinearLayout) view.findViewById(R.id.ll_today_empty);
        this.d0 = (TextView) view.findViewById(R.id.txt_program_name);
        this.e0 = (ImageView) view.findViewById(R.id.img_empty_tv);
        this.g0 = (TextView) view.findViewById(R.id.txt_program_duration);
        this.i0 = (ImageView) view.findViewById(R.id.img_tv);
        this.h0 = (TextView) view.findViewById(R.id.txt_program_title);
        this.j0 = (RelativeLayout) view.findViewById(R.id.rl_progressbar);
        this.k0 = (ProgressBar) view.findViewById(R.id.pb_playing_light);
        com.zte.iptvclient.common.uiframe.f.a(this.f0);
        com.zte.iptvclient.common.uiframe.f.a(this.h0);
        com.zte.iptvclient.common.uiframe.f.a(this.g0);
        com.zte.iptvclient.common.uiframe.f.a(this.i0);
        com.zte.iptvclient.common.uiframe.f.a(this.j0);
        com.zte.iptvclient.common.uiframe.f.a(this.k0);
        com.zte.iptvclient.common.uiframe.f.a(this.b0);
        com.zte.iptvclient.common.uiframe.f.a(this.c0);
        com.zte.iptvclient.common.uiframe.f.a(this.d0);
        com.zte.iptvclient.common.uiframe.f.a(this.e0);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.cl_program_item));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_program_describ));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_showdetail));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_playing));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_nowplaying));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_playing));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_empty_tv));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_tv));
        this.r = (HorizontalScrollViewEx) view.findViewById(R.id.hs_column_view);
        this.s = (LinearLayout) view.findViewById(R.id.ll_page);
        this.t = (RecyclerView) view.findViewById(R.id.channel_list);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_program);
        this.N = linearLayout;
        this.O = (LinearLayout) linearLayout.findViewById(R.id.ll_program_edit_main);
        this.P = (GridView) this.N.findViewById(R.id.gv_program_edit);
        TextView textView = (TextView) this.N.findViewById(R.id.txt_ok);
        this.Q = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.multiscreen_program_confirm));
        this.R = (LinearLayout) this.N.findViewById(R.id.ll_add_window);
        if (TextUtils.equals("1", ConfigMgr.readPropertie("IsSupportHideSearchVOD"))) {
            this.R.setVisibility(8);
        }
        this.S = (ImageView) this.R.findViewById(R.id.img_add);
        TextView textView2 = (TextView) this.R.findViewById(R.id.txt_add);
        this.T = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.add_vod_to_multiscreen_tip));
        com.zte.iptvclient.common.uiframe.f.a(this.N);
        com.zte.iptvclient.common.uiframe.f.a(this.O);
        com.zte.iptvclient.common.uiframe.f.a(this.P);
        com.zte.iptvclient.common.uiframe.f.a(this.Q);
        com.zte.iptvclient.common.uiframe.f.a(this.R);
        com.zte.iptvclient.common.uiframe.f.a(this.S);
        com.zte.iptvclient.common.uiframe.f.a(this.T);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_tv_column_menu_layout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.view_more));
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.middle_line));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.tag_bottom_line));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_bottom_line));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.tag_function_menu_line));
        if ("1".equals(ConfigMgr.readPropertie("ForbiddenMulScreenPlay", "0"))) {
            this.N.setVisibility(8);
        } else if (this.V) {
            this.N.setVisibility(0);
        } else {
            this.N.setVisibility(8);
        }
    }

    private void e(String str, String str2) {
        ArrayList<Channel> arrayList;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= this.A.size()) {
                break;
            }
            if (TextUtils.equals(str, "radio")) {
                this.x = this.A.size() - 1;
                ArrayList<ColumnBean> arrayList2 = this.A;
                this.D = arrayList2.get(arrayList2.size() - 1);
                break;
            } else {
                if (TextUtils.equals(this.A.get(i2).getColumnCode(), str)) {
                    this.x = i2;
                    this.D = this.A.get(i2);
                    break;
                }
                i2++;
            }
        }
        if (this.x < this.A.size()) {
            this.r.a(this.x, true);
            this.D = this.A.get(this.x);
            HashMap<ColumnBean, ArrayList<Channel>> hashMap = this.G;
            if (hashMap == null || hashMap.size() <= 0 || (arrayList = this.G.get(this.D)) == null) {
                return;
            }
            while (true) {
                if (i >= arrayList.size()) {
                    break;
                }
                if (TextUtils.equals(arrayList.get(i).getChannelcode(), str2)) {
                    this.K = arrayList.get(i);
                    LogEx.d(this.p, "swicth current Channel=" + this.K.getChannelname() + "selectedChnnelcode=" + str2);
                    this.J.e(i);
                    d(i);
                    break;
                }
                i++;
            }
            if (arrayList.equals(this.J.e())) {
                return;
            }
            this.J.a(arrayList);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.a aVar) {
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ColumnBean columnBean) {
        if (TextUtils.equals(columnBean.getColumnName(), this.E.getColumnName()) && !com.zte.iptvclient.android.mobile.n.c.b.t()) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            t.a(this.h, new c(this));
            this.r.a(this.x);
            return;
        }
        W();
        O();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.b bVar) {
        int a2;
        if (bVar == null || (a2 = bVar.a()) >= this.B.size()) {
            return;
        }
        if (!bVar.c()) {
            LogEx.d(this.p, "sendPlayLiveTVQueryEvent");
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(true, this.B.get(a2).getChannelcode(), this.B.get(a2).getColumncode()));
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null || !(parentFragment instanceof com.zte.iptvclient.android.mobile.a0.b.g) || bVar.d()) {
            this.K = this.B.get(a2);
            LogEx.d(this.p, "swicth current Channel=" + this.K.getChannelname());
            com.zte.iptvclient.android.mobile.a0.a.e.a aVar = this.J;
            if (aVar != null) {
                aVar.e(a2);
            }
        }
    }

    private void a(Channel channel) {
        boolean z;
        ArrayList<Channel> arrayList = this.B;
        if (arrayList == null || channel == null) {
            return;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
                break;
            }
            if (this.B.get(i) != null && TextUtils.equals(channel.getChannelcode(), this.B.get(i).getChannelcode())) {
                this.J.e(i);
                this.Z = i;
                this.K = this.B.get(i);
                LogEx.d(this.p, "swicth current Channel=" + this.K.getChannelname());
                z = true;
                break;
            }
            i++;
        }
        if (!z && this.B.size() > 0) {
            this.K = this.B.get(0);
            LogEx.d(this.p, "swicth current Channel=" + this.K.getChannelname());
            this.J.e(0);
            this.Z = 0;
            if (!this.V) {
                LogEx.d(this.p, "sendPlayLiveTVQueryEvent");
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(true, this.K.getChannelcode(), this.K.getColumncode()));
            }
        }
        d(this.Z);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.e eVar) {
        String channelcode;
        String str;
        LogEx.d(this.p, " recve InPlayerSwitchChannelEvent");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null || !(parentFragment instanceof com.zte.iptvclient.android.mobile.a0.b.f)) {
            return;
        }
        if (!TextUtils.isEmpty(eVar.a())) {
            channelcode = eVar.a();
        } else {
            Channel channel = this.K;
            channelcode = channel != null ? channel.getChannelcode() : "";
        }
        if (!TextUtils.isEmpty(eVar.b())) {
            str = eVar.b();
        } else {
            str = this.a0;
        }
        LogEx.d(this.p, "get SearchData columncode=" + str + " selectedChnnelcode=" + channelcode);
        int i = 0;
        while (true) {
            if (i >= this.B.size()) {
                break;
            }
            if (TextUtils.equals(this.B.get(i).getChannelcode(), channelcode)) {
                this.K = this.B.get(i);
                break;
            }
            i++;
        }
        LogEx.d(this.p, "swicth current InPlayerSwitchChannelEvent Channel=" + channelcode);
        s.b();
        new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);
        e(str, channelcode);
        W();
        LogEx.d(this.p, "sendPlayLiveTVQueryEvent");
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(true, channelcode, str));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.zte.iptvclient.android.common.player.k.c cVar) {
        for (int i = 0; i < this.U.size(); i++) {
            if (TextUtils.equals(this.U.get(i).d(), cVar.L1())) {
                this.U.get(i).b(String.valueOf(cVar.O1() / 1000));
                return;
            }
        }
    }

    public void a(String str, String str2, String str3, boolean z) {
        Channel channel = this.K;
        if (channel == null || !TextUtils.equals(channel.getChannelcode(), str2) || this.w >= this.L.size()) {
            return;
        }
        LogEx.d(this.p, "playNextTvod prevuecode " + str);
        this.L.get(this.w).a(str, str2, str3, z, false);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.o oVar) {
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null || !(parentFragment instanceof com.zte.iptvclient.android.mobile.a0.b.g)) {
            return;
        }
        PrevueBean b2 = oVar.b();
        e(this.a0, b2.getChannelcode());
        LogEx.d(this.p, "get SearchData columncode=" + this.a0 + " selectedChnnelcode=" + b2.getChannelcode() + " date=" + b2.getBegintime());
        W();
        com.zte.iptvclient.android.common.javabean.e.f4730a = false;
        com.zte.iptvclient.android.common.javabean.e.f4731b = b2;
        if (oVar.a()) {
            return;
        }
        Date date = new Date();
        Date date2 = new Date();
        try {
            date = x.a(b2.getEndtime(), new SimpleDateFormat("yyyyMMddHHmmss"));
            date2 = x.a(b2.getBegintime(), new SimpleDateFormat("yyyyMMddHHmmss"));
        } catch (Exception e2) {
            LogEx.e(this.p, e2.getMessage());
        }
        if (this.K != null && com.zte.iptvclient.android.common.j.i.d().a(date2, date, this.K.getMixno())) {
            com.zte.iptvclient.android.common.player.k.c t = ((MainActivity) this.h).t();
            if (t != null) {
                t.j(3);
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(getResources().getString(R.string.program_playbcak).replace("hour", com.zte.iptvclient.android.common.j.i.d().b(this.K.getMixno())));
            return;
        }
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.b(b2, true));
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.f fVar) {
        com.zte.iptvclient.android.common.player.i.a aVar = this.W;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    private void d(int i) {
        int G = this.X.G();
        int H = this.X.H();
        if (i <= G) {
            this.t.j(i);
        } else if (i <= H) {
            this.t.scrollBy(0, this.t.getChildAt(i - G).getTop());
        } else {
            this.t.j(i);
            this.Y = true;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        if (TextUtils.equals(cVar.a(), "0")) {
            this.a0 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL);
            ArrayList<String> arrayList = this.u;
            if (arrayList == null || arrayList.size() <= 0) {
                S();
            }
        }
    }
}
