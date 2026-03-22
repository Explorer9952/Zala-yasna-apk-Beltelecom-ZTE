package com.video.androidsdk.player;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.MediaCodec;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;
import com.google.android.exoplayer2.drm.HttpMediaDrmCallback;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DashUtil;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.source.zte.ZteMediaSource;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.FixedTrackSelection;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.DebugTextViewHelper;
import com.google.android.exoplayer2.ui.SubtitleView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.zte.ZteDataSourceFactory;
import com.google.android.exoplayer2.upstream.zte.ZteLibVodJni;
import com.google.android.exoplayer2.util.DeviceInfo;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.PlayerInfoCollect;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.zte.ZteIptvMediaInfo;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.VideoTimeListener;
import com.google.common.logging.nano.Vr;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.video.androidsdk.common.util.FileUtil;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.IBasePlayer;
import com.video.androidsdk.player.agama.AgamaIntegration;
import com.video.androidsdk.player.common.AssetType;
import com.video.androidsdk.player.common.DrmType;
import com.video.androidsdk.player.common.EventLogger;
import com.video.androidsdk.player.common.PlayerConstants;
import com.video.androidsdk.player.common.SourceType;
import com.video.androidsdk.player.common.UrlUtils;
import com.video.androidsdk.player.common.ZoomModeType;
import com.video.androidsdk.player.common.c;
import com.video.androidsdk.player.render.RenderImpl;
import java.io.File;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
import tv.agama.emp.client.Definitions$Measurement;

/* loaded from: classes.dex */
public class Exoplayer extends a {
    private static final TrackSelection.Factory j = new FixedTrackSelection.Factory();
    private static final DefaultBandwidthMeter k = new DefaultBandwidthMeter();
    private static final CookieManager p;
    private boolean A;
    private boolean B;
    private ComponentListener C;
    private boolean E;
    private boolean F;
    private TrackSelection.Factory G;
    private boolean H;
    private String I;
    private TextureView J;
    private HttpMediaDrmCallback K;
    private View L;
    private FrameLayout M;
    private Surface O;
    private DefaultLoadControl P;
    private DefaultDrmSessionManager<FrameworkMediaCrypto> Q;
    private RelativeLayout T;
    private FrameLayout U;
    private FrameLayout V;
    private String W;
    private ImaSdkSettings X;
    private AdsLoader Y;
    private float Z;
    private ZteLibVodJni ac;
    private AgamaIntegration ad;
    private DebugTextViewHelper ae;
    private boolean af;
    private String aj;
    private String ak;
    private int al;
    private boolean am;
    private long an;
    private boolean ao;
    private ExecutorService aq;
    protected AudioManager h;
    private AspectRatioFrameLayout q;
    private Handler t;
    private EventLogger u;
    private DataSource.Factory v;
    private SimpleExoPlayer w;
    private DefaultTrackSelector x;
    private Bundle y;
    private SurfaceView r = null;
    private SubtitleView s = null;
    private int z = 0;
    private boolean D = false;
    private boolean N = false;
    private int R = 1;
    private boolean S = true;
    private boolean aa = false;
    private String ab = null;
    private boolean ag = true;
    private boolean ah = false;
    private int ai = 3;
    private long ap = 7200;
    private MediaSource ar = null;
    private long as = -1;
    private long at = 0;
    protected Handler i = new Handler() { // from class: com.video.androidsdk.player.Exoplayer.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                Exoplayer.this.open(String.valueOf(message.obj));
                return;
            }
            if (i == 2) {
                Exoplayer.this.a();
                sendEmptyMessageDelayed(2, 1000L);
                return;
            }
            if (i == 4) {
                Object obj = message.obj;
                if (obj == null) {
                    obj = false;
                }
                boolean booleanValue = ((Boolean) obj).booleanValue();
                LogEx.d("Exoplayer", "isShow is " + booleanValue);
                Exoplayer.this.a(booleanValue);
                return;
            }
            if (i == 5) {
                SurfaceView unused = Exoplayer.this.r;
                return;
            }
            if (i == 6) {
                SurfaceView unused2 = Exoplayer.this.r;
                return;
            }
            if (i == 7) {
                if (message.arg1 == 1) {
                    try {
                        Exoplayer.this.ar = Exoplayer.this.a(Exoplayer.this.ar, Uri.parse(Exoplayer.this.W));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                LogEx.w("Exoplayer", "prepareSource");
                Exoplayer exoplayer = Exoplayer.this;
                exoplayer.a(exoplayer.ar);
                return;
            }
            if (i == 20) {
                Exoplayer.this.f();
                Exoplayer.this.i.sendEmptyMessageDelayed(20, 1000L);
            } else if (i != 21) {
                LogEx.w("Exoplayer", "unkown msg");
            } else {
                Exoplayer.this.g();
                Exoplayer.this.i.sendEmptyMessageDelayed(21, 1000L);
            }
        }
    };

    /* renamed from: com.video.androidsdk.player.Exoplayer$4, reason: invalid class name */
    /* loaded from: classes.dex */
    /* synthetic */ class AnonymousClass4 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3237a;

