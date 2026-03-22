package com.zte.iptvclient.android.mobile.e0.e;

import android.app.Activity;
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.vod.SDKVodMgr;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.gridview.RecomeGridView;
import com.zte.iptvclient.android.common.f.b.k;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import com.zte.iptvclient.android.common.javabean.models.MovieDetailBundleBean;
import com.zte.iptvclient.android.common.javabean.models.SeriesHeadBean;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.vod.ui.columnview.a;
import com.zte.iptvclient.android.zala.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DetailRecommendFragment_HD.java */
/* loaded from: classes2.dex */
public class h extends com.zte.fragmentlib.b {
    private RecomeGridView A;
    private i B;
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private TextView J;
    private String K;
    private LinearLayout M;
    private RecomeGridView N;
    private com.zte.iptvclient.android.mobile.e0.d.e O;
    private SDKVodMgr R;
    private com.zte.iptvclient.android.common.f.b.k S;
    protected com.zte.iptvclient.android.common.j.h p;
    private VideoDetailBean q;
    FrameLayout r;
    private LinearLayout s;
    private RelativeLayout t;
    private RecomeGridView u;
    private LinearLayout v;
    private RelativeLayout w;
    private RecomeGridView x;
    private LinearLayout y;
    private RelativeLayout z;
    private long L = 0;
    private ArrayList<com.zte.iptvclient.android.mobile.vod.entity.a> P = new ArrayList<>();
    private String Q = "";
    private HandlerC0233h T = new HandlerC0233h(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailRecommendFragment_HD.java */
    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            LogEx.d("DetailRecommendFragment_HD", "--onItemClick--position : " + i);
            Object adapter = adapterView.getAdapter();
            if (adapter instanceof com.zte.iptvclient.android.mobile.e0.d.e) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.i());
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.j());
                com.zte.iptvclient.android.mobile.e0.d.e eVar = (com.zte.iptvclient.android.mobile.e0.d.e) adapter;
                com.zte.iptvclient.android.mobile.vod.entity.a item = eVar.getItem(i);
                if (item.f()) {
                    return;
                }
                Fragment parentFragment = h.this.getParentFragment();
                if (parentFragment instanceof j) {
                    ((j) parentFragment).s(item.c());
                }
                eVar.a(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailRecommendFragment_HD.java */
    /* loaded from: classes2.dex */
    public class b implements SDKVodMgr.OnVodListReturnListener {
        b() {
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnVodListReturnListener
        public void onVodListReturn(String str, String str2, String str3) {
            LogEx.d("DetailRecommendFragment_HD", "getVodList data : " + str3);
            if (TextUtils.equals(str, "0")) {
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        CommonVideoBean a2 = CommonVideoBean.a(jSONArray.getJSONObject(i));
                        if (a2 != null) {
                            if (!TextUtils.equals(h.this.q.getProgramcode(), a2.d())) {
                                arrayList.add(a2);
                                if (arrayList.size() >= 12) {
                                    break;
                                }
                            } else {
                                LogEx.d("DetailRecommendFragment_HD", "programcode = " + h.this.q.getProgramcode());
                            }
                        }
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 28673;
                    obtain.obj = arrayList;
                    h.this.T.sendMessage(obtain);
                } catch (Exception e) {
                    LogEx.e("DetailRecommendFragment_HD", e.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailRecommendFragment_HD.java */
    /* loaded from: classes2.dex */
    public class c implements SDKVodMgr.OnSeriesChildListReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5945a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SeriesHeadBean f5946b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f5947c;

        c(String str, SeriesHeadBean seriesHeadBean, String str2) {
            this.f5945a = str;
            this.f5946b = seriesHeadBean;
            this.f5947c = str2;
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnSeriesChildListReturnListener
        public void onSeriesChildListReturn(String str, String str2, String str3) {
            LogEx.d("DetailRecommendFragment_HD", "Season Data --> returncode : " + str + " , error : " + str2 + " , data : " + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    h.this.s(jSONObject.optString("totalcount"));
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        com.zte.iptvclient.android.mobile.vod.entity.a a2 = com.zte.iptvclient.android.mobile.vod.entity.a.a(jSONArray.getJSONObject(i));
                        if (this.f5945a != null && this.f5945a.equals(a2.c())) {
                            a2.a(true);
                        }
                        arrayList.add(a2);
                    }
                    h.this.P.clear();
                    if (!arrayList.isEmpty()) {
                        h.this.P.addAll(arrayList);
                    } else {
                        h.this.P.add(com.zte.iptvclient.android.mobile.vod.entity.a.a(this.f5946b));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (TextUtils.equals(this.f5947c, "3")) {
                h hVar = h.this;
                hVar.Q = ((com.zte.iptvclient.android.mobile.vod.entity.a) hVar.P.get(0)).c();
                Fragment parentFragment = h.this.getParentFragment();
                if (parentFragment instanceof j) {
                    ((j) parentFragment).s(h.this.Q);
                }
            }
            h.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailRecommendFragment_HD.java */
    /* loaded from: classes2.dex */
    public class d implements k.c {
        d() {
        }

        @Override // com.zte.iptvclient.android.common.f.b.k.c
        public void a(ArrayList<CommonVideoBean> arrayList) {
            if (arrayList != null) {
                h.this.a(2, arrayList);
                LogEx.d("DetailRecommendFragment_HD", "queryRecommendVod vodList.size = " + arrayList.size());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailRecommendFragment_HD.java */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.d(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailRecommendFragment_HD.java */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {

        /* compiled from: DetailRecommendFragment_HD.java */
        /* loaded from: classes2.dex */
        class a implements a.e {
            a() {
            }

            @Override // com.zte.iptvclient.android.mobile.vod.ui.columnview.a.e
            public void a() {
                h.this.r.findViewById(R.id.movie_recommend_scrollview).setVisibility(0);
                h.this.r.removeViewAt(r0.getChildCount() - 1);
            }
        }

        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zte.iptvclient.android.mobile.vod.ui.columnview.a aVar = new com.zte.iptvclient.android.mobile.vod.ui.columnview.a(((com.zte.fragmentlib.b) h.this).h, new a());
            aVar.a(h.this.q);
            h.this.r.addView(aVar, new FrameLayout.LayoutParams(-1, -1));
            h.this.r.findViewById(R.id.movie_recommend_scrollview).setVisibility(8);
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailRecommendFragment_HD.java */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.d(0);
        }
    }

    /* compiled from: DetailRecommendFragment_HD.java */
    /* renamed from: com.zte.iptvclient.android.mobile.e0.e.h$h, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static final class HandlerC0233h extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<h> f5954a;

        public HandlerC0233h(h hVar) {
            this.f5954a = new WeakReference<>(hVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            h hVar = this.f5954a.get();
            if (hVar != null && message.what == 28673) {
                hVar.a(2, (ArrayList<CommonVideoBean>) message.obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailRecommendFragment_HD.java */
    /* loaded from: classes2.dex */
    public class i extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<CommonVideoBean> f5955a;

        /* renamed from: b, reason: collision with root package name */
        private LayoutInflater f5956b;

        /* renamed from: c, reason: collision with root package name */
        private Activity f5957c;

        /* compiled from: DetailRecommendFragment_HD.java */
        /* loaded from: classes2.dex */
        private class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            private CommonVideoBean f5959a;

            public a(CommonVideoBean commonVideoBean) {
                this.f5959a = commonVideoBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((((com.zte.fragmentlib.b) h.this).h instanceof MainActivity) && ((MainActivity) ((com.zte.fragmentlib.b) h.this).h).s()) {
                    return;
                }
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.i());
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.j());
                i.this.a(this.f5959a);
            }
        }

        /* compiled from: DetailRecommendFragment_HD.java */
        /* loaded from: classes2.dex */
        class b {

            /* renamed from: a, reason: collision with root package name */
            ImageView f5961a;

            /* renamed from: b, reason: collision with root package name */
            ImageView f5962b;

            /* renamed from: c, reason: collision with root package name */
            TextView f5963c;

            /* renamed from: d, reason: collision with root package name */
            TextView f5964d;

            b(i iVar) {
            }
        }

        public i(Activity activity, ArrayList<CommonVideoBean> arrayList) {
            this.f5955a = arrayList;
            this.f5957c = activity;
            this.f5956b = (LayoutInflater) activity.getSystemService("layout_inflater");
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<CommonVideoBean> arrayList = this.f5955a;
            if (arrayList == null) {
                LogEx.d("DetailRecommendFragment_HD", "getCount is null!");
                return 0;
            }
            if (arrayList.size() > 12) {
                LogEx.d("DetailRecommendFragment_HD", "getCount=" + this.f5955a.size());
                return 12;
            }
            LogEx.d("DetailRecommendFragment_HD", "getCount=" + this.f5955a.size());
            return this.f5955a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            ArrayList<CommonVideoBean> arrayList = this.f5955a;
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
                view2 = this.f5956b.inflate(R.layout.home_video_item, (ViewGroup) null);
                bVar.f5961a = (ImageView) view2.findViewById(R.id.poster_img);
                bVar.f5962b = (ImageView) view2.findViewById(R.id.ivi_logo_top);
                bVar.f5963c = (TextView) view2.findViewById(R.id.title_txt);
                bVar.f5964d = (TextView) view2.findViewById(R.id.rating_txt);
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.home_video_item_fl));
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.img_rlayout));
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.rating_rl));
                com.zte.iptvclient.common.uiframe.f.a(bVar.f5964d);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f5961a);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f5962b);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f5963c);
                view2.setTag(bVar);
            } else {
                b bVar2 = (b) view.getTag();
                bVar2.f5961a.setImageResource(R.drawable.default_poster_thumb);
                view2 = view;
                bVar = bVar2;
            }
            CommonVideoBean commonVideoBean = this.f5955a.get(i);
            if (commonVideoBean != null) {
                if (commonVideoBean.b().equals("ivi")) {
                    bVar.f5962b.setVisibility(0);
                    bVar.f5962b.setImageDrawable(this.f5957c.getResources().getDrawable(R.drawable.ivi_logo));
                } else if (commonVideoBean.b().equals("Megogo")) {
                    bVar.f5962b.setVisibility(0);
                    bVar.f5962b.setImageDrawable(this.f5957c.getResources().getDrawable(R.drawable.megogo_logo));
                } else {
                    bVar.f5962b.setVisibility(8);
                }
                String a2 = com.zte.iptvclient.android.common.k.g.a(BaseApp.a(h.this.getContext()) ? 9 : 3, commonVideoBean.c());
                if (!TextUtils.isEmpty(a2) && a2.contains("/image")) {
                    int indexOf = a2.indexOf("/image", 1);
                    a2 = com.zte.iptvclient.android.common.f.b.i.g() + a2.substring(indexOf);
                }
                if (!((com.zte.fragmentlib.b) h.this).h.isFinishing()) {
                    com.bumptech.glide.d<String> a3 = com.bumptech.glide.i.a((FragmentActivity) ((com.zte.fragmentlib.b) h.this).h).a(a2);
                    a3.b(R.drawable.default_poster_thumb);
                    a3.a(R.drawable.default_poster_thumb);
                    a3.c(300);
                    a3.a(bVar.f5961a);
                }
                TextView textView = bVar.f5963c;
                String g = commonVideoBean.g();
                String e = commonVideoBean.e();
                String a4 = com.zte.iptvclient.android.common.i.a.a.a(R.string.common_blocktitle);
                h hVar = h.this;
                textView.setText(com.zte.iptvclient.android.mobile.f.b.a.a(g, e, a4, hVar.p, ((com.zte.fragmentlib.b) hVar).h));
                if (commonVideoBean.k() != null) {
                    try {
                        float parseInt = Integer.parseInt(r12) * 1.0f;
                        if (parseInt > 0.0f) {
                            String valueOf = String.valueOf(parseInt);
                            if (valueOf != null) {
                                bVar.f5964d.setText(valueOf);
                                bVar.f5964d.setVisibility(0);
                            } else {
                                bVar.f5964d.setVisibility(4);
                            }
                        }
                    } catch (Exception e2) {
                        LogEx.d("DetailRecommendFragment_HD", e2.getMessage());
                    }
                }
                bVar.f5961a.setOnClickListener(new a(this.f5955a.get(i)));
            }
            return view2;
        }

        public void a(ArrayList<CommonVideoBean> arrayList) {
            ArrayList<CommonVideoBean> arrayList2 = this.f5955a;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            this.f5955a = arrayList;
            notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(CommonVideoBean commonVideoBean) {
            String f = commonVideoBean.f();
            if (TextUtils.isEmpty(f)) {
                return;
            }
            if (f.equals("1")) {
                Bundle bundle = new Bundle();
                bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, commonVideoBean.d());
                bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, commonVideoBean.a());
                bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_RECOMMENDTYPE, "1");
                bundle.putBoolean("doAnim", false);
                Intent intent = new Intent(h.this.getActivity(), (Class<?>) HostActivity.class);
                bundle.putString("fragmenttype", "moviedetail");
                intent.putExtras(bundle);
                intent.setFlags(536870912);
                h.this.getActivity().startActivity(intent);
                return;
            }
            if (f.equals("14")) {
                Bundle bundle2 = new Bundle();
                bundle2.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, commonVideoBean.d());
                bundle2.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, commonVideoBean.a());
                bundle2.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_RECOMMENDTYPE, "1");
                bundle2.putBoolean("doAnim", false);
                Intent intent2 = new Intent(h.this.getActivity(), (Class<?>) HostActivity.class);
                bundle2.putString("fragmenttype", "seriesdetail");
                intent2.putExtras(bundle2);
                intent2.setFlags(536870912);
                h.this.getActivity().startActivity(intent2);
            }
        }
    }

    private boolean J() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.L <= 500) {
            LogEx.w("UseeTv", "Operate limit,less than 500(ms)!");
            return true;
        }
        this.L = currentTimeMillis;
        return false;
    }

    private void K() {
        this.t.setOnClickListener(new e());
        this.z.setOnClickListener(new f());
        this.w.setOnClickListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        this.M.setVisibility(0);
        this.O.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof j) {
            ((j) parentFragment).t(str);
        }
    }

    public void I() {
        SDKVodMgr sDKVodMgr = this.R;
        if (sDKVodMgr != null) {
            sDKVodMgr.cancelRequest();
            this.R = null;
        }
        com.zte.iptvclient.android.common.f.b.k kVar = this.S;
        if (kVar != null) {
            kVar.a();
            this.S = null;
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.K = com.zte.iptvclient.android.common.k.o.j().f();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.p = new com.zte.iptvclient.android.common.j.h(this.h);
        LogEx.d("DetailRecommendFragment_HD", "onCreate");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.detail_movie_recommend_hd, viewGroup, false);
        e(inflate);
        d(inflate);
        K();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.zte.fragmentlib.publicbaseclass.skinloader.a, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    private void c(VideoDetailBean videoDetailBean) {
        com.zte.iptvclient.android.common.f.b.k kVar = new com.zte.iptvclient.android.common.f.b.k(this.h, this.K, videoDetailBean, new d());
        this.S = kVar;
        kVar.a(2);
    }

    private void d(View view) {
        this.r = (FrameLayout) view.findViewById(R.id.fl_recommend_container);
        this.s = (LinearLayout) view.findViewById(R.id.llRecDirector_contaioner);
        this.t = (RelativeLayout) view.findViewById(R.id.rl_rec_directo_header);
        this.u = (RecomeGridView) view.findViewById(R.id.video_detail_rec_director_grid);
        this.v = (LinearLayout) view.findViewById(R.id.llRecStars_contaioner);
        this.w = (RelativeLayout) view.findViewById(R.id.rl_rec_stars_header);
        this.x = (RecomeGridView) view.findViewById(R.id.video_detail_rec_stars_grid);
        this.y = (LinearLayout) view.findViewById(R.id.llMb_Likes_contaioner);
        this.z = (RelativeLayout) view.findViewById(R.id.rl_mb_likes_header);
        this.A = (RecomeGridView) view.findViewById(R.id.video_detail_mb_likes_grid);
        this.u.setNumColumns(4);
        this.x.setNumColumns(4);
        this.A.setNumColumns(4);
        TextView textView = (TextView) view.findViewById(R.id.rec_director_text);
        this.C = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.rec_rel_dir));
        TextView textView2 = (TextView) view.findViewById(R.id.rec_director_more_txt);
        this.D = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.more));
        TextView textView3 = (TextView) view.findViewById(R.id.rec_stars_text);
        this.E = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.rec_rel_stars));
        TextView textView4 = (TextView) view.findViewById(R.id.rec_stars_more_txt);
        this.F = textView4;
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.more));
        TextView textView5 = (TextView) view.findViewById(R.id.mb_likes_text);
        this.G = textView5;
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.rec_may_likes));
        TextView textView6 = (TextView) view.findViewById(R.id.mb_likes_more_txt);
        this.J = textView6;
        textView6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.more));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.movie_recommend_scrollview));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.recomment_contaioner));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.llRecDirector_contaioner));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_rec_directo_header));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_director_text));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_director_more_llayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_director_more_txt));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_director_more_img));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.video_detail_rec_director_grid));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.llRecStars_contaioner));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_rec_stars_header));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_stars_text));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_stars_more_llayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_stars_more_txt));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_stars_more_img));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.video_detail_rec_stars_grid));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.llMb_Likes_contaioner));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_mb_likes_header));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.mb_likes_text));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.mb_likes_more_llayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.mb_likes_more_txt));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.mb_likes_more_img));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.video_detail_mb_likes_grid));
    }

    private void e(View view) {
        this.M = (LinearLayout) view.findViewById(R.id.ll_series_season_layout_pad);
        this.N = (RecomeGridView) view.findViewById(R.id.rv_series_season);
        com.zte.iptvclient.common.uiframe.f.a(this.M.findViewById(R.id.rl_season_title));
        com.zte.iptvclient.common.uiframe.f.a(this.M.findViewById(R.id.tv_season_title));
        this.N.setNumColumns(4);
        com.zte.iptvclient.android.mobile.e0.d.e eVar = new com.zte.iptvclient.android.mobile.e0.d.e(getContext(), this.P);
        this.O = eVar;
        this.N.setAdapter((ListAdapter) eVar);
        this.N.setOnItemClickListener(new com.zte.iptvclient.android.mobile.vod.event.b(new a()));
    }

    private void b(VideoDetailBean videoDetailBean) {
        this.R = new SDKVodMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("columncode", videoDetailBean.getColumncode());
        hashMap.put("pageno", "1");
        hashMap.put("numperpage", "20");
        hashMap.put("ordertype", "0");
        hashMap.put("seriestype", "1,3");
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            hashMap.put("ratingid", com.zte.iptvclient.android.common.k.p.a(new com.zte.iptvclient.android.common.j.h(getContext()).t()));
            LogEx.d("DetailRecommendFragment_HD", " Child Mode getVodSearchList param ratingid");
        }
        this.R.getVodList(hashMap, new b());
    }

    public void a(VideoDetailBean videoDetailBean) {
        this.q = videoDetailBean;
        if (videoDetailBean != null) {
            d(videoDetailBean);
        }
    }

    public void a(SeriesHeadBean seriesHeadBean) {
        if (seriesHeadBean != null) {
            VideoDetailBean b2 = b(seriesHeadBean);
            this.q = b2;
            a(b2);
        }
    }

    public void a(String str, String str2, String str3, SeriesHeadBean seriesHeadBean) {
        LogEx.d("DetailRecommendFragment_HD", "---notifyPadObtainAllSeason---seriesprogramcode : " + str2 + " , programcode : " + str3);
        if (this.P.size() > 0) {
            return;
        }
        SDKVodMgr sDKVodMgr = new SDKVodMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("seriestype", "3");
        hashMap.put("seriesprogramcode", str2);
        sDKVodMgr.getSeriesChildlList(hashMap, new c(str3, seriesHeadBean, str));
    }

    private VideoDetailBean b(SeriesHeadBean seriesHeadBean) {
        VideoDetailBean videoDetailBean = new VideoDetailBean();
        videoDetailBean.setProgramcode(seriesHeadBean.getProgramcode());
        videoDetailBean.setColumncode(seriesHeadBean.getColumncode());
        videoDetailBean.setProgramname(seriesHeadBean.getProgramname());
        videoDetailBean.setDirector(seriesHeadBean.getDirector());
        videoDetailBean.setActor(seriesHeadBean.getActor());
        videoDetailBean.setDescription(seriesHeadBean.getDescription());
        videoDetailBean.setProgramtype(seriesHeadBean.getProgramtype());
        videoDetailBean.setGenre(seriesHeadBean.getGenre());
        videoDetailBean.setCpcode(seriesHeadBean.getCpcode());
        videoDetailBean.setBocode(seriesHeadBean.getBocode());
        videoDetailBean.setContentcode(seriesHeadBean.getContentcode());
        videoDetailBean.setRatingnum(seriesHeadBean.getRatingnum());
        videoDetailBean.setRatingsum(seriesHeadBean.getRatingsum());
        videoDetailBean.setRatingid(seriesHeadBean.getRatingid());
        videoDetailBean.setTrailer(seriesHeadBean.getTrailer());
        videoDetailBean.setTelecomcode(seriesHeadBean.getTelecomcode());
        videoDetailBean.setIsprotection(seriesHeadBean.getIsprotection());
        videoDetailBean.setMediaservices(seriesHeadBean.getMediaservices());
        videoDetailBean.setSeriestype(seriesHeadBean.getSeriestype());
        return videoDetailBean;
    }

    protected void a(int i2, ArrayList<CommonVideoBean> arrayList) {
        if (arrayList == null) {
            return;
        }
        if (i2 == 0 && arrayList.size() > 0) {
            this.s.setVisibility(0);
            this.u.setAdapter((ListAdapter) new i(this.h, arrayList));
            return;
        }
        if (i2 == 1 && arrayList.size() > 0) {
            this.v.setVisibility(0);
            this.x.setAdapter((ListAdapter) new i(this.h, arrayList));
            return;
        }
        if (i2 != 2 || arrayList.size() <= 0) {
            return;
        }
        this.y.setVisibility(0);
        i iVar = this.B;
        if (iVar == null) {
            i iVar2 = new i(this.h, arrayList);
            this.B = iVar2;
            this.A.setAdapter((ListAdapter) iVar2);
            return;
        }
        iVar.a(arrayList);
    }

    private void d(VideoDetailBean videoDetailBean) {
        if (TextUtils.isEmpty(this.K)) {
            b(videoDetailBean);
        } else {
            c(videoDetailBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        if (J() || this.q == null) {
            return;
        }
        com.zte.iptvclient.android.mobile.l.b.b bVar = new com.zte.iptvclient.android.mobile.l.b.b();
        Bundle bundle = new Bundle();
        bundle.putSerializable("VideoDetailBean", this.q);
        bundle.putInt("recommendType", i2);
        bVar.setArguments(bundle);
        a(bVar);
    }
}
