package com.sina.weibo.sdk.auth;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.UIUtils;
import com.sina.weibo.sdk.utils.Utility;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class WeiboAuth {
    private static final String OAUTH2_BASE_URL = "https://open.weibo.cn/oauth2/authorize?";
    public static final int OBTAIN_AUTH_CODE = 0;
    public static final int OBTAIN_AUTH_TOKEN = 1;
    public static final String TAG = "Weibo_web_login";
    private AuthInfo mAuthInfo;
    private Context mContext;

    /* loaded from: classes.dex */
    public static class AuthInfo {
        private String mAppKey;
        private Bundle mBundle = null;
        private String mKeyHash;
        private String mPackageName;
        private String mRedirectUrl;
        private String mScope;

        public AuthInfo(Context context, String str, String str2, String str3) {
            this.mAppKey = "";
            this.mRedirectUrl = "";
            this.mScope = "";
            this.mPackageName = "";
            this.mKeyHash = "";
            this.mAppKey = str;
            this.mRedirectUrl = str2;
            this.mScope = str3;
            String packageName = context.getPackageName();
            this.mPackageName = packageName;
            this.mKeyHash = Utility.getSign(context, packageName);
            initAuthBundle();
        }

        private void initAuthBundle() {
            Bundle bundle = new Bundle();
            this.mBundle = bundle;
            bundle.putString(WBConstants.SSO_APP_KEY, this.mAppKey);
            this.mBundle.putString(WBConstants.SSO_REDIRECT_URL, this.mRedirectUrl);
            this.mBundle.putString("scope", this.mScope);
            this.mBundle.putString("packagename", this.mPackageName);
            this.mBundle.putString("key_hash", this.mKeyHash);
        }

        public String getAppKey() {
            return this.mAppKey;
        }

        public Bundle getAuthBundle() {
            return this.mBundle;
        }

        public String getRedirectUrl() {
            return this.mRedirectUrl;
        }

        public String getScope() {
            return this.mScope;
        }
    }

    public WeiboAuth(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mAuthInfo = new AuthInfo(context, str, str2, str3);
    }

    private void startDialog(WeiboAuthListener weiboAuthListener, int i) {
        if (weiboAuthListener == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("client_id", this.mAuthInfo.mAppKey);
        linkedHashMap.put("redirect_uri", this.mAuthInfo.mRedirectUrl);
        linkedHashMap.put("scope", this.mAuthInfo.mScope);
        linkedHashMap.put("response_type", "code");
        linkedHashMap.put("display", "mobile");
        if (1 == i) {
            linkedHashMap.put("packagename", this.mAuthInfo.mPackageName);
            linkedHashMap.put("key_hash", this.mAuthInfo.mKeyHash);
        }
        String str = OAUTH2_BASE_URL + Utility.packUrl(linkedHashMap);
        if (!NetworkHelper.hasInternetPermission(this.mContext)) {
            UIUtils.showAlert(this.mContext, "Error", "Application requires permission to access the Internet");
            return;
        }
        if (NetworkHelper.isNetworkAvailable(this.mContext)) {
            new WeiboDialog(this.mContext, str, weiboAuthListener, this).show();
            return;
        }
        String string = ResourceManager.getString(this.mContext, 2);
        LogUtil.i(TAG, "String: " + string);
        UIUtils.showToast(this.mContext, string, 0);
    }

    public void anthorize(WeiboAuthListener weiboAuthListener) {
        authorize(weiboAuthListener, 1);
    }

    public void authorize(WeiboAuthListener weiboAuthListener, int i) {
        startDialog(weiboAuthListener, i);
    }

    public AuthInfo getAuthInfo() {
        return this.mAuthInfo;
    }

    public void setAuthInfo(AuthInfo authInfo) {
        this.mAuthInfo = authInfo;
    }

    public WeiboAuth(Context context, AuthInfo authInfo) {
        this.mContext = context;
        this.mAuthInfo = authInfo;
    }
}
