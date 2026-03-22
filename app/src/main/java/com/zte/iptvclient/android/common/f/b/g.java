package com.zte.iptvclient.android.common.f.b;

import android.content.Context;
import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.common.config.ConfigMgr;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.javabean.models.SeriesEpisodeBean;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;

/* compiled from: DurationMgr.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f4558a;

    /* renamed from: b, reason: collision with root package name */
    private static String f4559b;

    /* renamed from: c, reason: collision with root package name */
    private static String f4560c;

    /* renamed from: d, reason: collision with root package name */
    private static String f4561d;
    private static int e;

    public static void a(SeriesEpisodeBean seriesEpisodeBean) {
        e = 1;
        f4558a = false;
        f4559b = seriesEpisodeBean.c();
        f4560c = seriesEpisodeBean.g();
        f4561d = seriesEpisodeBean.i();
    }

    public static String b() {
        return (!h() || TextUtils.isEmpty(f4559b)) ? "0" : f4559b;
    }

    private static Context c() {
        return BaseApp.e().getApplicationContext();
    }

    public static int d() {
        if (a() && h()) {
            return e;
        }
        return -1;
    }

    public static String e() {
        return (!h() || TextUtils.isEmpty(f4560c)) ? "0" : f4560c;
    }

    public static String f() {
        return TextUtils.isEmpty(f4561d) ? "0" : f4561d;
    }

    public static boolean g() {
        return f4558a;
    }

    public static boolean h() {
        return TextUtils.equals("1", com.zte.iptvclient.android.common.j.h.a(c(), "skip_duration", "1"));
    }

    public static void i() {
        f4558a = true;
    }

    public static void j() {
        com.zte.iptvclient.android.common.j.h.b(c(), "skip_duration", h() ? "0" : "1");
    }

    public static void a(VideoDetailBean videoDetailBean) {
        e = 0;
        f4559b = TextUtils.isEmpty(videoDetailBean.getBeginduration()) ? "0" : videoDetailBean.getBeginduration();
        f4560c = TextUtils.isEmpty(videoDetailBean.getEndduration()) ? "0" : videoDetailBean.getEndduration();
        f4561d = TextUtils.isEmpty(videoDetailBean.getPreduration()) ? "0" : videoDetailBean.getPreduration();
    }

    public static boolean a() {
        return "1".equals(ConfigMgr.readPropertie("IsSkipDuration", WeiboAuthException.DEFAULT_AUTH_ERROR_CODE));
    }
}
