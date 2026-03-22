package com.zte.iptvclient.android.mobile.d.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.d;
import com.bumptech.glide.i;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.u;
import com.zte.iptvclient.android.mobile.bookmark.entity.ViewHistoryEntity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AdapterViewHistory.java */
/* loaded from: classes.dex */
public class a extends RecyclerView.g {

    /* renamed from: c, reason: collision with root package name */
    private Context f5713c;

    /* renamed from: d, reason: collision with root package name */
    LayoutInflater f5714d;
    Fragment e;
    List<ViewHistoryEntity> f;
    private ArrayList<ViewHistoryEntity> g;
    private int k;
    private boolean i = false;
    private boolean j = false;
    ArrayList<ViewHistoryEntity> h = new ArrayList<>();

    /* compiled from: AdapterViewHistory.java */
    /* renamed from: com.zte.iptvclient.android.mobile.d.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0208a extends RecyclerView.b0 {
        ImageView t;
        ImageView u;
        TextView v;
        RelativeLayout w;
        RelativeLayout x;

        public C0208a(a aVar, View view) {
            super(view);
            this.t = (ImageView) view.findViewById(R.id.poster_img);
            TextView textView = (TextView) view.findViewById(R.id.title_txt);
            this.v = textView;
            textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.title_upper));
            this.u = (ImageView) view.findViewById(R.id.ivi_logo_top);
            this.w = (RelativeLayout) view.findViewById(R.id.rl_del_selected);
            this.x = (RelativeLayout) view.findViewById(R.id.rl_del_select);
            f.a(view.findViewById(R.id.ll_video_item));
            f.a(view.findViewById(R.id.rl_img));
            f.a(view.findViewById(R.id.poster_img));
            f.a(view.findViewById(R.id.img_corner));
            f.a(view.findViewById(R.id.rating_rl));
            f.a(view.findViewById(R.id.rating_txt));
            f.a(view.findViewById(R.id.rl_del_selected));
            f.a(view.findViewById(R.id.img_del_selected));
            f.a(view.findViewById(R.id.rl_del_select));
            f.a(view.findViewById(R.id.img_del_select));
            f.a(view.findViewById(R.id.title_txt));
            f.a(this.u);
            if (BaseApp.a(aVar.f5713c)) {
                int a2 = g.a(aVar.f5713c, 25.0f);
                ImageView imageView = (ImageView) view.findViewById(R.id.img_del_selected);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = a2;
                    layoutParams.height = a2;
                    imageView.setLayoutParams(layoutParams);
                }
                ImageView imageView2 = (ImageView) view.findViewById(R.id.img_del_select);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = a2;
                    layoutParams2.height = a2;
                    imageView2.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    /* compiled from: AdapterViewHistory.java */
    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private ViewHistoryEntity f5715a;

        /* renamed from: b, reason: collision with root package name */
        private RelativeLayout f5716b;

