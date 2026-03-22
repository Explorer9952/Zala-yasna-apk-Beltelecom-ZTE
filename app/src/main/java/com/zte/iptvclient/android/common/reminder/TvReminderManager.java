package com.zte.iptvclient.android.common.reminder;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.PreferenceHelper;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.sns.Constants;
import com.zte.iptvclient.android.common.Splashscreen;
import com.zte.iptvclient.android.common.function.receiver.TvAlarmReceiver;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.s;
import com.zte.iptvclient.android.common.player.activity.VOPlayerActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class TvReminderManager extends Service {

    /* renamed from: d, reason: collision with root package name */
    private static List<PrevueBean> f5211d;
    private static PreferenceHelper e;
    private static h f;

    /* renamed from: a, reason: collision with root package name */
    private TvReminderReceiver f5212a;

    /* renamed from: b, reason: collision with root package name */
    private int f5213b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f5214c = 0;

    /* loaded from: classes.dex */
    public static class InnerService extends Service {
        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override // android.app.Service
        public void onCreate() {
            Log.i("TvReminderManager", "InnerService -> onCreate");
            super.onCreate();
        }

        @Override // android.app.Service
        public void onDestroy() {
            Log.i("TvReminderManager", "InnerService -> onDestroy");
            super.onDestroy();
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i, int i2) {
            Log.i("TvReminderManager", "InnerService -> onStartCommand");
            startForeground(ErrCode.ERRCODE_EPG_SESSION_TIMEOUT, new Notification());
            stopSelf();
            return super.onStartCommand(intent, i, i2);
        }
    }

    /* loaded from: classes.dex */
    public class TvReminderReceiver extends BroadcastReceiver {
        public TvReminderReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            PrevueBean prevueBean = (PrevueBean) intent.getSerializableExtra("tv_reminder");
            if (prevueBean != null) {
                int intExtra = intent.getIntExtra("reminder_operation_type", 0);
                if (intExtra != -1) {
                    if (intExtra == 1) {
                        TvReminderManager.this.a(prevueBean);
                    }
                } else {
                    TvReminderManager.this.b(prevueBean);
                    LogEx.d("TvReminderManagersubReminder", "subReminder the Tv is=" + prevueBean.getChannelcode());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements TvAlarmReceiver.a {
        a() {
        }

        @Override // com.zte.iptvclient.android.common.function.receiver.TvAlarmReceiver.a
        public void a(Context context, Intent intent) {
            Bundle bundleExtra;
            PrevueBean prevueBean;
            if (TvReminderManager.f5211d == null || TvReminderManager.f5211d.size() == 0 || (bundleExtra = intent.getBundleExtra("reminderdata")) == null || (prevueBean = (PrevueBean) bundleExtra.getSerializable("reminderbean")) == null) {
                return;
            }
            for (PrevueBean prevueBean2 : TvReminderManager.f5211d) {
                if (TextUtils.equals(prevueBean2.getPrevuecode(), prevueBean.getPrevuecode())) {
                    TvReminderManager.f5211d.remove(prevueBean2);
                    TvReminderManager.this.f(prevueBean2);
                    TvReminderManager.this.f();
                    LogEx.d("TvReminderManager", "remove prevue,prevuecode is " + prevueBean.getPrevuecode());
                    LogEx.d("TvReminderManager", "mReminderDataList size is  " + TvReminderManager.f5211d.size());
                    return;
                }
            }
        }
    }

    private static long b() {
        return s.b().getTime();
    }

    public static boolean c(PrevueBean prevueBean) {
        if (f5211d != null && prevueBean != null) {
            String c2 = com.zte.iptvclient.common.uiframe.a.c("LiveTv_Alert_Max_Num");
            if (f5211d.size() < (TextUtils.isEmpty(c2) ? 10 : Integer.valueOf(c2).intValue())) {
                try {
                    long b2 = b();
                    long time = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").parse(prevueBean.getBegintime()).getTime();
                    String c3 = com.zte.iptvclient.common.uiframe.a.c("LiveTv_Alert_Interval");
                    int intValue = TextUtils.isEmpty(c3) ? 300000 : Integer.valueOf(c3).intValue() * 1000;
                    StringBuilder sb = new StringBuilder();
                    sb.append("program start time is ");
                    sb.append(time);
                    sb.append(",now time is ");
                    sb.append(intValue);
                    sb.append("interval time is ");
                    sb.append(intValue);
                    sb.append(",difftime is ");
                    long j = time - b2;
                    sb.append(j);
                    LogEx.d("TvReminderManager", sb.toString());
                    if (j > intValue) {
                        return true;
                    }
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.tv_the_program_is_about_to_play);
                    return false;
                } catch (ParseException e2) {
                    e2.printStackTrace();
                    LogEx.e("TvReminderManager", "TimeFormate Exception ");
                    return false;
                }
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.reminder_live_context_number);
            return false;
        }
        LogEx.d("TvReminderManager", "reminder size is empty");
        return false;
    }

    public static List<PrevueBean> d() {
        return f5211d;
    }

    private void e() {
        f = new h(this);
        f5211d = new ArrayList();
        e = new PreferenceHelper(getApplicationContext(), "tv_reminder");
        TvAlarmReceiver.a(new a());
        c();
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(16)
    public void f(PrevueBean prevueBean) {
        Intent intent;
        LogEx.d("TvReminderManager", "LiveTv_Alert_Interval:300000");
        long b2 = b();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(b2);
        LogEx.d("TvReminderManager", "server time: day " + calendar.get(5) + " " + calendar.get(11) + ":" + calendar.get(12) + ":" + calendar.get(13));
        boolean a2 = g.a(getApplicationContext(), getApplicationContext().getPackageName());
        StringBuilder sb = new StringBuilder();
        sb.append("is App running :");
        sb.append(a2);
        LogEx.d("TvReminderManager", sb.toString());
        boolean d2 = a2 ? g.d(getApplicationContext()) : true;
        LogEx.d("TvReminderManager", "is background running:" + d2);
        if (!a2) {
            Intent intent2 = new Intent(this, (Class<?>) Splashscreen.class);
            intent2.putExtra("TvAlert_TvShowItem", prevueBean);
            intent2.putExtra("TvAlert_reminder", true);
            int i = this.f5214c;
            this.f5214c = i + 1;
            PendingIntent activity = PendingIntent.getActivity(this, i, intent2, 268435456);
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            Notification.Builder builder = new Notification.Builder(this);
            builder.setContentTitle(getString(R.string.alert));
            builder.setContentText(String.format(getString(R.string.reminder_live_context), prevueBean.getPrevuename()));
            builder.setSmallIcon(R.drawable.ic_launcher);
            builder.setContentIntent(activity);
            builder.setAutoCancel(true);
            builder.setDefaults(-1);
            Notification build = builder.build();
            build.flags |= 16;
            int i2 = this.f5213b + 1;
            this.f5213b = i2;
            notificationManager.notify(i2, build);
            LogEx.d("TvReminderManager", "进程被杀掉");
            return;
        }
        if (d2) {
            Intent intent3 = new Intent(this, (Class<?>) MainActivity.class);
            intent3.putExtra("TvAlert_TvShowItem", prevueBean);
            intent3.putExtra("TvAlert_needConfirm", false);
            int i3 = this.f5214c;
            this.f5214c = i3 + 1;
            PendingIntent activity2 = PendingIntent.getActivity(this, i3, intent3, 268435456);
            NotificationManager notificationManager2 = (NotificationManager) getSystemService("notification");
            Notification.Builder builder2 = new Notification.Builder(this);
            builder2.setContentTitle(getString(R.string.alert));
            builder2.setContentText(String.format(getString(R.string.reminder_live_context), prevueBean.getPrevuename()));
            builder2.setSmallIcon(R.drawable.ic_launcher);
            builder2.setPriority(1);
            if (Build.VERSION.SDK_INT > 20) {
                builder2.setVisibility(1);
            }
            builder2.setContentIntent(activity2);
            builder2.setAutoCancel(true);
            builder2.setDefaults(-1);
            Notification build2 = builder2.build();
            build2.tickerText = String.format(getString(R.string.reminder_live_context), prevueBean.getPrevuename());
            build2.flags |= 16;
            int i4 = this.f5213b + 1;
            this.f5213b = i4;
            notificationManager2.notify(i4, build2);
            LogEx.d("TvReminderManager", "在后台运行，收到直播提醒消息");
            return;
        }
        LogEx.d("TvReminderManager", "VOPlayerActivity.class.getName() is " + VOPlayerActivity.class.getName() + " , getTopActivityName is " + g.b(getApplicationContext()));
        if (g.b(getApplicationContext()).contains(VOPlayerActivity.class.getName())) {
            intent = new Intent(this, (Class<?>) VOPlayerActivity.class);
        } else {
            intent = new Intent(this, (Class<?>) MainActivity.class);
        }
        intent.putExtra("TvAlert_TvShowItem", prevueBean);
        intent.putExtra("TvAlert_needConfirm", true);
        try {
            int i5 = this.f5214c;
            this.f5214c = i5 + 1;
            PendingIntent.getActivity(this, i5, intent, 268435456).send();
        } catch (PendingIntent.CanceledException e2) {
            e2.printStackTrace();
        }
    }

    private void g() {
        h();
        List<PrevueBean> list = f5211d;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<PrevueBean> it2 = f5211d.iterator();
        while (it2.hasNext()) {
            e(it2.next());
        }
    }

    private void h() {
        List<PrevueBean> list = f5211d;
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PrevueBean prevueBean : f5211d) {
            try {
                String begintime = prevueBean.getBegintime();
                long b2 = b();
                Date parse = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").parse(begintime);
                LogEx.d("TvReminderManager", "delaytime=" + (parse.getTime() - b2));
                if (parse.getTime() - b2 > (TextUtils.isEmpty(com.zte.iptvclient.common.uiframe.a.c("LiveTv_Alert_Interval")) ? 0 : Integer.valueOf(r8).intValue() * 1000)) {
                    arrayList.add(prevueBean);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                LogEx.e("TvReminderManager", "TimeFormate Exception");
            }
        }
        LogEx.d("TvReminderManager", "cacheSize=" + arrayList.size());
        f5211d.clear();
        f5211d.addAll(arrayList);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f5212a = new TvReminderReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tv.remindReceive");
        registerReceiver(this.f5212a, intentFilter);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f5212a);
        List<PrevueBean> list = f5211d;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        e();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 18) {
            startForeground(ErrCode.ERRCODE_EPG_SESSION_TIMEOUT, new Notification());
        } else if (i3 < 26) {
            startService(new Intent(this, (Class<?>) InnerService.class));
            startForeground(ErrCode.ERRCODE_EPG_SESSION_TIMEOUT, new Notification());
        }
        return super.onStartCommand(intent, 1, i2);
    }

    private boolean d(PrevueBean prevueBean) {
        if (prevueBean == null) {
            return false;
        }
        String prevuecode = prevueBean.getPrevuecode();
        if (TextUtils.isEmpty(prevuecode)) {
            return false;
        }
        Iterator<PrevueBean> it2 = f5211d.iterator();
        while (it2.hasNext()) {
            if (TextUtils.equals(prevuecode, it2.next().getPrevuecode())) {
                return true;
            }
        }
        return false;
    }

    public void b(PrevueBean prevueBean) {
        List<PrevueBean> list;
        if (prevueBean == null || (list = f5211d) == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < f5211d.size(); i++) {
            try {
                PrevueBean prevueBean2 = f5211d.get(i);
                if (TextUtils.equals(prevueBean2.getPrevuecode(), prevueBean.getPrevuecode())) {
                    f5211d.remove(prevueBean2);
                    f();
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                LogEx.e("TvReminderManager", "TimeFormate Exception ");
                return;
            }
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str) || f5211d == null) {
            return false;
        }
        LogEx.d("TvReminderManager", "reminder size is " + f5211d.size());
        Iterator<PrevueBean> it2 = f5211d.iterator();
        while (it2.hasNext()) {
            if (TextUtils.equals(it2.next().getPrevuecode(), str)) {
                LogEx.d("TvReminderManager", "exists id is " + str);
                return true;
            }
        }
        return false;
    }

    private void e(PrevueBean prevueBean) {
        if (prevueBean == null) {
            return;
        }
        try {
            String begintime = prevueBean.getBegintime();
            long currentTimeMillis = System.currentTimeMillis();
            Date parse = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").parse(begintime);
            String c2 = com.zte.iptvclient.common.uiframe.a.c("LiveTv_Alert_Interval");
            int intValue = TextUtils.isEmpty(c2) ? 300000 : Integer.valueOf(c2).intValue() * 1000;
            if (intValue < 0) {
                intValue = 0;
            }
            long time = (parse.getTime() - currentTimeMillis) - intValue;
            if (time <= 0) {
                time = 1000;
            }
            LogEx.i("TvReminderManager", "@@@@@@@@@@NextStartTime=" + parse.getTime() + "，nowTime=" + currentTimeMillis + "，DEFAULT_ADVANCE_TIME=" + intValue + ",delaytime is " + (time / 1000) + "s");
            AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
            Intent intent = new Intent(getApplicationContext(), (Class<?>) TvAlarmReceiver.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("reminderbean", prevueBean);
            intent.putExtra("reminderdata", bundle);
            Context applicationContext = getApplicationContext();
            int i = this.f5214c;
            this.f5214c = i + 1;
            PendingIntent broadcast = PendingIntent.getBroadcast(applicationContext, i, intent, 134217728);
            if (Build.VERSION.SDK_INT >= 23) {
                alarmManager.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + Long.valueOf(time).intValue(), broadcast);
            } else if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setExact(2, SystemClock.elapsedRealtime() + Long.valueOf(time).intValue(), broadcast);
            } else {
                alarmManager.set(2, SystemClock.elapsedRealtime() + Long.valueOf(time).intValue(), broadcast);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogEx.e("TvReminderManager", e2.getMessage());
        }
    }

    public void a(PrevueBean prevueBean) {
        if (f5211d == null || prevueBean == null) {
            return;
        }
        String c2 = com.zte.iptvclient.common.uiframe.a.c("LiveTv_Alert_Max_Num");
        if (f5211d.size() < (TextUtils.isEmpty(c2) ? 10 : Integer.valueOf(c2).intValue())) {
            try {
                long b2 = b();
                long time = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").parse(prevueBean.getBegintime()).getTime();
                LogEx.d("TvReminderManager", "beginLiveDate=" + time + "nowTime=" + b2);
                String c3 = com.zte.iptvclient.common.uiframe.a.c("LiveTv_Alert_Interval");
                int intValue = TextUtils.isEmpty(c3) ? 300000 : Integer.valueOf(c3).intValue() * 1000;
                StringBuilder sb = new StringBuilder();
                sb.append("program start time is ");
                sb.append(time);
                sb.append(",now time is ");
                sb.append(intValue);
                sb.append("interval time is ");
                sb.append(intValue);
                sb.append(",difftime is ");
                long j = time - b2;
                sb.append(j);
                LogEx.d("TvReminderManager", sb.toString());
                if (j > intValue) {
                    if (d(prevueBean)) {
                        return;
                    }
                    f5211d.add(prevueBean);
                    f();
                    e(prevueBean);
                    return;
                }
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.the_program_is_about_to_play);
                return;
            } catch (ParseException e2) {
                e2.printStackTrace();
                LogEx.e("TvReminderManager", "TimeFormate Exception");
                return;
            }
        }
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.reminder_live_context_number);
    }

    private void c() {
        String string = e.getString(Constants.SINA_WEIBO_USERNAME, "");
        if (TextUtils.isEmpty(string) || !TextUtils.equals(string, f.V())) {
            return;
        }
        String string2 = e.getString("tv_reminder", "");
        if (TextUtils.isEmpty(string2)) {
            return;
        }
        List<PrevueBean> list = f5211d;
        if (list == null) {
            f5211d = new ArrayList();
        } else {
            list.clear();
        }
        try {
            JSONArray jSONArray = new JSONArray(string2);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    PrevueBean prevueBean = new PrevueBean();
                    prevueBean.setPrevuecode(a(jSONObject, "prevuecode"));
                    prevueBean.setChannelcode(a(jSONObject, "channelcode"));
                    prevueBean.setChannelname(a(jSONObject, "channelname"));
                    prevueBean.setBegintime(a(jSONObject, "begintime"));
                    prevueBean.setEndtime(a(jSONObject, "endtime"));
                    prevueBean.setPrevuename(a(jSONObject, "prevuename"));
                    prevueBean.setDuration(a(jSONObject, ParamConst.NPVR_QUERY_RSP_DURATION));
                    prevueBean.setColumncode(a(jSONObject, "columncode"));
                    f5211d.add(prevueBean);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogEx.e("TvReminderManager", "JSONException");
        }
    }

    private void a(JSONObject jSONObject, String str, String str2) {
        if (jSONObject != null) {
            if (str2 == null) {
                str2 = "";
            }
            try {
                jSONObject.put(str, str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
                LogEx.e("TvReminderManager", "JSONException");
            }
        }
    }

    private String a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return "";
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
            LogEx.e("TvReminderManager", "JSONException");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        JSONArray jSONArray = new JSONArray();
        List<PrevueBean> list = f5211d;
        if (list != null) {
            for (PrevueBean prevueBean : list) {
                JSONObject jSONObject = new JSONObject();
                a(jSONObject, "prevuecode", prevueBean.getPrevuecode());
                a(jSONObject, "channelcode", prevueBean.getChannelcode());
                a(jSONObject, "channelname", prevueBean.getChannelname());
                a(jSONObject, "begintime", prevueBean.getBegintime());
                a(jSONObject, "endtime", prevueBean.getEndtime());
                a(jSONObject, "prevuename", prevueBean.getPrevuename());
                a(jSONObject, ParamConst.NPVR_QUERY_RSP_DURATION, prevueBean.getDuration());
                a(jSONObject, "columncode", prevueBean.getColumncode());
                jSONArray.put(jSONObject);
            }
        }
        e.putString("tv_reminder", jSONArray.toString());
        e.putString(Constants.SINA_WEIBO_USERNAME, f.V());
    }
}
