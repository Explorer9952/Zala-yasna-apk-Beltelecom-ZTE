package com.zte.iptvclient.android.mobile.j.b;

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
import com.zte.iptvclient.android.common.customview.viewpager.SlideViewPager;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;

/* compiled from: FavoriteFragment.java */
/* loaded from: classes.dex */
public class a extends com.zte.fragmentlib.b {
    private TextView A;
    private TextView B;
    private RelativeLayout C;
    private RelativeLayout D;
    private RelativeLayout E;
    private FrameLayout F;
    private RelativeLayout G;
    private RelativeLayout J;
    private ImageView K;
    private RelativeLayout L;
    private TextView M;
    private TextView N;
    private com.zte.iptvclient.android.common.j.h R;
    private ArrayList<Fragment> p;
    private com.zte.iptvclient.android.mobile.j.b.b q;
    private com.zte.iptvclient.android.mobile.j.b.d r;
    private Button s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private ImageView y;
    private SlideViewPager z;
    private long O = 0;
    private boolean P = false;
    private boolean Q = false;
    private boolean S = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.j.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewTreeObserverOnGlobalLayoutListenerC0285a implements ViewTreeObserver.OnGlobalLayoutListener {
        ViewTreeObserverOnGlobalLayoutListenerC0285a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            a.this.J.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            a.this.y.setScaleX((a.this.J.getWidth() * 1.0f) / a.this.y.getWidth());
            a.this.y.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteFragment.java */
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
    /* compiled from: FavoriteFragment.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.q.N() || a.this.r.K()) {
                a.this.P = true;
                a.this.L();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteFragment.java */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.P = false;
            a.this.Q = false;
            a.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteFragment.java */
    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!a.this.Q && 1 == a.this.z.c()) {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.please_delete_on_stb);
                return;
            }
            a.this.Q = !r3.Q;
            if (a.this.Q) {
                a.this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_null));
                a.this.q.c(true);
                a aVar = a.this;
                aVar.d(aVar.q.J());
                return;
            }
            a.this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
            a.this.q.c(false);
            a aVar2 = a.this;
            aVar2.d(aVar2.q.J());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteFragment.java */
    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.q.J() == 0) {
                return;
            }
            a.this.q.R();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteFragment.java */
    /* loaded from: classes.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (System.currentTimeMillis() - a.this.O >= 200) {
                a.this.z.d(0);
                a.this.A.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_selected));
                ((com.zte.fragmentlib.b) a.this).h.a(a.this.A, "textColor", R.color.download_tag_title_selected);
                a.this.B.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_normal));
                ((com.zte.fragmentlib.b) a.this).h.a(a.this.B, "textColor", R.color.download_tag_title_normal);
                a.this.O = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteFragment.java */
    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (System.currentTimeMillis() - a.this.O >= 200) {
                a.this.z.d(1);
                a.this.B.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_selected));
                ((com.zte.fragmentlib.b) a.this).h.a(a.this.B, "textColor", R.color.download_tag_title_selected);
                a.this.A.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_normal));
                ((com.zte.fragmentlib.b) a.this).h.a(a.this.A, "textColor", R.color.download_tag_title_normal);
                a.this.O = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteFragment.java */
    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            aVar.S = aVar.R.k();
            if (a.this.R != null) {
                a.this.S = !r4.S;
                a.this.R.a(a.this.S);
                a.this.q.b(a.this.S);
                a.this.r.b(a.this.S);
                if (a.this.S) {
                    a.this.K.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.favorite_list_icon));
                    ((com.zte.fragmentlib.b) a.this).h.a(a.this.K, "src", R.drawable.favorite_list_icon);
                    a.this.M.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.switch_list_mode));
                } else {
                    a.this.K.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.favorite_poster_icon));
                    ((com.zte.fragmentlib.b) a.this).h.a(a.this.K, "src", R.drawable.favorite_poster_icon);
                    a.this.M.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.switch_poster_mode));
                }
            }
        }
    }

    /* compiled from: FavoriteFragment.java */
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
        public void a(ViewGroup viewGroup, int i, Object obj) {
            super.a(viewGroup, i, obj);
        }

        @Override // androidx.fragment.app.n, androidx.viewpager.widget.a
        public Object a(ViewGroup viewGroup, int i) {
            return super.a(viewGroup, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FavoriteFragment.java */
    /* loaded from: classes.dex */
    public class k implements ViewPager.i {
        private k() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i, float f, int i2) {
            float width = (a.this.J.getWidth() * i * (1.0f - f)) + (a.this.J.getWidth() * (i + 1) * f);
            a.this.y.setTranslationX(width);
            a.this.y.setScaleX((a.this.J.getWidth() * 1.0f) / a.this.y.getWidth());
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void b(int i) {
            a.this.J();
            a.this.K();
            if (i == 0) {
                a.this.A.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_selected));
                ((com.zte.fragmentlib.b) a.this).h.a(a.this.A, "textColor", R.color.download_tag_title_selected);
                a.this.B.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_normal));
                ((com.zte.fragmentlib.b) a.this).h.a(a.this.B, "textColor", R.color.download_tag_title_normal);
                return;
            }
            a.this.B.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_selected));
            ((com.zte.fragmentlib.b) a.this).h.a(a.this.B, "textColor", R.color.download_tag_title_selected);
            a.this.A.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_normal));
            ((com.zte.fragmentlib.b) a.this).h.a(a.this.A, "textColor", R.color.download_tag_title_normal);
        }

        /* synthetic */ k(a aVar, ViewTreeObserverOnGlobalLayoutListenerC0285a viewTreeObserverOnGlobalLayoutListenerC0285a) {
            this();
        }
    }

    private void O() {
        this.s.setOnClickListener(new b());
        this.u.setOnClickListener(new c());
        this.x.setOnClickListener(new d());
        this.v.setOnClickListener(new e());
        this.F.setOnClickListener(new f());
        this.G.setOnClickListener(new g());
        this.J.setOnClickListener(new h());
        this.L.setOnClickListener(new i());
    }

    private void P() {
        this.R = new com.zte.iptvclient.android.common.j.h(this.h);
        this.p = new ArrayList<>();
        this.q = new com.zte.iptvclient.android.mobile.j.b.b();
        this.r = new com.zte.iptvclient.android.mobile.j.b.d();
        this.p.add(this.q);
        this.p.add(this.r);
        this.q.a(this);
        this.r.a(this);
    }

    private void Q() {
        this.J.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0285a());
        this.z.a(new j(getChildFragmentManager(), this.p));
        this.z.d(0);
        this.A.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_selected));
        this.h.a(this.A, "textColor", R.color.download_tag_title_selected);
        this.B.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_normal));
        this.h.a(this.B, "textColor", R.color.download_tag_title_normal);
        this.z.a(new k(this, null));
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        if (!this.P) {
            return false;
        }
        this.P = false;
        L();
        this.q.c(false);
        return true;
    }

    public boolean I() {
        return this.P;
    }

    public void J() {
        if (this.z.c() == 0) {
            if (this.q.N()) {
                this.u.setVisibility(0);
                return;
            } else {
                this.u.setVisibility(8);
                return;
            }
        }
        if (this.r.K()) {
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(8);
        }
    }

    public void K() {
        int size;
        if (this.z.c() == 0) {
            size = this.q.L().size();
        } else {
            size = this.r.I().size();
        }
        this.N.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.total_favorite), Integer.valueOf(size)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L() {
        if (this.P) {
            M();
        } else {
            N();
        }
    }

    protected void M() {
        this.D.setVisibility(8);
        this.E.setVisibility(0);
        this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
        this.q.d(true);
        this.q.c(false);
        e(this.q.J());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N() {
        this.D.setVisibility(0);
        this.E.setVisibility(8);
        this.F.setVisibility(8);
        this.q.d(false);
        this.q.c(false);
        e(this.q.J());
        a(0, 0, 0, 0);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Q();
        O();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        P();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.favorite_fragment_layout, (ViewGroup) null);
        d(inflate);
        boolean k2 = this.R.k();
        this.S = k2;
        if (k2) {
            this.K.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.favorite_list_icon));
            this.h.a(this.K, "src", R.drawable.favorite_list_icon);
            this.M.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.switch_list_mode));
        } else {
            this.K.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.favorite_poster_icon));
            this.h.a(this.K, "src", R.drawable.favorite_poster_icon);
            this.M.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.switch_poster_mode));
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.s = (Button) view.findViewById(R.id.btn_back);
        TextView textView2 = (TextView) view.findViewById(R.id.title_txt);
        this.t = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_favorite));
        TextView textView3 = (TextView) view.findViewById(R.id.edit_txt);
        this.u = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.edit));
        TextView textView4 = (TextView) view.findViewById(R.id.txt_selected_all);
        this.v = textView4;
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
        TextView textView5 = (TextView) view.findViewById(R.id.txt_selected_num);
        this.w = textView5;
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_num));
        TextView textView6 = (TextView) view.findViewById(R.id.txt_cancel);
        this.x = textView6;
        textView6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel));
        this.y = (ImageView) view.findViewById(R.id.cursor);
        this.z = (SlideViewPager) view.findViewById(R.id.viewpager);
        this.F = (FrameLayout) view.findViewById(R.id.fl_delete);
        this.G = (RelativeLayout) view.findViewById(R.id.rl_mobile_fav);
        this.J = (RelativeLayout) view.findViewById(R.id.rl_stb_fav);
        TextView textView7 = (TextView) view.findViewById(R.id.tag_title01);
        this.A = textView7;
        textView7.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.mobile_phone_collection));
        TextView textView8 = (TextView) view.findViewById(R.id.tag_title02);
        this.B = textView8;
        textView8.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.television_collection));
        this.D = (RelativeLayout) view.findViewById(R.id.title_rlayout);
        this.E = (RelativeLayout) view.findViewById(R.id.edit_rlayout);
        this.C = (RelativeLayout) view.findViewById(R.id.rl_ViewPager);
        this.K = (ImageView) view.findViewById(R.id.img_change_mode);
        this.M = (TextView) view.findViewById(R.id.text_change_mode);
        this.N = (TextView) view.findViewById(R.id.text_fav_num);
        this.L = (RelativeLayout) view.findViewById(R.id.rl_change_mode);
        ((TextView) view.findViewById(R.id.txt_delete)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.delete));
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
        com.zte.iptvclient.common.uiframe.f.a(this.K);
        com.zte.iptvclient.common.uiframe.f.a(this.M);
        com.zte.iptvclient.common.uiframe.f.a(this.N);
        com.zte.iptvclient.common.uiframe.f.a(this.L);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_change_mode));
    }

    public void e(int i2) {
        int J = this.q.J();
        if (J == this.q.K()) {
            this.w.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_nums), Integer.valueOf(J)));
            this.Q = true;
            this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_null));
        } else if (J <= 1) {
            this.w.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_num), Integer.valueOf(J)));
            this.Q = false;
            this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
        } else {
            this.w.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_nums), Integer.valueOf(J)));
            this.Q = false;
            this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
        }
    }

    public void b(boolean z) {
        this.P = z;
    }

    private void a(int i2, int i3, int i4, int i5) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(i2, i3, i4, i5);
        this.z.setLayoutParams(layoutParams);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
    }

    public int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void d(int i2) {
        if (i2 == 0) {
            this.F.setVisibility(8);
            a(0, 0, 0, 0);
        } else {
            this.F.setVisibility(0);
            a(0, 0, 0, a(this.h, 58.0f));
        }
    }
}
