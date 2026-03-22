package com.video.androidsdk.sns.a;

import com.sina.weibo.sdk.api.share.SendMultiMessageToWeiboRequest;
import com.video.androidsdk.log.LogEx;

/* compiled from: SinaWeibo.java */
/* loaded from: classes.dex */
class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SendMultiMessageToWeiboRequest f3850a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ j f3851b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, SendMultiMessageToWeiboRequest sendMultiMessageToWeiboRequest) {
        this.f3851b = jVar;
        this.f3850a = sendMultiMessageToWeiboRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3851b.f3849d.f3841c.sendRequest(this.f3850a)) {
            return;
        }
        LogEx.e(h.g, "sendMessage - Send MultiMessage failed!");
        this.f3851b.f3848c.onFail(8, "Sina weibo send failed!");
    }
}
