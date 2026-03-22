package com.zte.iptvclient.android.common.player.k;

import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.r;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.common.AndroidUniqueCode;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.impl.IIPTVLogin;
import com.video.androidsdk.mes.SDKPushMsgMgr;
import com.video.androidsdk.player.Exoplayer;
import com.video.androidsdk.player.IBasePlayer;
import com.video.androidsdk.player.MediaPlayer;
import com.video.androidsdk.player.common.CommonFunc;
import com.video.androidsdk.player.common.DecoderType;
import com.video.androidsdk.player.common.DrmType;
import com.video.androidsdk.player.common.PlayerConstants;
import com.video.androidsdk.player.common.SubtitleHorizontal;
import com.video.androidsdk.player.common.SubtitleVertical;
import com.video.androidsdk.player.common.UrlUtils;
import com.video.androidsdk.player.common.ZoomModeType;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.function.service.PushMessageService;
import com.zte.iptvclient.android.common.k.s;
import com.zte.ucs.tvcall.Commons;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

/* compiled from: BasePlayerFragment.java */
/* loaded from: classes.dex */
public class a extends Fragment {
    protected float A0;
    protected float B0;
    protected boolean D;
    protected ImageView D0;
    protected RelativeLayout F0;
    protected IBasePlayer L;
    protected long L0;
    protected IBasePlayer M;
    protected Date M0;
    protected i N;
    protected Date N0;
    public String O;
    protected Date O0;
    protected long P;
    protected Date P0;
    protected long Q;
    protected Date Q0;
    protected Date R;
    protected Date R0;
    protected Date S0;
    protected Date T0;
    Fragment U0;

    /* renamed from: b, reason: collision with root package name */
    protected Activity f4977b;
    protected LinearLayout c0;
    protected RelativeLayout d0;
    protected String e;
    protected RelativeLayout f;
    protected RelativeLayout g;
    protected RelativeLayout h;
    protected RelativeLayout i;
    protected RelativeLayout j;
    protected h j0;
    protected RelativeLayout k;
    private SDKPushMsgMgr k0;
    protected String n0;
    protected g o0;
    private Timer p0;
    private String q0;
    protected int r0;
    protected RelativeLayout t0;
    protected boolean u0;
    protected SeekBar v0;
    protected SeekBar w0;

    /* renamed from: a, reason: collision with root package name */
    private boolean f4976a = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4978c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4979d = false;
    protected boolean l = false;
    protected boolean m = false;
    protected boolean n = false;
    protected boolean o = true;
    protected boolean p = false;
    protected boolean q = false;
    protected boolean r = false;
    protected boolean s = false;
    protected boolean t = false;
    protected String u = "";
    protected String v = "";
    protected boolean w = false;
    protected boolean x = false;
    protected boolean y = false;
    protected boolean z = false;
    public boolean A = false;
    protected boolean B = true;
    protected boolean C = false;
    private boolean E = false;
    protected boolean F = false;
    protected boolean G = false;
    protected boolean J = true;
    protected boolean K = false;
    private SharedPreferences S = null;
    protected String T = "";
    protected int U = 0;
    protected int V = 0;
    protected int W = 1;
    protected int X = 2;
    protected int Y = 4;
    protected int Z = 3;
    protected boolean a0 = false;
    public boolean b0 = true;
    public boolean e0 = false;
    public boolean f0 = false;
    public boolean g0 = false;
    protected boolean h0 = false;
    public boolean i0 = true;
    protected boolean l0 = false;
    protected boolean m0 = false;
    protected boolean s0 = true;
    protected boolean x0 = false;
    protected int y0 = 0;
    private Timer z0 = null;
    protected long C0 = 7200000;
    protected String E0 = "";
    protected boolean G0 = false;
    protected Handler H0 = new HandlerC0147a();
    private IBasePlayer.OnEventListener I0 = new b();
    private IBasePlayer.OnEventListener J0 = new c();
    protected long K0 = -1;

    /* compiled from: BasePlayerFragment.java */
    /* renamed from: com.zte.iptvclient.android.common.player.k.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class HandlerC0147a extends Handler {
        HandlerC0147a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            LogEx.d("BasePlayerFragment", "msg.what is " + message.what);
            int i = message.what;
            if (i == 5) {
                LogEx.d("BasePlayerFragment", "playNext");
                a.this.O();
            } else if (i == 10) {
                LogEx.d("BasePlayerFragment", "releasePlayer is called!");
                a.this.R();
            } else if (i == 11) {
                LogEx.d("BasePlayerFragment", "ivi isnowplayer");
                EventBus.getDefault().post(new com.zte.iptvclient.android.mobile.ivi.b.a());
            }
        }
    }

    /* compiled from: BasePlayerFragment.java */
    /* loaded from: classes.dex */
    class b implements IBasePlayer.OnEventListener {
        b() {
        }

        @Override // com.video.androidsdk.player.IBasePlayer.OnEventListener
        public void onBufferingUpdate(int i) {
        }

