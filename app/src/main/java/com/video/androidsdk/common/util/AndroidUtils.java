package com.video.androidsdk.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.text.TextUtils;
import com.video.androidsdk.common.config.ConfigMgr;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AndroidUtils {
    private AndroidUtils() {
    }

    public static void enableStrictMode() {
        if (hasGingerbread()) {
            StrictMode.ThreadPolicy.Builder penaltyLog = new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog();
            StrictMode.VmPolicy.Builder penaltyLog2 = new StrictMode.VmPolicy.Builder().detectAll().penaltyLog();
            if (hasHoneycomb()) {
                penaltyLog.penaltyFlashScreen();
            }
            StrictMode.setThreadPolicy(penaltyLog.build());
            StrictMode.setVmPolicy(penaltyLog2.build());
        }
    }

    public static String getAppName(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    public static int getAppVersionCode(Context context) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return 0;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static File getExternalCacheDir(Context context) {
        if (hasFroyo()) {
            return context.getExternalCacheDir();
        }
        return new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache/"));
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getReleaseVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getTransaction(int i) {
        String str = ConfigMgr.readPropertie("TransactionSp") + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
        String valueOf = String.valueOf(i);
        if (valueOf.length() > 18) {
            return str + valueOf.substring(0, 18);
        }
        int length = 18 - valueOf.length();
        StringBuilder sb = new StringBuilder(valueOf);
        for (int i2 = 0; i2 < length; i2++) {
            sb.insert(0, "0");
        }
        return str + sb.toString();
    }

    public static boolean hasFroyo() {
        return Build.VERSION.SDK_INT >= 8;
    }

    public static boolean hasGingerbread() {
        return Build.VERSION.SDK_INT >= 9;
    }

    public static boolean hasHoneycomb() {
        return Build.VERSION.SDK_INT >= 11;
    }

    public static boolean hasHoneycombMR1() {
        return Build.VERSION.SDK_INT >= 12;
    }

    public static boolean hasJellyBean() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static HashMap<String, String> initPackageInfo(Context context) {
        PackageManager packageManager;
        String str;
        ApplicationInfo applicationInfo = null;
        if (context == null) {
            return null;
        }
        try {
            packageManager = context.getApplicationContext().getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        String str2 = (String) packageManager.getApplicationLabel(applicationInfo);
        try {
            str = packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            str = "";
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("appname", str2);
        hashMap.put("appversion", str);
        return hashMap;
    }

    public static boolean isExternalStorageRemovable() {
        if (hasGingerbread()) {
            return Environment.isExternalStorageRemovable();
        }
        return true;
    }

    public static HashMap<String, String> toHashMap(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String valueOf = String.valueOf(keys.next());
                String str2 = "";
                if (jSONObject.get(valueOf) instanceof JSONArray) {
                    JSONArray jSONArray = jSONObject.getJSONArray(valueOf);
                    if (jSONArray != null && jSONArray.length() != 0) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            str2 = jSONArray.get(i) + ",";
                        }
                    }
                    if (str2.endsWith(",")) {
                        str2 = str2.substring(0, str2.length() - 1);
                    }
                } else {
                    str2 = String.valueOf(jSONObject.get(valueOf));
                }
                hashMap.put(valueOf, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }
}
