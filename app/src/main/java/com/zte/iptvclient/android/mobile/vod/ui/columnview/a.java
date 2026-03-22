package com.zte.iptvclient.android.mobile.vod.ui.columnview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
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
import com.bumptech.glide.i;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.vod.SDKVodMgr;
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
import com.zte.iptvclient.android.mobile.home.ui.layout.linearLayout.GeneralColumnView;
import com.zte.iptvclient.android.zala.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: VideoRecommendMoreView.java */
/* loaded from: classes2.dex */
public class a extends GeneralColumnView {
    private static final String q = a.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    private int f7672a;

    /* renamed from: b, reason: collision with root package name */
    private VideoDetailBean f7673b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f7674c;

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f7675d;
    private GridView e;
    private ArrayList<CommonVideoBean> f;
    private long g;
    private com.zte.iptvclient.android.mobile.e0.d.h h;
    private h i;
    private boolean j;
    private SmartRefreshLayout k;
    private RelativeLayout l;
    private boolean m;
    private TextView n;
    e o;
    private g p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoRecommendMoreView.java */
    /* renamed from: com.zte.iptvclient.android.mobile.vod.ui.columnview.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewOnClickListenerC0379a implements View.OnClickListener {
        ViewOnClickListenerC0379a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar = a.this.o;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoRecommendMoreView.java */
    /* loaded from: classes2.dex */
    public class b implements com.scwang.smartrefresh.layout.d.c {
        b() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            a.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoRecommendMoreView.java */
    /* loaded from: classes2.dex */
    public class c implements SDKVodMgr.OnVodListReturnListener {
        c() {
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnVodListReturnListener
        public void onVodListReturn(String str, String str2, String str3) {
            Message obtain = Message.obtain();
            obtain.what = 24577;
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    LogEx.d(a.q, "sdkQueryRecommentByEpg:" + jSONObject.toString());
                    a.this.a(jSONObject, obtain);
                } catch (Exception e) {
                    LogEx.d(a.q, "sdkQueryRecommentByEpg  exception = " + e.getMessage());
                }
            }
            a.this.p.sendMessage(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoRecommendMoreView.java */
    /* loaded from: classes2.dex */
    public class d implements k.c {
        d() {
        }

        @Override // com.zte.iptvclient.android.common.f.b.k.c
        public void a(ArrayList<CommonVideoBean> arrayList) {
            if (arrayList != null) {
                a.this.f = arrayList;
                if (a.this.h != null) {
                    a.this.h.a(a.this.f);
                    a.this.h.notifyDataSetChanged();
                } else {
                    a.this.h = new com.zte.iptvclient.android.mobile.e0.d.h(a.this.getContext(), a.this.f);
                    a.this.e.setAdapter((ListAdapter) a.this.h);
                }
            }
            a.this.m = false;
            a.this.f();
        }
    }

    /* compiled from: VideoRecommendMoreView.java */
    /* loaded from: classes2.dex */
    public interface e {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VideoRecommendMoreView.java */
    /* loaded from: classes2.dex */
    public class f implements AdapterView.OnItemClickListener {
        private f() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            CommonVideoBean commonVideoBean;
            if (a.this.c() || (commonVideoBean = (CommonVideoBean) a.this.f.get(i)) == null) {
                return;
            }
            String f = commonVideoBean.f();
            if (TextUtils.equals(f, "1")) {
                a.this.b(commonVideoBean.d(), commonVideoBean.a());
            } else if (TextUtils.equals(f, "14")) {
                a.this.a(commonVideoBean.d(), commonVideoBean.a());
            } else if (TextUtils.equals(f, "10")) {
                a.this.a(commonVideoBean.i(), commonVideoBean.a(), commonVideoBean.h());
            }
        }

        /* synthetic */ f(a aVar, ViewOnClickListenerC0379a viewOnClickListenerC0379a) {
            this();
        }
    }

    /* compiled from: VideoRecommendMoreView.java */
    /* loaded from: classes2.dex */
    private final class g extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<a> f7681a;

        public g(a aVar) {
            this.f7681a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            a aVar = this.f7681a.get();
            if (aVar != null && message.what == 24577) {
                ArrayList arrayList = (ArrayList) message.obj;
                if (arrayList != null) {
                    aVar.f.addAll(arrayList);
                    if (aVar.i != null) {
                        aVar.i.a(aVar.f);
                        aVar.i.notifyDataSetChanged();
                    } else {
                        aVar.i = new h(aVar.getContext(), aVar.f);
                        aVar.e.setAdapter((ListAdapter) aVar.i);
                    }
                }
                aVar.m = false;
                aVar.f();
            }
        }
    }

