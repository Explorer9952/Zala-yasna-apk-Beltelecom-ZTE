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
import com.zte.iptvclient.android.common.k.u;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.DeleteSchduleResultBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.RecordFileDetailBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.RecordFileListBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.ScheduleBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.ScheduleListBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.ScheduleResultBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.UserVolumeBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.LeftSlideDeleteRecyclerview;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.c;
import com.zte.iptvclient.android.zala.R;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: CloudDvrSchedulesFragment.java */
/* loaded from: classes.dex */
public class c extends com.zte.fragmentlib.b implements com.zte.iptvclient.android.mobile.g.a.c {
    private static final String c0 = c.class.getName();
    com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.c B;
    int C;
    int D;
    private String E;
    private String F;
    private String G;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;
    private String O;
    private l P;
    private f Q;
    private h R;
    private g S;
    private i T;
    private com.zte.iptvclient.android.mobile.g.a.h.a U;
    private SmartRefreshLayout X;
    private RelativeLayout Y;
    private TextView Z;
    private String a0;
    com.zte.iptvclient.android.common.j.h b0;
    TextView q;
    Button r;
    TextView s;
    TextView t;
    ConstraintLayout u;
    ImageView v;
    TextView w;
    TextView x;
    LeftSlideDeleteRecyclerview y;
    Spinner z;
    ArrayList<Integer> p = new ArrayList<>();
    ArrayList<ScheduleBean> A = new ArrayList<>();
    private boolean V = true;
    private int W = 0;

