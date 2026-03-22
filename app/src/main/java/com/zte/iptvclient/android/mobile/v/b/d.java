package com.zte.iptvclient.android.mobile.v.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
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
import com.google.vr.cardboard.TransitionView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.search.SDKSearchMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.javabean.models.MovieDetailBundleBean;
import com.zte.iptvclient.android.common.k.o;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.v.c.a;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SearchVodFragment.java */
/* loaded from: classes.dex */
public class d extends com.zte.fragmentlib.b implements View.OnTouchListener {
    private static boolean W = false;
    private RelativeLayout A;
    private ImageView F;
    private AnimationDrawable G;
    private com.zte.iptvclient.android.mobile.v.c.a J;
    private g K;
    View L;
    private RelativeLayout N;
    private RelativeLayout O;
    private RelativeLayout P;
    private TextView Q;
    private TextView R;
    private ImageView S;
    private ImageView T;
    private String p;
    private GridView q;
    private h r;
    private int t;
    private int u;
    private SmartRefreshLayout z;
    private LayoutInflater s = null;
    private long v = 0;
    private String w = "";
    private int x = 1;
    private boolean y = false;
    private String B = "";
    private int C = 1;
    private ArrayList<com.zte.iptvclient.android.common.javabean.models.f> D = new ArrayList<>();
    private boolean E = false;
    private boolean M = false;
    private String U = "";
    private String V = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchVodFragment.java */
    /* loaded from: classes2.dex */
    public class a implements SDKSearchMgr.OnSearchProgramListReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.service.search.SDKSearchMgr.OnSearchProgramListReturnListener
        public void onSearchProgramListReturn(String str, String str2, String str3) {
            LogEx.d("SearchVodFragment", "returncode : " + str + ", errormsg : " + str2 + " , data : " + str3);
            if (TextUtils.equals(str, "0")) {
                d.this.s(str3);
            }
            d.this.O();
            d.this.y = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchVodFragment.java */
    /* loaded from: classes2.dex */
    public class b implements com.scwang.smartrefresh.layout.d.a {
        b() {
        }

        @Override // com.scwang.smartrefresh.layout.d.a
        public void b(com.scwang.smartrefresh.layout.a.h hVar) {
            if (d.this.y) {
                return;
            }
            d.w(d.this);
            if (d.this.C >= d.this.x) {
                if (!TextUtils.isEmpty(d.this.B)) {
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
    /* compiled from: SearchVodFragment.java */
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
    /* compiled from: SearchVodFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.v.b.d$d, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewOnClickListenerC0375d implements View.OnClickListener {
        ViewOnClickListenerC0375d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.Q.setTextColor(((com.zte.fragmentlib.b) d.this).h.getResources().getColor(R.color.white));
            d.this.T.setImageDrawable(((com.zte.fragmentlib.b) d.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up));
            d.this.O.setBackgroundDrawable(((com.zte.fragmentlib.b) d.this).h.getResources().getDrawable(R.drawable.search_sort_bg));
            d.this.V = "";
            d.this.P.setBackgroundDrawable(((com.zte.fragmentlib.b) d.this).h.getResources().getDrawable(R.drawable.search_sort_select_bg));
            if (d.this.S.getDrawable().getCurrent().getConstantState() == ((com.zte.fragmentlib.b) d.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up).getConstantState()) {
                d.this.S.setImageDrawable(((com.zte.fragmentlib.b) d.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up_select));
                d.this.R.setTextColor(((com.zte.fragmentlib.b) d.this).h.getResources().getColor(R.color.black));
                d.this.U = GlobalConst.WINPHONE_CLIENT;
                d.this.L();
                return;
            }
            if (d.this.R.getText().equals("A-Z")) {
                d.this.R.setText("Z-A");
                d.this.R.setTextColor(((com.zte.fragmentlib.b) d.this).h.getResources().getColor(R.color.black));
                d.this.S.setImageDrawable(((com.zte.fragmentlib.b) d.this).h.getResources().getDrawable(R.drawable.icon_search_sort_down_select));
                d.this.U = "17";
            } else {
                d.this.R.setText("A-Z");
                d.this.R.setTextColor(((com.zte.fragmentlib.b) d.this).h.getResources().getColor(R.color.black));
                d.this.S.setImageDrawable(((com.zte.fragmentlib.b) d.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up_select));
                d.this.U = GlobalConst.WINPHONE_CLIENT;
            }
            d.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchVodFragment.java */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.R.setText("A-Z");
            d.this.R.setTextColor(((com.zte.fragmentlib.b) d.this).h.getResources().getColor(R.color.white));
            d.this.S.setImageDrawable(((com.zte.fragmentlib.b) d.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up));
            d.this.P.setBackgroundDrawable(((com.zte.fragmentlib.b) d.this).h.getResources().getDrawable(R.drawable.search_sort_bg));
            d.this.U = "";
            d.this.O.setBackgroundDrawable(((com.zte.fragmentlib.b) d.this).h.getResources().getDrawable(R.drawable.search_sort_select_bg));
            if (d.this.T.getDrawable().getCurrent().getConstantState() == ((com.zte.fragmentlib.b) d.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up).getConstantState()) {
                d.this.T.setImageDrawable(((com.zte.fragmentlib.b) d.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up_select));
                d.this.Q.setTextColor(((com.zte.fragmentlib.b) d.this).h.getResources().getColor(R.color.black));
                d.this.V = "3";
                d.this.L();
                return;
            }
            if (d.this.T.getDrawable().getCurrent().getConstantState() == ((com.zte.fragmentlib.b) d.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up_select).getConstantState()) {
                d.this.T.setImageDrawable(((com.zte.fragmentlib.b) d.this).h.getResources().getDrawable(R.drawable.icon_search_sort_down_select));
                d.this.Q.setTextColor(((com.zte.fragmentlib.b) d.this).h.getResources().getColor(R.color.black));
                d.this.V = "4";
            } else {
                d.this.T.setImageDrawable(((com.zte.fragmentlib.b) d.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up_select));
                d.this.Q.setTextColor(((com.zte.fragmentlib.b) d.this).h.getResources().getColor(R.color.black));
                d.this.V = "3";
            }
            d.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchVodFragment.java */
    /* loaded from: classes2.dex */
    public class f implements SDKSearchMgr.OnSearchProgramListByEPGReturnListener {
        f() {
        }

        @Override // com.video.androidsdk.service.search.SDKSearchMgr.OnSearchProgramListByEPGReturnListener
        public void onSearchProgramListReturn(String str, String str2, String str3) {
            LogEx.d("SearchVodFragment", "returncode : " + str + ", errormsg : " + str2 + " , data : " + str3);
            if (TextUtils.equals(str, "0")) {
                d.this.s(str3);
            }
            d.this.O();
            d.this.y = false;
        }
    }

    /* compiled from: SearchVodFragment.java */
    /* loaded from: classes2.dex */
    interface g {
        void a();

        void a(com.zte.iptvclient.android.common.javabean.models.f fVar);

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchVodFragment.java */
    /* loaded from: classes2.dex */
    public class h extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<com.zte.iptvclient.android.common.javabean.models.f> f7592a;

        /* renamed from: b, reason: collision with root package name */
        private Context f7593b;

        /* renamed from: c, reason: collision with root package name */
        a.k f7594c = new a();

        /* compiled from: SearchVodFragment.java */
        /* loaded from: classes2.dex */
        class a implements a.k {
            a() {
            }

            @Override // com.zte.iptvclient.android.mobile.v.c.a.k
            public void a() {
                if (d.this.K != null) {
                    d.this.K.a();
                }
            }

            @Override // com.zte.iptvclient.android.mobile.v.c.a.k
            public void b() {
                if (d.this.K != null) {
                    d.this.K.b();
                }
            }

            @Override // com.zte.iptvclient.android.mobile.v.c.a.k
            public void c() {
                if (d.this.G != null && d.this.G.isRunning()) {
                    d.this.G.stop();
                }
                d.this.F.setVisibility(8);
                if (d.this.J != null) {
                    d.this.J.a(d.this.q);
                }
            }

            @Override // com.zte.iptvclient.android.mobile.v.c.a.k
            public void d() {
                if (d.this.G != null && d.this.G.isRunning()) {
                    d.this.G.stop();
                }
                d.this.F.setVisibility(8);
                if (d.this.J != null) {
                    d.this.J.dismiss();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SearchVodFragment.java */
        /* loaded from: classes2.dex */
        public class b implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.zte.iptvclient.android.common.javabean.models.f f7597a;

            b(com.zte.iptvclient.android.common.javabean.models.f fVar) {
                this.f7597a = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.d(TransitionView.TRANSITION_ANIMATION_DURATION_MS)) {
                    return;
                }
                if (TextUtils.equals(this.f7597a.z(), "1")) {
                    if (d.this.K != null) {
                        d.this.K.a(this.f7597a);
                        return;
                    }
                    return;
                }
                if (d.this.J != null) {
                    d.this.J.dismiss();
                    d.this.J = null;
                    if (d.this.G != null && d.this.G.isRunning()) {
                        d.this.G.stop();
                    }
                }
                d.this.F.setVisibility(0);
                if (d.this.G != null && d.this.G.isRunning()) {
                    d.this.G.start();
                }
                d.this.J = new com.zte.iptvclient.android.mobile.v.c.a(((com.zte.fragmentlib.b) d.this).h, d.this.q, d.this.M, this.f7597a, h.this.f7594c);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SearchVodFragment.java */
        /* loaded from: classes2.dex */
        public class c implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.zte.iptvclient.android.common.javabean.models.f f7599a;

            c(com.zte.iptvclient.android.common.javabean.models.f fVar) {
                this.f7599a = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.d(TransitionView.TRANSITION_ANIMATION_DURATION_MS) || d.this.E) {
                    return;
                }
                d.this.A();
                if (TextUtils.equals(this.f7599a.z(), "1")) {
                    Bundle bundle = new Bundle();
                    bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, this.f7599a.r());
                    bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, this.f7599a.y());
                    bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_RECOMMENDTYPE, "1");
                    bundle.putBoolean("doAnim", false);
                    Intent intent = new Intent(d.this.getActivity(), (Class<?>) HostActivity.class);
                    bundle.putString("fragmenttype", "moviedetail");
                    intent.putExtras(bundle);
                    d.this.getActivity().startActivity(intent);
                    return;
                }
                if (TextUtils.equals(this.f7599a.z(), "14")) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, this.f7599a.r());
                    bundle2.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, this.f7599a.y());
                    bundle2.putString("recommendtype", "1");
                    bundle2.putBoolean("doAnim", false);
                    Intent intent2 = new Intent(d.this.getActivity(), (Class<?>) HostActivity.class);
                    bundle2.putString("fragmenttype", "seriesdetail");
                    intent2.putExtras(bundle2);
                    d.this.getActivity().startActivity(intent2);
                }
            }
        }

        public h(Context context, ArrayList<com.zte.iptvclient.android.common.javabean.models.f> arrayList) {
            d.this.s = (LayoutInflater) context.getSystemService("layout_inflater");
            d.this.t = (com.zte.iptvclient.common.uiframe.f.a() * 114) / 480;
            d.this.u = (d.this.t * 3) / 2;
            this.f7593b = context;
            this.f7592a = arrayList;
        }

        private void a(com.zte.iptvclient.android.common.javabean.models.f fVar, i iVar) {
            if (d.this.E) {
                iVar.g.setVisibility(0);
                if (!d.this.M) {
                    iVar.g.setBackgroundColor(((com.zte.fragmentlib.b) d.this).h.getResources().getColor(R.color.search_vod_select_bg));
                } else {
                    iVar.g.setBackgroundColor(((com.zte.fragmentlib.b) d.this).h.getResources().getColor(R.color.transparent));
                }
                iVar.g.setOnClickListener(new b(fVar));
                if (com.zte.iptvclient.android.common.player.multiplay.a.c().a(com.zte.iptvclient.android.common.player.multiplay.a.a(fVar))) {
                    iVar.h.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.multiscreen_delete_blue));
                    ((com.zte.fragmentlib.b) d.this).h.a(iVar.h, "src", R.drawable.multiscreen_delete_blue);
                } else {
                    iVar.h.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.multiscreen_add_blue));
                    ((com.zte.fragmentlib.b) d.this).h.a(iVar.h, "src", R.drawable.multiscreen_add_blue);
                }
            } else {
                iVar.f7601a.setOnClickListener(new c(fVar));
                iVar.g.setVisibility(8);
            }
            String e = fVar.e();
            if (d.W && com.zte.iptvclient.android.mobile.f.b.a.a(fVar.s(), ((com.zte.fragmentlib.b) d.this).h)) {
                iVar.f7603c.setText(R.string.common_blocktitle);
            } else if (!TextUtils.isEmpty(e)) {
                iVar.f7603c.setText(e);
            } else {
                iVar.f7603c.setText(" ");
            }
            if (d.this.M) {
                iVar.f7603c.setTextColor(c.a.a.a.d.b.d().b(R.color.search_small_color));
                ((com.zte.fragmentlib.b) d.this).h.a(iVar.f7603c, "textColor", R.color.search_small_color);
            } else {
                iVar.f7603c.setTextColor(c.a.a.a.d.b.d().b(R.color.vod_programname_textcolor));
                ((com.zte.fragmentlib.b) d.this).h.a(iVar.f7603c, "textColor", R.color.vod_programname_textcolor);
            }
            String a2 = com.zte.iptvclient.android.common.k.g.a(BaseApp.a(this.f7593b) ? 9 : 3, fVar.o());
            Context context = this.f7593b;
            if (context != null && !((Activity) context).isFinishing()) {
                com.bumptech.glide.d<String> a3 = com.bumptech.glide.i.b(this.f7593b).a(a2);
                a3.b(d.this.t, d.this.u);
                a3.b(R.drawable.default_poster_thumb);
                a3.a(R.drawable.default_poster_thumb);
                a3.c(300);
                a3.a(iVar.f7601a);
                if (fVar.f().equals("ivi")) {
                    iVar.f7602b.setVisibility(0);
                    iVar.f7602b.setImageDrawable(this.f7593b.getResources().getDrawable(R.drawable.ivi_logo));
                } else if (fVar.f().equals("Megogo")) {
                    iVar.f7602b.setVisibility(0);
                    iVar.f7602b.setImageDrawable(this.f7593b.getResources().getDrawable(R.drawable.megogo_logo));
                } else {
                    iVar.f7602b.setVisibility(8);
                }
            }
            iVar.f.setVisibility(0);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<com.zte.iptvclient.android.common.javabean.models.f> arrayList = this.f7592a;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            i iVar;
            if (view == null) {
                iVar = new i();
                view2 = d.this.s.inflate(R.layout.search_vod_item_layout, (ViewGroup) null);
                iVar.f = (LinearLayout) view2.findViewById(R.id.video_item_fl1);
                iVar.f7604d = (TextView) view2.findViewById(R.id.rating_txt1);
                iVar.e = (TextView) view2.findViewById(R.id.txt_series_update_hint);
                iVar.f7601a = (ImageView) view2.findViewById(R.id.poster_img1);
                iVar.f7602b = (ImageView) view2.findViewById(R.id.ivi_logo_top);
                iVar.f7603c = (TextView) view2.findViewById(R.id.title_txt1);
                iVar.g = (RelativeLayout) view2.findViewById(R.id.rl_del_selected1);
                iVar.h = (ImageView) view2.findViewById(R.id.img_del_selected1);
                ((TextView) view2.findViewById(R.id.title_txt1)).setSingleLine(true);
                com.zte.iptvclient.common.uiframe.f.a(iVar.f);
                com.zte.iptvclient.common.uiframe.f.a(iVar.f7604d);
                com.zte.iptvclient.common.uiframe.f.a(iVar.e);
                com.zte.iptvclient.common.uiframe.f.a(iVar.f7603c);
                com.zte.iptvclient.common.uiframe.f.a(iVar.f7601a);
                com.zte.iptvclient.common.uiframe.f.a(iVar.f7602b);
                com.zte.iptvclient.common.uiframe.f.a(iVar.g);
                com.zte.iptvclient.common.uiframe.f.a(iVar.h);
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.img_rlayout1));
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.rating_rl1));
                iVar.e.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.series_update_hint));
                view2.setTag(iVar);
            } else {
                view2 = view;
                iVar = (i) view.getTag();
            }
            if (i < this.f7592a.size()) {
                a(this.f7592a.get(i), iVar);
            }
            return view2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SearchVodFragment.java */
    /* loaded from: classes2.dex */
    public static class i extends com.zte.iptvclient.common.uiframe.d {

        /* renamed from: a, reason: collision with root package name */
        ImageView f7601a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f7602b;

        /* renamed from: c, reason: collision with root package name */
        TextView f7603c;

        /* renamed from: d, reason: collision with root package name */
        TextView f7604d;
        TextView e;
        LinearLayout f;
        RelativeLayout g;
        ImageView h;

        public i() {
            boolean unused = d.W = "1".equals(ConfigMgr.readPropertie("IsShowBlockTitle"));
        }
    }

    static /* synthetic */ int w(d dVar) {
        int i2 = dVar.x;
        dVar.x = i2 + 1;
        return i2;
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
        new com.zte.iptvclient.android.common.j.h(this.h);
        this.B = o.j().g();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.E = arguments.getBoolean("MulitScreenEdit", false);
            this.M = arguments.getBoolean("SmallView", false);
        }
        if (BaseApp.a(this.h)) {
            this.p = "30";
        } else {
            this.p = "15";
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.search_vod_fragment, viewGroup, false);
        this.L = inflate;
        d(inflate);
        return this.L;
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
        this.w = bVar.a();
        K();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id = view.getId();
        if (id == R.id.refreshLayout || id == R.id.rl_empty || id == R.id.search_vod_gv) {
            LogEx.d("SearchVodFragment", "onTouch");
            if (motionEvent.getAction() != 0 || (view instanceof EditText)) {
                return false;
            }
            A();
        }
        return false;
    }

    private void J() {
        if (this.h != null) {
            this.r = new h(this.h, this.D);
        }
        this.q.setAdapter((ListAdapter) this.r);
    }

    private void K() {
        this.x = 1;
        this.z.a(false);
        if (!TextUtils.isEmpty(this.B)) {
            N();
        } else {
            M();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (this.y) {
            return;
        }
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        this.y = true;
        ArrayList<com.zte.iptvclient.android.common.javabean.models.f> arrayList = this.D;
        if (arrayList != null && this.x == 1) {
            arrayList.clear();
            this.r.notifyDataSetChanged();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("condition", this.w);
        hashMap.put("conditiontype", "16|17|18|19|20|21");
        hashMap.put("contenttype", "0");
        hashMap.put("languagetype", com.zte.iptvclient.android.common.i.a.a.a(R.string.search_language_type));
        hashMap.put("pageno", String.valueOf(this.x));
        hashMap.put("numperpage", this.p);
        hashMap.put("contentcode", SDKLoginMgr.getInstance().getPropertiesInfo("Video_Column"));
        new SDKSearchMgr().searchProgramListByEPG(hashMap, new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (TextUtils.isEmpty(this.w)) {
            return;
        }
        this.y = true;
        ArrayList<com.zte.iptvclient.android.common.javabean.models.f> arrayList = this.D;
        if (arrayList != null && this.x == 1) {
            arrayList.clear();
            this.r.notifyDataSetChanged();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("condition", this.w);
        hashMap.put("conditiontype", "16|17|18|19|20|21");
        if (ConfigMgr.readPropertie("SearchType_Chinese") != null && ConfigMgr.readPropertie("SearchType_Chinese").equals("1")) {
            hashMap.put("searchtype", "0");
        } else {
            hashMap.put("searchtype", "2");
        }
        hashMap.put("platformid", "0");
        hashMap.put("languagetype", com.zte.iptvclient.android.common.i.a.a.a(R.string.search_language_type));
        hashMap.put("pageno", String.valueOf(this.x));
        hashMap.put("numperpage", this.p);
        hashMap.put("contenttype", "0");
        hashMap.put("contentcode", SDKLoginMgr.getInstance().getPropertiesInfo("Video_Column"));
        hashMap.put("subtype", "1|14");
        hashMap.put("filtertype", "2|5");
        hashMap.put("mediaservices", "2|3|255");
        if (TextUtils.isEmpty(this.U) && TextUtils.isEmpty(this.V)) {
            hashMap.put("ordertype", "0");
        } else if (!TextUtils.isEmpty(this.U)) {
            hashMap.put("ordertype", this.U);
            LogEx.d("SearchVodFragment", "ordertype mStrLetterSort =" + this.U);
        } else {
            hashMap.put("ordertype", this.V);
            LogEx.d("SearchVodFragment", "ordertype mStrTimeSort =" + this.V);
        }
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Un_Search_VodColumn");
        if (!TextUtils.isEmpty(c2)) {
            hashMap.put("uncontentcode", c2);
        }
        hashMap.put("seriestype", "1|3");
        SDKSearchMgr sDKSearchMgr = new SDKSearchMgr();
        if (!TextUtils.isEmpty(this.B)) {
            sDKSearchMgr.setServerDomain(this.B);
        }
        sDKSearchMgr.searchProgramList(hashMap, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        this.z.a();
        this.z.j();
        h hVar = this.r;
        if (hVar != null) {
            hVar.notifyDataSetChanged();
        }
        if (this.D.size() == 0) {
            this.A.setVisibility(0);
            this.q.setVisibility(8);
        } else {
            this.A.setVisibility(8);
            this.q.setVisibility(0);
        }
    }

    private void d(View view) {
        View view2;
        GridView gridView = (GridView) view.findViewById(R.id.search_vod_gv);
        this.q = gridView;
        com.zte.iptvclient.common.uiframe.f.a(gridView);
        this.z = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        this.A = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.N = (RelativeLayout) view.findViewById(R.id.rl_lineup);
        this.O = (RelativeLayout) view.findViewById(R.id.lineup_two);
        this.P = (RelativeLayout) view.findViewById(R.id.lineup_one);
        this.R = (TextView) view.findViewById(R.id.txt_lineup_one);
        this.Q = (TextView) view.findViewById(R.id.txt_lineup_two);
        this.S = (ImageView) view.findViewById(R.id.img_lineup_one);
        this.T = (ImageView) view.findViewById(R.id.img_lineup_two);
        com.zte.iptvclient.common.uiframe.f.a(this.N);
        com.zte.iptvclient.common.uiframe.f.a(this.O);
        com.zte.iptvclient.common.uiframe.f.a(this.P);
        com.zte.iptvclient.common.uiframe.f.a(this.P.findViewById(R.id.img_lineup_one));
        com.zte.iptvclient.common.uiframe.f.a(this.P.findViewById(R.id.txt_lineup_one));
        com.zte.iptvclient.common.uiframe.f.a(this.O.findViewById(R.id.txt_lineup_two));
        com.zte.iptvclient.common.uiframe.f.a(this.O.findViewById(R.id.img_lineup_two));
        com.zte.iptvclient.common.uiframe.f.a(this.A.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.A.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.A.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.A.findViewById(R.id.refresh_image));
        ((TextView) this.A.findViewById(R.id.txt_pullrefresh)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.vod_not_found));
        this.A.setVisibility(8);
        this.z.a(new DefaultRefreshHeader(this.h));
        this.z.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.z;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.z;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.z.c(false);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_animation_loading);
        this.F = imageView;
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        this.G = (AnimationDrawable) this.F.getDrawable();
        this.z.a(new b());
        this.z.a(new c());
        this.P.setOnClickListener(new ViewOnClickListenerC0375d());
        this.O.setOnClickListener(new e());
        if (this.M && (view2 = this.L) != null) {
            view2.setBackgroundResource(R.color.search_view_main_theme_color_small_trance);
            this.q.setBackground(null);
        }
        this.z.setOnTouchListener(this);
        this.A.setOnTouchListener(this);
        this.q.setOnTouchListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.C = jSONObject.getInt("totalpages");
            JSONArray optJSONArray = jSONObject.optJSONArray("contentcode");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("contenttype");
            JSONArray optJSONArray3 = jSONObject.optJSONArray("subtype");
            JSONArray optJSONArray4 = jSONObject.optJSONArray("subjectcode");
            JSONArray optJSONArray5 = jSONObject.optJSONArray("subjectname");
            JSONArray optJSONArray6 = jSONObject.optJSONArray("channelcode");
            JSONArray optJSONArray7 = jSONObject.optJSONArray("programcode");
            JSONArray optJSONArray8 = jSONObject.optJSONArray("starttime");
            JSONArray optJSONArray9 = jSONObject.optJSONArray("endtime");
            JSONArray optJSONArray10 = jSONObject.optJSONArray("ratingid");
            JSONArray optJSONArray11 = jSONObject.optJSONArray("cpcode");
            JSONArray optJSONArray12 = jSONObject.optJSONArray("postfilelist");
            JSONArray optJSONArray13 = jSONObject.optJSONArray("seriesnum");
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
            JSONArray jSONArray4 = optJSONArray13;
            JSONArray optJSONArray24 = jSONObject.optJSONArray("channelname");
            JSONArray optJSONArray25 = jSONObject.optJSONArray("mediaservice");
            JSONArray optJSONArray26 = jSONObject.optJSONArray("markfilename");
            JSONArray optJSONArray27 = jSONObject.optJSONArray("isfavorite");
            int i2 = jSONObject.getInt("totalcount");
            if (i2 > Integer.valueOf(this.p).intValue()) {
                i2 = Integer.valueOf(this.p).intValue();
            }
            int i3 = 0;
            while (i3 < i2) {
                int i4 = i2;
                com.zte.iptvclient.android.common.javabean.models.f fVar = new com.zte.iptvclient.android.common.javabean.models.f();
                if (optJSONArray != null) {
                    jSONArray = optJSONArray;
                    fVar.d(optJSONArray.get(i3).toString());
                } else {
                    jSONArray = optJSONArray;
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
                if (jSONArray4 != null) {
                    JSONArray jSONArray5 = jSONArray4;
                    jSONArray2 = jSONArray5;
                    fVar.A(jSONArray5.get(i3).toString());
                } else {
                    jSONArray2 = jSONArray4;
                }
                if (optJSONArray14 != null) {
                    fVar.a(optJSONArray14.get(i3).toString());
                }
                if (optJSONArray15 != null) {
                    JSONArray jSONArray6 = optJSONArray15;
                    jSONArray3 = jSONArray6;
                    fVar.l(jSONArray6.get(i3).toString());
                } else {
                    jSONArray3 = optJSONArray15;
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
                    fVar.c(optJSONArray24.get(i3).toString());
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
                this.D.add(fVar);
                i3++;
                optJSONArray15 = jSONArray3;
                i2 = i4;
                jSONArray4 = jSONArray2;
                optJSONArray = jSONArray;
            }
        } catch (Exception e2) {
            LogEx.e("SearchVodFragment", e2.getMessage());
        }
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        com.zte.iptvclient.android.mobile.v.c.a aVar = this.J;
        if (aVar == null) {
            return false;
        }
        aVar.dismiss();
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.y.b bVar) {
        LogEx.d("SearchVodFragment", "UpdateMulitScreenItems");
        h hVar = this.r;
        if (hVar != null) {
            hVar.notifyDataSetChanged();
        }
    }

    public void a(g gVar) {
        this.K = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.v <= i2) {
            LogEx.w("UseeTv", "Operate limit,less than " + i2 + "(ms)!");
            return true;
        }
        this.v = currentTimeMillis;
        return false;
    }
}
