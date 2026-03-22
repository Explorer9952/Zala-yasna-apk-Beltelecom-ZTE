package com.video.androidsdk.sns.a;

import com.sina.weibo.sdk.api.share.IWeiboDownloadListener;
import com.video.androidsdk.log.LogEx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SinaWeibo.java */
/* loaded from: classes.dex */
public class i implements IWeiboDownloadListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f3845a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f3845a = hVar;
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboDownloadListener
    public void onCancel() {
        LogEx.d(h.g, "User cancel download!");
    }
}
