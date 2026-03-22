package com.zte.iptvclient.android.mobile.a0.a;

import android.app.Activity;
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
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;

/* compiled from: AdapterTvLock.java */
/* loaded from: classes2.dex */
public class b extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    Activity f5308a;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<Channel> f5309b;

    /* renamed from: c, reason: collision with root package name */
    ArrayList<Boolean> f5310c;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<Boolean> f5311d;
    LayoutInflater e;
    Fragment g;
    private SupportActivity i;
    int f = 0;
    private boolean h = false;

    /* compiled from: AdapterTvLock.java */
    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5312a;

        a(int i) {
            this.f5312a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.h) {
                if (b.this.f5310c.get(this.f5312a).booleanValue()) {
                    b.this.f5310c.set(this.f5312a, false);
                    b bVar = b.this;
                    bVar.f--;
                    bVar.notifyDataSetChanged();
                } else {
                    b.this.f5310c.set(this.f5312a, true);
                    b bVar2 = b.this;
                    bVar2.f++;
                    bVar2.notifyDataSetChanged();
                }
            }
            b bVar3 = b.this;
            com.zte.iptvclient.android.mobile.a0.b.c cVar = (com.zte.iptvclient.android.mobile.a0.b.c) bVar3.g;
            if (bVar3.f > 0) {
                if (cVar != null) {
                    cVar.I();
                }
            } else if (cVar != null) {
                cVar.L();
            }
        }
    }

    /* compiled from: AdapterTvLock.java */
    /* renamed from: com.zte.iptvclient.android.mobile.a0.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0169b {

        /* renamed from: a, reason: collision with root package name */
        ImageView f5314a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f5315b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f5316c;

        /* renamed from: d, reason: collision with root package name */
        TextView f5317d;
        LinearLayout e;
        RelativeLayout f;
        LinearLayout g;

        private C0169b() {
        }

        /* synthetic */ C0169b(a aVar) {
            this();
        }
    }

    public b(Activity activity, ArrayList<Channel> arrayList, ArrayList<Boolean> arrayList2, ArrayList<Boolean> arrayList3, Fragment fragment) {
        this.f5309b = arrayList;
        this.f5310c = arrayList2;
        this.f5308a = activity;
        this.g = fragment;
        this.f5311d = arrayList3;
        this.e = (LayoutInflater) activity.getSystemService("layout_inflater");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f5309b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f5309b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C0169b c0169b;
        if (view == null) {
            c0169b = new C0169b(null);
            view2 = this.e.inflate(R.layout.lock_tvchannel_item, (ViewGroup) null);
            c0169b.f5315b = (ImageView) view2.findViewById(R.id.tv_lock_selector);
            c0169b.f5316c = (ImageView) view2.findViewById(R.id.lock_img);
            c0169b.f5314a = (ImageView) view2.findViewById(R.id.tv_lock_icon);
            c0169b.f5317d = (TextView) view2.findViewById(R.id.lock_tv_name);
            c0169b.e = (LinearLayout) view2.findViewById(R.id.tv_lock_rightll);
            c0169b.f = (RelativeLayout) view2.findViewById(R.id.tv_lock_contentll);
            c0169b.g = (LinearLayout) view2.findViewById(R.id.ll_tv_lock_item);
            f.a(c0169b.e);
            f.a(c0169b.f);
            f.a(c0169b.g);
            f.a(c0169b.f5315b);
            f.a(c0169b.f5316c);
            f.a(c0169b.f5314a);
            f.a(c0169b.f5317d);
            view2.setTag(c0169b);
        } else {
            view2 = view;
            c0169b = (C0169b) view.getTag();
        }
        c0169b.g.setOnClickListener(new a(i));
        String posterimage = this.f5309b.get(i).getPosterimage();
        if (!TextUtils.isEmpty(posterimage)) {
            int indexOf = posterimage.indexOf("/image", 1);
            posterimage = i.g() + posterimage.substring(indexOf);
            LogEx.d("USee", "AdapterMovie image url = " + posterimage);
        }
        Activity activity = this.f5308a;
        if (activity != null && !activity.isFinishing()) {
            com.bumptech.glide.d<String> a2 = com.bumptech.glide.i.a(this.f5308a).a(posterimage);
            a2.b(R.drawable.default_tv_logo);
            a2.a(R.drawable.default_tv_logo);
            a2.c(300);
            a2.a(c0169b.f5314a);
        }
        c0169b.f5317d.setText(this.f5309b.get(i).getChannelname());
        if (this.h) {
            c0169b.f5315b.setVisibility(0);
        } else {
            c0169b.f5315b.setVisibility(8);
        }
        if (this.f5310c.get(i).booleanValue()) {
            c0169b.f5315b.setImageResource(R.drawable.select);
        } else {
            c0169b.f5315b.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.unselect));
            SupportActivity supportActivity = this.i;
            if (supportActivity != null) {
                supportActivity.a(c0169b.f5315b, "background", R.drawable.unselect);
            }
        }
        if (this.f5311d.get(i).booleanValue()) {
            c0169b.f5316c.setVisibility(0);
        } else {
            c0169b.f5316c.setVisibility(4);
        }
        return view2;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void a() {
        this.f = 0;
    }
}
