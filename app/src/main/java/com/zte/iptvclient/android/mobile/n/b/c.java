package com.zte.iptvclient.android.mobile.n.b;

import android.app.Activity;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.login.activity.LoginActivity;
import com.zte.iptvclient.android.zala.R;
import java.util.HashMap;

/* compiled from: AtRegisterFragment.java */
/* loaded from: classes.dex */
public class c extends com.zte.fragmentlib.b {
    private WebView p;
    private Button q;
    private String r;
    private LinearLayout s;
    private InterfaceC0310c t;
    Activity u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtRegisterFragment.java */
    /* loaded from: classes.dex */
    public class a extends WebViewClient {

        /* compiled from: AtRegisterFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.n.b.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0309a implements t.e {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ SslErrorHandler f6802a;

            C0309a(a aVar, SslErrorHandler sslErrorHandler) {
                this.f6802a = sslErrorHandler;
            }

            @Override // com.zte.iptvclient.android.common.k.t.e
            public void a() {
                this.f6802a.cancel();
            }

            @Override // com.zte.iptvclient.android.common.k.t.e
            public void b() {
                this.f6802a.proceed();
            }
        }

        a() {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            t.a(c.this.getActivity(), com.zte.iptvclient.android.common.i.a.a.a(R.string.register_sslcertificate), new C0309a(this, sslErrorHandler));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            LogEx.d("AtRegisterFragment", "url is " + str);
            if (str.startsWith("zte")) {
                HashMap hashMap = new HashMap();
                if (str.startsWith("zte://127.0.0.1/webviewreturn?type=1&result=0")) {
                    int indexOf = str.indexOf("&username=") + 10;
                    int indexOf2 = str.indexOf("&password=");
                    String substring = str.substring(indexOf, indexOf2);
                    String substring2 = str.substring(indexOf2 + 10, str.length());
                    hashMap.put("returncode", "0");
                    hashMap.put("username", substring);
                    hashMap.put("password", substring2);
                    LogEx.d("AtRegisterFragment", "register success,user name is " + substring);
                    if (BaseApp.a(((com.zte.fragmentlib.b) c.this).h)) {
                        c.this.t.a(hashMap);
                        c.this.F();
                    } else {
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putString("name", substring);
                        bundle.putString("pwd", substring2);
                        intent.putExtras(bundle);
                        c.this.getActivity().setResult(1, intent);
                        c.this.getActivity().finish();
                    }
                    return true;
                }
            } else if (str.contains("app_terms")) {
                c.this.p.loadUrl(str);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtRegisterFragment.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.s.removeView(c.this.p);
            if (!(c.this.getActivity() instanceof MainActivity) && !(c.this.getActivity() instanceof LoginActivity)) {
                if (c.this.getActivity() instanceof HostActivity) {
                    c.this.getActivity().finish();
                    return;
                }
                return;
            }
            c.this.F();
        }
    }

    /* compiled from: AtRegisterFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.n.b.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0310c {
        void a(HashMap hashMap);
    }

    private void I() {
        if (BaseApp.a(getActivity())) {
            com.zte.iptvclient.android.mobile.n.b.a.a((Activity) getActivity());
        }
        K();
        this.p.loadUrl(this.r);
        this.p.getSettings().setJavaScriptEnabled(true);
        this.p.getSettings().setSupportZoom(true);
        this.p.setScrollBarStyle(0);
        this.p.getSettings().setPluginState(WebSettings.PluginState.ON);
        this.p.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.p.getSettings().setUseWideViewPort(true);
        this.p.getSettings().setLoadWithOverviewMode(true);
        this.p.getSettings().setCacheMode(2);
        this.p.getSettings().setAllowFileAccess(true);
        this.p.getSettings().setBuiltInZoomControls(false);
        this.p.setWebChromeClient(new WebChromeClient());
        this.p.getSettings().setDomStorageEnabled(true);
        this.p.setWebViewClient(new a());
    }

    private void J() {
        this.q.setOnClickListener(new b());
    }

    private void K() {
        String ePGPort = SDKLoginMgr.getInstance().getEPGPort();
        String hTTPSessionID = SDKLoginMgr.getInstance().getHTTPSessionID();
        String ePGHost = SDKLoginMgr.getInstance().getEPGHost();
        if (!StringUtil.isEmptyString(hTTPSessionID) && !StringUtil.isEmptyString(ePGHost)) {
            CookieSyncManager.createInstance(this.h);
            CookieManager cookieManager = CookieManager.getInstance();
            String str = "JSESSIONID=" + hTTPSessionID + "; domain=" + ePGHost;
            String str2 = ePGHost + ":" + ePGPort;
            LogEx.d("AtRegisterFragment", "Set " + str2 + " cookie to " + str);
            String cookie = cookieManager.getCookie(str2);
            StringBuilder sb = new StringBuilder();
            sb.append("strOldCookie=");
            sb.append(cookie);
            LogEx.d("AtRegisterFragment", sb.toString());
            cookieManager.setAcceptCookie(true);
            if (!StringUtil.isEmptyString(cookie)) {
                cookieManager.removeAllCookie();
            }
            cookieManager.setCookie(str2, str);
            LogEx.d("AtRegisterFragment", "strCurCookie=" + cookieManager.getCookie(str2));
            CookieSyncManager.getInstance().sync();
            return;
        }
        LogEx.d("AtRegisterFragment", "url、strJSessionID or strEpgDomain has one is empty");
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        I();
        J();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.u = activity;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.r = getArguments().getString("weburl");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_at_register, (ViewGroup) null);
        d(inflate);
        return inflate;
    }

    private void d(View view) {
        if (BaseApp.a(this.u)) {
            TextView textView = (TextView) view.findViewById(R.id.top);
            int a2 = v.a();
            if (a2 <= 0) {
                a2 = 60;
            }
            textView.setHeight(a2);
        } else {
            view.findViewById(R.id.top).setVisibility(8);
        }
        Button button = (Button) view.findViewById(R.id.btn_back);
        this.q = button;
        button.setVisibility(0);
        TextView textView2 = (TextView) view.findViewById(R.id.title_txt);
        textView2.setText(R.string.regist);
        textView2.setTextSize(20.0f);
        this.p = (WebView) view.findViewById(R.id.at_register_web);
        this.s = (LinearLayout) view.findViewById(R.id.layout);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(textView2);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_title));
    }
}
