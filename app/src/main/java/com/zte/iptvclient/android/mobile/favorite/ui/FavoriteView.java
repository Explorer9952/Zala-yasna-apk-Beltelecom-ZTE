package com.zte.iptvclient.android.mobile.favorite.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zte.iptvclient.android.common.customview.view.listview.ScrollListView;
import com.zte.iptvclient.android.common.customview.viewgroup.gridview.ScrollGridView;
import com.zte.iptvclient.android.common.javabean.StbVideoBean;
import com.zte.iptvclient.android.common.javabean.models.VoDBean;
import com.zte.iptvclient.android.mobile.j.b.d;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FavoriteView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private TextView f6234a;

    /* renamed from: b, reason: collision with root package name */
    private ScrollGridView f6235b;

    /* renamed from: c, reason: collision with root package name */
    private ScrollListView f6236c;

    /* renamed from: d, reason: collision with root package name */
    private com.zte.iptvclient.android.mobile.j.a.a f6237d;
    private com.zte.iptvclient.android.mobile.j.a.b e;
    private c f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (FavoriteView.this.e == null || FavoriteView.this.f == null) {
                return;
            }
            FavoriteView.this.f.a(FavoriteView.this.e.a().get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (FavoriteView.this.e == null || FavoriteView.this.f == null) {
                return;
            }
            FavoriteView.this.f.a(FavoriteView.this.e.a().get(i));
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(StbVideoBean stbVideoBean);
    }

    public FavoriteView(Context context) {
        super(context);
        a(context);
    }

    private void c() {
        this.f6236c.setOnItemClickListener(new a());
        this.f6235b.setOnItemClickListener(new b());
    }

    private void a(Context context) {
        a(View.inflate(context, R.layout.favorite_view_layout, this), context);
        c();
    }

    public void b(ArrayList<StbVideoBean> arrayList, String str) {
        this.f6234a.setText(str);
        if (arrayList != null && arrayList.size() > 0) {
            this.f6234a.setVisibility(0);
        } else {
            this.f6234a.setVisibility(8);
        }
        com.zte.iptvclient.android.mobile.j.a.b bVar = this.e;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public FavoriteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public FavoriteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(View view, Context context) {
        this.f6234a = (TextView) view.findViewById(R.id.text_time);
        this.f6235b = (ScrollGridView) view.findViewById(R.id.favorite_grid_view);
        this.f6236c = (ScrollListView) view.findViewById(R.id.favorite_list_view);
        f.a(this.f6234a);
        f.a(view.findViewById(R.id.line));
    }

    public void b(boolean z) {
        this.f6237d.a(z);
    }

    public ArrayList<VoDBean> b() {
        return this.f6237d.c();
    }

    public void a(com.zte.iptvclient.android.mobile.j.b.b bVar, ArrayList<VoDBean> arrayList, String str, boolean z) {
        if (this.f6237d == null) {
            this.f6237d = new com.zte.iptvclient.android.mobile.j.a.a(bVar, arrayList, z);
        }
        this.f6237d.b(z);
        if (z) {
            this.f6235b.setAdapter((ListAdapter) this.f6237d);
            this.f6235b.setVisibility(0);
            this.f6236c.setVisibility(8);
        } else {
            this.f6236c.setAdapter((ListAdapter) this.f6237d);
            this.f6236c.setVisibility(0);
            this.f6235b.setVisibility(8);
        }
        this.f6237d.notifyDataSetChanged();
    }

    public void a(d dVar, ArrayList<StbVideoBean> arrayList, String str, boolean z) {
        com.zte.iptvclient.android.mobile.j.a.b bVar = new com.zte.iptvclient.android.mobile.j.a.b(dVar, arrayList, z);
        this.e = bVar;
        if (z) {
            this.f6235b.setAdapter((ListAdapter) bVar);
            this.f6235b.setVisibility(0);
            this.f6236c.setVisibility(8);
        } else {
            this.f6236c.setAdapter((ListAdapter) bVar);
            this.f6236c.setVisibility(0);
            this.f6235b.setVisibility(8);
        }
    }

    public void a(ArrayList<VoDBean> arrayList, String str) {
        this.f6234a.setText(str);
        if (arrayList != null && arrayList.size() > 0) {
            this.f6234a.setVisibility(0);
        } else {
            this.f6234a.setVisibility(8);
        }
        com.zte.iptvclient.android.mobile.j.a.a aVar = this.f6237d;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void a(boolean z) {
        if (z) {
            this.f6237d.d();
        } else {
            this.f6237d.b();
        }
    }

    public void a() {
        this.f6237d.a();
    }

    public void a(c cVar) {
        this.f = cVar;
    }
}
