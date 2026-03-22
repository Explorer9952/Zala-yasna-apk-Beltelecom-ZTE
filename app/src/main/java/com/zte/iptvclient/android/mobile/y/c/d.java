package com.zte.iptvclient.android.mobile.y.c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.i;
import com.google.vr.cardboard.TransitionView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.search.SDKSearchMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.o;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SearchPlayVodFragment.java */
/* loaded from: classes.dex */
public class d extends com.zte.fragmentlib.b implements View.OnTouchListener {
    private static boolean J = false;
    private ImageView D;
    private e E;
    View F;
    private h G;
    private GridView p;
    private f q;
    private int s;
    private int t;
    private SmartRefreshLayout y;
    private RelativeLayout z;
    private LayoutInflater r = null;
    private long u = 0;
    private String v = "";
    private int w = 1;
    private boolean x = false;
    private String A = "";
    private int B = 1;
    private ArrayList<com.zte.iptvclient.android.common.javabean.models.f> C = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayVodFragment.java */
    /* loaded from: classes2.dex */
    public class a implements SDKSearchMgr.OnSearchProgramListReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.service.search.SDKSearchMgr.OnSearchProgramListReturnListener
        public void onSearchProgramListReturn(String str, String str2, String str3) {
            LogEx.d("SearchPlayVodFragment", "returncode : " + str + ", errormsg : " + str2 + " , data : " + str3);
            if (TextUtils.equals(str, "0")) {
                d.this.s(str3);
            }
            d.this.O();
            d.this.x = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayVodFragment.java */
    /* loaded from: classes2.dex */
    public class b implements com.scwang.smartrefresh.layout.d.a {
        b() {
        }

        @Override // com.scwang.smartrefresh.layout.d.a
        public void b(com.scwang.smartrefresh.layout.a.h hVar) {
            if (d.this.x) {
                return;
            }
            d.l(d.this);
            if (d.this.B >= d.this.w) {
                if (!TextUtils.isEmpty(d.this.A)) {
                    d.this.N();
                    return;
                } else {
                    d.this.M();
                    return;
                }
            }
            hVar.j();
            hVar.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayVodFragment.java */
    /* loaded from: classes2.dex */
    public class c implements com.scwang.smartrefresh.layout.d.c {
        c() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            d.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayVodFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.y.c.d$d, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0403d implements SDKSearchMgr.OnSearchProgramListByEPGReturnListener {
        C0403d() {
        }

        @Override // com.video.androidsdk.service.search.SDKSearchMgr.OnSearchProgramListByEPGReturnListener
        public void onSearchProgramListReturn(String str, String str2, String str3) {
            LogEx.d("SearchPlayVodFragment", "returncode : " + str + ", errormsg : " + str2 + " , data : " + str3);
            if (TextUtils.equals(str, "0")) {
                d.this.s(str3);
            }
            d.this.O();
            d.this.x = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayVodFragment.java */
    /* loaded from: classes2.dex */
    public interface e {
        void a(com.zte.iptvclient.android.common.javabean.models.f fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayVodFragment.java */
    /* loaded from: classes2.dex */
    public class f extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<com.zte.iptvclient.android.common.javabean.models.f> f7858a;

        /* renamed from: b, reason: collision with root package name */
        private Context f7859b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SearchPlayVodFragment.java */
        /* loaded from: classes2.dex */
        public class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.zte.iptvclient.android.common.javabean.models.f f7861a;

            a(com.zte.iptvclient.android.common.javabean.models.f fVar) {
                this.f7861a = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.d(TransitionView.TRANSITION_ANIMATION_DURATION_MS) || !TextUtils.equals(this.f7861a.z(), "1") || d.this.E == null) {
                    return;
                }
                d.this.E.a(this.f7861a);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: SearchPlayVodFragment.java */
        /* loaded from: classes2.dex */
        public class b extends com.zte.iptvclient.common.uiframe.d {

            /* renamed from: a, reason: collision with root package name */
            ImageView f7863a;

            /* renamed from: b, reason: collision with root package name */
            TextView f7864b;

            /* renamed from: c, reason: collision with root package name */
            TextView f7865c;

            /* renamed from: d, reason: collision with root package name */
            LinearLayout f7866d;
            RelativeLayout e;
            ImageView f;

            public b(f fVar) {
                boolean unused = d.J = "1".equals(ConfigMgr.readPropertie("IsShowBlockTitle"));
            }
        }

        public f(Context context, ArrayList<com.zte.iptvclient.android.common.javabean.models.f> arrayList) {
            d.this.r = (LayoutInflater) context.getSystemService("layout_inflater");
            d.this.s = (com.zte.iptvclient.common.uiframe.f.a() * 114) / 480;
            d.this.t = (d.this.s * 3) / 2;
            this.f7859b = context;
            this.f7858a = arrayList;
        }

        private void a(com.zte.iptvclient.android.common.javabean.models.f fVar, b bVar) {
            bVar.e.setVisibility(0);
            bVar.e.setBackgroundColor(((com.zte.fragmentlib.b) d.this).h.getResources().getColor(R.color.search_vod_select_bg));
            bVar.e.setOnClickListener(new a(fVar));
            if (com.zte.iptvclient.android.mobile.y.b.a.c().a(com.zte.iptvclient.android.mobile.y.b.a.a(fVar))) {
                bVar.f.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.multiscreen_delete_blue));
                ((com.zte.fragmentlib.b) d.this).h.a(bVar.f, "src", R.drawable.multiscreen_delete_blue);
            } else {
                bVar.f.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.multiscreen_add_blue));
                ((com.zte.fragmentlib.b) d.this).h.a(bVar.f, "src", R.drawable.multiscreen_add_blue);
            }
            String e = fVar.e();
            if (d.J && com.zte.iptvclient.android.mobile.f.b.a.a(fVar.s(), ((com.zte.fragmentlib.b) d.this).h)) {
                bVar.f7864b.setText(R.string.common_blocktitle);
            } else if (!TextUtils.isEmpty(e)) {
                bVar.f7864b.setText(e);
            } else {
                bVar.f7864b.setText(" ");
            }
            bVar.f7864b.setTextColor(((com.zte.fragmentlib.b) d.this).h.getResources().getColor(R.color.account_text_color));
            String a2 = g.a(BaseApp.a(this.f7859b) ? 9 : 3, fVar.o());
            Context context = this.f7859b;
            if (context != null && !((Activity) context).isFinishing()) {
                com.bumptech.glide.d<String> a3 = i.b(this.f7859b).a(a2);
                a3.b(d.this.s, d.this.t);
                a3.b(R.drawable.default_poster_thumb);
                a3.a(R.drawable.default_poster_thumb);
                a3.c(300);
                a3.a(bVar.f7863a);
            }
            bVar.f7866d.setVisibility(0);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<com.zte.iptvclient.android.common.javabean.models.f> arrayList = this.f7858a;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f7858a.get(i);
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
                view2 = d.this.r.inflate(R.layout.vod_favorite_item, (ViewGroup) null);
                bVar.f7866d = (LinearLayout) view2.findViewById(R.id.ll_video_item);
                bVar.f7865c = (TextView) view2.findViewById(R.id.rating_txt);
                bVar.f7863a = (ImageView) view2.findViewById(R.id.poster_img);
                bVar.f7864b = (TextView) view2.findViewById(R.id.title_txt);
                bVar.e = (RelativeLayout) view2.findViewById(R.id.rl_del_selected);
                bVar.f = (ImageView) view2.findViewById(R.id.img_del_selected1);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f7866d);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f7865c);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f7864b);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f7863a);
                com.zte.iptvclient.common.uiframe.f.a(bVar.e);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f);
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.img_rlayout1));
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.rating_rl1));
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            if (i < this.f7858a.size()) {
                a(this.f7858a.get(i), bVar);
            }
            return view2;
        }
    }

    public d() {
        new ArrayList();
    }

    private void J() {
        f fVar = new f(this.h, this.C);
        this.q = fVar;
        this.p.setAdapter((ListAdapter) fVar);
    }

    private void K() {
        this.w = 1;
        this.y.a(false);
        if (!TextUtils.isEmpty(this.A)) {
            N();
        } else {
            M();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (this.x) {
            return;
        }
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        this.x = true;
        ArrayList<com.zte.iptvclient.android.common.javabean.models.f> arrayList = this.C;
        if (arrayList != null && this.w == 1) {
            arrayList.clear();
            this.q.notifyDataSetChanged();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("condition", this.v);
        hashMap.put("conditiontype", "16|17|18|19|20|21");
        hashMap.put("contenttype", "0");
        hashMap.put("languagetype", com.zte.iptvclient.android.common.i.a.a.a(R.string.search_language_type));
        hashMap.put("pageno", String.valueOf(this.w));
        hashMap.put("numperpage", "15");
        new SDKSearchMgr().searchProgramListByEPG(hashMap, new C0403d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (TextUtils.isEmpty(this.v)) {
            return;
        }
        this.x = true;
        ArrayList<com.zte.iptvclient.android.common.javabean.models.f> arrayList = this.C;
        if (arrayList != null && this.w == 1) {
            arrayList.clear();
            this.q.notifyDataSetChanged();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("condition", this.v);
        hashMap.put("conditiontype", "16|17|18|19|20|21");
        if (ConfigMgr.readPropertie("SearchType_Chinese") != null && ConfigMgr.readPropertie("SearchType_Chinese").equals("1")) {
            hashMap.put("searchtype", "0");
        } else {
            hashMap.put("searchtype", "2");
        }
        hashMap.put("platformid", "0");
        hashMap.put("languagetype", com.zte.iptvclient.android.common.i.a.a.a(R.string.search_language_type));
        hashMap.put("pageno", String.valueOf(this.w));
        hashMap.put("numperpage", "15");
        hashMap.put("contenttype", "0");
        hashMap.put("subtype", "1|14");
        hashMap.put("filtertype", "2|5");
        hashMap.put("mediaservices", "2|3");
        hashMap.put("ratatingid", com.zte.iptvclient.android.mobile.v.b.a.d(this.G.t()));
        SDKSearchMgr sDKSearchMgr = new SDKSearchMgr();
        sDKSearchMgr.setServerDomain(this.A);
        sDKSearchMgr.searchProgramList(hashMap, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        this.y.a();
        this.y.j();
        f fVar = this.q;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
        if (this.C.size() == 0) {
            this.z.setVisibility(0);
            this.p.setVisibility(8);
        } else {
            this.z.setVisibility(8);
            this.p.setVisibility(0);
        }
    }

    static /* synthetic */ int l(d dVar) {
        int i = dVar.w;
        dVar.w = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONArray optJSONArray3;
        JSONArray optJSONArray4;
        JSONArray optJSONArray5;
        JSONArray optJSONArray6;
        JSONArray optJSONArray7;
        JSONArray optJSONArray8;
        JSONArray optJSONArray9;
        JSONArray optJSONArray10;
        JSONArray optJSONArray11;
        JSONArray optJSONArray12;
        JSONArray optJSONArray13;
        int i;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        try {
            jSONObject = new JSONObject(str);
            this.B = jSONObject.getInt("totalpages");
            optJSONArray = jSONObject.optJSONArray("contentcode");
            optJSONArray2 = jSONObject.optJSONArray("contenttype");
            optJSONArray3 = jSONObject.optJSONArray("subtype");
            optJSONArray4 = jSONObject.optJSONArray("subjectcode");
            optJSONArray5 = jSONObject.optJSONArray("subjectname");
            optJSONArray6 = jSONObject.optJSONArray("channelcode");
            optJSONArray7 = jSONObject.optJSONArray("programcode");
            optJSONArray8 = jSONObject.optJSONArray("starttime");
            optJSONArray9 = jSONObject.optJSONArray("endtime");
            optJSONArray10 = jSONObject.optJSONArray("ratingid");
            optJSONArray11 = jSONObject.optJSONArray("cpcode");
            optJSONArray12 = jSONObject.optJSONArray("postfilelist");
            optJSONArray13 = jSONObject.optJSONArray("seriesnum");
        } catch (Exception e2) {
            e = e2;
        }
        try {
            JSONArray optJSONArray14 = jSONObject.optJSONArray("actor");
            JSONArray optJSONArray15 = jSONObject.optJSONArray("genre");
            JSONArray optJSONArray16 = jSONObject.optJSONArray("subgenre");
            JSONArray optJSONArray17 = jSONObject.optJSONArray("releasedate");
            JSONArray optJSONArray18 = jSONObject.optJSONArray("elapsedtime");
            JSONArray optJSONArray19 = jSONObject.optJSONArray("prevuecode");
            JSONArray optJSONArray20 = jSONObject.optJSONArray("countryname");
            JSONArray optJSONArray21 = jSONObject.optJSONArray("director");
            JSONArray optJSONArray22 = jSONObject.optJSONArray("toppick");
            JSONArray optJSONArray23 = jSONObject.optJSONArray("contentname");
            JSONArray jSONArray5 = optJSONArray13;
            JSONArray optJSONArray24 = jSONObject.optJSONArray("channelname");
            JSONArray optJSONArray25 = jSONObject.optJSONArray("mediaservice");
            JSONArray optJSONArray26 = jSONObject.optJSONArray("markfilename");
            JSONArray optJSONArray27 = jSONObject.optJSONArray("isfavorite");
            int i2 = jSONObject.getInt("totalcount");
            if (i2 > Integer.valueOf("15").intValue()) {
                i2 = Integer.valueOf("15").intValue();
            }
            int i3 = 0;
            while (i3 < i2) {
                com.zte.iptvclient.android.common.javabean.models.f fVar = new com.zte.iptvclient.android.common.javabean.models.f();
                if (optJSONArray != null) {
                    i = i2;
                    fVar.d(optJSONArray.get(i3).toString());
                } else {
                    i = i2;
                }
                if (optJSONArray23 != null) {
                    fVar.e(optJSONArray23.get(i3).toString());
                }
                if (optJSONArray2 != null) {
                    fVar.f(optJSONArray2.get(i3).toString());
                }
                if (optJSONArray3 != null) {
                    fVar.F(optJSONArray3.get(i3).toString());
                }
                if (optJSONArray4 != null) {
                    fVar.D(optJSONArray4.get(i3).toString());
                }
                if (optJSONArray5 != null) {
                    fVar.E(optJSONArray5.get(i3).toString());
                }
                if (optJSONArray6 != null) {
                    fVar.b(optJSONArray6.get(i3).toString());
                }
                if (optJSONArray7 != null) {
                    fVar.t(optJSONArray7.get(i3).toString());
                }
                if (optJSONArray8 != null) {
                    fVar.B(optJSONArray8.get(i3).toString());
                }
                if (optJSONArray9 != null) {
                    fVar.k(optJSONArray9.get(i3).toString());
                }
                if (optJSONArray10 != null) {
                    fVar.u(optJSONArray10.get(i3).toString());
                }
                if (optJSONArray11 != null) {
                    fVar.h(optJSONArray11.get(i3).toString());
                }
                if (optJSONArray12 != null) {
                    fVar.q(optJSONArray12.get(i3).toString());
                }
                if (jSONArray5 != null) {
                    JSONArray jSONArray6 = jSONArray5;
                    jSONArray = jSONArray6;
                    fVar.A(jSONArray6.get(i3).toString());
                } else {
                    jSONArray = jSONArray5;
                }
                if (optJSONArray14 != null) {
                    fVar.a(optJSONArray14.get(i3).toString());
                }
                if (optJSONArray15 != null) {
                    JSONArray jSONArray7 = optJSONArray15;
                    jSONArray2 = jSONArray7;
                    fVar.l(jSONArray7.get(i3).toString());
                } else {
                    jSONArray2 = optJSONArray15;
                }
                if (optJSONArray16 != null) {
                    fVar.C(optJSONArray16.get(i3).toString());
                }
                if (optJSONArray17 != null) {
                    fVar.w(optJSONArray17.get(i3).toString());
                }
                if (optJSONArray18 != null) {
                    fVar.j(optJSONArray18.get(i3).toString());
                }
                if (optJSONArray19 != null) {
                    fVar.r(optJSONArray19.get(i3).toString());
                }
                if (optJSONArray20 != null) {
                    fVar.g(optJSONArray20.get(i3).toString());
                }
                if (optJSONArray21 != null) {
                    fVar.i(optJSONArray21.get(i3).toString());
                }
                if (optJSONArray22 != null) {
                    fVar.G(optJSONArray22.get(i3).toString());
                }
                if (optJSONArray23 != null) {
                    fVar.e(optJSONArray23.get(i3).toString());
                }
                if (optJSONArray24 != null) {
                    jSONArray3 = optJSONArray24;
                    jSONArray4 = optJSONArray23;
                    fVar.c(jSONArray3.get(i3).toString());
                } else {
                    jSONArray3 = optJSONArray24;
                    jSONArray4 = optJSONArray23;
                }
                if (optJSONArray25 != null) {
                    fVar.o(optJSONArray25.get(i3).toString());
                }
                if (optJSONArray26 != null) {
                    fVar.n(optJSONArray26.get(i3).toString());
                }
                if (optJSONArray27 != null) {
                    fVar.m(optJSONArray27.get(i3).toString());
                }
                JSONArray jSONArray8 = jSONArray3;
                this.C.add(fVar);
                i3++;
                optJSONArray23 = jSONArray4;
                i2 = i;
                optJSONArray24 = jSONArray8;
                optJSONArray15 = jSONArray2;
                jSONArray5 = jSONArray;
            }
        } catch (Exception e3) {
            e = e3;
            LogEx.e("SearchPlayVodFragment", e.getMessage());
        }
    }

    public void b(ArrayList<VideoDetailBean> arrayList) {
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Window window;
        super.onActivityCreated(bundle);
        EventBus.getDefault().register(this);
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(48);
        }
        J();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.G = new h(this.h);
        this.A = o.j().g();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.search_vod_fragment_one, viewGroup, false);
        this.F = inflate;
        d(inflate);
        return this.F;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.v.b bVar) {
        if (TextUtils.isEmpty(bVar.a())) {
            return;
        }
        this.v = bVar.a();
        K();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id = view.getId();
        if (id == R.id.refreshLayout || id == R.id.rl_empty || id == R.id.search_vod_gv) {
            LogEx.d("SearchPlayVodFragment", "onTouch");
            if (motionEvent.getAction() != 0 || (view instanceof EditText)) {
                return false;
            }
            A();
        }
        return false;
    }

    private void d(View view) {
        GridView gridView = (GridView) view.findViewById(R.id.search_vod_gv);
        this.p = gridView;
        com.zte.iptvclient.common.uiframe.f.a(gridView);
        this.y = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.z = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.z.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.z.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.z.findViewById(R.id.refresh_image));
        this.z.setVisibility(8);
        this.y.a(new DefaultRefreshHeader(this.h));
        this.y.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.y;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        this.y.c(false);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_animation_loading);
        this.D = imageView;
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        this.y.a(new b());
        this.y.a(new c());
        this.y.setOnTouchListener(this);
        this.z.setOnTouchListener(this);
        this.p.setOnTouchListener(this);
        if (BaseApp.a(this.h)) {
            return;
        }
        ((TextView) view.findViewById(R.id.txt_pullrefresh)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.pull_to_refresh));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.w.e eVar) {
        LogEx.d("SearchPlayVodFragment", "UpdateMulitScreenItems");
        f fVar = this.q;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    public void a(e eVar) {
        this.E = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.u <= i) {
            LogEx.w("UseeTv", "Operate limit,less than " + i + "(ms)!");
            return true;
        }
        this.u = currentTimeMillis;
        return false;
    }
}
