package com.video.androidsdk.player;

import android.media.MediaPlayer;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.common.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidMediaPlayer.java */
/* loaded from: classes.dex */
public class g implements MediaPlayer.OnPreparedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f3376a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.f3376a = cVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(android.media.MediaPlayer mediaPlayer) {
        int i;
        int i2;
        int i3;
        LogEx.d("AndroidMediaPlayer", "onPrepared called");
        i = this.f3376a.y;
        if (-1 != i) {
            i2 = this.f3376a.y;
            if (i2 == 0) {
                return;
            }
            i3 = this.f3376a.y;
            if (3 != i3) {
                this.f3376a.y = 2;
                this.f3376a.w = false;
                com.video.androidsdk.player.common.c.b(c.a.OPEN_COMPLETE_TIME);
                this.f3376a.f3307c.onStateChanged(2);
                this.f3376a.i.sendEmptyMessage(2);
            }
        }
    }
}
