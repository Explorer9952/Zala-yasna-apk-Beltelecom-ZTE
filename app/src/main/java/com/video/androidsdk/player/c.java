package com.video.androidsdk.player;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.google.android.exoplayer2.util.MimeTypes;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.IBasePlayer;
import com.video.androidsdk.player.common.AssetStatus;
import com.video.androidsdk.player.common.AssetType;
import com.video.androidsdk.player.common.DecoderType;
import com.video.androidsdk.player.common.SubtitleHorizontal;
import com.video.androidsdk.player.common.SubtitleVertical;
import com.video.androidsdk.player.common.ZoomModeType;
import com.video.androidsdk.player.common.c;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: AndroidMediaPlayer.java */
/* loaded from: classes.dex */
public class c extends com.video.androidsdk.player.a {
    private TextureView A;
    private Surface B;
    private int k;
    private AudioManager z;
    private android.media.MediaPlayer j = null;
    private String p = null;
    private SurfaceView q = null;
    private SurfaceHolder r = null;
    private boolean s = false;
    protected boolean h = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private SurfaceHolder.Callback x = null;
    private int y = 0;
    private boolean C = false;
    private MediaPlayer.OnCompletionListener D = new d(this);
    private MediaPlayer.OnErrorListener E = new e(this);
    private MediaPlayer.OnInfoListener F = new f(this);
    private MediaPlayer.OnPreparedListener G = new g(this);
    private MediaPlayer.OnSeekCompleteListener H = new h(this);
    private MediaPlayer.OnVideoSizeChangedListener I = new i(this);
    private MediaPlayer.OnBufferingUpdateListener J = new j(this);
    protected Handler i = new k(this);

