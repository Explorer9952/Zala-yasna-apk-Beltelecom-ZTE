package com.zte.iptvclient.android.mobile.g.b;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* compiled from: DateUtils.java */
/* loaded from: classes.dex */
public class a {
    public static String a(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }

    public static Date b(String str, String str2) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date parse = simpleDateFormat.parse(str);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(parse.getTime())));
    }

    public static Date a(String str, String str2) throws ParseException {
        return new SimpleDateFormat(str2).parse(str);
    }
}
