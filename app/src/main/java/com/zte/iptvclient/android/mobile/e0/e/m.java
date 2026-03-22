package com.zte.iptvclient.android.mobile.e0.e;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.impl.IIPTVLogin;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.vod.SDKVodMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.a.a.e.g;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.vod.videofilter.ui.VideoFilterMultiSelectHeadView;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: VideoFilterFragment.java */
/* loaded from: classes2.dex */
public class m extends com.zte.fragmentlib.b implements g.a {
    private static final String V = m.class.getSimpleName();
    private String B;
    private RecyclerView C;
    private String G;
    private TextView K;
    private SDKVodMgr L;
    private String M;
    private String N;
    private String O;
    private String P;
    private String Q;
    private String R;
    private int S;
    private Button p;
    private TextView q;
    private SmartRefreshLayout r;
    private RelativeLayout s;
    private TextView t;
    private VideoFilterMultiSelectHeadView u;
    private RelativeLayout v;
    private ArrayList<CommonVideoBean> w;
    private com.zte.iptvclient.android.mobile.e0.d.d x;
    private int y = 1;
    private int z = 0;
    private boolean A = false;
    private boolean D = false;
    private int E = 1;
    private int F = 0;
    private GridLayoutManager J = null;
    private String[] T = new String[0];
    private l U = new l(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoFilterFragment.java */
    /* loaded from: classes2.dex */
    public class a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!TextUtils.isEmpty(m.this.B)) {
                    LogEx.d(m.V, "sdkQueryVideoByDouban onDataReturn : object " + jSONObject.toString());
                    m.this.b(jSONObject);
                }
            } catch (Exception e) {
                LogEx.d(m.V, "sdkQueryVideoByDouban exception = " + e.getMessage());
            }
            m.this.N();
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d(m.V, "sdkQueryVideoByDouban  onFailReturn,arg0= " + str + " ,arg1=" + i);
            m.this.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoFilterFragment.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m.this.getActivity() instanceof MainActivity) {
                m.this.F();
            } else if (m.this.getActivity() instanceof HostActivity) {
                m.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoFilterFragment.java */
    /* loaded from: classes2.dex */
    public class c implements com.scwang.smartrefresh.layout.d.c {
        c() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            m.this.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoFilterFragment.java */
    /* loaded from: classes2.dex */
    public class d implements com.scwang.smartrefresh.layout.d.a {
        d() {
        }

        @Override // com.scwang.smartrefresh.layout.d.a
        public void b(com.scwang.smartrefresh.layout.a.h hVar) {
            if (m.this.D) {
                if (m.this.E <= m.this.F) {
                    if (TextUtils.isEmpty(m.this.B)) {
                        return;
                    }
                    LogEx.d(m.V, "sdkQueryTopDoubanList for=" + m.this.E);
                    m mVar = m.this;
                    mVar.d(mVar.E);
                    return;
                }
                hVar.a(true);
                m.this.N();
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.load_data_complete);
                return;
            }
            if (m.this.y <= m.this.z) {
                if (TextUtils.isEmpty(m.this.B)) {
                    return;
                }
                LogEx.d(m.V, "sdkQueryVideoByColumnCode for=" + m.this.y);
                m mVar2 = m.this;
                mVar2.e(mVar2.y);
                return;
            }
            hVar.a(true);
            m.this.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoFilterFragment.java */
    /* loaded from: classes2.dex */
    public class e implements SDKVodMgr.OnVodFilterReturnListener {
        e() {
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnVodFilterReturnListener
        public void onVodFilterReturn(String str, String str2, String str3) {
            LogEx.d(m.V, "returncode : " + str + ",data : " + str3);
            if (!TextUtils.equals(str, "0")) {
                m.this.C.setVisibility(0);
                m.this.y = 1;
                m.this.z = 0;
                m mVar = m.this;
                mVar.e(mVar.y);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str3);
                if (!TextUtils.equals(jSONObject.optString("returncode"), "0")) {
                    m.this.J();
                } else {
                    com.zte.iptvclient.android.common.k.h.a().a(new k(jSONObject));
                }
            } catch (Exception e) {
                LogEx.e(m.V, e.getMessage());
                m.this.J();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoFilterFragment.java */
    /* loaded from: classes2.dex */
    public class f implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        f() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d(m.V, "sdk_getcolumngenre onDataReturn s= " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("returncode").equals("0")) {
                    m.this.G = jSONObject.getString(ParamConst.VOD_GET_GENRE_LIST_RSP_GENRENAME);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            m.this.P();
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d(m.V, "sdk_getcolumngenre onDataReturn i= " + i + "  s=" + str);
            m.this.P();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoFilterFragment.java */
    /* loaded from: classes2.dex */
    public class g implements VideoFilterMultiSelectHeadView.d {
        g() {
        }

        @Override // com.zte.iptvclient.android.mobile.vod.videofilter.ui.VideoFilterMultiSelectHeadView.d
        public void a(String str, String str2, String str3, String str4, String str5, String str6) {
            LogEx.d(m.V, "genres: " + str + "\n relaseDates: " + str2 + "\n countrys: " + str3 + "\n ratingIds: " + str4 + "\n frees: " + str5 + "\n ages: " + str6);
            m.this.M = str;
            m.this.N = str2;
            m.this.O = str3;
            m.this.P = str4;
            m.this.Q = str5;
            m.this.R = str6;
            m.this.D = false;
            m.this.w.clear();
            m.this.y = 1;
            m.this.z = 0;
            m.this.r.a(false);
            m mVar = m.this;
            mVar.e(mVar.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoFilterFragment.java */
    /* loaded from: classes2.dex */
    public class h implements SDKVodMgr.OnVodSearchListReturnListener {
        h() {
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnVodSearchListReturnListener
        public void onVodSearchListReturn(String str, String str2, String str3) {
            LogEx.d(m.V, "returncode : " + str + ",errormsg : " + str2 + ",data : " + str3);
            if (!TextUtils.equals(str, "0")) {
                m.this.N();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str3);
                if (TextUtils.isEmpty(m.this.B)) {
                    return;
                }
                m.this.a(jSONObject);
            } catch (Exception e) {
                LogEx.d(m.V, "sdkQueryVideoByColumnCode exception = " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoFilterFragment.java */
    /* loaded from: classes2.dex */
    public class i extends GridLayoutManager.b {
        i() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int b(int i) {
            if (m.this.x.e(i) || m.this.x.f(i)) {
                return m.this.J.L();
            }
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoFilterFragment.java */
    /* loaded from: classes2.dex */
    public class j implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        j() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!TextUtils.isEmpty(m.this.B)) {
                    LogEx.d(m.V, "sdkQueryTopDoubanList onDataReturn : object " + jSONObject.toString());
                    m.this.c(jSONObject);
                }
            } catch (Exception e) {
                LogEx.d(m.V, "sdkQueryTopDoubanList exception = " + e.getMessage());
            }
            m.this.N();
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d(m.V, "sdkQueryTopDoubanList  onFailReturn,arg0= " + str + " ,arg1=" + i);
            m.this.N();
        }
    }

    /* compiled from: VideoFilterFragment.java */
    /* loaded from: classes2.dex */
    private class k implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public JSONObject f6097a;

        public k(JSONObject jSONObject) {
            this.f6097a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            LogEx.d(m.V, "ParseFilterConditionRunnable -> run ");
            String optString = this.f6097a.optString(ParamConst.VOD_GET_GENRE_LIST_RSP_GENRENAME);
            LogEx.d(m.V, "genrename:" + optString);
            String optString2 = this.f6097a.optString("countryname");
            LogEx.d(m.V, "countryname:" + optString2);
            String optString3 = this.f6097a.optString("releasedate");
            String optString4 = this.f6097a.optString("ratingid");
            String optString5 = this.f6097a.optString("genrelock");
            LogEx.d(m.V, "genrelock:" + optString5);
            String optString6 = this.f6097a.optString(ParamConst.VOD_GET_GENRE_LIST_RSP_GENREID);
            LogEx.d(m.V, "genreid:" + optString6);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            String[] c2 = com.zte.iptvclient.android.mobile.e0.f.h.c();
            if (c2 != null) {
                Collections.addAll(arrayList6, c2);
            }
            if (!TextUtils.isEmpty(m.this.G)) {
                Collections.addAll(arrayList, m.this.G.split(","));
            }
            if (!TextUtils.isEmpty(optString2)) {
                Collections.addAll(arrayList2, optString2.split(","));
            }
            if (!TextUtils.isEmpty(optString3)) {
                Collections.addAll(arrayList3, optString3.split(","));
            }
            if (m.this.t(optString4)) {
                Collections.addAll(arrayList4, optString4.split(";"));
            }
            Collections.addAll(arrayList5, com.zte.iptvclient.android.common.i.a.a.a(R.string.filter_free));
            LogEx.d(m.V, "ParseFilterConditionRunnable.run 耗时: " + (SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
            Bundle bundle = new Bundle(5);
            bundle.putSerializable("listGenre", arrayList);
            bundle.putSerializable("listCountry", arrayList2);
            bundle.putSerializable("listReleaseDate", arrayList3);
            bundle.putSerializable("listRatingId", arrayList4);
            bundle.putSerializable("listFree", arrayList5);
            bundle.putSerializable("listAge", arrayList6);
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = bundle;
            m.this.U.sendMessage(obtain);
        }
    }

    /* compiled from: VideoFilterFragment.java */
    /* loaded from: classes2.dex */
    static final class l extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<m> f6099a;

        public l(m mVar) {
            this.f6099a = new WeakReference<>(mVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            m mVar = this.f6099a.get();
            if (mVar == null) {
                return;
            }
            int i = message.what;
            if (i == 1) {
                Bundle bundle = (Bundle) message.obj;
                mVar.a((ArrayList) bundle.getSerializable("listGenre"), (ArrayList) bundle.getSerializable("listReleaseDate"), (ArrayList) bundle.getSerializable("listCountry"), (ArrayList) bundle.getSerializable("listRatingId"), (ArrayList) bundle.getSerializable("listFree"), (ArrayList) bundle.getSerializable("listAge"));
                return;
            }
            if (i != 2) {
                return;
            }
            ArrayList arrayList = (ArrayList) message.obj;
            int size = mVar.w.size();
            mVar.w.addAll(arrayList);
            if (mVar.x != null) {
                int i2 = mVar.x.f(0) ? size + 1 : size;
                if (size == 0) {
                    mVar.x.d();
                } else {
                    mVar.x.b(i2, arrayList.size());
                    mVar.x.a(i2, mVar.x.a());
                }
            }
            mVar.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VideoFilterFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.e0.e.m$m, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0241m implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private JSONObject f6100a;

        public RunnableC0241m(JSONObject jSONObject) {
            this.f6100a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            ArrayList arrayList = new ArrayList();
            try {
                m.this.z = (this.f6100a.optInt("totalcount") + 23) / 24;
                JSONArray jSONArray = this.f6100a.getJSONArray("data");
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(CommonVideoBean.a(jSONArray.getJSONObject(i)));
                }
            } catch (Exception e) {
                e.printStackTrace();
                LogEx.e(m.V, e.getMessage());
            }
            LogEx.d(m.V, "VodSearchListReturnRunnable.run 耗时: " + (SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = arrayList;
            m.this.U.sendMessage(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        ArrayList<CommonVideoBean> arrayList = this.w;
        if (arrayList != null && arrayList.size() > 0) {
            this.v.setVisibility(8);
        } else {
            this.v.setVisibility(0);
        }
        this.C.setVisibility(8);
        this.h.d();
        this.A = false;
    }

    private String K() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.M)) {
            sb.append(this.M);
        }
        if (!TextUtils.isEmpty(this.R)) {
            if (sb.length() > 0) {
                sb.append(";");
            }
            sb.append(this.R);
        }
        return sb.toString();
    }

    private void L() {
        s(this.B);
    }

    private void M() {
        this.p.setOnClickListener(new b());
        this.r.a(new c());
        this.r.a(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        this.h.d();
        this.r.a();
        this.r.j();
        if (this.x == null) {
            com.zte.iptvclient.android.mobile.e0.d.d dVar = new com.zte.iptvclient.android.mobile.e0.d.d(this.h, this.w);
            this.x = dVar;
            dVar.a(this.u);
            if (BaseApp.a(this.h)) {
                this.J = new GridLayoutManager(this.h, 8);
                this.C.a(new com.zte.iptvclient.android.common.customview.viewgroup.a.a(8, com.zte.iptvclient.android.common.k.g.a(this.h, 16.0f), true));
                this.C.k(5);
            } else {
                this.J = new GridLayoutManager(this.h, 3);
                this.C.a(new com.zte.iptvclient.android.common.customview.viewgroup.a.a(3, com.zte.iptvclient.android.common.k.g.a(this.h, 6.0f), true));
            }
            this.J.a(new i());
            this.C.a(this.J);
            this.C.d(true);
            this.C.a(this.x);
            this.C.v().a(1, 16);
        }
        if (this.D) {
            if (this.E >= this.F) {
                this.x.b(true);
            } else {
                this.x.b(false);
            }
            this.x.d();
            this.A = false;
            this.E++;
        } else {
            if (this.y >= this.z) {
                this.x.b(true);
            } else {
                this.x.b(false);
            }
            this.A = false;
            this.y++;
        }
        ArrayList<CommonVideoBean> arrayList = this.w;
        if (arrayList != null && arrayList.size() > 0) {
            this.v.setVisibility(8);
        } else {
            this.v.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        if (this.A) {
            return;
        }
        this.y = 1;
        this.w.clear();
        this.z = 0;
        this.r.a(false);
        if (this.D) {
            d(this.E);
        } else {
            e(this.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        this.A = true;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("columncode", this.B);
        new SDKVodMgr().getVodFilter(hashMap, new e());
    }

    private void s(String str) {
        String str2 = "http://{ipadd:port}/iptvepg/{frame}/sdk_getcolumngenre.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f()) + "?columncode=" + str;
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        LogEx.d(V, "sdk_getcolumngenre " + str2);
        sDKNetHTTPRequest.startRequest(str2, HttpRequest.METHOD_GET, new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int length = str.length() - str.replace(":", "").length();
        String trim = str.trim();
        return (length == 0 || (length == 1 && (trim.startsWith(":") || trim.endsWith(":")))) ? false : true;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.h.q();
        L();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.B = arguments.getString("ColumnCode", "");
        }
        onHiddenChanged(false);
        this.h.a((g.a) this);
        new com.zte.iptvclient.android.common.j.h(this.h);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.video_filter_fragment, viewGroup, false);
        d(inflate);
        M();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2) {
        this.A = true;
        com.zte.iptvclient.android.mobile.e0.d.d dVar = this.x;
        int i3 = 0;
        if (dVar != null) {
            dVar.b(false);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pageno", String.valueOf(i2));
        hashMap.put("numperpage", String.valueOf(24));
        hashMap.put("ordertype", "0");
        hashMap.put("columncode", this.B);
        hashMap.put(ParamConst.COLUMN_INFO_RSP_SUBEXIST, "0");
        hashMap.put("mediaservices", "2");
        hashMap.put("seriestype", "1,3");
        if (TextUtils.isEmpty(this.M) && TextUtils.isEmpty(this.R) && TextUtils.isEmpty(this.N) && TextUtils.isEmpty(this.O) && TextUtils.isEmpty(this.P) && TextUtils.isEmpty(this.Q)) {
            hashMap.put("isadult", "0");
        } else {
            if (TextUtils.isEmpty(this.M) && TextUtils.isEmpty(this.R)) {
                hashMap.put(ParamConst.VOD_GET_GENRE_LIST_RSP_GENRENAME, "");
            } else {
                String K = K();
                LogEx.d(V, "combineGenreAndAge: " + K);
                hashMap.put(ParamConst.VOD_GET_GENRE_LIST_RSP_GENRENAME, K);
            }
            if (!TextUtils.isEmpty(this.N)) {
                hashMap.put("releasedate", this.N);
            } else {
                hashMap.put("releasedate", "");
            }
            if (!TextUtils.isEmpty(this.O)) {
                hashMap.put("countryname", this.O);
            } else {
                hashMap.put("countryname", "");
            }
            if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
                this.S = 0;
                int i4 = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().i();
                String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo(PortalConst.STR_PARENT_CONTROL_LIMIT_LEVEL_VALUE);
                if (!TextUtils.isEmpty(propertiesInfo)) {
                    this.T = propertiesInfo.split(",");
                }
                while (true) {
                    String[] strArr = this.T;
                    if (i3 >= strArr.length) {
                        break;
                    }
                    this.S += Integer.parseInt(strArr[i3]);
                    i3++;
                }
                hashMap.put("ratingid", com.zte.iptvclient.android.common.k.p.a(this.S - i4));
                hashMap.put("isfilterratingid", "0");
                LogEx.d(V, " Child Mode getVodSearchList param ratingid");
            }
            if (!TextUtils.isEmpty(this.P)) {
                hashMap.put("ratingid", this.P);
            }
            if (!TextUtils.isEmpty(this.Q)) {
                hashMap.put("isqueryfree", this.Q);
            } else {
                hashMap.put("isqueryfree", "");
            }
        }
        LogEx.d(V, " params: " + hashMap.toString());
        SDKVodMgr sDKVodMgr = this.L;
        if (sDKVodMgr != null) {
            sDKVodMgr.cancelRequest();
        }
        SDKVodMgr sDKVodMgr2 = new SDKVodMgr();
        this.L = sDKVodMgr2;
        sDKVodMgr2.getVodSearchList(hashMap, new h());
    }

    @Override // com.zte.iptvclient.android.common.customview.a.a.e.g.a
    public void h() {
        if (getActivity() instanceof MainActivity) {
            F();
        } else if (getActivity() instanceof HostActivity) {
            getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject) {
        this.A = true;
        com.zte.iptvclient.android.mobile.e0.d.d dVar = this.x;
        if (dVar != null) {
            dVar.b(false);
            this.x.d();
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        try {
            stringBuffer.append("contentcodes=");
            stringBuffer2.append("columncodes=");
            if (jSONObject.getString("returncode").equals("0")) {
                this.F = (jSONObject.optInt("totalcount") + 9) / 10;
                JSONArray jSONArray = new JSONArray(jSONObject.optString("data"));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    stringBuffer.append(jSONObject2.optString("contentcode") + ",");
                    stringBuffer2.append(jSONObject2.optString("columncode") + ",");
                }
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                stringBuffer2.deleteCharAt(stringBuffer2.length() - 1);
                LogEx.i(V, "contentcodes = " + ((Object) stringBuffer));
                LogEx.i(V, "columncodes = " + ((Object) stringBuffer2));
            } else {
                LogEx.d(V, " getFilteredVideoList :" + jSONObject.getString("errormsg"));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogEx.e(V, e2.getMessage());
        }
        String str = "http://{epgdomain}/iptvepg/{frame}/sdk_getcontentbatch.jsp".replace("http://{epgdomain}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f()) + "?" + ((Object) stringBuffer) + "&" + ((Object) stringBuffer2);
        LogEx.d(V, "sdkQueryVideoByDouban   url   " + str);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "gbk");
        sDKNetHTTPRequest.startRequest(str, HttpRequest.METHOD_GET, new a());
    }

    private void d(View view) {
        com.zte.iptvclient.android.common.k.g.a(this.h, view, R.id.header_bottom_line);
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.p = (Button) view.findViewById(R.id.btn_back);
        this.q = (TextView) view.findViewById(R.id.title_txt);
        this.p.setVisibility(0);
        this.r = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        this.C = (RecyclerView) view.findViewById(R.id.rv_video);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.btn_back));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_txt));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.refreshLayout));
        this.r.a(new DefaultRefreshHeader(this.h));
        this.r.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.r;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.r;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.r.c(false);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.v = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.v.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.v.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.v.findViewById(R.id.refresh_image));
        TextView textView2 = (TextView) view.findViewById(R.id.txt_pullrefresh);
        this.K = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.there_is_no_collection));
        this.v.setVisibility(8);
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            this.r.setBackgroundResource(R.drawable.bg_child);
        } else if (BaseApp.f()) {
            this.r.setBackgroundResource(R.drawable.bg_pad);
        }
        this.s = (RelativeLayout) view.findViewById(R.id.filter_result_title);
        view.findViewById(R.id.filter_result_bg).setAlpha(0.95f);
        TextView textView3 = (TextView) view.findViewById(R.id.filter_result_text);
        this.t = textView3;
        textView3.setText("");
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.filter_result_title));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.filter_result_bg));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.filter_result_text));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_filter_result));
        this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.filter_txt));
        this.w = new ArrayList<>();
        ImageView imageView = (ImageView) view.findViewById(R.id.header_bottom_line);
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        if (BaseApp.a(this.h)) {
            com.zte.iptvclient.android.common.k.g.a(imageView, this.h);
        }
    }

    protected void b(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            if (jSONObject.getString("returncode").equals("0")) {
                jSONObject.optInt("totalcount");
                JSONArray jSONArray = new JSONArray(jSONObject.optString("data"));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    CommonVideoBean commonVideoBean = new CommonVideoBean();
                    commonVideoBean.o(jSONArray.getJSONObject(i2).optString("programcode"));
                    commonVideoBean.p(jSONArray.getJSONObject(i2).optString("programname"));
                    commonVideoBean.b(jSONArray.getJSONObject(i2).optString("columncode"));
                    commonVideoBean.c(jSONArray.getJSONObject(i2).optString("contentcode"));
                    commonVideoBean.m(jSONArray.getJSONObject(i2).optString("posterimage"));
                    commonVideoBean.s(jSONArray.getJSONObject(i2).optString("ratingnum"));
                    commonVideoBean.t(jSONArray.getJSONObject(i2).optString("ratingsum"));
                    commonVideoBean.r(jSONArray.getJSONObject(i2).optString("ratingid"));
                    commonVideoBean.q(jSONArray.getJSONObject(i2).optString("programtype"));
                    commonVideoBean.z(jSONArray.getJSONObject(i2).optString("starlevel"));
                    if (jSONObject.has("vrflag")) {
                        commonVideoBean.C(jSONArray.getJSONObject(i2).optString("vrflag"));
                    }
                    if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_SHORTTITLE)) {
                        commonVideoBean.x(jSONArray.getJSONObject(i2).optString(ParamConst.VOD_DETAIL_QUERY_RSP_SHORTTITLE));
                    }
                    commonVideoBean.B(jSONArray.getJSONObject(i2).optString(ParamConst.VOD_DETAIL_QUERY_RSP_UPDATENNUM));
                    commonVideoBean.v(jSONArray.getJSONObject(i2).optString("seriesnum"));
                    commonVideoBean.E(jSONArray.getJSONObject(i2).optString(ParamConst.VOD_DETAIL_QUERY_RSP_WGKEYWORDS));
                    arrayList.add(commonVideoBean);
                }
            } else {
                LogEx.d(V, " getFilteredVideoList :" + jSONObject.getString("errormsg"));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogEx.e(V, e2.getMessage());
        }
        this.w.addAll(arrayList);
    }

    public void a(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, ArrayList<String> arrayList4, ArrayList<String> arrayList5, ArrayList<String> arrayList6) {
        this.u = new VideoFilterMultiSelectHeadView(this.h, arrayList, arrayList2, arrayList3, arrayList4, arrayList5, arrayList6, new g());
        this.C.setVisibility(0);
        this.y = 1;
        this.z = 0;
        e(1);
    }

    protected void a(JSONObject jSONObject) {
        com.zte.iptvclient.android.common.k.h.a().a(new RunnableC0241m(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        this.A = true;
        com.zte.iptvclient.android.mobile.e0.d.d dVar = this.x;
        if (dVar != null) {
            dVar.b(false);
            this.x.d();
        }
        String replace = "http://{epgdomain}/iptvepg/{frame}/getdoubantopinfo.jsp".replace("http://{epgdomain}", com.zte.iptvclient.android.common.f.b.i.b());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("pageno=" + String.valueOf(i2) + "&numperpage=10&columncode=" + this.B);
        StringBuilder sb = new StringBuilder();
        sb.append(replace);
        sb.append("?");
        sb.append(stringBuffer.toString());
        String sb2 = sb.toString();
        LogEx.d(V, "sdkQueryTopDoubanList   url   " + sb2);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "gbk");
        sDKNetHTTPRequest.startRequest(sb2, HttpRequest.METHOD_GET, new j());
    }
}
