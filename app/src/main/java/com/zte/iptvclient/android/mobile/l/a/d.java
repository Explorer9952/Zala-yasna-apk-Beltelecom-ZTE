package com.zte.iptvclient.android.mobile.l.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import com.zte.iptvclient.android.mobile.e0.f.g;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;

/* compiled from: HomeCustomColumnAdapter.java */
/* loaded from: classes.dex */
public class d extends RecyclerView.g {

    /* renamed from: c, reason: collision with root package name */
    private Context f6716c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<CommonVideoBean> f6717d;
    private LayoutInflater e;
    h f;
    int g = -1;
    b h;

    /* compiled from: HomeCustomColumnAdapter.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6718a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CommonVideoBean f6719b;

        a(int i, CommonVideoBean commonVideoBean) {
            this.f6718a = i;
            this.f6719b = commonVideoBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar;
            if (com.zte.iptvclient.android.common.k.c.a() || (bVar = d.this.h) == null) {
                return;
            }
            bVar.a(this.f6718a, this.f6719b);
        }
    }

    /* compiled from: HomeCustomColumnAdapter.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(int i, CommonVideoBean commonVideoBean);
    }

    /* compiled from: HomeCustomColumnAdapter.java */
    /* loaded from: classes.dex */
    public class c extends RecyclerView.b0 {
        private TextView A;
        private ImageView t;
        private TextView u;
        private ImageView v;
        private RelativeLayout w;
        private LinearLayout x;
        private TextView y;
        private ImageView z;

        public c(d dVar, View view) {
            super(view);
            this.x = (LinearLayout) view.findViewById(R.id.ll_poster);
            this.w = (RelativeLayout) view.findViewById(R.id.img_rlayout);
            this.t = (ImageView) view.findViewById(R.id.poster_img);
            this.u = (TextView) view.findViewById(R.id.title_txt);
            this.v = (ImageView) view.findViewById(R.id.ivi_logo_top);
            this.y = (TextView) view.findViewById(R.id.series_lastupdate_txt);
            this.z = (ImageView) view.findViewById(R.id.img_pay_free);
            this.A = (TextView) view.findViewById(R.id.short_title);
            f.a(this.x);
            f.a(this.w);
            f.a(this.t);
            f.a(this.u);
            f.a(this.v);
            f.a(this.y);
            f.a(this.z);
            f.a(this.A);
            g.a(this.A);
        }
    }

    public d(Context context, ArrayList<CommonVideoBean> arrayList) {
        this.f6716c = context;
        this.f6717d = arrayList;
        this.e = LayoutInflater.from(context);
        this.f = new h(context);
    }

    public void a(b bVar) {
        this.h = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.b0 b(ViewGroup viewGroup, int i) {
        return new c(this, this.e.inflate(R.layout.video_poster_item, (ViewGroup) null));
    }

    public void e(int i) {
        this.g = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        int i = this.g;
        if (i == -1) {
            ArrayList<CommonVideoBean> arrayList = this.f6717d;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        ArrayList<CommonVideoBean> arrayList2 = this.f6717d;
        return Math.min(i, arrayList2 != null ? arrayList2.size() : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void b(RecyclerView.b0 b0Var, int i) {
        LinearLayout.LayoutParams layoutParams;
        CommonVideoBean commonVideoBean = this.f6717d.get(i);
        c cVar = (c) b0Var;
        ImageView imageView = cVar.t;
        TextView textView = cVar.u;
        ImageView imageView2 = cVar.v;
        TextView unused = cVar.A;
        ImageView imageView3 = cVar.z;
        TextView textView2 = cVar.y;
        String a2 = com.zte.iptvclient.android.common.k.g.a(BaseApp.a(this.f6716c) ? 9 : 3, commonVideoBean.c());
        if (commonVideoBean.b().equals("ivi")) {
            imageView2.setVisibility(0);
            imageView2.setImageDrawable(this.f6716c.getResources().getDrawable(R.drawable.ivi_logo));
        } else if (commonVideoBean.b().equals("Megogo")) {
            imageView2.setVisibility(0);
            imageView2.setImageDrawable(this.f6716c.getResources().getDrawable(R.drawable.megogo_logo));
        } else {
            imageView2.setVisibility(8);
        }
        textView.setText(com.zte.iptvclient.android.mobile.f.b.a.a(commonVideoBean.g(), commonVideoBean.e(), com.zte.iptvclient.android.common.i.a.a.a(R.string.common_blocktitle), this.f, this.f6716c));
        if (!BaseApp.a(this.f6716c) && (layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams()) != null) {
            layoutParams.height = com.zte.iptvclient.android.common.k.g.a(this.f6716c, 28.0f);
            textView.setLayoutParams(layoutParams);
            textView.setPadding(0, 0, 0, com.zte.iptvclient.android.common.k.g.a(this.f6716c, 2.0f));
        }
        if (!TextUtils.isEmpty(a2) && a2.contains("/image")) {
            a2 = i.g() + a2.substring(a2.indexOf("/image", 1));
            com.bumptech.glide.d<String> a3 = com.bumptech.glide.i.b(this.f6716c).a(a2);
            a3.b(R.drawable.default_poster_thumb);
            a3.a(R.drawable.default_poster_thumb);
            a3.a(imageView);
        } else {
            com.bumptech.glide.d<Integer> a4 = com.bumptech.glide.i.b(this.f6716c).a(Integer.valueOf(R.drawable.default_poster_thumb));
            a4.b(R.drawable.default_poster_thumb);
            a4.a(R.drawable.default_poster_thumb);
            a4.a(imageView);
        }
        LogEx.d("HomeCustomColumnAdapter", "Image url=" + a2);
        textView2.setVisibility(8);
        com.zte.iptvclient.android.mobile.e0.f.i.a(commonVideoBean.l(), false, imageView3, false);
        b0Var.f1492a.setOnClickListener(new a(i, commonVideoBean));
    }
}
