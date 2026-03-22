package com.video.androidsdk.player.ctciptvplayer;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Util;
import com.video.androidsdk.log.LogEx;
import common.android.mscpcfg.McspCfgmanager;
import common.mcspevtmanager.McspCompCommun;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CTCIPTVPlayer {

    /* renamed from: d, reason: collision with root package name */
    private static int f3369d = 2;
    private static int e;
    private static Map<Long, WeakReference<CTCIPTVPlayer>> l = new HashMap();
    private d A;
    private String g;
    private String h;
    private String i;
    private String j;
    private int m;
    private int n;
    private int o;
    private int p;
    private a u;
    private f v;
    private g w;
    private e x;
    private b y;
    private c z;
    private String f = "";
    private boolean k = false;
    private McspCompCommun q = null;
    private McspCfgmanager r = null;

    /* renamed from: a, reason: collision with root package name */
    List<String> f3370a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    Map<String, String> f3371b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    Map<String, String> f3372c = new HashMap();
    private int[] s = {25186304, 25190326, 25190327};
    private boolean t = false;

    /* loaded from: classes.dex */
    public interface a {
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean onError(CTCIPTVPlayer cTCIPTVPlayer, int i, String str);
    }

    /* loaded from: classes.dex */
    public interface d {
    }

    /* loaded from: classes.dex */
    public interface e {
        void onPrepared(CTCIPTVPlayer cTCIPTVPlayer);
    }

    /* loaded from: classes.dex */
    public interface f {
    }

    /* loaded from: classes.dex */
    public interface g {
    }

    public CTCIPTVPlayer(boolean z) {
        try {
            System.loadLibrary("CTC_MediaControl");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
        b("CTCIPTVPlayer");
        String a2 = a(z);
        LogEx.i("CTCIPTVPlayer", "strPlayerID=" + a2);
        if (!TextUtils.isEmpty(a2)) {
            e = Integer.valueOf(a2).intValue();
        } else {
            LogEx.e("CTCIPTVPlayer", "strPlayerID is null!!!");
        }
        l.put(Long.valueOf(e), new WeakReference<>(this));
        LogEx.i("CTCIPTVPlayer", "miPlayerID=" + e);
    }

    private String A() {
        String a2 = a("TV_Client", 25182208, 25182227, 0, String.format("{\"mplayerid\":\"%d\"}", Integer.valueOf(e)));
        LogEx.d("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        this.f3370a.add("audiochannel");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("audiochannel") : "";
    }

    private String B() {
        String a2 = a("TV_Client", 25182208, 25182334, 0, String.format("{\"mplayerid\":\"%d\",\"UserChannelID\":\"%s\",\"ChannelURL\":\"%s\",\"TimeShiftURL\":\"%s\"}", Integer.valueOf(e), this.j, this.h, this.i));
        LogEx.d("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("returncode") : "";
    }

    private native int JNI_create(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13);

    private void b(String str) {
        McspCompCommun mcspCompCommun = new McspCompCommun(str);
        this.q = mcspCompCommun;
        if (mcspCompCommun == null) {
            LogEx.d("CTCIPTVPlayer", "----------> compCom null error");
            return;
        }
        int MCSP_SrvEvt_Init = mcspCompCommun.MCSP_SrvEvt_Init();
        if (MCSP_SrvEvt_Init < 0) {
            LogEx.d("CTCIPTVPlayer", "MCSP_SrvEvt_Init error! ret = " + MCSP_SrvEvt_Init);
        }
        this.q.MCSP_RegisterMethod(this, CTCIPTVPlayer.class.getName(), "notify", "invoke");
        McspCfgmanager mcspCfgmanager = new McspCfgmanager();
        this.r = mcspCfgmanager;
        mcspCfgmanager.newComoCommun(this.q);
    }

    public static byte[] g(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }

    private String r() {
        String a2 = a("TV_Client", 25182208, 25182280, 0, String.format("{\"mplayerid\": \"%s\"}", Integer.valueOf(e)));
        LogEx.d("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        this.f3370a.add("playmode");
        this.f3370a.add("speed");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("playmode") : "";
    }

    private String s() {
        String a2 = a("TV_Client", 25182208, 25182211, 0, String.format("{\"cmd\":\"playfromstart\",\"session\":%d, \"mplayerid\":%d}", 0, Integer.valueOf(e)));
        LogEx.d("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("returncode") : "";
    }

    private String t() {
        String a2 = a("TV_Client", 25182208, 25182213, 0, String.format("{\"cmd\":\"pause\",\"session\":%d, \"mplayerid\":%d}", 0, Integer.valueOf(e)));
        LogEx.d("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("returncode") : "";
    }

    private String u() {
        String format = String.format("{\"cmd\":\"stop\",\"session\":%d, \"mplayerid\":%d}", 0, Integer.valueOf(e));
        LogEx.d("CTCIPTVPlayer", "strRequest is " + format);
        String a2 = a("TV_Client", 25182208, 25182219, 0, format);
        LogEx.d("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("returncode") : "";
    }

    private String v() {
        String format = String.format("{\"mplayerid\":%d}", Integer.valueOf(e));
        LogEx.d("CTCIPTVPlayer", "strRequest is " + format);
        String a2 = a("TV_Client", 25182208, 25182210, 0, format);
        LogEx.d("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("returncode") : "";
    }

    private String w() {
        String a2 = a("TV_Client", 25182208, 25182272, 0, String.format("{\"mplayerid\":\"%d\"}", Integer.valueOf(e)));
        LogEx.d("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("returncode") : "";
    }

    private String x() {
        String a2 = a("TV_Client", 25182208, 25182223, 0, String.format("{\"mplayerid\":\"%d\"}", Integer.valueOf(e)));
        LogEx.d("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        this.f3370a.add("volume");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("volume") : "";
    }

    private String y() {
        String a2 = a("TV_Client", 25182208, 25182243, 0, String.format("{\"mplayerid\":\"%d\"}", Integer.valueOf(e)));
        LogEx.d("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        this.f3370a.add("mediaduration");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("mediaduration") : "";
    }

    private String z() {
        String a2 = a("TV_Client", 25182208, 25182244, 0, String.format("{\"mplayerid\":\"%d\"}", Integer.valueOf(e)));
        LogEx.d("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        this.f3370a.add("currentplaytime");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("currentplaytime") : "";
    }

    public int a() {
        return e;
    }

    public boolean c() {
        LogEx.i("CTCIPTVPlayer", "isPlaying start");
        String r = r();
        LogEx.i("CTCIPTVPlayer", "strPlayState is: " + r);
        return "Normal Play".equalsIgnoreCase(r);
    }

    public int d() {
        LogEx.i("CTCIPTVPlayer", "GetPlayState start");
        String r = r();
        LogEx.i("CTCIPTVPlayer", "strPlayState is: " + r);
        if ("Stoped".equalsIgnoreCase(r)) {
            return 0;
        }
        if ("Pause".equalsIgnoreCase(r)) {
            return 1;
        }
        if ("Normal Play".equalsIgnoreCase(r)) {
            return 2;
        }
        return "Trickmode".equalsIgnoreCase(r) ? 3 : 6;
    }

    public long e() {
        LogEx.i("CTCIPTVPlayer", "getCurrentPosition start");
        String z = z();
        LogEx.d("CTCIPTVPlayer", "strCurrentPosition is:" + z);
        if (!TextUtils.isEmpty(z)) {
            try {
                return Long.valueOf(z).longValue();
            } catch (Exception unused) {
                LogEx.i("CTCIPTVPlayer", "strCurrentPosition is:" + z);
                String z2 = z();
                if (z2 != null && z2.endsWith(".00Z")) {
                    String substring = z2.substring(0, z2.length() - 4);
                    LogEx.i("CTCIPTVPlayer", "strCurrentPosition is:" + substring);
                    Date date = new Date(Long.valueOf(substring.replace("T", "")).longValue());
                    LogEx.i("CTCIPTVPlayer", "strCurrentPosition is:" + date.toString());
                    return date.getTime();
                }
            }
        }
        return 0L;
    }

    public int f() {
        LogEx.i("CTCIPTVPlayer", "getDuration start");
        String y = y();
        if (TextUtils.isEmpty(y)) {
            return 0;
        }
        return Integer.valueOf(y).intValue();
    }

    public void g() {
        t();
    }

    public int h() {
        String B;
        McspCompCommun mcspCompCommun = this.q;
        if (mcspCompCommun != null) {
            int[] iArr = this.s;
            mcspCompCommun.MCSP_EVTSubscribe(iArr, iArr.length);
        }
        if (!this.k) {
            B = s();
        } else {
            B = B();
        }
        int intValue = !TextUtils.isEmpty(B) ? Integer.valueOf(B).intValue() : -1;
        LogEx.d("CTCIPTVPlayer", "iHr=" + intValue);
        return intValue;
    }

    public void i() {
        LogEx.i("CTCIPTVPlayer", "stop start");
        McspCompCommun mcspCompCommun = this.q;
        if (mcspCompCommun != null) {
            int[] iArr = this.s;
            mcspCompCommun.MCSP_EVTUnsubscribe(iArr, iArr.length);
        }
        if (!this.k) {
            u();
        } else {
            v();
        }
    }

    public void j() {
        LogEx.i("CTCIPTVPlayer", "release start");
        this.x = null;
        this.u = null;
        this.y = null;
        this.v = null;
        this.z = null;
        this.A = null;
        this.w = null;
        McspCompCommun mcspCompCommun = this.q;
        if (mcspCompCommun != null) {
            int[] iArr = this.s;
            mcspCompCommun.MCSP_EVTUnsubscribe(iArr, iArr.length);
        }
        w();
    }

    public int k() {
        LogEx.i("CTCIPTVPlayer", "getVolume start");
        return Integer.valueOf(x()).intValue();
    }

    public int l() {
        LogEx.i("CTCIPTVPlayer", "GetAudioBalance start");
        String A = A();
        LogEx.d("CTCIPTVPlayer", "strAudioBalance is: " + A);
        if ("Left".equalsIgnoreCase(A)) {
            return 0;
        }
        if ("Right".equalsIgnoreCase(A)) {
            return 1;
        }
        if ("Stereo".equalsIgnoreCase(A)) {
            return 2;
        }
        return "JointStereo".equalsIgnoreCase(A) ? 3 : 0;
    }

    public String m() {
        String a2 = a("TV_Client", 25182208, 25182214, 0, String.format("{\"cmd\":\"resume\",\"session\":%d, \"mplayerid\":%d}", 0, Integer.valueOf(e)));
        LogEx.d("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("returncode") : "";
    }

    public String n() {
        String a2 = a("TV_Client", 25182208, 25182218, 0, String.format("{\"mplayerid\":\"%d\"}", Integer.valueOf(e)));
        LogEx.i("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("returncode") : "";
    }

    native int nativeCreateSurface(Object obj, int i, int i2);

    native void nativeDelMediaProcess();

    native boolean nativeFast();

    native int nativeGetAudioBalance();

    native void nativeGetMediaProcess();

    native int nativeGetPlayMode();

    native void nativeGetVideoPixels();

    native int nativeGetVolume();

    native int nativeInit(int i, int i2, int i3, int i4, String str, int i5);

    native boolean nativeIsSoftFit();

    native boolean nativePause();

    native boolean nativeResume();

    native boolean nativeSeek();

    native boolean nativeSetAudioBalance(int i);

    native void nativeSetEPGSize(int i, int i2);

    native boolean nativeSetRatio(int i);

    native void nativeSetVideoHole(int i, int i2, int i3, int i4);

    native int nativeSetVideoWindow(int i, int i2, int i3, int i4);

    native boolean nativeSetVolume(int i);

    native boolean nativeStartPlay();

    native boolean nativeStop();

    native boolean nativeStopFast();

    native int nativeVideoHide();

    native int nativeVideoShow();

    native int nativeWriteData(String str);

    native void nativeWriteFile(String str, String str2, String str3);

    public ArrayList<String> o() {
        String a2 = a("TV_Client", 25182208, 25182242, 0, String.format("{\"mplayerid\":\"%d\",\"fieldname\":\"%s\"}", Integer.valueOf(e), "GetAudioTrackList"));
        LogEx.d("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        this.f3370a.add("fieldvalue");
        this.f3372c = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        ArrayList<String> arrayList = new ArrayList<>();
        Map<String, String> map = this.f3372c;
        if (map != null) {
            String str = map.get("fieldvalue");
            LogEx.i("CTCIPTVPlayer", "fieldvalue : " + str);
            if (str != null) {
                for (String str2 : str.split(",")) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<String> p() {
        String a2 = a("TV_Client", 25182208, 25182242, 0, String.format("{\"mplayerid\":\"%d\",\"fieldname\":\"%s\"}", Integer.valueOf(e), "GetSubtitleList"));
        LogEx.d("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        this.f3370a.add("fieldvalue");
        this.f3372c = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        ArrayList<String> arrayList = new ArrayList<>();
        Map<String, String> map = this.f3372c;
        if (map != null) {
            String str = map.get("fieldvalue");
            LogEx.i("CTCIPTVPlayer", "fieldvalue : " + str);
            if (str != null) {
                for (String str2 : str.split(",")) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    public String q() {
        String a2 = a("TV_Client", 25182208, 25184210, 0, String.format("{\"mplayerid\":\"%d\",\"fieldname\":\"%s\"}", Integer.valueOf(e), "EnableCloseCaption"));
        LogEx.i("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        this.f3370a.add("fieldvalue");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("fieldvalue") : "";
    }

    public void a(int i, int i2, int i3, int i4) {
        LogEx.i("CTCIPTVPlayer", "setVideoDisplayArea start");
        this.o = i;
        this.p = i2;
        this.m = i4;
        this.n = i3;
    }

    private String c(String str) {
        String a2 = a("TV_Client", 25182208, 25182220, 0, String.format("{\"cmd\":\"setsinglemedia\",\"session\":%d,\"mplayerid\":%d,\"mediaURL\":\"%s\",\"mediaCode\":\"%s\",\"mediaType\":%d,\"audioType\":%d,\"videoType\":%d,\"streamType\":%d,\"drmType\":%d,\"fingerPrint\":%d,\"copyProtection\":%d,\"allowTrickmode\":%d,\"startTime\":\"%s\",\"endTime\":\"%s\",\"entryID\":\"%s\"}", 0, Integer.valueOf(e), str, "code1", 2, 1, 1, 1, 1, 0, 1, 1, "0", "5000", "entry1"));
        LogEx.d("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("returncode") : "";
    }

    public String f(int i) {
        String a2 = a("TV_Client", 25182208, 25184212, 0, String.format("{\"mplayerid\":\"%d\",\"fieldname\":\"%s\",\"fieldvalue\":\"%d\"}", Integer.valueOf(e), "EnableCloseCaption", Integer.valueOf(i)));
        LogEx.i("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("returncode") : "";
    }

    public void a(String str) {
        LogEx.i("CTCIPTVPlayer", "setProgramURL start");
        if (TextUtils.isEmpty(str)) {
            LogEx.e("CTCIPTVPlayer", "play uri is null");
        } else {
            this.g = str;
            this.k = false;
        }
    }

    private String d(String str) {
        if (true == this.k) {
            Date date = new Date(Long.valueOf(str).longValue());
            LogEx.i("CTCIPTVPlayer", "curDate:   " + date.toString());
            String format = new SimpleDateFormat("yyyyMMdd-HHmmss").format(date);
            LogEx.i("CTCIPTVPlayer", "dateString:   " + format + ".00Z");
            str = format.replace("-", "T") + ".00Z";
        }
        String a2 = a("TV_Client", 25182208, 25182212, 0, String.format("{\"cmd\":\"playbytime\",\"session\":%d, \"mplayerid\":%d, \"timetype\":%d, \"playtime\":\"%s\",\"playspeed\":%d}", 0, Integer.valueOf(e), 1, str, 1));
        LogEx.d("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("returncode") : "";
    }

    public void b() {
        LogEx.i("CTCIPTVPlayer", "prepareAsync start");
        if (!this.k) {
            String c2 = c(this.g);
            LogEx.d("CTCIPTVPlayer", "res is " + c2);
            if ("0".equals(c2)) {
                this.x.onPrepared(this);
                return;
            } else {
                if (TextUtils.isEmpty(c2)) {
                    this.z.onError(this, Integer.valueOf(c2).intValue(), "prepare video failed");
                    return;
                }
                return;
            }
        }
        this.x.onPrepared(this);
    }

    public void a(String str, String str2, String str3) {
        LogEx.i("CTCIPTVPlayer", "setTVUrl start");
        if (TextUtils.isEmpty(str)) {
            LogEx.e("CTCIPTVPlayer", "play uri is null");
            return;
        }
        this.h = str;
        this.i = str2;
        this.j = str3;
        this.k = true;
    }

    public String c(int i) {
        String a2 = a("TV_Client", 25182208, 25182222, 0, String.format("{\"mplayerid\":\"%d\", \"volume\":\"%d\"}", Integer.valueOf(e), Integer.valueOf(i)));
        LogEx.d("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("returncode") : "";
    }

    private String e(String str) {
        String a2 = a("TV_Client", 25182208, 25182226, 0, String.format("{\"mplayerid\":\"%d\", \"audiochannel\": \"%s\"}", Integer.valueOf(e), str));
        LogEx.d("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("returncode") : "";
    }

    public void b(int i) {
        LogEx.i("CTCIPTVPlayer", "SetAudioBalance start");
        LogEx.d("CTCIPTVPlayer", "iResult is: " + e("" + i));
    }

    public void a(long j) {
        LogEx.i("CTCIPTVPlayer", "seekTo start");
        d("" + j);
    }

    public void a(int i) {
        LogEx.i("CTCIPTVPlayer", "setVolume start");
        c(i);
    }

    public String e(int i) {
        String a2 = a("TV_Client", 25182208, 25182241, 0, String.format("{\"mplayerid\":\"%d\",\"fieldname\":\"%s\",\"fieldvalue\":\"%d\"}", Integer.valueOf(e), "SetSubtitle", Integer.valueOf(i)));
        LogEx.d("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("returncode") : "";
    }

    private String a(boolean z) {
        String a2;
        if (z) {
            a2 = a("TV_Client", 25182208, 25182342, 0, "{\"PlayerType\":\"PIP\"}");
        } else {
            a2 = a("TV_Client", 25182208, 25182342, 0, null);
        }
        LogEx.d("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("mplayerid");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("mplayerid") : "";
    }

    public String d(int i) {
        String a2 = a("TV_Client", 25182208, 25182241, 0, String.format("{\"mplayerid\":\"%d\",\"fieldname\":\"%s\",\"fieldvalue\":\"%d\"}", Integer.valueOf(e), "SetAudioTrack", Integer.valueOf(i)));
        LogEx.d("CTCIPTVPlayer", "rsp is " + a2);
        this.f3370a.clear();
        this.f3370a.add("returncode");
        Map<String, String> a3 = com.video.androidsdk.player.ctciptvplayer.a.a(this.f3370a, a2);
        this.f3372c = a3;
        return a3 != null ? a3.get("returncode") : "";
    }

    public void a(a aVar) {
        this.u = aVar;
    }

    public void a(f fVar) {
        this.v = fVar;
    }

    public void a(g gVar) {
        this.w = gVar;
    }

    public void a(e eVar) {
        this.x = eVar;
    }

    public void a(b bVar) {
        this.y = bVar;
    }

    public void a(c cVar) {
        this.z = cVar;
    }

    public void a(d dVar) {
        this.A = dVar;
    }

    public String a(String str, int i, int i2, int i3, String str2) {
        LogEx.d("CTCIPTVPlayer", "InvokeService: strComp is " + str + "; iCmdType is " + i2 + "; iSession is " + i3 + "; strReq is " + str2);
        if (this.q == null) {
            LogEx.e("CTCIPTVPlayer", "mCompComm is null");
            return "";
        }
        byte[] bArr = new byte[Util.BYTE_OF_KB];
        byte[] g2 = g(i2);
        LogEx.d("CTCIPTVPlayer", "aCmdData: " + ((int) g2[0]) + ((int) g2[1]) + ((int) g2[2]) + ((int) g2[3]));
        byte[] g3 = g(i3);
        byte[] bytes = str2 == null ? null : str2.getBytes();
        byte[] bArr2 = new byte[LVBuffer.MAX_STRING_LENGTH];
        int i4 = 0;
        for (byte b2 : g2) {
            bArr2[i4] = b2;
            i4++;
        }
        LogEx.d("CTCIPTVPlayer", "iDataLength : " + i4);
        for (byte b3 : g3) {
            bArr2[i4] = b3;
            i4++;
        }
        LogEx.d("CTCIPTVPlayer", "iDataLength : " + i4);
        if (bytes != null) {
            for (byte b4 : bytes) {
                bArr2[i4] = b4;
                i4++;
            }
        }
        LogEx.d("CTCIPTVPlayer", "iDataLength : " + i4);
        LogEx.d("CTCIPTVPlayer", "aCmdData: " + ((int) bArr2[0]) + ((int) bArr2[1]) + ((int) bArr2[2]) + ((int) bArr2[3]));
        int MCSP_InvokeService = this.q.MCSP_InvokeService(str, i, bArr2, i4, bArr, new int[]{Util.BYTE_OF_KB});
        StringBuilder sb = new StringBuilder();
        sb.append("result : ");
        sb.append(MCSP_InvokeService);
        LogEx.d("CTCIPTVPlayer", sb.toString());
        String str3 = new String(bArr);
        LogEx.d("CTCIPTVPlayer", "Rsp: " + str3);
        String trim = str3.trim();
        LogEx.d("CTCIPTVPlayer", "Rsp: " + trim);
        return trim;
    }
}
