package com.zte.iptvclient.android.common.update;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: VersionUpdateFragment.java */
/* loaded from: classes.dex */
public class c extends com.zte.fragmentlib.b {
    private ImageView p;
    private Button q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private long v = 0;
    private h w;
    private RelativeLayout x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VersionUpdateFragment.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.J()) {
                return;
            }
            String X = c.this.w.X();
            LogEx.d("VersionUpdateFragment", "strUrl = " + X);
            if (StringUtil.isEmptyString(X)) {
                return;
            }
            try {
                Uri parse = Uri.parse(X.trim());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (((com.zte.fragmentlib.b) c.this).h != null) {
                    intent.putExtra("com.android.browser.application_id", ((com.zte.fragmentlib.b) c.this).h.getApplication().getPackageName());
                    ((com.zte.fragmentlib.b) c.this).h.startActivity(intent);
                }
            } catch (Exception e) {
                LogEx.e("VersionUpdateFragment", e.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VersionUpdateFragment.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BaseApp.f()) {
                c.this.getFragmentManager().F();
            } else {
                c.this.D();
            }
        }
    }

    private String I() {
        try {
            String str = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;
            if (!str.startsWith("V")) {
                str = "V" + str;
            }
            LogEx.d("VersionUpdateFragment", "version is : " + str);
            return !StringUtil.isEmptyString(str) ? str : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.v <= 500) {
            LogEx.w("UseeTv", "Operate limit,less than 500(ms)!");
            return true;
        }
        this.v = currentTimeMillis;
        return false;
    }

    private void K() {
        this.x.setOnClickListener(new a());
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        if (getActivity() instanceof MainActivity) {
            F();
            return true;
        }
        if (!(getActivity() instanceof HostActivity)) {
            return true;
        }
        getActivity().finish();
        return true;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.w = new h(this.h);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.version_update_fragment_hd, (ViewGroup) null);
        d(inflate);
        String W = this.w.W();
        this.u.setText(I());
        if (e(I(), W).booleanValue()) {
            this.s.setVisibility(0);
            this.t.setVisibility(8);
            this.p.setVisibility(0);
            this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.new_vierson_upate_tip) + " " + W);
            K();
        } else {
            this.s.setVisibility(8);
            this.t.setVisibility(0);
            this.p.setVisibility(8);
            this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.no_update));
        }
        return inflate;
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.q = (Button) view.findViewById(R.id.btn_back);
        TextView textView2 = (TextView) view.findViewById(R.id.web_title_txt);
        this.r = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.about_us));
        this.s = (TextView) view.findViewById(R.id.txt_version_number_current);
        this.t = (TextView) view.findViewById(R.id.txt_version_number_new);
        this.u = (TextView) view.findViewById(R.id.text_current_version);
        this.p = (ImageView) view.findViewById(R.id.version_arrow);
        this.x = (RelativeLayout) view.findViewById(R.id.rl_version_update);
        f.a(this.q);
        f.a(this.r);
        f.a(this.s);
        f.a(this.t);
        f.a(this.u);
        f.a(this.p);
        f.a(view.findViewById(R.id.rl_version));
        f.a(view.findViewById(R.id.version_img));
        f.a(view.findViewById(R.id.rl_version_update));
        f.a(view.findViewById(R.id.bottom_line01));
        f.a(view.findViewById(R.id.bottom_line02));
        f.a(view.findViewById(R.id.web_title_rlayout));
        f.a(view.findViewById(R.id.header_bottom_line));
        this.q.setOnClickListener(new b());
        ImageView imageView = (ImageView) view.findViewById(R.id.header_bottom_line);
        f.a(imageView);
        if (BaseApp.a(this.h)) {
            g.a(imageView, this.h);
        }
    }

    private Boolean e(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str4.startsWith("V")) {
            str4 = str4.substring(1);
        }
        String[] split = str4.split("\\.");
        if (4 != split.length) {
            LogEx.w("VersionUpdateFragment", " illegal ServerVersionName");
        }
        String str5 = split[0];
        String str6 = split[1];
        String str7 = split[2];
        String str8 = split.length >= 4 ? split[3] : "0";
        int intValue = Integer.valueOf(str5).intValue();
        int intValue2 = Integer.valueOf(str6).intValue();
        int intValue3 = Integer.valueOf(str7).intValue();
        int intValue4 = split.length >= 4 ? Integer.valueOf(str8).intValue() : 0;
        if (StringUtil.isEmptyString(str)) {
            return false;
        }
        if (str3.startsWith("V")) {
            str3 = str3.substring(1);
        }
        String[] split2 = str3.split("\\.");
        if (4 != split2.length) {
            LogEx.w("VersionUpdateFragment", " illegal curVersionName");
        }
        String str9 = split2[0];
        String str10 = split2[1];
        String str11 = split2[2];
        String str12 = split2.length >= 4 ? split2[3] : "0";
        int intValue5 = Integer.valueOf(str9).intValue();
        int intValue6 = Integer.valueOf(str10).intValue();
        int intValue7 = Integer.valueOf(str11).intValue();
        int intValue8 = split2.length >= 4 ? Integer.valueOf(str12).intValue() : 0;
        if (intValue <= intValue5 && ((intValue != intValue5 || intValue2 <= intValue6) && ((intValue != intValue5 || intValue2 != intValue6 || intValue3 <= intValue7) && (intValue != intValue5 || intValue2 != intValue6 || intValue3 != intValue7 || intValue4 <= intValue8)))) {
            return false;
        }
        return true;
    }
}
