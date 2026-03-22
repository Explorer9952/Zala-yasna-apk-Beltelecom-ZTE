package com.sina.weibo.sdk.auth;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.internal.NativeProtocol;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.sina.weibo.sdk.exception.WeiboDialogException;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.Utility;

/* loaded from: classes.dex */
public class WeiboDialog extends Dialog {
    private static final String TAG = "WeiboDialog";
    private static final int WEBVIEW_CONTAINER_MARGIN_TOP = 25;
    private static final int WEBVIEW_MARGIN = 10;
    private static int theme = 16973840;
    private String mAuthUrl;
    private Context mContext;
    private boolean mIsDetached;
    private WeiboAuthListener mListener;
    private ProgressDialog mLoadingDlg;
    private RelativeLayout mRootContainer;
    private WebView mWebView;
    private RelativeLayout mWebViewContainer;
    private WeiboAuth mWeibo;

    public WeiboDialog(Context context, String str, WeiboAuthListener weiboAuthListener, WeiboAuth weiboAuth) {
        super(context, theme);
        this.mIsDetached = false;
        this.mAuthUrl = str;
        this.mListener = weiboAuthListener;
        this.mContext = context;
        this.mWeibo = weiboAuth;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRedirectUrl(String str) {
        Bundle parseUrl = Utility.parseUrl(str);
        String string = parseUrl.getString("error");
        String string2 = parseUrl.getString("error_code");
        String string3 = parseUrl.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
        if (string == null && string2 == null) {
            this.mListener.onComplete(parseUrl);
        } else {
            this.mListener.onWeiboException(new WeiboAuthException(string2, string, string3));
        }
    }

    private void initCloseButton() {
        ImageView imageView = new ImageView(this.mContext);
        Drawable drawable = ResourceManager.getDrawable(this.mContext, 2);
        imageView.setImageDrawable(drawable);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.sina.weibo.sdk.auth.WeiboDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WeiboDialog.this.dismiss();
                if (WeiboDialog.this.mListener != null) {
                    WeiboDialog.this.mListener.onCancel();
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mWebViewContainer.getLayoutParams();
        layoutParams.leftMargin = (layoutParams2.leftMargin - (drawable.getIntrinsicWidth() / 2)) + 5;
        layoutParams.topMargin = (layoutParams2.topMargin - (drawable.getIntrinsicHeight() / 2)) + 5;
        this.mRootContainer.addView(imageView, layoutParams);
    }

    private void initLoadingDlg() {
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        this.mLoadingDlg = progressDialog;
        progressDialog.requestWindowFeature(1);
        this.mLoadingDlg.setMessage(ResourceManager.getString(this.mContext, 1));
    }

    private void initWebView() {
        this.mWebViewContainer = new RelativeLayout(getContext());
        WebView webView = new WebView(getContext());
        this.mWebView = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setSavePassword(false);
        this.mWebView.setWebViewClient(new WeiboWebViewClient(this, null));
        this.mWebView.requestFocus();
        this.mWebView.setScrollBarStyle(0);
        this.mWebView.setVisibility(4);
        NetworkHelper.clearCookies(this.mContext, this.mAuthUrl);
        this.mWebView.loadUrl(this.mAuthUrl);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        int i = (int) (displayMetrics.density * 10.0f);
        layoutParams2.setMargins(i, i, i, i);
        this.mWebViewContainer.setBackgroundDrawable(ResourceManager.getNinePatchDrawable(this.mContext, 1));
        this.mWebViewContainer.addView(this.mWebView, layoutParams2);
        this.mWebViewContainer.setGravity(17);
        int intrinsicWidth = (ResourceManager.getDrawable(this.mContext, 2).getIntrinsicWidth() / 2) + 1;
        layoutParams.setMargins(intrinsicWidth, (int) (displayMetrics.density * 25.0f), intrinsicWidth, intrinsicWidth);
        this.mRootContainer.addView(this.mWebViewContainer, layoutParams);
    }

    private void initWindow() {
        requestWindowFeature(1);
        getWindow().setFeatureDrawableAlpha(0, 0);
        getWindow().setSoftInputMode(16);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.mRootContainer = relativeLayout;
        relativeLayout.setBackgroundColor(0);
        addContentView(this.mRootContainer, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.mIsDetached) {
            return;
        }
        ProgressDialog progressDialog = this.mLoadingDlg;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.mLoadingDlg.dismiss();
        }
        super.dismiss();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        this.mIsDetached = false;
        super.onAttachedToWindow();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        WeiboAuthListener weiboAuthListener = this.mListener;
        if (weiboAuthListener != null) {
            weiboAuthListener.onCancel();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initWindow();
        initLoadingDlg();
        initWebView();
        initCloseButton();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        WebView webView = this.mWebView;
        if (webView != null) {
            this.mWebViewContainer.removeView(webView);
            this.mWebView.stopLoading();
            this.mWebView.removeAllViews();
            this.mWebView.destroy();
            this.mWebView = null;
        }
        this.mIsDetached = true;
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class WeiboWebViewClient extends WebViewClient {
        private boolean isCallBacked;

        private WeiboWebViewClient() {
            this.isCallBacked = false;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            LogUtil.d(WeiboDialog.TAG, "onPageFinished URL: " + str);
            super.onPageFinished(webView, str);
            if (!WeiboDialog.this.mIsDetached && WeiboDialog.this.mLoadingDlg != null) {
                WeiboDialog.this.mLoadingDlg.dismiss();
            }
            WeiboDialog.this.mWebView.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            LogUtil.d(WeiboDialog.TAG, "onPageStarted URL: " + str);
            if (str.startsWith(WeiboDialog.this.mWeibo.getAuthInfo().getRedirectUrl()) && !this.isCallBacked) {
                this.isCallBacked = true;
                WeiboDialog.this.handleRedirectUrl(str);
                webView.stopLoading();
                WeiboDialog.this.dismiss();
                return;
            }
            super.onPageStarted(webView, str, bitmap);
            if (WeiboDialog.this.mIsDetached || WeiboDialog.this.mLoadingDlg == null || WeiboDialog.this.mLoadingDlg.isShowing()) {
                return;
            }
            WeiboDialog.this.mLoadingDlg.show();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            LogUtil.d(WeiboDialog.TAG, "onReceivedError: errorCode = " + i + ", description = " + str + ", failingUrl = " + str2);
            super.onReceivedError(webView, i, str, str2);
            if (WeiboDialog.this.mListener != null) {
                WeiboDialog.this.mListener.onWeiboException(new WeiboDialogException(str, i, str2));
            }
            WeiboDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            LogUtil.i(WeiboDialog.TAG, "load URL: " + str);
            if (str.startsWith("sms:")) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.putExtra(IntegrityManager.INTEGRITY_TYPE_ADDRESS, str.replace("sms:", ""));
                intent.setType("vnd.android-dir/mms-sms");
                WeiboDialog.this.getContext().startActivity(intent);
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        /* synthetic */ WeiboWebViewClient(WeiboDialog weiboDialog, WeiboWebViewClient weiboWebViewClient) {
            this();
        }
    }
}
