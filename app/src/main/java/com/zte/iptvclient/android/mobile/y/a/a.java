package com.zte.iptvclient.android.mobile.y.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;

/* compiled from: SearchMovieAddAdapter.java */
/* loaded from: classes2.dex */
public class a extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private SupportActivity f7791a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<VideoDetailBean> f7792b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f7793c;

    /* compiled from: SearchMovieAddAdapter.java */
    /* loaded from: classes2.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        TextView f7794a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f7795b;

        private b() {
        }
    }

    public a(SupportActivity supportActivity, ArrayList<VideoDetailBean> arrayList) {
        this.f7792b = new ArrayList<>();
        this.f7791a = supportActivity;
        this.f7792b = arrayList;
        this.f7793c = LayoutInflater.from(supportActivity);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<VideoDetailBean> arrayList = this.f7792b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<VideoDetailBean> arrayList = this.f7792b;
        if (arrayList == null) {
            return null;
        }
        return arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        if (view == null) {
            bVar = new b();
            view2 = this.f7793c.inflate(R.layout.search_movie_add, (ViewGroup) null);
            bVar.f7794a = (TextView) view2.findViewById(R.id.txt_program);
            bVar.f7795b = (ImageView) view2.findViewById(R.id.img_close);
            f.a(bVar.f7794a);
            f.a(bVar.f7795b);
            view2.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getMeasuredHeight()));
            view2.setTag(bVar);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        ArrayList<VideoDetailBean> arrayList = this.f7792b;
        if (arrayList != null && arrayList.size() > 0) {
            bVar.f7794a.setText(this.f7792b.get(i).getProgramname());
        }
        return view2;
    }
}
