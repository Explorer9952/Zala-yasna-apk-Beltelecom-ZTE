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
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import com.video.androidsdk.common.PreferenceHelper;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.sns.Constants;
import com.zte.iptvclient.android.common.Splashscreen;
import com.zte.iptvclient.android.common.e.b0.f;
import com.zte.iptvclient.android.common.function.receiver.VodAlarmReceiver;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class VodReminderManager extends Service {

    /* renamed from: b, reason: collision with root package name */
    private static List<AlarmVideoBean> f5217b = null;

    /* renamed from: c, reason: collision with root package name */
    public static int f5218c = 20;

    /* renamed from: d, reason: collision with root package name */
    public static int f5219d = 10000;
    public static String e = "vod_reminder";
    private static PreferenceHelper f = null;
    public static String g = "reminder_operation_type";
    public static int h = -1;
    public static int i = 1;
    private static h j = null;
    private static int k = 39600000;
    private static int l = 72000000;

    /* renamed from: a, reason: collision with root package name */
    private VodReminderReceiver f5220a;

    /* loaded from: classes.dex */
    public class VodReminderReceiver extends BroadcastReceiver {
        public VodReminderReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AlarmVideoBean alarmVideoBean = (AlarmVideoBean) intent.getSerializableExtra("vod_reminder");
            int intExtra = intent.getIntExtra(VodReminderManager.g, 0);
            if (intExtra == VodReminderManager.h) {
                VodReminderManager.this.b(alarmVideoBean);
                EventBus.getDefault().post(new f());
            } else if (intExtra == VodReminderManager.i) {
                VodReminderManager.this.a(alarmVideoBean);
                EventBus.getDefault().post(new f());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements VodAlarmReceiver.a {
        a() {
        }

        @Override // com.zte.iptvclient.android.common.function.receiver.VodAlarmReceiver.a
        public void a(Context context, Intent intent) {
            if (VodReminderManager.f5217b == null || VodReminderManager.f5217b.size() == 0) {
                return;
            }
            LogEx.d("VodReminderManager", "mReminderDataList.size=" + VodReminderManager.f5217b.size());
            VodReminderManager.this.d((AlarmVideoBean) VodReminderManager.f5217b.remove(0));
            VodReminderManager.this.e();
            EventBus.getDefault().post(new f());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Comparator<AlarmVideoBean> {
        b(VodReminderManager vodReminderManager) {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(AlarmVideoBean alarmVideoBean, AlarmVideoBean alarmVideoBean2) {
            String onLineTime = alarmVideoBean.getOnLineTime();
            String onLineTime2 = alarmVideoBean2.getOnLineTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                return simpleDateFormat.parse(onLineTime).compareTo(simpleDateFormat.parse(onLineTime2));
            } catch (ParseException e) {
                e.printStackTrace();
                LogEx.e("VodReminderManager", "TimeFormate Exception");
                return 0;
            }
        }
    }

    public static List<AlarmVideoBean> b() {
        return f5217b;
    }

    private void c() {
        String string = f.getString(Constants.SINA_WEIBO_USERNAME, "");
        if (TextUtils.isEmpty(string) || !TextUtils.equals(string, j.V())) {
            return;
        }
        String string2 = f.getString("vod_reminder", "");
        if (TextUtils.isEmpty(string2)) {
            return;
        }
        List<AlarmVideoBean> list = f5217b;
        if (list == null) {
            f5217b = new ArrayList();
        } else {
            list.clear();
        }
        try {
            LogEx.d("VodReminderManager", "cache data vod_reminder : " + string2);
            JSONArray jSONArray = new JSONArray(string2);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject != null) {
                    AlarmVideoBean alarmVideoBean = new AlarmVideoBean();
                    alarmVideoBean.setProgramCode(a(jSONObject, "programCode"));
                    alarmVideoBean.setProgramType(a(jSONObject, "programType"));
                    alarmVideoBean.setOnLineTime(a(jSONObject, "onLineTime"));
                    alarmVideoBean.setProgramName(a(jSONObject, "programName"));
                    alarmVideoBean.setColumnCode(a(jSONObject, "columnCode"));
                    alarmVideoBean.setId(a(jSONObject, "id"));
                    f5217b.add(alarmVideoBean);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogEx.e("VodReminderManager", "JSONException");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(16)
    public void d(AlarmVideoBean alarmVideoBean) {
        LogEx.d("VodReminderManager", "LiveTv_Alert_Interval:" + f5219d);
        long d2 = d();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(d2);
        LogEx.d("VodReminderManager", "server time: day " + calendar.get(5) + " " + calendar.get(11) + ":" + calendar.get(12) + ":" + calendar.get(13));
        boolean a2 = g.a(getApplicationContext(), getApplicationContext().getPackageName());
        StringBuilder sb = new StringBuilder();
        sb.append("is App running :");
        sb.append(a2);
        LogEx.d("VodReminderManager", sb.toString());
        boolean d3 = a2 ? g.d(getApplicationContext()) : true;
        LogEx.d("VodReminderManager", "is background running:" + d3);
        int nextInt = new SecureRandom().nextInt(10000);
        if (!a2) {
            Intent intent = new Intent(this, (Class<?>) Splashscreen.class);
            intent.putExtra("VodAlert_VodAlarmItem", alarmVideoBean);
            intent.putExtra("VodAlert_reminder", true);
            PendingIntent activity = PendingIntent.getActivity(this, nextInt, intent, 268435456);
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            Notification.Builder builder = new Notification.Builder(this);
            builder.setContentTitle(getString(R.string.alert));
            builder.setContentText(String.format(getString(R.string.reminder_live_context), alarmVideoBean.getProgramName()));
            builder.setSmallIcon(R.drawable.ic_launcher);
            builder.setContentIntent(activity);
            builder.setAutoCancel(true);
            builder.setDefaults(-1);
            Notification build = builder.build();
            build.flags |= 16;
            notificationManager.notify(1, build);
            LogEx.d("VodReminderManager", "进程被杀掉");
            return;
        }
        if (d3) {
            Intent intent2 = new Intent(this, (Class<?>) MainActivity.class);
            intent2.putExtra("VodAlert_VodAlarmItem", alarmVideoBean);
            intent2.putExtra("VodAlert_needConfirm", false);
            PendingIntent activity2 = PendingIntent.getActivity(this, nextInt, intent2, 268435456);
            NotificationManager notificationManager2 = (NotificationManager) getSystemService("notification");
            Notification.Builder builder2 = new Notification.Builder(this);
            builder2.setContentTitle(getString(R.string.alert));
            builder2.setContentText(String.format(getString(R.string.reminder_live_context), alarmVideoBean.getProgramName()));
            builder2.setSmallIcon(R.drawable.ic_launcher);
            builder2.setContentIntent(activity2);
            builder2.setAutoCancel(true);
            builder2.setDefaults(-1);
            Notification build2 = builder2.build();
            build2.flags |= 16;
            notificationManager2.notify(1, build2);
            LogEx.d("VodReminderManager", "在后台运行，收到直播提醒消息");
            return;
        }
        Intent intent3 = new Intent(this, (Class<?>) MainActivity.class);
        intent3.putExtra("VodAlert_VodAlarmItem", alarmVideoBean);
        intent3.putExtra("VodAlert_needConfirm", true);
        try {
            PendingIntent.getActivity(this, 0, intent3, 268435456).send();
        } catch (PendingIntent.CanceledException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        List<AlarmVideoBean> list = f5217b;
        if (list == null || list.size() == 0) {
            return;
        }
        try {
            LogEx.d("VodReminderManager", "getNextmReminderDataList.size=" + f5217b.size());
            String onLineTime = f5217b.get(0).getOnLineTime();
            long d2 = d();
            Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(onLineTime);
            int i2 = f5219d;
            long time = (parse.getTime() - d2) - i2;
            LogEx.d("VodReminderManager", "@@@@@@@@@@@NextStartTime=" + parse.getTime() + "，nowTime=" + d2 + "，DEFAULT_ADVANCE_TIME=" + i2 + ",delaytime is " + (time / 1000) + "s");
            if (time < 0) {
                time = 0;
            }
            AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
            PendingIntent broadcast = PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent(getApplicationContext(), (Class<?>) VodAlarmReceiver.class), 0);
            alarmManager.cancel(broadcast);
            alarmManager.set(2, SystemClock.elapsedRealtime() + Long.valueOf(time).intValue(), broadcast);
        } catch (ParseException e2) {
            e2.printStackTrace();
            LogEx.e("VodReminderManager", "ParseException");
        }
    }

    private void f() {
        j = new h(this);
        f5217b = new ArrayList();
        f = new PreferenceHelper(getApplicationContext(), e);
        VodAlarmReceiver.a(new a());
        c();
        g();
        e();
    }

    private void g() {
        List<AlarmVideoBean> list = f5217b;
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (AlarmVideoBean alarmVideoBean : f5217b) {
            try {
                String onLineTime = alarmVideoBean.getOnLineTime();
                long d2 = d();
                Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(onLineTime);
                LogEx.d("VodReminderManager", "delaytime=" + (parse.getTime() - d2));
                if (parse.getTime() - d2 > f5219d - 1000) {
                    arrayList.add(alarmVideoBean);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                LogEx.e("VodReminderManager", "TimeFormate Exception");
            }
        }
        LogEx.d("VodReminderManager", "cacheSize=" + arrayList.size());
        f5217b.clear();
        f5217b.addAll(arrayList);
        Collections.sort(f5217b, new b(this));
    }

    private void h() {
        JSONArray jSONArray = new JSONArray();
        List<AlarmVideoBean> list = f5217b;
        if (list != null) {
            for (AlarmVideoBean alarmVideoBean : list) {
                JSONObject jSONObject = new JSONObject();
                a(jSONObject, "programCode", alarmVideoBean.getProgramCode());
                a(jSONObject, "programType", alarmVideoBean.getProgramType());
                a(jSONObject, "onLineTime", alarmVideoBean.getOnLineTime());
                a(jSONObject, "programName", alarmVideoBean.getProgramName());
                a(jSONObject, "columnCode", alarmVideoBean.getColumnCode());
                a(jSONObject, "id", alarmVideoBean.getId());
                jSONArray.put(jSONObject);
            }
        }
        f.putString("vod_reminder", jSONArray.toString());
        f.putString(Constants.SINA_WEIBO_USERNAME, j.V());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f5220a = new VodReminderReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.vod.remindReceive");
        registerReceiver(this.f5220a, intentFilter);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f5220a);
        List<AlarmVideoBean> list = f5217b;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        f();
        return super.onStartCommand(intent, 1, i3);
    }

    public void b(AlarmVideoBean alarmVideoBean) {
        List<AlarmVideoBean> list;
        if (alarmVideoBean == null || (list = f5217b) == null || list.size() <= 0) {
            return;
        }
        try {
            if (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(alarmVideoBean.getOnLineTime()).getTime() - d() > f5219d) {
                ArrayList arrayList = new ArrayList();
                String id = alarmVideoBean.getId();
                for (int i2 = 0; i2 < f5217b.size(); i2++) {
                    if (!TextUtils.equals(id, f5217b.get(i2).getId())) {
                        arrayList.add(f5217b.get(i2));
                    }
                }
                f5217b.clear();
                f5217b.addAll(arrayList);
                g();
                e();
                h();
            }
        } catch (ParseException e2) {
            e2.printStackTrace();
            LogEx.e("VodReminderManager", "TimeFormate Exception ");
        }
    }

    public void a(AlarmVideoBean alarmVideoBean) {
        if (f5217b == null || alarmVideoBean == null) {
            return;
        }
        String c2 = com.zte.iptvclient.common.uiframe.a.c("VOD_Alert_Max_Num");
        int i2 = f5218c;
        if (!TextUtils.isEmpty(c2)) {
            i2 = Integer.valueOf(c2).intValue() * 2;
        }
        if (f5217b.size() < i2) {
            try {
                long d2 = d();
                String onLineTime = alarmVideoBean.getOnLineTime();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                long time = simpleDateFormat.parse(onLineTime).getTime() + k;
                LogEx.d("VodReminderManager", "beginLiveDate=" + time + " , nowTime=" + d2);
                int i3 = f5219d;
                StringBuilder sb = new StringBuilder();
                sb.append("program start time is ");
                sb.append(time);
                sb.append(",now time is ");
                sb.append(i3);
                sb.append("interval time is ");
                sb.append(i3);
                sb.append(",difftime is ");
                long j2 = time - d2;
                sb.append(j2);
                LogEx.d("VodReminderManager", sb.toString());
                if (j2 > i3) {
                    if (!c(alarmVideoBean)) {
                        alarmVideoBean.setOnLineTime(x.b(time, "yyyy-MM-dd HH:mm:ss"));
                        f5217b.add(alarmVideoBean);
                        AlarmVideoBean alarmVideoBean2 = new AlarmVideoBean();
                        alarmVideoBean2.setProgramCode(alarmVideoBean.getProgramCode());
                        alarmVideoBean2.setProgramName(alarmVideoBean.getProgramName());
                        alarmVideoBean2.setColumnCode(alarmVideoBean.getColumnCode());
                        alarmVideoBean2.setProgramType(alarmVideoBean.getProgramType());
                        alarmVideoBean2.setId(alarmVideoBean.getId());
                        alarmVideoBean2.setOnLineTime(x.b(simpleDateFormat.parse(onLineTime).getTime() + l, "yyyy-MM-dd HH:mm:ss"));
                        f5217b.add(alarmVideoBean2);
                        g();
                        e();
                        h();
                    }
                } else {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.the_program_is_about_to_play);
                }
                return;
            } catch (ParseException e2) {
                e2.printStackTrace();
                LogEx.e("VodReminderManager", "TimeFormate Exception");
                return;
            }
        }
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.reminder_live_context_number);
    }

    private boolean c(AlarmVideoBean alarmVideoBean) {
        if (alarmVideoBean == null) {
            return false;
        }
        String id = alarmVideoBean.getId();
        if (TextUtils.isEmpty(id)) {
            return false;
        }
        Iterator<AlarmVideoBean> it2 = f5217b.iterator();
        while (it2.hasNext()) {
            if (TextUtils.equals(id, it2.next().getId())) {
                return true;
            }
        }
        return false;
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
                LogEx.e("VodReminderManager", "JSONException");
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
            LogEx.e("VodReminderManager", "JSONException");
            return "";
        }
    }

    private static long d() {
        return TimeUtil.getNow().getTime();
    }
}
