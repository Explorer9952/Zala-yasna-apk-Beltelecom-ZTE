package com.zte.iptvclient.android.mobile.g.a.i.g;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.k.u;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.DeleteSchduleResultBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.RecordFileDetailBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.RecordFileListBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.ScheduleListBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.ScheduleResultBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.UserVolumeBean;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: SetSchedulesFragment.java */
/* loaded from: classes.dex */
public class e extends com.zte.fragmentlib.b implements com.zte.iptvclient.android.mobile.g.a.c {
    private static final String X = e.class.getName();
    String A;
    String B;
    String C;
    String D;
    String E;
    String F;
    String G;
    String J;
    String K;
    String L;
    String M;
    String N;
    String O;
    h P;
    private com.zte.iptvclient.android.mobile.g.a.h.a Q;
    TextView R;
    TextView S;
    TextView T;
    TextView U;
    TextView V;
    TextView W;
    public int p = 0;
    Button q;
    TextView r;
    TextView s;
    TextView t;
    RelativeLayout u;
    TextView v;
    RelativeLayout w;
    TextView x;
    RelativeLayout y;
    TextView z;

    /* compiled from: SetSchedulesFragment.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.getActivity().finish();
        }
    }

    /* compiled from: SetSchedulesFragment.java */
    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            e.this.L();
        }
    }

    /* compiled from: SetSchedulesFragment.java */
    /* loaded from: classes.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            u.c(((com.zte.fragmentlib.b) e.this).h, e.this.J);
        }
    }

    /* compiled from: SetSchedulesFragment.java */
    /* loaded from: classes.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            u.d(((com.zte.fragmentlib.b) e.this).h, e.this.K);
        }
    }

    /* compiled from: SetSchedulesFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.g.a.i.g.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ViewOnClickListenerC0266e implements View.OnClickListener {
        ViewOnClickListenerC0266e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            u.b(((com.zte.fragmentlib.b) e.this).h, e.this.L);
        }
    }

    private void I() {
        if (TextUtils.isEmpty(this.L)) {
            this.L = "1";
        }
        int parseInt = Integer.parseInt(this.L);
        String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.until_i_delete);
        if (parseInt == 0) {
            a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.memory_is_full);
        } else if (parseInt == 1) {
            a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.until_i_delete);
        }
        this.z.setText(a2);
    }

    private void J() {
        if (TextUtils.isEmpty(this.J)) {
            this.J = "0";
        }
        int parseInt = Integer.parseInt(this.J);
        String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.on_time);
        if (parseInt == -300) {
            a2 = "5 " + com.zte.iptvclient.android.common.i.a.a.a(R.string.min_later);
        } else if (parseInt == -180) {
            a2 = "3 " + com.zte.iptvclient.android.common.i.a.a.a(R.string.min_later);
        } else if (parseInt == -60) {
            a2 = "1 " + com.zte.iptvclient.android.common.i.a.a.a(R.string.min_later);
        } else if (parseInt == 0) {
            a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.on_time);
        } else if (parseInt == 60) {
            a2 = "1 " + com.zte.iptvclient.android.common.i.a.a.a(R.string.min_early);
        } else if (parseInt == 180) {
            a2 = "3 " + com.zte.iptvclient.android.common.i.a.a.a(R.string.min_early);
        } else if (parseInt != 300) {
            this.J = "0";
        } else {
            a2 = "5 " + com.zte.iptvclient.android.common.i.a.a.a(R.string.min_early);
        }
        TextView textView = this.v;
        if (textView != null) {
            textView.setText(a2);
        }
    }

    private void K() {
        if (TextUtils.isEmpty(this.K)) {
            this.K = "0";
        }
        int parseInt = Integer.parseInt(this.K);
        String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.on_time);
        if (parseInt == -300) {
            a2 = "5 " + com.zte.iptvclient.android.common.i.a.a.a(R.string.min_early);
        } else if (parseInt == -180) {
            a2 = "3 " + com.zte.iptvclient.android.common.i.a.a.a(R.string.min_early);
        } else if (parseInt == -60) {
            a2 = "1 " + com.zte.iptvclient.android.common.i.a.a.a(R.string.min_early);
        } else if (parseInt == 0) {
            a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.on_time);
        } else if (parseInt == 60) {
            a2 = "1 " + com.zte.iptvclient.android.common.i.a.a.a(R.string.min_later);
        } else if (parseInt == 180) {
            a2 = "3 " + com.zte.iptvclient.android.common.i.a.a.a(R.string.min_later);
        } else if (parseInt != 300) {
            this.K = "0";
        } else {
            a2 = "5 " + com.zte.iptvclient.android.common.i.a.a.a(R.string.min_later);
        }
        TextView textView = this.x;
        if (textView != null) {
            textView.setText(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        int i = this.p;
        if (i == 0) {
            LogEx.d(X, "modify schedule");
            this.Q.a(this.B, this.C, this.D, this.E, this.F, this.G, this.J, this.K, this.L, this.M, this.N, this.O, null, null, null);
        } else {
            if (i != 1) {
                return;
            }
            LogEx.d(X, "modify record file");
            this.Q.b(this.C, this.E, this.L, this.K, this.O);
        }
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(DeleteSchduleResultBean deleteSchduleResultBean) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(RecordFileDetailBean recordFileDetailBean) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(RecordFileListBean recordFileListBean) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(ScheduleListBean scheduleListBean) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(UserVolumeBean userVolumeBean) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void c(String str) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void e(String str) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void g(String str) {
        LogEx.d(X, "showModifyRecordFileFailed, errorMsg = " + str);
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
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h hVar = new h(this.h);
        this.P = hVar;
        this.O = hVar.F();
        LogEx.d(X, "profile code = " + this.O);
        this.Q = new com.zte.iptvclient.android.mobile.g.a.h.a(this, com.zte.iptvclient.android.mobile.g.a.g.a.b());
        EventBus.getDefault().register(this);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.p = arguments.getInt("type");
        this.A = arguments.getString("name");
        this.B = arguments.getString("mac");
        this.C = arguments.getString("scheduleid");
        this.D = arguments.getString("prevueid");
        this.E = arguments.getString("seriesrec");
        this.F = arguments.getString("channelmode");
        this.G = arguments.getString("recordtype");
        this.J = arguments.getString("rectimebefore");
        this.K = arguments.getString("rectimeafter");
        this.L = arguments.getString("recmode");
        this.M = arguments.getString("keepatmost");
        this.N = arguments.getString("episodetype");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_set_schedules_layout, viewGroup, false);
        Button button = (Button) inflate.findViewById(R.id.fragment_setschedules_btn_back);
        this.q = button;
        button.setOnClickListener(new a());
        this.r = (TextView) inflate.findViewById(R.id.fragment_setschedules_title_txt);
        f.a(inflate.findViewById(R.id.title_header_rl));
        TextView textView = (TextView) inflate.findViewById(R.id.fragment_setschedules_confirm_txt);
        this.s = textView;
        textView.setOnClickListener(new b());
        TextView textView2 = (TextView) inflate.findViewById(R.id.fragment_setschedules_schedule_title_txt);
        this.t = textView2;
        textView2.setText(this.A);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.fragment_setschedules_start_rl);
        this.u = relativeLayout;
        relativeLayout.setOnClickListener(new c());
        this.v = (TextView) inflate.findViewById(R.id.fragment_setschedules_start_current_txt);
        RelativeLayout relativeLayout2 = (RelativeLayout) inflate.findViewById(R.id.fragment_setschedules_stop_rl);
        this.w = relativeLayout2;
        relativeLayout2.setOnClickListener(new d());
        TextView textView3 = (TextView) inflate.findViewById(R.id.fragment_setschedules_stop_current_txt);
        this.x = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.on_time));
        RelativeLayout relativeLayout3 = (RelativeLayout) inflate.findViewById(R.id.fragment_setschedules_keepuntil_rl);
        this.y = relativeLayout3;
        relativeLayout3.setOnClickListener(new ViewOnClickListenerC0266e());
        TextView textView4 = (TextView) inflate.findViewById(R.id.fragment_setschedules_keepuntil_current_txt);
        this.z = textView4;
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.until_i_delete));
        TextView textView5 = (TextView) inflate.findViewById(R.id.fragment_setschedules_title_txt);
        this.R = textView5;
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.set_schedules));
        TextView textView6 = (TextView) inflate.findViewById(R.id.fragment_setschedules_confirm_txt);
        this.S = textView6;
        textView6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_ok));
        TextView textView7 = (TextView) inflate.findViewById(R.id.fragment_setschedules_start_txt);
        this.T = textView7;
        textView7.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_start));
        TextView textView8 = (TextView) inflate.findViewById(R.id.fragment_setschedules_start_current_txt);
        this.U = textView8;
        textView8.setText("1 " + com.zte.iptvclient.android.common.i.a.a.a(R.string.min_early));
        TextView textView9 = (TextView) inflate.findViewById(R.id.fragment_setschedules_stop_txt);
        this.V = textView9;
        textView9.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_stop));
        TextView textView10 = (TextView) inflate.findViewById(R.id.fragment_setschedules_keepuntil_txt);
        this.W = textView10;
        textView10.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_keep_until));
        J();
        K();
        I();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.k.c cVar) {
        this.J = cVar.a();
        J();
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(ScheduleResultBean scheduleResultBean) {
        LogEx.d(X, "showModifyScheduleSuccess");
        String str = this.C;
        com.zte.iptvclient.android.common.e.k.e eVar = new com.zte.iptvclient.android.common.e.k.e();
        eVar.d(str);
        eVar.a(this.L);
        eVar.b(this.K);
        eVar.c(this.J);
        EventBus.getDefault().post(eVar);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void b(String str) {
        String str2 = this.C;
        com.zte.iptvclient.android.common.e.k.a aVar = new com.zte.iptvclient.android.common.e.k.a();
        aVar.d(str2);
        aVar.a(this.L);
        aVar.b(this.K);
        aVar.c(this.J);
        EventBus.getDefault().post(aVar);
        LogEx.d(X, "showModifyRecordFileSuccess");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.k.d dVar) {
        this.K = dVar.a();
        K();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.k.b bVar) {
        this.L = bVar.a();
        I();
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(String str) {
        LogEx.d(X, "showModifyScheduleFailed, errorMsg = " + str);
    }
}
