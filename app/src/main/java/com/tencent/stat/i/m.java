package com.tencent.stat.i;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.Utility;
import com.google.android.exoplayer2.C;
import com.tencent.mm.sdk.platformtools.Util;
import com.zte.sdk.enumclass.CapablityEnum;
import com.zte.ucs.tvcall.Commons;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static String f2888a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f2889b = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f2890c = null;

    /* renamed from: d, reason: collision with root package name */
    private static Random f2891d = null;
    private static b e = null;
    private static String f = null;
    private static n g = null;
    private static String h = "__MTA_FIRST_ACTIVATE__";
    private static int i = -1;

    public static String A(Context context) {
        String path;
        try {
        } catch (Throwable th) {
            e.c(th);
        }
        if (!a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            e.h("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        }
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState != null && externalStorageState.equals("mounted") && (path = Environment.getExternalStorageDirectory().getPath()) != null) {
            StatFs statFs = new StatFs(path);
            long blockCount = (statFs.getBlockCount() * statFs.getBlockSize()) / C.MICROS_PER_SECOND;
            return String.valueOf((statFs.getAvailableBlocks() * statFs.getBlockSize()) / C.MICROS_PER_SECOND) + "/" + String.valueOf(blockCount);
        }
        return null;
    }

    static String B(Context context) {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String C(Context context) {
        return b(context, a.f2867a);
    }

    public static synchronized Integer D(Context context) {
        int i2;
        synchronized (m.class) {
            i2 = 0;
            try {
                int a2 = q.a(context, "MTA_EVENT_INDEX", 0);
                if (a2 < 2147483646) {
                    i2 = a2;
                }
                q.b(context, "MTA_EVENT_INDEX", i2 + 1);
            } finally {
                return Integer.valueOf(i2 + 1);
            }
        }
        return Integer.valueOf(i2 + 1);
    }

    public static String E(Context context) {
        return String.valueOf(g(context) / C.MICROS_PER_SECOND) + "/" + String.valueOf(i() / C.MICROS_PER_SECOND);
    }

    public static synchronized n F(Context context) {
        n nVar;
        synchronized (m.class) {
            if (g == null) {
                g = new n();
            }
            nVar = g;
        }
        return nVar;
    }

    public static JSONObject G(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            F(context);
            int b2 = n.b();
            if (b2 > 0) {
                jSONObject.put("fx", b2 / 1000000);
            }
            F(context);
            int c2 = n.c();
            if (c2 > 0) {
                jSONObject.put(UserDataStore.FIRST_NAME, c2 / 1000000);
            }
            F(context);
            int a2 = n.a();
            if (a2 > 0) {
                jSONObject.put("n", a2);
            }
            F(context);
            String d2 = n.d();
            if (d2 != null && d2.length() == 0) {
                F(context);
                jSONObject.put("na", n.d());
            }
        } catch (Exception e2) {
            e.a(e2);
        }
        return jSONObject;
    }

    public static int a() {
        return h().nextInt(Integer.MAX_VALUE);
    }

    public static Long a(String str, String str2, int i2, int i3, Long l) {
        if (str != null && str2 != null) {
            if (str2.equalsIgnoreCase(".") || str2.equalsIgnoreCase(CapablityEnum.SPLIT_CODE)) {
                str2 = "\\" + str2;
            }
            String[] split = str.split(str2);
            if (split.length == i3) {
                try {
                    Long l2 = 0L;
                    for (String str3 : split) {
                        l2 = Long.valueOf(i2 * (l2.longValue() + Long.valueOf(str3).longValue()));
                    }
                    return l2;
                } catch (NumberFormatException unused) {
                }
            }
        }
        return l;
    }

    public static String a(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j));
    }

    public static String a(Context context) {
        List<Sensor> sensorList;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < sensorList.size(); i2++) {
                sb.append(sensorList.get(i2).getType());
                if (i2 != sensorList.size() - 1) {
                    sb.append(",");
                }
            }
            return sb.toString();
        } catch (Throwable th) {
            e.c(th);
            return "";
        }
    }

    public static String a(String str) {
        if (str == null) {
            return "0";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                int i2 = b2 & 255;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "0";
        }
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() > 0) {
                    jSONObject.put(str, str2);
                }
            } catch (Throwable th) {
                e.c(th);
            }
        }
    }

    public static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            e.c(th);
            return false;
        }
    }

    public static byte[] a(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
    }

    public static long b(String str) {
        return a(str, ".", 100, 3, 0L).longValue();
    }

    public static WifiInfo b(Context context) {
        WifiManager wifiManager;
        if (!a(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null) {
            return null;
        }
        return wifiManager.getConnectionInfo();
    }

    public static synchronized b b() {
        b bVar;
        synchronized (m.class) {
            if (e == null) {
                b bVar2 = new b("MtaSDK");
                e = bVar2;
                bVar2.a(false);
            }
            bVar = e;
        }
        return bVar;
    }

    public static String b(Context context, String str) {
        if (com.tencent.stat.c.s()) {
            if (f == null) {
                f = B(context);
            }
            if (f != null) {
                return str + "_" + f;
            }
        }
        return str;
    }

    public static long c() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis() + Util.MILLSECONDS_OF_DAY;
        } catch (Throwable th) {
            e.c(th);
            return System.currentTimeMillis() + Util.MILLSECONDS_OF_DAY;
        }
    }

    public static String c(Context context) {
        try {
            WifiInfo b2 = b(context);
            if (b2 != null) {
                return b2.getBSSID();
            }
            return null;
        } catch (Throwable th) {
            e.c(th);
            return null;
        }
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(i.b(g.a(str.getBytes("UTF-8")), 0), "UTF-8");
        } catch (Throwable th) {
            e.c(th);
            return str;
        }
    }

    public static int d() {
        return Build.VERSION.SDK_INT;
    }

    public static String d(Context context) {
        try {
            WifiInfo b2 = b(context);
            if (b2 != null) {
                return b2.getSSID();
            }
            return null;
        } catch (Throwable th) {
            e.c(th);
            return null;
        }
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(g.b(i.a(str.getBytes("UTF-8"), 0)), "UTF-8");
        } catch (Throwable th) {
            e.c(th);
            return str;
        }
    }

    public static synchronized int e(Context context) {
        synchronized (m.class) {
            if (i != -1) {
                return i;
            }
            f(context);
            return i;
        }
    }

    public static String e() {
        long f2 = f() / C.MICROS_PER_SECOND;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return String.valueOf((statFs.getBlockSize() * statFs.getAvailableBlocks()) / C.MICROS_PER_SECOND) + "/" + String.valueOf(f2);
    }

    public static long f() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    public static void f(Context context) {
        int a2 = q.a(context, h, 1);
        i = a2;
        e.c(Integer.valueOf(a2));
        if (i == 1) {
            q.b(context, h, 0);
        }
    }

    private static long g(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    private static synchronized Random h() {
        Random random;
        synchronized (m.class) {
            if (f2891d == null) {
                f2891d = new Random();
            }
            random = f2891d;
        }
        return random;
    }

    public static HttpHost h(Context context) {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        if (context == null) {
            return null;
        }
        try {
        } catch (Throwable th) {
            e.c(th);
        }
        if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0 || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return null;
        }
        if ((activeNetworkInfo.getTypeName() != null && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) || (extraInfo = activeNetworkInfo.getExtraInfo()) == null) {
            return null;
        }
        if (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap") && !extraInfo.equals("uniwap")) {
            if (extraInfo.equals("ctwap")) {
                return new HttpHost("10.0.0.200", 80);
            }
            return null;
        }
        return new HttpHost("10.0.0.172", 80);
    }

    private static long i() {
        long j = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            j = Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() * Util.BYTE_OF_KB;
            bufferedReader.close();
            return j;
        } catch (IOException unused) {
            return j;
        }
    }

    public static synchronized String i(Context context) {
        synchronized (m.class) {
            if (f2888a != null && f2888a.trim().length() != 0) {
                return f2888a;
            }
            String s = s(context);
            f2888a = s;
            if (s == null || s.trim().length() == 0) {
                f2888a = Integer.toString(h().nextInt(Integer.MAX_VALUE));
            }
            return f2888a;
        }
    }

    public static synchronized String j(Context context) {
        String str;
        synchronized (m.class) {
            if (f2890c == null || "" == f2890c) {
                f2890c = m(context);
            }
            str = f2890c;
        }
        return str;
    }

    public static DisplayMetrics k(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static boolean l(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
        } catch (Throwable th) {
            e.c(th);
        }
        if (!a(context, "android.permission.ACCESS_WIFI_STATE")) {
            e.h("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
            for (int i2 = 0; i2 < allNetworkInfo.length; i2++) {
                if (allNetworkInfo[i2].getTypeName().equalsIgnoreCase("WIFI") && allNetworkInfo[i2].isConnected()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String m(Context context) {
        if (!a(context, "android.permission.ACCESS_WIFI_STATE")) {
            e.c("Could not get permission of android.permission.ACCESS_WIFI_STATE");
            return "";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return wifiManager == null ? "" : wifiManager.getConnectionInfo().getMacAddress();
        } catch (Exception e2) {
            e.a(e2);
            return "";
        }
    }

    public static boolean n(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            if (a(context, "android.permission.INTERNET") && a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI");
            }
            e.h("can not get the permisson of android.permission.INTERNET");
        } catch (Throwable th) {
            e.c(th);
        }
        return false;
    }

    public static boolean o(Context context) {
        try {
            if (a(context, "android.permission.INTERNET") && a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                        return true;
                    }
                    e.g("Network error");
                    return false;
                }
            } else {
                e.h("can not get the permisson of android.permission.INTERNET");
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String p(Context context) {
        String str = f2889b;
        if (str != null) {
            return str;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), Commons.MSG_MCSP_INIT_SUCCESS);
            if (applicationInfo == null) {
                return null;
            }
            String string = applicationInfo.metaData.getString("TA_APPKEY");
            if (string != null) {
                f2889b = string;
                return string;
            }
            e.g("Could not read APPKEY meta-data from AndroidManifest.xml");
            return null;
        } catch (Throwable unused) {
            e.g("Could not read APPKEY meta-data from AndroidManifest.xml");
            return null;
        }
    }

    public static String q(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), Commons.MSG_MCSP_INIT_SUCCESS);
            if (applicationInfo == null) {
                return null;
            }
            Object obj = applicationInfo.metaData.get("InstallChannel");
            if (obj != null) {
                return obj.toString();
            }
            e.g("Could not read InstallChannel meta-data from AndroidManifest.xml");
            return null;
        } catch (Throwable unused) {
            e.c("Could not read InstallChannel meta-data from AndroidManifest.xml");
            return null;
        }
    }

    public static String r(Context context) {
        if (context == null) {
            return null;
        }
        return context.getClass().getName();
    }

    public static String s(Context context) {
        try {
            if (!a(context, "android.permission.READ_PHONE_STATE")) {
                e.c("Could not get permission of android.permission.READ_PHONE_STATE");
                return null;
            }
            String deviceId = v(context) ? ((TelephonyManager) context.getSystemService("phone")).getDeviceId() : "";
            if (deviceId != null) {
                return deviceId;
            }
            return null;
        } catch (Throwable th) {
            e.c(th);
            return null;
        }
    }

    public static String t(Context context) {
        TelephonyManager telephonyManager;
        String str = null;
        try {
            if (!a(context, "android.permission.READ_PHONE_STATE")) {
                e.c("Could not get permission of android.permission.READ_PHONE_STATE");
            } else if (v(context) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                str = telephonyManager.getSimOperator();
            }
        } catch (Throwable th) {
            e.c(th);
        }
        return str;
    }

    public static String u(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return str == null ? "" : str;
        } catch (Throwable th) {
            e.c(th);
            return "";
        }
    }

    public static boolean v(Context context) {
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0;
    }

    public static String w(Context context) {
        String str = null;
        try {
        } catch (Throwable th) {
            e.c(th);
        }
        if (a(context, "android.permission.INTERNET") && a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                String typeName = activeNetworkInfo.getTypeName();
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (typeName != null) {
                    if (!typeName.equalsIgnoreCase("WIFI")) {
                        if (typeName.equalsIgnoreCase("MOBILE")) {
                            str = extraInfo != null ? extraInfo : "MOBILE";
                        } else {
                            if (extraInfo == null) {
                                str = typeName;
                            }
                        }
                        e.c(th);
                        return str;
                    }
                    str = "WIFI";
                }
            }
        } else {
            e.c("can not get the permission of android.permission.ACCESS_WIFI_STATE");
        }
        return str;
    }

    public static Integer x(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String y(Context context) {
        String str = "";
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            e.c(th);
        }
        return str != null ? str.length() == 0 ? "unknown" : str : "unknown";
    }

    public static int z(Context context) {
        try {
            return p.a() ? 1 : 0;
        } catch (Throwable th) {
            e.c(th);
            return 0;
        }
    }
}
