package com.video.androidsdk.player;

import android.os.Handler;
import android.os.Message;
import com.video.androidsdk.log.LogEx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FvPlayer.java */
/* loaded from: classes.dex */
public class v extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f3394a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(l lVar) {
        this.f3394a = lVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            LogEx.d(l.h, "handler message: MSG_OPEN");
            this.f3394a.a();
            this.f3394a.k.postDelayed(new w(this), 50L);
        } else {
            if (i != 2) {
                LogEx.w(l.h, "unkown msg");
                return;
            }
            LogEx.d(l.h, "handler message: MSG_UPDATE_UI");
            this.f3394a.a();
            sendEmptyMessageDelayed(2, 1000L);
        }
    }
}
