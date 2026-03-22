package com.video.androidsdk.sns.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.share.IWeiboDownloadListener;
import com.sina.weibo.sdk.api.share.IWeiboHandler;
import com.sina.weibo.sdk.api.share.IWeiboShareAPI;
import com.sina.weibo.sdk.api.share.WeiboShareSDK;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuth;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;
import com.video.androidsdk.common.ClientNetworkInfo;
import com.video.androidsdk.common.PreferenceHelper;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.sns.Constants;
import com.video.androidsdk.sns.ISNSActionListener;
import com.video.androidsdk.sns.ISNSAuthListener;
import com.video.androidsdk.sns.ISinaWeibo;
import com.video.androidsdk.sns.bean.OAuth2Param;
import com.video.androidsdk.sns.bean.SNSMessage;
import java.lang.ref.WeakReference;
import java.util.Vector;

/* compiled from: SinaWeibo.java */
/* loaded from: classes.dex */
public class h implements ISinaWeibo {

    /* renamed from: a, reason: collision with root package name */
    static h f3839a = null;
    private static final String g = "h";

    /* renamed from: b, reason: collision with root package name */
    PreferenceHelper f3840b;

    /* renamed from: c, reason: collision with root package name */
    IWeiboShareAPI f3841c;

    /* renamed from: d, reason: collision with root package name */
    a f3842d;
    IWeiboDownloadListener e = new i(this);
    WeakReference<Activity> f;
    private WeiboAuth h;
    private Oauth2AccessToken i;
    private SsoHandler j;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        Activity activity;
        Oauth2AccessToken oauth2AccessToken = this.i;
        if (oauth2AccessToken == null) {
            if (this.f3840b == null) {
                WeakReference<Activity> weakReference = this.f;
                if (weakReference == null || (activity = weakReference.get()) == null) {
                    return false;
                }
                this.f3840b = new PreferenceHelper(activity.getApplicationContext(), Constants.PREFERENCE_NAME);
            }
            LogEx.d(g, "checkToken - get local accesstoken.");
            if (this.f3840b.getString(Constants.PREF_SINA_CODE, null) != null) {
                return true;
            }
            String string = this.f3840b.getString("access_token", null);
            long parseLong = Long.parseLong(this.f3840b.getString("expires_in", "0"));
            if (string != null && 0 != parseLong) {
                Oauth2AccessToken oauth2AccessToken2 = new Oauth2AccessToken();
                this.i = oauth2AccessToken2;
                oauth2AccessToken2.setToken(string);
                this.i.setExpiresTime(parseLong);
            }
            Oauth2AccessToken oauth2AccessToken3 = this.i;
            if (oauth2AccessToken3 == null) {
                LogEx.w(g, "checkToken - no local accesstoken.");
                return false;
            }
            if (oauth2AccessToken3.isSessionValid()) {
                return true;
            }
            LogEx.w(g, "checkToken - local accesstoken not valid.");
            return false;
        }
        if (oauth2AccessToken.isSessionValid()) {
            return true;
        }
        LogEx.w(g, "checkToken - local accesstoken not valid.");
        return false;
    }

    @Override // com.video.androidsdk.sns.ISinaWeibo
    public void authCallBack(int i, int i2, Intent intent) {
        if (this.j != null) {
            LogEx.d(g, "=====onActivityResult=mSsoHandler resultCode = " + i2 + " requestCode = " + i);
            this.j.authorizeCallBack(i, i2, intent);
        }
    }

    @Override // com.video.androidsdk.sns.ISNSWrapper
    public void authorize(Context context, ISNSAuthListener iSNSAuthListener) {
        Activity activity;
        if (context == null || !(context instanceof Activity)) {
            if (iSNSAuthListener != null) {
                iSNSAuthListener.onError(1, "context null");
                return;
            }
            return;
        }
        if (!ClientNetworkInfo.isNetworkAvailable((ConnectivityManager) context.getSystemService("connectivity"))) {
            if (iSNSAuthListener != null) {
                iSNSAuthListener.onError(153, "network invalid");
                return;
            }
            return;
        }
        if (this.f3840b == null) {
            this.f3840b = new PreferenceHelper(context.getApplicationContext(), Constants.PREFERENCE_NAME);
        }
        if (this.h == null) {
            LogEx.w(g, "authorize - not init");
            if (iSNSAuthListener != null) {
                iSNSAuthListener.onError(2, "Not init!");
                return;
            }
            return;
        }
        WeakReference<Activity> weakReference = this.f;
        if (weakReference != null && (activity = weakReference.get()) != null && activity.equals(context)) {
            a(iSNSAuthListener);
            return;
        }
        LogEx.e(g, "authorize - need reinit!");
        if (iSNSAuthListener != null) {
            iSNSAuthListener.onError(2, "Need reinit!");
        }
    }

    @Override // com.video.androidsdk.sns.ISNSWrapper
    public int init(Context context, OAuth2Param oAuth2Param) {
        if (context == null || !(context instanceof Activity)) {
            if (context != null) {
                LogEx.d(g, "Activity: " + context.getClass().getName());
            }
            return 1;
        }
        if (oAuth2Param == null) {
            return 1;
        }
        if (this.f3840b == null) {
            this.f3840b = new PreferenceHelper(context.getApplicationContext(), Constants.PREFERENCE_NAME);
        }
        try {
            this.f3841c = WeiboShareSDK.createWeiboAPI(context, oAuth2Param.getAppKey());
            WeiboAuth weiboAuth = new WeiboAuth(context, oAuth2Param.getAppKey(), oAuth2Param.getRedirectURL(), Constants.SCOPE);
            this.h = weiboAuth;
            this.j = new SsoHandler((Activity) context, weiboAuth);
            if (this.f == null) {
                this.f = new WeakReference<>((Activity) context);
            } else {
                Activity activity = this.f.get();
                if (activity == null || !activity.equals(context)) {
                    this.f = new WeakReference<>((Activity) context);
                }
            }
            this.f3841c.registerWeiboDownloadListener(this.e);
            this.f3841c.registerApp();
            return 0;
        } catch (Exception e) {
            LogEx.w(g, "SinaWeibo.init - Catch exception:" + e.getMessage());
            e.printStackTrace();
            return 255;
        }
    }

    @Override // com.video.androidsdk.sns.ISNSWrapper
    public boolean isAuth() {
        Activity activity;
        if (this.f3840b == null) {
            WeakReference<Activity> weakReference = this.f;
            if (weakReference == null || (activity = weakReference.get()) == null) {
                return false;
            }
            this.f3840b = new PreferenceHelper(activity.getApplicationContext(), Constants.PREFERENCE_NAME);
        }
        return (TextUtils.isEmpty(this.f3840b.getString(Constants.PREF_SINA_ACCESSTOKEN, "")) && TextUtils.isEmpty(this.f3840b.getString(Constants.PREF_SINA_CODE, ""))) ? false : true;
    }

    @Override // com.video.androidsdk.sns.ISinaWeibo
    public int isClientInstalled() {
        IWeiboShareAPI iWeiboShareAPI = this.f3841c;
        if (iWeiboShareAPI == null) {
            return 2;
        }
        return iWeiboShareAPI.isWeiboAppInstalled() ? 0 : 255;
    }

    @Override // com.video.androidsdk.sns.ISinaWeibo
    public void logout() {
        if (this.f3840b == null) {
            WeakReference<Activity> weakReference = this.f;
            if (weakReference == null || weakReference.get() == null) {
                return;
            } else {
                this.f3840b = new PreferenceHelper(this.f.get().getApplicationContext(), Constants.PREFERENCE_NAME);
            }
        }
        this.f3840b.remove(Constants.PREF_SINA_ACCESSTOKEN);
    }

    @Override // com.video.androidsdk.sns.ISinaWeibo
    public int registerApp() {
        IWeiboShareAPI iWeiboShareAPI = this.f3841c;
        if (iWeiboShareAPI == null) {
            return 2;
        }
        return iWeiboShareAPI.registerApp() ? 0 : 255;
    }

    @Override // com.video.androidsdk.sns.ISNSWrapper
    public int sendMessage(Context context, SNSMessage sNSMessage, ISNSActionListener iSNSActionListener) {
        if (sNSMessage == null) {
            LogEx.d(g, "sendMessage - msg is null.");
            return 1;
        }
        if (context != null && (context instanceof Activity)) {
            if (!ClientNetworkInfo.isNetworkAvailable((ConnectivityManager) context.getSystemService("connectivity"))) {
                LogEx.d(g, "sendMessage - network invalid.");
                return 153;
            }
            if (this.f3841c == null) {
                LogEx.w(g, "sendMessage - not init!");
                return 2;
            }
            WeakReference<Activity> weakReference = this.f;
            if (weakReference == null) {
                LogEx.e(g, "sendMessage - need reinit!");
                if (iSNSActionListener != null) {
                    iSNSActionListener.onFail(2, "Need reinit!");
                }
                return 2;
            }
            Activity activity = weakReference.get();
            if (activity != null && activity.equals(context)) {
                if (this.f3841c.isWeiboAppInstalled() && this.f3841c.isWeiboAppSupportAPI() && this.f3841c.checkEnvironment(true)) {
                    new j(this, sNSMessage, context, iSNSActionListener).start();
                    return 0;
                }
                LogEx.w(g, "sendMessage - API not supported. Use base http.");
                if (!c()) {
                    return 11;
                }
                if (iSNSActionListener == null) {
                    return 0;
                }
                iSNSActionListener.onRunning();
                return 0;
            }
            LogEx.e(g, "sendMessage - need reinit!");
            if (iSNSActionListener != null) {
                iSNSActionListener.onFail(2, "Need reinit!");
            }
            return 2;
        }
        LogEx.d(g, "sendMessage - context invalid.");
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.video.androidsdk.sns.ISinaWeibo
    public void weiboListener(Intent intent, Context context) {
        if (context != 0 && (context instanceof Activity)) {
            if (this.f3841c == null) {
                return;
            }
            LogEx.e(g, "enter weiboListener");
            if (context instanceof IWeiboHandler.Request) {
                if (!this.f3841c.handleWeiboRequest(intent, (IWeiboHandler.Request) context)) {
                    LogEx.e(g, "Register request listener failed!");
                } else {
                    LogEx.d(g, "Register request listener success!");
                }
            }
            if (context instanceof IWeiboHandler.Response) {
                if (!this.f3841c.handleWeiboResponse(intent, (IWeiboHandler.Response) context)) {
                    LogEx.e(g, "Register response listener failed!");
                    return;
                } else {
                    LogEx.d(g, "Register response listener success!");
                    return;
                }
            }
            return;
        }
        LogEx.d(g, "weiboListener - context invalid.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SinaWeibo.java */
    /* loaded from: classes.dex */
    public class a implements WeiboAuthListener {

        /* renamed from: a, reason: collision with root package name */
        Vector<ISNSAuthListener> f3843a = new Vector<>();

        public a() {
        }

        private synchronized void b() {
            while (this.f3843a.size() > 0) {
                this.f3843a.remove(0).onComplete();
            }
        }

        public synchronized void a(ISNSAuthListener iSNSAuthListener) {
            if (!this.f3843a.contains(iSNSAuthListener)) {
                this.f3843a.add(iSNSAuthListener);
            }
        }

        @Override // com.sina.weibo.sdk.auth.WeiboAuthListener
        public void onCancel() {
            LogEx.i(h.g, "Auth canceled");
            a();
        }

        @Override // com.sina.weibo.sdk.auth.WeiboAuthListener
        public void onComplete(Bundle bundle) {
            for (String str : bundle.keySet()) {
                LogEx.d(h.g, "bundle: key = " + str + " value = " + bundle.getString(str));
            }
            String string = bundle.getString("code");
            if (string != null) {
                LogEx.d(h.g, "Auth success! code = " + string);
                h.this.f3840b.putString(Constants.PREF_SINA_CODE, string);
                if (h.this.c()) {
                    b();
                    return;
                }
                return;
            }
            String string2 = bundle.getString("access_token");
            String string3 = bundle.getString(Constants.SINA_WEIBO_UID);
            String string4 = bundle.getString(Constants.SINA_WEIBO_USERNAME);
            String string5 = bundle.getString("expires_in");
            String string6 = bundle.getString(Constants.SINA_WEIBO_REMINDIN);
            if (TextUtils.isEmpty(string5)) {
                LogEx.e(h.g, "AccessToken invalid! expires_in = " + string5);
                string5 = "0";
            }
            h.this.i = new Oauth2AccessToken(string2, string5);
            if (!h.this.i.isSessionValid()) {
                LogEx.d(h.g, "AccessToken session invalid!");
                a(11, "getToken process: AccessToken got still session invalid!");
                return;
            }
            h.this.f3840b.putString(Constants.PREF_SINA_ACCESSTOKEN, string2);
            h.this.f3840b.putString(Constants.PREF_SINA_UID, string3);
            h hVar = h.this;
            hVar.f3840b.putLong(Constants.PREF_SINA_EXPIRESTIME, hVar.i.getExpiresTime());
            h.this.f3840b.putString(Constants.PREF_SINA_REMINDIN, string6);
            if (TextUtils.isEmpty(string4)) {
                if (TextUtils.isEmpty(string3)) {
                    LogEx.e(h.g, "getUserName process: uid is null!Cannot get UserName, skip.");
                }
            } else {
                h.this.f3840b.putString(Constants.PREF_SINA_USERNAME, string4);
            }
            LogEx.d(h.g, "isSessionValid~~~~~~~token = " + string2 + " uid = " + string3 + " userName = " + string4 + " expiresIn = " + string5 + " remindIn = " + string6);
            b();
        }

        @Override // com.sina.weibo.sdk.auth.WeiboAuthListener
        public void onWeiboException(WeiboException weiboException) {
            LogEx.w(h.g, "Auth exception:" + weiboException.getMessage());
            weiboException.printStackTrace();
            a(weiboException);
        }

        private synchronized void a() {
            while (this.f3843a.size() > 0) {
                this.f3843a.remove(0).onCancel();
            }
        }

        private synchronized void a(int i, String str) {
            while (this.f3843a.size() > 0) {
                this.f3843a.remove(0).onError(i, str);
            }
        }

        private synchronized void a(Exception exc) {
            while (this.f3843a.size() > 0) {
                this.f3843a.remove(0).onException(exc);
            }
        }
    }

    public static h a() {
        if (f3839a == null) {
            f3839a = new h();
        }
        return f3839a;
    }

    private void a(ISNSAuthListener iSNSAuthListener) {
        if (this.f3842d == null) {
            this.f3842d = new a();
        }
        this.f3842d.a(iSNSAuthListener);
        try {
            if (this.j == null) {
                LogEx.w(g, "processAuth - ssohandler not construct! try to user weibo");
                if (this.f != null && this.f.get() != null) {
                    if (this.h == null) {
                        LogEx.e(g, "processAuth - weibo null!");
                        return;
                    } else {
                        this.h.anthorize(this.f3842d);
                        return;
                    }
                }
                LogEx.e(g, "processAuth - Activity null! Cannot weibo auth.");
                return;
            }
            this.j.authorize(this.f3842d);
        } catch (Exception e) {
            LogEx.w(g, "SinaWeibo.processAuth  - Catch exception:" + e.getMessage());
        }
    }
}
