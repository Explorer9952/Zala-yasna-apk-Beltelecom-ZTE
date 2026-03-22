package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import com.zte.ucs.tvcall.Commons;
import java.util.Map;

/* loaded from: classes.dex */
public final class ChannelUtil {
    public static final int FLAG_NULL = 0;
    public static final int FLAG_UPDATE_EXTERNAL = 1;
    public static final int FLAG_UPDATE_NOTIP = 2;
    public static int buildRev;
    public static int channelId;
    public static boolean fullVersionInfo;
    public static String marketURL;
    public static String profileDeviceType;
    public static int updateMode;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.VERSION.SDK_INT);
        profileDeviceType = sb.toString();
        updateMode = 0;
        buildRev = 0;
        marketURL = "market://details?id=" + MMApplicationContext.getPackageName();
        fullVersionInfo = false;
    }

    private ChannelUtil() {
    }

    public static String formatVersion(Context context, int i) {
        String str = ((i >> 24) & 15) + "." + ((i >> 16) & 255);
        int i2 = i & 65535;
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), Commons.MSG_MCSP_INIT_SUCCESS);
                if (packageInfo != null) {
                    i2 = packageInfo.versionCode;
                    str = packageInfo.versionName;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!fullVersionInfo) {
            return str;
        }
        String str2 = str + " r" + i2 + "(build." + buildRev + ")";
        Log.d("MicroMsg.SDK.ChannelUtil", "full version: " + str2);
        return str2;
    }

    public static void loadProfile(Context context) {
        try {
            Map<String, String> parseIni = KVConfig.parseIni(Util.convertStreamToString(context.getAssets().open("profile.ini")));
            String nullAsNil = Util.nullAsNil(parseIni.get("PROFILE_DEVICE_TYPE"));
            profileDeviceType = nullAsNil;
            if (nullAsNil.length() <= 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(Build.VERSION.SDK_INT);
                profileDeviceType = sb.toString();
            }
            updateMode = Integer.parseInt(parseIni.get("UPDATE_MODE"));
            buildRev = Integer.parseInt(parseIni.get("BUILD_REVISION"));
            android.util.Log.w("MicroMsg.SDK.ChannelUtil", "profileDeviceType=" + profileDeviceType);
            android.util.Log.w("MicroMsg.SDK.ChannelUtil", "updateMode=" + updateMode);
            String str = parseIni.get("MARKET_URL");
            if (str != null && str.trim().length() != 0 && Uri.parse(str) != null) {
                marketURL = str;
            }
            android.util.Log.w("MicroMsg.SDK.ChannelUtil", "marketURL=" + marketURL);
        } catch (Exception e) {
            android.util.Log.e("MicroMsg.SDK.ChannelUtil", "setup profile from profile.ini failed");
            e.printStackTrace();
        }
    }

    public static void setupChannelId(Context context) {
        try {
            channelId = Integer.parseInt(KVConfig.parseIni(Util.convertStreamToString(context.getAssets().open("channel.ini"))).get("CHANNEL"));
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.ChannelUtil", "setup channel id from channel.ini failed");
            e.printStackTrace();
        }
    }
}