    /* compiled from: VideoRecommendMoreView.java */
    /* loaded from: classes2.dex */
    class h extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<CommonVideoBean> f7683a;

        /* renamed from: b, reason: collision with root package name */
        private LayoutInflater f7684b;

        /* compiled from: VideoRecommendMoreView.java */
        /* renamed from: com.zte.iptvclient.android.mobile.vod.ui.columnview.a$h$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private class ViewOnClickListenerC0380a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            private CommonVideoBean f7686a;

            public ViewOnClickListenerC0380a(CommonVideoBean commonVideoBean) {
                this.f7686a = commonVideoBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.c()) {
                    return;
                }
                String f = this.f7686a.f();
                if (TextUtils.equals(f, "14")) {
                    a.this.a(this.f7686a.d(), this.f7686a.a());
                } else if (TextUtils.equals(f, "1")) {
                    a.this.b(this.f7686a.d(), this.f7686a.a());
                } else if (TextUtils.equals(f, "10")) {
                    a.this.a(this.f7686a.i(), this.f7686a.a(), this.f7686a.h());
                }
            }
        }

        /* compiled from: VideoRecommendMoreView.java */
        /* loaded from: classes2.dex */
        class b {

            /* renamed from: a, reason: collision with root package name */
            ImageView f7688a;

            /* renamed from: b, reason: collision with root package name */
            TextView f7689b;

            /* renamed from: c, reason: collision with root package name */
            TextView f7690c;

            b(h hVar) {
            }
        }

