package com.video.androidsdk.player;

import android.media.MediaPlayer;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.IBasePlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidMediaPlayer.java */
/* loaded from: classes.dex */
public class e implements MediaPlayer.OnErrorListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f3374a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.f3374a = cVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(android.media.MediaPlayer mediaPlayer, int i, int i2) {
        LogEx.w("AndroidMediaPlayer", "onError called");
        LogEx.w("AndroidMediaPlayer", "ErrorCode： " + i + ";  extra: " + i2);
        this.f3374a.y = -1;
        String str = "[player_error]The video is streamed and its container is not valid for progressive playback.";
        if (i == -1010) {
            LogEx.w("AndroidMediaPlayer", "MEDIA_ERROR_UNSUPPORTED");
            LogEx.e("AndroidMediaPlayer", "[player_error]The video is streamed and its container is not valid for progressive playback.");
        } else if (i == -1007) {
            LogEx.w("AndroidMediaPlayer", "MEDIA_ERROR_MALFORMED");
            str = "[player_error]Bitstream is not conforming to the related coding standard or file spec.";
            LogEx.e("AndroidMediaPlayer", "[player_error]Bitstream is not conforming to the related coding standard or file spec.");
        } else if (i == -1004) {
            LogEx.w("AndroidMediaPlayer", "MEDIA_ERROR_IO");
            str = "[player_error]File or network related operation errors.";
            LogEx.e("AndroidMediaPlayer", "[player_error]File or network related operation errors.");
        } else if (i == -110) {
            LogEx.w("AndroidMediaPlayer", "MEDIA_ERROR_TIMED_OUT");
            str = "[player_error]Some operation takes too long to complete, usually more than 3-5 seconds.";
            LogEx.e("AndroidMediaPlayer", "[player_error]Some operation takes too long to complete, usually more than 3-5 seconds.");
        } else if (i == 1) {
            LogEx.w("AndroidMediaPlayer", "MEDIA_ERROR_UNKNOWN");
            str = "[player_error]Unspecified media player error.";
            LogEx.e("AndroidMediaPlayer", "[player_error]Unspecified media player error.");
        } else if (i == 100) {
            LogEx.w("AndroidMediaPlayer", "MEDIA_ERROR_SERVER_DIED");
            str = "[player_error]Media server died.";
            LogEx.e("AndroidMediaPlayer", "[player_error]Media server died.");
        } else if (i != 200) {
            LogEx.w("AndroidMediaPlayer", "ErrorCode： " + i + ";  extra: " + i2);
            str = "";
        } else {
            LogEx.w("AndroidMediaPlayer", "MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK");
            LogEx.e("AndroidMediaPlayer", "[player_error]The video is streamed and its container is not valid for progressive playback.");
        }
        IBasePlayer.OnEventListener onEventListener = this.f3374a.f3307c;
        if (onEventListener == null) {
            return false;
        }
        onEventListener.onError(String.valueOf(i), str);
        return false;
    }
}
