package com.video.androidsdk.player;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.widget.RelativeLayout;
import com.media.player.fvplayer.FVGlSurfaceView;
import com.media.player.fvplayer.FVPlayer;
import com.media.player.fvplayer.IMediaPlayer;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.IBasePlayer;
import com.video.androidsdk.player.common.AssetStatus;
import com.video.androidsdk.player.common.AssetType;
import com.video.androidsdk.player.common.DecoderType;
import com.video.androidsdk.player.common.SubtitleHorizontal;
import com.video.androidsdk.player.common.SubtitleVertical;
import com.video.androidsdk.player.common.ZoomModeType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: FvPlayer.java */
/* loaded from: classes.dex */
public class l extends a {
    public static String h = "FvPlayer";
    private boolean B;
    Map<String, Map<String, Map<String, String>>> i;
    String j;
    private FVPlayer p;
    private FVGlSurfaceView q;
    private SurfaceHolder r;
    private RelativeLayout s;
    private Surface w;
    private int t = 0;
    private boolean u = false;
    private boolean v = true;
    private boolean x = false;
    private String y = null;
    private boolean z = false;
    private boolean A = false;
    private boolean C = false;
    private IMediaPlayer.OnPreparedListener D = new m(this);
    private IMediaPlayer.OnBufferingUpdateListener E = new o(this);
    private IMediaPlayer.OnCompletionListener F = new p(this);
    private IMediaPlayer.OnSeekCompleteListener G = new q(this);
    private IMediaPlayer.OnErrorListener H = new r(this);
    private IMediaPlayer.OnInfoListener I = new s(this);
    private IMediaPlayer.OnVideoSizeChangedListener J = new t(this);
    private IMediaPlayer.OnSubBitmapListener K = new u(this);
    protected Handler k = new v(this);

