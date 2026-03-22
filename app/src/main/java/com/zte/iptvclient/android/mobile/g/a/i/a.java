package com.zte.iptvclient.android.mobile.g.a.i;

import android.os.Bundle;
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
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.javabean.models.Channel;
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
import com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.a;
import com.zte.iptvclient.android.zala.R;
import com.zte.sdk.enumclass.CapablityEnum;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: CloudDvrHistoryFragment.java */
/* loaded from: classes.dex */
public class a extends com.zte.fragmentlib.b implements com.zte.iptvclient.android.mobile.g.a.c {
    private static final String e0 = a.class.getName();
    Spinner A;
    com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.a C;
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
    private l Q;
    private f R;
    private h S;
    private g T;
    private i U;
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

    /* compiled from: CloudDvrHistoryFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.g.a.i.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ViewOnClickListenerC0256a implements View.OnClickListener {
        ViewOnClickListenerC0256a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.D();
        }
    }

    /* compiled from: CloudDvrHistoryFragment.java */
    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogEx.d(a.e0, "Delete");
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            a.this.K();
        }
    }

    /* compiled from: CloudDvrHistoryFragment.java */
    /* loaded from: classes.dex */
    class c implements com.scwang.smartrefresh.layout.d.c {
        c() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            a aVar = a.this;
            aVar.f(aVar.X);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudDvrHistoryFragment.java */
    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* compiled from: CloudDvrHistoryFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.g.a.i.a$e$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0257a implements Runnable {
            RunnableC0257a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                aVar.C.a(0, aVar.B.size(), MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
            }
        }

        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<RecordFileListBean.DataBean> arrayList;
            ArrayList<Channel> b2 = com.zte.iptvclient.android.common.j.i.d().b();
            boolean z = false;
            if (b2 != null && (arrayList = a.this.B) != null) {
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
                a.this.z.post(new RunnableC0257a());
            }
        }
    }

    /* compiled from: CloudDvrHistoryFragment.java */
    /* loaded from: classes.dex */
    public class f implements l {

        /* compiled from: CloudDvrHistoryFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.g.a.i.a$f$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class ViewOnClickListenerC0258a implements View.OnClickListener {
            ViewOnClickListenerC0258a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = a.this;
                aVar.Q = aVar.S;
                a.this.Q.a();
            }
        }

        public f() {
        }

        @Override // com.zte.iptvclient.android.mobile.g.a.i.a.l
        public void a() {
            a aVar = a.this;
            aVar.u.setText(aVar.K);
            a.this.u.setVisibility(0);
            a.this.u.setOnClickListener(new ViewOnClickListenerC0258a());
            a.this.t.setVisibility(0);
            a.this.s.setVisibility(8);
            a.this.v.setVisibility(0);
            a.this.Z.setVisibility(8);
            a.this.b(true);
            a.this.p.clear();
            a aVar2 = a.this;
            aVar2.t.setText(aVar2.F);
            a.this.A.setClickable(false);
            a.this.A.setFocusable(false);
            a.this.A.setEnabled(false);
            a.this.Y.d(false);
            a.this.O();
        }
    }

    /* compiled from: CloudDvrHistoryFragment.java */
    /* loaded from: classes.dex */
    public class g implements l {
        public g() {
        }

        @Override // com.zte.iptvclient.android.mobile.g.a.i.a.l
        public void a() {
            a.this.u.setVisibility(4);
            a.this.A.setClickable(false);
            a.this.A.setFocusable(false);
            a.this.A.setEnabled(false);
            a.this.Z.setVisibility(0);
            a.this.t.setVisibility(8);
            a.this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_recorded_history));
            a.this.s.setVisibility(0);
            a.this.v.setVisibility(8);
            a.this.b(false);
            a.this.p.clear();
            a.this.Y.d(true);
        }
    }

    /* compiled from: CloudDvrHistoryFragment.java */
    /* loaded from: classes.dex */
    public class h implements l {

        /* compiled from: CloudDvrHistoryFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.g.a.i.a$h$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class ViewOnClickListenerC0259a implements View.OnClickListener {
            ViewOnClickListenerC0259a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = a.this;
                aVar.Q = aVar.R;
                a.this.Q.a();
            }
        }

        public h() {
        }

        @Override // com.zte.iptvclient.android.mobile.g.a.i.a.l
        public void a() {
            a aVar = a.this;
            aVar.u.setText(aVar.J);
            a.this.u.setVisibility(0);
            a.this.u.setOnClickListener(new ViewOnClickListenerC0259a());
            a.this.Z.setVisibility(8);
            a.this.t.setVisibility(8);
            a.this.s.setVisibility(0);
            a.this.v.setVisibility(8);
            a.this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_recorded_history));
            a.this.b(false);
            a.this.p.clear();
            a aVar2 = a.this;
            aVar2.t.setText(aVar2.F);
            a.this.A.setClickable(true);
            a.this.A.setFocusable(true);
            a.this.A.setEnabled(true);
            a.this.Y.d(true);
        }
    }

    /* compiled from: CloudDvrHistoryFragment.java */
    /* loaded from: classes.dex */
    public class i implements l {
        public i() {
        }

        @Override // com.zte.iptvclient.android.mobile.g.a.i.a.l
        public void a() {
            a.this.u.setVisibility(4);
            a.this.A.setClickable(false);
            a.this.A.setFocusable(false);
            a.this.A.setEnabled(false);
            a.this.Z.setVisibility(4);
            a.this.t.setVisibility(8);
            a.this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_recorded_history));
            a.this.s.setVisibility(0);
            a.this.v.setVisibility(8);
            a.this.b(false);
            a.this.p.clear();
            a.this.Y.d(true);
        }
    }

    /* compiled from: CloudDvrHistoryFragment.java */
    /* loaded from: classes.dex */
    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogEx.d(a.e0, "Select All");
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            if (a.this.p.size() < a.this.B.size()) {
                a.this.M();
                return;
            }
            a.this.N();
            ArrayList<Integer> arrayList = a.this.p;
            if (arrayList != null) {
                arrayList.clear();
            }
        }
    }

    /* compiled from: CloudDvrHistoryFragment.java */
    /* loaded from: classes.dex */
    class k implements AdapterView.OnItemSelectedListener {
        k() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            LogEx.d(a.e0, "mSortSpinner");
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            a.this.X = i;
            if (a.this.W) {
                a.this.W = false;
            } else {
                a aVar = a.this;
                aVar.f(aVar.X);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: CloudDvrHistoryFragment.java */
    /* loaded from: classes.dex */
    public interface l {
        void a();
    }

    private void J() {
        if (this.B.size() > 0) {
            h hVar = this.S;
            this.Q = hVar;
            hVar.a();
        } else {
            g gVar = this.T;
            this.Q = gVar;
            gVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        ArrayList<Integer> arrayList = this.p;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        String F = this.d0.F();
        Iterator<Integer> it2 = this.p.iterator();
        while (it2.hasNext()) {
            Integer next = it2.next();
            LogEx.d(e0, "delete position = " + next);
            RecordFileListBean.DataBean dataBean = this.B.get(next.intValue());
            stringBuffer.append(dataBean.getScheduleid() + CapablityEnum.SPLIT_CODE);
            this.q.add(dataBean.getScheduleid());
            F = dataBean.getProfilecode();
        }
        LogEx.d(e0, "delete scheduleIDandRecs = " + ((Object) stringBuffer));
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2.length() > 1) {
            stringBuffer2 = stringBuffer2.substring(0, stringBuffer.length() - 1);
        }
        LogEx.d(e0, "delete scheduleIDandRecs = " + ((Object) stringBuffer));
        this.V.a("3", stringBuffer2, F);
    }

    private void L() {
        new Thread(new e()).start();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2) {
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

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void h(String str) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void o(String str) {
        LogEx.d(e0, "showQueryUserVolumeFailed errorMsg = " + str);
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
        this.C = new com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.a(this.h, false, this.B, this.p);
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
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_recorded_history));
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.fragment_recording_shedules_header_rl));
        Button button = (Button) inflate.findViewById(R.id.fragment_recording_schedules_btn_back);
        this.s = button;
        com.zte.iptvclient.common.uiframe.f.a(button);
        this.s.setOnClickListener(new ViewOnClickListenerC0256a());
        TextView textView3 = (TextView) inflate.findViewById(R.id.fragment_recording_schedules_selectall_txt);
        this.t = textView3;
        com.zte.iptvclient.common.uiframe.f.a(textView3);
        this.t.setOnClickListener(new j());
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
        this.v.setOnClickListener(new b());
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
        this.A.setOnItemSelectedListener(new k());
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
        this.U = new i();
        this.S = new h();
        this.R = new f();
        this.T = new g();
        i iVar = this.U;
        this.Q = iVar;
        iVar.a();
        f(0);
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
        if (i2 == 0) {
            g(1);
        } else if (i2 == 1) {
            g(0);
        } else {
            if (i2 != 2) {
                return;
            }
            g(2);
        }
    }

    private void g(int i2) {
        this.V.a("3", "1", "500", i2 + "", this.b0, "0", null, this.d0.F());
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
            g gVar = this.T;
            this.Q = gVar;
            gVar.a();
        } else {
            O();
        }
        this.V.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        RecordFileListBean.DataBean dataBean = this.B.get(i2);
        this.q.add(dataBean.getScheduleid());
        this.V.a("3", dataBean.getScheduleid(), this.d0.F());
    }

    /* compiled from: CloudDvrHistoryFragment.java */
    /* loaded from: classes.dex */
    class d implements a.g {
        d() {
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.a.g
        public void a(int i) {
            LogEx.d(a.e0, "onItemDelete");
            a.this.p.clear();
            a.this.p.add(Integer.valueOf(i));
            a.this.d(i);
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.a.g
        public void b(int i) {
            LogEx.d(a.e0, "onItemClick");
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.a.g
        public void c(int i) {
            a.this.e(i);
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.a.g
        public void a(int i, boolean z) {
            LogEx.d(a.e0, "onItemSelect");
            a.this.a(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.a aVar = this.C;
        if (aVar == null || aVar.e() == z) {
            return;
        }
        this.C.b(z);
        this.C.a(0, this.B.size());
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
        this.B.addAll(recordFileListBean.getData());
        this.C.a(0, this.B.size());
        L();
        J();
        this.Y.a();
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(RecordFileDetailBean recordFileDetailBean) {
        for (int i2 = 0; i2 < this.B.size(); i2++) {
            RecordFileListBean.DataBean dataBean = this.B.get(i2);
            if (dataBean.getScheduleid().equals(recordFileDetailBean.getScheduleid())) {
                dataBean.setChannelcode(recordFileDetailBean.getChannelcode());
                dataBean.setMediaservice(recordFileDetailBean.getMediaservice());
                dataBean.setPrevuecode(recordFileDetailBean.getPrevuecode());
                dataBean.setStarttimeutc(recordFileDetailBean.getStarttimeutc());
                dataBean.setEndtimeutc(recordFileDetailBean.getEndtimeutc());
                this.C.c(i2);
            }
        }
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
