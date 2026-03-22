package com.zte.iptvclient.android.mobile.download.helper.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.video.androidsdk.common.AndroidUniqueCode;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.download.Linstener.DownloadListReturnListener;
import com.video.androidsdk.download.Linstener.OnInitReturnListener;
import com.video.androidsdk.download.Linstener.OnTaskOperReturnListener;
import com.video.androidsdk.download.SDKDownloadMgr;
import com.video.androidsdk.download.bean.DownLoadMgrInitInfo;
import com.video.androidsdk.download.bean.DownloadTask;
import com.video.androidsdk.log.LogEx;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/* compiled from: DownloadUtil.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static int f5768a = 1;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f5769b;

    /* renamed from: c, reason: collision with root package name */
    private static f f5770c;

    /* renamed from: d, reason: collision with root package name */
    private static BroadcastReceiver f5771d = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadUtil.java */
    /* loaded from: classes.dex */
    public static class a implements OnInitReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.download.Linstener.OnInitReturnListener
        public void onInitReturn(String str, String str2) {
            LogEx.d("DownloadUtil", " strErrorCode = " + str + ", strErrorMsg = " + str2);
        }
    }

    /* compiled from: DownloadUtil.java */
    /* loaded from: classes.dex */
    static class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && !action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                LogEx.d("DownloadUtil", "mNetWorkReceiver action error,action is:" + action);
                return;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                String typeName = activeNetworkInfo.getTypeName();
                LogEx.d("DownloadUtil", "NetWork Changed to:" + typeName);
                if (typeName.equalsIgnoreCase("mobile")) {
                    c.b(2);
                    return;
                } else {
                    if (typeName.equalsIgnoreCase("WIFI")) {
                        c.b(3);
                        return;
                    }
                    return;
                }
            }
            LogEx.d("DownloadUtil", "NetWork Changed to:null");
            c.b(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadUtil.java */
    /* renamed from: com.zte.iptvclient.android.mobile.download.helper.c.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0213c implements OnTaskOperReturnListener {
        C0213c() {
        }

        @Override // com.video.androidsdk.download.Linstener.OnTaskOperReturnListener
        public void onTaskOperReturn(String str, String str2, String str3) {
            LogEx.d("DownloadUtil", "onTaskOperReturn NET_NONE s = " + str + ", s1 = " + str2 + ", s2 = " + str3);
            if (c.f5770c != null) {
                c.f5770c.f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadUtil.java */
    /* loaded from: classes.dex */
    public static class d implements OnTaskOperReturnListener {
        d() {
        }

        @Override // com.video.androidsdk.download.Linstener.OnTaskOperReturnListener
        public void onTaskOperReturn(String str, String str2, String str3) {
            LogEx.d("DownloadUtil", "onTaskOperReturn NET_MOBILE s = " + str + ", s1 = " + str2 + ", s2 = " + str3);
            if (c.f5770c != null) {
                c.f5770c.f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadUtil.java */
    /* loaded from: classes.dex */
    public static class e implements DownloadListReturnListener {
        e() {
        }

        @Override // com.video.androidsdk.download.Linstener.DownloadListReturnListener
        public void returnDownloadTaskList(String str, int i, String str2, ArrayList<DownloadTask> arrayList) {
            LogEx.d("DownloadUtil", "status = " + str + ", errorCode = " + i + ", errorMsg = " + str2 + ", arraylist = " + arrayList);
            if (arrayList == null || arrayList.isEmpty()) {
                return;
            }
            Iterator<DownloadTask> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                DownloadTask next = it2.next();
                if ("false".equals(next.videoInfo.get("isHandStop"))) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(next);
                    SDKDownloadMgr.getInstance().startDownload(arrayList2, 1, null);
                }
            }
        }
    }

    /* compiled from: DownloadUtil.java */
    /* loaded from: classes.dex */
    public interface f {
        void f();
    }

    public static boolean b() {
        return f5769b;
    }

    public static boolean c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            String typeName = activeNetworkInfo.getTypeName();
            if (typeName.equals("mobile")) {
                f5768a = 2;
            } else if (typeName.equals("WIFI")) {
                f5768a = 3;
            }
            return true;
        }
        f5768a = 1;
        return false;
    }

    public static void d(Context context) {
        try {
            context.unregisterReceiver(f5771d);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }

    public static void b(Context context) {
        LogEx.d("DownloadUtil", "register receiver android.net.conn.CONNECTIVITY_CHANGE");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.setPriority(1000);
        context.registerReceiver(f5771d, intentFilter);
    }

    public static void a(boolean z) {
        f5769b = z;
    }

    public static void a(f fVar) {
        f5770c = fVar;
    }

    public static DownLoadMgrInitInfo a(Context context, int i) {
        DownLoadMgrInitInfo downLoadMgrInitInfo = new DownLoadMgrInitInfo();
        downLoadMgrInitInfo.drmIp = com.zte.iptvclient.android.mobile.download.helper.a.n().b();
        downLoadMgrInitInfo.drmPort = String.valueOf(com.zte.iptvclient.android.mobile.download.helper.a.n().c());
        downLoadMgrInitInfo.mac = AndroidUniqueCode.getAndroidId(context);
        downLoadMgrInitInfo.companyName = com.zte.iptvclient.android.mobile.download.helper.a.n().a();
        downLoadMgrInitInfo.drmStorePath = com.zte.iptvclient.android.mobile.download.helper.a.n().d();
        downLoadMgrInitInfo.downloadAllPath = a(context);
        downLoadMgrInitInfo.downloadVideoPath = com.zte.iptvclient.android.mobile.download.helper.a.n().j();
        downLoadMgrInitInfo.connectNetwork = c(context) ? "1" : "0";
        downLoadMgrInitInfo.miniMumSpace = String.valueOf(com.zte.iptvclient.android.mobile.download.helper.a.n().e());
        downLoadMgrInitInfo.downloadType = String.valueOf(i);
        LogEx.d("DownloadUtil", " info.drmIp = " + downLoadMgrInitInfo.drmIp + " info.drmPort = " + downLoadMgrInitInfo.drmPort + " info.mac = " + downLoadMgrInitInfo.mac + " info.companyName = " + downLoadMgrInitInfo.companyName + " info.drmStorePath = " + downLoadMgrInitInfo.drmStorePath + " info.downloadAllPath = " + downLoadMgrInitInfo.downloadAllPath + " info.downloadVideoPath = " + downLoadMgrInitInfo.downloadVideoPath + " info.connectNetwork = " + downLoadMgrInitInfo.connectNetwork + " info.miniMumSpace = " + downLoadMgrInitInfo.miniMumSpace + "  info.downloadType = " + downLoadMgrInitInfo.downloadType);
        return downLoadMgrInitInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i) {
        int c2 = c(i);
        LogEx.d("DownloadUtil", "NetWork Changed to type: " + c2);
        if (c2 == 1) {
            SDKDownloadMgr.getInstance().pauseALL(1, new C0213c());
            return;
        }
        if (c2 == 2) {
            if (com.zte.iptvclient.android.mobile.download.helper.a.n().i() == 0) {
                SDKDownloadMgr.getInstance().pauseALL(1, new d());
            }
        } else if (c2 != 3) {
            LogEx.d("DownloadUtil", "network change ignored");
        } else if (com.zte.iptvclient.android.mobile.download.helper.a.n().i() == 0) {
            c();
        } else {
            LogEx.d("DownloadUtil", "Auto download in WIFI is off,No need to do anything");
        }
    }

    private static int c(int i) {
        if (i == f5768a) {
            return 911;
        }
        f5768a = i;
        return i;
    }

    public static void c() {
        SDKDownloadMgr.getInstance().getDownloadList("1", 1, new e());
    }

    public static void a(String str, Context context) {
        String b2 = com.zte.iptvclient.android.mobile.download.helper.a.n().b();
        String a2 = com.zte.iptvclient.android.mobile.download.helper.a.n().a();
        int c2 = com.zte.iptvclient.android.mobile.download.helper.a.n().c();
        if (b2 != null && a2 != null && c2 != 0) {
            String c3 = com.zte.iptvclient.common.uiframe.a.c("DRM_Server_IP");
            String c4 = com.zte.iptvclient.common.uiframe.a.c("DRM_Company_Name");
            String c5 = com.zte.iptvclient.common.uiframe.a.c("DRM_Server_Port");
            if (c3 != null && c4 != null && c5 != null) {
                try {
                    int parseInt = Integer.parseInt(c5);
                    if (!TextUtils.equals(c3, "") && !TextUtils.equals(c4, "")) {
                        if (b2.equals(c3) && a2.equals(c4) && c2 == parseInt) {
                            LogEx.d("DownloadUtil", "Drm info not changed, no need to reinit download proxy");
                            return;
                        }
                        LogEx.d("DownloadUtil", "Drm info changed, update drm info into mPreference");
                        LogEx.d("DownloadUtil", "New Drm IP:" + c3);
                        LogEx.d("DownloadUtil", "New Drm Company:" + c4);
                        LogEx.d("DownloadUtil", "New Drm Port:" + parseInt);
                        com.zte.iptvclient.android.mobile.download.helper.a.n().b(c3);
                        com.zte.iptvclient.android.mobile.download.helper.a.n().a(c4);
                        com.zte.iptvclient.android.mobile.download.helper.a.n().a(parseInt);
                        LogEx.d("DownloadUtil", "Drm info changed, reinit download proxy ");
                        SDKDownloadMgr.getInstance().uninit();
                        SDKDownloadMgr.getInstance().init(a(context, 3), new a());
                        return;
                    }
                    LogEx.d("DownloadUtil", "Drm info got from portal.properties is null");
                    return;
                } catch (NumberFormatException unused) {
                    LogEx.d("DownloadUtil", "Server_Port is not a Nunber, return");
                    return;
                }
            }
            LogEx.d("DownloadUtil", "New Drm info is null, return");
            return;
        }
        LogEx.d("DownloadUtil", "Old Drm info is null, return");
    }

    private static String a(Context context) {
        return com.zte.iptvclient.android.mobile.download.helper.c.b.a(context, 0) + ";" + com.zte.iptvclient.android.mobile.download.helper.c.b.a(context, 1);
    }

    public static Boolean a(DownloadTask downloadTask) {
        String str = downloadTask.videoInfo.get("expiredDate");
        Date date = new Date();
        Date now = TimeUtil.getNow();
        try {
            date = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").parse(str);
        } catch (ParseException unused) {
            LogEx.w("DownloadUtil", "Parse expiredDateStr : " + str + " failed!");
        }
        if (now.after(date)) {
            return true;
        }
        return false;
    }

    public static boolean a(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = (calendar.get(1) * 100) + calendar.get(2);
        calendar.setTime(TimeUtil.getNow());
        int i2 = (calendar.get(1) * 100) + calendar.get(2);
        LogEx.d("DownloadUtil", "expireTime:" + i + "nowTime:" + i2);
        return i <= i2;
    }
}