    public l(Context context, Bundle bundle) {
        this.B = false;
        if (bundle != null && bundle.containsKey("isLive")) {
            this.B = bundle.getBoolean("isLive");
        }
        this.m = context;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        LogEx.d(h, "mPath is " + this.y);
        if (!this.v) {
            LogEx.w(h, "cannot find watermark, so cannot play");
            return;
        }
        try {
            c(this.y);
            if (this.w != null) {
                LogEx.d(h, "setSurface(mSurface)  " + this.w);
                this.p.setSurface(this.w);
            }
            this.p.setAudioStreamType(3);
            this.p.prepareAsync();
            LogEx.d(h, "prepareAsync");
            this.t = 2;
            this.f3307c.onStateChanged(2);
        } catch (IllegalArgumentException e) {
            LogEx.w(h, "Unable to open content: " + this.y);
            this.t = -1;
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onError(String.valueOf(1), "Unable to open content");
            }
            e.printStackTrace();
        } catch (IllegalStateException e2) {
            LogEx.w(h, "Unable to open content: " + this.y);
            this.t = -1;
            IBasePlayer.OnEventListener onEventListener2 = this.f3307c;
            if (onEventListener2 != null) {
                onEventListener2.onError(String.valueOf(1), "Unable to open content");
            }
            e2.printStackTrace();
        }
        this.A = true;
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
        return 0;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getAssetIndex(AssetType assetType, AssetStatus assetStatus) {
        return 0;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getAudioChannel() {
        return 0;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getAudioInfoArray(ArrayList<String> arrayList) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getBufferedPosition() {
        return 0L;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getCurrentPosition() {
        FVPlayer fVPlayer = this.p;
        if (fVPlayer == null) {
            return 0L;
        }
        long currentPosition = fVPlayer.getCurrentPosition();
        LogEx.d(h, "Position  is  " + currentPosition);
        return currentPosition;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getDuration() {
        return 0L;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public float getPlaySpeed() {
        return 0.0f;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getPlayerState() {
        return this.t;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public String getProbeKP() {
        return super.getProbeKP();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getScreenBrightness() {
        return 0;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getSeekOff() {
        return 0L;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public float getSphericalViewSensorRoll() {
        return 0.0f;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getSubtitleInfoArray(ArrayList<String> arrayList) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public SurfaceView getSurfaceView() {
        return super.getSurfaceView();
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getUTCPosition() {
        return 0L;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getVideoHeight() {
        return 0;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getVideoInfoArray(ArrayList<String> arrayList) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getVideoWidth() {
        return 0;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public float getVolume() {
        return 0.0f;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(Surface surface) {
        super.init(surface);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean isPlaying() {
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean isTrackAvailable(AssetType assetType, int i) {
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void mute() {
    }

    @Override // com.video.androidsdk.player.a
    public void openInternal(String str) {
        LogEx.d(h, " url is " + str);
        this.y = str;
        if (TextUtils.isEmpty(str)) {
            LogEx.w(h, "player url is null");
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(-1);
                return;
            }
            return;
        }
        if (this.p != null) {
            if (this.x && !this.z) {
                d();
            } else {
                this.k.sendEmptyMessage(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.video.androidsdk.player.a
    public void openInternal(String str, int i) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean openSensor() {
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void pause() {
        FVPlayer fVPlayer = this.p;
        if (fVPlayer != null) {
            fVPlayer.pause();
            this.t = 4;
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void release() {
        if (this.p != null) {
            this.s.removeAllViews();
            this.p.release();
            this.p = null;
            this.t = 0;
            this.k.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void resume() {
        FVPlayer fVPlayer = this.p;
        if (fVPlayer != null) {
            fVPlayer.start();
            this.t = 3;
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void resume4bg() {
        FVPlayer fVPlayer = this.p;
        if (fVPlayer != null) {
            fVPlayer.start();
            this.t = 3;
            this.k.sendEmptyMessage(2);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void seek(long j) {
        FVPlayer fVPlayer = this.p;
        if (fVPlayer != null) {
            fVPlayer.seekTo(j);
            LogEx.d(h, "Position  is  " + j);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectAudioByIndex(int i) {
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectSubtitleByIndex(int i) {
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectVideoByIndex(int i) {
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setAudioChannel(int i) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setAudioChannel(boolean z, boolean z2) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setAutoSpeed(boolean z) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setDecoderType(DecoderType decoderType, DecoderType decoderType2) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setFadingVolumn(float f, long j) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setInitialBufferingTime(int i) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setLooping(boolean z) {
        FVPlayer fVPlayer = this.p;
        if (fVPlayer != null) {
            fVPlayer.setLooping(z);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setMaxAllBufferSize(long j) {
        this.p.setMaxBufferSize(j);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setMaxBufferSize(long j) {
        this.p.setMaxBufferSize(j);
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setMaxBufferingTime(int i) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setOnEventListener(IBasePlayer.OnEventListener onEventListener) {
        LogEx.d(h, "setOnEventListener");
        this.f3307c = onEventListener;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPlaySpeed(float f) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPlaybackBufferingTime(int i) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPreferredAudioLanguage(String str) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPreferredBitrate(long j) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPreferredSubtitleLanguage(String str) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setRenderTypeOpenGL() {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setScale(float f) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setScreenBrightness(int i) {
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
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setVolume(float f) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setZoomMode(ZoomModeType zoomModeType, Rect rect) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void start() {
        if (this.p != null) {
            LogEx.d(h, "FVPlayer.start");
            this.p.start();
            this.t = 3;
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void stop() {
        FVPlayer fVPlayer = this.p;
        if (fVPlayer != null) {
            fVPlayer.stop();
            this.t = 0;
            this.k.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void stopSphericalView() {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void suspend4bg() {
        FVPlayer fVPlayer = this.p;
        if (fVPlayer != null) {
            fVPlayer.pause();
            this.t = 4;
            this.k.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void unmute() {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void updateVideoSize(int i, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        FVPlayer fVPlayer;
        if (this.u || (fVPlayer = this.p) == null) {
            return;
        }
        long currentPosition = fVPlayer.getCurrentPosition();
        LogEx.d(h, "currentPositon is " + currentPosition);
        LogEx.d(h, "Duration is " + this.p.getDuration());
        IBasePlayer.OnEventListener onEventListener = this.f3307c;
        if (onEventListener != null) {
            onEventListener.onTime(currentPosition);
        }
    }

    private void b() {
        LogEx.d(h, "init surfaceview");
        this.q = new FVGlSurfaceView(this.m);
        this.p = new FVPlayer(this.m, this.q, this.B);
        this.q.setOnSurfaceCreated(new n(this));
        this.p.setOnPreparedListener(this.D);
        this.p.setOnBufferingUpdateListener(this.E);
        this.p.setOnCompletionListener(this.F);
        this.p.setOnSeekCompleteListener(this.G);
        this.p.setOnErrorListener(this.H);
        this.p.setOnInfoListener(this.I);
        this.p.setOnVideoSizeChangedListener(this.J);
        this.p.setOnSubBitmapListener(this.K);
    }

    public void c(String str) {
        try {
            this.p.setDataSource(str);
            Thread.sleep(300L);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        LogEx.d(h, "serverUrl is " + this.y);
        this.t = 0;
        Map<String, Map<String, Map<String, String>>> eventList = this.p.getEventList();
        this.i = eventList;
        Iterator<String> it2 = eventList.keySet().iterator();
        if (it2.hasNext()) {
            this.j = it2.next();
        }
        LogEx.d(h, "mCurrentEventCode is " + this.j);
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
        this.p.setVodUrl(this.p.getVodUrlByEventCode(this.j));
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(RelativeLayout relativeLayout) {
        LogEx.d(h, "start init");
        if (relativeLayout == null) {
            LogEx.d(h, "layout is null, return");
            return;
        }
        relativeLayout.removeAllViews();
        this.s = relativeLayout;
        c();
        this.s.addView(this.q);
        LogEx.d(h, " init end");
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
        LogEx.d(h, "start init");
        if (relativeLayout == null) {
            LogEx.d(h, "layout is null, return");
        } else {
            relativeLayout.removeAllViews();
            LogEx.d(h, " init end");
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(SurfaceView surfaceView) {
        SurfaceHolder holder = surfaceView.getHolder();
        this.r = holder;
        FVPlayer fVPlayer = this.p;
        if (fVPlayer != null) {
            fVPlayer.setDisplay(holder);
        }
    }

    private void c() {
        if (this.r == null) {
            LogEx.d(h, "add callback");
            SurfaceHolder holder = this.q.getHolder();
            this.r = holder;
            holder.setFormat(1);
        }
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
