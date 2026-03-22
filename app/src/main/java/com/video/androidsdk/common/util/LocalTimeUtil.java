package com.video.androidsdk.common.util;

import com.video.androidsdk.log.LogEx;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* loaded from: classes.dex */
public final class LocalTimeUtil {
    public static final String STR_FORMAT_DATA_BEGIN = "dd.MM.yyyy";
    public static final String STR_FORMAT_DATE = "yyyy.MM.dd";
    public static final String STR_FORMAT_DATE_TIME = "yyyy.MM.dd HH:mm:ss";
    public static final String STR_FORMAT_HOUR_MINUTE = "HH:mm";

    private LocalTimeUtil() {
    }

    public static String calFormatTimeFromSecond(int i) {
        return i < 0 ? "0" : String.format("%02d:%02d:%02d", Integer.valueOf(i / 3600), Integer.valueOf((i % 3600) / 60), Integer.valueOf(i % 60));
    }

    public static String calHourFromSecond(int i) {
        return i < 0 ? "0" : String.format("%2d:%02d", Integer.valueOf(i / 3600), Integer.valueOf((i % 3600) / 60));
    }

    public static String calHourMinuteSecondFromSecond(int i) {
        if (i < 0) {
            return "0";
        }
        int i2 = i / 3600;
        int i3 = (i % 3600) / 60;
        return String.format("%02d:%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((i - ((i2 * 60) * 60)) - (i3 * 60)));
    }

    public static String calMinuteFromSecond(String str) {
        float f;
        int i;
        if (str == null) {
            return null;
        }
        try {
            f = Float.parseFloat(str);
            i = (int) f;
        } catch (Exception e) {
            e.printStackTrace();
            f = 0.0f;
            i = 0;
        }
        int i2 = i / 60;
        if (f < 0.0f) {
            return null;
        }
        return i2 < 10 ? String.format("%2d'", Integer.valueOf(i2)) : String.format("%02d'", Integer.valueOf(i2));
    }

    public static boolean checkTimeFormatType(String str, String str2) {
        if (!StringUtil.isEmptyString(str) && !StringUtil.isEmptyString(str2)) {
            try {
                new SimpleDateFormat(str2).parse(str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static String getDateAfterCurDay(String str, int i) {
        if (StringUtil.isEmptyString(str)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, i);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static Date getDateByStrDate(String str, String str2) throws ParseException {
        if (StringUtil.isEmptyString(str) || StringUtil.isEmptyString(str2) || !checkTimeFormatType(str, str2)) {
            return null;
        }
        return new SimpleDateFormat(str2).parse(str);
    }

    public static String getEpgTimePoint(Date date) {
        if (date == null) {
            return null;
        }
        return date.getMinutes() < 30 ? String.format("%02d:%02d", Integer.valueOf(date.getHours()), 0) : String.format("%02d:%02d", Integer.valueOf(date.getHours()), 30);
    }

    public static String getFormattedLocalTimeStr(String str) {
        if (StringUtil.isEmptyString(str)) {
            return null;
        }
        TimeData localTime = getLocalTime();
        Calendar calendar = Calendar.getInstance();
        calendar.set(localTime.getYear(), localTime.getMonth(), localTime.getDay(), localTime.getHour(), localTime.getMinute(), localTime.getSecond());
        return new StringBuffer(new SimpleDateFormat(str).format(calendar.getTime())).toString();
    }

    public static String getFormattedLocalTodayMaxTimeStr() {
        return getFormattedLocalTodayMaxTimeStr("yyyy.MM.dd HH:mm:ss");
    }

    public static String getFormattedLocalTodayMinTimeStr() {
        return getFormattedLocalTodayMinTimeStr("yyyy.MM.dd HH:mm:ss");
    }

    public static TimeData getLocalTime() {
        Calendar calendar = Calendar.getInstance();
        return new TimeData(calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(11), calendar.get(12), calendar.get(13), calendar.get(14));
    }

    public static int getMinuteNumber(String str) {
        int secondNumber;
        if (StringUtil.isEmptyString(str) || -2 == (secondNumber = getSecondNumber(str))) {
            return -1;
        }
        return secondNumber / 60;
    }

    public static int getMinuteNumberAddSecond(String str) {
        if (StringUtil.isEmptyString(str) || -2 == getSecondNumber(str)) {
            return -1;
        }
        int secondNumber = getSecondNumber(str) / 60;
        return getSecondNumber(str) % 60 > 0 ? secondNumber + 1 : secondNumber;
    }

    public static String getNearestTimePoint() {
        TimeData localTime = getLocalTime();
        return localTime.getMinute() < 30 ? String.format("%02d:%02d", Integer.valueOf(localTime.getHour()), 0) : String.format("%02d:%02d", Integer.valueOf(localTime.getHour()), 30);
    }

    public static int getSecondNumber(String str) {
        if (StringUtil.isEmptyString(str) || !str.matches("(^[0-9]{1,2}\\:[0-5][0-9]\\:[0-9]{1,2}$)")) {
            return -2;
        }
        String[] split = str.split(":");
        return (Integer.parseInt(split[0]) * 3600) + (Integer.parseInt(split[1]) * 60) + Integer.parseInt(split[2]);
    }

    public static int getTimeDiffMinute(String str, String str2, String str3) {
        return getTimeDiffSeconds(str, str2, str3) / 60;
    }

    public static int getTimeDiffSeconds(String str, String str2, String str3) {
        if (!StringUtil.isEmptyString(str) && !StringUtil.isEmptyString(str2) && !StringUtil.isEmptyString(str3) && checkTimeFormatType(str, str3) && checkTimeFormatType(str2, str3)) {
            try {
                Date dateByStrDate = getDateByStrDate(str, str3);
                Date dateByStrDate2 = getDateByStrDate(str2, str3);
                if (dateByStrDate == null || dateByStrDate2 == null) {
                    return 0;
                }
                double time = dateByStrDate2.getTime() - dateByStrDate.getTime();
                Double.isNaN(time);
                return (int) Math.floor(time / 1000.0d);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static String transformTimeFormat(String str, String str2, String str3) {
        if (StringUtil.isEmptyString(str2) || StringUtil.isEmptyString(str3) || StringUtil.isEmptyString(str) || !checkTimeFormatType(str, str2)) {
            return null;
        }
        try {
            Date dateByStrDate = getDateByStrDate(str, str2);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str3);
            if (dateByStrDate != null) {
                return simpleDateFormat.format(dateByStrDate);
            }
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFormattedLocalTodayMaxTimeStr(String str) {
        if (StringUtil.isEmptyString(str)) {
            return null;
        }
        TimeData localTime = getLocalTime();
        Calendar calendar = Calendar.getInstance();
        calendar.set(localTime.getYear(), localTime.getMonth(), localTime.getDay(), 23, 59, 59);
        return new StringBuffer(new SimpleDateFormat(str).format(calendar.getTime())).toString();
    }

    public static String getFormattedLocalTodayMinTimeStr(String str) {
        if (StringUtil.isEmptyString(str)) {
            return null;
        }
        TimeData localTime = getLocalTime();
        Calendar calendar = Calendar.getInstance();
        calendar.set(localTime.getYear(), localTime.getMonth(), localTime.getDay(), 0, 0, 0);
        return new StringBuffer(new SimpleDateFormat(str).format(calendar.getTime())).toString();
    }

    /* loaded from: classes.dex */
    public static class TimeData {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int m_iDay;
        private int m_iHour;
        private int m_iMilliSecond;
        private int m_iMinute;
        private int m_iMonth;
        private int m_iSecond;
        private int m_iYear;

        public TimeData() {
            this.m_iHour = 0;
            this.m_iMinute = 0;
        }

        public int getDay() {
            return this.m_iDay;
        }

        public int getHour() {
            return this.m_iHour;
        }

        public int getMilliSecond() {
            return this.m_iMilliSecond;
        }

        public int getMinute() {
            return this.m_iMinute;
        }

        public int getMonth() {
            return this.m_iMonth;
        }

        public int getSecond() {
            return this.m_iSecond;
        }

        public int getYear() {
            return this.m_iYear;
        }

        public void setDay(int i) throws AssertionError {
            this.m_iDay = i;
        }

        public void setHour(int i) throws AssertionError {
            this.m_iHour = i;
        }

        public void setMilliSecond(int i) throws AssertionError {
            this.m_iMilliSecond = i;
        }

        public void setMinute(int i) throws AssertionError {
            this.m_iMinute = i;
        }

        public void setMonth(int i) throws AssertionError {
            this.m_iMonth = i;
        }

        public void setSecond(int i) throws AssertionError {
            this.m_iSecond = i;
        }

        public void setYear(int i) throws AssertionError {
            this.m_iYear = i;
        }

        public TimeData(int i, int i2) {
            this.m_iHour = i;
            this.m_iMinute = i2;
        }

        public TimeData(int i, int i2, int i3, int i4, int i5, int i6) {
            this.m_iMinute = i5;
            this.m_iHour = i4;
            this.m_iDay = i3;
            this.m_iMonth = i2;
            this.m_iYear = i;
            this.m_iSecond = i6;
        }

        public TimeData(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.m_iMinute = i5;
            this.m_iHour = i4;
            this.m_iDay = i3;
            this.m_iMonth = i2;
            this.m_iYear = i;
            this.m_iSecond = i6;
            this.m_iMilliSecond = i7;
        }
    }

    public static String getDateAfterCurDay(String str, String str2, int i) {
        if (!StringUtil.isEmptyString(str) && !StringUtil.isEmptyString(str2)) {
            if (!checkTimeFormatType(str2, str)) {
                LogEx.d("common TimeUtil", "strFormat or strDate is not same FormatType");
                return null;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
            try {
                Date dateByStrDate = getDateByStrDate(str2, str);
                if (dateByStrDate == null) {
                    LogEx.d("common TimeUtil", "date = null");
                    return null;
                }
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.setTime(dateByStrDate);
                gregorianCalendar.add(5, i);
                return simpleDateFormat.format(gregorianCalendar.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
                LogEx.d("common TimeUtil", "getDateByStrDate failed");
                return null;
            }
        }
        LogEx.d("common TimeUtil", "strFormat or strDate is null");
        return null;
    }

    public static String transformTimeFormat(String str, String str2) {
        if (StringUtil.isEmptyString(str2) || StringUtil.isEmptyString(str) || !checkTimeFormatType(str, "yyyy.MM.dd HH:mm:ss")) {
            return null;
        }
        try {
            Date dateByStrDate = getDateByStrDate(str, "yyyy.MM.dd HH:mm:ss");
            return dateByStrDate != null ? new SimpleDateFormat(str2).format(dateByStrDate) : "";
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFormattedLocalTimeStr() {
        return getFormattedLocalTimeStr("yyyy-MM-dd HH:mm:ss.SS");
    }

    public static String transformTimeFormat(Date date, String str) {
        if (StringUtil.isEmptyString(str) || date == null) {
            return null;
        }
        return new SimpleDateFormat(str).format(date);
    }
}
