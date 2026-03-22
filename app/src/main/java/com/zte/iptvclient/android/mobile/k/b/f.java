package com.zte.iptvclient.android.mobile.k.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.a.h;
import com.video.androidsdk.service.prevue.SDKPrevueMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.f.b.m;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.javabean.models.i;
import com.zte.iptvclient.android.common.k.s;
import com.zte.iptvclient.android.mobile.history.ui.HistoryView;
import com.zte.iptvclient.android.zala.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TvHistoryFragment.java */
/* loaded from: classes.dex */
public class f extends com.zte.fragmentlib.b {
    private boolean A;
    private HistoryView B;
    private HistoryView C;
    public e p;
    private SmartRefreshLayout q;
    private RelativeLayout r;
    private TextView s;
    private LinearLayout t;
    private List<i> u = null;
    private List<i> v;
    private List<i> w;
    private List<HistoryView> x;
    private ImageView y;
    private RelativeLayout z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvHistoryFragment.java */
    /* loaded from: classes.dex */
    public class a implements com.scwang.smartrefresh.layout.d.c {
        a() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(h hVar) {
            if (f.this.A) {
                f.this.q.c(1000);
                return;
            }
            if (f.this.u != null) {
                f.this.u.clear();
            } else {
                f.this.u = new ArrayList();
            }
            f.this.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvHistoryFragment.java */
    /* loaded from: classes.dex */
    public class b implements SDKPrevueMgr.OnPrevueListReturnListener {
        b() {
        }

        @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnPrevueListReturnListener
        public void onPrevueListReturn(String str, String str2, String str3) {
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    int length = jSONArray.length();
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < length; i++) {
                        arrayList.add(PrevueBean.getPrevueBeanFromJSon(jSONArray.getJSONObject(i)));
                    }
                    int size = f.this.u.size();
                    int size2 = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < size2) {
                                PrevueBean prevueBean = (PrevueBean) arrayList.get(i3);
                                if (prevueBean.getChannelcode().equals(((i) f.this.u.get(i2)).a())) {
                                    ((i) f.this.u.get(i2)).a(prevueBean.getPrevuename());
                                    ((i) f.this.u.get(i2)).b(f.this.a(prevueBean));
                                    arrayList.remove(i3);
                                    size2--;
                                    break;
                                }
                                i3++;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            f.this.a0();
            f.this.W();
        }
    }

    private void V() {
        this.q.a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        this.x.get(0).a(this.v, com.zte.iptvclient.android.common.i.a.a.a(R.string.today));
        this.x.get(1).a(this.w, com.zte.iptvclient.android.common.i.a.a.a(R.string.earlier));
        this.q.a();
        List<i> list = this.u;
        if (list != null && list.size() > 0) {
            this.t.setVisibility(0);
            this.r.setVisibility(8);
        } else {
            this.t.setVisibility(8);
            this.r.setVisibility(0);
        }
        this.p.P();
    }

    private List<i> X() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.x.get(0).a());
        arrayList.addAll(this.x.get(1).a());
        return arrayList;
    }

    private void Y() {
        if (this.u == null) {
            this.v.clear();
            this.w.clear();
            W();
        } else {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("begintime", L());
            hashMap.put("endtime", L());
            new SDKPrevueMgr().getPrevueList(hashMap, new b());
        }
    }

    private void Z() {
        this.u = m.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        this.v.clear();
        this.w.clear();
        int size = this.u.size();
        for (int i = 0; i < size; i++) {
            i iVar = this.u.get(i);
            if (TextUtils.equals(new SimpleDateFormat("yyyy.MM.dd").format(Long.valueOf(System.currentTimeMillis())), iVar.c())) {
                this.v.add(iVar);
            } else {
                this.w.add(iVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I() {
        m.a(X());
        O();
    }

    public int J() {
        return this.x.get(0).c() + this.x.get(1).c();
    }

    public boolean K() {
        return this.x.get(0).b() && this.x.get(1).b();
    }

    String L() {
        return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(s.b());
    }

    public void M() {
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.x = new ArrayList();
        if (this.B == null) {
            this.B = new HistoryView(this.h);
        }
        if (this.C == null) {
            this.C = new HistoryView(this.h);
        }
        this.B.a(this, this.v, com.zte.iptvclient.android.common.i.a.a.a(R.string.this_week));
        this.C.a(this, this.w, com.zte.iptvclient.android.common.i.a.a.a(R.string.earlier));
        this.t.addView(this.B);
        this.t.addView(this.C);
        this.x.clear();
        this.x.add(this.B);
        this.x.add(this.C);
    }

    public boolean N() {
        List<i> list = this.u;
        return list != null && list.size() > 0;
    }

    void O() {
        Z();
        Y();
    }

    protected void P() {
        this.A = true;
        this.x.get(0).b(true);
        this.x.get(1).b(true);
    }

    protected void Q() {
        this.A = false;
        this.x.get(0).b(false);
        this.x.get(1).b(false);
    }

    public void R() {
        this.p.S();
    }

    public void S() {
        this.p.Q();
    }

    public void T() {
        this.p.T();
    }

    public void U() {
        this.p.U();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        V();
        Z();
        M();
        Y();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tv_history, (ViewGroup) null);
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    private void d(View view) {
        this.q = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        this.r = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.t = (LinearLayout) view.findViewById(R.id.fl_container);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.r.findViewById(R.id.ll_pullrefresh));
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
        this.y = (ImageView) view.findViewById(R.id.img_animation_loading);
        this.z = (RelativeLayout) view.findViewById(R.id.rl_loading);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
    }

    public void b(boolean z) {
        Iterator<HistoryView> it2 = this.x.iterator();
        while (it2.hasNext()) {
            it2.next().a(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(boolean z) {
        if (z) {
            P();
        } else {
            Q();
        }
    }

    public void a(e eVar) {
        this.p = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(PrevueBean prevueBean) {
        return prevueBean.getBegintime().substring(11, 16) + "-" + prevueBean.getEndtime().substring(11, 16);
    }
}
