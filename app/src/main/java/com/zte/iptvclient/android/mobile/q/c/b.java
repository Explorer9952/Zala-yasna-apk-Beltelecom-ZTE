package com.zte.iptvclient.android.mobile.q.c;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.a.h;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.javabean.j;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.mobile.q.a.c;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OnlineSubscribeFragment.java */
/* loaded from: classes.dex */
public class b extends com.zte.fragmentlib.b {
    private SmartRefreshLayout p;
    private RelativeLayout q;
    private ListView r;
    private ArrayList<j> s;
    private com.zte.iptvclient.android.mobile.q.a.c t;
    private TextView u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnlineSubscribeFragment.java */
    /* loaded from: classes.dex */
    public class a implements com.scwang.smartrefresh.layout.d.c {
        a() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(h hVar) {
            b.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnlineSubscribeFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.q.c.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0337b implements c.b {
        C0337b() {
        }

        @Override // com.zte.iptvclient.android.mobile.q.a.c.b
        public void a(j jVar) {
            b.this.a(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnlineSubscribeFragment.java */
    /* loaded from: classes.dex */
    public class c implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f7078a;

        c(j jVar) {
            this.f7078a = jVar;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("OnlineSubscribeFragment", "onDataReturn s = " + str);
            try {
                if ("0".equals(new JSONObject(str).optString("returncode"))) {
                    LogEx.d("OnlineSubscribeFragment", "deleteSubscribe success");
                    b.this.s.remove(this.f7078a);
                    b.this.J();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("OnlineSubscribeFragment", "onFailReturn i = " + i + "  s = " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnlineSubscribeFragment.java */
    /* loaded from: classes.dex */
    public class d implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        d() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("OnlineSubscribeFragment", "sdkQueryOrder onDataReturn = " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if ("0".equals(jSONObject.optString("returncode"))) {
                    String str2 = "";
                    JSONArray optJSONArray = jSONObject.optJSONArray("data");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        j a2 = j.a(optJSONArray.getJSONObject(i));
                        if (a2 != null) {
                            if (!str2.equals(a2.c())) {
                                j jVar = new j();
                                jVar.a(true);
                                jVar.l(a2.c());
                                b.this.s.add(jVar);
                                str2 = a2.c();
                            }
                            b.this.s.add(a2);
                        }
                    }
                }
                LogEx.d("OnlineSubscribeFragment", "mListSubscribe size = " + b.this.s.size());
                b.this.J();
            } catch (JSONException e) {
                e.printStackTrace();
                b.this.J();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("OnlineSubscribeFragment", "onFailReturn i = " + i + "  s = " + str);
            b.this.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (this.s.size() == 0) {
            this.r.setVisibility(8);
            this.q.setVisibility(0);
        } else {
            this.r.setVisibility(0);
            this.q.setVisibility(8);
        }
        this.p.a();
        this.t.notifyDataSetChanged();
    }

    private void K() {
        this.s = new ArrayList<>();
        com.zte.iptvclient.android.mobile.q.a.c cVar = new com.zte.iptvclient.android.mobile.q.a.c(this.h, this.s);
        this.t = cVar;
        this.r.setAdapter((ListAdapter) cVar);
    }

    private void L() {
        this.p.a(new a());
        this.t.a(new C0337b());
    }

    private void d(View view) {
        this.r = (ListView) view.findViewById(R.id.listview_subscribe);
        this.p = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        f.a(view.findViewById(R.id.title_rlayout));
        f.a(view.findViewById(R.id.title_txt));
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.q = relativeLayout;
        f.a(relativeLayout.findViewById(R.id.ll_pullrefresh));
        f.a(this.q.findViewById(R.id.img_pullrefresh_icon));
        f.a(this.q.findViewById(R.id.txt_pullrefresh));
        f.a(this.q.findViewById(R.id.refresh_image));
        this.q.setVisibility(8);
        this.p.a(new DefaultRefreshHeader(this.h));
        this.p.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.p;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.p;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.p.a(true);
        this.p.c(false);
        TextView textView = (TextView) this.q.findViewById(R.id.refresh_image);
        this.u = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.pull_to_refresh));
    }

    public void I() {
        ArrayList<j> arrayList = this.s;
        if (arrayList != null) {
            arrayList.clear();
        }
        String replace = "http://{ipadd:port}/iptvepg/{frame}/sdk_upcomingquery.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", i.f());
        LogEx.d("OnlineSubscribeFragment", "sdkQueryOrder url = " + replace);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        String d2 = com.zte.iptvclient.common.uiframe.a.d("UserToken");
        String d3 = com.zte.iptvclient.common.uiframe.a.d("UserID");
        sDKNetHTTPRequest.setParam("usertoken", d2);
        sDKNetHTTPRequest.setParam("usercode", d3);
        sDKNetHTTPRequest.setParam("sorttype", "1");
        sDKNetHTTPRequest.setHeader("Cookie", i.h());
        sDKNetHTTPRequest.startRequest(replace, "GET", new d());
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        L();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.online_subscribe_layout, viewGroup, false);
        d(inflate);
        K();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar) {
        String replace = "http://{ipadd:port}/iptvepg/{frame}/sdk_upcomingset.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", i.f());
        LogEx.d("OnlineSubscribeFragment", "addSubscribe url = " + replace);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        String d2 = com.zte.iptvclient.common.uiframe.a.d("UserToken");
        String d3 = com.zte.iptvclient.common.uiframe.a.d("UserID");
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Recommend_Server_CpCode");
        LogEx.d("OnlineSubscribeFragment", "contentmediacode = " + c2);
        sDKNetHTTPRequest.setParam("usertoken", d2);
        sDKNetHTTPRequest.setParam("usercode", d3);
        sDKNetHTTPRequest.setParam("action", "0");
        sDKNetHTTPRequest.setParam("contentcode", jVar.a());
        sDKNetHTTPRequest.setParam("contentname", jVar.b());
        sDKNetHTTPRequest.setParam("contentmediacode", c2);
        sDKNetHTTPRequest.setHeader("Cookie", i.h());
        sDKNetHTTPRequest.startRequest(replace, "GET", new c(jVar));
    }
}
