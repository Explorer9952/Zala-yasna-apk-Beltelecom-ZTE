package com.zte.iptvclient.android.mobile.e0.d;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.i;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;

/* compiled from: AdapterDynimicMoreVideo.java */
/* loaded from: classes2.dex */
public class a extends BaseAdapter {

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<CommonVideoBean> f5792b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f5793c;

    /* renamed from: d, reason: collision with root package name */
    private Context f5794d;

    /* renamed from: a, reason: collision with root package name */
    private String f5791a = "AdapterVideoNew";
    private boolean e = false;

    /* compiled from: AdapterDynimicMoreVideo.java */
    /* renamed from: com.zte.iptvclient.android.mobile.e0.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0217a {

        /* renamed from: a, reason: collision with root package name */
        ImageView f5795a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f5796b;

        /* renamed from: c, reason: collision with root package name */
        TextView f5797c;

        /* renamed from: d, reason: collision with root package name */
        RelativeLayout f5798d;
        ConstraintLayout e;
        ImageView f;
        TextView g;

        public C0217a(a aVar) {
            aVar.e = "1".equals(ConfigMgr.readPropertie("IsShowBlockTitle"));
        }
    }

    public a(Context context, ArrayList<CommonVideoBean> arrayList) {
        this.f5792b = arrayList;
        this.f5794d = context;
        this.f5793c = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<CommonVideoBean> arrayList = this.f5792b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f5792b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C0217a c0217a;
        if (view == null) {
            c0217a = new C0217a(this);
            view2 = this.f5793c.inflate(R.layout.home_video_more_item, (ViewGroup) null);
            c0217a.f5795a = (ImageView) view2.findViewById(R.id.poster_img);
            c0217a.f5796b = (ImageView) view2.findViewById(R.id.ivi_logo_top);
            c0217a.f5797c = (TextView) view2.findViewById(R.id.title_txt);
            c0217a.f5798d = (RelativeLayout) view2.findViewById(R.id.img_rlayout);
            c0217a.e = (ConstraintLayout) view2.findViewById(R.id.home_video_item_cl);
            c0217a.f = (ImageView) view2.findViewById(R.id.img_corner);
            c0217a.g = (TextView) view2.findViewById(R.id.title_txt_fu);
            int a2 = com.zte.iptvclient.android.common.k.g.a(this.f5794d, 3.0f);
            c0217a.f5797c.setPadding(a2, a2, 0, a2);
            c0217a.f5797c.setPaddingRelative(a2, a2, 0, a2);
            com.zte.iptvclient.common.uiframe.f.a(c0217a.e);
            com.zte.iptvclient.common.uiframe.f.a(c0217a.f5798d);
            com.zte.iptvclient.common.uiframe.f.a(c0217a.f5795a);
            com.zte.iptvclient.common.uiframe.f.a(c0217a.f5797c);
            com.zte.iptvclient.common.uiframe.f.a(c0217a.f);
            com.zte.iptvclient.common.uiframe.f.a(c0217a.g);
            com.zte.iptvclient.common.uiframe.f.a(c0217a.f5796b);
            view2.setTag(c0217a);
        } else {
            view2 = view;
            c0217a = (C0217a) view.getTag();
        }
        com.zte.iptvclient.android.mobile.e0.f.g.a(c0217a.g);
        CommonVideoBean commonVideoBean = (CommonVideoBean) getItem(i);
        if (commonVideoBean != null) {
            LogEx.d(this.f5791a, " ---------####current postion : " + i);
            String a3 = com.zte.iptvclient.android.common.k.g.a(BaseApp.a(this.f5794d) ? 9 : 3, commonVideoBean.c());
            Context context = this.f5794d;
            if (context != null && !((Activity) context).isFinishing()) {
                com.bumptech.glide.d<String> a4 = i.b(this.f5794d).a(a3);
                a4.b(164, 235);
                a4.b(R.drawable.default_poster_thumb);
                a4.a(R.drawable.default_poster_thumb);
                a4.c(300);
                a4.a(c0217a.f5795a);
            }
            if (this.e && com.zte.iptvclient.android.mobile.f.b.a.a(commonVideoBean.g(), this.f5794d)) {
                c0217a.f5797c.setText(R.string.common_blocktitle);
            } else {
                c0217a.f5797c.setText(commonVideoBean.e());
                c0217a.g.setText(commonVideoBean.j());
            }
            int b2 = com.zte.iptvclient.android.common.k.g.b(commonVideoBean.l());
            if (b2 == 1) {
                c0217a.f.setVisibility(0);
                c0217a.f.setImageResource(R.drawable.free);
            } else if (b2 == 2) {
                c0217a.f.setVisibility(0);
                c0217a.f.setImageResource(R.drawable.pay);
            } else {
                c0217a.f.setVisibility(8);
            }
            if (commonVideoBean.b().equals("ivi")) {
                c0217a.f5796b.setVisibility(0);
                Context context2 = this.f5794d;
                if (context2 != null) {
                    c0217a.f5796b.setImageDrawable(context2.getResources().getDrawable(R.drawable.ivi_logo));
                }
            } else if (commonVideoBean.b().equals("Megogo")) {
                c0217a.f5796b.setVisibility(0);
                Context context3 = this.f5794d;
                if (context3 != null) {
                    c0217a.f5796b.setImageDrawable(context3.getResources().getDrawable(R.drawable.megogo_logo));
                }
            } else {
                c0217a.f5796b.setVisibility(8);
            }
        }
        return view2;
    }
}
