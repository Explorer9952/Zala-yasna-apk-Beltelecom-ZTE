package com.zte.iptvclient.android.mobile.v.a;

import android.app.Activity;
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

/* compiled from: SearchHotKeyWordAdapter.java */
/* loaded from: classes2.dex */
public class b extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Activity f7494a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<String> f7495b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f7496c = false;

    /* renamed from: d, reason: collision with root package name */
    protected SupportActivity f7497d;

    /* compiled from: SearchHotKeyWordAdapter.java */
    /* renamed from: com.zte.iptvclient.android.mobile.v.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0368b extends d {

        /* renamed from: a, reason: collision with root package name */
        TextView f7498a;

        /* renamed from: b, reason: collision with root package name */
        TextView f7499b;

        private C0368b() {
        }
    }

    public b(Activity activity, ArrayList<String> arrayList) {
        this.f7494a = activity;
        this.f7495b = arrayList;
    }

    public void a(boolean z) {
        this.f7496c = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f7495b.size() == 0) {
            return 0;
        }
        if (this.f7495b.size() % 2 == 0) {
            if (this.f7495b.size() > 10) {
                return 10;
            }
            return this.f7495b.size();
        }
        if (this.f7495b.size() > 9) {
            return 10;
        }
        return this.f7495b.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C0368b c0368b;
        if (view == null) {
            c0368b = new C0368b();
            view2 = ((LayoutInflater) this.f7494a.getSystemService("layout_inflater")).inflate(R.layout.search_most_searched_item, (ViewGroup) null);
            c0368b.f7498a = (TextView) view2.findViewById(R.id.search_most_searched_order);
            c0368b.f7499b = (TextView) view2.findViewById(R.id.search_most_searched_txt);
            f.a(c0368b.f7498a);
            f.a(c0368b.f7499b);
            f.a(view2.findViewById(R.id.ll_search_hot_item));
            view2.setTag(c0368b);
        } else {
            view2 = view;
            c0368b = (C0368b) view.getTag();
        }
        if (i == this.f7495b.size()) {
            c0368b.f7498a.setVisibility(4);
            c0368b.f7499b.setText("");
        } else {
            c0368b.f7498a.setText((i + 1) + "");
            if (this.f7496c) {
                c0368b.f7498a.setTextColor(this.f7494a.getResources().getColor(R.color.search_small_color));
            }
            c0368b.f7498a.setBackgroundResource(R.drawable.search_hot_order_other);
            c0368b.f7499b.setText(this.f7495b.get(i));
            if (this.f7496c) {
                c0368b.f7499b.setTextColor(this.f7494a.getResources().getColor(R.color.search_small_color));
            } else {
                c0368b.f7499b.setTextColor(c.a.a.a.d.b.d().b(R.color.select_stb));
                SupportActivity supportActivity = this.f7497d;
                if (supportActivity != null) {
                    supportActivity.a(c0368b.f7499b, "textColor", R.color.select_stb);
                }
            }
        }
        return view2;
    }
}
