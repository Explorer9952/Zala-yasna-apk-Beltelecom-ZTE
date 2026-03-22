package com.video.androidsdk.player;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.exoplayer2.util.MimeTypes;
import com.render.vrlib.MDVRLibrary;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.IBasePlayer;
import com.video.androidsdk.player.common.AssetStatus;
import com.video.androidsdk.player.common.AssetType;
import com.video.androidsdk.player.common.DecoderType;
import com.video.androidsdk.player.common.SubtitleHorizontal;
import com.video.androidsdk.player.common.SubtitleVertical;
import com.video.androidsdk.player.common.c;
import com.video.androidsdk.player.render.IRender;
import com.video.androidsdk.player.render.RenderImpl;
import ijk.media.player.IMediaPlayer;
import ijk.media.player.IjkMediaPlayer;
import ijk.media.player.misc.IMediaFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes.dex */
public class VrPlayer extends a {
    private float A;
    private View p;
    private AudioManager w;
    private Surface x;
    private RelativeLayout y;
    private IjkMediaPlayer j = null;
    private String k = null;
    private boolean q = false;
    protected boolean h = false;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private int v = 0;
    private boolean z = false;
    private long B = 0;
    private SparseArray<Integer> C = new SparseArray<>();
    private SparseArray<Integer> D = new SparseArray<>();
    private SparseArray<Integer> E = new SparseArray<>();
    private int F = 1;
    private IMediaPlayer.e G = new IMediaPlayer.e() { // from class: com.video.androidsdk.player.VrPlayer.1
        @Override // ijk.media.player.IMediaPlayer.e
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            LogEx.d("VrPlayer", "onPrepared called");
            if (-1 == VrPlayer.this.v || VrPlayer.this.v == 0 || 3 == VrPlayer.this.v) {
                return;
            }
            VrPlayer.this.v = 2;
            VrPlayer.this.u = false;
            com.video.androidsdk.player.common.c.b(c.a.OPEN_COMPLETE_TIME);
            VrPlayer.this.notifyPlayerChanged();
            VrPlayer.this.f3307c.onStateChanged(2);
        }
    };
    private IMediaPlayer.b H = new IMediaPlayer.b() { // from class: com.video.androidsdk.player.VrPlayer.2
        @Override // ijk.media.player.IMediaPlayer.b
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            LogEx.d("VrPlayer", "onCompletion called");
            VrPlayer.this.v = 5;
            IBasePlayer.OnEventListener onEventListener = VrPlayer.this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(5);
            }
        }
    };
    private IMediaPlayer.f I = new IMediaPlayer.f() { // from class: com.video.androidsdk.player.VrPlayer.3
        @Override // ijk.media.player.IMediaPlayer.f
        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            LogEx.d("VrPlayer", "onSeekComplete called");
            if (4 == VrPlayer.this.v) {
                return;
            }
            IBasePlayer.OnEventListener onEventListener = VrPlayer.this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(11);
            }
            VrPlayer.this.j.start();
            if (((RenderImpl) VrPlayer.this).l != null) {
                ((RenderImpl) VrPlayer.this).l.c(((RenderImpl) VrPlayer.this).m);
            }
            VrPlayer.this.v = 3;
        }
    };
    private IMediaPlayer.a J = new IMediaPlayer.a() { // from class: com.video.androidsdk.player.VrPlayer.4
        @Override // ijk.media.player.IMediaPlayer.a
        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
        }
    };
    private IMediaPlayer.d K = new IMediaPlayer.d() { // from class: com.video.androidsdk.player.VrPlayer.5
        @Override // ijk.media.player.IMediaPlayer.d
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            if (i == 3) {
                LogEx.d("VrPlayer", "MEDIA_INFO_VIDEO_RENDERING_START:");
                VrPlayer.this.i.obtainMessage(4, false).sendToTarget();
                IBasePlayer.OnEventListener onEventListener = VrPlayer.this.f3307c;
                if (onEventListener != null) {
                    onEventListener.onStateChanged(12);
                }
                VrPlayer.this.i.removeMessages(2);
                VrPlayer.this.i.sendEmptyMessage(2);
                return true;
            }
            if (i == 901) {
                LogEx.d("VrPlayer", "MEDIA_INFO_UNSUPPORTED_SUBTITLE:");
                return true;
            }
            if (i == 902) {
                LogEx.d("VrPlayer", "MEDIA_INFO_SUBTITLE_TIMED_OUT:");
                return true;
            }
            if (i == 10001) {
                LogEx.d("VrPlayer", "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i2);
                return true;
            }
            if (i != 10002) {
                switch (i) {
                    case IMediaPlayer.MEDIA_INFO_VIDEO_TRACK_LAGGING /* 700 */:
                        LogEx.d("VrPlayer", "MEDIA_INFO_VIDEO_TRACK_LAGGING:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                        LogEx.d("VrPlayer", "MEDIA_INFO_BUFFERING_START:");
                        IBasePlayer.OnEventListener onEventListener2 = VrPlayer.this.f3307c;
                        if (onEventListener2 == null) {
                            return true;
                        }
                        onEventListener2.onStateChanged(7);
                        return true;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                        LogEx.d("VrPlayer", "MEDIA_INFO_BUFFERING_END:");
                        IBasePlayer.OnEventListener onEventListener3 = VrPlayer.this.f3307c;
                        if (onEventListener3 == null) {
                            return true;
                        }
                        onEventListener3.onStateChanged(9);
                        return true;
                    case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                        LogEx.d("VrPlayer", "MEDIA_INFO_NETWORK_BANDWIDTH: " + i2);
                        return true;
                    default:
                        switch (i) {
                            case 800:
                                LogEx.d("VrPlayer", "MEDIA_INFO_BAD_INTERLEAVING:");
                                return true;
                            case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                                LogEx.d("VrPlayer", "MEDIA_INFO_NOT_SEEKABLE:");
                                return true;
                            case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /* 802 */:
                                LogEx.d("VrPlayer", "MEDIA_INFO_METADATA_UPDATE:");
                                return true;
                            default:
                                return true;
                        }
                }
            }
            LogEx.d("VrPlayer", "MEDIA_INFO_AUDIO_RENDERING_START:");
            IBasePlayer.OnEventListener onEventListener4 = VrPlayer.this.f3307c;
            if (onEventListener4 == null) {
                return true;
            }
            onEventListener4.onStateChanged(9);
            return true;
        }
    };
    private IMediaPlayer.c L = new IMediaPlayer.c() { // from class: com.video.androidsdk.player.VrPlayer.6
        @Override // ijk.media.player.IMediaPlayer.c
        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            LogEx.w("VrPlayer", "onError called");
            LogEx.w("VrPlayer", "framework_err： " + i + ";  impl_err: " + i2);
            VrPlayer.this.v = -1;
            String str = i == 200 ? "VideoView_error_text_invalid_progressive_playback" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            IBasePlayer.OnEventListener onEventListener = VrPlayer.this.f3307c;
            if (onEventListener == null) {
                return false;
            }
            onEventListener.onError(String.valueOf(i), str);
            return true;
        }
    };
    private IMediaPlayer.i M = new IMediaPlayer.i() { // from class: com.video.androidsdk.player.VrPlayer.7
        @Override // ijk.media.player.IMediaPlayer.i
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            VrPlayer.this.onTextureResize(i, i2);
        }
    };
    protected Handler i = new Handler() { // from class: com.video.androidsdk.player.VrPlayer.8
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 2) {
                VrPlayer.this.c();
                sendEmptyMessageDelayed(2, 1000L);
                return;
            }
            if (i != 3) {
                if (i != 4) {
                    LogEx.w("VrPlayer", "unkown msg");
                    return;
                }
                Object obj = message.obj;
                if (obj == null) {
                    obj = false;
                }
                boolean booleanValue = ((Boolean) obj).booleanValue();
                LogEx.d("VrPlayer", "isShow is " + booleanValue);
                VrPlayer.this.a(booleanValue);
                return;
            }
            if (VrPlayer.this.q) {
                LogEx.d("VrPlayer", "MSG_RESUME 1");
                if (VrPlayer.this.j != null && VrPlayer.this.h) {
                    LogEx.d("VrPlayer", "MSG_RESUME 2");
                    LogEx.d("VrPlayer", "mIjkMediaPlayer.start()");
                    VrPlayer.this.j.start();
                    VrPlayer.this.v = 3;
                    LogEx.d("VrPlayer", "send msg to updateUI ");
                    removeMessages(2);
                    sendEmptyMessage(2);
                }
                VrPlayer.this.r = false;
                return;
            }
            LogEx.d("VrPlayer", "MSG_RESUME 3");
            sendEmptyMessageDelayed(3, 200L);
        }
    };

    public VrPlayer(Context context) {
        this.m = context;
        a();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean closeSensor() {
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void enableCardBoardVideo(boolean z) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary == null) {
            LogEx.d("VrPlayer", "mMDVRLibrary is null ");
        } else if (z) {
            mDVRLibrary.a(this.m, 102);
        } else {
            mDVRLibrary.a(this.m, 101);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void enableSphericalVideo(boolean z) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void enableSubtitle(boolean z) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getAssetCount(AssetType assetType) {
        int i = 0;
        if (this.j != null) {
            if (assetType == AssetType.Asset_Video) {
                if (this.C.size() == 0) {
                    ijk.media.player.misc.k[] trackInfo = this.j.getTrackInfo();
                    int i2 = 0;
                    while (i < trackInfo.length) {
                        ijk.media.player.misc.k kVar = trackInfo[i];
                        if (kVar.getTrackType() == 1 && kVar.getFormat() != null) {
                            this.C.put(i2, Integer.valueOf(i));
                            i2++;
                        }
                        i++;
                    }
                }
                return this.C.size();
            }
            if (assetType == AssetType.Asset_Audio) {
                if (this.D.size() == 0) {
                    ijk.media.player.misc.k[] trackInfo2 = this.j.getTrackInfo();
                    int i3 = 0;
                    while (i < trackInfo2.length) {
                        if (trackInfo2[i].getTrackType() == 2) {
                            this.D.put(i3, Integer.valueOf(i));
                            i3++;
                        }
                        i++;
                    }
                }
                return this.D.size();
            }
            if (assetType == AssetType.Asset_Subtitle) {
                if (this.E.size() == 0) {
                    ijk.media.player.misc.k[] trackInfo3 = this.j.getTrackInfo();
                    int i4 = 0;
                    while (i < trackInfo3.length) {
                        if (trackInfo3[i].getTrackType() == 4) {
                            this.E.put(i4, Integer.valueOf(i));
                            i4++;
                        }
                        i++;
                    }
                }
                return this.E.size();
            }
        }
        return 0;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getAssetIndex(AssetType assetType, AssetStatus assetStatus) {
        int i = -1;
        if (this.j != null) {
            int i2 = 0;
            if (assetType == AssetType.Asset_Video) {
                if (this.C.size() == 0) {
                    ijk.media.player.misc.k[] trackInfo = this.j.getTrackInfo();
                    int i3 = 0;
                    while (i2 < trackInfo.length) {
                        ijk.media.player.misc.k kVar = trackInfo[i2];
                        if (kVar.getTrackType() == 1 && kVar.getFormat() != null) {
                            this.C.put(i3, Integer.valueOf(i2));
                            i3++;
                        }
                        i2++;
                    }
                }
                int selectedTrack = this.j.getSelectedTrack(1);
                LogEx.d("VrPlayer", "track type is video ,track index in stream is  " + selectedTrack);
                if (selectedTrack >= 0 && this.C.indexOfValue(Integer.valueOf(selectedTrack)) != -1) {
                    i = this.C.indexOfValue(Integer.valueOf(selectedTrack));
                }
            } else if (assetType == AssetType.Asset_Audio) {
                if (this.D.size() == 0) {
                    ijk.media.player.misc.k[] trackInfo2 = this.j.getTrackInfo();
                    int i4 = 0;
                    while (i2 < trackInfo2.length) {
                        if (trackInfo2[i2].getTrackType() == 2) {
                            this.D.put(i4, Integer.valueOf(i2));
                            i4++;
                        }
                        i2++;
                    }
                }
                int selectedTrack2 = this.j.getSelectedTrack(2);
                LogEx.d("VrPlayer", "track type is audio ,track index in stream is  " + selectedTrack2);
                if (selectedTrack2 >= 0 && this.D.indexOfValue(Integer.valueOf(selectedTrack2)) != -1) {
                    i = this.D.indexOfValue(Integer.valueOf(selectedTrack2));
                }
            } else if (assetType == AssetType.Asset_Subtitle) {
                LogEx.d("VrPlayer", "track type is subitle");
                if (this.E.size() == 0) {
                    ijk.media.player.misc.k[] trackInfo3 = this.j.getTrackInfo();
                    int i5 = 0;
                    while (i2 < trackInfo3.length) {
                        if (trackInfo3[i2].getTrackType() == 4) {
                            this.E.put(i5, Integer.valueOf(i2));
                            i5++;
                        }
                        i2++;
                    }
                }
                int selectedTrack3 = this.j.getSelectedTrack(4);
                if (selectedTrack3 >= 0 && this.E.indexOfValue(Integer.valueOf(selectedTrack3)) != -1) {
                    i = this.E.indexOfValue(Integer.valueOf(selectedTrack3));
                }
            }
        }
        LogEx.d("VrPlayer", "selected index is " + i);
        return i;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getAudioInfoArray(ArrayList<String> arrayList) {
        ijk.media.player.misc.k[] trackInfo;
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer == null || (trackInfo = ijkMediaPlayer.getTrackInfo()) == null) {
            return;
        }
        if (this.D == null) {
            this.D = new SparseArray<>();
        }
        this.D.clear();
        int i = 0;
        for (int i2 = 0; i2 < trackInfo.length; i2++) {
            ijk.media.player.misc.k kVar = trackInfo[i2];
            if (kVar.getTrackType() == 2) {
                String language = kVar.getLanguage();
                LogEx.d("VrPlayer", "trackInfo is " + kVar);
                arrayList.add(language + "," + i2);
                this.D.put(i, Integer.valueOf(i2));
                i++;
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getBufferedPosition() {
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer == null) {
            return 0L;
        }
        long videoCachedDuration = ijkMediaPlayer.getVideoCachedDuration();
        LogEx.d("VrPlayer", "IjkPlayer Position  is  " + videoCachedDuration);
        return videoCachedDuration;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getCurrentPosition() {
        if (this.j == null || !b()) {
            return 0L;
        }
        long currentPosition = this.j.getCurrentPosition();
        LogEx.d("VrPlayer", "Position  is  " + currentPosition);
        return currentPosition;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getDuration() {
        if (this.j == null || !b()) {
            return -1L;
        }
        long duration = this.j.getDuration();
        LogEx.d("VrPlayer", "duration  is  " + duration);
        if (duration < 0) {
            return 0L;
        }
        return duration;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public float getPlaySpeed() {
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.getSpeed();
        }
        return 0.0f;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getPlayerState() {
        return this.v;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getSeekOff() {
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.getSeekOff();
        }
        return 0L;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public float getSphericalViewSensorRoll() {
        return 0.0f;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getSubtitleInfoArray(ArrayList<String> arrayList) {
        ijk.media.player.misc.k[] trackInfo;
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer == null || (trackInfo = ijkMediaPlayer.getTrackInfo()) == null) {
            return;
        }
        if (this.E == null) {
            this.E = new SparseArray<>();
        }
        this.E.clear();
        int i = 0;
        for (int i2 = 0; i2 < trackInfo.length; i2++) {
            ijk.media.player.misc.k kVar = trackInfo[i2];
            if (kVar.getTrackType() == 4) {
                String language = kVar.getLanguage();
                LogEx.d("VrPlayer", "subtitile is " + language);
                arrayList.add(language + "," + i2);
                this.E.put(i, Integer.valueOf(i2));
                i++;
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public SurfaceView getSurfaceView() {
        return null;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getUTCPosition() {
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer == null) {
            return 0L;
        }
        long currentPosition = ijkMediaPlayer.getCurrentPosition();
        LogEx.d("VrPlayer", "IjkPlayer Position  is  " + currentPosition);
        long j = this.B + currentPosition;
        LogEx.d("VrPlayer", "IjkPlayer iUTCPosition  is  " + j);
        return j;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getVideoHeight() {
        if (this.j == null || !b()) {
            return 0;
        }
        int videoHeight = this.j.getVideoHeight();
        LogEx.d("VrPlayer", "VideoHeight  is  " + videoHeight);
        if (videoHeight < 0) {
            return 0;
        }
        return videoHeight;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getVideoInfoArray(ArrayList<String> arrayList) {
        ijk.media.player.misc.k[] trackInfo;
        IMediaFormat format;
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer == null || (trackInfo = ijkMediaPlayer.getTrackInfo()) == null) {
            return;
        }
        if (this.C == null) {
            this.C = new SparseArray<>();
        }
        this.C.clear();
        int i = 0;
        for (int i2 = 0; i2 < trackInfo.length; i2++) {
            ijk.media.player.misc.k kVar = trackInfo[i2];
            if (kVar.getTrackType() == 1 && (format = kVar.getFormat()) != null) {
                LogEx.d("VrPlayer", "format is " + format.getInteger("bitrate"));
                arrayList.add(String.format(Locale.US, "%.2fMbit", Float.valueOf(((float) format.getInteger("bitrate")) / 1000000.0f)) + "," + i2);
                this.C.put(i, Integer.valueOf(i2));
                i++;
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getVideoWidth() {
        if (this.j == null || !b()) {
            return 0;
        }
        int videoWidth = this.j.getVideoWidth();
        LogEx.d("VrPlayer", "IjkPlayer VideoWidth  is  " + videoWidth);
        if (videoWidth < 0) {
            return 0;
        }
        return videoWidth;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public float getVolume() {
        if (this.j == null) {
            return 0.0f;
        }
        LogEx.d("VrPlayer", "getVolume");
        float volume = this.j.getVolume();
        LogEx.d("VrPlayer", "Volume is " + volume);
        return volume;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(Surface surface) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(SurfaceView surfaceView) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(TextureView textureView) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(RelativeLayout relativeLayout) {
        LogEx.d("VrPlayer", "start init");
        if (relativeLayout == null) {
            LogEx.d("VrPlayer", "layout is null, return");
            return;
        }
        this.y = relativeLayout;
        relativeLayout.removeAllViews();
        this.w = (AudioManager) this.m.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        a(this.y);
        LogEx.d("VrPlayer", " init end");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean isPlaying() {
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer == null) {
            return false;
        }
        boolean isPlaying = ijkMediaPlayer.isPlaying();
        LogEx.d("VrPlayer", " status  is  " + isPlaying);
        return isPlaying;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean isTrackAvailable(AssetType assetType, int i) {
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void mute() {
        if (this.j != null) {
            LogEx.d("VrPlayer", "mVolume is " + this.A);
            this.A = this.j.getVolume();
            this.j.setVolume(0.0f, 0.0f);
        }
    }

    @Override // com.video.androidsdk.player.a
    public void openInternal(String str) {
        LogEx.d("VrPlayer", " url is " + str);
        this.k = str;
        if (TextUtils.isEmpty(str)) {
            LogEx.w("VrPlayer", "player url is null");
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(-1);
                return;
            }
            return;
        }
        if (this.j != null) {
            e();
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean openSensor() {
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void pause() {
        IjkMediaPlayer ijkMediaPlayer;
        LogEx.d("VrPlayer", " pause().");
        if (b() && (ijkMediaPlayer = this.j) != null && ijkMediaPlayer.isPlaying()) {
            LogEx.d("VrPlayer", "The player status is " + this.j.isPlaying());
            com.video.androidsdk.player.common.c.a(c.a.PAUSE_TIME);
            this.j.pause();
            MDVRLibrary mDVRLibrary = this.l;
            if (mDVRLibrary != null) {
                mDVRLibrary.b(this.m);
            }
            com.video.androidsdk.player.common.c.b(c.a.PAUSE_TIME);
            this.v = 4;
            return;
        }
        LogEx.e("VrPlayer", "player status is error");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void release() {
        LogEx.d("VrPlayer", "IjkPlayer release(). " + this);
        RelativeLayout relativeLayout = this.y;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.release();
            onRenderDestory();
            this.j.setSurface(null);
            this.j = null;
            this.v = 0;
            this.t = true;
            this.i.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void resume() {
        LogEx.d("VrPlayer", "resume().");
        if (this.j != null && 4 == this.v) {
            LogEx.d("VrPlayer", "STATE_PAUSED == miPlayerStatus");
            com.video.androidsdk.player.common.c.a(c.a.RUN_TIME);
            this.j.start();
            MDVRLibrary mDVRLibrary = this.l;
            if (mDVRLibrary != null) {
                mDVRLibrary.c(this.m);
            }
            com.video.androidsdk.player.common.c.b(c.a.RUN_TIME);
            this.v = 3;
            return;
        }
        LogEx.e("VrPlayer", "player status is error");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void resume4bg() {
        MDVRLibrary mDVRLibrary;
        if (this.j != null) {
            if (!this.n && (mDVRLibrary = this.l) != null) {
                mDVRLibrary.c(this.m);
            }
            if (this.s) {
                this.i.sendEmptyMessage(3);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void seek(long j) {
        if (this.j == null || !b()) {
            return;
        }
        LogEx.d("VrPlayer", " seek to ---  " + j);
        com.video.androidsdk.player.common.c.a(c.a.SEEK_TIME);
        this.j.seekTo((long) ((int) j));
        com.video.androidsdk.player.common.c.b(c.a.SEEK_TIME);
        IBasePlayer.OnEventListener onEventListener = this.f3307c;
        if (onEventListener != null) {
            onEventListener.onStateChanged(10);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectAudioByIndex(int i) {
        if (this.j != null) {
            if (this.D.size() == 0) {
                ijk.media.player.misc.k[] trackInfo = this.j.getTrackInfo();
                int i2 = 0;
                for (int i3 = 0; i3 < trackInfo.length; i3++) {
                    ijk.media.player.misc.k kVar = trackInfo[i3];
                    if (kVar.getTrackType() == 2) {
                        kVar.getLanguage();
                        this.D.put(i2, Integer.valueOf(i3));
                        i2++;
                    }
                }
            }
            if (this.D.size() > i) {
                LogEx.d("VrPlayer", "the mapped index is " + this.D.get(i));
                this.j.selectTrack(this.D.get(i).intValue());
                return true;
            }
            LogEx.e("VrPlayer", "invalid selected index " + i);
        }
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectSubtitleByIndex(int i) {
        if (this.j != null) {
            if (this.E.size() == 0) {
                ijk.media.player.misc.k[] trackInfo = this.j.getTrackInfo();
                int i2 = 0;
                for (int i3 = 0; i3 < trackInfo.length; i3++) {
                    if (trackInfo[i3].getTrackType() == 4) {
                        this.E.put(i2, Integer.valueOf(i3));
                        i2++;
                    }
                }
            }
            if (this.E.size() > i) {
                LogEx.d("VrPlayer", "the mapped index is " + this.E.get(i));
                this.j.selectTrack(this.E.get(i).intValue());
                return true;
            }
            LogEx.e("VrPlayer", "invalid selected index " + i);
        }
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectVideoByIndex(int i) {
        if (this.j != null) {
            if (this.C.size() == 0) {
                ijk.media.player.misc.k[] trackInfo = this.j.getTrackInfo();
                int i2 = 0;
                for (int i3 = 0; i3 < trackInfo.length; i3++) {
                    ijk.media.player.misc.k kVar = trackInfo[i3];
                    if (kVar.getTrackType() == 1 && kVar.getFormat() != null) {
                        this.C.put(i2, Integer.valueOf(i3));
                        i2++;
                    }
                }
            }
            if (this.C.size() > i) {
                LogEx.d("VrPlayer", "the mapped index is " + this.C.get(i));
                this.j.selectTrack(this.C.get(i).intValue());
                return true;
            }
            LogEx.e("VrPlayer", "invalid selected index " + i);
        }
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setAudioChannel(boolean z, boolean z2) {
        if (this.j != null) {
            float volume = getVolume();
            IjkMediaPlayer ijkMediaPlayer = this.j;
            float f = z ? volume : 0.0f;
            if (!z2) {
                volume = 0.0f;
            }
            ijkMediaPlayer.setVolume(f, volume);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setAutoSpeed(boolean z) {
        if (this.j != null) {
            LogEx.d("VrPlayer", "setAutoSpeed");
            this.j.setAutoSpeed(z);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setDecoderType(DecoderType decoderType, DecoderType decoderType2) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setFadingVolumn(float f, long j) {
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setFadingVolume(f, j);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setInitialBufferingTime(int i) {
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setInitBufferTime(i);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setLooping(boolean z) {
        if (this.j != null) {
            LogEx.d("VrPlayer", "setLooping");
            this.j.setLooping(z);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setMaxAllBufferSize(long j) {
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setMaxAllBufferSize(j);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setMaxBufferSize(long j) {
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setMaxBufferSize(j);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setMaxBufferingTime(int i) {
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setMaxBufferTime(i);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPlaySpeed(float f) {
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setSpeed(f);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPlaybackBufferingTime(int i) {
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setPlaybackBufferTime(i);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPreferredAudioLanguage(String str) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPreferredBitrate(long j) {
        if (this.j != null) {
            LogEx.d("VrPlayer", "setPreferBitrate");
            this.j.setPreferBitrate(j);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setRenderTypeOpenGL() {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setSourceType(String str) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setSphericalVideoView(float f, float f2, float f3) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setSubtitleGravity(SubtitleHorizontal subtitleHorizontal, SubtitleVertical subtitleVertical) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setUseAdaptiveTrack() {
        if (this.j != null) {
            LogEx.d("VrPlayer", "set to use AdaptiveTrack");
            this.j.selectTrack(-1);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setVolume(float f) {
        if (this.j != null) {
            LogEx.d("VrPlayer", "setVolume");
            this.j.setVolume(f, f);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void start() {
        if (b() && this.j != null) {
            LogEx.d("VrPlayer", "IjkPlayer start().");
            com.video.androidsdk.player.common.c.a(c.a.RUN_TIME);
            this.j.start();
            MDVRLibrary mDVRLibrary = this.l;
            if (mDVRLibrary != null) {
                mDVRLibrary.c(this.m);
            }
            com.video.androidsdk.player.common.c.b(c.a.RUN_TIME);
            this.v = 3;
            this.f3307c.onStateChanged(3);
            return;
        }
        LogEx.e("VrPlayer", "player status is error");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void startWriteLog() {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void stop() {
        if (this.j != null) {
            LogEx.d("VrPlayer", " stop() " + this);
            this.j.stop();
            this.v = 6;
            this.j.reset();
            onRenderReset();
            this.v = 0;
            this.u = true;
            this.s = false;
            this.i.obtainMessage(4, Boolean.valueOf(true ^ this.z)).sendToTarget();
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void stopSphericalView() {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void stopWriteLog() {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void suspend4bg() {
        if (this.j != null) {
            LogEx.d("VrPlayer", "suspend4bg() " + this);
            LogEx.d("VrPlayer", "-------- misPlayerRun is " + this.s);
            MDVRLibrary mDVRLibrary = this.l;
            if (mDVRLibrary != null) {
                mDVRLibrary.b(this.m);
            }
            if (this.s) {
                this.r = true;
                this.h = this.j.isPlaying();
                LogEx.d("VrPlayer", "-------- mIsPlayingWhenSuspend is " + this.h);
                if (this.h && 3 == this.v) {
                    this.j.pause();
                    this.v = 4;
                }
                this.i.removeCallbacksAndMessages(null);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void unmute() {
        if (this.j != null) {
            float max = Math.max(0.0f, this.A);
            LogEx.d("VrPlayer", "volume is " + max);
            this.j.setVolume(max, max);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void updateVideoSize(int i, int i2) {
    }

    private void e() {
        LogEx.d("VrPlayer", "mPath is " + this.k);
        try {
            if (this.x != null) {
                LogEx.d("VrPlayer", "setSurface   " + this.x);
                this.j.setSurface(this.x);
            }
            this.j.setDataSource(this.k);
            if (this.k.contains("rtsp://")) {
                this.F = 0;
            } else if (this.k.contains("rtmp://")) {
                this.F = 2;
            } else {
                this.F = 1;
            }
            f();
            this.j.setAudioStreamType(3);
            this.j.prepareAsync();
            LogEx.d("VrPlayer", "prepareAsync");
            this.v = 1;
        } catch (IOException e) {
            LogEx.w("VrPlayer", "Unable to open content: " + this.k);
            this.v = -1;
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onError(String.valueOf(1), "Unable to open content");
            }
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            LogEx.w("VrPlayer", "Unable to open content: " + this.k);
            this.v = -1;
            IBasePlayer.OnEventListener onEventListener2 = this.f3307c;
            if (onEventListener2 != null) {
                onEventListener2.onError(String.valueOf(1), "Unable to open content");
            }
            e2.printStackTrace();
        } catch (IllegalStateException e3) {
            LogEx.w("VrPlayer", "Unable to open content: " + this.k);
            this.v = -1;
            IBasePlayer.OnEventListener onEventListener3 = this.f3307c;
            if (onEventListener3 != null) {
                onEventListener3.onError(String.valueOf(1), "Unable to open content");
            }
            e3.printStackTrace();
        }
        this.s = true;
    }

    private void f() {
        this.j.setOption(4, "mediacodec-all-videos", 1L);
        this.j.setOption(4, "mediacodec-auto-rotate", 1L);
        int i = this.F;
        if (i == 0) {
            this.j.setOption(4, "packet-buffering", 1L);
            this.j.setOption(4, "auto-set-speed", 0L);
            this.j.setOption(4, "overlay-format", 842225234L);
            this.j.setOption(1, "flush_packets", 1L);
            this.j.setOption(2, "skip_frame", 8L);
            this.j.setOption(4, "connect-timeout-msec", 300000L);
            this.j.setOption(1, "probesize", PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            this.j.setOption(1, "analyzeduration", 5000000L);
            this.j.setOption(1, "reconnect", 1L);
            this.j.setOption(1, "one_connection_seek", 1L);
            return;
        }
        if (2 == i) {
            this.j.setOption(1, "http-detect-range-support", 0L);
            this.j.setOption(1, "flush_packets", 1L);
            this.j.setOption(4, "packet-buffering", 0L);
            this.j.setOption(4, "connect-timeout-msec", 300000L);
            this.j.setOption(1, "probesize", PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            this.j.setOption(1, "analyzeduration", 5000000L);
            this.j.setOption(1, "reconnect", 1L);
            this.j.setOption(1, "one_connection_seek", 1L);
            return;
        }
        this.j.setOption(1, "probesize", 5242880L);
        this.j.setOption(1, "analyzeduration", 5000000L);
        this.j.setOption(4, "overlay-format", 842225234L);
        this.j.setOption(4, "max-fps", 0L);
        this.j.setOption(4, "connect-timeout-msec", 300000L);
        this.j.setOption(1, "reconnect", 1L);
        this.j.setOption(1, "one_connection_seek", 1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        IjkMediaPlayer ijkMediaPlayer;
        if (this.u || (ijkMediaPlayer = this.j) == null) {
            return;
        }
        long currentPosition = ijkMediaPlayer.getCurrentPosition();
        LogEx.d("VrPlayer", "currentPositon is " + currentPosition);
        LogEx.d("VrPlayer", "Duration is " + this.j.getDuration());
        IBasePlayer.OnEventListener onEventListener = this.f3307c;
        if (onEventListener != null) {
            onEventListener.onTime(currentPosition);
        }
    }

    private void d() {
        setOnSurfaceDestroyCallback(new IRender.IOnSurfaceDestroyCallback() { // from class: com.video.androidsdk.player.VrPlayer.9
            @Override // com.video.androidsdk.player.render.IRender.IOnSurfaceDestroyCallback, com.render.vrlib.MDVRLibrary.i
            public void onSurfaceDestroy() {
                LogEx.d("VrPlayer", "OnSurfaceDestroy");
                VrPlayer.this.q = false;
                if (VrPlayer.this.j != null) {
                    VrPlayer.this.j.setSurface(null);
                }
                IBasePlayer.OnEventListener onEventListener = VrPlayer.this.f3307c;
                if (onEventListener != null) {
                    onEventListener.onStateChanged(14);
                }
            }
        });
        setOnSurfaceReadyCallback(new IRender.IOnSurfaceReadyCallback() { // from class: com.video.androidsdk.player.VrPlayer.10
            @Override // com.video.androidsdk.player.render.IRender.IOnSurfaceReadyCallback, com.render.vrlib.MDVRLibrary.j
            public void onSurfaceReady(Surface surface) {
                LogEx.d("VrPlayer", "onSurfaceReady");
                VrPlayer.this.q = true;
                if (VrPlayer.this.j != null) {
                    VrPlayer.this.j.setSurface(surface);
                }
                VrPlayer.this.x = surface;
                IBasePlayer.OnEventListener onEventListener = VrPlayer.this.f3307c;
                if (onEventListener != null) {
                    onEventListener.onStateChanged(15);
                }
            }
        });
    }

    protected boolean b() {
        int i;
        return (this.j == null || (i = this.v) == -1 || i == 0 || i == 1) ? false : true;
    }

    protected void a() {
        this.j = new IjkMediaPlayer();
        if (LogEx.getLogLevel() == LogEx.LogLevelType.TYPE_LOG_LEVEL_DEBUG) {
            IjkMediaPlayer.native_setLogLevel(2);
        }
        this.j.setOption(4, "mediacodec-handle-resolution-change", 1L);
        this.j.setOnCompletionListener(this.H);
        this.j.setOnPreparedListener(this.G);
        this.j.setOnErrorListener(this.L);
        this.j.setOnInfoListener(this.K);
        this.j.setOnSeekCompleteListener(this.I);
        this.j.setOnBufferingUpdateListener(this.J);
        this.j.setOnVideoSizeChangedListener(this.M);
        this.t = false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(RelativeLayout relativeLayout, int i, boolean z) {
        if (relativeLayout == null) {
            LogEx.d("VrPlayer", "layout is null, return");
            return;
        }
        this.y = relativeLayout;
        relativeLayout.removeAllViews();
        a(this.y);
        this.w = (AudioManager) this.m.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(this.m);
        frameLayout.setLayoutParams(layoutParams);
        View view = new View(this.m);
        this.p = view;
        view.setBackgroundColor(-16777216);
        this.p.setLayoutParams(layoutParams);
        this.z = z;
        a(!z);
        frameLayout.addView(this.p);
        relativeLayout.addView(frameLayout);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void seek(long j, long j2) {
        if (this.j == null || !b()) {
            return;
        }
        this.B = j2 - this.j.getDuration();
        LogEx.d("VrPlayer", "seek to ---  " + j + getDuration());
        com.video.androidsdk.player.common.c.a(c.a.SEEK_TIME);
        this.j.seekTo(j + getDuration());
        com.video.androidsdk.player.common.c.b(c.a.SEEK_TIME);
        IBasePlayer.OnEventListener onEventListener = this.f3307c;
        if (onEventListener != null) {
            onEventListener.onStateChanged(10);
        }
    }

    @Override // com.video.androidsdk.player.a
    public void openInternal(String str, int i) {
        LogEx.d("VrPlayer", "url is " + str);
        this.k = str;
        if (TextUtils.isEmpty(str)) {
            LogEx.w("VrPlayer", "player url is null");
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(-1);
                return;
            }
            return;
        }
        if (this.j != null) {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        LogEx.d("VrPlayer", "show shutterView " + z);
        View view = this.p;
        if (view != null) {
            if (z) {
                view.setVisibility(0);
            } else {
                view.setVisibility(4);
            }
        }
    }

    private void a(RelativeLayout relativeLayout) {
        initRenderLibrary(this.m, relativeLayout);
        d();
    }
}
