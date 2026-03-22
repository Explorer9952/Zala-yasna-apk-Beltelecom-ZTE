package com.zte.iptvclient.android.mobile.a0.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.favorite.SDKFavoriteMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.scrollview.HorizontalScrollViewEx;
import com.zte.iptvclient.android.common.javabean.column.ColumnBean;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.player.activity.VOPlayerActivity;
import com.zte.iptvclient.android.common.player.multiplay.activity.MultiPlayActivity;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.tv.activity.ColumnSortActivity;
import com.zte.iptvclient.android.mobile.tv.ui.c;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import net.lucode.hackware.magicindicator.MagicIndicator;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: LiveTVFragment.java */
/* loaded from: classes.dex */
public class b extends com.zte.fragmentlib.b {
    private ImageView A;
    private String A0;
    private RelativeLayout B;
    private String B0;
    private RelativeLayout C;
    private String C0;
    private RelativeLayout D;
    private RelativeLayout E;
    private HorizontalScrollViewEx F;
    private LinearLayout F0;
    private RelativeLayout G;
    private LinearLayout G0;
    private TextView H0;
    private ImageView I0;
    private MagicIndicator J;
    private LinearLayout J0;
    private LinearLayout K;
    private TextView K0;
    private RecyclerView L;
    private TextView L0;
    private ArrayList<String> M;
    private ImageView M0;
    private String N;
    private RelativeLayout N0;
    private ProgressBar O0;
    private PrevueBean P0;
    private int Q0;
    private ArrayList<Channel> R;
    private String R0;
    private ArrayList<Channel> S;
    private String S0;
    private ArrayList<Channel> T;
    private String T0;
    private boolean U0;
    private ArrayList<ColumnBean> V;
    private ArrayList<Channel> W;
    private ColumnBean X;
    private ColumnBean Y;
    private ColumnBean Z;
    private ColumnBean a0;
    private HashMap<ColumnBean, ArrayList<Channel>> b0;
    private com.zte.iptvclient.android.mobile.a0.a.e.a c0;
    private Channel d0;
    private ViewPager e0;
    private List<com.zte.iptvclient.android.mobile.a0.b.h> f0;
    private z g0;
    private net.lucode.hackware.magicindicator.e.c.a h0;
    private net.lucode.hackware.magicindicator.e.c.b.a i0;
    private View j0;
    private Bitmap k0;
    public PrevueBean m0;
    private LinearLayout n0;
    private LinearLayout o0;
    private GridView p0;
    private TextView q0;
    private LinearLayout r;
    private LinearLayout r0;
    private RelativeLayout s;
    private ImageView s0;
    private ImageView t;
    private TextView t0;
    private ImageView u;
    private y u0;
    private ImageView v;
    private ArrayList<com.zte.iptvclient.android.common.javabean.f> v0;
    private ImageView w;
    private ImageView x;
    public com.zte.iptvclient.android.common.player.i.a x0;
    private ImageView y;
    private LinearLayoutManager y0;
    private ImageView z;
    private String p = b.class.getSimpleName();
    private int q = 0;
    private int O = 0;
    private int P = 0;
    private int Q = 3;
    private ArrayList<Channel> U = new ArrayList<>();
    private boolean l0 = true;
    private boolean w0 = false;
    private int z0 = 0;
    private String D0 = "";
    private String E0 = "";
    private Handler V0 = new k();
    Runnable W0 = new n();
    Runnable X0 = new o();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    public class a implements HorizontalScrollViewEx.a {
        a() {
        }

        @Override // com.zte.iptvclient.android.common.customview.viewgroup.scrollview.HorizontalScrollViewEx.a
        public void a(int i) {
            if (i < b.this.V.size()) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.f());
                b bVar = b.this;
                bVar.Y = (ColumnBean) bVar.V.get(i);
                b bVar2 = b.this;
                bVar2.a(bVar2.Y);
                b.this.Q = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.a0.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0173b implements t.d {
        C0173b(b bVar) {
        }

        @Override // com.zte.iptvclient.android.common.k.t.d
        public void onDismiss() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(((com.zte.fragmentlib.b) b.this).h, ColumnSortActivity.class);
            intent.putExtra("From", "LiveTvFragment");
            ((com.zte.fragmentlib.b) b.this).h.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {

        /* compiled from: LiveTVFragment.java */
        /* loaded from: classes2.dex */
        class a implements Runnable {

            /* compiled from: LiveTVFragment.java */
            /* renamed from: com.zte.iptvclient.android.mobile.a0.b.b$d$a$a, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            class ViewTreeObserverOnGlobalLayoutListenerC0174a implements ViewTreeObserver.OnGlobalLayoutListener {
                ViewTreeObserverOnGlobalLayoutListenerC0174a() {
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    b.this.p0.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    b.this.x0 = new com.zte.iptvclient.android.common.player.i.a(((com.zte.fragmentlib.b) b.this).h, b.this.v0, b.this.q);
                    b.this.p0.setAdapter((ListAdapter) b.this.x0);
                    b.this.x0.notifyDataSetChanged();
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.l0) {
                    if (b.this.d0 == null || TextUtils.isEmpty(b.this.d0.getChannelcode())) {
                        return;
                    }
                    if (!com.zte.iptvclient.android.common.player.multiplay.a.c().a("0", b.this.d0.getChannelcode())) {
                        b.this.v0.add(0, com.zte.iptvclient.android.common.player.multiplay.a.a(b.this.d0));
                    }
                } else {
                    PrevueBean prevueBean = b.this.m0;
                    if (prevueBean == null || TextUtils.isEmpty(prevueBean.getPrevuecode())) {
                        return;
                    }
                    if (!com.zte.iptvclient.android.common.player.multiplay.a.c().a("1", b.this.m0.getPrevuecode())) {
                        b.this.v0.add(0, com.zte.iptvclient.android.common.player.multiplay.a.a(b.this.m0));
                    }
                }
                if (b.this.v0.size() > 4) {
                    b.this.v0.remove(4);
                }
                if (b.this.f0 != null && b.this.e0 != null && b.this.f0.size() > b.this.e0.c()) {
                    ((com.zte.iptvclient.android.mobile.a0.b.h) b.this.f0.get(b.this.e0.c())).f();
                }
                b.this.p0.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0174a());
            }
        }

        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.X == null || b.this.d0 == null) {
                return;
            }
            b bVar = b.this;
            bVar.A0 = bVar.X.getColumnCode();
            b bVar2 = b.this;
            bVar2.B0 = bVar2.d0.getChannelcode();
            if (b.this.u0 != null) {
                b.this.u0.a();
            }
            com.zte.iptvclient.android.common.player.multiplay.a.c().a().clear();
            if (b.this.n0 != null) {
                b.this.n0.post(new a());
            }
            b.this.w0 = true;
            b.this.G.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = b.this.F.getLayoutParams();
            if (layoutParams != null) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(layoutParams);
                layoutParams2.setMargins(0, 0, 0, 0);
                b.this.F.setLayoutParams(layoutParams2);
            }
            b.this.b(true);
            if (b.this.n0 != null) {
                b.this.n0.setVisibility(0);
            }
            if (b.this.r != null) {
                b.this.r.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {

        /* compiled from: LiveTVFragment.java */
        /* loaded from: classes2.dex */
        class a implements t.d {
            a(e eVar) {
            }

            @Override // com.zte.iptvclient.android.common.k.t.d
            public void onDismiss() {
            }
        }

        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.d0 == null) {
                LogEx.d(b.this.p, "mCurSelectedChannel is null");
                return;
            }
            if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                com.zte.iptvclient.android.common.k.t.a(((com.zte.fragmentlib.b) b.this).h, new a(this));
            } else {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                if (TextUtils.equals(b.this.d0.getIsfavourite(), "1")) {
                    b bVar = b.this;
                    bVar.b(bVar.d0);
                } else {
                    b bVar2 = b.this;
                    bVar2.a(bVar2.d0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {

        /* compiled from: LiveTVFragment.java */
        /* loaded from: classes2.dex */
        class a implements t.d {
            a(f fVar) {
            }

            @Override // com.zte.iptvclient.android.common.k.t.d
            public void onDismiss() {
            }
        }

        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zte.iptvclient.android.common.player.k.c t;
            if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                com.zte.iptvclient.android.common.k.t.a(((com.zte.fragmentlib.b) b.this).h, new a(this));
            } else {
                if (com.zte.iptvclient.android.common.k.c.a() || b.this.d0 == null || (t = ((MainActivity) ((com.zte.fragmentlib.b) b.this).h).t()) == null) {
                    return;
                }
                com.zte.iptvclient.android.common.e.r.g gVar = new com.zte.iptvclient.android.common.e.r.g();
                gVar.a(b.this.D0);
                gVar.d(b.this.E0);
                gVar.b(b.this.d0.getMixno());
                t.a(gVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ("1".equals(ConfigMgr.readPropertie("isShowInConstructionTip"))) {
                com.zte.iptvclient.android.common.k.t.a(((com.zte.fragmentlib.b) b.this).h);
            } else {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                b.this.e(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {

        /* compiled from: LiveTVFragment.java */
        /* loaded from: classes2.dex */
        class a implements t.d {
            a(h hVar) {
            }

            @Override // com.zte.iptvclient.android.common.k.t.d
            public void onDismiss() {
            }
        }

        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
                if (b.this.d0 == null) {
                    return;
                }
                Bundle bundle = new Bundle();
                b bVar = b.this;
                PrevueBean prevueBean = bVar.m0;
                if (prevueBean == null) {
                    bundle.putString("contentCode", bVar.d0.getChannelcode());
                } else {
                    bundle.putString("contentCode", prevueBean.getPrevuecode());
                }
                b.this.a("fragment_bt_comment", bundle);
                return;
            }
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            com.zte.iptvclient.android.common.k.t.a(((com.zte.fragmentlib.b) b.this).h, new a(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zte.iptvclient.android.mobile.v.b.a aVar = new com.zte.iptvclient.android.mobile.v.b.a();
            Bundle bundle = new Bundle();
            bundle.putBoolean("MulitScreenEdit", true);
            if (((com.zte.fragmentlib.b) b.this).h.getResources().getConfiguration().orientation == 1) {
                if (((com.zte.fragmentlib.b) b.this).h instanceof MainActivity) {
                    ((MainActivity) b.this.getActivity()).u().setVisibility(8);
                }
                bundle.putBoolean("DarkTheme", false);
                if (((com.zte.fragmentlib.b) b.this).h instanceof MultiPlayActivity) {
                    aVar.setArguments(bundle);
                    com.zte.iptvclient.android.common.e.x.n nVar = new com.zte.iptvclient.android.common.e.x.n();
                    nVar.a(aVar);
                    EventBus.getDefault().post(nVar);
                    return;
                }
                bundle.putBoolean("IsFullScreen", true);
                bundle.putString("InitCondition", com.zte.iptvclient.android.common.k.o.j().b(com.zte.iptvclient.android.common.i.a.a.a(R.string.search_default)));
                b.this.a("search", bundle);
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.d(1));
                return;
            }
            bundle.putBoolean("DarkTheme", true);
            aVar.setArguments(bundle);
            Fragment parentFragment = b.this.getParentFragment();
            if (parentFragment != null && (parentFragment instanceof com.zte.iptvclient.android.common.player.k.c)) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.v.a());
                return;
            }
            if (parentFragment != null && (parentFragment instanceof com.zte.iptvclient.android.common.player.k.d)) {
                com.zte.iptvclient.android.common.e.x.n nVar2 = new com.zte.iptvclient.android.common.e.x.n();
                nVar2.a(aVar);
                EventBus.getDefault().post(nVar2);
                return;
            }
            b.this.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    public class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.v0.size() <= 1) {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.multiscreen_program_too_less);
                return;
            }
            int i = 0;
            if (b.this.I()) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.a());
            } else {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.c(false));
            }
            if (!(((com.zte.fragmentlib.b) b.this).h instanceof MultiPlayActivity)) {
                if (((com.zte.fragmentlib.b) b.this).h instanceof VOPlayerActivity) {
                    boolean a2 = com.zte.iptvclient.android.common.k.m.a(((com.zte.fragmentlib.b) b.this).h, MultiPlayActivity.class.getSimpleName());
                    Intent intent = new Intent();
                    intent.setClass(((com.zte.fragmentlib.b) b.this).h, MultiPlayActivity.class);
                    if (!a2) {
                        if (((com.zte.fragmentlib.b) b.this).h.getRequestedOrientation() == 0) {
                            intent.putExtra("IsLandScape", true);
                        }
                        ((com.zte.fragmentlib.b) b.this).h.startActivity(intent);
                        return;
                    }
                    Fragment parentFragment = b.this.getParentFragment();
                    if (parentFragment != null && (parentFragment instanceof com.zte.iptvclient.android.common.player.k.c)) {
                        while (true) {
                            if (i >= b.this.v0.size()) {
                                break;
                            }
                            com.zte.iptvclient.android.common.javabean.f fVar = (com.zte.iptvclient.android.common.javabean.f) b.this.v0.get(i);
                            com.zte.iptvclient.android.common.player.k.c cVar = (com.zte.iptvclient.android.common.player.k.c) parentFragment;
                            if (TextUtils.equals(fVar.d(), cVar.L1())) {
                                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.i.c(fVar.d(), cVar.O1()));
                                break;
                            }
                            i++;
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(b.this.v0);
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.i(arrayList));
                    ((com.zte.fragmentlib.b) b.this).h.finish();
                    return;
                }
                Fragment parentFragment2 = b.this.getParentFragment();
                com.zte.iptvclient.android.common.player.k.c cVar2 = null;
                if (parentFragment2 != null) {
                    if (parentFragment2 instanceof com.zte.iptvclient.android.common.player.k.c) {
                        cVar2 = (com.zte.iptvclient.android.common.player.k.c) parentFragment2;
                        b.this.a(cVar2);
                        EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.a());
                    } else if (parentFragment2 instanceof com.zte.iptvclient.android.mobile.e0.e.d) {
                        cVar2 = ((com.zte.iptvclient.android.mobile.e0.e.d) parentFragment2).J();
                        if (cVar2 != null) {
                            b.this.a(cVar2);
                        }
                    } else if (parentFragment2 instanceof com.zte.iptvclient.android.mobile.e0.e.i) {
                        cVar2 = ((com.zte.iptvclient.android.mobile.e0.e.i) parentFragment2).J();
                        if (cVar2 != null) {
                            b.this.a(cVar2);
                        }
                    } else if (parentFragment2 instanceof com.zte.iptvclient.android.mobile.a0.b.g) {
                        cVar2 = ((com.zte.iptvclient.android.mobile.a0.b.g) parentFragment2).I();
                    }
                }
                if (cVar2 != null) {
                    cVar2.G1();
                }
                Intent intent2 = new Intent(((com.zte.fragmentlib.b) b.this).h, (Class<?>) MultiPlayActivity.class);
                if (((com.zte.fragmentlib.b) b.this).h.getRequestedOrientation() == 0) {
                    intent2.putExtra("IsLandScape", true);
                }
                b.this.startActivity(intent2);
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.d(1));
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(b.this.v0);
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.i(arrayList2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    public class k extends Handler {
        k() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                Bundle data = message.getData();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                try {
                    LogEx.d(b.this.p, "getUserFavoriteList returncode is " + data.getString("returncode") + "   errormsg is " + data.getString("errormsg") + ",msg is " + message);
                    JSONObject jSONObject = new JSONObject(data.getString("msg"));
                    if ("0".equals(jSONObject.optString("returncode"))) {
                        JSONArray jSONArray = jSONObject.getJSONArray("data");
                        if (arrayList2.size() > 0) {
                            arrayList2.clear();
                        }
                        if (arrayList.size() > 0) {
                            arrayList.clear();
                        }
                        b.this.S = com.zte.iptvclient.android.common.j.i.d().c();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            for (int i2 = 0; i2 < b.this.S.size(); i2++) {
                                if (TextUtils.equals(((Channel) b.this.S.get(i2)).getChannelcode(), jSONObject2.getString("contentcode"))) {
                                    LogEx.d(b.this.p, "current channel is favoriteItem=" + ((Channel) b.this.R.get(i2)).getChannelcode());
                                    ((Channel) b.this.S.get(i2)).setIsfavourite("1");
                                    arrayList2.add(b.this.S.get(i2));
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    LogEx.e(b.this.p, "query channel favorite: " + e.getMessage());
                }
                if (b.this.S != null) {
                    for (int i3 = 0; i3 < b.this.S.size(); i3++) {
                        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                            if (TextUtils.equals(((Channel) b.this.S.get(i3)).getChannelcode(), ((Channel) arrayList2.get(i4)).getChannelcode())) {
                                arrayList.add(arrayList2.get(i4));
                            }
                        }
                    }
                }
                b.this.b((ArrayList<Channel>) arrayList);
                LogEx.d(b.this.p, " sdkQueryFavoriteChannelList finish");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    public class l extends net.lucode.hackware.magicindicator.e.c.b.a {

        /* compiled from: LiveTVFragment.java */
        /* loaded from: classes2.dex */
        class a implements c.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ TextView f5358a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ TextView f5359b;

            a(TextView textView, TextView textView2) {
                this.f5358a = textView;
                this.f5359b = textView2;
            }

            @Override // com.zte.iptvclient.android.mobile.tv.ui.c.b
            public void a(int i, int i2) {
                if (b.this.q == 0) {
                    this.f5358a.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_date_txt_normal));
                    ((com.zte.fragmentlib.b) b.this).h.a(this.f5358a, "textColor", R.color.tv_date_txt_normal);
                    this.f5359b.setBackground(c.a.a.a.d.b.d().d(R.drawable.weekly_circle_shape));
                    ((com.zte.fragmentlib.b) b.this).h.a(this.f5359b, "background", R.drawable.weekly_circle_shape_light);
                    this.f5359b.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_date_txt_normal));
                    ((com.zte.fragmentlib.b) b.this).h.a(this.f5359b, "textColor", R.color.tv_date_txt_normal);
                    return;
                }
                this.f5358a.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_date_selected));
                ((com.zte.fragmentlib.b) b.this).h.a(this.f5358a, "textColor", R.color.tv_date_txt_normal);
                this.f5359b.setBackground(c.a.a.a.d.b.d().d(R.drawable.weekly_circle_shape));
                ((com.zte.fragmentlib.b) b.this).h.a(this.f5359b, "background", R.drawable.weekly_circle_shape_light);
                this.f5359b.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_date_selected));
                ((com.zte.fragmentlib.b) b.this).h.a(this.f5359b, "textColor", R.color.multiplayer_date_selected_light);
            }

            @Override // com.zte.iptvclient.android.mobile.tv.ui.c.b
            public void a(int i, int i2, float f, boolean z) {
            }

            @Override // com.zte.iptvclient.android.mobile.tv.ui.c.b
            public void b(int i, int i2) {
                if (b.this.P == i) {
                    return;
                }
                if (i == 0) {
                    i = b.this.O;
                }
                this.f5358a.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_date_txt_select));
                ((com.zte.fragmentlib.b) b.this).h.a(this.f5358a, "textColor", R.color.tv_date_txt_select);
                this.f5359b.setBackground(c.a.a.a.d.b.d().d(R.drawable.weekly_circle_shape_dark));
                ((com.zte.fragmentlib.b) b.this).h.a(this.f5359b, "background", R.drawable.weekly_circle_shape_selected);
                this.f5359b.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_date_weekly_select_textcolor));
                ((com.zte.fragmentlib.b) b.this).h.a(this.f5359b, "textColor", R.color.multiplayer_date_selected_light);
                if (i < b.this.M.size()) {
                    b.this.O = i;
                    b bVar = b.this;
                    bVar.P = bVar.O;
                    b bVar2 = b.this;
                    bVar2.N = (String) bVar2.M.get(i);
                    if (b.this.f0 == null || b.this.f0.size() <= 0) {
                        return;
                    }
                    ((com.zte.iptvclient.android.mobile.a0.b.h) b.this.f0.get(i)).f();
                }
            }

            @Override // com.zte.iptvclient.android.mobile.tv.ui.c.b
            public void b(int i, int i2, float f, boolean z) {
            }
        }

        /* compiled from: LiveTVFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.a0.b.b$l$b, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class ViewOnClickListenerC0175b implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f5361a;

            ViewOnClickListenerC0175b(int i) {
                this.f5361a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.f5361a != b.this.O && this.f5361a < b.this.M.size()) {
                    b.this.O = this.f5361a;
                    b bVar = b.this;
                    bVar.N = (String) bVar.M.get(this.f5361a);
                    if (b.this.f0 == null || b.this.f0.size() <= b.this.O) {
                        return;
                    }
                    b.this.e0.d(this.f5361a);
                }
            }
        }

        l() {
        }

        @Override // net.lucode.hackware.magicindicator.e.c.b.a
        public int a() {
            if (b.this.M == null) {
                return 0;
            }
            return b.this.M.size();
        }

        @Override // net.lucode.hackware.magicindicator.e.c.b.a
        public net.lucode.hackware.magicindicator.e.c.b.d a(Context context, int i) {
            if (i >= b.this.M.size()) {
                return null;
            }
            com.zte.iptvclient.android.mobile.tv.ui.c cVar = new com.zte.iptvclient.android.mobile.tv.ui.c(((com.zte.fragmentlib.b) b.this).h);
            cVar.a(R.layout.weekly_title_item_dark);
            TextView textView = (TextView) cVar.findViewById(R.id.date_text);
            TextView textView2 = (TextView) cVar.findViewById(R.id.weekly_text);
            textView.setText(com.zte.iptvclient.android.common.k.x.a(((com.zte.fragmentlib.b) b.this).h, (String) b.this.M.get(i), Locale.ENGLISH));
            textView2.setText(com.zte.iptvclient.android.common.k.x.a(((com.zte.fragmentlib.b) b.this).h, (String) b.this.M.get(i)));
            com.zte.iptvclient.common.uiframe.f.a(cVar);
            com.zte.iptvclient.common.uiframe.f.a(textView);
            com.zte.iptvclient.common.uiframe.f.a(textView2);
            cVar.a(new a(textView, textView2));
            cVar.setOnClickListener(new ViewOnClickListenerC0175b(i));
            return cVar;
        }

        @Override // net.lucode.hackware.magicindicator.e.c.b.a
        public net.lucode.hackware.magicindicator.e.c.b.c a(Context context) {
            net.lucode.hackware.magicindicator.e.c.c.a aVar = new net.lucode.hackware.magicindicator.e.c.c.a(context);
            aVar.a(Integer.valueOf(((com.zte.fragmentlib.b) b.this).h.getResources().getColor(R.color.line_pagerindicator_light)));
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    public class m implements AdapterView.OnItemClickListener {
        m() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b.this.v0.remove(b.this.x0.getItem(i));
            b.this.x0.notifyDataSetChanged();
            ((com.zte.iptvclient.android.mobile.a0.b.h) b.this.f0.get(b.this.e0.c())).f();
        }
    }

    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.V();
        }
    }

    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    class o implements Runnable {

        /* compiled from: LiveTVFragment.java */
        /* loaded from: classes2.dex */
        class a implements SDKFavoriteMgr.OnUserFavoriteListReturnListener {
            a() {
            }

            @Override // com.video.androidsdk.service.favorite.SDKFavoriteMgr.OnUserFavoriteListReturnListener
            public void onUserFavoriteListReturn(String str, String str2, String str3) {
                LogEx.d(b.this.p, "onUserFavoriteListReturn " + str3);
                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("returncode", str);
                bundle.putString("errormsg", str2);
                bundle.putString("msg", str3);
                message.what = 1;
                message.setData(bundle);
                b.this.V0.sendMessage(message);
            }
        }

        o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.R != null) {
                b.this.R.clear();
            } else {
                b.this.R = new ArrayList();
            }
            b.this.R.addAll(com.zte.iptvclient.android.common.j.i.d().b());
            LogEx.d(b.this.p, " sdkQueryFavoriteChannelList start");
            if (b.this.R != null) {
                for (int i = 0; i < b.this.R.size(); i++) {
                    ((Channel) b.this.R.get(i)).setIsfavourite("0");
                }
            }
            SDKFavoriteMgr sDKFavoriteMgr = new SDKFavoriteMgr();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("favoritetype", DownloadConstant.REPORT_MSGTYPE_ADD);
            sDKFavoriteMgr.getUserFavoriteList(hashMap, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    public class p implements SDKFavoriteMgr.OnAddFavoriteReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Channel f5367a;

        p(Channel channel) {
            this.f5367a = channel;
        }

        @Override // com.video.androidsdk.service.favorite.SDKFavoriteMgr.OnAddFavoriteReturnListener
        public void onAddFavoriteReturn(String str, String str2) {
            LogEx.d(b.this.p, "onAddFavoriteReturn returncode=" + str + " errormsg=" + str2);
            if (!TextUtils.equals(str, "0")) {
                LogEx.w(b.this.p, str2);
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.add_favourite_msg5);
                return;
            }
            if (b.this.d0 != null && TextUtils.equals(this.f5367a.getChannelcode(), b.this.d0.getChannelcode())) {
                b.this.d0.setIsfavourite("1");
            }
            if (b.this.v != null) {
                b.this.v.setBackground(c.a.a.a.d.b.d().d(R.drawable.function_fav_selected));
                ((com.zte.fragmentlib.b) b.this).h.a(b.this.v, "background", R.drawable.function_fav_selected);
            }
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.m.a());
            b.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    public class q implements SDKFavoriteMgr.OnDelFavoriteReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Channel f5369a;

        q(Channel channel) {
            this.f5369a = channel;
        }

        @Override // com.video.androidsdk.service.favorite.SDKFavoriteMgr.OnDelFavoriteReturnListener
        public void onDelFavoriteReturn(String str, String str2) {
            LogEx.d(b.this.p, " del favorite channel , returncode : " + str + ", errormsg : " + str2);
            if (!TextUtils.equals(str, "0")) {
                LogEx.w(b.this.p, str2);
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.del_favorite_channel_fail);
                return;
            }
            if (b.this.d0 != null && TextUtils.equals(this.f5369a.getChannelcode(), b.this.d0.getChannelcode())) {
                b.this.d0.setIsfavourite("0");
            }
            if (b.this.v != null) {
                b.this.v.setBackground(c.a.a.a.d.b.d().d(R.drawable.function_fav_normal));
                ((com.zte.fragmentlib.b) b.this).h.a(b.this.v, "background", R.drawable.function_fav_normal);
            }
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.m.a());
            b.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    public class r implements ViewPager.i {
        r() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void b(int i) {
            if (i < b.this.f0.size()) {
                ((com.zte.iptvclient.android.mobile.a0.b.h) b.this.f0.get(i)).a(b.this.Y);
                ((com.zte.iptvclient.android.mobile.a0.b.h) b.this.f0.get(i)).b(b.this.d0);
            } else {
                LogEx.e(b.this.p, "current onPageSelected position > all views");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    public class s implements ViewTreeObserver.OnGlobalLayoutListener {
        s() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            b.this.p0.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            b.this.x0 = new com.zte.iptvclient.android.common.player.i.a(((com.zte.fragmentlib.b) b.this).h, b.this.v0, b.this.q);
            b.this.p0.setAdapter((ListAdapter) b.this.x0);
            b.this.x0.notifyDataSetChanged();
        }
    }

    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    class t implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5373a;

        t(int i) {
            this.f5373a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.F.a(this.f5373a);
            b.this.Q = this.f5373a;
        }
    }

    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    class u implements Runnable {
        u() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.F.a(1);
            b.this.Q = 1;
        }
    }

    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    class v implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5376a;

        v(int i) {
            this.f5376a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.F.a(this.f5376a);
            b.this.Q = this.f5376a;
        }
    }

    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    class w implements Runnable {
        w() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.F.a(3);
            b.this.Q = 3;
        }
    }

    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    class x extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PrevueBean f5379a;

        x(b bVar, PrevueBean prevueBean) {
            this.f5379a = prevueBean;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.b(this.f5379a, true));
        }
    }

    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes.dex */
    public interface y {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LiveTVFragment.java */
    /* loaded from: classes2.dex */
    public static class z extends androidx.viewpager.widget.a {

        /* renamed from: c, reason: collision with root package name */
        private List<com.zte.iptvclient.android.mobile.a0.b.h> f5380c;

        /* synthetic */ z(List list, k kVar) {
            this(list);
        }

        @Override // androidx.viewpager.widget.a
        public void a(Parcelable parcelable, ClassLoader classLoader) {
        }

        @Override // androidx.viewpager.widget.a
        public void a(View view) {
        }

        public void a(List<com.zte.iptvclient.android.mobile.a0.b.h> list) {
            this.f5380c = list;
            b();
        }

        @Override // androidx.viewpager.widget.a
        public void b(View view) {
        }

        @Override // androidx.viewpager.widget.a
        public Parcelable c() {
            return null;
        }

        private z(List<com.zte.iptvclient.android.mobile.a0.b.h> list) {
            this.f5380c = list;
        }

        @Override // androidx.viewpager.widget.a
        public void a(View view, int i, Object obj) {
            if (view instanceof ViewPager) {
                List<com.zte.iptvclient.android.mobile.a0.b.h> list = this.f5380c;
                ((ViewPager) view).removeView(list.get(i % list.size()));
            }
        }

        @Override // androidx.viewpager.widget.a
        public int a() {
            List<com.zte.iptvclient.android.mobile.a0.b.h> list = this.f5380c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.viewpager.widget.a
        public Object a(View view, int i) {
            int size = i % this.f5380c.size();
            if (view instanceof ViewPager) {
                ((ViewPager) view).addView(this.f5380c.get(size), 0);
                return this.f5380c.get(size);
            }
            super.a(view, i);
            throw null;
        }

        @Override // androidx.viewpager.widget.a
        public boolean a(View view, Object obj) {
            return view.equals(obj);
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        P();
        K();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.w0 = arguments.getBoolean("isMultiScreenMode", false);
            this.q = arguments.getInt("themetype", 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        if (this.j0 == null) {
            View inflate = layoutInflater.inflate(R.layout.live_tv_fragment, (ViewGroup) null);
            this.j0 = inflate;
            d(inflate);
        }
        this.y.setVisibility(TextUtils.equals(ConfigMgr.readPropertie("isShareBtn"), "1") ? 0 : 8);
        return this.j0;
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
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.h hVar) {
        LogEx.d(this.p, "PlayNextDateEvent");
        int i2 = this.O + 1;
        this.O = i2;
        if (i2 < this.f0.size()) {
            this.e0.d(this.O);
            this.f0.get(this.O).a(this.R0, this.T0, this.S0, this.U0, true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.zte.iptvclient.android.common.player.i.a aVar = this.x0;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
        List<com.zte.iptvclient.android.mobile.a0.b.h> list = this.f0;
        if (list == null || this.e0 == null || list.size() <= this.e0.c()) {
            return;
        }
        this.f0.get(this.e0.c()).f();
    }

    private void P() {
        this.G.setOnClickListener(new c());
        this.s.setOnClickListener(new d());
        this.v.setOnClickListener(new e());
        this.x.setOnClickListener(new f());
        this.y.setOnClickListener(new g());
        this.z.setOnClickListener(new h());
        this.r0.setOnClickListener(new i());
        this.q0.setOnClickListener(new j());
        this.p0.setOnItemClickListener(new m());
    }

    private void Q() {
        if (com.zte.iptvclient.android.mobile.e0.f.b.b()) {
            this.E.setVisibility(0);
        } else {
            this.E.setVisibility(8);
        }
    }

    private void R() {
        if (this.d0 != null && !this.w0) {
            LogEx.d(this.p, "send PlayLiveTVQueryEvent");
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(true, this.d0.getChannelcode(), this.d0.getColumncode()));
        } else {
            LogEx.d(this.p, "defaultToPlay mCurSelectedChannel is null!");
        }
    }

    private void S() {
        if (this.M == null) {
            return;
        }
        if (TextUtils.isEmpty(this.N)) {
            try {
                this.N = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(TimeUtil.getNow());
            } catch (Exception e2) {
                LogEx.e(this.p, e2.getMessage());
            }
            LogEx.d(this.p, "mStrCurrentDate=" + this.N);
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.M.size()) {
                break;
            }
            if (TextUtils.equals(this.N, this.M.get(i2))) {
                this.O = i2;
                LogEx.d(this.p, "mstrCurrentDate=" + this.N + " selectedDateIndex=" + this.O);
                break;
            }
            i2++;
        }
        if (this.O >= this.M.size()) {
            this.O = 0;
            LogEx.w(this.p, "selectedDate=" + this.O);
        }
    }

    private void T() {
        HorizontalScrollViewEx horizontalScrollViewEx;
        ViewGroup.LayoutParams layoutParams;
        ArrayList<ColumnBean> arrayList = this.V;
        if (arrayList == null || arrayList.size() <= 1 || (horizontalScrollViewEx = this.F) == null) {
            return;
        }
        if (this.w0 && (layoutParams = horizontalScrollViewEx.getLayoutParams()) != null) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(layoutParams);
            layoutParams2.setMargins(0, 0, 0, 0);
            this.F.setLayoutParams(layoutParams2);
        }
        this.F.a(this.q, this.V, this.Q, new a());
    }

    private void U() {
        this.C0 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL);
        this.v0 = com.zte.iptvclient.android.common.player.multiplay.a.c().a();
        Executors.newCachedThreadPool();
        z zVar = new z(this.f0, null);
        this.g0 = zVar;
        this.e0.a(zVar);
        net.lucode.hackware.magicindicator.e.c.a aVar = new net.lucode.hackware.magicindicator.e.c.a(this.h);
        this.h0 = aVar;
        aVar.a(0.5f);
        this.h0.c(true);
        this.h0.b(true);
        l lVar = new l();
        this.i0 = lVar;
        this.h0.a(lVar);
        this.J.a(this.h0);
        net.lucode.hackware.magicindicator.c.a(this.J, this.e0);
        this.e0.d(new r());
        this.p0.getViewTreeObserver().addOnGlobalLayoutListener(new s());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        if (this.f0 == null) {
            this.f0 = new ArrayList();
            for (int i2 = 0; i2 < this.M.size(); i2++) {
                this.f0.add(new com.zte.iptvclient.android.mobile.a0.b.h(this.h, this.M.get(i2), this.w0, this.q));
            }
        } else {
            for (int i3 = 0; i3 < this.f0.size(); i3++) {
                this.f0.get(i3).a(this.q);
            }
        }
        if (this.O < this.M.size()) {
            this.N = this.M.get(this.O);
        } else {
            this.N = this.M.get(0);
        }
        this.g0.a(this.f0);
        LogEx.d(this.p, "mstrCurrentDate=" + this.N + ";mListDate=" + this.M.toString() + " selectedDate=" + this.O);
        if (this.h0.c() != null) {
            this.h0.c().b();
        }
        int size = this.f0.size();
        int i4 = this.O;
        if (size > i4) {
            this.e0.d(i4);
        }
    }

    private void W() {
        int i2;
        ArrayList<String> arrayList = new ArrayList<>();
        String c2 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_PREVIEW_DAYOFTV);
        String c3 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_AFTER_DAYOFTV);
        int i3 = 7;
        try {
            i2 = Integer.parseInt(c2);
        } catch (NumberFormatException unused) {
            i2 = 7;
        }
        if (i2 < 0) {
            i2 *= -1;
        }
        try {
            i3 = Integer.parseInt(c3);
        } catch (NumberFormatException unused2) {
        }
        if (i3 < 0) {
            i3 *= -1;
        }
        Date b2 = com.zte.iptvclient.android.common.k.s.b();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        for (int i4 = -i2; i4 <= i3; i4++) {
            try {
                arrayList.add(simpleDateFormat.format(TimeUtil.addOffset(b2, 5, i4)));
            } catch (Exception unused3) {
                LogEx.e(this.p, "translate time Failed.......");
            }
        }
        LogEx.d(this.p, "listDays=" + arrayList);
        ArrayList<String> arrayList2 = this.M;
        if (arrayList2 != null) {
            if (arrayList2.size() > 0 && arrayList.size() > 0 && !TextUtils.equals(arrayList.get(0), this.M.get(0))) {
                this.M = arrayList;
                this.f0 = null;
            }
        } else {
            this.M = arrayList;
        }
        S();
    }

    private void X() {
        ArrayList<ColumnBean> arrayList = this.V;
        if (arrayList == null) {
            this.V = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        this.V.addAll(com.zte.iptvclient.android.common.j.j.e().a());
        ArrayList<ColumnBean> arrayList2 = this.V;
        if (arrayList2 != null && arrayList2.size() > 1) {
            if (this.d0 == null) {
                if ("1".equals(ConfigMgr.readPropertie("isShowSub"))) {
                    this.Q = 3;
                } else {
                    this.Q = 1;
                }
                this.X = this.V.get(this.Q);
            } else {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.V.size()) {
                        break;
                    }
                    if (TextUtils.equals(this.V.get(i2).getColumnCode(), this.d0.getColumncode())) {
                        this.Q = i2;
                        this.X = this.V.get(i2);
                        break;
                    }
                    i2++;
                }
            }
            this.Z = this.V.get(0);
            ArrayList<ColumnBean> arrayList3 = this.V;
            this.a0 = arrayList3.get(arrayList3.size() - 1);
            this.Y = this.X;
            T();
            return;
        }
        LogEx.e(this.p, "getColumnBeanList() is null !!!");
    }

    private void Y() {
        X();
        J();
    }

    private void Z() {
        ColumnBean columnBean = this.Y;
        if (columnBean != null && this.Z != null && TextUtils.equals(columnBean.getColumnName(), this.Z.getColumnName())) {
            ArrayList<Channel> arrayList = this.W;
            if (arrayList != null && arrayList.size() != 0) {
                this.L.setVisibility(0);
                return;
            } else {
                this.L.setVisibility(8);
                return;
            }
        }
        this.L.setVisibility(0);
    }

    private void a0() {
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.f(null, 0, this.d0));
        b0();
    }

    private void b0() {
        Channel channel = this.d0;
        if (channel != null) {
            if (TextUtils.equals(channel.getIsfavourite(), "1")) {
                ImageView imageView = this.v;
                if (imageView != null) {
                    imageView.setBackground(c.a.a.a.d.b.d().d(R.drawable.function_fav_selected));
                    this.h.a(this.v, "background", R.drawable.function_fav_selected);
                    return;
                }
                return;
            }
            ImageView imageView2 = this.v;
            if (imageView2 != null) {
                imageView2.setBackground(c.a.a.a.d.b.d().d(R.drawable.function_fav_normal));
                this.h.a(this.v, "background", R.drawable.function_fav_normal);
            }
        }
    }

    private void c0() {
        List<com.zte.iptvclient.android.mobile.a0.b.h> list = this.f0;
        if (list == null || list.size() <= 0) {
            return;
        }
        int c2 = this.e0.c();
        List<com.zte.iptvclient.android.mobile.a0.b.h> list2 = this.f0;
        if (list2 != null && c2 < list2.size()) {
            ArrayList<Channel> arrayList = this.W;
            if (arrayList != null && arrayList.size() >= 1) {
                LogEx.d(this.p, "mProgramListViewPage onSelected setCurrentSelectedChannel");
                this.f0.get(c2).b(this.d0);
            } else {
                this.f0.get(c2).a((Channel) null);
            }
        }
        for (int i2 = 0; i2 < this.f0.size(); i2++) {
            if (i2 != c2) {
                ArrayList<Channel> arrayList2 = this.W;
                if (arrayList2 != null && arrayList2.size() >= 1) {
                    this.f0.get(i2).a(this.d0);
                } else {
                    this.f0.get(i2).a((Channel) null);
                }
            }
        }
    }

    private void d(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_detail_function_menu);
        this.r = linearLayout;
        this.s = (RelativeLayout) linearLayout.findViewById(R.id.rl_more_screen_watching);
        this.t = (ImageView) view.findViewById(R.id.iv_function_trailer);
        this.u = (ImageView) this.r.findViewById(R.id.iv_function_rating);
        this.v = (ImageView) this.r.findViewById(R.id.iv_function_favorite);
        ImageView imageView = (ImageView) this.r.findViewById(R.id.iv_function_play_push);
        this.x = imageView;
        imageView.setBackgroundResource(R.drawable.push_disable);
        this.x.setEnabled(false);
        this.w = (ImageView) this.r.findViewById(R.id.iv_function_download);
        this.y = (ImageView) this.r.findViewById(R.id.iv_function_share);
        this.z = (ImageView) this.r.findViewById(R.id.iv_function_comment);
        this.A = (ImageView) this.r.findViewById(R.id.iv_function_sort);
        this.B = (RelativeLayout) this.r.findViewById(R.id.rl_function_play_push);
        this.C = (RelativeLayout) this.r.findViewById(R.id.rl_function_favorite);
        this.D = (RelativeLayout) this.r.findViewById(R.id.rl_function_share);
        this.E = (RelativeLayout) this.r.findViewById(R.id.rl_function_comment);
        this.J0 = (LinearLayout) view.findViewById(R.id.ll_now_playing);
        this.F0 = (LinearLayout) view.findViewById(R.id.ll_play_now);
        this.G0 = (LinearLayout) view.findViewById(R.id.ll_today_empty);
        this.H0 = (TextView) view.findViewById(R.id.txt_program_name);
        this.I0 = (ImageView) view.findViewById(R.id.img_empty_tv);
        this.K0 = (TextView) view.findViewById(R.id.txt_program_duration);
        this.M0 = (ImageView) view.findViewById(R.id.img_tv);
        this.L0 = (TextView) view.findViewById(R.id.txt_program_title);
        this.N0 = (RelativeLayout) view.findViewById(R.id.rl_progressbar);
        this.O0 = (ProgressBar) view.findViewById(R.id.pb_playing_light);
        com.zte.iptvclient.common.uiframe.f.a(this.J0);
        com.zte.iptvclient.common.uiframe.f.a(this.L0);
        com.zte.iptvclient.common.uiframe.f.a(this.K0);
        com.zte.iptvclient.common.uiframe.f.a(this.M0);
        com.zte.iptvclient.common.uiframe.f.a(this.N0);
        com.zte.iptvclient.common.uiframe.f.a(this.O0);
        com.zte.iptvclient.common.uiframe.f.a(this.F0);
        com.zte.iptvclient.common.uiframe.f.a(this.G0);
        com.zte.iptvclient.common.uiframe.f.a(this.H0);
        com.zte.iptvclient.common.uiframe.f.a(this.I0);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.cl_program_item));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_program_describ));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_showdetail));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_playing));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_nowplaying));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_playing));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_empty_tv));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_tv));
        this.t.setVisibility(8);
        this.w.setVisibility(8);
        this.u.setVisibility(8);
        if ("1".equals(ConfigMgr.readPropertie("SupportFaceBook"))) {
            this.y.setVisibility(0);
        }
        this.F = (HorizontalScrollViewEx) view.findViewById(R.id.hs_column_view);
        this.G = (RelativeLayout) view.findViewById(R.id.rl_viewmore);
        this.J = (MagicIndicator) view.findViewById(R.id.hlv_date);
        if (TextUtils.equals("1", ConfigMgr.readPropertie("isShowTvColumnSort", "1"))) {
            this.A.setVisibility(0);
            this.G.setVisibility(0);
        } else {
            this.A.setVisibility(8);
            this.G.setVisibility(8);
        }
        this.K = (LinearLayout) view.findViewById(R.id.ll_page);
        this.L = (RecyclerView) view.findViewById(R.id.channel_list);
        this.e0 = (ViewPager) view.findViewById(R.id.program_view_vpager);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_program);
        this.n0 = linearLayout2;
        this.o0 = (LinearLayout) linearLayout2.findViewById(R.id.ll_program_edit_main);
        this.p0 = (GridView) this.n0.findViewById(R.id.gv_program_edit);
        TextView textView = (TextView) this.n0.findViewById(R.id.txt_ok);
        this.q0 = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.multiscreen_program_confirm));
        this.r0 = (LinearLayout) this.n0.findViewById(R.id.ll_add_window);
        if (TextUtils.equals("1", ConfigMgr.readPropertie("IsSupportHideSearchVOD"))) {
            this.r0.setVisibility(8);
        }
        this.s0 = (ImageView) this.r0.findViewById(R.id.img_add);
        TextView textView2 = (TextView) this.r0.findViewById(R.id.txt_add);
        this.t0 = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.add_vod_to_multiscreen_tip));
        com.zte.iptvclient.common.uiframe.f.a(this.n0);
        com.zte.iptvclient.common.uiframe.f.a(this.o0);
        com.zte.iptvclient.common.uiframe.f.a(this.p0);
        com.zte.iptvclient.common.uiframe.f.a(this.q0);
        com.zte.iptvclient.common.uiframe.f.a(this.r0);
        com.zte.iptvclient.common.uiframe.f.a(this.s0);
        com.zte.iptvclient.common.uiframe.f.a(this.t0);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        TextView textView3 = (TextView) this.s.findViewById(R.id.tv_more_screen_watching);
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.multi_play_title));
        com.zte.iptvclient.common.uiframe.f.a(textView3);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        com.zte.iptvclient.common.uiframe.f.a(this.D);
        com.zte.iptvclient.common.uiframe.f.a(this.E);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        Q();
        TextView textView4 = (TextView) view.findViewById(R.id.sort_txt);
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.column_sort_txt));
        com.zte.iptvclient.common.uiframe.f.a(this.F);
        com.zte.iptvclient.common.uiframe.f.a(this.G);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_tv_column_menu_layout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.view_more));
        com.zte.iptvclient.common.uiframe.f.a(textView4);
        com.zte.iptvclient.common.uiframe.f.a(this.J);
        com.zte.iptvclient.common.uiframe.f.a(this.K);
        com.zte.iptvclient.common.uiframe.f.a(this.L);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.middle_line));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.tag_bottom_line));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_bottom_line));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.tag_function_menu_line));
        com.zte.iptvclient.common.uiframe.f.a(this.e0);
        if ("1".equals(ConfigMgr.readPropertie("ForbiddenMulScreenPlay", "0"))) {
            this.s.setVisibility(8);
            this.n0.setVisibility(8);
        } else if (this.w0) {
            this.n0.setVisibility(0);
            this.r.setVisibility(8);
        } else {
            this.n0.setVisibility(8);
            this.r.setVisibility(0);
        }
        if (BaseApp.a(this.h)) {
            this.s.setVisibility(8);
        }
    }

    private void d0() {
        ColumnBean columnBean;
        LogEx.d(this.p, "updateCurrentChannelBySelectedColumn");
        HashMap<ColumnBean, ArrayList<Channel>> hashMap = this.b0;
        if (hashMap != null && hashMap.size() > 0 && (columnBean = this.Y) != null) {
            ArrayList<Channel> arrayList = this.b0.get(columnBean);
            this.W = arrayList;
            if (arrayList == null) {
                LogEx.e(this.p, "mListCurrentChannel is null");
                return;
            }
            if (arrayList.size() == 0) {
                this.v.setBackgroundResource(R.drawable.function_fav_display);
                this.v.setEnabled(false);
                this.y.setBackgroundResource(R.drawable.function_share_focus);
                this.y.setEnabled(false);
                this.z.setBackgroundResource(R.drawable.function_comment_normal_white);
                this.z.setEnabled(false);
            } else {
                this.v.setBackgroundResource(R.drawable.function_fav_normal);
                this.v.setEnabled(true);
                this.y.setBackgroundResource(R.drawable.function_share_normal);
                this.y.setEnabled(true);
                this.z.setBackgroundResource(R.drawable.function_comment_normal);
                this.z.setEnabled(true);
            }
            if (TextUtils.equals(this.Y.getColumnCode(), this.C0)) {
                com.zte.iptvclient.android.common.j.b.e().a(this.W);
                this.W = com.zte.iptvclient.android.common.j.b.e().a();
                LogEx.d(this.p, "mListCurrentChannel=" + this.W.size() + "; >" + this.Y.getColumnName());
            }
            com.zte.iptvclient.android.mobile.a0.a.e.a aVar = this.c0;
            if (aVar == null) {
                Fragment parentFragment = getParentFragment();
                this.c0 = new com.zte.iptvclient.android.mobile.a0.a.e.a(this.h, this.W, this.q, parentFragment != null && (parentFragment instanceof com.zte.iptvclient.android.mobile.a0.b.g));
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.h);
                this.y0 = linearLayoutManager;
                this.L.a(linearLayoutManager);
                this.L.a(this.c0);
                this.c0.d();
                this.c0.b(this.w0);
            } else if (this.W != aVar.e()) {
                this.c0.a(this.W);
            }
            ArrayList<Channel> arrayList2 = this.W;
            if (arrayList2 != null && arrayList2.size() > 0) {
                if (this.d0 == null) {
                    this.d0 = this.W.get(0);
                }
            } else {
                LogEx.d(this.p, "swicth current Channel= nullselectedChnnelcode is null");
                this.d0 = null;
            }
            Channel channel = this.d0;
            if (channel != null && this.Y != null) {
                if (!TextUtils.equals(channel.getChannelname(), this.Y.getColumnName())) {
                    s(this.d0.getChannelcode());
                }
                a0();
            }
            this.X = this.Y;
            List<com.zte.iptvclient.android.mobile.a0.b.h> list = this.f0;
            if (list != null && this.e0 != null && list.size() > this.e0.c()) {
                this.f0.get(this.e0.c()).a(this.Y);
            }
            O();
        }
        Z();
    }

    private void e(String str, String str2) {
        ArrayList<Channel> arrayList;
        int i2 = 0;
        while (true) {
            if (i2 >= this.V.size()) {
                break;
            }
            if (TextUtils.equals(str, "radio")) {
                this.Q = this.V.size() - 1;
                ArrayList<ColumnBean> arrayList2 = this.V;
                this.Y = arrayList2.get(arrayList2.size() - 1);
                break;
            } else {
                if (TextUtils.equals(this.V.get(i2).getColumnCode(), str)) {
                    this.Q = i2;
                    this.Y = this.V.get(i2);
                    break;
                }
                i2++;
            }
        }
        if (this.Q < this.V.size()) {
            this.F.a(this.Q, true);
            this.Y = this.V.get(this.Q);
            HashMap<ColumnBean, ArrayList<Channel>> hashMap = this.b0;
            if (hashMap == null || hashMap.size() <= 0 || (arrayList = this.b0.get(this.Y)) == null) {
                return;
            }
            if (!arrayList.equals(this.c0.e())) {
                this.c0.a(arrayList);
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (TextUtils.equals(arrayList.get(i3).getChannelcode(), str2)) {
                    this.d0 = arrayList.get(i3);
                    LogEx.d(this.p, "swicth current Channel=" + this.d0.getChannelname() + "selectedChnnelcode=" + str2);
                    this.c0.e(i3);
                    d(i3);
                    return;
                }
            }
        }
    }

    private void f(View view) {
        String str;
        String channelcode;
        if (this.d0 == null) {
            return;
        }
        String c2 = com.zte.iptvclient.common.uiframe.a.c("EAS_Domain");
        LogEx.d(this.p, "eas_dns=" + c2);
        String c3 = com.zte.iptvclient.common.uiframe.a.c("Share_Link_Address");
        String channelname = this.d0.getChannelname();
        String str2 = "";
        String prevuename = !TextUtils.isEmpty(this.d0.getPrevuename()) ? this.d0.getPrevuename() : "";
        int i2 = 0;
        if (this.m0 != null) {
            str = c3 + "?vt=4&vc=" + this.m0.getPrevuecode();
            prevuename = this.m0.getPrevuename();
            str2 = this.m0.getPosterfilelist();
            if (!TextUtils.isEmpty(str2)) {
                str2 = com.zte.iptvclient.android.common.k.g.b(BaseApp.a(this.h) ? 9 : 3, str2);
            }
            if (TextUtils.isEmpty(str2)) {
                String[] split = this.d0.getPosterimage().split("/");
                int length = split.length;
                while (i2 < length) {
                    str2 = split[3];
                    i2++;
                }
            }
            channelcode = this.m0.getPrevuecode();
        } else {
            str = c3 + "?vt=2&vc=" + this.d0.getChannelcode();
            String[] split2 = this.d0.getPosterimage().split("/");
            int length2 = split2.length;
            while (i2 < length2) {
                str2 = split2[3];
                i2++;
            }
            channelcode = this.d0.getChannelcode();
        }
        new com.zte.iptvclient.android.mobile.x.b.c.c(this.h, channelname, str, str2, com.zte.iptvclient.android.common.i.a.a.a(R.string.let_us_watch) + " " + prevuename + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.on_app_click_link_below), this.k0, null, channelcode).a(view);
    }

    private void t(String str) {
        try {
            Date parse = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).parse(str);
            String format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(parse);
            LogEx.d(this.p, "mStrCurrentstartDate=" + parse);
            for (int i2 = 0; i2 < this.M.size(); i2++) {
                if (TextUtils.equals(this.M.get(i2), format)) {
                    this.O = i2;
                    this.N = this.M.get(i2);
                    this.e0.d(this.O);
                    LogEx.d(this.p, "mStrCurrentDate=" + this.N + " selectedDateIndex=" + this.O);
                    return;
                }
            }
        } catch (Exception e2) {
            LogEx.e(this.p, e2.getMessage());
        }
    }

    public boolean I() {
        return getResources().getConfiguration().orientation == 2;
    }

    public void J() {
        ArrayList<ColumnBean> arrayList = this.V;
        if (arrayList != null && arrayList.size() >= 1) {
            ArrayList<Channel> arrayList2 = this.R;
            if (arrayList2 == null) {
                this.R = new ArrayList<>();
            } else {
                arrayList2.clear();
            }
            ArrayList<Channel> arrayList3 = this.T;
            if (arrayList3 == null) {
                this.T = new ArrayList<>();
            } else {
                arrayList3.clear();
            }
            this.T.addAll(com.zte.iptvclient.android.common.j.i.d().a());
            this.R.addAll(com.zte.iptvclient.android.common.j.i.d().b());
            ArrayList<Channel> arrayList4 = this.R;
            if (arrayList4 != null && arrayList4.size() > 0) {
                this.b0 = new HashMap<>();
                Iterator<ColumnBean> it2 = this.V.iterator();
                while (it2.hasNext()) {
                    ColumnBean next = it2.next();
                    ArrayList<Channel> arrayList5 = new ArrayList<>();
                    Iterator<Channel> it3 = this.R.iterator();
                    while (it3.hasNext()) {
                        Channel next2 = it3.next();
                        if (TextUtils.equals(next.getColumnCode(), next2.getColumncode())) {
                            arrayList5.add(next2);
                        }
                    }
                    LogEx.d(this.p, "sort columnName=" + next.getColumnName() + "; " + next.getColumnCode() + ">>>" + arrayList5.size());
                    this.b0.put(next, arrayList5);
                }
                this.b0.put(this.a0, this.T);
                L();
                d0();
                R();
                c0();
                return;
            }
            LogEx.e(this.p, "getTVALLChannelList() is null !!!");
            return;
        }
        LogEx.d(this.p, " mListColumn  is null!");
    }

    public void K() {
        U();
        Y();
        W();
        this.V0.postDelayed(this.W0, 500L);
    }

    public void L() {
        new Thread(this.X0).start();
    }

    public void M() {
        if (this.d0 != null) {
            String str = this.C0;
            ColumnBean columnBean = this.Y;
            if (columnBean != null && !TextUtils.equals(str, columnBean.getColumnCode())) {
                str = this.Y.getColumnCode();
            }
            LogEx.d(this.p, "current selectedChnnelcode=" + this.d0.getChannelcode());
            e(str, this.d0.getChannelcode());
            R();
            t(new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(com.zte.iptvclient.android.common.k.s.b()));
            int c2 = this.e0.c();
            List<com.zte.iptvclient.android.mobile.a0.b.h> list = this.f0;
            if (list == null || c2 >= list.size()) {
                return;
            }
            this.f0.get(c2).a(this.w0);
            this.f0.get(c2).b(this.d0);
        }
    }

    public void N() {
        ArrayList<ColumnBean> arrayList = this.V;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.V.size(); i2++) {
            if (!TextUtils.isEmpty(this.V.get(i2).getColumnCode()) && this.V.get(i2).getColumnCode().equalsIgnoreCase(this.Y.getColumnCode())) {
                this.Q = i2;
                return;
            }
        }
    }

    public void O() {
        if (this.W == null || this.c0 == null) {
            return;
        }
        for (int i2 = 0; i2 < this.W.size(); i2++) {
            this.W.get(i2).setIsChannelLock("0");
            this.W.get(i2).setAfterChannelLock("0");
        }
        HashMap<String, String> a2 = com.zte.iptvclient.android.common.j.e.b().a();
        if (a2 != null && a2.size() != 0) {
            for (String str : a2.keySet()) {
                for (int i3 = 0; i3 < this.W.size(); i3++) {
                    if (TextUtils.equals(str, this.W.get(i3).getChannelcode())) {
                        this.W.get(i3).setIsChannelLock("1");
                        this.W.get(i3).setAfterChannelLock("1");
                    }
                }
            }
        }
        for (int i4 = 0; i4 < this.W.size(); i4++) {
            if (com.zte.iptvclient.android.mobile.f.b.a.b(this.W.get(i4).getRatingid(), this.h)) {
                this.W.get(i4).setIsChannelLock("1");
                this.W.get(i4).setAfterChannelLock("1");
            }
        }
        this.c0.d();
    }

    public void s(String str) {
        boolean z2;
        ArrayList<Channel> arrayList = this.W;
        if (arrayList == null || str == null) {
            return;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                z2 = false;
                break;
            }
            if (this.W.get(i2) != null && TextUtils.equals(str, this.W.get(i2).getChannelcode())) {
                this.c0.e(i2);
                this.z0 = i2;
                this.d0 = this.W.get(i2);
                LogEx.d(this.p, "swicth current Channel=" + this.d0.getChannelname());
                z2 = true;
                break;
            }
            i2++;
        }
        if (!z2 && this.W.size() > 0) {
            this.d0 = this.W.get(0);
            LogEx.d(this.p, "swicth current Channel=" + this.d0.getChannelname());
            this.c0.e(0);
            this.z0 = 0;
            if (!this.w0) {
                LogEx.d(this.p, "sendPlayLiveTVQueryEvent");
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(true, this.d0.getChannelcode(), this.d0.getColumncode()));
            }
        }
        d(this.z0);
    }

    public void c(boolean z2) {
        if (z2) {
            ImageView imageView = this.x;
            if (imageView != null) {
                imageView.setBackgroundResource(R.drawable.play_push_new);
                this.x.setEnabled(true);
                return;
            }
            return;
        }
        ImageView imageView2 = this.x;
        if (imageView2 != null) {
            imageView2.setBackgroundResource(R.drawable.push_disable);
            this.x.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<Channel> arrayList) {
        if (this.b0 != null) {
            LogEx.d(this.p, " mFavoriteColumnBean >>>" + arrayList.size());
            this.b0.put(this.Z, arrayList);
        }
        ColumnBean columnBean = this.Y;
        if (columnBean != null && this.Z != null && TextUtils.equals(columnBean.getColumnName(), this.Z.getColumnName())) {
            d0();
            c0();
        }
        Iterator<Channel> it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Channel next = it2.next();
            Channel channel = this.d0;
            if (channel != null && TextUtils.equals(channel.getChannelcode(), next.getChannelcode())) {
                this.d0.setIsfavourite("1");
                break;
            }
            LogEx.e(this.p, "mCurSelectedChannel is null or mCurSelectedChannel has not in favorteList!");
        }
        b0();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.f fVar) {
        if (fVar.c() != null) {
            String posterimage = fVar.c().getPosterimage();
            if (fVar.b() != null) {
                this.F0.setVisibility(0);
                this.G0.setVisibility(8);
                this.P0 = fVar.b();
                int a2 = fVar.a();
                this.Q0 = a2;
                this.O0.setProgress(a2);
                this.K0.setText(this.P0.getDuration());
                this.L0.setText(this.P0.getPrevuename());
                if (TextUtils.isEmpty(posterimage)) {
                    return;
                }
                int indexOf = posterimage.indexOf("/image", 1);
                String str = com.zte.iptvclient.android.common.f.b.i.g() + posterimage.substring(indexOf);
                SupportActivity supportActivity = this.h;
                if (supportActivity != null && !supportActivity.isFinishing()) {
                    com.bumptech.glide.d<String> a3 = com.bumptech.glide.i.a((FragmentActivity) this.h).a(str);
                    a3.a(R.drawable.default_video_thumb);
                    a3.b(126, 94);
                    a3.a(this.M0);
                    return;
                }
                this.M0.setImageResource(R.drawable.default_video_thumb);
                return;
            }
            this.H0.setText(fVar.c().getChannelname());
            if (!TextUtils.isEmpty(posterimage)) {
                int indexOf2 = posterimage.indexOf("/image", 1);
                String str2 = com.zte.iptvclient.android.common.f.b.i.g() + posterimage.substring(indexOf2);
                SupportActivity supportActivity2 = this.h;
                if (supportActivity2 != null && !supportActivity2.isFinishing()) {
                    com.bumptech.glide.d<String> a4 = com.bumptech.glide.i.a((FragmentActivity) this.h).a(str2);
                    a4.a(R.drawable.default_video_thumb);
                    a4.b(126, 94);
                    a4.a(this.I0);
                } else {
                    this.I0.setImageResource(R.drawable.default_video_thumb);
                }
            }
            this.F0.setVisibility(8);
            this.G0.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ColumnBean columnBean) {
        if (TextUtils.equals(columnBean.getColumnName(), this.Z.getColumnName()) && !com.zte.iptvclient.android.mobile.n.c.b.t()) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            com.zte.iptvclient.android.common.k.t.a(this.h, new C0173b(this));
            this.F.a(this.Q);
            return;
        }
        if (TextUtils.equals(columnBean.getColumnName(), this.a0.getColumnName())) {
            this.B.setVisibility(8);
            this.C.setVisibility(8);
            this.D.setVisibility(8);
        } else {
            this.B.setVisibility(0);
            this.C.setVisibility(0);
            this.D.setVisibility(0);
        }
        L();
        d0();
        R();
        c0();
        O();
    }

    public void b(boolean z2) {
        for (int i2 = 0; i2 < this.f0.size(); i2++) {
            this.f0.get(i2).b(z2);
        }
        com.zte.iptvclient.android.mobile.a0.a.e.a aVar = this.c0;
        if (aVar != null) {
            aVar.b(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view) {
        f(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Channel channel) {
        LogEx.d(this.p, "current channel is  sdkDelFavorite channel" + channel.getChannelcode());
        SDKFavoriteMgr sDKFavoriteMgr = new SDKFavoriteMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(ParamConst.FAVORITE_DELETE_BATCH_REQ_FAVORITETYPES, DownloadConstant.REPORT_MSGTYPE_ADD);
        hashMap.put("contentcodes", channel.getChannelcode());
        hashMap.put("columncodes", this.C0);
        sDKFavoriteMgr.doDelFavorite(hashMap, new q(channel));
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
        for (int i2 = 0; i2 < this.v0.size(); i2++) {
            if (TextUtils.equals(this.v0.get(i2).d(), cVar.L1())) {
                this.v0.get(i2).b(String.valueOf(cVar.O1() / 1000));
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Channel channel) {
        LogEx.d(this.p, "current channel is  sdkAddFavorite channel" + channel.getChannelcode());
        SDKFavoriteMgr sDKFavoriteMgr = new SDKFavoriteMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("favoritetype", DownloadConstant.REPORT_MSGTYPE_ADD);
        hashMap.put("contentcode", channel.getChannelcode());
        hashMap.put("columncode", this.C0);
        sDKFavoriteMgr.doAddFavorite(hashMap, new p(channel));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.r rVar) {
        LogEx.d(this.p, "TvDataQueryFinishedEvent get AllChannel and ColumnList!");
        ArrayList<ColumnBean> arrayList = this.V;
        if (arrayList == null || this.R == null || arrayList.size() <= 0 || this.R.size() <= 0) {
            K();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.a aVar) {
        Y();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.n.e eVar) {
        if ("LiveTvFragment".equalsIgnoreCase(eVar.a())) {
            boolean c2 = eVar.c();
            int b2 = eVar.b();
            if (c2) {
                T();
                N();
                if (b2 != 0 && b2 < this.V.size()) {
                    this.Y = this.V.get(b2);
                    new Handler().postDelayed(new t(b2), 200L);
                } else if (this.V.size() > 1) {
                    this.Y = this.V.get(1);
                    new Handler().postDelayed(new u(), 200L);
                }
                d0();
                R();
                c0();
            } else {
                if (b2 != 0 && b2 < this.V.size()) {
                    this.Y = this.V.get(b2);
                    new Handler().postDelayed(new v(b2), 200L);
                } else if (this.V.size() > 1) {
                    this.Y = this.V.get(1);
                    new Handler().postDelayed(new w(), 200L);
                }
                d0();
                R();
                c0();
            }
        }
        if ("LiveTvChannels".equalsIgnoreCase(eVar.a())) {
            boolean c3 = eVar.c();
            int b3 = eVar.b();
            if (!c3) {
                if (b3 != -1) {
                    this.z0 = b3;
                    s(this.W.get(b3).getChannelcode());
                    this.c0.e(this.z0);
                    EventBus eventBus = EventBus.getDefault();
                    int i2 = this.z0;
                    eventBus.post(new com.zte.iptvclient.android.common.e.x.b(i2, this.w0, true, this.W.get(i2).getChannelcode()));
                    d0();
                    c0();
                    return;
                }
                return;
            }
            if (b3 != -1) {
                this.z0 = 0;
                this.c0.e(0);
                s(this.W.get(this.z0).getChannelcode());
                EventBus eventBus2 = EventBus.getDefault();
                int i3 = this.z0;
                eventBus2.post(new com.zte.iptvclient.android.common.e.x.b(i3, this.w0, true, this.W.get(i3).getChannelcode()));
            } else {
                s(this.d0.getChannelcode());
                this.c0.e(this.z0);
            }
            ArrayList<Channel> arrayList = this.U;
            if (arrayList == null) {
                this.U = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            this.U.addAll(com.zte.iptvclient.android.common.j.i.d().b());
            d0();
            c0();
        }
    }

    public void a(String str, String str2, String str3, boolean z2) {
        Channel channel = this.d0;
        if (channel != null) {
            this.R0 = str;
            this.T0 = str2;
            this.S0 = str3;
            this.U0 = z2;
            if (!TextUtils.equals(channel.getChannelcode(), str2) || this.O >= this.f0.size()) {
                return;
            }
            LogEx.d(this.p, "playNextTvod prevuecode " + str);
            this.f0.get(this.O).a(str, str2, str3, z2, false);
        }
    }

    public void a(y yVar) {
        this.u0 = yVar;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.g gVar) {
        V();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.a aVar) {
        this.d0.setAuthid(aVar.a());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.b bVar) {
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a() || bVar == null) {
            return;
        }
        t(new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(com.zte.iptvclient.android.common.k.s.b()));
        int a2 = bVar.a();
        String b2 = bVar.b();
        boolean z2 = false;
        for (int i2 = 0; i2 < this.W.size(); i2++) {
            if (TextUtils.equals(b2, this.W.get(i2).getChannelcode())) {
                z2 = true;
            }
        }
        if (z2) {
            if (!bVar.c()) {
                LogEx.d(this.p, "sendPlayLiveTVQueryEvent");
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(true, this.W.get(a2).getChannelcode(), this.W.get(a2).getColumncode()));
                com.zte.iptvclient.android.mobile.a0.a.e.a aVar = this.c0;
                if (aVar != null) {
                    aVar.e(a2);
                }
                this.d0 = this.W.get(a2);
                this.e0.c();
                b0();
            }
            Fragment parentFragment = getParentFragment();
            if (parentFragment == null || !(parentFragment instanceof com.zte.iptvclient.android.mobile.a0.b.g) || bVar.d()) {
                this.d0 = this.W.get(a2);
                LogEx.d(this.p, "swicth current Channel=" + this.d0.getChannelname());
                com.zte.iptvclient.android.mobile.a0.a.e.a aVar2 = this.c0;
                if (aVar2 != null) {
                    aVar2.e(a2);
                }
                int c2 = this.e0.c();
                List<com.zte.iptvclient.android.mobile.a0.b.h> list = this.f0;
                if (list != null && c2 < list.size()) {
                    this.f0.get(c2).a(this.w0);
                    this.f0.get(c2).b(this.d0);
                }
                a0();
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.e eVar) {
        if (eVar.a()) {
            return;
        }
        int c2 = this.e0.c();
        LogEx.e(this.p, "exit from full Screen  " + c2);
        List<com.zte.iptvclient.android.mobile.a0.b.h> list = this.f0;
        if (list == null || c2 >= list.size()) {
            return;
        }
        this.f0.get(c2).a(this.w0);
        this.f0.get(c2).d();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.y.b bVar) {
        com.zte.iptvclient.android.common.player.i.a aVar = this.x0;
        if (aVar != null) {
            aVar.a(this.q);
            this.x0.notifyDataSetChanged();
        }
        int c2 = this.e0.c();
        List<com.zte.iptvclient.android.mobile.a0.b.h> list = this.f0;
        if (list == null || c2 >= list.size()) {
            return;
        }
        this.f0.get(c2).a(true);
    }

    private void d(int i2) {
        LogEx.d(this.p, "moveToChannelListPosition N =" + i2);
        this.L.j(i2);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.e eVar) {
        String channelcode;
        String str;
        LogEx.d(this.p, " recve InPlayerSwitchChannelEvent");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null || !(parentFragment instanceof com.zte.iptvclient.android.mobile.a0.b.g)) {
            return;
        }
        if (!TextUtils.isEmpty(eVar.a())) {
            channelcode = eVar.a();
        } else {
            Channel channel = this.d0;
            channelcode = channel != null ? channel.getChannelcode() : "";
        }
        if (!TextUtils.isEmpty(eVar.b())) {
            str = eVar.b();
        } else {
            str = this.C0;
        }
        LogEx.d(this.p, "get SearchData columncode=" + str + " selectedChnnelcode=" + channelcode);
        int i2 = 0;
        while (true) {
            if (i2 >= this.W.size()) {
                break;
            }
            if (TextUtils.equals(this.W.get(i2).getChannelcode(), channelcode)) {
                this.d0 = this.W.get(i2);
                break;
            }
            i2++;
        }
        LogEx.d(this.p, "swicth current InPlayerSwitchChannelEvent Channel=" + channelcode);
        Date b2 = com.zte.iptvclient.android.common.k.s.b();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);
        e(str, channelcode);
        t(simpleDateFormat.format(b2));
        d0();
        c0();
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(true, channelcode, str));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.o oVar) {
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null || !(parentFragment instanceof com.zte.iptvclient.android.mobile.a0.b.g)) {
            return;
        }
        PrevueBean b2 = oVar.b();
        e(this.C0, b2.getChannelcode());
        LogEx.d(this.p, "get SearchData columncode=" + this.C0 + " selectedChnnelcode=" + b2.getChannelcode() + " date=" + b2.getBegintime());
        t(b2.getBegintime());
        d0();
        com.zte.iptvclient.android.common.javabean.e.f4730a = false;
        com.zte.iptvclient.android.common.javabean.e.f4731b = b2;
        c0();
        if (oVar.a()) {
            return;
        }
        Date date = new Date();
        Date date2 = new Date();
        try {
            date = com.zte.iptvclient.android.common.k.x.a(b2.getEndtime(), new SimpleDateFormat("yyyyMMddHHmmss"));
            date2 = com.zte.iptvclient.android.common.k.x.a(b2.getBegintime(), new SimpleDateFormat("yyyyMMddHHmmss"));
        } catch (Exception e2) {
            LogEx.e(this.p, e2.getMessage());
        }
        if (this.d0 != null && com.zte.iptvclient.android.common.j.i.d().a(date2, date, this.d0.getMixno())) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(this.h.getResources().getString(R.string.program_playbcak).replace("hour", com.zte.iptvclient.android.common.j.i.d().b(this.d0.getMixno())));
        } else {
            new Timer().schedule(new x(this, b2), 1000L);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.b bVar) {
        this.l0 = false;
        PrevueBean a2 = bVar.a();
        this.m0 = a2;
        this.E0 = DownloadConstant.REPORT_MSGTYPE_ADD;
        this.D0 = a2.getPrevuecode();
        com.zte.iptvclient.android.common.javabean.e.f4731b = this.m0;
        com.zte.iptvclient.android.common.javabean.e.f4730a = false;
        c(false);
        List<com.zte.iptvclient.android.mobile.a0.b.h> list = this.f0;
        if (list != null && this.e0 != null && list.size() > this.e0.c()) {
            this.f0.get(this.e0.c()).f();
        }
        if (this.e0 != null) {
            t(this.m0.getBegintime());
            int c2 = this.e0.c();
            LogEx.e(this.p, "exit from full Screen  " + c2);
            List<com.zte.iptvclient.android.mobile.a0.b.h> list2 = this.f0;
            if (list2 == null || c2 >= list2.size()) {
                return;
            }
            this.f0.get(c2).a(this.w0);
            this.f0.get(c2).d();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.g gVar) {
        this.E0 = "0";
        this.D0 = gVar.b();
        this.l0 = true;
        com.zte.iptvclient.android.common.javabean.e.f4731b = null;
        com.zte.iptvclient.android.common.javabean.e.f4730a = true;
        c(false);
        List<com.zte.iptvclient.android.mobile.a0.b.h> list = this.f0;
        if (list != null && this.e0 != null && list.size() > this.e0.c()) {
            this.e0.d(this.O);
            this.f0.get(this.O).f();
        }
        this.m0 = null;
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.f fVar) {
        com.zte.iptvclient.android.common.player.i.a aVar = this.x0;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        if (TextUtils.equals(cVar.a(), "0")) {
            this.C0 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL);
            Q();
            ArrayList<String> arrayList = this.M;
            if (arrayList == null || arrayList.size() <= 0) {
                W();
            }
        }
    }
}
