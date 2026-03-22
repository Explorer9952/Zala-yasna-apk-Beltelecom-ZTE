package com.video.androidsdk.download;

import java.util.TimerTask;

/* compiled from: RemoteDownloadMsgCenter.java */
/* loaded from: classes.dex */
class c extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f3119a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f3119a = bVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f3119a.c();
    }
}
