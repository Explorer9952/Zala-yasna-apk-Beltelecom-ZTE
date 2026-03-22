package com.zte.iptvclient.android.common.function.service;

import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.logging.nano.Vr;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.video.androidsdk.common.AndroidUniqueCode;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.download.Linstener.DownloadListReturnListener;
import com.video.androidsdk.download.SDKDownloadMgr;
import com.video.androidsdk.download.bean.DownloadTask;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.player.IBasePlayer;
import com.video.androidsdk.player.MediaPlayer;
import com.video.androidsdk.player.common.DrmType;
import com.video.androidsdk.player.common.PlayerConstants;
import com.video.androidsdk.player.common.ZoomModeType;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.k.i;
import com.zte.iptvclient.android.common.k.s;
import com.zte.iptvclient.android.common.netstate.NetWorkUtil;
import com.zte.iptvclient.android.common.netstate.NetworkStateReceiver;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PlayBackService extends Service implements View.OnTouchListener {
    public static com.zte.iptvclient.android.common.player.c A0;
    public static IBasePlayer z0;
    private Bundle A;
    private DownloadTask D;
    private boolean E;
    private h F;
    private com.zte.iptvclient.android.common.netstate.a G;
    private String K;
    private long N;
    private boolean T;
    private String W;
    private int Y;

    /* renamed from: a, reason: collision with root package name */
    private RelativeLayout f4600a;

    /* renamed from: b, reason: collision with root package name */
    private RelativeLayout f4601b;

    /* renamed from: c, reason: collision with root package name */
    private WindowManager.LayoutParams f4602c;

    /* renamed from: d, reason: collision with root package name */
    private LayoutInflater f4603d;
    private WindowManager e;
    private int f;
    private int g;
    private String g0;
    private IBasePlayer h;
    private int h0;
    private RelativeLayout i;
    private int i0;
    private ImageView j;
    private int j0;
    private TextView k;
    private String k0;
    private TextView l;
    private LinearLayout m;
    private LinearLayout n;
    private TextView o;
    private String p;
    private int p0;
    private long q;
    private boolean r;
    private long s;
    private int s0;
    private long t;
    private int u;
    private int v;
    private int v0;
    private float w;
    private String w0;
    private float x;
    private int x0;
    private int y;
    private int z;
    private String B = "";
    private int C = 0;
    protected boolean J = false;
    private boolean L = false;
    private boolean M = false;
    private boolean O = true;
    private long[] P = new long[2];
    private long Q = 0;
    private long R = 0;
    private boolean S = false;
    private long U = -1;
    private int V = 0;
    private long X = 0;
    private ArrayList<String> Z = new ArrayList<>();
    private ArrayList<Integer> a0 = new ArrayList<>();
    private ArrayList<Integer> b0 = new ArrayList<>();
    private ArrayList<Integer> c0 = new ArrayList<>();
    private ArrayList<Integer> d0 = new ArrayList<>();
    private ArrayList<Integer> e0 = new ArrayList<>();
    private ArrayList<Integer> f0 = new ArrayList<>();
    private int l0 = 0;
    private int m0 = 0;
    private int n0 = 2;
    private int o0 = 4;
    private boolean q0 = false;
    private ArrayList<String> r0 = new ArrayList<>();
    private ArrayList<Integer> t0 = new ArrayList<>();
    private ArrayList<Integer> u0 = new ArrayList<>();
    private IBasePlayer.OnEventListener y0 = new f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseApp.e().a(true);
            PlayBackService.this.b(false);
            PlayBackService.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b(PlayBackService playBackService) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.l.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PlayBackService.z0 != null && PlayBackService.this.S && PlayBackService.this.l0 == PlayBackService.this.m0) {
                if (PlayBackService.z0.isPlaying()) {
                    PlayBackService.z0.pause();
                } else {
                    PlayBackService.z0.start();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PlayBackService.this.l0 == PlayBackService.this.o0) {
                PlayBackService.this.i();
            }
            if (PlayBackService.this.l0 == PlayBackService.this.n0) {
                PlayBackService.this.s();
                PlayBackService.this.stopSelf();
            }
        }
    }

    /* loaded from: classes.dex */
    class f implements IBasePlayer.OnEventListener {
        f() {
        }

        @Override // com.video.androidsdk.player.IBasePlayer.OnEventListener
        public void onBufferingUpdate(int i) {
        }

        @Override // com.video.androidsdk.player.IBasePlayer.OnEventListener
        public void onError(String str, String str2) {
            LogEx.w("FloatingService", "onError, " + str2 + " is error, errorcode is " + str);
        }

        @Override // com.video.androidsdk.player.IBasePlayer.OnEventListener
        public void onStateChanged(int i) {
            LogEx.d("FloatingService", "status is " + i);
            if (i == 2) {
                LogEx.d("FloatingService", "STATE_OPENED");
                if (!PlayBackService.this.r) {
                    if (!PlayBackService.this.B.equals("2") && PlayBackService.this.l0 == PlayBackService.this.m0) {
                        PlayBackService.this.h.seek(PlayBackService.this.X);
                        LogEx.d("FloatingService", "seek = " + PlayBackService.this.X);
                    }
                } else {
                    PlayBackService.this.h.seek(PlayBackService.this.s - PlayBackService.this.t, s.b().getTime());
                }
                PlayBackService.this.L = false;
                PlayBackService.this.h.start();
                return;
            }
            if (i == 5) {
                LogEx.d("FloatingService", "STATE_PLAYBACK_COMPLETED");
                if (PlayBackService.this.l0 == PlayBackService.this.o0) {
                    PlayBackService.this.r();
                    return;
                } else if (PlayBackService.this.l0 == PlayBackService.this.n0) {
                    PlayBackService.this.q();
                    return;
                } else {
                    if (PlayBackService.this.l0 == PlayBackService.this.m0) {
                        PlayBackService.this.f();
                        return;
                    }
                    return;
                }
            }
            if (i == 6) {
                LogEx.d("FloatingService", "STATE_STOPED");
                return;
            }
            if (i != 7) {
                switch (i) {
                    case 9:
                        LogEx.d("FloatingService", "STATE_BUFFERING_END");
                        PlayBackService.this.k();
                        PlayBackService.this.T = true;
                        return;
                    case 10:
                        LogEx.d("FloatingService", "STATE_SEEKING");
                        return;
                    case 11:
                        PlayBackService.this.w();
                        LogEx.d("FloatingService", "STATE_SEEK_COMPLETED");
                        return;
                    case 12:
                        LogEx.d("FloatingService", "STATE_RENDER_START");
                        PlayBackService.this.i.setVisibility(0);
                        return;
                    case 13:
                        LogEx.d("FloatingService", "media player event: EnterTSProtectWindow");
                        return;
                    default:
                        return;
                }
            }
            LogEx.d("FloatingService", "STATE_BUFFERING_START");
            PlayBackService.this.w();
            PlayBackService.this.T = false;
        }

        @Override // com.video.androidsdk.player.IBasePlayer.OnEventListener
        public void onTime(long j) {
            PlayBackService.this.h();
            PlayBackService playBackService = PlayBackService.this;
            playBackService.U = playBackService.h.getCurrentPosition();
            LogEx.d("FloatingService", " mCurrentPosition = " + PlayBackService.this.U);
            PlayBackService.this.g();
            PlayBackService.this.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements DownloadListReturnListener {

        /* renamed from: a, reason: collision with root package name */
        private String f4609a;

        public g(String str) {
            this.f4609a = str;
        }

        @Override // com.video.androidsdk.download.Linstener.DownloadListReturnListener
        public void returnDownloadTaskList(String str, int i, String str2, ArrayList<DownloadTask> arrayList) {
            LogEx.d("FloatingService", "status = " + str + ", errorCode = " + i + ", errorMsg = " + str2 + ", arraylist = " + arrayList);
            PlayBackService playBackService = PlayBackService.this;
            playBackService.D = playBackService.a(this.f4609a, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class h extends BroadcastReceiver {
        private h() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action) || PlayBackService.this.F == null) {
                    return;
                }
                if ("FloatWindowUpdate".equals(action)) {
                    LogEx.d("FloatingService", "STR_FLOAT_WINDOW_UPDATE__ACTION");
                    PlayBackService.this.E = false;
                    return;
                }
                if ("FloatWindowClose".equals(action)) {
                    LogEx.d("FloatingService", "STR_FLOAT_WINDOW_CLOSE__ACTION");
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.l.a());
                    return;
                }
                if ("android.intent.action.SCREEN_ON".equals(action)) {
                    LogEx.d("FloatingService", "ACTION_SCREEN_ON");
                    return;
                }
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    LogEx.d("FloatingService", "ACTION_SCREEN_OFF");
                    PlayBackService.z0.pause();
                } else if ("android.intent.action.USER_PRESENT".equals(action) && PlayBackService.this.O) {
                    LogEx.d("FloatingService", "ACTION_USER_PRESENT");
                    PlayBackService.z0.resume();
                } else if ("android.intent.action.PHONE_STATE".equals(action)) {
                    LogEx.i("FloatingService", "ACTION_PHONE_STATE_CHANGED");
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.l.a());
                }
            }
        }

        /* synthetic */ h(PlayBackService playBackService, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            p();
            EventBus.getDefault().register(this);
            this.F = new h(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("FloatWindowUpdate");
            intentFilter.addAction("FloatWindowClose");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.PHONE_STATE");
            registerReceiver(this.F, intentFilter);
        } catch (WindowManager.BadTokenException unused) {
            stopSelf();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.l.a aVar) {
        s();
        stopSelf();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        o();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            this.A = extras;
            if (extras != null) {
                a(extras);
            }
        }
        c();
        this.l0 = this.m0;
        b(this.p);
        m();
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.Q = System.currentTimeMillis();
            l();
            this.u = (int) motionEvent.getRawX();
            this.v = (int) motionEvent.getRawY();
            WindowManager.LayoutParams layoutParams = this.f4602c;
            this.y = layoutParams.x;
            this.z = layoutParams.y;
        } else if (action == 1) {
            this.R = System.currentTimeMillis();
            this.w = motionEvent.getRawX();
            this.x = motionEvent.getRawY();
            if (this.R - this.Q < 200 && Math.abs(this.w - this.u) > 250.0f) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.l.a());
            } else if (this.R - this.Q >= 300.0d) {
                this.S = false;
            } else if (Math.abs(this.w - this.u) < 10.0f && Math.abs(this.x - this.v) < 10.0f) {
                this.S = true;
            } else {
                this.S = false;
            }
        } else if (action == 2) {
            this.S = true;
            int rawX = ((int) motionEvent.getRawX()) - this.u;
            int rawY = ((int) motionEvent.getRawY()) - this.v;
            WindowManager.LayoutParams layoutParams2 = this.f4602c;
            int i = this.y + rawX;
            layoutParams2.x = i;
            layoutParams2.y = this.z + rawY;
            if (i < 0) {
                layoutParams2.x = 0;
            }
            WindowManager.LayoutParams layoutParams3 = this.f4602c;
            if (layoutParams3.y < 0) {
                layoutParams3.y = 0;
            }
            try {
                this.e.updateViewLayout(this.f4600a, this.f4602c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ArrayList<String> arrayList = this.r0;
        if (arrayList != null && arrayList.size() != 0) {
            this.g0 = this.r0.get(0);
            ArrayList<Integer> arrayList2 = this.u0;
            arrayList2.set(0, Integer.valueOf(arrayList2.get(0).intValue() - 1));
            this.x0 = 1;
            if (TextUtils.isEmpty(this.g0)) {
                return;
            }
            this.l0 = this.n0;
            e();
            y();
            b(this.g0);
            this.g0 = null;
            LogEx.d("FloatingService", "start play adE");
            return;
        }
        s();
        stopSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        ArrayList<String> arrayList;
        if ("0".equals(ConfigMgr.readPropertie("isSupportVodMiddleAds")) || (arrayList = this.Z) == null || arrayList.size() == 0 || this.l0 != this.m0) {
            return;
        }
        long duration = this.h.getDuration();
        for (int i = 0; i < this.a0.size(); i++) {
            try {
                long parseInt = (Integer.parseInt(this.W) + this.a0.get(i).intValue()) * 1000;
                LogEx.d("FloatingService", "lPlayMiddleAdsTime = " + parseInt + LocaleUtil.MALAY + " mCurrentPosition = " + this.U);
                if (duration != 0 && parseInt < duration && this.U > parseInt && this.U < parseInt + 1000) {
                    this.X = ((this.U + 1000) / 1000) * 1000;
                    this.Y = i;
                    x();
                }
            } catch (Exception e2) {
                LogEx.d("FloatingService", "lPlayMiddleAdsTime exception");
                e2.printStackTrace();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (!this.h.isPlaying() || this.C == 0) {
            return;
        }
        if (this.B.equals("2")) {
            if (this.L || this.M) {
                return;
            }
            this.q++;
            LogEx.d("FloatingService", "miLivePlayingTime === " + this.q);
            if (this.q >= this.N) {
                c(false);
                return;
            }
            return;
        }
        this.q = this.h.getCurrentPosition();
        if ((this.B.equals("1") || this.B.equals("4")) && this.q >= this.N * 1000 && !DownloadConstant.REPORT_MSGTYPE_ADD.equals(this.K)) {
            c(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.l.setVisibility(4);
        this.k.setVisibility(4);
        e();
        this.q0 = false;
        this.l0 = this.m0;
        y();
        b(this.p);
    }

    private void j() {
        Bundle bundle = new Bundle();
        String str = com.zte.iptvclient.common.uiframe.a.c("Widevine_License_URL") + "?deviceId=" + AndroidUniqueCode.getAndroidId(getApplicationContext());
        LogEx.d("FloatingService", "ExoPlayer drmLicenseURL=" + str);
        bundle.putString(PlayerConstants.DRM_SCHEME, DrmType.DRM_TYPE_WIDEVINE);
        bundle.putString(PlayerConstants.STR_ENCRYPT_CONTENT, n());
        bundle.putString(PlayerConstants.STR_ENCRYPT_KEY, SDKLoginMgr.getInstance().getPropertiesInfo("DRM_Key"));
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(PlayerConstants.DRM_LICENSE_URL, str);
        }
        this.h = new MediaPlayer(getApplicationContext(), 7, bundle).createPlayer();
    }

    private void l() {
        int i = this.l0;
        if (i == this.o0 || i == this.n0) {
            return;
        }
        long[] jArr = this.P;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.P;
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        long[] jArr3 = this.P;
        if (jArr3[jArr3.length - 1] - jArr3[0] >= 400 || this.A == null) {
            return;
        }
        c(true);
    }

    private void m() {
        Bundle bundle = this.A;
        if (bundle == null || !DownloadConstant.REPORT_MSGTYPE_ADD.equals(bundle.getString("definition"))) {
            return;
        }
        String string = this.A.getString("taskID");
        String string2 = this.A.getString("headId");
        if (TextUtils.isEmpty(string2)) {
            SDKDownloadMgr.getInstance().getDownloadList("0", 1, new g(string));
        } else {
            SDKDownloadMgr.getInstance().getDownloadList("0", 1, string2, new g(string));
        }
    }

    private String n() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Usertoken", SDKLoginMgr.getInstance().getUserInfo("UserToken"));
            jSONObject.put("VendorCode", SDKLoginMgr.getInstance().getPropertiesInfo("Vendor_Code"));
            jSONObject.put("ProjectCode", SDKLoginMgr.getInstance().getPropertiesInfo("Project_Code"));
            jSONObject.put("DeviceId", AndroidUniqueCode.getAndroidId(this));
            jSONObject.put("TimeStamp", TimeUtil.format(s.b(), "yyyyMMddHHmmss"));
            return jSONObject.toString();
        } catch (Exception e2) {
            LogEx.e("Exception", e2.getMessage());
            return "";
        }
    }

    private void o() {
        this.i = (RelativeLayout) this.f4600a.findViewById(R.id.rlayout_player);
        this.j = (ImageView) this.f4600a.findViewById(R.id.btn_dismiss);
        TextView textView = (TextView) this.f4600a.findViewById(R.id.txt_ad_hint);
        this.k = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.ad));
        TextView textView2 = (TextView) this.f4600a.findViewById(R.id.txt_ad_timer);
        this.l = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_ad));
        this.m = (LinearLayout) this.f4600a.findViewById(R.id.llayout_net_hint);
        this.n = (LinearLayout) this.f4600a.findViewById(R.id.llayout_continue_play);
        this.f4601b = (RelativeLayout) this.f4600a.findViewById(R.id.rl_float_player_window);
        TextView textView3 = (TextView) this.f4600a.findViewById(R.id.txtvew_order_hint);
        this.o = textView3;
        com.zte.iptvclient.common.uiframe.f.a(textView3);
        com.zte.iptvclient.common.uiframe.f.a(this.m);
        com.zte.iptvclient.common.uiframe.f.a(this.n);
        com.zte.iptvclient.common.uiframe.f.a(this.j);
        com.zte.iptvclient.common.uiframe.f.a(this.k);
        com.zte.iptvclient.common.uiframe.f.a(this.l);
        u();
        a(true);
    }

    private void p() {
        this.e = (WindowManager) getApplication().getSystemService("window");
        this.f4602c = a(this.f4602c);
        LayoutInflater from = LayoutInflater.from(getApplication());
        this.f4603d = from;
        RelativeLayout relativeLayout = (RelativeLayout) from.inflate(R.layout.player_suspendwindow_layout, (ViewGroup) null);
        this.f4600a = relativeLayout;
        this.e.addView(relativeLayout, this.f4602c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.s0 -= this.t0.get(this.x0 - 1).intValue();
        if (this.u0.get(this.x0 - 1).intValue() > 0) {
            this.g0 = this.r0.get(this.x0 - 1);
            LogEx.d("FloatingService", "mAdURL" + this.g0);
            ArrayList<Integer> arrayList = this.u0;
            int i = this.x0;
            arrayList.set(i + (-1), Integer.valueOf(arrayList.get(i + (-1)).intValue() + (-1)));
            if (!TextUtils.isEmpty(this.g0)) {
                this.l0 = this.n0;
                e();
                y();
                b(this.g0);
                this.g0 = null;
                LogEx.d("FloatingService", "start play adE");
                return;
            }
            LogEx.d("FloatingService", "releasePlayer is called!");
            s();
            stopSelf();
            return;
        }
        if (this.x0 < this.r0.size()) {
            this.g0 = this.r0.get(this.x0);
            LogEx.d("FloatingService", "mAdURL" + this.g0);
            ArrayList<Integer> arrayList2 = this.u0;
            int i2 = this.x0;
            arrayList2.set(i2, Integer.valueOf(arrayList2.get(i2).intValue() + (-1)));
            this.x0++;
            if (!TextUtils.isEmpty(this.g0)) {
                this.l0 = this.n0;
                e();
                y();
                b(this.g0);
                this.g0 = null;
                LogEx.d("FloatingService", "start play adE");
                return;
            }
            LogEx.d("FloatingService", "releasePlayer is called!");
            s();
            stopSelf();
            return;
        }
        LogEx.d("FloatingService", "releasePlayer is called!");
        s();
        stopSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.i0--;
        LogEx.d("FloatingService", "miPlayMiddleTime = " + this.i0);
        if (this.i0 <= 0) {
            i();
            LogEx.d("FloatingService", "continue play positive");
            return;
        }
        this.g0 = this.Z.get(this.Y);
        LogEx.d("FloatingService", "onADMPlay mAdURL = " + this.g0);
        if (!TextUtils.isEmpty(this.g0)) {
            e();
            y();
            b(this.g0);
            this.g0 = null;
            LogEx.d("FloatingService", "start play adM");
            return;
        }
        i();
        LogEx.d("FloatingService", "continue play positive");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        WindowManager windowManager;
        A0.t();
        a();
        if (this.f4600a != null) {
            this.i.setVisibility(4);
        }
        RelativeLayout relativeLayout = this.f4600a;
        if (relativeLayout != null && (windowManager = this.e) != null) {
            windowManager.removeView(relativeLayout);
        }
        IBasePlayer iBasePlayer = this.h;
        if (iBasePlayer != null) {
            iBasePlayer.stop();
            this.h.release();
        }
        h hVar = this.F;
        if (hVar != null) {
            unregisterReceiver(hVar);
            this.F = null;
        }
        com.zte.iptvclient.android.common.netstate.a aVar = this.G;
        if (aVar != null) {
            NetworkStateReceiver.b(aVar);
            this.G = null;
        }
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.s.b());
        EventBus.getDefault().unregister(this);
    }

    private void t() {
        if (this.B.equals("2")) {
            if (this.r) {
                long duration = z0.getDuration();
                this.A.putString(ParamConst.CHANNEL_INFO_RSP_TSAVAILABLE, String.valueOf((duration / 60) / 1000));
                this.A.putString("timeshifting_time", String.valueOf(duration - (new Date().getTime() - z0.getUTCPosition())));
            } else if (this.C != 0) {
                this.A.putInt("playing_time", (int) this.q);
            }
        } else {
            long currentPosition = z0.getCurrentPosition();
            this.q = currentPosition;
            this.A.putString("bookmark_breakpoint", String.valueOf(currentPosition / 1000));
        }
        this.A.putBoolean("isFromFloatWindow", true);
    }

    private void u() {
        this.i.setOnTouchListener(this);
        this.m.setOnTouchListener(this);
        this.n.setOnClickListener(new a());
        this.j.setOnClickListener(new b(this));
        this.i.setOnClickListener(new c());
        this.l.setOnClickListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.l0 == this.o0) {
            if (!this.q0) {
                long j = this.U;
                if (j / 1000 > 1) {
                    this.p0 = this.h0;
                } else {
                    this.p0 = this.h0 - (((int) j) / 1000);
                    this.q0 = true;
                }
            } else {
                if (this.U / 1000 <= 1) {
                    this.h0 = this.c0.get(this.Y).intValue() * this.i0;
                }
                this.p0 = this.h0 - (((int) this.U) / 1000);
            }
            LogEx.d("FloatingService", "mLeftTime = " + this.p0 + "miTotalContentLengthM = " + this.h0 + "miCurrentPosition = " + this.U);
        }
        if (this.l0 == this.n0) {
            this.p0 = this.s0 - (((int) this.U) / 1000);
        }
        int i = this.l0;
        if ((i == this.o0 || i == this.n0) && this.p0 >= 0) {
            LogEx.d("FloatingService", "miVideoType = " + this.l0 + "mLeftTime = " + this.p0);
            a(String.valueOf(this.p0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.j.setVisibility(0);
    }

    private void x() {
        this.g0 = this.Z.get(this.Y);
        LogEx.d("FloatingService", "mMiddleAdURL : " + this.g0);
        this.h0 = this.b0.get(this.Y).intValue();
        this.i0 = this.d0.get(this.Y).intValue();
        this.j0 = this.e0.get(this.Y).intValue();
        this.k0 = String.valueOf(this.f0.get(this.Y));
        if (!TextUtils.isEmpty(this.g0)) {
            this.l0 = this.o0;
            e();
            y();
            b(this.g0);
            this.g0 = null;
            LogEx.d("FloatingService", "start play adM");
            return;
        }
        LogEx.d("FloatingService", "mMiddleAdURL is null");
    }

    private void y() {
        if (this.L) {
            return;
        }
        this.L = true;
        IBasePlayer iBasePlayer = this.h;
        if (iBasePlayer != null) {
            iBasePlayer.stop();
        }
    }

    public void d() {
        e eVar = new e();
        this.G = eVar;
        NetworkStateReceiver.a(eVar);
    }

    protected void e() {
        this.l.setClickable(false);
        this.l.setTextColor(androidx.core.content.a.a(getApplicationContext(), R.color.close_ad_bg));
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.l.a());
            return;
        }
        String a2 = i.a(str);
        z0.open(a2);
        this.J = true;
        LogEx.d("FloatingService", "strPlayUrl = " + a2);
    }

    private void c(boolean z) {
        Intent intent;
        this.A.putBoolean("IsUesMutliWindowToPlay", false);
        this.A.putBoolean("switchToFullScreen", z);
        this.A.putBoolean("isFromFloatWindow", true);
        if (!"2".equals(this.B) && !"4".equals(this.B)) {
            if ("1".equals(this.B)) {
                intent = new Intent(getApplicationContext(), (Class<?>) HostActivity.class);
                this.A.putString("fragmenttype", "moviedetail");
            } else if ("10".equals(this.B) || "15".equals(this.B)) {
                intent = new Intent(getApplicationContext(), (Class<?>) HostActivity.class);
                this.A.putString("fragmenttype", "seriesdetail");
            } else {
                intent = null;
            }
        } else {
            intent = new Intent(getApplicationContext(), (Class<?>) MainActivity.class);
        }
        t();
        if (intent != null) {
            intent.putExtras(this.A);
            intent.addFlags(268435456);
            try {
                PendingIntent.getActivity(getApplicationContext(), 0, intent, 268435456).send();
            } catch (PendingIntent.CanceledException e2) {
                e2.printStackTrace();
            }
        }
        s();
        stopSelf();
    }

    public WindowManager.LayoutParams a(WindowManager.LayoutParams layoutParams) {
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.type = Vr.VREvent.EventType.START_VR_APPLICATION;
        layoutParams2.flags = 329640;
        layoutParams2.gravity = 51;
        Display defaultDisplay = this.e.getDefaultDisplay();
        this.f = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        this.g = height;
        int i = this.f;
        layoutParams2.width = i / 2;
        layoutParams2.height = ((i / 2) / 16) * 9;
        int i2 = (height * 90) / 1000;
        this.V = i2;
        layoutParams2.x = i / 2;
        layoutParams2.y = (height - (((i / 2) / 16) * 9)) - i2;
        layoutParams2.format = 1;
        return layoutParams2;
    }

    protected void b(boolean z) {
        if (BaseApp.e().b()) {
            z = false;
        }
        if (z) {
            this.m.setVisibility(0);
            IBasePlayer iBasePlayer = z0;
            if (iBasePlayer != null) {
                iBasePlayer.pause();
                return;
            }
            return;
        }
        this.m.setVisibility(8);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends com.zte.iptvclient.android.common.netstate.a {
        e() {
        }

        @Override // com.zte.iptvclient.android.common.netstate.a
        public void a(NetWorkUtil.netType nettype) {
            super.a(nettype);
            if (nettype.equals(NetWorkUtil.netType.wifi)) {
                PlayBackService.this.b(false);
                PlayBackService.this.b();
            } else if (nettype.equals(NetWorkUtil.netType.CMNET) || nettype.equals(NetWorkUtil.netType.CMWAP)) {
                if (!BaseApp.e().b()) {
                    if (PlayBackService.this.h != null && PlayBackService.this.h.isPlaying()) {
                        PlayBackService.this.h.pause();
                    }
                } else {
                    PlayBackService.this.b();
                }
                PlayBackService.this.b(true);
            }
        }

        @Override // com.zte.iptvclient.android.common.netstate.a
        public void a() {
            super.a();
        }
    }

    protected void b() {
        if (!this.J) {
            LogEx.i("FloatingService", "playerStart()");
        } else if (this.O) {
            z0.resume();
        }
    }

    private void a(Bundle bundle) {
        if (bundle == null) {
            LogEx.w("FloatingService", "null == bundle");
            return;
        }
        this.A.getBoolean("isFixedWindowPlaying");
        this.C = this.A.getInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID);
        this.p = this.A.getString(ParamConst.UPDATE_VERSION_RSP_URL);
        String string = this.A.getString("auth_contenttype");
        this.B = string;
        if ("2".equals(string)) {
            this.r = this.A.getBoolean("isTimeShifting");
            this.s = this.A.getLong("timeshifting_time");
            this.t = this.A.getLong("timeshifting_duration");
        }
        if (!"2".equals(this.B) && !"4".equals(this.B)) {
            if ("1".equals(this.B)) {
                LogEx.d("FloatingService", "strPreDuration is  ===========  " + com.zte.iptvclient.common.uiframe.a.c("VOD_Preview_Duration"));
                try {
                    this.N = Integer.parseInt(r8);
                    LogEx.d("FloatingService", "mPreviewTimeOrSitComNO is  ===========  " + this.N);
                } catch (Exception unused) {
                    LogEx.e("FloatingService", "strPreDuration can not be parsed to int");
                    this.N = 0L;
                }
            }
        } else {
            LogEx.d("FloatingService", "strPreDuration is  ===========  " + com.zte.iptvclient.common.uiframe.a.c("TV_Preview_Duration"));
            try {
                this.N = Integer.parseInt(r8);
                LogEx.d("FloatingService", "mPreviewTimeOrSitComNO is  ===========  " + this.N);
            } catch (Exception unused2) {
                LogEx.e("FloatingService", "strPreDuration can not be parsed to int");
                this.N = 0L;
            }
        }
        this.q = this.A.getLong("playing_time");
        this.X = this.A.getLong("playing_time");
        this.K = this.A.getString("current_definition");
        this.W = this.A.getString("middleAdsStartPlayTime");
        this.Z = this.A.getStringArrayList("middleAdsList");
        this.a0 = this.A.getIntegerArrayList("middleAdsOffsetTimeList");
        this.b0 = this.A.getIntegerArrayList("middleAdsTotalTimeList");
        this.c0 = this.A.getIntegerArrayList("middleAdsSingleTimeList");
        this.d0 = this.A.getIntegerArrayList("middleAdsPlayNumList");
        this.e0 = this.A.getIntegerArrayList("middleAdsCloseTimeList");
        this.f0 = this.A.getIntegerArrayList("middleAdsShowTimeList");
        this.r0 = this.A.getStringArrayList("afterAdsList");
        this.s0 = this.A.getInt("afterAdsTotalTime");
        this.t0 = this.A.getIntegerArrayList("afterAdsSingleTimeList");
        this.u0 = this.A.getIntegerArrayList("afterAdsPlayNumList");
        this.v0 = this.A.getInt("afterAdsCloseTime");
        this.w0 = this.A.getString("afterAdsShowTime");
        if (DownloadConstant.REPORT_MSGTYPE_ADD.equals(this.K)) {
            return;
        }
        d();
    }

    protected void c() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Android_Player_Type");
        LogEx.i("FloatingService", "strPlayerType is " + c2);
        if ("1".equals(c2)) {
            LogEx.i("FloatingService", "Start VisualonPlayer");
            this.h = new MediaPlayer(getApplicationContext(), 1).createPlayer();
        } else if ("2".equals(c2)) {
            LogEx.i("FloatingService", "Start ZTEPlayer");
            this.h = new MediaPlayer(getApplicationContext(), 2).createPlayer();
        } else if (DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT.equals(c2)) {
            LogEx.i("FloatingService", "Start ExoPlayer");
            j();
        } else {
            LogEx.i("FloatingService", "Start ZTEPlayer");
            this.h = new MediaPlayer(getApplicationContext(), 2).createPlayer();
        }
        this.h.setOnEventListener(this.y0);
        this.h.init(this.i);
        this.h.setZoomMode(ZoomModeType.ZOOM_FITWINDOW, null);
        z0 = this.h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadTask a(String str, ArrayList<DownloadTask> arrayList) {
        if (arrayList != null && !TextUtils.isEmpty(str)) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).videoInfo.get("taskID").startsWith(str)) {
                    return arrayList.get(i);
                }
            }
        }
        return null;
    }

    protected int a() {
        DownloadTask downloadTask;
        long j = this.U;
        if (j == -1) {
            return 1;
        }
        int i = this.l0;
        long j2 = 0;
        if (i != this.m0) {
            if (i == this.o0) {
                j = this.X;
            } else {
                int i2 = this.n0;
                j = 0;
            }
        }
        long duration = this.h.getDuration();
        long j3 = this.U;
        if (duration != j3 && duration - 999 >= j3) {
            j2 = j;
        }
        if (DownloadConstant.REPORT_MSGTYPE_ADD.equals(this.K) && (downloadTask = this.D) != null) {
            downloadTask.videoInfo.put("bookMarkPoint", String.valueOf(((int) j2) / 1000));
            SDKDownloadMgr.getInstance().updateTask(1, this.D);
        }
        if (com.zte.iptvclient.common.uiframe.b.c().a() == 5) {
            LogEx.d("FloatingService", "ActivityMgr.getActivityMgr().getApplicationStatus()= ActivityMgr.INT_STATUS_LOGIN_GUEST_LOGINED!");
            return 2;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("columncode", this.A.getString("columncode"));
        hashMap.put("contentcode", this.A.getString("contentcode"));
        hashMap.put("bookmarktype", this.A.getString("bookmarktype"));
        hashMap.put("breakpoint", String.valueOf(((int) j2) / 1000));
        hashMap.put("binduserid", new com.zte.iptvclient.android.common.j.h(getApplicationContext()).j());
        hashMap.put("copyright", this.A.getString("isprotection"));
        if (!this.B.equals("1") && !this.B.equals("10") && !this.B.equals("14")) {
            return 0;
        }
        LogEx.d("FloatingService", "mPlayingTime:" + j2 + ",mContentDuration:" + duration);
        if ("1".equals(ConfigMgr.readPropertie("UseOldBookmark"))) {
            com.zte.iptvclient.android.common.f.b.c.c(hashMap);
            return 0;
        }
        com.zte.iptvclient.android.common.f.b.c.a((HashMap<String, String>) hashMap);
        return 0;
    }

    public void a(boolean z) {
        if (Build.VERSION.SDK_INT < 8) {
            LogEx.d("FloatingService", "Android 2.1 and below can not stop music");
            return;
        }
        AudioManager audioManager = (AudioManager) getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (z) {
            audioManager.requestAudioFocus(null, 3, 2);
        } else {
            audioManager.abandonAudioFocus(null);
        }
        LogEx.d("FloatingService", "pauseMusic bMute=" + z);
    }

    private void a(String str) {
        LogEx.d("FloatingService", "onAdTimeChanged strTime = " + str);
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        if (this.l0 == this.o0) {
            if (TextUtils.equals(this.k0, "0")) {
                this.l.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_ad_with_no_second));
            } else {
                this.l.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_ad), str));
            }
            int i = this.j0;
            if (i == 0) {
                this.l.setClickable(true);
                this.l.setTextColor(-1);
                LogEx.d("FloatingService", "miCloseMiddleTime = " + this.j0);
            } else if (i > 0) {
                a(this.h0, str);
                LogEx.d("FloatingService", "skipADM miCloseMiddleTime = " + this.j0);
            }
        }
        if (this.l0 == this.n0) {
            if (!TextUtils.equals(this.w0, "0") && !TextUtils.equals(this.w0, "1")) {
                this.l.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_ad), str));
            } else {
                this.l.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_ad_with_no_second));
            }
            int i2 = this.v0;
            if (i2 == 0) {
                this.l.setClickable(true);
                this.l.setTextColor(-1);
            } else if (i2 > 0) {
                a(this.s0, str);
            }
        }
        if ("0".equals(str) || this.l0 == this.m0) {
            this.l.setVisibility(4);
            this.k.setVisibility(4);
        }
    }

    private void a(int i, String str) {
        int i2;
        try {
            if (this.l0 == this.o0) {
                i2 = this.j0;
            } else {
                i2 = this.l0 == this.n0 ? this.v0 : -1;
            }
            if (i - Integer.valueOf(str).intValue() > i2) {
                LogEx.d("FloatingService", "iCloseTime = " + i2);
                this.l.setClickable(true);
                this.l.setTextColor(-1);
            }
        } catch (Exception e2) {
            LogEx.d("FloatingService", "updateCloseAdBtnState exception: " + e2.getMessage());
            e();
        }
    }
}
