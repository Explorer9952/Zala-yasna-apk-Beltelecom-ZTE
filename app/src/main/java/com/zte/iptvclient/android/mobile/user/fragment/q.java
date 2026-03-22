package com.zte.iptvclient.android.mobile.user.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.zte.iptvclient.android.common.customview.viewpager.SlideViewPager;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;

/* compiled from: TerminalBindingFragmentNew.java */
/* loaded from: classes2.dex */
public class q extends com.zte.fragmentlib.b implements View.OnClickListener {
    private ArrayList<Fragment> A;
    private p B;
    private r C;
    private RelativeLayout q;
    private Button r;
    private TextView s;
    private RelativeLayout t;
    private RelativeLayout u;
    private TextView v;
    private TextView w;
    private ImageView x;
    private SlideViewPager y;
    private FrameLayout z;
    private String p = "TerminalBindingNew";
    private long D = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TerminalBindingFragmentNew.java */
    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            q.this.u.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            q.this.x.setScaleX((q.this.u.getWidth() * 1.0f) / q.this.x.getWidth());
            q.this.x.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TerminalBindingFragmentNew.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (System.currentTimeMillis() - q.this.D >= 200) {
                q.this.y.d(0);
                q.this.v.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_selected));
                ((com.zte.fragmentlib.b) q.this).h.a(q.this.v, "textColor", R.color.download_tag_title_selected);
                q.this.w.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_normal));
                ((com.zte.fragmentlib.b) q.this).h.a(q.this.w, "textColor", R.color.download_tag_title_normal);
                q.this.D = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TerminalBindingFragmentNew.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (System.currentTimeMillis() - q.this.D >= 200) {
                q.this.y.d(1);
                q.this.w.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_selected));
                ((com.zte.fragmentlib.b) q.this).h.a(q.this.w, "textColor", R.color.download_tag_title_selected);
                q.this.v.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_normal));
                ((com.zte.fragmentlib.b) q.this).h.a(q.this.v, "textColor", R.color.download_tag_title_normal);
                q.this.D = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TerminalBindingFragmentNew.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q.this.getActivity() instanceof MainActivity) {
                Log.d(q.this.p, "back button onclick MainActivity");
                q.this.F();
            } else if (q.this.getActivity() instanceof HostActivity) {
                Log.d(q.this.p, "back button onclick HostActivity");
                q.this.getActivity().finish();
            }
        }
    }

    /* compiled from: TerminalBindingFragmentNew.java */
    /* loaded from: classes2.dex */
    public static class e extends androidx.fragment.app.n {
        ArrayList<Fragment> h;

        public e(FragmentManager fragmentManager, ArrayList<Fragment> arrayList) {
            super(fragmentManager);
            this.h = arrayList;
        }

        @Override // androidx.viewpager.widget.a
        public int a() {
            return this.h.size();
        }

        @Override // androidx.fragment.app.n
        public Fragment c(int i) {
            return this.h.get(i);
        }

        @Override // androidx.fragment.app.n, androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i, Object obj) {
            super.a(viewGroup, i, obj);
        }

        @Override // androidx.fragment.app.n, androidx.viewpager.widget.a
        public Object a(ViewGroup viewGroup, int i) {
            return super.a(viewGroup, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TerminalBindingFragmentNew.java */
    /* loaded from: classes2.dex */
    public class f implements ViewPager.i {
        private f() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i, float f, int i2) {
            float width = (q.this.u.getWidth() * i * (1.0f - f)) + (q.this.u.getWidth() * (i + 1) * f);
            q.this.x.setTranslationX(width);
            q.this.x.setScaleX((q.this.u.getWidth() * 1.0f) / q.this.x.getWidth());
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void b(int i) {
            if (i == 0) {
                q.this.v.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_selected));
                ((com.zte.fragmentlib.b) q.this).h.a(q.this.v, "textColor", R.color.download_tag_title_selected);
                q.this.w.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_normal));
                ((com.zte.fragmentlib.b) q.this).h.a(q.this.w, "textColor", R.color.download_tag_title_normal);
                return;
            }
            q.this.w.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_selected));
            ((com.zte.fragmentlib.b) q.this).h.a(q.this.w, "textColor", R.color.download_tag_title_selected);
            q.this.v.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_normal));
            ((com.zte.fragmentlib.b) q.this).h.a(q.this.v, "textColor", R.color.download_tag_title_normal);
        }

        /* synthetic */ f(q qVar, a aVar) {
            this();
        }
    }

    private void I() {
        this.t.setOnClickListener(new b());
        this.u.setOnClickListener(new c());
        this.r.setOnClickListener(new d());
    }

    private void J() {
        this.A = new ArrayList<>();
        this.B = new p();
        r rVar = new r();
        this.C = rVar;
        rVar.p = 3;
        this.A.add(rVar);
        this.A.add(this.B);
        this.B.a(this.C);
    }

    private void K() {
        this.u.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        this.y.a(new e(getChildFragmentManager(), this.A));
        this.y.d(0);
        this.v.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_selected));
        this.h.a(this.v, "textColor", R.color.download_tag_title_selected);
        this.w.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_normal));
        this.h.a(this.w, "textColor", R.color.download_tag_title_normal);
        this.y.a(new f(this, null));
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        K();
        I();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        J();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.terminal_binding_ott_new, (ViewGroup) null);
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
        this.q = (RelativeLayout) view.findViewById(R.id.title_rlayout);
        this.r = (Button) view.findViewById(R.id.btn_back);
        TextView textView2 = (TextView) view.findViewById(R.id.title_txt);
        this.s = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.terminal_binding));
        this.t = (RelativeLayout) view.findViewById(R.id.rl_mobile_fav);
        TextView textView3 = (TextView) view.findViewById(R.id.tag_title01);
        this.v = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.termial_binding_package));
        this.u = (RelativeLayout) view.findViewById(R.id.rl_stb_fav);
        TextView textView4 = (TextView) view.findViewById(R.id.tag_title02);
        this.w = textView4;
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.termial_binding_bound_terminal));
        this.x = (ImageView) view.findViewById(R.id.cursor);
        this.y = (SlideViewPager) view.findViewById(R.id.viewpager);
        this.z = (FrameLayout) view.findViewById(R.id.fl_delete);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.favorite_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_delete));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_delete));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_delete));
        ((TextView) view.findViewById(R.id.txt_delete)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.delete));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_bottom_line));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_tag));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.line_1));
    }
}