        static {
            int[] iArr = new int[AssetType.values().length];
            f3237a = iArr;
            try {
                iArr[AssetType.Asset_Video.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3237a[AssetType.Asset_Audio.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3237a[AssetType.Asset_Subtitle.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        CookieManager cookieManager = new CookieManager();
        p = cookieManager;
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
    }

    public Exoplayer(Context context, Bundle bundle) {
        this.m = context;
        this.y = bundle;
        this.A = true;
        this.v = a(k);
        this.t = new Handler();
        CookieHandler cookieHandler = CookieHandler.getDefault();
        CookieManager cookieManager = p;
        if (cookieHandler != cookieManager) {
            CookieHandler.setDefault(cookieManager);
        }
        c();
        b();
    }

    public void clearSurfaceView() {
        LogEx.d("Exoplayer", "clearSurfaceView");
        SurfaceView surfaceView = this.r;
        if (surfaceView != null) {
            this.w.clearVideoSurfaceView(surfaceView);
        }
        TextureView textureView = this.J;
        if (textureView != null) {
            this.w.clearVideoTextureView(textureView);
        }
        RelativeLayout relativeLayout = this.T;
        if (relativeLayout != null) {
            relativeLayout.removeAllViewsInLayout();
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void enableSubtitle(boolean z) {
        if (this.x == null) {
            return;
        }
        LogEx.e("Exoplayer", "enableSubtitle === " + z);
        this.x.setRendererDisabled(2, z ^ true);
        this.x.clearSelectionOverrides(2);
    }

    public void fastForward(int i) {
        LogEx.d("Exoplayer", "speed: " + i);
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.fastForward(i);
        }
    }

    public void fastRewind(int i) {
        LogEx.d("Exoplayer", "speed: " + i);
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.fastRewind(i);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getAssetCount(AssetType assetType) {
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;
        DefaultTrackSelector defaultTrackSelector = this.x;
        if (defaultTrackSelector == null || (currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo()) == null) {
            return 0;
        }
        if (assetType == AssetType.Asset_Video) {
            return currentMappedTrackInfo.getTrackGroups(0).length;
        }
        if (assetType == AssetType.Asset_Audio && currentMappedTrackInfo.length > 1) {
            return currentMappedTrackInfo.getTrackGroups(1).length;
        }
        if (assetType != AssetType.Asset_Subtitle || currentMappedTrackInfo.length <= 2) {
            return 0;
        }
        return currentMappedTrackInfo.getTrackGroups(2).length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r8 != 3) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0082  */
    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getAssetIndex(com.video.androidsdk.player.common.AssetType r8, com.video.androidsdk.player.common.AssetStatus r9) {
        /*
            r7 = this;
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector r9 = r7.x
            java.lang.String r0 = "Exoplayer"
            r1 = 0
            if (r9 != 0) goto Le
            java.lang.String r8 = "trackSelector is null"
            com.video.androidsdk.log.LogEx.e(r0, r8)
            return r1
        Le:
            int[] r9 = com.video.androidsdk.player.Exoplayer.AnonymousClass4.f3237a
            int r8 = r8.ordinal()
            r8 = r9[r8]
            r9 = 2
            r2 = 1
            if (r8 == r2) goto L1f
            if (r8 == r9) goto L21
            r2 = 3
            if (r8 == r2) goto L22
        L1f:
            r9 = 0
            goto L22
        L21:
            r9 = 1
        L22:
            android.util.Pair r8 = r7.getCurrentTrackIndex(r9)
            r2 = -1
            if (r8 == 0) goto L82
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "groupIndex is "
            r3.append(r4)
            java.lang.Object r4 = r8.first
            r3.append(r4)
            java.lang.String r4 = "  trackIndex is "
            r3.append(r4)
            java.lang.Object r4 = r8.second
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.video.androidsdk.log.LogEx.i(r0, r3)
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector r0 = r7.x
            com.google.android.exoplayer2.trackselection.MappingTrackSelector$MappedTrackInfo r0 = r0.getCurrentMappedTrackInfo()
            if (r0 != 0) goto L52
            return r2
        L52:
            com.google.android.exoplayer2.source.TrackGroupArray r9 = r0.getTrackGroups(r9)
            r0 = 0
            r3 = 0
        L58:
            int r4 = r9.length
            if (r0 >= r4) goto L87
            com.google.android.exoplayer2.source.TrackGroup r4 = r9.get(r0)
            r5 = 0
        L61:
            int r6 = r4.length
            if (r5 >= r6) goto L7f
            java.lang.Object r6 = r8.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            if (r0 != r6) goto L7a
            java.lang.Object r6 = r8.second
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            if (r5 != r6) goto L7a
            return r3
        L7a:
            int r3 = r3 + 1
            int r5 = r5 + 1
            goto L61
        L7f:
            int r0 = r0 + 1
            goto L58
        L82:
            java.lang.String r8 = "pair is null return -1"
            com.video.androidsdk.log.LogEx.e(r0, r8)
        L87:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.player.Exoplayer.getAssetIndex(com.video.androidsdk.player.common.AssetType, com.video.androidsdk.player.common.AssetStatus):int");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getAudioInfoArray(ArrayList<String> arrayList) {
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;
        DefaultTrackSelector defaultTrackSelector = this.x;
        if (defaultTrackSelector == null || (currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo()) == null) {
            return;
        }
        TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(1);
        for (int i = 0; i < trackGroups.length; i++) {
            TrackGroup trackGroup = trackGroups.get(i);
            for (int i2 = 0; i2 < trackGroup.length; i2++) {
                String str = trackGroup.getFormat(i2).language;
                if (str == null) {
                    str = "";
                }
                arrayList.add(str);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getAvailabilityStartTime() {
        SimpleExoPlayer simpleExoPlayer = this.w;
        long j2 = (simpleExoPlayer == null || !(simpleExoPlayer.getCurrentManifest() instanceof DashManifest)) ? 0L : ((DashManifest) this.w.getCurrentManifest()).availabilityStartTime;
        LogEx.d("Exoplayer", "availabilityStartTime is " + j2);
        return j2;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getBitrateEstimate() {
        DefaultBandwidthMeter defaultBandwidthMeter = k;
        if (defaultBandwidthMeter != null) {
            return defaultBandwidthMeter.getBitrateEstimate();
        }
        return 0L;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getBufferedPosition() {
        long bufferedPosition;
        if (this.w == null) {
            return 0L;
        }
        if (isPlayingAd()) {
            bufferedPosition = this.w.getContentPosition();
        } else {
            bufferedPosition = this.w.getBufferedPosition();
        }
        LogEx.d("Exoplayer", "ExoPlayer Position  is  " + bufferedPosition);
        return bufferedPosition;
    }

    public MappingTrackSelector.MappedTrackInfo getCurrentMappedTrackInfo() {
        DefaultTrackSelector defaultTrackSelector = this.x;
        if (defaultTrackSelector != null) {
            return defaultTrackSelector.getCurrentMappedTrackInfo();
        }
        return null;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getCurrentPosition() {
        long currentPosition;
        if (this.w == null) {
            return 0L;
        }
        if (isPlayingAd()) {
            currentPosition = this.w.getContentPosition();
        } else {
            currentPosition = this.w.getCurrentPosition();
        }
        LogEx.d("Exoplayer", "ExoPlayer Position  is  " + currentPosition);
        return currentPosition;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getCurrentTimeMs() {
        LogEx.d("Exoplayer", "mCurrentTimeMs is " + this.an);
        return this.an;
    }

    public Pair<Integer, Integer> getCurrentTrackIndex(int i) {
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;
        DefaultTrackSelector defaultTrackSelector = this.x;
        if (defaultTrackSelector == null || (currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo()) == null) {
            return null;
        }
        MappingTrackSelector.SelectionOverride selectionOverride = this.x.getSelectionOverride(i, currentMappedTrackInfo.getTrackGroups(i));
        if (selectionOverride == null) {
            if (!this.x.getRendererDisabled(i)) {
                LogEx.d("Exoplayer", "getRendererDisabled  is false");
                return this.x.getCurrentSelectedTack(i);
            }
            LogEx.d("Exoplayer", "getRendererDisabled  is true");
            return null;
        }
        LogEx.d("Exoplayer", "override  is not null");
        return new Pair<>(Integer.valueOf(selectionOverride.groupIndex), Integer.valueOf(selectionOverride.tracks[0]));
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getDuration() {
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer == null) {
            return 0L;
        }
        long duration = simpleExoPlayer.getDuration();
        LogEx.d("Exoplayer", "ExoPlayer duration  is  " + duration);
        if (duration < 0) {
            return 0L;
        }
        return duration;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getLeftTimeMs() {
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer == null || !(simpleExoPlayer.getCurrentManifest() instanceof DashManifest)) {
            return 0L;
        }
        DashManifest dashManifest = (DashManifest) this.w.getCurrentManifest();
        if (dashManifest.dynamic) {
            long firstSegmentStartTimeMs = dashManifest.getFirstSegmentStartTimeMs();
            LogEx.d("Exoplayer", "leftTimeMs is " + firstSegmentStartTimeMs);
            return firstSegmentStartTimeMs;
        }
        long j2 = dashManifest.extraPictime;
        LogEx.d("Exoplayer", "leftTimeMs is " + j2);
        return j2;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public float getPlaySpeed() {
        PlaybackParameters playbackParameters;
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer == null || (playbackParameters = simpleExoPlayer.getPlaybackParameters()) == null) {
            return 1.0f;
        }
        return playbackParameters.speed;
    }

    public SimpleExoPlayer getPlayer() {
        return this.w;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getPlayerState() {
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer != null) {
            int playbackState = simpleExoPlayer.getPlaybackState();
            boolean playWhenReady = this.w.getPlayWhenReady();
            LogEx.d("Exoplayer", "ExoPlayer playbackState  is  " + playbackState);
            if (playbackState == 3 && !playWhenReady) {
                this.z = 4;
            } else if (playbackState == 3 && playWhenReady) {
                this.z = 3;
            } else if (playbackState == 2 && !playWhenReady) {
                this.z = 6;
            } else if (playbackState == 4) {
                this.z = 5;
            } else if (playbackState == 2) {
                this.z = 7;
            } else if (playbackState == 1) {
                this.z = 0;
            }
        }
        return this.z;
    }

    public int getRenderCount() {
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer != null) {
            return simpleExoPlayer.getRendererCount();
        }
        return -1;
    }

    public int getRenderType(int i) {
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer != null) {
            return simpleExoPlayer.getRendererType(i);
        }
        return -1;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getRightTimeMs() {
        SimpleExoPlayer simpleExoPlayer = this.w;
        long lastSegmentEndTimeMs = (simpleExoPlayer == null || !(simpleExoPlayer.getCurrentManifest() instanceof DashManifest)) ? 0L : ((DashManifest) this.w.getCurrentManifest()).getLastSegmentEndTimeMs();
        LogEx.d("Exoplayer", "rightTimeMs is " + lastSegmentEndTimeMs);
        return lastSegmentEndTimeMs;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getSubtitleInfoArray(ArrayList<String> arrayList) {
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;
        DefaultTrackSelector defaultTrackSelector = this.x;
        if (defaultTrackSelector == null || (currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo()) == null) {
            return;
        }
        TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(2);
        for (int i = 0; i < trackGroups.length; i++) {
            TrackGroup trackGroup = trackGroups.get(i);
            for (int i2 = 0; i2 < trackGroup.length; i2++) {
                String str = trackGroup.getFormat(i2).language;
                if (str == null) {
                    str = "";
                }
                arrayList.add(str);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public SurfaceView getSurfaceView() {
        return this.r;
    }

    public TrackSelection.Factory getTrackFactory() {
        return this.G;
    }

    public DefaultTrackSelector getTrackSelector() {
        return this.x;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getUTCPosition() {
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer == null) {
            return 0L;
        }
        long uTCPosition = simpleExoPlayer.getUTCPosition();
        LogEx.d("Exoplayer", "ExoPlayer iUTCPosition  is  " + uTCPosition);
        return uTCPosition;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getVideoFrameRate() {
        return PlayerInfoCollect.getVideoFrameRate();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getVideoHeight() {
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer == null || simpleExoPlayer.getVideoFormat() == null) {
            return 0;
        }
        return this.w.getVideoFormat().height;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getVideoInfoArray(ArrayList<String> arrayList) {
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;
        DefaultTrackSelector defaultTrackSelector = this.x;
        if (defaultTrackSelector == null || (currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo()) == null) {
            return;
        }
        TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(0);
        for (int i = 0; i < trackGroups.length; i++) {
            TrackGroup trackGroup = trackGroups.get(i);
            for (int i2 = 0; i2 < trackGroup.length; i2++) {
                arrayList.add(String.format(Locale.US, "%.2fMbit", Float.valueOf(trackGroup.getFormat(i2).bitrate / 1000000.0f)) + "," + trackGroup.getFormat(i2).id);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getVideoWidth() {
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer == null || simpleExoPlayer.getVideoFormat() == null) {
            return 0;
        }
        return this.w.getVideoFormat().width;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public float getVolume() {
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer != null) {
            return simpleExoPlayer.getVolume();
        }
        return 0.0f;
    }

    public void hideDebugPlayInfo() {
        DebugTextViewHelper debugTextViewHelper = this.ae;
        if (debugTextViewHelper != null) {
            debugTextViewHelper.stop();
        }
        FrameLayout frameLayout = this.M;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
    }

    public void hideRenderView() {
        RelativeLayout relativeLayout = this.T;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        SurfaceView surfaceView = this.r;
        if (surfaceView != null) {
            surfaceView.setVisibility(8);
        }
        SubtitleView subtitleView = this.s;
        if (subtitleView != null) {
            subtitleView.setVisibility(8);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(RelativeLayout relativeLayout) {
        this.T = relativeLayout;
        LogEx.d("Exoplayer", "start init");
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.removeAllViewsInLayout();
        this.h = (AudioManager) this.m.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        LogEx.d("Exoplayer", "init surfaceview");
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(this.m);
        this.q = aspectRatioFrameLayout;
        aspectRatioFrameLayout.setLayoutParams(layoutParams);
        SurfaceView surfaceView = new SurfaceView(this.m);
        this.r = surfaceView;
        if (Build.VERSION.SDK_INT >= 17) {
            surfaceView.setSecure(true);
        }
        this.r.setLayoutParams(layoutParams);
        this.q.addView(this.r, 0);
        SubtitleView subtitleView = new SubtitleView(this.m);
        this.s = subtitleView;
        subtitleView.setLayoutParams(layoutParams);
        this.s.setStyle(new CaptionStyleCompat(-1, 0, 0, 0, -1, null));
        this.s.setUserDefaultTextSize();
        this.q.addView(this.s, 1);
        View view = new View(this.m);
        this.L = view;
        view.setBackgroundColor(-16777216);
        this.L.setLayoutParams(layoutParams);
        this.N = true;
        a(!true);
        this.q.addView(this.L, 2);
        this.q.setResizeMode(0);
        relativeLayout.addView(this.q);
        relativeLayout.setBackgroundColor(this.m.getResources().getColor(R.color.background_dark));
        relativeLayout.setGravity(17);
        this.w.setVideoSurfaceView(this.r);
        LogEx.d("Exoplayer", " init end");
    }

    public void initAdSource(String str, ImaSdkSettings imaSdkSettings) {
        if (!TextUtils.isEmpty(str)) {
            this.W = str;
        }
        this.X = imaSdkSettings;
        if (LogEx.getLogLevel() == LogEx.LogLevelType.TYPE_LOG_LEVEL_DEBUG) {
            if (this.X == null) {
                this.X = new ImaSdkSettings();
            }
            this.X.setDebugMode(true);
        }
    }

    public void initAdUiView(FrameLayout frameLayout) {
        if (frameLayout != null) {
            this.U = frameLayout;
        }
    }

    public void initIPAddr() {
        try {
            LogEx.d("Exoplayer", "zteLibVodJni  initIPAddr");
            if (this.ac != null) {
                this.ac.initIPAddr();
            }
        } catch (Exception e) {
            LogEx.w("Exoplayer", e.getMessage());
            e.printStackTrace();
        }
    }

    public void iptvSeek(long j2) {
        LogEx.d("Exoplayer", "position: " + j2);
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.iptvSeek(j2);
        }
    }

    public boolean isDRMSupported() {
        LogEx.d("Exoplayer", "mbIsDRMSupported  is " + this.f3306b);
        return this.f3306b;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean isPlaying() {
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer == null) {
            return false;
        }
        int playbackState = simpleExoPlayer.getPlaybackState();
        LogEx.d("Exoplayer", "ExoPlayer status  is  " + playbackState);
        LogEx.d("Exoplayer", "ExoPlayer PlayWhenReady  is  " + this.w.getPlayWhenReady());
        if (playbackState == 3 && this.w.getPlayWhenReady()) {
            return true;
        }
        return playbackState == 2 && this.w.getPlayWhenReady();
    }

    public boolean isPlayingAd() {
        SimpleExoPlayer simpleExoPlayer = this.w;
        return simpleExoPlayer != null && simpleExoPlayer.isPlayingAd() && this.w.getPlayWhenReady();
    }

    public boolean isRendererEnabled(int i) {
        if (this.x == null) {
            return false;
        }
        return !r0.getRendererDisabled(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r10 != 3) goto L11;
     */
    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean isTrackAvailable(com.video.androidsdk.player.common.AssetType r10, int r11) {
        /*
            r9 = this;
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector r0 = r9.x
            r1 = 0
            if (r0 != 0) goto Le
            java.lang.String r10 = "Exoplayer"
            java.lang.String r11 = "trackSelector is null"
            com.video.androidsdk.log.LogEx.e(r10, r11)
            return r1
        Le:
            int[] r0 = com.video.androidsdk.player.Exoplayer.AnonymousClass4.f3237a
            int r10 = r10.ordinal()
            r10 = r0[r10]
            r0 = 2
            r2 = 1
            if (r10 == r2) goto L1f
            if (r10 == r0) goto L21
            r3 = 3
            if (r10 == r3) goto L22
        L1f:
            r0 = 0
            goto L22
        L21:
            r0 = 1
        L22:
            android.util.Pair r10 = r9.getCurrentTrackIndex(r0)
            if (r10 == 0) goto L56
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector r10 = r9.x
            com.google.android.exoplayer2.trackselection.MappingTrackSelector$MappedTrackInfo r10 = r10.getCurrentMappedTrackInfo()
            if (r10 != 0) goto L31
            return r1
        L31:
            com.google.android.exoplayer2.source.TrackGroupArray r3 = r10.getTrackGroups(r0)
            r4 = 0
            r5 = 0
        L37:
            int r6 = r3.length
            if (r4 >= r6) goto L56
            com.google.android.exoplayer2.source.TrackGroup r6 = r3.get(r4)
            r7 = 0
        L40:
            int r8 = r6.length
            if (r7 >= r8) goto L53
            if (r5 != r11) goto L4e
            int r10 = r10.getTrackFormatSupport(r0, r4, r7)
            if (r10 == 0) goto L4d
            r1 = 1
        L4d:
            return r1
        L4e:
            int r5 = r5 + 1
            int r7 = r7 + 1
            goto L40
        L53:
            int r4 = r4 + 1
            goto L37
        L56:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.player.Exoplayer.isTrackAvailable(com.video.androidsdk.player.common.AssetType, int):boolean");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void mute() {
        LogEx.d("Exoplayer", "misMute   " + this.ah);
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer == null || this.ah) {
            return;
        }
        this.Z = simpleExoPlayer.getVolume();
        LogEx.d("Exoplayer", "getVolume   " + this.Z);
        LogEx.d("Exoplayer", "setVolume   0 ");
        this.ah = true;
        this.w.setVolume(0.0f);
    }

    public void open(ZteIptvMediaInfo zteIptvMediaInfo) {
        if (com.video.androidsdk.license.a.h) {
            LogEx.d("Exoplayer", "open");
            MediaSource a2 = a(zteIptvMediaInfo);
            SimpleExoPlayer simpleExoPlayer = this.w;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.prepare(a2);
                this.B = true;
                this.H = true;
                this.al = zteIptvMediaInfo.exoMediaInfo.mediaType;
                this.am = true;
                return;
            }
            return;
        }
        LogEx.d("Exoplayer", "you should check license");
        IBasePlayer.OnEventListener onEventListener = this.f3307c;
        if (onEventListener != null) {
            onEventListener.onError("30000502", "[player_error][APP][EVENT]Received license failed event");
        }
    }

    public void openForTsTV(final String str, final long j2) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.aq = newSingleThreadExecutor;
        newSingleThreadExecutor.execute(new Runnable() { // from class: com.video.androidsdk.player.Exoplayer.2

            /* renamed from: a, reason: collision with root package name */
            String f3232a;

            {
                this.f3232a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Exoplayer.this.as = -1L;
                Exoplayer.this.at = 0L;
                Exoplayer.this.ao = false;
                try {
                    DashManifest loadManifest = DashUtil.loadManifest(Exoplayer.this.b((DefaultBandwidthMeter) null).createDataSource(), Uri.parse(this.f3232a));
                    if (Exoplayer.this.w != null && loadManifest != null) {
                        long firstSegmentStartTimeMs = loadManifest.getFirstSegmentStartTimeMs();
                        LogEx.d("Exoplayer", "leftTimeMs is " + firstSegmentStartTimeMs);
                        long lastSegmentEndTimeMs = loadManifest.getLastSegmentEndTimeMs();
                        LogEx.d("Exoplayer", "rightTimeMs is " + lastSegmentEndTimeMs);
                        LogEx.d("Exoplayer", "seekTimeMs is " + j2);
                        if (j2 != -1 && j2 < lastSegmentEndTimeMs - (loadManifest.minBufferTime * 3)) {
                            if (j2 >= firstSegmentStartTimeMs) {
                                long j3 = j2;
                                long j4 = loadManifest.minBufferTime;
                                Long.signum(j4);
                                if (j3 < lastSegmentEndTimeMs - (j4 * 3)) {
                                    Exoplayer.this.ao = true;
                                    Exoplayer.this.at = (-loadManifest.timeShiftBufferDepth) / 1000;
                                    Exoplayer.this.as = j2 - firstSegmentStartTimeMs;
                                    this.f3232a += "&npt=" + Exoplayer.this.at;
                                    LogEx.d("Exoplayer", "[TsSeek]seekInside live mpd, seekTimeMs is " + j2 + LocaleUtil.MALAY);
                                }
                            }
                            if (j2 < firstSegmentStartTimeMs && j2 >= lastSegmentEndTimeMs - (Exoplayer.this.ap * 1000)) {
                                LogEx.d("Exoplayer", "[TsSeekseekTimeMs " + j2 + LocaleUtil.MALAY + " between leftTimeMs " + firstSegmentStartTimeMs + " and (rightTimeMs-maxSupportTimeS) " + (lastSegmentEndTimeMs - (Exoplayer.this.ap * 1000)) + " ,maxSupportTimeS is " + Exoplayer.this.ap);
                                Exoplayer.this.ao = true;
                                Exoplayer.this.at = ((j2 - lastSegmentEndTimeMs) - (loadManifest.minBufferTime * 3)) / 1000;
                                Exoplayer.this.as = loadManifest.minBufferTime * 3;
                                StringBuilder sb = new StringBuilder();
                                sb.append(this.f3232a);
                                sb.append("&npt=");
                                sb.append(Exoplayer.this.at);
                                this.f3232a = sb.toString();
                                LogEx.d("Exoplayer", "[TsSeek] npt is" + Exoplayer.this.at + " s");
                            } else if (j2 < lastSegmentEndTimeMs - (Exoplayer.this.ap * 1000)) {
                                LogEx.d("Exoplayer", "[TsSeek]seekTimeMs  " + j2 + LocaleUtil.MALAY + " before (rightTimeMs - maxSupportTimeS)" + (lastSegmentEndTimeMs - (Exoplayer.this.ap * 1000)) + " ,maxSupportTimeS is " + Exoplayer.this.ap);
                                Exoplayer.this.ao = true;
                                Exoplayer.this.at = -Exoplayer.this.ap;
                                Exoplayer.this.as = 0L;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(this.f3232a);
                                sb2.append("&npt=");
                                sb2.append(Exoplayer.this.at);
                                this.f3232a = sb2.toString();
                                LogEx.d("Exoplayer", "[TsSeek] npt is" + Exoplayer.this.at + " s");
                                Exoplayer.this.w.seekForTimeShirft(0L, Exoplayer.this.at);
                            }
                        }
                        LogEx.d("Exoplayer", "[TsSeek]open live, timeMs " + j2 + "s,unsafe seek");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Exoplayer exoplayer = Exoplayer.this;
                if (exoplayer.f3307c != null) {
                    if (exoplayer.ao) {
                        Exoplayer.this.f3307c.onStateChanged(18);
                    } else {
                        Exoplayer.this.f3307c.onStateChanged(19);
                    }
                }
                Message message = new Message();
                message.what = 1;
                message.obj = this.f3232a;
                Exoplayer.this.i.sendMessage(message);
            }
        });
    }

    @Override // com.video.androidsdk.player.a
    public void openInternal(String str) {
        HashMap<String, String> paramsMap;
        LogEx.d("Exoplayer", "ExoPlayer open, url is == " + str);
        this.ao = false;
        if (TextUtils.isEmpty(str)) {
            LogEx.w("Exoplayer", "player url is null");
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(-1);
                return;
            }
            return;
        }
        if (!this.f3306b) {
            LogEx.d("Exoplayer", "Protected content cannot be played");
            IBasePlayer.OnEventListener onEventListener2 = this.f3307c;
            if (onEventListener2 != null) {
                onEventListener2.onError(this.aj, "[drm_error]" + this.ak);
            }
        }
        this.i.sendEmptyMessage(5);
        this.ar = null;
        if (!str.contains(SourceType.STE_SOURCE_TYPE_MPD) && !SourceType.STE_SOURCE_TYPE_MPD.equalsIgnoreCase(this.I)) {
            if (!str.contains(SourceType.STE_SOURCE_TYPE_M3U8) && !SourceType.STE_SOURCE_TYPE_M3U8.equalsIgnoreCase(this.I)) {
                if (!str.contains(".ism") && !SourceType.STE_SOURCE_TYPE_ISM.equalsIgnoreCase(this.I)) {
                    this.ar = a(Uri.parse(str), (String) null);
                } else {
                    this.ar = a(Uri.parse(str), SourceType.STE_SOURCE_TYPE_ISM);
                }
            } else {
                this.ar = a(Uri.parse(str), SourceType.STE_SOURCE_TYPE_M3U8);
            }
        } else {
            this.ar = a(Uri.parse(str), SourceType.STE_SOURCE_TYPE_MPD);
        }
        if (this.aa && (paramsMap = UrlUtils.getParamsMap(str)) != null && paramsMap.containsKey("videoid")) {
            String str2 = paramsMap.get("videoid");
            if (this.Q != null && !TextUtils.isEmpty(str2)) {
                this.ab = str2;
                this.Q.setUseOfflineDrm(this.m, str2);
            }
        }
        d(str);
        if (this.w == null || this.ar == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.W)) {
            d();
        } else {
            a(this.ar);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void pause() {
        LogEx.d("Exoplayer", "ExoPlayer pause().");
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(false);
        }
    }

    public void refreshUserToken(String str, String str2) {
        HttpMediaDrmCallback httpMediaDrmCallback = this.K;
        if (httpMediaDrmCallback != null) {
            httpMediaDrmCallback.setUserToken(str, str2);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void release() {
        super.release();
        LogEx.d("Exoplayer", "ExoPlayer release().");
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer != null) {
            this.A = simpleExoPlayer.getPlayWhenReady();
            this.w.stop();
            this.w.release();
            this.w.removeListener(this.C);
            this.w.removeVideoTiemListener(this.C);
            this.w.removeVideoListener(this.C);
            this.w.removeTextOutput(this.C);
            this.w.removeListener(this.u);
            this.w.removeMetadataOutput(this.u);
            this.w.setVideoListener(null);
            this.w = null;
            this.x = null;
            this.u = null;
            this.i.removeCallbacksAndMessages(null);
        }
        e();
        this.r = null;
        this.s = null;
        this.J = null;
        this.m = null;
    }

    public void resetInitEstimateBitrate(long j2) {
        LogEx.d("Exoplayer", "resetInitEstimateBitrate " + j2);
        String str = com.video.androidsdk.player.common.b.a().get("lastbitrate");
        if (!TextUtils.isEmpty(str)) {
            j2 = Integer.parseInt(str);
        }
        LogEx.d("Exoplayer", "resetInitEstimateBitrate " + j2);
        long j3 = ((long) (((float) j2) / 0.75f)) + 1;
        DefaultBandwidthMeter defaultBandwidthMeter = k;
        if (defaultBandwidthMeter != null) {
            defaultBandwidthMeter.resetEstimateBitrate(j3);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void resume() {
        LogEx.d("Exoplayer", "ExoPlayer resume().");
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(true);
            this.w.resume();
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void resume4bg() {
        LogEx.d("Exoplayer", "ExoPlayer resume4bg().");
        if (this.w != null) {
            if (this.D) {
                this.D = false;
            }
            this.w.setPlayWhenReady(this.A);
            this.i.sendEmptyMessage(2);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void seek(long j2) {
        LogEx.d("Exoplayer", "ExoPlayer seek to ---  " + j2);
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer != null) {
            if (this.am) {
                simpleExoPlayer.iptvSeek(j2);
            } else if (simpleExoPlayer.getCurrentManifest() != null && (this.w.getCurrentManifest() instanceof DashManifest) && ((DashManifest) this.w.getCurrentManifest()).dynamic) {
                this.w.seekForTimeShirftByPts(j2);
            } else {
                this.w.seekTo(j2);
            }
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(10);
                AgamaIntegration agamaIntegration = this.ad;
                if (agamaIntegration != null) {
                    agamaIntegration.setViewState(10, null, null);
                }
                this.E = true;
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectAudioByIndex(int i) {
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;
        DefaultTrackSelector defaultTrackSelector = this.x;
        if (defaultTrackSelector == null || (currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo()) == null) {
            return false;
        }
        TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(1);
        int i2 = 0;
        for (int i3 = 0; i3 < trackGroups.length; i3++) {
            TrackGroup trackGroup = trackGroups.get(i3);
            for (int i4 = 0; i4 < trackGroup.length; i4++) {
                if (i2 == i) {
                    selectFixedTrack(1, i3, i4);
                    return true;
                }
                i2++;
            }
        }
        return false;
    }

    public void selectFixedTrack(int i, int i2, int i3) {
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;
        DefaultTrackSelector defaultTrackSelector = this.x;
        if (defaultTrackSelector == null || (currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo()) == null) {
            return;
        }
        TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i);
        MappingTrackSelector.SelectionOverride selectionOverride = new MappingTrackSelector.SelectionOverride(j, i2, i3);
        LogEx.d("Exoplayer", "rendererIndex  is " + i);
        LogEx.d("Exoplayer", "groupIndex  is " + i2);
        LogEx.d("Exoplayer", "trackIndex  is " + i3);
        this.x.setRendererDisabled(i, false);
        this.x.setSelectionOverride(i, trackGroups, selectionOverride);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectSubtitleByIndex(int i) {
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;
        DefaultTrackSelector defaultTrackSelector = this.x;
        if (defaultTrackSelector == null || (currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo()) == null) {
            return false;
        }
        TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(2);
        int i2 = 0;
        for (int i3 = 0; i3 < trackGroups.length; i3++) {
            TrackGroup trackGroup = trackGroups.get(i3);
            for (int i4 = 0; i4 < trackGroup.length; i4++) {
                if (i2 == i) {
                    selectFixedTrack(2, i3, i4);
                    return true;
                }
                i2++;
            }
        }
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectVideoByIndex(int i) {
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;
        DefaultTrackSelector defaultTrackSelector = this.x;
        if (defaultTrackSelector == null || (currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo()) == null) {
            return false;
        }
        TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(0);
        int i2 = 0;
        for (int i3 = 0; i3 < trackGroups.length; i3++) {
            TrackGroup trackGroup = trackGroups.get(i3);
            for (int i4 = 0; i4 < trackGroup.length; i4++) {
                if (i2 == i) {
                    selectFixedTrack(0, i3, i4);
                    return true;
                }
                i2++;
            }
        }
        return false;
    }

    public void setAgamaIntegration(AgamaIntegration agamaIntegration) {
        this.ad = agamaIntegration;
        EventLogger eventLogger = this.u;
        if (eventLogger != null) {
            eventLogger.setAgamaIntegration(agamaIntegration);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setAudioChannel(boolean z, boolean z2) {
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setAudioChannel(z, z2);
        }
    }

    public void setChasingFrame(boolean z) {
        LogEx.d("Exoplayer", "setChasingFrame :" + z);
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setUseSpeedControl(z);
        }
    }

    public void setFastSpeed(int i, boolean z) {
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer == null) {
            return;
        }
        this.R = i;
        this.S = z;
        PlaybackParameters playbackParameters = simpleExoPlayer.getPlaybackParameters();
        if (playbackParameters != null) {
            playbackParameters.isForward = z;
            this.w.setPlaybackParameters(playbackParameters);
        }
        if (this.S) {
            this.i.removeMessages(21);
            if (i == 1) {
                this.i.removeMessages(20);
                setRendererDisabled(1, false);
                return;
            } else {
                setRendererDisabled(1, true);
                this.i.sendEmptyMessage(20);
                return;
            }
        }
        setRendererDisabled(1, true);
        this.i.removeMessages(20);
        this.i.sendEmptyMessage(21);
    }

    public void setInitOffsetPeriod(int i) {
        LogEx.d("Exoplayer", "setInitOffsetPeriod " + i);
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setInitOffsetPeriod(i);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setInitialBufferingTime(int i) {
        DefaultLoadControl defaultLoadControl = this.P;
        if (defaultLoadControl != null) {
            defaultLoadControl.setInitBufferMs(i);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setIsNormalSeek(boolean z) {
        LogEx.d("Exoplayer", "isnormal is " + z);
        this.ag = z;
        this.w.setTsNormalSeek(z);
    }

    public void setLoadableRetryCount(int i) {
        this.ai = i;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setMaxBufferingTime(int i) {
        DefaultLoadControl defaultLoadControl = this.P;
        if (defaultLoadControl != null) {
            defaultLoadControl.setDefaultMaxBufferMs(i);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setMaxSupportTime(long j2) {
        if (this.w != null) {
            LogEx.d("Exoplayer", "maxSupportTimeS is " + j2);
            this.ap = j2;
            this.w.setMaxSupportTime(j2);
        }
    }

    public boolean setOfflineDrmInfo(String str) {
        DefaultDrmSessionManager<FrameworkMediaCrypto> defaultDrmSessionManager;
        LogEx.d("Exoplayer", "programId is " + str);
        byte[] offlineKeySetId = OfflineLicenseLoader.getInstance(this.m).getOfflineKeySetId(str);
        if (offlineKeySetId == null || (defaultDrmSessionManager = this.Q) == null) {
            return false;
        }
        defaultDrmSessionManager.setMode(0, offlineKeySetId);
        return true;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPlaySpeed(float f) {
        if (this.w == null) {
            return;
        }
        if (f >= 0.5f && f <= 2.0f) {
            setRendererDisabled(1, false);
        } else {
            setRendererDisabled(1, true);
        }
        PlaybackParameters playbackParameters = this.w.getPlaybackParameters();
        this.w.setPlaybackParameters(new PlaybackParameters(f, playbackParameters != null ? playbackParameters.pitch : 1.0f));
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPlaybackBufferingTime(int i) {
        DefaultLoadControl defaultLoadControl = this.P;
        if (defaultLoadControl != null) {
            defaultLoadControl.setPlaybackAfterRebufferMs(i);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPlayerHeader(String str) {
        DeviceInfo.setmDeviceId(str);
        DeviceInfo.setKey(com.video.androidsdk.license.a.a("exodrmtypekey"));
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPreferredAudioLanguage(String str) {
        if (this.x != null) {
            LogEx.d("Exoplayer", "PreferredAudioLanguage  is " + str);
            DefaultTrackSelector defaultTrackSelector = this.x;
            defaultTrackSelector.setParameters(defaultTrackSelector.getParameters().withPreferredAudioLanguage(str));
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPreferredSubtitleLanguage(String str) {
        if (this.x != null) {
            LogEx.d("Exoplayer", "PreferredSubtitleLanguage  is " + str);
            DefaultTrackSelector defaultTrackSelector = this.x;
            defaultTrackSelector.setParameters(defaultTrackSelector.getParameters().withPreferredTextLanguage(str));
        }
    }

    public void setRendererDisabled(int i, boolean z) {
        DefaultTrackSelector defaultTrackSelector = this.x;
        if (defaultTrackSelector == null) {
            return;
        }
        defaultTrackSelector.setRendererDisabled(i, z);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setSourceType(String str) {
        this.I = str;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setUseAdaptiveTrack() {
        if (this.x != null) {
            LogEx.d("Exoplayer", "set to use AdaptiveTrack");
            this.x.setUseAdaptiveTrack(true);
        }
    }

    public void setUseCacheDrm(boolean z) {
        LogEx.d("Exoplayer", "useCacheDrm :" + z);
        this.aa = z;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setUserLanguage(String str) {
        if (this.x != null) {
            LogEx.d("Exoplayer", "DefaultUserLanguage  is " + str);
            DefaultTrackSelector defaultTrackSelector = this.x;
            defaultTrackSelector.setParameters(defaultTrackSelector.getParameters().withDefaultUserLanguage(str));
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setVolume(float f) {
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVolume(f);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setZoomMode(ZoomModeType zoomModeType, Rect rect) {
        LogEx.d("Exoplayer", "ZoomModeType is " + zoomModeType.getValue());
        if (this.q != null) {
            if (zoomModeType.getValue() == ZoomModeType.ZOOM_MODE_FIT.getValue()) {
                this.q.setResizeMode(0);
                return;
            }
            if (zoomModeType.getValue() == ZoomModeType.ZOOM_MODE_FIXED_WIDTH.getValue()) {
                this.q.setResizeMode(1);
                return;
            }
            if (zoomModeType.getValue() == ZoomModeType.ZOOM_MODE_FIXED_HEIGHT.getValue()) {
                this.q.setResizeMode(2);
            } else if (zoomModeType.getValue() == ZoomModeType.ZOOM_MODE_ZOOM.getValue()) {
                this.q.setResizeMode(4);
            } else if (zoomModeType.getValue() == ZoomModeType.ZOOM_MODE_FILL.getValue()) {
                this.q.setResizeMode(3);
            }
        }
    }

    public void showDebugPlayInfo(FrameLayout frameLayout) {
        this.M = frameLayout;
        TextView textView = new TextView(this.m);
        textView.setPadding(10, 6, 30, 6);
        textView.setTextSize(20.0f);
        textView.setTextColor(this.m.getResources().getColor(R.color.white));
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView.setBackgroundColor(Color.argb(155, 0, 255, 10));
        textView.setGravity(3);
        this.M.addView(textView);
        this.M.setVisibility(0);
        DebugTextViewHelper debugTextViewHelper = new DebugTextViewHelper(this.w, textView);
        this.ae = debugTextViewHelper;
        if (debugTextViewHelper != null) {
            debugTextViewHelper.start();
        }
    }

    public void showRenderView() {
        RelativeLayout relativeLayout = this.T;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        SurfaceView surfaceView = this.r;
        if (surfaceView != null) {
            surfaceView.setVisibility(0);
        }
        SubtitleView subtitleView = this.s;
        if (subtitleView != null) {
            subtitleView.setVisibility(0);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void start() {
        LogEx.d("Exoplayer", "ExoPlayer start().");
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(true);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void stop() {
        super.stop();
        LogEx.d("Exoplayer", "ExoPlayer stop().");
        if (this.w != null) {
            this.i.sendEmptyMessage(6);
            this.af = true;
            this.w.setPlayWhenReady(false);
            this.w.stop();
            DefaultBandwidthMeter defaultBandwidthMeter = k;
            if (defaultBandwidthMeter != null) {
                defaultBandwidthMeter.resetEstimateBitrate(-1L);
            }
            this.aa = false;
            e();
            this.i.removeCallbacksAndMessages(null);
            this.i.obtainMessage(4, Boolean.valueOf(true ^ this.N)).sendToTarget();
        }
        ZteLibVodJni zteLibVodJni = this.ac;
        if (zteLibVodJni != null) {
            zteLibVodJni.resetplayer();
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void suspend4bg() {
        LogEx.d("Exoplayer", "ExoPlayer suspend4bg().");
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer != null) {
            this.D = true;
            this.A = simpleExoPlayer.getPlayWhenReady();
            this.w.setPlayWhenReady(false);
            this.i.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean unifySeekIsLive() {
        SimpleExoPlayer simpleExoPlayer = this.w;
        return (simpleExoPlayer != null && (simpleExoPlayer.getCurrentManifest() instanceof DashManifest) && ((DashManifest) this.w.getCurrentManifest()).dynamic && this.ao) ? false : true;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void unmute() {
        LogEx.d("Exoplayer", "misMute   " + this.ah);
        if (this.w == null || !this.ah) {
            return;
        }
        LogEx.d("Exoplayer", "setVolume    " + this.Z);
        this.ah = false;
        this.w.setVolume(Math.max(0.0f, this.Z));
    }

    public void updateDrmLicenseUlr(String str) {
        HttpMediaDrmCallback httpMediaDrmCallback = this.K;
        if (httpMediaDrmCallback != null) {
            httpMediaDrmCallback.updateDrmLicenseUlr(str);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void updateVideoSize(int i, int i2) {
    }

    private void d() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.aq = newSingleThreadExecutor;
        newSingleThreadExecutor.execute(new Runnable() { // from class: com.video.androidsdk.player.Exoplayer.3
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                if (!TextUtils.isEmpty(Exoplayer.this.W)) {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Exoplayer.this.W).openConnection();
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setInstanceFollowRedirects(true);
                        httpURLConnection.setConnectTimeout(Vr.VREvent.EventType.EMBEDVR_START_SESSION);
                        httpURLConnection.setReadTimeout(Vr.VREvent.EventType.EMBEDVR_START_SESSION);
                        try {
                            httpURLConnection.connect();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode >= 100 && responseCode < 400) {
                            LogEx.d("Exoplayer", "AdTagUri can connect");
                            i = 1;
                        } else {
                            LogEx.d("Exoplayer", "AdTagUri can't connect");
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        LogEx.d("Exoplayer", "AdTagUri can't connect");
                    }
                }
                Message message = new Message();
                message.what = 7;
                message.arg1 = i;
                Exoplayer.this.i.sendMessage(message);
            }
        });
    }

    private void e() {
        AdsLoader adsLoader = this.Y;
        if (adsLoader != null) {
            adsLoader.release();
            this.Y = null;
            this.W = null;
            this.U.removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.w == null) {
            return;
        }
        LogEx.d("Exoplayer", "fastForward");
        long duration = this.w.getDuration();
        long currentPosition = this.w.getCurrentPosition() + (this.R * 1000);
        if (duration != C.TIME_UNSET) {
            currentPosition = Math.min(currentPosition, duration);
        }
        this.w.seekTo(currentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        LogEx.d("Exoplayer", "fastBackward");
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.seekTo(Math.max(simpleExoPlayer.getCurrentPosition() - (this.R * 1000), 0L));
        }
    }

    private UUID c(String str) throws ParserException {
        LogEx.d("Exoplayer", "drm type is " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase(DrmType.DRM_TYPE_WIDEVINE)) {
            return C.WIDEVINE_UUID;
        }
        if (str.equalsIgnoreCase(DrmType.DRM_TYPE_PLAYREADY)) {
            return C.PLAYREADY_UUID;
        }
        try {
            return UUID.fromString(str);
        } catch (RuntimeException unused) {
            throw new ParserException("Unsupported drm type: " + str);
        }
    }

    private void d(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("live_hls.zte.com")) {
            LogEx.d("Exoplayer", "setUseSpeedControl true");
            this.w.setUseSpeedControl(true);
        } else {
            LogEx.d("Exoplayer", "setUseSpeedControl false");
            this.w.setUseSpeedControl(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b() {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.player.Exoplayer.b():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer != null) {
            long currentPosition = simpleExoPlayer.getCurrentPosition();
            LogEx.d("Exoplayer", "currentPositon is " + currentPosition + this);
            LogEx.d("Exoplayer", "Duration is " + this.w.getDuration() + this);
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onTime(currentPosition);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(ExoPlaybackException exoPlaybackException) {
        return exoPlaybackException.type == 2 || (exoPlaybackException.getCause() instanceof MediaCodec.CryptoException);
    }

    private void c() {
        Bundle bundle = this.y;
        if (bundle == null || !bundle.getBoolean(PlayerConstants.STR_IS_MULTICAST)) {
            return;
        }
        this.ac = new ZteLibVodJni();
        Context context = this.m;
        FileUtil.copyFileFromAssets(context, "config.ini", context.getFilesDir().getAbsolutePath(), null);
        String str = this.m.getFilesDir().getAbsolutePath() + "/config.ini";
        if (new File(str).exists()) {
            this.ac.open(str);
        } else {
            this.ac.open("");
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void seek(long j2, long j3) {
        LogEx.d("Exoplayer", "ExoPlayer currentTime ---  " + j3);
        LogEx.d("Exoplayer", "ExoPlayer position is  ---  " + j2);
        SimpleExoPlayer simpleExoPlayer = this.w;
        if (simpleExoPlayer != null) {
            if (this.ag && !this.am) {
                long duration = j2 + simpleExoPlayer.getDuration();
                com.video.androidsdk.player.common.c.a(c.a.SEEK_TIME);
                LogEx.d("Exoplayer", "ExoPlayer seek to ---  " + duration);
                this.w.seekTo(duration);
            } else if (this.am) {
                long j4 = j2 + j3;
                LogEx.d("Exoplayer", "ExoPlayer seek to ---  " + j4);
                this.w.iptvSeek(j4);
            }
            AgamaIntegration agamaIntegration = this.ad;
            if (agamaIntegration != null) {
                agamaIntegration.setViewState(10, null, null);
            }
            com.video.androidsdk.player.common.c.b(c.a.SEEK_TIME);
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(10);
                this.E = true;
            }
        }
    }

    private DrmSessionManager<FrameworkMediaCrypto> a(UUID uuid, String str, Map<String, String> map) throws UnsupportedDrmException {
        if (Util.SDK_INT < 18) {
            LogEx.w("Exoplayer", "Protected content not supported on API levels below 18");
            return null;
        }
        this.K = new HttpMediaDrmCallback(str, b((DefaultBandwidthMeter) null));
        String string = this.y.getString(PlayerConstants.STR_ENCRYPT_CONTENT);
        String string2 = this.y.getString(PlayerConstants.STR_ENCRYPT_KEY);
        if (TextUtils.isEmpty(string2)) {
            string2 = com.video.androidsdk.license.a.a("exocustomkey");
        }
        this.K.setUserToken(string, string2);
        FrameworkMediaDrm newInstance = FrameworkMediaDrm.newInstance(uuid);
        LogEx.d("Exoplayer", "widevine level is " + newInstance.getPropertyString("securityLevel"));
        DefaultDrmSessionManager<FrameworkMediaCrypto> defaultDrmSessionManager = new DefaultDrmSessionManager<>(uuid, newInstance, this.K, null, this.t, this.u);
        this.Q = defaultDrmSessionManager;
        return defaultDrmSessionManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(ExoPlaybackException exoPlaybackException) {
        return exoPlaybackException != null && exoPlaybackException.type == 0 && (exoPlaybackException.getCause() instanceof HttpDataSource.InvalidResponseCodeException);
    }

    private DataSource.Factory a(DefaultBandwidthMeter defaultBandwidthMeter) {
        return new DefaultDataSourceFactory(this.m.getApplicationContext(), defaultBandwidthMeter, b(defaultBandwidthMeter));
    }

    private MediaSource a(ZteIptvMediaInfo zteIptvMediaInfo) {
        return new ZteMediaSource(zteIptvMediaInfo, new ZteDataSourceFactory(this.ac), new DefaultExtractorsFactory(), this.t, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaSource mediaSource) {
        DefaultTrackSelector defaultTrackSelector = this.x;
        if (defaultTrackSelector != null) {
            defaultTrackSelector.clearAllSelectedTrack();
            this.x.clearSelectionOverrides();
        }
        this.w.prepare(mediaSource);
        this.B = true;
        this.H = true;
    }

    @Override // com.video.androidsdk.player.a
    public void openInternal(String str, int i) {
        LogEx.d("Exoplayer", "ExoPlayer open.");
        openInternal(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class ComponentListener implements ExoPlayer.EventListener, SimpleExoPlayer.VideoListener, AudioRendererEventListener, TextRenderer.Output, VideoRendererEventListener, VideoTimeListener {
        private ComponentListener() {
        }

        private void a(ExoPlaybackException exoPlaybackException) {
            String str;
            int i = exoPlaybackException.type;
            String str2 = "";
            if (i == 0) {
                String str3 = "Source error: " + exoPlaybackException.getSourceException().getMessage();
                if (str3 != null && str3.contains("Response code:")) {
                    String trim = exoPlaybackException.getSourceException().getMessage().replace("Response code:", "").trim();
                    if (trim.length() == 3 && trim.startsWith("4")) {
                        if (Exoplayer.this.ad != null) {
                            Exoplayer.this.ad.setMeasurement(Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_4XX, 1L);
                        }
                    } else if (trim.length() == 3 && trim.startsWith(DownloadConstant.REPORT_MSGTYPE_ADD) && Exoplayer.this.ad != null) {
                        Exoplayer.this.ad.setMeasurement(Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_5XX, 1L);
                    }
                }
                str = "E201";
                str2 = str3;
            } else if (i == 1) {
                str2 = "Render error: " + exoPlaybackException.getRendererException().getMessage();
                str = "E101";
            } else if (i != 2) {
                str = "";
            } else {
                str2 = "Unexpected error: " + exoPlaybackException.getUnexpectedException().getMessage();
                str = "E301";
            }
            LogEx.e("Exoplayer", "onPlayerError: " + str2);
            if (Exoplayer.this.ad != null) {
                Exoplayer.this.ad.setViewState(-1, str, str2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDecoderInitialized(String str, long j, long j2) {
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDisabled(DecoderCounters decoderCounters) {
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioEnabled(DecoderCounters decoderCounters) {
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioInputFormatChanged(Format format) {
            IBasePlayer.OnEventListener onEventListener = Exoplayer.this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(23);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioSessionId(int i) {
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioSinkUnderrun(int i, long j, long j2) {
        }

        @Override // com.google.android.exoplayer2.text.TextOutput
        public void onCues(List<Cue> list) {
            if (Exoplayer.this.s != null) {
                Exoplayer.this.s.onCues(list);
            }
            IBasePlayer.OnTextRenderListener onTextRenderListener = Exoplayer.this.g;
            if (onTextRenderListener != null) {
                onTextRenderListener.onCues(list);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onDroppedFrames(int i, long j) {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onLoadingChanged(boolean z) {
            LogEx.d("Exoplayer", "onLoadingChanged, isLoading is ====" + z);
            Exoplayer exoplayer = Exoplayer.this;
            if (exoplayer.f3307c != null) {
                if (exoplayer.B && z) {
                    LogEx.d("Exoplayer", "Opened " + this + Exoplayer.this.f3307c);
                    Exoplayer.this.B = false;
                    Exoplayer.this.f3307c.onStateChanged(2);
                    if (Exoplayer.this.at != 0) {
                        Exoplayer.this.w.seekForTimeShirft(Exoplayer.this.as, Exoplayer.this.at);
                        Exoplayer.this.as = -1L;
                        Exoplayer.this.at = 0L;
                    }
                    Exoplayer.this.i.removeCallbacksAndMessages(null);
                    Exoplayer.this.i.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            LogEx.w("Exoplayer", "null == mOnEventListener");
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            LogEx.d("Exoplayer", "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", Float.valueOf(playbackParameters.speed), Float.valueOf(playbackParameters.pitch)));
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlayerError(ExoPlaybackException exoPlaybackException) {
            LogEx.w("Exoplayer", "onPlayerError");
            com.video.androidsdk.player.common.b.a().remove("lastbitrate");
            a(exoPlaybackException);
            exoPlaybackException.printStackTrace();
            Exoplayer.this.i.removeCallbacksAndMessages(null);
            String str = "Exoplayer encounteredError " + exoPlaybackException.getMessage();
            if (exoPlaybackException.type == 1) {
                Exception rendererException = exoPlaybackException.getRendererException();
                if (rendererException instanceof MediaCodecRenderer.DecoderInitializationException) {
                    MediaCodecRenderer.DecoderInitializationException decoderInitializationException = (MediaCodecRenderer.DecoderInitializationException) rendererException;
                    String str2 = decoderInitializationException.decoderName;
                    if (str2 == null) {
                        if (decoderInitializationException.getCause() instanceof MediaCodecUtil.DecoderQueryException) {
                            str = "Unable to query device decoders";
                        } else {
                            str = decoderInitializationException.secureDecoderRequired ? String.format("This device does not provide a secure decoder for %1$s", decoderInitializationException.mimeType) : String.format("This device does not provide a decoder for %1$s", decoderInitializationException.mimeType);
                        }
                    } else {
                        str = String.format("Unable to instantiate decoder %1$s", str2);
                    }
                }
            }
            if (Exoplayer.this.d(exoPlaybackException)) {
                if (Exoplayer.this.Q != null && Exoplayer.this.aa && !TextUtils.isEmpty(Exoplayer.this.ab)) {
                    LogEx.d("Exoplayer", "release cached license if we got drm error");
                    Exoplayer.this.Q.releaseOfflineKey(((RenderImpl) Exoplayer.this).m, Exoplayer.this.ab);
                }
                if (exoPlaybackException.getCause() != null && (exoPlaybackException.getCause() instanceof MediaCodec.CryptoException)) {
                    LogEx.d("Exoplayer", " error code is " + ((MediaCodec.CryptoException) exoPlaybackException.getCause()).getErrorCode());
                    Exoplayer.this.f3307c.onError("-2", "[player_error]" + exoPlaybackException.getCause().getMessage());
                    return;
                }
                Exoplayer.this.f3307c.onError("-2", "[player_error]");
                return;
            }
            if (!Exoplayer.b(exoPlaybackException) && !Exoplayer.this.c(exoPlaybackException)) {
                if (exoPlaybackException != null && exoPlaybackException.type == 0 && (exoPlaybackException.getCause() instanceof HttpDataSource.HttpDataSourceException)) {
                    Exoplayer.this.f3307c.onError("-4", "[source_error]" + exoPlaybackException.getCause().getMessage());
                    return;
                }
                Exoplayer.this.f3307c.onError(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "[player_error]" + str);
                return;
            }
            if (exoPlaybackException.getCause() != null) {
                Exoplayer.this.f3307c.onError("-3", "[source_error]" + exoPlaybackException.getCause().getMessage());
                return;
            }
            Exoplayer.this.f3307c.onError("-3", "[player_error]");
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlayerStateChanged(boolean z, int i) {
            LogEx.d("player", "onPlayerStateChanged: playWhenReady == " + z);
            LogEx.d("player", "onPlayerStateChanged: playbackState == " + i + this + Exoplayer.this.f3307c);
            Exoplayer exoplayer = Exoplayer.this;
            if (exoplayer.f3307c != null) {
                if (i == 2 && z) {
                    exoplayer.F = true;
                    Exoplayer.this.f3307c.onStateChanged(7);
                }
                if (Exoplayer.this.F && i != 2) {
                    Exoplayer.this.F = false;
                    Exoplayer.this.f3307c.onStateChanged(9);
                }
                if (i == 3 && !z) {
                    Exoplayer.this.f3307c.onStateChanged(4);
                }
                if (i == 3 && z) {
                    Exoplayer.this.f3307c.onStateChanged(3);
                }
                if (i == 4) {
                    Exoplayer.this.f3307c.onStateChanged(5);
                }
                if (i == 1 && Exoplayer.this.af) {
                    Exoplayer.this.af = false;
                    Exoplayer.this.f3307c.onStateChanged(6);
                    return;
                }
                return;
            }
            LogEx.d("Exoplayer", "null == mOnEventListener");
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPositionDiscontinuity(int i) {
            LogEx.d("Exoplayer", "" + i);
        }

        @Override // com.google.android.exoplayer2.SimpleExoPlayer.VideoListener
        public void onRenderedFirstFrame() {
            LogEx.d("Exoplayer", "onRenderedFirstFrame");
            Exoplayer.this.i.obtainMessage(4, false).sendToTarget();
            if (Exoplayer.this.H) {
                Exoplayer.this.f3307c.onStateChanged(12);
                Exoplayer.this.H = false;
            }
            if (Exoplayer.this.E) {
                Exoplayer.this.f3307c.onStateChanged(11);
                Exoplayer.this.E = false;
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onRenderedFirstFrame(Surface surface) {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onRepeatModeChanged(int i) {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onSeekProcessed() {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onSeektoTimeShift(boolean z) {
            LogEx.d("Exoplayer", "isTsTV " + z);
            Exoplayer.this.ao = z;
            IBasePlayer.OnEventListener onEventListener = Exoplayer.this.f3307c;
            if (onEventListener != null) {
                if (z) {
                    onEventListener.onStateChanged(18);
                } else {
                    onEventListener.onStateChanged(19);
                }
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onShuffleModeEnabledChanged(boolean z) {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTimelineChanged(Timeline timeline, Object obj) {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDecoderInitialized(String str, long j, long j2) {
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDisabled(DecoderCounters decoderCounters) {
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoEnabled(DecoderCounters decoderCounters) {
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoInputFormatChanged(Format format) {
            IBasePlayer.OnEventListener onEventListener = Exoplayer.this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(22);
            }
        }

        @Override // com.google.android.exoplayer2.SimpleExoPlayer.VideoListener
        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            LogEx.d("Exoplayer", "onVideoSizeChanged width is " + i + "height is " + i2);
            if (Exoplayer.this.q != null) {
                Exoplayer.this.q.setAspectRatio(i2 == 0 ? 1.0f : (i * f) / i2);
            }
            IBasePlayer.OnVideoListener onVideoListener = Exoplayer.this.f;
            if (onVideoListener != null) {
                onVideoListener.onVideoSizeChanged(i, i2, i3, f);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoTimeListener
        public void onVideoTimeChanged(long j) {
            LogEx.d("Exoplayer", "CurrentTimeMs is " + j);
            Exoplayer.this.an = j;
        }

        public void vodMsgReport(String str) {
            LogEx.d("Exoplayer", "rsp is " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i = jSONObject.getInt("eventType");
                LogEx.d("Exoplayer", "eventType is " + i);
                if (i == 2026) {
                    LogEx.d("Exoplayer", "eventType is EVT_VOD_EXIT_TIMETV");
                    if (Exoplayer.this.e != null) {
                        Exoplayer.this.e.onMsgReport(19, str);
                    }
                    Exoplayer.this.f3307c.onStateChanged(19);
                    return;
                }
                if (i != 2067) {
                    switch (i) {
                        case 2001:
                            LogEx.d("Exoplayer", "eventType is EVT_VOD_PLAY_RESP");
                            if (Exoplayer.this.e != null) {
                                Exoplayer.this.e.onMsgReport(20, str);
                            }
                            if (jSONObject.has("type") && jSONObject.getString("type").matches("fastrewind")) {
                                Exoplayer.this.f3307c.onStateChanged(21);
                            }
                            Exoplayer.this.f3307c.onStateChanged(20);
                            return;
                        case 2002:
                            LogEx.d("Exoplayer", "eventType is EVT_VOD_FF_RESP");
                            if (Exoplayer.this.e != null) {
                                Exoplayer.this.e.onMsgReport(16, str);
                            }
                            Exoplayer.this.f3307c.onStateChanged(16);
                            return;
                        case 2003:
                            LogEx.d("Exoplayer", "eventType is EVT_VOD_REW_RESP");
                            if (Exoplayer.this.e != null) {
                                Exoplayer.this.e.onMsgReport(17, str);
                            }
                            Exoplayer.this.f3307c.onStateChanged(17);
                            return;
                        default:
                            return;
                    }
                }
                LogEx.d("Exoplayer", "eventType is EVT_VOD_ENTER_TIMETV");
                if (Exoplayer.this.e != null) {
                    Exoplayer.this.e.onMsgReport(18, str);
                }
                Exoplayer.this.f3307c.onStateChanged(18);
            } catch (Exception e) {
                LogEx.w("Exoplayer", e.getMessage());
                e.printStackTrace();
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlayerError(String str, String str2) {
            LogEx.w("Exoplayer", "[onPlayerError] errorcode is " + str);
            LogEx.w("Exoplayer", "[onPlayerError] errorMsg is " + str2);
            IBasePlayer.OnEventListener onEventListener = Exoplayer.this.f3307c;
            if (onEventListener != null) {
                onEventListener.onError(str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpDataSource.Factory b(DefaultBandwidthMeter defaultBandwidthMeter) {
        return new DefaultHttpDataSourceFactory(Util.getUserAgent(this.m.getApplicationContext(), "ExoPlayerSDK"), defaultBandwidthMeter);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(RelativeLayout relativeLayout, int i, boolean z) {
        this.T = relativeLayout;
        LogEx.d("Exoplayer", "start init");
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.removeAllViewsInLayout();
        this.h = (AudioManager) this.m.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        LogEx.d("Exoplayer", "init surfaceview");
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(this.m);
        this.q = aspectRatioFrameLayout;
        aspectRatioFrameLayout.setLayoutParams(layoutParams);
        if (i == 2) {
            TextureView textureView = new TextureView(this.m);
            this.J = textureView;
            textureView.setLayoutParams(layoutParams);
            this.q.addView(this.J, 0);
            this.w.setVideoTextureView(this.J);
        } else if (i == 1) {
            SurfaceView surfaceView = new SurfaceView(this.m);
            this.r = surfaceView;
            if (Build.VERSION.SDK_INT >= 17) {
                surfaceView.setSecure(true);
            }
            this.r.setLayoutParams(layoutParams);
            this.q.addView(this.r, 0);
            this.w.setVideoSurfaceView(this.r);
        }
        SubtitleView subtitleView = new SubtitleView(this.m);
        this.s = subtitleView;
        subtitleView.setLayoutParams(layoutParams);
        this.s.setStyle(new CaptionStyleCompat(-1, -1308622848, 0, 0, -1, null));
        this.s.setUserDefaultTextSize();
        this.q.addView(this.s, 1);
        View view = new View(this.m);
        this.L = view;
        view.setBackgroundColor(-16777216);
        this.L.setLayoutParams(layoutParams);
        this.N = z;
        a(!z);
        this.q.addView(this.L, 2);
        this.q.setResizeMode(0);
        relativeLayout.addView(this.q);
        relativeLayout.setBackgroundColor(this.m.getResources().getColor(R.color.background_dark));
        relativeLayout.setGravity(17);
        LogEx.d("Exoplayer", " init end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ExoPlaybackException exoPlaybackException) {
        if (exoPlaybackException.type != 0) {
            return false;
        }
        for (Throwable sourceException = exoPlaybackException.getSourceException(); sourceException != null; sourceException = sourceException.getCause()) {
            if (sourceException instanceof BehindLiveWindowException) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaSource a(MediaSource mediaSource, Uri uri) throws Exception {
        Class<?> cls = Class.forName("com.google.android.exoplayer2.ext.ima.ImaAdsLoader");
        if (this.Y == null) {
            this.Y = (AdsLoader) cls.getConstructor(Context.class, Uri.class, ImaSdkSettings.class).newInstance(this.m, uri, this.X);
            this.V = new FrameLayout(this.m);
            FrameLayout frameLayout = this.U;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
                this.U.addView(this.V);
            }
        }
        return new AdsMediaSource(mediaSource, this.v, this.Y, this.V);
    }

    private MediaSource a(Uri uri, String str) {
        String lastPathSegment;
        if (TextUtils.isEmpty(str)) {
            lastPathSegment = uri.getLastPathSegment();
        } else {
            lastPathSegment = "." + str;
        }
        int inferContentType = TextUtils.isEmpty(lastPathSegment) ? -1 : Util.inferContentType(lastPathSegment);
        LogEx.d("Exoplayer", "content type is == " + inferContentType);
        if (inferContentType == 0) {
            return new DashMediaSource(uri, a((DefaultBandwidthMeter) null), new DefaultDashChunkSource.Factory(this.v), this.ai, -1L, this.t, this.u);
        }
        if (inferContentType == 1) {
            return new SsMediaSource(uri, a((DefaultBandwidthMeter) null), new DefaultSsChunkSource.Factory(this.v), this.t, this.u);
        }
        if (inferContentType == 2) {
            return new HlsMediaSource(uri, this.v, this.t, this.u);
        }
        if (inferContentType != 3) {
            LogEx.w("Exoplayer", "Unsupported type: " + inferContentType + "Uri  ==  " + uri);
            return null;
        }
        return new ExtractorMediaSource(uri, this.v, new DefaultExtractorsFactory(), this.t, this.u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        LogEx.d("Exoplayer", "show shutterView " + z);
        View view = this.L;
        if (view != null) {
            if (z) {
                view.setVisibility(0);
            } else {
                view.setVisibility(4);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(TextureView textureView) {
        LogEx.d("Exoplayer", "start init textureview");
        this.J = textureView;
        this.w.setVideoTextureView(textureView);
        LogEx.d("Exoplayer", " init end textureview");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(SurfaceView surfaceView) {
        LogEx.d("Exoplayer", "start init");
        LogEx.d("Exoplayer", "init surfaceview");
        this.h = (AudioManager) this.m.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.r = surfaceView;
        if (Build.VERSION.SDK_INT >= 17) {
            surfaceView.setSecure(true);
        }
        this.w.setVideoSurfaceView(this.r);
        LogEx.d("Exoplayer", " init end");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(Surface surface) {
        LogEx.d("Exoplayer", "init surface " + surface);
        this.O = surface;
        this.w.setVideoSurface(surface);
    }

    public void init(RelativeLayout relativeLayout, FrameLayout frameLayout, int i, boolean z) {
        this.T = relativeLayout;
        LogEx.d("Exoplayer", "start init");
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.removeAllViewsInLayout();
        this.h = (AudioManager) this.m.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(this.m);
        this.q = aspectRatioFrameLayout;
        aspectRatioFrameLayout.setLayoutParams(layoutParams);
        LogEx.d("Exoplayer", "child count is " + this.q.getChildCount());
        if (i == 2) {
            LogEx.d("Exoplayer", "init textureview");
            TextureView textureView = new TextureView(this.m);
            this.J = textureView;
            textureView.setLayoutParams(layoutParams);
            this.q.addView(this.J, 0);
            this.w.setVideoTextureView(this.J);
        } else {
            LogEx.d("Exoplayer", "init surfaceview");
            SurfaceView surfaceView = new SurfaceView(this.m);
            this.r = surfaceView;
            if (Build.VERSION.SDK_INT >= 17) {
                surfaceView.setSecure(true);
            }
            this.r.getHolder().setFormat(-2);
            this.r.setZOrderOnTop(true);
            this.r.setZOrderMediaOverlay(true);
            this.r.setLayoutParams(layoutParams);
            this.q.addView(this.r, 0);
            this.w.setVideoSurfaceView(this.r);
            LogEx.d("Exoplayer", "child count is " + this.q.getChildCount());
        }
        SubtitleView subtitleView = new SubtitleView(this.m);
        this.s = subtitleView;
        subtitleView.setLayoutParams(layoutParams);
        this.s.setStyle(new CaptionStyleCompat(-1, 0, 0, 0, -1, null));
        this.s.setUserDefaultTextSize();
        if (frameLayout != null) {
            frameLayout.addView(this.s);
        } else {
            this.q.addView(this.s);
            LogEx.d("Exoplayer", "subtitle frame is null ,we can not display subtitle");
        }
        View view = new View(this.m);
        this.L = view;
        view.setBackgroundColor(-16777216);
        this.L.setLayoutParams(layoutParams);
        this.N = z;
        a(!z);
        this.q.addView(this.L);
        this.q.setResizeMode(0);
        relativeLayout.addView(this.q);
        relativeLayout.setBackgroundColor(this.m.getResources().getColor(R.color.background_dark));
        relativeLayout.setGravity(17);
        LogEx.d("Exoplayer", " init end");
    }
}
