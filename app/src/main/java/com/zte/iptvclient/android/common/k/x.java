package com.zte.iptvclient.android.common.k;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.tencent.mm.sdk.platformtools.Util;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.TimeShowUtil;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* compiled from: TimeShowUtil.java */
/* loaded from: classes.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4833a = "x";

    public static String a(String str, String str2, String str3) {
        Date date = TimeUtil.getDate(str, str2, 1);
        return date == null ? "" : TimeUtil.formatUTC(date, str3);
    }

    public static String b(String str, String str2, String str3) {
        Date date = TimeUtil.getDate(str, str2, 0);
        return date == null ? "" : TimeUtil.format(date, str3);
    }

    public static String c(String str, String str2, String str3, int i) {
        Date date = TimeUtil.getDate(str, str2, i);
        if (date == null) {
            LogEx.w(f4833a, "date is null ");
            return "";
        }
        if (i == 0) {
            return TimeUtil.formatUTC(date, str3);
        }
        return TimeUtil.format(date, str3);
    }

    public static Date d(String str) {
        try {
            return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").parse(str);
        } catch (Exception e) {
            e.printStackTrace();
            return new Date();
        }
    }

    public static Date e(String str) {
        try {
            return new SimpleDateFormat("yyyyMMddHHmmss").parse(str);
        } catch (Exception e) {
            e.printStackTrace();
            return new Date();
        }
    }

    public static String f(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            return new SimpleDateFormat("yyyyMMddHHmm").format(simpleDateFormat.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String g(String str) {
        String str2 = "";
        try {
            str2 = new SimpleDateFormat("MM.yyyy").format(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(str));
            LogEx.d(f4833a, "time: " + str2);
            return str2;
        } catch (ParseException e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static Date h(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition parsePosition = new ParsePosition(0);
        new Date();
        return simpleDateFormat.parse(str, parsePosition);
    }

    public static Date a(Date date) {
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

    public static int b(String str, String str2, String str3, int i) {
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

    public static Date c(String str, String str2) {
        Date date = new Date();
        if (s.a() != 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
            try {
                long a2 = s.a();
                date = simpleDateFormat.parse(str);
                date.setTime(date.getTime() - a2);
                return date;
            } catch (Exception e) {
                LogEx.d("e=", e.toString());
                return date;
            }
        }
        Date date2 = TimeUtil.getDate(str, str2, 0);
        return date2 == null ? date : date2;
    }

    public static String b(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }

    public static String b(long j, String str) throws ParseException {
        return b(a(j, str), str);
    }

    public static Date a(Date date, int i, long j) {
        if (date == null) {
            LogEx.w(f4833a, "date is null ");
            return null;
        }
        if (14 != i) {
            if (j <= 2147483647L && j >= -2147483648L) {
                return TimeUtil.addOffset(date, i, (int) j);
            }
            LogEx.w(f4833a, "offset out of 32bit,and unit is not millisecond");
            return null;
        }
        int i2 = (int) (j % Util.MILLSECONDS_OF_DAY);
        int i3 = (int) (j / Util.MILLSECONDS_OF_DAY);
        if (Integer.MIN_VALUE != i2 && Integer.MIN_VALUE != i3) {
            return TimeUtil.addOffset(TimeUtil.addOffset(date, 5, i3), 14, i2);
        }
        LogEx.w(f4833a, "offset out of 32bit,and cannot be divite to day");
        return null;
    }

    public static Date b(String str, String str2) throws ParseException {
        return new SimpleDateFormat(str2).parse(str);
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() - str.replace(":", "").length() == 1) {
            return a(str);
        }
        return b(str);
    }

    public static String b(String str) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static int a(String str, String str2, String str3, int i) {
        return b(str, str2, str3, i) / 60;
    }

    public static Date a(String str, String str2) throws ParseException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return new SimpleDateFormat(str2).parse(str);
    }

    public static String a(Locale locale) {
        return new SimpleDateFormat("yyyy-MM-dd", locale).format(TimeUtil.getNow());
    }

    public static String a(String str, Date date) {
        return new SimpleDateFormat(str).format(date);
    }

    public static Date a(String str, SimpleDateFormat simpleDateFormat) {
        try {
            return simpleDateFormat.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
            return new Date();
        }
    }

    public static String a(Date date, String str) {
        return (date == null || TextUtils.isEmpty(str)) ? "" : new SimpleDateFormat(str).format(date);
    }

    public static String a(Context context, String str, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeShowUtil.STR_FORMAT_DATE_MONTH);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        if (str.equals(a(locale))) {
            return com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_today);
        }
        try {
            return simpleDateFormat.format(simpleDateFormat2.parse(str));
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String a(Context context, String str) {
        String a2;
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            switch (calendar.get(7)) {
                case 2:
                    a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.week_monday);
                    break;
                case 3:
                    a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.week_tuesday);
                    break;
                case 4:
                    a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.week_wednesday);
                    break;
                case 5:
                    a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.week_thursday);
                    break;
                case 6:
                    a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.week_friday);
                    break;
                case 7:
                    a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.week_saturday);
                    break;
                default:
                    a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.week_sunday);
                    break;
            }
            return a2;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Date a(long j, String str) throws ParseException {
        return b(b(new Date(j), str), str);
    }

    public static String a(String str) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static int a(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        int i = calendar.get(6);
        int i2 = calendar2.get(6);
        int i3 = calendar.get(1);
        int i4 = calendar2.get(1);
        if (i3 != i4) {
            int i5 = 0;
            while (i3 < i4) {
                i5 = ((i3 % 4 != 0 || i3 % 100 == 0) && i3 % DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS != 0) ? i5 + 365 : i5 + 366;
                i3++;
            }
            return i5 + (i2 - i);
        }
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append("判断day2 - day1 : ");
        int i6 = i2 - i;
        sb.append(i6);
        printStream.println(sb.toString());
        return i6;
    }
}
