package com.zte.iptvclient.android.mobile.l.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.javabean.column.ColumnBean;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;

/* compiled from: ColumnSortAdapter.java */
/* loaded from: classes.dex */
public class c extends BaseAdapter implements com.zte.iptvclient.android.common.customview.viewgroup.gridview.draggridview.a {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<ColumnBean> f6711a;

    /* renamed from: b, reason: collision with root package name */
    private Context f6712b;

    /* compiled from: ColumnSortAdapter.java */
    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        public ImageView f6713a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f6714b;

        /* renamed from: c, reason: collision with root package name */
        public View f6715c;

        a() {
        }
    }

    public c(Context context, ArrayList<ColumnBean> arrayList) {
        this.f6711a = new ArrayList<>();
        this.f6712b = context;
        this.f6711a = arrayList;
    }

    @Override // com.zte.iptvclient.android.common.customview.viewgroup.gridview.draggridview.a
    public void a(int i, int i2) {
        if (i2 < this.f6711a.size()) {
            this.f6711a.add(i2, this.f6711a.remove(i));
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f6711a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f6711a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        ColumnBean columnBean = this.f6711a.get(i);
        String posterfilelist = columnBean.getPosterfilelist();
        if (!TextUtils.isEmpty(posterfilelist)) {
            String[] split = posterfilelist.split(";");
            String b2 = i.b();
            if (split.length > 3) {
                posterfilelist = b2 + "/images/poster/" + split[3];
            }
        }
        if (view == null) {
            aVar = new a();
            view2 = LayoutInflater.from(this.f6712b).inflate(R.layout.column_sort_item, (ViewGroup) null);
            aVar.f6713a = (ImageView) view2.findViewById(R.id.icon_img);
            aVar.f6714b = (TextView) view2.findViewById(R.id.name_tv);
            aVar.f6715c = view2.findViewById(R.id.item_container);
            f.a(aVar.f6713a);
            f.a(aVar.f6714b);
            f.a(aVar.f6715c);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        if (this.f6712b != null && posterfilelist != null && !posterfilelist.equalsIgnoreCase("") && !posterfilelist.equalsIgnoreCase(";")) {
            com.bumptech.glide.d<String> a2 = com.bumptech.glide.i.b(this.f6712b).a(posterfilelist);
            a2.b(R.drawable.icon_sort_default);
            a2.a(R.drawable.icon_sort_default);
            a2.c(300);
            a2.a(aVar.f6713a);
        }
        aVar.f6714b.setText(columnBean.getColumnName());
        return view2;
    }
}
