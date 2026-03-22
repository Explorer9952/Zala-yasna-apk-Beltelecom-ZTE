package com.zte.iptvclient.android.mobile.s.a.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.auth.SDKSubscribeMgr;
import com.video.androidsdk.service.bean.SubscribeInfo;
import com.video.androidsdk.service.bean.SubscribeReq;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.a.a.e.f;
import com.zte.iptvclient.android.common.customview.a.a.e.m;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.k.b;
import com.zte.iptvclient.android.common.k.s;
import com.zte.iptvclient.android.common.k.w;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.mobile.productpackage.fragment.bean.PackageBean;
import com.zte.iptvclient.android.zala.R;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* compiled from: PackageAdapter.java */
/* loaded from: classes2.dex */
public class a extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private List<PackageBean> f7153a;

    /* renamed from: b, reason: collision with root package name */
    private LayoutInflater f7154b;

    /* renamed from: c, reason: collision with root package name */
    private Context f7155c;

    /* renamed from: d, reason: collision with root package name */
    protected SupportActivity f7156d;
    String e;

    /* compiled from: PackageAdapter.java */
    /* renamed from: com.zte.iptvclient.android.mobile.s.a.g.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class ViewOnClickListenerC0345a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PackageBean f7157a;

        /* compiled from: PackageAdapter.java */
        /* renamed from: com.zte.iptvclient.android.mobile.s.a.g.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0346a implements f.c {

            /* compiled from: PackageAdapter.java */
            /* renamed from: com.zte.iptvclient.android.mobile.s.a.g.a$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            class C0347a implements SDKSubscribeMgr.OnDoSubscribeReturnListener {
                C0347a() {
                }

                @Override // com.video.androidsdk.service.auth.SDKSubscribeMgr.OnDoSubscribeReturnListener
                public void onDoSubscribeReturn(String str, String str2, SubscribeInfo subscribeInfo) {
                    if (TextUtils.equals(str, "0")) {
                        if (TextUtils.equals(ViewOnClickListenerC0345a.this.f7157a.i(), "1")) {
                            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.unsubscription_success);
                            ViewOnClickListenerC0345a.this.f7157a.p("0");
                        } else if (TextUtils.equals(ViewOnClickListenerC0345a.this.f7157a.i(), "0")) {
                            ViewOnClickListenerC0345a.this.f7157a.p("1");
                            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.pay_success);
                        }
                        a.this.notifyDataSetChanged();
                        EventBus.getDefault().post(new com.zte.iptvclient.android.mobile.s.a.b());
                        return;
                    }
                    if (TextUtils.equals(str, "70116677")) {
                        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.purchase_error);
                    } else {
                        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(str2);
                    }
                }
            }

            C0346a() {
            }

            @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
            public void a() {
                new SDKSubscribeMgr().doSubscribe(new SubscribeReq("0", ViewOnClickListenerC0345a.this.f7157a.l(), a.this.e), new C0347a());
            }

            @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
            public void b() {
            }
        }

        ViewOnClickListenerC0345a(PackageBean packageBean) {
            this.f7157a = packageBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ("1".equals(this.f7157a.i())) {
                a.this.e = "4";
            } else {
                a.this.e = "1";
            }
            if (TextUtils.equals(this.f7157a.g(), "0")) {
                return;
            }
            try {
                new com.zte.iptvclient.android.common.customview.a.a.e.f(a.this.f7155c, R.drawable.custom_dialog_title_img, TextUtils.equals(this.f7157a.i(), "0") ? R.string.order_confirm_tip : TextUtils.equals(this.f7157a.i(), "1") ? R.string.purchase_cancel : 0, R.drawable.custom_dialog_button_blue, R.string.common_ok, 0, R.drawable.custom_dialog_button_blue, R.string.common_cancel, 0, new C0346a()).a();
            } catch (Exception e) {
                LogEx.e("AdapterSubscription", e.getMessage());
            }
        }
    }

    /* compiled from: PackageAdapter.java */
    /* loaded from: classes2.dex */
    class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PackageBean f7161a;

        b(PackageBean packageBean) {
            this.f7161a = packageBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f7161a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PackageAdapter.java */
    /* loaded from: classes2.dex */
    public class c implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PackageBean f7163a;

        c(PackageBean packageBean) {
            this.f7163a = packageBean;
        }

        @Override // com.zte.iptvclient.android.common.k.b.d
        public void a() {
            a.this.a(this.f7163a.l());
        }

        @Override // com.zte.iptvclient.android.common.k.b.d
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PackageAdapter.java */
    /* loaded from: classes2.dex */
    public class d implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PackageBean f7165a;

        d(PackageBean packageBean) {
            this.f7165a = packageBean;
        }

        @Override // com.zte.iptvclient.android.common.k.b.d
        public void a() {
            a.this.a(this.f7165a.l());
        }

        @Override // com.zte.iptvclient.android.common.k.b.d
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PackageAdapter.java */
    /* loaded from: classes2.dex */
    public class e implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PackageBean f7167a;

        e(PackageBean packageBean) {
            this.f7167a = packageBean;
        }

        @Override // com.zte.iptvclient.android.common.k.b.d
        public void a() {
            a.this.a(this.f7167a.l());
        }

        @Override // com.zte.iptvclient.android.common.k.b.d
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PackageAdapter.java */
    /* loaded from: classes2.dex */
    public class f implements SDKSubscribeMgr.OnDoSubscribeReturnListener {
        f(a aVar) {
        }

        @Override // com.video.androidsdk.service.auth.SDKSubscribeMgr.OnDoSubscribeReturnListener
        public void onDoSubscribeReturn(String str, String str2, SubscribeInfo subscribeInfo) {
            if (TextUtils.equals(str, "0")) {
                com.zte.iptvclient.android.mobile.e0.f.e.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.cancel_renew_success));
                EventBus.getDefault().post(new com.zte.iptvclient.android.mobile.s.a.a());
                return;
            }
            com.zte.iptvclient.android.mobile.e0.f.e.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.cancel_renew_failed));
        }
    }

    /* compiled from: PackageAdapter.java */
    /* loaded from: classes2.dex */
    static class g {

        /* renamed from: a, reason: collision with root package name */
        public TextView f7169a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f7170b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f7171c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f7172d;
        public ImageView e;
        public ImageView f;
        private ImageView g;
        private LinearLayout h;
        private LinearLayout i;
        public TextView j;
        public TextView k;

        g() {
        }
    }

    /* compiled from: PackageAdapter.java */
    /* loaded from: classes2.dex */
    public interface h {
    }

    public a(Context context, List<PackageBean> list) {
        this.f7155c = context;
        this.f7153a = list;
        this.f7154b = LayoutInflater.from(context);
    }

    public void a(h hVar) {
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<PackageBean> list = this.f7153a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        g gVar;
        View view2;
        if (view == null) {
            View inflate = this.f7154b.inflate(R.layout.recycleritem_package, (ViewGroup) null);
            g gVar2 = new g();
            gVar2.f7169a = (TextView) inflate.findViewById(R.id.package_name);
            gVar2.f7170b = (TextView) inflate.findViewById(R.id.purchase_time);
            gVar2.f7171c = (TextView) inflate.findViewById(R.id.price);
            gVar2.f7172d = (ImageView) inflate.findViewById(R.id.img_poster);
            gVar2.e = (ImageView) inflate.findViewById(R.id.order);
            gVar2.f = (ImageView) inflate.findViewById(R.id.image);
            gVar2.h = (LinearLayout) inflate.findViewById(R.id.item_layout);
            gVar2.i = (LinearLayout) inflate.findViewById(R.id.ll_package_detail);
            gVar2.g = (ImageView) inflate.findViewById(R.id.est_icon);
            gVar2.j = (TextView) inflate.findViewById(R.id.effective_time);
            gVar2.k = (TextView) inflate.findViewById(R.id.tv_cancel_renew);
            com.zte.iptvclient.common.uiframe.f.a(gVar2.f7172d);
            com.zte.iptvclient.common.uiframe.f.a(gVar2.e);
            com.zte.iptvclient.common.uiframe.f.a(gVar2.f);
            com.zte.iptvclient.common.uiframe.f.a(gVar2.h);
            com.zte.iptvclient.common.uiframe.f.a(gVar2.i);
            com.zte.iptvclient.common.uiframe.f.a(gVar2.f7169a);
            com.zte.iptvclient.common.uiframe.f.a(gVar2.f7170b);
            com.zte.iptvclient.common.uiframe.f.a(gVar2.f7171c);
            com.zte.iptvclient.common.uiframe.f.a(gVar2.j);
            com.zte.iptvclient.common.uiframe.f.a(gVar2.k);
            inflate.setTag(gVar2);
            gVar = gVar2;
            view2 = inflate;
        } else {
            gVar = (g) view.getTag();
            view2 = view;
        }
        PackageBean item = getItem(i);
        gVar.e.setVisibility(4);
        if ("1".equals(item.g())) {
            gVar.k.setVisibility(0);
        } else {
            gVar.k.setVisibility(4);
        }
        String b2 = item.b();
        String f2 = item.f();
        if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(f2)) {
            gVar.f7169a.setText(item.c());
            String str = com.zte.iptvclient.android.common.i.a.a.a(R.string.package_purchase_time) + x.a(b2);
            String str2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.package_available_unit) + x.c(f2);
            gVar.f7170b.setText(str);
            gVar.j.setText(str2);
            String k = item.k();
            String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_price);
            if (!TextUtils.isEmpty(k)) {
                try {
                    a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_price) + w.b(Double.valueOf(k).doubleValue()) + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.money_unit_sign);
                    if ("0".equals(item.n())) {
                        a2 = a2 + "/ " + com.zte.iptvclient.android.common.i.a.a.a(R.string.my_package_month_product_tip);
                    }
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            gVar.f7171c.setText(a2);
            gVar.f.setVisibility(8);
            gVar.i.setEnabled(false);
        } else {
            gVar.f7169a.setText(item.m());
            gVar.j.setText("");
            String k2 = item.k();
            TextUtils.equals(item.d(), "0");
            String a3 = TextUtils.equals(item.d(), "1") ? com.zte.iptvclient.android.common.i.a.a.a(R.string.time_day) : "";
            if (TextUtils.equals(item.d(), "2")) {
                a3 = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_week);
            }
            if (TextUtils.equals(item.d(), "3")) {
                a3 = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_month);
            }
            if (TextUtils.equals(item.d(), "4")) {
                a3 = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_half_year);
            }
            if (TextUtils.equals(item.d(), DownloadConstant.REPORT_MSGTYPE_ADD)) {
                a3 = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_year);
            }
            if (TextUtils.equals(item.d(), DownloadConstant.REPORT_MSGTYPE_URL_NULL)) {
                a3 = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_hour);
            }
            if (TextUtils.equals(item.d(), DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT)) {
                a3 = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_min);
            }
            if (TextUtils.equals(item.d(), "8")) {
                a3 = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_season);
            }
            if (TextUtils.isEmpty(k2)) {
                LogEx.e("AdapterSubscription", "getPrice is null !");
                k2 = "0";
            }
            Double valueOf = Double.valueOf(a(Integer.valueOf(k2)));
            if (!item.d().equals("0") && !"0".equals(k2)) {
                gVar.f7171c.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_price) + (valueOf.doubleValue() / 100.0d) + "0/" + a3);
            } else {
                gVar.f7171c.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_price) + (valueOf.doubleValue() / 100.0d) + "0");
            }
            gVar.f.setVisibility(0);
            gVar.i.setEnabled(true);
        }
        if (TextUtils.equals(item.i(), "1")) {
            gVar.f.setVisibility(8);
        }
        gVar.i.setOnClickListener(new ViewOnClickListenerC0345a(item));
        if (TextUtils.equals(item.n(), DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT)) {
            String a4 = com.zte.iptvclient.android.common.k.g.a(BaseApp.a(this.f7155c) ? 9 : 3, item.j());
            if (!TextUtils.isEmpty(a4) && a4.contains("/image")) {
                int indexOf = a4.indexOf("/image", 1);
                a4 = i.g() + a4.substring(indexOf);
            }
            SupportActivity supportActivity = this.f7156d;
            if (supportActivity != null && !supportActivity.isFinishing()) {
                com.bumptech.glide.d<String> a5 = com.bumptech.glide.i.a((FragmentActivity) this.f7156d).a(a4);
                a5.b(R.drawable.poster);
                a5.a(R.drawable.poster);
                a5.c(300);
                a5.a(gVar.f7172d);
            }
            gVar.g.setVisibility(8);
        } else {
            String j = item.j();
            String[] split = j.split(";");
            if (!TextUtils.isEmpty(j)) {
                String j2 = item.j();
                if (split.length > 3) {
                    LogEx.d("USee", "AdapterFavorite image url = " + (j2 + "/images/poster/" + split[3]));
                }
            }
            gVar.g.setVisibility(8);
        }
        gVar.k.setOnClickListener(new b(item));
        return view2;
    }

    @Override // android.widget.Adapter
    public PackageBean getItem(int i) {
        return this.f7153a.get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PackageBean packageBean) {
        if (com.zte.iptvclient.android.common.k.c.a()) {
            return;
        }
        if (!TextUtils.isEmpty(packageBean.o())) {
            try {
                int a2 = x.a(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(packageBean.b()), s.b());
                int parseInt = Integer.parseInt(packageBean.o());
                if (parseInt >= 99999) {
                    new m(this.f7155c, R.style.dialog_order, this.f7155c.getResources().getString(R.string.un_subscribe_is_not_supported)).show();
                } else if (parseInt == 0) {
                    com.zte.iptvclient.android.common.k.b.a(this.f7155c, com.zte.iptvclient.android.common.i.a.a.a(R.string.purchase_cancel), new c(packageBean));
                } else if (a2 > parseInt) {
                    com.zte.iptvclient.android.common.k.b.a(this.f7155c, com.zte.iptvclient.android.common.i.a.a.a(R.string.purchase_cancel), new d(packageBean));
                } else {
                    new m(this.f7155c, R.style.dialog_order, this.f7155c.getResources().getString(R.string.unsubscription_time_not_reached).replace("xx", packageBean.o())).show();
                }
                return;
            } catch (ParseException e2) {
                e2.printStackTrace();
                return;
            }
        }
        com.zte.iptvclient.android.common.k.b.a(this.f7155c, com.zte.iptvclient.android.common.i.a.a.a(R.string.purchase_cancel), new e(packageBean));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        new SDKSubscribeMgr().doSubscribe(new SubscribeReq("0", str, "4"), new f(this));
    }

    public static double a(Integer num) {
        return (num == null ? new BigDecimal("0.00") : new BigDecimal(Double.toString(num.intValue()))).divide(new BigDecimal("1"), 3, 4).doubleValue();
    }
}
