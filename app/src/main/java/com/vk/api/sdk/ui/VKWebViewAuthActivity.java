package com.vk.api.sdk.ui;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.facebook.AccessToken;
import com.facebook.internal.NativeProtocol;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants;
import com.vk.api.sdk.R$id;
import com.vk.api.sdk.R$layout;
import com.vk.api.sdk.R$string;
import com.vk.api.sdk.auth.d;
import com.vk.api.sdk.g;
import com.vk.api.sdk.r.h;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.y;
import kotlin.j;
import kotlin.jvm.internal.f;
import kotlin.text.u;
import kotlin.text.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VKWebViewAuthActivity.kt */
/* loaded from: classes.dex */
public class VKWebViewAuthActivity extends Activity {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private static g.b f4019d;
    public static final a e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private WebView f4020a;

    /* renamed from: b, reason: collision with root package name */
    private ProgressBar f4021b;

    /* renamed from: c, reason: collision with root package name */
    private d f4022c;

    /* compiled from: VKWebViewAuthActivity.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        @Nullable
        public final g.b a() {
            return VKWebViewAuthActivity.f4019d;
        }

        public /* synthetic */ a(kotlin.jvm.internal.d dVar) {
            this();
        }

        public final void a(@Nullable g.b bVar) {
            VKWebViewAuthActivity.f4019d = bVar;
        }

        public final void a(@NotNull Activity activity, @NotNull d dVar, int i) {
            f.b(activity, "activity");
            f.b(dVar, NativeProtocol.WEB_DIALOG_PARAMS);
            Intent putExtra = new Intent(activity, (Class<?>) VKWebViewAuthActivity.class).putExtra("vk_auth_params", dVar.d());
            f.a((Object) putExtra, "Intent(activity, VKWebVi…ARAMS, params.toBundle())");
            activity.startActivityForResult(putExtra, i);
        }

