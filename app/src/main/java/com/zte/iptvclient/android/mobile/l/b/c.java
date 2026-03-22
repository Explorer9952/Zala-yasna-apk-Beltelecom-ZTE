package com.zte.iptvclient.android.mobile.l.b;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.a.h;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.recommend.SDKRecommendMgr;
import com.video.androidsdk.service.vod.SDKVodMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import com.zte.iptvclient.android.common.javabean.models.MovieDetailBundleBean;
import com.zte.iptvclient.android.common.k.o;
import com.zte.iptvclient.android.common.k.u;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: HomeCustomMoreFragment.java */
/* loaded from: classes.dex */
public class c extends com.zte.fragmentlib.b {
    private SDKRecommendMgr A;
    private SDKRecommendMgr B;
    private int p;
    private String q;
    private ArrayList<CommonVideoBean> r;
    private com.zte.iptvclient.android.mobile.e0.d.a s;
    private SmartRefreshLayout w;
    private GridView x;
    private String y;
    private int t = 1;
    private boolean u = false;
    private long v = 0;
    private int z = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeCustomMoreFragment.java */
    /* loaded from: classes.dex */
    public class a implements com.scwang.smartrefresh.layout.d.c {
        a() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(h hVar) {
            c.this.t = 1;
            c.this.w.a(false);
            c.this.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeCustomMoreFragment.java */
    /* loaded from: classes.dex */
    public class b implements com.scwang.smartrefresh.layout.d.a {
        b() {
        }

        @Override // com.scwang.smartrefresh.layout.d.a
        public void b(h hVar) {
            c.this.O();
            hVar.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeCustomMoreFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.l.b.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0301c implements View.OnClickListener {
        ViewOnClickListenerC0301c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.getActivity() instanceof HostActivity) {
                c.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeCustomMoreFragment.java */
    /* loaded from: classes.dex */
    public class d implements SDKVodMgr.OnVodSearchListReturnListener {
        d() {
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnVodSearchListReturnListener
        public void onVodSearchListReturn(String str, String str2, String str3) {
            LogEx.d("HomeCustomMoreFragment", " returncode : " + str + ", errormsg : " + str2 + ", data : " + str3);
            if (c.this.s(str)) {
                return;
            }
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    LogEx.d("HomeCustomMoreFragment", "sdkQueryRecommentByEpg:" + jSONObject.toString());
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(CommonVideoBean.a(jSONArray.getJSONObject(i)));
                    }
                    c.this.b((ArrayList<CommonVideoBean>) arrayList);
                } catch (Exception e) {
                    LogEx.d("HomeCustomMoreFragment", "sdkQueryRecommentByEpg  exception = " + e.getMessage());
                }
            }
            c.this.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeCustomMoreFragment.java */
    /* loaded from: classes.dex */
    public class e implements SDKRecommendMgr.OnCollaborateRankListReturnListener {
        e() {
        }

        @Override // com.video.androidsdk.service.recommend.SDKRecommendMgr.OnCollaborateRankListReturnListener
        public void onCollaborateRankListReturn(String str, String str2, String str3) {
            LogEx.d("HomeCustomMoreFragment", "returncode : " + str + ", errormsg : " + str2 + ", data : " + str3);
            if (c.this.s(str)) {
                return;
            }
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("programinfo");
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(CommonVideoBean.a(jSONArray.getJSONObject(i)));
                    }
                    c.this.b((ArrayList<CommonVideoBean>) arrayList);
                } catch (Exception e) {
                    LogEx.e("HomeCustomMoreFragment", e.getMessage());
                }
            }
            c.this.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeCustomMoreFragment.java */
    /* loaded from: classes.dex */
    public class f implements SDKRecommendMgr.OnHotRankListReturnListener {
        f() {
        }

        @Override // com.video.androidsdk.service.recommend.SDKRecommendMgr.OnHotRankListReturnListener
        public void onHotRankListReturn(String str, String str2, String str3) {
            LogEx.d("HomeCustomMoreFragment", "returncode : " + str + ", errormsg : " + str2 + ", data : " + str3);
            if (c.this.s(str)) {
                return;
            }
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("programinfo");
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(CommonVideoBean.a(jSONArray.getJSONObject(i)));
                    }
                    c.this.b((ArrayList<CommonVideoBean>) arrayList);
                } catch (Exception e) {
                    LogEx.e("HomeCustomMoreFragment", e.getMessage());
                }
            }
            c.this.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HomeCustomMoreFragment.java */
    /* loaded from: classes.dex */
    public class g implements AdapterView.OnItemClickListener {
        private g() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            CommonVideoBean commonVideoBean;
            String f;
            if (c.this.M() || (commonVideoBean = (CommonVideoBean) c.this.r.get(i)) == null || (f = commonVideoBean.f()) == null) {
                return;
            }
            if (f.equals("1")) {
                c.this.t(commonVideoBean.d());
            } else if (f.equals("14")) {
                c.this.e(commonVideoBean.d(), commonVideoBean.a());
            } else if ("10".equals(f)) {
                u.a(c.this.getActivity(), commonVideoBean.i(), commonVideoBean.a(), commonVideoBean.h());
            }
        }

        /* synthetic */ g(c cVar, a aVar) {
            this();
        }
    }

    private void I() {
        SDKRecommendMgr sDKRecommendMgr = this.A;
        if (sDKRecommendMgr != null) {
            sDKRecommendMgr.cancelRequest();
        }
        SDKRecommendMgr sDKRecommendMgr2 = this.B;
        if (sDKRecommendMgr2 != null) {
            sDKRecommendMgr2.cancelRequest();
        }
    }

    private void J() {
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Video_Column");
        this.A = new SDKRecommendMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("rec_num", String.valueOf(50));
        hashMap.put("bocode", SDKLoginMgr.getInstance().getUserInfo(ParamConst.LOGIN_PORTALAUTH_RSP_BOCODE));
        hashMap.put("langtype", com.zte.iptvclient.android.common.i.a.a.a(R.string.search_language_type));
        hashMap.put(ParamConst.VOD_DETAIL_RECOMMEND_REQ_ALGORITHM, "4");
        hashMap.put("contenttype", "1,14");
        hashMap.put(ParamConst.VOD_DETAIL_RECOMMEND_REQ_SID, "1");
        hashMap.put("mediaservices", "2");
        hashMap.put("columncode", propertiesInfo);
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Un_Recommend_VodColumn");
        if (!TextUtils.isEmpty(c2)) {
            hashMap.put(ParamConst.VOD_DETAIL_RECOMMEND_REQ_COLUMNLOCK, c2);
        }
        hashMap.put("ungenre", com.zte.iptvclient.android.mobile.home.tab.helper.b.a());
        hashMap.put("seriestype", "1,3");
        this.A.setServerDomain(this.y);
        this.A.getCollaborateRankList(hashMap, new e());
    }

    private void K() {
        SDKVodMgr sDKVodMgr = new SDKVodMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pageno", String.valueOf(this.t));
        hashMap.put("numperpage", String.valueOf(50));
        hashMap.put("columncode", com.zte.iptvclient.android.mobile.home.tab.helper.b.b());
        hashMap.put("ordertype", DownloadConstant.REPORT_MSGTYPE_URL_NULL);
        hashMap.put("seriestype", "1,3");
        hashMap.put("isadult", "0");
        sDKVodMgr.getVodSearchList(hashMap, new d());
    }

    private void L() {
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Video_Column");
        this.B = new SDKRecommendMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("rec_num", String.valueOf(50));
        hashMap.put("langtype", com.zte.iptvclient.android.common.i.a.a.a(R.string.search_language_type));
        hashMap.put("mediaservices", "2");
        hashMap.put("contenttype", "1,14");
        hashMap.put("sorttype", "0");
        hashMap.put(ParamConst.VOD_DETAIL_RECOMMEND_REQ_SID, "1");
        hashMap.put("columncode", propertiesInfo);
        hashMap.put("ungenre", com.zte.iptvclient.android.mobile.home.tab.helper.b.a());
        hashMap.put("seriestype", "1,3");
        this.B.setServerDomain(this.y);
        this.B.getHotRankList(hashMap, new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.v <= 500) {
            LogEx.w("HomeCustomMoreFragment", "Operate limit,less than 500(ms)!");
            return true;
        }
        this.v = currentTimeMillis;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (this.u) {
            return;
        }
        this.u = true;
        int i = this.p;
        if (i == 1) {
            K();
        } else if (i == 2) {
            J();
        } else if (i == 3) {
            L();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        this.u = false;
        this.w.a();
        this.w.j();
    }

    private void P() {
        this.r = new ArrayList<>();
        com.zte.iptvclient.android.mobile.e0.d.a aVar = new com.zte.iptvclient.android.mobile.e0.d.a(this.h, this.r);
        this.s = aVar;
        this.x.setAdapter((ListAdapter) aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s(String str) {
        if (!"18501004".equals(str)) {
            return false;
        }
        int i = this.z;
        if (i < 3) {
            this.z = i + 1;
            this.u = false;
            N();
        } else {
            this.z = 1;
            O();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str);
        Intent intent = new Intent(getActivity(), (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "moviedetail");
        intent.putExtras(bundle);
        getActivity().startActivity(intent);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        N();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.p = arguments.getInt("colType");
            this.q = arguments.getString("ColumnName");
        }
        this.y = o.j().f();
        new com.zte.iptvclient.android.common.j.h(this.h);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.home_more_fragment, viewGroup, false);
        d(inflate);
        P();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        I();
    }

    private void d(View view) {
        com.zte.iptvclient.android.common.k.g.a(this.h, view, R.id.header_bottom_line);
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        textView.setVisibility(0);
        this.x = (GridView) view.findViewById(R.id.pull_refresh_grid);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        this.w = smartRefreshLayout;
        smartRefreshLayout.a(new DefaultRefreshHeader(this.h));
        this.w.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout2 = this.w;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout2.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout3 = this.w;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout3.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.w.c(false);
        Button button = (Button) view.findViewById(R.id.btn_back);
        TextView textView2 = (TextView) view.findViewById(R.id.title_txt);
        if (!TextUtils.isEmpty(this.q)) {
            textView2.setText(this.q);
        }
        this.w.a(new a());
        this.w.a(new b());
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(button);
        com.zte.iptvclient.common.uiframe.f.a(textView2);
        button.setOnClickListener(new ViewOnClickListenerC0301c());
        this.x.setOnItemClickListener(new g(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str);
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, str2);
        Intent intent = new Intent(getActivity(), (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "seriesdetail");
        intent.putExtras(bundle);
        getActivity().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<CommonVideoBean> arrayList) {
        if (this.t <= 1) {
            this.r.clear();
        }
        this.r.addAll(arrayList);
        this.s.notifyDataSetChanged();
    }
}
