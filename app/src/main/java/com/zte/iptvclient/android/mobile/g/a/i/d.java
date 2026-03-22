package com.zte.iptvclient.android.mobile.g.a.i;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.k.u;
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
import com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.e;
import com.zte.iptvclient.android.zala.R;
import com.zte.sdk.enumclass.CapablityEnum;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: RecordingSchedulesFragment.java */
/* loaded from: classes.dex */
public class d extends com.zte.fragmentlib.b implements com.zte.iptvclient.android.mobile.g.a.c {
    private static final String N = d.class.getName();
    private static String O;
    private static String P;
    com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.e A;
    int C;
    int D;
    private k E;
    private i F;
    private j G;
    private com.zte.iptvclient.android.mobile.g.a.h.a J;
    private String L;
    TextView r;
    Button s;
    TextView t;
    TextView u;
    TextView v;
    TextView w;
    LeftSlideDeleteRecyclerview x;
    Spinner y;
    public int p = 0;
    ArrayList<Integer> q = new ArrayList<>();
    ArrayList<ScheduleBean> z = new ArrayList<>();
    ArrayList<RecordFileListBean.DataBean> B = new ArrayList<>();
    private boolean K = true;
    String M = "";

    /* compiled from: RecordingSchedulesFragment.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.D();
        }
    }

    /* compiled from: RecordingSchedulesFragment.java */
    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogEx.d(d.N, "Select All");
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            if (d.this.q.size() < (d.this.z.size() > 0 ? d.this.z : d.this.B).size()) {
                d.this.L();
                return;
            }
            d.this.M();
            ArrayList<Integer> arrayList = d.this.q;
            if (arrayList != null) {
                arrayList.clear();
            }
        }
    }

    /* compiled from: RecordingSchedulesFragment.java */
    /* loaded from: classes.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogEx.d(d.N, "Delete");
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            d.this.K();
        }
    }

    /* compiled from: RecordingSchedulesFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.g.a.i.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0262d extends ArrayAdapter<String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f6310a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0262d(Context context, int i, List list, ArrayList arrayList) {
            super(context, i, list);
            this.f6310a = arrayList;
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            View inflate = View.inflate(((com.zte.fragmentlib.b) d.this).h, R.layout.recording_sort_spinner_item_layout, null);
            TextView textView = (TextView) inflate.findViewById(R.id.recording_sort_spinner_item_title_txt);
            textView.setText((CharSequence) this.f6310a.get(i));
            if (d.this.y.getSelectedItemPosition() == i) {
                textView.setTextColor(d.this.C);
            } else {
                textView.setTextColor(d.this.D);
            }
            return inflate;
        }
    }

    /* compiled from: RecordingSchedulesFragment.java */
    /* loaded from: classes.dex */
    class e implements AdapterView.OnItemSelectedListener {

        /* renamed from: a, reason: collision with root package name */
        private int f6312a = 0;

        e() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            LogEx.d(d.N, "mSortSpinner");
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            this.f6312a = i;
            if (d.this.K) {
                d.this.K = false;
            } else {
                d.this.f(this.f6312a);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: RecordingSchedulesFragment.java */
    /* loaded from: classes.dex */
    class g implements k.a {

        /* compiled from: RecordingSchedulesFragment.java */
        /* loaded from: classes.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar = d.this;
                dVar.E = dVar.F;
                d.this.E.a();
            }
        }

        g() {
        }

        @Override // com.zte.iptvclient.android.mobile.g.a.i.d.k.a
        public void a() {
            d.this.u.setText("Edit");
            d.this.u.setOnClickListener(new a());
            d.this.t.setVisibility(8);
            d.this.s.setVisibility(0);
            d.this.w.setVisibility(8);
            d.this.b(false);
            d.this.q.clear();
            d.this.t.setText(d.O);
            d.this.y.setClickable(true);
            d.this.y.setFocusable(true);
            d.this.y.setEnabled(true);
        }
    }

    /* compiled from: RecordingSchedulesFragment.java */
    /* loaded from: classes.dex */
    class h implements k.a {

        /* compiled from: RecordingSchedulesFragment.java */
        /* loaded from: classes.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar = d.this;
                dVar.E = dVar.G;
                d.this.E.a();
            }
        }

        h() {
        }

        @Override // com.zte.iptvclient.android.mobile.g.a.i.d.k.a
        public void a() {
            d.this.u.setText("Cancel");
            d.this.u.setOnClickListener(new a());
            d.this.t.setVisibility(0);
            d.this.s.setVisibility(8);
            d.this.w.setVisibility(0);
            d.this.b(true);
            d.this.q.clear();
            d.this.t.setText(d.O);
            d.this.y.setClickable(false);
            d.this.y.setFocusable(false);
            d.this.y.setEnabled(false);
        }
    }

    /* compiled from: RecordingSchedulesFragment.java */
    /* loaded from: classes.dex */
    public static class i implements k {

        /* renamed from: a, reason: collision with root package name */
        k.a f6319a;

        public void a(k.a aVar) {
            this.f6319a = aVar;
        }

        @Override // com.zte.iptvclient.android.mobile.g.a.i.d.k
        public void a() {
            k.a aVar = this.f6319a;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    /* compiled from: RecordingSchedulesFragment.java */
    /* loaded from: classes.dex */
    public static class j implements k {

        /* renamed from: a, reason: collision with root package name */
        k.a f6320a;

        public void a(k.a aVar) {
            this.f6320a = aVar;
        }

        @Override // com.zte.iptvclient.android.mobile.g.a.i.d.k
        public void a() {
            k.a aVar = this.f6320a;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    /* compiled from: RecordingSchedulesFragment.java */
    /* loaded from: classes.dex */
    public interface k {

        /* compiled from: RecordingSchedulesFragment.java */
        /* loaded from: classes.dex */
        public interface a {
            void a();
        }

        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        ArrayList<Integer> arrayList;
        int i2 = this.p;
        if (i2 != 0) {
            if ((i2 == 1 || i2 == 2) && (arrayList = this.q) != null && arrayList.size() > 0) {
                StringBuffer stringBuffer = new StringBuffer();
                Iterator<Integer> it2 = this.q.iterator();
                while (it2.hasNext()) {
                    Integer next = it2.next();
                    LogEx.d(N, "delete position = " + next);
                    RecordFileListBean.DataBean dataBean = this.B.get(next.intValue());
                    stringBuffer.append(dataBean.getScheduleid() + "-" + dataBean.getSeriesrec() + CapablityEnum.SPLIT_CODE);
                }
                LogEx.d(N, "delete scheduleIDandRecs = ");
                String substring = stringBuffer.length() > 1 ? stringBuffer.substring(0, stringBuffer.length() - 1) : "";
                LogEx.d(N, "delete scheduleIDandRecs = " + substring);
                this.J.a("0", substring, this.M);
                return;
            }
            return;
        }
        ArrayList<Integer> arrayList2 = this.q;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = new StringBuffer();
        Iterator<Integer> it3 = this.q.iterator();
        while (it3.hasNext()) {
            Integer next2 = it3.next();
            LogEx.d(N, "delete position = " + next2);
            stringBuffer2.append(this.z.get(next2.intValue()).getScheduleid() + ",");
            stringBuffer3.append("2,");
            stringBuffer4.append(this.z.get(next2.intValue()).getStarttime() + ",");
        }
        LogEx.d(N, "delete ids = " + ((Object) stringBuffer2) + " types = " + ((Object) stringBuffer3));
        if (stringBuffer2.length() > 1) {
            this.J.a(stringBuffer2.substring(0, stringBuffer2.length() - 1), stringBuffer3.substring(0, stringBuffer3.length() - 1), stringBuffer4.substring(0, stringBuffer4.length() - 1), "1", this.M);
            LogEx.d(N, "delete ids = " + ((Object) stringBuffer2) + " types = " + ((Object) stringBuffer3) + " begintimes = " + ((Object) stringBuffer4));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        int size = (this.z.size() > 0 ? this.z : this.B).size();
        int i2 = this.p;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            this.q.clear();
            for (int i3 = 0; i3 < size; i3++) {
                this.q.add(Integer.valueOf(i3));
            }
            this.A.a(0, size, MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
            this.t.setText(P);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        int size = (this.z.size() > 0 ? this.z : this.B).size();
        int i2 = this.p;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            this.q.clear();
            this.A.a(0, size, MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
            this.t.setText(O);
        }
    }

    private static double a(double d2) {
        return (d2 / 1024.0d) / 1024.0d;
    }

    private void i(int i2) {
        this.J.c("1", "100", i2 + "", null, this.M);
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
        LogEx.d(N, "showDeleteRecordFileFailed errorMsg = " + str);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void m(String str) {
        LogEx.d(N, "query RecordFile list failed, errormsg = " + str);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void n(String str) {
        if (this.q.size() > 0) {
            this.t.setText(O);
        }
        for (int size = this.q.size() - 1; size >= 0; size--) {
            int intValue = this.q.get(size).intValue();
            this.B.remove(intValue);
            this.A.d(intValue);
            this.q.remove(size);
        }
        this.A.a(0, this.z.size());
        this.J.a();
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void o(String str) {
        LogEx.d(N, "showQueryUserVolumeFailed errorMsg = " + str);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.x.a(this.A);
        this.A.a(new f());
        this.J.a();
        j jVar = new j();
        this.G = jVar;
        jVar.a(new g());
        i iVar = new i();
        this.F = iVar;
        iVar.a(new h());
        j jVar2 = this.G;
        this.E = jVar2;
        jVar2.a();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        this.L = com.zte.iptvclient.android.common.i.a.a.a(R.string.record_memory);
        O = com.zte.iptvclient.android.common.i.a.a.a(R.string.bottom_btn_selectall);
        P = com.zte.iptvclient.android.common.i.a.a.a(R.string.bottom_btn_cancelselect);
        this.J = new com.zte.iptvclient.android.mobile.g.a.h.a(this, new com.zte.iptvclient.android.mobile.g.a.g.a());
        this.C = androidx.core.content.a.a(this.h, R.color.recording_sort_text_select);
        this.D = androidx.core.content.a.a(this.h, R.color.recording_sort_text_unselect);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.p = arguments.getInt("type");
        com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.e eVar = new com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.e(this.h, false, this.z, this.B, this.q);
        this.A = eVar;
        int i2 = this.p;
        if (i2 == 0) {
            eVar.e(1);
        } else if (i2 == 1) {
            eVar.e(2);
        } else if (i2 == 2) {
            eVar.e(3);
        }
        f(0);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_recording_schedules_layout, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.fragment_recording_schedules_title_txt);
        this.r = textView;
        textView.setText("Recording Schedules");
        int i2 = this.p;
        if (i2 == 0) {
            this.r.setText("Recording Schedules");
        } else if (i2 == 1) {
            this.r.setText("Recorded Mananger");
        } else if (i2 == 2) {
            this.r.setText("Recorded History");
        }
        Button button = (Button) inflate.findViewById(R.id.fragment_recording_schedules_btn_back);
        this.s = button;
        button.setOnClickListener(new a());
        TextView textView2 = (TextView) inflate.findViewById(R.id.fragment_recording_schedules_selectall_txt);
        this.t = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.bottom_btn_selectall));
        this.t.setOnClickListener(new b());
        TextView textView3 = (TextView) inflate.findViewById(R.id.fragment_recording_schedules_edit_txt);
        this.u = textView3;
        textView3.setText("Edit");
        this.v = (TextView) inflate.findViewById(R.id.fragment_recording_schedules_bottom_uservolume_txt);
        TextView textView4 = (TextView) inflate.findViewById(R.id.fragment_recording_schedules_bottom_delete_txt);
        this.w = textView4;
        textView4.setText("Delete");
        this.w.setOnClickListener(new c());
        LeftSlideDeleteRecyclerview leftSlideDeleteRecyclerview = (LeftSlideDeleteRecyclerview) inflate.findViewById(R.id.fragment_recording_schedules_recyclerview);
        this.x = leftSlideDeleteRecyclerview;
        leftSlideDeleteRecyclerview.a(new LinearLayoutManager(this.h, 1, false));
        this.y = (Spinner) inflate.findViewById(R.id.fragment_recording_schedules_sort_spinner);
        ArrayList arrayList = new ArrayList();
        arrayList.add("By Time");
        arrayList.add("By Title");
        arrayList.add("By Channel");
        C0262d c0262d = new C0262d(this.h, R.layout.recording_sort_spinner_checked_text, arrayList, arrayList);
        c0262d.setDropDownViewResource(R.layout.recording_sort_spinner_item_layout);
        this.y.setAdapter((SpinnerAdapter) c0262d);
        this.y.setOnItemSelectedListener(new e());
        return inflate;
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.k.e eVar) {
        LogEx.d(N, "需要更改录制计划:" + eVar.d() + " Recmode = " + eVar.a() + " Rectimeafter = " + eVar.b() + " Rectimebefore = " + eVar.c());
        String d2 = eVar.d();
        Iterator<ScheduleBean> it2 = this.z.iterator();
        while (it2.hasNext()) {
            ScheduleBean next = it2.next();
            if (next.getScheduleid().equals(d2)) {
                LogEx.d(N, "找到录制计划，scheduleid = " + d2);
                next.setRecmode(eVar.a());
                next.setRectimeafter(eVar.b());
                next.setRectimebefore(eVar.c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        int i3 = this.p;
        if (i3 == 0) {
            this.J.a(this.z.get(i2).getScheduleid(), "2", "", null, this.M);
        } else if (i3 == 1 || i3 == 2) {
            RecordFileListBean.DataBean dataBean = this.B.get(i2);
            this.J.a("0", dataBean.getScheduleid() + "-" + dataBean.getSeriesrec(), this.M);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2) {
        int i3 = this.p;
        if (i3 == 0) {
            ScheduleBean scheduleBean = this.z.get(i2);
            if (scheduleBean != null) {
                u.a(this.h, scheduleBean.getName(), "", scheduleBean.getScheduleid(), scheduleBean.getPrevueid(), scheduleBean.getSeriesrec(), scheduleBean.getChannelmode(), scheduleBean.getRecordtype(), scheduleBean.getRectimebefore(), scheduleBean.getRectimeafter(), scheduleBean.getRecmode(), scheduleBean.getKeepatmost(), scheduleBean.getEpisodetype());
                return;
            }
            LogEx.d(N, "ScheduleBean = null, position = " + i2);
            return;
        }
        if (i3 != 1) {
            return;
        }
        RecordFileListBean.DataBean dataBean = this.B.get(i2);
        if (dataBean != null) {
            u.a(this.h, dataBean.getSchedulename(), dataBean.getScheduleid(), dataBean.getSeriesrec(), dataBean.getRecmode(), dataBean.getRectimeafter(), dataBean.getProfilecode());
            return;
        }
        LogEx.d(N, "Record File Bean = null, position = " + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i2) {
        if (i2 == 0) {
            int i3 = this.p;
            if (i3 == 0) {
                i(0);
                return;
            } else if (i3 == 1) {
                h(1);
                return;
            } else {
                if (i3 != 2) {
                    return;
                }
                g(1);
                return;
            }
        }
        if (i2 == 1) {
            int i4 = this.p;
            if (i4 == 0) {
                i(1);
                return;
            } else if (i4 == 1) {
                h(0);
                return;
            } else {
                if (i4 != 2) {
                    return;
                }
                g(0);
                return;
            }
        }
        if (i2 != 2) {
            return;
        }
        int i5 = this.p;
        if (i5 == 0) {
            i(2);
        } else if (i5 == 1) {
            h(2);
        } else {
            if (i5 != 2) {
                return;
            }
            g(2);
        }
    }

    private void g(int i2) {
        this.J.a("3", "1", "100", i2 + "", "eng", null, null, this.M);
    }

    private void h(int i2) {
        this.J.a("1", "1", "100", i2 + "", "eng", null, null, this.M);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void c(String str) {
        LogEx.d(N, "query schedule list failed, errormsg = " + str);
    }

    /* compiled from: RecordingSchedulesFragment.java */
    /* loaded from: classes.dex */
    class f implements e.j {
        f() {
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.e.j
        public void a(int i) {
            LogEx.d(d.N, "onItemDelete");
            d.this.q.clear();
            d.this.q.add(Integer.valueOf(i));
            d.this.d(i);
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.e.j
        public void c(int i) {
            LogEx.d(d.N, "onItemEdit");
            d.this.e(i);
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.e.j
        public void a(int i, boolean z) {
            LogEx.d(d.N, "onItemSelect");
            d.this.a(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.e eVar = this.A;
        if (eVar == null || eVar.e() == z) {
            return;
        }
        this.A.b(z);
        int i2 = this.p;
        if (i2 == 0) {
            this.A.a(0, this.z.size());
        } else if (i2 == 1) {
            this.A.a(0, this.B.size());
        } else {
            if (i2 != 2) {
                return;
            }
            this.A.a(0, this.B.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, boolean z) {
        if (z) {
            LogEx.d(N, "isSelected == true: position = " + i2);
            Iterator<Integer> it2 = this.q.iterator();
            while (it2.hasNext()) {
                if (it2.next().intValue() == i2) {
                    return;
                }
            }
            this.q.add(Integer.valueOf(i2));
            if (this.q.size() == this.z.size() || this.q.size() == this.B.size()) {
                this.t.setText(P);
            }
            Collections.sort(this.q);
            return;
        }
        LogEx.d(N, "isSelected == false: position = " + i2);
        Iterator<Integer> it3 = this.q.iterator();
        while (it3.hasNext()) {
            Integer next = it3.next();
            if (next.intValue() == i2) {
                this.q.remove(next);
                this.t.setText(O);
                return;
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.k.a aVar) {
        LogEx.d(N, "更改录制文件:" + aVar.d() + " Recmode = " + aVar.a() + " Rectimeafter = " + aVar.b() + " Rectimebefore = " + aVar.c());
        String d2 = aVar.d();
        Iterator<RecordFileListBean.DataBean> it2 = this.B.iterator();
        while (it2.hasNext()) {
            RecordFileListBean.DataBean next = it2.next();
            if (next.getScheduleid().equals(d2)) {
                next.setRecmode(aVar.a());
            }
        }
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void e(String str) {
        LogEx.d(N, "showDeleteScheduleFailed errorMsg = " + str);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(ScheduleListBean scheduleListBean) {
        this.z.clear();
        this.z.addAll(scheduleListBean.getData());
        this.A.a(0, this.z.size());
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(DeleteSchduleResultBean deleteSchduleResultBean) {
        if (this.q.size() > 0) {
            this.t.setText(O);
        }
        for (int size = this.q.size() - 1; size >= 0; size--) {
            int intValue = this.q.get(size).intValue();
            this.z.remove(intValue);
            this.q.remove(size);
            this.A.d(intValue);
        }
        this.A.a(0, this.z.size());
        this.J.a();
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(RecordFileListBean recordFileListBean) {
        this.B.clear();
        this.B.addAll(recordFileListBean.getData());
        this.A.a(0, this.B.size());
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(UserVolumeBean userVolumeBean) {
        LogEx.d(N, "showQueryUserVolumeSuccess");
        double usedvolume = userVolumeBean.getUsedvolume();
        double availablevolume = userVolumeBean.getAvailablevolume();
        double totalvolume = userVolumeBean.getTotalvolume();
        double a2 = a(usedvolume);
        double a3 = a(availablevolume);
        int a4 = (int) ((a2 / a(totalvolume)) * 100.0d);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String format = String.format(this.L, decimalFormat.format(a2), decimalFormat.format(a3), a4 + "%");
        LogEx.d(N, "uservolumn = " + format);
        this.v.setText(format);
    }
}
