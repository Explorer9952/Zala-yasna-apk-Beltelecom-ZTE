package com.video.androidsdk.sns.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.api.share.SendMessageToWeiboRequest;
import com.sina.weibo.sdk.api.share.SendMultiMessageToWeiboRequest;
import com.video.androidsdk.common.DeviceInfo;
import com.video.androidsdk.common.util.BitmapUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.sns.ISNSActionListener;
import com.video.androidsdk.sns.bean.SNSMessage;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SinaWeibo.java */
/* loaded from: classes.dex */
public class j extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SNSMessage f3846a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f3847b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ISNSActionListener f3848c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ h f3849d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, SNSMessage sNSMessage, Context context, ISNSActionListener iSNSActionListener) {
        this.f3849d = hVar;
        this.f3846a = sNSMessage;
        this.f3847b = context;
        this.f3848c = iSNSActionListener;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            int weiboAppSupportAPI = this.f3849d.f3841c.getWeiboAppSupportAPI();
            LogEx.w(h.g, "sendMessage - API supported. Use weibo client. ver." + weiboAppSupportAPI);
            if (weiboAppSupportAPI >= 10351) {
                WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
                if (this.f3846a.getText() != null) {
                    TextObject textObject = new TextObject();
                    textObject.text = this.f3846a.getText();
                    weiboMultiMessage.textObject = textObject;
                }
                if (this.f3846a.getBitmap() != null) {
                    DisplayMetrics displayMetrix = DeviceInfo.getDisplayMetrix(this.f3847b);
                    ImageObject imageObject = new ImageObject();
                    imageObject.setImageObject(BitmapUtil.compressThumb(this.f3846a.getBitmap(), displayMetrix.widthPixels, displayMetrix.heightPixels, 65536, this.f3847b).getBitmap());
                    weiboMultiMessage.imageObject = imageObject;
                }
                SendMultiMessageToWeiboRequest sendMultiMessageToWeiboRequest = new SendMultiMessageToWeiboRequest();
                sendMultiMessageToWeiboRequest.transaction = String.valueOf(UUID.randomUUID());
                sendMultiMessageToWeiboRequest.multiMessage = weiboMultiMessage;
                new Handler(Looper.getMainLooper()).post(new k(this, sendMultiMessageToWeiboRequest));
                return;
            }
            WeiboMessage weiboMessage = new WeiboMessage();
            SendMessageToWeiboRequest sendMessageToWeiboRequest = new SendMessageToWeiboRequest();
            sendMessageToWeiboRequest.transaction = String.valueOf(UUID.randomUUID());
            if (this.f3846a.getBitmap() != null) {
                DisplayMetrics displayMetrix2 = DeviceInfo.getDisplayMetrix(this.f3847b);
                new ImageObject().setImageObject(BitmapUtil.compressThumb(this.f3846a.getBitmap(), displayMetrix2.widthPixels, displayMetrix2.heightPixels, 65536, this.f3847b).getBitmap());
            } else if (this.f3846a.getText() != null) {
                TextObject textObject2 = new TextObject();
                textObject2.text = this.f3846a.getText();
                weiboMessage.mediaObject = textObject2;
            }
            sendMessageToWeiboRequest.transaction = String.valueOf(UUID.randomUUID());
            sendMessageToWeiboRequest.message = weiboMessage;
            new Handler(Looper.getMainLooper()).post(new l(this, sendMessageToWeiboRequest));
        } catch (Exception e) {
            LogEx.w(h.g, "SinaWeibo.sendMessage - Native Function. Catch Exception: " + e.getMessage());
            e.printStackTrace();
            if (this.f3848c != null) {
                new Handler(Looper.getMainLooper()).post(new m(this, e));
            }
        }
    }
}
