package com.video.androidsdk.service.cache;

import com.video.androidsdk.a.d;
import com.video.androidsdk.login.a.a;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class SDKCacheMgr {
    public static void clearCache() {
        d.b();
    }

    public static boolean delete(String str) {
        return d.e(str);
    }

    public static void enableCache(boolean z) {
        d.a(z);
    }

    public static List<HashMap<String, String>> getAllChannelList() {
        return a.a();
    }

    public static byte[] getAsBinary(String str) {
        return d.d(str);
    }

    public static Object getAsObject(String str) {
        return d.c(str);
    }

    public static String getAsString(String str) {
        return d.b(str);
    }

    public static long getCacheSize() {
        return d.c();
    }

    public static void put(String str, String str2, long j) {
        d.a(str, str2, ((int) j) * 60);
    }

    public static void put(String str, String str2) {
        d.a(str, str2);
    }

    public static void put(String str, Serializable serializable, long j) {
        d.a(str, serializable, ((int) j) * 60);
    }

    public static void put(String str, Serializable serializable) {
        d.a(str, serializable);
    }

    public static void put(String str, byte[] bArr) {
        d.a(str, bArr);
    }
}
