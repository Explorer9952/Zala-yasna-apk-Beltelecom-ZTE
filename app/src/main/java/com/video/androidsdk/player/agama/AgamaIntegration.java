package com.video.androidsdk.player.agama;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.video.androidsdk.player.agama.Utils;
import java.text.SimpleDateFormat;
import java.util.Date;
import tv.agama.emp.client.Definitions$DeviceMetadata;
import tv.agama.emp.client.Definitions$DsPlaylistType;
import tv.agama.emp.client.Definitions$DsProtocol;
import tv.agama.emp.client.Definitions$LogLevel;
import tv.agama.emp.client.Definitions$Measurement;
import tv.agama.emp.client.Definitions$SessionMetadata;
import tv.agama.emp.client.Definitions$ShutdownType;
import tv.agama.emp.client.Definitions$ViewStates;
import tv.agama.emp.client.EMPClient;
import tv.agama.emp.client.exception.AgamaException;

/* loaded from: classes.dex */
public final class AgamaIntegration {
    public static final int PROP_ASSET_DURATION = 5;
    public static final int PROP_CONTENT_TITLE = 2;
    public static final int PROP_CONTENT_TYPE = 3;
    public static final int PROP_SERVICE_NAME = 4;
    public static final int PROP_USER_ACCOUNT_ID = 1;

    /* renamed from: b, reason: collision with root package name */
    private static Utils.AgamaConf f3317b = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f3318c = "1.0";

    /* renamed from: d, reason: collision with root package name */
    private static EMPClient f3319d;
    private static Context r;

