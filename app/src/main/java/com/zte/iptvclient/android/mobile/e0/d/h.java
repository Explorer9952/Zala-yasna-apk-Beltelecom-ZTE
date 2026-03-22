package com.zte.iptvclient.android.mobile.e0.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;

/* compiled from: RecommendAdapterVideo.java */
/* loaded from: classes2.dex */
public class h extends BaseAdapter {

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<CommonVideoBean> f5829b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f5830c;

    /* renamed from: d, reason: collision with root package name */
    private String f5831d;
    private Context e;

    /* renamed from: a, reason: collision with root package name */
    private String f5828a = "AdapterVideoColumn";
    private boolean f = false;

    /* compiled from: RecommendAdapterVideo.java */
    /* loaded from: classes2.dex */
    class a {

        /* renamed from: a, reason: collision with root package name */
        ImageView f5832a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f5833b;

        /* renamed from: c, reason: collision with root package name */
        TextView f5834c;

        /* renamed from: d, reason: collision with root package name */
        RelativeLayout f5835d;

        public a(h hVar) {
            hVar.f = "1".equals(ConfigMgr.readPropertie("IsShowBlockTitle"));
        }
    }

    public h(Context context, ArrayList<CommonVideoBean> arrayList) {
        this.f5831d = "";
        this.f5829b = arrayList;
        this.e = context;
        this.f5831d = i.g();
        this.f5830c = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<CommonVideoBean> arrayList = this.f5829b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<CommonVideoBean> arrayList = this.f5829b;
        if (arrayList != null && arrayList.size() > i) {
            return this.f5829b.get(i);
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
        a aVar;
        String splitedString;
        if (view == null) {
            aVar = new a(this);
            view2 = this.f5830c.inflate(R.layout.video_fragment_item, (ViewGroup) null);
            aVar.f5832a = (ImageView) view2.findViewById(R.id.poster_img);
            aVar.f5833b = (ImageView) view2.findViewById(R.id.ivi_logo_top);
            aVar.f5834c = (TextView) view2.findViewById(R.id.title_txt);
            aVar.f5835d = (RelativeLayout) view2.findViewById(R.id.img_rlayout);
            com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.home_video_item_fl));
            com.zte.iptvclient.common.uiframe.f.a(aVar.f5835d);
            com.zte.iptvclient.common.uiframe.f.a(aVar.f5832a);
            com.zte.iptvclient.common.uiframe.f.a(aVar.f5833b);
            com.zte.iptvclient.common.uiframe.f.a(aVar.f5834c);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        CommonVideoBean commonVideoBean = this.f5829b.get(i);
        aVar.f5832a.setImageResource(R.drawable.default_poster_thumb);
        if (commonVideoBean != null) {
            if (commonVideoBean.b().equals("ivi")) {
                aVar.f5833b.setVisibility(0);
                aVar.f5833b.setImageDrawable(this.e.getResources().getDrawable(R.drawable.ivi_logo));
            } else if (commonVideoBean.b().equals("Megogo")) {
                aVar.f5833b.setVisibility(0);
                aVar.f5833b.setImageDrawable(this.e.getResources().getDrawable(R.drawable.megogo_logo));
            } else {
                aVar.f5833b.setVisibility(8);
            }
            if (BaseApp.a(this.e)) {
                splitedString = StringUtil.getSplitedString(this.f5829b.get(i).c(), ";", 9);
            } else {
                splitedString = StringUtil.getSplitedString(this.f5829b.get(i).c(), ";", 3);
            }
            String str = "../images/poster/" + splitedString;
            if (!TextUtils.isEmpty(str) && str.contains("/image")) {
                str = this.f5831d + str.substring(str.indexOf("/image", 1));
                LogEx.d(this.f5828a, "AdapterVideoFragment image url = " + str);
            }
            Context context = this.e;
            if (context != null && !((Activity) context).isFinishing()) {
                com.bumptech.glide.d<String> a2 = com.bumptech.glide.i.b(this.e).a(str);
                a2.b(R.drawable.default_poster_thumb);
                a2.a(R.drawable.default_poster_thumb);
                a2.c(300);
                a2.a(aVar.f5832a);
            }
            if (this.f && com.zte.iptvclient.android.mobile.f.b.a.a(commonVideoBean.g(), this.e)) {
                aVar.f5834c.setText(R.string.common_blocktitle);
            } else {
                aVar.f5834c.setText(commonVideoBean.e());
            }
        }
        return view2;
    }

    public void a(ArrayList<CommonVideoBean> arrayList) {
        this.f5829b = arrayList;
        notifyDataSetChanged();
    }
}
