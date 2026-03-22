package com.video.androidsdk.player;

import android.media.MediaPlayer;
import com.video.androidsdk.log.LogEx;
import ijk.media.player.IMediaPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidMediaPlayer.java */
/* loaded from: classes.dex */
public class f implements MediaPlayer.OnInfoListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f3375a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.f3375a = cVar;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(android.media.MediaPlayer mediaPlayer, int i, int i2) {
        int i3;
        LogEx.i("AndroidMediaPlayer", "onInfo called");
        LogEx.i("AndroidMediaPlayer", "whatInfo ----" + i + ", extra--------" + i2);
        if (this.f3375a.f3307c == null) {
            LogEx.w("AndroidMediaPlayer", "null == mOnEventListener");
            return false;
        }
        if (i != 1) {
            switch (i) {
                case IMediaPlayer.MEDIA_INFO_VIDEO_TRACK_LAGGING /* 700 */:
                    LogEx.i("AndroidMediaPlayer", "MEDIA_INFO_VIDEO_TRACK_LAGGING");
                    break;
                case IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                    LogEx.i("AndroidMediaPlayer", "MEDIA_INFO_BUFFERING_START");
                    this.f3375a.f3307c.onStateChanged(7);
                    break;
                case IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                    LogEx.i("AndroidMediaPlayer", "MEDIA_INFO_BUFFERING_END");
                    this.f3375a.f3307c.onStateChanged(9);
                    StringBuilder sb = new StringBuilder();
                    sb.append("mSeekWhenPrepared: ");
                    i3 = this.f3375a.k;
                    sb.append(i3);
                    LogEx.d("AndroidMediaPlayer", sb.toString());
                    break;
                default:
                    switch (i) {
                        case 800:
                            LogEx.i("AndroidMediaPlayer", "MEDIA_INFO_BAD_INTERLEAVING");
                            break;
                        case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                            LogEx.i("AndroidMediaPlayer", "MEDIA_INFO_NOT_SEEKABLE");
                            break;
                        case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /* 802 */:
                            LogEx.i("AndroidMediaPlayer", "MEDIA_INFO_METADATA_UPDATE");
                            break;
                    }
            }
        } else {
            LogEx.i("AndroidMediaPlayer", "MEDIA_INFO_UNKNOWN");
        }
        return false;
    }
}
