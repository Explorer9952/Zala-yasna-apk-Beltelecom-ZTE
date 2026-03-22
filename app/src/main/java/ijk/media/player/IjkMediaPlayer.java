package ijk.media.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.util.MimeTypes;
import com.video.androidsdk.common.http.HttpConstant;
import ijk.media.player.c;
import ijk.media.player.misc.IAndroidIO;
import ijk.media.player.misc.IMediaDataSource;
import ijk.media.player.misc.k;
import ijk.media.player.render.FVGlSurfaceView;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;

/* loaded from: classes2.dex */
public final class IjkMediaPlayer extends ijk.media.player.a {
    public static final int FFP_PROPV_DECODER_AVCODEC = 1;
    public static final int FFP_PROPV_DECODER_MEDIACODEC = 2;
    public static final int FFP_PROPV_DECODER_UNKNOWN = 0;
    public static final int FFP_PROPV_DECODER_VIDEOTOOLBOX = 3;
    public static final int FFP_PROP_FLOAT_DROP_FRAME_RATE = 10007;
    public static final int FFP_PROP_FLOAT_LEFT_VOLUME = 10009;
    public static final int FFP_PROP_FLOAT_PLAYBACK_RATE = 10003;
    public static final int FFP_PROP_FLOAT_PLAYBACK_RATE_AUTO = 10011;
    public static final int FFP_PROP_FLOAT_RIGHT_VOLUME = 10008;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_BACKWARDS = 20201;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_CAPACITY = 20203;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_FORWARDS = 20202;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_BYTES = 20008;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_DURATION = 20006;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_PACKETS = 20010;
    public static final int FFP_PROP_INT64_AUDIO_DECODER = 20004;
    public static final int FFP_PROP_INT64_AUDIO_STREAM_SUM = 20017;
    public static final int FFP_PROP_INT64_BIT_RATE = 20100;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_COUNT_BYTES = 20208;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_FILE_FORWARDS = 20206;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_FILE_POS = 20207;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_PHYSICAL_POS = 20205;
    public static final int FFP_PROP_INT64_FIRST_HIGH_WATER_MARK_IN_MS = 20011;
    public static final int FFP_PROP_INT64_FREEVIEW_TRACK_ID = 20021;
    public static final int FFP_PROP_INT64_FREEVIEW_TRACK_NUM = 20020;
    public static final int FFP_PROP_INT64_FREEVIEW_TRACK_OFF = 20022;
    public static final int FFP_PROP_INT64_LAST_HIGH_WATER_MARK_IN_BYTES = 20014;
    public static final int FFP_PROP_INT64_LAST_HIGH_WATER_MARK_IN_MS = 20013;
    public static final int FFP_PROP_INT64_LATEST_SEEK_LOAD_DURATION = 20300;
    public static final int FFP_PROP_INT64_LOGICAL_FILE_SIZE = 20209;
    public static final int FFP_PROP_INT64_MAX_BUFFER_SIZE = 20015;
    public static final int FFP_PROP_INT64_NEXT_HIGH_WATER_MARK_IN_MS = 20012;
    public static final int FFP_PROP_INT64_PREFER_BITRATES = 20019;
    public static final int FFP_PROP_INT64_SELECTED_AUDIO_STREAM = 20002;
    public static final int FFP_PROP_INT64_SELECTED_TIMEDTEXT_STREAM = 20111;
    public static final int FFP_PROP_INT64_SELECTED_VIDEO_STREAM = 20001;
    public static final int FFP_PROP_INT64_SHARE_CACHE_DATA = 20210;
    public static final int FFP_PROP_INT64_SUBTITLE_STREAM_SUM = 20018;
    public static final int FFP_PROP_INT64_TCP_SPEED = 20200;
    public static final int FFP_PROP_INT64_TRAFFIC_STATISTIC_BYTE_COUNT = 20204;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_BYTES = 20007;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_DURATION = 20005;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_PACKETS = 20009;
    public static final int FFP_PROP_INT64_VIDEO_DECODER = 20003;
    public static final int FFP_PROP_INT64_VIDEO_STREAM_SUM = 20016;
    public static final int IJK_LOG_DEBUG = 3;
    public static final int IJK_LOG_DEFAULT = 1;
    public static final int IJK_LOG_ERROR = 6;
    public static final int IJK_LOG_FATAL = 7;
    public static final int IJK_LOG_INFO = 4;
    public static final int IJK_LOG_SILENT = 8;
    public static final int IJK_LOG_UNKNOWN = 0;
    public static final int IJK_LOG_VERBOSE = 2;
    public static final int IJK_LOG_WARN = 5;
    public static final int OPT_CATEGORY_CODEC = 2;
    public static final int OPT_CATEGORY_FORMAT = 1;
    public static final int OPT_CATEGORY_PLAYER = 4;
    public static final int OPT_CATEGORY_SWS = 3;
    public static final int PREFER_ESTIMATED_BITRATE = 2;
    public static final int PREFER_HIGH_BITRATE = 1;
    public static final int PREFER_LOW_BITRATE = 0;
    public static final int PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND = 10001;
    public static final int PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND = 10002;
    public static final int SDL_FCC_RV16 = 909203026;
    public static final int SDL_FCC_RV32 = 842225234;
    public static final int SDL_FCC_YV12 = 842094169;

    /* renamed from: a, reason: collision with root package name */
    private static final String f8073a = "ijk.media.player.IjkMediaPlayer";
    private c C;
    private e D;
    private int E;
    private int F;
    private int G;

    /* renamed from: b, reason: collision with root package name */
    private SurfaceHolder f8074b;

    /* renamed from: c, reason: collision with root package name */
    private a f8075c;

    /* renamed from: d, reason: collision with root package name */
    private PowerManager.WakeLock f8076d;
    private boolean e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private int j;
    private String k;
    private int l;
    private String m;
    private long mNativeAndroidIO;
    private long mNativeMediaDataSource;
    private long mNativeMediaPlayer;
    private int mNativeSurfaceTexture;
    public d mOnMediaCodecSelectListener;
    private boolean n;
    private Pair<Integer, String> o;
    private List<String> p;
    private List<String> q;
    private List<String> r;
    private ijk.media.player.a.a s;
    private FVGlSurfaceView t;
    private Timer u;
    private int v;
    private int w;
    private float x;
    private long y;
    private long z;
    private static final ijk.media.player.b sLocalLibLoader = new ijk.media.player.d();
    private static volatile boolean A = false;
    private static volatile boolean B = false;
    public static String onSelectCodecStr = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<IjkMediaPlayer> f8077a;

