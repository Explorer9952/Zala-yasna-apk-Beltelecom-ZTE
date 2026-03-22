package com.zte.iptvclient.android.mobile.j.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.d;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.javabean.models.VoDBean;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.u;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;

/* compiled from: AdapterVODFavorite.java */
/* loaded from: classes.dex */
public class c extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    Fragment f6617a;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<VoDBean> f6618b;

    /* renamed from: d, reason: collision with root package name */
    LayoutInflater f6620d;
    private boolean e = false;
    private boolean f = false;

    /* renamed from: c, reason: collision with root package name */
    ArrayList<VoDBean> f6619c = new ArrayList<>();

    /* compiled from: AdapterVODFavorite.java */
    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private VoDBean f6621a;

        /* renamed from: b, reason: collision with root package name */
        private RelativeLayout f6622b;

        public a(VoDBean voDBean, RelativeLayout relativeLayout) {
            this.f6621a = voDBean;
            this.f6622b = relativeLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.e) {
                if (c.this.f6619c.contains(this.f6621a)) {
                    c.this.f6619c.remove(this.f6621a);
                    this.f6622b.setVisibility(8);
                } else {
                    c.this.f6619c.add(this.f6621a);
                    this.f6622b.setVisibility(0);
                }
                c cVar = c.this;
                ((com.zte.iptvclient.android.mobile.j.b.c) cVar.f6617a).e(cVar.f6619c.size());
                c cVar2 = c.this;
                ((com.zte.iptvclient.android.mobile.j.b.c) cVar2.f6617a).d(cVar2.f6619c.size());
                return;
            }
            String j = this.f6621a.j();
            if (j != null) {
                if (j.equals("1")) {
                    u.c(c.this.f6617a.getActivity(), this.f6621a.h(), this.f6621a.c());
                    return;
                }
                String h = this.f6621a.h();
                String c2 = this.f6621a.c();
                LogEx.i(c2, c2);
                if (h == null && c2 == null) {
                    return;
                }
                u.a(c.this.f6617a.getActivity(), h, c2);
            }
        }
    }

    /* compiled from: AdapterVODFavorite.java */
    /* loaded from: classes.dex */
    private class b {

        /* renamed from: a, reason: collision with root package name */
        ImageView f6624a;

        /* renamed from: b, reason: collision with root package name */
        TextView f6625b;

        /* renamed from: c, reason: collision with root package name */
        TextView f6626c;

        /* renamed from: d, reason: collision with root package name */
        RelativeLayout f6627d;
        RelativeLayout e;
        ImageView f;
        ImageView g;

        public b(c cVar) {
            cVar.f = "1".equals(ConfigMgr.readPropertie("IsShowBlockTitle"));
        }
    }

    public c(Fragment fragment, ArrayList<VoDBean> arrayList) {
        this.f6617a = fragment;
        this.f6618b = arrayList;
        if (fragment.getActivity() != null) {
            this.f6620d = (LayoutInflater) fragment.getActivity().getSystemService("layout_inflater");
        }
    }

    public void b() {
        this.f6619c.clear();
        ((com.zte.iptvclient.android.mobile.j.b.c) this.f6617a).e(this.f6619c.size());
        notifyDataSetChanged();
    }

    public ArrayList<VoDBean> c() {
        return this.f6619c;
    }

    public int d() {
        return this.f6618b.size();
    }

    public void e() {
        ArrayList<VoDBean> arrayList = new ArrayList<>(this.f6618b);
        this.f6619c = arrayList;
        ((com.zte.iptvclient.android.mobile.j.b.c) this.f6617a).e(arrayList.size());
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f6618b.size() == 0) {
            return 0;
        }
        return this.f6618b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        if (view == null) {
            bVar = new b(this);
            view2 = this.f6620d.inflate(R.layout.vod_favorite_item, (ViewGroup) null);
            bVar.f6624a = (ImageView) view2.findViewById(R.id.poster_img);
            TextView textView = (TextView) view2.findViewById(R.id.title_txt);
            bVar.f6625b = textView;
            textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.title_upper));
            bVar.g = (ImageView) view2.findViewById(R.id.ivi_logo_top);
            bVar.f6626c = (TextView) view2.findViewById(R.id.rating_txt);
            bVar.f6627d = (RelativeLayout) view2.findViewById(R.id.rl_del_selected);
            bVar.e = (RelativeLayout) view2.findViewById(R.id.rl_del_select);
            bVar.f = (ImageView) view2.findViewById(R.id.img_corner);
            f.a(view2.findViewById(R.id.ll_video_item));
            f.a(view2.findViewById(R.id.rl_img));
            f.a(view2.findViewById(R.id.poster_img));
            f.a(view2.findViewById(R.id.img_corner));
            f.a(view2.findViewById(R.id.rating_rl));
            f.a(view2.findViewById(R.id.rating_txt));
            f.a(view2.findViewById(R.id.rl_del_selected));
            f.a(view2.findViewById(R.id.img_del_selected1));
            f.a(view2.findViewById(R.id.rl_del_select));
            f.a(view2.findViewById(R.id.img_del_select));
            f.a(view2.findViewById(R.id.title_txt));
            f.a(bVar.g);
            view2.setTag(bVar);
            Context context = this.f6617a.getContext();
            if (BaseApp.a(context)) {
                int a2 = g.a(context, 25.0f);
                ImageView imageView = (ImageView) view2.findViewById(R.id.img_del_selected1);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = a2;
                    layoutParams.height = a2;
                    imageView.setLayoutParams(layoutParams);
                }
                ImageView imageView2 = (ImageView) view2.findViewById(R.id.img_del_select);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = a2;
                    layoutParams2.height = a2;
                    imageView2.setLayoutParams(layoutParams2);
                }
            }
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        VoDBean voDBean = this.f6618b.get(i);
        if (voDBean.e().equals("ivi")) {
            bVar.g.setVisibility(0);
            bVar.g.setImageDrawable(this.f6617a.getResources().getDrawable(R.drawable.ivi_logo));
        } else if (voDBean.e().equals("Megogo")) {
            bVar.g.setVisibility(0);
            bVar.g.setImageDrawable(this.f6617a.getResources().getDrawable(R.drawable.megogo_logo));
        } else {
            bVar.g.setVisibility(8);
        }
        if (this.f && com.zte.iptvclient.android.mobile.f.b.a.a(voDBean.k(), this.f6617a.getContext())) {
            bVar.f6625b.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_blocktitle));
        } else {
            bVar.f6625b.setText(voDBean.i());
        }
        int b2 = g.b(voDBean.o());
        if (b2 == 1) {
            bVar.f.setVisibility(0);
            bVar.f.setImageResource(R.drawable.free);
        } else if (b2 == 2) {
            bVar.f.setVisibility(0);
            bVar.f.setImageResource(R.drawable.pay);
        } else {
            bVar.f.setVisibility(8);
        }
        String g = voDBean.g();
        String[] split = g.split(";");
        if (!TextUtils.isEmpty(g)) {
            String g2 = i.g();
            if (BaseApp.a(this.f6617a.getContext())) {
                if (split.length > 9) {
                    g = g2 + "/images/poster/" + split[9];
                    LogEx.d("USee", "AdapterFavorite image url = " + g);
                }
            } else if (split.length > 3) {
                g = g2 + "/images/poster/" + split[3];
                LogEx.d("USee", "AdapterFavorite image url = " + g);
            }
        }
        Fragment fragment = this.f6617a;
        if (fragment != null && fragment.getActivity() != null && !this.f6617a.getActivity().isFinishing()) {
            d<String> a3 = com.bumptech.glide.i.a(this.f6617a).a(g);
            a3.a(R.drawable.default_poster_thumb);
            a3.c(300);
            a3.a(bVar.f6624a);
        }
        if (voDBean.m() != null) {
            try {
                float intValue = Integer.valueOf(r1).intValue() * 1.0f;
                if (intValue > 0.0f) {
                    String valueOf = String.valueOf(intValue);
                    if (valueOf != null) {
                        bVar.f6626c.setVisibility(0);
                        bVar.f6626c.setText(valueOf);
                    } else {
                        bVar.f6626c.setVisibility(4);
                    }
                }
            } catch (Exception e) {
                LogEx.d("UseeTv", e.getMessage());
            }
        }
        bVar.f6624a.setOnClickListener(new a(voDBean, bVar.f6627d));
        if (this.e && this.f6619c.contains(this.f6618b.get(i))) {
            bVar.f6627d.setVisibility(0);
        } else {
            bVar.f6627d.setVisibility(8);
        }
        if (!this.e) {
            bVar.e.setVisibility(8);
        } else {
            bVar.e.setVisibility(0);
        }
        return view2;
    }

    public void a(ArrayList<VoDBean> arrayList) {
        this.f6618b = arrayList;
        notifyDataSetChanged();
    }

    public void a() {
        this.f6619c.clear();
    }

    public void a(boolean z) {
        if (z) {
            this.e = true;
            this.f6619c.clear();
        } else {
            this.e = false;
        }
    }
}
