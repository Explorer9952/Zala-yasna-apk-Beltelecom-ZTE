package com.zte.iptvclient.android.common.k;

import android.text.TextUtils;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;

/* compiled from: DashUtil.java */
/* loaded from: classes.dex */
public class i {
    public static String a() {
        if (!c()) {
            return "";
        }
        return "&urlredirect=" + b() + "&NeedJITP=1&JITPMediaType=DASH&JITPDRMType=Widevine";
    }

    private static String b() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("HLS_To_DASH");
        return !"1".equals(c2) ? "0" : c2;
    }

    public static boolean c() {
        return "1".equals(com.zte.iptvclient.common.uiframe.a.c("HLS_To_DASH"));
    }

    public static String a(String str) {
        LogEx.d("DashUtil", "JITP_DRM_INFO_GOOGLE" + com.zte.iptvclient.common.uiframe.a.c("JITP_DRM_INFO_GOOGLE"));
        if (!DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT.equals(com.zte.iptvclient.common.uiframe.a.c("Android_Player_Type")) || str.contains(".mpd") || TextUtils.isEmpty("&NeedJITP=1&JITPMediaType=DASH&JITPDRMType=Widevine")) {
            return str;
        }
        return str + "&NeedJITP=1&JITPMediaType=DASH&JITPDRMType=Widevine";
    }

    public static String a(String str, String str2) {
        LogEx.d("DashUtil", "JITP_DRM_INFO_GOOGLE" + com.zte.iptvclient.common.uiframe.a.c("JITP_DRM_INFO_GOOGLE"));
        String c2 = com.zte.iptvclient.common.uiframe.a.c("JITP_DRM_INFO_GOOGLE");
        if (DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT.equals(com.zte.iptvclient.common.uiframe.a.c("Android_Player_Type")) && !str.contains(".mpd") && !TextUtils.isEmpty(c2)) {
            if (!c2.startsWith("&")) {
                c2 = "&" + c2;
            }
            if (c2.contains("JITPDRMType=NO")) {
                str = str + c2;
            } else {
                str = str + c2 + "-" + str2;
            }
            LogEx.d("DashUtil", "getDashRedirectUrl= " + str);
        }
        return str;
    }
}
