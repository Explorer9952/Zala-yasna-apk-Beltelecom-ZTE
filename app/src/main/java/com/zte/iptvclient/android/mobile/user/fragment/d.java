package com.zte.iptvclient.android.mobile.user.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.TimeShowUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AtValidityDateFragment.java */
/* loaded from: classes2.dex */
public class d extends com.zte.fragmentlib.b {
    private Button p;
    private TextView q;
    private TextView r;
    private TextView s;
    private String t;
    private com.zte.iptvclient.android.common.j.h u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtValidityDateFragment.java */
    /* loaded from: classes2.dex */
    public class a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("returncode").equals("0")) {
                    d.this.t = jSONObject.getString("expiredtime");
                    try {
                        if (TextUtils.isEmpty(d.this.t)) {
                            return;
                        }
                        String format = new SimpleDateFormat(TimeShowUtil.STR_FORMAT_DATE2).format(new SimpleDateFormat("yyyyMMddhhmmss").parse(d.this.t));
                        d.this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.subscription_will_expire) + " " + format);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.e("userbalancequery", "onFailReturn::" + i + "userbalancequery" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtValidityDateFragment.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.D();
        }
    }

    private void I() {
        String c2 = com.zte.iptvclient.android.common.k.o.j().c();
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        String d2 = com.zte.iptvclient.common.uiframe.a.d("UserID");
        String a2 = com.zte.iptvclient.android.mobile.c0.d.a.a(d2);
        String d3 = this.u.d();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.setCharset("UTF-8");
        sDKNetHTTPRequest.setBody("usercode=" + d2 + "&opertype=1&bossusercode=" + d3 + "&authinfo=" + a2);
        sDKNetHTTPRequest.startRequest(c2 + "/queryvaliditydate", HttpRequest.METHOD_POST, new a());
    }

    private void J() {
        this.p.setOnClickListener(new b());
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.p = (Button) view.findViewById(R.id.btn_back);
        this.q = (TextView) view.findViewById(R.id.title_txt);
        this.r = (TextView) view.findViewById(R.id.txt_balance);
        TextView textView2 = (TextView) view.findViewById(R.id.txt_display);
        this.s = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.balance_display_svod));
        this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.validity_date));
        this.p.setVisibility(0);
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
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
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        I();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.at_balance_fragment, (ViewGroup) null);
        d(inflate);
        J();
        this.u = new com.zte.iptvclient.android.common.j.h(this.h);
        return inflate;
    }
}
