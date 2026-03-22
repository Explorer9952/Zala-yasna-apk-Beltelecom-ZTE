package com.zte.iptvclient.android.common.k;

import android.text.TextUtils;
import com.video.androidsdk.common.http.HttpConstant;
import com.zte.servicesdk.util.PortalConst;
import java.net.URLDecoder;

/* compiled from: PortalUtil.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private static o f4820a;

    public static o j() {
        if (f4820a == null) {
            f4820a = new o();
        }
        return f4820a;
    }

    public String a() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_ADVERTISE_SERVER);
        if (TextUtils.isEmpty(c2) || c2.contains(HttpConstant.PROTOCOL_HTTP)) {
            return c2;
        }
        return "http://" + c2;
    }

    public String b() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Poster_Update_CDN_Cache_Service");
        if (TextUtils.isEmpty(c2) || c2.contains(HttpConstant.PROTOCOL_HTTP)) {
            return c2;
        }
        return "http://" + c2;
    }

    public String c() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("IMP_Server");
        if (TextUtils.isEmpty(c2) || c2.contains(HttpConstant.PROTOCOL_HTTP)) {
            return c2;
        }
        return "http://" + c2;
    }

    public String d() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Log_Server_Address");
        if (TextUtils.isEmpty(c2) || c2.contains(HttpConstant.PROTOCOL_HTTP)) {
            return c2;
        }
        return "http://" + c2;
    }

    public String e() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_MES_SERVER_DOMAIN);
        if (TextUtils.isEmpty(c2) || c2.contains(HttpConstant.PROTOCOL_HTTP)) {
            return c2;
        }
        return "http://" + c2;
    }

    public String f() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Recommend_Server");
        if (TextUtils.isEmpty(c2) || c2.contains(HttpConstant.PROTOCOL_HTTP)) {
            return c2;
        }
        return "http://" + c2;
    }

    public String g() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_SEARCH_SERVER);
        if (TextUtils.isEmpty(c2) || c2.contains(HttpConstant.PROTOCOL_HTTP)) {
            return c2;
        }
        return "http://" + c2;
    }

    public String h() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_THUMBNAILS_SERVER);
        if (TextUtils.isEmpty(c2) || c2.contains(HttpConstant.PROTOCOL_HTTP)) {
            return c2;
        }
        return "http://" + c2;
    }

    public String i() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_UPS_SERVER);
        if (TextUtils.isEmpty(c2) || c2.contains(HttpConstant.PROTOCOL_HTTP)) {
            return c2;
        }
        return "http://" + c2;
    }

    public String a(String str) {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Contact_Number");
        if (TextUtils.isEmpty(c2)) {
            c2 = "";
        }
        return str.replace("123", c2);
    }

    public String b(String str) {
        String c2 = com.zte.iptvclient.common.uiframe.a.c(str);
        return (c2 == null || TextUtils.isEmpty(c2)) ? "" : (str.endsWith("_be") || str.endsWith("_ru")) ? URLDecoder.decode(com.zte.iptvclient.common.uiframe.a.c(str)) : c2;
    }
}
