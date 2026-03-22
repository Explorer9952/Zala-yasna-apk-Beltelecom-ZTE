package com.zte.iptvclient.android.mobile.g.a.i.g;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.d;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;

/* compiled from: SetScheduleStartFragment.java */
/* loaded from: classes.dex */
public class c extends com.zte.fragmentlib.b {
    Button q;
    RecyclerView r;
    com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.d s;
    TextView u;
    String p = "0";
    ArrayList<d.b> t = new ArrayList<>();

    /* compiled from: SetScheduleStartFragment.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.getActivity().finish();
        }
    }

    /* compiled from: SetScheduleStartFragment.java */
    /* loaded from: classes.dex */
    class b implements d.InterfaceC0206d {
        b() {
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.d.InterfaceC0206d
        public void b(int i) {
            com.zte.iptvclient.android.common.e.k.c cVar = new com.zte.iptvclient.android.common.e.k.c();
            cVar.a(c.this.t.get(i).b() + "");
            EventBus.getDefault().post(cVar);
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.t.add(new d.b(300, "5 " + com.zte.iptvclient.android.common.i.a.a.a(R.string.min_early)));
        this.t.add(new d.b(180, "3 " + com.zte.iptvclient.android.common.i.a.a.a(R.string.min_early)));
        this.t.add(new d.b(60, "1 " + com.zte.iptvclient.android.common.i.a.a.a(R.string.min_early)));
        this.t.add(new d.b(0, com.zte.iptvclient.android.common.i.a.a.a(R.string.on_time)));
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.p = arguments.getString("timebefore");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = 0;
        View inflate = layoutInflater.inflate(R.layout.fragment_set_schedule_start_layout, viewGroup, false);
        Button button = (Button) inflate.findViewById(R.id.fragment_recording_modify_start_btn_back);
        this.q = button;
        button.setOnClickListener(new a());
        this.r = (RecyclerView) inflate.findViewById(R.id.fragment_recording_modify_start_chocie_rv);
        com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.d dVar = new com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.d(this.h, this.t);
        this.s = dVar;
        dVar.a(new b());
        this.r.a(this.s);
        this.r.a(new LinearLayoutManager(this.h, 1, false));
        while (true) {
            if (i >= this.t.size()) {
                break;
            }
            if (this.t.get(i).b() == Integer.parseInt(this.p)) {
                this.s.e(i);
                break;
            }
            i++;
        }
        TextView textView = (TextView) inflate.findViewById(R.id.fragment_recording_modify_start_title_txt);
        this.u = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_start));
        f.a(inflate.findViewById(R.id.title_header_rl));
        return inflate;
    }
}