        public b(ViewHistoryEntity viewHistoryEntity, RelativeLayout relativeLayout) {
            this.f5715a = viewHistoryEntity;
            this.f5716b = relativeLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String g;
            if (a.this.i) {
                if (a.this.h.contains(this.f5715a)) {
                    a.this.h.remove(this.f5715a);
                    this.f5716b.setVisibility(8);
                } else {
                    a.this.h.add(this.f5715a);
                    this.f5716b.setVisibility(0);
                }
                a aVar = a.this;
                ((com.zte.iptvclient.android.mobile.d.b.a) aVar.e).e(aVar.h.size());
                a aVar2 = a.this;
                ((com.zte.iptvclient.android.mobile.d.b.a) aVar2.e).d(aVar2.h.size());
                return;
            }
            if (com.zte.iptvclient.android.common.k.c.a() || (g = this.f5715a.g()) == null) {
                return;
            }
            if ("1".equals(g)) {
                u.c(a.this.e.getActivity(), this.f5715a.e(), this.f5715a.a());
                return;
            }
            if ("14".equals(g)) {
                String e = this.f5715a.e();
                String a2 = this.f5715a.a();
                LogEx.d("AdapterBookMarkNew", "columncode = " + a2 + ",programcode = " + e);
                if (e == null && a2 == null) {
                    return;
                }
                u.a(a.this.e.getActivity(), e, a2);
                return;
            }
            if ("10".equals(g)) {
                u.a(a.this.e.getActivity(), this.f5715a.j(), this.f5715a.a(), this.f5715a.i());
            }
        }
    }

    /* compiled from: AdapterViewHistory.java */
    /* loaded from: classes.dex */
    class c extends RecyclerView.b0 {
        TextView t;

        public c(a aVar, View view) {
            super(view);
            TextView textView = (TextView) view.findViewById(R.id.text_time);
            this.t = textView;
            f.a(textView);
        }
    }

    public a(Fragment fragment, ArrayList<ViewHistoryEntity> arrayList, ArrayList<ViewHistoryEntity> arrayList2, Context context) {
        this.f5713c = context;
        this.e = fragment;
        this.f = arrayList;
        this.g = arrayList2;
        this.f5714d = LayoutInflater.from(context);
        if (this.f == null) {
            LogEx.d("AdapterBookMarkNew", "lstVoD null");
            this.f = new ArrayList();
        }
    }

    public void e() {
        this.h.clear();
        d();
    }

    public void f() {
        this.h.clear();
        ((com.zte.iptvclient.android.mobile.d.b.a) this.e).e(this.h.size());
        d();
    }

    public ArrayList<ViewHistoryEntity> g() {
        return this.h;
    }

    public int h() {
        return this.k;
    }

    public void i() {
        this.h.clear();
        this.h.addAll(this.g);
        ((com.zte.iptvclient.android.mobile.d.b.a) this.e).e(this.h.size());
        d();
    }

    public void a(List<ViewHistoryEntity> list) {
        this.f = list;
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

    public void e(int i) {
        this.k = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int b(int i) {
        if ("1".equals(this.f.get(i).l())) {
            return 1;
        }
        return "2".equals(this.f.get(i).l()) ? 2 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.b0 b(ViewGroup viewGroup, int i) {
        if (1 != i && 2 != i) {
            return new C0208a(this, this.f5714d.inflate(R.layout.vod_bookmark_item, viewGroup, false));
        }
        return new c(this, this.f5714d.inflate(R.layout.book_mark_time_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void b(RecyclerView.b0 b0Var, int i) {
        if (b0Var instanceof c) {
            c cVar = (c) b0Var;
            if (1 == b(i)) {
                if ("1".equals(ConfigMgr.readPropertie("isShow"))) {
                    cVar.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.today));
                    return;
                } else {
                    cVar.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.this_week));
                    return;
                }
            }
            cVar.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.earlier));
            return;
        }
        C0208a c0208a = (C0208a) b0Var;
        ViewHistoryEntity viewHistoryEntity = this.f.get(i);
        if (viewHistoryEntity.c().equals("ivi")) {
            c0208a.u.setVisibility(0);
            c0208a.u.setImageDrawable(this.e.getResources().getDrawable(R.drawable.ivi_logo));
        } else if (viewHistoryEntity.c().equals("Megogo")) {
            c0208a.u.setVisibility(0);
            c0208a.u.setImageDrawable(this.e.getResources().getDrawable(R.drawable.megogo_logo));
        } else {
            c0208a.u.setVisibility(8);
        }
        if (this.j && com.zte.iptvclient.android.mobile.f.b.a.a(viewHistoryEntity.h(), this.e.getContext())) {
            c0208a.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_blocktitle));
        } else {
            c0208a.v.setText(viewHistoryEntity.f());
        }
        String a2 = g.a(BaseApp.a(this.f5713c) ? 9 : 3, viewHistoryEntity.d());
        Fragment fragment = this.e;
        if (fragment != null && fragment.getActivity() != null && !this.e.getActivity().isFinishing()) {
            d<String> a3 = i.a(this.e).a(a2);
            a3.b(R.drawable.default_poster_thumb);
            a3.a(R.drawable.default_poster_thumb);
            a3.c(300);
            a3.a(c0208a.t);
        }
        c0208a.t.setOnClickListener(new b(viewHistoryEntity, c0208a.w));
        if (this.i && this.h.contains(viewHistoryEntity)) {
            c0208a.w.setVisibility(0);
        } else {
            c0208a.w.setVisibility(8);
        }
        if (!this.i) {
            c0208a.x.setVisibility(8);
        } else {
            c0208a.x.setVisibility(0);
        }
    }
}
