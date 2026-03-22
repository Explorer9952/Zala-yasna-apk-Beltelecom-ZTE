package com.zte.iptvclient.android.mobile.e0.e;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.vod.SDKVodMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.view.imageview.LevelImageView;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.mobile.vod.entity.GetVodListEntity;
import com.zte.iptvclient.android.mobile.vod.entity.GetVodListItemEntity;
import com.zte.iptvclient.android.mobile.vod.ui.columnview.MyGridLayoutManager;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: VodListViewFragment.java */
/* loaded from: classes2.dex */
public class p extends com.zte.iptvclient.android.mobile.e0.e.c {
    private SmartRefreshLayout A;
    private RecyclerView B;
    private RelativeLayout C;
    private TextView D;
    private LevelImageView E;
    private com.zte.iptvclient.android.mobile.e0.d.g G;
    private int J;
    private String p;
    private View z;
    private String q = "1";
    private boolean r = false;
    private int s = 1;
    private int t = 1;
    private int u = 0;
    private int v = 0;
    private int w = 5;
    private boolean x = false;
    private boolean y = false;
    private ArrayList<GetVodListItemEntity> F = new ArrayList<>();
    private String[] K = new String[0];
    private f L = new f(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VodListViewFragment.java */
    /* loaded from: classes2.dex */
    public class a implements com.scwang.smartrefresh.layout.d.c {
        a() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            p.this.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VodListViewFragment.java */
    /* loaded from: classes2.dex */
    public class b implements com.scwang.smartrefresh.layout.d.a {
        b() {
        }

        @Override // com.scwang.smartrefresh.layout.d.a
        public void b(com.scwang.smartrefresh.layout.a.h hVar) {
            if (p.this.r) {
                return;
            }
            if (p.this.s <= p.this.u) {
                if (TextUtils.isEmpty(p.this.p)) {
                    return;
                }
                LogEx.d("VodListViewFragment", "sdkQueryVideoByColumnCode for=" + p.this.s);
                p pVar = p.this;
                pVar.a(pVar.p, p.this.s);
                return;
            }
            p.this.Q();
            p.this.A.a(true);
            p.this.A.b(false);
            if (p.this.G != null) {
                p.this.G.b(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VodListViewFragment.java */
    /* loaded from: classes2.dex */
    public class c extends RecyclerView.s {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, int i) {
            super.a(recyclerView, i);
            if (i == 0) {
                if (((com.zte.fragmentlib.b) p.this).h != null) {
                    com.bumptech.glide.i.a((FragmentActivity) ((com.zte.fragmentlib.b) p.this).h).g();
                }
            } else {
                if (i != 1) {
                    if (i == 2 && ((com.zte.fragmentlib.b) p.this).h != null) {
                        com.bumptech.glide.i.a((FragmentActivity) ((com.zte.fragmentlib.b) p.this).h).f();
                        return;
                    }
                    return;
                }
                if (((com.zte.fragmentlib.b) p.this).h != null) {
                    com.bumptech.glide.i.a((FragmentActivity) ((com.zte.fragmentlib.b) p.this).h).f();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VodListViewFragment.java */
    /* loaded from: classes2.dex */
    public class d extends GridLayoutManager.b {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MyGridLayoutManager f6124c;

        d(MyGridLayoutManager myGridLayoutManager) {
            this.f6124c = myGridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int b(int i) {
            if (p.this.G.b(i) == 1 || p.this.G.b(i) == 3) {
                return this.f6124c.L();
            }
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VodListViewFragment.java */
    /* loaded from: classes2.dex */
    public class e implements SDKVodMgr.OnVodSearchListReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6126a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f6127b;

        e(int i, String str) {
            this.f6126a = i;
            this.f6127b = str;
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnVodSearchListReturnListener
        public void onVodSearchListReturn(String str, String str2, String str3) {
            LogEx.d("VodListViewFragment", "onVodSearchListReturn , returncode : " + str + " , errormsg : " + str2 + " , data : " + str3);
            com.zte.iptvclient.android.common.k.h.a().a(new g(p.this, str, str3, this.f6126a, this.f6127b));
        }
    }

    /* compiled from: VodListViewFragment.java */
    /* loaded from: classes2.dex */
    private static final class f extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<p> f6129a;

        public f(p pVar) {
            this.f6129a = new WeakReference<>(pVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            p pVar = this.f6129a.get();
            if (pVar == null) {
                return;
            }
            switch (message.what) {
                case 49153:
                    GetVodListEntity getVodListEntity = (GetVodListEntity) message.obj;
                    if (getVodListEntity != null) {
                        LogEx.d("VodListViewFragment", "1111");
                        pVar.v = getVodListEntity.f7635a;
                        pVar.u = getVodListEntity.f7636b;
                        pVar.q = getVodListEntity.f7638d ? "1" : "0";
                        if (getVodListEntity.f7637c) {
                            LogEx.d("VodListViewFragment", "2222");
                            pVar.O();
                            pVar.F.clear();
                        }
                        int size = pVar.F.size();
                        pVar.F.addAll(getVodListEntity.e);
                        if (pVar.G != null) {
                            if (size == 0) {
                                LogEx.d("VodListViewFragment", "3333");
                                pVar.G.d();
                            } else {
                                LogEx.d("VodListViewFragment", "4444");
                                pVar.G.b(size, getVodListEntity.e.size());
                                pVar.G.a(size, pVar.G.a());
                            }
                        }
                        p.r(pVar);
                    }
                    pVar.Q();
                    pVar.x = true;
                    return;
                case 49154:
                    pVar.w = 24;
                    pVar.q = "0";
                    pVar.b(pVar.p, pVar.s);
                    return;
                case 49155:
                    if (pVar.s == 1) {
                        LogEx.d("VodListViewFragment", "getVodSearchList() connect timeout " + pVar.t);
                        if (pVar.t >= 3) {
                            pVar.t = 1;
                            pVar.Q();
                            return;
                        } else {
                            pVar.r = false;
                            p.d(pVar);
                            pVar.K();
                            return;
                        }
                    }
                    return;
                case 49156:
                    pVar.Q();
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: VodListViewFragment.java */
    /* loaded from: classes2.dex */
    private static final class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<p> f6130a;

        /* renamed from: b, reason: collision with root package name */
        private String f6131b;

        /* renamed from: c, reason: collision with root package name */
        private String f6132c;

        /* renamed from: d, reason: collision with root package name */
        private int f6133d;
        private String e;

        public g(p pVar, String str, String str2, int i, String str3) {
            this.f6130a = new WeakReference<>(pVar);
            this.f6131b = str;
            this.f6132c = str2;
            this.f6133d = i;
            this.e = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            p pVar = this.f6130a.get();
            if (pVar == null) {
                return;
            }
            if (this.f6132c == null) {
                if ("18507004".equals(this.f6131b)) {
                    pVar.L.sendEmptyMessage(49155);
                    return;
                } else {
                    pVar.L.sendEmptyMessage(49156);
                    return;
                }
            }
            if (TextUtils.equals(this.f6131b, "1") && TextUtils.equals(this.e, "1")) {
                pVar.L.sendEmptyMessage(49154);
                return;
            }
            if (!"1".equals(this.f6131b) && TextUtils.equals(this.e, "1")) {
                try {
                    JSONObject jSONObject = new JSONObject(this.f6132c);
                    if (!jSONObject.has(ParamConst.BATCH_PREVUE_LIST_RSP_ITEM)) {
                        pVar.L.sendEmptyMessage(49154);
                        return;
                    } else if (jSONObject.getJSONArray(ParamConst.BATCH_PREVUE_LIST_RSP_ITEM).length() <= 0) {
                        pVar.L.sendEmptyMessage(49154);
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 49153;
            if (TextUtils.equals(this.f6131b, "0")) {
                GetVodListEntity getVodListEntity = new GetVodListEntity();
                getVodListEntity.f7638d = "1".equals(this.e);
                try {
                    JSONObject jSONObject2 = new JSONObject(this.f6132c);
                    int optInt = jSONObject2.optInt("totalcount");
                    getVodListEntity.f7635a = optInt;
                    getVodListEntity.f7636b = (optInt + (pVar.w - 1)) / pVar.w;
                    if (this.f6133d <= 1) {
                        getVodListEntity.f7637c = true;
                    }
                    if (!getVodListEntity.f7638d) {
                        pVar.b(jSONObject2.optJSONArray("data"), getVodListEntity);
                    } else {
                        pVar.a(jSONObject2.optJSONArray(ParamConst.BATCH_PREVUE_LIST_RSP_ITEM), getVodListEntity);
                    }
                    obtain.obj = getVodListEntity;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    LogEx.e("VodListViewFragment", e2.getMessage());
                }
            }
            pVar.L.sendMessage(obtain);
        }
    }

    private void L() {
        this.r = false;
    }

    private void M() {
        if (TextUtils.isEmpty(this.p) || this.x) {
            return;
        }
        K();
        this.A.b(false);
        this.A.d(false);
        this.E.setVisibility(0);
        this.E.i();
    }

    private void N() {
        this.A.a(new a());
        this.A.a(new b());
        RecyclerView recyclerView = this.B;
        if (recyclerView != null) {
            recyclerView.a(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        MyGridLayoutManager myGridLayoutManager;
        LogEx.d("VodListViewFragment", "--initData--");
        if (this.B.s() != null) {
            return;
        }
        this.G = new com.zte.iptvclient.android.mobile.e0.d.g(this.h, this.F, this.p);
        if (BaseApp.a(this.h)) {
            myGridLayoutManager = new MyGridLayoutManager(this.h, 8);
            this.B.a(new com.zte.iptvclient.android.mobile.e0.c(8, com.zte.iptvclient.android.common.k.g.a(this.h, 16.0f), true, this.q));
            this.B.k(5);
        } else {
            myGridLayoutManager = new MyGridLayoutManager(this.h, 3);
            this.B.a(new com.zte.iptvclient.android.mobile.e0.c(3, com.zte.iptvclient.android.common.k.g.a(this.h, 6.0f), true, this.q));
        }
        myGridLayoutManager.a(new d(myGridLayoutManager));
        this.B.a(myGridLayoutManager);
        this.B.d(true);
        this.G.a(true);
        this.B.a(this.G);
        this.B.v().a(2, 16);
    }

    private void P() {
        this.u = 0;
        this.v = 0;
        this.s = 1;
        a(this.p, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        this.r = false;
        this.A.d(true);
        this.A.b(true);
        this.A.a();
        this.A.j();
        this.E.g();
        this.E.setVisibility(8);
        if (this.F.size() == 0) {
            LogEx.d("VodListViewFragment", "5555");
            this.C.setVisibility(0);
            this.B.setVisibility(8);
        } else {
            LogEx.d("VodListViewFragment", "6666");
            this.C.setVisibility(8);
            this.B.setVisibility(0);
        }
        if (this.G != null) {
            if (this.F.size() >= this.v) {
                LogEx.d("VodListViewFragment", "7777");
                this.G.b(true);
            } else {
                LogEx.d("VodListViewFragment", "8888");
                this.G.b(false);
            }
        }
    }

    static /* synthetic */ int d(p pVar) {
        int i = pVar.t;
        pVar.t = i + 1;
        return i;
    }

    static /* synthetic */ int r(p pVar) {
        int i = pVar.s;
        pVar.s = i + 1;
        return i;
    }

    @Override // com.zte.iptvclient.android.mobile.e0.e.c
    public void I() {
        L();
    }

    @Override // com.zte.iptvclient.android.mobile.e0.e.c
    public void J() {
        M();
    }

    public void K() {
        if (TextUtils.isEmpty(this.p) || this.r) {
            return;
        }
        this.A.b(true);
        this.A.a(false);
        P();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.y) {
            K();
            this.E.setVisibility(0);
            this.E.i();
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.p = arguments.getString("Columncode");
            this.y = arguments.getBoolean("AutoLoadData", true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.z == null) {
            this.z = layoutInflater.inflate(R.layout.video_column_view_layout, viewGroup, false);
            new com.zte.iptvclient.android.common.j.h(this.h);
            d(this.z);
            N();
        }
        return this.z;
    }

    private void d(View view) {
        LevelImageView levelImageView = (LevelImageView) view.findViewById(R.id.img_animation_loading);
        this.E = levelImageView;
        com.zte.iptvclient.common.uiframe.f.a(levelImageView);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        this.A = smartRefreshLayout;
        smartRefreshLayout.a(new DefaultRefreshHeader(this.h));
        this.A.a(new DefaultRefreshFooter(this.h));
        this.A.a(false);
        this.A.c(false);
        SmartRefreshLayout smartRefreshLayout2 = this.A;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout2.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout3 = this.A;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout3.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.C = relativeLayout;
        TextView textView = (TextView) relativeLayout.findViewById(R.id.txt_pullrefresh);
        this.D = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.there_is_no_collection));
        com.zte.iptvclient.common.uiframe.f.a(this.C.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.C.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.C.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.C.findViewById(R.id.refresh_image));
        this.C.setVisibility(8);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        this.B = recyclerView;
        com.zte.iptvclient.common.uiframe.f.a(recyclerView);
        this.B.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i) {
        LogEx.d("VodListViewFragment", "realReq method is called. mColumnCode : " + str + " , iPageIndex : " + i + " , mSubeExit : " + this.q);
        a(str, i, this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        this.r = true;
        b(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONArray jSONArray, GetVodListEntity getVodListEntity) {
        LogEx.d("VodListViewFragment", "--bindItemData--");
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(GetVodListItemEntity.a(jSONArray.optJSONObject(i)));
        }
        getVodListEntity.e.addAll(arrayList);
    }

    private void a(String str, int i, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pageno", String.valueOf(i));
        hashMap.put("numperpage", String.valueOf(this.w));
        hashMap.put("columncode", str);
        hashMap.put("ordertype", "0");
        hashMap.put(ParamConst.COLUMN_INFO_RSP_SUBEXIST, str2);
        hashMap.put("seriestype", "1,3");
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            int i2 = 0;
            this.J = 0;
            int i3 = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().i();
            if (i3 == 0) {
                String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo(PortalConst.STR_PARENT_CONTROL_LIMIT_LEVEL_VALUE);
                if (!TextUtils.isEmpty(propertiesInfo)) {
                    this.K = propertiesInfo.substring(0, propertiesInfo.lastIndexOf(",")).split(",");
                }
                while (true) {
                    String[] strArr = this.K;
                    if (i2 >= strArr.length) {
                        break;
                    }
                    this.J += Integer.parseInt(strArr[i2]);
                    i2++;
                }
                hashMap.put("ratingid", com.zte.iptvclient.android.common.k.p.a(this.J - i3));
                hashMap.put("isfilterratingid", "0");
            } else {
                String propertiesInfo2 = SDKLoginMgr.getInstance().getPropertiesInfo(PortalConst.STR_PARENT_CONTROL_LIMIT_LEVEL_VALUE);
                if (!TextUtils.isEmpty(propertiesInfo2)) {
                    this.K = propertiesInfo2.split(",");
                }
                while (true) {
                    String[] strArr2 = this.K;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    this.J += Integer.parseInt(strArr2[i2]);
                    i2++;
                }
                hashMap.put("ratingid", com.zte.iptvclient.android.common.k.p.a(this.J - i3));
                hashMap.put("isfilterratingid", "0");
                LogEx.d("VodListViewFragment", " Child Mode getVodSearchList param ratingid");
            }
        }
        hashMap.put("isadult", "0");
        new SDKVodMgr().getVodSearchList(hashMap, new e(i, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONArray jSONArray, GetVodListEntity getVodListEntity) {
        LogEx.d("VodListViewFragment", "--bindColumnItemData--");
        boolean a2 = BaseApp.a(this.h);
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                ArrayList<GetVodListItemEntity> a3 = GetVodListItemEntity.a(jSONArray.optJSONObject(i), a2);
                if (a3 != null) {
                    getVodListEntity.e.addAll(a3);
                }
            }
        }
    }
}
