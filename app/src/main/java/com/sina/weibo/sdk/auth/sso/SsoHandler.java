package com.sina.weibo.sdk.auth.sso;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.sina.sso.RemoteSSO;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuth;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.exception.WeiboDialogException;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.SecurityHelper;
import java.util.Iterator;

/* loaded from: classes.dex */
public class SsoHandler {
    private static final String DEFAULT_SINA_WEIBO_PACKAGE_NAME = "com.sina.weibo";
    private static final String DEFAULT_WEIBO_REMOTE_SSO_SERVICE_NAME = "com.sina.weibo.remotessoservice";
    private static final int REQUEST_CODE_SSO_AUTH = 32973;
    private static final String TAG = "Weibo_SSO_login";
    private Activity mAuthActivity;
    private WeiboAuthListener mAuthListener;
    private ServiceConnection mConnection = new ServiceConnection() { // from class: com.sina.weibo.sdk.auth.sso.SsoHandler.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            RemoteSSO asInterface = RemoteSSO.Stub.asInterface(iBinder);
            try {
                if (SsoHandler.this.startSingleSignOn(asInterface.getPackageName(), asInterface.getActivityName())) {
                    return;
                }
                SsoHandler.this.mWeibo.anthorize(SsoHandler.this.mAuthListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            SsoHandler.this.mWeibo.anthorize(SsoHandler.this.mAuthListener);
        }
    };
    private int mSSOAuthRequestCode;
    private WeiboAuth mWeibo;

    public SsoHandler(Activity activity, WeiboAuth weiboAuth) {
        this.mAuthActivity = activity;
        this.mWeibo = weiboAuth;
    }

    private boolean bindRemoteSSOService(Context context, String str) {
        if (TextUtils.isEmpty(str) || str.trim().equals("")) {
            str = DEFAULT_SINA_WEIBO_PACKAGE_NAME;
        }
        Intent intent = new Intent(DEFAULT_WEIBO_REMOTE_SSO_SERVICE_NAME);
        intent.setPackage(str);
        if (context.bindService(intent, this.mConnection, 1)) {
            return true;
        }
        return context.bindService(new Intent(DEFAULT_WEIBO_REMOTE_SSO_SERVICE_NAME), this.mConnection, 1);
    }

    public static ComponentName isServiceExisted(Context context, String str) {
        Iterator<ActivityManager.RunningServiceInfo> it2 = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
        while (it2.hasNext()) {
            ComponentName componentName = it2.next().service;
            if (componentName.getPackageName().equals(str)) {
                if (componentName.getClassName().equals(String.valueOf(str) + ".business.RemoteSSOService")) {
                    return componentName;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean startSingleSignOn(String str, String str2) {
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        intent.putExtras(this.mWeibo.getAuthInfo().getAuthBundle());
        intent.putExtra(WBConstants.COMMAND_TYPE_KEY, 3);
        intent.putExtra(WBConstants.TRAN, String.valueOf(System.currentTimeMillis()));
        boolean z = false;
        if (!SecurityHelper.validateAppSignatureForIntent(this.mAuthActivity, intent)) {
            return false;
        }
        try {
            this.mAuthActivity.startActivityForResult(intent, this.mSSOAuthRequestCode);
            z = true;
        } catch (ActivityNotFoundException unused) {
        }
        this.mAuthActivity.getApplicationContext().unbindService(this.mConnection);
        return z;
    }

    public void authorize(WeiboAuthListener weiboAuthListener) {
        authorize(32973, weiboAuthListener, null);
    }

    public void authorizeCallBack(int i, int i2, Intent intent) {
        if (i == this.mSSOAuthRequestCode) {
            if (i2 != -1) {
                if (i2 == 0) {
                    if (intent != null) {
                        LogUtil.d(TAG, "Login failed: " + intent.getStringExtra("error"));
                        this.mAuthListener.onWeiboException(new WeiboDialogException(intent.getStringExtra("error"), intent.getIntExtra("error_code", -1), intent.getStringExtra("failing_url")));
                        return;
                    }
                    LogUtil.d(TAG, "Login canceled by user.");
                    this.mAuthListener.onCancel();
                    return;
                }
                return;
            }
            if (SecurityHelper.checkResponseAppLegal(this.mAuthActivity, intent)) {
                String stringExtra = intent.getStringExtra("error");
                if (stringExtra == null) {
                    stringExtra = intent.getStringExtra(NativeProtocol.BRIDGE_ARG_ERROR_TYPE);
                }
                if (stringExtra != null) {
                    if (!stringExtra.equals("access_denied") && !stringExtra.equals("OAuthAccessDeniedException")) {
                        String stringExtra2 = intent.getStringExtra(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
                        if (stringExtra2 != null) {
                            stringExtra = String.valueOf(stringExtra) + ":" + stringExtra2;
                        }
                        LogUtil.d(TAG, "Login failed: " + stringExtra);
                        this.mAuthListener.onWeiboException(new WeiboDialogException(stringExtra, i2, stringExtra2));
                        return;
                    }
                    LogUtil.d(TAG, "Login canceled by user.");
                    this.mAuthListener.onCancel();
                    return;
                }
                Bundle extras = intent.getExtras();
                Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(extras);
                if (parseAccessToken != null && parseAccessToken.isSessionValid()) {
                    LogUtil.d(TAG, "Login Success! " + parseAccessToken.toString());
                    this.mAuthListener.onComplete(extras);
                    return;
                }
                LogUtil.d(TAG, "Failed to receive access token by SSO");
                this.mWeibo.anthorize(this.mAuthListener);
            }
        }
    }

    public void authorize(WeiboAuthListener weiboAuthListener, String str) {
        authorize(32973, weiboAuthListener, str);
    }

    public void authorize(int i, WeiboAuthListener weiboAuthListener, String str) {
        WeiboAuth weiboAuth;
        this.mSSOAuthRequestCode = i;
        this.mAuthListener = weiboAuthListener;
        if (bindRemoteSSOService(this.mAuthActivity.getApplicationContext(), str) || (weiboAuth = this.mWeibo) == null) {
            return;
        }
        weiboAuth.anthorize(this.mAuthListener);
    }
}
