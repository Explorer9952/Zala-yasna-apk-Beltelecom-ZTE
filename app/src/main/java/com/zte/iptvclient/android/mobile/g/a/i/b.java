package com.zte.iptvclient.android.mobile.g.a.i;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.impl.IIPTVLogin;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.k.u;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.DeleteSchduleResultBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.RecordFileDetailBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.RecordFileListBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.ScheduleListBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.ScheduleResultBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.UserVolumeBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.LeftSlideDeleteRecyclerview;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.b;
import com.zte.iptvclient.android.zala.R;
import com.zte.sdk.enumclass.CapablityEnum;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CloudDvrManagerFragment.java */
/* loaded from: classes.dex */
public class b extends com.zte.fragmentlib.b implements com.zte.iptvclient.android.mobile.g.a.c {
    private static final String e0 = b.class.getName();
    Spinner A;
    com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.b C;
    int D;
    int E;
    private String F;
    private String G;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;
    private String O;
    private String P;
    private m Q;
    private g R;
    private i S;
    private h T;
    private j U;
    private com.zte.iptvclient.android.mobile.g.a.h.a V;
    private SmartRefreshLayout Y;
    private RelativeLayout Z;
    private TextView a0;
    private String b0;
    private String c0;
    com.zte.iptvclient.android.common.j.h d0;
    TextView r;
    Button s;
    TextView t;
    TextView u;
    ConstraintLayout v;
    ImageView w;
    TextView x;
    TextView y;
    LeftSlideDeleteRecyclerview z;
    ArrayList<Integer> p = new ArrayList<>();
    ArrayList<String> q = new ArrayList<>();
    ArrayList<RecordFileListBean.DataBean> B = new ArrayList<>();
    private boolean W = true;
    private int X = 0;

