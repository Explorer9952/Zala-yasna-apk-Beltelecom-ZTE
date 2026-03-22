package com.zte.iptvclient.android.mobile.q.c;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;

/* compiled from: MyOrderFragment.java */
/* loaded from: classes.dex */
public class a extends com.zte.fragmentlib.b {
    private com.zte.iptvclient.android.mobile.c.b.b A;
    private com.zte.iptvclient.android.mobile.q.c.b B;
    private long C = 0;
    private Button p;
    private TextView q;
    private RelativeLayout r;
    private RelativeLayout s;
    private ImageView t;
    private TextView u;
    private TextView v;
    private ImageView w;
    private ImageView x;
    private ViewPager y;
    private ArrayList<com.zte.fragmentlib.b> z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyOrderFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.q.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0336a implements com.zte.fragmentlib.helper.c {
        C0336a() {
        }

        @Override // com.zte.fragmentlib.helper.c
        public void a() {
            a.this.B.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyOrderFragment.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.getActivity() instanceof MainActivity) {
                a.this.F();
            } else if (a.this.getActivity() instanceof HostActivity) {
                a.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyOrderFragment.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (System.currentTimeMillis() - a.this.C >= 200) {
                a.this.y.d(0);
                a.this.v.setTextColor(a.this.getResources().getColor(R.color.account_text_color));
                a.this.u.setTextColor(a.this.getResources().getColor(R.color.anhui_mobile_theme));
                a.this.C = System.currentTimeMillis();
                a aVar = a.this;
                aVar.a((com.zte.fragmentlib.b) aVar.z.get(0), (com.zte.fragmentlib.b) a.this.z.get(1));
                a.this.w.setVisibility(0);
                a.this.x.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyOrderFragment.java */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (System.currentTimeMillis() - a.this.C >= 200) {
                a.this.y.d(1);
                a.this.v.setTextColor(a.this.getResources().getColor(R.color.anhui_mobile_theme));
                a.this.u.setTextColor(a.this.getResources().getColor(R.color.account_text_color));
                a.this.C = System.currentTimeMillis();
                a aVar = a.this;
                aVar.a((com.zte.fragmentlib.b) aVar.z.get(1), (com.zte.fragmentlib.b) a.this.z.get(0));
                a.this.w.setVisibility(4);
                a.this.x.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyOrderFragment.java */
    /* loaded from: classes.dex */
    public class e implements View.OnTouchListener {
        e(a aVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    private void I() {
        this.z = new ArrayList<>();
        this.A = new com.zte.iptvclient.android.mobile.c.b.b();
        this.B = new com.zte.iptvclient.android.mobile.q.c.b();
        this.z.add(this.A);
        this.z.add(this.B);
    }

    private void J() {
        a(new C0336a());
        this.p.setOnClickListener(new b());
        this.r.setOnClickListener(new c());
        this.s.setOnClickListener(new d());
        this.y.setOnTouchListener(new e(this));
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        J();
        a(R.id.rl_ViewPager, 0, this.z);
        this.w.setVisibility(0);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        I();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.my_order_layout, (ViewGroup) null);
        d(inflate);
        return inflate;
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.p = (Button) view.findViewById(R.id.btn_back);
        this.q = (TextView) view.findViewById(R.id.title_txt);
        this.r = (RelativeLayout) view.findViewById(R.id.rl_live_rec);
        this.s = (RelativeLayout) view.findViewById(R.id.rl_online_sub);
        this.t = (ImageView) view.findViewById(R.id.cursor);
        this.y = (ViewPager) view.findViewById(R.id.viewpager);
        this.u = (TextView) view.findViewById(R.id.tag_title01);
        this.v = (TextView) view.findViewById(R.id.tag_title02);
        this.w = (ImageView) view.findViewById(R.id.bottom_line01);
        this.x = (ImageView) view.findViewById(R.id.bottom_line02);
        f.a(this.p);
        f.a(this.r);
        f.a(this.s);
        f.a(this.t);
        f.a(this.y);
        f.a(this.w);
        f.a(this.x);
        f.a(view.findViewById(R.id.title_rlayout));
        f.a(this.q);
        f.a(view.findViewById(R.id.title_bottom_line));
        f.a(view.findViewById(R.id.rl_tag));
        f.a(this.u);
        f.a(this.v);
        this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.my_subscribe));
        this.u.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.reminder_live_live));
        this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.online_reservation));
    }
}
