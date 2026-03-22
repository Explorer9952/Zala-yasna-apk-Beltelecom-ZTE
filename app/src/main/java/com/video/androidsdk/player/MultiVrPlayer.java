package com.video.androidsdk.player;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
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
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import com.render.vrlib.MDVRLibrary;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.common.AssetStatus;
import com.video.androidsdk.player.common.AssetType;
import com.video.androidsdk.player.common.DecoderType;
import com.video.androidsdk.player.common.PlayerConstants;
import com.video.androidsdk.player.common.SubtitleHorizontal;
import com.video.androidsdk.player.common.SubtitleVertical;
import com.video.androidsdk.player.common.c;
import com.video.androidsdk.player.render.IRender;
import com.video.androidsdk.player.render.RenderImpl;
import ijk.media.player.IMediaPlayer;
import ijk.media.player.IjkMediaPlayer;
import ijk.media.player.misc.IMediaFormat;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public class MultiVrPlayer extends a {
    private static int p = 10;
    public static final int sMultiScreenSize = 2;
    private Surface A;
    private RelativeLayout B;
    private float D;
    private int J;
    private com.video.androidsdk.player.a.a N;
    private IRender.OnBulletTimeStateListener Q;
    private SetFadingVolumeThread S;
    private View s;
    private AudioManager y;
    private OnZTEMultiVrPlayerEventListener z;
    private IjkMediaPlayer q = null;
    private String r = null;
    private boolean t = false;
    protected boolean h = false;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private boolean C = false;
    private long E = 0;
    private SparseArray<Integer> F = new SparseArray<>();
    private SparseArray<Integer> G = new SparseArray<>();
    private SparseArray<Integer> H = new SparseArray<>();
    private ArrayList<com.video.androidsdk.player.a.b> I = new ArrayList<>();
    ArrayList<String> i = new ArrayList<>();
    ArrayList<String> j = new ArrayList<>();
    private int K = 1;
    private boolean L = false;
    private int M = 0;
    private int O = 0;
    private boolean P = false;
    private int R = 0;
    protected Handler k = new Handler() { // from class: com.video.androidsdk.player.MultiVrPlayer.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 2) {
                MultiVrPlayer.this.b();
                sendEmptyMessageDelayed(2, 1000L);
                return;
            }
            if (i != 3) {
                if (i != 4) {
                    LogEx.w("MultiVrPlayer", "unkown msg");
                    return;
                }
                Object obj = message.obj;
                if (obj == null) {
                    obj = false;
                }
                boolean booleanValue = ((Boolean) obj).booleanValue();
                LogEx.d("MultiVrPlayer", "isShow is " + booleanValue);
                MultiVrPlayer.this.a(booleanValue);
                return;
            }
            if (MultiVrPlayer.this.t) {
                LogEx.d("MultiVrPlayer", "MSG_RESUME 1");
                if (MultiVrPlayer.this.q != null && MultiVrPlayer.this.h) {
                    LogEx.d("MultiVrPlayer", "MSG_RESUME 2");
                    LogEx.d("MultiVrPlayer", "mIjkMediaPlayer.start()");
                    MultiVrPlayer.this.q.start();
                    ((com.video.androidsdk.player.a.b) MultiVrPlayer.this.I.get(MultiVrPlayer.this.J)).a(3);
                    LogEx.d("MultiVrPlayer", "send msg to updateUI ");
                    removeMessages(2);
                    sendEmptyMessage(2);
                }
                MultiVrPlayer.this.u = false;
                return;
            }
            LogEx.d("MultiVrPlayer", "MSG_RESUME 3");
            sendEmptyMessageDelayed(3, 200L);
        }
    };
    private Handler T = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class MyPlayerOnBufferingUpdateListener implements IMediaPlayer.a {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<MultiVrPlayer> f3271a;

        public MyPlayerOnBufferingUpdateListener(MultiVrPlayer multiVrPlayer) {
            this.f3271a = new WeakReference<>(multiVrPlayer);
        }

        @Override // ijk.media.player.IMediaPlayer.a
        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class MyPlayerOnCompletionListener implements IMediaPlayer.b {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<MultiVrPlayer> f3272a;

        public MyPlayerOnCompletionListener(MultiVrPlayer multiVrPlayer) {
            this.f3272a = new WeakReference<>(multiVrPlayer);
        }

        @Override // ijk.media.player.IMediaPlayer.b
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            MultiVrPlayer multiVrPlayer = this.f3272a.get();
            if (multiVrPlayer != null && multiVrPlayer.z != null && multiVrPlayer.I != null && multiVrPlayer.I.size() > 0) {
                LogEx.d("MultiVrPlayer", "onCompletion called");
                ((com.video.androidsdk.player.a.b) multiVrPlayer.I.get(multiVrPlayer.a(iMediaPlayer))).a(5);
                multiVrPlayer.z.onStateChanged(multiVrPlayer.a(iMediaPlayer), 5);
                return;
            }
            LogEx.w("MultiVrPlayer", "null == player || null == player.monEventListener");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class MyPlayerOnErrorListener implements IMediaPlayer.c {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<MultiVrPlayer> f3273a;

        public MyPlayerOnErrorListener(MultiVrPlayer multiVrPlayer) {
            this.f3273a = new WeakReference<>(multiVrPlayer);
        }

        @Override // ijk.media.player.IMediaPlayer.c
        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            LogEx.w("MultiVrPlayer", "onError called");
            LogEx.w("MultiVrPlayer", "framework_err： " + i + ";  impl_err: " + i2);
            String str = i == 200 ? "VideoView_error_text_invalid_progressive_playback" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            MultiVrPlayer multiVrPlayer = this.f3273a.get();
            if (multiVrPlayer != null && multiVrPlayer.z != null && multiVrPlayer.I != null && multiVrPlayer.I.size() > 0) {
                multiVrPlayer.z.onError(multiVrPlayer.a(iMediaPlayer), String.valueOf(i), str);
                int a2 = multiVrPlayer.a(iMediaPlayer);
                LogEx.w("MultiVrPlayer", "onError , player " + a2);
                ((com.video.androidsdk.player.a.b) multiVrPlayer.I.get(a2)).a(true);
                ((com.video.androidsdk.player.a.b) multiVrPlayer.I.get(a2)).a(-1);
                if (a2 == multiVrPlayer.O) {
                    multiVrPlayer.e();
                }
                return false;
            }
            LogEx.w("MultiVrPlayer", "null == player || null == player.monEventListener");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class MyPlayerOnInfoListener implements IMediaPlayer.d {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<MultiVrPlayer> f3274a;

        public MyPlayerOnInfoListener(MultiVrPlayer multiVrPlayer) {
            this.f3274a = new WeakReference<>(multiVrPlayer);
        }

        @Override // ijk.media.player.IMediaPlayer.d
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            MultiVrPlayer multiVrPlayer = this.f3274a.get();
            if (multiVrPlayer == null || multiVrPlayer.z == null || multiVrPlayer.I == null || multiVrPlayer.I.size() <= 0) {
                LogEx.w("MultiVrPlayer", "null == player || null == player.monEventListener");
                return false;
            }
            if (i == 3) {
                LogEx.d("MultiVrPlayer", "MEDIA_INFO_VIDEO_RENDERING_START:");
                multiVrPlayer.z.onStateChanged(multiVrPlayer.a(iMediaPlayer), 12);
                int a2 = multiVrPlayer.a(iMediaPlayer);
                ((com.video.androidsdk.player.a.b) multiVrPlayer.I.get(a2)).f3314b = true;
                LogEx.d("MultiVrPlayer", "player[" + a2 + "] is rendered");
                multiVrPlayer.k.removeMessages(2);
                multiVrPlayer.k.sendEmptyMessage(2);
            } else if (i == 10008) {
                LogEx.d("MultiVrPlayer", "MEDIA_INFO_VIDEO_SEEK_RENDERING_START:");
                int a3 = multiVrPlayer.a(iMediaPlayer);
                if (a3 != multiVrPlayer.J && !((com.video.androidsdk.player.a.b) multiVrPlayer.I.get(a3)).d()) {
                    iMediaPlayer.pause();
                }
            } else if (i == 901) {
                LogEx.d("MultiVrPlayer", "MEDIA_INFO_UNSUPPORTED_SUBTITLE:");
            } else if (i == 902) {
                LogEx.d("MultiVrPlayer", "MEDIA_INFO_SUBTITLE_TIMED_OUT:");
            } else if (i == 10001) {
                LogEx.d("MultiVrPlayer", "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i2);
            } else if (i != 10002) {
                switch (i) {
                    case IMediaPlayer.MEDIA_INFO_VIDEO_TRACK_LAGGING /* 700 */:
                        LogEx.d("MultiVrPlayer", "MEDIA_INFO_VIDEO_TRACK_LAGGING:");
                        break;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                        LogEx.d("MultiVrPlayer", "MEDIA_INFO_BUFFERING_START:");
                        multiVrPlayer.z.onStateChanged(multiVrPlayer.a(iMediaPlayer), 7);
                        break;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                        LogEx.d("MultiVrPlayer", "MEDIA_INFO_BUFFERING_END:");
                        multiVrPlayer.z.onStateChanged(multiVrPlayer.a(iMediaPlayer), 9);
                        break;
                    case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                        LogEx.d("MultiVrPlayer", "MEDIA_INFO_NETWORK_BANDWIDTH: " + i2);
                        break;
                    default:
                        switch (i) {
                            case 800:
                                LogEx.d("MultiVrPlayer", "MEDIA_INFO_BAD_INTERLEAVING:");
                                break;
                            case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                                LogEx.d("MultiVrPlayer", "MEDIA_INFO_NOT_SEEKABLE:");
                                break;
                            case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /* 802 */:
                                LogEx.d("MultiVrPlayer", "MEDIA_INFO_METADATA_UPDATE:");
                                break;
                        }
                }
            } else {
                LogEx.d("MultiVrPlayer", "MEDIA_INFO_AUDIO_RENDERING_START:");
                multiVrPlayer.z.onStateChanged(multiVrPlayer.a(iMediaPlayer), 9);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class MyPlayerOnPreparedListener implements IMediaPlayer.e {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<MultiVrPlayer> f3275a;

        public MyPlayerOnPreparedListener(MultiVrPlayer multiVrPlayer) {
            this.f3275a = new WeakReference<>(multiVrPlayer);
        }

        @Override // ijk.media.player.IMediaPlayer.e
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            LogEx.d("MultiVrPlayer", "onPrepared called");
            MultiVrPlayer multiVrPlayer = this.f3275a.get();
            if (multiVrPlayer != null && multiVrPlayer.z != null && multiVrPlayer.I != null && multiVrPlayer.I.size() > 0) {
                if (((RenderImpl) multiVrPlayer).l != null) {
                    ((RenderImpl) multiVrPlayer).l.l();
                }
                int a2 = multiVrPlayer.a(iMediaPlayer);
                if (multiVrPlayer.J == a2) {
                    multiVrPlayer.z.onStateChanged(a2, 2);
                    ((com.video.androidsdk.player.a.b) multiVrPlayer.I.get(a2)).a(2);
                } else {
                    iMediaPlayer.start();
                    ((com.video.androidsdk.player.a.b) multiVrPlayer.I.get(a2)).a(3);
                }
                LogEx.d("MultiVrPlayer", "player[" + a2 + "] is onPrepared");
                return;
            }
            LogEx.w("MultiVrPlayer", "null == player || null == player.monEventListener");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class MyPlayerOnSeekCompleteListener implements IMediaPlayer.f {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<MultiVrPlayer> f3276a;

        public MyPlayerOnSeekCompleteListener(MultiVrPlayer multiVrPlayer) {
            this.f3276a = new WeakReference<>(multiVrPlayer);
        }

        @Override // ijk.media.player.IMediaPlayer.f
        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            LogEx.d("MultiVrPlayer", "onSeekComplete called");
            MultiVrPlayer multiVrPlayer = this.f3276a.get();
            if (multiVrPlayer != null && multiVrPlayer.z != null && multiVrPlayer.I != null && multiVrPlayer.I.size() > 0) {
                int a2 = multiVrPlayer.a(iMediaPlayer);
                if (4 == ((com.video.androidsdk.player.a.b) multiVrPlayer.I.get(a2)).e()) {
                    return;
                }
                multiVrPlayer.z.onStateChanged(a2, 11);
                iMediaPlayer.start();
                if (((RenderImpl) multiVrPlayer).l != null) {
                    ((RenderImpl) multiVrPlayer).l.c(((RenderImpl) multiVrPlayer).m);
                }
                ((com.video.androidsdk.player.a.b) multiVrPlayer.I.get(a2)).a(3);
                return;
            }
            LogEx.w("MultiVrPlayer", "null == player || null == player.monEventListener");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class MyPlayerOnVideoSizeChangedListener implements IMediaPlayer.i {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<MultiVrPlayer> f3277a;

        public MyPlayerOnVideoSizeChangedListener(MultiVrPlayer multiVrPlayer) {
            this.f3277a = new WeakReference<>(multiVrPlayer);
        }

        @Override // ijk.media.player.IMediaPlayer.i
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            MultiVrPlayer multiVrPlayer = this.f3277a.get();
            if (multiVrPlayer != null) {
                if (multiVrPlayer.J != multiVrPlayer.a(iMediaPlayer) || ((RenderImpl) multiVrPlayer).l == null) {
                    return;
                }
                ((RenderImpl) multiVrPlayer).l.a(i, i2);
                return;
            }
            LogEx.w("MultiVrPlayer", "null == player || null == player.monEventListener");
        }
    }

    /* loaded from: classes.dex */
    public interface OnZTEMultiVrPlayerEventListener {
        void onBufferingUpdate(int i, int i2);

        void onError(int i, String str, String str2);

        void onStateChanged(int i, int i2);

        void onTime(int i, long j);
    }

    /* loaded from: classes.dex */
    public class SetFadingVolumeThread extends Thread {

        /* renamed from: b, reason: collision with root package name */
        private boolean f3279b = false;

        public SetFadingVolumeThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                if (this.f3279b) {
                    MultiVrPlayer.this.q.setFadingVolume(1.0f, 500L);
                    this.f3279b = false;
                }
            }
        }

        public void setSuspend(boolean z) {
            this.f3279b = z;
        }
    }

    public MultiVrPlayer(Context context, Bundle bundle) {
        this.m = context;
        if (bundle != null) {
            this.o = bundle.getInt(PlayerConstants.STR_VIDEO_COUNT);
            p = bundle.getInt(PlayerConstants.STR_PLAYER_MAXCOUNT);
            LogEx.d("MultiVrPlayer", "there are " + this.o + "players");
        }
        int i = this.o;
        if (i == 1) {
            LogEx.d("MultiVrPlayer", "Please enter more than one url !");
            return;
        }
        if (i > p) {
            LogEx.d("MultiVrPlayer", "Enter more than 4 urls, just play the first 4 urls !");
            this.o = p;
        }
        for (int i2 = 0; i2 < this.o; i2++) {
            a(i2);
        }
        SetFadingVolumeThread setFadingVolumeThread = new SetFadingVolumeThread();
        this.S = setFadingVolumeThread;
        setFadingVolumeThread.start();
    }

    static /* synthetic */ int p(MultiVrPlayer multiVrPlayer) {
        int i = multiVrPlayer.J;
        multiVrPlayer.J = i - 1;
        return i;
    }

    static /* synthetic */ int q(MultiVrPlayer multiVrPlayer) {
        int i = multiVrPlayer.J;
        multiVrPlayer.J = i + 1;
        return i;
    }

    public void activeTouch() {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.a();
        }
    }

    public int addPlayerToHead(String str, boolean z) {
        com.render.vrlib.a.g b2;
        Surface surface;
        boolean z2;
        LogEx.d("MultiVrPlayer", "addPlayerToHead start");
        int i = this.o;
        if (i < p) {
            this.o = i + 1;
            this.J++;
            b2 = this.l.b();
            surface = b2 != null ? new Surface(b2.b()) : null;
            z2 = true;
        } else {
            int i2 = this.J + 1;
            this.J = i2;
            if (i2 >= i) {
                int i3 = i - 1;
                this.J = i3;
                setPlayerId(i3);
            }
            b2 = this.I.get(this.o - 1).b();
            surface = new Surface(b2.b());
            e(this.o - 1);
            z2 = false;
        }
        a(0);
        IjkMediaPlayer d2 = d(0);
        if (d2 != null) {
            d2.setSurface(surface);
        }
        a(0, str, z);
        this.I.get(0).a(b2);
        if (z2) {
            c(this.o - 1);
        }
        LogEx.d("MultiVrPlayer", "addPlayerToHead  end");
        return 0;
    }

    public int addPlayerToTail(String str, boolean z) {
        com.render.vrlib.a.g b2;
        Surface surface;
        boolean z2;
        int i = this.o;
        if (i < p - 1) {
            this.o = i + 1;
            b2 = this.l.b();
            surface = b2 != null ? new Surface(b2.b()) : null;
            z2 = true;
        } else {
            int i2 = this.J - 1;
            this.J = i2;
            if (i2 < 0) {
                this.J = 0;
                setPlayerId(0);
            }
            b2 = this.I.get(0).b();
            surface = new Surface(b2.b());
            e(0);
            z2 = false;
        }
        a(this.o - 1);
        IjkMediaPlayer d2 = d(this.o - 1);
        if (d2 != null) {
            d2.setSurface(surface);
        }
        a(this.o - 1, str, z);
        this.I.get(this.o - 1).a(b2);
        if (z2) {
            c(this.o - 1);
        }
        LogEx.d("MultiVrPlayer", "addPlayerToTail");
        return 0;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean closeSensor() {
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void enableCardBoardVideo(boolean z) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary == null) {
            LogEx.d("MultiVrPlayer", "mMDVRLibrary is null ");
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
        if (this.q != null) {
            if (assetType == AssetType.Asset_Video) {
                if (this.F.size() == 0) {
                    ijk.media.player.misc.k[] trackInfo = this.q.getTrackInfo();
                    int i2 = 0;
                    while (i < trackInfo.length) {
                        ijk.media.player.misc.k kVar = trackInfo[i];
                        if (kVar.getTrackType() == 1 && kVar.getFormat() != null) {
                            this.F.put(i2, Integer.valueOf(i));
                            i2++;
                        }
                        i++;
                    }
                }
                return this.F.size();
            }
            if (assetType == AssetType.Asset_Audio) {
                if (this.G.size() == 0) {
                    ijk.media.player.misc.k[] trackInfo2 = this.q.getTrackInfo();
                    int i3 = 0;
                    while (i < trackInfo2.length) {
                        if (trackInfo2[i].getTrackType() == 2) {
                            this.G.put(i3, Integer.valueOf(i));
                            i3++;
                        }
                        i++;
                    }
                }
                return this.G.size();
            }
            if (assetType == AssetType.Asset_Subtitle) {
                if (this.H.size() == 0) {
                    ijk.media.player.misc.k[] trackInfo3 = this.q.getTrackInfo();
                    int i4 = 0;
                    while (i < trackInfo3.length) {
                        if (trackInfo3[i].getTrackType() == 4) {
                            this.H.put(i4, Integer.valueOf(i));
                            i4++;
                        }
                        i++;
                    }
                }
                return this.H.size();
            }
        }
        return 0;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getAssetIndex(AssetType assetType, AssetStatus assetStatus) {
        int i = -1;
        if (this.q != null) {
            int i2 = 0;
            if (assetType == AssetType.Asset_Video) {
                if (this.F.size() == 0) {
                    ijk.media.player.misc.k[] trackInfo = this.q.getTrackInfo();
                    int i3 = 0;
                    while (i2 < trackInfo.length) {
                        ijk.media.player.misc.k kVar = trackInfo[i2];
                        if (kVar.getTrackType() == 1 && kVar.getFormat() != null) {
                            this.F.put(i3, Integer.valueOf(i2));
                            i3++;
                        }
                        i2++;
                    }
                }
                int selectedTrack = this.q.getSelectedTrack(1);
                LogEx.d("MultiVrPlayer", "track type is video ,track index in stream is  " + selectedTrack);
                if (selectedTrack >= 0 && this.F.indexOfValue(Integer.valueOf(selectedTrack)) != -1) {
                    i = this.F.indexOfValue(Integer.valueOf(selectedTrack));
                }
            } else if (assetType == AssetType.Asset_Audio) {
                if (this.G.size() == 0) {
                    ijk.media.player.misc.k[] trackInfo2 = this.q.getTrackInfo();
                    int i4 = 0;
                    while (i2 < trackInfo2.length) {
                        if (trackInfo2[i2].getTrackType() == 2) {
                            this.G.put(i4, Integer.valueOf(i2));
                            i4++;
                        }
                        i2++;
                    }
                }
                int selectedTrack2 = this.q.getSelectedTrack(2);
                LogEx.d("MultiVrPlayer", "track type is audio ,track index in stream is  " + selectedTrack2);
                if (selectedTrack2 >= 0 && this.G.indexOfValue(Integer.valueOf(selectedTrack2)) != -1) {
                    i = this.G.indexOfValue(Integer.valueOf(selectedTrack2));
                }
            } else if (assetType == AssetType.Asset_Subtitle) {
                LogEx.d("MultiVrPlayer", "track type is subitle");
                if (this.H.size() == 0) {
                    ijk.media.player.misc.k[] trackInfo3 = this.q.getTrackInfo();
                    int i5 = 0;
                    while (i2 < trackInfo3.length) {
                        if (trackInfo3[i2].getTrackType() == 4) {
                            this.H.put(i5, Integer.valueOf(i2));
                            i5++;
                        }
                        i2++;
                    }
                }
                int selectedTrack3 = this.q.getSelectedTrack(4);
                if (selectedTrack3 >= 0 && this.H.indexOfValue(Integer.valueOf(selectedTrack3)) != -1) {
                    i = this.H.indexOfValue(Integer.valueOf(selectedTrack3));
                }
            }
        }
        LogEx.d("MultiVrPlayer", "selected index is " + i);
        return i;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getAudioInfoArray(ArrayList<String> arrayList) {
        ijk.media.player.misc.k[] trackInfo;
        IjkMediaPlayer ijkMediaPlayer = this.q;
        if (ijkMediaPlayer == null || (trackInfo = ijkMediaPlayer.getTrackInfo()) == null) {
            return;
        }
        if (this.G == null) {
            this.G = new SparseArray<>();
        }
        this.G.clear();
        int i = 0;
        for (int i2 = 0; i2 < trackInfo.length; i2++) {
            ijk.media.player.misc.k kVar = trackInfo[i2];
            if (kVar.getTrackType() == 2) {
                String language = kVar.getLanguage();
                LogEx.d("MultiVrPlayer", "trackInfo is " + kVar);
                arrayList.add(language + "," + i2);
                this.G.put(i, Integer.valueOf(i2));
                i++;
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getBufferedPosition() {
        IjkMediaPlayer ijkMediaPlayer = this.q;
        if (ijkMediaPlayer == null) {
            return 0L;
        }
        long videoCachedDuration = ijkMediaPlayer.getVideoCachedDuration();
        LogEx.d("MultiVrPlayer", "IjkPlayer Position  is  " + videoCachedDuration);
        return videoCachedDuration;
    }

    public int getCount() {
        return this.o;
    }

    public int getCurPlayerId() {
        return this.J;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getCurrentPosition() {
        if (this.q == null || !a()) {
            return 0L;
        }
        long currentPosition = this.q.getCurrentPosition();
        LogEx.d("MultiVrPlayer", "Position  is  " + currentPosition);
        return currentPosition;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getDuration() {
        if (this.q == null || !a()) {
            return -1L;
        }
        long duration = this.q.getDuration();
        LogEx.d("MultiVrPlayer", "duration  is  " + duration);
        if (duration < 0) {
            return 0L;
        }
        return duration;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getPlayerState() {
        return this.I.get(this.J).e();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public float getSphericalViewSensorRoll() {
        return 0.0f;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getSubtitleInfoArray(ArrayList<String> arrayList) {
        ijk.media.player.misc.k[] trackInfo;
        IjkMediaPlayer ijkMediaPlayer = this.q;
        if (ijkMediaPlayer == null || (trackInfo = ijkMediaPlayer.getTrackInfo()) == null) {
            return;
        }
        if (this.H == null) {
            this.H = new SparseArray<>();
        }
        this.H.clear();
        int i = 0;
        for (int i2 = 0; i2 < trackInfo.length; i2++) {
            ijk.media.player.misc.k kVar = trackInfo[i2];
            if (kVar.getTrackType() == 4) {
                String language = kVar.getLanguage();
                LogEx.d("MultiVrPlayer", "subtitile is " + language);
                arrayList.add(language + "," + i2);
                this.H.put(i, Integer.valueOf(i2));
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
        IjkMediaPlayer ijkMediaPlayer = this.q;
        if (ijkMediaPlayer == null) {
            return 0L;
        }
        long currentPosition = ijkMediaPlayer.getCurrentPosition();
        LogEx.d("MultiVrPlayer", "IjkPlayer Position  is  " + currentPosition);
        long j = this.E + currentPosition;
        LogEx.d("MultiVrPlayer", "IjkPlayer iUTCPosition  is  " + j);
        return j;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getVideoHeight() {
        if (this.q == null || !a()) {
            return 0;
        }
        int videoHeight = this.q.getVideoHeight();
        LogEx.d("MultiVrPlayer", "VideoHeight  is  " + videoHeight);
        if (videoHeight < 0) {
            return 0;
        }
        return videoHeight;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getVideoInfoArray(ArrayList<String> arrayList) {
        ijk.media.player.misc.k[] trackInfo;
        IMediaFormat format;
        IjkMediaPlayer ijkMediaPlayer = this.q;
        if (ijkMediaPlayer == null || (trackInfo = ijkMediaPlayer.getTrackInfo()) == null) {
            return;
        }
        if (this.F == null) {
            this.F = new SparseArray<>();
        }
        this.F.clear();
        int i = 0;
        for (int i2 = 0; i2 < trackInfo.length; i2++) {
            ijk.media.player.misc.k kVar = trackInfo[i2];
            if (kVar.getTrackType() == 1 && (format = kVar.getFormat()) != null) {
                LogEx.d("MultiVrPlayer", "format is " + format.getInteger("bitrate"));
                arrayList.add(String.format(Locale.US, "%.2fMbit", Float.valueOf(((float) format.getInteger("bitrate")) / 1000000.0f)) + "," + i2);
                this.F.put(i, Integer.valueOf(i2));
                i++;
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getVideoWidth() {
        if (this.q == null || !a()) {
            return 0;
        }
        int videoWidth = this.q.getVideoWidth();
        LogEx.d("MultiVrPlayer", "IjkPlayer VideoWidth  is  " + videoWidth);
        if (videoWidth < 0) {
            return 0;
        }
        return videoWidth;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public float getVolume() {
        if (this.q == null) {
            return 0.0f;
        }
        LogEx.d("MultiVrPlayer", "getVolume");
        float volume = this.q.getVolume();
        LogEx.d("MultiVrPlayer", "Volume is " + volume);
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
        LogEx.d("MultiVrPlayer", "start init");
        if (relativeLayout == null) {
            LogEx.d("MultiVrPlayer", "layout is null, return");
            return;
        }
        this.B = relativeLayout;
        relativeLayout.removeAllViews();
        this.y = (AudioManager) this.m.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        a(this.B);
        LogEx.d("MultiVrPlayer", " init end");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean isPlaying() {
        IjkMediaPlayer ijkMediaPlayer = this.q;
        if (ijkMediaPlayer == null) {
            return false;
        }
        boolean isPlaying = ijkMediaPlayer.isPlaying();
        LogEx.d("MultiVrPlayer", " status  is  " + isPlaying);
        return isPlaying;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean isTrackAvailable(AssetType assetType, int i) {
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void mute() {
        if (this.q != null) {
            LogEx.d("MultiVrPlayer", "mVolume is " + this.D);
            this.D = this.q.getVolume();
            this.q.setVolume(0.0f, 0.0f);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void open(String str) {
        this.r = str;
        LogEx.d("MultiVrPlayer", "mPath is " + this.r);
        if (TextUtils.isEmpty(this.r)) {
            return;
        }
        try {
            this.q.setDataSource(b(this.r));
            if (this.r.contains("rtsp://")) {
                this.K = 0;
            } else if (this.r.contains("rtmp://")) {
                this.K = 2;
            } else {
                this.K = 1;
            }
            a(this.q, this.K);
            this.q.setAudioStreamType(3);
            this.q.prepareAsync();
            LogEx.d("MultiVrPlayer", "prepareAsync");
            this.I.get(this.J).a(1);
        } catch (IOException e) {
            LogEx.w("MultiVrPlayer", "Unable to open content: " + this.r);
            this.I.get(this.J).a(-1);
            OnZTEMultiVrPlayerEventListener onZTEMultiVrPlayerEventListener = this.z;
            if (onZTEMultiVrPlayerEventListener != null) {
                onZTEMultiVrPlayerEventListener.onError(this.J, String.valueOf(1), "Unable to open content");
            }
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            LogEx.w("MultiVrPlayer", "Unable to open content: " + this.r);
            this.I.get(this.J).a(-1);
            OnZTEMultiVrPlayerEventListener onZTEMultiVrPlayerEventListener2 = this.z;
            if (onZTEMultiVrPlayerEventListener2 != null) {
                onZTEMultiVrPlayerEventListener2.onError(this.J, String.valueOf(1), "Unable to open content");
            }
            e2.printStackTrace();
        } catch (IllegalStateException e3) {
            LogEx.w("MultiVrPlayer", "Unable to open content: " + this.r);
            this.I.get(this.J).a(-1);
            OnZTEMultiVrPlayerEventListener onZTEMultiVrPlayerEventListener3 = this.z;
            if (onZTEMultiVrPlayerEventListener3 != null) {
                onZTEMultiVrPlayerEventListener3.onError(this.J, String.valueOf(1), "Unable to open content");
            }
            e3.printStackTrace();
        }
        this.v = true;
    }

    @Override // com.video.androidsdk.player.a
    public void openInternal(String str) {
    }

    @Override // com.video.androidsdk.player.a
    public void openInternal(String str, int i) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean openSensor() {
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void pause() {
        IjkMediaPlayer ijkMediaPlayer;
        LogEx.d("MultiVrPlayer", " pause().");
        if (a() && (ijkMediaPlayer = this.q) != null && ijkMediaPlayer.isPlaying()) {
            LogEx.d("MultiVrPlayer", "The player status is " + this.q.isPlaying());
            com.video.androidsdk.player.common.c.a(c.a.PAUSE_TIME);
            this.q.pause();
            MDVRLibrary mDVRLibrary = this.l;
            if (mDVRLibrary != null) {
                mDVRLibrary.b(this.m);
            }
            com.video.androidsdk.player.common.c.b(c.a.PAUSE_TIME);
            this.I.get(this.J).a(4);
            return;
        }
        LogEx.e("MultiVrPlayer", "player status is error");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void release() {
        LogEx.d("MultiVrPlayer", "IjkPlayer release(). ");
        RelativeLayout relativeLayout = this.B;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        if (this.I != null) {
            onRenderDestory();
            Iterator<com.video.androidsdk.player.a.b> it2 = this.I.iterator();
            while (it2.hasNext()) {
                com.video.androidsdk.player.a.b next = it2.next();
                if (next != null) {
                    next.g();
                }
            }
            this.q = null;
            this.w = true;
            this.k.removeCallbacksAndMessages(null);
            SetFadingVolumeThread setFadingVolumeThread = this.S;
            if (setFadingVolumeThread != null) {
                setFadingVolumeThread.setSuspend(false);
                this.S.interrupt();
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void resume() {
        LogEx.d("MultiVrPlayer", "resume().");
        if (this.q != null && 4 == this.I.get(this.J).e()) {
            LogEx.d("MultiVrPlayer", "STATE_PAUSED == miPlayerStatus");
            com.video.androidsdk.player.common.c.a(c.a.RUN_TIME);
            this.q.start();
            MDVRLibrary mDVRLibrary = this.l;
            if (mDVRLibrary != null) {
                mDVRLibrary.c(this.m);
            }
            com.video.androidsdk.player.common.c.b(c.a.RUN_TIME);
            this.I.get(this.J).a(3);
            return;
        }
        LogEx.e("MultiVrPlayer", "player status is error");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void resume4bg() {
        MDVRLibrary mDVRLibrary;
        if (this.q != null) {
            if (!this.L && (mDVRLibrary = this.l) != null) {
                mDVRLibrary.c(this.m);
            }
            if (this.v) {
                this.k.sendEmptyMessage(3);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void seek(long j) {
        if (this.q == null || !a()) {
            return;
        }
        LogEx.d("MultiVrPlayer", " seek to ---  " + j);
        com.video.androidsdk.player.common.c.a(c.a.SEEK_TIME);
        this.q.seekTo((long) ((int) j));
        com.video.androidsdk.player.common.c.b(c.a.SEEK_TIME);
        OnZTEMultiVrPlayerEventListener onZTEMultiVrPlayerEventListener = this.z;
        if (onZTEMultiVrPlayerEventListener != null) {
            onZTEMultiVrPlayerEventListener.onStateChanged(this.J, 10);
        }
    }

    public void seekAllPlayer(long j) {
        if (this.I != null) {
            LogEx.d("MultiVrPlayer", " stopAllPlayer() ");
            for (int i = 0; i < this.I.size(); i++) {
                com.video.androidsdk.player.a.b bVar = this.I.get(i);
                if (bVar != null && bVar.a() != null) {
                    bVar.a().seekTo(j);
                    bVar.a(10);
                }
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectAudioByIndex(int i) {
        if (this.q != null) {
            if (this.G.size() == 0) {
                ijk.media.player.misc.k[] trackInfo = this.q.getTrackInfo();
                int i2 = 0;
                for (int i3 = 0; i3 < trackInfo.length; i3++) {
                    ijk.media.player.misc.k kVar = trackInfo[i3];
                    if (kVar.getTrackType() == 2) {
                        kVar.getLanguage();
                        this.G.put(i2, Integer.valueOf(i3));
                        i2++;
                    }
                }
            }
            if (this.G.size() > i) {
                LogEx.d("MultiVrPlayer", "the mapped index is " + this.G.get(i));
                this.q.selectTrack(this.G.get(i).intValue());
                return true;
            }
            LogEx.e("MultiVrPlayer", "invalid selected index " + i);
        }
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectSubtitleByIndex(int i) {
        if (this.q != null) {
            if (this.H.size() == 0) {
                ijk.media.player.misc.k[] trackInfo = this.q.getTrackInfo();
                int i2 = 0;
                for (int i3 = 0; i3 < trackInfo.length; i3++) {
                    if (trackInfo[i3].getTrackType() == 4) {
                        this.H.put(i2, Integer.valueOf(i3));
                        i2++;
                    }
                }
            }
            if (this.H.size() > i) {
                LogEx.d("MultiVrPlayer", "the mapped index is " + this.H.get(i));
                this.q.selectTrack(this.H.get(i).intValue());
                return true;
            }
            LogEx.e("MultiVrPlayer", "invalid selected index " + i);
        }
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectVideoByIndex(int i) {
        if (this.q != null) {
            if (this.F.size() == 0) {
                ijk.media.player.misc.k[] trackInfo = this.q.getTrackInfo();
                int i2 = 0;
                for (int i3 = 0; i3 < trackInfo.length; i3++) {
                    ijk.media.player.misc.k kVar = trackInfo[i3];
                    if (kVar.getTrackType() == 1 && kVar.getFormat() != null) {
                        this.F.put(i2, Integer.valueOf(i3));
                        i2++;
                    }
                }
            }
            if (this.F.size() > i) {
                LogEx.d("MultiVrPlayer", "the mapped index is " + this.F.get(i));
                this.q.selectTrack(this.F.get(i).intValue());
                return true;
            }
            LogEx.e("MultiVrPlayer", "invalid selected index " + i);
        }
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setAudioChannel(boolean z, boolean z2) {
        if (this.q != null) {
            float volume = getVolume();
            IjkMediaPlayer ijkMediaPlayer = this.q;
            float f = z ? volume : 0.0f;
            if (!z2) {
                volume = 0.0f;
            }
            ijkMediaPlayer.setVolume(f, volume);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setAutoSpeed(boolean z) {
        IjkMediaPlayer ijkMediaPlayer;
        if (!this.P || (ijkMediaPlayer = this.q) == null) {
            return;
        }
        ijkMediaPlayer.setAutoSpeed(z);
    }

    public void setBulletTimeAll(int i, boolean z) {
        LogEx.d("MultiVrPlayer", "setBulletTimeAll");
        this.M = 1;
        this.N = new com.video.androidsdk.player.a.a(i, z);
        String str = this.I.get(0).f3313a;
        int i2 = 0;
        while (i2 < this.i.size() && !str.equals(this.i.get(i2))) {
            i2++;
        }
        while (true) {
            i2--;
            if (i2 < 0) {
                break;
            }
            LogEx.d("MultiVrPlayer", "addPlayerToHead");
            addPlayerToHead(this.i.get(i2), "0".equals(this.j.get(i2)));
        }
        Iterator<com.video.androidsdk.player.a.b> it2 = this.I.iterator();
        while (it2.hasNext()) {
            it2.next().a().pause();
        }
        setPlayerId(0);
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.a(this.N.f3310b, false);
            IRender.OnBulletTimeStateListener onBulletTimeStateListener = this.Q;
            if (onBulletTimeStateListener != null) {
                onBulletTimeStateListener.onStateChanged(0);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setDecoderType(DecoderType decoderType, DecoderType decoderType2) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setFadingVolumn(float f, long j) {
        IjkMediaPlayer ijkMediaPlayer = this.q;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setFadingVolume(f, j);
        }
    }

    public void setFrameSyncEnable(boolean z) {
        if (z) {
            if (this.P) {
                return;
            }
            d();
            for (int i = 0; i < this.I.size(); i++) {
                if (i != this.O && !this.I.get(i).c()) {
                    c(i);
                }
            }
            this.P = true;
            LogEx.d("MultiVrPlayer", "FrameSync ON");
            return;
        }
        this.P = false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setInitialBufferingTime(int i) {
        IjkMediaPlayer ijkMediaPlayer = this.q;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setInitBufferTime(i);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setMaxBufferSize(long j) {
        IjkMediaPlayer ijkMediaPlayer = this.q;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setMaxBufferSize(j);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setMaxBufferingTime(int i) {
        IjkMediaPlayer ijkMediaPlayer = this.q;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setMaxBufferTime(i);
        }
    }

    @Override // com.video.androidsdk.player.render.RenderImpl, com.video.androidsdk.player.render.IRender
    public void setOnBulletTimeStateListener(IRender.OnBulletTimeStateListener onBulletTimeStateListener) {
        this.Q = onBulletTimeStateListener;
    }

    public void setOnEventListener(OnZTEMultiVrPlayerEventListener onZTEMultiVrPlayerEventListener) {
        this.z = onZTEMultiVrPlayerEventListener;
    }

    @Override // com.video.androidsdk.player.render.RenderImpl, com.video.androidsdk.player.render.IRender
    public void setOnStateChangedListener(IRender.OnStateChangedListener onStateChangedListener) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPlaySpeed(float f) {
        IjkMediaPlayer ijkMediaPlayer = this.q;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setSpeed(f);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPlaybackBufferingTime(int i) {
        IjkMediaPlayer ijkMediaPlayer = this.q;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setPlaybackBufferTime(i);
        }
    }

    public void setPlayerId(int i) {
        IjkMediaPlayer d2;
        int i2 = this.o;
        if (i2 <= 1 || i > i2) {
            return;
        }
        IjkMediaPlayer ijkMediaPlayer = this.q;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setVolume(0.0f, 0.0f);
        }
        if (this.l.h() < 215) {
            for (int i3 = 0; i3 < this.I.size(); i3++) {
                if (i3 != i && !this.I.get(i3).d() && (d2 = d(i3)) != null) {
                    d2.start();
                    d2.seekTo(0L);
                }
            }
        }
        this.J = i;
        IjkMediaPlayer d3 = d(i);
        this.q = d3;
        if (d3 != null) {
            this.S.setSuspend(true);
            this.q.setVolume(1.0f, 1.0f);
            if (!this.I.get(this.J).d() && this.l.h() < 215) {
                this.q.start();
            }
        }
        com.render.vrlib.a.g b2 = this.I.get(this.J).b();
        LogEx.d("MultiVrPlayer", "setPlayerId " + this.J);
        while (b2 == null) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LogEx.d("MultiVrPlayer", "setPlayerId waiting..." + b2);
            b2 = this.I.get(this.J).b();
        }
        this.l.a(b2);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPreferredAudioLanguage(String str) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPreferredBitrate(long j) {
        if (this.I != null) {
            LogEx.d("MultiVrPlayer", "setPreferredBitrate");
            for (int i = 0; i < this.I.size(); i++) {
                com.video.androidsdk.player.a.b bVar = this.I.get(i);
                if (bVar != null && bVar.a() != null) {
                    bVar.a().setPreferBitrate(j);
                }
            }
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
        if (this.q != null) {
            LogEx.d("MultiVrPlayer", "set to use AdaptiveTrack");
            this.q.selectTrack(-1);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setVolume(float f) {
        if (this.q != null) {
            LogEx.d("MultiVrPlayer", "setVolume");
            this.q.setVolume(f, f);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void start() {
        if (a() && this.q != null) {
            LogEx.d("MultiVrPlayer", "IjkPlayer start().");
            com.video.androidsdk.player.common.c.a(c.a.RUN_TIME);
            this.q.start();
            MDVRLibrary mDVRLibrary = this.l;
            if (mDVRLibrary != null) {
                mDVRLibrary.c(this.m);
            }
            com.video.androidsdk.player.common.c.b(c.a.RUN_TIME);
            this.I.get(this.J).a(3);
            this.z.onStateChanged(this.J, 3);
            return;
        }
        LogEx.e("MultiVrPlayer", "player status is error");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void startWriteLog() {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void stop() {
        if (this.q != null) {
            LogEx.d("MultiVrPlayer", " stop() " + this);
            this.q.stop();
            this.q.reset();
            onRenderReset();
            this.I.get(this.J).a(0);
            this.x = true;
            this.v = false;
            this.k.obtainMessage(4, Boolean.valueOf(true ^ this.C)).sendToTarget();
        }
    }

    public void stopAllPlayer() {
        if (this.I != null) {
            LogEx.d("MultiVrPlayer", " stopAllPlayer() ");
            for (int i = 0; i < this.I.size(); i++) {
                com.video.androidsdk.player.a.b bVar = this.I.get(i);
                if (bVar != null && bVar.a() != null) {
                    IMediaPlayer a2 = bVar.a();
                    a2.stop();
                    a2.reset();
                    bVar.a(0);
                }
            }
            onRenderReset();
        }
        this.x = true;
        this.v = false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void stopSphericalView() {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void stopWriteLog() {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void suspend4bg() {
        if (this.q != null) {
            LogEx.d("MultiVrPlayer", "suspend4bg() " + this);
            LogEx.d("MultiVrPlayer", "-------- misPlayerRun is " + this.v);
            MDVRLibrary mDVRLibrary = this.l;
            if (mDVRLibrary != null) {
                mDVRLibrary.b(this.m);
            }
            if (this.v) {
                this.u = true;
                this.h = this.q.isPlaying();
                LogEx.d("MultiVrPlayer", "-------- mIsPlayingWhenSuspend is " + this.h);
                if (this.h && 3 == this.I.get(this.J).e()) {
                    this.h = true;
                    this.q.pause();
                    this.I.get(this.J).a(4);
                }
                this.k.removeCallbacksAndMessages(null);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void unmute() {
        if (this.q != null) {
            float max = Math.max(0.0f, this.D);
            LogEx.d("MultiVrPlayer", "volume is " + max);
            this.q.setVolume(max, max);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void updateVideoSize(int i, int i2) {
    }

    private void d() {
        if (this.T == null) {
            this.T = new Handler() { // from class: com.video.androidsdk.player.MultiVrPlayer.8
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (MultiVrPlayer.this.I == null) {
                        return;
                    }
                    super.handleMessage(message);
                    MultiVrPlayer multiVrPlayer = MultiVrPlayer.this;
                    multiVrPlayer.a(multiVrPlayer.O, message.arg1);
                }
            };
        }
    }

    private void e(int i) {
        LogEx.d("MultiVrPlayer", "deleteTexturePlayer :" + i);
        this.I.get(i).g();
        this.I.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        IjkMediaPlayer ijkMediaPlayer;
        if (this.x || (ijkMediaPlayer = this.q) == null) {
            return;
        }
        long currentPosition = ijkMediaPlayer.getCurrentPosition();
        LogEx.d("MultiVrPlayer", "currentPositon is " + currentPosition);
        LogEx.d("MultiVrPlayer", "Duration is " + this.q.getDuration());
        OnZTEMultiVrPlayerEventListener onZTEMultiVrPlayerEventListener = this.z;
        if (onZTEMultiVrPlayerEventListener != null) {
            onZTEMultiVrPlayerEventListener.onTime(this.J, currentPosition);
        }
    }

    private void c() {
        setOnSurfaceDestroyCallback(new IRender.IOnSurfaceDestroyCallback() { // from class: com.video.androidsdk.player.MultiVrPlayer.2
            @Override // com.video.androidsdk.player.render.IRender.IOnSurfaceDestroyCallback, com.render.vrlib.MDVRLibrary.i
            public void onSurfaceDestroy() {
                LogEx.d("MultiVrPlayer", "OnSurfaceDestroy");
                MultiVrPlayer.this.t = false;
                Iterator it2 = MultiVrPlayer.this.I.iterator();
                while (it2.hasNext()) {
                    com.video.androidsdk.player.a.b bVar = (com.video.androidsdk.player.a.b) it2.next();
                    if (bVar != null && bVar.a() != null) {
                        bVar.a().setSurface(null);
                    }
                }
            }
        });
        setOnSurfaceReadyCallback(new IRender.IOnSurfaceReadyCallback() { // from class: com.video.androidsdk.player.MultiVrPlayer.3
            @Override // com.video.androidsdk.player.render.IRender.IOnSurfaceReadyCallback, com.render.vrlib.MDVRLibrary.j
            public void onSurfaceReady(Surface surface) {
                LogEx.d("MultiVrPlayer", "onSurfaceReady");
                MultiVrPlayer.this.t = true;
                Iterator it2 = MultiVrPlayer.this.I.iterator();
                while (it2.hasNext()) {
                    com.video.androidsdk.player.a.b bVar = (com.video.androidsdk.player.a.b) it2.next();
                    if (bVar != null && bVar.a() != null) {
                        bVar.a().setSurface(surface);
                    }
                }
                MultiVrPlayer.this.A = surface;
            }
        });
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary == null) {
            return;
        }
        mDVRLibrary.a(new MDVRLibrary.k() { // from class: com.video.androidsdk.player.MultiVrPlayer.4
            @Override // com.render.vrlib.MDVRLibrary.k
            public void onSurfaceTexturesReady(ArrayList<com.render.vrlib.a.g> arrayList) {
                LogEx.d("MultiVrPlayer", "onSurfaceTexturesReady " + arrayList.size());
                for (int i = 0; i < arrayList.size(); i++) {
                    Surface surface = new Surface(arrayList.get(i).b());
                    if (MultiVrPlayer.this.I.get(i) != null && ((com.video.androidsdk.player.a.b) MultiVrPlayer.this.I.get(i)).a() != null) {
                        ((com.video.androidsdk.player.a.b) MultiVrPlayer.this.I.get(i)).a().setSurface(surface);
                    }
                    ((com.video.androidsdk.player.a.b) MultiVrPlayer.this.I.get(i)).a(arrayList.get(i));
                }
            }
        });
        this.l.a(new IRender.OnStateChangedListener() { // from class: com.video.androidsdk.player.MultiVrPlayer.5
            @Override // com.video.androidsdk.player.render.IRender.OnStateChangedListener, com.render.vrlib.MDVRLibrary.q
            public void onStateChanged(int i) {
                if (i == 1) {
                    LogEx.d("MultiVrPlayer", "miCurPlayerId  " + MultiVrPlayer.this.J);
                    if (MultiVrPlayer.this.J > 0) {
                        MultiVrPlayer.p(MultiVrPlayer.this);
                        LogEx.d("MultiVrPlayer", "miCurPlayerId  " + MultiVrPlayer.this.J);
                        MultiVrPlayer multiVrPlayer = MultiVrPlayer.this;
                        multiVrPlayer.setPlayerId(multiVrPlayer.J);
                        MultiVrPlayer.this.getCurrentScale();
                        MultiVrPlayer.this.setVideoWindow(MultiVrPlayer.this.getVideoWindow());
                        MultiVrPlayer.this.activeTouch();
                        return;
                    }
                    return;
                }
                if (i != 2) {
                    return;
                }
                LogEx.d("MultiVrPlayer", "miCurPlayerId  " + MultiVrPlayer.this.J);
                if (MultiVrPlayer.this.J < MultiVrPlayer.this.getCount() - 1) {
                    MultiVrPlayer.q(MultiVrPlayer.this);
                    LogEx.d("MultiVrPlayer", "miCurPlayerId  " + MultiVrPlayer.this.J);
                    MultiVrPlayer multiVrPlayer2 = MultiVrPlayer.this;
                    multiVrPlayer2.setPlayerId(multiVrPlayer2.J);
                    MultiVrPlayer.this.getCurrentScale();
                    MultiVrPlayer.this.setVideoWindow(MultiVrPlayer.this.getVideoWindow());
                    MultiVrPlayer.this.activeTouch();
                }
            }
        });
        this.l.a(new MDVRLibrary.o() { // from class: com.video.androidsdk.player.MultiVrPlayer.6
            @Override // com.render.vrlib.MDVRLibrary.o
            public void onStateChanged(int i) {
                if (i != 2) {
                    if (i == 3 && MultiVrPlayer.this.Q != null) {
                        MultiVrPlayer.this.Q.onStateChanged(3);
                        return;
                    }
                    return;
                }
                LogEx.d("MultiVrPlayer", "STATUS_BULLET_END ");
                if (MultiVrPlayer.this.M != 0) {
                    MultiVrPlayer.this.N.f3311c++;
                    LogEx.d("MultiVrPlayer", "bulletTimeAllCfg.curId : " + MultiVrPlayer.this.N.f3311c);
                    if (MultiVrPlayer.this.N.f3311c >= MultiVrPlayer.this.i.size() * 2) {
                        Iterator it2 = MultiVrPlayer.this.I.iterator();
                        while (it2.hasNext()) {
                            ((com.video.androidsdk.player.a.b) it2.next()).a().start();
                        }
                        if (MultiVrPlayer.this.Q != null) {
                            LogEx.d("MultiVrPlayer", "onStateChanged");
                            MultiVrPlayer.this.Q.onStateChanged(2);
                        }
                        MultiVrPlayer.this.N = null;
                        LogEx.d("MultiVrPlayer", "bulletTimeAllCfg.curId >= 2 * mlistURL.size()");
                        return;
                    }
                    try {
                        Thread.sleep(MultiVrPlayer.this.N.f3310b);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (MultiVrPlayer.this.N.f3311c < MultiVrPlayer.this.i.size()) {
                        int i2 = MultiVrPlayer.this.N.f3311c >= ((RenderImpl) MultiVrPlayer.this).o ? ((RenderImpl) MultiVrPlayer.this).o - 1 : MultiVrPlayer.this.N.f3311c;
                        LogEx.d("MultiVrPlayer", "-->: " + MultiVrPlayer.this.N.f3311c + "   id:" + i2);
                        if (!((com.video.androidsdk.player.a.b) MultiVrPlayer.this.I.get(i2)).f3314b && !((com.video.androidsdk.player.a.b) MultiVrPlayer.this.I.get(i2)).c()) {
                            try {
                                Thread.sleep(500L);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (!((com.video.androidsdk.player.a.b) MultiVrPlayer.this.I.get(i2)).f3314b || ((com.video.androidsdk.player.a.b) MultiVrPlayer.this.I.get(i2)).c()) {
                            Iterator it3 = MultiVrPlayer.this.I.iterator();
                            while (it3.hasNext()) {
                                ((com.video.androidsdk.player.a.b) it3.next()).a().start();
                            }
                            if (MultiVrPlayer.this.Q != null) {
                                MultiVrPlayer.this.Q.onStateChanged(2);
                            }
                            MultiVrPlayer.this.N = null;
                            LogEx.e("MultiVrPlayer", "player " + i2 + " is not rendered or got error");
                            LogEx.d("MultiVrPlayer", "player " + i2 + " isRendered  === " + ((com.video.androidsdk.player.a.b) MultiVrPlayer.this.I.get(i2)).f3314b);
                            LogEx.d("MultiVrPlayer", "player " + i2 + " isErr  === " + ((com.video.androidsdk.player.a.b) MultiVrPlayer.this.I.get(i2)).c());
                            return;
                        }
                        MultiVrPlayer.this.setPlayerId(i2);
                        LogEx.d("MultiVrPlayer", "setBulletIndexChanged ");
                        MultiVrPlayer.this.b(0);
                        if (((RenderImpl) MultiVrPlayer.this).l == null || MultiVrPlayer.this.N == null) {
                            return;
                        }
                        ((RenderImpl) MultiVrPlayer.this).l.a(MultiVrPlayer.this.N.f3310b, MDVRLibrary.BulletTimeMode.MODE_TO_RIGHT_ONLY);
                        return;
                    }
                    LogEx.d("MultiVrPlayer", "bulletTimeAllCfg.back: " + MultiVrPlayer.this.N.f3309a);
                    if (MultiVrPlayer.this.N.f3309a) {
                        int size = ((((RenderImpl) MultiVrPlayer.this).o - MultiVrPlayer.this.N.f3311c) + MultiVrPlayer.this.i.size()) - 1;
                        int i3 = size >= 0 ? size : 0;
                        LogEx.d("MultiVrPlayer", "<--: " + MultiVrPlayer.this.N.f3311c + "   id:" + i3);
                        if (!((com.video.androidsdk.player.a.b) MultiVrPlayer.this.I.get(i3)).f3314b && !((com.video.androidsdk.player.a.b) MultiVrPlayer.this.I.get(i3)).c()) {
                            try {
                                Thread.sleep(500L);
                            } catch (InterruptedException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (((com.video.androidsdk.player.a.b) MultiVrPlayer.this.I.get(i3)).f3314b && !((com.video.androidsdk.player.a.b) MultiVrPlayer.this.I.get(i3)).c()) {
                            MultiVrPlayer.this.setPlayerId(i3);
                            LogEx.d("MultiVrPlayer", "setBulletIndexChanged ");
                            MultiVrPlayer.this.b(((RenderImpl) r15).l.c() - 1);
                            if (((RenderImpl) MultiVrPlayer.this).l == null || MultiVrPlayer.this.N == null) {
                                return;
                            }
                            ((RenderImpl) MultiVrPlayer.this).l.a(MultiVrPlayer.this.N.f3310b, MDVRLibrary.BulletTimeMode.MODE_TO_LEFT_ONLY);
                            return;
                        }
                        LogEx.d("MultiVrPlayer", "player " + i3 + " isRendered  === " + ((com.video.androidsdk.player.a.b) MultiVrPlayer.this.I.get(i3)).f3314b);
                        LogEx.d("MultiVrPlayer", "player " + i3 + " isErr  === " + ((com.video.androidsdk.player.a.b) MultiVrPlayer.this.I.get(i3)).c());
                        Iterator it4 = MultiVrPlayer.this.I.iterator();
                        while (it4.hasNext()) {
                            ((com.video.androidsdk.player.a.b) it4.next()).a().start();
                        }
                        if (MultiVrPlayer.this.Q != null) {
                            MultiVrPlayer.this.Q.onStateChanged(2);
                        }
                        MultiVrPlayer.this.N = null;
                        LogEx.e("MultiVrPlayer", "player " + i3 + " is not rendered or got error");
                        return;
                    }
                    return;
                }
                MultiVrPlayer.this.start();
                if (MultiVrPlayer.this.Q != null) {
                    MultiVrPlayer.this.Q.onStateChanged(2);
                }
            }
        });
        this.l.a(new MDVRLibrary.n() { // from class: com.video.androidsdk.player.MultiVrPlayer.7
            @Override // com.render.vrlib.MDVRLibrary.n
            public void OnBulletIndexChanged(int i) {
                LogEx.d("MultiVrPlayer", "setBulletIndexChanged ");
                MultiVrPlayer.this.b(i);
            }
        });
    }

    private IjkMediaPlayer d(int i) {
        ArrayList<com.video.androidsdk.player.a.b> arrayList = this.I;
        if (arrayList == null || i >= arrayList.size()) {
            return null;
        }
        return (IjkMediaPlayer) this.I.get(i).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.I == null) {
            return;
        }
        int i = this.O;
        do {
            int size = (this.O + 1) % this.I.size();
            this.O = size;
            if (!this.I.get(size).c()) {
                LogEx.d("MultiVrPlayer", "sync on player " + this.O);
                for (int i2 = 0; i2 < this.I.size(); i2++) {
                    if (i2 != this.O && !this.I.get(i2).c()) {
                        c(i2);
                    }
                }
                return;
            }
        } while (this.O != i);
        LogEx.d("MultiVrPlayer", "All players are onError !");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(IMediaPlayer iMediaPlayer) {
        if (this.I != null) {
            for (int i = 0; i < this.I.size(); i++) {
                if (this.I.get(i).a().equals(iMediaPlayer)) {
                    return i;
                }
            }
        }
        return 0;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(RelativeLayout relativeLayout, int i, boolean z) {
        if (relativeLayout == null) {
            LogEx.d("MultiVrPlayer", "layout is null, return");
            return;
        }
        this.B = relativeLayout;
        relativeLayout.removeAllViews();
        a(this.B);
        this.y = (AudioManager) this.m.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(this.m);
        frameLayout.setLayoutParams(layoutParams);
        View view = new View(this.m);
        this.s = view;
        view.setBackgroundColor(-16777216);
        this.s.setLayoutParams(layoutParams);
        this.C = z;
        a(!z);
        frameLayout.addView(this.s);
        relativeLayout.addView(frameLayout);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void seek(long j, long j2) {
        if (this.q == null || !a()) {
            return;
        }
        this.E = j2 - this.q.getDuration();
        LogEx.d("MultiVrPlayer", "seek to ---  " + j + getDuration());
        com.video.androidsdk.player.common.c.a(c.a.SEEK_TIME);
        this.q.seekTo(j + getDuration());
        com.video.androidsdk.player.common.c.b(c.a.SEEK_TIME);
        OnZTEMultiVrPlayerEventListener onZTEMultiVrPlayerEventListener = this.z;
        if (onZTEMultiVrPlayerEventListener != null) {
            onZTEMultiVrPlayerEventListener.onStateChanged(this.J, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        LogEx.d("MultiVrPlayer", "curId " + this.J + ", OnBulletIndexChanged " + i);
        int c2 = this.l.c();
        StringBuilder sb = new StringBuilder();
        sb.append("getBulletNbs  ");
        sb.append(c2);
        LogEx.d("MultiVrPlayer", sb.toString());
        if (c2 <= 1) {
            return;
        }
        int i2 = this.J;
        int i3 = 0;
        if (i2 <= (this.o - 1) / 2) {
            if (i < (c2 + 1) / 2 && this.R == i + 1) {
                String str = this.I.get(i2).f3313a;
                LogEx.d("MultiVrPlayer", "current url is   " + str);
                int i4 = 0;
                while (i4 < this.i.size() && !str.equals(this.i.get(i4))) {
                    i4++;
                }
                LogEx.d("MultiVrPlayer", "the index is  " + i4);
                if (i4 != 0) {
                    LogEx.d("MultiVrPlayer", "mlistIjkPlayer.get(0).url is " + this.I.get(0).f3313a);
                    LogEx.d("MultiVrPlayer", "mlistURL.get(0) is " + this.i.get(0));
                    if (TextUtils.equals(this.I.get(0).f3313a, this.i.get(0))) {
                        LogEx.d("MultiVrPlayer", "already added the first " + this.I.get(0).f3313a);
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("addPlayerToHead  i-1  ===  ");
                        int i5 = i4 - 1;
                        sb2.append(i5);
                        LogEx.d("MultiVrPlayer", sb2.toString());
                        addPlayerToHead(this.i.get(i5), "0".equals(this.j.get(i5)));
                    }
                } else {
                    LogEx.d("MultiVrPlayer", "already at the top");
                }
            }
        } else if (i == (c2 - 1) / 2 && this.R == i - 1) {
            String str2 = this.I.get(i2).f3313a;
            LogEx.d("MultiVrPlayer", "current url is   " + str2);
            while (i3 < this.i.size() && !str2.equals(this.i.get(i3))) {
                i3++;
            }
            LogEx.d("MultiVrPlayer", "the index is  " + i3);
            if (i3 >= this.i.size() - 1) {
                LogEx.d("MultiVrPlayer", "already at the bottom");
            } else {
                LogEx.d("MultiVrPlayer", "mlistIjkPlayer.get(0).url is " + this.I.get(this.o - 1).f3313a);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("mlistURL.get(mlistURL.size() - 1) is ");
                ArrayList<String> arrayList = this.i;
                sb3.append(arrayList.get(arrayList.size() - 1));
                LogEx.d("MultiVrPlayer", sb3.toString());
                String str3 = this.I.get(this.o - 1).f3313a;
                ArrayList<String> arrayList2 = this.i;
                if (TextUtils.equals(str3, arrayList2.get(arrayList2.size() - 1))) {
                    LogEx.d("MultiVrPlayer", "already added the last " + this.I.get(this.o - 1).f3313a);
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("addPlayerToTail  i+1  ===  ");
                    int i6 = i3 + 1;
                    sb4.append(i6);
                    LogEx.d("MultiVrPlayer", sb4.toString());
                    addPlayerToTail(this.i.get(i6), "0".equals(this.j.get(i6)));
                }
            }
        }
        this.R = i;
    }

    private void c(int i) {
        if (this.T == null) {
            return;
        }
        LogEx.d("MultiVrPlayer", "startFrameSync : " + i + " @" + this.O);
        Message message = new Message();
        message.arg1 = i;
        ArrayList<com.video.androidsdk.player.a.b> arrayList = this.I;
        if (arrayList != null && i < arrayList.size()) {
            this.I.get(i).a(10.0f);
        }
        this.T.sendMessage(message);
    }

    public void stop(int i) {
        if (this.I != null) {
            IjkMediaPlayer d2 = d(i);
            if (d2 != null) {
                d2.stop();
                d2.reset();
            }
            this.I.get(i).a(0);
        }
        onRenderReset();
    }

    protected void a(int i) {
        LogEx.d("MultiVrPlayer", "createPlayer " + i);
        this.I.add(i, new com.video.androidsdk.player.a.b());
        LogEx.d("MultiVrPlayer", "the size of mlistIjkPlayer " + this.I.size());
        IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) this.I.get(i).a();
        if (ijkMediaPlayer == null) {
            return;
        }
        if (LogEx.getLogLevel() == LogEx.LogLevelType.TYPE_LOG_LEVEL_DEBUG) {
            IjkMediaPlayer.native_setLogLevel(2);
        }
        ijkMediaPlayer.setOption(4, "mediacodec-all-videos", 1L);
        ijkMediaPlayer.setOption(4, "mediacodec-auto-rotate", 1L);
        ijkMediaPlayer.setOption(4, "mediacodec-handle-resolution-change", 1L);
        ijkMediaPlayer.setOption(4, "overlay-format", 842225234L);
        ijkMediaPlayer.setOption(1, "http-detect-range-support", 0L);
        ijkMediaPlayer.setOnCompletionListener(new MyPlayerOnCompletionListener(this));
        ijkMediaPlayer.setOnPreparedListener(new MyPlayerOnPreparedListener(this));
        ijkMediaPlayer.setOnErrorListener(new MyPlayerOnErrorListener(this));
        ijkMediaPlayer.setOnInfoListener(new MyPlayerOnInfoListener(this));
        ijkMediaPlayer.setOnSeekCompleteListener(new MyPlayerOnSeekCompleteListener(this));
        ijkMediaPlayer.setOnBufferingUpdateListener(new MyPlayerOnBufferingUpdateListener(this));
        ijkMediaPlayer.setOnVideoSizeChangedListener(new MyPlayerOnVideoSizeChangedListener(this));
    }

    public void start(int i) {
        if (this.I != null) {
            IjkMediaPlayer d2 = d(i);
            if (d2 != null) {
                d2.start();
            }
            this.I.get(i).a(3);
        }
    }

    public void seek(int i, long j) {
        if (this.I != null) {
            IjkMediaPlayer d2 = d(i);
            if (d2 != null) {
                d2.seekTo(j);
            }
            this.I.get(i).a(10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        LogEx.d("MultiVrPlayer", "show shutterView " + z);
        View view = this.s;
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
        c();
    }

    private void a(int i, String str, boolean z) {
        int i2;
        try {
            if (i > this.I.size() - 1) {
                LogEx.w("MultiVrPlayer", "index is out of mlistIjkPlayer.size()");
                return;
            }
            com.video.androidsdk.player.a.b bVar = this.I.get(i);
            bVar.b(z);
            bVar.f3313a = str;
            IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) bVar.a();
            if (ijkMediaPlayer != null) {
                ijkMediaPlayer.setDataSource(b(str));
                if (str.contains("rtsp://")) {
                    i2 = 0;
                } else {
                    i2 = str.contains("rtmp://") ? 2 : 1;
                }
                a(ijkMediaPlayer, i2);
                ijkMediaPlayer.setAudioStreamType(3);
                ijkMediaPlayer.prepareAsync();
                LogEx.d("MultiVrPlayer", "prepareAsync");
                this.I.get(i).a(1);
                ijkMediaPlayer.setVolume(0.0f, 0.0f);
            }
        } catch (IOException e) {
            LogEx.w("MultiVrPlayer", "Unable to open content: " + this.r);
            this.I.get(i).a(-1);
            OnZTEMultiVrPlayerEventListener onZTEMultiVrPlayerEventListener = this.z;
            if (onZTEMultiVrPlayerEventListener != null) {
                onZTEMultiVrPlayerEventListener.onError(i, String.valueOf(1), "Unable to open content");
            }
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            LogEx.w("MultiVrPlayer", "Unable to open content: " + this.r);
            this.I.get(i).a(-1);
            OnZTEMultiVrPlayerEventListener onZTEMultiVrPlayerEventListener2 = this.z;
            if (onZTEMultiVrPlayerEventListener2 != null) {
                onZTEMultiVrPlayerEventListener2.onError(i, String.valueOf(1), "Unable to open content");
            }
            e2.printStackTrace();
        } catch (IllegalStateException e3) {
            LogEx.w("MultiVrPlayer", "Unable to open content: " + this.r);
            this.I.get(i).a(-1);
            OnZTEMultiVrPlayerEventListener onZTEMultiVrPlayerEventListener3 = this.z;
            if (onZTEMultiVrPlayerEventListener3 != null) {
                onZTEMultiVrPlayerEventListener3.onError(i, String.valueOf(1), "Unable to open content");
            }
            e3.printStackTrace();
        }
    }

    public void open(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null && arrayList.size() > 1 && arrayList2 != null && arrayList2.size() > 0) {
            this.i = arrayList;
            this.j = arrayList2;
            Math.min(this.o, arrayList.size());
            for (int i = 0; i < this.o; i++) {
                if (i > arrayList.size() - 1) {
                    LogEx.w("MultiVrPlayer", "index is out of listURL.size()");
                    return;
                }
                LogEx.w("MultiVrPlayer", "open  " + i + "  mediadatasurce");
                String str = arrayList.get(i);
                if ("0".equals(arrayList2.get(i))) {
                    a(i, str, true);
                } else {
                    a(i, str, false);
                }
            }
            this.J = 0;
            IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) this.I.get(0).a();
            this.q = ijkMediaPlayer;
            ijkMediaPlayer.setVolume(1.0f, 1.0f);
            this.v = true;
            return;
        }
        LogEx.w("MultiVrPlayer", "listURL or lstContentType is null");
    }

    private void a(IjkMediaPlayer ijkMediaPlayer, int i) {
        ijkMediaPlayer.setOption(4, "mediacodec-all-videos", 1L);
        ijkMediaPlayer.setOption(4, "mediacodec-auto-rotate", 1L);
        if (i == 0) {
            ijkMediaPlayer.setOption(4, "packet-buffering", 1L);
            ijkMediaPlayer.setOption(4, "overlay-format", 842225234L);
            ijkMediaPlayer.setOption(1, "flush_packets", 1L);
            ijkMediaPlayer.setOption(2, "skip_frame", 8L);
            ijkMediaPlayer.setOption(1, "rtsp_transport", "tcp");
            ijkMediaPlayer.setOption(1, "probesize", PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            ijkMediaPlayer.setOption(1, "analyzeduration", 5000000L);
            ijkMediaPlayer.setOption(1, "reconnect", 1L);
            ijkMediaPlayer.setOption(1, "one_connection_seek", 1L);
            return;
        }
        if (2 == i) {
            ijkMediaPlayer.setOption(1, "probesize", PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            ijkMediaPlayer.setOption(1, "analyzeduration", 5000000L);
            ijkMediaPlayer.setOption(1, "http-detect-range-support", 0L);
            ijkMediaPlayer.setOption(1, "flush_packets", 1L);
            ijkMediaPlayer.setOption(4, "packet-buffering", 0L);
            ijkMediaPlayer.setOption(4, "connect-timeout-msec", 300000L);
            ijkMediaPlayer.setOption(1, "reconnect", 1L);
            ijkMediaPlayer.setOption(1, "one_connection_seek", 1L);
            return;
        }
        ijkMediaPlayer.setOption(1, "probesize", 5242880L);
        ijkMediaPlayer.setOption(1, "analyzeduration", 5000000L);
        ijkMediaPlayer.setOption(4, "overlay-format", 842225234L);
        ijkMediaPlayer.setOption(4, "max-fps", 0L);
        ijkMediaPlayer.setOption(4, "connect-timeout-msec", 300000L);
        ijkMediaPlayer.setOption(1, "reconnect", 1L);
        ijkMediaPlayer.setOption(1, "one_connection_seek", 1L);
    }

    protected boolean a() {
        int e = this.I.get(this.J).e();
        return (this.q == null || e == -1 || e == 0 || e == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        ArrayList<com.video.androidsdk.player.a.b> arrayList;
        float f;
        LogEx.d("MultiVrPlayer", "baseId : " + i + " , refId : " + i2);
        if (!this.P) {
            LogEx.d("MultiVrPlayer", "FrameSync OFF");
            return;
        }
        IjkMediaPlayer d2 = d(this.O);
        if (d2 != null) {
            d2.setAutoSpeed(true);
            LogEx.d("MultiVrPlayer", "baseId : " + this.O + " , playspeed : " + d2.getSpeed());
        }
        if (i != this.O) {
            LogEx.d("MultiVrPlayer", "endFrameSync : " + i + " @" + this.O);
            return;
        }
        IjkMediaPlayer d3 = d(i);
        IjkMediaPlayer d4 = d(i2);
        if (d3 == null || d4 == null || (arrayList = this.I) == null || i2 >= arrayList.size() || i >= this.I.size() || this.I.get(i).e() < 1 || this.I.get(i2).e() < 1) {
            return;
        }
        LogEx.d("MultiVrPlayer", "mp1 current position is " + d3.getCurrentPosition() + "  , seekoff is " + d3.getSeekOff());
        LogEx.d("MultiVrPlayer", "mp2 current position is " + d4.getCurrentPosition() + "  , seekoff is " + d4.getSeekOff());
        long currentPosition = d3.getCurrentPosition() - d3.getSeekOff();
        long currentPosition2 = d4.getCurrentPosition() - d4.getSeekOff();
        LogEx.d("MultiVrPlayer", "time1 is " + currentPosition + "  , time2 is " + currentPosition2);
        float f2 = this.I.get(i2).f();
        long j = currentPosition - currentPosition2;
        if (Math.abs(j) <= 40) {
            f = 10.0f;
        } else {
            if (j >= DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS) {
                if (d4 != null) {
                    d4.seekTo((int) currentPosition);
                    Message message = new Message();
                    message.arg1 = i2;
                    ArrayList<com.video.androidsdk.player.a.b> arrayList2 = this.I;
                    if (arrayList2 != null && i2 < arrayList2.size()) {
                        this.I.get(i2).a(f2);
                    }
                    this.T.sendMessageDelayed(message, 1000L);
                    return;
                }
                return;
            }
            f = j > 40 ? 12.5f : 7.5f;
        }
        if (f != f2) {
            d4.setSpeed(f / 10.0f);
        }
        IjkMediaPlayer d5 = d(this.O);
        if (d5 != null) {
            LogEx.d("MultiVrPlayer", "baseId : " + this.O + " , playspeed : " + d5.getSpeed());
        }
        Message message2 = new Message();
        message2.arg1 = i2;
        ArrayList<com.video.androidsdk.player.a.b> arrayList3 = this.I;
        if (arrayList3 != null && i2 < arrayList3.size()) {
            this.I.get(i2).a(f);
        }
        this.T.sendMessageDelayed(message2, 100L);
    }
}
