package com.zte.iptvclient.android.common.update;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;
import androidx.core.app.h;
import com.facebook.internal.ServerProtocol;
import com.video.androidsdk.common.util.FileUtil;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.e.n.d;
import com.zte.iptvclient.android.zala.R;
import java.io.File;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes.dex */
public class UpdateService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private String f5238a;

    /* renamed from: b, reason: collision with root package name */
    private String f5239b;

    /* renamed from: c, reason: collision with root package name */
    private NotificationManager f5240c;

    /* renamed from: d, reason: collision with root package name */
    private Notification f5241d;
    private String e = "UpdateService";
    private boolean f = false;

    private void a(String str, String str2) {
    }

    private void a(String str, String str2, int i) {
        PendingIntent activity;
        if (!this.f) {
            h.c cVar = new h.c(this);
            cVar.a(R.drawable.ic_launcher);
            cVar.a(BaseApp.e().getString(R.string.upgrade_downloading) + i + "%");
            cVar.b(true);
            if (i > 0 && i <= 100) {
                cVar.a(100, i, false);
            } else {
                cVar.a(5, 0, false);
            }
            cVar.a(true);
            cVar.a(System.currentTimeMillis());
            cVar.b(str);
            if (i >= 100) {
                activity = a();
            } else {
                activity = PendingIntent.getActivity(this, 0, new Intent(), 134217728);
            }
            cVar.a(activity);
            Notification a2 = cVar.a();
            this.f5241d = a2;
            this.f5240c.notify(0, a2);
            if (i < 100 || this.f) {
                return;
            }
            this.f5240c.cancelAll();
            stopSelf();
            return;
        }
        b.a(i);
    }

    private void b() {
        a(this.f5238a, this.f5239b);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f5240c = (NotificationManager) getSystemService("notification");
        this.f5239b = com.zte.iptvclient.android.common.c.c.f4109b;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f5240c.cancel(0);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            a(BaseApp.e().getString(R.string.failed_upgrade), "", 0);
            stopSelf();
            return super.onStartCommand(intent, i, i2);
        }
        this.f5238a = intent.getStringExtra("apkUrl");
        String stringExtra = intent.getStringExtra("Force");
        if (stringExtra != null && stringExtra.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            this.f = true;
        }
        a(BaseApp.e().getString(R.string.start_upgrade), "", 0);
        Log.d(this.e, "apkUrl  =  " + this.f5238a);
        Context applicationContext = BaseApp.e().getApplicationContext();
        BaseApp.e().getApplicationContext();
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) applicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            b();
        } else {
            LogEx.d(this.e, "network none");
            stopSelf();
            if (this.f) {
                b.a(getApplicationContext());
            } else {
                EventBus.getDefault().post(new d());
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    private PendingIntent a() {
        LogEx.d(this.e, "跳转apk");
        File file = new File(this.f5239b);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setDataAndType(Uri.parse(FileUtil.STR_TAG_LOCALIMG + file.getAbsolutePath()), "application/vnd.android.package-archive");
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 134217728);
        startActivity(intent);
        return activity;
    }
}
