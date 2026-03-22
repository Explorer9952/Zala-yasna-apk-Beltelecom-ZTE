package com.zte.iptvclient.android.mobile.e0.d;

import android.app.Activity;
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
import com.zte.iptvclient.android.common.k.u;
import com.zte.iptvclient.android.mobile.vod.entity.GetVodListItemEntity;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;

/* compiled from: AdapterVodListSubColumn.java */
/* loaded from: classes2.dex */
public class g extends RecyclerView.g<RecyclerView.b0> {

    /* renamed from: c, reason: collision with root package name */
    private Context f5822c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<GetVodListItemEntity> f5823d;
    private LayoutInflater e;
    private boolean f = false;
    private b g;

    /* compiled from: AdapterVodListSubColumn.java */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.b0 {
        private TextView A;
        int B;
        String C;
        private ImageView t;
        private ImageView u;
        private TextView v;
        private RelativeLayout w;
        private LinearLayout x;
        private TextView y;
        private ImageView z;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AdapterVodListSubColumn.java */
        /* renamed from: com.zte.iptvclient.android.mobile.e0.d.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class ViewOnClickListenerC0222a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ GetVodListItemEntity f5824a;

            ViewOnClickListenerC0222a(GetVodListItemEntity getVodListItemEntity) {
                this.f5824a = getVodListItemEntity;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                String str = this.f5824a.g;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (str.equals("1")) {
                    Activity activity = (Activity) g.this.f5822c;
                    GetVodListItemEntity getVodListItemEntity = this.f5824a;
                    u.c(activity, getVodListItemEntity.e, getVodListItemEntity.f7641c);
                } else if (str.equals("14")) {
                    Activity activity2 = (Activity) g.this.f5822c;
                    GetVodListItemEntity getVodListItemEntity2 = this.f5824a;
                    u.a(activity2, getVodListItemEntity2.e, getVodListItemEntity2.f7641c);
                } else if ("10".equals(str)) {
                    GetVodListItemEntity getVodListItemEntity3 = this.f5824a;
                    u.a((Activity) g.this.f5822c, getVodListItemEntity3.i, getVodListItemEntity3.f7641c, getVodListItemEntity3.j);
                }
            }
        }

        public a(View view) {
            super(view);
            com.zte.iptvclient.android.common.i.a.a.a(R.string.series_updated_all_hint);
            com.zte.iptvclient.android.common.i.a.a.a(R.string.series_update_hint);
            this.x = (LinearLayout) view.findViewById(R.id.ll_poster);
            this.w = (RelativeLayout) view.findViewById(R.id.img_rlayout);
            this.t = (ImageView) view.findViewById(R.id.poster_img);
            this.u = (ImageView) view.findViewById(R.id.ivi_logo_top);
            this.v = (TextView) view.findViewById(R.id.title_txt);
            this.y = (TextView) view.findViewById(R.id.series_lastupdate_txt);
            this.z = (ImageView) view.findViewById(R.id.img_pay_free);
            this.A = (TextView) view.findViewById(R.id.short_title);
            this.B = BaseApp.a(g.this.f5822c) ? 9 : 3;
            this.C = i.g();
            com.zte.iptvclient.common.uiframe.f.a(this.x);
            com.zte.iptvclient.common.uiframe.f.a(this.w);
            com.zte.iptvclient.common.uiframe.f.a(this.t);
            com.zte.iptvclient.common.uiframe.f.a(this.u);
            com.zte.iptvclient.common.uiframe.f.a(this.v);
            com.zte.iptvclient.common.uiframe.f.a(this.y);
            com.zte.iptvclient.common.uiframe.f.a(this.z);
            com.zte.iptvclient.common.uiframe.f.a(this.A);
            com.zte.iptvclient.android.mobile.e0.f.g.a(this.A);
        }

        public void a(GetVodListItemEntity getVodListItemEntity, boolean z) {
            int indexOf;
            if (getVodListItemEntity != null) {
                String a2 = com.zte.iptvclient.android.common.k.g.a(this.B, getVodListItemEntity.k);
                if (a2 != null && (indexOf = a2.indexOf("/image", 1)) > 0) {
                    a2 = this.C + a2.substring(indexOf);
                }
                if (g.this.f5822c != null) {
                    com.bumptech.glide.d<String> a3 = com.bumptech.glide.i.b(g.this.f5822c).a(a2);
                    a3.b(164, 235);
                    a3.b(R.drawable.default_poster_thumb);
                    a3.a(R.drawable.default_poster_thumb);
                    a3.c(150);
                    a3.a(this.t);
                    if (getVodListItemEntity.p.equals("ivi")) {
                        this.u.setVisibility(0);
                        this.u.setImageDrawable(g.this.f5822c.getResources().getDrawable(R.drawable.ivi_logo));
                    } else if (getVodListItemEntity.p.equals("Megogo")) {
                        this.u.setVisibility(0);
                        this.u.setImageDrawable(g.this.f5822c.getResources().getDrawable(R.drawable.megogo_logo));
                    } else {
                        this.u.setVisibility(8);
                    }
                }
                this.v.setText(getVodListItemEntity.f);
                this.A.setText(getVodListItemEntity.m);
                this.y.setVisibility(4);
                com.zte.iptvclient.android.mobile.e0.f.i.a(getVodListItemEntity.o, z, this.z, false);
                this.x.setOnClickListener(new ViewOnClickListenerC0222a(getVodListItemEntity));
            }
        }
    }

    /* compiled from: AdapterVodListSubColumn.java */
    /* loaded from: classes2.dex */
    public class b extends RecyclerView.b0 {
        private View t;

        public b(g gVar, View view) {
            super(view);
            this.t = view;
        }

        public View D() {
            return this.t;
        }
    }

    /* compiled from: AdapterVodListSubColumn.java */
    /* loaded from: classes2.dex */
    public class c extends RecyclerView.b0 {
        private ImageView t;
        private TextView u;
        private ImageView v;
        private RelativeLayout w;
        private TextView x;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AdapterVodListSubColumn.java */
        /* loaded from: classes2.dex */
        public class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ GetVodListItemEntity f5826a;

            a(GetVodListItemEntity getVodListItemEntity) {
                this.f5826a = getVodListItemEntity;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                c cVar = c.this;
                GetVodListItemEntity getVodListItemEntity = this.f5826a;
                cVar.a(getVodListItemEntity.f7641c, getVodListItemEntity.f7640b);
            }
        }

        public c(View view) {
            super(view);
            this.t = (ImageView) view.findViewById(R.id.column_img);
            this.u = (TextView) view.findViewById(R.id.column_title_txt);
            this.v = (ImageView) view.findViewById(R.id.lock_tips);
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_next_all);
            this.w = relativeLayout;
            TextView textView = (TextView) relativeLayout.findViewById(R.id.more_text);
            this.x = textView;
            textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_all));
            com.zte.iptvclient.common.uiframe.f.a(this.u);
            com.zte.iptvclient.common.uiframe.f.a(this.x);
            com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.more_icon));
            com.zte.iptvclient.android.mobile.e0.f.g.a(this.t, this.u);
            this.v.setVisibility(8);
        }

        public void a(GetVodListItemEntity getVodListItemEntity) {
            this.u.setText(getVodListItemEntity.f7640b);
            this.w.setOnClickListener(new a(getVodListItemEntity));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, String str2) {
            if (str == null || str2 == null) {
                return;
            }
            u.d((Activity) g.this.f5822c, str, str2);
        }
    }

    public g(Context context, ArrayList<GetVodListItemEntity> arrayList, String str) {
        this.f5822c = context;
        this.f5823d = arrayList;
        this.e = LayoutInflater.from(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long a(int i) {
        return i;
    }

    public void b(boolean z) {
        b bVar = this.g;
        if (bVar != null) {
            bVar.D().setVisibility(z ? 0 : 8);
        }
    }

    public int e(int i) {
        if (i >= this.f5823d.size()) {
            return -1;
        }
        return this.f5823d.get(i).q;
    }

    public boolean f(int i) {
        return i == a() - 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        ArrayList<GetVodListItemEntity> arrayList = this.f5823d;
        if (arrayList != null) {
            return arrayList.size() + 1;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int b(int i) {
        if (f(i)) {
            return 3;
        }
        return this.f5823d.get(i).f7639a ? 1 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.b0 b(ViewGroup viewGroup, int i) {
        LogEx.d("AdapterVodListSubColumn", "--onCreateViewHolder-- viewType: " + i);
        if (i == 1) {
            return new c(this.e.inflate(R.layout.pct_common_head_view_layout, (ViewGroup) null));
        }
        if (i == 2) {
            return new a(this.e.inflate(R.layout.video_poster_item, (ViewGroup) null));
        }
        b bVar = new b(this, this.e.inflate(R.layout.no_content_layout, (ViewGroup) null));
        this.g = bVar;
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void b(RecyclerView.b0 b0Var, int i) {
        LogEx.d("AdapterVodListSubColumn", "--onBindViewHolder-- position: " + i);
        int b2 = b(i);
        if (b2 == 1) {
            ((c) b0Var).a(this.f5823d.get(i));
        } else if (b2 == 2) {
            ((a) b0Var).a(this.f5823d.get(i), this.f);
        }
    }
}
