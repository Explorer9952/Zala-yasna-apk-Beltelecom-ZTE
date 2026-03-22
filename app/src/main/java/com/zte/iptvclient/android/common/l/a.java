package com.zte.iptvclient.android.common.l;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.zte.iptvclient.android.common.customview.a.c.a;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.SDKUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: LoadWeb.java */
@SuppressLint({"UseValueOf"})
/* loaded from: classes.dex */
public class a {
    public static int q = 1;

    /* renamed from: a, reason: collision with root package name */
    public WebView f4834a;

    /* renamed from: b, reason: collision with root package name */
    private ProgressBar f4835b;

    /* renamed from: d, reason: collision with root package name */
    private e f4837d;
    private RelativeLayout f;
    private String h;
    private Context i;
    private h j;
    private f k;
    private int l;
    private Timer m;
    private TimerTask n;

    /* renamed from: c, reason: collision with root package name */
    private View f4836c = null;
    private WebChromeClient.CustomViewCallback e = null;
    private Handler g = new Handler();
    private boolean o = false;
    Handler p = new HandlerC0138a();

    /* compiled from: LoadWeb.java */
    /* renamed from: com.zte.iptvclient.android.common.l.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class HandlerC0138a extends Handler {
        HandlerC0138a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (!Thread.currentThread().isInterrupted()) {
                int i = message.what;
                if (i == 0) {
                    LogEx.d("LoadWeb", "===hide web===");
                } else if (i == 1) {
                    a.this.a(true);
                    LogEx.d("LoadWeb", "===show web===");
                }
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoadWeb.java */
    /* loaded from: classes.dex */
    public class b extends WebViewClient {
        b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            LogEx.d("LoadWeb", "onPageFinished : url " + str);
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            LogEx.d("LoadWeb", "onPageStarted:" + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            LogEx.d("LoadWeb", "errorCode: " + i + "description: " + str + "failingUrl: " + str2);
            a.this.k.b();
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            LogEx.d("LoadWeb", "web view reload new url1:" + str);
            if (str.startsWith("http://127.0.0.1/gettime")) {
                Log.d("LoadWeb", "web view reload new url3:" + str);
                try {
                    Map a2 = a.this.a(a.this.b(str));
                    if (a2 != null) {
                        String str2 = (String) a2.get("timetype");
                        if (!StringUtil.isEmptyString(str2) && str2 != null) {
                            str2.equals("1");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
            WebResourceResponse shouldInterceptRequest = super.shouldInterceptRequest(webView, str);
            LogEx.d("LoadWeb", "reponse url:" + str);
            return shouldInterceptRequest;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            LogEx.d("LoadWeb", "4.web view reload new url:" + str);
            if (str.startsWith("zte")) {
                Map a2 = a.this.a(a.this.b(str));
                if (str.equals("zte://127.0.0.1/onload")) {
                    a.this.m.cancel();
                }
                if (str.startsWith("zte://127.0.0.1/webviewreturn?result=0&")) {
                    int indexOf = str.indexOf("&username=") + 10;
                    int indexOf2 = str.indexOf("&password=");
                    a.this.k.a(str.substring(indexOf, indexOf2), str.substring(indexOf2 + 10, str.length()));
                } else if (str.equals("zte://127.0.0.1/webviewreturn?type=0")) {
                    a.this.k.onCancel();
                } else if (str.startsWith("zte://127.0.0.1/webviewjump?contenttype=")) {
                    int indexOf3 = str.indexOf("contenttype=") + 12;
                    int indexOf4 = str.indexOf("&programcode=");
                    String substring = str.substring(indexOf3, indexOf4);
                    int indexOf5 = str.indexOf("&contentcode=");
                    String substring2 = str.substring(indexOf4 + 13, indexOf5);
                    int indexOf6 = str.indexOf("&columncode=");
                    a.this.k.a(substring, substring2, str.substring(indexOf5 + 13, indexOf6), str.substring(indexOf6 + 12, str.length()));
                }
                if (str.equals("zte://127.0.0.1/webviewreturn")) {
                    return true;
                }
                if (a2 != null) {
                    String str2 = (String) a2.get("result");
                    String str3 = (String) a2.get("timetype");
                    if (!StringUtil.isEmptyString(str2) || StringUtil.isEmptyString(str3)) {
                        return true;
                    }
                    if (str.startsWith("zte://127.0.0.1/cleartime")) {
                        LogEx.d("LoadWeb", "web view reload new url2:" + str);
                        return true;
                    }
                    if (!str.startsWith("zte://127.0.0.1/savetime")) {
                        return true;
                    }
                    LogEx.d("LoadWeb", "web view reload new url2:" + str);
                    return true;
                }
                LogEx.d("LoadWeb", "mapresult is null");
                return true;
            }
            a.this.c(str);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoadWeb.java */
    /* loaded from: classes.dex */
    public class c implements View.OnKeyListener {
        c(a aVar) {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoadWeb.java */
    /* loaded from: classes.dex */
    public class d extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4840a;

        /* compiled from: LoadWeb.java */
        /* renamed from: com.zte.iptvclient.android.common.l.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0139a implements Runnable {

            /* compiled from: LoadWeb.java */
            /* renamed from: com.zte.iptvclient.android.common.l.a$d$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0140a implements a.c {
                C0140a() {
                }

                @Override // com.zte.iptvclient.android.common.customview.a.c.a.c
                public void a() {
                    LogEx.d("LoadWeb", "5.web view start load url:" + d.this.f4840a);
                    a.this.f4834a.getSettings().setBuiltInZoomControls(true);
                    a.this.f4834a.getSettings().setJavaScriptEnabled(true);
                    d dVar = d.this;
                    a.this.f4834a.loadUrl(dVar.f4840a);
                }

                @Override // com.zte.iptvclient.android.common.customview.a.c.a.c
                public void cancel() {
                }
            }

            RunnableC0139a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                new com.zte.iptvclient.android.common.customview.a.c.a(a.this.i, "Server connection failed, please try again.", new C0140a()).a();
            }
        }

        d(String str) {
            this.f4840a = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (a.this.o) {
                return;
            }
            a.this.g.post(new RunnableC0139a());
        }
    }

    /* compiled from: LoadWeb.java */
    /* loaded from: classes.dex */
    public class e extends WebChromeClient {
        public e() {
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            if (a.this.f4836c == null) {
                return;
            }
            a.this.f.removeView(a.this.f4836c);
            a.this.f4836c = null;
            a.this.f.addView(a.this.f4834a);
            a.this.e.onCustomViewHidden();
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i == 100) {
                LogEx.d("LoadWeb", "webview height:" + a.this.f4834a.getHeight() + " width:" + a.this.f4834a.getWidth());
                LogEx.d("LoadWeb", "web view load data finish");
                a.this.p.sendEmptyMessage(1);
            }
            super.onProgressChanged(webView, i);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            if (a.this.f4836c == null) {
                a.this.f.removeView(a.this.f4834a);
                a.this.f.addView(view);
                a.this.f4836c = view;
                a.this.e = customViewCallback;
                return;
            }
            customViewCallback.onCustomViewHidden();
        }
    }

    /* compiled from: LoadWeb.java */
    /* loaded from: classes.dex */
    public interface f {
        void a(String str, String str2);

        void a(String str, String str2, String str3, String str4);

        void b();

        void onCancel();
    }

    public a(Context context, String str, f fVar) {
        this.h = " ";
        this.i = null;
        this.j = null;
        this.k = null;
        this.i = context;
        this.k = fVar;
        this.j = new h(this.i);
        f();
        a(str);
        this.h = e();
        LogEx.d("LoadWeb", "111 LoadWebURL=" + this.h);
        this.m = new Timer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        String hTTPSessionID;
        String c2;
        LogEx.d("LoadWeb", "1.web view start load url:" + str);
        LogEx.d("LoadWeb", "2.web view start load url:" + str);
        String d2 = i.d();
        if (this.j.o().equals("1")) {
            hTTPSessionID = this.j.N();
            c2 = this.j.f();
        } else {
            hTTPSessionID = SDKLoginMgr.getInstance().getHTTPSessionID();
            c2 = i.c();
        }
        if (a(hTTPSessionID, c2, d2)) {
            this.o = a(hTTPSessionID, c2, d2);
            TimerTask timerTask = this.n;
            if (timerTask != null) {
                timerTask.cancel();
            }
            this.n = new d(str);
            LogEx.d("LoadWeb", "3. wbContent.mLoadUrl:" + str);
            this.f4834a.loadUrl(str);
            LogEx.d("LoadWeb", "4. wbContent.mLoadUrl:" + str);
            return;
        }
        LogEx.w("LoadWeb", "Error in getting content from server");
    }

    private boolean d() {
        Context context = this.i;
        if (context == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            return true;
        }
        LogEx.e("LoadWeb", "The network is not available.");
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a("The network is not available.");
        return false;
    }

    private String e() {
        String d2;
        String b2;
        String hTTPSessionID;
        String str;
        com.zte.iptvclient.common.uiframe.a.d("StypeUrl");
        if (this.j.o().equals("1")) {
            d2 = this.j.g();
            b2 = this.j.f();
        } else {
            d2 = com.zte.iptvclient.common.uiframe.a.d("StypeUrl");
            b2 = i.b();
        }
        LogEx.d("LoadWeb", "strEPGIP=" + b2 + ", strFrameCode" + d2);
        String str2 = "about:blank";
        int i = this.l;
        if (i == 1) {
            str2 = "file:///android_asset/copyright/copyright_announce.html";
        } else if (i == 2) {
            str2 = "file:///android_asset/faq/faq.html";
        } else if (i == 3) {
            str2 = "";
        } else if (i == 4) {
            String c2 = com.zte.iptvclient.common.uiframe.a.c("Column_Discovery_ActivityCenter_Url");
            if (c2 == null || c2.length() <= 0) {
                c2 = "http://58.223.0.68/adshd/";
            }
            String str3 = c2 + "?user=";
            String d3 = com.zte.iptvclient.common.uiframe.a.d("UserID");
            LogEx.d("LoadWeb", "@@@userID=" + d3);
            String encryption3DES = SDKUtil.encryption3DES(d3);
            try {
                encryption3DES = URLEncoder.encode(encryption3DES, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            String str4 = (str3 + encryption3DES) + "&token=";
            String d4 = com.zte.iptvclient.common.uiframe.a.d("UserToken");
            LogEx.d("LoadWeb", "@@@userToken=" + d4);
            String encryption3DES2 = SDKUtil.encryption3DES(d4);
            try {
                encryption3DES2 = URLEncoder.encode(encryption3DES2, "UTF-8");
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
            }
            str2 = str4 + encryption3DES2;
        } else if (i == 5) {
            String str5 = "?terminalFlag=2&requestUrl=" + i.b() + "/iptvepg/" + d2 + ";jsessionid=" + SDKLoginMgr.getInstance().getHTTPSessionID();
            str2 = i.b() + "/iptvepg/" + d2 + "/pc/app_selfcare_register.jsp?terminalFlag=2";
        } else if (i == 6) {
            str2 = i.a() + d2 + "/pc/app_feedback.jsp?terminalFlag=2";
        } else if (i == 7) {
            str2 = com.zte.iptvclient.common.uiframe.a.c("Column_Discovery_Game_Url");
        } else if (i == 8) {
            str2 = com.zte.iptvclient.common.uiframe.a.c("Column_Discovery_Read_Url");
        } else if (i == 9) {
            str2 = com.zte.iptvclient.common.uiframe.a.c("Column_Discovery_FacilitatePeople_Url");
        } else if (i == 10) {
            str2 = com.zte.iptvclient.common.uiframe.a.c("Column_Discovery_ColorRing_Url");
        } else if (i == 11) {
            str2 = "file:///android_asset/term.html";
        } else if (i == 12) {
            str2 = com.zte.iptvclient.common.uiframe.a.c("Column_Discovery_Topic_Url");
            if (str2 == null || str2.length() <= 0) {
                str2 = "http://58.223.0.68/adszt/";
            }
        } else if (i == 13) {
            String c3 = com.zte.iptvclient.common.uiframe.a.c("Column_Discovery_FlowCenter_Url");
            if (c3 == null || c3.length() <= 0) {
                str = "http://js150.10006.info:9002/flowCenter?adsAccount=";
            } else {
                str = c3 + "?adsAccount=";
            }
            str2 = str;
            if (this.j.b0().booleanValue()) {
                String d5 = com.zte.iptvclient.common.uiframe.a.d("UserID");
                LogEx.d("LoadWeb", "userID=" + d5);
                String encryption3DES3 = SDKUtil.encryption3DES(d5);
                try {
                    encryption3DES3 = URLEncoder.encode(encryption3DES3, "UTF-8");
                } catch (UnsupportedEncodingException e4) {
                    e4.printStackTrace();
                }
                str2 = str2 + encryption3DES3;
            }
        } else if (i == 14) {
            str2 = "file:///android_asset/serviceagreement.html";
        } else if (i == 15) {
            String c4 = com.zte.iptvclient.common.uiframe.a.c("Column_Discovery_YangguangFM_Url");
            if (c4 == null || c4.length() <= 0) {
                c4 = "http://itvfm.cnrmobile.com/tvfm/index";
            }
            String str6 = c4 + "?user=";
            String encryption3DES4 = SDKUtil.encryption3DES(com.zte.iptvclient.common.uiframe.a.d("UserID"));
            try {
                encryption3DES4 = URLEncoder.encode(encryption3DES4, "UTF-8");
            } catch (UnsupportedEncodingException e5) {
                e5.printStackTrace();
            }
            String str7 = (str6 + encryption3DES4) + "&token=";
            String encryption3DES5 = SDKUtil.encryption3DES(com.zte.iptvclient.common.uiframe.a.d("UserToken"));
            try {
                encryption3DES5 = URLEncoder.encode(encryption3DES5, "UTF-8");
            } catch (UnsupportedEncodingException e6) {
                e6.printStackTrace();
            }
            str2 = str7 + encryption3DES5;
        } else if (i == 16) {
            String c5 = com.zte.iptvclient.common.uiframe.a.c("Column_Discovery_Yuanxiantong_Url");
            if (c5 == null || c5.length() <= 0) {
                c5 = "http://jsyxt.tenkent.com:8088/weixin?channelName=gxitv&flag=1&userid=";
            }
            str2 = c5 + com.zte.iptvclient.common.uiframe.a.d("UserID") + "&flag=1";
        } else if (i == 17) {
            if (this.j.o().equals("1")) {
                hTTPSessionID = this.j.N();
                LogEx.e("LoadWeb", "sessionID=" + hTTPSessionID);
                LogEx.e("LoadWeb", "sessionID=" + hTTPSessionID);
            } else {
                hTTPSessionID = SDKLoginMgr.getInstance().getHTTPSessionID();
            }
            String c6 = com.zte.iptvclient.common.uiframe.a.c("News_Hot_Column");
            if (!StringUtil.isEmptyString(c6)) {
                str2 = b2 + "/iptvepg/" + d2 + "/static/videolist.html?columncode=" + c6 + "&jsessionid=" + hTTPSessionID;
            }
            LogEx.d("LoadWeb", "webUrl=" + str2);
        }
        LogEx.d("LoadWeb", "webUrl=" + str2);
        return str2;
    }

    private void f() {
        i.c();
        a();
    }

    @SuppressLint({"SetJavaScriptEnabled", "InlinedApi", "NewApi"})
    private void g() {
        this.f4834a.getSettings().setJavaScriptEnabled(true);
        this.f4834a.getSettings().setSupportZoom(true);
        this.f4834a.setScrollBarStyle(0);
        this.f4834a.getSettings().setPluginState(WebSettings.PluginState.ON);
        this.f4834a.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.f4834a.getSettings().setUseWideViewPort(true);
        this.f4834a.getSettings().setLoadWithOverviewMode(true);
        this.f4834a.setWebChromeClient(new WebChromeClient());
        this.f4834a.getSettings().setAllowFileAccess(true);
        this.f4834a.getSettings().setBuiltInZoomControls(false);
        this.f4834a.getSettings().setDomStorageEnabled(true);
        this.f4834a.setWebViewClient(new b());
        e eVar = new e();
        this.f4837d = eVar;
        this.f4834a.setWebChromeClient(eVar);
        this.f4834a.setOnKeyListener(new c(this));
    }

    private void h() {
        this.p.sendEmptyMessage(0);
        c(this.h);
        LogEx.d("LoadWeb", "33 mLoadUrl=" + this.h);
    }

    public void b() {
        g();
        if (d()) {
            h();
        } else {
            this.p.sendEmptyMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] b(String str) {
        if (!StringUtil.isEmptyString(str) && str.contains("?")) {
            String[] split = str.split("\\?");
            if (split.length > 1) {
                if (split[1].contains("&")) {
                    return split[1].split("&");
                }
                split[0] = split[1];
                split[1] = "";
                return split;
            }
        }
        return null;
    }

    public void a(String str) {
        if (TextUtils.equals(str, "TermsFragment")) {
            this.l = 1;
            return;
        }
        if (TextUtils.equals("FAQFragment", str)) {
            this.l = 2;
            return;
        }
        if (TextUtils.equals(str, "AboutFragment")) {
            this.l = 3;
            return;
        }
        if (TextUtils.equals(str, "ActivityCenterFragment")) {
            this.l = 4;
            return;
        }
        if (TextUtils.equals(str, "RegistFragment")) {
            this.l = 5;
            return;
        }
        if (TextUtils.equals(str, "CustomerFragment")) {
            this.l = 6;
            return;
        }
        if (TextUtils.equals(str, "Column_Discovery_Game_Url")) {
            this.l = 7;
            return;
        }
        if (TextUtils.equals(str, "Column_Discovery_Read_Url")) {
            this.l = 8;
            return;
        }
        if (TextUtils.equals(str, "Column_Discovery_FacilitatePeople_Url")) {
            this.l = 9;
            return;
        }
        if (TextUtils.equals(str, "Column_Discovery_ColorRing_Url")) {
            this.l = 10;
            return;
        }
        if (TextUtils.equals(str, "ServiceAgreementFragment")) {
            this.l = 11;
            return;
        }
        if (TextUtils.equals(str, "SpecialFragment")) {
            this.l = 12;
            return;
        }
        if (TextUtils.equals(str, "FlowCenterFragment")) {
            this.l = 13;
            return;
        }
        if (TextUtils.equals(str, "CustomerServiceAgreement")) {
            this.l = 14;
            return;
        }
        if (TextUtils.equals(str, "SunshineFMFragment")) {
            this.l = 15;
            return;
        }
        if (TextUtils.equals(str, "CinemaFragment")) {
            this.l = 16;
        } else if (TextUtils.equals(str, "ShortVideoFragment")) {
            this.l = 17;
        } else if (TextUtils.equals(str, "AHMobile_VIP_Service")) {
            this.l = 18;
        }
    }

    public a(Context context, String str, String str2, f fVar) {
        this.h = " ";
        this.i = null;
        this.j = null;
        this.k = null;
        this.i = context;
        this.k = fVar;
        this.j = new h(this.i);
        f();
        this.h = str2;
        LogEx.d("LoadWeb", "2222 LoadWebURL=" + this.h);
        this.m = new Timer();
    }

    public void c() {
        CookieSyncManager.createInstance(this.i);
        CookieManager.getInstance().removeSessionCookie();
        this.f.removeView(this.f4834a);
        this.f4834a.destroy();
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Window window;
        View inflate = layoutInflater.inflate(R.layout.sign_up_web, viewGroup, false);
        Context context = this.i;
        if (context != null && (window = ((Activity) context).getWindow()) != null) {
            window.addFlags(16777216);
            window.setFlags(16777216, 16777216);
        }
        com.zte.iptvclient.common.uiframe.f.a(inflate);
        WebView webView = (WebView) inflate.findViewById(R.id.signUpWebview);
        this.f4834a = webView;
        webView.setBackgroundColor(0);
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.signUpWebProgress);
        this.f4835b = progressBar;
        progressBar.setVisibility(8);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.sign_up_web_rlayout);
        this.f = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout);
        com.zte.iptvclient.common.uiframe.f.a(this.f4834a);
        com.zte.iptvclient.common.uiframe.f.a(this.f4835b);
        this.f4834a.setLayerType(2, null);
        return inflate;
    }

    public boolean a() {
        return q == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.f4834a.setVisibility(0);
            this.f4835b.setVisibility(8);
        } else {
            this.f4834a.setVisibility(8);
            this.f4835b.setVisibility(0);
        }
    }

    private boolean a(String str, String str2, String str3) {
        String str4;
        String str5;
        LogEx.d("LoadWeb", "strEpgDomain=" + str2);
        LogEx.d("LoadWeb", "strJSessionID=" + str);
        if (!StringUtil.isEmptyString(str) && !StringUtil.isEmptyString(str2)) {
            CookieSyncManager.createInstance(this.i);
            CookieManager cookieManager = CookieManager.getInstance();
            if (this.l == 13) {
                str4 = "JSESSIONID=" + str + "; domain=" + str2 + ":" + str3;
                str5 = str2 + ":" + str3;
            } else {
                str4 = "JSESSIONID=" + str + "; domain=" + str2;
                str5 = str2 + ":" + str3;
            }
            LogEx.d("LoadWeb", "Set " + str5 + " cookie to " + str4);
            String cookie = cookieManager.getCookie(str5);
            StringBuilder sb = new StringBuilder();
            sb.append("strOldCookie=");
            sb.append(cookie);
            LogEx.d("LoadWeb", sb.toString());
            cookieManager.setAcceptCookie(true);
            if (!StringUtil.isEmptyString(cookie)) {
                cookieManager.removeSessionCookie();
            }
            cookieManager.setCookie(str5, str4);
            LogEx.d("LoadWeb", "strCurCookie=" + cookieManager.getCookie(str5));
            CookieSyncManager.getInstance().sync();
            return true;
        }
        LogEx.d("LoadWeb", "url、strJSessionID or strEpgDomain has one is empty");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            String[] split = str.split("=");
            if (hashMap != null && split.length > 1) {
                hashMap.put(split[0], split[1]);
            } else if (hashMap == null || split.length != 1) {
                hashMap = null;
            } else {
                hashMap.put(split[0], "");
            }
        }
        return hashMap;
    }
}
