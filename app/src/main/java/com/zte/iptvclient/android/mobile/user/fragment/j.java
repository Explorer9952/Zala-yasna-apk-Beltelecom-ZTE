package com.zte.iptvclient.android.mobile.user.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.vod.SDKVodMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.common.player.activity.VOPlayerActivity;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.e0.d.c;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.video.ContentType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: HelpVideoFragment.java */
/* loaded from: classes2.dex */
public class j extends com.zte.fragmentlib.b {
    private com.zte.iptvclient.android.mobile.e0.d.c A;
    private ArrayList<VideoDetailBean> B;
    private com.zte.iptvclient.android.common.player.f C;
    private String p;
    private Button q;
    private TextView r;
    private RecyclerView s;
    private ArrayList<CommonVideoBean> v;
    private SmartRefreshLayout x;
    private RelativeLayout y;
    private int t = 1;
    private int u = 0;
    private boolean w = false;
    private boolean z = false;
    private f D = new f(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HelpVideoFragment.java */
    /* loaded from: classes2.dex */
    public class a implements c.InterfaceC0220c {
        a() {
        }

        @Override // com.zte.iptvclient.android.mobile.e0.d.c.InterfaceC0220c
        public void a(CommonVideoBean commonVideoBean) {
            if (commonVideoBean != null) {
                j.this.a(commonVideoBean);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HelpVideoFragment.java */
    /* loaded from: classes2.dex */
    public class b implements SDKVodMgr.OnVodDetailWithUrlReturnListener {
        b() {
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnVodDetailWithUrlReturnListener
        public void onVodDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d("HelpFragment", "getVodDetailWithUrl returncode : " + str + ", errormsg : " + str2 + ",data : " + str3);
            if (j.this.B != null) {
                j.this.B.clear();
            } else {
                j.this.B = new ArrayList();
            }
            if (TextUtils.equals(str, "0")) {
                try {
                    if (str3.contains("},]}")) {
                        str3 = str3.replace("},]}", "}]}");
                    }
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        VideoDetailBean videoDetailBeanFromJSon = VideoDetailBean.getVideoDetailBeanFromJSon(jSONArray.getJSONObject(i));
                        if (videoDetailBeanFromJSon != null) {
                            LogEx.d("HelpFragment", "Definition =" + videoDetailBeanFromJSon.getDefinition() + " : playURl=" + videoDetailBeanFromJSon.getPlayurl());
                            j.this.B.add(videoDetailBeanFromJSon);
                        }
                    }
                } catch (Exception e) {
                    LogEx.e("HelpFragment", e.getMessage());
                }
            }
            j.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HelpVideoFragment.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.this.getActivity() instanceof MainActivity) {
                j.this.F();
            } else if (j.this.getActivity() instanceof HostActivity) {
                j.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HelpVideoFragment.java */
    /* loaded from: classes2.dex */
    public class d implements com.scwang.smartrefresh.layout.d.c {
        d() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            j.this.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HelpVideoFragment.java */
    /* loaded from: classes2.dex */
    public class e implements com.scwang.smartrefresh.layout.d.a {
        e() {
        }

        @Override // com.scwang.smartrefresh.layout.d.a
        public void b(com.scwang.smartrefresh.layout.a.h hVar) {
            if (j.this.t <= j.this.u) {
                if (TextUtils.isEmpty(j.this.p)) {
                    return;
                }
                LogEx.d("HelpFragment", "sdkQueryVideoByColumnCode for=" + j.this.t);
                j jVar = j.this;
                jVar.a(jVar.p, j.this.t);
                return;
            }
            j.this.M();
            hVar.a(true);
            if (j.this.A != null) {
                j.this.A.b(true);
            }
        }
    }

    /* compiled from: HelpVideoFragment.java */
    /* loaded from: classes2.dex */
    private static final class f extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<j> f7453a;

        public f(j jVar) {
            this.f7453a = new WeakReference<>(jVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            j jVar = this.f7453a.get();
            if (jVar != null && message.what == 20481) {
                if (jVar.t <= 1) {
                    jVar.v.clear();
                    if (jVar.A != null) {
                        jVar.A.d();
                        jVar.A.b(false);
                    }
                }
                ArrayList arrayList = (ArrayList) message.obj;
                if (arrayList != null) {
                    jVar.v.addAll(arrayList);
                    if (jVar.A != null) {
                        jVar.A.d();
                    }
                    j.b(jVar);
                    if (jVar.t > jVar.u) {
                        jVar.z = true;
                    } else {
                        jVar.z = false;
                    }
                }
                if (jVar.A != null) {
                    jVar.M();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HelpVideoFragment.java */
    /* loaded from: classes2.dex */
    public class g extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private String f7454a;

        /* renamed from: b, reason: collision with root package name */
        private String f7455b;

        /* renamed from: c, reason: collision with root package name */
        private String f7456c;

        /* renamed from: d, reason: collision with root package name */
        private String f7457d;

        /* compiled from: HelpVideoFragment.java */
        /* loaded from: classes2.dex */
        class a implements SDKVodMgr.OnVodListReturnListener {
            a() {
            }

            @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnVodListReturnListener
            public void onVodListReturn(String str, String str2, String str3) {
                Message obtain = Message.obtain();
                obtain.what = 20481;
                LogEx.d("HelpFragment", "onVodListReturn data : " + str3);
                if (TextUtils.equals(str, "0")) {
                    ArrayList arrayList = new ArrayList();
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        j.this.u = (jSONObject.optInt("totalcount") + 23) / 24;
                        JSONArray jSONArray = jSONObject.getJSONArray("data");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            CommonVideoBean a2 = CommonVideoBean.a(jSONArray.getJSONObject(i));
                            if (a2 != null) {
                                arrayList.add(a2);
                            }
                        }
                        obtain.obj = arrayList;
                    } catch (Exception e) {
                        LogEx.e("HelpFragment", e.getMessage());
                    }
                }
                j.this.D.sendMessage(obtain);
            }
        }

        public g(String str, String str2, String str3, String str4) {
            this.f7454a = str;
            this.f7455b = str2;
            this.f7456c = str3;
            this.f7457d = str4;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            SDKVodMgr sDKVodMgr = new SDKVodMgr();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("columncode", this.f7456c);
            hashMap.put("pageno", this.f7454a);
            hashMap.put("numperpage", this.f7455b);
            hashMap.put("ordertype", this.f7457d);
            hashMap.put("programtype", "1");
            hashMap.put("seriestype", "1,3");
            sDKVodMgr.getVodList(hashMap, new a());
        }
    }

    private void I() {
        this.q.setOnClickListener(new c());
        this.x.a(new d());
        this.x.a(new e());
    }

    private void J() {
        if (!TextUtils.isEmpty(this.p)) {
            this.t = 1;
            a(this.p, 1);
            return;
        }
        this.w = false;
        this.x.a();
        this.x.j();
        this.y.setVisibility(0);
        this.s.setVisibility(8);
    }

    private void K() {
        this.p = com.zte.iptvclient.common.uiframe.a.c("Help_Columncode");
        LogEx.d("HelpFragment", "Help_Columncode " + this.p);
        this.v = new ArrayList<>();
        this.B = new ArrayList<>();
        this.A = new com.zte.iptvclient.android.mobile.e0.d.c(this.h, this.v, new a());
        this.s.a(new LinearLayoutManager(this.h));
        RecyclerView recyclerView = this.s;
        SupportActivity supportActivity = this.h;
        recyclerView.a(new com.zte.iptvclient.android.common.customview.b.a.a(supportActivity, 0, 1, supportActivity.getResources().getColor(R.color.mine_separation_line_bg)));
        this.s.d(true);
        this.s.a(this.A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (this.B.size() <= 0) {
            LogEx.e("HelpFragment", "video detail bean list is empty");
            this.h.d();
            return;
        }
        if (this.C == null) {
            this.C = new com.zte.iptvclient.android.common.player.f();
        }
        Bundle bundle = new Bundle();
        if (this.B.size() == 1 && com.zte.iptvclient.android.common.player.f.c(this.B.get(0).getDefinition())) {
            LogEx.d("HelpFragment", "Definition =" + this.B.get(0).getDefinition());
            bundle.putBoolean("LimitDefinetion", true);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<VideoDetailBean> it2 = this.B.iterator();
        while (it2.hasNext()) {
            VideoDetailBean next = it2.next();
            LogEx.d("HelpFragment", "Definition =" + next.getDefinition());
            if (!com.zte.iptvclient.android.common.player.f.c(next.getDefinition())) {
                arrayList.add(next);
                String playurl = next.getPlayurl();
                if (TextUtils.equals(next.getDefinition(), "1")) {
                    if (TextUtils.isEmpty(playurl)) {
                        playurl = "";
                    }
                    bundle.putString("url_sd", playurl);
                    bundle.putString("physicalcontentid_url_sd", next.getPhysicalcontentid());
                } else if (TextUtils.equals(next.getDefinition(), "2")) {
                    if (TextUtils.isEmpty(playurl)) {
                        playurl = "";
                    }
                    bundle.putString("url_sd_h", playurl);
                    bundle.putString("physicalcontentid_url_sd_h", next.getPhysicalcontentid());
                } else if (TextUtils.equals(next.getDefinition(), "4")) {
                    if (TextUtils.isEmpty(playurl)) {
                        playurl = "";
                    }
                    bundle.putString("url_hd", playurl);
                    bundle.putString("physicalcontentid_url_hd", next.getPhysicalcontentid());
                } else if (TextUtils.equals(next.getDefinition(), "8")) {
                    if (TextUtils.isEmpty(playurl)) {
                        playurl = "";
                    }
                    bundle.putString("url_480p", playurl);
                    bundle.putString("physicalcontentid_url_480p", next.getPhysicalcontentid());
                } else if (TextUtils.equals(next.getDefinition(), GlobalConst.WINPHONE_CLIENT)) {
                    if (TextUtils.isEmpty(playurl)) {
                        playurl = "";
                    }
                    bundle.putString("url_720p", playurl);
                    bundle.putString("physicalcontentid_url_720p", next.getPhysicalcontentid());
                } else if (TextUtils.equals(next.getDefinition(), GlobalConst.ANDRIODSTB_CLIENT)) {
                    if (TextUtils.isEmpty(playurl)) {
                        playurl = "";
                    }
                    bundle.putString("url_1280p", playurl);
                    bundle.putString("physicalcontentid_url_1280p", next.getPhysicalcontentid());
                } else {
                    bundle.putString("url_sd", "");
                }
            }
        }
        if (arrayList.size() == 0 && this.B.size() > arrayList.size()) {
            bundle.putBoolean("LimitDefinetion", true);
        }
        VideoDetailBean videoDetailBean = this.B.get(0);
        bundle.putString("taskID", videoDetailBean.getProgramcode());
        bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, videoDetailBean.getPlayurl());
        LogEx.d("HelpFragment", "playURL=" + videoDetailBean.getPlayurl());
        LogEx.d("UseeTv", "auth code is：" + (TextUtils.isEmpty(videoDetailBean.getAuth_returncode()) ? -1 : Integer.valueOf(videoDetailBean.getAuth_returncode()).intValue()));
        bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, 0);
        bundle.putString("isprotection", videoDetailBean.getIsprotection());
        bundle.putString("programname", videoDetailBean.getProgramname());
        bundle.putString("contentcode", videoDetailBean.getContentcode());
        bundle.putString(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTELECOMCODE, videoDetailBean.getTelecomcode());
        bundle.putString("ratingid", videoDetailBean.getRatingid());
        bundle.putString("programcode", videoDetailBean.getProgramcode());
        if (!TextUtils.isEmpty(videoDetailBean.getPosterfilelist())) {
            String a2 = com.zte.iptvclient.android.common.k.g.a(BaseApp.a(this.h) ? 9 : 3, videoDetailBean.getPosterfilelist());
            bundle.putString("posterUrl", a2);
            LogEx.d("HelpFragment", "POSTERURL=" + a2);
        }
        bundle.putString("posterfilelist", videoDetailBean.getPosterfilelist());
        bundle.putString("columncode", videoDetailBean.getColumncode());
        bundle.putString("Id", videoDetailBean.getProgramcode());
        bundle.putString("playuri4dlna", com.zte.iptvclient.android.mobile.h.a.b.b(videoDetailBean.getColumncode(), videoDetailBean.getProgramcode(), videoDetailBean.getProgramtype(), videoDetailBean.getContentcode(), videoDetailBean.getProgramname(), videoDetailBean.getTelecomcode()));
        bundle.putString("telecomcode", videoDetailBean.getTelecomcode());
        if (!TextUtils.isEmpty(videoDetailBean.getPosterfilelist())) {
            bundle.putString("shareImage", com.zte.iptvclient.android.common.k.g.a(BaseApp.a(this.h) ? 9 : 3, videoDetailBean.getPosterfilelist()));
        }
        bundle.putString("auth_contenttype", String.valueOf(ContentType.TYPE_CONTENT_NORMAL_VOD.getIntValue()));
        bundle.putBoolean("PlayHelperCheck", false);
        bundle.putBoolean("support_push", false);
        bundle.putString("fromActivityName", "HelpVideoFragment");
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.setClass(this.h, VOPlayerActivity.class);
        intent.addFlags(268435456);
        this.h.startActivity(intent);
        this.h.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        this.w = false;
        this.x.a();
        this.x.j();
        ArrayList<CommonVideoBean> arrayList = this.v;
        if (arrayList != null) {
            if (arrayList.size() == 0) {
                this.y.setVisibility(0);
                this.s.setVisibility(8);
            } else {
                this.y.setVisibility(8);
                this.s.setVisibility(0);
            }
            if (this.v.size() >= 24 && !this.z) {
                this.A.b(false);
            } else {
                this.A.b(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (TextUtils.isEmpty(this.p) || this.w) {
            return;
        }
        this.t = 1;
        this.z = false;
        this.x.a(false);
        LogEx.d("HelpFragment", "sdkQueryVideoByColumnCode for=" + this.t);
        a(this.p, this.t);
    }

    static /* synthetic */ int b(j jVar) {
        int i = jVar.t;
        jVar.t = i + 1;
        return i;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        K();
        J();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.help_fragment_layout, (ViewGroup) null);
        d(inflate);
        I();
        if (this.o) {
            this.q.setVisibility(0);
        }
        return inflate;
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.q = (Button) view.findViewById(R.id.btn_back);
        TextView textView2 = (TextView) view.findViewById(R.id.title_txt);
        this.r = textView2;
        textView2.setText(this.h.getResources().getString(R.string.help_feedbook));
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_bottom_line));
        ImageView imageView = (ImageView) view.findViewById(R.id.header_bottom_line);
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        if (BaseApp.a(this.h)) {
            imageView.setVisibility(0);
            com.zte.iptvclient.android.common.k.g.a(imageView, this.h);
        }
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        this.x = smartRefreshLayout;
        smartRefreshLayout.a(new DefaultRefreshHeader(this.h));
        this.x.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout2 = this.x;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout2.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout3 = this.x;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout3.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.x.c(false);
        this.y = (RelativeLayout) view.findViewById(R.id.rl_empty);
        ((TextView) view.findViewById(R.id.txt_pullrefresh)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.there_is_no_collection));
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.y.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.y.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.y.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.y.findViewById(R.id.refresh_image));
        this.y.setVisibility(8);
        this.s = (RecyclerView) view.findViewById(R.id.rv_video);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CommonVideoBean commonVideoBean) {
        SupportActivity supportActivity = this.h;
        if (supportActivity != null) {
            supportActivity.q();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("programcode", commonVideoBean.d());
        hashMap.put("recommendtype", "0");
        hashMap.put("isquerybookmark", "0");
        new SDKVodMgr().getVodDetailWithUrl(hashMap, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        this.w = true;
        new g(String.valueOf(i), String.valueOf(24), str, "0").start();
    }
}
