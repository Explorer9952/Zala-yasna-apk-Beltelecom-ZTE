package com.zte.iptvclient.android.mobile.download.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.widget.RemoteViews;
import com.video.androidsdk.download.Linstener.DownloadListReturnListener;
import com.video.androidsdk.download.Linstener.OnTaskOperReturnListener;
import com.video.androidsdk.download.SDKDownloadMgr;
import com.video.androidsdk.download.bean.DownloadTask;
import com.video.androidsdk.download.bean.DownloadTaskReq;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public class DownloadNotifyService extends Service {
    private String e;
    private DownloadTaskReq f;
    private HashMap<String, String> g;
    private OnTaskOperReturnListener h;
    private EventBus i;

    /* renamed from: a, reason: collision with root package name */
    private int f5772a = 0;

    /* renamed from: b, reason: collision with root package name */
    private final IBinder f5773b = new b(this);

    /* renamed from: c, reason: collision with root package name */
    private boolean f5774c = false;

    /* renamed from: d, reason: collision with root package name */
    private int f5775d = 0;
    private Handler j = new Handler();
    private Runnable k = new a();

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: com.zte.iptvclient.android.mobile.download.service.DownloadNotifyService$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0214a implements DownloadListReturnListener {
            C0214a() {
            }

            @Override // com.video.androidsdk.download.Linstener.DownloadListReturnListener
            public void returnDownloadTaskList(String str, int i, String str2, ArrayList<DownloadTask> arrayList) {
                LogEx.d("DownloadNotifyService", "status = " + str + ", errorCode = " + i + ", errorMsg = " + str2 + ", arraylist = " + arrayList);
                if (arrayList != null) {
                    DownloadNotifyService.this.f5774c = false;
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        DownloadTask downloadTask = arrayList.get(i2);
                        if (Integer.valueOf(downloadTask.status).intValue() == 1) {
                            DownloadNotifyService.this.f5775d = Integer.valueOf(downloadTask.progress).intValue() % 100;
                            DownloadNotifyService.this.e = downloadTask.videoInfo.get("videoName");
                            DownloadNotifyService.this.f5774c = true;
                        }
                    }
                    if (DownloadNotifyService.this.f5774c) {
                        DownloadNotifyService.this.j.postDelayed(DownloadNotifyService.this.k, 1000L);
                        DownloadNotifyService downloadNotifyService = DownloadNotifyService.this;
                        DownloadNotifyService.this.startForeground(2, downloadNotifyService.a(downloadNotifyService, downloadNotifyService.f5775d, DownloadNotifyService.this.e));
                        return;
                    }
                    DownloadNotifyService.this.stopSelf();
                    return;
                }
                LogEx.i("DownloadNotifyService", "arrayList 是空！！！");
                DownloadNotifyService.this.stopSelf();
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SDKDownloadMgr.getInstance().getDownloadList("1", 1, new C0214a());
        }
    }

    /* loaded from: classes.dex */
    public class b extends Binder {
        public b(DownloadNotifyService downloadNotifyService) {
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f5773b;
    }

    @Override // android.app.Service
    public void onCreate() {
        LogEx.i("DownloadNotifyService", "at download service create");
        super.onCreate();
        EventBus eventBus = EventBus.getDefault();
        this.i = eventBus;
        eventBus.register(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        LogEx.i("DownloadNotifyService", "at download service destroy");
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.mobile.download.bean.a aVar) {
        this.f = aVar.b();
        this.g = aVar.c();
        this.h = aVar.a();
        SDKDownloadMgr.getInstance().addTask(this.f, this.g, this.h);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.f5772a == 0) {
            this.j.postDelayed(this.k, 200L);
        }
        this.f5772a++;
        LogEx.i("DownloadNotifyService", "at download service start");
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Notification a(Context context, int i, String str) {
        PendingIntent activity;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.download_notify_view);
        if (this.f5774c) {
            remoteViews.setTextViewText(R.id.download_notify_progress_name, str);
            remoteViews.setTextViewText(R.id.download_notify_progress_state, com.zte.iptvclient.android.common.i.a.a.a(R.string.download_notify_state_is_downloading));
        } else {
            remoteViews.setTextViewText(R.id.download_notify_progress_name, str);
            remoteViews.setTextViewText(R.id.download_notify_progress_state, com.zte.iptvclient.android.common.i.a.a.a(R.string.download_notify_state_is_downloaded));
        }
        remoteViews.setProgressBar(R.id.download_notify_progress, 100, i, false);
        if (BaseApp.a(context)) {
            Intent intent = new Intent(context, (Class<?>) MainActivity.class);
            intent.putExtra("mydownload", "mydownload");
            activity = PendingIntent.getActivity(context, 0, intent, 134217728);
        } else {
            Bundle bundle = new Bundle();
            Intent intent2 = new Intent(context, (Class<?>) HostActivity.class);
            bundle.putString("fragmenttype", "download");
            intent2.putExtras(bundle);
            intent2.setFlags(603979776);
            activity = PendingIntent.getActivity(context, 0, intent2, 268435456);
        }
        Notification.Builder builder = new Notification.Builder(context);
        if (Build.VERSION.SDK_INT >= 26) {
            builder = new Notification.Builder(context, "atdownload");
        }
        builder.setContentIntent(activity).setContent(remoteViews).setTicker("AT").setSmallIcon(R.drawable.notify_icon);
        return builder.build();
    }
}
