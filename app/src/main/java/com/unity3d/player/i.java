package com.unity3d.player;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.MediaController;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public final class i extends FrameLayout implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback, MediaController.MediaPlayerControl {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f3014a = false;

    /* renamed from: b, reason: collision with root package name */
    private final Context f3015b;

    /* renamed from: c, reason: collision with root package name */
    private final SurfaceView f3016c;

    /* renamed from: d, reason: collision with root package name */
    private final SurfaceHolder f3017d;
    private final String e;
    private final int f;
    private final int g;
    private final boolean h;
    private final long i;
    private final long j;
    private final FrameLayout k;
    private final Display l;
    private int m;
    private int n;
    private int o;
    private int p;
    private MediaPlayer q;
    private MediaController r;
    private boolean s;
    private boolean t;
    private int u;
    private boolean v;
    private boolean w;
    private a x;
    private volatile int y;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(Context context, String str, int i, int i2, int i3, boolean z, long j, long j2, a aVar) {
        super(context);
        this.s = false;
        this.t = false;
        this.u = 0;
        this.v = false;
        this.w = false;
        this.y = 0;
        this.x = aVar;
        this.f3015b = context;
        this.k = this;
        SurfaceView surfaceView = new SurfaceView(context);
        this.f3016c = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        this.f3017d = holder;
        holder.addCallback(this);
        this.f3017d.setType(3);
        this.k.setBackgroundColor(i);
        this.k.addView(this.f3016c);
        this.l = ((WindowManager) this.f3015b.getSystemService("window")).getDefaultDisplay();
        this.e = str;
        this.f = i2;
        this.g = i3;
        this.h = z;
        this.i = j;
        this.j = j2;
        if (f3014a) {
            a("fileName: " + this.e);
        }
        if (f3014a) {
            a("backgroundColor: " + i);
        }
        if (f3014a) {
            a("controlMode: " + this.f);
        }
        if (f3014a) {
            a("scalingMode: " + this.g);
        }
        if (f3014a) {
            a("isURL: " + this.h);
        }
        if (f3014a) {
            a("videoOffset: " + this.i);
        }
        if (f3014a) {
            a("videoLength: " + this.j);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    private void a(int i) {
        this.y = i;
        a aVar = this.x;
        if (aVar != null) {
            aVar.a(this.y);
        }
    }

    private static void a(String str) {
        Log.i("Video", "VideoPlayer: " + str);
    }

    private void b() {
        FileInputStream fileInputStream;
        MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer != null) {
            mediaPlayer.setDisplay(this.f3017d);
            if (this.v) {
                return;
            }
            if (f3014a) {
                a("Resuming playback");
            }
            this.q.start();
            return;
        }
        a(0);
        doCleanUp();
        try {
            MediaPlayer mediaPlayer2 = new MediaPlayer();
            this.q = mediaPlayer2;
            if (this.h) {
                mediaPlayer2.setDataSource(this.f3015b, Uri.parse(this.e));
            } else {
                if (this.j != 0) {
                    fileInputStream = new FileInputStream(this.e);
                    this.q.setDataSource(fileInputStream.getFD(), this.i, this.j);
                } else {
                    try {
                        AssetFileDescriptor openFd = getResources().getAssets().openFd(this.e);
                        this.q.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                        openFd.close();
                    } catch (IOException unused) {
                        fileInputStream = new FileInputStream(this.e);
                        this.q.setDataSource(fileInputStream.getFD());
                    }
                }
                fileInputStream.close();
            }
            this.q.setDisplay(this.f3017d);
            this.q.setScreenOnWhilePlaying(true);
            this.q.setOnBufferingUpdateListener(this);
            this.q.setOnCompletionListener(this);
            this.q.setOnPreparedListener(this);
            this.q.setOnVideoSizeChangedListener(this);
            this.q.setAudioStreamType(3);
            this.q.prepare();
            if (this.f == 0 || this.f == 1) {
                MediaController mediaController = new MediaController(this.f3015b);
                this.r = mediaController;
                mediaController.setMediaPlayer(this);
                this.r.setAnchorView(this);
                this.r.setEnabled(true);
                this.r.show();
            }
        } catch (Exception e) {
            if (f3014a) {
                a("error: " + e.getMessage() + e);
            }
            a(2);
        }
    }

    private void c() {
        if (isPlaying()) {
            return;
        }
        a(1);
        if (f3014a) {
            a("startVideoPlayback");
        }
        updateVideoLayout();
        if (this.v) {
            return;
        }
        start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a() {
        return this.v;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekBackward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekForward() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void destroyPlayer() {
        if (f3014a) {
            a("destroyPlayer");
        }
        if (!this.v) {
            pause();
        }
        doCleanUp();
    }

    protected final void doCleanUp() {
        MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.q = null;
        }
        this.o = 0;
        this.p = 0;
        this.t = false;
        this.s = false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getBufferPercentage() {
        if (this.h) {
            return this.u;
        }
        return 100;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getDuration() {
        MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getDuration();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean isPlaying() {
        boolean z = this.t && this.s;
        MediaPlayer mediaPlayer = this.q;
        return mediaPlayer == null ? !z : mediaPlayer.isPlaying() || !z;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        if (f3014a) {
            a("onBufferingUpdate percent:" + i);
        }
        this.u = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (f3014a) {
            a("onCompletion called");
        }
        destroyPlayer();
        a(3);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 && (this.f != 2 || i == 0 || keyEvent.isSystem())) {
            MediaController mediaController = this.r;
            return mediaController != null ? mediaController.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
        }
        destroyPlayer();
        a(3);
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        if (f3014a) {
            a("onPrepared called");
        }
        this.t = true;
        if (1 == 0 || !this.s) {
            return;
        }
        c();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (this.f != 2 || action != 0) {
            MediaController mediaController = this.r;
            return mediaController != null ? mediaController.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
        }
        destroyPlayer();
        a(3);
        return true;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        if (f3014a) {
            a("onVideoSizeChanged called " + i + "x" + i2);
        }
        if (i != 0 && i2 != 0) {
            this.s = true;
            this.o = i;
            this.p = i2;
            if (!this.t || 1 == 0) {
                return;
            }
            c();
            return;
        }
        if (f3014a) {
            a("invalid video width(" + i + ") or height(" + i2 + ")");
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void pause() {
        MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer == null) {
            return;
        }
        if (this.w) {
            mediaPlayer.pause();
        }
        this.v = true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void seekTo(int i) {
        MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.seekTo(i);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void start() {
        if (f3014a) {
            a("Start");
        }
        MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer == null) {
            return;
        }
        if (this.w) {
            mediaPlayer.start();
        }
        this.v = false;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (f3014a) {
            a("surfaceChanged called " + i + " " + i2 + "x" + i3);
        }
        if (this.m == i2 && this.n == i3) {
            return;
        }
        this.m = i2;
        this.n = i3;
        if (this.w) {
            updateVideoLayout();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (f3014a) {
            a("surfaceCreated called");
        }
        this.w = true;
        b();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (f3014a) {
            a("surfaceDestroyed called");
        }
        this.w = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
    
        if (r5 <= r3) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
    
        r1 = (int) (r0 / r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
    
        r0 = (int) (r1 * r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
    
        if (r5 >= r3) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void updateVideoLayout() {
        /*
            r8 = this;
            boolean r0 = com.unity3d.player.i.f3014a
            if (r0 == 0) goto La
            java.lang.String r0 = "updateVideoLayout"
            a(r0)
        La:
            android.media.MediaPlayer r0 = r8.q
            if (r0 != 0) goto Lf
            return
        Lf:
            int r0 = r8.m
            if (r0 == 0) goto L17
            int r0 = r8.n
            if (r0 != 0) goto L36
        L17:
            android.content.Context r0 = r8.f3015b
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r1 = r0.getDefaultDisplay()
            int r1 = r1.getWidth()
            r8.m = r1
            android.view.Display r0 = r0.getDefaultDisplay()
            int r0 = r0.getHeight()
            r8.n = r0
        L36:
            int r0 = r8.m
            int r1 = r8.n
            int r2 = r8.o
            float r3 = (float) r2
            int r4 = r8.p
            float r5 = (float) r4
            float r3 = r3 / r5
            float r5 = (float) r0
            float r6 = (float) r1
            float r5 = r5 / r6
            int r6 = r8.g
            r7 = 1
            if (r6 != r7) goto L56
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 > 0) goto L51
        L4d:
            float r1 = (float) r0
            float r1 = r1 / r3
            int r1 = (int) r1
            goto L62
        L51:
            float r0 = (float) r1
            float r0 = r0 * r3
            int r0 = (int) r0
            goto L62
        L56:
            r7 = 2
            if (r6 != r7) goto L5e
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 < 0) goto L51
            goto L4d
        L5e:
            if (r6 != 0) goto L62
            r0 = r2
            r1 = r4
        L62:
            boolean r2 = com.unity3d.player.i.f3014a
            if (r2 == 0) goto L7f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "frameWidth = "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r3 = "; frameHeight = "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            a(r2)
        L7f:
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = 17
            r2.<init>(r0, r1, r3)
            android.widget.FrameLayout r0 = r8.k
            android.view.SurfaceView r1 = r8.f3016c
            r0.updateViewLayout(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.i.updateVideoLayout():void");
    }
}
