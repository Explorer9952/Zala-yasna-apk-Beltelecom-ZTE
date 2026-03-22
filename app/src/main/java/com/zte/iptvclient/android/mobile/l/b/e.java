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
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.vod.SDKVodMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import com.zte.iptvclient.android.common.javabean.models.MovieDetailBundleBean;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: HomeMoreFragment.java */
/* loaded from: classes.dex */
public class e extends com.zte.fragmentlib.b {
    private String q;
    private String r;
    private ArrayList<CommonVideoBean> s;
    private com.zte.iptvclient.android.mobile.e0.d.a t;
    private SmartRefreshLayout y;
    private GridView z;
    private String p = e.class.getSimpleName();
    private int u = 1;
    private int v = 0;
    private boolean w = false;
    private long x = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeMoreFragment.java */
    /* loaded from: classes.dex */
    public class a implements com.scwang.smartrefresh.layout.d.c {
        a() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(h hVar) {
            e.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeMoreFragment.java */
    /* loaded from: classes.dex */
    public class b implements com.scwang.smartrefresh.layout.d.a {
        b() {
        }

        @Override // com.scwang.smartrefresh.layout.d.a
        public void b(h hVar) {
            if (e.this.u > e.this.v) {
                e.this.K();
                hVar.a(true);
            } else {
                e eVar = e.this;
                eVar.a(eVar.r, e.this.u);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeMoreFragment.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.getActivity() instanceof MainActivity) {
                e.this.F();
            } else if (e.this.getActivity() instanceof HostActivity) {
                e.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeMoreFragment.java */
    /* loaded from: classes.dex */
    public class d implements SDKVodMgr.OnVodListReturnListener {
        d() {
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnVodListReturnListener
        public void onVodListReturn(String str, String str2, String str3) {
            LogEx.d(e.this.p, "getVodList data : " + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    e.this.a(new JSONObject(str3));
                } catch (Exception e) {
                    LogEx.e(e.this.p, e.getMessage());
                }
            }
            e.this.K();
            e.this.w = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HomeMoreFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.l.b.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0303e implements AdapterView.OnItemClickListener {
        private C0303e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            CommonVideoBean commonVideoBean;
            String f;
            if (e.this.J() || (commonVideoBean = (CommonVideoBean) e.this.s.get(i)) == null || (f = commonVideoBean.f()) == null) {
                return;
            }
            if (f.equals("1")) {
                e.this.s(commonVideoBean.d());
            } else if (f.equals("14")) {
                e.this.e(commonVideoBean.d(), commonVideoBean.a());
            }
        }

        /* synthetic */ C0303e(e eVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.x <= 500) {
            LogEx.w(this.p, "Operate limit,less than 500(ms)!");
            return true;
        }
        this.x = currentTimeMillis;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        this.y.a();
        this.y.j();
    }

    private void L() {
        this.s = new ArrayList<>();
        com.zte.iptvclient.android.mobile.e0.d.a aVar = new com.zte.iptvclient.android.mobile.e0.d.a(this.h, this.s);
        this.t = aVar;
        this.z.setAdapter((ListAdapter) aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str);
        Intent intent = new Intent(getActivity(), (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "moviedetail");
        intent.putExtras(bundle);
        getActivity().startActivity(intent);
    }

    public void I() {
        this.u = 1;
        this.y.a(false);
        if (this.w) {
            return;
        }
        a(this.r, this.u);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(this.r, this.u);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.r = arguments.getString("ColumnCode");
            this.q = arguments.getString("ColumnName");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.home_more_fragment, viewGroup, false);
        d(inflate);
        L();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.t != null) {
            this.t = null;
        }
        ArrayList<CommonVideoBean> arrayList = this.s;
        if (arrayList != null) {
            arrayList.clear();
            this.s = null;
        }
        super.onDestroy();
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        textView.setVisibility(0);
        this.z = (GridView) view.findViewById(R.id.pull_refresh_grid);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        this.y = smartRefreshLayout;
        smartRefreshLayout.a(new DefaultRefreshHeader(this.h));
        this.y.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout2 = this.y;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout2.e(g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout3 = this.y;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout3.f(g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.y.c(false);
        Button button = (Button) view.findViewById(R.id.btn_back);
        TextView textView2 = (TextView) view.findViewById(R.id.title_txt);
        if (!TextUtils.isEmpty(this.q)) {
            textView2.setText(this.q);
        }
        this.y.a(new a());
        this.y.a(new b());
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(button);
        com.zte.iptvclient.common.uiframe.f.a(textView2);
        button.setOnClickListener(new c());
        this.z.setOnItemClickListener(new C0303e(this, null));
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
    public void a(String str, int i) {
        this.w = true;
        SDKVodMgr sDKVodMgr = new SDKVodMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("columncode", str);
        hashMap.put("pageno", String.valueOf(i));
        hashMap.put("numperpage", String.valueOf(24));
        hashMap.put("ordertype", "0");
        hashMap.put("seriestype", "1,3");
        sDKVodMgr.getVodList(hashMap, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        try {
            this.v = (jSONObject.optInt("totalcount") + 23) / 24;
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            LogEx.d(this.p, "DynamicContent Data: " + jSONArray);
            int length = jSONArray.length();
            if (this.u <= 1) {
                this.s.clear();
                if (this.t != null) {
                    this.t.notifyDataSetChanged();
                }
            }
            for (int i = 0; i < length; i++) {
                this.s.add(CommonVideoBean.a(jSONArray.getJSONObject(i)));
            }
            LogEx.d(this.p, " ---------#####list size is : " + this.s.size());
            if (this.t != null) {
                this.t.notifyDataSetChanged();
            }
            this.u++;
        } catch (Exception e) {
            LogEx.d(this.p, e.getMessage());
        }
    }
}
