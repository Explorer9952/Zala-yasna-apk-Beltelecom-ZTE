package com.zte.iptvclient.android.mobile.v.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.d;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;

/* compiled from: SearchKeyWordHistoryAdapter.java */
/* loaded from: classes2.dex */
public class c extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private LayoutInflater f7500a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<String> f7501b;

    /* renamed from: c, reason: collision with root package name */
    private SupportActivity f7502c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7503d = false;
    private boolean e = false;

    /* compiled from: SearchKeyWordHistoryAdapter.java */
    /* loaded from: classes2.dex */
    private static class b extends d {

        /* renamed from: a, reason: collision with root package name */
        TextView f7504a;

        private b() {
        }
    }

    public c(Context context, ArrayList<String> arrayList) {
        this.f7500a = null;
        this.f7500a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f7501b = arrayList;
    }

    public void a(boolean z) {
        this.f7503d = z;
    }

    public void b(boolean z) {
        this.e = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f7501b.size() == 0) {
            return 0;
        }
        if (this.f7501b.size() % 2 == 0) {
            if (this.f7501b.size() > 8) {
                if (!this.f7503d) {
                    return 8;
                }
                if (this.f7501b.size() > 10) {
                    return 10;
                }
                return this.f7501b.size();
            }
            return this.f7501b.size();
        }
        if (this.f7501b.size() > 7) {
            if (!this.f7503d) {
                return 8;
            }
            if (this.f7501b.size() > 9) {
                return 10;
            }
            return this.f7501b.size();
        }
        return this.f7501b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = this.f7500a.inflate(R.layout.search_history_item, (ViewGroup) null);
            bVar = new b();
            TextView textView = (TextView) view.findViewById(R.id.search_history_txt01);
            bVar.f7504a = textView;
            textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.search_history));
            f.a(view.findViewById(R.id.ll_search_history_item));
            f.a(bVar.f7504a);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (i == this.f7501b.size()) {
            bVar.f7504a.setText("");
        } else {
            bVar.f7504a.setText(this.f7501b.get(i));
        }
        if (this.e) {
            bVar.f7504a.setTextColor(c.a.a.a.d.b.d().b(R.color.search_small_color));
            SupportActivity supportActivity = this.f7502c;
            if (supportActivity != null) {
                supportActivity.a(bVar.f7504a, "textColor", R.color.search_small_color);
            }
        } else {
            bVar.f7504a.setTextColor(c.a.a.a.d.b.d().b(R.color.search_most_color));
            SupportActivity supportActivity2 = this.f7502c;
            if (supportActivity2 != null) {
                supportActivity2.a(bVar.f7504a, "textColor", R.color.search_most_color);
            }
        }
        return view;
    }

    public boolean a() {
        return this.f7503d;
    }
}
