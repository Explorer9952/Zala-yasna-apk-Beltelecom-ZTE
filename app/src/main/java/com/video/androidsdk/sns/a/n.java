package com.video.androidsdk.sns.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.video.androidsdk.common.ClientNetworkInfo;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.sns.ISNSActionListener;
import com.video.androidsdk.sns.ISNSAuthListener;
import com.video.androidsdk.sns.ITencentWechat;
import com.video.androidsdk.sns.bean.OAuth2Param;
import com.video.androidsdk.sns.bean.SNSMessage;

/* compiled from: TencentWechat.java */
/* loaded from: classes.dex */
public class n implements ITencentWechat {

    /* renamed from: a, reason: collision with root package name */
    static n f3856a = null;
    private static final String g = "n";

    /* renamed from: b, reason: collision with root package name */
    int f3857b;

    /* renamed from: c, reason: collision with root package name */
    boolean f3858c;

    /* renamed from: d, reason: collision with root package name */
    String f3859d;
    IWXAPI e;
    IWXAPIEventHandler f = new o(this);

    public static n a() {
        if (f3856a == null) {
            f3856a = new n();
        }
        return f3856a;
    }

    @Override // com.video.androidsdk.sns.ITencentWechat
    public void authCallBack(int i, int i2, Intent intent) {
        if (this.e != null) {
            LogEx.d(g, "=====onActivityResult=mWXApi resultCode = " + i2 + " requestCode = " + i);
            if (this.e.handleIntent(intent, this.f)) {
                return;
            }
            LogEx.e(g, "Set handler failed!");
        }
    }

    @Override // com.video.androidsdk.sns.ISNSWrapper
    public void authorize(Context context, ISNSAuthListener iSNSAuthListener) {
        if (context != null && (context instanceof Activity)) {
            if (this.f3858c && this.e != null) {
                if (iSNSAuthListener != null) {
                    iSNSAuthListener.onComplete();
                    return;
                }
                return;
            } else {
                LogEx.e(g, "WeChat not initlized!");
                if (iSNSAuthListener != null) {
                    iSNSAuthListener.onError(2, "authorize - WeChat not initlized!");
                    return;
                }
                return;
            }
        }
        LogEx.d(g, "authorize - context invalid.");
        if (iSNSAuthListener != null) {
            iSNSAuthListener.onError(1, "authorize - context invalid.");
        }
    }

    @Override // com.video.androidsdk.sns.ITencentWechat
    public int getScene() {
        return this.f3857b;
    }

    @Override // com.video.androidsdk.sns.ISNSWrapper
    public int init(Context context, OAuth2Param oAuth2Param) {
        this.f3858c = false;
        if (context == null || !(context instanceof Activity) || oAuth2Param == null) {
            return 1;
        }
        this.f3859d = oAuth2Param.getAppKey();
        try {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, oAuth2Param.getAppKey(), false);
            this.e = createWXAPI;
            if (createWXAPI == null) {
                LogEx.e(g, "create wechatapi failed!");
                return 5;
            }
            if (!createWXAPI.isWXAppInstalled()) {
                LogEx.e(g, "WeChat not installed!");
                return 13;
            }
            if (!this.e.isWXAppSupportAPI()) {
                LogEx.e(g, "WXApi not support!");
                return 12;
            }
            this.f3858c = true;
            return 0;
        } catch (Exception e) {
            LogEx.w(g, "TencentWechat.init - Catch Exception: " + e.getMessage());
            e.printStackTrace();
            return 255;
        }
    }

    @Override // com.video.androidsdk.sns.ISNSWrapper
    public boolean isAuth() {
        return this.f3858c;
    }

    @Override // com.video.androidsdk.sns.ITencentWechat
    public int isClientInstalled() {
        IWXAPI iwxapi = this.e;
        if (iwxapi == null) {
            return 2;
        }
        return iwxapi.isWXAppInstalled() ? 0 : 255;
    }

    @Override // com.video.androidsdk.sns.ITencentWechat
    public int openClient() {
        IWXAPI iwxapi = this.e;
        if (iwxapi == null) {
            return 2;
        }
        return iwxapi.openWXApp() ? 0 : 255;
    }

    @Override // com.video.androidsdk.sns.ITencentWechat
    public int registerApp() {
        IWXAPI iwxapi = this.e;
        if (iwxapi == null) {
            return 2;
        }
        return iwxapi.registerApp(this.f3859d) ? 0 : 255;
    }

    @Override // com.video.androidsdk.sns.ISNSWrapper
    public int sendMessage(Context context, SNSMessage sNSMessage, ISNSActionListener iSNSActionListener) {
        int wXAppSupportAPI;
        if (sNSMessage == null) {
            LogEx.d(g, "sendMessage - msg is null.");
            return 1;
        }
        if (context != null && (context instanceof Activity)) {
            if (this.f3858c && this.e != null) {
                if (!ClientNetworkInfo.isNetworkAvailable((ConnectivityManager) context.getSystemService("connectivity"))) {
                    LogEx.d(g, "sendMessage - network invalid.");
                    return 153;
                }
                if (this.f3857b == 1 && (wXAppSupportAPI = this.e.getWXAppSupportAPI()) < 553779201) {
                    LogEx.d(g, "WeChat Version is " + wXAppSupportAPI + ". Not support friends cicle.");
                    return 12;
                }
                new p(this, sNSMessage, context, iSNSActionListener).start();
                return 0;
            }
            LogEx.e(g, "WeChat not initlized!");
            return 2;
        }
        LogEx.d(g, "sendMessage - context invalid.");
        return 1;
    }

    @Override // com.video.androidsdk.sns.ITencentWechat
    public void setScene(int i) {
        this.f3857b = i;
    }
}
