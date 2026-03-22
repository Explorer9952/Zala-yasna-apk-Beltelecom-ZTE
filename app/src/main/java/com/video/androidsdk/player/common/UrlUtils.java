package com.video.androidsdk.player.common;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.video.androidsdk.common.http.HttpConstant;
import com.video.androidsdk.log.LogEx;
import java.util.HashMap;

/* loaded from: classes.dex */
public class UrlUtils {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Pair<String, Long>> f3357a = new HashMap<>();

    public static void clearCaches() {
        HashMap<String, Pair<String, Long>> hashMap = f3357a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static void delCacheURLByChannelCode(String str) {
        HashMap<String, Pair<String, Long>> hashMap = f3357a;
        if (hashMap != null) {
            hashMap.remove(str);
        }
    }

    public static HashMap<String, String> getParamsMap(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        String[] split = str.split("[?]");
        if (split.length == 1) {
            return hashMap;
        }
        for (String str2 : split[1].split("&")) {
            String[] split2 = str2.split("=");
            if (split2.length > 1) {
                hashMap.put(split2[0], split2[1]);
            } else if (TextUtils.isEmpty(split2[0])) {
                hashMap.put(split2[0], "");
            }
        }
        return hashMap;
    }

    public static HashMap<String, Pair<String, Long>> getUrlMap() {
        return f3357a;
    }

    public static boolean isNeedToRedirect(String str) {
        try {
            String path = Uri.parse(str).getPath();
            LogEx.d("UrlUtils", "path is " + str);
            if (!path.endsWith(".mpd") && !path.endsWith(".m3u8") && !path.endsWith(DefaultHlsExtractorFactory.MP4_FILE_EXTENSION) && !path.endsWith(".mkv") && !path.endsWith(".ts") && !path.matches(".*\\.ism(l)?(/manifest(\\(.+\\))?)?") && !str.contains(PlayerConstants.MULTICAST_IP)) {
                if (str.startsWith(HttpConstant.PROTOCOL_HTTP)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            LogEx.w("UrlUtils", e.getMessage());
            return false;
        }
    }
}
