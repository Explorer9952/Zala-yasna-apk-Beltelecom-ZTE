package com.zte.iptvclient.android.mobile.home.ui.columnview;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.recommend.SDKRecommendMgr;
import com.video.androidsdk.service.vod.SDKVodMgr;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import com.zte.iptvclient.android.common.k.o;
import com.zte.iptvclient.android.common.k.u;
import com.zte.iptvclient.android.mobile.home.ui.layout.linearLayout.GeneralColumnView;
import com.zte.iptvclient.android.mobile.l.a.d;
import com.zte.iptvclient.android.mobile.vod.ui.columnview.MyGridLayoutManager;
import com.zte.iptvclient.android.zala.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class HomeHorizontalCustomView extends GeneralColumnView {

    /* renamed from: a, reason: collision with root package name */
    private int f6435a;

    /* renamed from: b, reason: collision with root package name */
    private Context f6436b;

    /* renamed from: c, reason: collision with root package name */
    private String f6437c;

    /* renamed from: d, reason: collision with root package name */
    private int f6438d;
    private g e;
    private ConstraintLayout f;
    private RelativeLayout g;
    private TextView h;
    private ImageView i;
    private RelativeLayout j;
    private RecyclerView k;
    private com.zte.iptvclient.android.mobile.l.a.d l;
    private LinearLayout m;
    private ArrayList<CommonVideoBean> n;
    private String o;
    private String p;
    private f q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements SDKVodMgr.OnVodSearchListReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnVodSearchListReturnListener
        public void onVodSearchListReturn(String str, String str2, String str3) {
            LogEx.d("HomeHorizontalCustomView", " returncode : " + str + ", errormsg : " + str2 + ", data : " + str3);
            if (!TextUtils.equals(str, "0")) {
                HomeHorizontalCustomView.this.e();
                HomeHorizontalCustomView.this.q.sendEmptyMessage(63490);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str3);
                LogEx.d("HomeHorizontalCustomView", "sdkQueryRecommentByEpg:" + jSONObject.toString());
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(CommonVideoBean.a(jSONArray.getJSONObject(i)));
                }
                Message obtain = Message.obtain();
                obtain.what = 63489;
                obtain.obj = arrayList;
                HomeHorizontalCustomView.this.q.sendMessage(obtain);
            } catch (Exception e) {
                LogEx.d("HomeHorizontalCustomView", "sdkQueryRecommentByEpg  exception = " + e.getMessage());
                HomeHorizontalCustomView.this.q.sendEmptyMessage(63490);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements SDKRecommendMgr.OnHotRankListReturnListener {
        b() {
        }

        @Override // com.video.androidsdk.service.recommend.SDKRecommendMgr.OnHotRankListReturnListener
        public void onHotRankListReturn(String str, String str2, String str3) {
            LogEx.d("HomeHorizontalCustomView", "returncode : " + str + ", errormsg : " + str2 + ", data : " + str3);
            if (!TextUtils.equals(str, "0")) {
                HomeHorizontalCustomView.this.e();
                HomeHorizontalCustomView.this.q.sendEmptyMessage(63490);
                return;
            }
            try {
                JSONArray jSONArray = new JSONObject(str3).getJSONArray("programinfo");
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(CommonVideoBean.a(jSONArray.getJSONObject(i)));
                }
                Message obtain = Message.obtain();
                obtain.what = 63489;
                obtain.obj = arrayList;
                HomeHorizontalCustomView.this.q.sendMessage(obtain);
            } catch (Exception e) {
                LogEx.e("HomeHorizontalCustomView", e.getMessage());
                HomeHorizontalCustomView.this.q.sendEmptyMessage(63490);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements SDKRecommendMgr.OnCollaborateRankListReturnListener {
        c() {
        }

        @Override // com.video.androidsdk.service.recommend.SDKRecommendMgr.OnCollaborateRankListReturnListener
        public void onCollaborateRankListReturn(String str, String str2, String str3) {
            LogEx.d("HomeHorizontalCustomView", "returncode : " + str + ", errormsg : " + str2 + ", data : " + str3);
            if (!TextUtils.equals(str, "0")) {
                HomeHorizontalCustomView.this.e();
                HomeHorizontalCustomView.this.q.sendEmptyMessage(63490);
                return;
            }
            try {
                JSONArray jSONArray = new JSONObject(str3).getJSONArray("programinfo");
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(CommonVideoBean.a(jSONArray.getJSONObject(i)));
                }
                Message obtain = Message.obtain();
                obtain.what = 63489;
                obtain.obj = arrayList;
                HomeHorizontalCustomView.this.q.sendMessage(obtain);
            } catch (Exception e) {
                LogEx.e("HomeHorizontalCustomView", e.getMessage());
                HomeHorizontalCustomView.this.q.sendEmptyMessage(63490);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements d.b {
        d() {
        }

        @Override // com.zte.iptvclient.android.mobile.l.a.d.b
        public void a(int i, CommonVideoBean commonVideoBean) {
            HomeHorizontalCustomView.this.a(commonVideoBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            HomeHorizontalCustomView.this.h();
        }
    }

    /* loaded from: classes.dex */
    private static final class f extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<HomeHorizontalCustomView> f6444a;

        public f(HomeHorizontalCustomView homeHorizontalCustomView) {
            this.f6444a = new WeakReference<>(homeHorizontalCustomView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            HomeHorizontalCustomView homeHorizontalCustomView = this.f6444a.get();
            if (homeHorizontalCustomView == null) {
                return;
            }
            switch (message.what) {
                case 63489:
                    homeHorizontalCustomView.n.clear();
                    homeHorizontalCustomView.n.addAll((ArrayList) message.obj);
                    homeHorizontalCustomView.setVisibility(0);
                    homeHorizontalCustomView.i();
                    if (homeHorizontalCustomView.e != null) {
                        homeHorizontalCustomView.e.a(homeHorizontalCustomView.f6438d);
                        return;
                    }
                    return;
                case 63490:
                    if (homeHorizontalCustomView.e != null) {
                        homeHorizontalCustomView.e.a(homeHorizontalCustomView.f6438d);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(int i);
    }

    public HomeHorizontalCustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6435a = 0;
        this.n = new ArrayList<>();
        this.q = new f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        u.a((Activity) this.f6436b, this.f6438d, this.f6437c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.n.size() <= 0) {
            e();
            return;
        }
        this.j.setVisibility(0);
        this.g.setVisibility(0);
        this.l.d();
    }

    private void b() {
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Video_Column");
        SDKRecommendMgr sDKRecommendMgr = new SDKRecommendMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("rec_num", this.o);
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
        sDKRecommendMgr.setServerDomain(this.p);
        sDKRecommendMgr.getCollaborateRankList(hashMap, new c());
    }

    private void c() {
        SDKVodMgr sDKVodMgr = new SDKVodMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pageno", "1");
        hashMap.put("numperpage", this.o);
        hashMap.put("columncode", com.zte.iptvclient.android.mobile.home.tab.helper.b.b());
        hashMap.put("ordertype", DownloadConstant.REPORT_MSGTYPE_URL_NULL);
        hashMap.put("isadult", "0");
        sDKVodMgr.getVodSearchList(hashMap, new a());
    }

    private void d() {
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Video_Column");
        SDKRecommendMgr sDKRecommendMgr = new SDKRecommendMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("rec_num", this.o);
        hashMap.put("langtype", com.zte.iptvclient.android.common.i.a.a.a(R.string.search_language_type));
        hashMap.put("mediaservices", "2");
        hashMap.put("contenttype", "1,14");
        hashMap.put("sorttype", "0");
        hashMap.put(ParamConst.VOD_DETAIL_RECOMMEND_REQ_SID, "1");
        hashMap.put("columncode", propertiesInfo);
        hashMap.put("ungenre", com.zte.iptvclient.android.mobile.home.tab.helper.b.a());
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Un_Recommend_VodColumn");
        if (!TextUtils.isEmpty(c2)) {
            hashMap.put(ParamConst.VOD_DETAIL_RECOMMEND_REQ_COLUMNLOCK, c2);
        }
        hashMap.put("seriestype", "1,3");
        sDKRecommendMgr.setServerDomain(this.p);
        sDKRecommendMgr.getHotRankList(hashMap, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        setVisibility(0);
        this.g.setVisibility(8);
        this.j.setVisibility(8);
    }

    private void f() {
        int i = this.f6438d;
        if (i == 1) {
            c();
        } else if (i == 2) {
            b();
        } else if (i == 3) {
            d();
        }
    }

    private void g() {
        this.h.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_all));
        this.h.setVisibility(0);
        this.i.setVisibility(0);
        this.g.setOnClickListener(new e());
    }

    private void a(Context context) {
        View inflate = View.inflate(context, R.layout.home_column_one_horizontal_third_vertical_layout, this);
        this.f = (ConstraintLayout) inflate.findViewById(R.id.common_column_header_rlayout);
        this.g = (RelativeLayout) inflate.findViewById(R.id.rl_next_all);
        com.zte.iptvclient.common.uiframe.f.a(this.f);
        com.zte.iptvclient.common.uiframe.f.a(this.g);
        this.j = (RelativeLayout) findViewById(R.id.rl_rv_container);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.home_dynamic_column_videos_recyclerview);
        this.k = recyclerView;
        com.zte.iptvclient.common.uiframe.f.a(recyclerView);
        com.zte.iptvclient.android.mobile.l.a.d dVar = new com.zte.iptvclient.android.mobile.l.a.d(this.f6436b, this.n);
        this.l = dVar;
        this.k.a(dVar);
        a(this.f6435a);
        this.l.a(new d());
        TextView textView = (TextView) inflate.findViewById(R.id.column_title_txt);
        com.zte.iptvclient.common.uiframe.f.a(textView);
        textView.setText(this.f6437c);
        com.zte.iptvclient.android.mobile.e0.f.g.a((ImageView) inflate.findViewById(R.id.column_img), textView);
        this.h = (TextView) inflate.findViewById(R.id.more_text);
        this.i = (ImageView) inflate.findViewById(R.id.more_icon);
        com.zte.iptvclient.common.uiframe.f.a(this.h);
        com.zte.iptvclient.common.uiframe.f.a(this.i);
        g();
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ll_buttom_layout);
        this.m = linearLayout;
        com.zte.iptvclient.common.uiframe.f.a(linearLayout);
        this.m.setVisibility(8);
    }

    public HomeHorizontalCustomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6435a = 0;
        this.n = new ArrayList<>();
        this.q = new f(this);
    }

    public HomeHorizontalCustomView(Context context, String str, int i, g gVar) {
        super(context);
        this.f6435a = 0;
        this.n = new ArrayList<>();
        this.q = new f(this);
        this.f6436b = context;
        new h(context);
        this.e = gVar;
        this.f6437c = str;
        this.f6438d = i;
        if (BaseApp.a(this.f6436b)) {
            this.f6435a = 0;
            this.o = "8";
        } else {
            this.f6435a = 1;
            this.o = DownloadConstant.REPORT_MSGTYPE_URL_NULL;
        }
        this.p = o.j().f();
        a(context);
    }

    private void a(int i) {
        if (i == 0) {
            if (this.k != null) {
                this.k.a(new MyGridLayoutManager(this.f6436b, 8));
                this.k.a(new com.zte.iptvclient.android.mobile.e0.c(8, com.zte.iptvclient.android.common.k.g.a(this.f6436b, 16.0f), true, "0"));
                com.zte.iptvclient.android.mobile.l.a.d dVar = this.l;
                if (dVar != null) {
                    dVar.e(8);
                    return;
                }
                return;
            }
            return;
        }
        if (i != 1) {
            return;
        }
        if (this.k != null) {
            this.k.a(new MyGridLayoutManager(this.f6436b, 3));
            this.k.a(new com.zte.iptvclient.android.mobile.e0.c(3, com.zte.iptvclient.android.common.k.g.a(this.f6436b, 6.0f), true, "0"));
        }
        com.zte.iptvclient.android.mobile.l.a.d dVar2 = this.l;
        if (dVar2 != null) {
            dVar2.e(6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CommonVideoBean commonVideoBean) {
        String f2 = commonVideoBean.f();
        if (TextUtils.isEmpty(f2)) {
            return;
        }
        if (f2.equals("1")) {
            u.c((Activity) this.f6436b, commonVideoBean.d(), commonVideoBean.a());
            return;
        }
        if (f2.equals("14")) {
            u.a((Activity) this.f6436b, commonVideoBean.d(), commonVideoBean.a());
        } else if ("10".equals(f2)) {
            u.a((Activity) this.f6436b, commonVideoBean.i(), commonVideoBean.a(), commonVideoBean.h());
        }
    }

    public void a() {
        f();
    }
}
