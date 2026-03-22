package com.zte.iptvclient.android.mobile.order.helper.f;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.ServerDate;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.bean.Product;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.k.w;
import com.zte.iptvclient.android.mobile.order.helper.d;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: CommonOrderProductDialogNew.java */
/* loaded from: classes.dex */
public class a extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private Activity f6953a;

    /* renamed from: b, reason: collision with root package name */
    private RelativeLayout f6954b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f6955c;

    /* renamed from: d, reason: collision with root package name */
    private ListView f6956d;
    private LinearLayout e;
    private TextView f;
    private TextView g;
    private List<Product> h;
    private ArrayList<d> i;
    private com.zte.iptvclient.android.mobile.order.helper.b j;
    private String k;
    private c l;
    private String m;
    private String n;
    private String o;
    private String p;
    private h q;
    private List r;
    private Product s;
    private boolean t;
    private String u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonOrderProductDialogNew.java */
    /* renamed from: com.zte.iptvclient.android.mobile.order.helper.f.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0325a implements View.OnClickListener {
        ViewOnClickListenerC0325a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.s != null) {
                if (!a.this.q.A() && !com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
                    if ("1".equals(ConfigMgr.readPropertie("IsOnlySupportEPGPayment", "1"))) {
                        com.zte.iptvclient.android.mobile.order.helper.a aVar = new com.zte.iptvclient.android.mobile.order.helper.a(a.this.f6953a, a.this.m, a.this.n, a.this.o, a.this.p);
                        a.this.i.add(aVar);
                        ((d) a.this.i.get(a.this.i.indexOf(aVar))).a(a.this.s, a.this.j);
                        a.this.dismiss();
                        return;
                    }
                    return;
                }
                new com.zte.iptvclient.android.common.customview.a.a.a.c(a.this.f6953a, R.style.dialog_order, a.this.s, a.this.k).a();
                a.this.dismiss();
                return;
            }
            a.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonOrderProductDialogNew.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CommonOrderProductDialogNew.java */
    /* loaded from: classes.dex */
    public class c extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private LayoutInflater f6959a;

        /* compiled from: CommonOrderProductDialogNew.java */
        /* renamed from: com.zte.iptvclient.android.mobile.order.helper.f.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class ViewOnClickListenerC0326a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f6961a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f6962b;

            ViewOnClickListenerC0326a(b bVar, int i) {
                this.f6961a = bVar;
                this.f6962b = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.s = null;
                if (this.f6961a.f6965b.isChecked()) {
                    for (int i = 0; i < a.this.h.size(); i++) {
                        a.this.r.set(i, false);
                    }
                    a.this.r.set(this.f6962b, true);
                    this.f6961a.f6965b.setChecked(true);
                    c.this.notifyDataSetChanged();
                    return;
                }
                a.this.r.set(this.f6962b, false);
                this.f6961a.f6965b.setChecked(false);
                c.this.notifyDataSetChanged();
            }
        }

        /* compiled from: CommonOrderProductDialogNew.java */
        /* loaded from: classes.dex */
        class b {

            /* renamed from: a, reason: collision with root package name */
            LinearLayout f6964a;

            /* renamed from: b, reason: collision with root package name */
            CheckBox f6965b;

            /* renamed from: c, reason: collision with root package name */
            TextView f6966c;

            /* renamed from: d, reason: collision with root package name */
            TextView f6967d;
            TextView e;

            b(c cVar) {
            }
        }

        /* synthetic */ c(a aVar, Context context, ViewOnClickListenerC0325a viewOnClickListenerC0325a) {
            this(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (a.this.h == null) {
                return 0;
            }
            return a.this.h.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return a.this.h.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar = new b(this);
            if (view == null) {
                view = this.f6959a.inflate(R.layout.common_order_product_item_new, (ViewGroup) null);
                bVar.f6964a = (LinearLayout) view.findViewById(R.id.package_item);
                bVar.f6965b = (CheckBox) view.findViewById(R.id.package_selector);
                bVar.f6966c = (TextView) view.findViewById(R.id.pacakge_name);
                bVar.f6967d = (TextView) view.findViewById(R.id.price);
                bVar.e = (TextView) view.findViewById(R.id.time);
                f.a(bVar.f6964a);
                f.a(bVar.f6965b);
                f.a(bVar.f6966c);
                f.a(bVar.f6967d);
                f.a(bVar.e);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            Product product = (Product) a.this.h.get(i);
            bVar.f6966c.setText(product.getProductname());
            if (!TextUtils.isEmpty(product.getFee())) {
                a.this.u = w.b(Double.valueOf(Double.valueOf(product.getFee()).doubleValue() / 100.0d).doubleValue());
            }
            bVar.e.setText(a.this.a(product.getPurchasetype(), product.getChargetype(), product.getRentalterm(), product.getRentalunit()));
            bVar.f6967d.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.vod_cost_indicate) + a.this.u + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.money_unit_sign) + "/" + a.this.a(product.getRentalterm(), product.getRentalunit()) + " ");
            if (a.this.r.get(i).equals(true)) {
                bVar.f6965b.setChecked(true);
                a aVar = a.this;
                aVar.s = (Product) aVar.h.get(i);
            } else {
                bVar.f6965b.setChecked(false);
            }
            bVar.f6965b.setOnClickListener(new ViewOnClickListenerC0326a(bVar, i));
            return view;
        }

        private c(Context context) {
            this.f6959a = LayoutInflater.from(context);
        }
    }

    public a(Activity activity, int i, List<Product> list, com.zte.iptvclient.android.mobile.order.helper.b bVar, com.zte.iptvclient.android.common.javabean.models.h hVar) {
        super(activity, i);
        this.i = new ArrayList<>();
        this.r = new ArrayList();
        this.t = false;
        this.q = new h(activity);
        this.m = hVar.b();
        this.n = hVar.a();
        this.o = hVar.c();
        this.k = hVar.d();
        this.p = hVar.e();
        this.j = bVar;
        this.f6953a = activity;
        this.h = list;
        if (EventBus.getDefault().isRegistered(this)) {
            return;
        }
        EventBus.getDefault().register(this);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_common_order);
        setCancelable(false);
        if (this.r != null) {
            for (int i = 0; i < this.h.size(); i++) {
                this.r.add(i, false);
            }
        }
        b();
        a();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.q.b bVar) {
        if (this.t) {
            return;
        }
        if ("1".equals(ConfigMgr.readPropertie("IsOnlySupportEPGPayment", "1"))) {
            com.zte.iptvclient.android.mobile.order.helper.a aVar = new com.zte.iptvclient.android.mobile.order.helper.a(this.f6953a, this.m, this.n, this.o, this.p);
            this.i.add(aVar);
            ArrayList<d> arrayList = this.i;
            arrayList.get(arrayList.indexOf(aVar)).a(bVar.a(), this.j);
            dismiss();
        }
        this.t = true;
    }

    private void b() {
        this.f6954b = (RelativeLayout) findViewById(R.id.rl_package_dialog);
        this.f6955c = (TextView) findViewById(R.id.title);
        this.f6956d = (ListView) findViewById(R.id.ls_pacakge);
        this.e = (LinearLayout) findViewById(R.id.comm_dialog_bottom);
        this.f = (TextView) findViewById(R.id.ok);
        this.g = (TextView) findViewById(R.id.cancel);
        f.a(this.f6954b);
        f.a(this.f6955c);
        f.a(this.f6956d);
        f.a(this.e);
        f.a(this.f);
        f.a(this.g);
        this.f6955c.setText(this.f6953a.getResources().getString(R.string.order_format));
        c cVar = new c(this, this.f6953a, null);
        this.l = cVar;
        this.f6956d.setAdapter((ListAdapter) cVar);
    }

    private void a() {
        this.f.setOnClickListener(new ViewOnClickListenerC0325a());
        this.g.setOnClickListener(new b());
    }

    public String a(String str, String str2, String str3, String str4) {
        LogEx.d("CommonOrderProductDialogNew", "purChaseType " + str + " ;chargeType " + str2 + " ;rentalTerm " + str3 + " ;rentalUnit " + str4);
        StringBuilder sb = new StringBuilder();
        if ("0".equals(str)) {
            if ("2".equals(str2)) {
                sb.append(this.f6953a.getString(R.string.tip_my_package_range_from) + " ");
                String format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).format(ServerDate.getEpgTime());
                sb.append(format);
                sb.append(" " + this.f6953a.getString(R.string.tip_my_package_range_to) + " ");
                try {
                    sb.append(a(Integer.parseInt(str3), str4, format));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else if (TextUtils.equals(str2, "3")) {
                sb.append(this.f6953a.getString(R.string.tip_my_package_range_from) + " ");
                String format2 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).format(ServerDate.getEpgTime());
                sb.append(format2);
                sb.append(" " + this.f6953a.getString(R.string.tip_my_package_range_to) + " ");
                try {
                    sb.append(a(Integer.parseInt(str3), str4, format2));
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
            } else {
                sb.append(this.f6953a.getString(R.string.tip_my_package_range_from) + " ");
                String format3 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).format(ServerDate.getEpgTime());
                sb.append(format3);
                sb.append(" " + this.f6953a.getString(R.string.tip_my_package_range_to) + " ");
                try {
                    sb.append(a(Integer.parseInt(str3), str4, format3));
                } catch (ParseException e3) {
                    e3.printStackTrace();
                }
            }
        } else if (TextUtils.equals(str, "3")) {
            sb.append(this.f6953a.getString(R.string.tip_my_package_range_from) + " ");
            String format4 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).format(ServerDate.getEpgTime());
            sb.append(format4);
            sb.append(" " + this.f6953a.getString(R.string.tip_my_package_range_to) + " ");
            try {
                sb.append(a(Integer.parseInt(str3), str4, format4));
            } catch (ParseException e4) {
                e4.printStackTrace();
            }
        } else if (TextUtils.equals(str, "2")) {
            sb.append(this.f6953a.getString(R.string.tip_my_package_range_from) + " ");
            String format5 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).format(ServerDate.getEpgTime());
            sb.append(format5);
            sb.append(" " + this.f6953a.getString(R.string.tip_my_package_range_to) + " ");
            try {
                sb.append(a(Integer.parseInt(str3), str4, format5));
            } catch (ParseException e5) {
                e5.printStackTrace();
            }
        }
        return sb.toString();
    }

    public String a(int i, String str, String str2) throws ParseException {
        LogEx.d("CommonOrderProductDialogNew", "num " + i + " rentalunit " + str);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        simpleDateFormat.parse(str2);
        Calendar calendar = Calendar.getInstance();
        if ("1".equals(str)) {
            calendar.add(5, i);
        } else if ("2".equals(str)) {
            calendar.add(7, i);
        } else if ("3".equals(str)) {
            calendar.add(2, i);
        } else if ("4".equals(str)) {
            calendar.add(2, i / 6);
        } else if (DownloadConstant.REPORT_MSGTYPE_ADD.equals(str)) {
            calendar.add(2, i);
        } else if (DownloadConstant.REPORT_MSGTYPE_URL_NULL.equals(str)) {
            calendar.add(11, i);
        } else if (DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT.equals(str)) {
            calendar.add(12, i);
        } else if ("8".equals(str)) {
            calendar.add(2, i / 3);
        }
        String format = simpleDateFormat.format(calendar.getTime());
        LogEx.d("CommonOrderProductDialogNew", " plusDay 增加天数以后的日期 " + format);
        return format;
    }

    public String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if ("1".equals(str2)) {
            sb.append(str + " ");
            sb.append(this.f6953a.getString(R.string.time_day));
        } else if ("2".equals(str2)) {
            sb.append(str + " ");
            sb.append(this.f6953a.getString(R.string.time_week));
        } else if ("3".equals(str2)) {
            sb.append(String.format("%1$s", Integer.valueOf(Integer.valueOf(str).intValue())) + " ");
            sb.append(this.f6953a.getString(R.string.time_month));
        } else if ("4".equals(str2)) {
            sb.append(str + " ");
            sb.append(this.f6953a.getString(R.string.time_half_year));
        } else if (DownloadConstant.REPORT_MSGTYPE_ADD.equals(str2)) {
            sb.append(str + " ");
            sb.append(this.f6953a.getString(R.string.time_month));
        } else if (DownloadConstant.REPORT_MSGTYPE_URL_NULL.equals(str2)) {
            sb.append(str + " ");
            sb.append(this.f6953a.getString(R.string.time_hour));
        } else if (DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT.equals(str2)) {
            int intValue = Integer.valueOf(str).intValue() / 60;
            if (intValue < 1) {
                intValue = 1;
            }
            sb.append(String.format("%1$s", Integer.valueOf(intValue)) + " ");
            sb.append(this.f6953a.getString(R.string.time_hour));
        } else if ("8".equals(str2)) {
            sb.append(str + " ");
            sb.append(this.f6953a.getString(R.string.time_season));
        } else {
            sb.append(str + " ");
            sb.append(this.f6953a.getString(R.string.time_min));
        }
        return sb.toString();
    }
}
