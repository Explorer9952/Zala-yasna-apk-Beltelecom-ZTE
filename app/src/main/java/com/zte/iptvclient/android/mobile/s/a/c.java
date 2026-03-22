package com.zte.iptvclient.android.mobile.s.a;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.video.androidsdk.download.DownloadConstant;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.common.k.w;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.productpackage.fragment.bean.PackageBean;
import com.zte.iptvclient.android.zala.R;

/* compiled from: PackageDetailFragemnt.java */
/* loaded from: classes2.dex */
public class c extends com.zte.fragmentlib.b {
    private Button p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private PackageBean v;
    private ImageView w;
    private String x;
    private String y;
    private TextView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PackageDetailFragemnt.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.getActivity() instanceof MainActivity) {
                c.this.F();
            } else if (c.this.getActivity() instanceof HostActivity) {
                c.this.getActivity().finish();
            }
        }
    }

    private void I() {
        this.p.setOnClickListener(new a());
    }

    private void J() {
        PackageBean packageBean = this.v;
        if (packageBean != null) {
            if (!TextUtils.isEmpty(packageBean.b()) && !TextUtils.isEmpty(this.v.f())) {
                this.q.setText(this.v.c());
                this.t.setVisibility(0);
                String str = com.zte.iptvclient.android.common.i.a.a.a(R.string.package_purchase_time) + this.x.replaceAll("/", ".");
                String str2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.package_available_unit) + this.y.replaceAll("/", ".");
                this.t.setText(str);
                this.u.setText(str2);
                String k = this.v.k();
                String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_price);
                if (!TextUtils.isEmpty(k)) {
                    try {
                        a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_price) + " " + w.b(Double.valueOf(k).doubleValue()) + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.money_unit_sign);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                this.r.setText(a2);
            } else {
                this.q.setText(this.v.m());
                this.v.d().equals("0");
                String a3 = this.v.d().equals("1") ? com.zte.iptvclient.android.common.i.a.a.a(R.string.time_day) : "";
                if (this.v.d().equals("2")) {
                    a3 = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_week);
                }
                if (this.v.d().equals("3")) {
                    a3 = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_month);
                }
                if (this.v.d().equals("4")) {
                    a3 = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_half_year);
                }
                if (this.v.d().equals(DownloadConstant.REPORT_MSGTYPE_ADD)) {
                    a3 = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_year);
                }
                if (this.v.d().equals(DownloadConstant.REPORT_MSGTYPE_URL_NULL)) {
                    a3 = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_hour);
                }
                if (this.v.d().equals(DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT)) {
                    a3 = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_min);
                }
                if (this.v.d().equals("8")) {
                    a3 = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_season);
                }
                this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_price) + (Double.valueOf(com.zte.iptvclient.android.mobile.s.a.g.a.a(Integer.valueOf(this.v.k()))).doubleValue() / 100.0d) + "0/" + a3);
                if (this.v.n().equals(DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT)) {
                    this.w.setVisibility(0);
                } else {
                    this.w.setVisibility(8);
                }
                this.t.setVisibility(4);
            }
        }
        PackageBean packageBean2 = this.v;
        if (packageBean2 != null && packageBean2.e() != null) {
            this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_movie_detail) + ":  " + this.v.e());
            return;
        }
        this.s.setText("");
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.z = (TextView) view.findViewById(R.id.title_txt);
        this.p = (Button) view.findViewById(R.id.btn_back);
        this.q = (TextView) view.findViewById(R.id.package_name);
        this.t = (TextView) view.findViewById(R.id.ordertime);
        this.r = (TextView) view.findViewById(R.id.price);
        this.s = (TextView) view.findViewById(R.id.detail);
        this.w = (ImageView) view.findViewById(R.id.est_icon);
        this.u = (TextView) view.findViewById(R.id.effective_time);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.package_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.view));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.llpackage));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_package_detail));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.btn_back));
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        this.z.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.package_detail));
        ImageView imageView = (ImageView) view.findViewById(R.id.view);
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        if (BaseApp.a(this.h)) {
            g.a(imageView, this.h);
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            PackageBean packageBean = (PackageBean) arguments.getParcelable("dataBean");
            this.v = packageBean;
            if (packageBean != null) {
                this.x = packageBean.b();
                this.y = this.v.f();
            }
        }
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.packagedetail_mobile_layout, (ViewGroup) null);
        d(inflate);
        I();
        J();
        return inflate;
    }
}
