package com.zte.iptvclient.android.mobile.k.b;

import android.content.Context;
import android.os.Bundle;
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
import androidx.fragment.app.n;
import androidx.viewpager.widget.ViewPager;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.customview.viewpager.SlideViewPager;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.home.tab.helper.TabHostManager;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;

/* compiled from: HistoryFragment.java */
/* loaded from: classes.dex */
public class e extends com.zte.fragmentlib.b {
    private TextView A;
    private TextView B;
    private RelativeLayout C;
    private RelativeLayout D;
    private RelativeLayout E;
    private FrameLayout F;
    private RelativeLayout G;
    private RelativeLayout J;
    private long K = 0;
    private boolean L = false;
    private boolean M = false;
    private int N = 0;
    private ArrayList<Fragment> p;
    private com.zte.iptvclient.android.mobile.k.b.g q;
    private com.zte.iptvclient.android.mobile.k.b.f r;
    private Button s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private ImageView y;
    private SlideViewPager z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HistoryFragment.java */
    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            e.this.J.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            e.this.y.setScaleX((e.this.J.getWidth() * 1.0f) / e.this.y.getWidth());
            e.this.y.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HistoryFragment.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HistoryFragment.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HistoryFragment.java */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.P();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HistoryFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.k.b.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0293e implements View.OnClickListener {
        ViewOnClickListenerC0293e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.N == 0) {
                e.this.q.b(!e.this.M);
            } else {
                e.this.r.b(!e.this.M);
            }
            e.this.T();
            e.this.Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HistoryFragment.java */
    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HistoryFragment.java */
    /* loaded from: classes.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (System.currentTimeMillis() - e.this.K >= 200) {
                e.this.z.d(0);
                e.this.A.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_selected));
                e.this.B.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_normal));
                if (((com.zte.fragmentlib.b) e.this).h != null) {
                    ((com.zte.fragmentlib.b) e.this).h.a(e.this.A, "textColor", R.color.download_tag_title_selected);
                    ((com.zte.fragmentlib.b) e.this).h.a(e.this.B, "textColor", R.color.download_tag_title_normal);
                }
                e.this.K = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HistoryFragment.java */
    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (System.currentTimeMillis() - e.this.K >= 200) {
                e.this.z.d(1);
                e.this.B.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_selected));
                e.this.A.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_normal));
                if (((com.zte.fragmentlib.b) e.this).h != null) {
                    ((com.zte.fragmentlib.b) e.this).h.a(e.this.B, "textColor", R.color.download_tag_title_selected);
                    ((com.zte.fragmentlib.b) e.this).h.a(e.this.A, "textColor", R.color.download_tag_title_normal);
                }
                e.this.K = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HistoryFragment.java */
    /* loaded from: classes.dex */
    public class i implements t.e {
        i() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void a() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void b() {
            e.this.I();
        }
    }

    /* compiled from: HistoryFragment.java */
    /* loaded from: classes.dex */
    public static class j extends n {
        ArrayList<Fragment> h;

        public j(FragmentManager fragmentManager, ArrayList<Fragment> arrayList) {
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
        public Object a(ViewGroup viewGroup, int i) {
            return super.a(viewGroup, i);
        }

        @Override // androidx.fragment.app.n, androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i, Object obj) {
            super.a(viewGroup, i, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HistoryFragment.java */
    /* loaded from: classes.dex */
    public class k implements ViewPager.i {
        private k() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i, float f, int i2) {
            float width = (e.this.J.getWidth() * i * (1.0f - f)) + (e.this.J.getWidth() * (i + 1) * f);
            e.this.y.setTranslationX(width);
            e.this.y.setScaleX((e.this.J.getWidth() * 1.0f) / e.this.y.getWidth());
            e.this.S();
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void b(int i) {
            e.this.L();
            e.this.N = i;
            e.this.T();
            e.this.Q();
            if (i == 0) {
                e.this.A.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_selected));
                e.this.B.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_normal));
                if (((com.zte.fragmentlib.b) e.this).h != null) {
                    ((com.zte.fragmentlib.b) e.this).h.a(e.this.A, "textColor", R.color.download_tag_title_selected);
                    ((com.zte.fragmentlib.b) e.this).h.a(e.this.B, "textColor", R.color.download_tag_title_normal);
                    return;
                }
                return;
            }
            e.this.A.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_normal));
            e.this.B.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_selected));
            if (((com.zte.fragmentlib.b) e.this).h != null) {
                ((com.zte.fragmentlib.b) e.this).h.a(e.this.A, "textColor", R.color.download_tag_title_normal);
                ((com.zte.fragmentlib.b) e.this).h.a(e.this.B, "textColor", R.color.download_tag_title_selected);
            }
        }

        /* synthetic */ k(e eVar, a aVar) {
            this();
        }
    }

    private void V() {
        this.s.setOnClickListener(new b());
        this.u.setOnClickListener(new c());
        this.x.setOnClickListener(new d());
        this.v.setOnClickListener(new ViewOnClickListenerC0293e());
        this.F.setOnClickListener(new f());
        this.G.setOnClickListener(new g());
        this.J.setOnClickListener(new h());
    }

    private void W() {
        this.p = new ArrayList<>();
        this.q = new com.zte.iptvclient.android.mobile.k.b.g();
        this.r = new com.zte.iptvclient.android.mobile.k.b.f();
        this.p.add(this.q);
        this.p.add(this.r);
        this.q.a(this);
        this.r.a(this);
    }

    private void X() {
        this.J.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        this.z.a(new j(getChildFragmentManager(), this.p));
        this.z.d(0);
        this.A.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_selected));
        this.B.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_normal));
        SupportActivity supportActivity = this.h;
        if (supportActivity != null) {
            supportActivity.a(this.A, "textColor", R.color.download_tag_title_selected);
            this.h.a(this.B, "textColor", R.color.download_tag_title_normal);
        }
        this.z.a(new k(this, null));
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        if (!this.L) {
            return false;
        }
        N();
        this.q.b(false);
        this.r.b(false);
        return true;
    }

    void I() {
        this.q.I();
        this.r.I();
    }

    public int J() {
        if (this.N == 0) {
            return this.q.J();
        }
        return this.r.J();
    }

    boolean K() {
        return this.q.L() || this.r.N();
    }

    public void L() {
        if (this.N == 0) {
            this.u.setVisibility(this.q.L() ? 0 : 8);
        } else {
            this.u.setVisibility(this.r.N() ? 0 : 8);
        }
    }

    void M() {
        t.a(this.h, com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_delete_history), new i());
    }

    protected void N() {
        if (!this.L) {
            O();
        } else {
            P();
        }
    }

    protected void O() {
        this.L = true;
        S();
        R();
        T();
        this.q.c(this.L);
        this.r.c(this.L);
        this.q.b(false);
        this.r.b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P() {
        this.L = false;
        this.M = false;
        S();
        R();
        this.F.setVisibility(8);
        this.q.c(this.L);
        this.r.c(this.L);
        this.q.b(false);
        this.r.b(false);
        a(0, 0, 0, 0);
    }

    public void Q() {
        if (this.L) {
            this.F.setVisibility(J() == 0 ? 8 : 0);
            a(0, 0, 0, a(this.h, J() == 0 ? 10.0f : 58.0f));
        }
    }

    void R() {
        int i2 = 8;
        this.D.setVisibility((K() && this.L) ? 8 : 0);
        RelativeLayout relativeLayout = this.E;
        if (K() && this.L) {
            i2 = 0;
        }
        relativeLayout.setVisibility(i2);
        T();
        U();
    }

    public void S() {
        L();
    }

    public void T() {
        if (K()) {
            boolean K = this.N == 0 ? this.q.K() : this.r.K();
            this.M = K;
            this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(K ? R.string.favorite_select_null : R.string.favorite_select_all));
            this.v.setVisibility(0);
        } else {
            this.v.setVisibility(8);
        }
        U();
    }

    public void U() {
        this.w.setVisibility(this.L ? 0 : 8);
        StringBuffer stringBuffer = new StringBuffer(this.N == 0 ? R.string.history_vod_sel : R.string.history_tv_sel);
        stringBuffer.append(J());
        stringBuffer.append(com.zte.iptvclient.android.common.i.a.a.a(R.string.history_classifier));
        this.w.setText(stringBuffer.toString());
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        X();
        V();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        W();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_history, (ViewGroup) null);
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
        this.s = (Button) view.findViewById(R.id.btn_back);
        this.t = (TextView) view.findViewById(R.id.title_txt);
        this.u = (TextView) view.findViewById(R.id.edit_txt);
        this.v = (TextView) view.findViewById(R.id.txt_selected_all);
        this.w = (TextView) view.findViewById(R.id.txt_selected_num);
        this.x = (TextView) view.findViewById(R.id.txt_cancel);
        this.y = (ImageView) view.findViewById(R.id.cursor);
        this.z = (SlideViewPager) view.findViewById(R.id.viewpager);
        this.F = (FrameLayout) view.findViewById(R.id.fl_delete);
        this.G = (RelativeLayout) view.findViewById(R.id.rl_mobile_fav);
        this.J = (RelativeLayout) view.findViewById(R.id.rl_stb_fav);
        this.A = (TextView) view.findViewById(R.id.tag_title01);
        this.B = (TextView) view.findViewById(R.id.tag_title02);
        this.D = (RelativeLayout) view.findViewById(R.id.title_rlayout);
        this.E = (RelativeLayout) view.findViewById(R.id.edit_rlayout);
        this.C = (RelativeLayout) view.findViewById(R.id.rl_ViewPager);
        this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_bookmark));
        this.u.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.edit));
        this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
        this.x.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel));
        this.B.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_history));
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.F);
        com.zte.iptvclient.common.uiframe.f.a(this.G);
        com.zte.iptvclient.common.uiframe.f.a(this.J);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.favorite_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.edit_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_bottom_line));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_tag));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.tag_title01));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.bottom_line01));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.line_1));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.tag_title02));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.bottom_line02));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_delete));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_delete));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_delete));
        ((TextView) view.findViewById(R.id.tag_title01)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.vod_history));
        ((TextView) view.findViewById(R.id.txt_delete)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.delete));
    }

    public void s(String str) {
        this.q.G();
        this.r.G();
        F();
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.n.a(TabHostManager.TabName.TV));
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.e(str, ""));
    }

    public int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void a(int i2, int i3, int i4, int i5) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(i2, i3, i4, i5);
        this.z.setLayoutParams(layoutParams);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
    }
}
