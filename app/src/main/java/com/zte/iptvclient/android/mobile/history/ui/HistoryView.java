package com.zte.iptvclient.android.mobile.history.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zte.iptvclient.android.common.customview.view.listview.ScrollListView;
import com.zte.iptvclient.android.common.customview.viewgroup.gridview.ScrollGridView;
import com.zte.iptvclient.android.common.javabean.models.i;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.List;

/* loaded from: classes.dex */
public class HistoryView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private TextView f6412a;

    /* renamed from: b, reason: collision with root package name */
    private ScrollGridView f6413b;

    /* renamed from: c, reason: collision with root package name */
    private ScrollListView f6414c;

    /* renamed from: d, reason: collision with root package name */
    private com.zte.iptvclient.android.mobile.k.a.b f6415d;
    private c e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (HistoryView.this.f6415d == null || HistoryView.this.e == null) {
                return;
            }
            HistoryView.this.e.a(HistoryView.this.f6415d.e().get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (HistoryView.this.f6415d == null || HistoryView.this.e == null) {
                return;
            }
            HistoryView.this.e.a(HistoryView.this.f6415d.e().get(i));
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(i iVar);
    }

    public HistoryView(Context context) {
        super(context);
        a(context);
    }

    private void d() {
        this.f6414c.setOnItemClickListener(new a());
        this.f6413b.setOnItemClickListener(new b());
    }

    public int c() {
        return this.f6415d.c();
    }

    private void a(Context context) {
        a(View.inflate(context, R.layout.layout_view_history, this), context);
        d();
    }

    public void b(boolean z) {
        this.f6415d.a(z);
    }

    public HistoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public boolean b() {
        return this.f6415d.b();
    }

    public HistoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(View view, Context context) {
        this.f6412a = (TextView) view.findViewById(R.id.text_time);
        this.f6413b = (ScrollGridView) view.findViewById(R.id.history_grid_view);
        this.f6414c = (ScrollListView) view.findViewById(R.id.history_list_view);
        f.a(this.f6412a);
        f.a(view.findViewById(R.id.line));
    }

    public void a(com.zte.iptvclient.android.mobile.k.b.f fVar, List<i> list, String str) {
        if (this.f6415d == null) {
            this.f6415d = new com.zte.iptvclient.android.mobile.k.a.b(fVar, list);
        }
        this.f6414c.setAdapter((ListAdapter) this.f6415d);
        this.f6414c.setVisibility(0);
        this.f6413b.setVisibility(8);
    }

    public void a(List<i> list, String str) {
        this.f6412a.setText(str);
        if (list != null && list.size() > 0) {
            this.f6412a.setVisibility(0);
        } else {
            this.f6412a.setVisibility(8);
        }
        com.zte.iptvclient.android.mobile.k.a.b bVar = this.f6415d;
        if (bVar != null) {
            bVar.a(list);
            this.f6415d.notifyDataSetChanged();
        }
    }

    public void a(boolean z) {
        if (z) {
            this.f6415d.f();
        } else {
            this.f6415d.a();
        }
    }

    public List<i> a() {
        return this.f6415d.d();
    }
}
