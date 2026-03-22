package com.zte.iptvclient.android.mobile.k.a;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.d;
import com.bumptech.glide.i;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.javabean.models.VoDBean;
import com.zte.iptvclient.android.common.k.u;
import com.zte.iptvclient.android.mobile.k.b.g;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;

/* compiled from: AdapterVodHistory.java */
/* loaded from: classes.dex */
public class c extends RecyclerView.g {

    /* renamed from: c, reason: collision with root package name */
    private Context f6678c;

    /* renamed from: d, reason: collision with root package name */
    LayoutInflater f6679d;
    g e;
    ArrayList<VoDBean> f;
    private ArrayList<VoDBean> g;
    private boolean i = false;
    private boolean j = false;
    ArrayList<VoDBean> h = new ArrayList<>();

    /* compiled from: AdapterVodHistory.java */
    /* loaded from: classes.dex */
    private class a extends RecyclerView.b0 {
        ImageView t;
        TextView u;
        TextView v;
        ImageView w;
        RelativeLayout x;

        a(c cVar, View view) {
            super(view);
            this.t = (ImageView) view.findViewById(R.id.poster_img);
            TextView textView = (TextView) view.findViewById(R.id.title_txt);
            this.u = textView;
            textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.title_upper));
            this.v = (TextView) view.findViewById(R.id.rating_txt);
            this.w = (ImageView) view.findViewById(R.id.img_corner);
            this.x = (RelativeLayout) view.findViewById(R.id.rl_del_selected);
            f.a(view.findViewById(R.id.ll_video_item));
            f.a(view.findViewById(R.id.rl_img));
            f.a(view.findViewById(R.id.poster_img));
            f.a(view.findViewById(R.id.img_corner));
            f.a(view.findViewById(R.id.rating_rl));
            f.a(view.findViewById(R.id.rating_txt));
            f.a(view.findViewById(R.id.rl_del_selected));
            f.a(view.findViewById(R.id.img_del_selected));
            f.a(view.findViewById(R.id.title_txt));
        }
    }

    /* compiled from: AdapterVodHistory.java */
    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private VoDBean f6680a;

        /* renamed from: b, reason: collision with root package name */
        private RelativeLayout f6681b;

        public b(VoDBean voDBean, RelativeLayout relativeLayout) {
            this.f6680a = voDBean;
            this.f6681b = relativeLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String j;
            if (c.this.i) {
                if (c.this.h.contains(this.f6680a)) {
                    c.this.h.remove(this.f6680a);
                    this.f6681b.setVisibility(8);
                } else {
                    c.this.h.add(this.f6680a);
                    this.f6681b.setVisibility(0);
                }
                c.this.e.Q();
                c cVar = c.this;
                cVar.e.d(cVar.h.size());
                c.this.e.S();
                c.this.e.R();
                return;
            }
            if (com.zte.iptvclient.android.common.k.c.a() || (j = this.f6680a.j()) == null) {
                return;
            }
            if (j.equals("1")) {
                u.c((Activity) c.this.f6678c, this.f6680a.h(), this.f6680a.c());
                return;
            }
            String h = this.f6680a.h();
            String c2 = this.f6680a.c();
            LogEx.d("AdapterVodHistory", "columncode = " + c2 + ",programcode = " + h);
            if (h == null && c2 == null) {
                return;
            }
            u.a((Activity) c.this.f6678c, h, c2);
        }
    }

    /* compiled from: AdapterVodHistory.java */
    /* renamed from: com.zte.iptvclient.android.mobile.k.a.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0291c extends RecyclerView.b0 {
        TextView t;

        C0291c(c cVar, View view) {
            super(view);
            TextView textView = (TextView) view.findViewById(R.id.text_time);
            this.t = textView;
            f.a(textView);
        }
    }

    public c(g gVar, ArrayList<VoDBean> arrayList, ArrayList<VoDBean> arrayList2, Context context) {
        this.f6678c = context;
        this.e = gVar;
        this.f = arrayList;
        this.g = arrayList2;
        this.f6679d = LayoutInflater.from(context);
        if (this.f == null) {
            LogEx.d("AdapterVodHistory", "lstVoD null");
            this.f = new ArrayList<>();
        }
    }

    public void e() {
        this.h.clear();
    }

    public void f() {
        this.h.clear();
        d();
    }

    public boolean g() {
        return this.g.size() == this.h.size();
    }

    public ArrayList<VoDBean> h() {
        return this.h;
    }

    public void i() {
        this.h.clear();
        this.h.addAll(this.g);
        d();
    }

    public void a(ArrayList<VoDBean> arrayList) {
        this.f = arrayList;
    }

    public void b(boolean z) {
        if (z) {
            this.i = true;
            this.h.clear();
        } else {
            this.i = false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        if (this.f.size() > 0) {
            return this.f.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int b(int i) {
        if ("1".equals(this.f.get(i).n())) {
            return 1;
        }
        return "2".equals(this.f.get(i).n()) ? 2 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.b0 b(ViewGroup viewGroup, int i) {
        if (1 != i && 2 != i) {
            return new a(this, this.f6679d.inflate(R.layout.item_vod_history, viewGroup, false));
        }
        return new C0291c(this, this.f6679d.inflate(R.layout.item_vod_history_time, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void b(RecyclerView.b0 b0Var, int i) {
        String valueOf;
        String valueOf2;
        String valueOf3;
        if (b0Var instanceof C0291c) {
            C0291c c0291c = (C0291c) b0Var;
            if (1 == b(i)) {
                c0291c.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.this_week));
                return;
            } else {
                c0291c.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.earlier));
                return;
            }
        }
        a aVar = (a) b0Var;
        VoDBean voDBean = this.f.get(i);
        if (this.j && com.zte.iptvclient.android.mobile.f.b.a.a(voDBean.k(), this.e.getContext())) {
            aVar.u.setText(R.string.common_blocktitle);
        } else {
            aVar.u.setText(voDBean.i());
        }
        String a2 = com.zte.iptvclient.android.common.k.g.a(BaseApp.a(this.f6678c) ? 9 : 3, voDBean.g());
        g gVar = this.e;
        if (gVar != null && gVar.getActivity() != null && !this.e.getActivity().isFinishing()) {
            d<String> a3 = i.a(this.e).a(a2);
            a3.b(R.drawable.default_poster_thumb);
            a3.a(R.drawable.default_poster_thumb);
            a3.c(300);
            a3.a(aVar.t);
        }
        int b2 = com.zte.iptvclient.android.common.k.g.b(voDBean.o());
        if (b2 == 1) {
            aVar.w.setVisibility(0);
            aVar.w.setImageResource(R.drawable.free);
        } else if (b2 == 2) {
            aVar.w.setVisibility(0);
            aVar.w.setImageResource(R.drawable.pay);
        } else {
            aVar.w.setVisibility(8);
        }
        String b3 = voDBean.b();
        if (b3 != null) {
            if (StringUtil.isSameString("1", voDBean.a())) {
                int intValue = Integer.valueOf(b3).intValue();
                if (intValue >= 60) {
                    int i2 = intValue / 3600;
                    int i3 = intValue % 3600;
                    int i4 = i3 / 60;
                    int i5 = i3 % 60;
                    if (i2 < 10) {
                        valueOf = "0" + String.valueOf(i2);
                    } else {
                        valueOf = String.valueOf(i2);
                    }
                    if (i4 < 10) {
                        valueOf2 = "0" + String.valueOf(i4);
                    } else {
                        valueOf2 = String.valueOf(i4);
                    }
                    if (i5 < 10) {
                        valueOf3 = "0" + String.valueOf(i5);
                    } else {
                        valueOf3 = String.valueOf(i5);
                    }
                    if (this.e != null) {
                        aVar.v.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.breakpoint_vod), valueOf, valueOf2, valueOf3));
                    }
                } else if (this.e != null) {
                    aVar.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.breakpoint_vod_not_enough_one_min));
                }
                aVar.v.setVisibility(0);
            } else if (StringUtil.isSameString("4", voDBean.a()) && this.e != null) {
                aVar.v.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.breakpoint_series_child), Integer.valueOf(b3)));
                aVar.v.setVisibility(0);
            } else {
                aVar.v.setVisibility(4);
            }
        } else {
            aVar.v.setVisibility(4);
        }
        aVar.t.setOnClickListener(new b(voDBean, aVar.x));
        if (this.i && this.h.contains(voDBean)) {
            aVar.x.setVisibility(0);
        } else {
            aVar.x.setVisibility(8);
        }
    }
}
