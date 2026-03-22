package com.zte.iptvclient.android.mobile.j.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.cache.SDKCacheMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.favorite.SDKFavoriteMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.javabean.models.VoDBean;
import com.zte.iptvclient.android.common.k.b;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: FavoriteNewFragment.java */
/* loaded from: classes.dex */
public class c extends com.zte.fragmentlib.b {
    private FrameLayout A;
    private TextView B;
    private TextView C;
    private LinearLayout D;
    private LinearLayout E;
    private SmartRefreshLayout F;
    private RelativeLayout G;
    private com.zte.iptvclient.android.common.j.h O;
    private k P;
    private com.zte.iptvclient.android.mobile.j.a.c p;
    private Button r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private ImageView w;
    private GridView x;
    private RelativeLayout y;
    private RelativeLayout z;
    private ArrayList<VoDBean> q = null;
    private boolean J = true;
    private boolean K = false;
    private int L = 0;
    private String M = "";
    private boolean N = false;
    private j Q = new j(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteNewFragment.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.getActivity() instanceof MainActivity) {
                c.this.F();
            } else if (c.this.getActivity() instanceof HostActivity) {
                c.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteNewFragment.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.q == null || c.this.q.size() <= 0) {
                return;
            }
            c.this.K = true;
            c.this.K();
            c.this.N = false;
            c.this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteNewFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.j.b.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0287c implements View.OnClickListener {
        ViewOnClickListenerC0287c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.K = false;
            c.this.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteNewFragment.java */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.N = !r2.N;
            if (c.this.N) {
                c.this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_null));
                c.this.p.e();
                c cVar = c.this;
                cVar.d(cVar.p.c().size());
                return;
            }
            c.this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
            c.this.p.b();
            c cVar2 = c.this;
            cVar2.d(cVar2.p.c().size());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteNewFragment.java */
    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.p.c().size() == 0) {
                return;
            }
            c.this.S();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteNewFragment.java */
    /* loaded from: classes.dex */
    public class f implements com.scwang.smartrefresh.layout.d.c {
        f() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            if (!c.this.K) {
                c.this.P();
            } else {
                hVar.c(2000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteNewFragment.java */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.q = (ArrayList) SDKCacheMgr.getAsObject(com.zte.iptvclient.android.common.c.c.f4110c + c.this.O.V());
            if (c.this.q != null) {
                c.this.p.a(c.this.q);
                c.this.O();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteNewFragment.java */
    /* loaded from: classes.dex */
    public class h implements b.d {
        h() {
        }

        @Override // com.zte.iptvclient.android.common.k.b.d
        public void a() {
            c.this.I();
        }

        @Override // com.zte.iptvclient.android.common.k.b.d
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FavoriteNewFragment.java */
    /* loaded from: classes.dex */
    public class i extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private String f6650a;

        /* renamed from: b, reason: collision with root package name */
        private String f6651b;

        /* renamed from: c, reason: collision with root package name */
        private String f6652c;

        /* compiled from: FavoriteNewFragment.java */
        /* loaded from: classes.dex */
        class a implements SDKFavoriteMgr.OnDelFavoriteReturnListener {
            a() {
            }

            @Override // com.video.androidsdk.service.favorite.SDKFavoriteMgr.OnDelFavoriteReturnListener
            public void onDelFavoriteReturn(String str, String str2) {
                LogEx.d("FavoriteNewFragment", "onDelFavoriteReturn");
                if (TextUtils.equals(str, "0")) {
                    c.this.Q.sendEmptyMessage(8193);
                    return;
                }
                Message obtain = Message.obtain();
                obtain.what = 8194;
                obtain.obj = str2;
                c.this.Q.sendMessage(obtain);
            }
        }

        public i(String str, String str2, String str3) {
            this.f6650a = str;
            this.f6651b = str2;
            this.f6652c = str3;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("contentcodes", this.f6650a);
            hashMap.put("columncodes", this.f6651b);
            hashMap.put(ParamConst.FAVORITE_DELETE_BATCH_REQ_FAVORITETYPES, this.f6652c);
            new SDKFavoriteMgr().doDelFavorite(hashMap, new a());
        }
    }

    /* compiled from: FavoriteNewFragment.java */
    /* loaded from: classes.dex */
    private static final class j extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<c> f6655a;

        public j(c cVar) {
            this.f6655a = new WeakReference<>(cVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            c cVar = this.f6655a.get();
            if (cVar == null) {
                return;
            }
            switch (message.what) {
                case 8193:
                    cVar.q.removeAll(cVar.p.c());
                    cVar.p.a();
                    cVar.p.notifyDataSetChanged();
                    SDKCacheMgr.put(com.zte.iptvclient.android.common.c.c.f4110c + cVar.O.V(), cVar.q);
                    cVar.e(cVar.p.c().size());
                    cVar.d(cVar.p.c().size());
                    cVar.K = false;
                    cVar.O();
                    return;
                case 8194:
                    String str = (String) message.obj;
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.del_favourite_msg) + " " + str);
                    return;
                case 8195:
                    if (cVar.q != null) {
                        cVar.q.clear();
                    } else {
                        cVar.q = new ArrayList();
                    }
                    ArrayList arrayList = (ArrayList) message.obj;
                    if (arrayList != null) {
                        cVar.q.addAll(arrayList);
                        SDKCacheMgr.put(com.zte.iptvclient.android.common.c.c.f4110c + cVar.O.V(), cVar.q);
                    }
                    if (cVar.p != null) {
                        cVar.p.a(cVar.q);
                        cVar.p.notifyDataSetChanged();
                    }
                    cVar.J = true;
                    cVar.O();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FavoriteNewFragment.java */
    /* loaded from: classes.dex */
    public class k extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private String f6656a;

        /* renamed from: b, reason: collision with root package name */
        private SDKFavoriteMgr f6657b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f6658c;

        /* compiled from: FavoriteNewFragment.java */
        /* loaded from: classes.dex */
        class a implements SDKFavoriteMgr.OnUserFavoriteListReturnListener {
            a() {
            }

            @Override // com.video.androidsdk.service.favorite.SDKFavoriteMgr.OnUserFavoriteListReturnListener
            public void onUserFavoriteListReturn(String str, String str2, String str3) {
                if (k.this.f6658c) {
                    return;
                }
                LogEx.d("FavoriteNewFragment", " returncode : " + str + ", errormsg : " + str2 + ", data : " + str3);
                Message obtain = Message.obtain();
                obtain.what = 8195;
                if (TextUtils.equals(str, "0")) {
                    try {
                        JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(VoDBean.a(jSONArray.getJSONObject(i)));
                        }
                        obtain.obj = arrayList;
                    } catch (Exception e) {
                        LogEx.e("FavoriteNewFragment", e.getMessage());
                    }
                }
                c.this.Q.sendMessage(obtain);
            }
        }

        public k(String str) {
            this.f6656a = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            if (this.f6658c) {
                return;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("favoritetype", this.f6656a);
            SDKFavoriteMgr sDKFavoriteMgr = new SDKFavoriteMgr();
            this.f6657b = sDKFavoriteMgr;
            sDKFavoriteMgr.getUserFavoriteList(hashMap, new a());
        }

        public void a() {
            this.f6658c = true;
            SDKFavoriteMgr sDKFavoriteMgr = this.f6657b;
            if (sDKFavoriteMgr != null) {
                sDKFavoriteMgr.cancelRequest();
            }
        }
    }

    private void N() {
        k kVar = this.P;
        if (kVar != null) {
            kVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        this.F.a();
        M();
        ArrayList<VoDBean> arrayList = this.q;
        if (arrayList == null) {
            this.G.setVisibility(0);
            this.x.setVisibility(8);
            this.s.setVisibility(8);
        } else if (arrayList.size() == 0) {
            this.G.setVisibility(0);
            this.x.setVisibility(8);
            this.s.setVisibility(8);
        } else {
            this.G.setVisibility(8);
            this.x.setVisibility(0);
            this.s.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        new Handler().postDelayed(new g(), 5L);
        if (this.J) {
            Q();
        }
    }

    private void Q() {
        this.J = false;
        k kVar = new k("1,4");
        this.P = kVar;
        kVar.start();
    }

    private void R() {
        com.zte.iptvclient.android.mobile.j.a.c cVar = new com.zte.iptvclient.android.mobile.j.a.c(this, this.q);
        this.p = cVar;
        this.x.setAdapter((ListAdapter) cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_delete_items);
        int size = this.p.c().size();
        this.L = size;
        if (size == 1) {
            a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_delete_item);
        }
        com.zte.iptvclient.android.common.k.b.a(this.h, a2, new h());
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        if (!this.K) {
            return false;
        }
        this.K = false;
        K();
        com.zte.iptvclient.android.mobile.j.a.c cVar = this.p;
        if (cVar == null) {
            return true;
        }
        cVar.b();
        return true;
    }

    protected void I() {
        ArrayList<VoDBean> c2 = this.p.c();
        ArrayList arrayList = new ArrayList(this.q);
        if (c2.size() == 0) {
            return;
        }
        try {
            arrayList.removeAll(c2);
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            for (int i2 = 0; i2 < c2.size(); i2++) {
                VoDBean voDBean = c2.get(i2);
                stringBuffer.append(voDBean.d());
                stringBuffer2.append(voDBean.c());
                stringBuffer3.append(voDBean.f());
                if (i2 != c2.size() - 1) {
                    stringBuffer.append(",");
                    stringBuffer2.append(",");
                    stringBuffer3.append(",");
                }
            }
            new i(stringBuffer.toString(), stringBuffer2.toString(), stringBuffer3.toString()).start();
        } catch (Exception e2) {
            LogEx.d("FavoriteNewFragment", e2.getMessage());
        }
    }

    public void J() {
        this.r.setOnClickListener(new a());
        this.D.setOnClickListener(new b());
        this.E.setOnClickListener(new ViewOnClickListenerC0287c());
        this.t.setOnClickListener(new d());
        this.A.setOnClickListener(new e());
        this.F.a(new f());
    }

    protected void K() {
        if (this.K) {
            L();
        } else {
            M();
        }
    }

    protected void L() {
        this.y.setVisibility(8);
        this.z.setVisibility(0);
        com.zte.iptvclient.android.mobile.j.a.c cVar = this.p;
        if (cVar != null) {
            cVar.a(true);
            this.p.b();
            e(this.p.c().size());
        }
    }

    protected void M() {
        this.y.setVisibility(0);
        this.z.setVisibility(8);
        this.A.setVisibility(8);
        com.zte.iptvclient.android.mobile.j.a.c cVar = this.p;
        if (cVar != null) {
            cVar.a(false);
            this.p.b();
            e(this.p.c().size());
        }
        int a2 = a(this.h, 10.0f);
        a(a2, a2, a2, a2);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.O = new com.zte.iptvclient.android.common.j.h(this.h);
        R();
        J();
        P();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogEx.d("FavoriteNewFragment", "FavoriteNewFragment create");
        this.q = new ArrayList<>();
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.favorite_fragment_main, viewGroup, false);
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        LogEx.d("FavoriteNewFragment", "Favorite onDestroy");
        EventBus.getDefault().unregister(this);
        N();
        super.onDestroy();
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.m.b bVar) {
        if (this.K) {
            return;
        }
        P();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
    }

    public void d(View view) {
        com.zte.iptvclient.android.common.k.g.a(this.h, view, R.id.title_bottom_line);
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        Button button = (Button) view.findViewById(R.id.btn_back);
        this.r = button;
        if (this.o) {
            button.setVisibility(0);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.edit_txt);
        this.s = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.edit));
        this.w = (ImageView) view.findViewById(R.id.fav_edit_ivew);
        TextView textView3 = (TextView) view.findViewById(R.id.txt_cancel);
        this.u = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel));
        TextView textView4 = (TextView) view.findViewById(R.id.txt_selected_all);
        this.t = textView4;
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
        TextView textView5 = (TextView) view.findViewById(R.id.txt_selected_num);
        this.v = textView5;
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_num));
        this.F = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        this.x = (GridView) view.findViewById(R.id.favorite_grid_view);
        this.y = (RelativeLayout) view.findViewById(R.id.title_rlayout);
        this.z = (RelativeLayout) view.findViewById(R.id.edit_rlayout);
        this.A = (FrameLayout) view.findViewById(R.id.fl_delete);
        this.B = (TextView) view.findViewById(R.id.title_txt);
        this.D = (LinearLayout) view.findViewById(R.id.fav_edit_llayout);
        this.E = (LinearLayout) view.findViewById(R.id.fav_cancel_edit_llayout);
        if ("1".equals(ConfigMgr.readPropertie("IsShowEditIconOrText", "0"))) {
            this.s.setVisibility(8);
            this.w.setVisibility(0);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.title_bottom_line);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.D);
        com.zte.iptvclient.common.uiframe.f.a(this.E);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_delete));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_delete));
        TextView textView6 = (TextView) view.findViewById(R.id.txt_delete);
        textView6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.delete));
        com.zte.iptvclient.common.uiframe.f.a(textView6);
        if (TextUtils.isEmpty(this.M)) {
            this.B.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_favorite));
        } else {
            this.B.setText(this.M);
        }
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        this.x.setVisibility(0);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.G = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.G.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.G.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.G.findViewById(R.id.refresh_image));
        this.G.setVisibility(8);
        TextView textView7 = (TextView) view.findViewById(R.id.txt_pullrefresh);
        this.C = textView7;
        textView7.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.there_is_no_collection_yet));
        if (this.h != null) {
            this.F.a(new DefaultRefreshHeader(this.h));
            this.F.a(new DefaultRefreshFooter(this.h));
            SmartRefreshLayout smartRefreshLayout = this.F;
            SupportActivity supportActivity = this.h;
            smartRefreshLayout.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
            SmartRefreshLayout smartRefreshLayout2 = this.F;
            SupportActivity supportActivity2 = this.h;
            smartRefreshLayout2.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        }
        this.F.a(true);
        this.F.c(false);
        SupportActivity supportActivity3 = this.h;
        if (supportActivity3 == null || !BaseApp.a(supportActivity3)) {
            return;
        }
        com.zte.iptvclient.android.common.k.g.a(imageView, this.h);
    }

    public void e(int i2) {
        if (i2 == this.p.d()) {
            this.v.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.bookmark_select_nums), Integer.valueOf(i2)));
            this.N = true;
            this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_null));
        } else if (i2 <= 1) {
            this.v.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.bookmark_select_num), Integer.valueOf(i2)));
            this.N = false;
            this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
        } else {
            this.v.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.bookmark_select_nums), Integer.valueOf(i2)));
            this.N = false;
            this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
        }
    }

    private void a(int i2, int i3, int i4, int i5) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(i2, i3, i4, i5);
        this.x.setLayoutParams(layoutParams);
    }

    public int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void d(int i2) {
        if (i2 == 0) {
            this.A.setVisibility(8);
            int a2 = a(this.h, 10.0f);
            a(a2, a2, a2, a2);
        } else {
            this.A.setVisibility(0);
            int a3 = a(this.h, 10.0f);
            a(a3, a3, a3, a(this.h, 58.0f));
        }
    }
}