        public h(Context context, ArrayList<CommonVideoBean> arrayList) {
            this.f7683a = arrayList;
            this.f7684b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void a(ArrayList<CommonVideoBean> arrayList) {
            this.f7683a = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<CommonVideoBean> arrayList = this.f7683a;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            ArrayList<CommonVideoBean> arrayList = this.f7683a;
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
            b bVar;
            if (view == null) {
                bVar = new b(this);
                view2 = this.f7684b.inflate(R.layout.home_video_item, (ViewGroup) null);
                bVar.f7688a = (ImageView) view2.findViewById(R.id.poster_img);
                bVar.f7689b = (TextView) view2.findViewById(R.id.title_txt);
                bVar.f7690c = (TextView) view2.findViewById(R.id.rating_txt);
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.home_video_item_fl));
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.img_rlayout));
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.rating_rl));
                com.zte.iptvclient.common.uiframe.f.a(bVar.f7690c);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f7688a);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f7689b);
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            bVar.f7688a.setImageResource(R.drawable.default_poster_thumb);
            CommonVideoBean commonVideoBean = this.f7683a.get(i);
            if (commonVideoBean != null) {
                com.bumptech.glide.d<String> a2 = i.b(view2.getContext()).a(com.zte.iptvclient.android.common.k.g.a(BaseApp.f() ? 9 : 3, commonVideoBean.c()));
                a2.b(R.drawable.default_poster_thumb);
                a2.a(R.drawable.default_poster_thumb);
                a2.c(300);
                a2.a(bVar.f7688a);
                if (a.this.j && com.zte.iptvclient.android.mobile.f.b.a.a(this.f7683a.get(i).g(), view2.getContext())) {
                    bVar.f7689b.setText(R.string.common_blocktitle);
                } else {
                    bVar.f7689b.setText(this.f7683a.get(i).e());
                }
                bVar.f7690c.setVisibility(8);
                bVar.f7688a.setOnClickListener(new ViewOnClickListenerC0380a(commonVideoBean));
            }
            return view2;
        }
    }

    public a(Context context, e eVar) {
        this(context, null, eVar);
        this.o = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.g <= 500) {
            return true;
        }
        this.g = currentTimeMillis;
        return false;
    }

    private void d() {
        if (!TextUtils.isEmpty(o.j().f())) {
            h();
        } else {
            this.f7674c.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.rec_may_likes));
            e();
        }
    }

    private void e() {
        this.m = true;
        SDKVodMgr sDKVodMgr = new SDKVodMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("columncode", this.f7673b.getColumncode());
        hashMap.put("pageno", "1");
        hashMap.put("numperpage", String.valueOf(32));
        hashMap.put("ordertype", "0");
        hashMap.put("seriestype", "1,3");
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            hashMap.put("ratingid", p.a(new com.zte.iptvclient.android.common.j.h(getContext()).t()));
            LogEx.d(q, " Child Mode getVodSearchList param ratingid");
        }
        sDKVodMgr.getVodList(hashMap, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.k.j();
        this.k.a();
        this.k.a(true);
        if (this.f.size() == 0) {
            this.l.setVisibility(0);
            this.e.setVisibility(8);
        } else {
            this.l.setVisibility(8);
            this.e.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f.clear();
        if (this.m) {
            return;
        }
        d();
    }

    private void h() {
        this.f7674c.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.rec_may_likes));
        if (this.f7673b == null) {
            return;
        }
        this.m = true;
        new k(getContext(), o.j().f(), this.f7673b, new d()).a(this.f7672a);
    }

    private void i() {
        this.f = new ArrayList<>();
        this.e.setOnItemClickListener(new f(this, null));
        this.f7675d.setOnClickListener(new ViewOnClickListenerC0379a());
        this.k.a(new b());
    }

    public a(Context context, AttributeSet attributeSet, e eVar) {
        this(context, attributeSet, -1, eVar);
        this.o = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str);
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, str2);
        bundle.putBoolean("doAnim", false);
        Intent intent = new Intent(getContext(), (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "moviedetail");
        intent.putExtras(bundle);
        intent.setFlags(536870912);
        getContext().startActivity(intent);
    }

    public a(Context context, AttributeSet attributeSet, int i, e eVar) {
        super(context, attributeSet, i);
        this.f7672a = 2;
        this.g = 0L;
        this.j = false;
        this.m = false;
        this.p = new g(this);
        this.o = eVar;
        a(context);
        i();
    }

    public void a(VideoDetailBean videoDetailBean) {
        this.f7673b = videoDetailBean;
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
                if (TextUtils.isEmpty(string) || !string.equals(this.f7673b.getProgramcode())) {
                    arrayList.add(CommonVideoBean.a(jSONObject2));
                }
            }
            message.obj = arrayList;
        } catch (Exception e2) {
            LogEx.d(q, e2.getMessage());
        }
    }

    private void a(Context context) {
        View inflate = View.inflate(context, R.layout.common_recommend_program_layout, this);
        this.f7674c = (TextView) inflate.findViewById(R.id.detail_title);
        this.f7675d = (RelativeLayout) inflate.findViewById(R.id.rl_colse_img);
        this.e = (GridView) inflate.findViewById(R.id.pull_refresh_grid);
        if ("1".equals(ConfigMgr.readPropertie("isShow")) && BaseApp.f()) {
            this.e.setNumColumns(4);
        } else {
            this.e.setNumColumns(3);
        }
        com.zte.iptvclient.common.uiframe.f.a(this.e);
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.common_detail_layout));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.common_detail_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.detail_title));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.rl_colse_img));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.img_close));
        this.k = (SmartRefreshLayout) inflate.findViewById(R.id.refreshLayout);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rl_empty);
        this.l = relativeLayout;
        TextView textView = (TextView) relativeLayout.findViewById(R.id.txt_pullrefresh);
        this.n = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.pull_to_refresh));
        com.zte.iptvclient.common.uiframe.f.a(this.l.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.l.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.l.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.l.findViewById(R.id.refresh_image));
        this.l.setVisibility(8);
        this.k.a(new DefaultRefreshHeader(context));
        this.k.a(new DefaultRefreshFooter(context));
        this.k.e(com.zte.iptvclient.android.common.k.g.a(context, getResources().getDimension(R.dimen.refresh_footer_height)));
        this.k.f(com.zte.iptvclient.android.common.k.g.a(context, getResources().getDimension(R.dimen.refresh_header_height)));
    }

    public void a() {
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str);
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, str2);
        bundle.putString(MovieDetailBundleBean.SERIES_BUNDLEPARAMS_SERIES_NUM, str3);
        Intent intent = new Intent(getContext(), (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "seriesdetail");
        intent.putExtras(bundle);
        intent.setFlags(536870912);
        getContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str);
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, str2);
        bundle.putBoolean("doAnim", false);
        Intent intent = new Intent(getContext(), (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "seriesdetail");
        intent.putExtras(bundle);
        intent.setFlags(536870912);
        getContext().startActivity(intent);
    }
}
