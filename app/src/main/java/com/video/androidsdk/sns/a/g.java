package com.video.androidsdk.sns.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.sns.ISNSActionListener;
import com.video.androidsdk.sns.ISNSAuthListener;
import com.video.androidsdk.sns.ISNSWrapper;
import com.video.androidsdk.sns.bean.OAuth2Param;
import com.video.androidsdk.sns.bean.SNSMessage;

/* compiled from: SMS.java */
/* loaded from: classes.dex */
public class g implements ISNSWrapper {

    /* renamed from: a, reason: collision with root package name */
    static g f3837a = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f3838b = "g";

    public static g a() {
        if (f3837a == null) {
            f3837a = new g();
        }
        return f3837a;
    }

    @Override // com.video.androidsdk.sns.ISNSWrapper
    public void authorize(Context context, ISNSAuthListener iSNSAuthListener) {
        if (iSNSAuthListener != null) {
            iSNSAuthListener.onComplete();
        }
    }

    @Override // com.video.androidsdk.sns.ISNSWrapper
    public int init(Context context, OAuth2Param oAuth2Param) {
        return 0;
    }

    @Override // com.video.androidsdk.sns.ISNSWrapper
    public boolean isAuth() {
        return true;
    }

    @Override // com.video.androidsdk.sns.ISNSWrapper
    public int sendMessage(Context context, SNSMessage sNSMessage, ISNSActionListener iSNSActionListener) {
        if (sNSMessage == null) {
            LogEx.d(f3838b, "sendMessage - msg is null.");
            return 1;
        }
        if (context == null) {
            LogEx.d(f3838b, "sendMessage - context is null.");
            return 1;
        }
        if (!(context instanceof Activity)) {
            LogEx.d(f3838b, "sendMessage - context is not activity.");
            return 1;
        }
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:"));
        if (sNSMessage.getText() != null) {
            intent.putExtra("sms_body", sNSMessage.getText());
        }
        context.startActivity(intent);
        return 0;
    }
}
