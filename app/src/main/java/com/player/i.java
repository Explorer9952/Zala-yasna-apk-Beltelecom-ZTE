package com.player;

import android.os.SystemClock;
import android.view.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: OmafMediaPlayer.java */
/* loaded from: classes.dex */
class i extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ KeyEvent f2422a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ float f2423b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f2424c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ OmafMediaPlayer f2425d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(OmafMediaPlayer omafMediaPlayer, KeyEvent keyEvent, float f, int i) {
        this.f2425d = omafMediaPlayer;
        this.f2422a = keyEvent;
        this.f2423b = f;
        this.f2424c = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Timer timer;
        this.f2425d.C = SystemClock.uptimeMillis();
        this.f2425d.a(this.f2422a.getKeyCode(), this.f2423b);
        OmafMediaPlayer omafMediaPlayer = this.f2425d;
        if (omafMediaPlayer.C - omafMediaPlayer.B <= this.f2424c * 1000 || (timer = omafMediaPlayer.A) == null) {
            return;
        }
        timer.cancel();
    }
}
