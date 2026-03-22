package com.zte.iptvclient.android.common;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.Util;
import com.video.androidsdk.SDKMgr;
import com.video.androidsdk.common.CrashHandler;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.cache.SDKCacheMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.f.b.f;
import com.zte.iptvclient.android.common.f.b.n;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.javabean.BrowserReturnBean;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.netstate.NetworkStateReceiver;
import com.zte.iptvclient.android.common.player.activity.VOPlayerActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.launcher.activity.LauncherPageActivity;
import com.zte.iptvclient.android.zala.R;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class Splashscreen extends SupportActivity {
    private com.zte.iptvclient.android.mobile.n.c.b A;
    private ImageView B;
    private RelativeLayout C;
    private MediaPlayer D;
    private SurfaceView E;
    private ExecutorService G;
    private Timer J;
    private TimerTask K;
    private Context v;
    private h w;
    private String x = "";
    private boolean y = false;
    private Intent z = null;
    private boolean F = false;
    private int L = 2;
    Runnable M = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements SDKMgr.OnSDKInitReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.SDKMgr.OnSDKInitReturnListener
        public void onSDKInitReturn(String str, String str2) {
            LogEx.d("SplashscreenActivity", "onSDKInitReturn s = " + str + "   s1=" + str2);
            if (TextUtils.equals(str, "0")) {
                SDKCacheMgr.enableCache(false);
                Splashscreen.this.B();
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Splashscreen.this.A();
            SharedPreferences sharedPreferences = Splashscreen.this.getSharedPreferences("need_clear_download_file", 0);
            if (sharedPreferences.getBoolean("need_clear", true)) {
                sharedPreferences.edit().putBoolean("need_clear", false).commit();
                com.zte.iptvclient.android.common.k.c.a(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/IPTV/"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends TimerTask {
        c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            LogEx.d("SplashscreenActivity", "miTotalTime:" + Splashscreen.this.L);
            Splashscreen.d(Splashscreen.this);
            if (Splashscreen.this.L == 0) {
                Splashscreen.this.s();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        f b2 = f.b();
        b2.a(getApplicationContext());
        b2.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        v();
        c(getIntent());
        n.d().a(getApplicationContext());
        C();
        D();
    }

    private void C() {
        LogEx.d("SplashscreenActivity", "startLogin");
        com.zte.iptvclient.android.mobile.n.c.b k = com.zte.iptvclient.android.mobile.n.c.b.k();
        this.A = k;
        k.i();
        this.A.a(getApplicationContext());
    }

    private void D() {
        LogEx.d("SplashscreenActivity", "startTimerTask");
        if (this.J == null) {
            this.J = new Timer();
        }
        TimerTask timerTask = this.K;
        if (timerTask != null) {
            timerTask.cancel();
            this.K = null;
        }
        c cVar = new c();
        this.K = cVar;
        this.J.schedule(cVar, 0L, 1000L);
    }

    private void E() {
        LogEx.d("SplashscreenActivity", "stopTimerTask");
        Timer timer = this.J;
        if (timer != null) {
            timer.cancel();
            this.J = null;
        }
        TimerTask timerTask = this.K;
        if (timerTask != null) {
            timerTask.cancel();
            this.K = null;
        }
    }

    static /* synthetic */ int d(Splashscreen splashscreen) {
        int i = splashscreen.L;
        splashscreen.L = i - 1;
        return i;
    }

    private void t() {
        if (this.F) {
            return;
        }
        SurfaceView surfaceView = this.E;
        if (surfaceView != null) {
            surfaceView.removeCallbacks(null);
        }
        MediaPlayer mediaPlayer = this.D;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.D.stop();
            }
            this.D.release();
        }
        this.F = true;
    }

    private void u() {
        com.zte.iptvclient.android.common.i.a.a.a(getApplicationContext());
        y();
        com.zte.iptvclient.common.uiframe.h.a(BaseApp.e());
        SDKMgr.initSDK(getApplicationContext(), new a());
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.G = newSingleThreadExecutor;
        newSingleThreadExecutor.submit(this.M);
        NetworkStateReceiver.b(getApplicationContext());
        if (z()) {
            return;
        }
        String str = ConfigMgr.getApplicationExceptionFilePath() + "ZALAMobile/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        CrashHandler crashHandler = CrashHandler.getInstance(str);
        crashHandler.setICrashHandlerListener(BaseApp.e());
        crashHandler.init(getApplicationContext());
    }

    private void v() {
        LogEx.d("SplashscreenActivity", "IsShowTourPage = " + ConfigMgr.readPropertie("IsShowTourPage"));
        LogEx.d("SplashscreenActivity", "IsForceShowTourPage = " + ConfigMgr.readPropertie("IsForceShowTourPage"));
        if ("1".equals(ConfigMgr.readPropertie("IsShowTourPage"))) {
            if ("1".equals(ConfigMgr.readPropertie("IsForceShowTourPage"))) {
                LogEx.d("SplashscreenActivity", "this is the first launcher");
                this.z = new Intent(this, (Class<?>) LauncherPageActivity.class);
                ConfigMgr.writeProperties("IsForceShowTourPage", "0");
                this.w.d(false);
                this.w.e(true);
                this.w.f(true);
                this.w.g(true);
                return;
            }
            if (this.w.n()) {
                LogEx.d("SplashscreenActivity", "this is the first launcher");
                this.z = new Intent(this, (Class<?>) LauncherPageActivity.class);
                this.w.d(false);
                this.w.e(true);
                this.w.f(true);
                this.w.g(true);
                return;
            }
            this.z = new Intent(this, (Class<?>) MainActivity.class);
            if (TextUtils.isEmpty(this.x)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("pcode", this.x);
            this.z.putExtras(bundle);
            return;
        }
        this.z = new Intent(this, (Class<?>) MainActivity.class);
        if (TextUtils.isEmpty(this.x)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("pcode", this.x);
        this.z.putExtras(bundle2);
    }

    private void w() {
        this.E = (SurfaceView) findViewById(R.id.surfaceview);
        this.B = (ImageView) findViewById(R.id.image_splash);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.splash_layout);
        this.C = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        this.B.setVisibility(0);
    }

    private void x() {
        if (BaseApp.a(this)) {
            com.zte.iptvclient.common.uiframe.f.a(Util.BYTE_OF_KB, 768);
        } else {
            com.zte.iptvclient.common.uiframe.f.a(480, 800);
        }
        com.zte.iptvclient.common.uiframe.f.a(this);
    }

    private void y() {
        c.a.a.a.d.b.d().a((Context) this);
        c.a.a.a.d.b.d().b();
        com.zte.fragmentlib.publicbaseclass.skinloader.b.a(getApplicationContext());
        if (TextUtils.equals(new h(getApplicationContext()).O(), "black.skin")) {
            c.a.a.a.d.b.d().a(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4074a + "//black.skin", (c.a.a.a.c.b) null);
            com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b = "black.skin";
            return;
        }
        if (TextUtils.equals(ConfigMgr.readPropertie("IsSupportSwitchSkin"), "1")) {
            c.a.a.a.d.b.d().a(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4074a + "//white.skin", (c.a.a.a.c.b) null);
            com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b = "white.skin";
        }
    }

    private boolean z() {
        try {
            return (getApplicationContext().getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.zte.fragmentlib.SupportActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        getApplication().onTerminate();
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.SupportActivity, com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setFlags(512, 512);
        }
        this.v = this;
        this.w = new h(this);
        setContentView(R.layout.splashscreen);
        x();
        d(getIntent());
        w();
        r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.SupportActivity, com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        E();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 1) {
            return;
        }
        if (iArr.length > 3 && iArr[0] == 0 && iArr[1] == 0 && iArr[2] == 0 && iArr[3] == 0) {
            u();
        } else {
            Toast.makeText(this, "App must has permission!", 0).show();
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void r() {
        if (androidx.core.content.a.a(this, "android.permission.READ_PHONE_STATE") == 0 && androidx.core.content.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && androidx.core.content.a.a(this, "android.permission.READ_EXTERNAL_STORAGE") == 0 && androidx.core.content.a.a(this, "android.permission.CAMERA") == 0) {
            LogEx.d("SplashscreenActivity", "has permission");
            u();
        } else {
            androidx.core.app.a.a(this, new String[]{"android.permission.READ_PHONE_STATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.CAMERA"}, 1);
        }
    }

    public void s() {
        if (this.z == null) {
            LogEx.e("SplashscreenActivity", "startActivity for Intent in NULL!");
            return;
        }
        LogEx.e("SplashscreenActivity", "startActivity");
        startActivity(this.z);
        finish();
    }

    private BrowserReturnBean a(Uri uri) {
        String str;
        String str2;
        if (uri == null) {
            return null;
        }
        LogEx.d("SplashscreenActivity", "intent data uri : " + uri.toString());
        String uri2 = uri.toString();
        if (!uri2.contains("contenttype=") || !uri2.contains("columncode=") || !uri2.contains("programcode=")) {
            return null;
        }
        int indexOf = uri2.indexOf("contenttype=") + 12;
        int indexOf2 = uri2.indexOf("&programcode=");
        str = "";
        String substring = !TextUtils.isEmpty(uri2.substring(indexOf, indexOf2)) ? uri2.substring(indexOf, indexOf2) : "";
        if (TextUtils.isEmpty(substring)) {
            return null;
        }
        LogEx.d("SplashscreenActivity", "contentType : " + substring);
        int indexOf3 = uri2.indexOf("programcode=") + 12;
        int indexOf4 = uri2.indexOf("&columncode=");
        String substring2 = !TextUtils.isEmpty(uri2.substring(indexOf3, indexOf4)) ? uri2.substring(indexOf3, indexOf4) : "";
        if (TextUtils.isEmpty(substring2)) {
            return null;
        }
        LogEx.d("SplashscreenActivity", "programcode : " + substring2);
        if (uri2.contains("seriesnumber=")) {
            int indexOf5 = uri2.indexOf("columncode=") + 11;
            int indexOf6 = uri2.indexOf("&seriesnumber=");
            String substring3 = !TextUtils.isEmpty(uri2.substring(indexOf5, indexOf6)) ? uri2.substring(indexOf5, indexOf6) : "";
            int indexOf7 = uri2.indexOf("seriesnumber=") + 13;
            int length = uri2.length();
            str2 = TextUtils.isEmpty(uri2.substring(indexOf7, length)) ? "" : uri2.substring(indexOf7, length);
            str = substring3;
        } else {
            int indexOf8 = uri2.indexOf("columncode=") + 11;
            int length2 = uri2.length();
            if (TextUtils.isEmpty(uri2.substring(indexOf8, length2))) {
                str2 = "";
            } else {
                str = uri2.substring(indexOf8, length2);
                str2 = "";
            }
        }
        LogEx.d("SplashscreenActivity", "columncode : " + str);
        LogEx.d("SplashscreenActivity", "seriesnumber : " + str2);
        BrowserReturnBean browserReturnBean = new BrowserReturnBean();
        browserReturnBean.setContentType(substring);
        browserReturnBean.setProgramCode(substring2);
        browserReturnBean.setColumnCode(str);
        browserReturnBean.setSeriesNumber(str2);
        return browserReturnBean;
    }

    public void c(Intent intent) {
        BrowserReturnBean a2;
        if (intent != null) {
            if (intent.getBooleanExtra("TvAlert_reminder", false) || intent.getBooleanExtra("VodAlert_reminder", false)) {
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    extras = new Bundle();
                }
                extras.putBoolean("Alert_reminder", this.y);
                if (this.z == null) {
                    v();
                }
                this.z.putExtras(extras);
            }
            if ("android.intent.action.VIEW".equals(intent.getAction())) {
                Uri data = intent.getData();
                if (data != null && !TextUtils.isEmpty(data.toString())) {
                    String queryParameter = data.getQueryParameter("videoid");
                    String queryParameter2 = data.getQueryParameter(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTYPE);
                    LogEx.d("SplashscreenActivity", "schemavideoid=" + queryParameter + ";schemavideotype=" + queryParameter2);
                    if (!TextUtils.isEmpty(queryParameter) && !TextUtils.isEmpty(queryParameter2)) {
                        if (this.z == null) {
                            v();
                        }
                        Bundle extras2 = this.z.getExtras();
                        if (extras2 == null) {
                            extras2 = new Bundle();
                        }
                        extras2.putString("videoid", queryParameter);
                        extras2.putString(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTYPE, queryParameter2);
                        this.z.putExtras(extras2);
                    }
                }
                LogEx.d("SplashscreenActivity", "$$$$getApplicationStatus : " + com.zte.iptvclient.common.uiframe.b.c().a());
                if ((2 == com.zte.iptvclient.common.uiframe.b.c().a() || 5 == com.zte.iptvclient.common.uiframe.b.c().a()) && g.a(getApplicationContext(), getApplicationContext().getPackageName(), MainActivity.class.getSimpleName()) && (a2 = a(intent.getData())) != null) {
                    if (g.b(getApplicationContext()).contains(VOPlayerActivity.class.getName())) {
                        Intent intent2 = new Intent(this, (Class<?>) VOPlayerActivity.class);
                        this.z = intent2;
                        Bundle extras3 = intent2.getExtras();
                        if (extras3 == null) {
                            extras3 = new Bundle();
                        }
                        extras3.putSerializable("BrowserReturnData", a2);
                        this.z.putExtras(extras3);
                        startActivity(this.z);
                        finish();
                        LogEx.d("SplashscreenActivity", "return to deail BrowserReturn");
                        return;
                    }
                    if (this.z == null) {
                        v();
                    }
                    Bundle extras4 = this.z.getExtras();
                    if (extras4 == null) {
                        extras4 = new Bundle();
                    }
                    extras4.putSerializable("BrowserReturnData", a2);
                    this.z.putExtras(extras4);
                }
            }
        }
    }

    public void d(Intent intent) {
        if (isTaskRoot() || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action) && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(action)) {
            finish();
        }
    }
}
