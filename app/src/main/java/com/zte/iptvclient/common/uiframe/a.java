package com.zte.iptvclient.common.uiframe;

import com.video.androidsdk.login.SDKLoginMgr;

/* compiled from: AccessLocalInfo.java */
/* loaded from: classes2.dex */
public class a {
    public static String c(String str) {
        return SDKLoginMgr.getInstance().getPropertiesInfo(str);
    }

    public static String d(String str) {
        return SDKLoginMgr.getInstance().getUserInfo(str);
    }

    public String a(String str) {
        return SDKLoginMgr.getInstance().getPropertiesInfo(str);
    }

    public String b(String str) {
        return SDKLoginMgr.getInstance().getUserInfo(str);
    }
}
