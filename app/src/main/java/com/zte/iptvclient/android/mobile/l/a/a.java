package com.zte.iptvclient.android.mobile.l.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.q.j.g;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;

/* compiled from: AdapterCustomTvChannel.java */
/* loaded from: classes.dex */
public class a extends RecyclerView.g {

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f6708c;

    /* renamed from: d, reason: collision with root package name */
    private Context f6709d;
    private ArrayList<Channel> e;
    private b f;

    /* compiled from: AdapterCustomTvChannel.java */
    /* renamed from: com.zte.iptvclient.android.mobile.l.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0296a extends g<com.bumptech.glide.load.i.e.b> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f6710d;

        C0296a(a aVar, c cVar) {
            this.f6710d = cVar;
        }

        @Override // com.bumptech.glide.q.j.j
        public /* bridge */ /* synthetic */ void a(Object obj, com.bumptech.glide.q.i.c cVar) {
            a((com.bumptech.glide.load.i.e.b) obj, (com.bumptech.glide.q.i.c<? super com.bumptech.glide.load.i.e.b>) cVar);
        }

        public void a(com.bumptech.glide.load.i.e.b bVar, com.bumptech.glide.q.i.c<? super com.bumptech.glide.load.i.e.b> cVar) {
            this.f6710d.t.setImageDrawable(bVar);
        }
    }

    /* compiled from: AdapterCustomTvChannel.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(View view, int i);
    }

    /* compiled from: AdapterCustomTvChannel.java */
    /* loaded from: classes.dex */
    public class c extends RecyclerView.b0 implements View.OnClickListener {
        private ImageView t;
        private b u;

        public c(a aVar, View view, b bVar) {
            super(view);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_custom_tv_item);
            this.t = imageView;
            f.a(imageView);
            f.a(view.findViewById(R.id.rl_custom_tv_item));
            this.t.setOnClickListener(this);
            this.u = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = this.u;
            if (bVar != null) {
                bVar.a(view, i());
            }
        }
    }

    public a(Context context, ArrayList<Channel> arrayList) {
        LogEx.d("AdapterCustomTvChannel", "AdapterCustomTvChannel constructor...");
        this.f6709d = context;
        this.e = arrayList;
        this.f6708c = LayoutInflater.from(context);
    }

    public void a(b bVar) {
        this.f = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.b0 b(ViewGroup viewGroup, int i) {
        return new c(this, this.f6708c.inflate(R.layout.home_custom_tv_item, viewGroup, false), this.f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        ArrayList<Channel> arrayList = this.e;
        if (arrayList == null) {
            return 0;
        }
        int size = arrayList.size();
        if (BaseApp.a(this.f6709d)) {
            if (size <= 20) {
                return size;
            }
            return 20;
        }
        if (size <= 15) {
            return size;
        }
        return 15;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void b(RecyclerView.b0 b0Var, int i) {
        LogEx.d("AdapterCustomTvChannel", "onBindViewHolder position: " + i);
        c cVar = (c) b0Var;
        try {
            String a2 = com.zte.iptvclient.android.common.k.g.a(this.e.get(i).getPosterimage());
            if (a2 == null || TextUtils.isEmpty(a2)) {
                return;
            }
            if (a2.contains("/image")) {
                int indexOf = a2.indexOf("/image", 1);
                a2 = i.g() + a2.substring(indexOf);
            }
            LogEx.d("AdapterCustomTvChannel", "getTvUrl=" + a2);
            if (this.f6709d == null || ((Activity) this.f6709d).isFinishing()) {
                return;
            }
            com.bumptech.glide.d<String> a3 = com.bumptech.glide.i.b(this.f6709d).a(a2);
            a3.b(R.drawable.default_video_thumb);
            a3.a(R.drawable.default_video_thumb);
            a3.c(300);
            a3.a((com.bumptech.glide.d<String>) new C0296a(this, cVar));
        } catch (Exception e) {
            LogEx.d("e=", e.toString());
        }
    }
}
