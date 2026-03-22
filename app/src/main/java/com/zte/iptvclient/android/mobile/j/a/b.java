package com.zte.iptvclient.android.mobile.j.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.javabean.StbVideoBean;
import com.zte.iptvclient.android.mobile.j.b.d;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;

/* compiled from: AdapterStbFavorite.java */
/* loaded from: classes.dex */
public class b extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<StbVideoBean> f6609a;

    /* renamed from: b, reason: collision with root package name */
    private d f6610b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f6611c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6612d;

    /* compiled from: AdapterStbFavorite.java */
    /* renamed from: com.zte.iptvclient.android.mobile.j.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0284b {

        /* renamed from: a, reason: collision with root package name */
        ImageView f6613a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f6614b;

        /* renamed from: c, reason: collision with root package name */
        TextView f6615c;

        /* renamed from: d, reason: collision with root package name */
        TextView f6616d;
        ImageView e;

        private C0284b() {
        }
    }

    public b(d dVar, ArrayList<StbVideoBean> arrayList, boolean z) {
        this.f6612d = true;
        this.f6609a = arrayList;
        this.f6610b = dVar;
        this.f6612d = z;
        if (dVar.getActivity() != null) {
            this.f6611c = (LayoutInflater) dVar.getActivity().getSystemService("layout_inflater");
        }
    }

    public ArrayList<StbVideoBean> a() {
        return this.f6609a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<StbVideoBean> arrayList = this.f6609a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<StbVideoBean> arrayList = this.f6609a;
        if (arrayList != null && arrayList.size() > i) {
            return this.f6609a.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C0284b c0284b;
        String posterfileList;
        if (view == null) {
            c0284b = new C0284b();
            if (this.f6612d) {
                view2 = this.f6611c.inflate(R.layout.vod_favorite_stb_item, (ViewGroup) null);
                c0284b.f6613a = (ImageView) view2.findViewById(R.id.poster_img);
                c0284b.f6614b = (ImageView) view2.findViewById(R.id.img_corner);
                c0284b.f6615c = (TextView) view2.findViewById(R.id.title_txt);
                f.a(c0284b.f6613a);
                f.a(c0284b.f6614b);
                f.a(c0284b.f6615c);
                f.a(view2.findViewById(R.id.rl_img));
                f.a(view2.findViewById(R.id.ll_video_item));
            } else {
                view2 = this.f6611c.inflate(R.layout.favorite_list_item, (ViewGroup) null);
                c0284b.f6616d = (TextView) view2.findViewById(R.id.txt_name);
                c0284b.e = (ImageView) view2.findViewById(R.id.img_select);
                f.a(c0284b.f6616d);
                f.a(c0284b.e);
            }
            view2.setTag(c0284b);
        } else {
            view2 = view;
            c0284b = (C0284b) view.getTag();
        }
        if (this.f6612d) {
            if (!StringUtil.isEmptyString(this.f6609a.get(i).getContentname())) {
                c0284b.f6615c.setText(this.f6609a.get(i).getContentname());
            } else {
                c0284b.f6615c.setText("");
            }
            if (!StringUtil.isEmptyString(this.f6609a.get(i).getPosterurl())) {
                posterfileList = this.f6609a.get(i).getPosterurl();
            } else {
                posterfileList = this.f6609a.get(i).getPosterfileList();
                if (!StringUtil.isEmptyString(posterfileList)) {
                    String[] split = posterfileList.split(";");
                    if (!TextUtils.isEmpty(posterfileList)) {
                        String g = i.g();
                        if (split.length > 3) {
                            posterfileList = g + "/images/poster/" + split[3];
                        }
                    }
                }
            }
            LogEx.d("AdapterStbFavorite", "AdapterFavorite image url = " + posterfileList);
            d dVar = this.f6610b;
            if (dVar != null && dVar.getActivity() != null && !this.f6610b.getActivity().isFinishing()) {
                com.bumptech.glide.d<String> a2 = com.bumptech.glide.i.a(this.f6610b).a(posterfileList);
                a2.a(R.drawable.default_poster_thumb);
                a2.c(300);
                a2.a(c0284b.f6613a);
            }
        } else if (!StringUtil.isEmptyString(this.f6609a.get(i).getContentname())) {
            c0284b.f6616d.setText(this.f6609a.get(i).getContentname());
        } else {
            c0284b.f6616d.setText("");
        }
        return view2;
    }
}
