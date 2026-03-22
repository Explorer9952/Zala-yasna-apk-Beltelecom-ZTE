package com.video.androidsdk.sns.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.video.androidsdk.common.util.BitmapUtil;
import com.video.androidsdk.common.util.FileUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.sns.ISNSActionListener;
import com.video.androidsdk.sns.ISNSAuthListener;
import com.video.androidsdk.sns.ISNSWrapper;
import com.video.androidsdk.sns.bean.OAuth2Param;
import com.video.androidsdk.sns.bean.SNSMessage;
import java.io.File;

/* compiled from: EMail.java */
/* loaded from: classes.dex */
public class a implements ISNSWrapper {

    /* renamed from: a, reason: collision with root package name */
    static a f3823a = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f3824b = "a";

    public static a a() {
        if (f3823a == null) {
            f3823a = new a();
        }
        return f3823a;
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
            LogEx.d(f3824b, "sendMessage - msg is null.");
            return 1;
        }
        if (context == null) {
            LogEx.d(f3824b, "sendMessage - context is null.");
            return 1;
        }
        if (!(context instanceof Activity)) {
            LogEx.d(f3824b, "sendMessage - context is not activity.");
            return 1;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        if (sNSMessage.getTitle() != null) {
            intent.putExtra("android.intent.extra.SUBJECT", sNSMessage.getTitle());
        }
        if (sNSMessage.getText() != null) {
            intent.putExtra("android.intent.extra.TEXT", sNSMessage.getText());
        }
        if (sNSMessage.getBitmap() != null) {
            if (FileUtil.write2File(context.getFilesDir().getAbsolutePath() + "/.tmpFile.png", BitmapUtil.bitmap2Bytes(sNSMessage.getBitmap()))) {
                intent.setType("application/octet-stream");
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(context.getFilesDir(), ".tmpFile.png")));
            }
        } else {
            intent.setType("text/plain");
        }
        context.startActivity(intent);
        return 0;
    }
}
