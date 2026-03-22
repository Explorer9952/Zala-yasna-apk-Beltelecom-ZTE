package com.zte.iptvclient.android.mobile.e0.d;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.i;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import com.zte.iptvclient.android.common.k.u;
import com.zte.iptvclient.android.mobile.vod.videofilter.ui.VideoFilterMultiSelectHeadView;
import com.zte.iptvclient.android.zala.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: AdapterRecyclerViewVideo.java */
/* loaded from: classes2.dex */
public class d extends RecyclerView.g<RecyclerView.b0> {

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<CommonVideoBean> f5807c;

    /* renamed from: d, reason: collision with root package name */
    private VideoFilterMultiSelectHeadView f5808d;
    private Activity e;

    /* compiled from: AdapterRecyclerViewVideo.java */
    /* loaded from: classes2.dex */
    public static class a extends RecyclerView.b0 {
        private TextView A;
        private WeakReference<Activity> B;
        int C;
        private ImageView t;
        private ImageView u;
        private TextView v;
        private RelativeLayout w;
        private LinearLayout x;
        private TextView y;
        private ImageView z;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AdapterRecyclerViewVideo.java */
        /* renamed from: com.zte.iptvclient.android.mobile.e0.d.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class ViewOnClickListenerC0221a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CommonVideoBean f5809a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Activity f5810b;

            ViewOnClickListenerC0221a(a aVar, CommonVideoBean commonVideoBean, Activity activity) {
                this.f5809a = commonVideoBean;
                this.f5810b = activity;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                String f = this.f5809a.f();
                if (TextUtils.isEmpty(f)) {
                    return;
                }
                LogEx.d("AdapterRecyclerViewVideo", "programtype = " + f);
                if (f.equals("1")) {
                    u.c(this.f5810b, this.f5809a.d(), this.f5809a.a());
                    return;
                }
                if (f.equals("14")) {
                    u.a(this.f5810b, this.f5809a.d(), this.f5809a.a());
                } else if (f.equals("10")) {
                    u.a(this.f5810b, this.f5809a.i(), this.f5809a.a(), this.f5809a.h());
                }
            }
        }

        public a(Activity activity, View view) {
            super(view);
            com.zte.iptvclient.android.common.i.a.a.a(R.string.series_updated_all_hint);
            com.zte.iptvclient.android.common.i.a.a.a(R.string.series_update_hint);
            this.B = new WeakReference<>(activity);
            this.x = (LinearLayout) view.findViewById(R.id.ll_poster);
            this.w = (RelativeLayout) view.findViewById(R.id.img_rlayout);
            this.t = (ImageView) view.findViewById(R.id.poster_img);
            this.u = (ImageView) view.findViewById(R.id.ivi_logo_top);
            this.v = (TextView) view.findViewById(R.id.title_txt);
            this.y = (TextView) view.findViewById(R.id.series_lastupdate_txt);
            this.z = (ImageView) view.findViewById(R.id.img_pay_free);
            this.A = (TextView) view.findViewById(R.id.short_title);
            this.C = BaseApp.f() ? 9 : 3;
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

        public void a(CommonVideoBean commonVideoBean) {
            if (commonVideoBean != null) {
                String c2 = commonVideoBean.c();
                if (!TextUtils.isEmpty(c2)) {
                    c2 = com.zte.iptvclient.android.common.k.g.a(this.C, c2);
                }
                Activity activity = this.B.get();
                if (activity != null && !activity.isFinishing()) {
                    com.bumptech.glide.d<String> a2 = i.a(activity).a(c2);
                    a2.b(R.drawable.default_poster_thumb);
                    a2.a(R.drawable.default_poster_thumb);
                    a2.c(300);
                    a2.a(this.t);
                    if (commonVideoBean.b().equals("ivi")) {
                        this.u.setVisibility(0);
                        this.u.setImageDrawable(activity.getResources().getDrawable(R.drawable.ivi_logo));
                    } else if (commonVideoBean.b().equals("Megogo")) {
                        this.u.setVisibility(0);
                        this.u.setImageDrawable(activity.getResources().getDrawable(R.drawable.megogo_logo));
                    } else {
                        this.u.setVisibility(8);
                    }
                }
                this.v.setText(commonVideoBean.e());
                this.A.setText(commonVideoBean.j());
                this.y.setVisibility(4);
                com.zte.iptvclient.android.mobile.e0.f.i.a(commonVideoBean.l(), false, this.z, false);
                this.x.setOnClickListener(new ViewOnClickListenerC0221a(this, commonVideoBean, activity));
            }
        }
    }

    /* compiled from: AdapterRecyclerViewVideo.java */
    /* loaded from: classes2.dex */
    public class b extends RecyclerView.b0 {
        private View t;
        private LinearLayout u;
        private ImageView v;
        private TextView w;

        public b(d dVar, View view) {
            super(view);
            this.t = view;
            view.setVisibility(8);
            this.u = (LinearLayout) view.findViewById(R.id.ll_no_more);
            this.v = (ImageView) view.findViewById(R.id.img_no_more);
            this.w = (TextView) view.findViewById(R.id.txt_no_more);
            com.zte.iptvclient.common.uiframe.f.a(this.u);
            com.zte.iptvclient.common.uiframe.f.a(this.v);
            com.zte.iptvclient.common.uiframe.f.a(this.w);
            this.u.setVisibility(8);
        }
    }

    /* compiled from: AdapterRecyclerViewVideo.java */
    /* loaded from: classes2.dex */
    public class c extends RecyclerView.b0 {
        public c(d dVar, View view) {
            super(view);
        }
    }

    public d(Activity activity, ArrayList<CommonVideoBean> arrayList) {
        this.f5807c = arrayList;
        this.e = activity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        if (this.f5808d == null) {
            return this.f5807c.size() + 1;
        }
        return this.f5807c.size() + 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long a(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.b0 b(ViewGroup viewGroup, int i) {
        LogEx.d("AdapterRecyclerViewVideo", "--onCreateViewHolder-- viewType: " + i);
        if (i == 0) {
            return new c(this, this.f5808d);
        }
        if (i == 2) {
            return new b(this, LayoutInflater.from(this.e).inflate(R.layout.no_content_layout, (ViewGroup) null));
        }
        Activity activity = this.e;
        return new a(activity, LayoutInflater.from(activity).inflate(R.layout.video_poster_item, (ViewGroup) null));
    }

    public void b(boolean z) {
    }

    public boolean e(int i) {
        return i == a() - 1;
    }

    public boolean f(int i) {
        return i == 0 && this.f5808d != null;
    }

    public void a(VideoFilterMultiSelectHeadView videoFilterMultiSelectHeadView) {
        this.f5808d = videoFilterMultiSelectHeadView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void b(RecyclerView.b0 b0Var, int i) {
        ArrayList<CommonVideoBean> arrayList;
        LogEx.d("AdapterRecyclerViewVideo", "--onBindViewHolder-- position: " + i);
        if (b(i) == 1) {
            a aVar = (a) b0Var;
            if (this.f5808d != null) {
                arrayList = this.f5807c;
                i--;
            } else {
                arrayList = this.f5807c;
            }
            aVar.a(arrayList.get(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int b(int i) {
        if (f(i)) {
            return 0;
        }
        return e(i) ? 2 : 1;
    }
}
