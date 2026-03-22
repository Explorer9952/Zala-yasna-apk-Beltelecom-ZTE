package com.zte.iptvclient.android.mobile.e0.e;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.vod.SDKVodMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.vod.entity.GetVodSearchArrayEntity;
import com.zte.iptvclient.android.zala.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ViewMoreVideosFragment.java */
/* loaded from: classes2.dex */
public class o extends com.zte.fragmentlib.b {
    private RelativeLayout A;
    private String p;
    private String q;
    private TextView r;
    private ImageView s;
    private RecyclerView t;
    private com.zte.iptvclient.android.mobile.e0.d.b u;
    private ArrayList<CommonVideoBean> x;
    private SmartRefreshLayout z;
    private int v = 1;
    private int w = 0;
    private boolean y = false;
    private boolean B = false;
    private e C = new e(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewMoreVideosFragment.java */
    /* loaded from: classes2.dex */
    public class a extends GridLayoutManager.b {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GridLayoutManager f6110c;

        a(GridLayoutManager gridLayoutManager) {
            this.f6110c = gridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int b(int i) {
            if (o.this.u.e(i)) {
                return this.f6110c.L();
            }
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewMoreVideosFragment.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentActivity activity = o.this.getActivity();
            if (activity instanceof HostActivity) {
                activity.finish();
            }
            if (activity instanceof MainActivity) {
                o.this.F();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewMoreVideosFragment.java */
    /* loaded from: classes2.dex */
    public class c implements com.scwang.smartrefresh.layout.d.c {
        c() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            o.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewMoreVideosFragment.java */
    /* loaded from: classes2.dex */
    public class d implements com.scwang.smartrefresh.layout.d.a {
        d() {
        }

        @Override // com.scwang.smartrefresh.layout.d.a
        public void b(com.scwang.smartrefresh.layout.a.h hVar) {
            if (o.this.v <= o.this.w) {
                if (TextUtils.isEmpty(o.this.p)) {
                    return;
                }
                LogEx.d("ViewMoreVideosFragment", "sdkQueryVideoByColumnCode for=" + o.this.v);
                o oVar = o.this;
                oVar.a(oVar.p, o.this.v);
                return;
            }
            o.this.M();
            hVar.a(true);
            if (o.this.u != null) {
                o.this.u.b(true);
            }
        }
    }

    /* compiled from: ViewMoreVideosFragment.java */
    /* loaded from: classes2.dex */
    private static final class e extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<o> f6115a;

        public e(o oVar) {
            this.f6115a = new WeakReference<>(oVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            o oVar = this.f6115a.get();
            if (oVar != null && message.what == 20481) {
                if (oVar.v <= 1) {
                    oVar.x.clear();
                    if (oVar.u != null) {
                        oVar.u.d();
                        oVar.u.b(false);
                    }
                }
                GetVodSearchArrayEntity getVodSearchArrayEntity = (GetVodSearchArrayEntity) message.obj;
                if (getVodSearchArrayEntity != null) {
                    oVar.w = getVodSearchArrayEntity.f7643a;
                    oVar.x.addAll(getVodSearchArrayEntity.f7644b);
                    if (oVar.u != null) {
                        oVar.u.d();
                    }
                    o.c(oVar);
                    if (oVar.v > oVar.w) {
                        oVar.B = true;
                    } else {
                        oVar.B = false;
                    }
                }
                if (oVar.u != null) {
                    oVar.M();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewMoreVideosFragment.java */
    /* loaded from: classes2.dex */
    public class f extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private String f6116a;

        /* renamed from: b, reason: collision with root package name */
        private String f6117b;

        /* renamed from: c, reason: collision with root package name */
        private String f6118c;

        /* renamed from: d, reason: collision with root package name */
        private String f6119d;
        private String e;

        /* compiled from: ViewMoreVideosFragment.java */
        /* loaded from: classes2.dex */
        class a implements SDKVodMgr.OnVodSearchListReturnListener {
            a() {
            }

            @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnVodSearchListReturnListener
            public void onVodSearchListReturn(String str, String str2, String str3) {
                LogEx.d("ViewMoreVideosFragment", "onVodSearchListReturn , data : " + str3);
                Message obtain = Message.obtain();
                obtain.what = 20481;
                if (TextUtils.equals(str, "0")) {
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        int optInt = jSONObject.optInt("totalcount");
                        GetVodSearchArrayEntity getVodSearchArrayEntity = new GetVodSearchArrayEntity();
                        getVodSearchArrayEntity.f7643a = (optInt + 23) / 24;
                        o.this.a(jSONObject.optJSONArray("data"), getVodSearchArrayEntity);
                        obtain.obj = getVodSearchArrayEntity;
                    } catch (Exception e) {
                        e.printStackTrace();
                        LogEx.e("ViewMoreVideosFragment", e.getMessage());
                    }
                }
                o.this.C.sendMessage(obtain);
            }
        }

        public f(String str, String str2, String str3, String str4, String str5) {
            this.f6116a = str;
            this.f6117b = str2;
            this.f6118c = str3;
            this.f6119d = str4;
            this.e = str5;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("pageno", this.f6116a);
            hashMap.put("numperpage", this.f6117b);
            hashMap.put("columncode", this.f6118c);
            hashMap.put("ordertype", this.f6119d);
            hashMap.put(ParamConst.COLUMN_INFO_RSP_SUBEXIST, this.e);
            hashMap.put("seriestype", "1,3");
            if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
                hashMap.put("isfilterratingid", "1");
                LogEx.d("ViewMoreVideosFragment", " Child Mode getVodSearchList param ratingid");
            }
            hashMap.put("isadult", "0");
            new SDKVodMgr().getVodSearchList(hashMap, new a());
        }
    }

    private void J() {
        if (TextUtils.isEmpty(this.p)) {
            return;
        }
        this.v = 1;
        a(this.p, 1);
    }

    private void K() {
        this.s.setOnClickListener(new b());
        this.z.a(new c());
        this.z.a(new d());
    }

    private void L() {
        GridLayoutManager gridLayoutManager;
        this.u = new com.zte.iptvclient.android.mobile.e0.d.b(this.h, this.x);
        if (TextUtils.equals(this.q, com.zte.iptvclient.android.common.i.a.a.a(R.string.vip_product_movies))) {
            this.u.c(true);
        }
        if (BaseApp.a(this.h)) {
            gridLayoutManager = new GridLayoutManager(this.h, 8);
        } else {
            gridLayoutManager = new GridLayoutManager(this.h, 3);
        }
        gridLayoutManager.a(new a(gridLayoutManager));
        this.t.a(gridLayoutManager);
        if (BaseApp.a(this.h)) {
            this.t.a(new com.zte.iptvclient.android.common.customview.viewgroup.a.c(8, com.zte.iptvclient.android.common.k.g.a(this.h, 6.0f), true));
        } else {
            this.t.a(new com.zte.iptvclient.android.common.customview.viewgroup.a.c(3, com.zte.iptvclient.android.common.k.g.a(this.h, 6.0f), true));
        }
        this.t.d(true);
        this.t.a(this.u);
        J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        this.y = false;
        this.z.a();
        this.z.j();
        ArrayList<CommonVideoBean> arrayList = this.x;
        if (arrayList != null) {
            if (arrayList.size() == 0) {
                this.A.setVisibility(0);
                this.t.setVisibility(8);
            } else {
                this.A.setVisibility(8);
                this.t.setVisibility(0);
            }
            if (this.x.size() >= 24 && !this.B) {
                this.u.b(false);
            } else {
                this.u.b(true);
            }
        }
    }

    static /* synthetic */ int c(o oVar) {
        int i = oVar.v;
        oVar.v = i + 1;
        return i;
    }

    public void I() {
        if (TextUtils.isEmpty(this.p) || this.y) {
            return;
        }
        this.v = 1;
        this.B = false;
        this.z.a(false);
        LogEx.d("ViewMoreVideosFragment", "sdkQueryVideoByColumnCode for=" + this.v);
        a(this.p, this.v);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        L();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.p = arguments.getString("Columncode");
            this.q = arguments.getString("Columnname");
        }
        onHiddenChanged(false);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.view_more_videos_fragment, viewGroup, false);
        d(inflate);
        K();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
    }

    private void d(View view) {
        com.zte.iptvclient.android.common.k.g.a(this.h, view, R.id.header_bottom_line);
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            view.findViewById(R.id.ll_video_all_container).setBackgroundResource(R.drawable.bg_child);
        } else if (BaseApp.f()) {
            view.findViewById(R.id.ll_video_all_container).setBackgroundResource(R.drawable.bg_pad);
        }
        this.s = (ImageView) view.findViewById(R.id.img_view_more_back);
        TextView textView2 = (TextView) view.findViewById(R.id.head_title_text);
        this.r = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_all));
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        this.z = smartRefreshLayout;
        smartRefreshLayout.a(new DefaultRefreshHeader(this.h));
        this.z.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout2 = this.z;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout2.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout3 = this.z;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout3.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.z.c(false);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.A = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.A.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.A.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.A.findViewById(R.id.refresh_image));
        this.A.setVisibility(8);
        this.t = (RecyclerView) view.findViewById(R.id.rv_video);
        this.x = new ArrayList<>();
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_view_more_title));
        this.r.setText(this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        this.y = true;
        new f(String.valueOf(i), String.valueOf(24), str, "0", "0").start();
    }

    protected void a(JSONArray jSONArray, GetVodSearchArrayEntity getVodSearchArrayEntity) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                getVodSearchArrayEntity.f7644b.add(CommonVideoBean.a(jSONArray.getJSONObject(i)));
            } catch (Exception e2) {
                e2.printStackTrace();
                LogEx.e("ViewMoreVideosFragment", e2.getMessage());
                return;
            }
        }
    }
}
