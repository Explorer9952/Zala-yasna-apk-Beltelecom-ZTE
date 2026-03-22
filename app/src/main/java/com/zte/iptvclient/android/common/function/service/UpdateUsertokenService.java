package com.zte.iptvclient.android.common.function.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.zte.iptvclient.android.common.Splashscreen;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.k.s;
import com.zte.iptvclient.common.uiframe.g;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class UpdateUsertokenService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private h f4619a = null;

    /* renamed from: b, reason: collision with root package name */
    private int f4620b = 0;

    /* renamed from: c, reason: collision with root package name */
    private String f4621c = "";

    /* renamed from: d, reason: collision with root package name */
    private long f4622d = 0;
    private long e = 0;
    private String f = "";
    private String g = "";
    private String h = "";
    Handler i = new Handler();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements SDKLoginMgr.ISDKLoginReturnListener {

        /* renamed from: com.zte.iptvclient.android.common.function.service.UpdateUsertokenService$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0131a implements Runnable {
            RunnableC0131a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                UpdateUsertokenService.this.a();
            }
        }

        a() {
        }

        @Override // com.video.androidsdk.login.SDKLoginMgr.ISDKLoginReturnListener
        public void onHeartbeatReturn(String str, String str2) {
        }

        @Override // com.video.androidsdk.login.SDKLoginMgr.ISDKLoginReturnListener
        public void onLoginReturn(String str, String str2) {
        }

        @Override // com.video.androidsdk.login.SDKLoginMgr.ISDKLoginReturnListener
        public void onLogoutReturn(String str, String str2) {
        }

        @Override // com.video.androidsdk.login.SDKLoginMgr.ISDKLoginReturnListener
        public void onOtherRecvReturn(int i, String str, String str2) {
        }

        @Override // com.video.androidsdk.login.SDKLoginMgr.ISDKLoginReturnListener
        public void onRefreshUserTokeReturn(int i, String str, String str2) {
            if (i == 0) {
                UpdateUsertokenService.this.f4621c = str2;
                Date b2 = s.b();
                try {
                    r1 = StringUtil.isEmptyString(UpdateUsertokenService.this.f4621c) ? 0L : new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").parse(UpdateUsertokenService.this.f4621c).getTime();
                    if (b2 != null) {
                        UpdateUsertokenService.this.f4622d = b2.getTime();
                    }
                    LogEx.d("UpdateUsertokenService", "overtimeLong is:" + r1 + " mOvertime is:" + UpdateUsertokenService.this.f4621c);
                    LogEx.d("UpdateUsertokenService", "epgtome is : " + b2 + " local time is:" + UpdateUsertokenService.this.f4622d);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                UpdateUsertokenService updateUsertokenService = UpdateUsertokenService.this;
                updateUsertokenService.e = r1 - updateUsertokenService.f4622d;
                UpdateUsertokenService.this.i.postDelayed(new RunnableC0131a(), UpdateUsertokenService.this.e);
                LogEx.d("UpdateUsertokenService", "notifyTime2 is: " + UpdateUsertokenService.this.e);
                return;
            }
            LogEx.w("UpdateUsertokenService", "updateusertoken failed");
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UpdateUsertokenService.this.a();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        LogEx.d("UpdateUsertokenService", "UpdateUsertokenService---onDestroy");
        super.onDestroy();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x008f  */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int onStartCommand(android.content.Intent r11, int r12, int r13) {
        /*
            r10 = this;
            java.lang.String r0 = " "
            java.lang.String r1 = "UpdateUsertokenService"
            java.lang.String r2 = "UpdateUsertokenService---onStartCommand"
            com.video.androidsdk.log.LogEx.d(r1, r2)
            java.lang.String r2 = "TokenExpiredTime"
            java.lang.String r2 = com.zte.iptvclient.common.uiframe.a.d(r2)
            r10.f4621c = r2
            java.util.Date r2 = com.zte.iptvclient.android.common.k.s.b()
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyy.MM.dd HH:mm:ss"
            r3.<init>(r4)
            r4 = 0
            java.lang.String r6 = r10.f4621c     // Catch: java.text.ParseException -> L81
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch: java.text.ParseException -> L81
            if (r6 != 0) goto L32
            java.lang.String r6 = r10.f4621c     // Catch: java.text.ParseException -> L81
            java.util.Date r3 = r3.parse(r6)     // Catch: java.text.ParseException -> L81
            long r6 = r3.getTime()     // Catch: java.text.ParseException -> L81
            goto L33
        L32:
            r6 = r4
        L33:
            if (r2 == 0) goto L3e
            long r8 = r2.getTime()     // Catch: java.text.ParseException -> L3c
            r10.f4622d = r8     // Catch: java.text.ParseException -> L3c
            goto L3e
        L3c:
            r0 = move-exception
            goto L83
        L3e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.text.ParseException -> L3c
            r3.<init>()     // Catch: java.text.ParseException -> L3c
            java.lang.String r8 = "overtimeLong is:"
            r3.append(r8)     // Catch: java.text.ParseException -> L3c
            r3.append(r6)     // Catch: java.text.ParseException -> L3c
            r3.append(r0)     // Catch: java.text.ParseException -> L3c
            java.lang.String r8 = "mOvertime is:"
            r3.append(r8)     // Catch: java.text.ParseException -> L3c
            java.lang.String r8 = r10.f4621c     // Catch: java.text.ParseException -> L3c
            r3.append(r8)     // Catch: java.text.ParseException -> L3c
            java.lang.String r3 = r3.toString()     // Catch: java.text.ParseException -> L3c
            com.video.androidsdk.log.LogEx.d(r1, r3)     // Catch: java.text.ParseException -> L3c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.text.ParseException -> L3c
            r3.<init>()     // Catch: java.text.ParseException -> L3c
            java.lang.String r8 = "epgtome is : "
            r3.append(r8)     // Catch: java.text.ParseException -> L3c
            r3.append(r2)     // Catch: java.text.ParseException -> L3c
            r3.append(r0)     // Catch: java.text.ParseException -> L3c
            java.lang.String r0 = "local time is:"
            r3.append(r0)     // Catch: java.text.ParseException -> L3c
            long r8 = r10.f4622d     // Catch: java.text.ParseException -> L3c
            r3.append(r8)     // Catch: java.text.ParseException -> L3c
            java.lang.String r0 = r3.toString()     // Catch: java.text.ParseException -> L3c
            com.video.androidsdk.log.LogEx.d(r1, r0)     // Catch: java.text.ParseException -> L3c
            goto L86
        L81:
            r0 = move-exception
            r6 = r4
        L83:
            r0.printStackTrace()
        L86:
            long r2 = r10.f4622d
            long r6 = r6 - r2
            r10.e = r6
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 >= 0) goto L93
            r2 = 500(0x1f4, double:2.47E-321)
            r10.e = r2
        L93:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "mNotifyTime is: "
            r0.append(r2)
            long r2 = r10.e
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.video.androidsdk.log.LogEx.d(r1, r0)
            android.os.Handler r0 = r10.i
            com.zte.iptvclient.android.common.function.service.UpdateUsertokenService$b r1 = new com.zte.iptvclient.android.common.function.service.UpdateUsertokenService$b
            r1.<init>()
            long r2 = r10.e
            r0.postDelayed(r1, r2)
            int r11 = super.onStartCommand(r11, r12, r13)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.common.function.service.UpdateUsertokenService.onStartCommand(android.content.Intent, int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        h hVar = new h(getApplicationContext());
        this.f4619a = hVar;
        this.g = hVar.V();
        this.f = ConfigMgr.readPropertie("TransactionSp");
        this.f4620b = this.f4619a.T();
        this.h = com.zte.iptvclient.common.uiframe.a.d("UserToken");
        LogEx.d("UpdateUsertokenService", "mOldUserToken is : " + this.h);
        LogEx.d("UpdateUsertokenService", "iemg is : " + com.zte.iptvclient.android.common.c.b.a());
        if (com.zte.iptvclient.android.common.c.b.a()) {
            com.zte.iptvclient.common.uiframe.b.c().a(0);
            Intent intent = new Intent(getBaseContext(), (Class<?>) Splashscreen.class);
            intent.addFlags(268435456);
            getApplication().startActivity(intent);
            return;
        }
        SDKLoginMgr.getInstance().refreshUserToken(g.a().a(this.f4620b), this.f, this.g, this.h, new a());
        int i = this.f4620b + 1;
        this.f4620b = i;
        this.f4619a.b(i);
    }
}
