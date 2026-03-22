package com.zte.iptvclient.android.mobile.tv.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.customview.viewgroup.scrollview.HorizontalScrollViewEx;
import com.zte.iptvclient.android.common.e.x.o;
import com.zte.iptvclient.android.common.e.x.r;
import com.zte.iptvclient.android.common.eventbus.multi.f;
import com.zte.iptvclient.android.common.j.i;
import com.zte.iptvclient.android.common.j.j;
import com.zte.iptvclient.android.common.javabean.column.ColumnBean;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.mobile.tv.activity.ColumnSortActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: TvChildChannelsWithColumnView.java */
/* loaded from: classes.dex */
public class b extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private String f7304a;

    /* renamed from: b, reason: collision with root package name */
    private Context f7305b;

    /* renamed from: c, reason: collision with root package name */
    private SupportActivity f7306c;

    /* renamed from: d, reason: collision with root package name */
    private HorizontalScrollViewEx f7307d;
    private RelativeLayout e;
    private RecyclerView f;
    private ArrayList<Channel> g;
    private ArrayList<Channel> h;
    private ArrayList<ColumnBean> i;
    private ArrayList<Channel> j;
    private ColumnBean k;
    private ColumnBean l;
    private ColumnBean m;
    private ColumnBean n;
    private HashMap<ColumnBean, ArrayList<Channel>> o;
    private com.zte.iptvclient.android.mobile.a0.a.e.a p;
    private Channel q;
    private int r;
    private String s;
    private e t;
    private GridLayoutManager u;
    private String v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChildChannelsWithColumnView.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(b.this.f7306c, ColumnSortActivity.class);
            intent.putExtra("From", "LiveTvFragment");
            b.this.f7306c.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChildChannelsWithColumnView.java */
    /* renamed from: com.zte.iptvclient.android.mobile.tv.ui.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0357b implements HorizontalScrollViewEx.a {
        C0357b() {
        }

        @Override // com.zte.iptvclient.android.common.customview.viewgroup.scrollview.HorizontalScrollViewEx.a
        public void a(int i) {
            if (i < b.this.i.size()) {
                EventBus.getDefault().post(new f());
                b bVar = b.this;
                bVar.l = (ColumnBean) bVar.i.get(i);
                b bVar2 = b.this;
                bVar2.a(bVar2.l);
                b.this.r = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChildChannelsWithColumnView.java */
    /* loaded from: classes2.dex */
    public class c implements t.d {
        c() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.d
        public void onDismiss() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChildChannelsWithColumnView.java */
    /* loaded from: classes2.dex */
    public class d extends GridLayoutManager.b {
        d() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int b(int i) {
            return 1;
        }
    }

    /* compiled from: TvChildChannelsWithColumnView.java */
    /* loaded from: classes.dex */
    public interface e {
        void a(ColumnBean columnBean, Channel channel);

        void d();

        void s();
    }

    public b(Context context, SupportActivity supportActivity, e eVar) {
        super(context);
        this.f7304a = "TvChildChannelsWithColumnView";
        this.r = 1;
        this.f7305b = context;
        this.f7306c = supportActivity;
        this.t = eVar;
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        g();
        f();
        i();
    }

    private ColumnBean d() {
        for (int i = 0; i < this.i.size(); i++) {
            if (TextUtils.equals(this.i.get(i).getColumnCode(), this.s)) {
                this.f7307d.a(i, true);
                this.r = i;
                return this.i.get(i);
            }
        }
        return null;
    }

    private void e() {
        HorizontalScrollViewEx horizontalScrollViewEx;
        ArrayList<ColumnBean> arrayList = this.i;
        if (arrayList == null || arrayList.size() <= 1 || (horizontalScrollViewEx = this.f7307d) == null) {
            return;
        }
        horizontalScrollViewEx.a(1, this.i, this.r, new C0357b());
    }

    private void f() {
        this.s = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL);
        Executors.newCachedThreadPool();
    }

    private void g() {
        View inflate = View.inflate(this.f7306c, R.layout.tv_channel_child_view, this);
        this.f7307d = (HorizontalScrollViewEx) inflate.findViewById(R.id.hs_column_view);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rl_viewmore);
        this.e = relativeLayout;
        relativeLayout.setVisibility(8);
        this.f = (RecyclerView) inflate.findViewById(R.id.channel_list);
        com.zte.iptvclient.common.uiframe.f.a(this.f7307d);
        com.zte.iptvclient.common.uiframe.f.a(this.e);
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.rl_tv_column_menu_layout));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.view_more));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.sort_txt));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.middle_line));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.tag_bottom_line));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.rl_bottom_line));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.tag_function_menu_line));
    }

    private void h() {
        c();
        b();
        a();
    }

    private void i() {
        this.e.setOnClickListener(new a());
    }

    private void j() {
        LogEx.d(this.f7304a, "updateCurrentChannelData start");
        k();
        ArrayList<Channel> arrayList = this.j;
        if (arrayList == null || arrayList.size() < 1) {
            this.q = null;
        }
        e eVar = this.t;
        if (eVar != null) {
            eVar.a(this.l, this.q);
        }
        LogEx.d(this.f7304a, "updateCurrentChannelData finish");
    }

    private void k() {
        ColumnBean columnBean;
        HashMap<ColumnBean, ArrayList<Channel>> hashMap = this.o;
        if (hashMap == null || hashMap.size() <= 0 || (columnBean = this.l) == null) {
            return;
        }
        ArrayList<Channel> arrayList = this.o.get(columnBean);
        this.j = arrayList;
        if (arrayList == null) {
            LogEx.e(this.f7304a, "mListCurrentChannel is null");
            return;
        }
        if (TextUtils.equals(this.l.getColumnCode(), this.s)) {
            com.zte.iptvclient.android.common.j.b.e().a(this.j);
            this.j = com.zte.iptvclient.android.common.j.b.e().a();
        }
        com.zte.iptvclient.android.mobile.a0.a.e.a aVar = this.p;
        if (aVar == null) {
            this.p = new com.zte.iptvclient.android.mobile.a0.a.e.a(this.f7306c, this.j, 1, true);
            this.f.a(new LinearLayoutManager(this.f7306c));
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f7306c, 8);
            this.u = gridLayoutManager;
            gridLayoutManager.a(new d());
            this.f.a(this.u);
            com.zte.iptvclient.android.common.customview.viewgroup.a.c cVar = new com.zte.iptvclient.android.common.customview.viewgroup.a.c(8, g.a(this.f7306c, 0.5f), false);
            cVar.a(1, this.f7305b.getResources().getColor(R.color.multiplayer_date_selected_light));
            this.f.a(cVar);
            this.f.d(true);
            this.f.a(this.p);
            this.p.d();
        } else {
            ArrayList<Channel> arrayList2 = this.j;
            if (arrayList2 != null && !arrayList2.equals(aVar.e())) {
                this.p.a(this.j);
            }
        }
        Channel a2 = a(this.j);
        this.q = a2;
        if (a2 != null && this.l != null && !TextUtils.equals(a2.getChannelname(), this.l.getColumnName())) {
            a(this.q);
        }
        this.k = this.l;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        EventBus.getDefault().unregister(this);
        super.onDetachedFromWindow();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.a aVar) {
        h();
    }

    private void c() {
        LogEx.d(this.f7304a, " dealColumnList start");
        ArrayList<ColumnBean> a2 = j.e().a();
        this.i = a2;
        if (a2 != null && a2.size() > 1) {
            if (this.q == null) {
                this.r = 1;
                this.k = this.i.get(1);
            } else {
                int i = 0;
                while (true) {
                    if (i >= this.i.size()) {
                        break;
                    }
                    if (TextUtils.equals(this.i.get(i).getColumnCode(), this.q.getColumncode())) {
                        this.r = i;
                        this.k = this.i.get(i);
                        break;
                    }
                    i++;
                }
            }
            this.m = this.i.get(0);
            ArrayList<ColumnBean> arrayList = this.i;
            this.n = arrayList.get(arrayList.size() - 1);
            this.l = this.k;
            e();
        } else {
            LogEx.e(this.f7304a, "getColumnBeanList() is null !!!");
        }
        LogEx.d(this.f7304a, " dealColumnList finish");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.e eVar) {
        LogEx.d(this.f7304a, " recve InPlayerSwitchChannelEvent");
        if (!TextUtils.isEmpty(eVar.a())) {
            this.v = eVar.a();
        } else {
            Channel channel = this.q;
            if (channel != null) {
                this.v = channel.getChannelcode();
            } else {
                this.v = "";
            }
        }
        if (!TextUtils.isEmpty(eVar.b())) {
            this.l = a(eVar.b());
        } else {
            this.l = d();
        }
        j();
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(true, this.v, eVar.b()));
    }

    private void b() {
        LogEx.d(this.f7304a, " dealChannelList start");
        ArrayList<ColumnBean> arrayList = this.i;
        if (arrayList != null && arrayList.size() >= 1) {
            ArrayList<Channel> arrayList2 = this.h;
            if (arrayList2 == null) {
                this.h = new ArrayList<>();
            } else {
                arrayList2.clear();
            }
            this.h.addAll(i.d().a());
            ArrayList<Channel> b2 = i.d().b();
            this.g = b2;
            if (b2 != null && b2.size() > 0) {
                this.o = new HashMap<>();
                Iterator<ColumnBean> it2 = this.i.iterator();
                while (it2.hasNext()) {
                    ColumnBean next = it2.next();
                    ArrayList<Channel> arrayList3 = new ArrayList<>();
                    Iterator<Channel> it3 = this.g.iterator();
                    while (it3.hasNext()) {
                        Channel next2 = it3.next();
                        if (TextUtils.equals(next.getColumnCode(), next2.getColumncode())) {
                            arrayList3.add(next2);
                        }
                    }
                    this.o.put(next, arrayList3);
                }
                this.o.put(this.n, this.h);
                j();
                e eVar = this.t;
                if (eVar != null) {
                    eVar.d();
                }
            } else {
                LogEx.e(this.f7304a, "getTVALLChannelList() is null !!!");
            }
            LogEx.d(this.f7304a, " dealChannelList finish");
            return;
        }
        LogEx.e(this.f7304a, " TV ListColumn is null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ColumnBean columnBean) {
        if (TextUtils.equals(columnBean.getColumnName(), this.m.getColumnName()) && !com.zte.iptvclient.android.mobile.n.c.b.t()) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            t.a(this.f7306c, new c());
            LogEx.d(this.f7304a, "mHsLiveColumnView setCurrentItem start" + this.r);
            this.f7307d.a(this.r);
            return;
        }
        j();
        e eVar = this.t;
        if (eVar != null) {
            eVar.d();
        }
    }

    public void a() {
        if (this.j != null) {
            for (int i = 0; i < this.j.size(); i++) {
                this.j.get(i).setIsChannelLock("0");
                this.j.get(i).setAfterChannelLock("0");
            }
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                if (com.zte.iptvclient.android.mobile.f.b.a.b(this.j.get(i2).getRatingid(), this.f7306c)) {
                    this.j.get(i2).setIsChannelLock("1");
                    this.j.get(i2).setAfterChannelLock("1");
                }
            }
            this.p.d();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(o oVar) {
        PrevueBean b2 = oVar.b();
        if (b2 != null && !TextUtils.isEmpty(b2.getChannelcode())) {
            this.v = b2.getChannelcode();
        } else {
            Channel channel = this.q;
            if (channel != null) {
                this.v = channel.getChannelcode();
            }
        }
        this.l = d();
        j();
        if (oVar.a() || b2 == null) {
            return;
        }
        com.zte.iptvclient.android.common.javabean.e.f4731b = b2;
        com.zte.iptvclient.android.common.javabean.e.f4730a = false;
        Date date = new Date();
        Date date2 = new Date();
        try {
            date = x.a(b2.getEndtime(), new SimpleDateFormat("yyyyMMddHHmmss"));
            date2 = x.a(b2.getBegintime(), new SimpleDateFormat("yyyyMMddHHmmss"));
        } catch (Exception e2) {
            LogEx.d(this.f7304a, e2.toString());
        }
        if (this.q != null && i.d().a(date2, date, this.q.getMixno())) {
            e eVar = this.t;
            if (eVar != null) {
                eVar.s();
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(getResources().getString(R.string.program_playbcak).replace("hour", i.d().b(this.q.getMixno())));
            return;
        }
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.b(oVar.b(), true));
    }

    private ColumnBean a(String str) {
        for (int i = 0; i < this.i.size(); i++) {
            if (TextUtils.equals(this.i.get(i).getColumnCode(), str)) {
                this.f7307d.a(i, true);
                this.r = i;
                return this.i.get(i);
            }
        }
        return null;
    }

    private Channel a(ArrayList<Channel> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (TextUtils.isEmpty(this.v)) {
            return arrayList.get(0);
        }
        Channel channel = arrayList.get(0);
        for (int i = 0; i < arrayList.size(); i++) {
            if (TextUtils.equals(arrayList.get(i).getChannelcode(), this.v)) {
                Channel channel2 = arrayList.get(i);
                this.p.e(i);
                return channel2;
            }
        }
        return channel;
    }

    public void a(Channel channel) {
        boolean z;
        ArrayList<Channel> arrayList = this.j;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = false;
                    break;
                }
                if (this.j.get(i) != null && TextUtils.equals(channel.getChannelcode(), this.j.get(i).getChannelcode())) {
                    this.p.e(i);
                    this.q = this.j.get(i);
                    LogEx.d(this.f7304a, "swicth current Channel=" + this.q.getChannelname());
                    z = true;
                    break;
                }
                i++;
            }
            if (z || this.j.size() <= 0) {
                return;
            }
            this.q = this.j.get(0);
            LogEx.d(this.f7304a, "swicth current Channel=" + this.q.getChannelname());
            this.p.e(0);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        if ("0".equals(cVar.a())) {
            this.s = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(r rVar) {
        LogEx.d(this.f7304a, "TvDataQueryFinishedEvent get AllChannel and ColumnList!");
        ArrayList<ColumnBean> arrayList = this.i;
        if (arrayList == null || this.g == null || arrayList.size() <= 0 || this.g.size() <= 0) {
            h();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.b bVar) {
        int a2;
        if (bVar == null || (a2 = bVar.a()) >= this.j.size()) {
            return;
        }
        LogEx.d(this.f7304a, "send PlayLiveTVQueryEvent");
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(true, this.j.get(a2).getChannelcode(), this.j.get(a2).getColumncode()));
        this.q = this.j.get(a2);
        LogEx.d(this.f7304a, "swicth current Channel=" + this.q.getChannelname() + "selectedChnnelcode " + this.q.getChannelcode());
        com.zte.iptvclient.android.mobile.a0.a.e.a aVar = this.p;
        if (aVar != null) {
            aVar.e(a2);
        }
        e eVar = this.t;
        if (eVar != null) {
            eVar.a(this.l, this.q);
        }
        this.v = this.q.getChannelcode();
    }
}
