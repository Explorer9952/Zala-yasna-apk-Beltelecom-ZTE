package com.zte.iptvclient.android.mobile.g.a.i.g;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.DeleteSchduleResultBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.RecordFileDetailBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.RecordFileListBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.ScheduleListBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.ScheduleResultBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.UserVolumeBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.d;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;

/* compiled from: SetKeepUntilFragment.java */
/* loaded from: classes.dex */
public class a extends com.zte.fragmentlib.b implements com.zte.iptvclient.android.mobile.g.a.c {
    private static final String A = a.class.getName();
    String p;
    String q;
    String r;
    String t;
    Button u;
    RecyclerView v;
    com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.d w;
    TextView y;
    com.zte.iptvclient.android.mobile.g.a.h.a z;
    String s = "1";
    ArrayList<d.b> x = new ArrayList<>();

    /* compiled from: SetKeepUntilFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.g.a.i.g.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ViewOnClickListenerC0264a implements View.OnClickListener {
        ViewOnClickListenerC0264a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.getActivity().finish();
        }
    }

    /* compiled from: SetKeepUntilFragment.java */
    /* loaded from: classes.dex */
    class b implements d.InterfaceC0206d {
        b() {
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.d.InterfaceC0206d
        public void b(int i) {
            a.this.s = a.this.x.get(i).b() + "";
            LogEx.d(a.A, "modify record file");
            a aVar = a.this;
            aVar.z.b(aVar.p, aVar.q, aVar.s, aVar.r, aVar.t);
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
    public void a(ScheduleResultBean scheduleResultBean) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(UserVolumeBean userVolumeBean) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(String str) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void b(String str) {
        String str2 = this.p;
        com.zte.iptvclient.android.common.e.k.a aVar = new com.zte.iptvclient.android.common.e.k.a();
        aVar.d(str2);
        aVar.a(this.s);
        aVar.b(this.r);
        EventBus.getDefault().post(aVar);
        LogEx.d(A, "showModifyRecordFileSuccess");
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
        this.z = new com.zte.iptvclient.android.mobile.g.a.h.a(this, com.zte.iptvclient.android.mobile.g.a.g.a.b());
        new h(this.h);
        this.x.add(new d.b(1, com.zte.iptvclient.android.common.i.a.a.a(R.string.until_i_delete)));
        this.x.add(new d.b(0, com.zte.iptvclient.android.common.i.a.a.a(R.string.memory_is_full)));
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.p = arguments.getString("scheduleid");
        this.q = arguments.getString("seriesrec");
        this.r = arguments.getString("rectimeafter", "0");
        this.s = arguments.getString("recmode");
        this.t = arguments.getString("profilecode");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = 0;
        View inflate = layoutInflater.inflate(R.layout.fragment_set_schedule_keep_until_layout, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.fragment_recording_modify_keepuntil_title_txt);
        this.y = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_keep_until));
        f.a(inflate.findViewById(R.id.title_header_rl));
        Button button = (Button) inflate.findViewById(R.id.fragment_recording_modify_keepuntil_btn_back);
        this.u = button;
        button.setOnClickListener(new ViewOnClickListenerC0264a());
        this.v = (RecyclerView) inflate.findViewById(R.id.fragment_recording_modify_keepuntil_chocie_rv);
        com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.d dVar = new com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.d(this.h, this.x);
        this.w = dVar;
        dVar.a(new b());
        this.v.a(this.w);
        this.v.a(new LinearLayoutManager(this.h, 1, false));
        while (true) {
            if (i >= this.x.size()) {
                break;
            }
            if (this.x.get(i).b() == Integer.parseInt(this.s)) {
                this.w.e(i);
                break;
            }
            i++;
        }
        return inflate;
    }
}