        @Override // com.video.androidsdk.player.IBasePlayer.OnEventListener
        public void onError(String str, String str2) {
            LogEx.d("BasePlayerFragment", "Test the starting speed : mPlayer eocouter onError");
            LogEx.w("BasePlayerFragment", "onError, " + str2 + " is error, errorcode is " + str);
            if (TextUtils.equals("-2", str) || TextUtils.equals(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, str)) {
                a.this.f4978c = true;
                a.this.y();
                a.this.G();
                a aVar = a.this;
                aVar.s(aVar.q0);
                return;
            }
            if (TextUtils.equals("0110001", str) || TextUtils.equals("0110002", str) || TextUtils.equals("0110003", str)) {
                return;
            }
            a aVar2 = a.this;
            aVar2.z = false;
            aVar2.k0();
        }

        @Override // com.video.androidsdk.player.IBasePlayer.OnEventListener
        public void onStateChanged(int i) {
            IBasePlayer iBasePlayer;
            LogEx.d("BasePlayerFragment", "onStateChanged status is " + i);
            switch (i) {
                case 2:
                    double duration = a.this.M.getDuration();
                    Double.isNaN(duration);
                    int ceil = (int) Math.ceil(duration / 1000.0d);
                    a aVar = a.this;
                    aVar.r0 = ceil;
                    g gVar = aVar.o0;
                    if (gVar == null || gVar.a()) {
                        LogEx.d("BasePlayerFragment", "STATE_OPENED");
                        LogEx.d("BasePlayerFragment", "Test the starting speed mPlayer.open end  STATE_OPENED");
                        a.this.M.start();
                        return;
                    }
                    return;
                case 3:
                    LogEx.d("BasePlayerFragment", "STATE_PLAYING");
                    a.this.b0();
                    return;
                case 4:
                case 8:
                case 10:
                default:
                    return;
                case 5:
                case 11:
                    LogEx.d("BasePlayerFragment", "STATE_PLAYBACK_COMPLETED");
                    a.this.B();
                    a.this.M.seek(0L);
                    return;
                case 6:
                    LogEx.d("BasePlayerFragment", "STATE_STOPED");
                    return;
                case 7:
                    LogEx.d("BasePlayerFragment", "STATE_BUFFERING_START");
                    a aVar2 = a.this;
                    aVar2.G = true;
                    aVar2.h0();
                    return;
                case 9:
                    LogEx.d("BasePlayerFragment", "STATE_BUFFERING_END");
                    a aVar3 = a.this;
                    if (aVar3.g0) {
                        aVar3.d0.setVisibility(8);
                    } else {
                        aVar3.c0.setVisibility(8);
                    }
                    a aVar4 = a.this;
                    aVar4.G = false;
                    aVar4.A();
                    a aVar5 = a.this;
                    if (!aVar5.w || (iBasePlayer = aVar5.M) == null) {
                        return;
                    }
                    iBasePlayer.suspend4bg();
                    return;
                case 12:
                    LogEx.d("BasePlayerFragment", "STATE_RENDER_START");
                    LogEx.d("BasePlayerFragment", "Test the starting speed : mPlayer RENDER for show view");
                    synchronized (this) {
                        if (a.this.j0 != null) {
                            a.this.j0.a();
                            a.this.j0 = null;
                            a.this.f0 = true;
                        }
                    }
                    a aVar6 = a.this;
                    aVar6.K = true;
                    aVar6.K();
                    return;
                case 13:
                    LogEx.d("BasePlayerFragment", "media player event: EnterTSProtectWindow startChannelPlay");
                    a.this.j0();
                    return;
            }
        }

        @Override // com.video.androidsdk.player.IBasePlayer.OnEventListener
        public void onTime(long j) {
            a.this.e(j);
        }
    }

    /* compiled from: BasePlayerFragment.java */
    /* loaded from: classes.dex */
    class c implements IBasePlayer.OnEventListener {

