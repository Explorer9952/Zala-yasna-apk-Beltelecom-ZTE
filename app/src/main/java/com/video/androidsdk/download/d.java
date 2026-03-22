package com.video.androidsdk.download;

import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteDownloadMsgCenter.java */
/* loaded from: classes.dex */
public class d extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f3120a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.f3120a = bVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f3120a.c();
    }
}
