package com.zte.iptvclient.android.common;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.leakcanary.d;
import com.video.androidsdk.SDKMgr;
import com.video.androidsdk.common.CrashHandler;
import com.video.androidsdk.download.SDKDownloadMgr;
import com.video.androidsdk.log.LogEx;
import com.vk.api.sdk.n;
import com.zte.iptvclient.android.common.function.service.PushMessageService;
import com.zte.iptvclient.android.common.function.service.UpdateUsertokenService;
import com.zte.iptvclient.android.common.reminder.TvReminderManager;
import com.zte.iptvclient.android.common.reminder.VodReminderManager;
import com.zte.iptvclient.android.mobile.download.helper.c.c;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* loaded from: classes.dex */
public class BaseApp extends Application implements CrashHandler.ICrashHandler {
    public static int f = 0;
    private static BaseApp g = null;
    private static boolean h = false;
    private static boolean i = true;
    public static int j;
    public static int k;

    /* renamed from: a, reason: collision with root package name */
    private com.zte.iptvclient.android.common.d.b f4076a;

    /* renamed from: b, reason: collision with root package name */
    private int f4077b = -1;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4078c = false;

    /* renamed from: d, reason: collision with root package name */
    private Handler f4079d = new a();
    private n e = new b(this);

    /* loaded from: classes.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (BaseApp.this.f4079d == null || BaseApp.this.getApplicationContext() == null) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                Object obj = message.obj;
                BaseApp.this.a(obj != null ? (String) obj : "");
            } else {
                if (i != 1) {
                    return;
                }
                BaseApp.this.a(message.obj != null ? BaseApp.this.getApplicationContext().getResources().getString(((Integer) message.obj).intValue()) : "");
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements n {
        b(BaseApp baseApp) {
        }

        @Override // com.vk.api.sdk.n
        public void a() {
        }
    }

    public static BaseApp e() {
        return g;
    }

    public static boolean f() {
        return a((Context) g);
    }

    private void g() {
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(this.f4079d);
    }

    private void h() {
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

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        androidx.multidex.a.d(this);
    }

    public boolean b() {
        return h;
    }

    public boolean c() {
        return i;
    }

    public int d() {
        return this.f4077b;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        g = this;
        d.a(this);
        if (this.f4078c) {
            SDKMgr.setLogLevel(LogEx.LogLevelType.TYPE_LOG_LEVEL_DEBUG);
            LogEx.setLogLevel(LogEx.LogLevelType.TYPE_LOG_LEVEL_DEBUG);
        } else {
            SDKMgr.setLogLevel(LogEx.LogLevelType.TYPE_LOG_LEVEL_INFO);
            LogEx.setLogLevel(LogEx.LogLevelType.TYPE_LOG_LEVEL_INFO);
        }
        this.f4076a = new com.zte.iptvclient.android.common.d.b(getApplicationContext());
        g();
        d.b.a.a.a.a(this, new com.zte.iptvclient.android.common.a()).a();
        if (Build.VERSION.SDK_INT >= 26) {
            com.zte.iptvclient.android.mobile.i.c.a.a(this, "atdownload");
        }
        com.vk.api.sdk.a.a(this.e);
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        Handler handler = this.f4079d;
        if (handler != null) {
            handler.removeMessages(0);
            this.f4079d.removeMessages(1);
            this.f4079d.removeCallbacksAndMessages(null);
            this.f4079d = null;
        }
        SDKDownloadMgr.getInstance().uninit();
        c.d(getApplicationContext());
        h();
        System.exit(0);
    }

    @Override // com.video.androidsdk.common.CrashHandler.ICrashHandler
    public boolean onUncaughtExceptionOccured(Thread thread, Throwable th) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Toast makeText = Toast.makeText(getApplicationContext(), str, 0);
        View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.toast_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.textview);
        f.a(textView);
        textView.setText(str);
        makeText.setGravity(80, 0, 0);
        makeText.setView(inflate);
        makeText.show();
    }

    public com.zte.iptvclient.android.common.d.b a() {
        return this.f4076a;
    }

    public void a(boolean z) {
        h = z;
    }

    public void a(int i2) {
        this.f4077b = i2;
    }

    public static boolean a(Context context) {
        Resources resources;
        Configuration configuration;
        return (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null || (configuration.screenLayout & 15) < 3) ? false : true;
    }
}
