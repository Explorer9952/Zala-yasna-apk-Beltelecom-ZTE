package com.zte.iptvclient.android.mobile.l.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.i;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.vod.SDKVodMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.f.b.k;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import com.zte.iptvclient.android.common.javabean.models.MovieDetailBundleBean;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import com.zte.iptvclient.android.common.k.o;
import com.zte.iptvclient.android.common.k.p;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.e0.d.h;
import com.zte.iptvclient.android.zala.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DetailRecommendProgramFragment.java */
/* loaded from: classes.dex */
public class b extends com.zte.fragmentlib.b {
    private RelativeLayout A;
    private TextView C;
    private VideoDetailBean q;
    private TextView r;
    private RelativeLayout s;
    private GridView t;
    private ArrayList<CommonVideoBean> u;
    private h w;
    private g x;
    private SmartRefreshLayout z;
    private int p = 0;
    private long v = 0;
    private boolean y = false;
    private boolean B = false;
    private f D = new f(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailRecommendProgramFragment.java */
    /* loaded from: classes.dex */
    public class a implements SDKVodMgr.OnVodListReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnVodListReturnListener
        public void onVodListReturn(String str, String str2, String str3) {
            Message obtain = Message.obtain();
            obtain.what = 24577;
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    LogEx.d("DetailRecommendProgramFragment", "sdkQueryRecommentByEpg:" + jSONObject.toString());
                    b.this.a(jSONObject, obtain);
                } catch (Exception e) {
                    LogEx.d("DetailRecommendProgramFragment", "sdkQueryRecommentByEpg  exception = " + e.getMessage());
                }
            }
            b.this.D.sendMessage(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailRecommendProgramFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.l.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0299b implements k.c {
        C0299b() {
        }

        @Override // com.zte.iptvclient.android.common.f.b.k.c
        public void a(ArrayList<CommonVideoBean> arrayList) {
            if (arrayList != null) {
                b.this.u = arrayList;
                if (b.this.w != null) {
                    b.this.w.a(b.this.u);
                    b.this.w.notifyDataSetChanged();
                } else {
                    b.this.w = new h(((com.zte.fragmentlib.b) b.this).h, b.this.u);
                    b.this.t.setAdapter((ListAdapter) b.this.w);
                }
            }
            b.this.B = false;
            b.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailRecommendProgramFragment.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailRecommendProgramFragment.java */
    /* loaded from: classes.dex */
    public class d implements com.scwang.smartrefresh.layout.d.c {
        d() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            b.this.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DetailRecommendProgramFragment.java */
    /* loaded from: classes.dex */
    public class e implements AdapterView.OnItemClickListener {
        private e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            CommonVideoBean commonVideoBean;
            if (b.this.I() || (commonVideoBean = (CommonVideoBean) b.this.u.get(i)) == null) {
                return;
            }
            String f = commonVideoBean.f();
            if (TextUtils.equals(f, "1")) {
                b.this.f(commonVideoBean.d(), commonVideoBean.a());
            } else if (TextUtils.equals(f, "14")) {
                b.this.e(commonVideoBean.d(), commonVideoBean.a());
            } else if (TextUtils.equals(f, "10")) {
                b.this.a(commonVideoBean.i(), commonVideoBean.a(), commonVideoBean.h());
            }
        }

        /* synthetic */ e(b bVar, a aVar) {
            this();
        }
    }

    /* compiled from: DetailRecommendProgramFragment.java */
    /* loaded from: classes.dex */
    private final class f extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<b> f6731a;

        public f(b bVar) {
            this.f6731a = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            b bVar = this.f6731a.get();
            if (bVar != null && message.what == 24577) {
                ArrayList arrayList = (ArrayList) message.obj;
                if (arrayList != null) {
                    bVar.u.addAll(arrayList);
                    if (bVar.x != null) {
                        bVar.x.a(bVar.u);
                        bVar.x.notifyDataSetChanged();
                    } else {
                        bVar.x = new g(((com.zte.fragmentlib.b) bVar).h, bVar.u);
                        bVar.t.setAdapter((ListAdapter) bVar.x);
                    }
                }
                bVar.B = false;
                bVar.L();
            }
        }
    }

    /* compiled from: DetailRecommendProgramFragment.java */
    /* loaded from: classes.dex */
    class g extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<CommonVideoBean> f6733a;

        /* renamed from: b, reason: collision with root package name */
        private LayoutInflater f6734b;

        /* compiled from: DetailRecommendProgramFragment.java */
        /* loaded from: classes.dex */
        private class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            private CommonVideoBean f6736a;

            public a(CommonVideoBean commonVideoBean) {
                this.f6736a = commonVideoBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.I()) {
                    return;
                }
                String f = this.f6736a.f();
                if (TextUtils.equals(f, "14")) {
                    b.this.e(this.f6736a.d(), this.f6736a.a());
                } else if (TextUtils.equals(f, "1")) {
                    b.this.f(this.f6736a.d(), this.f6736a.a());
                } else if (TextUtils.equals(f, "10")) {
                    b.this.a(this.f6736a.i(), this.f6736a.a(), this.f6736a.h());
                }
            }
        }