        /* compiled from: BasePlayerFragment.java */
        /* renamed from: com.zte.iptvclient.android.common.player.k.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0148a implements Runnable {
            RunnableC0148a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                IBasePlayer iBasePlayer = a.this.L;
                if (iBasePlayer != null) {
                    iBasePlayer.pause();
                }
            }
        }

        c() {
        }

        @Override // com.video.androidsdk.player.IBasePlayer.OnEventListener
        public void onBufferingUpdate(int i) {
        }

        @Override // com.video.androidsdk.player.IBasePlayer.OnEventListener
        public void onError(String str, String str2) {
            LogEx.d("BasePlayerFragment", "Test the starting speed : mPlayer eocouter onError");
            LogEx.w("BasePlayerFragment", "onError, " + str2 + " is error, errorcode is " + str);
            if (TextUtils.equals("-2", str) || TextUtils.equals(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, str)) {
                a.this.f4978c = true;
                a.this.x();
                a.this.H();
                a aVar = a.this;
                if (aVar.s) {
                    a.this.v = UrlUtils.getParamsMap(aVar.O).get("videoid");
                    LogEx.d("BasePlayerFragment", "delCacheURLByChannelCode = " + a.this.v);
                    UrlUtils.delCacheURLByChannelCode(a.this.v);
                }
                a.this.L();
                return;
            }
            if (TextUtils.equals("0110001", str) || TextUtils.equals("0110002", str) || TextUtils.equals("0110003", str)) {
                return;
            }
            if (!a.this.x0 && (TextUtils.equals("0131001", str) || TextUtils.equals("0122001", str))) {
                a aVar2 = a.this;
                aVar2.x0 = true;
                if (aVar2.z0 == null) {
                    a.this.z0 = new Timer();
                }
                a.this.z0.schedule(new k(), 0L, 1000L);
            }
            a aVar3 = a.this;
            aVar3.z = false;
            aVar3.k0();
            a.this.m0();
            a.this.g0();
        }

        @Override // com.video.androidsdk.player.IBasePlayer.OnEventListener
        public void onStateChanged(int i) {
            IBasePlayer iBasePlayer;
            IBasePlayer iBasePlayer2;
            LogEx.d("BasePlayerFragment", "onStateChanged status is " + i);
            switch (i) {
                case 2:
                    g gVar = a.this.o0;
                    if (gVar == null || gVar.a()) {
                        LogEx.d("BasePlayerFragment", "STATE_OPENED");
                        LogEx.d("BasePlayerFragment", "Test the starting speed mPlayer.open end  STATE_OPENED");
                        a aVar = a.this;
                        aVar.z = false;
                        if (aVar.l) {
                            aVar.I();
                        } else {
                            aVar.Y();
                        }
                        a.this.L.start();
                        a aVar2 = a.this;
                        if (aVar2.h0 && (iBasePlayer = aVar2.L) != null) {
                            iBasePlayer.pause();
                        }
                        if (a.this.D()) {
                            new Handler().postDelayed(new RunnableC0148a(), 500L);
                        }
                        a aVar3 = a.this;
                        aVar3.a((View) aVar3.h, false);
                        a aVar4 = a.this;
                        aVar4.f0 = true;
                        h hVar = aVar4.j0;
                        if (hVar != null) {
                            hVar.a();
                            a.this.f0 = true;
                        }
                        a aVar5 = a.this;
                        if (aVar5.U == aVar5.V) {
                            aVar5.a0();
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    LogEx.d("BasePlayerFragment", "STATE_PLAYING");
                    a aVar6 = a.this;
                    if (aVar6.x0 && aVar6.t) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("TS ing mPlayer.guesture seek at ");
                        a aVar7 = a.this;
                        sb.append(aVar7.A0 - aVar7.B0);
                        sb.append(" continue play ");
                        LogEx.d("BasePlayerFragment", sb.toString());
                        a.this.d(r6.A0 - r6.B0);
                    }
                    a aVar8 = a.this;
                    aVar8.x0 = false;
                    aVar8.y0 = 0;
                    if (aVar8.z0 != null) {
                        a.this.z0.cancel();
                        a.this.z0.purge();
                        a.this.z0 = null;
                    }
                    a aVar9 = a.this;
                    if (aVar9.u0) {
                        aVar9.k0();
                    }
                    if (TextUtils.equals(a.this.n0, "ivi") || TextUtils.equals(a.this.n0, "Megogo")) {
                        a.this.V();
                        String format = TimeUtil.format(s.b(), "yyyy.MM.dd HH:mm:ss");
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put(IIPTVLogin.STR_PLAY_THIRDCDNFLAG, "1");
                        hashMap.put("starttime", format);
                        SDKLoginMgr.getInstance().updatePlayInfo(hashMap);
                        return;
                    }
                    return;
                case 4:
                case 8:
                default:
                    return;
                case 5:
                    LogEx.d("BasePlayerFragment", "STATE_PLAYBACK_COMPLETED");
                    return;
                case 6:
                    LogEx.d("BasePlayerFragment", "STATE_STOPED");
                    return;
                case 7:
                    LogEx.d("BasePlayerFragment", "STATE_BUFFERING_START");
                    a aVar10 = a.this;
                    aVar10.G = true;
                    aVar10.h0();
                    return;
                case 9:
                    LogEx.d("BasePlayerFragment", "STATE_BUFFERING_END");
                    a aVar11 = a.this;
                    if (aVar11.g0) {
                        aVar11.d0.setVisibility(8);
                    } else {
                        aVar11.c0.setVisibility(8);
                    }
                    a aVar12 = a.this;
                    aVar12.G = false;
                    aVar12.A();
                    a aVar13 = a.this;
                    if (!aVar13.w || (iBasePlayer2 = aVar13.L) == null) {
                        return;
                    }
                    iBasePlayer2.suspend4bg();
                    return;
                case 10:
                    LogEx.d("BasePlayerFragment", "STATE_SEEKING");
                    a.this.C = true;
                    return;
                case 11:
                    LogEx.d("BasePlayerFragment", "STATE_SEEK_COMPLETED");
                    a.this.f0();
                    a.this.b0();
                    a aVar14 = a.this;
                    aVar14.C = false;
                    aVar14.P = 0L;
                    if (aVar14.l) {
                        aVar14.m = true;
                        aVar14.l = false;
                        return;
                    }
                    return;
                case 12:
                    LogEx.d("BasePlayerFragment", "STATE_RENDER_START");
                    LogEx.d("BasePlayerFragment", "Test the starting speed : mPlayer RENDER for show view");
                    synchronized (this) {
                        if (a.this.j0 != null) {
                            a.this.j0.a();
                            a.this.j0 = null;
                            a.this.f0 = true;
                        }
                    }
                    a aVar15 = a.this;
                    aVar15.K = true;
                    aVar15.K();
                    return;
                case 13:
                    LogEx.d("BasePlayerFragment", "media player event: EnterTSProtectWindow startChannelPlay");
                    a.this.j0();
                    return;
            }
        }

        @Override // com.video.androidsdk.player.IBasePlayer.OnEventListener
        public void onTime(long j) {
            a.this.f(j);
            a.this.g(j);
        }
    }

    /* compiled from: BasePlayerFragment.java */
    /* loaded from: classes.dex */
    class d extends TimerTask {
        d() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a.this.Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BasePlayerFragment.java */
    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        e(a aVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BasePlayerFragment.java */
    /* loaded from: classes.dex */
    public class f extends AnimatorListenerAdapter {
        f(a aVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: BasePlayerFragment.java */
    /* loaded from: classes.dex */
    public interface g {
        boolean a();
    }

    /* compiled from: BasePlayerFragment.java */
    /* loaded from: classes.dex */
    public interface h {
        void a();
    }

    /* compiled from: BasePlayerFragment.java */
    /* loaded from: classes.dex */
    public interface i {
        void a(int i);

        void a(boolean z);

        int e();

        int i();
    }

    /* compiled from: BasePlayerFragment.java */
    /* loaded from: classes.dex */
    public class j extends TimerTask {
        public j() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 11;
            a.this.H0.sendMessage(message);
        }
    }

    /* compiled from: BasePlayerFragment.java */
    /* loaded from: classes.dex */
    class k extends TimerTask {
        k() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a.this.y0++;
            LogEx.d("BasePlayerFragment", "isNoNetWorkTime =" + a.this.y0);
        }
    }

    private void p0() {
        Bundle bundle = new Bundle();
        String str = com.zte.iptvclient.common.uiframe.a.c("Widevine_License_URL") + "?deviceId=" + AndroidUniqueCode.getAndroidId(getContext());
        LogEx.d("BasePlayerFragment", "ExoPlayer drmLicenseURL=" + str);
        bundle.putString(PlayerConstants.DRM_SCHEME, DrmType.DRM_TYPE_WIDEVINE);
        bundle.putString(PlayerConstants.STR_ENCRYPT_CONTENT, q0());
        bundle.putString(PlayerConstants.STR_ENCRYPT_KEY, SDKLoginMgr.getInstance().getPropertiesInfo("DRM_Key"));
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(PlayerConstants.DRM_LICENSE_URL, str);
        }
        this.L = new MediaPlayer(this.f4977b.getApplicationContext(), 7, bundle).createPlayer();
    }

