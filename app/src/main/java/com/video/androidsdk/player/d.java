package com.video.androidsdk.player;

import android.media.MediaPlayer;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.IBasePlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidMediaPlayer.java */
/* loaded from: classes.dex */
public class d implements MediaPlayer.OnCompletionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f3373a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f3373a = cVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(android.media.MediaPlayer mediaPlayer) {
        LogEx.d("AndroidMediaPlayer", "onCompletion called");
        this.f3373a.y = 5;
        IBasePlayer.OnEventListener onEventListener = this.f3373a.f3307c;
        if (onEventListener != null) {
            onEventListener.onStateChanged(5);
        }
    }
}
