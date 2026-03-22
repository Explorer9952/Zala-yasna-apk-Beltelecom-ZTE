package com.video.androidsdk.collectAgent;

import android.os.Handler;
import com.video.androidsdk.log.LogEx;

/* compiled from: CollectAgent.java */
/* loaded from: classes.dex */
final class a implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        long j;
        LogEx.d("CollectAgent", "start report collectInfo");
        CollectAgent.m();
        handler = CollectAgent.s;
        j = CollectAgent.e;
        handler.postDelayed(this, j * 60 * 1000);
    }
}
