package com.zte.iptvclient.android.mobile.j.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.d;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.javabean.models.VoDBean;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.u;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;

/* compiled from: AdapterMobileFavorite.java */
/* loaded from: classes.dex */
public class a extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    Fragment f6595a;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<VoDBean> f6596b;

    /* renamed from: d, reason: collision with root package name */
    LayoutInflater f6598d;
    private boolean f;
    private boolean e = false;
    private boolean g = false;

    /* renamed from: c, reason: collision with root package name */
    ArrayList<VoDBean> f6597c = new ArrayList<>();

    /* compiled from: AdapterMobileFavorite.java */
    /* renamed from: com.zte.iptvclient.android.mobile.j.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class ViewOnClickListenerC0283a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private VoDBean f6599a;

        /* renamed from: b, reason: collision with root package name */
        private View f6600b;

        public ViewOnClickListenerC0283a(VoDBean voDBean, View view) {
            this.f6599a = voDBean;
            this.f6600b = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.e) {
                if (a.this.f6597c.contains(this.f6599a)) {
                    a.this.f6597c.remove(this.f6599a);
                    this.f6600b.setVisibility(4);
                } else {
                    a.this.f6597c.add(this.f6599a);
                    this.f6600b.setVisibility(0);
                }
                a aVar = a.this;
                ((com.zte.iptvclient.android.mobile.j.b.b) aVar.f6595a).e(aVar.f6597c.size());
                a aVar2 = a.this;
                ((com.zte.iptvclient.android.mobile.j.b.b) aVar2.f6595a).d(aVar2.f6597c.size());
                return;
            }
            String j = this.f6599a.j();
            if (j != null) {
                if (j.equals("1")) {
                    u.c(a.this.f6595a.getActivity(), this.f6599a.h(), this.f6599a.c());
                    return;
                }
                String h = this.f6599a.h();
                String c2 = this.f6599a.c();
                LogEx.i(c2, c2);
                if (h == null && c2 == null) {
                    return;
                }
                u.a(a.this.f6595a.getActivity(), h, c2);
            }
        }
    }

    /* compiled from: AdapterMobileFavorite.java */
    /* loaded from: classes.dex */
    private class b {

        /* renamed from: a, reason: collision with root package name */
        TextView f6602a;

        /* renamed from: b, reason: collision with root package name */
        LinearLayout f6603b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f6604c;

        public b(a aVar) {
            aVar.g = "1".equals(ConfigMgr.readPropertie("IsShowBlockTitle"));
        }
    }

    /* compiled from: AdapterMobileFavorite.java */
    /* loaded from: classes.dex */
    private class c {

        /* renamed from: a, reason: collision with root package name */
        ImageView f6605a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f6606b;

        /* renamed from: c, reason: collision with root package name */
        TextView f6607c;

        /* renamed from: d, reason: collision with root package name */
        TextView f6608d;
        RelativeLayout e;

        public c(a aVar) {
            aVar.g = "1".equals(ConfigMgr.readPropertie("IsShowBlockTitle"));
        }
    }

    public a(Fragment fragment, ArrayList<VoDBean> arrayList, boolean z) {
        this.f = true;
        this.f6595a = fragment;
        this.f6596b = arrayList;
        this.f = z;
        if (fragment.getActivity() != null) {
            this.f6598d = (LayoutInflater) fragment.getActivity().getSystemService("layout_inflater");
        }
    }

    public void b(boolean z) {
        this.f = z;
    }

    public ArrayList<VoDBean> c() {
        return this.f6597c;
    }

    public void d() {
        ArrayList<VoDBean> arrayList = new ArrayList<>(this.f6596b);
        this.f6597c = arrayList;
        ((com.zte.iptvclient.android.mobile.j.b.b) this.f6595a).e(arrayList.size());
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f6596b.size() == 0) {
            return 0;
        }
        return this.f6596b.size();
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
        c cVar;
        if (this.f) {
            if (view == null) {
                cVar = new c(this);
                view2 = this.f6598d.inflate(R.layout.vod_favorite_item, (ViewGroup) null);
                cVar.f6605a = (ImageView) view2.findViewById(R.id.poster_img);
                cVar.f6607c = (TextView) view2.findViewById(R.id.title_txt);
                cVar.f6608d = (TextView) view2.findViewById(R.id.rating_txt);
                cVar.e = (RelativeLayout) view2.findViewById(R.id.rl_del_selected);
                cVar.f6606b = (ImageView) view2.findViewById(R.id.img_corner);
                f.a(view2.findViewById(R.id.ll_video_item));
                f.a(view2.findViewById(R.id.rl_img));
                f.a(view2.findViewById(R.id.poster_img));
                f.a(view2.findViewById(R.id.img_corner));
                f.a(view2.findViewById(R.id.rating_rl));
                f.a(view2.findViewById(R.id.rating_txt));
                f.a(view2.findViewById(R.id.rl_del_selected));
                f.a(view2.findViewById(R.id.img_del_selected1));
                f.a(view2.findViewById(R.id.title_txt));
                view2.setTag(cVar);
            } else {
                view2 = view;
                cVar = (c) view.getTag();
            }
            VoDBean voDBean = this.f6596b.get(i);
            if (voDBean != null) {
                if (this.g && com.zte.iptvclient.android.mobile.f.b.a.a(voDBean.k(), this.f6595a.getContext())) {
                    cVar.f6607c.setText(R.string.common_blocktitle);
                } else {
                    cVar.f6607c.setText(voDBean.i());
                }
                int b2 = g.b(this.f6596b.get(i).o());
                if (b2 == 1) {
                    cVar.f6606b.setVisibility(0);
                    cVar.f6606b.setImageResource(R.drawable.free);
                } else if (b2 == 2) {
                    cVar.f6606b.setVisibility(0);
                    cVar.f6606b.setImageResource(R.drawable.pay);
                } else {
                    cVar.f6606b.setVisibility(8);
                }
                String g = voDBean.g();
                String[] split = g.split(";");
                if (!TextUtils.isEmpty(g)) {
                    String g2 = i.g();
                    if (split.length > 3) {
                        g = g2 + "/images/poster/" + split[3];
                        LogEx.d("USee", "AdapterFavorite image url = " + g);
                    }
                }
                Fragment fragment = this.f6595a;
                if (fragment != null && fragment.getActivity() != null && !this.f6595a.getActivity().isFinishing()) {
                    d<String> a2 = com.bumptech.glide.i.a(this.f6595a).a(g);
                    a2.a(R.drawable.default_poster_thumb);
                    a2.c(300);
                    a2.a(cVar.f6605a);
                }
                if (voDBean.m() != null) {
                    try {
                        float intValue = Integer.valueOf(r11).intValue() * 1.0f;
                        if (intValue > 0.0f) {
                            String valueOf = String.valueOf(intValue);
                            if (valueOf != null) {
                                cVar.f6608d.setVisibility(0);
                                cVar.f6608d.setText(valueOf);
                            } else {
                                cVar.f6608d.setVisibility(4);
                            }
                        }
                    } catch (Exception e) {
                        LogEx.d("UseeTv", e.getMessage());
                    }
                }
                cVar.f6605a.setOnClickListener(new ViewOnClickListenerC0283a(voDBean, cVar.e));
                if (this.e && this.f6597c.contains(voDBean)) {
                    cVar.e.setVisibility(0);
                } else {
                    cVar.e.setVisibility(8);
                }
            }
        } else {
            if (view == null) {
                bVar = new b(this);
                view2 = this.f6598d.inflate(R.layout.favorite_list_item, (ViewGroup) null);
                bVar.f6602a = (TextView) view2.findViewById(R.id.txt_name);
                bVar.f6603b = (LinearLayout) view2.findViewById(R.id.ll_item);
                bVar.f6604c = (ImageView) view2.findViewById(R.id.img_select);
                f.a(bVar.f6602a);
                f.a(bVar.f6604c);
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            VoDBean voDBean2 = this.f6596b.get(i);
            if (voDBean2 != null) {
                if (this.g && com.zte.iptvclient.android.mobile.f.b.a.a(voDBean2.k(), this.f6595a.getContext())) {
                    bVar.f6602a.setText(R.string.common_blocktitle);
                } else {
                    bVar.f6602a.setText(voDBean2.i());
                }
                bVar.f6603b.setOnClickListener(new ViewOnClickListenerC0283a(voDBean2, bVar.f6604c));
                if (this.e && this.f6597c.contains(voDBean2)) {
                    bVar.f6604c.setVisibility(0);
                } else {
                    bVar.f6604c.setVisibility(4);
                }
            }
        }
        return view2;
    }

    public void b() {
        this.f6597c.clear();
        ((com.zte.iptvclient.android.mobile.j.b.b) this.f6595a).e(this.f6597c.size());
        notifyDataSetChanged();
    }

    public void a() {
        this.f6597c.clear();
    }

    public void a(boolean z) {
        if (z) {
            this.e = true;
            this.f6597c.clear();
        } else {
            this.e = false;
        }
    }
}
