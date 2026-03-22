package com.zte.iptvclient.android.common.function.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.common.AndroidUniqueCode;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.mes.MesMsg;
import com.video.androidsdk.mes.SDKPushMsgMgr;
import com.video.androidsdk.mes.bean.MsgInfo;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.Splashscreen;
import com.zte.iptvclient.android.common.f.b.j;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import java.security.SecureRandom;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes.dex */
public class PushMessageService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private h f4612a = null;

    /* renamed from: b, reason: collision with root package name */
    private Timer f4613b = null;

    /* renamed from: c, reason: collision with root package name */
    private Timer f4614c = null;

    /* renamed from: d, reason: collision with root package name */
    private String f4615d = "";
    private String e = "";
    private int f = 0;
    private String g = "";
    private String h = "";
    private String i = "";
    private String j = "";
    private SDKPushMsgMgr k;
    private j l;

    /* loaded from: classes.dex */
    class a implements SDKPushMsgMgr.OnPushMsgListener {
        a() {
        }

        @Override // com.video.androidsdk.mes.SDKPushMsgMgr.OnPushMsgListener
        public void onMsgInfo(MsgInfo msgInfo) {
            if (!TextUtils.equals("1", ConfigMgr.readPropertie("MessegePushSwitch")) || msgInfo == null) {
                return;
            }
            LogEx.d("PushMessageService", "onMsgInfo getMsgid=" + msgInfo.msgid + "getMsgfrom=" + msgInfo.msgFrom);
            if (PushMessageService.this.l.a(msgInfo.msgid)) {
                return;
            }
            PushMessageService.this.l.a(msgInfo);
            if (PushMessageService.this.f4612a.p()) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.p.a());
                PushMessageService.this.a(msgInfo.msgid, msgInfo.msgTitle, msgInfo.summary);
            }
            PushMessageService.this.a();
            if (StringUtil.isEmptyString(msgInfo.timestamp)) {
                return;
            }
            String str = msgInfo.timestamp;
            PushMessageService.this.f4612a.G(str);
            LogEx.d("PushMessageService", "set offLineMsg setTimeStamp=" + str);
        }

        @Override // com.video.androidsdk.mes.SDKPushMsgMgr.OnPushMsgListener
        public void onMsgInfoAfterTimestamp(MsgInfo[] msgInfoArr) {
            LogEx.d("PushMessageService", "onMsgInfoAfterTimestampBack");
            if (!TextUtils.equals("1", ConfigMgr.readPropertie("MessegePushSwitch")) || msgInfoArr == null || msgInfoArr.length == 0) {
                return;
            }
            for (MsgInfo msgInfo : msgInfoArr) {
                PushMessageService.this.l.a(msgInfo);
            }
            PushMessageService.this.a();
        }

        @Override // com.video.androidsdk.mes.SDKPushMsgMgr.OnPushMsgListener
        public void onMsgNotify(MesMsg mesMsg) {
        }

        @Override // com.video.androidsdk.mes.SDKPushMsgMgr.OnPushMsgListener
        public void onPrepared() {
        }

        @Override // com.video.androidsdk.mes.SDKPushMsgMgr.OnPushMsgListener
        public void onSummary(String str, String str2, String str3, String str4) {
            LogEx.d("PushMessageService", "onSummary getMsgid=" + str2 + "getMsgUrl=" + str3);
            if (TextUtils.equals("1", ConfigMgr.readPropertie("MessegePushSwitch"))) {
                if (!StringUtil.isEmptyString(str2) && !StringUtil.isEmptyString(str3) && !"0".equals(str2)) {
                    SDKPushMsgMgr.getInstance().queryMsgInfo(str3, str2);
                    LogEx.d("PushMessageService", "queryMsgInfo Msgid=" + str2 + "getMsgUrl=" + str3);
                    return;
                }
                LogEx.w("PushMessageService", "Summary Msgid or MsgUrl is null ！");
                com.zte.iptvclient.android.common.f.b.h.a().a(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "[Push MES Msg back]Summary Msgid or MsgUrl is null MsgID:" + str2);
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PushMessageService.this.k.initMesClient(PushMessageService.this.getApplicationContext(), PushMessageService.this.f4615d, PushMessageService.this.f, PushMessageService.this.i, PushMessageService.this.h, PushMessageService.this.g, PushMessageService.this.j);
        }
    }

    /* loaded from: classes.dex */
    class c extends TimerTask {
        c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            String Q = PushMessageService.this.f4612a.Q();
            if (TextUtils.isEmpty(Q)) {
                Q = x.a(TimeUtil.format(TimeUtil.getNow(), "yyyyMMddHHmmss"), "yyyyMMddHHmmss", "yyyyMMddHHmmss");
            }
            LogEx.d("PushMessageService", "queryMsgInfoAfterTimestampFromLocalTime=" + Q);
            PushMessageService.this.k.queryMsgInfoAfterTimestamp(Q);
            cancel();
        }
    }

    /* loaded from: classes.dex */
    public class d extends Binder {
        public d(PushMessageService pushMessageService) {
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        LogEx.d("PushMessageService", "PushMessageService---onBind");
        return new d(this);
    }

    @Override // android.app.Service
    public void onCreate() {
        LogEx.d("PushMessageService", "PushMessageService---onCreate");
        super.onCreate();
        this.k = SDKPushMsgMgr.getInstance();
        this.f4613b = new Timer();
        this.f4614c = new Timer();
        j e = j.e();
        this.l = e;
        e.a(getApplication());
        this.f4612a = new h(getApplication());
        this.k.setCallback(new a());
        this.k.setIntentClass(PushMessageService.class);
        this.f4615d = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_MESSAGE_HOST_IP);
        this.e = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_MESSAGE_HOST_PORT);
        if (StringUtil.isEmptyString(this.f4615d) || StringUtil.isEmptyString(this.e)) {
            this.f4615d = com.zte.iptvclient.common.uiframe.a.c("MultiGate_Host_IP");
            this.e = com.zte.iptvclient.common.uiframe.a.c("MultiGate_Host_Port");
        }
        LogEx.d("PushMessageService", "push service ip=" + this.f4615d + "mPort" + this.e);
        try {
            this.f = Integer.parseInt(this.e);
        } catch (Exception e2) {
            LogEx.d("UseeTv", e2.getMessage());
        }
        this.g = com.zte.iptvclient.common.uiframe.a.d("UserToken");
        this.h = com.zte.iptvclient.common.uiframe.a.d("UserID");
        this.i = AndroidUniqueCode.getAndroidId(getApplicationContext());
        if (BaseApp.a(getApplicationContext())) {
            this.j = "8";
        } else {
            this.j = "2";
        }
        if (!StringUtil.isEmptyString(this.f4615d)) {
            new Thread(new b()).start();
            if (TextUtils.equals("1", ConfigMgr.readPropertie("MessegePushSwitch"))) {
                this.f4614c.schedule(new c(), 50000L);
                return;
            }
            return;
        }
        LogEx.d("PushMessageService", "mIpaddr is null ,initMesClient Stop");
    }

    @Override // android.app.Service
    public void onDestroy() {
        LogEx.d("PushMessageService", "PushMessageService---onDestroy");
        this.f4613b.cancel();
        this.f4613b = null;
        this.g = "";
        this.h = "";
        this.i = "";
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        MsgInfo c2;
        j jVar = this.l;
        if (jVar == null || this.f4612a == null || (c2 = jVar.c()) == null) {
            return;
        }
        String str = c2.timestamp;
        this.f4612a.G(str);
        LogEx.d("PushMessageService", "set offLineMsg setTimeStamp=" + str);
    }

    @TargetApi(16)
    public void a(String str, String str2, String str3) {
        int nextInt = new SecureRandom().nextInt(10000);
        if (g.a(getApplicationContext(), getApplicationContext().getPackageName())) {
            Intent intent = new Intent(this, (Class<?>) MainActivity.class);
            intent.putExtra("PushMessage_MsgId", str);
            intent.putExtra("PushMessage_MsgTitle", str2);
            intent.putExtra("PushMessage_MsgContent", str3);
            PendingIntent activity = PendingIntent.getActivity(this, nextInt, intent, 268435456);
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            Notification.Builder builder = new Notification.Builder(this);
            builder.setContentTitle(com.zte.iptvclient.android.common.i.a.a.a(R.string.app_name));
            builder.setContentText(str3);
            builder.setSmallIcon(R.drawable.ic_launcher);
            builder.setContentIntent(activity);
            builder.setAutoCancel(true);
            builder.setDefaults(-1);
            if (Build.VERSION.SDK_INT >= 21) {
                builder.setVisibility(1);
                builder.setFullScreenIntent(activity, false);
            }
            Notification build = builder.build();
            build.flags |= 16;
            notificationManager.notify(1, build);
            LogEx.d("PushMessageService", "App current is background !");
            return;
        }
        LogEx.d("PushMessageService", "App process is over!");
        Intent intent2 = new Intent(this, (Class<?>) Splashscreen.class);
        intent2.putExtra("isRestart", true);
        PendingIntent activity2 = PendingIntent.getActivity(this, nextInt, intent2, 268435456);
        NotificationManager notificationManager2 = (NotificationManager) getSystemService("notification");
        Notification.Builder builder2 = new Notification.Builder(this);
        builder2.setContentTitle(com.zte.iptvclient.android.common.i.a.a.a(R.string.app_name));
        builder2.setContentText(str3);
        builder2.setSmallIcon(R.drawable.ic_launcher);
        builder2.setContentIntent(activity2);
        builder2.setAutoCancel(true);
        builder2.setDefaults(-1);
        if (Build.VERSION.SDK_INT >= 21) {
            builder2.setVisibility(1);
            builder2.setFullScreenIntent(activity2, false);
        }
        Notification build2 = builder2.build();
        build2.flags |= 16;
        notificationManager2.notify(1, build2);
        LogEx.d("PushMessageService", "App process is over to notification for restart!");
    }
}