    /* compiled from: CloudDvrSchedulesFragment.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.D();
        }
    }

    /* compiled from: CloudDvrSchedulesFragment.java */
    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogEx.d(c.c0, "Delete");
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            c.this.K();
        }
    }

    /* compiled from: CloudDvrSchedulesFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.g.a.i.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0261c implements com.scwang.smartrefresh.layout.d.c {
        C0261c() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            c cVar = c.this;
            cVar.f(cVar.W);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudDvrSchedulesFragment.java */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            ArrayList<ScheduleBean> arrayList;
            ArrayList<Channel> b2 = com.zte.iptvclient.android.common.j.i.d().b();
            if (b2 == null || (arrayList = c.this.A) == null) {
                z = false;
            } else {
                Iterator<ScheduleBean> it2 = arrayList.iterator();
                z = false;
                while (it2.hasNext()) {
                    ScheduleBean next = it2.next();
                    Iterator<Channel> it3 = b2.iterator();
                    while (it3.hasNext()) {
                        Channel next2 = it3.next();
                        if (next2.getChannelcode().endsWith(next.getChannelid())) {
                            next.setIconurl(next2.getPosterimage());
                            z = true;
                        }
                    }
                }
            }
            if (z) {
                c cVar = c.this;
                cVar.B.a(0, cVar.A.size(), MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
            }
        }
    }

    /* compiled from: CloudDvrSchedulesFragment.java */
    /* loaded from: classes.dex */
    public class f implements l {

        /* compiled from: CloudDvrSchedulesFragment.java */
        /* loaded from: classes.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = c.this;
                cVar.P = cVar.R;
                c.this.P.a();
            }
        }

        public f() {
        }

        @Override // com.zte.iptvclient.android.mobile.g.a.i.c.l
        public void a() {
            c cVar = c.this;
            cVar.t.setText(cVar.J);
            c.this.t.setVisibility(0);
            c.this.t.setOnClickListener(new a());
            c.this.s.setVisibility(0);
            c.this.r.setVisibility(8);
            c.this.u.setVisibility(0);
            c.this.Y.setVisibility(8);
            c.this.b(true);
            c.this.p.clear();
            c cVar2 = c.this;
            cVar2.s.setText(cVar2.E);
            c.this.z.setClickable(false);
            c.this.z.setFocusable(false);
            c.this.z.setEnabled(false);
            c.this.X.d(false);
            c.this.O();
        }
    }

    /* compiled from: CloudDvrSchedulesFragment.java */
    /* loaded from: classes.dex */
    public class g implements l {
        public g() {
        }

        @Override // com.zte.iptvclient.android.mobile.g.a.i.c.l
        public void a() {
            c.this.t.setVisibility(4);
            c.this.z.setClickable(false);
            c.this.z.setFocusable(false);
            c.this.z.setEnabled(false);
            c.this.Y.setVisibility(0);
            c.this.s.setVisibility(8);
            c.this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_recording_schedules));
            c.this.r.setVisibility(0);
            c.this.u.setVisibility(8);
            c.this.b(false);
            c.this.p.clear();
            c.this.X.d(true);
        }
    }

    /* compiled from: CloudDvrSchedulesFragment.java */
    /* loaded from: classes.dex */
    public class h implements l {

        /* compiled from: CloudDvrSchedulesFragment.java */
        /* loaded from: classes.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = c.this;
                cVar.P = cVar.Q;
                c.this.P.a();
            }
        }

        public h() {
        }

        @Override // com.zte.iptvclient.android.mobile.g.a.i.c.l
        public void a() {
            c cVar = c.this;
            cVar.t.setText(cVar.G);
            c.this.t.setVisibility(0);
            c.this.t.setOnClickListener(new a());
            c.this.Y.setVisibility(8);
            c.this.s.setVisibility(8);
            c.this.r.setVisibility(0);
            c.this.u.setVisibility(8);
            c.this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_recording_schedules));
            c.this.b(false);
            c.this.p.clear();
            c cVar2 = c.this;
            cVar2.s.setText(cVar2.E);
            c.this.z.setClickable(true);
            c.this.z.setFocusable(true);
            c.this.z.setEnabled(true);
            c.this.X.d(true);
        }
    }

    /* compiled from: CloudDvrSchedulesFragment.java */
    /* loaded from: classes.dex */
    public class i implements l {
        public i() {
        }

        @Override // com.zte.iptvclient.android.mobile.g.a.i.c.l
        public void a() {
            c.this.t.setVisibility(4);
            c.this.z.setClickable(false);
            c.this.z.setFocusable(false);
            c.this.z.setEnabled(false);
            c.this.Y.setVisibility(4);
            c.this.s.setVisibility(8);
            c.this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_recording_schedules));
            c.this.r.setVisibility(0);
            c.this.u.setVisibility(8);
            c.this.b(false);
            c.this.p.clear();
            c.this.X.d(true);
        }
    }

    /* compiled from: CloudDvrSchedulesFragment.java */
    /* loaded from: classes.dex */
    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogEx.d(c.c0, "Select All");
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            if (c.this.p.size() < c.this.A.size()) {
                c.this.M();
                return;
            }
            c.this.N();
            ArrayList<Integer> arrayList = c.this.p;
            if (arrayList != null) {
                arrayList.clear();
            }
        }
    }

    /* compiled from: CloudDvrSchedulesFragment.java */
    /* loaded from: classes.dex */
    class k implements AdapterView.OnItemSelectedListener {
        k() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            LogEx.d(c.c0, "mSortSpinner");
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            c.this.W = i;
            if (c.this.V) {
                c.this.V = false;
            } else {
                c cVar = c.this;
                cVar.f(cVar.W);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: CloudDvrSchedulesFragment.java */
    /* loaded from: classes.dex */
    public interface l {
        void a();
    }

    private void J() {
        if (this.A.size() > 0) {
            h hVar = this.R;
            this.P = hVar;
            hVar.a();
        } else {
            g gVar = this.S;
            this.P = gVar;
            gVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        ArrayList<Integer> arrayList = this.p;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        String F = this.b0.F();
        Iterator<Integer> it2 = this.p.iterator();
        String str = F;
        while (it2.hasNext()) {
            Integer next = it2.next();
            LogEx.d(c0, "delete position = " + next);
            str = this.A.get(next.intValue()).getProfilecode();
            String scheduleid = this.A.get(next.intValue()).getScheduleid();
            String starttimeutc = this.A.get(next.intValue()).getStarttimeutc();
            sb.append(scheduleid);
            sb.append(",");
            sb2.append("2,");
            sb3.append("1,");
            sb4.append(starttimeutc);
            sb4.append(",");
        }
        LogEx.d(c0, "delete ids = " + ((Object) sb) + " types = " + ((Object) sb3));
        if (sb.length() > 1) {
            StringBuilder sb5 = new StringBuilder(sb.substring(0, sb.length() - 1));
            StringBuilder sb6 = new StringBuilder(sb2.substring(0, sb2.length() - 1));
            StringBuilder sb7 = new StringBuilder(sb3.substring(0, sb3.length() - 1));
            sb4 = new StringBuilder(sb4.substring(0, sb4.length() - 1));
            sb3 = sb7;
            sb2 = sb6;
            sb = sb5;
        }
        LogEx.d(c0, "delete ids = " + ((Object) sb) + " seriesrecs = " + ((Object) sb2) + " begintimes = " + ((Object) sb4) + " types = " + ((Object) sb3));
        this.U.a(sb.toString(), sb2.toString(), sb4.toString(), sb3.toString(), str);
    }

    private void L() {
        new Thread(new e()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        int size = this.A.size();
        this.p.clear();
        for (int i2 = 0; i2 < size; i2++) {
            this.p.add(Integer.valueOf(i2));
        }
        this.B.a(0, size, MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
        this.s.setText(this.F);
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        int size = this.A.size();
        this.p.clear();
        this.B.a(0, size, MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
        this.s.setText(this.E);
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        int size = this.p.size();
        this.q.setText(String.format(size > 1 ? this.N : this.O, Integer.valueOf(size)));
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
    public void a(RecordFileDetailBean recordFileDetailBean) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(RecordFileListBean recordFileListBean) {
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
    public void g(String str) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void h(String str) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void j(String str) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void m(String str) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void n(String str) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void o(String str) {
        LogEx.d(c0, "showQueryUserVolumeFailed errorMsg = " + str);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.y.a(this.B);
        this.B.a(new d());
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b0 = new com.zte.iptvclient.android.common.j.h(this.h);
        EventBus.getDefault().register(this);
        com.zte.iptvclient.android.common.i.a.a.a(R.string.login_set_language);
        this.E = com.zte.iptvclient.android.common.i.a.a.a(R.string.bottom_btn_selectall);
        this.F = com.zte.iptvclient.android.common.i.a.a.a(R.string.bottom_btn_cancelselect);
        this.G = com.zte.iptvclient.android.common.i.a.a.a(R.string.common_edit);
        this.J = com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel);
        this.K = com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_sort_by_time);
        this.L = com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_sort_by_title);
        this.M = com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_sort_by_channel);
        this.N = com.zte.iptvclient.android.common.i.a.a.a(R.string.bookmark_select_nums);
        this.O = com.zte.iptvclient.android.common.i.a.a.a(R.string.bookmark_select_num);
        this.a0 = com.zte.iptvclient.android.common.i.a.a.a(R.string.record_memory);
        this.U = new com.zte.iptvclient.android.mobile.g.a.h.a(this, com.zte.iptvclient.android.mobile.g.a.g.a.b());
        this.C = androidx.core.content.a.a(this.h, R.color.recording_sort_text_select);
        this.D = androidx.core.content.a.a(this.h, R.color.recording_sort_text_unselect);
        if (getArguments() == null) {
            return;
        }
        this.B = new com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.c(this.h, false, this.A, this.p);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_clouddvr_schedules_layout, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.fragment_recording_shedules_top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        TextView textView2 = (TextView) inflate.findViewById(R.id.fragment_recording_schedules_title_txt);
        this.q = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_recording_schedules));
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.fragment_recording_shedules_header_rl));
        Button button = (Button) inflate.findViewById(R.id.fragment_recording_schedules_btn_back);
        this.r = button;
        com.zte.iptvclient.common.uiframe.f.a(button);
        this.r.setOnClickListener(new a());
        TextView textView3 = (TextView) inflate.findViewById(R.id.fragment_recording_schedules_selectall_txt);
        this.s = textView3;
        com.zte.iptvclient.common.uiframe.f.a(textView3);
        this.s.setOnClickListener(new j());
        TextView textView4 = (TextView) inflate.findViewById(R.id.fragment_recording_schedules_edit_txt);
        this.t = textView4;
        com.zte.iptvclient.common.uiframe.f.a(textView4);
        this.u = (ConstraintLayout) inflate.findViewById(R.id.fragment_recording_schedules_bottom_delete_cl);
        this.v = (ImageView) inflate.findViewById(R.id.delete_img);
        TextView textView5 = (TextView) inflate.findViewById(R.id.delete_txt);
        this.w = textView5;
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.delete));
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        this.u.setOnClickListener(new b());
        TextView textView6 = (TextView) inflate.findViewById(R.id.fragment_recording_schedules_bottom_uservolume_txt);
        this.x = textView6;
        com.zte.iptvclient.common.uiframe.f.a(textView6);
        LeftSlideDeleteRecyclerview leftSlideDeleteRecyclerview = (LeftSlideDeleteRecyclerview) inflate.findViewById(R.id.fragment_recording_schedules_recyclerview);
        this.y = leftSlideDeleteRecyclerview;
        com.zte.iptvclient.common.uiframe.f.a(leftSlideDeleteRecyclerview);
        this.y.a(new LinearLayoutManager(this.h, 1, false));
        this.z = (Spinner) inflate.findViewById(R.id.fragment_recording_schedules_sort_spinner);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.K);
        arrayList.add(this.L);
        arrayList.add(this.M);
        this.z.setAdapter((SpinnerAdapter) new com.zte.iptvclient.android.mobile.npvr.view.c(this.h, this.z, arrayList, this.C, this.D));
        this.z.setOnItemSelectedListener(new k());
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) inflate.findViewById(R.id.fragment_clouddvr_recording_refreshlayout);
        this.X = smartRefreshLayout;
        com.zte.iptvclient.common.uiframe.f.a(smartRefreshLayout);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rl_empty);
        this.Y = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout);
        this.Y.setVisibility(8);
        TextView textView7 = (TextView) inflate.findViewById(R.id.txt_pullrefresh);
        this.Z = textView7;
        com.zte.iptvclient.common.uiframe.f.a(textView7);
        this.Z.setText(this.h.getString(R.string.recording_no_recording_data));
        this.X.a(new DefaultRefreshHeader(this.h));
        this.X.a(new DefaultRefreshFooter(this.h));
        this.X.d(true);
        this.X.b(false);
        this.X.c(false);
        SmartRefreshLayout smartRefreshLayout2 = this.X;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout2.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout3 = this.X;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout3.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.X.a(new C0261c());
        this.T = new i();
        this.R = new h();
        this.Q = new f();
        this.S = new g();
        i iVar = this.T;
        this.P = iVar;
        iVar.a();
        f(0);
        this.U.a();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.k.e eVar) {
        LogEx.d(c0, "需要更改录制计划:" + eVar.d() + " Recmode = " + eVar.a() + " Rectimeafter = " + eVar.b() + " Rectimebefore = " + eVar.c());
        String d2 = eVar.d();
        Iterator<ScheduleBean> it2 = this.A.iterator();
        while (it2.hasNext()) {
            ScheduleBean next = it2.next();
            if (next.getScheduleid().equals(d2)) {
                LogEx.d(c0, "找到录制计划，scheduleid = " + d2);
                next.setRecmode(eVar.a());
                next.setRectimeafter(eVar.b());
                next.setRectimebefore(eVar.c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2) {
        ScheduleBean scheduleBean = this.A.get(i2);
        if (scheduleBean != null) {
            u.a(this.h, scheduleBean.getName(), "", scheduleBean.getScheduleid(), scheduleBean.getPrevueid(), scheduleBean.getSeriesrec(), scheduleBean.getChannelmode(), scheduleBean.getRecordtype(), scheduleBean.getRectimebefore(), scheduleBean.getRectimeafter(), scheduleBean.getRecmode(), scheduleBean.getKeepatmost(), scheduleBean.getEpisodetype());
            return;
        }
        LogEx.d(c0, "ScheduleBean = null, position = " + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i2) {
        if (i2 == 0) {
            g(0);
        } else if (i2 == 1) {
            g(1);
        } else {
            if (i2 != 2) {
                return;
            }
            g(2);
        }
    }

    private void g(int i2) {
        this.U.c("1", "500", i2 + "", null, this.b0.F());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        this.U.a(this.A.get(i2).getScheduleid(), "2", this.A.get(i2).getStarttime(), "1", this.A.get(i2).getProfilecode());
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void c(String str) {
        LogEx.d(c0, "query schedule list failed, errormsg = " + str);
        J();
        this.X.a();
    }

    /* compiled from: CloudDvrSchedulesFragment.java */
    /* loaded from: classes.dex */
    class d implements c.g {
        d() {
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.c.g
        public void a(int i) {
            LogEx.d(c.c0, "onItemDelete");
            c.this.p.clear();
            c.this.p.add(Integer.valueOf(i));
            c.this.d(i);
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.c.g
        public void b(int i) {
            LogEx.d(c.c0, "onItemClick");
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.c.g
        public void c(int i) {
            c.this.e(i);
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.c.g
        public void a(int i, boolean z) {
            LogEx.d(c.c0, "onItemSelect");
            c.this.a(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.c cVar = this.B;
        if (cVar == null || cVar.e() == z) {
            return;
        }
        this.B.b(z);
        this.B.a(0, this.A.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, boolean z) {
        if (z) {
            LogEx.d(c0, "isSelected == true: position = " + i2);
            Iterator<Integer> it2 = this.p.iterator();
            while (it2.hasNext()) {
                if (it2.next().intValue() == i2) {
                    return;
                }
            }
            this.p.add(Integer.valueOf(i2));
            if (this.p.size() == this.A.size()) {
                this.s.setText(this.F);
            }
            Collections.sort(this.p);
            O();
            return;
        }
        LogEx.d(c0, "isSelected == false: position = " + i2);
        Iterator<Integer> it3 = this.p.iterator();
        while (it3.hasNext()) {
            Integer next = it3.next();
            if (next.intValue() == i2) {
                this.p.remove(next);
                this.s.setText(this.E);
                O();
                return;
            }
        }
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void e(String str) {
        LogEx.d(c0, "showDeleteScheduleFailed errorMsg = " + str);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(ScheduleListBean scheduleListBean) {
        this.A.clear();
        this.A.addAll(scheduleListBean.getData());
        this.B.a(0, this.A.size());
        L();
        J();
        this.X.a();
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(DeleteSchduleResultBean deleteSchduleResultBean) {
        if (this.p.size() > 0) {
            this.s.setText(this.E);
        }
        String[] split = deleteSchduleResultBean.getScheduleid().split(",");
        int i2 = 0;
        while (i2 < this.A.size()) {
            ScheduleBean scheduleBean = this.A.get(i2);
            int length = split.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (split[i3].equals(scheduleBean.getScheduleid())) {
                    this.A.remove(i2);
                    i2--;
                    break;
                }
                i3++;
            }
            i2++;
        }
        this.B.d();
        this.p.clear();
        if (this.A.size() <= 0) {
            g gVar = this.S;
            this.P = gVar;
            gVar.a();
        } else {
            O();
        }
        this.U.a();
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.k());
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(UserVolumeBean userVolumeBean) {
        LogEx.d(c0, "showQueryUserVolumeSuccess");
        double usedvolume = userVolumeBean.getUsedvolume();
        double availablevolume = userVolumeBean.getAvailablevolume();
        double totalvolume = userVolumeBean.getTotalvolume();
        double a2 = a(usedvolume);
        double a3 = a(availablevolume);
        double a4 = (a2 / a(totalvolume)) * 100.0d;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String format = String.format(this.a0, decimalFormat.format(a2), decimalFormat.format(a3), decimalFormat.format(a4) + "%");
        LogEx.d(c0, "uservolumn = " + format);
        this.x.setText(format);
    }
}
