package com.zte.servicesdk.util;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.Util;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.log.LogEx;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class TimeShowUtil {
    public static final int INT_MILLISECOND_A_DAY = 86400000;
    public static final String STR_FORMAT_DATE = "yyyy.MM.dd";
    public static final String STR_FORMAT_DATE2 = "dd/MM/yyyy";
    public static final String STR_FORMAT_DATE_BEGIN = "dd.MM.yyyy";
    public static final String STR_FORMAT_DATE_DMY = "M/d/yy";
    public static final String STR_FORMAT_DATE_EDEM = "EEE, MMM d";
    public static final String STR_FORMAT_DATE_EDEM2 = "EEE,MMM.d";
    public static final String STR_FORMAT_DATE_EDM = "EEE M/d";
    public static final String STR_FORMAT_DATE_MDY = "M/d/yyyy";
    public static final String STR_FORMAT_DATE_MONTH = "dd.MM";
    public static final String STR_FORMAT_DATE_RECORD_TIME = "yyyyMMddHHmmss";
    public static final String STR_FORMAT_DATE_TIME = "yyyy.MM.dd HH:mm:ss";
    public static final String STR_FORMAT_HOUR_MINUTE = "HH:mm";
    public static final String STR_FORMAT_HOUR_MINUTE_AMPM = "h:mma";
    public static final String STR_FORMAT_HOUR_MINUTE_AMPM_EX = "h:mm a";
    public static final String STR_FORMAT_HOUR_MINUTE_AMPM_EX2 = "hh:mm a";
    public static final String STR_FORMAT_HOUR_MINUTE_AMPM_EX3 = "hh:mma";
    public static final String STR_FORMAT_MONTH_DATE = "MM.dd";
    public static final String STR_FORMAT_MONTH_DAY = "MMM d";
    public static final String STR_FORMAT_MONTH_DAY2 = "MMM.d";
    public static final String STR_FORMAT_YEAR_MOUTH = "yyyy.MM";
    public static final String STR_FORMAT_YEAR_MOUTH_DAY = "yyyyMMdd";
    private static final String STR_LOG_TAG = "TimeShowUtil";
    public static final String STR_VOD_DURATION_TIME_FORMATE = "HH:mm:ss";
    public static final String TODAY = "Today";
    static int mDstEndDayOfWeek;
    static int mDstEndMonth;
    static int mDstEndTime;
    static int mDstEndWeek;
    static int mDstSavings;
    static int mDstStartDayOfWeek;
    static int mDstStartMonth;
    static int mDstStartTime;
    static int mDstStartWeek;
    private static String[] mMonth = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    static String mZoneID;
    static int mZoneOffset;

    /* loaded from: classes2.dex */
    public static class ConfigSummerTime {
        public int miHour;
        public int miMonth;
        public int miWeekDay;
        public int miWhichWeek;
    }

    public static Date addOffset(Date date, int i, long j) {
        if (date == null) {
            LogEx.w(STR_LOG_TAG, "date is null ");
            return null;
        }
        if (14 != i) {
            if (j <= 2147483647L && j >= -2147483648L) {
                return TimeUtil.addOffset(date, i, (int) j);
            }
            LogEx.w(STR_LOG_TAG, "offset out of 32bit,and unit is not millisecond");
            return null;
        }
        int i2 = (int) (j % Util.MILLSECONDS_OF_DAY);
        int i3 = (int) (j / Util.MILLSECONDS_OF_DAY);
        if (Integer.MIN_VALUE != i2 && Integer.MIN_VALUE != i3) {
            return TimeUtil.addOffset(TimeUtil.addOffset(date, 5, i3), 14, i2);
        }
        LogEx.w(STR_LOG_TAG, "offset out of 32bit,and cannot be divite to day");
        return null;
    }

    public static String getDuration(String str, String str2) {
        if (StringUtil.isEmptyString(str)) {
            return "";
        }
        if (StringUtil.isEmptyString(str2)) {
            try {
                int round = Math.round(Float.parseFloat(str));
                if (round >= 0.0d) {
                    r2 = (round % 60 > 29 ? 1 : 0) + (round / 60);
                }
                return String.valueOf(r2);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        if (!STR_VOD_DURATION_TIME_FORMATE.equals(str2)) {
            return "";
        }
        try {
            String substring = str.substring(0, 2);
            String substring2 = str.substring(3, 5);
            String substring3 = str.substring(6, 8);
            if (substring != null && substring2 != null && substring3 != null) {
                int parseInt = Integer.parseInt(substring3);
                int parseInt2 = Integer.parseInt(substring);
                int parseInt3 = Integer.parseInt(substring2);
                if (30 <= parseInt) {
                    parseInt3++;
                }
                return String.valueOf((parseInt2 * 60) + parseInt3);
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static Date getEndTime(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeUtil.getServerTimeZone());
        calendar.setTime(date);
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar.getTime();
    }

    public static String getResumeTimeFormate(String str, String str2) {
        if (StringUtil.isEmptyString(str) || !STR_VOD_DURATION_TIME_FORMATE.equals(str2)) {
            return "";
        }
        try {
            int parseInt = Integer.parseInt(str) / 3600;
            int parseInt2 = (Integer.parseInt(str) % 3600) / 60;
            int parseInt3 = Integer.parseInt(str) % 60;
            String valueOf = String.valueOf(parseInt);
            String valueOf2 = String.valueOf(parseInt2);
            String valueOf3 = String.valueOf(parseInt3);
            if (parseInt < 10) {
                valueOf = "0" + valueOf;
            }
            if (parseInt2 < 10) {
                valueOf2 = "0" + valueOf2;
            }
            if (parseInt3 < 10) {
                valueOf3 = "0" + valueOf3;
            }
            return valueOf + ":" + valueOf2 + ":" + valueOf3;
        } catch (Exception unused) {
            return "";
        }
    }

    public static Date getStartTime(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeUtil.getServerTimeZone());
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static String getTimeAMPM(String str, String str2, int i) {
        if (StringUtil.isEmptyString(str)) {
            LogEx.w(STR_LOG_TAG, "date is null ");
            return "";
        }
        return transformTimeFormat(str, str2, STR_FORMAT_HOUR_MINUTE_AMPM, i);
    }

    public static String getTimeAMPMOld(String str, String str2, int i) {
        if (StringUtil.isEmptyString(str)) {
            LogEx.w(STR_LOG_TAG, "date is null ");
            return "";
        }
        String transformTimeFormat = transformTimeFormat(str, str2, "yyyy.MM.dd HH:mm:ss", i);
        if (StringUtil.isEmptyString(transformTimeFormat)) {
            LogEx.w(STR_LOG_TAG, "transform failed ");
            return "";
        }
        try {
            String substring = transformTimeFormat.substring(11, 16);
            String substring2 = substring.substring(0, 2);
            String substring3 = substring.substring(2, 5);
            if (!StringUtil.isEmptyString(substring) && !StringUtil.isEmptyString(substring2) && !StringUtil.isEmptyString(substring3)) {
                int parseInt = Integer.parseInt(substring2);
                if (parseInt > 12) {
                    return (parseInt - 12) + substring3 + "PM";
                }
                if (parseInt == 12) {
                    return parseInt + substring3 + "PM";
                }
                if (parseInt == 0) {
                    return "12" + substring3 + "AM";
                }
                return parseInt + substring3 + "AM";
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static String getTimeDate(String str, String str2, String str3, Boolean bool, int i) {
        if (!StringUtil.isEmptyString(str)) {
            return (bool.booleanValue() && TimeUtil.compare(getStartTime(TimeUtil.getNow()), getStartTime(TimeUtil.getDate(str, str2, i))) == 0) ? TODAY : transformTimeFormat(str, str2, str3, i);
        }
        LogEx.w(STR_LOG_TAG, "date is null ");
        return "";
    }

    public static String getTimeDateOld(String str, String str2, String str3, Boolean bool, int i) {
        String substring;
        int parseInt;
        int parseInt2;
        String formatUTC;
        String str4;
        String str5 = "";
        if (StringUtil.isEmptyString(str)) {
            return "";
        }
        if (!"yyyy.MM.dd HH:mm:ss".equals(str2)) {
            str = transformTimeFormat(str, str2, "yyyy.MM.dd HH:mm:ss", i);
        }
        if (StringUtil.isEmptyString(str)) {
            return "";
        }
        if (!STR_FORMAT_DATE_DMY.equals(str3) && !STR_FORMAT_DATE_EDM.equals(str3)) {
            return "";
        }
        if (bool.booleanValue()) {
            if (1 == i) {
                formatUTC = TimeUtil.format(TimeUtil.getNow(), "yyyy.MM.dd HH:mm:ss");
            } else {
                formatUTC = TimeUtil.formatUTC(TimeUtil.getNow(), "yyyy.MM.dd HH:mm:ss");
            }
            String substring2 = formatUTC.substring(0, 10);
            try {
                str4 = str.substring(0, 10);
            } catch (Exception unused) {
                str4 = TODAY;
            }
            if (substring2.trim().equals(str4.trim())) {
                return TODAY;
            }
        }
        try {
            substring = str.substring(2, 4);
            String substring3 = str.substring(5, 7);
            String substring4 = str.substring(8, 10);
            parseInt = Integer.parseInt(substring3);
            parseInt2 = Integer.parseInt(substring4);
        } catch (Exception unused2) {
        }
        if (STR_FORMAT_DATE_DMY.equals(str3)) {
            return parseInt + "/" + parseInt2 + "/" + substring;
        }
        if (STR_FORMAT_DATE_EDM.equals(str3)) {
            try {
                String transformTimeFormat = transformTimeFormat(str, "yyyy.MM.dd HH:mm:ss", STR_FORMAT_DATE_EDM, i);
                if (!StringUtil.isEmptyString(transformTimeFormat)) {
                    str5 = transformTimeFormat.substring(0, 3);
                }
            } catch (Exception unused3) {
            }
            return str5 + " " + parseInt + "/" + parseInt2;
        }
        return "";
    }

    public static int getTimeDiffSeconds(String str, String str2, String str3, int i) {
        if (StringUtil.isEmptyString(str) || StringUtil.isEmptyString(str2) || StringUtil.isEmptyString(str3)) {
            return 0;
        }
        if (i != 1 && i != 0) {
            return 0;
        }
        Date date = TimeUtil.getDate(str, str3, i);
        Date date2 = TimeUtil.getDate(str2, str3, i);
        if (date2 == null || date == null) {
            return 0;
        }
        double time = date2.getTime() - date.getTime();
        Double.isNaN(time);
        return (int) Math.floor(time / 1000.0d);
    }

    public static int getTimeOffset(String str) {
        int intValue;
        if (str != null && !StringUtil.isEmptyString(str)) {
            try {
                int i = 1;
                if (str.charAt(0) == '-') {
                    intValue = Integer.valueOf(str.substring(1)).intValue();
                    i = -1;
                } else {
                    intValue = Integer.valueOf(str).intValue();
                }
                LogEx.d(STR_LOG_TAG, "bFlag=" + i + ",iEPGTimeOffset = " + intValue);
                return i * intValue;
            } catch (Exception unused) {
                LogEx.w(STR_LOG_TAG, "get iEPGTimeOffse Exception,strEPGTimeOffset=" + str);
                return 0;
            }
        }
        LogEx.w(STR_LOG_TAG, "get TimeOffset error,maybe not congfig.");
        return 0;
    }

    public static String getWeekDayWithDate(String str, String str2, String str3, String str4, int i) {
        if (StringUtil.isEmptyString(str)) {
            LogEx.w(STR_LOG_TAG, "date is null ");
            return "";
        }
        if (TimeUtil.compare(getStartTime(TimeUtil.getNow()), getStartTime(TimeUtil.getDate(str, str2, i))) == 0) {
            return "Today," + TimeUtil.format(TimeUtil.getDate(str, str2, i), str4);
        }
        return TimeUtil.format(TimeUtil.getDate(str, str2, i), str3);
    }

    public static String getWeekDayWithDateOld(String str, String str2, int i) {
        String formatUTC;
        String str3;
        String str4 = "";
        if (StringUtil.isEmptyString(str)) {
            return "";
        }
        if (!"yyyy.MM.dd HH:mm:ss".equals(str2)) {
            str = transformTimeFormat(str, str2, "yyyy.MM.dd HH:mm:ss", i);
        }
        if (StringUtil.isEmptyString(str)) {
            return "";
        }
        if (1 == i) {
            formatUTC = TimeUtil.format(TimeUtil.getNow(), "yyyy.MM.dd HH:mm:ss");
        } else {
            formatUTC = TimeUtil.formatUTC(TimeUtil.getNow(), "yyyy.MM.dd HH:mm:ss");
        }
        Boolean bool = false;
        try {
            if (formatUTC.substring(0, 10).trim().equals(str.substring(0, 10).trim())) {
                bool = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String substring = str.substring(5, 7);
            String substring2 = str.substring(8, 10);
            int parseInt = Integer.parseInt(substring);
            int parseInt2 = Integer.parseInt(substring2);
            if (bool.booleanValue()) {
                str3 = TODAY;
            } else {
                try {
                    String transformTimeFormat = transformTimeFormat(str, "yyyy.MM.dd HH:mm:ss", STR_FORMAT_DATE_EDM, i);
                    if (!StringUtil.isEmptyString(transformTimeFormat)) {
                        str3 = transformTimeFormat.substring(0, 3);
                    }
                } catch (Exception unused) {
                }
                str3 = "";
            }
            if (parseInt > 0) {
                String[] strArr = mMonth;
                if (parseInt <= strArr.length) {
                    str4 = strArr[parseInt - 1];
                }
            }
            return str3 + ", " + str4 + " " + parseInt2;
        } catch (Exception unused2) {
            return "";
        }
    }

    public static String getZoneOffset(String str) {
        LogEx.d(STR_LOG_TAG, "strZoneOffset = " + str);
        if (str != null && !StringUtil.isEmptyString(str)) {
            return str;
        }
        LogEx.w(STR_LOG_TAG, "get ZoneOffset error,maybe not congfig.");
        return null;
    }

    public static boolean judgeCurTimeIsToday(String str, String str2, int i) {
        return !StringUtil.isEmptyString(str) && TimeUtil.compare(getStartTime(TimeUtil.getNow()), getStartTime(TimeUtil.getDate(str, str2, i))) == 0;
    }

    public static String local2Utc(String str, String str2, String str3) {
        Date date = TimeUtil.getDate(str, str2, 1);
        return date == null ? "" : TimeUtil.formatUTC(date, str3);
    }

    public static ConfigSummerTime parseSummerRule(String str) {
        if (StringUtil.isEmptyString(str)) {
            LogEx.w(STR_LOG_TAG, "Get strSummerRule error, maybe not congfig.");
            return null;
        }
        LogEx.d(STR_LOG_TAG, "strSummerRule," + str);
        String[] splitString = StringUtil.splitString(str, ",");
        if (splitString.length != 4) {
            LogEx.w(STR_LOG_TAG, "strSummerRule invalid," + str);
            return null;
        }
        ConfigSummerTime configSummerTime = new ConfigSummerTime();
        try {
            configSummerTime.miMonth = Integer.valueOf(splitString[0]).intValue();
            configSummerTime.miWhichWeek = Integer.valueOf(splitString[1]).intValue();
            configSummerTime.miWeekDay = Integer.valueOf(splitString[2]).intValue();
            configSummerTime.miHour = Integer.valueOf(splitString[3]).intValue();
            LogEx.d(STR_LOG_TAG, "miMonth=" + configSummerTime.miMonth + ", miWhichWeek=" + configSummerTime.miWhichWeek + ", miWeekDay=" + configSummerTime.miWeekDay + ", miHour=" + configSummerTime.miHour);
            return configSummerTime;
        } catch (Exception unused) {
            LogEx.w(STR_LOG_TAG, "SummerStartTime invalid," + str);
            return null;
        }
    }

    public static void setInitLocaleLanguage(Context context) {
        String readPropertie = ConfigMgr.readPropertie("LocaleLang");
        LogEx.d(STR_LOG_TAG, "LocaleLanguage = " + readPropertie);
        if (StringUtil.isEmptyString(readPropertie)) {
            return;
        }
        TimeUtil.setLanguage(readPropertie);
    }

    public static void setInitTimeZone(Context context) {
        mZoneOffset = tranZoneOffset(ConfigMgr.readPropertie("ZoneOffset")) * 60 * 1000;
        mZoneID = ConfigMgr.readPropertie("ZoneID", TimeZone.getDefault().getID());
        mDstSavings = Integer.parseInt(ConfigMgr.readPropertie("TimeOffset", "0")) * 60 * 1000;
        ConfigSummerTime parseSummerRule = parseSummerRule(ConfigMgr.readPropertie("SummerStartTime"));
        if (parseSummerRule == null) {
            LogEx.w(STR_LOG_TAG, "get summerStartTime null.");
            return;
        }
        mDstStartMonth = parseSummerRule.miMonth - 1;
        mDstStartWeek = ((parseSummerRule.miWhichWeek - 1) * 7) + 1;
        mDstStartDayOfWeek = -(parseSummerRule.miWeekDay + 1);
        mDstStartTime = parseSummerRule.miHour * 3600000;
        ConfigSummerTime parseSummerRule2 = parseSummerRule(ConfigMgr.readPropertie("SummerEndTime"));
        if (parseSummerRule2 == null) {
            LogEx.w(STR_LOG_TAG, "get summerEndTime null.");
            return;
        }
        int i = parseSummerRule2.miMonth - 1;
        mDstEndMonth = i;
        int i2 = ((parseSummerRule2.miWhichWeek - 1) * 7) + 1;
        mDstEndWeek = i2;
        int i3 = -(parseSummerRule2.miWeekDay + 1);
        mDstEndDayOfWeek = i3;
        int i4 = parseSummerRule2.miHour * 3600000;
        mDstEndTime = i4;
        TimeUtil.setDSTRules(mZoneOffset, mZoneID, mDstStartMonth, mDstStartWeek, mDstStartDayOfWeek, mDstStartTime, i, i2, i3, i4, mDstSavings);
    }

    public static void setLocalTimeZone() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0050, code lost:
    
        if (r11.charAt(3) == '-') goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int tranZoneOffset(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.servicesdk.util.TimeShowUtil.tranZoneOffset(java.lang.String):int");
    }

    public static String transformTimeFormat(String str, String str2, String str3, int i) {
        Date date = TimeUtil.getDate(str, str2, i);
        if (date == null) {
            LogEx.w(STR_LOG_TAG, "date is null ");
            return "";
        }
        if (i == 0) {
            return TimeUtil.formatUTC(date, str3);
        }
        return TimeUtil.format(date, str3);
    }

    public static String utc2Local(String str, String str2, String str3) {
        Date date = TimeUtil.getDate(str, str2, 0);
        return date == null ? "" : TimeUtil.format(date, str3);
    }

    public static String getTimeAMPM(Date date) {
        return date == null ? "" : new SimpleDateFormat(STR_FORMAT_HOUR_MINUTE_AMPM_EX2, Locale.US).format(date);
    }
}
