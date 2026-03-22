package com.zte.iptvclient.android.mobile.q.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.d;
import com.bumptech.glide.i;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.k.w;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.mobile.order.entity.PurchaseHistoryEntity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;

/* compiled from: AdapterPurchaseHistory.java */
/* loaded from: classes.dex */
public class a extends RecyclerView.g<RecyclerView.b0> {

    /* renamed from: c, reason: collision with root package name */
    private Context f7045c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<PurchaseHistoryEntity> f7046d;
    private ArrayList<PurchaseHistoryEntity> e;
    private LayoutInflater f;

    /* compiled from: AdapterPurchaseHistory.java */
    /* renamed from: com.zte.iptvclient.android.mobile.q.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ViewOnClickListenerC0333a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PurchaseHistoryEntity f7047a;

        ViewOnClickListenerC0333a(PurchaseHistoryEntity purchaseHistoryEntity) {
            this.f7047a = purchaseHistoryEntity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f7047a.a(!r2.l());
            a.this.e();
        }
    }

    /* compiled from: AdapterPurchaseHistory.java */
    /* loaded from: classes.dex */
    static class b extends RecyclerView.b0 {
        public TextView t;
        public ImageView u;
        private RelativeLayout v;

        public b(View view) {
            super(view);
            this.t = (TextView) view.findViewById(R.id.tv_subscription_time);
            this.u = (ImageView) view.findViewById(R.id.img_arrow_down);
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_subscription_time);
            this.v = relativeLayout;
            f.a(relativeLayout);
            f.a(this.t);
            f.a(this.u);
        }
    }

    /* compiled from: AdapterPurchaseHistory.java */
    /* loaded from: classes.dex */
    static class c extends RecyclerView.b0 {
        public TextView t;
        public ImageView u;
        public TextView v;
        public TextView w;
        public TextView x;
        public ImageView y;

        public c(View view) {
            super(view);
            this.t = (TextView) view.findViewById(R.id.package_name);
            this.u = (ImageView) view.findViewById(R.id.img_poster);
            this.v = (TextView) view.findViewById(R.id.purchase_time);
            this.w = (TextView) view.findViewById(R.id.effective_time);
            this.x = (TextView) view.findViewById(R.id.price);
            this.y = (ImageView) view.findViewById(R.id.ivi_logo_top);
            f.a(this.t);
            f.a(this.v);
            f.a(this.w);
            f.a(this.x);
            f.a(this.y);
        }
    }

    public a(Context context, ArrayList<PurchaseHistoryEntity> arrayList) {
        this.f7045c = context;
        this.f7046d = arrayList;
        this.f = LayoutInflater.from(context);
        f();
    }

    private void f() {
        LogEx.d("AdapterPurchaseHistory", "---integrateCollection---");
        if (this.f7046d == null) {
            this.e = null;
            return;
        }
        ArrayList<PurchaseHistoryEntity> arrayList = this.e;
        if (arrayList == null) {
            this.e = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        for (int i = 0; i < this.f7046d.size(); i++) {
            PurchaseHistoryEntity purchaseHistoryEntity = this.f7046d.get(i);
            if (purchaseHistoryEntity.l()) {
                this.e.addAll(purchaseHistoryEntity.g());
            } else {
                this.e.add(purchaseHistoryEntity);
            }
        }
        LogEx.d("AdapterPurchaseHistory", "mIntegratedList.size(): " + this.e.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        ArrayList<PurchaseHistoryEntity> arrayList = this.e;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int b(int i) {
        return TextUtils.isEmpty(this.e.get(i).k()) ? 2 : 1;
    }

    public final void e() {
        f();
        d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.b0 b(ViewGroup viewGroup, int i) {
        if (i == 2) {
            return new c(this.f.inflate(R.layout.recycleritem_ppv, (ViewGroup) null));
        }
        return new b(this.f.inflate(R.layout.contact_buddy_list_group, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void b(RecyclerView.b0 b0Var, int i) {
        PurchaseHistoryEntity purchaseHistoryEntity = this.e.get(i);
        if (b0Var instanceof c) {
            c cVar = (c) b0Var;
            d<String> a2 = i.b(this.f7045c).a(purchaseHistoryEntity.h());
            a2.b(R.drawable.default_poster_thumb);
            a2.a(R.drawable.default_poster_thumb);
            a2.a(cVar.u);
            cVar.t.setText(purchaseHistoryEntity.c());
            if (purchaseHistoryEntity.d().equals("ivi")) {
                cVar.y.setVisibility(0);
                cVar.y.setImageDrawable(this.f7045c.getResources().getDrawable(R.drawable.ivi_logo));
            } else if (purchaseHistoryEntity.d().equals("Megogo")) {
                cVar.y.setVisibility(0);
                cVar.y.setImageDrawable(this.f7045c.getResources().getDrawable(R.drawable.megogo_logo));
            } else {
                cVar.y.setVisibility(8);
            }
            String str = com.zte.iptvclient.android.common.i.a.a.a(R.string.package_purchase_time) + x.c(purchaseHistoryEntity.a());
            String str2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.package_available_unit) + x.c(purchaseHistoryEntity.e());
            cVar.v.setText(str);
            cVar.w.setText(str2);
            cVar.x.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_price));
            if (TextUtils.isEmpty(purchaseHistoryEntity.f())) {
                return;
            }
            String a3 = com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_price);
            try {
                Double valueOf = Double.valueOf(purchaseHistoryEntity.f());
                if (valueOf.doubleValue() >= 0.0d) {
                    cVar.x.setText(a3 + " " + w.b(valueOf.doubleValue()) + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.money_unit_sign));
                    return;
                }
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return;
            }
        }
        b bVar = (b) b0Var;
        bVar.t.setText(purchaseHistoryEntity.k());
        if (purchaseHistoryEntity.l()) {
            bVar.u.setImageResource(R.drawable.btn_arrowup);
        } else {
            bVar.u.setImageResource(R.drawable.btn_arrowdown);
        }
        bVar.f1492a.setOnClickListener(new ViewOnClickListenerC0333a(purchaseHistoryEntity));
    }
}
