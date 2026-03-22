package com.video.androidsdk.login.a;

import com.video.androidsdk.common.config.DSTConfigurator;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.login.SDKLoginMgr;

/* compiled from: PortalConfig.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3146a = "b";

    /* renamed from: b, reason: collision with root package name */
    private static b f3147b = new b();

    private b() {
    }

    public static b a() {
        return f3147b;
    }

    private void c() {
        new DSTConfigurator(SDKLoginMgr.getInstance().getPropertiesInfo("ZoneOffset"), SDKLoginMgr.getInstance().getPropertiesInfo("ZoneID"), SDKLoginMgr.getInstance().getPropertiesInfo("TimeOffset"), SDKLoginMgr.getInstance().getPropertiesInfo("SummerStartTime"), SDKLoginMgr.getInstance().getPropertiesInfo("SummerEndTime")).setDSTRules();
    }

    private void d() {
        TimeUtil.setLanguage(SDKLoginMgr.getInstance().getPropertiesInfo("LocaleLang"));
    }

    public void b() {
        c();
        d();
    }
}
