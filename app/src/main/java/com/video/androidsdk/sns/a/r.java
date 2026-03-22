package com.video.androidsdk.sns.a;

import com.video.androidsdk.sns.ISNSActionListener;

/* compiled from: TencentWechat.java */
/* loaded from: classes.dex */
class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Exception f3867a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f3868b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, Exception exc) {
        this.f3868b = pVar;
        this.f3867a = exc;
    }

    @Override // java.lang.Runnable
    public void run() {
        ISNSActionListener iSNSActionListener = this.f3868b.f3863c;
        if (iSNSActionListener != null) {
            iSNSActionListener.onFail(8, "WX send request failed! " + this.f3867a.getMessage());
        }
    }
}
