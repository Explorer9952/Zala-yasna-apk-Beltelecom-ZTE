package com.zte.iptvclient.android.common.customview.a.a.e;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.zala.R;

/* compiled from: MessageDialog.java */
/* loaded from: classes.dex */
public class h extends AlertDialog {

    /* renamed from: a, reason: collision with root package name */
    private TextView f4253a;

    /* renamed from: b, reason: collision with root package name */
    private WebView f4254b;

    /* renamed from: c, reason: collision with root package name */
    private String f4255c;

    /* renamed from: d, reason: collision with root package name */
    private Context f4256d;

    /* compiled from: MessageDialog.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.dismiss();
        }
    }

    public h(Context context, int i) {
        super(context, i);
        this.f4255c = "MessageDialog";
        this.f4256d = context;
    }

    private void a() {
        String str = com.zte.iptvclient.android.common.f.b.i.f() + "app_marquee.jsp?lan=" + b();
        LogEx.d(this.f4255c, " " + str);
        c();
        this.f4254b.loadUrl(str);
        this.f4254b.getSettings().setJavaScriptEnabled(true);
        this.f4254b.getSettings().setSupportZoom(true);
        this.f4254b.setScrollBarStyle(0);
        this.f4254b.getSettings().setPluginState(WebSettings.PluginState.ON);
        this.f4254b.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.f4254b.setInitialScale(250);
        this.f4254b.getSettings().setCacheMode(2);
        this.f4254b.getSettings().setAllowFileAccess(true);
        this.f4254b.getSettings().setBuiltInZoomControls(false);
        this.f4254b.setWebChromeClient(new WebChromeClient());
        this.f4254b.getSettings().setDomStorageEnabled(true);
        this.f4254b.setWebViewClient(new WebViewClient());
    }

    private static String b() {
        String lowerCase = BaseApp.e().getResources().getConfiguration().locale.getLanguage().toLowerCase();
        return "be".equals(lowerCase) ? "be" : (!LocaleUtil.RUSSIAN.equals(lowerCase) && "en".equals(lowerCase)) ? "en" : LocaleUtil.RUSSIAN;
    }

    private void c() {
        String ePGPort = SDKLoginMgr.getInstance().getEPGPort();
        String hTTPSessionID = SDKLoginMgr.getInstance().getHTTPSessionID();
        String ePGHost = SDKLoginMgr.getInstance().getEPGHost();
        if (!StringUtil.isEmptyString(hTTPSessionID) && !StringUtil.isEmptyString(ePGHost)) {
            CookieSyncManager.createInstance(this.f4256d);
            CookieManager cookieManager = CookieManager.getInstance();
            String str = "JSESSIONID=" + hTTPSessionID + "; domain=" + ePGHost;
            String str2 = ePGHost + ":" + ePGPort;
            LogEx.d(this.f4255c, "Set " + str2 + " cookie to " + str);
            String cookie = cookieManager.getCookie(str2);
            LogEx.d(this.f4255c, "strOldCookie=" + cookie);
            cookieManager.setAcceptCookie(true);
            if (!StringUtil.isEmptyString(cookie)) {
                cookieManager.removeAllCookie();
            }
            cookieManager.setCookie(str2, str);
            String cookie2 = cookieManager.getCookie(str2);
            LogEx.d(this.f4255c, "strCurCookie=" + cookie2);
            CookieSyncManager.getInstance().sync();
            return;
        }
        LogEx.d(this.f4255c, "url、strJSessionID or strEpgDomain has one is empty");
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.message_dialog);
        this.f4253a = (TextView) findViewById(R.id.ok);
        this.f4254b = (WebView) findViewById(R.id.webview);
        a();
        this.f4253a.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm));
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.rl_message_dialog));
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.ll_ok));
        com.zte.iptvclient.common.uiframe.f.a(this.f4253a);
        this.f4253a.setOnClickListener(new a());
    }
}
