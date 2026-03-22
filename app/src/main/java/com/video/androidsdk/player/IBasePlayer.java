package com.video.androidsdk.player;

import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.widget.RelativeLayout;
import com.google.android.exoplayer2.text.Cue;
import com.video.androidsdk.player.common.AssetStatus;
import com.video.androidsdk.player.common.AssetType;
import com.video.androidsdk.player.common.DecoderType;
import com.video.androidsdk.player.common.SubtitleHorizontal;
import com.video.androidsdk.player.common.SubtitleVertical;
import com.video.androidsdk.player.common.ZoomModeType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public interface IBasePlayer {
    public static final int MODE_DOWNLOAD = 2;
    public static final int MODE_PLAYBACK = 0;
    public static final int MODE_QUERY = 1;
    public static final int MODE_RELEASE = 3;
    public static final int MSG_FAST_BACKWARD = 21;
    public static final int MSG_FAST_FORWARD = 20;
    public static final int MSG_KEEP_SCREENON_FALSE = 6;
    public static final int MSG_KEEP_SCREENON_TRUE = 5;
    public static final int MSG_OPEN = 1;
    public static final int MSG_OPERATE_SHUTTER_VIEW = 4;
    public static final int MSG_PREPARE_SOURCE = 7;
    public static final int MSG_RESUME = 3;
    public static final int MSG_UPDATE_UI = 2;
    public static final int STATE_AUDIO_CHANGED = 23;
    public static final int STATE_BUFFERING_END = 9;
    public static final int STATE_BUFFERING_START = 7;
    public static final int STATE_BUFFERING_UPDATE = 8;
    public static final int STATE_ENTERTSPROTECTWindow = 13;
    public static final int STATE_ERROR = -1;
    public static final int STATE_FAST_FORWARD = 16;
    public static final int STATE_FAST_REWIND = 17;
    public static final int STATE_IDLE = 0;
    public static final int STATE_OPENED = 2;
    public static final int STATE_OPENING = 1;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_PLAY = 20;
    public static final int STATE_PLAYBACK_COMPLETED = 5;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_RENDER_START = 12;
    public static final int STATE_REWIND_TO_START = 21;
    public static final int STATE_SEEKING = 10;
    public static final int STATE_SEEK_COMPLETED = 11;
    public static final int STATE_STOPED = 6;
    public static final int STATE_TEXTURE_DESTROYED = 14;
    public static final int STATE_TEXTURE_UPDATED = 15;
    public static final int STATE_VIDEO_CHANGED = 22;
    public static final int STATE_VOD_ENTER_TIMESHIFT = 18;
    public static final int STATE_VOD_EXIT_TIMESHIFT = 19;
    public static final int SURFACE_TYPE_OPEN_GL = 3;
    public static final int SURFACE_TYPE_SURFACE_VIEW = 1;
    public static final int SURFACE_TYPE_TEXTURE_VIEW = 2;

    /* loaded from: classes.dex */
    public interface OnEventListener {
        void onBufferingUpdate(int i);

        void onError(String str, String str2);

        void onStateChanged(int i);

        void onTime(long j);
    }

    /* loaded from: classes.dex */
    public interface OnMsgReportListener {
        void onMsgReport(int i, String str);
    }

    /* loaded from: classes.dex */
    public interface OnTextRenderListener {
        void onCues(List<Cue> list);
    }

    /* loaded from: classes.dex */
    public interface OnUploadReturnListener {
        void OnUpLoadLogReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnVideoListener {
        void onVideoSizeChanged(int i, int i2, int i3, float f);
    }

    boolean closeSensor();

    void enableCardBoardVideo(boolean z);

    void enableSphericalVideo(boolean z);

    void enableSubtitle(boolean z);

    int getAssetCount(AssetType assetType);

    int getAssetIndex(AssetType assetType, AssetStatus assetStatus);

    int getAudioChannel();

    void getAudioInfoArray(ArrayList<String> arrayList);

    long getAvailabilityStartTime();

    long getBitrateEstimate();

    long getBufferedPosition();

    long getCurrentPosition();

    long getCurrentTimeMs();

    String getDRMUniqueIdentifier();

    long getDuration();

    long getLeftTimeMs();

    float getPlaySpeed();

    int getPlayerState();

    String getProbeKP();

    long getRightTimeMs();

    int getScreenBrightness();

    long getSeekOff();

    float getSphericalViewSensorRoll();

    void getSubtitleInfoArray(ArrayList<String> arrayList);

    SurfaceView getSurfaceView();

    long getUTCPosition();

    long getVideoFrameRate();

    int getVideoHeight();

    void getVideoInfoArray(ArrayList<String> arrayList);

    int getVideoWidth();

    float getVolume();

    void init(int i, int i2, int i3, int i4);

    void init(Surface surface);

    void init(SurfaceView surfaceView);

    void init(TextureView textureView);

    void init(RelativeLayout relativeLayout);

    void init(RelativeLayout relativeLayout, int i, boolean z);

    boolean isPlaying();

    boolean isRecording();

    boolean isTrackAvailable(AssetType assetType, int i);

    void mute();

    boolean onKeyDown(KeyEvent keyEvent, int i, int i2);

    void open(String str);

    void open(String str, int i);

    void open(String str, String str2, String str3);

    void open(String str, boolean z);

    void open(String str, boolean z, boolean z2);

    boolean openSensor();

    void pause();

    boolean recordStart(String str);

    boolean recordStop();

    void release();

    void resume();

    void resume4bg();

    void seek(long j);

    void seek(long j, long j2);

    void seek(long j, long j2, long j3);

    boolean selectAudioByIndex(int i);

    boolean selectSubtitleByIndex(int i);

    boolean selectVideoByIndex(int i);

    void setAudioChannel(int i);

    void setAudioChannel(boolean z, boolean z2);

    void setAutoSpeed(boolean z);

    void setDRMInfo(String str, String str2);

    void setDecoderType(DecoderType decoderType, DecoderType decoderType2);

    void setFadingVolumn(float f, long j);

    void setInitialBufferingTime(int i);

    void setIsNormalSeek(boolean z);

    void setLooping(boolean z);

    void setMaxAllBufferSize(long j);

    void setMaxBufferSize(long j);

    void setMaxBufferingTime(int i);

    void setMaxSupportTime(long j);

    void setOnEventListener(OnEventListener onEventListener);

    void setOnMsgReportListener(OnMsgReportListener onMsgReportListener);

    void setOnTextRenderListener(OnTextRenderListener onTextRenderListener);

    void setOnVideoListener(OnVideoListener onVideoListener);

    void setPlaySpeed(float f);

    void setPlaybackBufferingTime(int i);

    void setPlayerHeader(String str);

    void setPreferredAudioLanguage(String str);

    void setPreferredBitrate(long j);

    void setPreferredSubtitleLanguage(String str);

    void setRenderTypeOpenGL();

    void setScale(float f);

    void setScreenBrightness(int i);

    void setSourceType(String str);

    void setSphericalVideoView(float f, float f2, float f3);

    void setSubtitleGravity(SubtitleHorizontal subtitleHorizontal, SubtitleVertical subtitleVertical);

    void setUseAdaptiveTrack();

    void setUserLanguage(String str);

    void setVolume(float f);

    void setZoomMode(ZoomModeType zoomModeType, Rect rect);

    void start();

    void startWriteLog();

    void stop();

    void stopSphericalView();

    void stopWriteLog();

    void suspend4bg();

    boolean takeSnapShot(int i, String str, int i2, int i3);

    boolean unifySeekIsLive();

    void unmute();

    void updateVideoSize(int i, int i2);
}
