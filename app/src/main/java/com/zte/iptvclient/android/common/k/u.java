package com.zte.iptvclient.android.common.k;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.javabean.models.MovieDetailBundleBean;
import com.zte.iptvclient.android.common.player.activity.VOPlayerActivity;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.common.video.ContentType;

/* compiled from: SkipUtils.java */
/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4831a = "com.zte.iptvclient.android.common.k.u";

    public static void a(Activity activity, Bundle bundle, String str) {
        Intent intent = new Intent(activity, (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", str);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void b(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, (Class<?>) HostActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("fragmenttype", "messagecenter_detail_web");
        bundle.putString("ContentUrl", str2);
        bundle.putString("ContentName", str);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void c(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) HostActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("fragmenttype", "messagecenter");
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void d(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) HostActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("fragmenttype", "recording_history");
        bundle.putInt("type", 2);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void e(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) HostActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("fragmenttype", "recording_manager");
        bundle.putInt("type", 1);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void f(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) HostActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("fragmenttype", "recording_schedules");
        bundle.putInt("type", 0);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void g(Activity activity) {
        if ("1".equals(ConfigMgr.readPropertie("isNPVR"))) {
            a(activity, new Bundle(), "recordings_npvr");
        } else {
            a(activity, new Bundle(), "recordings");
        }
    }

    public static void h(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) HostActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("fragmenttype", "setting");
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void a(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) HostActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("fragmenttype", "bookmark");
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void c(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) HostActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("fragmenttype", "recordings_setschedules_start");
        bundle.putString("timebefore", str);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void d(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) HostActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("fragmenttype", "recordings_setschedules_stop");
        bundle.putString("timeafter", str);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void b(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) HostActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("fragmenttype", "recordings_setschedules_keepuntil");
        bundle.putString("keepuntil", str);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void a(Activity activity, String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("MainTitle", str);
        bundle.putString("MsgType", str2);
        bundle.putString("MsgTime", str3);
        bundle.putString("MsgDesc", str4);
        Intent intent = new Intent(activity, (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "messagecenter_detail_info");
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void c(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, (Class<?>) HostActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str);
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, str2);
        bundle.putString("fragmenttype", "moviedetail");
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void d(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, (Class<?>) HostActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("Columncode", str);
        bundle.putString("Columnname", str2);
        bundle.putString("fragmenttype", "vodmore");
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void b(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) HostActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("type", 0);
        bundle.putString("fragmenttype", "terminalconcurrency");
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void a(Activity activity, com.zte.iptvclient.android.mobile.o.a.a aVar, String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("MainTitle", str);
        bundle.putString("MsgType", str2);
        bundle.putString("MsgTime", str3);
        bundle.putString("MsgDesc", str4);
        if (BaseApp.a(activity)) {
            bundle.putBoolean("isSideMenu", false);
            com.zte.iptvclient.android.mobile.o.a.b bVar = new com.zte.iptvclient.android.mobile.o.a.b();
            bVar.setArguments(bundle);
            aVar.a(bVar);
        }
    }

    public static void a(Activity activity, com.zte.iptvclient.android.mobile.o.a.a aVar, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("ContentUrl", str2);
        bundle.putString("ContentName", str);
        if (BaseApp.a(activity)) {
            bundle.putBoolean("isSideMenu", false);
            com.zte.iptvclient.android.mobile.f0.a.a aVar2 = new com.zte.iptvclient.android.mobile.f0.a.a();
            aVar2.setArguments(bundle);
            aVar.a(aVar2);
        }
    }

    public static void a(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        Intent intent = new Intent(activity, (Class<?>) HostActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("fragmenttype", "recordings_setschedules");
        bundle.putInt("type", 0);
        bundle.putString("name", str);
        bundle.putString("mac", str2);
        bundle.putString("scheduleid", str3);
        bundle.putString("prevueid", str4);
        bundle.putString("seriesrec", str5);
        bundle.putString("channelmode", str6);
        bundle.putString("recordtype", str7);
        bundle.putString("rectimebefore", str8);
        bundle.putString("rectimeafter", str9);
        bundle.putString("recmode", str10);
        bundle.putString("keepatmost", str11);
        bundle.putString("episodetype", str12);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void a(Activity activity, String str, String str2, String str3, String str4, String str5, String str6) {
        Intent intent = new Intent(activity, (Class<?>) HostActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("fragmenttype", "recording_manager_modify");
        bundle.putString("schedulename", str);
        bundle.putString("scheduleid", str2);
        bundle.putString("seriesrec", str3);
        bundle.putString("recmode", str4);
        bundle.putString("profilecode", str6);
        bundle.putString("rectimeafter", str5);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void a(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, (Class<?>) HostActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str);
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, str2);
        bundle.putString("fragmenttype", "seriesdetail");
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void a(Activity activity, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str);
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, str2);
        bundle.putString(MovieDetailBundleBean.SERIES_BUNDLEPARAMS_SERIES_NUM, str3);
        Intent intent = new Intent(activity, (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "seriesdetail");
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void a(Activity activity, int i, String str) {
        Intent intent = new Intent(activity, (Class<?>) HostActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("colType", i);
        bundle.putString("ColumnName", str);
        bundle.putString("fragmenttype", "home_custom_more");
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static boolean a(Activity activity, String str, String str2, String str3, Boolean bool, Boolean bool2) {
        Bundle bundle = new Bundle();
        try {
            if (TextUtils.isEmpty(str)) {
                LogEx.e(f4831a, "PlayUrl = null");
                return false;
            }
            if ("1".equals(str2)) {
                bundle.putString("url_sd", str);
            } else if ("2".equals(str2)) {
                bundle.putString("url_sd_h", str);
            } else if ("4".equals(str2)) {
                bundle.putString("url_hd", str);
            } else if ("8".equals(str2)) {
                bundle.putString("url_480p", str);
            } else if (GlobalConst.WINPHONE_CLIENT.equals(str2)) {
                bundle.putString("url_720p", str);
            } else if (GlobalConst.ANDRIODSTB_CLIENT.equals(str2)) {
                bundle.putString("url_1280p", str);
            } else {
                bundle.putString("url_sd", str);
            }
            bundle.putString("auth_contenttype", str3);
            if (bool != null) {
                bundle.putBoolean("support_share", bool.booleanValue());
            }
            if (bool2 != null) {
                bundle.putBoolean("support_push", bool2.booleanValue());
            }
            Intent intent = new Intent();
            intent.putExtras(bundle);
            intent.setClass(activity, VOPlayerActivity.class);
            intent.addFlags(268435456);
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            LogEx.e(f4831a, e.getMessage());
            return false;
        }
    }

    public static boolean a(Activity activity, String str) {
        return a(activity, str, "", String.valueOf(ContentType.TYPE_CONTENT_TVOD.getIntValue()), (Boolean) false, (Boolean) false);
    }
}
