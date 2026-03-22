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

/* compiled from: SetScheduleStopFragment.java */
/* loaded from: classes.dex */
public class d extends com.zte.fragmentlib.b {
    Button p;
    RecyclerView q;
    com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.d r;
    ArrayList<d.b> s = new ArrayList<>();
    String t = "0";
    TextView u;

    /* compiled from: SetScheduleStopFragment.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.getActivity().finish();
        }
    }

    /* compiled from: SetScheduleStopFragment.java */
    /* loaded from: classes.dex */
    class b implements d.InterfaceC0206d {
        b() {
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.d.InterfaceC0206d
        public void b(int i) {
            com.zte.iptvclient.android.common.e.k.d dVar = new com.zte.iptvclient.android.common.e.k.d();
            dVar.a(d.this.s.get(i).b() + "");
            EventBus.getDefault().post(dVar);
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s.add(new d.b(300, "5 " + com.zte.iptvclient.android.common.i.a.a.a(R.string.min_later)));
        this.s.add(new d.b(180, "3 " + com.zte.iptvclient.android.common.i.a.a.a(R.string.min_later)));
        this.s.add(new d.b(60, "1 " + com.zte.iptvclient.android.common.i.a.a.a(R.string.min_later)));
        this.s.add(new d.b(0, com.zte.iptvclient.android.common.i.a.a.a(R.string.on_time)));
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.t = arguments.getString("timeafter");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = 0;
        View inflate = layoutInflater.inflate(R.layout.fragment_set_schedule_stop_layout, viewGroup, false);
        Button button = (Button) inflate.findViewById(R.id.fragment_recording_modify_stop_btn_back);
        this.p = button;
        button.setOnClickListener(new a());
        this.q = (RecyclerView) inflate.findViewById(R.id.fragment_recording_modify_stop_chocie_rv);
        com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.d dVar = new com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.d(this.h, this.s);
        this.r = dVar;
        dVar.a(new b());
        this.q.a(this.r);
        this.q.a(new LinearLayoutManager(this.h, 1, false));
        while (true) {
            if (i >= this.s.size()) {
                break;
            }
            if (this.s.get(i).b() == Integer.parseInt(this.t)) {
                this.r.e(i);
                break;
            }
            i++;
        }
        TextView textView = (TextView) inflate.findViewById(R.id.fragment_recording_modify_stop_title_txt);
        this.u = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_stop));
        f.a(inflate.findViewById(R.id.title_header_rl));
        return inflate;
    }
}
