package com.player;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import ijk.media.player.j;
import ijk.media.player.misc.ITrackInfo;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Timer;

/* loaded from: classes.dex */
public class OmafMediaPlayer extends ijk.media.player.a implements SensorEventListener, SurfaceHolder.Callback {
    public static String D = "OmafMediaPlayer";
    private static final ijk.media.player.b E = new c();
    private static volatile boolean F = false;
    Timer A;
    long B;
    long C;

    /* renamed from: a, reason: collision with root package name */
    private long f2389a;

    /* renamed from: b, reason: collision with root package name */
    private Uri f2390b;

    /* renamed from: c, reason: collision with root package name */
    private Uri f2391c;

    /* renamed from: d, reason: collision with root package name */
    private SurfaceHolder f2392d;
    private Context e;
    private GLSurfaceView f;
    private b g;
    public GLSurfaceView.Renderer h;
    private boolean i;
    private Point j;
    private Surface k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private SensorManager r;
    private Sensor s;
    private boolean t;
    private boolean u;
    private int v;
    private float w;
    private float x;
    private float y;
    private int z;

    /* loaded from: classes.dex */
    public enum EulerAxisOrder {
        XYZ,
        YXZ,
        ZXY,
        ZYX,
        YZX,
        XZY,
        COUNT
    }

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public float f2393a;

        /* renamed from: b, reason: collision with root package name */
        public float f2394b;

        /* renamed from: c, reason: collision with root package name */
        public float f2395c;

        /* renamed from: d, reason: collision with root package name */
        public float f2396d;

