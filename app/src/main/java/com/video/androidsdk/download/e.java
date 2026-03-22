package com.video.androidsdk.download;

import com.video.androidsdk.download.Linstener.SDKDownloadLoginSTBListener;
import com.video.androidsdk.log.LogEx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SDKDownloadMgr.java */
/* loaded from: classes.dex */
public class e extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3121a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f3122b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SDKDownloadLoginSTBListener f3123c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ SDKDownloadMgr f3124d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SDKDownloadMgr sDKDownloadMgr, String str, int i, SDKDownloadLoginSTBListener sDKDownloadLoginSTBListener) {
        this.f3124d = sDKDownloadMgr;
        this.f3121a = str;
        this.f3122b = i;
        this.f3123c = sDKDownloadLoginSTBListener;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        b bVar;
        int i;
        b bVar2;
        bVar = this.f3124d.e;
        if (bVar != null) {
            bVar2 = this.f3124d.e;
            i = bVar2.a(this.f3121a, this.f3122b);
            LogEx.d("SDKDownloadMgr", "loginSTB:result:" + i);
            if (i == 0) {
                this.f3124d.f = 5;
                this.f3124d.g = this.f3121a;
                this.f3124d.h = String.valueOf(this.f3122b);
            } else {
                this.f3124d.f = 4;
            }
        } else {
            LogEx.e("SDKDownloadMgr", "RemoteDownLoadProxy is null");
            i = -1;
        }
        SDKDownloadLoginSTBListener sDKDownloadLoginSTBListener = this.f3123c;
        if (sDKDownloadLoginSTBListener != null) {
            sDKDownloadLoginSTBListener.onLoginSTBReturn(i);
        }
    }
}
