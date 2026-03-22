package com.zte.iptvclient.android.common.k;

import com.video.androidsdk.log.LogEx;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: BlackoutTimeUtils.java */
/* loaded from: classes.dex */
public class d {
    static {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static String a(String str) {
        try {
            return new SimpleDateFormat(str).format(s.c());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Date b(String str) {
        String substring = str.substring(0, 4);
        String substring2 = str.substring(4, 6);
        String substring3 = str.substring(6, 8);
        String substring4 = str.substring(8, 10);
        String substring5 = str.substring(10, 12);
        String substring6 = str.substring(12, 14);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String str2 = substring + "-" + substring2 + "-" + substring3 + " " + substring4 + ":" + substring5 + ":" + substring6;
        LogEx.d("BlackoutTimeUtils", "time=" + str2);
        Date date = new Date();
        try {
            Date parse = simpleDateFormat.parse(str2);
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
            String format = simpleDateFormat.format(Long.valueOf(parse.getTime()));
            LogEx.d("BlackoutTimeUtils", "localTime=" + format);
            return simpleDateFormat.parse(format);
        } catch (ParseException e) {
            LogEx.d("BlackoutTimeUtils", "timeString format err");
            e.printStackTrace();
            return date;
        }
    }

    public static Date c(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        Date date = new Date();
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e) {
            LogEx.d("BlackoutTimeUtils", "timeString format err");
            e.printStackTrace();
            return date;
        }
    }
}