    /* compiled from: CloudDvrManagerFragment.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.D();
        }
    }

    /* compiled from: CloudDvrManagerFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.g.a.i.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ViewOnClickListenerC0260b implements View.OnClickListener {
        ViewOnClickListenerC0260b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogEx.d(b.e0, "Delete");
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            b.this.K();
        }
    }

    /* compiled from: CloudDvrManagerFragment.java */
    /* loaded from: classes.dex */
    class c implements com.scwang.smartrefresh.layout.d.c {
        c() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            b bVar = b.this;
            bVar.g(bVar.X);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudDvrManagerFragment.java */
    /* loaded from: classes.dex */
    public class e implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        e() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d(b.e0, "queryCloudDvrPlayURL  onDataReturn, resultJson= " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("returncode").equals("0")) {
                    String string = jSONObject.getString("playurl");
                    LogEx.d(b.e0, "playurl = " + string);
                    u.a(((com.zte.fragmentlib.b) b.this).h, string);
                }
                ((com.zte.fragmentlib.b) b.this).h.d();
            } catch (JSONException e) {
                e.printStackTrace();
                ((com.zte.fragmentlib.b) b.this).h.d();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d(b.e0, "queryCloudDvrPlayURL  onFailReturn,arg0= " + str + " ,arg1=" + i);
            ((com.zte.fragmentlib.b) b.this).h.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudDvrManagerFragment.java */
    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* compiled from: CloudDvrManagerFragment.java */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                bVar.C.a(0, bVar.B.size(), MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
            }
        }

        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<RecordFileListBean.DataBean> arrayList;
            ArrayList<Channel> b2 = com.zte.iptvclient.android.common.j.i.d().b();
            boolean z = false;
            if (b2 != null && (arrayList = b.this.B) != null) {
                Iterator<RecordFileListBean.DataBean> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    RecordFileListBean.DataBean next = it2.next();
                    Iterator<Channel> it3 = b2.iterator();
                    while (it3.hasNext()) {
                        Channel next2 = it3.next();
                        if (next.getChannelcode().equals(next2.getChannelcode())) {
                            next.setIconurl(next2.getPosterimage());
                            z = true;
                        }
                    }
                }
            }
            if (z) {
                b.this.z.post(new a());
            }
        }
    }

    /* compiled from: CloudDvrManagerFragment.java */
    /* loaded from: classes.dex */
    public class g implements m {

        /* compiled from: CloudDvrManagerFragment.java */
        /* loaded from: classes.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b bVar = b.this;
                bVar.Q = bVar.S;
                b.this.Q.a();
            }
        }

        public g() {
        }

        @Override // com.zte.iptvclient.android.mobile.g.a.i.b.m
        public void a() {
            b bVar = b.this;
            bVar.u.setText(bVar.K);
            b.this.u.setVisibility(0);
            b.this.u.setOnClickListener(new a());
            b.this.t.setVisibility(0);
            b.this.s.setVisibility(8);
            b.this.v.setVisibility(0);
            b.this.Z.setVisibility(8);
            b.this.b(true);
            b.this.p.clear();
            b bVar2 = b.this;
            bVar2.t.setText(bVar2.F);
            b.this.A.setClickable(false);
            b.this.A.setFocusable(false);
            b.this.A.setEnabled(false);
            b.this.Y.d(false);
            b.this.O();
        }
    }

    /* compiled from: CloudDvrManagerFragment.java */
    /* loaded from: classes.dex */
    public class h implements m {
        public h() {
        }

        @Override // com.zte.iptvclient.android.mobile.g.a.i.b.m
        public void a() {
            b.this.u.setVisibility(4);
            b.this.A.setClickable(false);
            b.this.A.setFocusable(false);
            b.this.A.setEnabled(false);
            b.this.Z.setVisibility(0);
            b.this.t.setVisibility(8);
            b.this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_recording_manager));
            b.this.s.setVisibility(0);
            b.this.v.setVisibility(8);
            b.this.b(false);
            b.this.p.clear();
            b.this.Y.d(true);
        }
    }

    /* compiled from: CloudDvrManagerFragment.java */
    /* loaded from: classes.dex */
    public class i implements m {

        /* compiled from: CloudDvrManagerFragment.java */
        /* loaded from: classes.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b bVar = b.this;
                bVar.Q = bVar.R;
                b.this.Q.a();
            }
        }

        public i() {
        }

        @Override // com.zte.iptvclient.android.mobile.g.a.i.b.m
        public void a() {
            b bVar = b.this;
            bVar.u.setText(bVar.J);
            b.this.u.setVisibility(0);
            b.this.u.setOnClickListener(new a());
            b.this.Z.setVisibility(8);
            b.this.t.setVisibility(8);
            b.this.s.setVisibility(0);
            b.this.v.setVisibility(8);
            b.this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_recording_manager));
            b.this.b(false);
            b.this.p.clear();
            b bVar2 = b.this;
            bVar2.t.setText(bVar2.F);
            b.this.A.setClickable(true);
            b.this.A.setFocusable(true);
            b.this.A.setEnabled(true);
            b.this.Y.d(true);
        }
    }

    /* compiled from: CloudDvrManagerFragment.java */
    /* loaded from: classes.dex */
    public class j implements m {
        public j() {
        }

        @Override // com.zte.iptvclient.android.mobile.g.a.i.b.m
        public void a() {
            b.this.u.setVisibility(4);
            b.this.A.setClickable(false);
            b.this.A.setFocusable(false);
            b.this.A.setEnabled(false);
            b.this.Z.setVisibility(4);
            b.this.t.setVisibility(8);
            b.this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_recording_manager));
            b.this.s.setVisibility(0);
            b.this.v.setVisibility(8);
            b.this.b(false);
            b.this.p.clear();
            b.this.Y.d(true);
        }
    }

    /* compiled from: CloudDvrManagerFragment.java */
    /* loaded from: classes.dex */
    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogEx.d(b.e0, "Select All");
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            if (b.this.p.size() < b.this.B.size()) {
                b.this.M();
                return;
            }
            b.this.N();
            ArrayList<Integer> arrayList = b.this.p;
            if (arrayList != null) {
                arrayList.clear();
            }
        }
    }

    /* compiled from: CloudDvrManagerFragment.java */
    /* loaded from: classes.dex */
    class l implements AdapterView.OnItemSelectedListener {
        l() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            LogEx.d(b.e0, "mSortSpinner");
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            b.this.X = i;
            if (b.this.W) {
                b.this.W = false;
            } else {
                b bVar = b.this;
                bVar.g(bVar.X);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: CloudDvrManagerFragment.java */
    /* loaded from: classes.dex */
    public interface m {
        void a();
    }

    private void J() {
        if (this.B.size() > 0) {
            i iVar = this.S;
            this.Q = iVar;
            iVar.a();
        } else {
            h hVar = this.T;
            this.Q = hVar;
            hVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        ArrayList<Integer> arrayList = this.p;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it2 = this.p.iterator();
        while (it2.hasNext()) {
            Integer next = it2.next();
            LogEx.d(e0, "delete position = " + next);
            RecordFileListBean.DataBean dataBean = this.B.get(next.intValue());
            sb.append(dataBean.getScheduleid());
            sb.append("-");
            sb.append(dataBean.getSeriesrec());
            sb.append(CapablityEnum.SPLIT_CODE);
            this.q.add(dataBean.getScheduleid());
        }
        LogEx.d(e0, "delete scheduleIDandRecs = " + ((Object) sb));
        if (sb.length() > 1) {
            sb = new StringBuilder(sb.substring(0, sb.length() - 1));
        }
        LogEx.d(e0, "delete scheduleIDandRecs = " + ((Object) sb));
        this.V.a("1", sb.toString(), this.d0.F());
    }

    private void L() {
        new Thread(new f()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        int size = this.B.size();
        this.p.clear();
        for (int i2 = 0; i2 < size; i2++) {
            this.p.add(Integer.valueOf(i2));
        }
        this.C.a(0, size, MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
        this.t.setText(this.G);
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        int size = this.B.size();
        this.p.clear();
        this.C.a(0, size, MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
        this.t.setText(this.F);
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        int size = this.p.size();
        this.r.setText(String.format(size > 1 ? this.O : this.P, Integer.valueOf(size)));
    }

    private static double a(double d2) {
        return (d2 / 1024.0d) / 1024.0d;
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        if (getActivity() instanceof MainActivity) {
            F();
            return true;
        }
        if (!(getActivity() instanceof HostActivity)) {
            return true;
        }
        getActivity().finish();
        return true;
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(DeleteSchduleResultBean deleteSchduleResultBean) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(ScheduleListBean scheduleListBean) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(ScheduleResultBean scheduleResultBean) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(String str) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void b(String str) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void c(String str) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void e(String str) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void g(String str) {
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.z.a(this.C);
        this.C.a(new d());
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d0 = new com.zte.iptvclient.android.common.j.h(this.h);
        EventBus.getDefault().register(this);
        this.b0 = com.zte.iptvclient.android.common.i.a.a.a(R.string.login_set_language);
        this.F = com.zte.iptvclient.android.common.i.a.a.a(R.string.bottom_btn_selectall);
        this.G = com.zte.iptvclient.android.common.i.a.a.a(R.string.bottom_btn_cancelselect);
        this.J = com.zte.iptvclient.android.common.i.a.a.a(R.string.common_edit);
        this.K = com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel);
        this.L = com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_sort_by_time);
        this.M = com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_sort_by_title);
        this.N = com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_sort_by_channel);
        this.O = com.zte.iptvclient.android.common.i.a.a.a(R.string.bookmark_select_nums);
        this.P = com.zte.iptvclient.android.common.i.a.a.a(R.string.bookmark_select_num);
        this.c0 = com.zte.iptvclient.android.common.i.a.a.a(R.string.record_memory);
        this.V = new com.zte.iptvclient.android.mobile.g.a.h.a(this, com.zte.iptvclient.android.mobile.g.a.g.a.b());
        this.D = androidx.core.content.a.a(this.h, R.color.recording_sort_text_select);
        this.E = androidx.core.content.a.a(this.h, R.color.recording_sort_text_unselect);
        if (getArguments() == null) {
            return;
        }
        this.C = new com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.b(this.h, false, this.B, this.p);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_clouddvr_manager_layout, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.fragment_recording_shedules_top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        TextView textView2 = (TextView) inflate.findViewById(R.id.fragment_recording_schedules_title_txt);
        this.r = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_recording_manager));
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.fragment_recording_shedules_header_rl));
        Button button = (Button) inflate.findViewById(R.id.fragment_recording_schedules_btn_back);
        this.s = button;
        com.zte.iptvclient.common.uiframe.f.a(button);
        this.s.setOnClickListener(new a());
        TextView textView3 = (TextView) inflate.findViewById(R.id.fragment_recording_schedules_selectall_txt);
        this.t = textView3;
        com.zte.iptvclient.common.uiframe.f.a(textView3);
        this.t.setOnClickListener(new k());
        TextView textView4 = (TextView) inflate.findViewById(R.id.fragment_recording_schedules_edit_txt);
        this.u = textView4;
        com.zte.iptvclient.common.uiframe.f.a(textView4);
        this.v = (ConstraintLayout) inflate.findViewById(R.id.fragment_recording_schedules_bottom_delete_cl);
        this.w = (ImageView) inflate.findViewById(R.id.delete_img);
        TextView textView5 = (TextView) inflate.findViewById(R.id.delete_txt);
        this.x = textView5;
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.delete));
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        this.v.setOnClickListener(new ViewOnClickListenerC0260b());
        TextView textView6 = (TextView) inflate.findViewById(R.id.fragment_recording_schedules_bottom_uservolume_txt);
        this.y = textView6;
        com.zte.iptvclient.common.uiframe.f.a(textView6);
        LeftSlideDeleteRecyclerview leftSlideDeleteRecyclerview = (LeftSlideDeleteRecyclerview) inflate.findViewById(R.id.fragment_recording_schedules_recyclerview);
        this.z = leftSlideDeleteRecyclerview;
        com.zte.iptvclient.common.uiframe.f.a(leftSlideDeleteRecyclerview);
        this.z.a(new LinearLayoutManager(this.h, 1, false));
        this.A = (Spinner) inflate.findViewById(R.id.fragment_recording_schedules_sort_spinner);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.L);
        arrayList.add(this.M);
        arrayList.add(this.N);
        this.A.setAdapter((SpinnerAdapter) new com.zte.iptvclient.android.mobile.npvr.view.c(this.h, this.A, arrayList, this.D, this.E));
        this.A.setOnItemSelectedListener(new l());
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) inflate.findViewById(R.id.fragment_clouddvr_recording_refreshlayout);
        this.Y = smartRefreshLayout;
        com.zte.iptvclient.common.uiframe.f.a(smartRefreshLayout);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rl_empty);
        this.Z = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout);
        this.Z.setVisibility(8);
        TextView textView7 = (TextView) inflate.findViewById(R.id.txt_pullrefresh);
        this.a0 = textView7;
        com.zte.iptvclient.common.uiframe.f.a(textView7);
        this.a0.setText(this.h.getString(R.string.recording_no_recording_data));
        this.Y.a(new DefaultRefreshHeader(this.h));
        this.Y.a(new DefaultRefreshFooter(this.h));
        this.Y.d(true);
        this.Y.b(false);
        this.Y.c(false);
        SmartRefreshLayout smartRefreshLayout2 = this.Y;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout2.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout3 = this.Y;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout3.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.Y.a(new c());
        this.U = new j();
        this.S = new i();
        this.R = new g();
        this.T = new h();
        j jVar = this.U;
        this.Q = jVar;
        jVar.a();
        g(0);
        this.V.a();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.k.a aVar) {
        LogEx.d(e0, "更改录制文件:" + aVar.d() + " Recmode = " + aVar.a() + " Rectimeafter = " + aVar.b() + " Rectimebefore = " + aVar.c());
        String d2 = aVar.d();
        Iterator<RecordFileListBean.DataBean> it2 = this.B.iterator();
        while (it2.hasNext()) {
            RecordFileListBean.DataBean next = it2.next();
            if (next.getScheduleid().equals(d2)) {
                next.setRecmode(aVar.a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i2) {
        RecordFileListBean.DataBean dataBean = this.B.get(i2);
        if (dataBean != null) {
            u.a(this.h, dataBean.getSchedulename(), dataBean.getScheduleid(), dataBean.getSeriesrec(), dataBean.getRecmode(), dataBean.getRectimeafter(), dataBean.getProfilecode());
            return;
        }
        LogEx.d(e0, "Record File Bean = null, position = " + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i2) {
        if (i2 == 0) {
            h(1);
        } else if (i2 == 1) {
            h(0);
        } else {
            if (i2 != 2) {
                return;
            }
            h(2);
        }
    }

    private void h(int i2) {
        this.V.a("1", "1", "500", i2 + "", this.b0, "0", null, this.d0.F());
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void j(String str) {
        LogEx.d(e0, "showDeleteRecordFileFailed errorMsg = " + str);
        this.q.clear();
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void m(String str) {
        LogEx.d(e0, "query RecordFile list failed, errormsg = " + str);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void n(String str) {
        if (this.p.size() > 0) {
            this.t.setText(this.F);
        }
        int i2 = 0;
        while (i2 < this.B.size()) {
            RecordFileListBean.DataBean dataBean = this.B.get(i2);
            Iterator<String> it2 = this.q.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (it2.next().equals(dataBean.getScheduleid())) {
                    this.B.remove(dataBean);
                    i2--;
                    break;
                }
            }
            i2++;
        }
        this.C.d();
        this.p.clear();
        this.q.clear();
        if (this.B.size() <= 0) {
            h hVar = this.T;
            this.Q = hVar;
            hVar.a();
        } else {
            O();
        }
        this.V.a();
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void o(String str) {
        LogEx.d(e0, "showQueryUserVolumeFailed errorMsg = " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        RecordFileListBean.DataBean dataBean = this.B.get(i2);
        this.V.a(dataBean.getScheduleid(), dataBean.getSeriesrec(), this.b0, dataBean.getProfilecode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2) {
        RecordFileListBean.DataBean dataBean = this.B.get(i2);
        this.q.add(dataBean.getScheduleid());
        this.V.a("1", dataBean.getScheduleid() + "-" + dataBean.getSeriesrec(), this.d0.F());
    }

    /* compiled from: CloudDvrManagerFragment.java */
    /* loaded from: classes.dex */
    class d implements b.g {
        d() {
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.b.g
        public void a(int i) {
            LogEx.d(b.e0, "onItemDelete");
            b.this.p.clear();
            b.this.p.add(Integer.valueOf(i));
            b.this.e(i);
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.b.g
        public void b(int i) {
            LogEx.d(b.e0, "onItemClick");
            b.this.d(i);
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.b.g
        public void c(int i) {
            b.this.f(i);
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.b.g
        public void a(int i, boolean z) {
            LogEx.d(b.e0, "onItemSelect");
            b.this.a(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.b bVar = this.C;
        if (bVar == null || bVar.e() == z) {
            return;
        }
        this.C.b(z);
        this.C.a(0, this.B.size());
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void h(String str) {
        LogEx.d(e0, "query RecordFile Detail failed, errormsg = " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, boolean z) {
        if (z) {
            LogEx.d(e0, "isSelected == true: position = " + i2);
            Iterator<Integer> it2 = this.p.iterator();
            while (it2.hasNext()) {
                if (it2.next().intValue() == i2) {
                    return;
                }
            }
            this.p.add(Integer.valueOf(i2));
            if (this.p.size() == this.B.size()) {
                this.t.setText(this.G);
            }
            Collections.sort(this.p);
            O();
            return;
        }
        LogEx.d(e0, "isSelected == false: position = " + i2);
        Iterator<Integer> it3 = this.p.iterator();
        while (it3.hasNext()) {
            Integer next = it3.next();
            if (next.intValue() == i2) {
                this.p.remove(next);
                this.t.setText(this.F);
                O();
                return;
            }
        }
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(RecordFileListBean recordFileListBean) {
        this.B.clear();
        for (RecordFileListBean.DataBean dataBean : recordFileListBean.getData()) {
            if (DownloadConstant.REPORT_MSGTYPE_URL_NULL.equals(dataBean.getStatus())) {
                this.B.add(dataBean);
            } else {
                LogEx.d(e0, "过滤: status = " + dataBean.getStatus() + " scheduleid = " + dataBean.getScheduleid());
            }
        }
        this.C.a(0, this.B.size());
        L();
        J();
        this.Y.a();
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(RecordFileDetailBean recordFileDetailBean) {
        RecordFileListBean.DataBean dataBean = new RecordFileListBean.DataBean();
        dataBean.setChannelcode(recordFileDetailBean.getChannelcode());
        dataBean.setMediaservice(recordFileDetailBean.getMediaservice());
        dataBean.setPrevuecode(recordFileDetailBean.getPrevuecode());
        dataBean.setScheduleid(recordFileDetailBean.getScheduleid());
        dataBean.setStarttimeutc(recordFileDetailBean.getStarttimeutc());
        dataBean.setStarttime(recordFileDetailBean.getStarttime());
        dataBean.setEndtimeutc(recordFileDetailBean.getEndtimeutc());
        dataBean.setEndtime(recordFileDetailBean.getEndtime());
        a(dataBean);
    }

    private void a(RecordFileListBean.DataBean dataBean) {
        this.h.q();
        String prevuecode = dataBean.getPrevuecode();
        String channelcode = dataBean.getChannelcode();
        String mediaservice = dataBean.getMediaservice();
        String scheduleid = dataBean.getScheduleid();
        String starttime = dataBean.getStarttime();
        String endtime = dataBean.getEndtime();
        LogEx.d(e0, "scheduleid = " + scheduleid + "prevuecode = " + prevuecode + " channelcode = " + channelcode + " mediaservice = " + mediaservice + " begintime = " + starttime + " endtime = " + endtime);
        if (TextUtils.isEmpty(prevuecode) || TextUtils.isEmpty(channelcode) || TextUtils.isEmpty(mediaservice)) {
            return;
        }
        String replace = "http://{ipadd:port}/iptvepg/{frame}/sdk_getclouddvrplayurl.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f());
        LogEx.d(e0, "" + replace);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "gbk");
        sDKNetHTTPRequest.setParam("scheduleid", scheduleid);
        sDKNetHTTPRequest.setParam("prevuecode", prevuecode);
        sDKNetHTTPRequest.setParam("channelcode", channelcode);
        sDKNetHTTPRequest.setParam("begintime", starttime);
        sDKNetHTTPRequest.setParam("endtime", endtime);
        sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_GET, new e());
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(UserVolumeBean userVolumeBean) {
        LogEx.d(e0, "showQueryUserVolumeSuccess");
        double usedvolume = userVolumeBean.getUsedvolume();
        double availablevolume = userVolumeBean.getAvailablevolume();
        double totalvolume = userVolumeBean.getTotalvolume();
        double a2 = a(usedvolume);
        double a3 = a(availablevolume);
        double a4 = (a2 / a(totalvolume)) * 100.0d;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String format = String.format(this.c0, decimalFormat.format(a2), decimalFormat.format(a3), decimalFormat.format(a4) + "%");
        LogEx.d(e0, "uservolumn = " + format);
        this.y.setText(format);
    }
}
