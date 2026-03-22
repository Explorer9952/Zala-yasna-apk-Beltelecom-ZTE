package com.zte.iptvclient.android.common.customview.a.a.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.video.androidsdk.common.ServerDate;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.bean.Product;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.k.w;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;

/* compiled from: OrderDialog.java */
/* loaded from: classes.dex */
public class c extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    String f4151a;

    /* renamed from: b, reason: collision with root package name */
    private Context f4152b;

    /* renamed from: c, reason: collision with root package name */
    private RelativeLayout f4153c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f4154d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private EditText i;
    private TextView j;
    private LinearLayout k;
    private TextView l;
    private TextView m;
    private Product n;
    private h o;
    private String p;
    private long q;
    private String r;

    /* compiled from: OrderDialog.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.b()) {
                return;
            }
            if (!TextUtils.equals(c.this.i.getText().toString(), c.this.o.u())) {
                c.this.j.setVisibility(0);
                c.this.j.setText(c.this.f4152b.getResources().getString(R.string.limitpwd_is_wrong));
            } else {
                com.zte.iptvclient.android.common.e.q.b bVar = new com.zte.iptvclient.android.common.e.q.b();
                bVar.a(c.this.n);
                EventBus.getDefault().post(bVar);
                c.this.dismiss();
            }
        }
    }

    /* compiled from: OrderDialog.java */
    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
        }
    }

    public c(Context context, int i, Product product, String str) {
        super(context, i);
        this.f4151a = "OrderDialog";
        this.q = 0L;
        this.f4152b = context;
        this.n = product;
        this.r = str;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.order_commoninput_dialog);
        this.o = new h(this.f4152b);
        this.f4153c = (RelativeLayout) findViewById(R.id.rl_order_dialog);
        this.f4154d = (TextView) findViewById(R.id.title);
        this.f = (TextView) findViewById(R.id.rentalterm);
        this.g = (TextView) findViewById(R.id.pacakge_name);
        this.e = (TextView) findViewById(R.id.price);
        this.h = (TextView) findViewById(R.id.tips);
        this.i = (EditText) findViewById(R.id.parental_password);
        this.j = (TextView) findViewById(R.id.txtvew_show_tips);
        this.k = (LinearLayout) findViewById(R.id.comm_dialog_bottom);
        this.l = (TextView) findViewById(R.id.buy);
        this.m = (TextView) findViewById(R.id.cancel);
        f.a(this.f4153c);
        f.a(this.f4154d);
        f.a(this.f);
        f.a(this.g);
        f.a(this.e);
        f.a(this.h);
        f.a(this.i);
        f.a(this.j);
        f.a(this.k);
        f.a(this.l);
        f.a(this.m);
        this.f4154d.setText(this.f4152b.getResources().getString(R.string.confirm_order));
        this.g.setText(this.n.getProductname());
        if (!TextUtils.isEmpty(this.n.getFee())) {
            this.p = w.b(Double.valueOf(Double.valueOf(this.n.getFee()).doubleValue() / 100.0d).doubleValue());
        }
        LogEx.d(this.f4151a, "getPurchasetype = " + this.n.getPurchasetype() + " Chargetype= " + this.n.getChargetype());
        this.f.setVisibility(0);
        this.f.setText(a(this.n.getPurchasetype(), this.n.getChargetype(), this.n.getRentalterm(), this.n.getRentalunit()));
        this.e.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.vod_cost_indicate) + this.p + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.money_unit_sign) + "/" + a(this.n.getRentalterm(), this.n.getRentalunit()) + " ");
        if ("3".equals(this.n.getPurchasetype())) {
            this.g.setText(this.r);
            this.e.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.vod_cost_indicate) + this.p + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.money_unit_sign) + "/" + a(this.n.getRentalterm(), this.n.getRentalunit()) + " ");
            this.f.setVisibility(0);
            this.f.setText(a(this.n.getPurchasetype(), this.n.getChargetype(), this.n.getRentalterm(), this.n.getRentalunit()));
        }
        if (TextUtils.isEmpty(this.n.getChargetype())) {
            this.f.setVisibility(0);
            this.f.setText(a(this.n.getPurchasetype(), this.n.getRentalterm(), this.n.getRentalunit()));
            this.e.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_price) + " " + this.p + this.f4152b.getResources().getString(R.string.money_unit_sign));
        }
        this.l.setOnClickListener(new a());
        this.m.setOnClickListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.q <= DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS) {
            LogEx.w("UseeTv", "Operate limit,less than 5000(ms)!");
            return true;
        }
        this.q = currentTimeMillis;
        return false;
    }

    public String a(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        sb.append(" " + this.f4152b.getString(R.string.tip_my_package_range_from) + " ");
        String format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).format(ServerDate.getEpgTime());
        sb.append(format);
        sb.append(" " + this.f4152b.getString(R.string.tip_my_package_range_to) + " ");
        try {
            sb.append(a(Integer.parseInt(str3), str4, format));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LogEx.d("getValidDate", sb.toString());
        return sb.toString();
    }

    public String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if ("1".equals(str2)) {
            sb.append(str + " ");
            sb.append(this.f4152b.getString(R.string.time_day));
        } else if ("2".equals(str2)) {
            sb.append(str + " ");
            sb.append(this.f4152b.getString(R.string.time_week));
        } else if ("3".equals(str2)) {
            sb.append(String.format("%1$s", Integer.valueOf(Integer.valueOf(str).intValue())) + " ");
            sb.append(this.f4152b.getString(R.string.time_month));
        } else if ("4".equals(str2)) {
            sb.append(str + " ");
            sb.append(this.f4152b.getString(R.string.time_half_year));
        } else if (DownloadConstant.REPORT_MSGTYPE_ADD.equals(str2)) {
            sb.append(str + " ");
            sb.append(this.f4152b.getString(R.string.time_month));
        } else if (DownloadConstant.REPORT_MSGTYPE_URL_NULL.equals(str2)) {
            sb.append(str + " ");
            sb.append(this.f4152b.getString(R.string.time_hour));
        } else if (DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT.equals(str2)) {
            int intValue = Integer.valueOf(str).intValue() / 60;
            if (intValue < 1) {
                intValue = 1;
            }
            sb.append(String.format("%1$s", Integer.valueOf(intValue)) + " ");
            sb.append(this.f4152b.getString(R.string.time_hour));
        } else if ("8".equals(str2)) {
            sb.append(str + " ");
            sb.append(this.f4152b.getString(R.string.time_season));
        } else {
            sb.append(str + " ");
            sb.append(this.f4152b.getString(R.string.time_min));
        }
        return sb.toString();
    }

    public String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.equals(str, "0")) {
            sb.append(" " + this.f4152b.getString(R.string.tip_my_package_range_from) + " ");
            String format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).format(ServerDate.getEpgTime());
            sb.append(format);
            sb.append(" " + this.f4152b.getString(R.string.tip_my_package_range_to) + " ");
            try {
                sb.append(a(Integer.parseInt(str2), str3, format));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if (TextUtils.equals(str, "3")) {
            sb.append(" " + this.f4152b.getString(R.string.tip_my_package_range_from) + " ");
            String format2 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).format(ServerDate.getEpgTime());
            sb.append(format2);
            sb.append(" " + this.f4152b.getString(R.string.tip_my_package_range_to) + " ");
            try {
                sb.append(a(Integer.parseInt(str2), str3, format2));
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        } else if (TextUtils.equals(str, "2")) {
            sb.append(this.f4152b.getString(R.string.valid_time));
            try {
                sb.append(a(Integer.parseInt(str2), str3, new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).format(ServerDate.getEpgTime())));
            } catch (ParseException e3) {
                e3.printStackTrace();
            }
        }
        LogEx.d("getValidDate", sb.toString());
        return sb.toString();
    }

    public String a(int i, String str, String str2) throws ParseException {
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
        System.out.println("增加天数以后的日期：" + format);
        return format;
    }

    public void a() {
        show();
    }
}