    private String q0() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Usertoken", SDKLoginMgr.getInstance().getUserInfo("UserToken"));
            jSONObject.put("VendorCode", SDKLoginMgr.getInstance().getPropertiesInfo("Vendor_Code"));
            jSONObject.put("ProjectCode", SDKLoginMgr.getInstance().getPropertiesInfo("Project_Code"));
            jSONObject.put("DeviceId", AndroidUniqueCode.getAndroidId(this.f4977b));
            jSONObject.put("TimeStamp", TimeUtil.format(s.b(), "yyyyMMddHHmmss"));
            return jSONObject.toString();
        } catch (Exception e2) {
            LogEx.e("BasePlayerFragment", e2.getMessage());
            return "";
        }
    }

    private void r0() {
        if (TextUtils.equals(this.T, "2")) {
            String readPropertie = ConfigMgr.readPropertie("TVInitialBufferingTime", "2");
            this.L.setInitialBufferingTime(Integer.valueOf(TextUtils.isEmpty(readPropertie) ? "2" : readPropertie).intValue() * 100);
            return;
        }
        if (TextUtils.equals(this.T, "1") || TextUtils.equals(this.T, "10") || TextUtils.equals(this.T, "15") || TextUtils.equals(this.T, "4")) {
            String readPropertie2 = ConfigMgr.readPropertie("VODInitialBufferingTime", "2");
            int intValue = Integer.valueOf(TextUtils.isEmpty(readPropertie2) ? "2" : readPropertie2).intValue();
            IBasePlayer iBasePlayer = this.L;
            if (iBasePlayer != null) {
                iBasePlayer.setInitialBufferingTime(intValue * 100);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A() {
    }

    protected void B() {
    }

    public Fragment C() {
        return this.U0;
    }

    public boolean D() {
        return this.f4976a;
    }

    public void E() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G() {
        IBasePlayer iBasePlayer = this.M;
        if (iBasePlayer != null) {
            iBasePlayer.init(this.i, 2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H() {
        IBasePlayer iBasePlayer = this.L;
        if (iBasePlayer != null) {
            iBasePlayer.init(this.h, 1, false);
        }
    }

    protected void I() {
    }

    protected void J() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L() {
        String str;
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Offset_Period_ToPlay");
        if (TextUtils.isEmpty(propertiesInfo)) {
            propertiesInfo = "3";
        }
        LogEx.d("BasePlayerFragment", "offsetPeriod = " + propertiesInfo);
        ((Exoplayer) this.L).setInitOffsetPeriod(Integer.parseInt(propertiesInfo));
        if (TextUtils.isEmpty(this.O)) {
            LogEx.w("BasePlayerFragment", "###url is null!");
            g0();
            return;
        }
        this.y = false;
        this.K = false;
        if (!this.F && !isHidden()) {
            if (!TextUtils.equals(this.n0, "ivi") && !TextUtils.equals(this.n0, "Megogo")) {
                str = this.O + "&clientDeviceid=" + AndroidUniqueCode.getAndroidId(this.f4977b) + "&clientDevicetype=" + (!BaseApp.a(this.f4977b) ? "2" : "8");
                if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
                    str = str.replace("profilecode=", "profilecode=1");
                }
                LogEx.d("BasePlayerFragment", "origin play url = " + str);
                if (!str.contains("JITPMediaType")) {
                    if (this.f4978c) {
                        str = str + "&NeedJITP=1&JITPMediaType=DASH&JITPDRMType=NO";
                    } else {
                        str = com.zte.iptvclient.android.common.k.i.a(str, TimeUtil.format(s.c(), "yyyyMMddHHmmss"));
                    }
                }
                if (this.q) {
                    this.L.setRenderTypeOpenGL();
                    LogEx.d("BasePlayerFragment", "finish setRenderTypeOpenGL");
                    this.L.enableSphericalVideo(true);
                    LogEx.d("BasePlayerFragment", "finish enableSphericalVideo");
                    this.L.setDecoderType(DecoderType.Decoder_HW, DecoderType.Decoder_SW);
                }
            } else {
                str = this.O;
            }
            r0();
            Z();
            o0();
            LogEx.d("BasePlayerFragment", "last play url = " + str);
            LogEx.d("BasePlayerFragment", "Test the starting speed: mPlayer.open(mStrPath) = " + str);
            this.f4979d = true;
            this.L.open(str);
            if ("8".equals(this.e) && this.g0 && this.a0 && this.b0) {
                this.L.mute();
            }
            this.y = true;
            this.J = false;
            if ("ivi".equals(this.n0)) {
                Timer timer = this.p0;
                if (timer != null) {
                    timer.cancel();
                    this.p0.purge();
                    this.p0 = null;
                }
                EventBus.getDefault().post(new com.zte.iptvclient.android.mobile.ivi.b.b());
                this.p0 = new Timer(true);
                this.p0.schedule(new j(), 0L, 60000L);
                return;
            }
            return;
        }
        LogEx.w("BasePlayerFragment", "###openPlayerToPlay return !!! for " + this.F + "or  currentViewisHide= " + isHidden());
    }

    protected void M() {
        r0();
        Z();
        o0();
        LogEx.d("BasePlayerFragment", "last play url = " + this.O);
        LogEx.d("BasePlayerFragment", "Test the starting speed: mPlayer.open(mStrPath) = " + this.O);
        this.f4979d = true;
        this.L.open(this.O);
        if ("8".equals(this.e) && this.g0 && this.a0 && this.b0) {
            this.L.mute();
        }
        this.y = true;
        this.J = false;
        if ("ivi".equals(this.n0)) {
            Timer timer = this.p0;
            if (timer != null) {
                timer.cancel();
                this.p0.purge();
                this.p0 = null;
            }
            EventBus.getDefault().post(new com.zte.iptvclient.android.mobile.ivi.b.b());
            this.p0 = new Timer(true);
            this.p0.schedule(new j(), 0L, 60000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N() {
        LogEx.d("BasePlayerFragment", "--------openVideo start----------");
        m0();
        Q();
        LogEx.d("BasePlayerFragment", "--------openVideo end----------");
    }

    protected void O() {
    }

    protected void P() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Q() {
        if (this.L == null) {
            LogEx.w("BasePlayerFragment", " mPlayer is null !");
            R();
        } else {
            L();
            d0();
        }
    }

    public void R() {
        RelativeLayout relativeLayout;
        LogEx.i("BasePlayerFragment", "releasePlayer()");
        h hVar = this.j0;
        if (hVar != null) {
            hVar.a();
        }
        if (this.g0 && (relativeLayout = this.d0) != null) {
            relativeLayout.setVisibility(8);
        } else {
            LinearLayout linearLayout = this.c0;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        }
        n0();
        this.E = true;
        LogEx.d("BasePlayerFragment", "releasePlayer end");
        if (TextUtils.equals(this.n0, "ivi") || TextUtils.equals(this.n0, "Megogo")) {
            W();
            String format = TimeUtil.format(s.b(), "yyyy.MM.dd HH:mm:ss");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("endtime", format);
            SDKLoginMgr.getInstance().updatePlayInfo(hashMap);
        }
    }

    protected void S() {
    }

    public void T() {
        LogEx.i("PlayerHelper", "reportAllAd");
        if (this.O0 != null) {
            Date b2 = s.b();
            this.R0 = b2;
            com.zte.iptvclient.android.common.player.f.b(this.O0, this.R0, b2.getTime() - this.O0.getTime());
            LogEx.i("PlayerHelper", "Forward ad Play report!");
            this.O0 = null;
        }
        if (this.P0 != null) {
            Date b3 = s.b();
            this.S0 = b3;
            com.zte.iptvclient.android.common.player.f.c(this.P0, this.S0, b3.getTime() - this.P0.getTime());
            LogEx.i("PlayerHelper", "Middle ad Play report!");
            this.P0 = null;
        }
        if (this.Q0 != null) {
            Date b4 = s.b();
            this.T0 = b4;
            com.zte.iptvclient.android.common.player.f.a(this.Q0, this.T0, b4.getTime() - this.Q0.getTime());
            LogEx.i("PlayerHelper", "End ad Play report!");
            this.Q0 = null;
        }
        U();
    }

    public synchronized void U() {
        if (this.M0 != null) {
            Date b2 = s.b();
            this.N0 = b2;
            com.zte.iptvclient.android.common.player.f.d(this.M0, this.N0, b2.getTime() - this.M0.getTime());
            this.M0 = null;
            LogEx.i("PlayerHelper", "Pause ad Play report!");
        }
    }

    protected void V() {
    }

    protected void W() {
    }

    protected void X() {
    }

    protected void Y() {
    }

    protected void Z() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List<com.zte.iptvclient.android.common.customview.view.imageview.a> list) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a0() {
    }

    protected void b0() {
    }

    public void c(boolean z) {
        this.g0 = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(int i2) {
    }

    protected void d(long j2) {
    }

    public void d(boolean z) {
        this.f4976a = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d0() {
    }

    protected void e(long j2) {
    }

    protected void e0() {
    }

    protected void f(long j2) {
    }

    public void f0() {
    }

    protected void g(long j2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h0() {
    }

    public void i0() {
    }

    protected void j0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k0() {
        this.G0 = false;
        U();
        this.u0 = false;
        this.t0.setVisibility(8);
        this.v0.setEnabled(true);
        this.w0.setEnabled(true);
        this.s0 = true;
        IBasePlayer iBasePlayer = this.M;
        if (iBasePlayer != null) {
            iBasePlayer.stop();
            this.M.release();
            this.M.setOnEventListener(null);
            a((View) this.i, true);
            LogEx.d("BasePlayerFragment", "mPuasePlayer is stop");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l0() {
        this.G0 = false;
        this.u0 = false;
        this.t0.setVisibility(8);
        this.v0.setEnabled(true);
        this.w0.setEnabled(true);
        e0();
        this.s0 = true;
        IBasePlayer iBasePlayer = this.M;
        if (iBasePlayer != null) {
            iBasePlayer.stop();
            this.M.release();
            this.M.setOnEventListener(null);
            a((View) this.i, true);
            LogEx.d("BasePlayerFragment", "mPuasePlayer is stop");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m0() {
        Timer timer = this.p0;
        if (timer != null) {
            timer.cancel();
            this.p0.purge();
            this.p0 = null;
        }
        if (this.z) {
            return;
        }
        a((View) this.h, true);
        this.z = true;
        IBasePlayer iBasePlayer = this.L;
        if (iBasePlayer != null) {
            iBasePlayer.stop();
        }
        IBasePlayer iBasePlayer2 = this.M;
        if (iBasePlayer2 != null) {
            iBasePlayer2.stop();
        }
        z();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n0() {
        Window window;
        z();
        v();
        if (this.x0) {
            this.x0 = false;
            this.y0 = 0;
            Timer timer = this.z0;
            if (timer != null) {
                timer.cancel();
                this.z0.purge();
                this.z0 = null;
            }
        }
        LogEx.i("BasePlayerFragment", "uninitPlayer()");
        A();
        if (this.B && this.A) {
            i0();
        }
        if (this.E) {
            LogEx.d("BasePlayerFragment", "player has been released");
            return;
        }
        LogEx.d("BasePlayerFragment", "BookMarkOperation");
        u();
        m0();
        IBasePlayer iBasePlayer = this.L;
        if (iBasePlayer != null) {
            if (this.q) {
                iBasePlayer.stopSphericalView();
            }
            this.L.release();
            this.y = false;
            this.L.setOnEventListener(null);
        }
        S();
        LogEx.d("BasePlayerFragment", "saveVolum");
        X();
        Activity activity = this.f4977b;
        if (activity != null && (window = activity.getWindow()) != null) {
            window.clearFlags(Commons.MSG_MCSP_INIT_SUCCESS);
        }
        LogEx.d("BasePlayerFragment", "uninitPlayer end");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o0() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f4977b = activity;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        LogEx.i("BasePlayerFragment", "Player onCreate");
        super.onCreate(bundle);
        Activity activity = this.f4977b;
        if (activity == null) {
            r b2 = getFragmentManager().b();
            b2.d(this);
            b2.a();
            getFragmentManager().F();
            return;
        }
        Window window = activity.getWindow();
        if (window != null) {
            window.setFlags(Commons.MSG_MCSP_INIT_SUCCESS, Commons.MSG_MCSP_INIT_SUCCESS);
        }
        if (this.L == null) {
            x();
        }
        if (this.M == null) {
            x();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        LogEx.i("BasePlayerFragment", "Player onDestroy");
        super.onDestroy();
        if (!this.e0 && this.L != null) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.i());
            n0();
            CommonFunc.setPlayer(null);
        }
        IBasePlayer iBasePlayer = this.M;
        if (iBasePlayer != null) {
            iBasePlayer.stop();
        }
        LogEx.i("BasePlayerFragment", "Player onDestroy Completed!");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        Window window;
        super.onHiddenChanged(z);
        Activity activity = this.f4977b;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        if (!z) {
            window.setFlags(Commons.MSG_MCSP_INIT_SUCCESS, Commons.MSG_MCSP_INIT_SUCCESS);
        } else {
            window.clearFlags(Commons.MSG_MCSP_INIT_SUCCESS);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        LogEx.i("BasePlayerFragment", "Player onPause");
        super.onPause();
        T();
        this.m0 = false;
        this.w = true;
        if (com.zte.iptvclient.android.common.k.g.c()) {
            n0();
            return;
        }
        if (this.y) {
            if (this.s) {
                J();
            }
            IBasePlayer iBasePlayer = this.L;
            if (iBasePlayer != null) {
                iBasePlayer.suspend4bg();
            }
            this.w = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        LogEx.i("BasePlayerFragment", "Player onResume");
        super.onResume();
        if (this.F0.getVisibility() == 0) {
            return;
        }
        if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
            SDKPushMsgMgr sDKPushMsgMgr = SDKPushMsgMgr.getInstance();
            this.k0 = sDKPushMsgMgr;
            sDKPushMsgMgr.uninitMesClient();
            Intent intent = new Intent();
            intent.setPackage(this.f4977b.getApplicationContext().getPackageName());
            intent.setAction(PushMessageService.class.getName());
            this.f4977b.getApplicationContext().stopService(intent);
            this.f4977b.getApplicationContext().startService(intent);
        }
        this.w = false;
        if (!this.m0 && this.f4979d) {
            if (com.zte.iptvclient.android.common.k.g.c()) {
                w();
                M();
                return;
            }
            LogEx.d("BasePlayerFragment", "mIsPlayerRun = " + this.y);
            if (this.y) {
                new Timer().schedule(new d(), 2000L);
                this.x = true;
                if (!this.i0) {
                    LogEx.d("BasePlayerFragment", "return");
                    return;
                }
                LogEx.d("BasePlayerFragment", "mNetHintShowing = " + this.F);
                if (this.F) {
                    return;
                }
                this.x = false;
                if (this.s) {
                    P();
                } else if (this.x0) {
                    P();
                } else {
                    this.L.resume4bg();
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        LogEx.i("BasePlayerFragment", "Player onStart");
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        LogEx.i("BasePlayerFragment", "Player onStop");
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(String str) {
        this.q0 = str;
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            this.q0 = this.q0.replace("profilecode=", "profilecode=1");
        }
        LogEx.d("BasePlayerFragment", "Test the starting speed: mPlayer.openPuaseAD(mStrPath) = " + this.q0);
        this.q0 += "&clientDeviceid=" + AndroidUniqueCode.getAndroidId(this.f4977b) + "&clientDevicetype=" + (!BaseApp.a(this.f4977b) ? "2" : "8");
        LogEx.d("BasePlayerFragment", "origin play url = " + this.q0);
        if (this.f4978c) {
            this.q0 += "&NeedJITP=1&JITPMediaType=DASH&JITPDRMType=NO";
        } else {
            this.q0 = com.zte.iptvclient.android.common.k.i.a(this.q0, TimeUtil.format(s.c(), "yyyyMMddHHmmss"));
        }
        this.M.open(this.q0);
    }

    @Override // androidx.fragment.app.Fragment
    public void setTargetFragment(Fragment fragment, int i2) {
        this.U0 = fragment;
    }

    public void t(String str) {
        this.O = str;
        LogEx.d("BasePlayerFragment", "Player mStrPath is " + this.O);
    }

    protected int u() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w() {
        Window window = this.f4977b.getWindow();
        if (window != null) {
            window.setFlags(Commons.MSG_MCSP_INIT_SUCCESS, Commons.MSG_MCSP_INIT_SUCCESS);
        }
        p0();
        this.L.setOnEventListener(this.J0);
        H();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Android_Player_Type");
        this.e = c2;
        if (TextUtils.isEmpty(c2)) {
            LogEx.e("BasePlayerFragment", "strPlayerType is null! unable getPortalProperty for PLAYER_TYPE");
            return;
        }
        LogEx.i("BasePlayerFragment", "strPlayerType is " + this.e);
        if ("1".equals(this.e)) {
            LogEx.i("BasePlayerFragment", "Start VisualonPlayer");
            this.L = new MediaPlayer(this.f4977b.getApplicationContext(), 1).createPlayer();
        } else if ("2".equals(this.e)) {
            this.L = new MediaPlayer(this.f4977b.getApplicationContext(), 2).createPlayer();
        } else if (DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT.equals(this.e)) {
            LogEx.i("BasePlayerFragment", "Start ExoPlayer");
            p0();
        } else if ("8".equals(this.e)) {
            LogEx.d("BasePlayerFragment", "Start ijkPlayer");
            this.L = new MediaPlayer(this.f4977b.getApplicationContext(), 8).createPlayer();
        } else {
            LogEx.i("BasePlayerFragment", "Start ZTEPlayer");
            this.L = new MediaPlayer(this.f4977b.getApplicationContext(), 2).createPlayer();
        }
        this.L.setOnEventListener(this.J0);
        CommonFunc.setPlayer(this.L);
        ((Exoplayer) this.L).setLoadableRetryCount(15);
        this.L.setZoomMode(ZoomModeType.ZOOM_FITWINDOW, null);
        this.L.setSubtitleGravity(SubtitleHorizontal.CENTER, SubtitleVertical.BOTTOM);
        SharedPreferences sharedPreferences = this.f4977b.getSharedPreferences("ZTEPlayerLogINI", 0);
        this.S = sharedPreferences;
        boolean z = sharedPreferences.getBoolean(" ZTEPlayerIsWriteLog", false);
        LogEx.d("BasePlayerFragment", "In ZTEPlayer isWriteLogBool is " + z);
        if (z) {
            this.L.startWriteLog();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y() {
        Bundle bundle = new Bundle();
        String str = com.zte.iptvclient.common.uiframe.a.c("Widevine_License_URL") + "?deviceId=" + AndroidUniqueCode.getAndroidId(getContext());
        LogEx.d("BasePlayerFragment", "ExoPlayer drmLicenseURL=" + str);
        bundle.putString(PlayerConstants.DRM_SCHEME, DrmType.DRM_TYPE_WIDEVINE);
        bundle.putString(PlayerConstants.STR_ENCRYPT_CONTENT, q0());
        bundle.putString(PlayerConstants.STR_ENCRYPT_KEY, SDKLoginMgr.getInstance().getPropertiesInfo("DRM_Key"));
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(PlayerConstants.DRM_LICENSE_URL, str);
        }
        IBasePlayer createPlayer = new MediaPlayer(this.f4977b.getApplicationContext(), 7, bundle).createPlayer();
        this.M = createPlayer;
        createPlayer.setOnEventListener(this.I0);
    }

    protected void z() {
    }

    public void b(boolean z) {
        LogEx.d("BasePlayerFragment", "是否静音mIsMute=" + this.a0);
        IBasePlayer iBasePlayer = this.L;
        if (iBasePlayer == null || this.a0 == z) {
            return;
        }
        this.a0 = z;
        if (z) {
            iBasePlayer.mute();
        } else {
            iBasePlayer.unmute();
        }
        LogEx.d("BasePlayerFragment", "Player sound state mIsMute=" + this.a0);
    }

    public void a(View view, boolean z) {
        if (view == null) {
            return;
        }
        this.f4977b.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        if (!z) {
            com.zte.iptvclient.android.common.k.g.a(view, com.zte.iptvclient.android.common.k.g.a(this.f4977b, r1.widthPixels), 0.0f, 0, 10, 1.0f, new e(this)).start();
        } else {
            com.zte.iptvclient.android.common.k.g.a(view, view.getX(), com.zte.iptvclient.android.common.k.g.a(this.f4977b, IIPTVLogin.REQUESTID_80), 0, 10, 1.0f, new f(this)).start();
        }
    }

    public void a(i iVar) {
        this.N = iVar;
    }

    public void a(h hVar) {
        this.j0 = hVar;
    }
}
