package com.zte.iptvclient.android.mobile.b0.b;

import android.content.Context;
import android.os.Bundle;
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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.prevue.SDKPrevueMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.f.b.m;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.k.s;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.tvhistory.ui.HistorySubView;
import com.zte.iptvclient.android.zala.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: LastWatchFragment.java */
/* loaded from: classes2.dex */
public class a extends com.zte.fragmentlib.b {
    private static final String R = a.class.getName();
    private LinearLayout A;
    private SmartRefreshLayout B;
    private RelativeLayout C;
    private TextView D;
    private boolean E;
    private boolean F;
    private List<com.zte.iptvclient.android.common.javabean.models.i> G;
    private List<com.zte.iptvclient.android.common.javabean.models.i> J;
    private List<HistorySubView> K;
    private List<com.zte.iptvclient.android.common.javabean.models.i> L = null;
    private HistorySubView M;
    private HistorySubView N;
    private LinearLayout O;
    private ImageView P;
    private RelativeLayout Q;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LastWatchFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.b0.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0190a implements com.scwang.smartrefresh.layout.d.c {
        C0190a() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            if (a.this.E) {
                a.this.B.c(1000);
                return;
            }
            if (a.this.L != null) {
                a.this.L.clear();
            } else {
                a.this.L = new ArrayList();
            }
            a.this.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LastWatchFragment.java */
    /* loaded from: classes2.dex */
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
    /* compiled from: LastWatchFragment.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.L == null || a.this.L.size() <= 0) {
                return;
            }
            a.this.E = true;
            a.this.L();
            a.this.F = false;
            a.this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
            a.this.R();
            a.this.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LastWatchFragment.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.E = false;
            a.this.M();
            a.this.R();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LastWatchFragment.java */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.F = !r2.F;
            if (a.this.F) {
                a.this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_null));
                a.this.X();
            } else {
                a.this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
                a.this.R();
            }
            a.this.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LastWatchFragment.java */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.U() == 0) {
                return;
            }
            a.this.Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LastWatchFragment.java */
    /* loaded from: classes2.dex */
    public class g implements com.scwang.smartrefresh.layout.d.c {
        g() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            if (a.this.E) {
                hVar.c(2000);
            } else {
                a.this.K();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LastWatchFragment.java */
    /* loaded from: classes2.dex */
    public class h implements SDKPrevueMgr.OnPrevueListReturnListener {
        h() {
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
                    int size = a.this.L.size();
                    int size2 = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < size2) {
                                PrevueBean prevueBean = (PrevueBean) arrayList.get(i3);
                                if (prevueBean.getChannelcode().equals(((com.zte.iptvclient.android.common.javabean.models.i) a.this.L.get(i2)).a())) {
                                    ((com.zte.iptvclient.android.common.javabean.models.i) a.this.L.get(i2)).a(prevueBean.getPrevuename());
                                    ((com.zte.iptvclient.android.common.javabean.models.i) a.this.L.get(i2)).b(a.this.a(prevueBean));
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
            a.this.Z();
            a.this.S();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LastWatchFragment.java */
    /* loaded from: classes2.dex */
    public class i implements t.e {
        i() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void a() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void b() {
            a.this.Q();
        }
    }

    private void P() {
        this.B.a(new C0190a());
        this.q.setOnClickListener(new b());
        this.z.setOnClickListener(new c());
        this.A.setOnClickListener(new d());
        this.s.setOnClickListener(new e());
        this.x.setOnClickListener(new f());
        this.B.a(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        m.a(T());
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        HistorySubView historySubView = this.M;
        if (historySubView == null || this.N == null) {
            return;
        }
        historySubView.a();
        this.N.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        this.K.get(0).a(this.G, com.zte.iptvclient.android.common.i.a.a.a(R.string.today));
        this.K.get(1).a(this.J, com.zte.iptvclient.android.common.i.a.a.a(R.string.earlier));
        this.B.a();
        List<com.zte.iptvclient.android.common.javabean.models.i> list = this.L;
        if (list != null && list.size() > 0) {
            this.O.setVisibility(0);
            this.C.setVisibility(8);
            this.r.setVisibility(0);
        } else {
            this.O.setVisibility(8);
            this.C.setVisibility(0);
            this.r.setVisibility(8);
        }
        M();
        this.z.setClickable(true);
    }

    private List<com.zte.iptvclient.android.common.javabean.models.i> T() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.K.get(0).c());
        arrayList.addAll(this.K.get(1).c());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int U() {
        HistorySubView historySubView = this.M;
        if (historySubView == null || this.N == null) {
            return 0;
        }
        return historySubView.b() + this.N.b();
    }

    private void V() {
        if (this.L == null) {
            this.G.clear();
            this.J.clear();
            S();
        } else {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("begintime", I());
            hashMap.put("endtime", I());
            new SDKPrevueMgr().getPrevueList(hashMap, new h());
        }
    }

    private void W() {
        this.L = m.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        HistorySubView historySubView = this.M;
        if (historySubView == null || this.N == null) {
            return;
        }
        historySubView.d();
        this.N.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_delete_items);
        if (U() == 1) {
            a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_delete_item);
        }
        t.a(this.h, a2, new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        this.G.clear();
        this.J.clear();
        int size = this.L.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.zte.iptvclient.android.common.javabean.models.i iVar = this.L.get(i2);
            if (TextUtils.equals(new SimpleDateFormat("yyyy.MM.dd").format(Long.valueOf(System.currentTimeMillis())), iVar.c())) {
                this.G.add(iVar);
            } else {
                this.J.add(iVar);
            }
        }
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        if (!this.E) {
            return false;
        }
        this.E = false;
        M();
        R();
        return true;
    }

    String I() {
        return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(s.b());
    }

    public void J() {
        this.G = new ArrayList();
        this.J = new ArrayList();
        this.K = new ArrayList();
        if (this.M == null) {
            this.M = new HistorySubView(this.h);
        }
        if (this.N == null) {
            this.N = new HistorySubView(this.h);
        }
        this.M.a(this, this.G, com.zte.iptvclient.android.common.i.a.a.a(R.string.this_week));
        this.N.a(this, this.J, com.zte.iptvclient.android.common.i.a.a.a(R.string.earlier));
        this.O.addView(this.M);
        this.O.addView(this.N);
        this.K.clear();
        this.K.add(this.M);
        this.K.add(this.N);
    }

    void K() {
        W();
        V();
    }

    protected void L() {
        this.v.setVisibility(8);
        this.w.setVisibility(0);
        HistorySubView historySubView = this.M;
        if (historySubView != null) {
            historySubView.a(true);
        }
        HistorySubView historySubView2 = this.N;
        if (historySubView2 != null) {
            historySubView2.a(true);
        }
        O();
    }

    protected void M() {
        this.v.setVisibility(0);
        this.w.setVisibility(8);
        this.x.setVisibility(8);
        HistorySubView historySubView = this.M;
        if (historySubView != null) {
            historySubView.a(false);
        }
        HistorySubView historySubView2 = this.N;
        if (historySubView2 != null) {
            historySubView2.a(false);
        }
        int a2 = a(this.h, 10.0f);
        a(a2, a2, a2, a2);
    }

    public void N() {
        if (U() == 0) {
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

    public void O() {
        int U = U();
        this.u.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(U > 1 ? R.string.bookmark_select_nums : R.string.bookmark_select_num), Integer.valueOf(U)));
        boolean z = U == this.L.size();
        this.F = z;
        this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(z ? R.string.favorite_select_null : R.string.favorite_select_all));
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        P();
        W();
        J();
        V();
        this.z.setClickable(false);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogEx.d(R, "LastWatchFragment onCreate");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LogEx.d(R, "LastWatchFragment onCreateView");
        View inflate = layoutInflater.inflate(R.layout.last_watch_fragment, viewGroup, false);
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        LogEx.d(R, "LastWatchFragment onDestroy");
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        LogEx.d(R, "LastWatchFragment onResume");
        super.onResume();
    }

    public void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_last_watch));
        this.O = (LinearLayout) view.findViewById(R.id.fl_container);
        this.v = (RelativeLayout) view.findViewById(R.id.rl_title);
        Button button = (Button) view.findViewById(R.id.btn_back);
        this.q = button;
        if (this.o) {
            button.setVisibility(0);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.tv_title);
        this.y = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_bookmark));
        TextView textView3 = (TextView) view.findViewById(R.id.tv_edit);
        this.r = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.edit));
        this.p = (ImageView) view.findViewById(R.id.iv_edit);
        this.z = (LinearLayout) view.findViewById(R.id.ll_edit);
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
        this.w = (RelativeLayout) view.findViewById(R.id.rl_edit);
        TextView textView4 = (TextView) view.findViewById(R.id.tv_select_all);
        this.s = textView4;
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.bookmark_select_all));
        TextView textView5 = (TextView) view.findViewById(R.id.tv_select_num);
        this.u = textView5;
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.bookmark_select_num));
        TextView textView6 = (TextView) view.findViewById(R.id.tv_cancel_edit);
        this.t = textView6;
        textView6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel));
        this.A = (LinearLayout) view.findViewById(R.id.ll_cancel_edit);
        ((TextView) view.findViewById(R.id.tv_delete)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.delete));
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_delete);
        this.x = frameLayout;
        com.zte.iptvclient.common.uiframe.f.a(frameLayout);
        this.x.setVisibility(4);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.iv_delete));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.tv_delete));
        this.P = (ImageView) view.findViewById(R.id.iv_animation_loading);
        this.Q = (RelativeLayout) view.findViewById(R.id.rl_loading);
        com.zte.iptvclient.common.uiframe.f.a(this.P);
        com.zte.iptvclient.common.uiframe.f.a(this.Q);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.C = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.C.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.C.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.C.findViewById(R.id.refresh_image));
        this.C.setVisibility(8);
        TextView textView7 = (TextView) this.C.findViewById(R.id.txt_pullrefresh);
        this.D = textView7;
        textView7.setText(this.h.getString(R.string.no_watching_video));
        this.B.a(new DefaultRefreshHeader(this.h));
        this.B.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.B;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.B;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.B.a(true);
        this.B.c(false);
    }

    private void a(int i2, int i3, int i4, int i5) {
        new RelativeLayout.LayoutParams(-1, -2).setMargins(i2, i3, i4, i5);
    }

    public int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(PrevueBean prevueBean) {
        return prevueBean.getBegintime().substring(11, 16) + "-" + prevueBean.getEndtime().substring(11, 16);
    }
}
