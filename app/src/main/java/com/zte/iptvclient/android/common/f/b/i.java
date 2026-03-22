package com.zte.iptvclient.android.common.f.b;

import android.text.TextUtils;
import com.video.androidsdk.login.SDKLoginMgr;
import com.zte.iptvclient.android.common.k.o;

/* compiled from: IPTVLoginMgr.java */
/* loaded from: classes.dex */
public class i {
    public static String a() {
        String ePGHome = SDKLoginMgr.getInstance().getEPGHome();
        return ePGHome == null ? "" : ePGHome;
    }

    public static String b() {
        String ePGHome = SDKLoginMgr.getInstance().getEPGHome();
        if (ePGHome == null) {
            ePGHome = "";
        }
        return ePGHome.contains("/iptvepg/") ? ePGHome.replace("/iptvepg/", "") : ePGHome;
    }

    public static String c() {
        String ePGHost = SDKLoginMgr.getInstance().getEPGHost();
        return ePGHost == null ? "" : ePGHost;
    }

    public static String d() {
        String ePGPort = SDKLoginMgr.getInstance().getEPGPort();
        return ePGPort == null ? "" : ePGPort;
    }

    public static String e() {
        String userInfo = SDKLoginMgr.getInstance().getUserInfo(com.zte.iptvclient.android.common.c.c.f4108a);
        return userInfo == null ? "" : userInfo;
    }

    public static String f() {
        String frameHome = SDKLoginMgr.getInstance().getFrameHome();
        return frameHome == null ? "" : frameHome;
    }

    public static String g() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Poster_Update_Mode");
        String b2 = o.j().b();
        if (TextUtils.equals(c2, "1")) {
            return b2;
        }
        if (TextUtils.equals(c2, "2")) {
            return b2 + "/" + c() + ":" + d();
        }
        return b();
    }

    public static String h() {
        return "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID();
    }

    public static String i() {
        String ePGHost = SDKLoginMgr.getInstance().getEPGHost();
        if (!ePGHost.contains("/iptvepg/")) {
            ePGHost = ePGHost + "/iptvepg/";
        }
        return "https://" + ePGHost;
    }
}