        /* compiled from: DetailRecommendProgramFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.l.b.b$g$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0300b {

            /* renamed from: a, reason: collision with root package name */
            ImageView f6738a;

            /* renamed from: b, reason: collision with root package name */
            TextView f6739b;

            /* renamed from: c, reason: collision with root package name */
            TextView f6740c;

            C0300b(g gVar) {
            }
        }

        public g(Context context, ArrayList<CommonVideoBean> arrayList) {
            this.f6733a = arrayList;
            this.f6734b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void a(ArrayList<CommonVideoBean> arrayList) {
            this.f6733a = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<CommonVideoBean> arrayList = this.f6733a;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            ArrayList<CommonVideoBean> arrayList = this.f6733a;
            if (arrayList == null) {
                return null;
            }
            return arrayList.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            C0300b c0300b;
            if (view == null) {
                c0300b = new C0300b(this);
                view2 = this.f6734b.inflate(R.layout.home_video_item, (ViewGroup) null);
                c0300b.f6738a = (ImageView) view2.findViewById(R.id.poster_img);
                c0300b.f6739b = (TextView) view2.findViewById(R.id.title_txt);
                c0300b.f6740c = (TextView) view2.findViewById(R.id.rating_txt);
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.home_video_item_fl));
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.img_rlayout));
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.rating_rl));
                com.zte.iptvclient.common.uiframe.f.a(c0300b.f6740c);
                com.zte.iptvclient.common.uiframe.f.a(c0300b.f6738a);
                com.zte.iptvclient.common.uiframe.f.a(c0300b.f6739b);
                view2.setTag(c0300b);
            } else {
                view2 = view;
                c0300b = (C0300b) view.getTag();
            }
            c0300b.f6738a.setImageResource(R.drawable.default_poster_thumb);
            CommonVideoBean commonVideoBean = this.f6733a.get(i);
            if (commonVideoBean != null) {
                String a2 = com.zte.iptvclient.android.common.k.g.a(BaseApp.a(((com.zte.fragmentlib.b) b.this).h) ? 9 : 3, commonVideoBean.c());
                if (!((com.zte.fragmentlib.b) b.this).h.isFinishing()) {
                    com.bumptech.glide.d<String> a3 = i.a((FragmentActivity) ((com.zte.fragmentlib.b) b.this).h).a(a2);
                    a3.b(R.drawable.default_poster_thumb);
                    a3.a(R.drawable.default_poster_thumb);
                    a3.c(300);
                    a3.a(c0300b.f6738a);
                }
                if (b.this.y && com.zte.iptvclient.android.mobile.f.b.a.a(this.f6733a.get(i).g(), ((com.zte.fragmentlib.b) b.this).h)) {
                    c0300b.f6739b.setText(R.string.common_blocktitle);
                } else {
                    c0300b.f6739b.setText(this.f6733a.get(i).e());
                }
                c0300b.f6740c.setVisibility(8);
                c0300b.f6738a.setOnClickListener(new a(commonVideoBean));
            }
            return view2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.v <= 500) {
            LogEx.w("DetailRecommendProgramFragment", "Operate limit,less than 500(ms)!");
            return true;
        }
        this.v = currentTimeMillis;
        return false;
    }

    private void J() {
        if (!TextUtils.isEmpty(o.j().f())) {
            N();
        } else {
            this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.rec_may_likes));
            K();
        }
    }

    private void K() {
        this.B = true;
        SDKVodMgr sDKVodMgr = new SDKVodMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("columncode", this.q.getColumncode());
        hashMap.put("pageno", "1");
        hashMap.put("numperpage", String.valueOf(32));
        hashMap.put("ordertype", "0");
        hashMap.put("seriestype", "1,3");
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            hashMap.put("ratingid", p.a(new com.zte.iptvclient.android.common.j.h(getContext()).t()));
            LogEx.d("DetailRecommendProgramFragment", " Child Mode getVodSearchList param ratingid");
        }
        sDKVodMgr.getVodList(hashMap, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        this.z.j();
        this.z.a();
        this.z.a(true);
        if (this.u.size() == 0) {
            this.A.setVisibility(0);
            this.t.setVisibility(8);
        } else {
            this.A.setVisibility(8);
            this.t.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        this.u.clear();
        if (this.B) {
            return;
        }
        J();
    }

    private void N() {
        this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.rec_may_likes));
        int i = this.p;
        if (i == 1) {
            this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.rec_rel_dir));
        } else if (i == 0) {
            this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.rec_rel_stars));
        }
        if (this.q == null) {
            return;
        }
        this.B = true;
        new k(this.h, o.j().f(), this.q, new C0299b()).a(this.p);
    }

    private void O() {
        this.u = new ArrayList<>();
        this.t.setOnItemClickListener(new e(this, null));
        this.s.setOnClickListener(new c());
        this.z.a(new d());
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        F();
        return true;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        O();
        J();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.q = (VideoDetailBean) arguments.getSerializable("VideoDetailBean");
            this.p = arguments.getInt("recommendType");
        }
        this.y = "1".equals(ConfigMgr.readPropertie("IsShowBlockTitle"));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.common_recommend_program_layout, viewGroup, false);
        this.r = (TextView) inflate.findViewById(R.id.detail_title);
        this.s = (RelativeLayout) inflate.findViewById(R.id.rl_colse_img);
        this.t = (GridView) inflate.findViewById(R.id.pull_refresh_grid);
        if ("1".equals(ConfigMgr.readPropertie("isShow")) && BaseApp.a(this.h)) {
            this.t.setNumColumns(4);
        } else {
            this.t.setNumColumns(3);
        }
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.common_detail_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.detail_title));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.rl_colse_img));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.img_close));
        this.z = (SmartRefreshLayout) inflate.findViewById(R.id.refreshLayout);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rl_empty);
        this.A = relativeLayout;
        TextView textView = (TextView) relativeLayout.findViewById(R.id.txt_pullrefresh);
        this.C = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.pull_to_refresh));
        com.zte.iptvclient.common.uiframe.f.a(this.A.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.A.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.A.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.A.findViewById(R.id.refresh_image));
        this.A.setVisibility(8);
        this.z.a(new DefaultRefreshHeader(this.h));
        this.z.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.z;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.z;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str);
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, str2);
        bundle.putBoolean("doAnim", false);
        Intent intent = new Intent(getActivity(), (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "seriesdetail");
        intent.putExtras(bundle);
        intent.setFlags(536870912);
        getActivity().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str);
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, str2);
        bundle.putBoolean("doAnim", false);
        Intent intent = new Intent(getActivity(), (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "moviedetail");
        intent.putExtras(bundle);
        intent.setFlags(536870912);
        getActivity().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, Message message) {
        try {
            LogEx.d("bindDataToView", jSONObject.toString());
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString("programcode");
                if (TextUtils.isEmpty(string) || !string.equals(this.q.getProgramcode())) {
                    arrayList.add(CommonVideoBean.a(jSONObject2));
                }
            }
            message.obj = arrayList;
        } catch (Exception e2) {
            LogEx.d("UseeTv", e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str);
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, str2);
        bundle.putString(MovieDetailBundleBean.SERIES_BUNDLEPARAMS_SERIES_NUM, str3);
        Intent intent = new Intent(getActivity(), (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "seriesdetail");
        intent.putExtras(bundle);
        intent.setFlags(536870912);
        getActivity().startActivity(intent);
    }
}
