package com.video.androidsdk.player;

import android.content.Context;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Base64;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.exoplayer2.util.MimeTypes;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.IBasePlayer;
import com.video.androidsdk.player.common.AssetStatus;
import com.video.androidsdk.player.common.AssetType;
import com.video.androidsdk.player.common.CommonFunc;
import com.video.androidsdk.player.common.DecoderType;
import com.video.androidsdk.player.common.SourceType;
import com.video.androidsdk.player.common.SubtitleHorizontal;
import com.video.androidsdk.player.common.SubtitleVertical;
import com.video.androidsdk.player.common.ZoomModeType;
import com.video.androidsdk.player.common.c;
import com.visualon.OSMPPlayer.VOCommonPlayer;
import com.visualon.OSMPPlayer.VOCommonPlayerAssetSelection;
import com.visualon.OSMPPlayer.VOCommonPlayerListener;
import com.visualon.OSMPPlayer.VOOSMPChunkInfo;
import com.visualon.OSMPPlayer.VOOSMPInitParam;
import com.visualon.OSMPPlayer.VOOSMPOpenParam;
import com.visualon.OSMPPlayer.VOOSMPPlaylistData;
import com.visualon.OSMPPlayer.VOOSMPSessionData;
import com.visualon.OSMPPlayer.VOOSMPType;
import com.visualon.OSMPPlayerImpl.VOCommonPlayerImpl;
import com.visualon.OSMPPlayerImpl.VOOSMPSphericalVideoViewImpl;
import com.visualon.OSMPUtils.voSurfaceView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VisualonPlayer extends a {
    private static final boolean k;
    private static boolean z;
    private DecoderType A;
    private DecoderType B;
    private boolean C;
    private String D;
    private VOOSMPSphericalVideoViewImpl E;
    protected Handler i;
    protected VOCommonPlayerListener j;
    private AudioManager y;
    private String p = null;
    protected VOCommonPlayer h = null;
    private voSurfaceView q = null;
    private SurfaceHolder r = null;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private SurfaceHolder.Callback w = null;
    private int x = 0;

    /* renamed from: com.video.androidsdk.player.VisualonPlayer$3, reason: invalid class name */
    /* loaded from: classes.dex */
    /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3293a;

        static {
            int[] iArr = new int[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.values().length];
            f3293a = iArr;
            try {
                iArr[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_VIDEO_START_BUFFER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_VIDEO_STOP_BUFFER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_PLAY_COMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_VIDEO_SIZE_CHANGED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_AUDIO_STOP_BUFFER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_AUDIO_START_BUFFER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_VIDEO_ASPECT_RATIO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_PD_DOWNLOAD_POSITION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_PD_BUFFERING_PERCENT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_PROGRAM_CHANGED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_PROGRAM_RESET.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_SEEK_COMPLETE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_SEEK_COMPLETE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_ADAPTIVE_STREAMING_SEEK2LASTCHUNK.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_VIDEO_RENDER_START.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_OPEN_FINISHED.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_CODEC_NOT_SUPPORT.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_PREFERRED_AUDIO_LANGUAGE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_PREFERRED_SUBTITLE_LANGUAGE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_DRM_WARNING.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_OUTPUT_CONTROL_BLOCK_PLAYBACK.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_ADAPTIVE_STREAMING_INFO.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_ADAPTIVE_STREAMING_ERROR.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_ADAPTIVE_STREAMING_WARNING.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_ERROR.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_LICENSE_FAIL.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_CONNECTION_TIMEOUT.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_CONNECTION_LOSS.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_CONNECTION_FAIL.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_DOWNLOAD_FAIL.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_DRM_FAIL.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_PLAYLIST_PARSE_ERR.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_CONNECTION_REJECTED.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f3293a[VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_DRM_AV_OUT_FAIL.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class SurfaceCallBack implements SurfaceHolder.Callback {
        private SurfaceCallBack() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            LogEx.d("VisualonPlayer", "Surface Changed");
            VOCommonPlayer vOCommonPlayer = VisualonPlayer.this.h;
            if (vOCommonPlayer != null) {
                vOCommonPlayer.setSurfaceChangeFinished();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            LogEx.d("VisualonPlayer", "Surface Created");
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            LogEx.d("VisualonPlayer", "Surface Destroyed");
            VOCommonPlayer vOCommonPlayer = VisualonPlayer.this.h;
            if (vOCommonPlayer != null) {
                vOCommonPlayer.setView((View) null);
            }
        }
    }

    static {
        k = Build.VERSION.SDK_INT < 18;
        StringBuilder sb = new StringBuilder();
        sb.append("Before load ");
        sb.append(k ? "ViewRightWebClient" : "ViewRightVideoMarkClient");
        LogEx.d("DRM", sb.toString());
        try {
            if (k) {
                System.loadLibrary("ViewRightWebClient");
            } else {
                System.loadLibrary("ViewRightVideoMarkClient");
            }
            z = true;
        } catch (Exception e) {
            z = false;
            e.printStackTrace();
        } catch (UnsatisfiedLinkError e2) {
            z = false;
            e2.printStackTrace();
        }
        LogEx.d("DRM", "After loadLibrary, libViewRightWebClient");
    }

    public VisualonPlayer(Context context) {
        DecoderType decoderType = DecoderType.Decoder_SW;
        this.A = decoderType;
        this.B = decoderType;
        this.E = null;
        this.i = new Handler() { // from class: com.video.androidsdk.player.VisualonPlayer.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    if (!VisualonPlayer.this.u) {
                        if (VisualonPlayer.this.r != null && VisualonPlayer.this.r.getSurface() != null && VisualonPlayer.this.r.getSurface().isValid()) {
                            LogEx.d("VisualonPlayer", "MSG_OPEN 1");
                            VisualonPlayer.this.e();
                            return;
                        } else {
                            LogEx.d("VisualonPlayer", "MSG_OPEN 2");
                            sendEmptyMessageDelayed(1, 200L);
                            return;
                        }
                    }
                    LogEx.w("VisualonPlayer", "VisualonPlayer has been released");
                    return;
                }
                if (i == 2) {
                    VisualonPlayer.this.b();
                    sendEmptyMessageDelayed(2, 1000L);
                    return;
                }
                if (i == 3) {
                    if (VisualonPlayer.this.s) {
                        if (VisualonPlayer.this.r != null && VisualonPlayer.this.r.getSurface() != null && VisualonPlayer.this.r.getSurface().isValid()) {
                            LogEx.d("VisualonPlayer", "MSG_RESUME 1");
                            if (VisualonPlayer.this.h != null) {
                                LogEx.d("VisualonPlayer", "VisualonPlayer resume, the view is " + VisualonPlayer.this.q);
                                VisualonPlayer visualonPlayer = VisualonPlayer.this;
                                visualonPlayer.h.resume(visualonPlayer.q);
                                VisualonPlayer.this.s = false;
                                if (VisualonPlayer.this.C) {
                                    LogEx.d("VisualonPlayer", "open finished");
                                    VisualonPlayer.this.f3307c.onStateChanged(2);
                                    VisualonPlayer.this.x = 2;
                                    VisualonPlayer.this.C = false;
                                }
                                VisualonPlayer.this.i.sendEmptyMessage(2);
                                return;
                            }
                            return;
                        }
                        LogEx.d("VisualonPlayer", "MSG_RESUME 2");
                        sendEmptyMessageDelayed(3, 200L);
                        return;
                    }
                    LogEx.w("VisualonPlayer", "VisualonPlayer can not resume");
                    return;
                }
                LogEx.w("VisualonPlayer", "unkown msg");
            }
        };
        this.j = new VOCommonPlayerListener() { // from class: com.video.androidsdk.player.VisualonPlayer.2
            public VOOSMPType.VO_OSMP_RETURN_CODE onVOEvent(VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID vo_osmp_cb_event_id, int i, int i2, Object obj) {
                LogEx.d("VisualonPlayer", "VisualonPlayer onVOEvent: " + vo_osmp_cb_event_id + " - " + Integer.toHexString(vo_osmp_cb_event_id.getValue()) + "  ,nParam1 is: " + i + "  ,nParam2 is: " + i2 + " ,obj is: " + obj);
                if (VisualonPlayer.this.f3307c == null) {
                    return VOOSMPType.VO_OSMP_RETURN_CODE.VO_OSMP_ERR_NONE;
                }
                int i3 = AnonymousClass3.f3293a[vo_osmp_cb_event_id.ordinal()];
                if (i3 == 1) {
                    LogEx.d("VisualonPlayer", "[APP][EVENT]Received video start buffering event");
                    com.video.androidsdk.player.common.c.a(c.a.BUFFER_TIME);
                    VisualonPlayer.this.f3307c.onStateChanged(7);
                } else if (i3 == 2) {
                    LogEx.d("VisualonPlayer", "[APP][EVENT]Received video stop buffering event");
                    com.video.androidsdk.player.common.c.b(c.a.BUFFER_TIME);
                    VisualonPlayer.this.f3307c.onStateChanged(9);
                } else if (i3 != 3) {
                    switch (i3) {
                        case 12:
                            LogEx.d("VisualonPlayer", "[APP][EVENT]Received seek completed event");
                            com.video.androidsdk.player.common.c.b(c.a.SEEK_COMPLETE_TIME);
                            VisualonPlayer.this.f3307c.onStateChanged(11);
                            break;
                        case 13:
                            com.video.androidsdk.player.common.c.b(c.a.SEEK_COMPLETE_TIME);
                            if (i2 == VOOSMPType.VO_OSMP_RETURN_CODE.VO_OSMP_ERR_NONE.getValue()) {
                                LogEx.d("VisualonPlayer", "seek success");
                                VisualonPlayer.this.f3307c.onStateChanged(11);
                                break;
                            } else if (i2 == VOOSMPType.VO_OSMP_RETURN_CODE.VO_OSMP_SRC_ERR_SEEK_FAIL.getValue()) {
                                LogEx.d("VisualonPlayer", "seek failed");
                                break;
                            }
                            break;
                        case 14:
                            com.video.androidsdk.player.common.c.b(c.a.SEEK_TO_LATEST_TRUNK);
                            break;
                        case 15:
                            com.video.androidsdk.player.common.c.b(c.a.OPEN_RENDER_TIME);
                            VisualonPlayer.this.f3307c.onStateChanged(12);
                            VisualonPlayer visualonPlayer = VisualonPlayer.this;
                            if (visualonPlayer.h != null) {
                                visualonPlayer.i.removeCallbacksAndMessages(null);
                                VisualonPlayer.this.i.sendEmptyMessage(2);
                                break;
                            }
                            break;
                        case 16:
                            VisualonPlayer.this.v = false;
                            com.video.androidsdk.player.common.c.b(c.a.OPEN_COMPLETE_TIME);
                            if (i == VOOSMPType.VO_OSMP_RETURN_CODE.VO_OSMP_ERR_NONE.getValue()) {
                                LogEx.d("VisualonPlayer", "mbIsResumePlayerNeeded is " + VisualonPlayer.this.s);
                                if (VisualonPlayer.this.s) {
                                    VisualonPlayer.this.C = true;
                                    break;
                                } else {
                                    VisualonPlayer.this.f3307c.onStateChanged(2);
                                    VisualonPlayer.this.x = 2;
                                    break;
                                }
                            } else {
                                LogEx.e("VisualonPlayer", "[APP][EVENT]Received open finished event, param1 is 0X " + Integer.toHexString(i));
                                VisualonPlayer.this.a("0X" + Integer.toHexString(i), "[APP][EVENT]Received open finished event");
                                break;
                            }
                        case 17:
                            LogEx.w("VisualonPlayer", "[player_error][APP][EVENT]Codec not supported, need switch to SW");
                            break;
                        case 18:
                            LogEx.d("VisualonPlayer", "[APP][EVENT]Received the preferred audio language, language is" + obj);
                            break;
                        case 19:
                            LogEx.d("VisualonPlayer", "[APP][EVENT]Received the preferred subtitle language, language is " + obj);
                            break;
                        case 20:
                            LogEx.w("VisualonPlayer", "[APP][EVENT]Received Drm engine warning, param1 is " + i);
                            break;
                        case 21:
                            LogEx.e("VisualonPlayer", "[player_error][APP][EVENT]Playback blocked");
                            VisualonPlayer.this.a("0X" + Integer.toHexString(vo_osmp_cb_event_id.getValue()), "[player_error][APP][EVENT]Playback blocked");
                            break;
                        case 22:
                            VisualonPlayer.this.a(i, obj);
                            break;
                        case 23:
                            VisualonPlayer.this.a("0X" + Integer.toHexString(vo_osmp_cb_event_id.getValue() + i), VisualonPlayer.this.a(i));
                            break;
                        case 24:
                            VisualonPlayer.this.b(i, obj);
                            break;
                        case 25:
                            LogEx.e("VisualonPlayer", "[player_error][APP][EVENT]Received CB error event");
                            VisualonPlayer.this.a("0X" + Integer.toHexString(vo_osmp_cb_event_id.getValue()), "[player_error][APP][EVENT]Received CB error event");
                            break;
                        case 26:
                            LogEx.e("VisualonPlayer", "[player_error][APP][EVENT]Received license failed event");
                            VisualonPlayer.this.a("0X" + Integer.toHexString(vo_osmp_cb_event_id.getValue()), "[player_error][APP][EVENT]Received license failed event");
                            break;
                        case 27:
                            LogEx.e("VisualonPlayer", "[player_error][APP][EVENT]Received connection timeout event");
                            VisualonPlayer.this.a("0X" + Integer.toHexString(vo_osmp_cb_event_id.getValue()), "[player_error][APP][EVENT]Received connection timeout event");
                            break;
                        case 28:
                            LogEx.e("VisualonPlayer", "[player_error][APP][EVENT]Received connection loss event");
                            VisualonPlayer.this.a("0X" + Integer.toHexString(vo_osmp_cb_event_id.getValue()), "[player_error][APP][EVENT]Received connection loss event");
                            break;
                        case 29:
                            LogEx.e("VisualonPlayer", "[player_error][APP][EVENT]Received connection fail event");
                            VisualonPlayer.this.a("0X" + Integer.toHexString(vo_osmp_cb_event_id.getValue()), "[player_error][APP][EVENT]Received connection fail event");
                            break;
                        case 30:
                            LogEx.e("VisualonPlayer", "[player_error][APP][EVENT]Received download failed event");
                            VisualonPlayer.this.a("0X" + Integer.toHexString(vo_osmp_cb_event_id.getValue()), "[player_error][APP][EVENT]Received download failed event");
                            break;
                        case 31:
                            LogEx.d("VisualonPlayer", "[APP][EVENT]Received the drm error, error code is " + i + ", " + obj);
                            break;
                        case 32:
                            LogEx.e("VisualonPlayer", "[player_error][APP][EVENT]Received playlist parse error event");
                            VisualonPlayer.this.a("0X" + Integer.toHexString(vo_osmp_cb_event_id.getValue()), "[player_error][APP][EVENT]Received playlist parse error event");
                            break;
                        case 33:
                            LogEx.e("VisualonPlayer", "[player_error][APP][EVENT]Received connection rejected event");
                            VisualonPlayer.this.a("0X" + Integer.toHexString(vo_osmp_cb_event_id.getValue()), "[player_error][APP][EVENT]Received connection rejected event");
                            break;
                        case 34:
                            LogEx.e("VisualonPlayer", "[player_error][APP][EVENT]Received DRM AV out failed event");
                            VisualonPlayer.this.a("0X" + Integer.toHexString(vo_osmp_cb_event_id.getValue()), "[player_error][APP][EVENT]Received DRM AV out failed event");
                            break;
                    }
                } else {
                    LogEx.d("VisualonPlayer", "[APP][EVENT]Received playback completed event");
                    com.video.androidsdk.player.common.c.b(c.a.PLAY_COMPLETE);
                    VisualonPlayer.this.f3307c.onStateChanged(5);
                }
                return VOOSMPType.VO_OSMP_RETURN_CODE.VO_OSMP_ERR_NONE;
            }

            public VOOSMPType.VO_OSMP_RETURN_CODE onVOSyncEvent(VOCommonPlayerListener.VO_OSMP_CB_SYNC_EVENT_ID vo_osmp_cb_sync_event_id, int i, int i2, Object obj) {
                return null;
            }
        };
        this.m = context;
        a();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean closeSensor() {
        VOOSMPSphericalVideoViewImpl vOOSMPSphericalVideoViewImpl = this.E;
        if (vOOSMPSphericalVideoViewImpl == null) {
            return false;
        }
        vOOSMPSphericalVideoViewImpl.stop();
        LogEx.d("VisualonPlayer", "m_sensor stop success.");
        return true;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void enableCardBoardVideo(boolean z2) {
        if (this.h != null) {
            if (z2) {
                LogEx.d("VisualonPlayer", "enableCardBoardVideo.");
                this.h.enableCardBoardVideo(true);
            } else {
                LogEx.d("VisualonPlayer", "disableCardBoardVideo.");
                this.h.enableCardBoardVideo(false);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void enableSphericalVideo(boolean z2) {
        stopSphericalView();
        if (this.h != null) {
            LogEx.d("VisualonPlayer", "enableSphericalVideo.");
            if (z2) {
                this.h.enableSphericalVideo(true);
                if (this.E == null) {
                    this.E = new VOOSMPSphericalVideoViewImpl(this.m);
                }
                this.E.start();
                this.h.setSphericalVideoView(this.E);
                return;
            }
            this.h.enableSphericalVideo(false);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void enableSubtitle(boolean z2) {
        if (this.h != null) {
            LogEx.d("VisualonPlayer", "enableSubtitle: " + z2);
            this.h.enableSubtitle(z2);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getAssetCount(AssetType assetType) {
        VOCommonPlayer vOCommonPlayer = this.h;
        int i = 0;
        if (vOCommonPlayer == null) {
            return 0;
        }
        if (assetType == AssetType.Asset_Video) {
            i = vOCommonPlayer.getVideoCount();
        } else if (assetType == AssetType.Asset_Audio) {
            i = vOCommonPlayer.getAudioCount();
        } else if (assetType == AssetType.Asset_Subtitle) {
            i = vOCommonPlayer.getSubtitleCount();
        }
        LogEx.d("VisualonPlayer", "AssetType is " + assetType + " ,count is " + i);
        return i;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getAssetIndex(AssetType assetType, AssetStatus assetStatus) {
        LogEx.d("VisualonPlayer", "AssetType is " + assetType + " ,AssetStatus is " + assetStatus);
        VOCommonPlayer vOCommonPlayer = this.h;
        if (vOCommonPlayer == null) {
            return -1;
        }
        VOCommonPlayerAssetSelection.VOOSMPAssetIndex vOOSMPAssetIndex = null;
        if (assetStatus == AssetStatus.Asset_Playing) {
            vOOSMPAssetIndex = vOCommonPlayer.getPlayingAsset();
        } else if (assetStatus == AssetStatus.Asset_Selected) {
            vOOSMPAssetIndex = vOCommonPlayer.getCurrentSelection();
        }
        if (vOOSMPAssetIndex == null) {
            return -1;
        }
        if (assetType == AssetType.Asset_Video) {
            return vOOSMPAssetIndex.getVideoIndex();
        }
        if (assetType == AssetType.Asset_Audio) {
            return vOOSMPAssetIndex.getAudioIndex();
        }
        if (assetType == AssetType.Asset_Subtitle) {
            return vOOSMPAssetIndex.getSubtitleIndex();
        }
        return -1;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getAudioInfoArray(ArrayList<String> arrayList) {
        VOCommonPlayer vOCommonPlayer;
        String str;
        if (arrayList == null || (vOCommonPlayer = this.h) == null) {
            return;
        }
        int audioCount = vOCommonPlayer.getAudioCount();
        LogEx.d("VisualonPlayer", "+++ getAudioDescription +++: " + audioCount);
        if (audioCount == 0) {
            return;
        }
        for (int i = 0; i < audioCount; i++) {
            if (!this.h.isAudioAvailable(i)) {
                LogEx.d("VisualonPlayer", "Audio is unAvailable");
            } else {
                VOCommonPlayerAssetSelection.VOOSMPAssetProperty audioProperty = this.h.getAudioProperty(i);
                if (audioProperty != null) {
                    if (audioProperty.getPropertyCount() == 0) {
                        str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    } else {
                        str = (String) audioProperty.getValue(1);
                        LogEx.d("VisualonPlayer", "--- getAudioDescription --- strDescription: " + str);
                        if (!TextUtils.isEmpty(str) && str.contains("-")) {
                            str = str.substring(0, str.indexOf("-"));
                        }
                    }
                    arrayList.add(str);
                }
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getCurrentPosition() {
        VOCommonPlayer vOCommonPlayer = this.h;
        if (vOCommonPlayer == null) {
            return 0L;
        }
        long position = vOCommonPlayer.getPosition();
        LogEx.d("VisualonPlayer", "VisualonPlayer Position  is  " + position);
        return position;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public String getDRMUniqueIdentifier() {
        VOCommonPlayer vOCommonPlayer = this.h;
        if (vOCommonPlayer == null) {
            return null;
        }
        String dRMUniqueIdentifier = vOCommonPlayer.getDRMUniqueIdentifier();
        LogEx.d("VisualonPlayer", "UUID is " + dRMUniqueIdentifier);
        return dRMUniqueIdentifier;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getDuration() {
        VOCommonPlayer vOCommonPlayer = this.h;
        if (vOCommonPlayer == null) {
            return 0L;
        }
        long maxPosition = vOCommonPlayer.getMaxPosition();
        long minPosition = this.h.getMinPosition();
        long j = maxPosition - minPosition;
        LogEx.d("VisualonPlayer", "VisualonPlayer MaxPosition  is  " + maxPosition);
        LogEx.d("VisualonPlayer", "VisualonPlayer MinPosition  is  " + minPosition);
        LogEx.d("VisualonPlayer", "VisualonPlayer duration  is  " + j);
        if (j <= 0) {
            j = this.h.getDuration();
            LogEx.d("VisualonPlayer", "VisualonPlayer duration  is  " + j);
        }
        if (j < 0) {
            return 0L;
        }
        return j;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getPlayerState() {
        VOCommonPlayer vOCommonPlayer = this.h;
        if (vOCommonPlayer != null) {
            VOOSMPType.VO_OSMP_STATUS playerStatus = vOCommonPlayer.getPlayerStatus();
            LogEx.d("VisualonPlayer", "VisualonPlayer status  is  " + playerStatus);
            if (playerStatus != VOOSMPType.VO_OSMP_STATUS.VO_OSMP_STATUS_INITIALIZING && playerStatus != VOOSMPType.VO_OSMP_STATUS.VO_OSMP_STATUS_LOADING) {
                if (playerStatus == VOOSMPType.VO_OSMP_STATUS.VO_OSMP_STATUS_PAUSED) {
                    this.x = 4;
                } else if (playerStatus == VOOSMPType.VO_OSMP_STATUS.VO_OSMP_STATUS_PLAYING) {
                    this.x = 3;
                } else if (playerStatus == VOOSMPType.VO_OSMP_STATUS.VO_OSMP_STATUS_STOPPED) {
                    this.x = 6;
                }
            } else {
                this.x = 1;
            }
        }
        return this.x;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getScreenBrightness() {
        if (this.h == null) {
            return 0;
        }
        LogEx.d("VisualonPlayer", "getScreenBrightness");
        int screenBrightness = this.h.getScreenBrightness();
        LogEx.d("VisualonPlayer", "ScreenBrightness is " + screenBrightness);
        return screenBrightness;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public float getSphericalViewSensorRoll() {
        VOOSMPSphericalVideoViewImpl vOOSMPSphericalVideoViewImpl = this.E;
        if (vOOSMPSphericalVideoViewImpl != null) {
            return vOOSMPSphericalVideoViewImpl.getSensorRoll();
        }
        return 0.0f;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getSubtitleInfoArray(ArrayList<String> arrayList) {
        VOCommonPlayer vOCommonPlayer;
        String substring;
        if (arrayList == null || (vOCommonPlayer = this.h) == null) {
            return;
        }
        int subtitleCount = vOCommonPlayer.getSubtitleCount();
        LogEx.d("VisualonPlayer", "+++ getSubtitleDescription +++: " + subtitleCount);
        if (subtitleCount == 0) {
            return;
        }
        for (int i = 0; i < subtitleCount; i++) {
            if (!this.h.isSubtitleAvailable(i)) {
                LogEx.d("VisualonPlayer", "Subtitle is unAvailable");
            } else {
                VOCommonPlayerAssetSelection.VOOSMPAssetProperty subtitleProperty = this.h.getSubtitleProperty(i);
                if (subtitleProperty != null) {
                    if (subtitleProperty.getPropertyCount() == 0) {
                        substring = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    } else {
                        String str = (String) subtitleProperty.getValue(1);
                        LogEx.d("VisualonPlayer", "--- getSubtitleDescription --- strDescription: " + str);
                        LogEx.d("VisualonPlayer", "--- getSubtitleLanguage --- strLanguage: " + ((String) subtitleProperty.getValue(2)));
                        substring = (TextUtils.isEmpty(str) || !str.contains("-")) ? str : str.substring(0, str.indexOf("-"));
                    }
                    arrayList.add(substring);
                }
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public SurfaceView getSurfaceView() {
        return this.q;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getUTCPosition() {
        VOCommonPlayer vOCommonPlayer = this.h;
        if (vOCommonPlayer == null) {
            return 0L;
        }
        long uTCPosition = vOCommonPlayer.getUTCPosition();
        LogEx.d("VisualonPlayer", "VisualonPlayer UTCPosition  is  " + uTCPosition);
        return uTCPosition;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getVideoHeight() {
        return 0;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getVideoInfoArray(ArrayList<String> arrayList) {
        VOCommonPlayer vOCommonPlayer;
        int i;
        String str;
        if (arrayList == null || (vOCommonPlayer = this.h) == null) {
            return;
        }
        int videoCount = vOCommonPlayer.getVideoCount();
        LogEx.d("VisualonPlayer", "+++ getVideoDescription +++: " + videoCount);
        if (videoCount == 0) {
            return;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < videoCount; i3++) {
            VOCommonPlayerAssetSelection.VOOSMPAssetProperty videoProperty = this.h.getVideoProperty(i3);
            if (videoProperty != null) {
                if (videoProperty.getPropertyCount() == 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("V");
                    i = i2 + 1;
                    sb.append(Integer.toString(i2));
                    str = sb.toString();
                } else {
                    i = i2;
                    str = (String) videoProperty.getValue(2);
                }
                LogEx.d("VisualonPlayer", "--- getVideoDescription --- strDescription: " + str);
                if (!TextUtils.isEmpty(str) && str.length() > 4) {
                    String substring = str.substring(0, str.length() - 4);
                    LogEx.d("VisualonPlayer", "getVideoDescription:str = " + substring);
                    if (substring.equals("0")) {
                        arrayList.add("0");
                    } else {
                        arrayList.add(CommonFunc.bitrateToString(Integer.valueOf(substring).intValue()));
                    }
                }
                i2 = i;
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getVideoWidth() {
        return 0;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public float getVolume() {
        if (this.h == null) {
            return 0.0f;
        }
        LogEx.d("VisualonPlayer", "getVolume");
        int streamMaxVolume = this.y.getStreamMaxVolume(3);
        LogEx.d("VisualonPlayer", "Volume is " + this.y.getStreamVolume(3));
        LogEx.d("VisualonPlayer", "Max Volume is " + streamMaxVolume);
        return (r2 / streamMaxVolume) * 1.0f;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(SurfaceView surfaceView) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(TextureView textureView) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(RelativeLayout relativeLayout) {
        LogEx.d("VisualonPlayer", "start init");
        CommonFunc.setApplicationSharedPreference(PreferenceManager.getDefaultSharedPreferences(this.m));
        this.y = (AudioManager) this.m.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        LogEx.d("VisualonPlayer", "init surfaceview");
        this.q = new voSurfaceView(this.m);
        this.q.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        relativeLayout.addView(this.q);
        c();
        LogEx.d("VisualonPlayer", " init end");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(RelativeLayout relativeLayout, int i, boolean z2) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean isPlaying() {
        VOCommonPlayer vOCommonPlayer = this.h;
        if (vOCommonPlayer == null) {
            return false;
        }
        VOOSMPType.VO_OSMP_STATUS playerStatus = vOCommonPlayer.getPlayerStatus();
        LogEx.d("VisualonPlayer", "VisualonPlayer status  is  " + playerStatus);
        return playerStatus == VOOSMPType.VO_OSMP_STATUS.VO_OSMP_STATUS_PLAYING;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean isTrackAvailable(AssetType assetType, int i) {
        LogEx.d("VisualonPlayer", "AssetType is " + assetType + " ,index is " + i);
        VOCommonPlayer vOCommonPlayer = this.h;
        if (vOCommonPlayer == null) {
            return false;
        }
        if (assetType == AssetType.Asset_Video) {
            return vOCommonPlayer.isVideoAvailable(i);
        }
        if (assetType == AssetType.Asset_Audio) {
            return vOCommonPlayer.isAudioAvailable(i);
        }
        if (assetType == AssetType.Asset_Subtitle) {
            return vOCommonPlayer.isSubtitleAvailable(i);
        }
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void mute() {
        if (this.h != null) {
            LogEx.d("VisualonPlayer", "mute");
            this.h.mute();
        }
    }

    @Override // com.video.androidsdk.player.a
    public void openInternal(String str) {
        LogEx.d("VisualonPlayer", "VisualonPlayer open.");
        this.p = str;
        if (TextUtils.isEmpty(str)) {
            LogEx.w("VisualonPlayer", "player url is null");
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(-1);
                return;
            }
            return;
        }
        if (this.h != null) {
            this.i.sendEmptyMessage(1);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean openSensor() {
        VOOSMPSphericalVideoViewImpl vOOSMPSphericalVideoViewImpl = this.E;
        if (vOOSMPSphericalVideoViewImpl == null) {
            return false;
        }
        vOOSMPSphericalVideoViewImpl.start();
        LogEx.d("VisualonPlayer", "m_sensor stop success.");
        return true;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void pause() {
        LogEx.d("VisualonPlayer", "VisualonPlayer pause().");
        VOCommonPlayer vOCommonPlayer = this.h;
        if (vOCommonPlayer != null) {
            VOOSMPType.VO_OSMP_STATUS playerStatus = vOCommonPlayer.getPlayerStatus();
            LogEx.d("VisualonPlayer", "The player playing status is " + playerStatus);
            if (playerStatus == VOOSMPType.VO_OSMP_STATUS.VO_OSMP_STATUS_PLAYING) {
                com.video.androidsdk.player.common.c.a(c.a.PAUSE_TIME);
                this.h.pause();
                com.video.androidsdk.player.common.c.b(c.a.PAUSE_TIME);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void release() {
        LogEx.d("VisualonPlayer", "VisualonPlayer release().");
        VOCommonPlayer vOCommonPlayer = this.h;
        if (vOCommonPlayer != null) {
            vOCommonPlayer.setOnEventListener((VOCommonPlayerListener) null);
            this.h.destroy();
            this.h = null;
            this.u = true;
            this.i.removeCallbacksAndMessages(null);
        }
        d();
        this.q = null;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void resume() {
        LogEx.d("VisualonPlayer", "VisualonPlayer resume().");
        VOCommonPlayer vOCommonPlayer = this.h;
        if (vOCommonPlayer != null) {
            VOOSMPType.VO_OSMP_STATUS playerStatus = vOCommonPlayer.getPlayerStatus();
            LogEx.d("VisualonPlayer", "The player playing status is " + playerStatus);
            if (playerStatus == VOOSMPType.VO_OSMP_STATUS.VO_OSMP_STATUS_PAUSED) {
                com.video.androidsdk.player.common.c.a(c.a.RUN_TIME);
                this.h.start();
                com.video.androidsdk.player.common.c.b(c.a.RUN_TIME);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void resume4bg() {
        LogEx.d("VisualonPlayer", "VisualonPlayer resume, the view is " + this.q);
        if (this.h != null) {
            c();
            LogEx.d("VisualonPlayer", "VisualonPlayer resume, mbIsPlayerRun is " + this.t);
            if (this.t) {
                this.i.sendEmptyMessage(3);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void seek(long j) {
        LogEx.d("VisualonPlayer", "VisualonPlayer seek to ---  " + j);
        if (this.h != null) {
            com.video.androidsdk.player.common.c.a(c.a.SEEK_TIME);
            this.h.setPosition(j);
            com.video.androidsdk.player.common.c.b(c.a.SEEK_TIME);
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(10);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectAudioByIndex(int i) {
        if (this.h == null) {
            return false;
        }
        LogEx.d("VisualonPlayer", "+++ selectAudioByIndex +++, index is " + i);
        com.video.androidsdk.player.common.c.a(c.a.SELECT_AUDIO);
        VOOSMPType.VO_OSMP_RETURN_CODE selectAudio = this.h.selectAudio(i);
        com.video.androidsdk.player.common.c.b(c.a.SELECT_AUDIO_COMPLETE);
        LogEx.d("VisualonPlayer", "+++ selectAudio +++, ret is " + selectAudio);
        if (VOOSMPType.VO_OSMP_RETURN_CODE.VO_OSMP_ERR_NONE != selectAudio) {
            return false;
        }
        VOOSMPType.VO_OSMP_RETURN_CODE commitSelection = this.h.commitSelection();
        LogEx.d("VisualonPlayer", "+++ commitSelection +++, ret is " + commitSelection);
        return VOOSMPType.VO_OSMP_RETURN_CODE.VO_OSMP_ERR_NONE == commitSelection;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectSubtitleByIndex(int i) {
        if (this.h == null) {
            return false;
        }
        LogEx.d("VisualonPlayer", "+++ selectSubtitleByIndex +++, index is " + i);
        com.video.androidsdk.player.common.c.a(c.a.SELECT_SUBTITLE);
        VOOSMPType.VO_OSMP_RETURN_CODE selectSubtitle = this.h.selectSubtitle(i);
        com.video.androidsdk.player.common.c.b(c.a.SELECT_SUBTITLE_COMPLETE);
        LogEx.d("VisualonPlayer", "+++ selectVideo +++, ret is " + selectSubtitle);
        if (VOOSMPType.VO_OSMP_RETURN_CODE.VO_OSMP_ERR_NONE != selectSubtitle) {
            return false;
        }
        VOOSMPType.VO_OSMP_RETURN_CODE commitSelection = this.h.commitSelection();
        LogEx.d("VisualonPlayer", "+++ commitSelection +++, ret is " + commitSelection);
        return VOOSMPType.VO_OSMP_RETURN_CODE.VO_OSMP_ERR_NONE == commitSelection;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectVideoByIndex(int i) {
        if (this.h == null) {
            return false;
        }
        LogEx.d("VisualonPlayer", "+++ selectVideoByIndex +++, index is " + i);
        com.video.androidsdk.player.common.c.a(c.a.SELECT_VIDEO);
        VOOSMPType.VO_OSMP_RETURN_CODE selectVideo = this.h.selectVideo(i);
        com.video.androidsdk.player.common.c.b(c.a.SELECT_VIDEO_COMPLETE);
        LogEx.d("VisualonPlayer", "+++ selectVideo +++, ret is " + selectVideo);
        if (VOOSMPType.VO_OSMP_RETURN_CODE.VO_OSMP_ERR_NONE != selectVideo) {
            return false;
        }
        VOOSMPType.VO_OSMP_RETURN_CODE commitSelection = this.h.commitSelection();
        LogEx.d("VisualonPlayer", "+++ commitSelection +++, ret is " + commitSelection);
        return VOOSMPType.VO_OSMP_RETURN_CODE.VO_OSMP_ERR_NONE == commitSelection;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setAudioChannel(boolean z2, boolean z3) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setDRMInfo(String str, String str2) {
        LogEx.d("VisualonPlayer", "mbDRMExist  is  " + z);
        VOCommonPlayer vOCommonPlayer = this.h;
        if (vOCommonPlayer == null || !z) {
            return;
        }
        vOCommonPlayer.setDRMLibrary(k ? "voDRM_Verimatrix_AES128_S42" : "voDRM_Verimatrix_AES128_S43", "voGetVerimatrixDRMAPI");
        LogEx.d("VisualonPlayer", "drm file path is  " + str2);
        if (!TextUtils.isEmpty(str2)) {
            this.h.setDRMFilePath(str2);
        }
        LogEx.d("VisualonPlayer", "App set DRM verificationString= " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.h.setDRMVerificationInfo(CommonFunc.creatVerificationInfo(str));
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setDecoderType(DecoderType decoderType, DecoderType decoderType2) {
        this.B = decoderType2;
        this.A = decoderType;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setInitialBufferingTime(int i) {
        LogEx.d("VisualonPlayer", "VisualonPlayer setInitialBufferingTime ==== " + i);
        VOCommonPlayer vOCommonPlayer = this.h;
        if (vOCommonPlayer != null) {
            vOCommonPlayer.setInitialBufferingTime(i);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setMaxBufferingTime(int i) {
        LogEx.d("VisualonPlayer", "VisualonPlayer setMaxBufferingTime ==== " + i);
        VOCommonPlayer vOCommonPlayer = this.h;
        if (vOCommonPlayer != null) {
            vOCommonPlayer.setMaxBufferingTime(i);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPlaybackBufferingTime(int i) {
        LogEx.d("VisualonPlayer", "VisualonPlayer setPlaybackBufferingTime ==== " + i);
        VOCommonPlayer vOCommonPlayer = this.h;
        if (vOCommonPlayer != null) {
            vOCommonPlayer.setPlaybackBufferingTime(i);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPreferredAudioLanguage(String str) {
        LogEx.d("VisualonPlayer", "VisualonPlayer setPreferredAudioLanguage, strLanguage is :" + str);
        String[] split = str.split(",");
        VOCommonPlayer vOCommonPlayer = this.h;
        if (vOCommonPlayer != null) {
            vOCommonPlayer.setPreferredAudioLanguage(split);
        }
    }

    public void setRenderType(VOOSMPType.VO_OSMP_RENDER_TYPE vo_osmp_render_type) {
        if (this.h != null) {
            LogEx.d("VisualonPlayer", "setRenderType is" + vo_osmp_render_type.toString() + ".");
            this.h.setRenderType(vo_osmp_render_type);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setRenderTypeOpenGL() {
        LogEx.d("VisualonPlayer", "setRenderTypeOpenGL ");
        setRenderType(VOOSMPType.VO_OSMP_RENDER_TYPE.VO_OSMP_RENDER_TYPE_OPENGLES);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setScreenBrightness(int i) {
        if (this.h != null) {
            LogEx.d("VisualonPlayer", "ScreenBrightness is " + i);
            this.h.setScreenBrightness(i);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setSourceType(String str) {
        this.D = str;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setSphericalVideoView(float f, float f2, float f3) {
        if (this.E == null) {
            this.E = new VOOSMPSphericalVideoViewImpl(this.m);
        }
        this.E.setTouchHeading(f);
        this.E.setTouchPitch(f2);
        this.E.setFOV(f3);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setSubtitleGravity(SubtitleHorizontal subtitleHorizontal, SubtitleVertical subtitleVertical) {
        if (this.h != null) {
            LogEx.d("VisualonPlayer", "VisualonPlayer setSubtitleGravity, horizontal position is :" + subtitleHorizontal + " ,vertical position is : " + subtitleVertical);
            this.h.setSubtitleGravity(VOOSMPType.VO_OSMP_HORIZONTAL.valueOf(subtitleHorizontal.getValue()), VOOSMPType.VO_OSMP_VERTICAL.valueOf(subtitleVertical.getValue()));
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setVolume(float f) {
        if (this.h != null) {
            LogEx.d("VisualonPlayer", "setVolume");
            this.h.setVolume(f);
            this.y.setStreamVolume(3, (int) (this.y.getStreamMaxVolume(3) * f), 0);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setZoomMode(ZoomModeType zoomModeType, Rect rect) {
        LogEx.d("VisualonPlayer", "zoom mode type is " + zoomModeType);
        VOCommonPlayer vOCommonPlayer = this.h;
        if (vOCommonPlayer != null) {
            vOCommonPlayer.setZoomMode(VOOSMPType.VO_OSMP_ZOOM_MODE.valueOf(zoomModeType.getValue()), rect);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void start() {
        LogEx.d("VisualonPlayer", "VisualonPlayer start().");
        if (this.h != null) {
            com.video.androidsdk.player.common.c.a(c.a.RUN_TIME);
            VOOSMPType.VO_OSMP_RETURN_CODE start = this.h.start();
            com.video.androidsdk.player.common.c.b(c.a.RUN_TIME);
            LogEx.d("VisualonPlayer", "start return code is  " + start.getValue());
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void startWriteLog() {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void stop() {
        LogEx.d("VisualonPlayer", "VisualonPlayer stop()");
        if (this.h != null) {
            com.video.androidsdk.player.common.c.a(c.a.STOP_TIME);
            this.h.stop();
            com.video.androidsdk.player.common.c.b(c.a.STOP_TIME);
            this.h.close();
            this.h.setView((View) null);
            this.t = false;
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void stopSphericalView() {
        if (this.E == null) {
            this.E = new VOOSMPSphericalVideoViewImpl(this.m);
        }
        this.E.stop();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void stopWriteLog() {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void suspend4bg() {
        LogEx.d("VisualonPlayer", "VisualonPlayer suspend()");
        if (this.h != null) {
            d();
            LogEx.d("VisualonPlayer", "VisualonPlayer -------- mbIsPlayerRun is " + this.t);
            if (this.t) {
                this.s = true;
                this.h.suspend(false);
                this.i.removeCallbacksAndMessages(null);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void unmute() {
        if (this.h != null) {
            LogEx.d("VisualonPlayer", "unmute");
            this.h.unmute();
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void updateVideoSize(int i, int i2) {
        LogEx.d("VisualonPlayer", "VisualonPlayer updateVideoSize()");
        VOCommonPlayer vOCommonPlayer = this.h;
        if (vOCommonPlayer != null) {
            vOCommonPlayer.setViewSize(i, i2);
        }
    }

    private void d() {
        if (this.w != null) {
            LogEx.d("VisualonPlayer", "remove callback");
            SurfaceHolder holder = this.q.getHolder();
            this.r = holder;
            holder.removeCallback(this.w);
            this.w = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        VOOSMPType.VO_OSMP_SRC_FORMAT vo_osmp_src_format;
        VOCommonPlayer vOCommonPlayer = this.h;
        if (vOCommonPlayer != null) {
            vOCommonPlayer.setView(this.q);
            if (!this.p.contains(SourceType.STE_SOURCE_TYPE_M3U8) && !SourceType.STE_SOURCE_TYPE_M3U8.equalsIgnoreCase(this.D)) {
                vo_osmp_src_format = VOOSMPType.VO_OSMP_SRC_FORMAT.VO_OSMP_SRC_AUTO_DETECT;
            } else {
                vo_osmp_src_format = VOOSMPType.VO_OSMP_SRC_FORMAT.VO_OSMP_SRC_FFSTREAMING_HLS;
            }
            LogEx.d("VisualonPlayer", "The open source format is " + vo_osmp_src_format);
            VOOSMPOpenParam vOOSMPOpenParam = new VOOSMPOpenParam();
            DecoderType decoderType = DecoderType.Decoder_SW;
            if (decoderType == this.A && decoderType == this.B) {
                vOOSMPOpenParam.setDecoderType(VOOSMPType.VO_OSMP_DECODER_TYPE.VO_OSMP_DEC_VIDEO_SW.getValue() | VOOSMPType.VO_OSMP_DECODER_TYPE.VO_OSMP_DEC_AUDIO_SW.getValue());
            } else {
                vOOSMPOpenParam.setDecoderType(VOOSMPType.VO_OSMP_DECODER_TYPE.VO_OSMP_DEC_VIDEO_MEDIACODEC.getValue() | VOOSMPType.VO_OSMP_DECODER_TYPE.VO_OSMP_DEC_AUDIO_SW.getValue());
            }
            VOOSMPType.VO_OSMP_SRC_FLAG vo_osmp_src_flag = VOOSMPType.VO_OSMP_SRC_FLAG.VO_OSMP_FLAG_SRC_OPEN_ASYNC;
            LogEx.d("VisualonPlayer", "The open source flag is " + vo_osmp_src_flag);
            com.video.androidsdk.player.common.c.a(c.a.OPEN_TIME);
            VOOSMPType.VO_OSMP_RETURN_CODE open = this.h.open(this.p, vo_osmp_src_flag, vo_osmp_src_format, vOOSMPOpenParam);
            com.video.androidsdk.player.common.c.b(c.a.OPEN_TIME);
            LogEx.d("VisualonPlayer", "The open url is : " + this.p);
            LogEx.d("VisualonPlayer", "The open returncode  is " + open);
            if (open == VOOSMPType.VO_OSMP_RETURN_CODE.VO_OSMP_ERR_NONE) {
                this.t = true;
                return;
            }
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onError("0X" + Integer.toHexString(open.getValue()), String.valueOf(1));
            }
        }
    }

    private void c() {
        if (this.w == null) {
            LogEx.d("VisualonPlayer", "add callback");
            this.w = new SurfaceCallBack();
            SurfaceHolder holder = this.q.getHolder();
            this.r = holder;
            holder.addCallback(this.w);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        VOCommonPlayer vOCommonPlayer;
        if (this.v || (vOCommonPlayer = this.h) == null) {
            return;
        }
        long position = vOCommonPlayer.getPosition();
        LogEx.d("VisualonPlayer", "currentPositon is " + position);
        LogEx.d("VisualonPlayer", "Duration is " + this.h.getDuration());
        IBasePlayer.OnEventListener onEventListener = this.f3307c;
        if (onEventListener != null) {
            onEventListener.onTime(position);
        }
    }

    protected void a() {
        LogEx.d("VisualonPlayer", "Create new instance of VOCommonPlayer");
        VOOSMPType.VO_OSMP_PLAYER_ENGINE vo_osmp_player_engine = VOOSMPType.VO_OSMP_PLAYER_ENGINE.VO_OSMP_VOME2_PLAYER;
        LogEx.d("VisualonPlayer", "The player engine type is " + vo_osmp_player_engine);
        LogEx.d("VisualonPlayer", "CreatePlayer Normally");
        com.video.androidsdk.player.common.c.a(c.a.INIT_TIME);
        String userNativeLibPath = CommonFunc.getUserNativeLibPath(this.m);
        VOOSMPInitParam vOOSMPInitParam = new VOOSMPInitParam();
        vOOSMPInitParam.setContext(this.m);
        vOOSMPInitParam.setLibraryPath(userNativeLibPath);
        VOCommonPlayerImpl vOCommonPlayerImpl = new VOCommonPlayerImpl();
        this.h = vOCommonPlayerImpl;
        if (vOCommonPlayerImpl.init(vo_osmp_player_engine, vOOSMPInitParam) == VOOSMPType.VO_OSMP_RETURN_CODE.VO_OSMP_ERR_NONE) {
            LogEx.d("VisualonPlayer", "MediaPlayer is initialized.");
        } else {
            LogEx.w("VisualonPlayer", "MediaPlayer is initialized failed!");
        }
        com.video.androidsdk.player.common.c.b(c.a.INIT_TIME);
        this.h.setOnEventListener(this.j);
        CommonFunc.copyfile(this.m, "cap.xml", "cap.xml");
        this.h.setDeviceCapabilityByFile(CommonFunc.getUserPath(this.m) + "/cap.xml");
        this.h.setLicenseContent(CommonFunc.readAsset(this.m, "voVidDec.dat"));
        String version = this.h.getVersion(VOOSMPType.VO_OSMP_MODULE_TYPE.VO_OSMP_MODULE_TYPE_SDK);
        String version2 = this.h.getVersion(VOOSMPType.VO_OSMP_MODULE_TYPE.VO_OSMP_MODULE_TYPE_DRM_VENDOR_A);
        LogEx.d("VisualonPlayer", "visualon player version == " + version);
        LogEx.d("VisualonPlayer", "verimatrix version == " + version2);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void seek(long j, long j2) {
        LogEx.d("VisualonPlayer", "VisualonPlayer seek to ---  " + j);
        if (this.h != null) {
            com.video.androidsdk.player.common.c.a(c.a.SEEK_TIME);
            this.h.setPosition(j);
            com.video.androidsdk.player.common.c.b(c.a.SEEK_TIME);
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(10);
            }
        }
    }

    @Override // com.video.androidsdk.player.a
    public void openInternal(String str, int i) {
        LogEx.d("VisualonPlayer", "VisualonPlayer open.");
        this.p = str;
        if (TextUtils.isEmpty(str)) {
            LogEx.w("VisualonPlayer", "player url is null");
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(-1);
                return;
            }
            return;
        }
        if (this.h != null) {
            this.i.sendEmptyMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, Object obj) {
        String str = "[APP][EVENT]Received adaptive streaming warning event, param1 is ";
        if (i == 1) {
            str = "[APP][EVENT]Received adaptive streaming warning event, param1 is 1, chunk download failed";
        } else if (i == 2) {
            str = "[APP][EVENT]Received adaptive streaming warning event, param1 is 2, chunk format not supported";
        } else if (i != 3) {
            if (i == 4) {
                str = "[APP][EVENT]Received adaptive streaming warning event, param1 is 4, playlist download failed";
            }
        } else if (obj != null && (obj instanceof VOOSMPChunkInfo)) {
            str = "[APP][EVENT]Received adaptive streaming warning event, param1 is 3, DRM error, error code:" + ((VOOSMPChunkInfo) obj).getErrorCode();
        }
        LogEx.w("VisualonPlayer", str);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void seek(long j, long j2, long j3) {
        LogEx.d("VisualonPlayer", "VisualonPlayer seek to ---  " + j);
        VOCommonPlayer vOCommonPlayer = this.h;
        if (vOCommonPlayer != null) {
            String version = vOCommonPlayer.getVersion(VOOSMPType.VO_OSMP_MODULE_TYPE.VO_OSMP_MODULE_TYPE_SDK);
            LogEx.d("VisualonPlayer", "Build Release: V" + version + "  API3");
            if (!TextUtils.isEmpty(version)) {
                String substring = version.substring(0, version.indexOf("-"));
                LogEx.d("VisualonPlayer", "Version is === " + substring);
                if (!TextUtils.isEmpty(substring)) {
                    String[] split = substring.split("\\.");
                    com.video.androidsdk.player.common.c.a(c.a.SEEK_TIME);
                    if (Integer.parseInt(split[0]) <= 3 && (3 != Integer.parseInt(split[0]) || Integer.parseInt(split[1]) <= 21)) {
                        LogEx.d("VisualonPlayer", "seek to negative value");
                        this.h.setPosition(j - j2);
                    } else {
                        LogEx.d("VisualonPlayer", "seek to positive value");
                        this.h.setPosition(j);
                    }
                } else {
                    LogEx.d("VisualonPlayer", "seek to negative value");
                    this.h.setPosition(j - j2);
                }
            } else {
                LogEx.d("VisualonPlayer", "seek to negative value");
                this.h.setPosition(j - j2);
            }
            com.video.androidsdk.player.common.c.b(c.a.SEEK_TIME);
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        LogEx.w("VisualonPlayer", "onError, errcode is  " + str);
        this.v = true;
        IBasePlayer.OnEventListener onEventListener = this.f3307c;
        if (onEventListener != null) {
            onEventListener.onError(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Object obj) {
        if (obj == null) {
            LogEx.w("VisualonPlayer", "null == obj");
            return;
        }
        if (i == VOCommonPlayerListener.VO_OSMP_SRC_ADAPTIVE_STREAMING_INFO_EVENT.VO_OSMP_SRC_ADAPTIVE_STREAMING_INFO_EVENT_PLAYLIST_DOWNLOADOK.getValue()) {
            if (!(obj instanceof VOOSMPPlaylistData)) {
                LogEx.w("VisualonPlayer", "obj is not VOOSMPPlaylistData instance");
                return;
            }
            VOOSMPPlaylistData vOOSMPPlaylistData = (VOOSMPPlaylistData) obj;
            String str = new String(vOOSMPPlaylistData.getData());
            try {
                str = new String(Base64.decode(str, 0));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (str.length() > 50) {
                str = str.substring(0, 50) + "... (truncated)";
            }
            LogEx.d("VisualonPlayer", String.format("7, playlist download ok: RootUrl=%s, NewUrl=%s, Url=%s, Data=%s, DataSize=%d, PlayListType=%s, ErrorCode=%x", vOOSMPPlaylistData.getRootUrl(), vOOSMPPlaylistData.getNewUrl(), vOOSMPPlaylistData.getUrl(), str, Integer.valueOf(vOOSMPPlaylistData.getDataSize()), vOOSMPPlaylistData.getPlaylistType(), Integer.valueOf(vOOSMPPlaylistData.getErrorCode())));
        }
        if (i == VOCommonPlayerListener.VO_OSMP_SRC_ADAPTIVE_STREAMING_INFO_EVENT.VO_OSMP_SRC_ADAPTIVE_STREAMING_INFO_EVENT_SESSION_DATA.getValue()) {
            if (!(obj instanceof VOOSMPSessionData)) {
                LogEx.w("VisualonPlayer", "obj is not VOOSMPSessionData instance");
                return;
            }
            VOOSMPSessionData vOOSMPSessionData = (VOOSMPSessionData) obj;
            StringBuilder sb = new StringBuilder("D, session data: ");
            sb.append("{");
            for (int i2 = 0; i2 < vOOSMPSessionData.getCount(); i2++) {
                sb.append(" [");
                sb.append(String.format("Index=%d, DataID=%s, Value=%s, URI=%s, Language=%s", Integer.valueOf(i2), vOOSMPSessionData.getDataID(i2), vOOSMPSessionData.getValue(i2), vOOSMPSessionData.getURI(i2), vOOSMPSessionData.getLanguage(i2)));
                sb.append("] ");
            }
            sb.append("}");
            LogEx.d("VisualonPlayer", sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("1, playlist parsing failed");
        arrayList.add("2, playlist not supported");
        arrayList.add("3, stream not supported");
        arrayList.add("4, download failed");
        arrayList.add("5, DRM error");
        arrayList.add("6, license error");
        String str = "[player_error][APP][EVENT]Received adaptive streaming error event, param1 is ";
        if (i <= arrayList.size() && i > 0) {
            str = "[player_error][APP][EVENT]Received adaptive streaming error event, param1 is " + ((String) arrayList.get(i - 1));
        }
        LogEx.e("VisualonPlayer", str);
        return str;
    }
}
