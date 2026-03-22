package com.zte.iptvclient.android.mobile.d.b;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.cache.SDKCacheMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.viewhistory.SDKViewHistoryMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.k.b;
import com.zte.iptvclient.android.common.k.s;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.bookmark.entity.ViewHistoryEntity;
import com.zte.iptvclient.android.zala.R;
import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ViewHistoryFragment.java */
/* loaded from: classes.dex */
public class a extends com.zte.fragmentlib.b {
    private LinearLayout A;
    private SmartRefreshLayout B;
    private RelativeLayout C;
    private TextView D;
    private com.zte.iptvclient.android.mobile.d.a.a J;
    private RecyclerView K;
    private ArrayList<ViewHistoryEntity> M;
    private ImageView O;
    private RelativeLayout P;
    private AnimationDrawable Q;
    private com.zte.iptvclient.android.common.j.h R;
    private k S;
    private ImageView p;
    private Button q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private RelativeLayout v;
    private RelativeLayout w;
    private FrameLayout x;
    private TextView y;
    private LinearLayout z;
    private boolean E = false;
    private int F = 0;
    private boolean G = false;
    private ArrayList<ViewHistoryEntity> L = null;
    private Boolean N = true;
    private j T = new j(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewHistoryFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.d.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0209a extends GridLayoutManager.b {
        C0209a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int b(int i) {
            if (a.this.J.b(i) == 0) {
                return 1;
            }
            if (BaseApp.a(((com.zte.fragmentlib.b) a.this).h)) {
                return ((com.zte.fragmentlib.b) a.this).o ? 8 : 6;
            }
            return 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewHistoryFragment.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.getActivity() instanceof MainActivity) {
                a.this.F();
            } else if (a.this.getActivity() instanceof HostActivity) {
                a.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewHistoryFragment.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.L == null || a.this.L.size() <= 0) {
                return;
            }
            a.this.E = true;
            a.this.K();
            a.this.G = false;
            a.this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
            if (a.this.J != null) {
                a.this.J.f();
                a aVar = a.this;
                aVar.d(aVar.J.g().size());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewHistoryFragment.java */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.E = false;
            a.this.K();
            if (a.this.J != null) {
                a.this.J.f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewHistoryFragment.java */
    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.G = !r2.G;
            if (a.this.G) {
                a.this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_null));
                if (a.this.J != null) {
                    a.this.J.i();
                    a aVar = a.this;
                    aVar.d(aVar.J.g().size());
                    return;
                }
                return;
            }
            a.this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
            if (a.this.J != null) {
                a.this.J.f();
                a aVar2 = a.this;
                aVar2.d(aVar2.J.g().size());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewHistoryFragment.java */
    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.J == null || a.this.J.g().size() == 0) {
                return;
            }
            a.this.U();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewHistoryFragment.java */
    /* loaded from: classes.dex */
    public class g implements com.scwang.smartrefresh.layout.d.c {
        g() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            if (!a.this.E) {
                a.this.R();
            } else {
                hVar.c(2000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewHistoryFragment.java */
    /* loaded from: classes.dex */
    public class h implements SDKViewHistoryMgr.OnDelViewHistoryReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f5725a;

        h(ArrayList arrayList) {
            this.f5725a = arrayList;
        }

        @Override // com.video.androidsdk.service.viewhistory.SDKViewHistoryMgr.OnDelViewHistoryReturnListener
        public void onDelViewHistoryReturn(String str, String str2) {
            LogEx.d("ViewHistoryFragment", "returncode = " + str + " errormsg  = " + str2);
            if (TextUtils.equals(str, "0")) {
                a.this.L.removeAll(this.f5725a);
                a.this.J.e();
                a aVar = a.this;
                aVar.e(aVar.J.g().size());
                a aVar2 = a.this;
                aVar2.d(aVar2.J.g().size());
                SDKCacheMgr.put(com.zte.iptvclient.android.common.c.c.e + a.this.R.V(), a.this.L);
                a.this.E = false;
                a.this.O();
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.s.b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewHistoryFragment.java */
    /* loaded from: classes.dex */
    public class i implements b.d {
        i() {
        }

        @Override // com.zte.iptvclient.android.common.k.b.d
        public void a() {
            a.this.I();
        }

        @Override // com.zte.iptvclient.android.common.k.b.d
        public void b() {
        }
    }

    /* compiled from: ViewHistoryFragment.java */
    /* loaded from: classes.dex */
    private static final class j extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<a> f5728a;

        public j(a aVar) {
            this.f5728a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            a aVar = this.f5728a.get();
            if (aVar != null && message.what == 12289) {
                if (aVar.L != null) {
                    aVar.L.clear();
                    aVar.J.d();
                } else {
                    aVar.L = new ArrayList();
                }
                ArrayList arrayList = (ArrayList) message.obj;
                if (arrayList != null) {
                    aVar.L.addAll(arrayList);
                    SDKCacheMgr.put(com.zte.iptvclient.android.common.c.c.e + aVar.R.V(), aVar.L);
                }
                aVar.z.setClickable(true);
                aVar.P();
                aVar.O();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewHistoryFragment.java */
    /* loaded from: classes.dex */
    public class k extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private String f5729a;

        /* renamed from: b, reason: collision with root package name */
        private String f5730b;

        /* renamed from: c, reason: collision with root package name */
        private SDKViewHistoryMgr f5731c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f5732d;

        /* compiled from: ViewHistoryFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.d.b.a$k$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0210a implements SDKViewHistoryMgr.OnUserViewHistorylistReturnListener {
            C0210a() {
            }

            @Override // com.video.androidsdk.service.viewhistory.SDKViewHistoryMgr.OnUserViewHistorylistReturnListener
            public void onUserViewHistorylistReturn(String str, String str2, String str3) {
                if (k.this.f5732d) {
                    return;
                }
                LogEx.d("ViewHistoryFragment", "returncode : " + str + " , errormsg : " + str2 + " , data : " + str3);
                Message obtain = Message.obtain();
                obtain.what = 12289;
                if (TextUtils.equals(str, "0")) {
                    try {
                        JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(ViewHistoryEntity.a(jSONArray.getJSONObject(i)));
                        }
                        obtain.obj = arrayList;
                    } catch (Exception e) {
                        LogEx.e("ViewHistoryFragment", e.getMessage());
                    }
                }
                a.this.T.sendMessage(obtain);
            }
        }

        public k(String str, String str2) {
            this.f5729a = str;
            this.f5730b = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            if (this.f5732d) {
                return;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("pageno", this.f5729a);
            hashMap.put("numperpage", this.f5730b);
            SDKViewHistoryMgr sDKViewHistoryMgr = new SDKViewHistoryMgr();
            this.f5731c = sDKViewHistoryMgr;
            sDKViewHistoryMgr.getUserViewHistorylist(hashMap, new C0210a());
        }

        public void a() {
            this.f5732d = true;
            SDKViewHistoryMgr sDKViewHistoryMgr = this.f5731c;
            if (sDKViewHistoryMgr != null) {
                sDKViewHistoryMgr.cancelRequest();
            }
        }
    }

    private void N() {
        k kVar = this.S;
        if (kVar != null) {
            kVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        V();
        this.N = true;
        this.B.a();
        M();
        if (this.L.size() == 0) {
            this.C.setVisibility(0);
            this.K.setVisibility(8);
            this.r.setVisibility(8);
        } else {
            this.C.setVisibility(8);
            this.K.setVisibility(0);
            this.r.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        AnimationDrawable animationDrawable = this.Q;
        if (animationDrawable != null && animationDrawable.isRunning()) {
            this.Q.stop();
        }
        this.P.setVisibility(8);
    }

    private void Q() {
        this.N = false;
        k kVar = new k("1", "100");
        this.S = kVar;
        kVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        T();
        if (this.N.booleanValue()) {
            Q();
        }
    }

    private void S() {
        GridLayoutManager gridLayoutManager;
        this.J = new com.zte.iptvclient.android.mobile.d.a.a(this, this.L, this.M, this.h);
        if (BaseApp.a(this.h)) {
            if (this.o) {
                gridLayoutManager = new GridLayoutManager(this.h, 8);
            } else {
                gridLayoutManager = new GridLayoutManager(this.h, 6);
            }
        } else {
            gridLayoutManager = new GridLayoutManager(this.h, 3);
        }
        gridLayoutManager.a(new C0209a());
        this.K.a(gridLayoutManager);
        this.K.a(this.J);
        if (BaseApp.f()) {
            return;
        }
        this.K.a(new com.zte.iptvclient.android.common.customview.viewgroup.a.b(3, com.zte.iptvclient.android.common.k.g.a(this.h, 6.0f), true));
    }

    private void T() {
        if (this.Q != null) {
            this.P.setVisibility(0);
            this.Q.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_delete_items);
        int size = this.J.g().size();
        this.F = size;
        if (size == 1) {
            a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_delete_item);
        }
        com.zte.iptvclient.android.common.k.b.a(this.h, a2, new i());
    }

    private void V() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < this.L.size(); i2++) {
            String k2 = this.L.get(i2).k();
            if (!TextUtils.isEmpty(k2)) {
                Date e2 = e(k2, "yyyy.MM.dd HH:mm:ss");
                if (e2 != null) {
                    if (a(e2)) {
                        arrayList.add(this.L.get(i2));
                    } else {
                        arrayList2.add(this.L.get(i2));
                    }
                } else {
                    arrayList2.add(this.L.get(i2));
                }
            }
        }
        this.M.clear();
        this.M.addAll(arrayList);
        this.M.addAll(arrayList2);
        int size = arrayList.size();
        if (size > 0) {
            ViewHistoryEntity viewHistoryEntity = new ViewHistoryEntity();
            viewHistoryEntity.p("1");
            arrayList.add(0, viewHistoryEntity);
        }
        if (arrayList2.size() > 0) {
            ViewHistoryEntity viewHistoryEntity2 = new ViewHistoryEntity();
            viewHistoryEntity2.p("2");
            arrayList2.add(0, viewHistoryEntity2);
        }
        this.L.clear();
        this.L.addAll(arrayList);
        this.L.addAll(arrayList2);
        this.J.a(this.L);
        this.J.e(size + 1);
        this.J.d();
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        if (!this.E) {
            return false;
        }
        this.E = false;
        K();
        com.zte.iptvclient.android.mobile.d.a.a aVar = this.J;
        if (aVar == null) {
            return true;
        }
        aVar.f();
        return true;
    }

    protected void I() {
        LogEx.d("ViewHistoryFragment", "delBookMark start.");
        com.zte.iptvclient.android.mobile.d.a.a aVar = this.J;
        if (aVar == null) {
            return;
        }
        ArrayList<ViewHistoryEntity> g2 = aVar.g();
        if (g2.size() == 0) {
            LogEx.d("ViewHistoryFragment", "listDel size is 0.");
            return;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i2 = 0; i2 < g2.size(); i2++) {
                ViewHistoryEntity viewHistoryEntity = g2.get(i2);
                if (TextUtils.isEmpty(viewHistoryEntity.l())) {
                    stringBuffer.append(viewHistoryEntity.a());
                    stringBuffer2.append(viewHistoryEntity.b());
                    if (i2 != g2.size() - 1) {
                        stringBuffer.append(",");
                        stringBuffer2.append(",");
                    }
                }
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("contentcodes", stringBuffer2.toString());
            hashMap.put("columncodes", stringBuffer.toString());
            hashMap.put(ParamConst.VOD_VIEW_RECORD_DEL_REQ_DELACTION, "1");
            new SDKViewHistoryMgr().doDelViewHistory(hashMap, new h(g2));
        } catch (Exception e2) {
            LogEx.d("ViewHistoryFragment", "e = " + e2.getMessage());
        }
    }

    public void J() {
        this.q.setOnClickListener(new b());
        this.z.setOnClickListener(new c());
        this.A.setOnClickListener(new d());
        this.s.setOnClickListener(new e());
        this.x.setOnClickListener(new f());
        this.B.a(new g());
    }

    protected void K() {
        if (this.E) {
            L();
        } else {
            M();
        }
    }

    protected void L() {
        this.v.setVisibility(8);
        this.w.setVisibility(0);
        com.zte.iptvclient.android.mobile.d.a.a aVar = this.J;
        if (aVar != null) {
            aVar.b(true);
            e(this.J.g().size());
        }
    }

    protected void M() {
        this.v.setVisibility(0);
        this.w.setVisibility(8);
        this.x.setVisibility(8);
        com.zte.iptvclient.android.mobile.d.a.a aVar = this.J;
        if (aVar != null) {
            aVar.b(false);
        }
        int a2 = a(this.h, 10.0f);
        a(a2, a2, a2, a2);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        EventBus.getDefault().register(this);
        J();
        this.z.setClickable(false);
        R();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogEx.d("ViewHistoryFragment", "BookMarkNewFragment onCreate");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LogEx.d("ViewHistoryFragment", "BookMarkNewFragment onCreateView");
        View inflate = layoutInflater.inflate(R.layout.bookmark_fragment_main, viewGroup, false);
        this.L = new ArrayList<>();
        this.M = new ArrayList<>();
        this.R = new com.zte.iptvclient.android.common.j.h(this.h);
        d(inflate);
        S();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        LogEx.d("ViewHistoryFragment", "BookMarkNewFragment onDestroy");
        EventBus.getDefault().unregister(this);
        N();
        super.onDestroy();
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.i.a aVar) {
        R();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        if (isHidden()) {
            return;
        }
        R();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        LogEx.d("ViewHistoryFragment", "BookMarkNewFragment onResume");
        super.onResume();
    }

    public void d(View view) {
        com.zte.iptvclient.android.common.k.g.a(this.h, view, R.id.title_bottom_line_imgvew);
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        this.K = recyclerView;
        com.zte.iptvclient.common.uiframe.f.a(recyclerView);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.bookmark_rlayout));
        SupportActivity supportActivity = this.h;
        boolean z = (supportActivity == null || BaseApp.a(supportActivity) || !com.zte.iptvclient.android.common.k.g.e(this.h)) ? false : true;
        this.v = (RelativeLayout) view.findViewById(R.id.bookmark_title_rlayout);
        Button button = (Button) view.findViewById(R.id.btn_back);
        this.q = button;
        if (this.o) {
            button.setVisibility(0);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.bookmark_title_txtvew);
        this.y = textView2;
        if (z) {
            textView2.setTextSize(2, 16);
        }
        this.y.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_bookmark));
        TextView textView3 = (TextView) view.findViewById(R.id.bookmark_edit_txtvew);
        this.r = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.edit));
        this.p = (ImageView) view.findViewById(R.id.bookmark_edit_ivew);
        this.z = (LinearLayout) view.findViewById(R.id.bookmark_edit_llayout);
        this.B = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        if ("1".equals(ConfigMgr.readPropertie("IsShowEditIconOrText", "0"))) {
            this.r.setVisibility(8);
            this.p.setVisibility(0);
        }
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        this.w = (RelativeLayout) view.findViewById(R.id.bookmark_edit_status_rlayout);
        TextView textView4 = (TextView) view.findViewById(R.id.selected_all_txtvew);
        this.s = textView4;
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.bookmark_select_all));
        TextView textView5 = (TextView) view.findViewById(R.id.selected_num_txtvew);
        this.u = textView5;
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.bookmark_select_num));
        TextView textView6 = (TextView) view.findViewById(R.id.cancel_edit_status_txtvew);
        this.t = textView6;
        textView6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel));
        this.A = (LinearLayout) view.findViewById(R.id.bookmark_cancel_edit_llayout);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.bookmark_delete_flayout);
        this.x = frameLayout;
        com.zte.iptvclient.common.uiframe.f.a(frameLayout);
        this.x.setVisibility(4);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.bookmark_delete_imgvew));
        TextView textView7 = (TextView) view.findViewById(R.id.bookmark_delete_txtvew);
        textView7.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.delete));
        com.zte.iptvclient.common.uiframe.f.a(textView7);
        this.O = (ImageView) view.findViewById(R.id.img_animation_loading);
        this.P = (RelativeLayout) view.findViewById(R.id.rl_loading);
        com.zte.iptvclient.common.uiframe.f.a(this.O);
        com.zte.iptvclient.common.uiframe.f.a(this.P);
        this.Q = (AnimationDrawable) this.O.getDrawable();
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.C = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.C.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.C.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.C.findViewById(R.id.refresh_image));
        this.C.setVisibility(8);
        TextView textView8 = (TextView) this.C.findViewById(R.id.txt_pullrefresh);
        this.D = textView8;
        textView8.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.no_watching_video));
        if (this.h != null) {
            this.B.a(new DefaultRefreshHeader(this.h));
            this.B.a(new DefaultRefreshFooter(this.h));
            SmartRefreshLayout smartRefreshLayout = this.B;
            SupportActivity supportActivity2 = this.h;
            smartRefreshLayout.e(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_footer_height)));
            SmartRefreshLayout smartRefreshLayout2 = this.B;
            SupportActivity supportActivity3 = this.h;
            smartRefreshLayout2.f(com.zte.iptvclient.android.common.k.g.a(supportActivity3, supportActivity3.getResources().getDimension(R.dimen.refresh_header_height)));
        }
        this.B.a(true);
        this.B.c(false);
        ImageView imageView = (ImageView) view.findViewById(R.id.title_bottom_line_imgvew);
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        SupportActivity supportActivity4 = this.h;
        if (supportActivity4 == null || !BaseApp.a(supportActivity4)) {
            return;
        }
        com.zte.iptvclient.android.common.k.g.a(imageView, this.h);
    }

    public void e(int i2) {
        if (i2 == this.M.size()) {
            this.u.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.bookmark_select_nums), Integer.valueOf(i2)));
            this.G = true;
            this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_null));
        } else if (i2 <= 1) {
            this.u.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.bookmark_select_num), Integer.valueOf(i2)));
            this.G = false;
            this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
        } else {
            this.u.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.bookmark_select_nums), Integer.valueOf(i2)));
            this.G = false;
            this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
        }
    }

    private void a(int i2, int i3, int i4, int i5) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 0, 0, i5);
        this.K.setLayoutParams(layoutParams);
    }

    public int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private boolean a(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
        return simpleDateFormat.format(date).equals(simpleDateFormat.format(s.b()));
    }

    public Date e(String str, String str2) {
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void d(int i2) {
        if (this.J.g().size() == 0) {
            this.x.setVisibility(8);
            int a2 = a(this.h, 10.0f);
            a(a2, a2, a2, a2);
        } else {
            this.x.setVisibility(0);
            int a3 = a(this.h, 10.0f);
            int a4 = a(this.h, 58.0f);
            if (this.x.getMeasuredHeight() > a3) {
                a4 = this.x.getMeasuredHeight();
            }
            a(a3, a3, a3, a4);
        }
    }
}