        public a(IjkMediaPlayer ijkMediaPlayer, Looper looper) {
            super(looper);
            this.f8077a = new WeakReference<>(ijkMediaPlayer);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IjkMediaPlayer ijkMediaPlayer = this.f8077a.get();
            if (ijkMediaPlayer != null) {
                if (ijkMediaPlayer.mNativeMediaPlayer != 0) {
                    int i = message.what;
                    if (i != 0) {
                        if (i == 1) {
                            ijkMediaPlayer.setStreamInfo();
                            ijkMediaPlayer.b();
                            ijkMediaPlayer.notifyOnPrepared();
                            return;
                        }
                        if (i == 2) {
                            ijkMediaPlayer.a(false);
                            ijkMediaPlayer.notifyOnCompletion();
                            return;
                        }
                        if (i == 3) {
                            long j = message.arg1;
                            if (j < 0) {
                                j = 0;
                            }
                            long duration = ijkMediaPlayer.getDuration();
                            long j2 = duration > 0 ? (j * 100) / duration : 0L;
                            ijkMediaPlayer.notifyOnBufferingUpdate((int) (j2 < 100 ? j2 : 100L));
                            return;
                        }
                        if (i == 4) {
                            ijkMediaPlayer.notifyOnSeekComplete();
                            return;
                        }
                        if (i == 5) {
                            ijkMediaPlayer.g = message.arg1;
                            ijkMediaPlayer.h = message.arg2;
                            ijkMediaPlayer.notifyOnVideoSizeChanged(ijkMediaPlayer.g, ijkMediaPlayer.h, ijkMediaPlayer.i, ijkMediaPlayer.j);
                            return;
                        }
                        if (i == 200) {
                            int i2 = message.arg1;
                            if (i2 == 3) {
                                ijk.media.player.b.a.b(IjkMediaPlayer.f8073a, "Info: MEDIA_INFO_VIDEO_RENDERING_START \n");
                            } else if (i2 == 10008) {
                                ijk.media.player.b.a.b(IjkMediaPlayer.f8073a, "Info: MEDIA_INFO_VIDEO_SEEK_RENDERING_START\n");
                                ijk.media.player.b.a.b(IjkMediaPlayer.f8073a, "Info: MEDIA_INFO_VIDEO_SEEK_RENDERING_START\n");
                                ijkMediaPlayer.z = message.arg2;
                            } else if (i2 == 10101) {
                                ijkMediaPlayer.b(message.arg2);
                            }
                            ijkMediaPlayer.notifyOnInfo(message.arg1, message.arg2);
                            return;
                        }
                        if (i != 10001) {
                            switch (i) {
                                case 98:
                                    Log.i(IjkMediaPlayer.f8073a, "MEDIA_SUB_BITMAP " + message.arg1);
                                    if (message.arg1 == 0) {
                                        ijkMediaPlayer.notifyOnSubBitmap(0, null);
                                        return;
                                    } else {
                                        int[] iArr = (int[]) message.obj;
                                        ijkMediaPlayer.notifyOnSubBitmap(1, new Rect(iArr[0], iArr[1], iArr[2], iArr[3]));
                                        return;
                                    }
                                case 99:
                                    if (message.obj == null) {
                                        ijkMediaPlayer.notifyOnTimedText(null);
                                        return;
                                    } else {
                                        ijkMediaPlayer.notifyOnTimedText(new i(new Rect(0, 0, 1, 1), (String) message.obj));
                                        return;
                                    }
                                case 100:
                                    ijk.media.player.b.a.a(IjkMediaPlayer.f8073a, "Error (" + message.arg1 + "," + message.arg2 + ")");
                                    Object obj = message.obj;
                                    if (obj != null) {
                                        ijkMediaPlayer.onErrorDebugLog(message.arg1, message.arg2, obj.toString());
                                    } else {
                                        ijkMediaPlayer.onErrorDebugLog(message.arg1, message.arg2, null);
                                    }
                                    if (ijkMediaPlayer.isPlaying()) {
                                        if (!ijkMediaPlayer.notifyOnError(message.arg1, message.arg2)) {
                                            ijkMediaPlayer.notifyOnCompletion();
                                        }
                                        ijkMediaPlayer.a(false);
                                        return;
                                    }
                                    ijkMediaPlayer.notifyOnError(message.arg1, message.arg2);
                                    return;
                                default:
                                    ijk.media.player.b.a.a(IjkMediaPlayer.f8073a, "Unknown message type " + message.what);
                                    return;
                            }
                        }
                        ijkMediaPlayer.i = message.arg1;
                        ijkMediaPlayer.j = message.arg2;
                        ijkMediaPlayer.notifyOnVideoSizeChanged(ijkMediaPlayer.g, ijkMediaPlayer.h, ijkMediaPlayer.i, ijkMediaPlayer.j);
                        return;
                    }
                    return;
                }
            }
            ijk.media.player.b.a.c(IjkMediaPlayer.f8073a, "IjkMediaPlayer went away with unhandled events");
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void a(float f, float f2);

        void b();

        void c();
    }

    /* loaded from: classes2.dex */
    public interface c {
        String a(int i);
    }

