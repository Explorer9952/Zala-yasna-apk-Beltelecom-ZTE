package com.video.androidsdk.player.agama;

import android.os.Handler;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AgamaIntegration.java */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AgamaIntegration f3329a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AgamaIntegration agamaIntegration) {
        this.f3329a = agamaIntegration;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Log.d("AgamaIntegration", "Reporting Bufferlength");
        handler = this.f3329a.s;
        handler.postDelayed(this, 1000L);
    }
}
