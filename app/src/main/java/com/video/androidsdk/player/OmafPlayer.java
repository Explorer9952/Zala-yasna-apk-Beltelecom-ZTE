package com.video.androidsdk.player;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.facebook.internal.AnalyticsEvents;
import com.player.OmafMediaPlayer;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.IBasePlayer;
import com.video.androidsdk.player.common.AssetStatus;
import com.video.androidsdk.player.common.AssetType;
import com.video.androidsdk.player.common.DecoderType;
import com.video.androidsdk.player.common.SubtitleHorizontal;
import com.video.androidsdk.player.common.SubtitleVertical;
import com.video.androidsdk.player.common.ZoomModeType;
import com.video.androidsdk.player.common.c;
import ijk.media.player.IMediaPlayer;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class OmafPlayer extends a {
    public static String LOG_TAG = "OmafPlayer";
    private OmafMediaPlayer i;
    private SurfaceView j;
    private SurfaceHolder k;
    private RelativeLayout p;
    private int q = 0;
    private boolean r = false;
    private boolean s = true;
    private IMediaPlayer.e t = new IMediaPlayer.e() { // from class: com.video.androidsdk.player.OmafPlayer.1
        @Override // ijk.media.player.IMediaPlayer.e
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            LogEx.d(OmafPlayer.LOG_TAG, "onPrepared called");
            OmafPlayer.this.q = 2;
            OmafPlayer.this.r = false;
            com.video.androidsdk.player.common.c.b(c.a.OPEN_COMPLETE_TIME);
            OmafPlayer.this.f3307c.onStateChanged(2);
        }
    };
    private IMediaPlayer.a u = new IMediaPlayer.a() { // from class: com.video.androidsdk.player.OmafPlayer.2
        @Override // ijk.media.player.IMediaPlayer.a
        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
        }
    };
    private IMediaPlayer.b v = new IMediaPlayer.b() { // from class: com.video.androidsdk.player.OmafPlayer.3
        @Override // ijk.media.player.IMediaPlayer.b
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            OmafPlayer.this.q = 5;
            IBasePlayer.OnEventListener onEventListener = OmafPlayer.this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(5);
            }
        }
    };
    private IMediaPlayer.f w = new IMediaPlayer.f() { // from class: com.video.androidsdk.player.OmafPlayer.4
        @Override // ijk.media.player.IMediaPlayer.f
        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            LogEx.d(OmafPlayer.LOG_TAG, "onSeekComplete called");
            if (4 == OmafPlayer.this.q) {
                return;
            }
            IBasePlayer.OnEventListener onEventListener = OmafPlayer.this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(11);
            }
            OmafPlayer.this.i.start();
            OmafPlayer.this.q = 3;
        }
    };
    private IMediaPlayer.c x = new IMediaPlayer.c() { // from class: com.video.androidsdk.player.OmafPlayer.5
        @Override // ijk.media.player.IMediaPlayer.c
        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            LogEx.w(OmafPlayer.LOG_TAG, "onError called");
            LogEx.w(OmafPlayer.LOG_TAG, "framework_err： " + i + ";  impl_err: " + i2);
            OmafPlayer.this.q = -1;
            String str = i == 200 ? "VideoView_error_text_invalid_progressive_playback" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            IBasePlayer.OnEventListener onEventListener = OmafPlayer.this.f3307c;
            if (onEventListener == null) {
                return false;
            }
            onEventListener.onError(String.valueOf(i), str);
            return true;
        }
    };
    private IMediaPlayer.d y = new IMediaPlayer.d() { // from class: com.video.androidsdk.player.OmafPlayer.6
        @Override // ijk.media.player.IMediaPlayer.d
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            if (i == 3) {
                LogEx.d(OmafPlayer.LOG_TAG, "MEDIA_INFO_VIDEO_RENDERING_START:");
                OmafPlayer.this.h.obtainMessage(4, false).sendToTarget();
                OmafPlayer omafPlayer = OmafPlayer.this;
                if (omafPlayer.f3307c == null) {
                    return true;
                }
                omafPlayer.h.removeMessages(2);
                OmafPlayer.this.h.sendEmptyMessage(2);
                OmafPlayer.this.f3307c.onStateChanged(12);
                return true;
            }
            if (i == 901) {
                LogEx.d(OmafPlayer.LOG_TAG, "MEDIA_INFO_UNSUPPORTED_SUBTITLE:");
                return true;
            }
            if (i == 902) {
                LogEx.d(OmafPlayer.LOG_TAG, "MEDIA_INFO_SUBTITLE_TIMED_OUT:");
                return true;
            }
            if (i == 10001) {
                LogEx.d(OmafPlayer.LOG_TAG, "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i2);
                return true;
            }
            if (i != 10002) {
                switch (i) {
                    case IMediaPlayer.MEDIA_INFO_VIDEO_TRACK_LAGGING /* 700 */:
                        LogEx.d(OmafPlayer.LOG_TAG, "MEDIA_INFO_VIDEO_TRACK_LAGGING:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                        LogEx.d(OmafPlayer.LOG_TAG, "MEDIA_INFO_BUFFERING_START:");
                        IBasePlayer.OnEventListener onEventListener = OmafPlayer.this.f3307c;
                        if (onEventListener == null) {
                            return true;
                        }
                        onEventListener.onStateChanged(7);
                        return true;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                        LogEx.d(OmafPlayer.LOG_TAG, "MEDIA_INFO_BUFFERING_END:");
                        IBasePlayer.OnEventListener onEventListener2 = OmafPlayer.this.f3307c;
                        if (onEventListener2 == null) {
                            return true;
                        }
                        onEventListener2.onStateChanged(9);
                        return true;
                    case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                        LogEx.d(OmafPlayer.LOG_TAG, "MEDIA_INFO_NETWORK_BANDWIDTH: " + i2);
                        return true;
                    default:
                        switch (i) {
                            case 800:
                                LogEx.d(OmafPlayer.LOG_TAG, "MEDIA_INFO_BAD_INTERLEAVING:");
                                return true;
                            case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                                LogEx.d(OmafPlayer.LOG_TAG, "MEDIA_INFO_NOT_SEEKABLE:");
                                return true;
                            case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /* 802 */:
                                LogEx.d(OmafPlayer.LOG_TAG, "MEDIA_INFO_METADATA_UPDATE:");
                                return true;
                            default:
                                return true;
                        }
                }
            }
            LogEx.d(OmafPlayer.LOG_TAG, "MEDIA_INFO_AUDIO_RENDERING_START:");
            IBasePlayer.OnEventListener onEventListener3 = OmafPlayer.this.f3307c;
            if (onEventListener3 == null) {
                return true;
            }
            onEventListener3.onStateChanged(9);
            return true;
        }
    };
    protected Handler h = new Handler() { // from class: com.video.androidsdk.player.OmafPlayer.7
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                OmafPlayer.this.a();
                sendEmptyMessageDelayed(2, 1000L);
            } else {
                LogEx.w(OmafPlayer.LOG_TAG, "unkown msg");
            }
        }
    };

    public OmafPlayer(Context context) {
        this.m = context;
        b();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean closeSensor() {
        return super.closeSensor();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void enableCardBoardVideo(boolean z) {
        super.enableCardBoardVideo(z);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void enableSphericalVideo(boolean z) {
        super.enableSphericalVideo(z);
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
        return super.getAudioChannel();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getAudioInfoArray(ArrayList<String> arrayList) {
        super.getAudioInfoArray(arrayList);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getBufferedPosition() {
        return super.getBufferedPosition();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getCurrentPosition() {
        OmafMediaPlayer omafMediaPlayer = this.i;
        if (omafMediaPlayer == null) {
            return 0L;
        }
        long currentPosition = omafMediaPlayer.getCurrentPosition();
        LogEx.d(LOG_TAG, "Position  is  " + currentPosition);
        return currentPosition;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getDuration() {
        OmafMediaPlayer omafMediaPlayer = this.i;
        if (omafMediaPlayer == null) {
            return -1L;
        }
        long duration = omafMediaPlayer.getDuration();
        LogEx.d(LOG_TAG, "duration  is  " + duration);
        if (duration < 0) {
            return 0L;
        }
        return duration;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public float getPlaySpeed() {
        return super.getPlaySpeed();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getPlayerState() {
        return this.q;
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
    public long getSeekOff() {
        return super.getSeekOff();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public float getSphericalViewSensorRoll() {
        return super.getSphericalViewSensorRoll();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getSubtitleInfoArray(ArrayList<String> arrayList) {
        super.getSubtitleInfoArray(arrayList);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public SurfaceView getSurfaceView() {
        return super.getSurfaceView();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getUTCPosition() {
        return super.getUTCPosition();
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
        return super.getVolume();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(Surface surface) {
        super.init(surface);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean isPlaying() {
        OmafMediaPlayer omafMediaPlayer = this.i;
        if (omafMediaPlayer == null) {
            return false;
        }
        boolean isPlaying = omafMediaPlayer.isPlaying();
        LogEx.d(LOG_TAG, " status  is  " + isPlaying);
        return isPlaying;
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
    public boolean onKeyDown(KeyEvent keyEvent, int i, int i2) {
        OmafMediaPlayer omafMediaPlayer = this.i;
        if (omafMediaPlayer == null) {
            return false;
        }
        omafMediaPlayer.a(keyEvent, i, i2);
        return false;
    }

    @Override // com.video.androidsdk.player.a
    public void openInternal(String str) {
        LogEx.d(LOG_TAG, " url is " + str);
        if (TextUtils.isEmpty(str)) {
            LogEx.w(LOG_TAG, "player url is null");
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(-1);
                this.q = -1;
                return;
            }
            return;
        }
        OmafMediaPlayer omafMediaPlayer = this.i;
        if (omafMediaPlayer != null) {
            try {
                omafMediaPlayer.setDataSource(this.m, Uri.parse(str));
                c();
                this.q = 1;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean openSensor() {
        return super.openSensor();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void pause() {
        OmafMediaPlayer omafMediaPlayer = this.i;
        if (omafMediaPlayer != null) {
            omafMediaPlayer.pause();
            this.q = 4;
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void release() {
        if (this.i != null) {
            this.p.removeAllViews();
            this.i.release();
            this.i = null;
            this.q = 0;
            this.h.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void resume() {
        OmafMediaPlayer omafMediaPlayer = this.i;
        if (omafMediaPlayer != null) {
            omafMediaPlayer.start();
            this.q = 3;
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void resume4bg() {
        OmafMediaPlayer omafMediaPlayer = this.i;
        if (omafMediaPlayer != null) {
            omafMediaPlayer.start();
            this.q = 3;
            this.h.sendEmptyMessage(2);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void seek(long j) {
        OmafMediaPlayer omafMediaPlayer = this.i;
        if (omafMediaPlayer != null) {
            omafMediaPlayer.seekTo(j);
            LogEx.d(LOG_TAG, "Position  is  " + j);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectAudioByIndex(int i) {
        return super.selectAudioByIndex(i);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectSubtitleByIndex(int i) {
        return super.selectSubtitleByIndex(i);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectVideoByIndex(int i) {
        return super.selectVideoByIndex(i);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setAudioChannel(boolean z, boolean z2) {
        super.setAudioChannel(z, z2);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setAutoSpeed(boolean z) {
        super.setAutoSpeed(z);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setDecoderType(DecoderType decoderType, DecoderType decoderType2) {
        super.setDecoderType(decoderType, decoderType2);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setFadingVolumn(float f, long j) {
        super.setFadingVolumn(f, j);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setInitialBufferingTime(int i) {
        super.setInitialBufferingTime(i);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setLooping(boolean z) {
        OmafMediaPlayer omafMediaPlayer = this.i;
        if (omafMediaPlayer != null) {
            omafMediaPlayer.setLooping(z);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setMaxBufferingTime(int i) {
        super.setMaxBufferingTime(i);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setOnEventListener(IBasePlayer.OnEventListener onEventListener) {
        super.setOnEventListener(onEventListener);
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
    public void setPreferredBitrate(long j) {
        super.setPreferredBitrate(j);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPreferredSubtitleLanguage(String str) {
        super.setPreferredSubtitleLanguage(str);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setRenderTypeOpenGL() {
        super.setRenderTypeOpenGL();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setScale(float f) {
        OmafMediaPlayer omafMediaPlayer = this.i;
        if (omafMediaPlayer != null) {
            omafMediaPlayer.a(f);
        }
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
        super.setVolume(f);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setZoomMode(ZoomModeType zoomModeType, Rect rect) {
        super.setZoomMode(zoomModeType, rect);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void start() {
        if (this.i != null) {
            LogEx.d(LOG_TAG, "momafMediaPlayer.start");
            this.i.start();
            this.q = 3;
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void stop() {
        OmafMediaPlayer omafMediaPlayer = this.i;
        if (omafMediaPlayer != null) {
            omafMediaPlayer.stop();
            this.q = 6;
            this.h.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void stopSphericalView() {
        super.stopSphericalView();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void suspend4bg() {
        OmafMediaPlayer omafMediaPlayer = this.i;
        if (omafMediaPlayer != null) {
            omafMediaPlayer.pause();
            this.q = 4;
            this.h.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void unmute() {
        super.unmute();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void updateVideoSize(int i, int i2) {
        super.updateVideoSize(i, i2);
    }

    private void b() {
        OmafMediaPlayer omafMediaPlayer = new OmafMediaPlayer(this.m);
        this.i = omafMediaPlayer;
        omafMediaPlayer.setOnPreparedListener(this.t);
        this.i.setOnBufferingUpdateListener(this.u);
        this.i.setOnCompletionListener(this.v);
        this.i.setOnSeekCompleteListener(this.w);
        this.i.setOnErrorListener(this.x);
        this.i.setOnInfoListener(this.y);
        Display defaultDisplay = ((Activity) this.m).getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        this.i.a(point);
    }

    private void c() {
        LogEx.d(LOG_TAG, "init surfaceview");
        this.j = new SurfaceView(this.m);
        this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.p.addView(this.j);
        SurfaceHolder holder = this.j.getHolder();
        this.k = holder;
        this.i.setDisplay(holder);
        if (!com.video.androidsdk.license.a.i || new com.video.androidsdk.player.view.a().a(this.m, this.p)) {
            return;
        }
        this.s = false;
        LogEx.w(LOG_TAG, "cannot find watermark picture");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(RelativeLayout relativeLayout) {
        LogEx.d(LOG_TAG, "start init");
        if (relativeLayout == null) {
            LogEx.d(LOG_TAG, "layout is null, return");
            return;
        }
        relativeLayout.removeAllViews();
        this.p = relativeLayout;
        LogEx.d(LOG_TAG, " init end");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setAudioChannel(int i) {
        super.setAudioChannel(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        OmafMediaPlayer omafMediaPlayer;
        if (this.r || (omafMediaPlayer = this.i) == null) {
            return;
        }
        long currentPosition = omafMediaPlayer.getCurrentPosition();
        LogEx.d(LOG_TAG, "currentPositon is " + currentPosition);
        LogEx.d(LOG_TAG, "Duration is " + this.i.getDuration());
        IBasePlayer.OnEventListener onEventListener = this.f3307c;
        if (onEventListener != null) {
            onEventListener.onTime(currentPosition);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void seek(long j, long j2) {
        super.seek(j, j2);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void seek(long j, long j2, long j3) {
        super.seek(j, j2, j3);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(RelativeLayout relativeLayout, int i, boolean z) {
        LogEx.d(LOG_TAG, "start init");
        if (relativeLayout == null) {
            LogEx.d(LOG_TAG, "layout is null, return");
        } else {
            relativeLayout.removeAllViews();
            LogEx.d(LOG_TAG, " init end");
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(SurfaceView surfaceView) {
        SurfaceHolder holder = surfaceView.getHolder();
        this.k = holder;
        OmafMediaPlayer omafMediaPlayer = this.i;
        if (omafMediaPlayer != null) {
            omafMediaPlayer.setDisplay(holder);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.video.androidsdk.player.a
    public void openInternal(String str, int i) {
        super.openInternal(str, i);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(TextureView textureView) {
        super.init(textureView);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(int i, int i2, int i3, int i4) {
        super.init(i, i2, i3, i4);
    }
}
