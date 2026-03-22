package com.video.androidsdk.common;

import com.video.androidsdk.log.LogEx;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class ServerDate {
    private static String TAG = "ServerDate";
    private static long mlEpgTimeOffset;
    private static SimpleDateFormat msdfNormal = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
    private static SimpleDateFormat msdfOther1 = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
    private static Date mdateEPG = null;

    public static Date getEpgTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis() + mlEpgTimeOffset);
        LogEx.d(TAG, "currenttime:" + System.currentTimeMillis());
        LogEx.d(TAG, "offsetTime:" + mlEpgTimeOffset);
        LogEx.d(TAG, "epgtime[LocalZone]:" + calendar.getTime());
        return calendar.getTime();
    }

    public static Date getRealEpgTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        Date date = mdateEPG;
        return date == null ? calendar.getTime() : date;
    }

    public static void setEpgTimeOffset(String str) {
        boolean z;
        LogEx.d(TAG, "epgTime:" + str);
        Date date = null;
        try {
            synchronized (msdfNormal) {
                date = msdfNormal.parse(str.trim());
            }
            mlEpgTimeOffset = date.getTime() - System.currentTimeMillis();
            mdateEPG = date;
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
            LogEx.w(TAG, "epgTime foramt error: " + str);
            z = false;
        }
        if (z) {
            return;
        }
        try {
            synchronized (msdfOther1) {
                date = msdfOther1.parse(str.trim());
            }
            mlEpgTimeOffset = date.getTime() - System.currentTimeMillis();
        } catch (Exception e2) {
            e2.printStackTrace();
            LogEx.w(TAG, "epgTime foramt error2: " + str);
        }
        mdateEPG = date;
        LogEx.d(TAG, "offsetTime:" + mlEpgTimeOffset);
    }
}
