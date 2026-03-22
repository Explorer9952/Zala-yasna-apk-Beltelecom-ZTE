package com.zte.iptvclient.android.mobile.tvhistory.ui;

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

/* loaded from: classes2.dex */
public class HistorySubView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private TextView f7314a;

    /* renamed from: b, reason: collision with root package name */
    private ScrollGridView f7315b;

    /* renamed from: c, reason: collision with root package name */
    private ScrollListView f7316c;

    /* renamed from: d, reason: collision with root package name */
    private com.zte.iptvclient.android.mobile.b0.a.a f7317d;
    private c e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (HistorySubView.this.f7317d == null || HistorySubView.this.e == null) {
                return;
            }
            HistorySubView.this.e.a(HistorySubView.this.f7317d.d().get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (HistorySubView.this.f7317d == null || HistorySubView.this.e == null) {
                return;
            }
            HistorySubView.this.e.a(HistorySubView.this.f7317d.d().get(i));
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(i iVar);
    }

    public HistorySubView(Context context) {
        super(context);
        a(context);
    }

    private void e() {
        this.f7316c.setOnItemClickListener(new a());
        this.f7315b.setOnItemClickListener(new b());
    }

    public List<i> c() {
        return this.f7317d.c();
    }

    public void d() {
        this.f7317d.e();
    }

    private void a(Context context) {
        a(View.inflate(context, R.layout.layout_view_history, this), context);
        e();
    }

    public int b() {
        com.zte.iptvclient.android.mobile.b0.a.a aVar = this.f7317d;
        if (aVar != null) {
            return aVar.b();
        }
        return 0;
    }

    public HistorySubView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public HistorySubView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(View view, Context context) {
        this.f7314a = (TextView) view.findViewById(R.id.text_time);
        this.f7315b = (ScrollGridView) view.findViewById(R.id.history_grid_view);
        this.f7316c = (ScrollListView) view.findViewById(R.id.history_list_view);
        f.a(this.f7314a);
        f.a(view.findViewById(R.id.line));
    }

    public void a(com.zte.iptvclient.android.mobile.b0.b.a aVar, List<i> list, String str) {
        if (this.f7317d == null) {
            this.f7317d = new com.zte.iptvclient.android.mobile.b0.a.a(aVar, list);
        }
        this.f7316c.setAdapter((ListAdapter) this.f7317d);
        this.f7316c.setVisibility(0);
        this.f7315b.setVisibility(8);
        this.f7314a.setText(str);
    }

    public void a(List<i> list, String str) {
        this.f7314a.setText(str);
        if (list != null && list.size() > 0) {
            this.f7314a.setVisibility(0);
        } else {
            this.f7314a.setVisibility(8);
        }
        com.zte.iptvclient.android.mobile.b0.a.a aVar = this.f7317d;
        if (aVar != null) {
            aVar.a(list);
            this.f7317d.notifyDataSetChanged();
        }
    }

    public void a(boolean z) {
        this.f7317d.a(z);
    }

    public void a() {
        this.f7317d.a();
    }
}
