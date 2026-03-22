package com.zte.iptvclient.android.mobile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.video.androidsdk.cast.bean.DLNAEvent;
import com.video.androidsdk.cast.bean.Device;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.http.HttpConstant;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.download.Linstener.SDKDownloadLoginSTBListener;
import com.video.androidsdk.download.SDKDownloadMgr;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.channel.SDKChannelMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.prevue.SDKPrevueMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.fragmentlib.anim.DefaultHorizontalAnimator;
import com.zte.fragmentlib.anim.FragmentAnimator;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.a.a.e.a;
import com.zte.iptvclient.android.common.customview.a.a.e.d;
import com.zte.iptvclient.android.common.e.x.o;
import com.zte.iptvclient.android.common.f.b.n;
import com.zte.iptvclient.android.common.function.service.PushMessageService;
import com.zte.iptvclient.android.common.function.service.UpdateUsertokenService;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.u;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.common.player.k.a;
import com.zte.iptvclient.android.common.reminder.TvReminderManager;
import com.zte.iptvclient.android.common.reminder.VodReminderManager;
import com.zte.iptvclient.android.common.update.UpdateService;
import com.zte.iptvclient.android.mobile.c0.d.a;
import com.zte.iptvclient.android.mobile.h.a.a;
import com.zte.iptvclient.android.mobile.home.tab.helper.TabHostManager;
import com.zte.iptvclient.android.zala.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MainActivity extends SupportActivity implements a.i {
    private List<Device> B;
    private com.zte.iptvclient.android.common.customview.a.a.e.a C;
    private RelativeLayout G;
    private com.zte.iptvclient.android.common.player.k.c J;
    private int U;
    private int V;
    private int W;
    private int X;
    private float Y;
    private float Z;
    private int a0;
    private int b0;
    private com.zte.iptvclient.android.mobile.a f0;
    private String h0;
    private Timer k0;
    private com.zte.iptvclient.android.mobile.n.c.b v;
    private com.zte.iptvclient.android.common.j.h w;
    private long x;
    private Activity z;
    private com.zte.iptvclient.android.mobile.l.a.b y = null;
    private a.p A = null;
    private boolean D = false;
    private ArrayList<com.zte.iptvclient.android.common.javabean.models.d> E = new ArrayList<>();
    private ArrayList<com.zte.iptvclient.android.common.javabean.models.c> F = new ArrayList<>();
    private int K = 0;
    private int L = 0;
    private int M = 0;
    private int N = 0;
    private long[] O = new long[2];
    private long P = 0;
    private long Q = 0;
    public boolean R = false;
    private int S = 0;
    private int T = 0;
    private boolean c0 = false;
    private boolean d0 = false;
    private int e0 = 0;
    private Timer g0 = null;
    private int i0 = 0;
    private boolean j0 = false;
    private Handler l0 = new b();
    a.d m0 = new c();
    boolean n0 = false;
    private ArrayList<k> o0 = new ArrayList<>();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.c0 = false;
        }
    }

    /* loaded from: classes.dex */
    class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (MainActivity.this.j0) {
                LogEx.d("MainActivity", "MyMessageTask   isShowMessage = true");
                MainActivity.this.j0 = false;
                if (!TextUtils.equals(MainActivity.this.w.V(), ConfigMgr.readPropertie("GuestName")) && !com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
                    String E = MainActivity.E();
                    if (!TextUtils.isEmpty(E)) {
                        LogEx.d("MainActivity", "getMessageByLang = " + E);
                        new com.zte.iptvclient.android.common.customview.a.a.e.h(MainActivity.this.z, R.style.dialog_order).show();
                    }
                }
                if (MainActivity.this.k0 != null) {
                    MainActivity.this.k0.cancel();
                    MainActivity.this.k0.purge();
                    MainActivity.this.k0 = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements a.d {
        c() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.a.d
        public void a() {
            MainActivity.this.D();
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.a.d
        public void a(String str) {
            MainActivity.this.D();
            if (StringUtil.isEmptyString(str) || !str.startsWith(HttpConstant.PROTOCOL_HTTP)) {
                return;
            }
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            MainActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements a.p {
        d() {
        }

        @Override // com.zte.iptvclient.android.mobile.h.a.a.p
        public void a(DLNAEvent dLNAEvent) {
            if (dLNAEvent == null) {
                return;
            }
            LogEx.d("MainActivity", " DLNAManager dlna event [" + dLNAEvent.getEvent() + "]");
            String event = dLNAEvent.getEvent();
            if (DLNAEvent.EVENT_DEVICE_ONLINE.equals(event) || DLNAEvent.EVENT_DEVICE_OFFLINE.equals(event)) {
                if (MainActivity.this.B != null) {
                    MainActivity.this.B.clear();
                }
                ArrayList<Device> a2 = com.zte.iptvclient.android.mobile.h.a.a.g().a();
                LogEx.d("MainActivity", " DLNAManager dmrlist size = " + a2.size());
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.l.b(event));
                for (Device device : a2) {
                    if (device != null && MainActivity.this.B != null) {
                        MainActivity.this.B.add(device);
                    }
                }
                if (DLNAEvent.EVENT_DEVICE_ONLINE.equals(event)) {
                    MainActivity.this.L();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements SDKDownloadLoginSTBListener {
        e() {
        }

        @Override // com.video.androidsdk.download.Linstener.SDKDownloadLoginSTBListener
        public void onLoginSTBReturn(int i) {
            com.zte.iptvclient.android.mobile.download.helper.c.c.a(i == 0);
            LogEx.d("MainActivity", "result = " + i);
        }
    }

    /* loaded from: classes.dex */
    class g implements t.e {
        g() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void a() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void b() {
            if (com.zte.iptvclient.android.mobile.w.a.b.class.isInstance(MainActivity.this.k())) {
                return;
            }
            u.h(MainActivity.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements SDKChannelMgr.OnChannelDetailWithUrlReturnListener {
        h() {
        }

        @Override // com.video.androidsdk.service.channel.SDKChannelMgr.OnChannelDetailWithUrlReturnListener
        public void onChannelDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d("MainActivity", "returncode= " + str + "  errmsg " + str2 + "  msg " + str3);
            MainActivity.this.d();
            if ("0".equals(str)) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        MainActivity.this.F.add(com.zte.iptvclient.android.common.javabean.models.c.a(jSONArray.getJSONObject(i)));
                    }
                } catch (Exception e) {
                    LogEx.e("MainActivity", e.getMessage());
                }
                MainActivity.this.F();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f5267a;

        i(boolean z) {
            this.f5267a = z;
        }

        @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener
        public void onPrevueDetailWithUrlReturn(String str, String str2, String str3) {
            MainActivity.this.d();
            LogEx.d("MainActivity", "sdkQueryTvodById:  onDataReturn,arg0= " + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        MainActivity.this.E.add(com.zte.iptvclient.android.common.javabean.models.d.a(jSONArray.getJSONObject(i)));
                    }
                    MainActivity.this.d(this.f5267a);
                    return;
                } catch (Exception e) {
                    LogEx.e("MainActivity", e.getMessage());
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.query_tvod_info_fail);
                    return;
                }
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.query_tvod_info_fail);
        }
    }

    /* loaded from: classes.dex */
    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.c0 = true;
        }
    }

    /* loaded from: classes.dex */
    public interface k {
        void a(MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    class l extends TimerTask {
        l() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            LogEx.d("MainActivity", "MyMessageTask");
            MainActivity.this.l0.sendMessage(new Message());
        }
    }

    /* loaded from: classes.dex */
    class m extends TimerTask {
        m() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            MainActivity.o(MainActivity.this);
            LogEx.d("MainActivity", "peijian =" + MainActivity.this.i0);
            LogEx.d("MainActivity", "peijian timeBackgroundLogout=" + MainActivity.this.h0);
            if (MainActivity.this.i0 == Integer.parseInt(MainActivity.this.h0)) {
                if (MainActivity.this.J != null) {
                    MainActivity.this.J.C1();
                }
                if (MainActivity.this.g0 != null) {
                    MainActivity.this.g0.cancel();
                    MainActivity.this.g0.purge();
                    MainActivity.this.g0 = null;
                }
                MainActivity.this.O();
                MainActivity.this.finish();
                System.exit(0);
            }
        }
    }

    private void A() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.player_container);
        this.G = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout);
    }

    private void B() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.getBooleanExtra("isRestart", false)) {
                u.c(this);
                return;
            } else {
                b(intent);
                a(intent);
                return;
            }
        }
        LogEx.e("MainActivity", "getIntent is null !");
    }

    private void C() {
        if (this.J.e0) {
            long[] jArr = this.O;
            System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
            long[] jArr2 = this.O;
            jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
            long[] jArr3 = this.O;
            if (jArr3[jArr3.length - 1] - jArr3[0] < 400) {
                LogEx.d("MainActivity", "text Play resumeFullWindow");
                this.J.B2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.flags &= -1025;
            window.setAttributes(attributes);
        }
        v.a((Activity) this);
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.s.a());
        LogEx.d("MainActivity", "mShowUpdateDialog " + this.d0);
        if (!this.d0) {
            LogEx.d("MainActivity", "BaseApp.getInstance().getUpgradeType()= " + BaseApp.e().d());
            if (BaseApp.e().d() == 1) {
                this.d0 = true;
                n.d().b(this);
            } else if (BaseApp.e().d() == 2) {
                this.d0 = true;
                n.d().d(this);
            }
        } else if (!w()) {
            q();
        } else {
            LogEx.d("MainActivity", "收到登录时间");
        }
        B();
        if (this.w.m()) {
            String c2 = com.zte.iptvclient.common.uiframe.a.c("Privacy_Policy_Address");
            if (!TextUtils.isEmpty(c2)) {
                com.zte.iptvclient.android.common.update.a aVar = new com.zte.iptvclient.android.common.update.a(this.z, R.style.dialog_order, c2);
                aVar.setCanceledOnTouchOutside(false);
                aVar.show();
            } else {
                com.zte.iptvclient.android.common.update.a aVar2 = new com.zte.iptvclient.android.common.update.a(this.z, R.style.dialog_order, "https://www.beltelecom.by/private/tv/smart/privacy_policy");
                aVar2.setCanceledOnTouchOutside(false);
                aVar2.show();
            }
        }
    }

    public static String E() {
        int K = K();
        if (1 == K) {
            return com.zte.iptvclient.common.uiframe.a.c("Portal_Msg_be");
        }
        if (2 == K) {
            return com.zte.iptvclient.common.uiframe.a.c("Portal_Msg_ru");
        }
        if (3 == K) {
            return com.zte.iptvclient.common.uiframe.a.c("Portal_Msg");
        }
        return com.zte.iptvclient.common.uiframe.a.c("Portal_Msg_ru");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        N();
    }

    private void G() {
        if (2 == com.zte.iptvclient.common.uiframe.b.c().a() && this.A == null) {
            H();
        }
    }

    private void H() {
        LogEx.d("MainActivity", "initDLNAListener");
        this.B = com.zte.iptvclient.android.mobile.h.a.a.g().a();
        this.A = new d();
        com.zte.iptvclient.android.mobile.h.a.a.g().a(this.A, 1);
    }

    private void I() {
        if (BaseApp.a(this)) {
            com.zte.iptvclient.common.uiframe.f.a(Util.BYTE_OF_KB, 768);
        } else {
            com.zte.iptvclient.common.uiframe.f.a(480, 800);
        }
        com.zte.iptvclient.common.uiframe.f.a(this);
    }

    private void J() {
        LogEx.d("MainActivity", "测试语言 killProcess and onDestroy!");
        com.zte.iptvclient.android.common.player.k.c cVar = this.J;
        if (cVar != null) {
            cVar.C1();
        }
        ((BaseApp) getApplication()).onTerminate();
        Process.killProcess(Process.myPid());
        onDestroy();
    }

    private static int K() {
        String lowerCase = BaseApp.e().getResources().getConfiguration().locale.getLanguage().toLowerCase();
        LogEx.d("MainActivity", "locale:" + lowerCase);
        if ("be".equals(lowerCase)) {
            return 1;
        }
        return (!LocaleUtil.RUSSIAN.equals(lowerCase) && "en".equals(lowerCase)) ? 3 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        List<Device> list = this.B;
        if (list == null || list.size() == 0) {
            return;
        }
        LogEx.d("MainActivity", " DLNAManager pairDMR mDMRListsize=" + this.B.size());
        for (Device device : this.B) {
            if (device != null) {
                LogEx.d("MainActivity", "DLNAManager Local store STBUND =" + this.w.L() + " online drm UDN=" + device.getUDN());
                if (TextUtils.equals(device.getUDN(), this.w.L())) {
                    Device b2 = com.zte.iptvclient.android.mobile.h.a.a.g().b();
                    if (b2 == null) {
                        a(device);
                        return;
                    } else {
                        if (TextUtils.equals(b2.getUDN(), device.getUDN())) {
                            return;
                        }
                        a(device);
                        return;
                    }
                }
                LogEx.d("MainActivity", "DLNAManager Local store STBDeviceID =" + this.w.K() + " online drm DeviceID=" + device.getUDN());
                if (TextUtils.equals(this.w.K(), device.getDeviceID())) {
                    Device b3 = com.zte.iptvclient.android.mobile.h.a.a.g().b();
                    if (b3 == null) {
                        a(device);
                        return;
                    } else {
                        if (TextUtils.equals(b3.getUDN(), device.getUDN())) {
                            return;
                        }
                        a(device);
                        return;
                    }
                }
            }
        }
    }

    private void M() {
        com.zte.iptvclient.android.mobile.n.c.b k2 = com.zte.iptvclient.android.mobile.n.c.b.k();
        this.v = k2;
        k2.i();
        this.v.a(getApplicationContext());
    }

    private void N() {
        ArrayList<com.zte.iptvclient.android.common.javabean.models.c> arrayList = this.F;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        com.zte.iptvclient.android.common.javabean.models.c cVar = this.F.get(0);
        com.zte.iptvclient.android.mobile.download.helper.a.n().a((Boolean) true);
        com.zte.iptvclient.android.common.player.f fVar = new com.zte.iptvclient.android.common.player.f();
        Bundle bundle = new Bundle();
        Iterator<com.zte.iptvclient.android.common.javabean.models.c> it2 = this.F.iterator();
        while (it2.hasNext()) {
            com.zte.iptvclient.android.common.javabean.models.c next = it2.next();
            String j2 = next.j();
            if (TextUtils.equals(next.g(), "1")) {
                if (TextUtils.isEmpty(j2)) {
                    j2 = "";
                }
                bundle.putString("url_sd", j2);
            } else if (TextUtils.equals(next.g(), "2")) {
                if (TextUtils.isEmpty(j2)) {
                    j2 = "";
                }
                bundle.putString("url_sd_h", j2);
            } else if (TextUtils.equals(next.g(), "4")) {
                if (TextUtils.isEmpty(j2)) {
                    j2 = "";
                }
                bundle.putString("url_hd", j2);
            } else if (TextUtils.equals(next.g(), "8")) {
                if (TextUtils.isEmpty(j2)) {
                    j2 = "";
                }
                bundle.putString("url_480p", j2);
            } else if (TextUtils.equals(next.g(), GlobalConst.WINPHONE_CLIENT)) {
                if (TextUtils.isEmpty(j2)) {
                    j2 = "";
                }
                bundle.putString("url_720p", j2);
            } else if (TextUtils.equals(next.g(), GlobalConst.ANDRIODSTB_CLIENT)) {
                if (TextUtils.isEmpty(j2)) {
                    j2 = "";
                }
                bundle.putString("url_1280p", j2);
            } else {
                bundle.putString("url_sd", "");
            }
        }
        bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, cVar.j());
        bundle.putString("tv_name", cVar.e());
        bundle.putString("programname", cVar.l());
        bundle.putString("isprotection", cVar.h());
        bundle.putString("supportTimeShift", cVar.q());
        bundle.putString(ParamConst.CHANNEL_INFO_RSP_TSAVAILABLE, cVar.r());
        bundle.putString("playuri4dlna", com.zte.iptvclient.android.mobile.h.a.b.b(cVar.i(), cVar.p(), cVar.d(), cVar.f()));
        bundle.putString("telecomcode", cVar.p());
        bundle.putString("poster_image", cVar.k());
        bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, TextUtils.isEmpty(cVar.c()) ? -1 : Integer.valueOf(cVar.c()).intValue());
        bundle.putString("contentcode", cVar.d());
        bundle.putString("ratingid", cVar.n());
        bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, cVar.j());
        bundle.putBoolean("Is_Dash_URL", com.zte.iptvclient.android.common.k.i.c());
        bundle.putString("auth_contenttype", "2");
        bundle.putBoolean("IsUesMutliWindowToPlay", false);
        com.zte.iptvclient.android.common.player.j.i iVar = new com.zte.iptvclient.android.common.player.j.i();
        iVar.b(cVar.d());
        iVar.a(cVar.f());
        fVar.a(iVar, bundle, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        Intent intent = new Intent();
        intent.setPackage(getApplicationContext().getPackageName());
        intent.setAction(UpdateUsertokenService.class.getName());
        getApplicationContext().stopService(intent);
        Intent intent2 = new Intent();
        intent2.setPackage(getApplicationContext().getPackageName());
        intent2.setAction(PushMessageService.class.getName());
        getApplicationContext().stopService(intent2);
        Intent intent3 = new Intent();
        intent3.setPackage(getApplicationContext().getPackageName());
        intent3.setAction(TvReminderManager.class.getName());
        getApplicationContext().stopService(intent3);
        Intent intent4 = new Intent();
        intent4.setPackage(getApplicationContext().getPackageName());
        intent4.setAction(VodReminderManager.class.getName());
        getApplicationContext().stopService(intent4);
    }

    static /* synthetic */ int o(MainActivity mainActivity) {
        int i2 = mainActivity.i0;
        mainActivity.i0 = i2 + 1;
        return i2;
    }

    @Override // com.zte.fragmentlib.SupportActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        com.zte.iptvclient.android.common.player.k.c cVar = (com.zte.iptvclient.android.common.player.k.c) getSupportFragmentManager().c("CommonPlayerFragment");
        this.J = cVar;
        if (cVar != null && cVar.e0) {
            LogEx.d("MainActivity", "text Play dispatchTouchEvent");
            int action = motionEvent.getAction();
            if (action == 0) {
                this.W = (int) motionEvent.getRawX();
                this.X = (int) motionEvent.getRawY();
                this.P = System.currentTimeMillis();
                C();
                this.U = this.K;
                this.V = this.L;
            } else if (action != 1) {
                if (action == 2 && this.J.X0) {
                    this.R = true;
                    int rawX = ((int) motionEvent.getRawX()) - this.W;
                    int rawY = ((int) motionEvent.getRawY()) - this.X;
                    int i2 = this.U;
                    this.K = i2 + rawX;
                    this.L = this.V + rawY;
                    if (i2 == 0 && rawX < (-(this.S / 5))) {
                        this.J.F1();
                        return true;
                    }
                    if (this.K < 0) {
                        this.K = 0;
                    }
                    if (this.L < 0) {
                        this.L = 0;
                    }
                    int i3 = this.K;
                    int i4 = this.S;
                    int i5 = this.M;
                    if (i3 > i4 - i5) {
                        this.K = i4 - i5;
                    }
                    int i6 = this.L;
                    int i7 = this.T;
                    int i8 = this.N;
                    if (i6 > i7 - i8) {
                        this.L = i7 - i8;
                    }
                    try {
                        a(this.K, this.L);
                    } catch (Exception e2) {
                        LogEx.d("e=", e2.toString());
                    }
                }
            } else {
                this.Q = System.currentTimeMillis();
                this.Y = motionEvent.getRawX();
                this.Z = motionEvent.getRawY();
                if (this.Q - this.P >= 200 || Math.abs(this.Y - this.W) <= 250.0f) {
                    if (this.Q - this.P >= 300.0d) {
                        this.R = false;
                    } else if (Math.abs(this.Y - this.W) < 10.0f && Math.abs(this.Z - this.X) < 10.0f) {
                        this.R = true;
                    } else {
                        this.R = false;
                    }
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        Iterator<k> it2 = this.o0.iterator();
        while (it2.hasNext()) {
            it2.next().a(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public int e() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.SupportActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2) {
            com.zte.iptvclient.android.mobile.h.b.a.b bVar = (com.zte.iptvclient.android.mobile.h.b.a.b) a(com.zte.iptvclient.android.mobile.h.b.a.b.class);
            if (bVar != null) {
                bVar.a(i3, intent);
                return;
            }
            return;
        }
        if (i2 != 4) {
            return;
        }
        com.zte.iptvclient.android.common.e.u.b bVar2 = new com.zte.iptvclient.android.common.e.u.b();
        bVar2.a(intent);
        bVar2.a(i3);
        EventBus.getDefault().post(bVar2);
    }

    @Override // com.zte.fragmentlib.SupportActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.zte.fragmentlib.SupportActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        LogEx.d("MainActivity", ".onConfigurationChanged");
        super.onConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.SupportActivity, com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        I();
        v.a((Activity) this);
        setContentView(R.layout.activity_main_new);
        A();
        this.J = new com.zte.iptvclient.android.common.player.k.c();
        r b2 = getSupportFragmentManager().b();
        b2.a(this.G.getId(), this.J, "CommonPlayerFragment");
        b2.d();
        this.z = this;
        this.w = new com.zte.iptvclient.android.common.j.h(this);
        if ("1".equals(ConfigMgr.readPropertie("isShowSplashAD"))) {
            com.zte.iptvclient.android.common.customview.a.a.e.a aVar = new com.zte.iptvclient.android.common.customview.a.a.e.a(this);
            this.C = aVar;
            aVar.a(this.m0);
        }
        EventBus.getDefault().register(this);
        TabHostManager.g().a(this);
        com.zte.iptvclient.android.mobile.a aVar2 = new com.zte.iptvclient.android.mobile.a();
        this.f0 = aVar2;
        a(R.id.base_container, aVar2);
        com.zte.iptvclient.android.mobile.download.helper.c.c.b(getApplicationContext());
        G();
        com.zte.iptvclient.android.common.k.g.b().a(getApplicationContext());
        D();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.SupportActivity, com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        LogEx.d("MainActivity", "测试语言 killProcess and onDestroy!");
        J();
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.b bVar) {
        J();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogEx.d("MainActivity", " recv intent ");
        if (intent != null) {
            if (intent.getBooleanExtra("ChildMode", false)) {
                LogEx.d("MainActivity", " recv intent ChildMode");
                com.zte.iptvclient.android.mobile.a aVar = this.f0;
                if (aVar != null) {
                    aVar.b(true);
                    return;
                }
                return;
            }
            if (this.w.p() && !TextUtils.isEmpty(intent.getStringExtra("PushMessage_MsgId"))) {
                u.c(this);
            }
            b(intent);
            a(intent);
            Bundle extras = intent.getExtras();
            if (extras == null || !extras.getBoolean("isFromFloatWindow")) {
                return;
            }
            a(extras);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        LogEx.d("MainActivity", "MainActivity onRestart ");
        SDKLoginMgr.getInstance().doHeartbeat();
        Timer timer = this.g0;
        if (timer != null) {
            timer.cancel();
            this.g0.purge();
            this.g0 = null;
        }
        this.i0 = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com.zte.iptvclient.android.common.customview.a.a.e.a aVar;
        super.onResume();
        LogEx.d("MainActivity", "MainActivity onResume ");
        if ("1".equals(ConfigMgr.readPropertie("isShowSplashAD")) && (aVar = this.C) != null && !aVar.h && !aVar.isShowing()) {
            this.C.show();
        }
        SDKLoginMgr.getInstance().doHeartbeat();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (com.zte.iptvclient.android.common.k.g.d(this)) {
            String c2 = com.zte.iptvclient.common.uiframe.a.c("Time_Background_Logout");
            this.h0 = c2;
            if (TextUtils.isEmpty(c2)) {
                this.h0 = "180";
            }
            if (this.g0 == null) {
                this.g0 = new Timer();
            }
            this.g0.schedule(new m(), 0L, 1000L);
        }
    }

    public boolean r() {
        return this.G.getVisibility() == 0;
    }

    public boolean s() {
        return this.c0;
    }

    public com.zte.iptvclient.android.common.player.k.c t() {
        return this.J;
    }

    public RelativeLayout u() {
        return this.G;
    }

    public void v() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        r b2 = supportFragmentManager.b();
        com.zte.iptvclient.android.common.player.k.c cVar = (com.zte.iptvclient.android.common.player.k.c) supportFragmentManager.c("CommonPlayerFragment");
        this.J = cVar;
        if (cVar != null) {
            b2.c(cVar);
            b2.b();
        }
        LogEx.d("MainActivity", "text Play hidePlayerFragment");
        u().setVisibility(8);
    }

    public boolean w() {
        return this.D;
    }

    public void x() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        r b2 = supportFragmentManager.b();
        com.zte.iptvclient.android.common.player.k.c cVar = (com.zte.iptvclient.android.common.player.k.c) supportFragmentManager.c("CommonPlayerFragment");
        this.J = cVar;
        if (cVar == null) {
            this.J = new com.zte.iptvclient.android.common.player.k.c();
            b2.a(this.G.getId(), this.J, "CommonPlayerFragment");
            b2.b();
            b2.c(this.J);
        }
        com.zte.iptvclient.android.common.player.k.c cVar2 = this.J;
        if (cVar2 != null) {
            cVar2.F1();
            b2.e(this.J);
            b2.b();
        }
        LogEx.d("MainActivity", "text Play showPlayerFragment");
        u().setVisibility(0);
    }

    public void y() {
        if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
            com.zte.iptvclient.android.mobile.h.b.a.b bVar = new com.zte.iptvclient.android.mobile.h.b.a.b();
            r b2 = getSupportFragmentManager().b();
            b2.b(R.id.base_container, bVar, "STBMgrFragment");
            b2.b();
            com.zte.iptvclient.android.mobile.l.a.b bVar2 = this.y;
            if (bVar2 == null) {
                return;
            }
            bVar2.a(TabHostManager.TabName.STB);
            throw null;
        }
        t.a((Context) this, false);
    }

    public void z() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.b();
        com.zte.iptvclient.android.common.player.k.c cVar = (com.zte.iptvclient.android.common.player.k.c) supportFragmentManager.c("CommonPlayerFragment");
        this.J = cVar;
        if (cVar != null) {
            cVar.x2();
            this.J.g(false);
            this.J.d3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        ArrayList<com.zte.iptvclient.android.common.javabean.models.d> arrayList = this.E;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        com.zte.iptvclient.android.common.javabean.models.d dVar = this.E.get(0);
        String a2 = dVar.a();
        LogEx.d("MainActivity", "onDataReturn: channelAuthId=" + a2);
        com.zte.iptvclient.android.common.player.f fVar = new com.zte.iptvclient.android.common.player.f();
        Bundle bundle = new Bundle();
        Iterator<com.zte.iptvclient.android.common.javabean.models.d> it2 = this.E.iterator();
        while (it2.hasNext()) {
            com.zte.iptvclient.android.common.javabean.models.d next = it2.next();
            String k2 = next.k();
            if (TextUtils.equals(next.f(), "1")) {
                if (TextUtils.isEmpty(k2)) {
                    k2 = "";
                }
                bundle.putString("url_sd", k2);
                bundle.putString("physicalcontentid_url_sd", next.j());
            } else if (TextUtils.equals(next.f(), "2")) {
                if (TextUtils.isEmpty(k2)) {
                    k2 = "";
                }
                bundle.putString("url_sd_h", k2);
                bundle.putString("physicalcontentid_url_sd_h", next.j());
            } else if (TextUtils.equals(next.f(), "4")) {
                if (TextUtils.isEmpty(k2)) {
                    k2 = "";
                }
                bundle.putString("url_hd", k2);
                bundle.putString("physicalcontentid_url_hd", next.j());
            } else if (TextUtils.equals(next.f(), "8")) {
                if (TextUtils.isEmpty(k2)) {
                    k2 = "";
                }
                bundle.putString("url_480p", k2);
                bundle.putString("physicalcontentid_url_480p", next.j());
            } else if (TextUtils.equals(next.f(), GlobalConst.WINPHONE_CLIENT)) {
                if (TextUtils.isEmpty(k2)) {
                    k2 = "";
                }
                bundle.putString("url_720p", k2);
                bundle.putString("physicalcontentid_url_720p", next.j());
            } else if (TextUtils.equals(next.f(), GlobalConst.ANDRIODSTB_CLIENT)) {
                if (TextUtils.isEmpty(k2)) {
                    k2 = "";
                }
                bundle.putString("url_1280p", k2);
                bundle.putString("physicalcontentid_url_1280p", next.j());
            } else {
                bundle.putString("url_sd", "");
            }
        }
        if (!TextUtils.isEmpty(a2)) {
            bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, Integer.valueOf(a2).intValue());
        } else {
            bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, -1);
        }
        String c2 = dVar.c();
        Channel channel = null;
        ArrayList<Channel> b2 = com.zte.iptvclient.android.common.j.i.d().b();
        int size = b2.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                Channel channel2 = b2.get(i2);
                if (channel2 != null && TextUtils.equals(channel2.getChannelcode(), c2)) {
                    channel = channel2;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        if (channel == null) {
            return;
        }
        bundle.putString("poster_image", channel.getPosterimage());
        bundle.putString("prevue_name", dVar.m());
        bundle.putString("tv_name", channel.getChannelname() + " " + channel.getMixno());
        bundle.putString("tv_id", dVar.c());
        bundle.putString("supportTimeShift", channel.getSupporttimeshift());
        bundle.putString("isprotection", dVar.h());
        bundle.putString("contentcode", dVar.l());
        bundle.putString("ratingid", dVar.o());
        bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, dVar.k());
        bundle.putString("recommendtype", z ? "1" : "0");
        String b3 = dVar.b();
        bundle.putString("prevuebegintime", b3);
        String g2 = dVar.g();
        bundle.putString("prevueendtime", g2);
        bundle.putString(ParamConst.NPVR_QUERY_RSP_DURATION, x.c(b3, "yyyy.MM.dd HH:mm:ss", "HH:mm", 1) + "-" + x.c(g2, "yyyy.MM.dd HH:mm:ss", "HH:mm", 1));
        bundle.putString("cmsid", dVar.d());
        bundle.putString("physicalcontentid", dVar.j());
        String p = dVar.p();
        bundle.putString("playuri4dlna", com.zte.iptvclient.android.mobile.h.a.b.a(dVar.l(), c2, p, x.c(b3, "yyyy.MM.dd HH:mm:ss", "yyyyMMddHHmmss", 1), x.c(g2, "yyyy.MM.dd HH:mm:ss", "yyyyMMddHHmmss", 1)));
        bundle.putString("telecomcode", p);
        com.zte.iptvclient.android.common.player.j.j jVar = new com.zte.iptvclient.android.common.player.j.j();
        jVar.b(c2);
        jVar.a(channel.getColumncode());
        jVar.c("1");
        if (TextUtils.equals("1", ConfigMgr.readPropertie("isSupportQueryAds"))) {
            fVar.a(true);
        } else {
            fVar.a(false);
        }
        if (TextUtils.equals("1", ConfigMgr.readPropertie("SuportTvoDAddBookMark", "0"))) {
            fVar.b(true);
        } else {
            fVar.b(false);
        }
        fVar.a(jVar, bundle, (Context) this);
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public int i() {
        return this.a0;
    }

    @Override // com.zte.fragmentlib.SupportActivity
    public void l() {
        if (this.n0) {
            super.l();
        }
        com.zte.iptvclient.android.common.player.k.c cVar = this.J;
        if (cVar != null && cVar.A) {
            if (cVar.s5) {
                return;
            }
            cVar.i0();
        } else {
            if (getSupportFragmentManager().q() > 1) {
                com.zte.iptvclient.android.common.player.k.c cVar2 = this.J;
                if (cVar2 == null || !cVar2.e0) {
                    n();
                    return;
                }
                return;
            }
            if (System.currentTimeMillis() - this.x > 2000) {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.exit_application_prompt_confirmation);
                this.x = System.currentTimeMillis();
            } else {
                J();
            }
        }
    }

    @Override // com.zte.fragmentlib.SupportActivity
    protected FragmentAnimator m() {
        return new DefaultHorizontalAnimator();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        String a2 = cVar.a();
        if (TextUtils.isEmpty(a2)) {
            a2 = "";
        }
        if (a2.equals("17101004") || a2.equals("17101001") || a2.equals("17102001")) {
            int i2 = this.e0 + 1;
            this.e0 = i2;
            if (i2 <= 1) {
                this.w.K(null);
                this.w.x(null);
                M();
                return;
            }
        }
        LogEx.d("MainActivity", "recv LoginReturnEvent event");
        this.D = true;
        d();
        if (cVar.a().equals("0")) {
            H();
            LogEx.d("MainActivity", "MianActivity scanDevices");
            com.zte.iptvclient.android.mobile.h.a.a.g().c();
            if ("1".equals(SDKLoginMgr.getInstance().getUserInfo("paymode")) && com.zte.iptvclient.android.mobile.n.c.b.t()) {
                new Handler().postDelayed(new f(), 1000L);
            } else {
                this.j0 = true;
            }
            this.k0 = new Timer(true);
            this.k0.schedule(new l(), 0L, 1000L);
        }
    }

    public synchronized void c(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return;
        }
        this.b0 = i2;
        this.a0 = i3;
    }

    public void a(int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.M, this.N);
        layoutParams.setMargins(i2, i3, 0, 0);
        this.G.setLayoutParams(layoutParams);
    }

    public void b(int i2) {
        LogEx.d("MainActivity", "movePlayer=" + i2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b0, this.a0);
        layoutParams.setMargins(0, i2, 0, 0);
        this.G.setLayoutParams(layoutParams);
    }

    private void a(Device device) {
        if (device == null) {
            return;
        }
        com.zte.iptvclient.android.mobile.h.a.a.g().a(device);
        if (!"1".equals(ConfigMgr.readPropertie("SupportRemoteDownload", "0")) || !TextUtils.equals(device.getHCAbility(), "1") || TextUtils.isEmpty(device.getSTBAddr()) || TextUtils.isEmpty(device.getHCDownloadPort())) {
            return;
        }
        LogEx.d("MainActivity", "HC100 login stbaddr = " + device.getSTBAddr() + ",stbport=" + device.getHCDownloadPort());
        SDKDownloadMgr.getInstance().loginSTB(device.getSTBAddr(), Integer.valueOf(device.getHCDownloadPort()).intValue(), new e());
    }

    public void c(boolean z) {
        if (z) {
            if (this.G != null) {
                this.G.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                return;
            }
            return;
        }
        if (this.G != null) {
            this.G.setLayoutParams(new RelativeLayout.LayoutParams(this.b0, this.a0));
        }
    }

    public void b(int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b0, this.a0);
        layoutParams.setMargins(i2, i3, 0, 0);
        this.G.setLayoutParams(layoutParams);
    }

    /* loaded from: classes.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.zte.iptvclient.android.mobile.c0.d.a.a(new a(), MainActivity.this.z);
        }

        /* loaded from: classes.dex */
        class a implements a.b {

            /* renamed from: com.zte.iptvclient.android.mobile.MainActivity$f$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0164a implements d.b {
                C0164a() {
                }

                @Override // com.zte.iptvclient.android.common.customview.a.a.e.d.b
                public void a() {
                    MainActivity.this.j0 = true;
                }
            }

            a() {
            }

            @Override // com.zte.iptvclient.android.mobile.c0.d.a.b
            public void a(String str) {
                String c2 = com.zte.iptvclient.common.uiframe.a.c("Balance_Limit");
                if (TextUtils.isEmpty(str) && TextUtils.isEmpty(c2)) {
                    MainActivity.this.j0 = true;
                    return;
                }
                String replaceAll = str.replaceAll(",", "").replaceAll("，", "");
                try {
                    if (Double.valueOf(replaceAll).doubleValue() < Double.valueOf(c2).doubleValue()) {
                        new com.zte.iptvclient.android.common.customview.a.a.e.d(MainActivity.this.z, R.style.dialog_order, MainActivity.this.getResources().getString(R.string.balance_dialog).replace("x.xx", str), new C0164a()).show();
                    }
                } catch (Exception e) {
                    MainActivity.this.j0 = true;
                    LogEx.d("MainActivity", e.toString());
                }
            }

            @Override // com.zte.iptvclient.android.mobile.c0.d.a.b
            public void a() {
                MainActivity.this.j0 = true;
            }
        }
    }

    private void a(String str) {
        q();
        ArrayList<com.zte.iptvclient.android.common.javabean.models.c> arrayList = this.F;
        if (arrayList != null) {
            arrayList.clear();
        }
        SDKChannelMgr sDKChannelMgr = new SDKChannelMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("channelcode", str);
        sDKChannelMgr.getChannelDetailWithURl(hashMap, new h());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.a aVar) {
        if (TextUtils.isEmpty(this.w.h())) {
            return;
        }
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.e(this.w.h(), ""));
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.n.a(TabHostManager.TabName.TV));
        com.zte.iptvclient.android.common.e.x.e eVar = new com.zte.iptvclient.android.common.e.x.e(this.J.I1(), "");
        eVar.a(true);
        EventBus.getDefault().post(eVar);
        this.w.k("");
    }

    private void a(String str, boolean z) {
        q();
        ArrayList<com.zte.iptvclient.android.common.javabean.models.d> arrayList = this.E;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.E = new ArrayList<>();
        }
        SDKPrevueMgr sDKPrevueMgr = new SDKPrevueMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("prevuecode", str);
        hashMap.put("recommendtype", z ? "1" : "0");
        sDKPrevueMgr.getPrevueDetailWithUrl(hashMap, new i(z));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.n.d dVar) {
        stopService(new Intent(this, (Class<?>) UpdateService.class));
        n.d().c(this);
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public void a(int i2) {
        WindowManager.LayoutParams attributes;
        setRequestedOrientation(i2);
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.flags |= 512;
            window.setAttributes(attributes);
        }
        new Handler().postDelayed(new j(), 500L);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.d dVar) {
        com.zte.iptvclient.android.common.player.k.c cVar;
        LogEx.d("MainActivity", "recv GeneralSkipToFragmentEvent");
        Bundle arguments = dVar.b().getArguments();
        if (arguments != null) {
            arguments.putBoolean("enable_title_back", true);
        } else {
            Bundle bundle = new Bundle();
            bundle.putBoolean("enable_title_back", true);
            dVar.b().setArguments(bundle);
        }
        if (((dVar.b() instanceof com.zte.iptvclient.android.mobile.a0.b.g) || (dVar.b() instanceof com.zte.iptvclient.android.mobile.e0.e.d) || (dVar.b() instanceof com.zte.iptvclient.android.mobile.e0.e.i) || (dVar.b() instanceof com.zte.iptvclient.android.mobile.u.a.a)) && (cVar = this.J) != null) {
            cVar.F1();
        }
        if (dVar.a() == 1) {
            b(dVar.b());
        } else {
            a(dVar.b());
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public void a(boolean z) {
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(512);
        }
        if (BaseApp.a(this)) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
        com.zte.iptvclient.android.common.player.k.c cVar = this.J;
        if (cVar != null && !z) {
            cVar.F1();
            a(this.J);
        }
        new Handler().postDelayed(new a(), 1000L);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.n.b bVar) {
        com.zte.iptvclient.android.mobile.l.a.b bVar2 = this.y;
        if (bVar2 == null) {
            getSupportFragmentManager().a(com.zte.iptvclient.android.mobile.a.class.getName(), 1);
            a(R.id.base_container, new com.zte.iptvclient.android.mobile.a());
        } else {
            bVar2.notifyDataSetChanged();
            this.y.a(0);
            throw null;
        }
    }

    public void a(com.zte.iptvclient.android.common.player.k.c cVar) {
        String N1 = cVar.N1();
        LogEx.d("MainActivity", "AUTH_CONTENT_TYPE_VOD  --   1 " + N1);
        if (TextUtils.equals(N1, "10")) {
            String M1 = cVar.M1();
            Bundle bundle = new Bundle();
            bundle.putBoolean("FromFloatWindow", true);
            bundle.putString("programcode", M1);
            Intent intent = new Intent(this, (Class<?>) HostActivity.class);
            bundle.putString("fragmenttype", "seriesdetail");
            intent.putExtras(bundle);
            startActivity(intent);
            return;
        }
        if (TextUtils.equals(N1, "1")) {
            LogEx.d("MainActivity", "AUTH_CONTENT_TYPE_VOD  --   1");
            String L1 = cVar.L1();
            com.zte.iptvclient.android.mobile.e0.e.d dVar = new com.zte.iptvclient.android.mobile.e0.e.d();
            Bundle bundle2 = new Bundle();
            bundle2.putString("programcode", L1);
            bundle2.putBoolean("FromFloatWindow", true);
            dVar.setArguments(bundle2);
            com.zte.iptvclient.android.common.e.x.d dVar2 = new com.zte.iptvclient.android.common.e.x.d();
            dVar2.a(dVar);
            EventBus.getDefault().post(dVar2);
            cVar.a((a.i) dVar);
            cVar.setTargetFragment(dVar, 20);
            return;
        }
        if (TextUtils.equals(N1, "2")) {
            getSupportFragmentManager().a(com.zte.iptvclient.android.mobile.a.class.getName(), 0);
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.n.a(TabHostManager.TabName.TV));
            com.zte.iptvclient.android.common.e.x.e eVar = new com.zte.iptvclient.android.common.e.x.e(cVar.I1(), "");
            eVar.a(true);
            EventBus.getDefault().post(eVar);
            return;
        }
        if (TextUtils.equals(N1, "4")) {
            getSupportFragmentManager().a(com.zte.iptvclient.android.mobile.a.class.getName(), 0);
            PrevueBean prevueBean = new PrevueBean();
            prevueBean.setPrevuecode(cVar.K1());
            prevueBean.setChannelcode(cVar.I1());
            String J1 = cVar.J1();
            LogEx.d("MainActivity", "play tvod begintime : " + J1);
            try {
                J1 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.ENGLISH).parse(J1));
            } catch (Exception e2) {
                LogEx.e("MainActivity", e2.getMessage());
            }
            prevueBean.setBegintime(J1);
            prevueBean.setPrevuebreakpoint(cVar.O1() / 1000);
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.n.a(TabHostManager.TabName.TV));
            EventBus.getDefault().post(new o(prevueBean));
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.b0.c cVar) {
        if (TextUtils.isEmpty(cVar.a())) {
            return;
        }
        a(cVar.a(), cVar.b());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.i iVar) {
        if (TextUtils.isEmpty(iVar.a())) {
            return;
        }
        a(iVar.a());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.n.c cVar) {
        if (this.w.l()) {
            this.w.b(false);
            t.a(this, getResources().getString(R.string.float_frist_close_message), R.string.float_frist_close_setting, R.string.float_frist_close_cancel, new g());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.e eVar) {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        this.S = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        this.T = height;
        int i2 = this.S;
        this.K = i2 / 2;
        this.L = (height - (((i2 / 2) / 16) * 9)) - ((height * 90) / 1000);
        this.M = i2 / 2;
        this.N = ((i2 / 2) / 16) * 9;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.M, this.N);
        layoutParams.setMargins(this.K, this.L, 0, 0);
        this.G.setLayoutParams(layoutParams);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.h hVar) {
        this.J = null;
        a(com.zte.iptvclient.android.mobile.a.class, false);
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.n.a(TabHostManager.TabName.TV));
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.e(hVar.a(), ""));
    }

    private void a(Bundle bundle) {
        String string = bundle.getString("auth_contenttype");
        if ("2".equals(string)) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.n.a(TabHostManager.TabName.TV));
            com.zte.iptvclient.android.common.e.x.e eVar = new com.zte.iptvclient.android.common.e.x.e(this.J.I1(), "");
            eVar.a(true);
            EventBus.getDefault().post(eVar);
            this.J.g(bundle);
            return;
        }
        if (TextUtils.equals(string, "4")) {
            PrevueBean prevueBean = new PrevueBean();
            prevueBean.setPrevuecode(this.J.K1());
            prevueBean.setChannelcode(this.J.I1());
            String J1 = this.J.J1();
            LogEx.d("MainActivity", "play tvod begintime : " + J1);
            try {
                J1 = new SimpleDateFormat("yyyyMMddHHmmss").format(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").parse(J1));
            } catch (Exception e2) {
                LogEx.e("MainActivity", e2.getMessage());
            }
            prevueBean.setBegintime(J1);
            prevueBean.setPrevuebreakpoint(this.J.O1() / 1000);
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.n.a(TabHostManager.TabName.TV));
            o oVar = new o(prevueBean);
            oVar.a(true);
            EventBus.getDefault().post(oVar);
            this.J.g(bundle);
        }
    }
}
