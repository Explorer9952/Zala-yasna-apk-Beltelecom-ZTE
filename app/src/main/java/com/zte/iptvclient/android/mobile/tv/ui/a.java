package com.zte.iptvclient.android.mobile.tv.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.favorite.SDKFavoriteMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.scrollview.HorizontalScrollViewEx;
import com.zte.iptvclient.android.common.e.x.o;
import com.zte.iptvclient.android.common.e.x.r;
import com.zte.iptvclient.android.common.javabean.column.ColumnBean;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.tv.activity.ColumnSortActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TvChannelsWithColumnView.java */
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private String A;
    private ColumnBean B;
    private ColumnBean C;
    private ColumnBean D;
    private ColumnBean E;
    private HashMap<ColumnBean, ArrayList<Channel>> F;
    private com.zte.iptvclient.android.mobile.a0.a.e.a G;
    private Channel J;
    private int K;
    private int L;
    private String M;
    private PrevueBean N;
    private m O;
    private GridLayoutManager P;
    private String Q;

    /* renamed from: a, reason: collision with root package name */
    private String f7285a;

    /* renamed from: b, reason: collision with root package name */
    private Context f7286b;

    /* renamed from: c, reason: collision with root package name */
    private SupportActivity f7287c;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f7288d;
    private RelativeLayout e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private ImageView m;
    private RelativeLayout n;
    private RelativeLayout o;
    private RelativeLayout p;
    private RelativeLayout q;
    private HorizontalScrollViewEx r;
    private RelativeLayout s;
    private RecyclerView t;
    private ArrayList<Channel> u;
    private ArrayList<Channel> v;
    private ArrayList<Channel> w;
    private ArrayList<ColumnBean> x;
    private ArrayList<Channel> y;
    private String z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChannelsWithColumnView.java */
    /* renamed from: com.zte.iptvclient.android.mobile.tv.ui.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0354a implements t.d {
        C0354a() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.d
        public void onDismiss() {
        }
    }

    /* compiled from: TvChannelsWithColumnView.java */
    /* loaded from: classes2.dex */
    class b extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ o f7290a;

        b(o oVar) {
            this.f7290a = oVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.b(this.f7290a.b(), true));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChannelsWithColumnView.java */
    /* loaded from: classes2.dex */
    public class c implements SDKFavoriteMgr.OnUserFavoriteListReturnListener {
        c() {
        }

        @Override // com.video.androidsdk.service.favorite.SDKFavoriteMgr.OnUserFavoriteListReturnListener
        public void onUserFavoriteListReturn(String str, String str2, String str3) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            try {
                LogEx.d(a.this.f7285a, "getUserFavoriteList returncode is " + str + "   errormsg is " + str2 + ",msg is " + str3);
                JSONObject jSONObject = new JSONObject(str3);
                if ("0".equals(jSONObject.optString("returncode"))) {
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    if (arrayList.size() > 0) {
                        arrayList.clear();
                    }
                    if (arrayList2.size() > 0) {
                        arrayList2.clear();
                    }
                    a.this.v = new ArrayList();
                    a.this.v = com.zte.iptvclient.android.common.j.i.d().c();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        for (int i2 = 0; i2 < a.this.v.size(); i2++) {
                            if (TextUtils.equals(((Channel) a.this.v.get(i2)).getChannelcode(), jSONObject2.getString("contentcode"))) {
                                ((Channel) a.this.v.get(i2)).setIsfavourite("1");
                                arrayList.add(a.this.v.get(i2));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                LogEx.e(a.this.f7285a, "query channel favorite: " + e.getMessage());
            }
            if (a.this.v != null) {
                for (int i3 = 0; i3 < a.this.v.size(); i3++) {
                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                        if (TextUtils.equals(((Channel) a.this.v.get(i3)).getChannelcode(), ((Channel) arrayList.get(i4)).getChannelcode())) {
                            arrayList2.add(arrayList.get(i4));
                        }
                    }
                }
            }
            a.this.a((ArrayList<Channel>) arrayList2);
            LogEx.d(a.this.f7285a, " sdkQueryFavoriteChannelList finish");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChannelsWithColumnView.java */
    /* loaded from: classes2.dex */
    public class d extends GridLayoutManager.b {
        d() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int b(int i) {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChannelsWithColumnView.java */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(a.this.f7287c, ColumnSortActivity.class);
            intent.putExtra("From", "LiveTvFragment");
            a.this.f7287c.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChannelsWithColumnView.java */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {

        /* compiled from: TvChannelsWithColumnView.java */
        /* renamed from: com.zte.iptvclient.android.mobile.tv.ui.a$f$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0355a implements t.d {
            C0355a(f fVar) {
            }

            @Override // com.zte.iptvclient.android.common.k.t.d
            public void onDismiss() {
            }
        }

        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.J == null) {
                return;
            }
            if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                t.a(a.this.f7287c, new C0355a(this));
            } else {
                if (com.zte.iptvclient.android.common.k.c.a() || a.this.J == null) {
                    return;
                }
                if (TextUtils.equals(a.this.J.getIsfavourite(), "1")) {
                    a aVar = a.this;
                    aVar.c(aVar.J);
                } else {
                    a aVar2 = a.this;
                    aVar2.b(aVar2.J);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChannelsWithColumnView.java */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {

        /* compiled from: TvChannelsWithColumnView.java */
        /* renamed from: com.zte.iptvclient.android.mobile.tv.ui.a$g$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0356a implements t.d {
            C0356a(g gVar) {
            }

            @Override // com.zte.iptvclient.android.common.k.t.d
            public void onDismiss() {
            }
        }

        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zte.iptvclient.android.common.player.k.c t;
            if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                t.a(a.this.f7287c, new C0356a(this));
            } else {
                if (com.zte.iptvclient.android.common.k.c.a() || a.this.J == null || (t = ((MainActivity) a.this.f7287c).t()) == null) {
                    return;
                }
                com.zte.iptvclient.android.common.e.r.g gVar = new com.zte.iptvclient.android.common.e.r.g();
                gVar.a(a.this.z);
                gVar.d(a.this.A);
                gVar.b(a.this.J.getMixno());
                t.a(gVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChannelsWithColumnView.java */
    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ("1".equals(ConfigMgr.readPropertie("isShowInConstructionTip"))) {
                t.a(a.this.f7287c);
            } else {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                a.this.a(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChannelsWithColumnView.java */
    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.m());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChannelsWithColumnView.java */
    /* loaded from: classes2.dex */
    public class j implements HorizontalScrollViewEx.a {
        j() {
        }

        @Override // com.zte.iptvclient.android.common.customview.viewgroup.scrollview.HorizontalScrollViewEx.a
        public void a(int i) {
            if (i < a.this.x.size()) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.f());
                a aVar = a.this;
                aVar.C = (ColumnBean) aVar.x.get(i);
                a aVar2 = a.this;
                aVar2.a(aVar2.C);
                a.this.L = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChannelsWithColumnView.java */
    /* loaded from: classes2.dex */
    public class k implements SDKFavoriteMgr.OnAddFavoriteReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Channel f7300a;

        k(Channel channel) {
            this.f7300a = channel;
        }

        @Override // com.video.androidsdk.service.favorite.SDKFavoriteMgr.OnAddFavoriteReturnListener
        public void onAddFavoriteReturn(String str, String str2) {
            LogEx.d(a.this.f7285a, "onAddFavoriteReturn returncode=" + str + " errormsg=" + str2);
            if (!TextUtils.equals(str, "0")) {
                LogEx.w(a.this.f7285a, str2);
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.add_favourite_msg5);
                return;
            }
            if (a.this.J != null && TextUtils.equals(a.this.J.getChannelcode(), this.f7300a.getChannelcode())) {
                a.this.J.setIsfavourite("1");
            }
            if (a.this.h != null) {
                a.this.h.setBackground(c.a.a.a.d.b.d().d(R.drawable.function_fav_selected));
            }
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.m.a());
            a.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChannelsWithColumnView.java */
    /* loaded from: classes2.dex */
    public class l implements SDKFavoriteMgr.OnDelFavoriteReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Channel f7302a;

        l(Channel channel) {
            this.f7302a = channel;
        }

        @Override // com.video.androidsdk.service.favorite.SDKFavoriteMgr.OnDelFavoriteReturnListener
        public void onDelFavoriteReturn(String str, String str2) {
            LogEx.d(a.this.f7285a, " del favorite channel , returncode : " + str + ", errormsg : " + str2);
            if (!TextUtils.equals(str, "0")) {
                LogEx.w(a.this.f7285a, str2);
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.del_favorite_channel_fail);
                return;
            }
            if (a.this.J != null && TextUtils.equals(a.this.J.getChannelcode(), this.f7302a.getChannelcode())) {
                a.this.J.setIsfavourite("0");
            }
            if (a.this.h != null) {
                a.this.h.setBackground(c.a.a.a.d.b.d().d(R.drawable.function_fav_normal));
            }
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.m.a());
            a.this.a();
        }
    }

    /* compiled from: TvChannelsWithColumnView.java */
    /* loaded from: classes.dex */
    public interface m {
        void a(ColumnBean columnBean, Channel channel);

        void d();
    }

    public a(Context context, SupportActivity supportActivity, m mVar) {
        super(context);
        this.f7285a = "TvChannelsWithColumnView";
        this.z = "";
        this.A = "";
        this.K = 0;
        this.L = 1;
        this.f7286b = context;
        this.f7287c = supportActivity;
        this.O = mVar;
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        i();
        h();
        l();
        j();
    }

    private void j() {
        e();
        d();
        k();
    }

    private void k() {
        if (this.y == null || this.G == null) {
            return;
        }
        HashMap<String, String> a2 = com.zte.iptvclient.android.common.j.e.b().a();
        if (a2 != null && a2.size() != 0) {
            for (String str : a2.keySet()) {
                for (int i2 = 0; i2 < this.y.size(); i2++) {
                    if (TextUtils.equals(str, this.y.get(i2).getChannelcode())) {
                        this.y.get(i2).setIsChannelLock("1");
                        this.y.get(i2).setAfterChannelLock("1");
                    }
                }
            }
        }
        for (int i3 = 0; i3 < this.y.size(); i3++) {
            if (com.zte.iptvclient.android.mobile.f.b.a.b(this.y.get(i3).getRatingid(), this.f7287c)) {
                this.y.get(i3).setIsChannelLock("1");
                this.y.get(i3).setAfterChannelLock("1");
            }
        }
    }

    private void l() {
        this.s.setOnClickListener(new e());
        this.h.setOnClickListener(new f());
        this.j.setOnClickListener(new g());
        this.k.setOnClickListener(new h());
        this.l.setOnClickListener(new i());
    }

    private void m() {
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.f(null, 0, this.J));
        n();
    }

    private void n() {
        Channel channel = this.J;
        if (channel != null) {
            if (TextUtils.equals(channel.getIsfavourite(), "1")) {
                ImageView imageView = this.h;
                if (imageView != null) {
                    imageView.setBackground(c.a.a.a.d.b.d().d(R.drawable.function_fav_selected));
                    return;
                }
                return;
            }
            ImageView imageView2 = this.h;
            if (imageView2 != null) {
                imageView2.setBackground(c.a.a.a.d.b.d().d(R.drawable.function_fav_normal));
            }
        }
    }

    private void o() {
        LogEx.d(this.f7285a, "updateCurrentChannelData start");
        p();
        ArrayList<Channel> arrayList = this.y;
        if (arrayList == null || arrayList.size() < 1) {
            this.J = null;
        }
        m mVar = this.O;
        if (mVar != null) {
            mVar.a(this.C, this.J);
        }
        LogEx.d(this.f7285a, "updateCurrentChannelData finish");
    }

    private void p() {
        ColumnBean columnBean;
        HashMap<ColumnBean, ArrayList<Channel>> hashMap = this.F;
        if (hashMap == null || hashMap.size() <= 0 || (columnBean = this.C) == null) {
            return;
        }
        ArrayList<Channel> arrayList = this.F.get(columnBean);
        this.y = arrayList;
        if (arrayList == null) {
            LogEx.e(this.f7285a, "mListCurrentChannel is null");
            return;
        }
        if (arrayList.size() == 0) {
            this.h.setBackgroundResource(R.drawable.function_fav_display);
            this.h.setEnabled(false);
            this.k.setBackgroundResource(R.drawable.function_share_focus);
            this.k.setEnabled(false);
            this.l.setBackgroundResource(R.drawable.function_comment_normal_white);
            this.l.setEnabled(false);
        } else {
            this.h.setBackgroundResource(R.drawable.function_fav_normal);
            this.h.setEnabled(true);
            this.k.setBackgroundResource(R.drawable.function_share_normal);
            this.k.setEnabled(true);
            this.l.setBackgroundResource(R.drawable.function_comment_normal);
            this.l.setEnabled(true);
        }
        if (TextUtils.equals(this.C.getColumnCode(), this.M)) {
            com.zte.iptvclient.android.common.j.b.e().a(this.y);
            this.y = com.zte.iptvclient.android.common.j.b.e().a();
        }
        com.zte.iptvclient.android.mobile.a0.a.e.a aVar = new com.zte.iptvclient.android.mobile.a0.a.e.a(this.f7287c, this.y, 1, true);
        this.G = aVar;
        this.t.a(aVar);
        this.G.d();
        ArrayList<Channel> arrayList2 = this.y;
        if (arrayList2 != null && arrayList2.size() > 0) {
            if (this.J == null) {
                this.J = this.y.get(0);
            }
            LogEx.d(this.f7285a, "swicth current Channel=" + this.J.getChannelname() + "selectedChnnelcode " + this.J.getChannelcode());
            this.K = 0;
            a(0);
        } else {
            LogEx.d(this.f7285a, "swicth current Channel= nullselectedChnnelcode is null");
            this.J = null;
        }
        Channel channel = this.J;
        if (channel != null && this.C != null) {
            if (!TextUtils.equals(channel.getChannelname(), this.C.getColumnName())) {
                a(this.J);
            }
            m();
        }
        this.B = this.C;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        EventBus.getDefault().unregister(this);
        super.onDetachedFromWindow();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.a aVar) {
        j();
    }

    private void c() {
        if (com.zte.iptvclient.android.mobile.e0.f.b.b()) {
            this.q.setVisibility(0);
        } else {
            this.q.setVisibility(8);
        }
    }

    private void d() {
        LogEx.d(this.f7285a, " dealChannelList start");
        ArrayList<ColumnBean> arrayList = this.x;
        if (arrayList != null && arrayList.size() >= 1) {
            ArrayList<Channel> arrayList2 = this.w;
            if (arrayList2 == null) {
                this.w = new ArrayList<>();
            } else {
                arrayList2.clear();
            }
            this.w.addAll(com.zte.iptvclient.android.common.j.i.d().a());
            ArrayList<Channel> b2 = com.zte.iptvclient.android.common.j.i.d().b();
            this.u = b2;
            if (b2 != null && b2.size() > 0) {
                this.F = new HashMap<>();
                Iterator<ColumnBean> it2 = this.x.iterator();
                while (it2.hasNext()) {
                    ColumnBean next = it2.next();
                    ArrayList<Channel> arrayList3 = new ArrayList<>();
                    Iterator<Channel> it3 = this.u.iterator();
                    while (it3.hasNext()) {
                        Channel next2 = it3.next();
                        if (TextUtils.equals(next.getColumnCode(), next2.getColumncode())) {
                            arrayList3.add(next2);
                        }
                    }
                    this.F.put(next, arrayList3);
                }
                a();
                this.F.put(this.E, this.w);
                o();
                m mVar = this.O;
                if (mVar != null) {
                    mVar.d();
                }
            } else {
                LogEx.e(this.f7285a, "getTVALLChannelList() is null !!!");
            }
            LogEx.d(this.f7285a, " dealChannelList finish");
            return;
        }
        LogEx.e(this.f7285a, " TV ListColumn is null!");
    }

    private void e() {
        LogEx.d(this.f7285a, " dealColumnList start");
        ArrayList<ColumnBean> a2 = com.zte.iptvclient.android.common.j.j.e().a();
        this.x = a2;
        if (a2 != null && a2.size() > 1) {
            if (this.J == null) {
                this.L = 1;
                this.B = this.x.get(1);
            } else {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.x.size()) {
                        break;
                    }
                    if (TextUtils.equals(this.x.get(i2).getColumnCode(), this.J.getColumncode())) {
                        this.L = i2;
                        this.B = this.x.get(i2);
                        break;
                    }
                    i2++;
                }
            }
            this.D = this.x.get(0);
            ArrayList<ColumnBean> arrayList = this.x;
            this.E = arrayList.get(arrayList.size() - 1);
            this.C = this.B;
            g();
        } else {
            LogEx.e(this.f7285a, "getColumnBeanList() is null !!!");
        }
        LogEx.d(this.f7285a, " dealColumnList finish");
    }

    private ColumnBean f() {
        for (int i2 = 0; i2 < this.x.size(); i2++) {
            if (TextUtils.equals(this.x.get(i2).getColumnCode(), this.M)) {
                this.r.a(i2, true);
                this.L = i2;
                return this.x.get(i2);
            }
        }
        return null;
    }

    private void g() {
        HorizontalScrollViewEx horizontalScrollViewEx;
        ArrayList<ColumnBean> arrayList = this.x;
        if (arrayList == null || arrayList.size() <= 1 || (horizontalScrollViewEx = this.r) == null) {
            return;
        }
        horizontalScrollViewEx.a(1, this.x, this.L, new j());
    }

    private void h() {
        this.M = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL);
        Executors.newCachedThreadPool();
    }

    private void i() {
        View inflate = View.inflate(this.f7287c, R.layout.tv_channel_from_column_view, this);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ll_detail_function_menu);
        this.f7288d = linearLayout;
        RelativeLayout relativeLayout = (RelativeLayout) linearLayout.findViewById(R.id.rl_more_screen_watching);
        this.e = relativeLayout;
        relativeLayout.setVisibility(8);
        ((TextView) this.e.findViewById(R.id.tv_more_screen_watching)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.multi_play_title));
        this.f = (ImageView) this.f7288d.findViewById(R.id.iv_function_trailer);
        this.g = (ImageView) this.f7288d.findViewById(R.id.iv_function_rating);
        this.h = (ImageView) this.f7288d.findViewById(R.id.iv_function_favorite);
        this.j = (ImageView) this.f7288d.findViewById(R.id.iv_function_play_push);
        this.i = (ImageView) this.f7288d.findViewById(R.id.iv_function_download);
        this.k = (ImageView) this.f7288d.findViewById(R.id.iv_function_share);
        this.l = (ImageView) this.f7288d.findViewById(R.id.iv_function_comment);
        this.n = (RelativeLayout) this.f7288d.findViewById(R.id.rl_function_play_push);
        this.o = (RelativeLayout) this.f7288d.findViewById(R.id.rl_function_favorite);
        this.p = (RelativeLayout) this.f7288d.findViewById(R.id.rl_function_share);
        this.q = (RelativeLayout) this.f7288d.findViewById(R.id.rl_function_comment);
        c();
        this.k.setVisibility(0);
        this.m = (ImageView) this.f7288d.findViewById(R.id.iv_function_sort);
        this.i.setVisibility(8);
        this.g.setVisibility(8);
        this.m.setVisibility(8);
        this.f.setVisibility(8);
        this.f7288d.findViewById(R.id.rl_function_trailer).setVisibility(8);
        this.r = (HorizontalScrollViewEx) inflate.findViewById(R.id.hs_column_view);
        RelativeLayout relativeLayout2 = (RelativeLayout) inflate.findViewById(R.id.rl_viewmore);
        this.s = relativeLayout2;
        relativeLayout2.setVisibility(8);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.channel_list);
        this.t = recyclerView;
        recyclerView.a(new LinearLayoutManager(this.f7287c));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f7287c, 4);
        this.P = gridLayoutManager;
        gridLayoutManager.a(new d());
        this.t.a(this.P);
        com.zte.iptvclient.android.common.customview.viewgroup.a.c cVar = new com.zte.iptvclient.android.common.customview.viewgroup.a.c(4, com.zte.iptvclient.android.common.k.g.a(this.f7287c, 0.5f), false);
        cVar.a(1, this.f7286b.getResources().getColor(R.color.multiplayer_date_selected_light));
        this.t.a(cVar);
        this.t.d(true);
        com.zte.iptvclient.common.uiframe.f.a(this.f);
        com.zte.iptvclient.common.uiframe.f.a(this.g);
        com.zte.iptvclient.common.uiframe.f.a(this.h);
        com.zte.iptvclient.common.uiframe.f.a(this.j);
        this.j.setBackgroundResource(R.drawable.push_disable);
        this.j.setEnabled(false);
        com.zte.iptvclient.common.uiframe.f.a(this.i);
        com.zte.iptvclient.common.uiframe.f.a(this.k);
        com.zte.iptvclient.common.uiframe.f.a(this.l);
        com.zte.iptvclient.common.uiframe.f.a(this.m);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.o);
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.n);
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.rl_tv_column_menu_layout));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.view_more));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.sort_txt));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.middle_line));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.tag_bottom_line));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.rl_bottom_line));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.tag_function_menu_line));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.e eVar) {
        LogEx.d(this.f7285a, " recve InPlayerSwitchChannelEvent");
        if (!TextUtils.isEmpty(eVar.a())) {
            this.Q = eVar.a();
            int i2 = 0;
            while (true) {
                if (i2 >= this.v.size()) {
                    break;
                }
                if (this.v.get(i2).getChannelcode().equals(this.Q)) {
                    this.J = this.v.get(i2);
                    break;
                }
                i2++;
            }
        } else {
            Channel channel = this.J;
            if (channel != null) {
                this.Q = channel.getChannelcode();
            } else {
                this.Q = "";
            }
        }
        if (!TextUtils.isEmpty(eVar.b())) {
            this.C = a(eVar.b());
        } else {
            this.C = f();
        }
        if (this.C == null) {
            this.C = f();
        }
        o();
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(true, this.Q, eVar.b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Channel channel) {
        LogEx.d(this.f7285a, "current channel is  sdkAddFavorite channel" + channel.getChannelcode());
        SDKFavoriteMgr sDKFavoriteMgr = new SDKFavoriteMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("favoritetype", DownloadConstant.REPORT_MSGTYPE_ADD);
        hashMap.put("contentcode", channel.getChannelcode());
        hashMap.put("columncode", this.M);
        sDKFavoriteMgr.doAddFavorite(hashMap, new k(channel));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Channel channel) {
        LogEx.d(this.f7285a, "current channel is  sdkDelFavorite channel" + channel.getChannelcode());
        SDKFavoriteMgr sDKFavoriteMgr = new SDKFavoriteMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(ParamConst.FAVORITE_DELETE_BATCH_REQ_FAVORITETYPES, DownloadConstant.REPORT_MSGTYPE_ADD);
        hashMap.put("contentcodes", channel.getChannelcode());
        hashMap.put("columncodes", this.M);
        sDKFavoriteMgr.doDelFavorite(hashMap, new l(channel));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        String str;
        String channelcode;
        if (this.J == null) {
            return;
        }
        String c2 = com.zte.iptvclient.common.uiframe.a.c("EAS_Domain");
        LogEx.d(this.f7285a, "eas_dns=" + c2);
        String c3 = com.zte.iptvclient.common.uiframe.a.c("Share_Link_Address");
        String channelname = this.J.getChannelname();
        String str2 = "";
        String prevuename = !TextUtils.isEmpty(this.J.getPrevuename()) ? this.J.getPrevuename() : "";
        int i2 = 0;
        if (this.N != null) {
            str = c3 + "?vt=4&vc=" + this.N.getPrevuecode();
            prevuename = this.N.getPrevuename();
            str2 = this.N.getPosterfilelist();
            if (!TextUtils.isEmpty(str2)) {
                str2 = com.zte.iptvclient.android.common.k.g.b(BaseApp.a(this.f7287c) ? 9 : 3, str2);
            }
            if (TextUtils.isEmpty(str2)) {
                String[] split = this.J.getPosterimage().split("/");
                int length = split.length;
                while (i2 < length) {
                    str2 = split[3];
                    i2++;
                }
            }
            channelcode = this.N.getPrevuecode();
        } else {
            str = c3 + "?vt=2&vc=" + this.J.getChannelcode();
            String[] split2 = this.J.getPosterimage().split("/");
            int length2 = split2.length;
            while (i2 < length2) {
                str2 = split2[3];
                i2++;
            }
            channelcode = this.J.getChannelcode();
        }
        new com.zte.iptvclient.android.mobile.x.b.c.c(this.f7287c, channelname, str, str2, com.zte.iptvclient.android.common.i.a.a.a(R.string.let_us_watch) + " " + prevuename + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.on_app_click_link_below), null, null, channelcode).a(view);
    }

    public void b() {
        if (this.y != null) {
            for (int i2 = 0; i2 < this.y.size(); i2++) {
                this.y.get(i2).setIsChannelLock("0");
                this.y.get(i2).setAfterChannelLock("0");
            }
            HashMap<String, String> a2 = com.zte.iptvclient.android.common.j.e.b().a();
            if (a2 != null && a2.size() != 0) {
                for (String str : a2.keySet()) {
                    for (int i3 = 0; i3 < this.y.size(); i3++) {
                        if (TextUtils.equals(str, this.y.get(i3).getChannelcode())) {
                            this.y.get(i3).setIsChannelLock("1");
                            this.y.get(i3).setAfterChannelLock("1");
                        }
                    }
                }
            }
            for (int i4 = 0; i4 < this.y.size(); i4++) {
                if (com.zte.iptvclient.android.mobile.f.b.a.b(this.y.get(i4).getRatingid(), this.f7287c)) {
                    this.y.get(i4).setIsChannelLock("1");
                    this.y.get(i4).setAfterChannelLock("1");
                }
            }
            this.G.d();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.b bVar) {
        PrevueBean a2 = bVar.a();
        if (a2 != null) {
            this.A = DownloadConstant.REPORT_MSGTYPE_ADD;
            this.z = a2.getPrevuecode();
            a(false);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.g gVar) {
        this.A = "0";
        this.z = gVar.b();
        a(false);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(o oVar) {
        PrevueBean b2 = oVar.b();
        if (b2 != null && !TextUtils.isEmpty(b2.getChannelcode())) {
            this.Q = b2.getChannelcode();
        } else {
            Channel channel = this.J;
            if (channel != null) {
                this.Q = channel.getChannelcode();
            }
        }
        this.C = f();
        if (!TextUtils.isEmpty(this.Q)) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.v.size()) {
                    break;
                }
                if (this.v.get(i2).getChannelcode().equals(this.Q)) {
                    this.J = this.v.get(i2);
                    break;
                }
                i2++;
            }
        }
        if (oVar.a() || b2 == null) {
            return;
        }
        o();
        com.zte.iptvclient.android.common.javabean.e.f4731b = b2;
        com.zte.iptvclient.android.common.javabean.e.f4730a = false;
        Date date = new Date();
        Date date2 = new Date();
        try {
            date = x.a(b2.getEndtime(), new SimpleDateFormat("yyyyMMddHHmmss"));
            date2 = x.a(b2.getBegintime(), new SimpleDateFormat("yyyyMMddHHmmss"));
        } catch (Exception e2) {
            LogEx.d(this.f7285a, e2.toString());
        }
        if (this.J != null && com.zte.iptvclient.android.common.j.i.d().a(date2, date, this.J.getMixno())) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(this.f7286b.getResources().getString(R.string.program_playbcak).replace("hour", com.zte.iptvclient.android.common.j.i.d().b(this.J.getMixno())));
        } else {
            new Timer().schedule(new b(oVar), 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ColumnBean columnBean) {
        if (TextUtils.equals(columnBean.getColumnName(), this.D.getColumnName()) && !com.zte.iptvclient.android.mobile.n.c.b.t()) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            t.a(this.f7287c, new C0354a());
            LogEx.d(this.f7285a, "mHsLiveColumnView setCurrentItem start" + this.L);
            this.r.a(this.L);
            return;
        }
        if (TextUtils.equals(columnBean.getColumnName(), this.E.getColumnName())) {
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            this.p.setVisibility(8);
        } else {
            this.n.setVisibility(0);
            this.o.setVisibility(0);
            this.p.setVisibility(0);
        }
        a();
        o();
        m mVar = this.O;
        if (mVar != null) {
            mVar.d();
        }
        b();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        if ("0".equals(cVar.a())) {
            this.M = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL);
            c();
        }
    }

    private ColumnBean a(String str) {
        for (int i2 = 0; i2 < this.x.size(); i2++) {
            if (TextUtils.equals(this.x.get(i2).getColumnCode(), str)) {
                this.r.a(i2, true);
                this.L = i2;
                return this.x.get(i2);
            }
        }
        return null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(r rVar) {
        LogEx.d(this.f7285a, "TvDataQueryFinishedEvent get AllChannel and ColumnList!");
        ArrayList<ColumnBean> arrayList = this.x;
        if (arrayList == null || this.u == null || arrayList.size() <= 0 || this.u.size() <= 0) {
            j();
        }
    }

    public void a(boolean z) {
        ImageView imageView = this.j;
        if (imageView != null) {
            if (z) {
                imageView.setBackgroundResource(R.drawable.play_push_new);
                this.j.setEnabled(true);
            } else {
                imageView.setBackgroundResource(R.drawable.push_disable);
                this.j.setEnabled(false);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.b bVar) {
        if (bVar != null) {
            int a2 = bVar.a();
            String b2 = bVar.b();
            boolean z = false;
            for (int i2 = 0; i2 < this.y.size(); i2++) {
                if (TextUtils.equals(b2, this.y.get(i2).getChannelcode())) {
                    z = true;
                }
            }
            LogEx.d(this.f7285a, "send PlayLiveTVQueryEvent");
            if (z) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(true, this.y.get(a2).getChannelcode(), this.y.get(a2).getColumncode()));
                this.J = this.y.get(a2);
                LogEx.d(this.f7285a, "swicth current Channel=" + this.J.getChannelname() + "selectedChnnelcode " + this.J.getChannelcode());
                com.zte.iptvclient.android.mobile.a0.a.e.a aVar = this.G;
                if (aVar != null) {
                    aVar.e(a2);
                }
                m mVar = this.O;
                if (mVar != null) {
                    mVar.a(this.C, this.J);
                }
                this.Q = this.J.getChannelcode();
                m();
            }
        }
    }

    public void a(Channel channel) {
        boolean z;
        ArrayList<Channel> arrayList = this.y;
        if (arrayList != null) {
            int size = arrayList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    z = false;
                    break;
                }
                if (this.y.get(i2) != null && TextUtils.equals(channel.getChannelcode(), this.y.get(i2).getChannelcode())) {
                    this.G.e(i2);
                    this.J = this.y.get(i2);
                    this.K = i2;
                    LogEx.d(this.f7285a, "swicth current Channel=" + this.J.getChannelname());
                    z = true;
                    break;
                }
                i2++;
            }
            if (!z && this.y.size() > 0) {
                this.J = this.y.get(0);
                this.K = 0;
                LogEx.d(this.f7285a, "swicth current Channel=" + this.J.getChannelname());
                this.G.e(0);
            }
        }
        a(this.K);
    }

    private void a(int i2) {
        this.t.j(i2);
    }

    public void a() {
        this.v = com.zte.iptvclient.android.common.j.i.d().c();
        LogEx.d(this.f7285a, " sdkQueryFavoriteChannelList start");
        if (this.v != null) {
            for (int i2 = 0; i2 < this.v.size(); i2++) {
                this.v.get(i2).setIsfavourite("0");
            }
        }
        SDKFavoriteMgr sDKFavoriteMgr = new SDKFavoriteMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("favoritetype", DownloadConstant.REPORT_MSGTYPE_ADD);
        sDKFavoriteMgr.getUserFavoriteList(hashMap, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<Channel> arrayList) {
        if (this.F != null) {
            LogEx.d(this.f7285a, " mFavoriteColumnBean >>>" + arrayList.size());
            this.F.put(this.D, arrayList);
        }
        ColumnBean columnBean = this.C;
        if (columnBean != null && TextUtils.equals(columnBean.getColumnName(), this.D.getColumnName())) {
            o();
        }
        Iterator<Channel> it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Channel next = it2.next();
            Channel channel = this.J;
            if (channel != null && TextUtils.equals(channel.getChannelcode(), next.getChannelcode())) {
                this.J.setIsfavourite("1");
                break;
            }
        }
        n();
    }

    public void a(PrevueBean prevueBean) {
        this.N = prevueBean;
    }
}
