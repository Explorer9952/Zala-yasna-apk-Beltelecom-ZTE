package com.video.androidsdk.sns.a;

import com.sina.weibo.sdk.api.share.SendMessageToWeiboRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.sns.ISNSActionListener;

/* compiled from: SinaWeibo.java */
/* loaded from: classes.dex */
class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SendMessageToWeiboRequest f3852a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ j f3853b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, SendMessageToWeiboRequest sendMessageToWeiboRequest) {
        this.f3853b = jVar;
        this.f3852a = sendMessageToWeiboRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3853b.f3849d.f3841c.sendRequest(this.f3852a)) {
            return;
        }
        LogEx.e(h.g, "sendMessage - Send Message failed!");
        ISNSActionListener iSNSActionListener = this.f3853b.f3848c;
        if (iSNSActionListener != null) {
            iSNSActionListener.onFail(8, "Sina weibo send failed!");
        }
    }
}