    /* compiled from: AndroidMediaPlayer.java */
    /* loaded from: classes.dex */
    private class a implements TextureView.SurfaceTextureListener {
        private a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            LogEx.d("AndroidMediaPlayer", "mbIsSurfaceCreated ");
            c.this.s = true;
            c.this.B = new Surface(surfaceTexture);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            LogEx.d("AndroidMediaPlayer", "SurfaceTextureDestroyed ");
            c.this.s = false;
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            LogEx.d("AndroidMediaPlayer", "onSurfaceTextureSizeChanged ");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        /* synthetic */ a(c cVar, d dVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidMediaPlayer.java */
    /* loaded from: classes.dex */
    public class b implements SurfaceHolder.Callback {
        private b() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            LogEx.d("AndroidMediaPlayer", "Surface Changed");
            c.this.s = true;
            LogEx.i("Surface Change:::", "---Width---:" + i2 + "---height--:" + i3);
            if (c.this.j != null) {
                c.this.j.setDisplay(surfaceHolder);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            LogEx.d("AndroidMediaPlayer", "Surface Created");
            c.this.s = true;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            LogEx.d("AndroidMediaPlayer", "Surface Destroyed");
            c.this.s = false;
        }

        /* synthetic */ b(c cVar, d dVar) {
            this();
        }
    }

    public c(Context context) {
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
        return 0;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getAssetIndex(AssetType assetType, AssetStatus assetStatus) {
        return 0;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getAudioInfoArray(ArrayList<String> arrayList) {
        MediaPlayer.TrackInfo[] trackInfoArr = new MediaPlayer.TrackInfo[0];
        try {
            trackInfoArr = this.j.getTrackInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < trackInfoArr.length; i++) {
            MediaPlayer.TrackInfo trackInfo = trackInfoArr[i];
            if (2 == trackInfo.getTrackType()) {
                String language = trackInfo.getLanguage();
                if (!TextUtils.isEmpty(language) && !TextUtils.equals(language, "und")) {
                    arrayList.add(language + "," + i);
                }
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getCurrentPosition() {
        if (this.j == null || !b()) {
            return 0L;
        }
        long currentPosition = this.j.getCurrentPosition();
        LogEx.d("AndroidMediaPlayer", "AndroidMediaPlayer Position  is  " + currentPosition);
        return currentPosition;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public String getDRMUniqueIdentifier() {
        return null;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public long getDuration() {
        if (this.j == null || !b()) {
            return -1L;
        }
        long duration = this.j.getDuration();
        LogEx.d("AndroidMediaPlayer", "AndroidMediaPlayer duration  is  " + duration);
        if (duration < 0) {
            return 0L;
        }
        return duration;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getPlayerState() {
        return this.y;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getScreenBrightness() {
        return 0;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public float getSphericalViewSensorRoll() {
        return 0.0f;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getSubtitleInfoArray(ArrayList<String> arrayList) {
        MediaPlayer.TrackInfo[] trackInfoArr = new MediaPlayer.TrackInfo[0];
        try {
            trackInfoArr = this.j.getTrackInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < trackInfoArr.length; i++) {
            MediaPlayer.TrackInfo trackInfo = trackInfoArr[i];
            if (4 == trackInfo.getTrackType()) {
                String language = trackInfo.getLanguage();
                if (!TextUtils.isEmpty(language) && !TextUtils.equals(language, "und")) {
                    arrayList.add(language + "," + i);
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
        return 0L;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getVideoHeight() {
        if (this.j == null || !b()) {
            return 0;
        }
        int videoHeight = this.j.getVideoHeight();
        LogEx.d("AndroidMediaPlayer", "AndroidMediaPlayer VideoHeight  is  " + videoHeight);
        if (videoHeight < 0) {
            return 0;
        }
        return videoHeight;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void getVideoInfoArray(ArrayList<String> arrayList) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public int getVideoWidth() {
        if (this.j == null || !b()) {
            return 0;
        }
        int videoWidth = this.j.getVideoWidth();
        LogEx.d("AndroidMediaPlayer", "AndroidMediaPlayer VideoWidth  is  " + videoWidth);
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
        LogEx.d("AndroidMediaPlayer", "getVolume");
        int streamVolume = this.z.getStreamVolume(1);
        LogEx.d("AndroidMediaPlayer", "Volume is " + streamVolume);
        return streamVolume;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(Surface surface) {
        android.media.MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(SurfaceView surfaceView) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(TextureView textureView) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean isPlaying() {
        android.media.MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer == null) {
            return false;
        }
        boolean isPlaying = mediaPlayer.isPlaying();
        LogEx.d("AndroidMediaPlayer", "AndroidMediaPlayer status  is  " + isPlaying);
        return isPlaying;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean isTrackAvailable(AssetType assetType, int i) {
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void mute() {
        AudioManager audioManager = this.z;
        if (audioManager == null || 2 != audioManager.getRingerMode()) {
            return;
        }
        LogEx.d("AndroidMediaPlayer", "mute");
        this.z.setStreamMute(3, true);
    }

    @Override // com.video.androidsdk.player.a
    public void openInternal(String str) {
        LogEx.d("AndroidMediaPlayer", "AndroidMediaPlayer open.");
        this.p = str;
        if (TextUtils.isEmpty(str)) {
            LogEx.w("AndroidMediaPlayer", "player url is null");
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(-1);
                return;
            }
            return;
        }
        if (this.j != null) {
            this.i.sendEmptyMessage(1);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean openSensor() {
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void pause() {
        android.media.MediaPlayer mediaPlayer;
        LogEx.d("AndroidMediaPlayer", "AndroidMediaPlayer pause().");
        if (b() && (mediaPlayer = this.j) != null && mediaPlayer.isPlaying()) {
            LogEx.d("AndroidMediaPlayer", "The player status is " + this.j.isPlaying());
            com.video.androidsdk.player.common.c.a(c.a.PAUSE_TIME);
            this.j.pause();
            com.video.androidsdk.player.common.c.b(c.a.PAUSE_TIME);
            this.y = 4;
            return;
        }
        LogEx.e("AndroidMediaPlayer", "player status is error");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void release() {
        super.release();
        LogEx.d("AndroidMediaPlayer", "AndroidMediaPlayer release().");
        android.media.MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(null);
            this.j.setOnErrorListener(null);
            this.j.setOnInfoListener(null);
            this.j.setOnPreparedListener(null);
            this.j.setOnSeekCompleteListener(null);
            this.j.setOnVideoSizeChangedListener(null);
            this.j.setOnBufferingUpdateListener(null);
            this.j.release();
            this.j = null;
            this.y = 0;
            this.v = true;
            this.i.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void resume() {
        LogEx.d("AndroidMediaPlayer", "AndroidMediaPlayer resume().");
        if (this.j != null && 4 == this.y) {
            LogEx.d("AndroidMediaPlayer", "STATE_PAUSED == miPlayerStatus");
            com.video.androidsdk.player.common.c.a(c.a.RUN_TIME);
            this.j.start();
            com.video.androidsdk.player.common.c.b(c.a.RUN_TIME);
            this.y = 3;
            return;
        }
        LogEx.e("AndroidMediaPlayer", "player status is error");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void resume4bg() {
        if (this.j != null) {
            LogEx.d("AndroidMediaPlayer", "AndroidMediaPlayer resume, the view is " + this.q);
            d();
            if (this.u) {
                this.i.sendEmptyMessage(3);
            }
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void seek(long j) {
        if (this.j == null || !b()) {
            return;
        }
        LogEx.d("AndroidMediaPlayer", "AndroidMediaPlayer seek to ---  " + j);
        com.video.androidsdk.player.common.c.a(c.a.SEEK_TIME);
        this.j.seekTo((int) j);
        com.video.androidsdk.player.common.c.b(c.a.SEEK_TIME);
        IBasePlayer.OnEventListener onEventListener = this.f3307c;
        if (onEventListener != null) {
            onEventListener.onStateChanged(10);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void seek(long j, long j2, long j3) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectAudioByIndex(int i) {
        android.media.MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer == null) {
            return true;
        }
        mediaPlayer.selectTrack(i);
        return true;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectSubtitleByIndex(int i) {
        android.media.MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer == null) {
            return true;
        }
        mediaPlayer.selectTrack(i);
        return true;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public boolean selectVideoByIndex(int i) {
        return false;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setAudioChannel(boolean z, boolean z2) {
        if (this.j != null) {
            float volume = getVolume();
            float streamMaxVolume = this.z.getStreamMaxVolume(1);
            this.j.setVolume(z ? volume / streamMaxVolume : 0.0f, z2 ? volume / streamMaxVolume : 0.0f);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setDRMInfo(String str, String str2) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setDecoderType(DecoderType decoderType, DecoderType decoderType2) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setInitialBufferingTime(int i) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setMaxBufferingTime(int i) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPlaybackBufferingTime(int i) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setPreferredAudioLanguage(String str) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setRenderTypeOpenGL() {
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
    public void setVolume(float f) {
        if (this.j != null) {
            LogEx.d("AndroidMediaPlayer", "setVolume");
            this.z.setRingerMode(2);
            this.z.setStreamVolume(3, (int) f, 0);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void setZoomMode(ZoomModeType zoomModeType, Rect rect) {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void start() {
        if (b() && this.j != null) {
            LogEx.d("AndroidMediaPlayer", "AndroidMediaPlayer start().");
            com.video.androidsdk.player.common.c.a(c.a.RUN_TIME);
            this.j.start();
            com.video.androidsdk.player.common.c.b(c.a.RUN_TIME);
            this.y = 3;
            this.f3307c.onStateChanged(3);
            return;
        }
        LogEx.e("AndroidMediaPlayer", "player status is error");
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void startWriteLog() {
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void stop() {
        super.stop();
        if (this.j != null) {
            LogEx.d("AndroidMediaPlayer", "AndroidMediaPlayer stop()");
            this.j.stop();
            this.y = 6;
            this.j.reset();
            this.y = 0;
            this.w = true;
            this.u = false;
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
            LogEx.d("AndroidMediaPlayer", "AndroidMediaPlayer suspend()");
            LogEx.d("AndroidMediaPlayer", "AndroidMediaPlayer -------- misPlayerRun is " + this.u);
            if (this.u) {
                this.t = true;
                this.h = this.j.isPlaying();
                LogEx.d("AndroidMediaPlayer", "AndroidMediaPlayer -------- mIsPlayingWhenSuspend is " + this.h);
                if (this.h && 3 == this.y) {
                    this.h = true;
                    this.j.pause();
                    this.y = 4;
                }
                this.i.removeCallbacksAndMessages(null);
            }
            if (this.C) {
                return;
            }
            e();
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void unmute() {
        if (this.z != null) {
            LogEx.d("AndroidMediaPlayer", "mute");
            this.z.setStreamMute(3, false);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void updateVideoSize(int i, int i2) {
    }

    private void d() {
        if (this.x == null) {
            LogEx.d("AndroidMediaPlayer", "add callback");
            this.x = new b(this, null);
            SurfaceHolder holder = this.q.getHolder();
            this.r = holder;
            holder.addCallback(this.x);
            this.r.setFormat(1);
        }
    }

    private void e() {
        if (this.x != null) {
            LogEx.d("AndroidMediaPlayer", "remove callback");
            SurfaceHolder holder = this.q.getHolder();
            this.r = holder;
            holder.removeCallback(this.x);
            this.x = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        LogEx.d("AndroidMediaPlayer", "mPath is " + this.p);
        try {
            this.j.setDataSource(this.p);
            if (this.C && this.B != null) {
                LogEx.d("AndroidMediaPlayer", "setSurface(mSurface)");
                this.j.setSurface(this.B);
            } else {
                LogEx.d("AndroidMediaPlayer", "setDisplay(mSurfaceHolder);");
                this.j.setDisplay(this.r);
            }
            this.j.setAudioStreamType(3);
            this.j.prepareAsync();
            this.y = 1;
        } catch (IOException e) {
            LogEx.w("AndroidMediaPlayer", "Unable to open content: " + this.p);
            this.y = -1;
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onError(String.valueOf(1), "Unable to open content");
            }
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            LogEx.w("AndroidMediaPlayer", "Unable to open content: " + this.p);
            this.y = -1;
            IBasePlayer.OnEventListener onEventListener2 = this.f3307c;
            if (onEventListener2 != null) {
                onEventListener2.onError(String.valueOf(1), "Unable to open content");
            }
            e2.printStackTrace();
        } catch (IllegalStateException e3) {
            LogEx.w("AndroidMediaPlayer", "Unable to open content: " + this.p);
            this.y = -1;
            IBasePlayer.OnEventListener onEventListener3 = this.f3307c;
            if (onEventListener3 != null) {
                onEventListener3.onError(String.valueOf(1), "Unable to open content");
            }
            e3.printStackTrace();
        }
        this.u = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        android.media.MediaPlayer mediaPlayer;
        if (this.w || (mediaPlayer = this.j) == null) {
            return;
        }
        long currentPosition = mediaPlayer.getCurrentPosition();
        LogEx.d("AndroidMediaPlayer", "currentPositon is " + currentPosition);
        LogEx.d("AndroidMediaPlayer", "Duration is " + this.j.getDuration());
        IBasePlayer.OnEventListener onEventListener = this.f3307c;
        if (onEventListener != null) {
            onEventListener.onTime(currentPosition);
        }
    }

    protected boolean b() {
        int i;
        return (this.j == null || (i = this.y) == -1 || i == 0 || i == 1) ? false : true;
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(RelativeLayout relativeLayout) {
        LogEx.d("AndroidMediaPlayer", "start init");
        if (relativeLayout == null) {
            LogEx.d("AndroidMediaPlayer", "layout is null, return");
            return;
        }
        relativeLayout.removeAllViews();
        this.z = (AudioManager) this.m.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.C = false;
        LogEx.d("AndroidMediaPlayer", "init surfaceview");
        this.q = new SurfaceView(this.m);
        this.q.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        relativeLayout.addView(this.q);
        d();
        LogEx.d("AndroidMediaPlayer", " init end");
    }

    protected void a() {
        Log.i("AndroidMediaPlayer", "Create new instance of AndroidMediaPlayer");
        LogEx.d("AndroidMediaPlayer", "Create new instance of AndroidMediaPlayer");
        try {
            android.media.MediaPlayer mediaPlayer = new android.media.MediaPlayer();
            this.j = mediaPlayer;
            mediaPlayer.setOnCompletionListener(this.D);
            this.j.setOnErrorListener(this.E);
            this.j.setOnInfoListener(this.F);
            this.j.setOnPreparedListener(this.G);
            this.j.setOnSeekCompleteListener(this.H);
            this.j.setOnVideoSizeChangedListener(this.I);
            this.j.setOnBufferingUpdateListener(this.J);
        } catch (IllegalArgumentException e) {
            LogEx.w("AndroidMediaPlayer", "failed to create AndroidMediaPlayer");
            this.y = -1;
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onError(String.valueOf(1), "failed to create AndroidMediaPlayer");
            }
            e.printStackTrace();
        } catch (IllegalStateException e2) {
            LogEx.w("AndroidMediaPlayer", "create AndroidMediaPlayer failed");
            this.y = -1;
            IBasePlayer.OnEventListener onEventListener2 = this.f3307c;
            if (onEventListener2 != null) {
                onEventListener2.onError(String.valueOf(1), "create AndroidMediaPlayer failed");
            }
            e2.printStackTrace();
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void seek(long j, long j2) {
        if (this.j == null || !b()) {
            return;
        }
        LogEx.d("AndroidMediaPlayer", "AndroidMediaPlayer seek to ---  " + j);
        com.video.androidsdk.player.common.c.a(c.a.SEEK_TIME);
        this.j.seekTo(-((int) j));
        com.video.androidsdk.player.common.c.b(c.a.SEEK_TIME);
        IBasePlayer.OnEventListener onEventListener = this.f3307c;
        if (onEventListener != null) {
            onEventListener.onStateChanged(10);
        }
    }

    @Override // com.video.androidsdk.player.a
    public void openInternal(String str, int i) {
        LogEx.d("AndroidMediaPlayer", "AndroidMediaPlayer open.");
        this.p = str;
        if (TextUtils.isEmpty(str)) {
            LogEx.w("AndroidMediaPlayer", "player url is null");
            IBasePlayer.OnEventListener onEventListener = this.f3307c;
            if (onEventListener != null) {
                onEventListener.onStateChanged(-1);
                return;
            }
            return;
        }
        if (this.j != null) {
            this.i.sendEmptyMessage(1);
        }
    }

    @Override // com.video.androidsdk.player.a, com.video.androidsdk.player.IBasePlayer
    public void init(RelativeLayout relativeLayout, int i, boolean z) {
        if (relativeLayout == null) {
            LogEx.d("AndroidMediaPlayer", "layout is null, return");
            return;
        }
        relativeLayout.removeAllViews();
        this.z = (AudioManager) this.m.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (i == 1) {
            Log.d("AndroidMediaPlayer", "init SurfaceView");
            this.C = false;
            this.q = new SurfaceView(this.m);
            this.q.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            relativeLayout.addView(this.q);
            d();
            return;
        }
        Log.d("AndroidMediaPlayer", "init TextureView");
        this.C = true;
        this.A = new TextureView(this.m);
        this.A.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.A.setSurfaceTextureListener(new a(this, null));
        relativeLayout.addView(this.A);
    }
}