    /* loaded from: classes2.dex */
    public interface d {
        String a(IMediaPlayer iMediaPlayer, String str, int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface e {
        boolean a(int i, Bundle bundle);
    }

    /* loaded from: classes2.dex */
    public static class f implements d {

        /* renamed from: a, reason: collision with root package name */
        public static final f f8078a = new f();

        @Override // ijk.media.player.IjkMediaPlayer.d
        public String a(IMediaPlayer iMediaPlayer, String str, int i, int i2) {
            String[] supportedTypes;
            String[] supportedTypes2;
            if (Build.VERSION.SDK_INT < 16 || TextUtils.isEmpty(str)) {
                return null;
            }
            Log.i(IjkMediaPlayer.f8073a, String.format(Locale.US, "onSelectCodec: mime=%s, profile=%d, level=%d", str, Integer.valueOf(i), Integer.valueOf(i2)));
            int codecCount = MediaCodecList.getCodecCount();
            for (int i3 = 0; i3 < codecCount; i3++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
                Log.d(IjkMediaPlayer.f8073a, String.format(Locale.US, "            found codec: %s", codecInfoAt.getName()));
                if (!codecInfoAt.isEncoder() && (supportedTypes2 = codecInfoAt.getSupportedTypes()) != null) {
                    for (String str2 : supportedTypes2) {
                        if (!TextUtils.isEmpty(str2)) {
                            Log.d(IjkMediaPlayer.f8073a, String.format(Locale.US, "                mime: %s", str2));
                            if (str2.equalsIgnoreCase(str)) {
                                return codecInfoAt.getName();
                            }
                        }
                    }
                }
            }
            Log.w(IjkMediaPlayer.f8073a, "There is no matching codec, try default");
            for (int i4 = 0; i4 < codecCount; i4++) {
                MediaCodecInfo codecInfoAt2 = MediaCodecList.getCodecInfoAt(i4);
                Log.d(IjkMediaPlayer.f8073a, String.format(Locale.US, "            found codec: %s", codecInfoAt2.getName()));
                if (!codecInfoAt2.isEncoder() && (supportedTypes = codecInfoAt2.getSupportedTypes()) != null) {
                    for (String str3 : supportedTypes) {
                        if (!TextUtils.isEmpty(str3)) {
                            Log.d(IjkMediaPlayer.f8073a, String.format(Locale.US, "Default codec: %s  mime: %s", codecInfoAt2.getName(), str3));
                            return codecInfoAt2.getName();
                        }
                    }
                }
            }
            return "UNKNOWN";
        }
    }

    public IjkMediaPlayer() {
        this(sLocalLibLoader);
    }

    private native String _getAudioCodecInfo();

    private native String _getCamMatrix();

    private static native String _getColorFormatName(int i);

    private native int _getLoopCount();

    private native Bundle _getMediaMeta();

    private native float _getPropertyFloat(int i, float f2);

    private native long _getPropertyLong(int i, long j);

    private native boolean _getSubBitmap(Bitmap bitmap);

    private native String _getSubtitleCodecInfo();

    private native Bundle _getTypeMeta(int i);

    private native String _getVideoCodecInfo();

    private native void _pause() throws IllegalStateException;

    private native void _release();

    private native void _reset();

    private native void _setAndroidIOCallback(IAndroidIO iAndroidIO) throws IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setAudioStreamSelected(String str, boolean z);

    private native void _setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDataSource(String str, String[] strArr, String[] strArr2) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDataSourceFd(int i) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setFrameAtTime(String str, long j, long j2, int i, int i2) throws IllegalArgumentException, IllegalStateException;

    private native void _setLoopCount(int i);

    private native void _setOption(int i, String str, long j);

    private native void _setOption(int i, String str, String str2);

    private native void _setPropertyFloat(int i, float f2);

    private native void _setPropertyLong(int i, long j);

    private native void _setStreamSelected(int i, boolean z);

    private native void _setSubtitleStreamSelected(String str, boolean z);

    private native void _setVideoStreamSelected(int i, boolean z);

    private native void _setVideoSurface(Surface surface);

    private native void _start() throws IllegalStateException;

    private native void _stop() throws IllegalStateException;

    private void a(ijk.media.player.b bVar) {
        loadLibrariesOnce(bVar);
        initNativeOnce();
        this.f8075c = new a(this, Looper.getMainLooper());
        native_setup(new WeakReference(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int access$1508(IjkMediaPlayer ijkMediaPlayer) {
        int i = ijkMediaPlayer.v;
        ijkMediaPlayer.v = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int access$1510(IjkMediaPlayer ijkMediaPlayer) {
        int i = ijkMediaPlayer.v;
        ijkMediaPlayer.v = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.t == null) {
            return;
        }
        this.E = Math.max((int) _getPropertyLong(FFP_PROP_INT64_FREEVIEW_TRACK_NUM, 1L), 1);
        Log.d(f8073a, "setFvTrackNum " + this.E);
        this.t.a(_getCamMatrix());
    }

    private void c() {
        ijk.media.player.a.a aVar = this.s;
        if (aVar != null) {
            aVar.a(new g(this));
        }
    }

    public static String getColorFormatName(int i) {
        return _getColorFormatName(i);
    }

    private native boolean getCurrentFrame(Bitmap bitmap);

    private native int getRecordStatus();

    private static void initNativeOnce() {
        synchronized (IjkMediaPlayer.class) {
            if (!B) {
                native_init();
                B = true;
            }
        }
    }

    public static void loadLibrariesOnce(ijk.media.player.b bVar) {
        synchronized (IjkMediaPlayer.class) {
            if (!A) {
                if (bVar == null) {
                    bVar = sLocalLibLoader;
                }
                bVar.loadLibrary("ijkffmpeg");
                bVar.loadLibrary("ijksdl");
                bVar.loadLibrary("ijkplayer");
                A = true;
            }
        }
    }

    private native void native_finalize();

    private static native void native_init();

    private native void native_message_loop(Object obj);

    public static native void native_profileBegin(String str);

    public static native void native_profileEnd();

    public static native void native_setLogLevel(int i);

    public static native void native_setSaveLogPathName(String str);

    private native void native_setup(Object obj);

    private static boolean onNativeInvoke(Object obj, int i, Bundle bundle) {
        ijk.media.player.b.a.a(f8073a, "onNativeInvoke %d", Integer.valueOf(i));
        if (obj != null && (obj instanceof WeakReference)) {
            IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get();
            if (ijkMediaPlayer != null) {
                e eVar = ijkMediaPlayer.D;
                if (eVar != null && eVar.a(i, bundle)) {
                    return true;
                }
                if (i != 131079) {
                    int i2 = bundle.getInt("error", 0);
                    if (i2 != 0) {
                        Log.e(f8073a, "onNativeInvoke: err:" + i2);
                    }
                    return false;
                }
                c cVar = ijkMediaPlayer.C;
                if (cVar == null) {
                    return false;
                }
                int i3 = bundle.getInt("segment_index", -1);
                if (i3 >= 0) {
                    String a2 = cVar.a(i3);
                    if (a2 != null) {
                        bundle.putString("url", a2);
                        return true;
                    }
                    throw new RuntimeException(new IOException("onNativeInvoke() = <NULL newUrl>"));
                }
                throw new InvalidParameterException("onNativeInvoke(invalid segment index)");
            }
            throw new IllegalStateException("<null weakPlayer>.onNativeInvoke()");
        }
        throw new IllegalStateException("<null weakThiz>.onNativeInvoke()");
    }

    private static String onSelectCodec(Object obj, String str, int i, int i2) {
        IjkMediaPlayer ijkMediaPlayer;
        if (obj == null || !(obj instanceof WeakReference) || (ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get()) == null) {
            return null;
        }
        d dVar = ijkMediaPlayer.mOnMediaCodecSelectListener;
        if (dVar == null) {
            dVar = f.f8078a;
        }
        return dVar.a(ijkMediaPlayer, str, i, i2);
    }

    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        IjkMediaPlayer ijkMediaPlayer;
        if (obj == null || (ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get()) == null) {
            return;
        }
        if (i == 200 && i2 == 2) {
            ijkMediaPlayer.start();
        }
        a aVar = ijkMediaPlayer.f8075c;
        if (aVar != null) {
            ijkMediaPlayer.f8075c.sendMessage(aVar.obtainMessage(i, i2, i3, obj2));
        }
    }

    private native int startRecord(String str);

    private native int stopRecord();

    @Override // ijk.media.player.IMediaPlayer
    public boolean GetCurrentFrame(Bitmap bitmap) {
        return getCurrentFrame(bitmap);
    }

    @Override // ijk.media.player.IMediaPlayer
    public int GetRecordStatus() {
        return getRecordStatus();
    }

    @Override // ijk.media.player.IMediaPlayer
    public int StartRecord(String str) {
        return startRecord(str);
    }

    @Override // ijk.media.player.IMediaPlayer
    public int StopRecord() {
        return stopRecord();
    }

    public native void _prepareAsync() throws IllegalStateException;

    public boolean checkLicense(Context context, String str) {
        return checkLicense(context, "0", str, context.getPackageName(), Build.MODEL, "2", "8", "0");
    }

    public void deselectTrack(int i) {
        _setStreamSelected(i, false);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        native_finalize();
    }

    public long getAsyncStatisticBufBackwards() {
        return _getPropertyLong(FFP_PROP_INT64_ASYNC_STATISTIC_BUF_BACKWARDS, 0L);
    }

    public long getAsyncStatisticBufCapacity() {
        return _getPropertyLong(FFP_PROP_INT64_ASYNC_STATISTIC_BUF_CAPACITY, 0L);
    }

    public long getAsyncStatisticBufForwards() {
        return _getPropertyLong(FFP_PROP_INT64_ASYNC_STATISTIC_BUF_FORWARDS, 0L);
    }

    public long getAudioCachedBytes() {
        return _getPropertyLong(FFP_PROP_INT64_AUDIO_CACHED_BYTES, 0L);
    }

    public long getAudioCachedDuration() {
        return _getPropertyLong(FFP_PROP_INT64_AUDIO_CACHED_DURATION, 0L);
    }

    public long getAudioCachedPackets() {
        return _getPropertyLong(FFP_PROP_INT64_AUDIO_CACHED_PACKETS, 0L);
    }

    @Override // ijk.media.player.IMediaPlayer
    public List<String> getAudioSeq() {
        return this.q;
    }

    @Override // ijk.media.player.IMediaPlayer
    public native int getAudioSessionId();

    @Override // ijk.media.player.a, ijk.media.player.IMediaPlayer
    public long getAudioTrackSum() {
        return _getPropertyLong(FFP_PROP_INT64_AUDIO_STREAM_SUM, 0L);
    }

    public boolean getAutoSpeed() {
        return _getPropertyFloat(FFP_PROP_FLOAT_PLAYBACK_RATE_AUTO, 0.0f) == 1.0f;
    }

    public long getBitRate() {
        return _getPropertyLong(FFP_PROP_INT64_BIT_RATE, 0L);
    }

    public int getCacheShare() {
        return (int) _getPropertyLong(FFP_PROP_INT64_SHARE_CACHE_DATA, 0L);
    }

    public long getCacheStatisticCountBytes() {
        return _getPropertyLong(FFP_PROP_INT64_CACHE_STATISTIC_COUNT_BYTES, 0L);
    }

    public long getCacheStatisticFileForwards() {
        return _getPropertyLong(FFP_PROP_INT64_CACHE_STATISTIC_FILE_FORWARDS, 0L);
    }

    public long getCacheStatisticFilePos() {
        return _getPropertyLong(FFP_PROP_INT64_CACHE_STATISTIC_FILE_POS, 0L);
    }

    public long getCacheStatisticPhysicalPos() {
        return _getPropertyLong(FFP_PROP_INT64_CACHE_STATISTIC_PHYSICAL_POS, 0L);
    }

    @Override // ijk.media.player.IMediaPlayer
    public native long getCurrentPosition();

    @Override // ijk.media.player.IMediaPlayer
    public String getDataSource() {
        return this.k;
    }

    public float getDropFrameRate() {
        return _getPropertyFloat(10007, 0.0f);
    }

    @Override // ijk.media.player.IMediaPlayer
    public native long getDuration();

    public int getErrorCode() {
        return this.l;
    }

    public String getErrorMsg() {
        return this.m;
    }

    public long getFileSize() {
        return _getPropertyLong(FFP_PROP_INT64_LOGICAL_FILE_SIZE, 0L);
    }

    public int getFvTrackId() {
        Log.d(f8073a, "getFvTrackId " + this.F);
        return this.F;
    }

    public int getFvTrackNum() {
        Log.d(f8073a, "getFvTrackNum " + this.E);
        return this.E;
    }

    public long getInitBufferTime() {
        return _getPropertyLong(FFP_PROP_INT64_FIRST_HIGH_WATER_MARK_IN_MS, 0L);
    }

    public long getMaxAllBufferSize() {
        return _getPropertyLong(FFP_PROP_INT64_LAST_HIGH_WATER_MARK_IN_BYTES, 0L);
    }

    public long getMaxBufferSize() {
        return _getPropertyLong(FFP_PROP_INT64_MAX_BUFFER_SIZE, 0L);
    }

    public long getMaxBufferTime() {
        return _getPropertyLong(FFP_PROP_INT64_LAST_HIGH_WATER_MARK_IN_MS, 0L);
    }

    @Override // ijk.media.player.IMediaPlayer
    public j getMediaInfo() {
        Log.d(f8073a, "getMediaInfo");
        j jVar = new j();
        jVar.f8097a = "ijkplayer";
        String _getVideoCodecInfo = _getVideoCodecInfo();
        if (!TextUtils.isEmpty(_getVideoCodecInfo)) {
            String[] split = _getVideoCodecInfo.split(",");
            if (split.length >= 2) {
                jVar.f8098b = split[0];
                jVar.f8099c = split[1];
            } else if (split.length >= 1) {
                jVar.f8098b = split[0];
                jVar.f8099c = "";
            }
        }
        String _getAudioCodecInfo = _getAudioCodecInfo();
        if (!TextUtils.isEmpty(_getAudioCodecInfo)) {
            String[] split2 = _getAudioCodecInfo.split(",");
            if (split2.length >= 2) {
                jVar.f8100d = split2[0];
                jVar.e = split2[1];
            } else if (split2.length >= 1) {
                jVar.f8100d = split2[0];
                jVar.e = "";
            }
        }
        String _getSubtitleCodecInfo = _getSubtitleCodecInfo();
        if (!TextUtils.isEmpty(_getSubtitleCodecInfo)) {
            String[] split3 = _getSubtitleCodecInfo.split(",");
            if (split3.length >= 2) {
                jVar.f = split3[0];
                jVar.g = split3[1];
            } else if (split3.length >= 1) {
                jVar.f = split3[0];
                jVar.g = "";
            }
        }
        try {
            jVar.h = ijk.media.player.c.a(_getMediaMeta());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jVar;
    }

    public Bundle getMediaMeta() {
        return _getMediaMeta();
    }

    public long getPlaybackBufferTime() {
        return _getPropertyLong(FFP_PROP_INT64_NEXT_HIGH_WATER_MARK_IN_MS, 0L);
    }

    @Override // ijk.media.player.IMediaPlayer
    public String getPlayerProbeKPI() {
        return getProbeKPI();
    }

    public native String getProbeKPI();

    public boolean getScreenOnWhilePlaying() {
        return this.e;
    }

    public long getSeekLoadDuration() {
        return _getPropertyLong(FFP_PROP_INT64_LATEST_SEEK_LOAD_DURATION, 0L);
    }

    public long getSeekOff() {
        return this.z;
    }

    public int getSelectedTrack(int i) {
        long _getPropertyLong;
        if (i == 1) {
            _getPropertyLong = _getPropertyLong(FFP_PROP_INT64_SELECTED_VIDEO_STREAM, -1L);
        } else if (i == 2) {
            _getPropertyLong = _getPropertyLong(FFP_PROP_INT64_SELECTED_AUDIO_STREAM, -1L);
        } else {
            if (i != 3) {
                return -1;
            }
            _getPropertyLong = _getPropertyLong(FFP_PROP_INT64_SELECTED_TIMEDTEXT_STREAM, -1L);
        }
        return (int) _getPropertyLong;
    }

    @Override // ijk.media.player.IMediaPlayer
    public float getSpeed() {
        return _getPropertyFloat(10003, 0.0f);
    }

    @Override // ijk.media.player.IMediaPlayer
    public boolean getSubBitmap(Bitmap bitmap) {
        return _getSubBitmap(bitmap);
    }

    @Override // ijk.media.player.IMediaPlayer
    public List<String> getSubtitleSeq() {
        return this.r;
    }

    @Override // ijk.media.player.a, ijk.media.player.IMediaPlayer
    public long getSubtitleTrackSum() {
        return _getPropertyLong(FFP_PROP_INT64_SUBTITLE_STREAM_SUM, 0L);
    }

    public long getTcpSpeed() {
        return _getPropertyLong(FFP_PROP_INT64_TCP_SPEED, 0L);
    }

    public long getTrafficStatisticByteCount() {
        return _getPropertyLong(FFP_PROP_INT64_TRAFFIC_STATISTIC_BYTE_COUNT, 0L);
    }

    public long getVideoCachedBytes() {
        return _getPropertyLong(FFP_PROP_INT64_VIDEO_CACHED_BYTES, 0L);
    }

    public long getVideoCachedDuration() {
        return _getPropertyLong(FFP_PROP_INT64_VIDEO_CACHED_DURATION, 0L);
    }

    public long getVideoCachedPackets() {
        return _getPropertyLong(FFP_PROP_INT64_VIDEO_CACHED_PACKETS, 0L);
    }

    public float getVideoDecodeFramesPerSecond() {
        return _getPropertyFloat(10001, 0.0f);
    }

    public int getVideoDecoder() {
        return (int) _getPropertyLong(FFP_PROP_INT64_VIDEO_DECODER, 0L);
    }

    @Override // ijk.media.player.IMediaPlayer
    public int getVideoHeight() {
        return this.h;
    }

    public float getVideoOutputFramesPerSecond() {
        return _getPropertyFloat(10002, 0.0f);
    }

    @Override // ijk.media.player.IMediaPlayer
    public int getVideoSarDen() {
        return this.j;
    }

    @Override // ijk.media.player.IMediaPlayer
    public int getVideoSarNum() {
        return this.i;
    }

    @Override // ijk.media.player.IMediaPlayer
    public List<String> getVideoSeq() {
        return this.p;
    }

    @Override // ijk.media.player.a, ijk.media.player.IMediaPlayer
    public long getVideoTrackSum() {
        return _getPropertyLong(FFP_PROP_INT64_VIDEO_STREAM_SUM, 0L);
    }

    @Override // ijk.media.player.IMediaPlayer
    public int getVideoWidth() {
        return this.g;
    }

    @Override // ijk.media.player.IMediaPlayer
    public float getVolume() {
        return Math.max(_getPropertyFloat(FFP_PROP_FLOAT_LEFT_VOLUME, 0.0f), _getPropertyFloat(10008, 0.0f));
    }

    @Override // ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        return _getLoopCount() != 1;
    }

    @Override // ijk.media.player.IMediaPlayer
    public boolean isPlayable() {
        return true;
    }

    @Override // ijk.media.player.IMediaPlayer
    public native boolean isPlaying();

    public String onErrorDebugLog(int i, int i2, String str) {
        this.l = i2;
        String str2 = this.k;
        if (str == null || str.isEmpty()) {
            str = str2;
        }
        if (i == 151) {
            this.m = "[render_error]Encryption decoding failed";
        } else if (i == 120000) {
            this.m = "[source_error]Unable to connect to server after redirection";
        } else if (i == 140000) {
            this.m = "[drm_error]DRM license certification failed:";
        } else if (i != 170001) {
            switch (i) {
                case 110001:
                    this.m = "[drm_error]Unsupport";
                    break;
                case 110002:
                    this.m = "[drm_error]Unsupport scheme";
                    break;
                case 110003:
                    this.m = "[drm_error]Init unknown error : " + i2;
                    break;
                default:
                    switch (i) {
                        case 121000:
                            this.m = "[source_error]The url file failed to load : " + str;
                            break;
                        case 121001:
                            this.m = "[source_error]Unable to connect to " + str;
                            break;
                        case 121002:
                            this.m = "[source_error]The url file parsing failed : " + str;
                            break;
                        default:
                            switch (i) {
                                case 130000:
                                    this.m = "[source_error]The child m3u8 file failed to load : " + str;
                                    break;
                                case 130001:
                                    this.m = "[source_error]Unable to connect to server while loading child m3u8 : " + str;
                                    break;
                                case 130002:
                                    this.m = "[source_error]The child m3u8 file parsing failed : " + str;
                                    break;
                                default:
                                    switch (i) {
                                        case 131000:
                                            this.m = "[source_error]The segment failed to load : " + str;
                                            break;
                                        case 131001:
                                            this.m = "[source_error]Unable to connect to server while loading segment : " + str;
                                            break;
                                        case 131002:
                                            this.m = "[source_error]The segment file parsing failed : " + str;
                                            break;
                                        case 131003:
                                            this.m = "[source_error]This is before the first chunk in the current manifest.";
                                            break;
                                        default:
                                            switch (i) {
                                                case 141001:
                                                    this.m = "[drm_error]Unable to connect to " + this.k;
                                                    break;
                                                case 141002:
                                                    this.m = "[drm_error]Create MediaCrypto failed";
                                                    break;
                                                case 141003:
                                                    this.m = "[drm_error]DRM keys expired";
                                                    break;
                                                case 141004:
                                                    this.m = "[drm_error]Unknown error : " + i2;
                                                    break;
                                                default:
                                                    switch (i) {
                                                        case 150001:
                                                            this.m = "[render_error]Unable to query device decoders : " + i2;
                                                            break;
                                                        case 150002:
                                                            this.m = "[render_error]This device does not provide a secure video decoder";
                                                            break;
                                                        case 150003:
                                                            this.m = "[render_error]This device does not provide a secure audio decoder";
                                                            break;
                                                        case 150004:
                                                            this.m = "[render_error]This device does not provide a video decoder";
                                                            break;
                                                        case 150005:
                                                            this.m = "[render_error]This device does not provide a audio decoder";
                                                            break;
                                                        case 150006:
                                                            this.m = "[render_error]Unable to instantiate decoder";
                                                            break;
                                                        case 150007:
                                                            this.m = "[render_error] drm session not init";
                                                            break;
                                                        case 150008:
                                                            this.m = "[render_error]Subtitle decoding failed";
                                                            break;
                                                        case 150009:
                                                            this.m = "[render error]Unknown Error : " + i2;
                                                            break;
                                                        default:
                                                            switch (i) {
                                                                case 30000501:
                                                                    this.m = "[error]Unsupport scheme";
                                                                    break;
                                                                case 30000502:
                                                                    this.m = "[license_error]License check fail";
                                                                    break;
                                                                default:
                                                                    this.m = "[error] unknown : " + i2;
                                                                    break;
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
            }
        } else {
            this.m = "[io_error] " + i2;
        }
        Log.e(f8073a, this.m);
        return this.m;
    }

    @Override // ijk.media.player.IMediaPlayer
    public void pause() throws IllegalStateException {
        a(false);
        _pause();
    }

    @Override // ijk.media.player.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        _prepareAsync();
    }

    @Override // ijk.media.player.IMediaPlayer
    public void release() {
        a(false);
        a();
        resetListeners();
        _release();
    }

    @Override // ijk.media.player.IMediaPlayer
    public void reset() {
        a(false);
        _reset();
        this.f8075c.removeCallbacksAndMessages(null);
        this.g = 0;
        this.h = 0;
    }

    @Override // ijk.media.player.a
    public void resetListeners() {
        super.resetListeners();
        this.mOnMediaCodecSelectListener = null;
    }

    @Override // ijk.media.player.IMediaPlayer
    public native void seekTo(long j) throws IllegalStateException;

    public void selectAudioMode(int i) {
        ijk.media.player.c a2;
        ArrayList<c.a> arrayList;
        if (i != 1 && i != 2) {
            Log.d(f8073a, "selectAudioMode not Support mode " + i);
            return;
        }
        if (getAudioTrackSum() == 1) {
            if (i == 1) {
                setVolume(1.0f, 0.0f);
                return;
            } else {
                setVolume(1.0f, 1.0f);
                return;
            }
        }
        if (getAudioTrackSum() == 2) {
            Bundle mediaMeta = getMediaMeta();
            if (mediaMeta == null || (a2 = ijk.media.player.c.a(mediaMeta)) == null || (arrayList = a2.f) == null) {
                return;
            }
            Iterator<c.a> it2 = arrayList.iterator();
            int i2 = 0;
            int i3 = 0;
            while (it2.hasNext() && (!it2.next().f8089c.equalsIgnoreCase(MimeTypes.BASE_TYPE_AUDIO) || (i2 = i2 + 1) != 3 - i)) {
                i3++;
            }
            selectTrack(i3);
            return;
        }
        Log.d(f8073a, "selectAudioMode not Support sum " + getAudioTrackSum());
    }

    public void selectTrack(int i) {
        _setStreamSelected(i, true);
    }

    public void setAndroidIOCallback(IAndroidIO iAndroidIO) throws IllegalArgumentException, SecurityException, IllegalStateException {
        _setAndroidIOCallback(iAndroidIO);
    }

    @Override // ijk.media.player.a, ijk.media.player.IMediaPlayer
    public void setAudioStreamSelected(String str, boolean z) {
        _setAudioStreamSelected(str, z);
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setAudioStreamType(int i) {
    }

    public void setAutoSpeed(boolean z) {
        _setPropertyFloat(FFP_PROP_FLOAT_PLAYBACK_RATE_AUTO, z ? 1.0f : 0.0f);
    }

    public void setCacheShare(int i) {
        _setPropertyLong(FFP_PROP_INT64_SHARE_CACHE_DATA, i);
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(context, uri, null);
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.f8074b = surfaceHolder;
        _setVideoSurface(surfaceHolder != null ? surfaceHolder.getSurface() : null);
        a();
    }

    public native void setFadingVolume(float f2, long j);

    public void setFreeViewEnable(Context context, boolean z, FVGlSurfaceView fVGlSurfaceView) {
        Log.d(f8073a, "setFreeViewEnable " + z);
        if (z) {
            this.s = new ijk.media.player.a.a(context);
            c();
            this.t = fVGlSurfaceView;
            fVGlSurfaceView.setOnTouchListener(new ijk.media.player.f(this));
            return;
        }
        ijk.media.player.a.a aVar = this.s;
        if (aVar != null) {
            aVar.a((b) null);
        }
        this.s = null;
        this.t = null;
    }

    public void setHardwareCodecOnly(boolean z) {
        if (z) {
            setOption(4, "hardware-codec-only", 1L);
        } else {
            setOption(4, "hardware-codec-only", 0L);
        }
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setInitBufferTime(long j) {
        _setPropertyLong(FFP_PROP_INT64_FIRST_HIGH_WATER_MARK_IN_MS, j);
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setKeepInBackground(boolean z) {
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setLogEnabled(boolean z) {
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setLooping(boolean z) {
        int i = !z ? 1 : 0;
        setOption(4, "loop", i);
        _setLoopCount(i);
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setMaxAllBufferSize(long j) {
        _setPropertyLong(FFP_PROP_INT64_LAST_HIGH_WATER_MARK_IN_BYTES, j);
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setMaxBufferSize(long j) {
        _setPropertyLong(FFP_PROP_INT64_MAX_BUFFER_SIZE, j);
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setMaxBufferTime(long j) {
        _setPropertyLong(FFP_PROP_INT64_LAST_HIGH_WATER_MARK_IN_MS, j);
    }

    public void setOnControlMessageListener(c cVar) {
        this.C = cVar;
    }

    public void setOnMediaCodecSelectListener(d dVar) {
        this.mOnMediaCodecSelectListener = dVar;
    }

    public void setOnNativeInvokeListener(e eVar) {
        this.D = eVar;
    }

    public void setOption(int i, String str, String str2) {
        _setOption(i, str, str2);
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setPlaybackBufferTime(long j) {
        _setPropertyLong(FFP_PROP_INT64_NEXT_HIGH_WATER_MARK_IN_MS, j);
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setPreferBitrate(long j) {
        setOption(4, "prefer-bitrate", j);
    }

    public void setPreferedStream(int i) {
        if (i < 0) {
            i = 0;
        }
        setOption(4, "prefer-stream", i);
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        if (this.e != z) {
            if (z && this.f8074b == null) {
                ijk.media.player.b.a.c(f8073a, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.e = z;
            a();
        }
    }

    public void setSensibilty(float f2) {
        ijk.media.player.a.a aVar = this.s;
        if (aVar != null) {
            aVar.a(f2);
        }
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setSpeed(float f2) {
        _setPropertyFloat(10003, f2);
    }

    public void setStreamInfo() {
        ijk.media.player.c a2 = ijk.media.player.c.a(_getTypeMeta(0));
        ijk.media.player.c a3 = ijk.media.player.c.a(_getTypeMeta(1));
        ijk.media.player.c a4 = ijk.media.player.c.a(_getTypeMeta(2));
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.r = new ArrayList();
        a(a2, this.p, "video");
        a(a3, this.q, MimeTypes.BASE_TYPE_AUDIO);
        a(a4, this.r, "timedtext");
    }

    @Override // ijk.media.player.a, ijk.media.player.IMediaPlayer
    public void setSubtitleStreamSelected(String str, boolean z) {
        _setSubtitleStreamSelected(str, z);
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setSurface(Surface surface) {
        if (this.e && surface != null) {
            ijk.media.player.b.a.c(f8073a, "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        this.f8074b = null;
        _setVideoSurface(surface);
        a();
    }

    @Override // ijk.media.player.a, ijk.media.player.IMediaPlayer
    public void setVideoStreamSelected(int i, boolean z) {
        _setVideoStreamSelected(i, z);
    }

    @Override // ijk.media.player.IMediaPlayer
    public native void setVolume(float f2, float f3);

    @Override // ijk.media.player.IMediaPlayer
    public void setWakeMode(Context context, int i) {
        boolean z;
        PowerManager.WakeLock wakeLock = this.f8076d;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                z = true;
                this.f8076d.release();
            } else {
                z = false;
            }
            this.f8076d = null;
        } else {
            z = false;
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i | 536870912, IjkMediaPlayer.class.getName());
        this.f8076d = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        if (z) {
            this.f8076d.acquire();
        }
    }

    @Override // ijk.media.player.IMediaPlayer
    public void start() throws IllegalStateException {
        a(true);
        _start();
    }

    @Override // ijk.media.player.IMediaPlayer
    public void stop() throws IllegalStateException {
        a(false);
        _stop();
    }

    public void switchLeft() {
        Log.d(f8073a, "left--->");
        this.F = Math.max(0, this.F - 1);
        this.G = -1;
        a(-1);
    }

    public void switchRight() {
        Log.d(f8073a, "right--->");
        this.F = Math.min(this.E - 1, this.F + 1);
        this.G = 1;
        a(1);
    }

    public IjkMediaPlayer(ijk.media.player.b bVar) {
        this.f8076d = null;
        this.l = 0;
        this.m = "";
        this.n = true;
        this.t = null;
        this.u = null;
        this.v = 0;
        this.w = 0;
        this.x = 0.0f;
        this.y = 0L;
        this.z = 0L;
        this.E = 1;
        this.F = 0;
        this.G = 0;
        a(bVar);
    }

    @Override // ijk.media.player.IMediaPlayer
    public k[] getTrackInfo() {
        ijk.media.player.c a2;
        Bundle mediaMeta = getMediaMeta();
        if (mediaMeta == null || (a2 = ijk.media.player.c.a(mediaMeta)) == null || a2.f == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<c.a> it2 = a2.f.iterator();
        while (it2.hasNext()) {
            c.a next = it2.next();
            k kVar = new k(next);
            if (next.f8089c.equalsIgnoreCase("video")) {
                kVar.a(1);
            } else if (next.f8089c.equalsIgnoreCase(MimeTypes.BASE_TYPE_AUDIO)) {
                kVar.a(2);
            } else if (next.f8089c.equalsIgnoreCase("timedtext")) {
                kVar.a(3);
            }
            arrayList.add(kVar);
        }
        return (k[]) arrayList.toArray(new k[arrayList.size()]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x007e, code lost:
    
        if (0 == 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
    
        android.util.Log.d(ijk.media.player.IjkMediaPlayer.f8073a, "Couldn't open file on client side, trying server side");
        setDataSource(r9.toString(), r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0095, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0084, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0082, code lost:
    
        if (0 == 0) goto L38;
     */
    @Override // ijk.media.player.IMediaPlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setDataSource(android.content.Context r8, android.net.Uri r9, java.util.Map<java.lang.String, java.lang.String> r10) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.SecurityException, java.lang.IllegalStateException {
        /*
            r7 = this;
            java.lang.String r0 = r9.getScheme()
            java.lang.String r1 = "file"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L14
            java.lang.String r8 = r9.getPath()
            r7.setDataSource(r8)
            return
        L14:
            java.lang.String r1 = "content"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L3b
            java.lang.String r0 = r9.getAuthority()
            java.lang.String r1 = "settings"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L3b
            int r9 = android.media.RingtoneManager.getDefaultType(r9)
            android.net.Uri r9 = android.media.RingtoneManager.getActualDefaultRingtoneUri(r8, r9)
            if (r9 == 0) goto L33
            goto L3b
        L33:
            java.io.FileNotFoundException r8 = new java.io.FileNotFoundException
            java.lang.String r9 = "Failed to resolve default ringtone"
            r8.<init>(r9)
            throw r8
        L3b:
            r0 = 0
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L76 java.io.IOException -> L7d java.lang.SecurityException -> L81
            java.lang.String r1 = "r"
            android.content.res.AssetFileDescriptor r0 = r8.openAssetFileDescriptor(r9, r1)     // Catch: java.lang.Throwable -> L76 java.io.IOException -> L7d java.lang.SecurityException -> L81
            if (r0 != 0) goto L4e
            if (r0 == 0) goto L4d
            r0.close()
        L4d:
            return
        L4e:
            long r1 = r0.getDeclaredLength()     // Catch: java.lang.Throwable -> L76 java.io.IOException -> L7d java.lang.SecurityException -> L81
            r3 = 0
            int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r8 >= 0) goto L60
            java.io.FileDescriptor r8 = r0.getFileDescriptor()     // Catch: java.lang.Throwable -> L76 java.io.IOException -> L7d java.lang.SecurityException -> L81
            r7.setDataSource(r8)     // Catch: java.lang.Throwable -> L76 java.io.IOException -> L7d java.lang.SecurityException -> L81
            goto L70
        L60:
            java.io.FileDescriptor r2 = r0.getFileDescriptor()     // Catch: java.lang.Throwable -> L76 java.io.IOException -> L7d java.lang.SecurityException -> L81
            long r3 = r0.getStartOffset()     // Catch: java.lang.Throwable -> L76 java.io.IOException -> L7d java.lang.SecurityException -> L81
            long r5 = r0.getDeclaredLength()     // Catch: java.lang.Throwable -> L76 java.io.IOException -> L7d java.lang.SecurityException -> L81
            r1 = r7
            r1.a(r2, r3, r5)     // Catch: java.lang.Throwable -> L76 java.io.IOException -> L7d java.lang.SecurityException -> L81
        L70:
            if (r0 == 0) goto L75
            r0.close()
        L75:
            return
        L76:
            r8 = move-exception
            if (r0 == 0) goto L7c
            r0.close()
        L7c:
            throw r8
        L7d:
            if (r0 == 0) goto L87
            goto L84
        L81:
            if (r0 == 0) goto L87
        L84:
            r0.close()
        L87:
            java.lang.String r8 = ijk.media.player.IjkMediaPlayer.f8073a
            java.lang.String r0 = "Couldn't open file on client side, trying server side"
            android.util.Log.d(r8, r0)
            java.lang.String r8 = r9.toString()
            r7.setDataSource(r8, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ijk.media.player.IjkMediaPlayer.setDataSource(android.content.Context, android.net.Uri, java.util.Map):void");
    }

    public void setOption(int i, String str, long j) {
        _setOption(i, str, j);
    }

    public boolean checkLicense(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        QcsLicJNI qcsLicJNI = new QcsLicJNI();
        this.n = false;
        qcsLicJNI.setLicenseCheckCallback(new ijk.media.player.e(this));
        if (qcsLicJNI.LicInit(str, str2, str3, str4, str5, str6, str7) == 0) {
            Log.d(f8073a, "qcsLicJNIInit succeed");
            return true;
        }
        Log.d(f8073a, "qcsLicJNIInit fail");
        return false;
    }

    private void a(FileDescriptor fileDescriptor, long j, long j2) throws IOException, IllegalArgumentException, IllegalStateException {
        setDataSource(fileDescriptor);
    }

    private void a(ijk.media.player.c cVar, List<String> list, String str) {
        String a2;
        ArrayList<Bundle> c2 = cVar.c("streams");
        if (c2 == null) {
            return;
        }
        Integer num = -1;
        Iterator<Bundle> it2 = c2.iterator();
        while (it2.hasNext()) {
            Bundle next = it2.next();
            num = Integer.valueOf(num.intValue() + 1);
            c.a aVar = new c.a(num.intValue());
            if (next != null) {
                aVar.f8087a = next;
                if (str.equals("video")) {
                    a2 = aVar.b("width") + " * " + aVar.b("height");
                } else {
                    a2 = aVar.a("language");
                    if (a2 == null) {
                        a2 = "und";
                    }
                }
                list.add(a2);
            }
        }
        if (num.intValue() == -1) {
            list.add("Null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        FVGlSurfaceView fVGlSurfaceView = this.t;
        if (fVGlSurfaceView != null) {
            fVGlSurfaceView.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        PowerManager.WakeLock wakeLock = this.f8076d;
        if (wakeLock != null) {
            if (z && !wakeLock.isHeld()) {
                this.f8076d.acquire();
            } else if (!z && this.f8076d.isHeld()) {
                this.f8076d.release();
            }
        }
        this.f = z;
        a();
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.k = str;
        if (!this.n) {
            Log.d(f8073a, "license is invalid");
            if (this.mNativeMediaPlayer == 0) {
                ijk.media.player.b.a.c(f8073a, "IjkMediaPlayer went away with unhandled events");
                return;
            }
            ijk.media.player.b.a.a(f8073a, "Error :LICENSE_INVALID");
            Pair<Integer, String> pair = this.o;
            if (pair != null && !notifyOnError(((Integer) pair.first).intValue(), 0)) {
                notifyOnCompletion();
            }
            a(false);
            return;
        }
        if (str.startsWith("zxquic")) {
            setOption(1, "http-tcp-hook", "zxquic");
            str = HttpConstant.PROTOCOL_HTTP + str.substring(6);
        }
        if (str.startsWith("multicast")) {
            setOption(1, "http-tcp-hook", "udp");
            str = HttpConstant.PROTOCOL_HTTP + str.substring(9);
        }
        _setDataSource(str, null, null);
    }

    private void a() {
        SurfaceHolder surfaceHolder = this.f8074b;
        if (surfaceHolder != null) {
            surfaceHolder.setKeepScreenOn(this.e && this.f);
        }
    }

    private void a(int i) {
        _setPropertyLong(FFP_PROP_INT64_FREEVIEW_TRACK_OFF, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(MotionEvent motionEvent) {
        ijk.media.player.a.a aVar = this.s;
        if (aVar == null) {
            return true;
        }
        aVar.a(motionEvent);
        return true;
    }

    public void setDataSource(String str, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":");
                if (!TextUtils.isEmpty(entry.getValue())) {
                    sb.append(entry.getValue());
                }
                sb.append("\r\n");
                setOption(1, "headers", sb.toString());
                setOption(1, "protocol_whitelist", "async,cache,crypto,file,http,https,ijkhttphook,ijkinject,ijklivehook,ijklongurl,ijksegment,ijktcphook,pipe,rtp,tcp,tls,udp,ijkurlhook,data");
            }
        }
        setDataSource(str);
    }

    @Override // ijk.media.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        if (Build.VERSION.SDK_INT < 12) {
            try {
                Field declaredField = fileDescriptor.getClass().getDeclaredField("descriptor");
                declaredField.setAccessible(true);
                _setDataSourceFd(declaredField.getInt(fileDescriptor));
                return;
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (NoSuchFieldException e3) {
                throw new RuntimeException(e3);
            }
        }
        ParcelFileDescriptor dup = ParcelFileDescriptor.dup(fileDescriptor);
        try {
            _setDataSourceFd(dup.getFd());
        } finally {
            dup.close();
        }
    }

    @Override // ijk.media.player.a, ijk.media.player.IMediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException {
        _setDataSource(iMediaDataSource);
    }
}
