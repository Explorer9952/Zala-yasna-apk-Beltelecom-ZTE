package com.video.androidsdk.a;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.HttpUrlConstants;
import java.io.File;
import java.io.Serializable;

/* compiled from: SDKCacheMgr.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f3030a = false;

    /* renamed from: b, reason: collision with root package name */
    public static long f3031b = 10080;

    /* renamed from: c, reason: collision with root package name */
    private static Context f3032c;

    /* renamed from: d, reason: collision with root package name */
    private static a f3033d;
    private static String[] e = {HttpUrlConstants.GET_COLUMN_LIST, HttpUrlConstants.GET_VOD_LIST, HttpUrlConstants.GET_VOD_DETAIL, HttpUrlConstants.GET_SERIES_INFO, HttpUrlConstants.GET_PREVUE_LIST, HttpUrlConstants.GET_CHANNEL_RECOMMEND_LIST, HttpUrlConstants.GET_TVOD_RECOMMEND_LIST, HttpUrlConstants.GET_VOD_RECOMMEND_LIST, HttpUrlConstants.GET_HOME_BANNER, HttpUrlConstants.GET_HOME_DYNAMIC_COLUMNLIST, HttpUrlConstants.GET_VOD_SEARCH_LIST};

    public static void a(Context context) {
        f3032c = context;
    }

    public static String b(String str) {
        a aVar = f3033d;
        return aVar != null ? aVar.a(f(str)) : "";
    }

    public static Object c(String str) {
        a aVar = f3033d;
        if (aVar != null) {
            return aVar.c(f(str));
        }
        return null;
    }

    private static void d() {
        if (f3033d == null) {
            f3033d = a.a(a(f3032c, "androidsdk"));
        }
    }

    public static boolean e(String str) {
        a aVar = f3033d;
        if (aVar != null) {
            return aVar.d(f(str));
        }
        return true;
    }

    private static String f(String str) {
        String userInfo = SDKLoginMgr.getInstance().getUserInfo("UserCode");
        if (TextUtils.isEmpty(userInfo)) {
            userInfo = SDKLoginMgr.getInstance().getUserInfo("UserID");
        }
        if (TextUtils.isEmpty(userInfo)) {
            userInfo = "guestphone";
        }
        LogEx.d("SDKCacheMgr", "Key === " + str + userInfo);
        return str + userInfo;
    }

    public static void a(boolean z) {
        f3030a = z;
    }

    public static boolean a() {
        return f3030a;
    }

    public static void b() {
        a aVar = f3033d;
        if (aVar != null) {
            aVar.a();
        }
    }

    public static long c() {
        a aVar = f3033d;
        if (aVar != null) {
            return aVar.b();
        }
        return 0L;
    }

    public static byte[] d(String str) {
        a aVar = f3033d;
        if (aVar != null) {
            return aVar.b(f(str));
        }
        return null;
    }

    public static boolean a(String str) {
        if (!f3030a || TextUtils.isEmpty(str)) {
            LogEx.d("SDKCacheMgr", "mbEnableCache is false");
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = e;
            if (i >= strArr.length) {
                return false;
            }
            if (str.equalsIgnoreCase(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    public static void a(String str, String str2, long j) {
        d();
        f3033d.a(f(str), str2, ((int) j) * 60);
    }

    public static void a(String str, String str2) {
        d();
        f3033d.a(f(str), str2);
    }

    public static void a(String str, Serializable serializable, long j) {
        d();
        f3033d.a(f(str), serializable, ((int) j) * 60);
    }

    public static void a(String str, Serializable serializable) {
        d();
        f3033d.a(f(str), serializable);
    }

    public static void a(String str, byte[] bArr) {
        d();
        f3033d.a(f(str), bArr);
    }

    public static File a(Context context, String str) {
        String str2;
        if (context == null) {
            str2 = "";
        } else if (!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
            str2 = context.getCacheDir().getPath();
        } else {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                str2 = externalCacheDir.getPath();
            } else {
                str2 = context.getCacheDir().getPath();
            }
        }
        LogEx.d("SDKCacheMgr", "cache directory is ==== " + str2);
        return new File(str2 + File.separator + str);
    }
}
