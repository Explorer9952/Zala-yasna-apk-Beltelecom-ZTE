package com.video.androidsdk.player;

import android.media.MediaPlayer;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.IBasePlayer;
import com.video.androidsdk.player.common.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidMediaPlayer.java */
/* loaded from: classes.dex */
public class h implements MediaPlayer.OnSeekCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f3377a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.f3377a = cVar;
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(android.media.MediaPlayer mediaPlayer) {
        int i;
        LogEx.d("AndroidMediaPlayer", "onSeekComplete called");
        com.video.androidsdk.player.common.c.b(c.a.SEEK_COMPLETE_TIME);
        IBasePlayer.OnEventListener onEventListener = this.f3377a.f3307c;
        if (onEventListener != null) {
            onEventListener.onStateChanged(11);
        }
        i = this.f3377a.y;
        if (4 == i) {
            return;
        }
        this.f3377a.j.start();
        this.f3377a.y = 3;
    }
}
