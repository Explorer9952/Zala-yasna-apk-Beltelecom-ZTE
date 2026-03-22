package com.zte.iptvclient.android.mobile.c0.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BalanceFragment.java */
/* loaded from: classes2.dex */
public class a extends com.zte.fragmentlib.b {
    private Button p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private b u = new b(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BalanceFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.c0.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewOnClickListenerC0196a implements View.OnClickListener {
        ViewOnClickListenerC0196a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.getActivity() instanceof MainActivity) {
                a.this.F();
            } else if (a.this.getActivity() instanceof HostActivity) {
                a.this.getActivity().finish();
            }
        }
    }

    /* compiled from: BalanceFragment.java */
    /* loaded from: classes2.dex */
    private static final class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<a> f5623a;

        public b(a aVar) {
            this.f5623a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            a aVar = this.f5623a.get();
            if (aVar == null) {
                return;
            }
            switch (message.what) {
                case 61697:
                    String str = (String) message.obj;
                    aVar.q.setVisibility(0);
                    aVar.q.setText(str + ".00 " + ((com.zte.fragmentlib.b) aVar).h.getResources().getString(R.string.money_unit_sign));
                    aVar.r.setVisibility(8);
                    aVar.s.setVisibility(0);
                    aVar.t.setVisibility(0);
                    return;
                case 61698:
                    aVar.q.setVisibility(4);
                    aVar.r.setText(((com.zte.fragmentlib.b) aVar).h.getResources().getString(R.string.refill_query_failed));
                    aVar.r.setVisibility(0);
                    aVar.s.setVisibility(8);
                    aVar.t.setVisibility(8);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BalanceFragment.java */
    /* loaded from: classes2.dex */
    public class c extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private String f5624a;

        /* renamed from: b, reason: collision with root package name */
        private String f5625b;

        /* renamed from: c, reason: collision with root package name */
        private String f5626c;

        /* compiled from: BalanceFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.c0.b.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0197a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
            C0197a() {
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                String str2 = "0";
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!"0".equals(jSONObject.optString("returncode"))) {
                        a.this.u.sendEmptyMessage(61698);
                        return;
                    }
                    if (!TextUtils.isEmpty(jSONObject.optString("balance"))) {
                        str2 = jSONObject.optString("balance");
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 61697;
                    obtain.obj = str2;
                    a.this.u.sendMessage(obtain);
                } catch (JSONException e) {
                    e.printStackTrace();
                    a.this.u.sendEmptyMessage(61698);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                a.this.u.sendEmptyMessage(61698);
            }
        }

        public c(String str, String str2, String str3) {
            this.f5624a = str;
            this.f5625b = str2;
            this.f5626c = str3;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
            sDKNetHTTPRequest.setHeader("Cookie", this.f5625b);
            sDKNetHTTPRequest.setCharset(this.f5626c);
            sDKNetHTTPRequest.startRequest(this.f5624a, HttpRequest.METHOD_GET, new C0197a());
        }
    }

    private void J() {
        this.p.setOnClickListener(new ViewOnClickListenerC0196a());
    }

    public void I() {
        new c("http://{ipadd:port}/iptvepg/{frame}/sdk_getbalance.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", i.f()), i.h(), "gbk").start();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_balance, (ViewGroup) null);
        d(inflate);
        I();
        J();
        return inflate;
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.p = (Button) view.findViewById(R.id.btn_back);
        if (BaseApp.a(this.h)) {
            this.p.setVisibility(8);
        } else {
            this.p.setVisibility(0);
        }
        ((TextView) view.findViewById(R.id.title_txt)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.my_balance));
        this.q = (TextView) view.findViewById(R.id.txt_balance);
        this.r = (TextView) view.findViewById(R.id.txt_balance_error);
        this.s = (TextView) view.findViewById(R.id.line);
        this.t = (TextView) view.findViewById(R.id.txt_balanceDetail);
        f.a(this.p);
        f.a(this.r);
        f.a(view.findViewById(R.id.title_txt));
        f.a(view.findViewById(R.id.title_rlayout));
        f.a(view.findViewById(R.id.img_balance));
        f.a(view.findViewById(R.id.txt_balance));
        f.a(view.findViewById(R.id.line));
        f.a(view.findViewById(R.id.txt_balanceDetail));
        f.a(view.findViewById(R.id.header_bottom_line));
        ImageView imageView = (ImageView) view.findViewById(R.id.header_bottom_line);
        f.a(imageView);
        if (BaseApp.a(this.h)) {
            imageView.setVisibility(0);
            g.a(imageView, this.h);
        }
    }
}
