package com.zte.iptvclient.android.mobile.k.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.bookmark.SDKBookMarkMgr;
import com.video.androidsdk.service.cache.SDKCacheMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.javabean.models.VoDBean;
import com.zte.iptvclient.android.zala.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: VodHistoryFragment.java */
/* loaded from: classes.dex */
public class g extends com.zte.fragmentlib.b {
    private RelativeLayout A;
    private h B;
    e p;
    private SmartRefreshLayout q;
    private RelativeLayout r;
    private TextView s;
    private com.zte.iptvclient.android.mobile.k.a.c u;
    private RecyclerView v;
    private ArrayList<VoDBean> w;
    private ArrayList<VoDBean> x;
    private ImageView z;
    private boolean t = false;
    private Boolean y = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VodHistoryFragment.java */
    /* loaded from: classes.dex */
    public class a implements SDKBookMarkMgr.OnUserBookMarkListReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.service.bookmark.SDKBookMarkMgr.OnUserBookMarkListReturnListener
        public void onUserBookMarkListReturn(String str, String str2, String str3) {
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    if (g.this.w != null) {
                        g.this.w.clear();
                    } else {
                        g.this.w = new ArrayList();
                    }
                    for (int i = 0; i < jSONArray.length(); i++) {
                        g.this.w.add(VoDBean.a(jSONArray.getJSONObject(i)));
                    }
                    SDKCacheMgr.put(com.zte.iptvclient.android.common.c.c.e + g.this.B.V(), g.this.w);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            g.this.T();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VodHistoryFragment.java */
    /* loaded from: classes.dex */
    public class b extends GridLayoutManager.b {
        b() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int b(int i) {
            return g.this.u.b(i) == 0 ? 1 : 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VodHistoryFragment.java */
    /* loaded from: classes.dex */
    public class c implements com.scwang.smartrefresh.layout.d.c {
        c() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            if (g.this.t) {
                hVar.c(2000);
            } else {
                g.this.M();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VodHistoryFragment.java */
    /* loaded from: classes.dex */
    public class d implements SDKBookMarkMgr.OnDelBookMarkReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f6699a;

        d(ArrayList arrayList) {
            this.f6699a = arrayList;
        }

        @Override // com.video.androidsdk.service.bookmark.SDKBookMarkMgr.OnDelBookMarkReturnListener
        public void onDelBookMarkReturn(String str, String str2) {
            LogEx.d("", "onDelBookMarkReturn");
            if (TextUtils.equals(str, "0")) {
                g.this.w.removeAll(this.f6699a);
                g.this.u.e();
                g.this.p.S();
                g gVar = g.this;
                gVar.d(gVar.u.h().size());
                SDKCacheMgr.put(com.zte.iptvclient.android.common.c.c.e + g.this.B.V(), g.this.w);
                g.this.M();
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.s.b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        W();
        this.u.a(this.w);
        this.u.d();
        this.y = true;
        this.q.a();
        P();
        if (this.w.size() == 0) {
            this.r.setVisibility(0);
            this.v.setVisibility(8);
        } else {
            this.r.setVisibility(8);
            this.v.setVisibility(0);
        }
        this.p.S();
    }

    private void U() {
        this.y = false;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pageno", "1");
        hashMap.put("numperpage", "100");
        new SDKBookMarkMgr().getUserBookMarkList(hashMap, new a());
    }

    private void V() {
        this.u = new com.zte.iptvclient.android.mobile.k.a.c(this, this.w, this.x, this.h);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.h, 3);
        gridLayoutManager.a(new b());
        this.v.a(gridLayoutManager);
        this.v.a(this.u);
    }

    private void W() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.w.size(); i++) {
            String l = this.w.get(i).l();
            if (!TextUtils.isEmpty(l)) {
                Date e = e(l, "yyyy.MM.dd HH:mm:ss");
                if (e != null) {
                    if (a(Long.valueOf(e.getTime()))) {
                        arrayList.add(this.w.get(i));
                    } else {
                        arrayList2.add(this.w.get(i));
                    }
                } else {
                    arrayList2.add(this.w.get(i));
                }
            }
        }
        this.x.clear();
        this.x.addAll(arrayList);
        this.x.addAll(arrayList2);
        if (arrayList.size() > 0) {
            VoDBean voDBean = new VoDBean();
            voDBean.V("1");
            arrayList.add(0, voDBean);
        }
        if (arrayList2.size() > 0) {
            VoDBean voDBean2 = new VoDBean();
            voDBean2.V("2");
            arrayList2.add(0, voDBean2);
        }
        this.w.clear();
        this.w.addAll(arrayList);
        this.w.addAll(arrayList2);
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        if (!this.t) {
            return false;
        }
        P();
        com.zte.iptvclient.android.mobile.k.a.c cVar = this.u;
        if (cVar == null) {
            return true;
        }
        cVar.f();
        return true;
    }

    public void I() {
        com.zte.iptvclient.android.mobile.k.a.c cVar = this.u;
        if (cVar == null) {
            return;
        }
        ArrayList<VoDBean> h = cVar.h();
        if (h.size() == 0) {
            return;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            for (int i = 0; i < h.size(); i++) {
                VoDBean voDBean = h.get(i);
                if (TextUtils.isEmpty(voDBean.n())) {
                    stringBuffer.append(voDBean.a());
                    stringBuffer2.append(voDBean.c());
                    stringBuffer3.append(voDBean.d());
                    if (i != h.size() - 1) {
                        stringBuffer.append(",");
                        stringBuffer2.append(",");
                        stringBuffer3.append(",");
                    }
                }
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("contentcodes", stringBuffer3.toString());
            hashMap.put("columncodes", stringBuffer2.toString());
            hashMap.put(ParamConst.BOOKMARK_DELETE_REQ_BOOKMARKTYPES, stringBuffer.toString());
            new SDKBookMarkMgr().doDelBookMark(hashMap, new d(h));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int J() {
        return this.u.h().size();
    }

    public boolean K() {
        return this.u.g();
    }

    public boolean L() {
        ArrayList<VoDBean> arrayList = this.w;
        return arrayList != null && arrayList.size() > 0;
    }

    public void M() {
        if (((ArrayList) SDKCacheMgr.getAsObject(com.zte.iptvclient.android.common.c.c.e + this.B.V())) != null) {
            this.w = (ArrayList) SDKCacheMgr.getAsObject(com.zte.iptvclient.android.common.c.c.e + this.B.V());
            T();
        }
        if (this.y.booleanValue()) {
            U();
        }
    }

    public void N() {
        this.q.a(new c());
    }

    protected void O() {
        com.zte.iptvclient.android.mobile.k.a.c cVar = this.u;
        if (cVar != null) {
            cVar.b(true);
        }
    }

    protected void P() {
        com.zte.iptvclient.android.mobile.k.a.c cVar = this.u;
        if (cVar != null) {
            cVar.b(false);
        }
        int a2 = a(this.h, 10.0f);
        a(a2, a2, a2, a2);
    }

    public void Q() {
        this.p.S();
    }

    public void R() {
        this.p.T();
    }

    public void S() {
        this.p.U();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        N();
        this.B = new h(this.h);
        M();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_vod_history, viewGroup, false);
        this.w = new ArrayList<>();
        this.x = new ArrayList<>();
        d(inflate);
        V();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.i.a aVar) {
        M();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        if (isHidden()) {
            return;
        }
        M();
    }

    public void b(boolean z) {
        if (z) {
            this.u.i();
        } else {
            this.u.f();
        }
    }

    public void c(boolean z) {
        if (z) {
            O();
        } else {
            P();
        }
    }

    public void d(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        this.v = recyclerView;
        com.zte.iptvclient.common.uiframe.f.a(recyclerView);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.bookmark_rlayout));
        this.q = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.bookmark_delete_imgvew));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.bookmark_delete_txtvew));
        this.z = (ImageView) view.findViewById(R.id.img_animation_loading);
        this.A = (RelativeLayout) view.findViewById(R.id.rl_loading);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.r = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.r.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.r.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.r.findViewById(R.id.refresh_image));
        this.r.setVisibility(8);
        TextView textView = (TextView) this.r.findViewById(R.id.txt_pullrefresh);
        this.s = textView;
        textView.setText(this.h.getString(R.string.no_watching_video));
        this.q.a(new DefaultRefreshHeader(this.h));
        this.q.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.q;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.q;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.q.a(true);
        this.q.c(false);
    }

    public Date e(String str, String str2) {
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void a(int i, int i2, int i3, int i4) {
        new RelativeLayout.LayoutParams(-1, -2).setMargins(i, i2, i3, i4);
    }

    private boolean a(Long l) {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(3);
        calendar.setTime(new Date(l.longValue()));
        return calendar.get(3) == i;
    }

    public void a(e eVar) {
        this.p = eVar;
    }

    public void d(int i) {
        this.p.Q();
        int a2 = a(this.h, 10.0f);
        if (i == 0) {
            a(a2, a2, a2, a2);
        } else {
            a(a2, a2, a2, a(this.h, 58.0f));
        }
    }
}
