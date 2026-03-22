package com.zte.iptvclient.android.mobile.user.fragment;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.video.androidsdk.download.DownloadConstant;
import com.zte.iptvclient.android.zala.R;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/* compiled from: AdapterTerminalConcurrency.java */
/* loaded from: classes2.dex */
public class a extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Context f7409a;

    /* renamed from: b, reason: collision with root package name */
    private List<com.zte.iptvclient.android.common.javabean.g> f7410b;

    /* compiled from: AdapterTerminalConcurrency.java */
    /* loaded from: classes2.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        ImageView f7411a;

        /* renamed from: b, reason: collision with root package name */
        TextView f7412b;

        /* renamed from: c, reason: collision with root package name */
        TextView f7413c;

        /* renamed from: d, reason: collision with root package name */
        TextView f7414d;
        TextView e;

        private b() {
        }
    }

    public a(Context context, List<com.zte.iptvclient.android.common.javabean.g> list) {
        this.f7409a = context;
        this.f7410b = list;
    }

    private String a(String str) {
        Double valueOf = Double.valueOf(0.0d);
        if (TextUtils.isEmpty(str)) {
            return valueOf.toString();
        }
        int parseInt = !TextUtils.isEmpty(com.zte.iptvclient.common.uiframe.a.c("Fee_Rate")) ? Integer.parseInt(com.zte.iptvclient.common.uiframe.a.c("Fee_Rate")) : 100;
        int i = parseInt != 0 ? parseInt : 100;
        double doubleValue = Double.valueOf(str).doubleValue();
        double d2 = i;
        Double.isNaN(d2);
        return a(Double.valueOf(doubleValue / d2));
    }

    private String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c2 = 0;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c2 = 1;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c2 = 2;
                    break;
                }
                break;
            case 53:
                if (str.equals(DownloadConstant.REPORT_MSGTYPE_ADD)) {
                    c2 = 3;
                    break;
                }
                break;
            case 54:
                if (str.equals(DownloadConstant.REPORT_MSGTYPE_URL_NULL)) {
                    c2 = 4;
                    break;
                }
                break;
            case 55:
                if (str.equals(DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT)) {
                    c2 = 5;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            return com.zte.iptvclient.android.common.i.a.a.a(R.string.time_day);
        }
        if (c2 == 1) {
            return com.zte.iptvclient.android.common.i.a.a.a(R.string.time_week);
        }
        if (c2 == 2) {
            return com.zte.iptvclient.android.common.i.a.a.a(R.string.time_month);
        }
        if (c2 == 3) {
            return com.zte.iptvclient.android.common.i.a.a.a(R.string.time_year);
        }
        if (c2 != 4) {
            return c2 != 5 ? "" : com.zte.iptvclient.android.common.i.a.a.a(R.string.time_min);
        }
        return com.zte.iptvclient.android.common.i.a.a.a(R.string.time_hour);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<com.zte.iptvclient.android.common.javabean.g> list = this.f7410b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        if (view == null) {
            bVar = new b();
            view2 = LayoutInflater.from(this.f7409a).inflate(R.layout.item_concurrency, (ViewGroup) null);
            bVar.f7411a = (ImageView) view2.findViewById(R.id.img_package);
            bVar.f7412b = (TextView) view2.findViewById(R.id.txt_package_name);
            bVar.f7413c = (TextView) view2.findViewById(R.id.txt_puchased);
            bVar.f7414d = (TextView) view2.findViewById(R.id.txt_terminal);
            bVar.e = (TextView) view2.findViewById(R.id.txt_price);
            com.zte.iptvclient.common.uiframe.f.a(bVar.f7411a);
            com.zte.iptvclient.common.uiframe.f.a(bVar.f7412b);
            com.zte.iptvclient.common.uiframe.f.a(bVar.f7413c);
            com.zte.iptvclient.common.uiframe.f.a(bVar.f7414d);
            com.zte.iptvclient.common.uiframe.f.a(bVar.e);
            com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.img_tv));
            com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.img_phone));
            com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.layout_package));
            com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.layout_productdetail));
            view2.setTag(bVar);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        com.zte.iptvclient.android.common.javabean.g gVar = this.f7410b.get(i);
        bVar.f7412b.setText(gVar.e());
        if (TextUtils.equals("1", gVar.a())) {
            bVar.f7411a.setImageResource(R.drawable.poster_package_autorenew);
        } else {
            bVar.f7411a.setImageResource(R.drawable.poster_package);
        }
        if (gVar.f() == 0) {
            bVar.f7413c.setText("");
            bVar.f7413c.setVisibility(4);
        } else {
            bVar.f7413c.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.purchased_times), String.valueOf(gVar.f())));
            bVar.f7413c.setVisibility(0);
        }
        bVar.f7414d.setText(gVar.b() + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.terminal_txt));
        String a2 = a(gVar.c());
        String b2 = b(gVar.g());
        bVar.e.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_movie_price) + ":" + com.zte.iptvclient.android.common.i.a.a.a(R.string.money_unit_sign) + a2 + " / " + b2);
        return view2;
    }

    public String a(Double d2) {
        return a((d2 == null ? new BigDecimal("0.00") : new BigDecimal(d2.doubleValue())).setScale(2, 5));
    }

    private String a(BigDecimal bigDecimal) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
            return "0.00";
        }
        if (bigDecimal.compareTo(BigDecimal.ZERO) > 0 && bigDecimal.compareTo(new BigDecimal(1)) < 0) {
            return "0" + decimalFormat.format(bigDecimal);
        }
        return decimalFormat.format(bigDecimal);
    }
}
