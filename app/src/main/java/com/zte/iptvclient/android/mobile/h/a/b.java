package com.zte.iptvclient.android.mobile.h.a;

import android.text.TextUtils;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;

/* compiled from: URI4DLNAManager.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static String f6360a = "URI4DLNAManager";

    public static String a(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!StringUtil.isEmptyString(str) && !StringUtil.isEmptyString(str2) && !StringUtil.isEmptyString(str3) && !StringUtil.isEmptyString(str4) && !StringUtil.isEmptyString(str5)) {
            String d2 = com.zte.iptvclient.common.uiframe.a.d("UserID");
            String d3 = com.zte.iptvclient.common.uiframe.a.d("FatherUserID");
            if (d3 == null) {
                d3 = "";
            }
            String str7 = d2 != null ? d2 : "";
            d3.equals(str7);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("pushtype=2");
            stringBuffer.append("&columnid=" + str);
            stringBuffer.append("&programid=" + str2);
            stringBuffer.append("&programtype=1");
            stringBuffer.append("&fatheruserid=" + str7);
            stringBuffer.append("&userid=" + str7);
            stringBuffer.append("&telecomcode=" + str6);
            stringBuffer.append("&breakpoint=");
            LogEx.d(f6360a, "getURI4DLNA URI = " + stringBuffer.toString());
            return stringBuffer.toString();
        }
        LogEx.w("getSeriesVodURI4DLNA", "request info is null");
        return "";
    }

    public static String b(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!StringUtil.isEmptyString(str) && !StringUtil.isEmptyString(str2) && !StringUtil.isEmptyString(str3) && !StringUtil.isEmptyString(str4) && !StringUtil.isEmptyString(str5)) {
            String d2 = com.zte.iptvclient.common.uiframe.a.d("UserID");
            String d3 = com.zte.iptvclient.common.uiframe.a.d("FatherUserID");
            if (d3 == null) {
                d3 = "";
            }
            String str7 = d2 != null ? d2 : "";
            d3.equals(str7);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("pushtype=1");
            stringBuffer.append("&columnid=" + str);
            stringBuffer.append("&programid=" + str2);
            stringBuffer.append("&programtype=1");
            stringBuffer.append("&fatheruserid=" + str7);
            stringBuffer.append("&userid=" + str7);
            stringBuffer.append("&telecomcode=" + str6);
            stringBuffer.append("&breakpoint=");
            LogEx.d(f6360a, "getURI4DLNA URI = " + stringBuffer.toString());
            return stringBuffer.toString();
        }
        LogEx.w("getVodURI4DLNA", "request info is null");
        return "";
    }

    public static String a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        if (!StringUtil.isEmptyString(str) && !StringUtil.isEmptyString(str2) && !StringUtil.isEmptyString(str3) && !StringUtil.isEmptyString(str4) && !StringUtil.isEmptyString(str5)) {
            String d2 = com.zte.iptvclient.common.uiframe.a.d("UserID");
            String d3 = com.zte.iptvclient.common.uiframe.a.d("FatherUserID");
            if (d3 == null) {
                d3 = "";
            }
            String str10 = d2 != null ? d2 : "";
            d3.equals(str10);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("pushtype=2");
            stringBuffer.append("&columnid=" + str);
            stringBuffer.append("&programid=" + str2);
            stringBuffer.append("&programtype=1");
            stringBuffer.append("&fatheruserid=" + str10);
            stringBuffer.append("&userid=" + str10);
            stringBuffer.append("&telecomcode=" + str6);
            stringBuffer.append("&seriestelecomcode=" + str7);
            stringBuffer.append("&seriesprogramcode=" + str9);
            stringBuffer.append("&episode=" + str8);
            stringBuffer.append("&breakpoint=");
            LogEx.d(f6360a, "getURI4DLNA URI = " + stringBuffer.toString());
            return stringBuffer.toString();
        }
        LogEx.w("getSeriesVodURI4DLNAExtend", "request info is null");
        return "";
    }

    public static String b(String str, String str2, String str3, String str4) {
        if (str != null && !TextUtils.equals(str, "")) {
            String d2 = com.zte.iptvclient.common.uiframe.a.d("UserID");
            String str5 = d2 != null ? d2 : "";
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("pushtype=0");
            stringBuffer.append("&userid=" + str5);
            stringBuffer.append("&mixno=" + str);
            stringBuffer.append("&telecomcode=" + str2);
            stringBuffer.append("&channelcode=" + str3);
            stringBuffer.append("&columnid =" + str4);
            stringBuffer.append("&breakpoint=");
            return stringBuffer.toString();
        }
        LogEx.w("getTvURI4DLNA", "request info is null");
        return "";
    }

    public static String a(String str, String str2, String str3, String str4, String str5) {
        if (str != null && str2 != null) {
            String d2 = com.zte.iptvclient.common.uiframe.a.d("UserID");
            String str6 = d2 != null ? d2 : "";
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("pushtype=5");
            stringBuffer.append("&userid=" + str6);
            stringBuffer.append("&programid=" + str);
            stringBuffer.append("&channelcode=" + str2);
            stringBuffer.append("&telecomcode=" + str3);
            stringBuffer.append("&begintime=" + str4);
            stringBuffer.append("&endtime=" + str5);
            stringBuffer.append("&breakpoint=");
            return stringBuffer.toString();
        }
        LogEx.w("getTVodURI4DLNA", "request info is null");
        return "";
    }

    public static String a(String str, String str2, String str3, String str4) {
        if (!StringUtil.isEmptyString(str) && !StringUtil.isEmptyString(str2) && !StringUtil.isEmptyString(str3)) {
            String d2 = com.zte.iptvclient.common.uiframe.a.d("UserID");
            String str5 = d2 != null ? d2 : "";
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("pushtype=4");
            stringBuffer.append("&userid=" + str5);
            stringBuffer.append("&columnid=" + str);
            stringBuffer.append("&programid=" + str2);
            stringBuffer.append("&telecomcode=" + str4);
            stringBuffer.append("&programtype=1");
            LogEx.d(f6360a, "getTrailerURL4DLNA URI = " + stringBuffer.toString());
            return stringBuffer.toString();
        }
        LogEx.w("getTrailerURL4DLNA", "request info is null");
        return "";
    }
}
