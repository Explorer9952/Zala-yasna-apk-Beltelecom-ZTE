package com.zte.iptvclient.android.mobile.g.a.i;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.u;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: RecordingsFragment.java */
/* loaded from: classes.dex */
public class e extends com.zte.fragmentlib.b {
    TextView p;
    Button q;
    RelativeLayout r;
    TextView s;
    ImageView t;
    RelativeLayout u;
    TextView v;
    ImageView w;
    RelativeLayout x;
    TextView y;
    ImageView z;

    /* compiled from: RecordingsFragment.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!BaseApp.a(((com.zte.fragmentlib.b) e.this).h)) {
                u.f(((com.zte.fragmentlib.b) e.this).h);
                return;
            }
            com.zte.iptvclient.android.mobile.g.a.i.d dVar = new com.zte.iptvclient.android.mobile.g.a.i.d();
            Bundle bundle = new Bundle();
            bundle.putInt("type", 0);
            dVar.setArguments(bundle);
            e.this.a(dVar);
        }
    }

    /* compiled from: RecordingsFragment.java */
    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!BaseApp.a(((com.zte.fragmentlib.b) e.this).h)) {
                u.e(((com.zte.fragmentlib.b) e.this).h);
                return;
            }
            com.zte.iptvclient.android.mobile.g.a.i.d dVar = new com.zte.iptvclient.android.mobile.g.a.i.d();
            Bundle bundle = new Bundle();
            bundle.putInt("type", 1);
            dVar.setArguments(bundle);
            e.this.a(dVar);
        }
    }

    /* compiled from: RecordingsFragment.java */
    /* loaded from: classes.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!BaseApp.a(((com.zte.fragmentlib.b) e.this).h)) {
                u.d(((com.zte.fragmentlib.b) e.this).h);
                return;
            }
            com.zte.iptvclient.android.mobile.g.a.i.d dVar = new com.zte.iptvclient.android.mobile.g.a.i.d();
            Bundle bundle = new Bundle();
            bundle.putInt("type", 2);
            dVar.setArguments(bundle);
            e.this.a(dVar);
        }
    }

    /* compiled from: RecordingsFragment.java */
    /* loaded from: classes.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.getActivity() instanceof MainActivity) {
                e.this.F();
            } else if (e.this.getActivity() instanceof HostActivity) {
                e.this.getActivity().finish();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_recordings_layout, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.r = (RelativeLayout) inflate.findViewById(R.id.fragment_recordings_shedules_rl);
        TextView textView2 = (TextView) inflate.findViewById(R.id.fragment_recordings_shedules_txt);
        this.s = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_recording_schedules));
        this.t = (ImageView) inflate.findViewById(R.id.fragment_recordings_shedules_arrow_img);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.fragment_recordings_header_bottom_line);
        f.a(this.r);
        f.a(this.s);
        f.a(this.t);
        f.a(imageView);
        if (BaseApp.a(this.h)) {
            g.a(imageView, this.h);
        }
        this.r.setOnClickListener(new a());
        this.u = (RelativeLayout) inflate.findViewById(R.id.fragment_recordings_manager_rl);
        TextView textView3 = (TextView) inflate.findViewById(R.id.fragment_recordings_manager_txt);
        this.v = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_recording_manager));
        this.w = (ImageView) inflate.findViewById(R.id.fragment_recordings_manager_arrow_img);
        f.a(this.u);
        f.a(this.v);
        f.a(this.w);
        this.u.setOnClickListener(new b());
        this.x = (RelativeLayout) inflate.findViewById(R.id.fragment_recordings_history_rl);
        TextView textView4 = (TextView) inflate.findViewById(R.id.fragment_recordings_history_txt);
        this.y = textView4;
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_recorded_history));
        this.z = (ImageView) inflate.findViewById(R.id.fragment_recordings_history_arrow_img);
        f.a(this.x);
        f.a(this.y);
        f.a(this.z);
        this.x.setOnClickListener(new c());
        TextView textView5 = (TextView) inflate.findViewById(R.id.fragment_recordings_title_txt);
        this.p = textView5;
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_my_recording));
        this.q = (Button) inflate.findViewById(R.id.fragment_recordings_btn_back);
        f.a(this.p);
        f.a(this.q);
        f.a(inflate.findViewById(R.id.rl_layout));
        this.q.setOnClickListener(new d());
        return inflate;
    }
}