    /* renamed from: a, reason: collision with root package name */
    private BroadcastReceiver f3320a;
    private SimpleExoPlayer e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private long p;
    private long q;
    private Handler s;
    private Runnable t;

    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final AgamaIntegration f3321a = new AgamaIntegration(null);
    }

    static {
        System.loadLibrary("empcomm-combined");
    }

    /* synthetic */ AgamaIntegration(com.video.androidsdk.player.agama.a aVar) {
        this();
    }

    private void b() {
        c();
        this.s = new Handler();
        Log.d("AgamaIntegration", "installBufferHandler");
        b bVar = new b(this);
        this.t = bVar;
        this.s.post(bVar);
    }

    private void c() {
        if (this.s == null || this.t == null) {
            return;
        }
        Log.d("AgamaIntegration", "unInstallBufferHandler");
        this.s.removeCallbacks(this.t);
    }

    private void d() {
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = 0L;
        this.l = 0L;
        this.m = 0L;
        this.n = 0L;
        this.o = 0L;
        this.p = 0L;
        this.q = 0L;
        this.g = false;
        this.f = false;
    }

    public static AgamaIntegration getAgamaInstance() {
        return a.f3321a;
    }

    public static Utils.AgamaConf getConfig() {
        Utils.AgamaConf agamaConf = f3317b;
        if (agamaConf == null) {
            return null;
        }
        return new Utils.AgamaConf(agamaConf);
    }

    public static boolean setConfig(Utils.AgamaConf agamaConf) {
        EMPClient eMPClient = f3319d;
        if (eMPClient == null) {
            return false;
        }
        try {
            eMPClient.a(agamaConf.a());
            f3317b = agamaConf;
            Log.d("AgamaIntegration", "Configuration updated to: " + agamaConf.a());
            return true;
        } catch (AgamaException unused) {
            Log.e("AgamaIntegration", "Invalid config string: " + agamaConf.a());
            return false;
        }
    }

    public EMPClient getEMpClientInstance() {
        return f3319d;
    }

    public void init(Context context, Utils.AgamaConf agamaConf, Definitions$LogLevel definitions$LogLevel) {
        r = context;
        if (f3319d != null) {
            return;
        }
        try {
            f3319d = new EMPClient(agamaConf.a(), definitions$LogLevel);
            f3317b = agamaConf;
            com.video.androidsdk.player.agama.a aVar = new com.video.androidsdk.player.agama.a(this);
            this.f3320a = aVar;
            context.registerReceiver(aVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            a(context);
        } catch (AgamaException e) {
            Log.e("AgamaIntegration", "Error : Could not initialise EMP client: " + e.getMessage());
        }
    }

    public void processHttpResponse(String str) {
        if (str.matches("HTTP/.* 1[09][09] .*")) {
            setMeasurement(Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_1XX, 1L);
            return;
        }
        if (str.matches("HTTP/.* 2[09][09] .*")) {
            setMeasurement(Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_2XX, 1L);
            return;
        }
        if (str.matches("HTTP/.* 3[09][09] .*")) {
            setMeasurement(Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_3XX, 1L);
        } else if (str.matches("HTTP/.* 4[09][09] .*")) {
            setMeasurement(Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_4XX, 1L);
        } else if (str.matches("HTTP/.* 5[09][09] .*")) {
            setMeasurement(Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_5XX, 1L);
        }
    }

    public void sessionExit() {
        Log.d("AgamaIntegration", "Exit session");
        updatePlayerPosition();
        c();
        EMPClient eMPClient = f3319d;
        if (eMPClient != null) {
            eMPClient.a();
        }
    }

    public void sessionOpen(Utils.Asset asset) {
        if (f3319d == null) {
            return;
        }
        try {
            d();
            Log.d("AgamaIntegration", "DS Session: " + asset.uri);
            f3319d.a(asset.uri, a(asset.protocol), asset.name, asset.isLive ? Definitions$DsPlaylistType.LIVE : Definitions$DsPlaylistType.VOD, Definitions$ViewStates.INITIAL_BUFFERING);
            setIntegrationExternalParams(2, asset.contentTitle);
            setIntegrationExternalParams(3, asset.contentType);
            setIntegrationExternalParams(5, asset.contentDuration);
            setIntegrationExternalParams(4, asset.isLive ? "live" : "svod");
            this.f = asset.isLive;
            b();
        } catch (IllegalArgumentException e) {
            Log.e("AgamaIntegration", "Could not create new dynamicStreamingSession: " + e);
        }
    }

    public void setIntegrationExternalParams(int i, String str) {
        EMPClient eMPClient = f3319d;
        if (eMPClient == null) {
            return;
        }
        if (i == 1) {
            eMPClient.a(Definitions$DeviceMetadata.USER_ACCOUNT_ID, str);
            return;
        }
        if (i == 2) {
            eMPClient.a(Definitions$SessionMetadata.CONTENT_TITLE, str);
        } else if (i == 3) {
            eMPClient.a(Definitions$SessionMetadata.CONTENT_TYPE, str);
        } else {
            if (i != 4) {
                return;
            }
            eMPClient.a(Definitions$SessionMetadata.SERVICE_NAME, str);
        }
    }

    public void setMeasurement(Definitions$Measurement definitions$Measurement, long j) {
        if (f3319d == null) {
            return;
        }
        switch (c.f3330a[definitions$Measurement.ordinal()]) {
            case 1:
                long j2 = this.k + j;
                this.k = j2;
                f3319d.a(Definitions$Measurement.BYTES_RECEIVED, j2);
                return;
            case 2:
                f3319d.a(Definitions$Measurement.SEGMENT_READ_BITRATE, j);
                return;
            case 3:
                long j3 = this.m + j;
                this.m = j3;
                f3319d.a(Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_1XX, j3);
                return;
            case 4:
                long j4 = this.n + j;
                this.n = j4;
                f3319d.a(Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_2XX, j4);
                return;
            case 5:
                long j5 = this.o + j;
                this.o = j5;
                f3319d.a(Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_3XX, j5);
                return;
            case 6:
                long j6 = this.p + j;
                this.p = j6;
                f3319d.a(Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_4XX, j6);
                return;
            case 7:
                long j7 = this.q + j;
                this.q = j7;
                f3319d.a(Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_5XX, j7);
                return;
            case 8:
                long j8 = this.l + j;
                this.l = j8;
                f3319d.a(Definitions$Measurement.NUMBER_OF_FRAMES_DROPPED, j8);
                return;
            case 9:
                f3319d.a(Definitions$Measurement.SEGMENT_PROFILE_BITRATE, j);
                return;
            default:
                f3319d.a(definitions$Measurement, j);
                return;
        }
    }

    public void setPlayer(SimpleExoPlayer simpleExoPlayer) {
        this.e = simpleExoPlayer;
    }

    public void setSessionMetadata(Definitions$SessionMetadata definitions$SessionMetadata, String str) {
        if (f3319d == null) {
            return;
        }
        int i = c.f3331b[definitions$SessionMetadata.ordinal()];
        if (i == 1) {
            if (this.h) {
                return;
            }
            f3319d.a(Definitions$SessionMetadata.MANIFEST_URI, str);
            this.h = true;
            return;
        }
        if (i != 2) {
            if (i == 3 && !this.j) {
                f3319d.a(Definitions$SessionMetadata.DS_INITIAL_PROFILE, str);
                this.j = true;
                return;
            }
            return;
        }
        if (this.i) {
            return;
        }
        f3319d.a(Definitions$SessionMetadata.NUMBER_OF_CONTENT_PROFILES, Integer.parseInt(str));
        this.i = true;
    }

    public void setViewState(int i, String str, String str2) {
        if (f3319d == null) {
            return;
        }
        updatePlayerPosition();
        if (i == -1) {
            f3319d.a(Definitions$ViewStates.FAILED, str, str2);
            this.g = true;
            return;
        }
        if (i == 0) {
            if (this.g) {
                return;
            }
            f3319d.a(Definitions$ViewStates.PAUSED);
            return;
        }
        if (i == 3) {
            f3319d.a(Definitions$ViewStates.PLAYING);
            return;
        }
        if (i == 4) {
            if (this.g) {
                return;
            }
            f3319d.a(Definitions$ViewStates.PAUSED, str, str2);
        } else if (i == 5) {
            f3319d.a(Definitions$ViewStates.PAUSED, str, str2);
        } else if (i == 8) {
            f3319d.a(Definitions$ViewStates.STALLED);
        } else {
            if (i != 10) {
                return;
            }
            f3319d.a(Definitions$ViewStates.SEEK);
        }
    }

    public void shutdown() {
        if (f3319d != null) {
            Log.d("AgamaIntegration", "Shutdown");
            f3319d.a(Definitions$ShutdownType.NORMAL_SHUTDOWN);
            f3319d = null;
            r.unregisterReceiver(this.f3320a);
        }
    }

    public void unsetPlayer() {
        this.e = null;
    }

    public void updatePlayerPosition() {
        SimpleExoPlayer simpleExoPlayer;
        EMPClient eMPClient;
        if (this.f || (simpleExoPlayer = this.e) == null || (eMPClient = f3319d) == null) {
            return;
        }
        eMPClient.a(Definitions$Measurement.PLAYBACK_POSITION, simpleExoPlayer.getContentPosition());
        Log.d("AgamaIntegration", "updatePlayerPosition");
    }

    private AgamaIntegration() {
        this.e = null;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = 0L;
        this.l = 0L;
        this.m = 0L;
        this.n = 0L;
        this.o = 0L;
        this.p = 0L;
        this.q = 0L;
        this.s = null;
        this.t = null;
    }

    private static void a(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%016d%s", 0, string));
        String sb2 = sb.insert(8, "-").insert(13, "-").insert(18, "-").insert(23, "-").toString();
        Log.d("AgamaIntegration", "DeviceID set to: " + sb2);
        f3319d.a(Definitions$DeviceMetadata.DEVICE_ID, sb2);
        f3319d.a(Definitions$DeviceMetadata.DEVICE_TYPE, Utils.a(context) ? "tablet" : "mobile");
        f3319d.a(Definitions$DeviceMetadata.DEVICE_MANUFACTURER, Build.MANUFACTURER);
        f3319d.a(Definitions$DeviceMetadata.DEVICE_MODEL, Build.MODEL);
        f3319d.a(Definitions$DeviceMetadata.DEVICE_IP, Utils.a());
        f3319d.a(Definitions$DeviceMetadata.DEVICE_OS, "Android");
        f3319d.a(Definitions$DeviceMetadata.DEVICE_OS_VERSION, String.valueOf(Build.VERSION.SDK_INT));
        f3319d.a(Definitions$DeviceMetadata.PLAYER, ExoPlayerLibraryInfo.TAG);
        f3319d.a(Definitions$DeviceMetadata.PLAYER_VERSION, ExoPlayerLibraryInfo.VERSION);
        f3319d.a(Definitions$DeviceMetadata.APPLICATION, context.getString(context.getApplicationInfo().labelRes));
        f3319d.a(Definitions$DeviceMetadata.APPLICATION_VERSION, "");
        f3319d.a(Definitions$DeviceMetadata.EMPCLIENT_INTEGRATION_VERSION, f3318c);
        f3319d.a(Definitions$DeviceMetadata.EMPCLIENT_INTEGRATION_BUILDDATE, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        f3319d.a(Definitions$DeviceMetadata.USER_ACCOUNT_ID, "");
    }

    public void setIntegrationExternalParams(int i, int i2) {
        EMPClient eMPClient = f3319d;
        if (eMPClient == null || i != 5 || this.f) {
            return;
        }
        eMPClient.a(Definitions$SessionMetadata.ASSET_DURATION, i2);
    }

    protected Definitions$DsProtocol a(String str) {
        if ("hls".equalsIgnoreCase(str)) {
            return Definitions$DsProtocol.APPLE_HLS;
        }
        if ("dash".equalsIgnoreCase(str)) {
            return Definitions$DsProtocol.MPEG_DASH;
        }
        return Definitions$DsProtocol.UNDEFINED;
    }
}
