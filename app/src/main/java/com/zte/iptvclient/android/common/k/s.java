package com.zte.iptvclient.android.common.k;

import android.text.TextUtils;
import com.video.androidsdk.common.ServerDate;
import com.video.androidsdk.log.LogEx;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: ServerDateNew.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private static String f4825a = "s";

    /* renamed from: b, reason: collision with root package name */
    private static long f4826b;

    /* renamed from: c, reason: collision with root package name */
    private static long f4827c;

    /* renamed from: d, reason: collision with root package name */
    private static String f4828d;
    private static String e;
    private static SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);
    private static SimpleDateFormat g = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.ENGLISH);

    public static void a(String str, String str2) {
        f4828d = str;
        e = str2;
        LogEx.d(f4825a, "mstrEpgLocalTime" + f4828d + " mstrEpgUtcTime" + e);
        if (TextUtils.isEmpty(f4828d) || TextUtils.isEmpty(e)) {
            return;
        }
        a(f4828d);
        b(e);
    }

    private static void b(String str) {
        boolean z;
        Date parse;
        Date parse2;
        LogEx.d(f4825a, "serviceBack epg UTCTime:" + str);
        try {
            synchronized (f) {
                parse2 = f.parse(str.trim());
            }
            f4827c = parse2.getTime() - System.currentTimeMillis();
            z = true;
        } catch (Exception e2) {
            e2.printStackTrace();
            LogEx.w(f4825a, "epgUTCTime foramt error: " + str);
            z = false;
        }
        if (z) {
            return;
        }
        try {
            synchronized (g) {
                parse = g.parse(str.trim());
            }
            f4827c = parse.getTime() - System.currentTimeMillis();
        } catch (Exception e3) {
            e3.printStackTrace();
            LogEx.w(f4825a, "epgUTCTime foramt error2: " + str);
        }
        LogEx.d(f4825a, "offUTCsetTime:" + f4827c);
    }

    public static Date c() {
        Date date = new Date();
        date.setTime(System.currentTimeMillis() + f4827c);
        LogEx.d(f4825a, "System currenttime:" + System.currentTimeMillis());
        LogEx.d(f4825a, "utc offsetTime:" + f4827c);
        LogEx.d(f4825a, "new epgUTCtime[Zone]:" + date);
        return date;
    }

    private static void a(String str) {
        boolean z;
        Date parse;
        Date parse2;
        LogEx.d(f4825a, "serviceBack epg localTime:" + str);
        try {
            synchronized (f) {
                parse2 = f.parse(str.trim());
            }
            f4826b = parse2.getTime() - System.currentTimeMillis();
            z = true;
        } catch (Exception e2) {
            e2.printStackTrace();
            LogEx.w(f4825a, "epgTime foramt error: " + str);
            z = false;
        }
        if (z) {
            return;
        }
        try {
            synchronized (g) {
                parse = g.parse(str.trim());
            }
            f4826b = parse.getTime() - System.currentTimeMillis();
        } catch (Exception e3) {
            e3.printStackTrace();
            LogEx.w(f4825a, "epgTime foramt error2: " + str);
        }
        LogEx.d(f4825a, "offsetTime:" + f4826b);
    }

    public static Date b() {
        if (f4826b == 0) {
            return ServerDate.getEpgTime();
        }
        Date date = new Date();
        date.setTime(System.currentTimeMillis() + f4826b);
        LogEx.d(f4825a, "System currenttime:" + System.currentTimeMillis());
        LogEx.d(f4825a, "offsetTime:" + f4826b);
        LogEx.d(f4825a, "new epgtime[LocalZone]:" + date);
        return date;
    }

    public static long a() {
        return f4827c - f4826b;
    }
}