        public a() {
        }
    }

    public OmafMediaPlayer(Context context) {
        this(context, true, true, 0);
    }

    private float a(float f, float f2) {
        float f3 = f + f2;
        return f3 >= 360.0f ? f3 - 360.0f : f3 <= -360.0f ? f3 + 360.0f : f3;
    }

    private float b(float f, float f2) {
        float f3 = f - f2;
        return f3 >= 360.0f ? f3 - 360.0f : f3 <= -360.0f ? f3 + 360.0f : f3;
    }

    public static void loadLibrariesOnce(ijk.media.player.b bVar) {
        Log.d(D, "loadLibrariesOnce 0");
        synchronized (OmafMediaPlayer.class) {
            if (!F) {
                if (bVar == null) {
                    bVar = E;
                }
                Log.d(D, "loadLibrariesOnce 0.1");
                bVar.loadLibrary("OMAFPlayerWrapper");
                Log.d(D, "libOMAFPlayerWrapper.so is loaded");
                F = true;
            }
        }
        Log.d(D, "loadLibrariesOnce 1");
    }

    public static native long nativeCreateApplication(OmafMediaPlayer omafMediaPlayer, AssetManager assetManager, Context context, String str, String str2, int i, int i2);

    private native void nativeDestroyApplication(long j);

    public static native void nativeDraw(long j);

    private native long nativeGetCurrentPosition();

    private native long nativeGetDuration();

    public static native void nativeLoadContent(String str);

    private native void nativeOnPause(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSurfaceCreated();

    private native void nativeSeekTo(long j);

    private native void nativeSetLooping(boolean z);

    private native void nativeSetRenderType(int i);

    private native void nativeSetScale(float f);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetTextureId(int i, int i2);

    private native void nativeUpdateCalibratedRotation(float f, float f2, float f3, float f4);

    private native void nativeUpdateRotation(float f, float f2, float f3, float f4);

    @Override // ijk.media.player.IMediaPlayer
    public boolean GetCurrentFrame(Bitmap bitmap) {
        return false;
    }

    @Override // ijk.media.player.IMediaPlayer
    public int GetRecordStatus() {
        return 0;
    }

    @Override // ijk.media.player.IMediaPlayer
    public int StartRecord(String str) {
        return 0;
    }

    @Override // ijk.media.player.IMediaPlayer
    public int StopRecord() {
        return 0;
    }

    @Override // ijk.media.player.IMediaPlayer
    public List<String> getAudioSeq() {
        return null;
    }

    @Override // ijk.media.player.IMediaPlayer
    public int getAudioSessionId() {
        return 0;
    }

    @Override // ijk.media.player.IMediaPlayer
    public long getCurrentPosition() {
        return nativeGetCurrentPosition();
    }

    @Override // ijk.media.player.IMediaPlayer
    public String getDataSource() {
        return null;
    }

    @Override // ijk.media.player.IMediaPlayer
    public long getDuration() {
        return nativeGetDuration();
    }

    @Override // ijk.media.player.IMediaPlayer
    public j getMediaInfo() {
        return null;
    }

    @Override // ijk.media.player.IMediaPlayer
    public String getPlayerProbeKPI() {
        return null;
    }

    @Override // ijk.media.player.IMediaPlayer
    public float getSpeed() {
        return 0.0f;
    }

    @Override // ijk.media.player.IMediaPlayer
    public boolean getSubBitmap(Bitmap bitmap) {
        return false;
    }

    @Override // ijk.media.player.IMediaPlayer
    public List<String> getSubtitleSeq() {
        return null;
    }

    @Override // ijk.media.player.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
        return new ITrackInfo[0];
    }

    @Override // ijk.media.player.IMediaPlayer
    public int getVideoHeight() {
        return this.j.y;
    }

    @Override // ijk.media.player.IMediaPlayer
    public int getVideoSarDen() {
        return 0;
    }

    @Override // ijk.media.player.IMediaPlayer
    public int getVideoSarNum() {
        return 0;
    }

    @Override // ijk.media.player.IMediaPlayer
    public List<String> getVideoSeq() {
        return null;
    }

    @Override // ijk.media.player.IMediaPlayer
    public int getVideoWidth() {
        return this.j.x;
    }

    @Override // ijk.media.player.IMediaPlayer
    public float getVolume() {
        return 0.0f;
    }

    @Override // ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        return this.o;
    }

    @Override // ijk.media.player.IMediaPlayer
    public boolean isPlayable() {
        return this.n;
    }

    @Override // ijk.media.player.IMediaPlayer
    public boolean isPlaying() {
        return this.i;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        synchronized (this.e) {
            if (sensorEvent.sensor.getType() == 15) {
                nativeUpdateCalibratedRotation(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2], sensorEvent.values[3]);
            }
        }
    }

    @Override // ijk.media.player.IMediaPlayer
    public void pause() throws IllegalStateException {
        this.i = false;
        Log.d(D, "nativeOnPause");
        nativeOnPause(0L);
    }

    @Override // ijk.media.player.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
    }

    @Override // ijk.media.player.IMediaPlayer
    public void release() {
        Timer timer = this.A;
        if (timer != null) {
            timer.cancel();
            this.A = null;
        }
        Log.d(D, "release " + Thread.currentThread().toString() + " main " + f());
        nativeDestroyApplication(this.f2389a);
    }

    @Override // ijk.media.player.IMediaPlayer
    public void reset() {
    }

    @Override // ijk.media.player.IMediaPlayer
    public void seekTo(long j) throws IllegalStateException {
        nativeSeekTo(j);
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setAudioStreamType(int i) {
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.f2390b = uri;
        Thread thread = new Thread(new f(this));
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(D, "setDataSource " + uri);
        notifyOnPrepared();
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        Log.i(D, "setDisplay sh=" + surfaceHolder);
        if (this.f2392d != null) {
            return;
        }
        this.f2392d = surfaceHolder;
        if (this.t) {
            surfaceHolder.addCallback(this);
        }
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setInitBufferTime(long j) {
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setKeepInBackground(boolean z) {
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setLogEnabled(boolean z) {
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setLooping(boolean z) {
        this.o = z;
        nativeSetLooping(z);
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setMaxAllBufferSize(long j) {
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setMaxBufferSize(long j) {
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setMaxBufferTime(long j) {
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setPlaybackBufferTime(long j) {
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setPreferBitrate(long j) {
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setSpeed(float f) {
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setSurface(Surface surface) {
        this.k = surface;
        Log.e(D, "setSurface");
        if (surface != null && surface == null && this.t && this.f == null) {
            this.g.a(new g(this, surface));
            this.g.a(this.h);
            this.g.surfaceCreated(null);
            b bVar = this.g;
            Point point = this.j;
            bVar.surfaceChanged(null, 4, point.x, point.y);
        }
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setVolume(float f, float f2) {
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setWakeMode(Context context, int i) {
    }

    @Override // ijk.media.player.IMediaPlayer
    public void start() throws IllegalStateException {
        Sensor sensor;
        Log.d(D, "start====== " + this.f2391c.toString());
        this.i = true;
        if (this.t) {
            if (this.k != null) {
                g();
            }
        } else if (this.f2391c != null) {
            Log.d(D, "start " + this.f2391c.toString());
            nativeLoadContent(this.f2391c.toString());
            Log.d(D, "2 SetTextureId  base:" + this.l + "\tenh:" + this.m);
            nativeSetTextureId(0, this.l);
            nativeSetTextureId(1, this.m);
            Log.d(D, "2 SetTextureId");
        } else {
            Log.e(D, "no url, play fails");
            return;
        }
        if (!this.u || (sensor = this.s) == null) {
            return;
        }
        this.r.registerListener(this, sensor, sensor.getMinDelay(), 0);
    }

    @Override // ijk.media.player.IMediaPlayer
    public void stop() throws IllegalStateException {
        if (this.u) {
            this.r.unregisterListener(this);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Log.i(D, "surfaceChanged");
        if (this.f == null) {
            this.g.surfaceChanged(surfaceHolder, i, i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.i(D, "surfaceCreated" + Thread.currentThread() + " main " + f());
        if (this.p && this.f == null) {
            this.g.a();
        }
        e();
        if (this.f == null) {
            this.g.surfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.i(D, "surfaceDestroyed " + Thread.currentThread() + " main " + f());
        if (this.f == null) {
            this.g.b();
        }
    }

    public OmafMediaPlayer(Context context, boolean z, boolean z2, int i) {
        this.f2392d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = false;
        this.j = new Point(3840, 1920);
        this.k = null;
        this.l = 0;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.t = true;
        this.u = false;
        this.v = 0;
        this.w = 0.0f;
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0;
        this.A = null;
        this.B = 0L;
        this.C = 0L;
        if (!F) {
            loadLibrariesOnce(null);
        }
        this.t = z;
        this.u = z2;
        this.v = i;
        this.e = context;
        Log.e(D, "jiangping create OmafMediaPlayer");
        a(context);
    }

    private void e() {
        if (!this.t || this.p) {
            return;
        }
        this.f2392d.addCallback(this);
        if (this.f == null) {
            this.g.a(new e(this));
            this.g.a(this.h);
            this.g.surfaceCreated(this.f2392d);
            b bVar = this.g;
            SurfaceHolder surfaceHolder = this.f2392d;
            Point point = this.j;
            bVar.surfaceChanged(surfaceHolder, 4, point.x, point.y);
        }
        this.p = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    private void g() {
        if (this.f != null) {
            return;
        }
        this.g.a(new h(this));
        this.g.a(this.h);
        this.g.surfaceCreated(null);
        b bVar = this.g;
        Point point = this.j;
        bVar.surfaceChanged(null, 4, point.x, point.y);
    }

    public void d() {
        AssetManager assets = this.e.getResources().getAssets();
        this.e.getResources().getDisplayMetrics();
        Log.d(D, "initNative " + Thread.currentThread().toString() + " main " + f());
        nativeSetRenderType(this.v);
        Context context = this.e;
        String path = context.getApplicationContext().getExternalFilesDir(null).getPath();
        String path2 = this.e.getApplicationContext().getCacheDir().getPath();
        Point point = this.j;
        this.f2389a = nativeCreateApplication(this, assets, context, path, path2, point.x, point.y);
    }

    public void a(Point point) {
        Log.d(D, "setScreenSize " + point.x + ", " + point.y);
        this.j = point;
    }

    public void a(Context context) {
        this.e = context;
        if (this.u) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.r = sensorManager;
            this.s = sensorManager.getDefaultSensor(15);
        }
        if (this.t) {
            Log.e(D, "create OmafMediaPlayer 1");
            if (this.f == null) {
                b bVar = new b(context);
                this.g = bVar;
                bVar.a(2);
                this.g.a(8, 8, 8, 0, 16, 0);
                this.g.a(true);
            }
            d dVar = new d(this);
            this.h = dVar;
            GLSurfaceView gLSurfaceView = this.f;
            if (gLSurfaceView != null) {
                gLSurfaceView.setRenderer(dVar);
                return;
            }
            return;
        }
        d();
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(context, uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Uri uri) {
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        } catch (IOException e) {
            e.printStackTrace();
            httpURLConnection = null;
        }
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setConnectTimeout(1000);
        try {
            if (httpURLConnection.getResponseCode() >= 400) {
                notifyOnError(100, -httpURLConnection.getResponseCode());
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return httpURLConnection.getURL().toString();
    }

    public a a(float f, float f2, float f3, EulerAxisOrder eulerAxisOrder) {
        double d2 = f * 0.5f;
        float cos = (float) Math.cos(d2);
        double d3 = f2 * 0.5f;
        float cos2 = (float) Math.cos(d3);
        double d4 = f3 * 0.5f;
        float cos3 = (float) Math.cos(d4);
        float sin = (float) Math.sin(d2);
        float sin2 = (float) Math.sin(d3);
        float sin3 = (float) Math.sin(d4);
        a aVar = new a();
        if (eulerAxisOrder == EulerAxisOrder.XYZ) {
            float f4 = sin * cos2;
            float f5 = cos * sin2;
            aVar.f2393a = (f4 * cos3) + (f5 * sin3);
            aVar.f2394b = (f5 * cos3) - (f4 * sin3);
            float f6 = cos * cos2;
            float f7 = sin * sin2;
            aVar.f2395c = (f6 * sin3) + (f7 * cos3);
            aVar.f2396d = (f6 * cos3) - (f7 * sin3);
        } else if (eulerAxisOrder == EulerAxisOrder.YXZ) {
            float f8 = sin * cos2;
            float f9 = cos * sin2;
            aVar.f2393a = (f8 * cos3) + (f9 * sin3);
            aVar.f2394b = (f9 * cos3) - (f8 * sin3);
            float f10 = cos * cos2;
            float f11 = sin * sin2;
            aVar.f2395c = (f10 * sin3) - (f11 * cos3);
            aVar.f2396d = (f10 * cos3) + (f11 * sin3);
        } else if (eulerAxisOrder == EulerAxisOrder.ZXY) {
            float f12 = sin * cos2;
            float f13 = cos * sin2;
            aVar.f2393a = (f12 * cos3) - (f13 * sin3);
            aVar.f2394b = (f13 * cos3) + (f12 * sin3);
            float f14 = cos * cos2;
            float f15 = sin * sin2;
            aVar.f2395c = (f14 * sin3) + (f15 * cos3);
            aVar.f2396d = (f14 * cos3) - (f15 * sin3);
        } else if (eulerAxisOrder == EulerAxisOrder.ZYX) {
            float f16 = sin * cos2;
            float f17 = cos * sin2;
            aVar.f2393a = (f16 * cos3) - (f17 * sin3);
            aVar.f2394b = (f17 * cos3) + (f16 * sin3);
            float f18 = cos * cos2;
            float f19 = sin * sin2;
            aVar.f2395c = (f18 * sin3) - (f19 * cos3);
            aVar.f2396d = (f18 * cos3) + (f19 * sin3);
        } else if (eulerAxisOrder == EulerAxisOrder.YZX) {
            float f20 = sin * cos2;
            float f21 = cos * sin2;
            aVar.f2393a = (f20 * cos3) + (f21 * sin3);
            aVar.f2394b = (f21 * cos3) + (f20 * sin3);
            float f22 = cos * cos2;
            float f23 = sin * sin2;
            aVar.f2395c = (f22 * sin3) - (f23 * cos3);
            aVar.f2396d = (f22 * cos3) - (f23 * sin3);
        } else if (eulerAxisOrder == EulerAxisOrder.XZY) {
            float f24 = sin * cos2;
            float f25 = cos * sin2;
            aVar.f2393a = (f24 * cos3) - (f25 * sin3);
            aVar.f2394b = (f25 * cos3) - (f24 * sin3);
            float f26 = cos * cos2;
            float f27 = sin * sin2;
            aVar.f2395c = (f26 * sin3) + (f27 * cos3);
            aVar.f2396d = (f26 * cos3) + (f27 * sin3);
        }
        return aVar;
    }

    public void a(int i, float f) {
        switch (i) {
            case 19:
                this.w = a(this.w, f);
                break;
            case 20:
                this.w = b(this.w, f);
                break;
            case 21:
                this.x = a(this.x, f);
                break;
            case 22:
                this.x = b(this.x, f);
                break;
            default:
                return;
        }
        a a2 = a((this.w * 3.1415927f) / 180.0f, (this.x * 3.1415927f) / 180.0f, (this.y * 3.1415927f) / 180.0f, EulerAxisOrder.YXZ);
        synchronized (this.e) {
            nativeUpdateRotation(a2.f2393a, a2.f2394b, a2.f2395c, a2.f2396d);
        }
    }

    public void a(float f) {
        float min = Math.min(5.0f, Math.max(1.0f, f));
        Log.i(D, "setScale " + min);
        nativeSetScale(min);
    }

    public boolean a(KeyEvent keyEvent, int i, int i2) {
        float f = (i * 17) / 1000.0f;
        if (keyEvent.getAction() == 0) {
            int repeatCount = keyEvent.getRepeatCount();
            this.z = repeatCount;
            if (repeatCount == 0) {
                Timer timer = this.A;
                if (timer != null) {
                    timer.cancel();
                    this.A = null;
                }
                this.A = new Timer();
                i iVar = new i(this, keyEvent, f, i2);
                this.B = SystemClock.uptimeMillis();
                this.A.schedule(iVar, 0L, 17L);
                return false;
            }
            this.B = SystemClock.uptimeMillis();
            return false;
        }
        if (keyEvent.getAction() != 1) {
            return false;
        }
        if (this.z == 0) {
            this.B = SystemClock.uptimeMillis();
            return false;
        }
        Timer timer2 = this.A;
        if (timer2 == null) {
            return false;
        }
        timer2.cancel();
        this.A = null;
        return false;
    }
}
