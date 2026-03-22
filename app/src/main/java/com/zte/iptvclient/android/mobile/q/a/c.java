package com.zte.iptvclient.android.mobile.q.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.zte.iptvclient.android.common.javabean.j;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;

/* compiled from: AdapterVodSubscribeList.java */
/* loaded from: classes.dex */
public class c extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private static int f7060d = 0;
    private static int e = 1;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<j> f7061a;

    /* renamed from: b, reason: collision with root package name */
    private LayoutInflater f7062b;

    /* renamed from: c, reason: collision with root package name */
    private b f7063c;

    /* compiled from: AdapterVodSubscribeList.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f7064a;

        a(j jVar) {
            this.f7064a = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f7063c != null) {
                c.this.f7063c.a(this.f7064a);
            }
        }
    }

    /* compiled from: AdapterVodSubscribeList.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(j jVar);
    }

    /* compiled from: AdapterVodSubscribeList.java */
    /* renamed from: com.zte.iptvclient.android.mobile.q.a.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0335c {

        /* renamed from: a, reason: collision with root package name */
        TextView f7066a;

        /* renamed from: b, reason: collision with root package name */
        Button f7067b;

        C0335c() {
        }
    }

    /* compiled from: AdapterVodSubscribeList.java */
    /* loaded from: classes.dex */
    static class d {

        /* renamed from: a, reason: collision with root package name */
        TextView f7068a;

        d() {
        }
    }

    public c(Context context, ArrayList<j> arrayList) {
        this.f7061a = arrayList;
        this.f7062b = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<j> arrayList = this.f7061a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<j> arrayList = this.f7061a;
        if (arrayList == null) {
            return null;
        }
        return arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.f7061a.get(i).d()) {
            return f7060d;
        }
        return e;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C0335c c0335c;
        d dVar;
        if (getItemViewType(i) == f7060d) {
            if (view == null) {
                dVar = new d();
                view2 = this.f7062b.inflate(R.layout.subscribe_list_view_item_time, (ViewGroup) null);
                TextView textView = (TextView) view2.findViewById(R.id.txt_time);
                dVar.f7068a = textView;
                f.a(textView);
                view2.setTag(dVar);
            } else {
                view2 = view;
                dVar = (d) view.getTag();
            }
            j jVar = this.f7061a.get(i);
            if (jVar != null) {
                dVar.f7068a.setText(a(jVar.c()));
            }
        } else {
            if (view == null) {
                c0335c = new C0335c();
                view2 = this.f7062b.inflate(R.layout.subscribe_list_view_item, (ViewGroup) null);
                c0335c.f7066a = (TextView) view2.findViewById(R.id.txt_name);
                c0335c.f7067b = (Button) view2.findViewById(R.id.btn_cancel);
                f.a(c0335c.f7066a);
                f.a(c0335c.f7067b);
                f.a(view2.findViewById(R.id.ll_layout));
                c0335c.f7067b.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.cancel_reservation));
                view2.setTag(c0335c);
            } else {
                view2 = view;
                c0335c = (C0335c) view.getTag();
            }
            j jVar2 = this.f7061a.get(i);
            if (jVar2 != null) {
                c0335c.f7066a.setText(jVar2.b());
                c0335c.f7067b.setOnClickListener(new a(jVar2));
            }
        }
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void a(b bVar) {
        this.f7063c = bVar;
    }

    private String a(String str) {
        return str.substring(4, 6) + "/" + str.substring(6, 8);
    }
}
