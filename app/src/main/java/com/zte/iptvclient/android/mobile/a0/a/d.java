package com.zte.iptvclient.android.mobile.a0.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.zte.iptvclient.android.common.customview.a.a.e.e;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: ChannelSortAdapter.java */
/* loaded from: classes2.dex */
public class d extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Context f5319a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<Channel> f5320b;

    /* compiled from: ChannelSortAdapter.java */
    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5321a;

        a(int i) {
            this.f5321a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new e(d.this.f5319a, R.style.dialog_order, d.this.f5320b, this.f5321a).a();
        }
    }

    /* compiled from: ChannelSortAdapter.java */
    /* loaded from: classes2.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        public ImageView f5323a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f5324b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f5325c;

        /* renamed from: d, reason: collision with root package name */
        private TextView f5326d;

        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    public d(Context context, ArrayList<Channel> arrayList) {
        this.f5319a = context;
        this.f5320b = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f5320b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        String posterimage = this.f5320b.get(i).getPosterimage();
        if (!TextUtils.isEmpty(posterimage)) {
            int indexOf = posterimage.indexOf("/image", 1);
            posterimage = i.g() + posterimage.substring(indexOf);
        }
        if (view == null) {
            view = View.inflate(this.f5319a, R.layout.channe_sort_listview_item, null);
            bVar = new b(null);
            bVar.f5323a = (ImageView) view.findViewById(R.id.dl_plugin_icon);
            bVar.f5324b = (ImageView) view.findViewById(R.id.dl_plugin_img);
            bVar.f5325c = (TextView) view.findViewById(R.id.dl_plugin_txt);
            bVar.f5326d = (TextView) view.findViewById(R.id.txt_mixno);
            f.a(view.findViewById(R.id.dl_plugin_icon_container));
            f.a(bVar.f5323a);
            f.a(bVar.f5324b);
            f.a(bVar.f5325c);
            f.a(bVar.f5326d);
            f.a(view.findViewById(R.id.dl_plugin_move));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        Context context = this.f5319a;
        if (context != null) {
            com.bumptech.glide.d<String> a2 = com.bumptech.glide.i.b(context).a(posterimage);
            a2.a(R.drawable.default_video_thumb);
            a2.b(126, 94);
            a2.a(bVar.f5323a);
        }
        Channel a3 = a(i);
        if (a3 != null) {
            bVar.f5325c.setText(a3.getChannelname());
            String customsort = this.f5320b.get(i).getCustomsort();
            if (customsort != null) {
                while (customsort.length() < 3) {
                    customsort = "0" + customsort;
                }
                bVar.f5326d.setText(customsort);
            }
        }
        ((ViewGroup) view).setDescendantFocusability(393216);
        bVar.f5324b.setOnClickListener(new a(i));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 1;
    }

    private Channel a(int i) {
        if (i < this.f5320b.size()) {
            return this.f5320b.get(i);
        }
        return null;
    }

    public boolean a(int i, int i2) {
        boolean z;
        Channel a2 = a(i);
        Channel a3 = a(i2);
        int indexOf = this.f5320b.indexOf(a2);
        int indexOf2 = this.f5320b.indexOf(a3);
        if (indexOf == -1 || indexOf2 == -1) {
            z = false;
        } else {
            Collections.swap(this.f5320b, indexOf, indexOf2);
            z = true;
        }
        if (z) {
            notifyDataSetChanged();
        }
        return z;
    }
}
