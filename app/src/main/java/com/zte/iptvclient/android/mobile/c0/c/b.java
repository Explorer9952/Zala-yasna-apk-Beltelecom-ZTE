package com.zte.iptvclient.android.mobile.c0.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.List;

/* compiled from: AdapterMyFragmentMenu.java */
/* loaded from: classes2.dex */
public class b extends RecyclerView.g<C0201b> {

    /* renamed from: c, reason: collision with root package name */
    private Context f5647c;

    /* renamed from: d, reason: collision with root package name */
    private List<com.zte.iptvclient.android.mobile.l.c.a.b> f5648d;
    private String e;
    private c f;
    private int g = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterMyFragmentMenu.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5649a;

        a(int i) {
            this.f5649a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f != null) {
                b.this.f.a(view, this.f5649a);
            }
        }
    }

    /* compiled from: AdapterMyFragmentMenu.java */
    /* renamed from: com.zte.iptvclient.android.mobile.c0.c.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0201b extends RecyclerView.b0 {
        private RelativeLayout t;
        private ImageView u;
        private TextView v;
        private TextView w;
        private TextView x;

        public C0201b(View view) {
            super(view);
            this.t = (RelativeLayout) view.findViewById(R.id.rlayout_mine_menu_item_root);
            this.u = (ImageView) view.findViewById(R.id.ivew_mine_menu_icon);
            this.x = (TextView) view.findViewById(R.id.txt_balance);
            TextView textView = (TextView) view.findViewById(R.id.txtvew_mine_menu_title);
            this.v = textView;
            textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.mine_login_or_register));
            this.w = (TextView) view.findViewById(R.id.vew_item_separator);
            f.a(this.t);
            f.a(this.u);
            f.a(this.v);
            f.a(this.w);
        }
    }

    /* compiled from: AdapterMyFragmentMenu.java */
    /* loaded from: classes2.dex */
    public interface c {
        void a(View view, int i);
    }

    public b(Context context, List<com.zte.iptvclient.android.mobile.l.c.a.b> list, String str) {
        this.f5647c = context;
        this.f5648d = list;
        this.e = str;
    }

    public void e(int i) {
        this.g = i;
    }

    public void a(c cVar) {
        this.f = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(C0201b c0201b, int i) {
        try {
            c0201b.u.setImageResource(this.f5648d.get(i).e);
            c0201b.v.setText(this.f5648d.get(i).f);
            if (this.f5648d.get(i).f.equals(this.f5647c.getResources().getString(R.string.tab_name_bookmark))) {
                ViewGroup.LayoutParams layoutParams = c0201b.w.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 40;
                    c0201b.w.setLayoutParams(layoutParams);
                }
                c0201b.w.setBackgroundResource(R.color.mine_line_bg);
            } else {
                ViewGroup.LayoutParams layoutParams2 = c0201b.w.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = 1;
                    c0201b.w.setLayoutParams(layoutParams2);
                }
                c0201b.w.setBackgroundResource(R.color.mine_line_bg);
            }
            if (!this.f5648d.get(i).f.equals(this.f5647c.getResources().getString(R.string.my_balance)) || !com.zte.iptvclient.android.mobile.n.c.b.t() || this.e.equals("")) {
                c0201b.x.setVisibility(8);
            } else {
                c0201b.x.setText(this.e + " " + this.f5647c.getResources().getString(R.string.money_unit_sign));
                c0201b.x.setTextColor(this.f5647c.getResources().getColor(R.color.balance_txt));
                c0201b.x.setVisibility(0);
            }
            if (i == this.g) {
                c0201b.t.setBackgroundColor(this.f5647c.getResources().getColor(R.color.mine_select_itme_bg));
                c0201b.v.setTextColor(this.f5647c.getResources().getColor(R.color.mine_title_select_textcolor));
            } else {
                c0201b.t.setBackgroundColor(this.f5647c.getResources().getColor(R.color.mine_order_subscription_bg));
                c0201b.v.setTextColor(this.f5647c.getResources().getColor(R.color.mine_title_textcolor));
            }
            b2(c0201b, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public C0201b b(ViewGroup viewGroup, int i) {
        return new C0201b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mine_menu_item, viewGroup, false));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private void b2(C0201b c0201b, int i) {
        c0201b.t.setOnClickListener(new a(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        List<com.zte.iptvclient.android.mobile.l.c.a.b> list = this.f5648d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void a(List<com.zte.iptvclient.android.mobile.l.c.a.b> list, String str) {
        if (list != null) {
            this.f5648d = list;
            this.e = str;
        }
        d();
    }
}