        public final void a(@NotNull Context context, @NotNull String str) {
            f.b(context, "context");
            f.b(str, "validationUrl");
            Intent putExtra = new Intent(context, (Class<?>) VKWebViewAuthActivity.class).putExtra("vk_validation_url", str);
            f.a((Object) putExtra, "Intent(context, VKWebVie…ATION_URL, validationUrl)");
            context.startActivity(putExtra);
        }
    }

    /* compiled from: VKWebViewAuthActivity.kt */
    /* loaded from: classes.dex */
    public final class b extends WebViewClient {

        /* renamed from: a, reason: collision with root package name */
        private boolean f4023a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: VKWebViewAuthActivity.kt */
        /* loaded from: classes.dex */
        public static final class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                b.this.f4023a = false;
                VKWebViewAuthActivity.this.e();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: VKWebViewAuthActivity.kt */
        /* renamed from: com.vk.api.sdk.ui.VKWebViewAuthActivity$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class DialogInterfaceOnClickListenerC0106b implements DialogInterface.OnClickListener {
            DialogInterfaceOnClickListenerC0106b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                VKWebViewAuthActivity.this.setResult(0);
                VKWebViewAuthActivity.this.finish();
            }
        }

        public b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
            super.onPageFinished(webView, str);
            if (this.f4023a) {
                return;
            }
            VKWebViewAuthActivity.this.g();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(@Nullable WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            a(str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest, @Nullable WebResourceError webResourceError) {
            CharSequence description;
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            String str = null;
            if (Build.VERSION.SDK_INT >= 23 && webResourceError != null && (description = webResourceError.getDescription()) != null) {
                str = description.toString();
            }
            a(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest) {
            return a(String.valueOf(webResourceRequest != null ? webResourceRequest.getUrl() : null));
        }

        private final boolean a(String str) {
            boolean a2;
            int a3;
            String a4;
            int i = 0;
            if (str != null) {
                String d2 = VKWebViewAuthActivity.this.d();
                f.a((Object) d2, "redirectUrl");
                a2 = u.a(str, d2, false, 2, null);
                if (a2) {
                    Intent intent = new Intent("com.vk.auth-token");
                    a3 = v.a((CharSequence) str, "#", 0, false, 6, (Object) null);
                    String substring = str.substring(a3 + 1);
                    f.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
                    intent.putExtra("extra-token-data", substring);
                    Map<String, String> a5 = com.vk.api.sdk.r.g.a(substring);
                    if (a5 == null || (!a5.containsKey("error") && !a5.containsKey("cancel"))) {
                        i = -1;
                    }
                    VKWebViewAuthActivity.this.setResult(i, intent);
                    if (VKWebViewAuthActivity.this.f()) {
                        a4 = u.a(str, "#", "?", false, 4, (Object) null);
                        Uri parse = Uri.parse(a4);
                        if (parse.getQueryParameter("success") != null) {
                            String queryParameter = parse.getQueryParameter("access_token");
                            String queryParameter2 = parse.getQueryParameter(MMPluginProviderConstants.OAuth.SECRET);
                            String queryParameter3 = parse.getQueryParameter(AccessToken.USER_ID_KEY);
                            VKWebViewAuthActivity.e.a(new g.b(queryParameter2, queryParameter, queryParameter3 != null ? Integer.valueOf(Integer.parseInt(queryParameter3)) : null));
                        }
                    }
                    h.f3998c.b();
                    VKWebViewAuthActivity.this.finish();
                    return true;
                }
            }
            return false;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@Nullable WebView webView, @Nullable String str) {
            return a(str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(@Nullable WebView webView, int i, @Nullable String str, @Nullable String str2) {
            super.onReceivedError(webView, i, str, str2);
            a(webView, str);
        }

        private final void a(WebView webView, String str) {
            this.f4023a = true;
            try {
                new AlertDialog.Builder(webView != null ? webView.getContext() : null).setMessage(str).setPositiveButton(R$string.vk_retry, new a()).setNegativeButton(R.string.cancel, new DialogInterfaceOnClickListenerC0106b()).show();
            } catch (Exception unused) {
                VKWebViewAuthActivity.this.setResult(0);
                VKWebViewAuthActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        String uri;
        try {
            if (f()) {
                uri = getIntent().getStringExtra("vk_validation_url");
            } else {
                Uri.Builder buildUpon = Uri.parse("https://oauth.vk.com/authorize").buildUpon();
                for (Map.Entry<String, String> entry : a().entrySet()) {
                    buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
                }
                uri = buildUpon.build().toString();
            }
            WebView webView = this.f4020a;
            if (webView == null) {
                f.d("webView");
                throw null;
            }
            webView.loadUrl(uri);
        } catch (Exception unused) {
            setResult(0);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f() {
        return getIntent().getStringExtra("vk_validation_url") != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        ProgressBar progressBar = this.f4021b;
        if (progressBar != null) {
            progressBar.setVisibility(8);
            WebView webView = this.f4020a;
            if (webView != null) {
                webView.setVisibility(0);
                return;
            } else {
                f.d("webView");
                throw null;
            }
        }
        f.d("progress");
        throw null;
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.vk_webview_auth_dialog);
        View findViewById = findViewById(R$id.webView);
        f.a((Object) findViewById, "findViewById(R.id.webView)");
        this.f4020a = (WebView) findViewById;
        View findViewById2 = findViewById(R$id.progress);
        f.a((Object) findViewById2, "findViewById(R.id.progress)");
        this.f4021b = (ProgressBar) findViewById2;
        d a2 = d.f3892d.a(getIntent().getBundleExtra("vk_auth_params"));
        if (a2 == null) {
            if (!f()) {
                finish();
            }
        } else {
            this.f4022c = a2;
        }
        c();
        e();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        WebView webView = this.f4020a;
        if (webView != null) {
            webView.destroy();
            h.f3998c.b();
            super.onDestroy();
            return;
        }
        f.d("webView");
        throw null;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private final void c() {
        WebView webView = this.f4020a;
        if (webView != null) {
            webView.setWebViewClient(new b());
            webView.setVerticalScrollBarEnabled(false);
            webView.setVisibility(4);
            webView.setOverScrollMode(2);
            WebView webView2 = this.f4020a;
            if (webView2 != null) {
                webView2.getSettings().setJavaScriptEnabled(true);
                return;
            } else {
                f.d("webView");
                throw null;
            }
        }
        f.d("webView");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d() {
        if (f()) {
            return getIntent().getStringExtra("vk_validation_url");
        }
        d dVar = this.f4022c;
        if (dVar != null) {
            return dVar.b();
        }
        f.d(NativeProtocol.WEB_DIALOG_PARAMS);
        throw null;
    }

    @NotNull
    protected Map<String, String> a() {
        Map<String, String> a2;
        Pair[] pairArr = new Pair[7];
        d dVar = this.f4022c;
        if (dVar != null) {
            pairArr[0] = j.a("client_id", String.valueOf(dVar.a()));
            d dVar2 = this.f4022c;
            if (dVar2 != null) {
                pairArr[1] = j.a("scope", dVar2.c());
                d dVar3 = this.f4022c;
                if (dVar3 != null) {
                    pairArr[2] = j.a("redirect_uri", dVar3.b());
                    pairArr[3] = j.a("response_type", "token");
                    pairArr[4] = j.a("display", "mobile");
                    pairArr[5] = j.a("v", com.vk.api.sdk.a.c());
                    pairArr[6] = j.a("revoke", "1");
                    a2 = y.a(pairArr);
                    return a2;
                }
                f.d(NativeProtocol.WEB_DIALOG_PARAMS);
                throw null;
            }
            f.d(NativeProtocol.WEB_DIALOG_PARAMS);
            throw null;
        }
        f.d(NativeProtocol.WEB_DIALOG_PARAMS);
        throw null;
    }
}
