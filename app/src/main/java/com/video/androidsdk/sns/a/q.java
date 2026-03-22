package com.video.androidsdk.sns.a;

import com.tencent.mm.sdk.openapi.SendMessageToWX;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.sns.ISNSActionListener;

/* compiled from: TencentWechat.java */
/* loaded from: classes.dex */
class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SendMessageToWX.Req f3865a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f3866b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, SendMessageToWX.Req req) {
        this.f3866b = pVar;
        this.f3865a = req;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        if (this.f3866b.f3864d.e.sendReq(this.f3865a)) {
            return;
        }
        str = n.g;
        LogEx.e(str, "WX send request failed!");
        ISNSActionListener iSNSActionListener = this.f3866b.f3863c;
        if (iSNSActionListener != null) {
            iSNSActionListener.onFail(8, "WX send request failed!");
        }
    }
}
