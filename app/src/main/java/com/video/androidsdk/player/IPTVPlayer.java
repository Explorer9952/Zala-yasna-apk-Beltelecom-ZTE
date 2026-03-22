package com.video.androidsdk.player;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.IBasePlayer;
import com.video.androidsdk.player.common.AssetStatus;
import com.video.androidsdk.player.common.AssetType;
import com.video.androidsdk.player.common.DecoderType;
import com.video.androidsdk.player.common.PlayerConstants;
import com.video.androidsdk.player.common.SubtitleHorizontal;
import com.video.androidsdk.player.common.SubtitleVertical;
import com.video.androidsdk.player.common.ZoomModeType;
import com.video.androidsdk.player.common.c;
import com.video.androidsdk.player.ctciptvplayer.CTCIPTVPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class IPTVPlayer extends a {
    private CTCIPTVPlayer h;
    private Bundle i;
    private int j = 0;

    /* loaded from: classes.dex */
    private static class IPTVBufferingUpdateListener implements CTCIPTVPlayer.a {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<IPTVPlayer> f3239a;

        public IPTVBufferingUpdateListener(IPTVPlayer iPTVPlayer) {
            this.f3239a = new WeakReference<>(iPTVPlayer);
        }

        public void onBufferingUpdate(CTCIPTVPlayer cTCIPTVPlayer, int i) {
        }
    }

    /* loaded from: classes.dex */
    private static class IPTVCompletionListener implements CTCIPTVPlayer.b {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<IPTVPlayer> f3240a;

        public IPTVCompletionListener(IPTVPlayer iPTVPlayer) {
            this.f3240a = new WeakReference<>(iPTVPlayer);
        }

        public void onCompletion(CTCIPTVPlayer cTCIPTVPlayer) {
            IBasePlayer.OnEventListener onEventListener;
            LogEx.d("IPTVPlayer", "onCompletion");
            IPTVPlayer iPTVPlayer = this.f3240a.get();
            if (iPTVPlayer != null && (onEventListener = iPTVPlayer.f3307c) != null) {
                onEventListener.onStateChanged(5);
            } else {
                LogEx.w("IPTVPlayer", "null == player || null == player.mOnEventListener");
            }
        }
    }

    /* loaded from: classes.dex */
    private static class IPTVErrorListener implements CTCIPTVPlayer.c {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<IPTVPlayer> f3241a;

        public IPTVErrorListener(IPTVPlayer iPTVPlayer) {
            this.f3241a = new WeakReference<>(iPTVPlayer);
        }

        @Override // com.video.androidsdk.player.ctciptvplayer.CTCIPTVPlayer.c
        public boolean onError(CTCIPTVPlayer cTCIPTVPlayer, int i, String str) {
            IBasePlayer.OnEventListener onEventListener;
            LogEx.d("IPTVPlayer", "onError");
            IPTVPlayer iPTVPlayer = this.f3241a.get();
            if (iPTVPlayer != null && (onEventListener = iPTVPlayer.f3307c) != null) {
                onEventListener.onError(String.valueOf(i), str);
                return false;
            }
            LogEx.w("IPTVPlayer", "null == player || null == player.mOnEventListener");
            return false;
        }
    }

    /* loaded from: classes.dex */
    private static class IPTVInfoListener implements CTCIPTVPlayer.d {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<IPTVPlayer> f3242a;

        public IPTVInfoListener(IPTVPlayer iPTVPlayer) {
            this.f3242a = new WeakReference<>(iPTVPlayer);
        }

        public boolean onInfo(CTCIPTVPlayer cTCIPTVPlayer, int i, int i2) {
            IBasePlayer.OnEventListener onEventListener;
            LogEx.d("IPTVPlayer", "onError");
            IPTVPlayer iPTVPlayer = this.f3242a.get();
            if (iPTVPlayer == null || (onEventListener = iPTVPlayer.f3307c) == null) {
                LogEx.w("IPTVPlayer", "null == player || null == player.mOnEventListener");
                return false;
            }
            if (i == 703) {
                onEventListener.onStateChanged(12);
            } else if (i == 704) {
                onEventListener.onStateChanged(3);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    private static class IPTVPreparedListener implements CTCIPTVPlayer.e {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<IPTVPlayer> f3243a;

        public IPTVPreparedListener(IPTVPlayer iPTVPlayer) {
            this.f3243a = new WeakReference<>(iPTVPlayer);
        }

        @Override // com.video.androidsdk.player.ctciptvplayer.CTCIPTVPlayer.e
        public void onPrepared(CTCIPTVPlayer cTCIPTVPlayer) {
            IBasePlayer.OnEventListener onEventListener;
            LogEx.d("IPTVPlayer", "onPrepared");
            IPTVPlayer iPTVPlayer = this.f3243a.get();
            if (iPTVPlayer != null && (onEventListener = iPTVPlayer.f3307c) != null) {
                onEventListener.onStateChanged(2);
            } else {
                LogEx.w("IPTVPlayer", "null == player || null == player.mOnEventListener");
            }
        }
    }

    /* loaded from: classes.dex */
    private static class IPTVSeekCompleteListener implements CTCIPTVPlayer.f {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<IPTVPlayer> f3244a;

        public IPTVSeekCompleteListener(IPTVPlayer iPTVPlayer) {
            this.f3244a = new WeakReference<>(iPTVPlayer);
        }

        public void onSeekComplete(CTCIPTVPlayer cTCIPTVPlayer) {
        }
    }

    /* loaded from: classes.dex */
    private static class IPTVVideoSizeChangedListener implements CTCIPTVPlayer.g {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<IPTVPlayer> f3245a;

        public IPTVVideoSizeChangedListener(IPTVPlayer iPTVPlayer) {
            this.f3245a = new WeakReference<>(iPTVPlayer);
        }

        public void onVideoSizeChanged(CTCIPTVPlayer cTCIPTVPlayer, int i, int i2) {
        }
    }

    public IPTVPlayer(Context context, Bundle bundle) {
        this.m = context;
        this.i = bundle;
        a();
    }

    private void a() {
        LogEx.i("IPTVPlayer", "Create new instance of IPTVPlayer");
        boolean z = this.i.getBoolean(PlayerConstants.STR_IS_PIP);
        LogEx.i("IPTVPlayer", "isPIP = " + z);
        this.h = new CTCIPTVPlayer(z);
    }

    public static Date getUtcTimeInDate(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(14, -(calendar.get(15) + calendar.get(16)));
        return calendar.getTime();
    }

    public String enableCaption(int i) {
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        return cTCIPTVPlayer != null ? cTCIPTVPlayer.f(i) : "";
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void enableSubtitle(boolean z) {
        super.enableSubtitle(z);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getAssetCount(AssetType assetType) {
        return super.getAssetCount(assetType);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getAssetIndex(AssetType assetType, AssetStatus assetStatus) {
        return super.getAssetIndex(assetType, assetStatus);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getAudioChannel() {
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        if (cTCIPTVPlayer != null) {
            return cTCIPTVPlayer.l();
        }
        return 0;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getAudioInfoArray(ArrayList<String> arrayList) {
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        if (cTCIPTVPlayer != null) {
            arrayList.addAll(cTCIPTVPlayer.o());
            LogEx.i("IPTVPlayer", "lstString is " + arrayList + " RESULT IS " + this.h.o());
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getBufferedPosition() {
        return super.getBufferedPosition();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getCurrentPosition() {
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        if (cTCIPTVPlayer == null) {
            return 0L;
        }
        long e = cTCIPTVPlayer.e() * 1000;
        LogEx.i("IPTVPlayer", "IPTVPlayer Position  is  " + e);
        return e;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getDuration() {
        if (this.h == null) {
            return 0L;
        }
        long f = r0.f() * 1000;
        LogEx.i("IPTVPlayer", "IPTVPlayer duration  is  " + f);
        if (f < 0) {
            return 0L;
        }
        return f;
    }

    public int getPlayerId() {
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        if (cTCIPTVPlayer != null) {
            return cTCIPTVPlayer.a();
        }
        return -1;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getPlayerState() {
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        if (cTCIPTVPlayer != null) {
            int d2 = cTCIPTVPlayer.d();
            LogEx.d("IPTVPlayer", "IPTVPlayer status  is  " + d2);
            this.j = d2;
        }
        return this.j;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public String getProbeKP() {
        return super.getProbeKP();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getScreenBrightness() {
        return super.getScreenBrightness();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getSubtitleInfoArray(ArrayList<String> arrayList) {
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        if (cTCIPTVPlayer != null) {
            arrayList.addAll(cTCIPTVPlayer.p());
            LogEx.i("IPTVPlayer", "lstString is " + arrayList + " RESULT IS " + this.h.o());
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getUTCPosition() {
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        if (cTCIPTVPlayer == null) {
            return 0L;
        }
        long e = cTCIPTVPlayer.e();
        LogEx.d("IPTVPlayer", "IPTVPlayer UTCPosition  is  " + e);
        return e;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getVideoHeight() {
        return super.getVideoHeight();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getVideoInfoArray(ArrayList<String> arrayList) {
        super.getVideoInfoArray(arrayList);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getVideoWidth() {
        return super.getVideoWidth();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public float getVolume() {
        if (this.h != null) {
            return r0.k();
        }
        return 0.0f;
    }

    public String gotoEnd() {
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        return cTCIPTVPlayer != null ? cTCIPTVPlayer.n() : "";
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(int i, int i2, int i3, int i4) {
        LogEx.d("IPTVPlayer", "start init");
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        if (cTCIPTVPlayer != null) {
            cTCIPTVPlayer.a(i, i2, i3, i4);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean isPlaying() {
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        if (cTCIPTVPlayer == null) {
            return false;
        }
        boolean c2 = cTCIPTVPlayer.c();
        LogEx.d("IPTVPlayer", "IPTVPlayer status  is  " + c2);
        return c2;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean isRecording() {
        return super.isRecording();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean isTrackAvailable(AssetType assetType, int i) {
        return super.isTrackAvailable(assetType, i);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void mute() {
        super.mute();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void open(String str) {
        LogEx.d("IPTVPlayer", "IPTVPlayer open.");
        if (TextUtils.isEmpty(str)) {
            LogEx.w("IPTVPlayer", "player url is null");
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(-1);
                return;
            }
            return;
        }
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        if (cTCIPTVPlayer != null) {
            cTCIPTVPlayer.a(str);
            this.h.a(new IPTVBufferingUpdateListener(this));
            this.h.a(new IPTVCompletionListener(this));
            this.h.a(new IPTVErrorListener(this));
            this.h.a(new IPTVInfoListener(this));
            this.h.a(new IPTVPreparedListener(this));
            this.h.a(new IPTVSeekCompleteListener(this));
            this.h.a(new IPTVVideoSizeChangedListener(this));
            this.h.b();
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void pause() {
        LogEx.d("IPTVPlayer", "IPTVPlayer pause().");
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        if (cTCIPTVPlayer != null) {
            int d2 = cTCIPTVPlayer.d();
            LogEx.d("IPTVPlayer", "The player playing status is " + d2);
            if (d2 == 2) {
                com.video.androidsdk.player.common.c.a(c.a.PAUSE_TIME);
                this.h.g();
                com.video.androidsdk.player.common.c.b(c.a.PAUSE_TIME);
            }
        }
    }

    public String queryCaption() {
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        return cTCIPTVPlayer != null ? cTCIPTVPlayer.q() : "";
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean recordStart(String str) {
        return super.recordStart(str);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean recordStop() {
        return super.recordStop();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void release() {
        LogEx.d("IPTVPlayer", "IPTVPlayer release.");
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        if (cTCIPTVPlayer != null) {
            cTCIPTVPlayer.j();
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void resume() {
        LogEx.d("IPTVPlayer", "IPTVPlayer resume().");
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        if (cTCIPTVPlayer != null) {
            int d2 = cTCIPTVPlayer.d();
            LogEx.d("IPTVPlayer", "The player playing status is " + d2);
            if (d2 == 1) {
                com.video.androidsdk.player.common.c.a(c.a.RUN_TIME);
                this.h.m();
                com.video.androidsdk.player.common.c.b(c.a.RUN_TIME);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void resume4bg() {
        LogEx.d("IPTVPlayer", "IPTVPlayer resume4bg().");
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        if (cTCIPTVPlayer != null) {
            int d2 = cTCIPTVPlayer.d();
            LogEx.d("IPTVPlayer", "The player playing status is " + d2);
            if (d2 == 1) {
                com.video.androidsdk.player.common.c.a(c.a.RUN_TIME);
                this.h.m();
                com.video.androidsdk.player.common.c.b(c.a.RUN_TIME);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void seek(long j) {
        LogEx.d("IPTVPlayer", "IPTVPlayer seek to ---  " + j);
        if (this.h != null) {
            com.video.androidsdk.player.common.c.a(c.a.SEEK_TIME);
            this.h.a(j / 1000);
            com.video.androidsdk.player.common.c.b(c.a.SEEK_TIME);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectAudioByIndex(int i) {
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        if (cTCIPTVPlayer != null) {
            return "0".equals(cTCIPTVPlayer.d(i));
        }
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectSubtitleByIndex(int i) {
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        if (cTCIPTVPlayer != null) {
            return "0".equals(cTCIPTVPlayer.e(i));
        }
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectVideoByIndex(int i) {
        return super.selectVideoByIndex(i);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setAudioChannel(int i) {
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        if (cTCIPTVPlayer != null) {
            cTCIPTVPlayer.b(i);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setDecoderType(DecoderType decoderType, DecoderType decoderType2) {
        super.setDecoderType(decoderType, decoderType2);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setInitialBufferingTime(int i) {
        super.setInitialBufferingTime(i);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setMaxBufferingTime(int i) {
        super.setMaxBufferingTime(i);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setOnEventListener(IBasePlayer.OnEventListener onEventListener) {
        this.f3307c = onEventListener;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPlaySpeed(float f) {
        super.setPlaySpeed(f);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPlaybackBufferingTime(int i) {
        super.setPlaybackBufferingTime(i);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPreferredAudioLanguage(String str) {
        super.setPreferredAudioLanguage(str);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPreferredSubtitleLanguage(String str) {
        super.setPreferredSubtitleLanguage(str);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setScreenBrightness(int i) {
        super.setScreenBrightness(i);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setSourceType(String str) {
        super.setSourceType(str);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setSphericalVideoView(float f, float f2, float f3) {
        super.setSphericalVideoView(f, f2, f3);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setSubtitleGravity(SubtitleHorizontal subtitleHorizontal, SubtitleVertical subtitleVertical) {
        super.setSubtitleGravity(subtitleHorizontal, subtitleVertical);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setUseAdaptiveTrack() {
        super.setUseAdaptiveTrack();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setVolume(float f) {
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        if (cTCIPTVPlayer != null) {
            cTCIPTVPlayer.a((int) f);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setZoomMode(ZoomModeType zoomModeType, Rect rect) {
        super.setZoomMode(zoomModeType, rect);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void start() {
        int h;
        IBasePlayer.OnEventListener onEventListener;
        LogEx.d("IPTVPlayer", "IPTVPlayer start.");
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        if (cTCIPTVPlayer == null || (h = cTCIPTVPlayer.h()) == 0 || (onEventListener = this.f3307c) == null) {
            return;
        }
        onEventListener.onError(String.valueOf(h), "IPTVPlayer start failed");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void startWriteLog() {
        super.startWriteLog();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void stop() {
        LogEx.i("IPTVPlayer", "IPTVPlayer stop().");
        if (this.h != null) {
            com.video.androidsdk.player.common.c.a(c.a.STOP_TIME);
            this.h.i();
            com.video.androidsdk.player.common.c.b(c.a.STOP_TIME);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void stopWriteLog() {
        super.stopWriteLog();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void suspend4bg() {
        LogEx.d("IPTVPlayer", "IPTVPlayer suspend4bg().");
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        if (cTCIPTVPlayer != null) {
            int d2 = cTCIPTVPlayer.d();
            LogEx.d("IPTVPlayer", "The player playing status is " + d2);
            if (d2 == 2) {
                com.video.androidsdk.player.common.c.a(c.a.PAUSE_TIME);
                this.h.g();
                com.video.androidsdk.player.common.c.b(c.a.PAUSE_TIME);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean takeSnapShot(int i, String str, int i2, int i3) {
        return super.takeSnapShot(i, str, i2, i3);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void unmute() {
        super.unmute();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void updateVideoSize(int i, int i2) {
        super.updateVideoSize(i, i2);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setAudioChannel(boolean z, boolean z2) {
        if (this.h != null) {
            int i = 0;
            if (true != z || true != z2) {
                if (true == z && !z2) {
                    i = 1;
                } else if (!z && true == z2) {
                    i = 2;
                }
            }
            this.h.b(i);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void seek(long j, long j2) {
        LogEx.d("IPTVPlayer", "IPTVPlayer seek to ---  " + j);
        LogEx.d("IPTVPlayer", "IPTVPlayer currentTime is ---  " + j2);
        if (j2 == 0) {
            j2 = new Date().getTime();
        }
        Date utcTimeInDate = getUtcTimeInDate(new Date(j2));
        if (this.h != null) {
            long time = utcTimeInDate.getTime() + j;
            LogEx.d("IPTVPlayer", "UTCPosition:   " + time);
            com.video.androidsdk.player.common.c.a(c.a.SEEK_TIME);
            this.h.a(time);
            com.video.androidsdk.player.common.c.b(c.a.SEEK_TIME);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void open(String str, String str2, String str3) {
        LogEx.d("IPTVPlayer", "IPTVPlayer open.");
        if (TextUtils.isEmpty(str)) {
            LogEx.w("IPTVPlayer", "player url is null");
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(-1);
                return;
            }
            return;
        }
        CTCIPTVPlayer cTCIPTVPlayer = this.h;
        if (cTCIPTVPlayer != null) {
            cTCIPTVPlayer.a(str, str2, str3);
            this.h.a(new IPTVBufferingUpdateListener(this));
            this.h.a(new IPTVCompletionListener(this));
            this.h.a(new IPTVErrorListener(this));
            this.h.a(new IPTVInfoListener(this));
            this.h.a(new IPTVPreparedListener(this));
            this.h.a(new IPTVSeekCompleteListener(this));
            this.h.a(new IPTVVideoSizeChangedListener(this));
            this.h.b();
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void seek(long j, long j2, long j3) {
        LogEx.d("IPTVPlayer", "IPTVPlayer seek to ---  " + j);
        LogEx.d("IPTVPlayer", "IPTVPlayer currentTime is ---  " + j3);
        if (j3 == 0) {
            j3 = new Date().getTime();
        }
        Date utcTimeInDate = getUtcTimeInDate(new Date(j3));
        if (this.h != null) {
            long time = utcTimeInDate.getTime() + (j - j2);
            LogEx.i("IPTVPlayer", "UTCPosition:   " + time);
            com.video.androidsdk.player.common.c.a(c.a.SEEK_TIME);
            this.h.a(time);
            com.video.androidsdk.player.common.c.b(c.a.SEEK_TIME);
        }
    }
}
