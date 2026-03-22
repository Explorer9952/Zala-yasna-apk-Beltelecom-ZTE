package com.zte.iptvclient.android.mobile.v.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.channel.SDKChannelMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.prevue.SDKPrevueMgr;
import com.video.androidsdk.service.search.SDKSearchMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.e.x.o;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.k.b;
import com.zte.iptvclient.android.common.k.s;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.home.tab.helper.TabHostManager;
import com.zte.iptvclient.android.mobile.npvr.model.bean.AddNpvrResultBean;
import com.zte.iptvclient.android.mobile.npvr.model.bean.DeleteNpvrResultBean;
import com.zte.iptvclient.android.mobile.npvr.model.bean.NpvrBean;
import com.zte.iptvclient.android.mobile.npvr.model.bean.NpvrListBean;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import com.zte.servicesdk.util.TimeShowUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SearchTvodFragment.java */
/* loaded from: classes.dex */
public class c extends com.zte.fragmentlib.b implements View.OnTouchListener, com.zte.iptvclient.android.mobile.p.c {
    public static final String R = c.class.getSimpleName();
    private RelativeLayout A;
    private RelativeLayout B;
    private RelativeLayout C;
    private TextView D;
    private TextView E;
    private ImageView F;
    private ImageView G;
    private int L;
    private int M;
    private com.zte.iptvclient.android.mobile.p.e.a P;
    private String Q;
    private ListView p;
    private j q;
    private String s;
    protected com.zte.iptvclient.android.common.j.h t;
    private SmartRefreshLayout u;
    private RelativeLayout v;
    private boolean r = false;
    private ArrayList<com.zte.iptvclient.android.common.javabean.models.f> w = new ArrayList<>();
    private int x = 1;
    private int y = 1;
    private String z = "";
    private String J = "";
    private String K = "";
    private String[] N = new String[0];
    private String[] O = new String[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchTvodFragment.java */
    /* loaded from: classes2.dex */
    public class a implements SDKSearchMgr.OnSearchProgramListByEPGReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.service.search.SDKSearchMgr.OnSearchProgramListByEPGReturnListener
        public void onSearchProgramListReturn(String str, String str2, String str3) {
            LogEx.d(c.R, "returncode : " + str + ", errormsg : " + str2 + " , data : " + str3);
            if (TextUtils.equals(str, "0")) {
                c.this.s(str3);
            }
            c.this.O();
            c.this.r = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchTvodFragment.java */
    /* loaded from: classes2.dex */
    public class b implements SDKSearchMgr.OnSearchProgramListReturnListener {
        b() {
        }

        @Override // com.video.androidsdk.service.search.SDKSearchMgr.OnSearchProgramListReturnListener
        public void onSearchProgramListReturn(String str, String str2, String str3) {
            LogEx.d(c.R, "returncode : " + str + ", errormsg : " + str2 + " , data : " + str3);
            if (TextUtils.equals(str, "0")) {
                c.this.s(str3);
            }
            c.this.O();
            c.this.r = false;
            c.this.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchTvodFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.v.b.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0373c implements com.scwang.smartrefresh.layout.d.c {
        C0373c() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            c.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchTvodFragment.java */
    /* loaded from: classes2.dex */
    public class d implements com.scwang.smartrefresh.layout.d.a {
        d() {
        }

        @Override // com.scwang.smartrefresh.layout.d.a
        public void b(com.scwang.smartrefresh.layout.a.h hVar) {
            if (c.this.r) {
                return;
            }
            c.O(c.this);
            if (c.this.y >= c.this.x) {
                if (!TextUtils.isEmpty(c.this.z)) {
                    c.this.N();
                    return;
                } else {
                    c.this.M();
                    return;
                }
            }
            hVar.j();
            hVar.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchTvodFragment.java */
    /* loaded from: classes2.dex */
    public class e implements AdapterView.OnItemClickListener {

        /* compiled from: SearchTvodFragment.java */
        /* loaded from: classes2.dex */
        class a implements t.d {
            a(e eVar) {
            }

            @Override // com.zte.iptvclient.android.common.k.t.d
            public void onDismiss() {
            }
        }

        /* compiled from: SearchTvodFragment.java */
        /* loaded from: classes2.dex */
        class b implements b.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f7568a;

            b(int i) {
                this.f7568a = i;
            }

            @Override // com.zte.iptvclient.android.common.k.b.d
            public void a() {
                c cVar = c.this;
                cVar.b((com.zte.iptvclient.android.common.javabean.models.f) cVar.w.get(this.f7568a));
            }

            @Override // com.zte.iptvclient.android.common.k.b.d
            public void b() {
            }
        }

        /* compiled from: SearchTvodFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.v.b.c$e$c, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0374c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ PrevueBean f7570a;

            RunnableC0374c(PrevueBean prevueBean) {
                this.f7570a = prevueBean;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.a(this.f7570a)) {
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.e(this.f7570a.getChannelcode(), com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL)));
                } else {
                    EventBus.getDefault().post(new o(this.f7570a));
                }
                if (c.this.getActivity() != null) {
                    if (c.this.getActivity() instanceof HostActivity) {
                        c.this.getActivity().finish();
                        return;
                    }
                    Fragment parentFragment = c.this.getParentFragment();
                    if (parentFragment == null || !(parentFragment instanceof com.zte.iptvclient.android.mobile.v.b.a)) {
                        return;
                    }
                    ((com.zte.iptvclient.android.mobile.v.b.a) parentFragment).F();
                }
            }
        }

        e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.zte.iptvclient.android.common.javabean.models.f fVar;
            if (!((com.zte.iptvclient.android.common.javabean.models.f) c.this.w.get(i)).B()) {
                if (c.this.w == null || i >= c.this.w.size() || (fVar = (com.zte.iptvclient.android.common.javabean.models.f) c.this.w.get(i)) == null) {
                    return;
                }
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.n.a(TabHostManager.TabName.TV));
                c.this.p.postDelayed(new RunnableC0374c(c.this.a(fVar)), 500L);
                return;
            }
            if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                t.a(((com.zte.fragmentlib.b) c.this).h, new a(this));
            } else if (!((com.zte.iptvclient.android.common.javabean.models.f) c.this.w.get(i)).t().equals("1")) {
                com.zte.iptvclient.android.common.k.b.a(((com.zte.fragmentlib.b) c.this).h, ((com.zte.fragmentlib.b) c.this).h.getResources().getString(R.string.search_npvr_record_msg), new b(i));
            } else {
                c.this.P.c(((com.zte.iptvclient.android.common.javabean.models.f) c.this.w.get(i)).p(), ((com.zte.iptvclient.android.common.javabean.models.f) c.this.w.get(i)).n());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchTvodFragment.java */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.D.setTextColor(((com.zte.fragmentlib.b) c.this).h.getResources().getColor(R.color.white));
            c.this.G.setImageDrawable(((com.zte.fragmentlib.b) c.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up));
            c.this.B.setBackgroundDrawable(((com.zte.fragmentlib.b) c.this).h.getResources().getDrawable(R.drawable.search_sort_bg));
            c.this.K = "";
            c.this.C.setBackgroundDrawable(((com.zte.fragmentlib.b) c.this).h.getResources().getDrawable(R.drawable.search_sort_select_bg));
            if (c.this.F.getDrawable().getCurrent().getConstantState() == ((com.zte.fragmentlib.b) c.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up).getConstantState()) {
                c.this.F.setImageDrawable(((com.zte.fragmentlib.b) c.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up_select));
                c.this.E.setTextColor(((com.zte.fragmentlib.b) c.this).h.getResources().getColor(R.color.black));
                c.this.J = GlobalConst.WINPHONE_CLIENT;
                c.this.L();
                return;
            }
            if (c.this.E.getText().equals("A-Z")) {
                c.this.E.setText("Z-A");
                c.this.E.setTextColor(((com.zte.fragmentlib.b) c.this).h.getResources().getColor(R.color.black));
                c.this.F.setImageDrawable(((com.zte.fragmentlib.b) c.this).h.getResources().getDrawable(R.drawable.icon_search_sort_down_select));
                c.this.J = "17";
            } else {
                c.this.E.setText("A-Z");
                c.this.E.setTextColor(((com.zte.fragmentlib.b) c.this).h.getResources().getColor(R.color.black));
                c.this.F.setImageDrawable(((com.zte.fragmentlib.b) c.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up_select));
                c.this.J = GlobalConst.WINPHONE_CLIENT;
            }
            c.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchTvodFragment.java */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.E.setText("A-Z");
            c.this.E.setTextColor(((com.zte.fragmentlib.b) c.this).h.getResources().getColor(R.color.white));
            c.this.F.setImageDrawable(((com.zte.fragmentlib.b) c.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up));
            c.this.C.setBackgroundDrawable(((com.zte.fragmentlib.b) c.this).h.getResources().getDrawable(R.drawable.search_sort_bg));
            c.this.J = "";
            c.this.B.setBackgroundDrawable(((com.zte.fragmentlib.b) c.this).h.getResources().getDrawable(R.drawable.search_sort_select_bg));
            if (c.this.G.getDrawable().getCurrent().getConstantState() == ((com.zte.fragmentlib.b) c.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up).getConstantState()) {
                c.this.G.setImageDrawable(((com.zte.fragmentlib.b) c.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up_select));
                c.this.D.setTextColor(((com.zte.fragmentlib.b) c.this).h.getResources().getColor(R.color.black));
                c.this.K = "3";
                c.this.L();
                return;
            }
            if (c.this.G.getDrawable().getCurrent().getConstantState() == ((com.zte.fragmentlib.b) c.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up_select).getConstantState()) {
                c.this.G.setImageDrawable(((com.zte.fragmentlib.b) c.this).h.getResources().getDrawable(R.drawable.icon_search_sort_down_select));
                c.this.D.setTextColor(((com.zte.fragmentlib.b) c.this).h.getResources().getColor(R.color.black));
                c.this.K = "4";
            } else {
                c.this.G.setImageDrawable(((com.zte.fragmentlib.b) c.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up_select));
                c.this.D.setTextColor(((com.zte.fragmentlib.b) c.this).h.getResources().getColor(R.color.black));
                c.this.K = "3";
            }
            c.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchTvodFragment.java */
    /* loaded from: classes2.dex */
    public class h implements SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.javabean.models.f f7574a;

        h(com.zte.iptvclient.android.common.javabean.models.f fVar) {
            this.f7574a = fVar;
        }

        @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener
        public void onPrevueDetailWithUrlReturn(String str, String str2, String str3) {
            if (!TextUtils.equals(str, "0")) {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(((com.zte.fragmentlib.b) c.this).h.getResources().getString(R.string.recording_error));
                return;
            }
            try {
                JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                String str4 = "";
                for (int i = 0; i < jSONArray.length(); i++) {
                    str4 = jSONArray.getJSONObject(i).optString("channelcode");
                }
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                c.this.a(str4, this.f7574a);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchTvodFragment.java */
    /* loaded from: classes2.dex */
    public class i implements SDKChannelMgr.OnChannelDetailWithUrlReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.javabean.models.f f7576a;

        i(com.zte.iptvclient.android.common.javabean.models.f fVar) {
            this.f7576a = fVar;
        }

        @Override // com.video.androidsdk.service.channel.SDKChannelMgr.OnChannelDetailWithUrlReturnListener
        public void onChannelDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d(c.R, " onChannelDetailWithUrlReturn " + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    String str4 = "";
                    for (int i = 0; i < jSONArray.length(); i++) {
                        str4 = jSONArray.getJSONObject(i).optString(ParamConst.VOD_MULTIPLE_URL_RSP_AUTH_RETURNCODE);
                    }
                    if (!TextUtils.equals(str4, "0")) {
                        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(((com.zte.fragmentlib.b) c.this).h.getResources().getString(R.string.npvr_not_available));
                    } else {
                        c.this.P.a(this.f7576a.p(), this.f7576a.m(), this.f7576a.b(), null, null, null);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* compiled from: SearchTvodFragment.java */
    /* loaded from: classes2.dex */
    public class j extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private LayoutInflater f7578a;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<com.zte.iptvclient.android.common.javabean.models.f> f7579b;

        /* renamed from: c, reason: collision with root package name */
        private Context f7580c;

        public j(Context context, ArrayList<com.zte.iptvclient.android.common.javabean.models.f> arrayList) {
            this.f7580c = context;
            this.f7579b = arrayList;
            this.f7578a = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<com.zte.iptvclient.android.common.javabean.models.f> arrayList = this.f7579b;
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
            k kVar;
            if (view == null) {
                kVar = new k(null);
                view2 = this.f7578a.inflate(R.layout.tv_mostviewed_item, (ViewGroup) null);
                kVar.f7582a = (ImageView) view2.findViewById(R.id.img_channel_icon);
                kVar.f7583b = (ImageView) view2.findViewById(R.id.img_play);
                kVar.f7585d = (TextView) view2.findViewById(R.id.txt_channel_program_name);
                kVar.e = (TextView) view2.findViewById(R.id.txt_channel_program_duration);
                kVar.f7584c = (TextView) view2.findViewById(R.id.txt_channel_name);
                com.zte.iptvclient.common.uiframe.f.a(kVar.f7582a);
                com.zte.iptvclient.common.uiframe.f.a(kVar.f7583b);
                com.zte.iptvclient.common.uiframe.f.a(kVar.f7585d);
                com.zte.iptvclient.common.uiframe.f.a(kVar.e);
                com.zte.iptvclient.common.uiframe.f.a(kVar.f7584c);
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.rl_channel_item));
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.ll_channel_item_describ));
                view2.setTag(kVar);
            } else {
                view2 = view;
                kVar = (k) view.getTag();
            }
            kVar.f7582a.setImageResource(R.drawable.default_video_thumb);
            c.this.a(this.f7580c, this.f7579b.get(i), kVar);
            return view2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SearchTvodFragment.java */
    /* loaded from: classes2.dex */
    public static class k extends com.zte.iptvclient.common.uiframe.d {

        /* renamed from: a, reason: collision with root package name */
        ImageView f7582a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f7583b;

        /* renamed from: c, reason: collision with root package name */
        TextView f7584c;

        /* renamed from: d, reason: collision with root package name */
        TextView f7585d;
        TextView e;

        private k() {
        }

        /* synthetic */ k(a aVar) {
            this();
        }
    }

    static /* synthetic */ int O(c cVar) {
        int i2 = cVar.x;
        cVar.x = i2 + 1;
        return i2;
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        return false;
    }

    @Override // com.zte.iptvclient.android.mobile.p.c
    public void l(String str) {
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
        this.P = new com.zte.iptvclient.android.mobile.p.e.a(this, new com.zte.iptvclient.android.mobile.p.d.a());
        this.Q = com.zte.iptvclient.android.common.i.a.a.a(R.string.login_set_language);
        this.z = com.zte.iptvclient.android.common.k.o.j().g();
        I();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.search_tvod_fragment, viewGroup, false);
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.v.b bVar) {
        if (TextUtils.isEmpty(bVar.a())) {
            return;
        }
        this.s = bVar.a();
        K();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id = view.getId();
        if (id == R.id.refreshLayout || id == R.id.rl_empty || id == R.id.search_tvod_lv) {
            LogEx.d(com.video.androidsdk.b.a.TAG, "onTouch");
            if (motionEvent.getAction() != 0 || (view instanceof EditText)) {
                return false;
            }
            A();
        }
        return false;
    }

    private void I() {
        if (this.h != null) {
            this.t = new com.zte.iptvclient.android.common.j.h(this.h);
            j jVar = new j(this.h, this.w);
            this.q = jVar;
            this.p.setAdapter((ListAdapter) jVar);
        }
        this.p.setOnItemClickListener(new e());
        this.C.setOnClickListener(new f());
        this.B.setOnClickListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.P.a("1", "500", "3", "4", null, this.Q, null);
    }

    private void K() {
        this.x = 1;
        this.u.a(false);
        if (!TextUtils.isEmpty(this.z)) {
            N();
        } else {
            M();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (this.r) {
            return;
        }
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        if (TextUtils.isEmpty(this.s)) {
            return;
        }
        this.r = true;
        ArrayList<com.zte.iptvclient.android.common.javabean.models.f> arrayList = this.w;
        if (arrayList != null && this.x == 1) {
            arrayList.clear();
            this.q.notifyDataSetChanged();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("condition", this.s);
        hashMap.put("conditiontype", "16|17|18|19|20|21");
        hashMap.put("contenttype", "3");
        hashMap.put("languagetype", com.zte.iptvclient.android.common.i.a.a.a(R.string.search_language_type));
        hashMap.put("pageno", String.valueOf(this.x));
        hashMap.put("numperpage", "15");
        hashMap.put("contentcode", com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL));
        new SDKSearchMgr().searchProgramListByEPG(hashMap, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (TextUtils.isEmpty(this.s)) {
            return;
        }
        this.r = true;
        ArrayList<com.zte.iptvclient.android.common.javabean.models.f> arrayList = this.w;
        if (arrayList != null && this.x == 1) {
            arrayList.clear();
            this.q.notifyDataSetChanged();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("condition", this.s);
        hashMap.put("conditiontype", "16|17|18|19|20|21");
        if (ConfigMgr.readPropertie("SearchType_Chinese") != null && ConfigMgr.readPropertie("SearchType_Chinese").equals("1")) {
            hashMap.put("searchtype", "0");
        } else {
            hashMap.put("searchtype", "2");
        }
        hashMap.put("platformid", "0");
        hashMap.put("languagetype", com.zte.iptvclient.android.common.i.a.a.a(R.string.search_language_type));
        hashMap.put("pageno", String.valueOf(this.x));
        hashMap.put("numperpage", "15");
        hashMap.put("contenttype", "1|3");
        hashMap.put("contentcode", com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL));
        hashMap.put("subtype", "");
        hashMap.put("filtertype", "2|5");
        hashMap.put("mediaservices", "2");
        if (this.t.t() != 0) {
            int i2 = 0;
            this.L = 0;
            this.M = 0;
            String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo(PortalConst.STR_PARENT_CONTROL_LIMIT_LEVEL_VALUE);
            if (!TextUtils.isEmpty(propertiesInfo)) {
                this.O = propertiesInfo.split(",");
                this.N = propertiesInfo.substring(0, propertiesInfo.lastIndexOf(",")).split(",");
            }
            int i3 = 0;
            while (true) {
                String[] strArr = this.N;
                if (i3 >= strArr.length) {
                    break;
                }
                this.L += Integer.parseInt(strArr[i3]);
                i3++;
            }
            while (true) {
                String[] strArr2 = this.O;
                if (i2 >= strArr2.length) {
                    break;
                }
                this.M += Integer.parseInt(strArr2[i2]);
                i2++;
            }
            hashMap.put("ratingid", String.valueOf(this.M - this.L));
        }
        if (TextUtils.isEmpty(this.J) && TextUtils.isEmpty(this.K)) {
            hashMap.put("ordertype", "0");
        } else if (!TextUtils.isEmpty(this.J)) {
            hashMap.put("ordertype", this.J);
            LogEx.d(R, "ordertype mStrLetterSort =" + this.J);
        } else {
            hashMap.put("ordertype", this.K);
            LogEx.d(R, "ordertype mStrTimeSort =" + this.K);
        }
        SDKSearchMgr sDKSearchMgr = new SDKSearchMgr();
        if (!TextUtils.isEmpty(this.z)) {
            sDKSearchMgr.setServerDomain(this.z);
        }
        sDKSearchMgr.searchProgramList(hashMap, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        this.u.a();
        this.u.j();
        if (this.w.size() == 0) {
            this.v.setVisibility(0);
            this.p.setVisibility(8);
        } else {
            this.v.setVisibility(8);
            this.p.setVisibility(0);
        }
        this.q.notifyDataSetChanged();
    }

    private void d(View view) {
        ListView listView = (ListView) view.findViewById(R.id.search_tvod_lv);
        this.p = listView;
        com.zte.iptvclient.common.uiframe.f.a(listView);
        this.u = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        this.v = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.A = (RelativeLayout) view.findViewById(R.id.rl_lineup);
        this.B = (RelativeLayout) view.findViewById(R.id.lineup_two);
        this.C = (RelativeLayout) view.findViewById(R.id.lineup_one);
        this.E = (TextView) view.findViewById(R.id.txt_lineup_one);
        this.D = (TextView) view.findViewById(R.id.txt_lineup_two);
        this.F = (ImageView) view.findViewById(R.id.img_lineup_one);
        this.G = (ImageView) view.findViewById(R.id.img_lineup_two);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        com.zte.iptvclient.common.uiframe.f.a(this.C.findViewById(R.id.img_lineup_one));
        com.zte.iptvclient.common.uiframe.f.a(this.C.findViewById(R.id.txt_lineup_one));
        com.zte.iptvclient.common.uiframe.f.a(this.B.findViewById(R.id.txt_lineup_two));
        com.zte.iptvclient.common.uiframe.f.a(this.B.findViewById(R.id.img_lineup_two));
        com.zte.iptvclient.common.uiframe.f.a(this.v.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.v.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.v.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.v.findViewById(R.id.refresh_image));
        ((TextView) this.v.findViewById(R.id.txt_pullrefresh)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tvod_not_found));
        this.v.setVisibility(8);
        this.u.a(new DefaultRefreshHeader(this.h));
        this.u.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.u;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.u;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.u.c(false);
        this.u.a(new C0373c());
        this.u.a(new d());
        this.u.setOnTouchListener(this);
        this.v.setOnTouchListener(this);
        this.p.setOnTouchListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        int i2;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.y = jSONObject.getInt("totalpages");
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
                int i3 = jSONObject.getInt("totalcount");
                if (i3 > Integer.valueOf("15").intValue()) {
                    i3 = Integer.valueOf("15").intValue();
                }
                int i4 = 0;
                while (i4 < i3) {
                    com.zte.iptvclient.android.common.javabean.models.f fVar = new com.zte.iptvclient.android.common.javabean.models.f();
                    if (optJSONArray != null) {
                        i2 = i3;
                        fVar.d(optJSONArray.get(i4).toString());
                    } else {
                        i2 = i3;
                    }
                    if (optJSONArray23 != null) {
                        fVar.e(optJSONArray23.get(i4).toString());
                    }
                    if (optJSONArray2 != null) {
                        fVar.f(optJSONArray2.get(i4).toString());
                    }
                    if (optJSONArray3 != null) {
                        fVar.F(optJSONArray3.get(i4).toString());
                    }
                    if (optJSONArray4 != null) {
                        fVar.D(optJSONArray4.get(i4).toString());
                    }
                    if (optJSONArray5 != null) {
                        fVar.E(optJSONArray5.get(i4).toString());
                    }
                    if (optJSONArray6 != null) {
                        fVar.b(optJSONArray6.get(i4).toString());
                    }
                    if (optJSONArray7 != null) {
                        fVar.t(optJSONArray7.get(i4).toString());
                    }
                    if (optJSONArray8 != null) {
                        fVar.B(optJSONArray8.get(i4).toString());
                    }
                    if (optJSONArray9 != null) {
                        fVar.k(optJSONArray9.get(i4).toString());
                    }
                    if (optJSONArray10 != null) {
                        fVar.u(optJSONArray10.get(i4).toString());
                    }
                    if (optJSONArray11 != null) {
                        fVar.h(optJSONArray11.get(i4).toString());
                    }
                    if (optJSONArray12 != null) {
                        fVar.q(optJSONArray12.get(i4).toString());
                    }
                    if (jSONArray5 != null) {
                        JSONArray jSONArray6 = jSONArray5;
                        jSONArray = jSONArray6;
                        fVar.A(jSONArray6.get(i4).toString());
                    } else {
                        jSONArray = jSONArray5;
                    }
                    if (optJSONArray14 != null) {
                        fVar.a(optJSONArray14.get(i4).toString());
                    }
                    if (optJSONArray15 != null) {
                        JSONArray jSONArray7 = optJSONArray15;
                        jSONArray2 = jSONArray7;
                        fVar.l(jSONArray7.get(i4).toString());
                    } else {
                        jSONArray2 = optJSONArray15;
                    }
                    if (optJSONArray16 != null) {
                        fVar.C(optJSONArray16.get(i4).toString());
                    }
                    if (optJSONArray17 != null) {
                        fVar.w(optJSONArray17.get(i4).toString());
                    }
                    if (optJSONArray18 != null) {
                        fVar.j(optJSONArray18.get(i4).toString());
                    }
                    if (optJSONArray19 != null) {
                        fVar.r(optJSONArray19.get(i4).toString());
                    }
                    if (optJSONArray20 != null) {
                        fVar.g(optJSONArray20.get(i4).toString());
                    }
                    if (optJSONArray21 != null) {
                        fVar.i(optJSONArray21.get(i4).toString());
                    }
                    if (optJSONArray22 != null) {
                        fVar.G(optJSONArray22.get(i4).toString());
                    }
                    if (optJSONArray23 != null) {
                        fVar.e(optJSONArray23.get(i4).toString());
                    }
                    if (optJSONArray24 != null) {
                        jSONArray3 = optJSONArray24;
                        jSONArray4 = optJSONArray23;
                        fVar.c(jSONArray3.get(i4).toString());
                    } else {
                        jSONArray3 = optJSONArray24;
                        jSONArray4 = optJSONArray23;
                    }
                    if (optJSONArray25 != null) {
                        fVar.o(optJSONArray25.get(i4).toString());
                    }
                    if (optJSONArray26 != null) {
                        fVar.n(optJSONArray26.get(i4).toString());
                    }
                    if (optJSONArray27 != null) {
                        fVar.m(optJSONArray27.get(i4).toString());
                    }
                    JSONArray jSONArray8 = jSONArray3;
                    if (s.b().before(x.e(fVar.x()))) {
                        fVar.a(true);
                    } else {
                        fVar.a(false);
                    }
                    try {
                        this.w.add(fVar);
                        i4++;
                        optJSONArray23 = jSONArray4;
                        i3 = i2;
                        optJSONArray24 = jSONArray8;
                        optJSONArray15 = jSONArray2;
                        jSONArray5 = jSONArray;
                    } catch (Exception e2) {
                        e = e2;
                        LogEx.e(R, e.getMessage());
                        return;
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    @Override // com.zte.iptvclient.android.mobile.p.c
    public void b(String str, String str2) {
        if ("70112505".equals(str2)) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(this.h.getResources().getString(R.string.insufficient_npvr));
        } else {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(this.h.getResources().getString(R.string.recording_error));
        }
        LogEx.d(com.video.androidsdk.b.a.TAG, "添加预约NPVR失败，errorMsg = " + str);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        if (cVar.a().equals("0")) {
            L();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(PrevueBean prevueBean) {
        Date e2 = x.e(prevueBean.getBegintime());
        Date e3 = x.e(prevueBean.getEndtime());
        Date b2 = s.b();
        return b2.after(e2) && b2.before(e3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.zte.iptvclient.android.common.javabean.models.f fVar) {
        SDKPrevueMgr sDKPrevueMgr = new SDKPrevueMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("prevuecode", fVar.p());
        hashMap.put("recommendtype", "0");
        sDKPrevueMgr.getPrevueDetailWithUrl(hashMap, new h(fVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PrevueBean a(com.zte.iptvclient.android.common.javabean.models.f fVar) {
        PrevueBean prevueBean = new PrevueBean();
        prevueBean.setPrevuecode(fVar.p());
        prevueBean.setPrevuename(fVar.e());
        prevueBean.setChannelcode(fVar.b());
        prevueBean.setBegintime(fVar.x());
        prevueBean.setEndtime(fVar.j());
        return prevueBean;
    }

    @Override // com.zte.iptvclient.android.mobile.p.c
    public void a(NpvrListBean npvrListBean) {
        boolean z;
        for (int i2 = 0; i2 < this.w.size(); i2++) {
            com.zte.iptvclient.android.common.javabean.models.f fVar = this.w.get(i2);
            LogEx.d(com.video.androidsdk.b.a.TAG, "节目单code = " + fVar.p());
            Iterator<NpvrBean> it2 = npvrListBean.getDataList().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = false;
                    break;
                }
                NpvrBean next = it2.next();
                LogEx.d(com.video.androidsdk.b.a.TAG, "录制计划的节目单code = " + next.getPrevuecode());
                if (TextUtils.equals(next.getPrevuecode(), fVar.p())) {
                    z = true;
                    break;
                }
            }
            if (z) {
                fVar.v("1");
            } else {
                fVar.v("0");
            }
        }
        this.q.notifyDataSetChanged();
    }

    @Override // com.zte.iptvclient.android.mobile.p.c
    public void a(AddNpvrResultBean addNpvrResultBean) {
        LogEx.d(com.video.androidsdk.b.a.TAG, "showAddNpvrSuccess Result prevuecode = " + addNpvrResultBean.getPrevuecode());
        for (int i2 = 0; i2 < this.w.size(); i2++) {
            com.zte.iptvclient.android.common.javabean.models.f fVar = this.w.get(i2);
            LogEx.d(com.video.androidsdk.b.a.TAG, "showAddNpvrSuccess 当前已有节目单的prevuecode = " + fVar.p());
            if (TextUtils.equals(fVar.p(), addNpvrResultBean.getPrevuecode())) {
                fVar.v("1");
                this.q.notifyDataSetChanged();
                return;
            }
        }
    }

    @Override // com.zte.iptvclient.android.mobile.p.c
    public void a(DeleteNpvrResultBean deleteNpvrResultBean) {
        LogEx.d(com.video.androidsdk.b.a.TAG, "删除的录制计划的Prevuecode = " + deleteNpvrResultBean.getPrevuecode());
        for (int i2 = 0; i2 < this.w.size(); i2++) {
            com.zte.iptvclient.android.common.javabean.models.f fVar = this.w.get(i2);
            LogEx.d(com.video.androidsdk.b.a.TAG, "已有节目单的Prevuecode = " + fVar.p());
            if (TextUtils.equals(fVar.p(), deleteNpvrResultBean.getPrevuecode())) {
                fVar.v("0");
                this.q.notifyDataSetChanged();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.zte.iptvclient.android.common.javabean.models.f fVar) {
        SDKChannelMgr sDKChannelMgr = new SDKChannelMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("channelcode", str);
        sDKChannelMgr.getChannelDetailWithURl(hashMap, new i(fVar));
    }

    @Override // com.zte.iptvclient.android.mobile.p.c
    public void d(String str, String str2) {
        LogEx.d(com.video.androidsdk.b.a.TAG, "errorMsg = " + str2);
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, com.zte.iptvclient.android.common.javabean.models.f fVar, k kVar) {
        if (fVar != null) {
            try {
                kVar.f7585d.setText(fVar.e());
                kVar.f7584c.setText(fVar.c());
                Date a2 = x.a(fVar.x(), "yyyyMMddHHmmss");
                LogEx.d(R, "startdate =" + a2);
                if (fVar.B()) {
                    if (fVar.t().equals("1")) {
                        kVar.f7583b.setImageDrawable(androidx.core.content.a.c(context, R.drawable.icon_waitrecording));
                    } else {
                        kVar.f7583b.setImageDrawable(androidx.core.content.a.c(context, R.drawable.icon_recording));
                    }
                } else {
                    kVar.f7583b.setImageDrawable(androidx.core.content.a.c(context, R.drawable.tv_tvod_play_bg));
                }
                String j2 = fVar.j();
                LogEx.d(R, "endTime =" + j2);
                Date a3 = x.a(j2, "yyyyMMddHHmmss");
                LogEx.d(R, "enddate =" + a3);
                kVar.e.setText(TimeUtil.format(a2, TimeShowUtil.STR_FORMAT_DATE_MONTH) + "  " + TimeUtil.format(a2, "HH:mm") + " - " + TimeUtil.format(a3, "HH:mm"));
                StringBuilder sb = new StringBuilder();
                sb.append(com.zte.iptvclient.android.common.f.b.i.b());
                sb.append("/iptvepg/images/markurl/");
                sb.append(fVar.l());
                String sb2 = sb.toString();
                LogEx.d(R, "strPosterURL=" + sb2);
                if (TextUtils.isEmpty(sb2) || context == null || ((Activity) context).isFinishing()) {
                    return;
                }
                com.bumptech.glide.d<String> a4 = com.bumptech.glide.i.b(context).a(sb2);
                a4.a(R.drawable.default_video_thumb);
                a4.b(126, 94);
                a4.a(kVar.f7582a);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
