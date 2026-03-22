package com.video.androidsdk.player;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.exoplayer2.util.MimeTypes;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.IBasePlayer;
import com.video.androidsdk.player.common.AssetStatus;
import com.video.androidsdk.player.common.AssetType;
import com.video.androidsdk.player.common.DecoderType;
import com.video.androidsdk.player.common.SubtitleHorizontal;
import com.video.androidsdk.player.common.SubtitleVertical;
import com.video.androidsdk.player.common.c;
import ijk.media.player.IMediaPlayer;
import ijk.media.player.IjkMediaPlayer;
import ijk.media.player.misc.IMediaFormat;
import ijk.media.player.render.FVGlSurfaceView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes.dex */
public class IjkPlayer extends a {
    private AudioManager A;
    private TextureView D;
    private Surface E;
    private float H;
    private View p;
    private IjkMediaPlayer j = null;
    private String k = null;
    private SurfaceView q = null;
    private FVGlSurfaceView r = null;
    private SurfaceHolder s = null;
    private boolean t = false;
    protected boolean h = false;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private SurfaceHolder.Callback y = null;
    private int z = 0;
    private boolean B = false;
    private boolean C = true;
    private boolean F = false;
    private boolean G = false;
    private long I = 0;
    private SparseArray<Integer> J = new SparseArray<>();
    private SparseArray<Integer> K = new SparseArray<>();
    private SparseArray<Integer> L = new SparseArray<>();
    private boolean M = true;
    private IMediaPlayer.e N = new IMediaPlayer.e() { // from class: com.video.androidsdk.player.IjkPlayer.1
        @Override // ijk.media.player.IMediaPlayer.e
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            LogEx.d("IjkPlayer", "onPrepared called");
            if (IjkPlayer.this.B) {
                IjkPlayer.this.j.start();
                return;
            }
            if (-1 == IjkPlayer.this.z || IjkPlayer.this.z == 0 || 3 == IjkPlayer.this.z) {
                return;
            }
            IjkPlayer.this.z = 2;
            IjkPlayer.this.x = false;
            com.video.androidsdk.player.common.c.b(c.a.OPEN_COMPLETE_TIME);
            IjkPlayer.this.f3307c.onStateChanged(2);
        }
    };
    private IMediaPlayer.b O = new IMediaPlayer.b() { // from class: com.video.androidsdk.player.IjkPlayer.2
        @Override // ijk.media.player.IMediaPlayer.b
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            LogEx.d("IjkPlayer", "onCompletion called");
            IjkPlayer.this.z = 5;
            IBasePlayer.OnEventListener onEventListener = IjkPlayer.this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(5);
            }
        }
    };
    private IMediaPlayer.f P = new IMediaPlayer.f() { // from class: com.video.androidsdk.player.IjkPlayer.3
        @Override // ijk.media.player.IMediaPlayer.f
        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            LogEx.d("IjkPlayer", "onSeekComplete called");
            if (4 == IjkPlayer.this.z) {
                return;
            }
            IBasePlayer.OnEventListener onEventListener = IjkPlayer.this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(11);
            }
            IjkPlayer.this.j.start();
            IjkPlayer.this.z = 3;
        }
    };
    private IMediaPlayer.a Q = new IMediaPlayer.a() { // from class: com.video.androidsdk.player.IjkPlayer.4
        @Override // ijk.media.player.IMediaPlayer.a
        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
        }
    };
    private IMediaPlayer.d R = new IMediaPlayer.d() { // from class: com.video.androidsdk.player.IjkPlayer.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // ijk.media.player.IMediaPlayer.d
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            if (i == 1) {
                LogEx.d("IjkPlayer", "MEDIA_INFO_UNKNOWN:");
            } else if (i == 2) {
                LogEx.d("IjkPlayer", "MEDIA_INFO_STARTED_AS_NEXT:");
            } else if (i == 3) {
                LogEx.d("IjkPlayer", "MEDIA_INFO_VIDEO_RENDERING_START:");
                IjkPlayer.this.i.obtainMessage(4, false).sendToTarget();
                IBasePlayer.OnEventListener onEventListener = IjkPlayer.this.f3307c;
                if (onEventListener != null) {
                    onEventListener.onStateChanged(12);
                }
                IjkPlayer.this.i.removeMessages(2);
                IjkPlayer.this.i.sendEmptyMessage(2);
            } else if (i != 10100) {
                switch (i) {
                    case IMediaPlayer.MEDIA_INFO_VIDEO_TRACK_LAGGING /* 700 */:
                        LogEx.d("IjkPlayer", "MEDIA_INFO_VIDEO_TRACK_LAGGING:");
                        break;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                        LogEx.d("IjkPlayer", "MEDIA_INFO_BUFFERING_START:");
                        IBasePlayer.OnEventListener onEventListener2 = IjkPlayer.this.f3307c;
                        if (onEventListener2 != null) {
                            onEventListener2.onStateChanged(7);
                            break;
                        }
                        break;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                        LogEx.d("IjkPlayer", "MEDIA_INFO_BUFFERING_END:");
                        IBasePlayer.OnEventListener onEventListener3 = IjkPlayer.this.f3307c;
                        if (onEventListener3 != null) {
                            onEventListener3.onStateChanged(9);
                            break;
                        }
                        break;
                    case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                        LogEx.d("IjkPlayer", "MEDIA_INFO_NETWORK_BANDWIDTH: " + i2);
                        break;
                    default:
                        switch (i) {
                            case 800:
                                LogEx.d("IjkPlayer", "MEDIA_INFO_BAD_INTERLEAVING:");
                                break;
                            case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                                LogEx.d("IjkPlayer", "MEDIA_INFO_NOT_SEEKABLE:");
                                break;
                            case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /* 802 */:
                                LogEx.d("IjkPlayer", "MEDIA_INFO_METADATA_UPDATE:");
                                break;
                            default:
                                switch (i) {
                                    case 900:
                                        LogEx.d("IjkPlayer", "MEDIA_INFO_TIMED_TEXT_ERROR:");
                                        break;
                                    case IMediaPlayer.MEDIA_INFO_UNSUPPORTED_SUBTITLE /* 901 */:
                                        LogEx.d("IjkPlayer", "MEDIA_INFO_UNSUPPORTED_SUBTITLE:");
                                        break;
                                    case IMediaPlayer.MEDIA_INFO_SUBTITLE_TIMED_OUT /* 902 */:
                                        LogEx.d("IjkPlayer", "MEDIA_INFO_SUBTITLE_TIMED_OUT:");
                                        break;
                                    default:
                                        switch (i) {
                                            case 10001:
                                                LogEx.d("IjkPlayer", "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i2);
                                                break;
                                            case 10002:
                                                LogEx.d("IjkPlayer", "MEDIA_INFO_AUDIO_RENDERING_START:");
                                                IBasePlayer.OnEventListener onEventListener4 = IjkPlayer.this.f3307c;
                                                if (onEventListener4 != null) {
                                                    onEventListener4.onStateChanged(9);
                                                    break;
                                                }
                                                break;
                                            case 10003:
                                                LogEx.d("IjkPlayer", "MEDIA_INFO_AUDIO_DECODED_START:");
                                                break;
                                            case IMediaPlayer.MEDIA_INFO_VIDEO_DECODED_START /* 10004 */:
                                                LogEx.d("IjkPlayer", "MEDIA_INFO_VIDEO_DECODED_START:");
                                                break;
                                            case IMediaPlayer.MEDIA_INFO_OPEN_INPUT /* 10005 */:
                                                LogEx.d("IjkPlayer", "MEDIA_INFO_OPEN_INPUT:");
                                                break;
                                            case IMediaPlayer.MEDIA_INFO_FIND_STREAM_INFO /* 10006 */:
                                                LogEx.d("IjkPlayer", "MEDIA_INFO_FIND_STREAM_INFO:");
                                                break;
                                            case 10007:
                                                LogEx.d("IjkPlayer", "MEDIA_INFO_COMPONENT_OPEN:");
                                                IjkPlayer.this.z = 2;
                                                IjkPlayer.this.x = false;
                                                com.video.androidsdk.player.common.c.b(c.a.OPEN_COMPLETE_TIME);
                                                IjkPlayer.this.f3307c.onStateChanged(2);
                                                break;
                                            case 10008:
                                                LogEx.d("IjkPlayer", "MEDIA_INFO_VIDEO_SEEK_RENDERING_START:");
                                                break;
                                        }
                                }
                        }
                }
            } else {
                LogEx.d("IjkPlayer", "MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE:");
            }
            return true;
        }
    };
    private IMediaPlayer.c S = new IMediaPlayer.c() { // from class: com.video.androidsdk.player.IjkPlayer.6
        @Override // ijk.media.player.IMediaPlayer.c
        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            LogEx.w("IjkPlayer", "onError called");
            LogEx.w("IjkPlayer", "framework_err： " + i + ";  impl_err: " + i2);
            IjkPlayer.this.z = -1;
            String str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            if (i == -1010) {
                str = "Media_error_unsupported";
            } else if (i == -1004) {
                str = "IO_error";
            } else if (i == -110) {
                str = "Media_error_time_out";
            } else if (i != 1) {
                if (i == 100) {
                    str = "Media_error_server_died";
                } else if (i == 200) {
                    str = "VideoView_error_text_invalid_progressive_playback";
                }
            }
            IBasePlayer.OnEventListener onEventListener = IjkPlayer.this.f3307c;
            if (onEventListener == null) {
                return false;
            }
            onEventListener.onError(String.valueOf(i), str);
            return true;
        }
    };
    protected Handler i = new Handler() { // from class: com.video.androidsdk.player.IjkPlayer.7
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                if (IjkPlayer.this.t) {
                    LogEx.d("IjkPlayer", "MSG_OPEN 1");
                    LogEx.d("IjkPlayer", "open, misPlayerRelease is " + IjkPlayer.this.w);
                    if (IjkPlayer.this.w) {
                        return;
                    }
                    IjkPlayer.this.e();
                    return;
                }
                LogEx.d("IjkPlayer", "MSG_OPEN 2 ,delay 50ms");
                sendEmptyMessageDelayed(1, 50L);
                return;
            }
            if (i == 2) {
                IjkPlayer.this.c();
                sendEmptyMessageDelayed(2, 1000L);
                return;
            }
            if (i != 3) {
                if (i != 4) {
                    LogEx.w("IjkPlayer", "unkown msg");
                    return;
                }
                Object obj = message.obj;
                if (obj == null) {
                    obj = false;
                }
                boolean booleanValue = ((Boolean) obj).booleanValue();
                LogEx.d("IjkPlayer", "isShow is " + booleanValue);
                IjkPlayer.this.a(booleanValue);
                return;
            }
            if (IjkPlayer.this.G) {
                if (IjkPlayer.this.t) {
                    LogEx.d("IjkPlayer", "MSG_RESUME 1");
                    LogEx.d("IjkPlayer", "resume, the view is " + IjkPlayer.this.q);
                    LogEx.d("IjkPlayer", "resume, the surface is " + IjkPlayer.this.E);
                    if (IjkPlayer.this.j != null && IjkPlayer.this.h) {
                        LogEx.d("IjkPlayer", "MSG_RESUME 2");
                        LogEx.d("IjkPlayer", "mIjkMediaPlayer.start()");
                        IjkPlayer.this.j.start();
                        IjkPlayer.this.z = 3;
                    }
                    LogEx.d("IjkPlayer", "send msg to updateUI ");
                    sendEmptyMessage(2);
                    IjkPlayer.this.u = false;
                    IjkPlayer.this.h = false;
                    return;
                }
                LogEx.d("IjkPlayer", "MSG_RESUME 3");
                sendEmptyMessageDelayed(3, 200L);
                return;
            }
            if (IjkPlayer.this.t) {
                LogEx.d("IjkPlayer", "MSG_RESUME 1");
                LogEx.d("IjkPlayer", "resume, the surface is " + IjkPlayer.this.E);
                IjkPlayer.this.j.setSurface(IjkPlayer.this.E);
                if (IjkPlayer.this.u) {
                    LogEx.d("IjkPlayer", "MSG_RESUME 2");
                    if (IjkPlayer.this.j != null && IjkPlayer.this.h) {
                        LogEx.d("IjkPlayer", "mIjkMediaPlayer.start()");
                        IjkPlayer.this.j.start();
                        IjkPlayer.this.z = 3;
                    }
                    LogEx.d("IjkPlayer", "send msg to updateUI ");
                    sendEmptyMessage(2);
                    IjkPlayer.this.u = false;
                    IjkPlayer.this.h = false;
                    return;
                }
                return;
            }
            LogEx.d("IjkPlayer", "MSG_RESUME 3");
            sendEmptyMessageDelayed(3, 200L);
        }
    };
    private GestureDetector T = new GestureDetector(this.m, new GestureDetector.OnGestureListener() { // from class: com.video.androidsdk.player.IjkPlayer.8
        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            LogEx.d("IjkPlayer", "onScroll event");
            if (f > 0.0f) {
                LogEx.d("IjkPlayer", "switch left===");
                IjkPlayer.this.j.switchLeft();
                return true;
            }
            if (f2 <= 0.0f) {
                return true;
            }
            LogEx.d("IjkPlayer", "switch right===");
            IjkPlayer.this.j.switchRight();
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (IjkPlayer.this.z != 3) {
                if (IjkPlayer.this.z != 4) {
                    return true;
                }
                IjkPlayer.this.resume();
                return true;
            }
            IjkPlayer.this.pause();
            return true;
        }
    });

    /* loaded from: classes.dex */
    private class MySurfaceTextureListener implements TextureView.SurfaceTextureListener {
        private MySurfaceTextureListener() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            LogEx.d("IjkPlayer", "mbIsSurfaceCreated ");
            IjkPlayer.this.E = new Surface(surfaceTexture);
            if (IjkPlayer.this.j != null) {
                IjkPlayer.this.j.setSurface(IjkPlayer.this.E);
            }
            IjkPlayer.this.t = true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            LogEx.d("IjkPlayer", "SurfaceTextureDestroyed ");
            IjkPlayer.this.t = false;
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            LogEx.d("IjkPlayer", "onSurfaceTextureSizeChanged ");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class SurfaceCallBack implements SurfaceHolder.Callback {
        private SurfaceCallBack() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            LogEx.d("IjkPlayer", "Surface Changed");
            IjkPlayer.this.t = true;
            LogEx.i("Surface Change:::", "---Width---:" + i2 + "---height--:" + i3);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            IjkPlayer.this.s = surfaceHolder;
            IjkPlayer.this.E = surfaceHolder.getSurface();
            LogEx.d("IjkPlayer", "Surface Created " + IjkPlayer.this.E);
            IjkPlayer.this.t = true;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            LogEx.d("IjkPlayer", "Surface Destroyed");
            IjkPlayer.this.t = false;
        }
    }

    public IjkPlayer(Context context) {
        this.m = context;
        a();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean closeSensor() {
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void enableCardBoardVideo(boolean z) {
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
                if (this.J.size() == 0) {
                    ijk.media.player.misc.k[] trackInfo = this.j.getTrackInfo();
                    int i2 = 0;
                    while (i < trackInfo.length) {
                        ijk.media.player.misc.k kVar = trackInfo[i];
                        if (kVar.getTrackType() == 1 && kVar.getFormat() != null) {
                            this.J.put(i2, Integer.valueOf(i));
                            i2++;
                        }
                        i++;
                    }
                }
                return this.J.size();
            }
            if (assetType == AssetType.Asset_Audio) {
                if (this.K.size() == 0) {
                    ijk.media.player.misc.k[] trackInfo2 = this.j.getTrackInfo();
                    int i3 = 0;
                    while (i < trackInfo2.length) {
                        if (trackInfo2[i].getTrackType() == 2) {
                            this.K.put(i3, Integer.valueOf(i));
                            i3++;
                        }
                        i++;
                    }
                }
                return this.K.size();
            }
            if (assetType == AssetType.Asset_Subtitle) {
                if (this.L.size() == 0) {
                    ijk.media.player.misc.k[] trackInfo3 = this.j.getTrackInfo();
                    int i4 = 0;
                    while (i < trackInfo3.length) {
                        if (trackInfo3[i].getTrackType() == 4) {
                            this.L.put(i4, Integer.valueOf(i));
                            i4++;
                        }
                        i++;
                    }
                }
                return this.L.size();
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
                if (this.J.size() == 0) {
                    ijk.media.player.misc.k[] trackInfo = this.j.getTrackInfo();
                    int i3 = 0;
                    while (i2 < trackInfo.length) {
                        ijk.media.player.misc.k kVar = trackInfo[i2];
                        if (kVar.getTrackType() == 1 && kVar.getFormat() != null) {
                            this.J.put(i3, Integer.valueOf(i2));
                            i3++;
                        }
                        i2++;
                    }
                }
                int selectedTrack = this.j.getSelectedTrack(1);
                LogEx.d("IjkPlayer", "track type is video ,track index in stream is  " + selectedTrack);
                if (selectedTrack >= 0 && this.J.indexOfValue(Integer.valueOf(selectedTrack)) != -1) {
                    i = this.J.indexOfValue(Integer.valueOf(selectedTrack));
                }
            } else if (assetType == AssetType.Asset_Audio) {
                if (this.K.size() == 0) {
                    ijk.media.player.misc.k[] trackInfo2 = this.j.getTrackInfo();
                    int i4 = 0;
                    while (i2 < trackInfo2.length) {
                        if (trackInfo2[i2].getTrackType() == 2) {
                            this.K.put(i4, Integer.valueOf(i2));
                            i4++;
                        }
                        i2++;
                    }
                }
                int selectedTrack2 = this.j.getSelectedTrack(2);
                LogEx.d("IjkPlayer", "track type is audio ,track index in stream is  " + selectedTrack2);
                if (selectedTrack2 >= 0 && this.K.indexOfValue(Integer.valueOf(selectedTrack2)) != -1) {
                    i = this.K.indexOfValue(Integer.valueOf(selectedTrack2));
                }
            } else if (assetType == AssetType.Asset_Subtitle) {
                LogEx.d("IjkPlayer", "track type is subitle");
                if (this.L.size() == 0) {
                    ijk.media.player.misc.k[] trackInfo3 = this.j.getTrackInfo();
                    int i5 = 0;
                    while (i2 < trackInfo3.length) {
                        if (trackInfo3[i2].getTrackType() == 4) {
                            this.L.put(i5, Integer.valueOf(i2));
                            i5++;
                        }
                        i2++;
                    }
                }
                int selectedTrack3 = this.j.getSelectedTrack(4);
                if (selectedTrack3 >= 0 && this.L.indexOfValue(Integer.valueOf(selectedTrack3)) != -1) {
                    i = this.L.indexOfValue(Integer.valueOf(selectedTrack3));
                }
            }
        }
        LogEx.d("IjkPlayer", "selected index is " + i);
        return i;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getAudioInfoArray(ArrayList<String> arrayList) {
        ijk.media.player.misc.k[] trackInfo;
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer == null || (trackInfo = ijkMediaPlayer.getTrackInfo()) == null) {
            return;
        }
        if (this.K == null) {
            this.K = new SparseArray<>();
        }
        this.K.clear();
        int i = 0;
        for (int i2 = 0; i2 < trackInfo.length; i2++) {
            ijk.media.player.misc.k kVar = trackInfo[i2];
            if (kVar.getTrackType() == 2) {
                String language = kVar.getLanguage();
                LogEx.d("IjkPlayer", "trackInfo is " + kVar);
                arrayList.add(language + "," + i2);
                this.K.put(i, Integer.valueOf(i2));
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
        LogEx.d("IjkPlayer", "IjkPlayer Position  is  " + videoCachedDuration);
        return videoCachedDuration;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getCurrentPosition() {
        if (this.j == null || !b()) {
            return 0L;
        }
        long currentPosition = this.j.getCurrentPosition();
        LogEx.d("IjkPlayer", "Position  is  " + currentPosition);
        return currentPosition;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getDuration() {
        if (this.j == null || !b()) {
            return -1L;
        }
        long duration = this.j.getDuration();
        LogEx.d("IjkPlayer", "duration  is  " + duration);
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
        return this.z;
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
        if (this.L == null) {
            this.L = new SparseArray<>();
        }
        this.L.clear();
        int i = 0;
        for (int i2 = 0; i2 < trackInfo.length; i2++) {
            ijk.media.player.misc.k kVar = trackInfo[i2];
            if (kVar.getTrackType() == 4) {
                String language = kVar.getLanguage();
                LogEx.d("IjkPlayer", "subtitile is " + language);
                arrayList.add(language + "," + i2);
                this.L.put(i, Integer.valueOf(i2));
                i++;
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public SurfaceView getSurfaceView() {
        return this.q;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getUTCPosition() {
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer == null) {
            return 0L;
        }
        long currentPosition = ijkMediaPlayer.getCurrentPosition();
        LogEx.d("IjkPlayer", "IjkPlayer Position  is  " + currentPosition);
        long j = this.I + currentPosition;
        LogEx.d("IjkPlayer", "IjkPlayer iUTCPosition  is  " + j);
        return j;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getVideoHeight() {
        if (this.j == null || !b()) {
            return 0;
        }
        int videoHeight = this.j.getVideoHeight();
        LogEx.d("IjkPlayer", "VideoHeight  is  " + videoHeight);
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
        if (this.J == null) {
            this.J = new SparseArray<>();
        }
        this.J.clear();
        int i = 0;
        for (int i2 = 0; i2 < trackInfo.length; i2++) {
            ijk.media.player.misc.k kVar = trackInfo[i2];
            if (kVar.getTrackType() == 1 && (format = kVar.getFormat()) != null) {
                LogEx.d("IjkPlayer", "format is " + format.getInteger("bitrate"));
                arrayList.add(String.format(Locale.US, "%.2fMbit", Float.valueOf(((float) format.getInteger("bitrate")) / 1000000.0f)) + "," + i2);
                this.J.put(i, Integer.valueOf(i2));
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
        LogEx.d("IjkPlayer", "IjkPlayer VideoWidth  is  " + videoWidth);
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
        LogEx.d("IjkPlayer", "getVolume");
        float volume = this.j.getVolume();
        LogEx.d("IjkPlayer", "Volume is " + volume);
        return volume;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(Surface surface) {
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setSurface(surface);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(TextureView textureView) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean isPlaying() {
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer == null) {
            return false;
        }
        boolean isPlaying = ijkMediaPlayer.isPlaying();
        LogEx.d("IjkPlayer", " status  is  " + isPlaying);
        return isPlaying;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean isTrackAvailable(AssetType assetType, int i) {
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void mute() {
        if (this.j != null) {
            LogEx.d("IjkPlayer", "mVolume is " + this.H);
            this.H = this.j.getVolume();
            this.j.setVolume(0.0f, 0.0f);
        }
    }

    @Override // com.video.androidsdk.player.a
    public void openInternal(String str) {
        LogEx.d("IjkPlayer", " url is " + str);
        this.k = str;
        if (TextUtils.isEmpty(str)) {
            LogEx.w("IjkPlayer", "player url is null");
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(-1);
                return;
            }
            return;
        }
        if (this.j != null) {
            if (this.t && !this.w) {
                e();
            } else {
                this.i.sendEmptyMessage(1);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean openSensor() {
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void pause() {
        IjkMediaPlayer ijkMediaPlayer;
        LogEx.d("IjkPlayer", " pause().");
        if (b() && (ijkMediaPlayer = this.j) != null && ijkMediaPlayer.isPlaying()) {
            LogEx.d("IjkPlayer", "The player status is " + this.j.isPlaying());
            com.video.androidsdk.player.common.c.a(c.a.PAUSE_TIME);
            this.j.pause();
            com.video.androidsdk.player.common.c.b(c.a.PAUSE_TIME);
            this.z = 4;
            return;
        }
        LogEx.e("IjkPlayer", "player status is error");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void release() {
        LogEx.d("IjkPlayer", "IjkPlayer release(). " + this);
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.release();
            this.j = null;
            this.z = 0;
            this.w = true;
            this.i.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void resume() {
        LogEx.d("IjkPlayer", "resume().");
        if (this.j != null && 4 == this.z) {
            LogEx.d("IjkPlayer", "STATE_PAUSED == miPlayerStatus");
            com.video.androidsdk.player.common.c.a(c.a.RUN_TIME);
            this.j.start();
            com.video.androidsdk.player.common.c.b(c.a.RUN_TIME);
            this.z = 3;
            return;
        }
        LogEx.e("IjkPlayer", "player status is error");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void resume4bg() {
        if (this.j != null) {
            LogEx.d("IjkPlayer", "resume4bg, the view is " + this.q);
            if (this.v) {
                this.i.sendEmptyMessage(3);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void seek(long j) {
        if (this.j == null || !b()) {
            return;
        }
        LogEx.d("IjkPlayer", " seek to ---  " + j);
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
            if (this.K.size() == 0) {
                ijk.media.player.misc.k[] trackInfo = this.j.getTrackInfo();
                int i2 = 0;
                for (int i3 = 0; i3 < trackInfo.length; i3++) {
                    ijk.media.player.misc.k kVar = trackInfo[i3];
                    if (kVar.getTrackType() == 2) {
                        kVar.getLanguage();
                        this.K.put(i2, Integer.valueOf(i3));
                        i2++;
                    }
                }
            }
            if (this.K.size() > i) {
                LogEx.d("IjkPlayer", "the mapped index is " + this.K.get(i));
                this.j.selectTrack(this.K.get(i).intValue());
                return true;
            }
            LogEx.e("IjkPlayer", "invalid selected index " + i);
        }
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectSubtitleByIndex(int i) {
        if (this.j != null) {
            if (this.L.size() == 0) {
                ijk.media.player.misc.k[] trackInfo = this.j.getTrackInfo();
                int i2 = 0;
                for (int i3 = 0; i3 < trackInfo.length; i3++) {
                    if (trackInfo[i3].getTrackType() == 4) {
                        this.L.put(i2, Integer.valueOf(i3));
                        i2++;
                    }
                }
            }
            if (this.L.size() > i) {
                LogEx.d("IjkPlayer", "the mapped index is " + this.L.get(i));
                this.j.selectTrack(this.L.get(i).intValue());
                return true;
            }
            LogEx.e("IjkPlayer", "invalid selected index " + i);
        }
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectVideoByIndex(int i) {
        if (this.j != null) {
            if (this.J.size() == 0) {
                ijk.media.player.misc.k[] trackInfo = this.j.getTrackInfo();
                int i2 = 0;
                for (int i3 = 0; i3 < trackInfo.length; i3++) {
                    ijk.media.player.misc.k kVar = trackInfo[i3];
                    if (kVar.getTrackType() == 1 && kVar.getFormat() != null) {
                        this.J.put(i2, Integer.valueOf(i3));
                        i2++;
                    }
                }
            }
            if (this.J.size() > i) {
                LogEx.d("IjkPlayer", "the mapped index is " + this.J.get(i));
                this.j.selectTrack(this.J.get(i).intValue());
                return true;
            }
            LogEx.e("IjkPlayer", "invalid selected index " + i);
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
            LogEx.d("IjkPlayer", "setAutoSpeed");
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

    public void setFreeViewEnable(Context context, boolean z, FVGlSurfaceView fVGlSurfaceView) {
        this.j.setFreeViewEnable(context, z, fVGlSurfaceView);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setInitialBufferingTime(int i) {
        IjkMediaPlayer ijkMediaPlayer = this.j;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setInitBufferTime(i);
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
            LogEx.d("IjkPlayer", "setPreferBitrate");
            this.j.setPreferBitrate(j);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setRenderTypeOpenGL() {
    }

    public void setSensibilty(float f) {
        this.j.setSensibilty(f);
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

    public void setSurfaceViewType(boolean z) {
        this.B = z;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setUseAdaptiveTrack() {
        if (this.j != null) {
            LogEx.d("IjkPlayer", "set to use AdaptiveTrack");
            this.j.selectTrack(-1);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setVolume(float f) {
        if (this.j != null) {
            LogEx.d("IjkPlayer", "setVolume");
            this.j.setVolume(f, f);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void start() {
        if (b() && this.j != null) {
            LogEx.d("IjkPlayer", "IjkPlayer start().");
            com.video.androidsdk.player.common.c.a(c.a.RUN_TIME);
            this.j.start();
            com.video.androidsdk.player.common.c.b(c.a.RUN_TIME);
            this.z = 3;
            this.f3307c.onStateChanged(3);
            return;
        }
        LogEx.e("IjkPlayer", "player status is error");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void startWriteLog() {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void stop() {
        if (this.j != null) {
            LogEx.d("IjkPlayer", " stop() " + this);
            this.j.stop();
            this.z = 6;
            this.j.reset();
            this.z = 0;
            this.x = true;
            this.v = false;
            this.i.obtainMessage(4, Boolean.valueOf(true ^ this.F)).sendToTarget();
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
            LogEx.d("IjkPlayer", "suspend4bg() " + this);
            LogEx.d("IjkPlayer", "-------- misPlayerRun is " + this.v);
            if (this.v) {
                this.u = true;
                this.h = this.j.isPlaying();
                if (!this.G) {
                    this.j.setSurface(null);
                }
                LogEx.d("IjkPlayer", "-------- mIsPlayingWhenSuspend is " + this.h);
                if (this.h && 3 == this.z) {
                    this.h = true;
                    this.j.pause();
                    this.z = 4;
                }
                this.i.removeCallbacksAndMessages(null);
            }
        }
    }

    public void switchLeft() {
        LogEx.d("IjkPlayer", "zhh:switch left");
        this.j.switchLeft();
    }

    public void switchRight() {
        LogEx.d("IjkPlayer", "zhh:switch right");
        this.j.switchRight();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void unmute() {
        if (this.j != null) {
            float max = Math.max(0.0f, this.H);
            LogEx.d("IjkPlayer", "volume is " + max);
            this.j.setVolume(max, max);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void updateVideoSize(int i, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        LogEx.d("IjkPlayer", "mPath is " + this.k);
        if (!this.M) {
            LogEx.w("IjkPlayer", "cannot find watermark, so cannot play");
            return;
        }
        try {
            this.j.setDataSource(this.k);
            if (this.G && this.E != null) {
                LogEx.d("IjkPlayer", "setSurface(mSurface)");
                this.j.setSurface(this.E);
            } else if (this.E != null) {
                LogEx.d("IjkPlayer", "setSurface(mSurface)  " + this.E);
                this.j.setSurface(this.E);
            }
            this.j.setAudioStreamType(3);
            this.j.setOption(4, "mediacodec-all-videos", 1L);
            this.j.setOption(4, "mediacodec-auto-rotate", 0L);
            this.j.setOption(4, "mediacodec-handle-resolution-change", 1L);
            this.j.setOption(4, "overlay-format", 842225234L);
            this.j.setOption(1, "http-detect-range-support", 0L);
            this.j.setOption(4, "connect-timeout-msec", 300000L);
            this.j.setOption(1, "probesize", 5242880L);
            this.j.setOption(1, "analyzeduration", 5000000L);
            this.j.setOption(1, "reconnect", 1L);
            this.j.setOption(1, "one_connection_seek", 1L);
            this.j.prepareAsync();
            LogEx.d("IjkPlayer", "prepareAsync");
            this.z = 1;
        } catch (IOException e) {
            LogEx.w("IjkPlayer", "Unable to open content: " + this.k);
            this.z = -1;
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onError(String.valueOf(1), "Unable to open content");
            }
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            LogEx.w("IjkPlayer", "Unable to open content: " + this.k);
            this.z = -1;
            IBasePlayer.OnEventListener onEventListener2 = this.f3307c;
            if (onEventListener2 != null) {
                onEventListener2.onError(String.valueOf(1), "Unable to open content");
            }
            e2.printStackTrace();
        } catch (IllegalStateException e3) {
            LogEx.w("IjkPlayer", "Unable to open content: " + this.k);
            this.z = -1;
            IBasePlayer.OnEventListener onEventListener3 = this.f3307c;
            if (onEventListener3 != null) {
                onEventListener3.onError(String.valueOf(1), "Unable to open content");
            }
            e3.printStackTrace();
        }
        this.v = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        IjkMediaPlayer ijkMediaPlayer;
        if (this.x || (ijkMediaPlayer = this.j) == null) {
            return;
        }
        long currentPosition = ijkMediaPlayer.getCurrentPosition();
        LogEx.d("IjkPlayer", "currentPositon is " + currentPosition);
        LogEx.d("IjkPlayer", "Duration is " + this.j.getDuration());
        IBasePlayer.OnEventListener onEventListener = this.f3307c;
        if (onEventListener != null) {
            onEventListener.onTime(currentPosition);
        }
    }

    private void d() {
        if (this.y == null) {
            LogEx.d("IjkPlayer", "add callback");
            this.y = new SurfaceCallBack();
            SurfaceHolder holder = this.q.getHolder();
            this.s = holder;
            holder.addCallback(this.y);
            this.s.setFormat(1);
        }
    }

    protected boolean b() {
        int i;
        return (this.j == null || (i = this.z) == -1 || i == 0 || i == 1) ? false : true;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(RelativeLayout relativeLayout) {
        LogEx.d("IjkPlayer", "start init");
        if (relativeLayout == null) {
            LogEx.d("IjkPlayer", "layout is null, return");
            return;
        }
        relativeLayout.removeAllViews();
        this.A = (AudioManager) this.m.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.G = false;
        LogEx.d("IjkPlayer", "init surfaceview");
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        if (this.B) {
            LogEx.d("IjkPlayer", "view type is FVGlSurfaceView");
            FVGlSurfaceView fVGlSurfaceView = new FVGlSurfaceView(this.m);
            this.r = fVGlSurfaceView;
            fVGlSurfaceView.setLayoutParams(layoutParams);
            relativeLayout.addView(this.r);
            this.j.setFreeViewEnable(this.m, this.C, this.r);
            IjkMediaPlayer.native_setLogLevel(2);
            this.j.setOption(4, "packet-buffering", 0L);
            this.j.setOption(4, "mediacodec-all-videos", 1L);
            this.j.setOption(4, "start-on-prepared", 1L);
            LogEx.d("IjkPlayer", "fvenable status == " + this.C);
            this.r.a(new FVGlSurfaceView.a() { // from class: com.video.androidsdk.player.IjkPlayer.9
                @Override // ijk.media.player.render.FVGlSurfaceView.a
                public void onSurfaceCreated(Surface surface) {
                    Log.d("IjkPlayer", "onSurfaceCreated success");
                    IjkPlayer.this.j.setSurface(surface);
                    IjkPlayer.this.t = true;
                    IjkPlayer.this.r.setOnTouchListener(new View.OnTouchListener() { // from class: com.video.androidsdk.player.IjkPlayer.9.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (IjkPlayer.this.T != null) {
                                return IjkPlayer.this.T.onTouchEvent(motionEvent);
                            }
                            return true;
                        }
                    });
                }
            });
        } else {
            SurfaceView surfaceView = new SurfaceView(this.m);
            this.q = surfaceView;
            surfaceView.setLayoutParams(layoutParams);
            relativeLayout.addView(this.q);
            d();
        }
        if (com.video.androidsdk.license.a.i && !new com.video.androidsdk.player.view.a().a(this.m, relativeLayout)) {
            this.M = false;
            LogEx.w("IjkPlayer", "cannot find watermark picture");
        }
        LogEx.d("IjkPlayer", " init end");
    }

    protected void a() {
        this.j = new IjkMediaPlayer();
        if (LogEx.getLogLevel() == LogEx.LogLevelType.TYPE_LOG_LEVEL_DEBUG) {
            IjkMediaPlayer.native_setLogLevel(2);
        }
        this.j.setOnCompletionListener(this.O);
        this.j.setOnPreparedListener(this.N);
        this.j.setOnErrorListener(this.S);
        this.j.setOnInfoListener(this.R);
        this.j.setOnSeekCompleteListener(this.P);
        this.j.setOnBufferingUpdateListener(this.Q);
        this.w = false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void seek(long j, long j2) {
        if (this.j == null || !b()) {
            return;
        }
        this.I = j2 - this.j.getDuration();
        LogEx.d("IjkPlayer", "seek to ---  " + j + getDuration());
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
        LogEx.d("IjkPlayer", "url is " + str);
        this.k = str;
        if (TextUtils.isEmpty(str)) {
            LogEx.w("IjkPlayer", "player url is null");
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(-1);
                return;
            }
            return;
        }
        if (this.j != null) {
            if (this.t && !this.w) {
                e();
            } else {
                this.i.sendEmptyMessage(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        LogEx.d("IjkPlayer", "show shutterView " + z);
        View view = this.p;
        if (view != null) {
            if (z) {
                view.setVisibility(0);
            } else {
                view.setVisibility(4);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(RelativeLayout relativeLayout, int i, boolean z) {
        if (relativeLayout == null) {
            LogEx.d("IjkPlayer", "layout is null, return");
            return;
        }
        relativeLayout.removeAllViews();
        this.A = (AudioManager) this.m.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(this.m);
        frameLayout.setLayoutParams(layoutParams);
        if (i == 1) {
            LogEx.d("IjkPlayer", "init SurfaceView");
            this.G = false;
            if (this.B) {
                FVGlSurfaceView fVGlSurfaceView = new FVGlSurfaceView(this.m);
                this.r = fVGlSurfaceView;
                fVGlSurfaceView.setLayoutParams(layoutParams);
                frameLayout.addView(this.r);
                this.r.a(new FVGlSurfaceView.a() { // from class: com.video.androidsdk.player.IjkPlayer.10
                    @Override // ijk.media.player.render.FVGlSurfaceView.a
                    public void onSurfaceCreated(Surface surface) {
                        Log.d("IjkPlayer", "onSurfaceCreated");
                        IjkPlayer.this.j.setSurface(surface);
                        IjkPlayer.this.j.prepareAsync();
                    }
                });
            } else {
                SurfaceView surfaceView = new SurfaceView(this.m);
                this.q = surfaceView;
                surfaceView.setLayoutParams(layoutParams);
                frameLayout.addView(this.q);
                d();
            }
        } else {
            Log.d("IjkPlayer", "init TextureView");
            this.G = true;
            TextureView textureView = new TextureView(this.m);
            this.D = textureView;
            textureView.setLayoutParams(layoutParams);
            this.D.setSurfaceTextureListener(new MySurfaceTextureListener());
            frameLayout.addView(this.D);
        }
        View view = new View(this.m);
        this.p = view;
        view.setBackgroundColor(-16777216);
        this.p.setLayoutParams(layoutParams);
        this.F = z;
        a(!z);
        frameLayout.addView(this.p);
        relativeLayout.addView(frameLayout);
        if (!com.video.androidsdk.license.a.i || new com.video.androidsdk.player.view.a().a(this.m, relativeLayout)) {
            return;
        }
        this.M = false;
        LogEx.w("IjkPlayer", "cannot find watermark picture");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(SurfaceView surfaceView) {
        this.q = surfaceView;
        d();
    }
}
