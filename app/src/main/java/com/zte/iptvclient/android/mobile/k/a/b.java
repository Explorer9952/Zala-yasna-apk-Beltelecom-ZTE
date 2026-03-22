package com.zte.iptvclient.android.mobile.k.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.d;
import com.video.androidsdk.common.util.StringUtil;
import com.zte.iptvclient.android.common.javabean.models.i;
import com.zte.iptvclient.android.mobile.k.b.f;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AdapterTvHistory.java */
/* loaded from: classes.dex */
public class b extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    List<i> f6667a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private boolean f6668b;

    /* renamed from: c, reason: collision with root package name */
    private List<i> f6669c;

    /* renamed from: d, reason: collision with root package name */
    private f f6670d;
    private LayoutInflater e;
    private boolean f;

    /* compiled from: AdapterTvHistory.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f6671a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ C0290b f6672b;

        a(i iVar, C0290b c0290b) {
            this.f6671a = iVar;
            this.f6672b = c0290b;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.f6668b) {
                b.this.f6670d.p.s(this.f6671a.a());
                return;
            }
            if (b.this.f6667a.contains(this.f6671a)) {
                this.f6672b.f.setVisibility(4);
                b.this.f6667a.remove(this.f6671a);
            } else {
                this.f6672b.f.setVisibility(0);
                b.this.f6667a.add(this.f6671a);
            }
            b.this.g();
            b.this.f6670d.R();
            b.this.f6670d.S();
            b.this.f6670d.U();
            b.this.f6670d.T();
        }
    }

    /* compiled from: AdapterTvHistory.java */
    /* renamed from: com.zte.iptvclient.android.mobile.k.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0290b {

        /* renamed from: a, reason: collision with root package name */
        TextView f6674a;

        /* renamed from: b, reason: collision with root package name */
        TextView f6675b;

        /* renamed from: c, reason: collision with root package name */
        TextView f6676c;

        /* renamed from: d, reason: collision with root package name */
        RelativeLayout f6677d;
        ImageView e;
        ImageView f;
        ImageView g;

        private C0290b() {
        }

        /* synthetic */ C0290b(a aVar) {
            this();
        }
    }

    public b(f fVar, List<i> list) {
        this.f6669c = list;
        this.f6670d = fVar;
        if (fVar.getActivity() != null) {
            this.e = (LayoutInflater) fVar.getActivity().getSystemService("layout_inflater");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f = this.f6669c.size() == this.f6667a.size();
    }

    public List<i> d() {
        return this.f6667a;
    }

    public List<i> e() {
        return this.f6669c;
    }

    public void f() {
        this.f6667a = new ArrayList(this.f6669c);
        this.f = true;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<i> list = this.f6669c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<i> list = this.f6669c;
        if (list != null && list.size() > i) {
            return this.f6669c.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C0290b c0290b;
        if (view == null) {
            c0290b = new C0290b(null);
            view2 = this.e.inflate(R.layout.item_layout_tv_history, (ViewGroup) null);
            c0290b.f6677d = (RelativeLayout) view2.findViewById(R.id.rl_content);
            c0290b.f6674a = (TextView) view2.findViewById(R.id.tv_channel);
            c0290b.f6676c = (TextView) view2.findViewById(R.id.tv_time);
            c0290b.e = (ImageView) view2.findViewById(R.id.iv_poster);
            c0290b.f = (ImageView) view2.findViewById(R.id.iv_select);
            c0290b.g = (ImageView) view2.findViewById(R.id.iv_now);
            c0290b.f6675b = (TextView) view2.findViewById(R.id.tv_programme);
            com.zte.iptvclient.common.uiframe.f.a(c0290b.f6677d);
            com.zte.iptvclient.common.uiframe.f.a(c0290b.f6674a);
            com.zte.iptvclient.common.uiframe.f.a(c0290b.f6676c);
            com.zte.iptvclient.common.uiframe.f.a(c0290b.e);
            com.zte.iptvclient.common.uiframe.f.a(c0290b.f);
            com.zte.iptvclient.common.uiframe.f.a(c0290b.g);
            com.zte.iptvclient.common.uiframe.f.a(c0290b.f6675b);
            view2.setTag(c0290b);
        } else {
            view2 = view;
            c0290b = (C0290b) view.getTag();
        }
        i iVar = this.f6669c.get(i);
        c0290b.f6677d.setOnClickListener(new a(iVar, c0290b));
        if (iVar != null) {
            c0290b.f6674a.setText(StringUtil.isEmptyString(iVar.b()) ? "" : iVar.b());
            d<String> a2 = com.bumptech.glide.i.a(this.f6670d).a(iVar.d());
            a2.a(R.drawable.default_poster_thumb);
            a2.a(c0290b.e);
            if (this.f6668b && this.f6667a.contains(iVar)) {
                c0290b.f.setVisibility(0);
            } else {
                c0290b.f.setVisibility(4);
            }
            c0290b.f6676c.setText(iVar.f());
            c0290b.f6675b.setText(iVar.e());
        }
        return view2;
    }

    public void a() {
        this.f6667a.clear();
        this.f = false;
        notifyDataSetChanged();
    }

    public boolean b() {
        return this.f;
    }

    public int c() {
        return this.f6667a.size();
    }

    public void a(boolean z) {
        if (z) {
            this.f6668b = true;
            this.f6667a.clear();
            notifyDataSetChanged();
        } else {
            this.f6668b = false;
            notifyDataSetChanged();
        }
    }

    public void a(List<i> list) {
        this.f6669c = list;
        this.f6667a.clear();
        notifyDataSetChanged();
    }
}
