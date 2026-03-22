package com.video.androidsdk.common.util;

import com.video.androidsdk.common.ServerDate;
import com.video.androidsdk.log.LogEx;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class TimeUtil {
    public static final int INT_ZONEFLAG_LOCAL = 1;
    public static final int INT_ZONEFLAG_UTC = 0;
    public static final String STR_FORMAT_YMDHMS = "yyyy.mm.dd HH:mm:ss";
    private static final String STR_LOCALE_UTC = "UTC";
    private static final String STR_LOG_TAG = "TimeUtil";
    public static final int UNIT_DATE = 5;
    public static final int UNIT_HOUR = 11;
    public static final int UNIT_MILLISECOND = 14;
    public static final int UNIT_MINUTE = 12;
    public static final int UNIT_MONTH = 2;
    public static final int UNIT_SECOND = 13;
    public static final int UNIT_WEEK = 3;
    public static final int UNIT_YEAR = 1;
    static TimeZone mServerTimeZone = TimeZone.getDefault();
    static Locale mLocale = Locale.getDefault();

    private TimeUtil() {
    }

    public static Date addOffset(Date date, int i, int i2) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(i, i2);
        return calendar.getTime();
    }

    public static long calcOffset(Date date, Date date2) throws NullPointerException {
        return date.getTime() - date2.getTime();
    }

    public static int compare(Date date, Date date2) {
        if (date == null) {
            return -2;
        }
        if (date2 == null) {
            return 2;
        }
        return date.compareTo(date2);
    }

    public static String format(Date date, String str) {
        if (date == null || StringUtil.isEmptyString(str)) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, mLocale);
        simpleDateFormat.setTimeZone(mServerTimeZone);
        return simpleDateFormat.format(date);
    }

    public static String formatUTC(Date date, String str) {
        if (date == null || StringUtil.isEmptyString(str)) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, mLocale);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(STR_LOCALE_UTC));
        return simpleDateFormat.format(date);
    }

    public static Date getDate(String str, String str2, int i) {
        if (StringUtil.isEmptyString(str) || StringUtil.isEmptyString(str2)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, mLocale);
        if (i == 0) {
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(STR_LOCALE_UTC));
        } else if (i == 1) {
            simpleDateFormat.setTimeZone(mServerTimeZone);
        }
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e) {
            LogEx.d(STR_LOG_TAG, str + " parse error! Format:" + str2 + " " + e.getMessage());
            return null;
        }
    }

    public static Date getNow() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(mServerTimeZone);
        calendar.setTime(ServerDate.getEpgTime());
        return calendar.getTime();
    }

    public static TimeZone getServerTimeZone() {
        return mServerTimeZone;
    }

    public static Date getSysTime() {
        return Calendar.getInstance().getTime();
    }

    public static void setDSTRules(int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        try {
            mServerTimeZone = new SimpleTimeZone(i, str, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        } catch (Exception unused) {
            LogEx.w(STR_LOG_TAG, "If the month, day, dayOfWeek, or time parameters are out of range for the start or end rule. [" + i + "," + str + "," + i2 + "," + i3 + "," + i4 + "," + i5 + "," + i6 + "," + i7 + "," + i8 + "," + i8 + "," + i8 + "]");
            try {
                int abs = Math.abs(i) / 3600000;
                int abs2 = (Math.abs(i) - (3600000 * abs)) / 60000;
                StringBuilder sb = new StringBuilder();
                sb.append("GMT");
                sb.append(i > 0 ? "+" : "-");
                sb.append(abs);
                sb.append(":");
                sb.append(abs2);
                mServerTimeZone = TimeZone.getTimeZone(sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
                if (!StringUtil.isEmptyString(str)) {
                    try {
                        mServerTimeZone = TimeZone.getTimeZone(str);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        mServerTimeZone = TimeZone.getDefault();
                    }
                } else {
                    mServerTimeZone = TimeZone.getDefault();
                }
            }
        }
        LogEx.d(STR_LOG_TAG, "Server TimeZone:" + mServerTimeZone.toString());
    }

    public static void setLanguage(String str) {
        if (str != null) {
            for (String str2 : Locale.getISOLanguages()) {
                if (str2.equals(str)) {
                    mLocale = new Locale(str);
                    return;
                }
            }
        }
        LogEx.w(STR_LOG_TAG, "Parameter[language] not valid!" + str);
    }

    public static Date stringToDate(String str, String str2) {
        if (str == null || str.trim().length() == 0) {
            return null;
        }
        if (str2 == null || str2.trim().length() == 0) {
            str2 = STR_FORMAT_YMDHMS;
        }
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
