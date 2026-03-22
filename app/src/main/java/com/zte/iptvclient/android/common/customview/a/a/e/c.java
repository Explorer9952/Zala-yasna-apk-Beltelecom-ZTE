package com.zte.iptvclient.android.common.customview.a.a.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.video.androidsdk.common.GlobalConst;
import com.zte.iptvclient.android.common.javabean.models.MultiDefinitionURLBean;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;

/* compiled from: AudoListAdapter.java */
/* loaded from: classes.dex */
public class c extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<VideoDetailBean> f4230a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<MultiDefinitionURLBean> f4231b;

    /* renamed from: c, reason: collision with root package name */
    private Context f4232c;

    /* compiled from: AudoListAdapter.java */
    /* loaded from: classes.dex */
    private static class b extends com.zte.iptvclient.common.uiframe.d {

        /* renamed from: a, reason: collision with root package name */
        LinearLayout f4233a;

        /* renamed from: b, reason: collision with root package name */
        TextView f4234b;

        private b() {
        }
    }

    public c(Context context, ArrayList<VideoDetailBean> arrayList, ArrayList<MultiDefinitionURLBean> arrayList2) {
        this.f4230a = arrayList;
        this.f4231b = arrayList2;
        this.f4232c = context;
    }

    private String a(String str) {
        if ("1".equals(str)) {
            return this.f4232c.getResources().getString(R.string.SD);
        }
        if ("2".equals(str)) {
            return this.f4232c.getResources().getString(R.string.play_vedio_type_sd_h);
        }
        if ("4".equals(str)) {
            return this.f4232c.getResources().getString(R.string.HD);
        }
        return "8".equals(str) ? "4K" : GlobalConst.WINPHONE_CLIENT.equals(str) ? "720P" : GlobalConst.ANDRIODSTB_CLIENT.equals(str) ? "1280P" : "";
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<VideoDetailBean> arrayList = this.f4230a;
        if (arrayList == null) {
            return this.f4231b.size();
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<VideoDetailBean> arrayList = this.f4230a;
        if (arrayList == null) {
            return this.f4231b.get(i);
        }
        return arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        LayoutInflater layoutInflater = (LayoutInflater) this.f4232c.getSystemService("layout_inflater");
        if (view == null) {
            view = layoutInflater.inflate(R.layout.audo_item, (ViewGroup) null);
            bVar = new b();
            bVar.f4233a = (LinearLayout) view.findViewById(R.id.ll_audo);
            bVar.f4234b = (TextView) view.findViewById(R.id.txt_audo);
            com.zte.iptvclient.common.uiframe.f.a(bVar.f4233a);
            com.zte.iptvclient.common.uiframe.f.a(bVar.f4234b);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        ArrayList<VideoDetailBean> arrayList = this.f4230a;
        if (arrayList != null) {
            if (arrayList.get(i).getAuth_returncode().equals("0")) {
                bVar.f4234b.setText(this.f4232c.getResources().getString(R.string.video_detail_popup_watch) + " " + a(this.f4230a.get(i).getDefinition()));
            } else {
                bVar.f4234b.setText(this.f4232c.getResources().getString(R.string.detail_movie_buy) + " " + a(this.f4230a.get(i).getDefinition()));
            }
            if (TextUtils.equals(this.f4230a.get(i).getVideotype(), "20")) {
                bVar.f4234b.setText(this.f4232c.getResources().getString(R.string.video_detail_popup_watch) + " " + a(this.f4230a.get(i).getDefinition()));
            }
        } else if (this.f4231b.get(i).a().equals("0")) {
            bVar.f4234b.setText(this.f4232c.getResources().getString(R.string.video_detail_popup_watch) + " " + a(this.f4231b.get(i).f()));
        } else {
            bVar.f4234b.setText(this.f4232c.getResources().getString(R.string.detail_movie_buy) + " " + a(this.f4231b.get(i).f()));
        }
        return view;
    }
}
