package com.zte.iptvclient.android.mobile.k.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.n;
import androidx.viewpager.widget.ViewPager;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.zala.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: ChildWatchHistoryFragment.java */
/* loaded from: classes.dex */
public class c extends com.zte.fragmentlib.b implements View.OnClickListener {
    private static final String E = c.class.getSimpleName();
    private ImageView A;
    private ViewPager B;
    private List<Fragment> C;
    private C0292c D;
    private RelativeLayout p;
    private TextView q;
    private RelativeLayout r;
    private TextView s;
    private ImageView t;
    private RelativeLayout u;
    private TextView v;
    private ImageView w;
    private RelativeLayout x;
    private TextView y;
    private ImageView z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChildWatchHistoryFragment.java */
    /* loaded from: classes.dex */
    public final class b extends n {
        private List<Fragment> h;

        public b(c cVar, FragmentManager fragmentManager, List<Fragment> list) {
            super(fragmentManager);
            this.h = list;
        }

        @Override // androidx.viewpager.widget.a
        public int a() {
            List<Fragment> list = this.h;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // androidx.fragment.app.n
        public Fragment c(int i) {
            return this.h.get(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChildWatchHistoryFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.k.b.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0292c implements ViewPager.i {
        private C0292c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i, float f, int i2) {
            LogEx.d(c.E, " onPageScrolled(position: " + i + ", positionOffset: " + f + ", positionOffsetPixels: " + i2 + ")");
            float width = (((float) (c.this.r.getWidth() * i)) * (1.0f - f)) + (((float) (c.this.r.getWidth() * (i + 1))) * f);
            String str = c.E;
            StringBuilder sb = new StringBuilder();
            sb.append(" targetoffset: ");
            sb.append(width);
            LogEx.d(str, sb.toString());
            float width2 = (((float) c.this.r.getWidth()) * 1.0f) / ((float) c.this.A.getWidth());
            LogEx.d(c.E, " targetScale: " + width2);
            c.this.A.setTranslationX(width);
            c.this.A.setScaleX(width2);
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void b(int i) {
            LogEx.d(c.E, " onPageSelected: " + i);
            c.this.d(i);
        }
    }

    private void J() {
        ArrayList arrayList = new ArrayList(3);
        this.C = arrayList;
        arrayList.add(new com.zte.iptvclient.android.mobile.k.b.b());
        this.C.add(new d());
        this.C.add(new com.zte.iptvclient.android.mobile.k.b.a());
        this.B.a(new b(this, getChildFragmentManager(), this.C));
        this.B.e(this.C.size() - 1);
        C0292c c0292c = new C0292c();
        this.D = c0292c;
        this.B.a(c0292c);
        e(0);
    }

    private String K() {
        return new SimpleDateFormat("dd.MM.yyyy").format(new Date(TimeUtil.getNow().getTime() - 172800000));
    }

    private void L() {
        this.r.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.x.setOnClickListener(this);
    }

    private void d(View view) {
        com.zte.iptvclient.android.common.k.g.a(this.h, view, R.id.title_bottom_line);
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.p = (RelativeLayout) view.findViewById(R.id.title_rlayout);
        this.q = (TextView) view.findViewById(R.id.title_txt);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_ppv);
        this.r = relativeLayout;
        this.s = (TextView) relativeLayout.findViewById(R.id.tag_title01);
        this.t = (ImageView) this.r.findViewById(R.id.bottom_line01);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.rl_tvod);
        this.u = relativeLayout2;
        this.v = (TextView) relativeLayout2.findViewById(R.id.tag_title02);
        this.w = (ImageView) this.u.findViewById(R.id.bottom_line02);
        this.x = (RelativeLayout) view.findViewById(R.id.rl_concrete_time);
        TextView textView2 = (TextView) view.findViewById(R.id.tag_title03);
        this.y = textView2;
        textView2.setText(K());
        this.z = (ImageView) this.u.findViewById(R.id.bottom_line03);
        this.A = (ImageView) view.findViewById(R.id.cursor);
        this.B = (ViewPager) view.findViewById(R.id.vp_my_ppv);
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.line_1));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.line_2));
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        if (BaseApp.f()) {
            com.zte.iptvclient.android.common.k.g.a((ImageView) view.findViewById(R.id.title_bottom_line), this.h);
        }
        this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.child_watch_history_title));
        this.A.setVisibility(0);
    }

    private void e(int i) {
        if (i == 0) {
            this.B.d(0);
            d(0);
        } else if (i == 1) {
            this.B.d(1);
            d(1);
        } else if (i == 2) {
            this.B.d(2);
            d(2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.rl_concrete_time) {
            e(2);
        } else if (id == R.id.rl_ppv) {
            e(0);
        } else {
            if (id != R.id.rl_tvod) {
                return;
            }
            e(1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_child_watch_history, (ViewGroup) null);
        d(inflate);
        J();
        L();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.B.b(this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (i == 0) {
            this.s.setSelected(true);
            this.v.setSelected(false);
            this.y.setSelected(false);
        } else if (i == 1) {
            this.v.setSelected(true);
            this.s.setSelected(false);
            this.y.setSelected(false);
        } else if (i == 2) {
            this.y.setSelected(true);
            this.s.setSelected(false);
            this.v.setSelected(false);
        }
    }
}
