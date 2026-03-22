package com.zte.iptvclient.android.mobile.t;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.a.h;
import com.scwang.smartrefresh.layout.d.c;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.e.d;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.javabean.models.QuizListBean;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: QuizFragment.java */
/* loaded from: classes.dex */
public class b extends com.zte.fragmentlib.b {
    private RelativeLayout p;
    private TextView q;
    private SmartRefreshLayout r;
    private RelativeLayout s;
    private ListView t;
    private com.zte.iptvclient.android.mobile.t.c.b u;
    private ArrayList<QuizListBean> v = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QuizFragment.java */
    /* loaded from: classes2.dex */
    public class a implements c {
        a() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(h hVar) {
            b.this.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QuizFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.t.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0350b implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        C0350b() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("QuizFragment", "sdk_getquizlist onDataReturn =" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!"0".equals(jSONObject.optString("returncode"))) {
                    b.this.s.setVisibility(0);
                } else {
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        b.this.v.add(QuizListBean.getQuizListBeanFromJSon(jSONArray.getJSONObject(i)));
                    }
                }
                b.this.r.a();
            } catch (JSONException e) {
                e.printStackTrace();
                b.this.s.setVisibility(0);
            }
            if (b.this.u != null) {
                b.this.u.notifyDataSetChanged();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("QuizFragment", "sdk_getquizlist onFailReturn returncode=" + i + " errormsg " + str);
            b.this.r.a();
            b.this.s.setVisibility(0);
            if (b.this.u != null) {
                b.this.u.notifyDataSetChanged();
            }
        }
    }

    private void J() {
        this.r.a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        ArrayList<QuizListBean> arrayList = this.v;
        if (arrayList != null) {
            arrayList.clear();
            this.s.setVisibility(8);
        }
        String str = "http://{ipadd:port}/iptvepg/{frame}/sdk_getquizlist.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", i.f()) + "?pageno=1&numperpage=100&languagetype=" + this.h.getResources().getString(R.string.login_set_language);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", i.h());
        sDKNetHTTPRequest.setCharset("gbk");
        sDKNetHTTPRequest.startRequest(str, HttpRequest.METHOD_GET, new C0350b());
    }

    public void I() {
        K();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        I();
        com.zte.iptvclient.android.mobile.t.c.b bVar = new com.zte.iptvclient.android.mobile.t.c.b(this.h, this.v);
        this.u = bVar;
        this.t.setAdapter((ListAdapter) bVar);
        J();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.quiz_layout, (ViewGroup) null);
        d(inflate);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(d dVar) {
        K();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        if (!z) {
            K();
        }
        super.onHiddenChanged(z);
    }

    private void d(View view) {
        g.a(this.h, view, R.id.title_bottom_line);
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.p = (RelativeLayout) view.findViewById(R.id.title_rlayout);
        this.q = (TextView) view.findViewById(R.id.title_txt);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        this.r = smartRefreshLayout;
        smartRefreshLayout.a(new DefaultRefreshHeader(this.h));
        this.r.a(new DefaultRefreshFooter(this.h));
        this.r.a(false);
        this.r.c(false);
        Resources resources = this.h.getResources();
        this.r.e(g.a(this.h, resources.getDimension(R.dimen.refresh_footer_height)));
        this.r.f(g.a(this.h, resources.getDimension(R.dimen.refresh_header_height)));
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.s = relativeLayout;
        relativeLayout.setVisibility(8);
        ImageView imageView = (ImageView) view.findViewById(R.id.title_bottom_line);
        this.t = (ListView) view.findViewById(R.id.quiz_lv);
        f.a(this.p);
        f.a(this.q);
        f.a(imageView);
        f.a(this.s.findViewById(R.id.ll_pullrefresh));
        f.a(this.s.findViewById(R.id.img_pullrefresh_icon));
        f.a(this.s.findViewById(R.id.txt_pullrefresh));
        f.a(this.s.findViewById(R.id.refresh_image));
        ((TextView) this.s.findViewById(R.id.txt_pullrefresh)).setText(this.h.getResources().getString(R.string.there_is_no_collection));
    }
}
