package com.picovr.picovrlib.ble;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes.dex */
public class SPUtils {
    public static final String FILE_NAME = "pingvr_share_data";

    /* loaded from: classes.dex */
    private static class SharedPreferencesCompat {
        private static final Method sApplyMethod = findApplyMethod();

        private SharedPreferencesCompat() {
        }

        public static void apply(SharedPreferences.Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor, new Object[0]);
                    return;
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
            editor.commit();
        }

        private static Method findApplyMethod() {
            try {
                return SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
    }

    public static void clear(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(FILE_NAME, 0).edit();
        edit.clear();
        SharedPreferencesCompat.apply(edit);
    }

    public static boolean contains(Context context, String str) {
        return context.getSharedPreferences(FILE_NAME, 0).contains(str);
    }

    public static boolean editWingSP(Context context, String str, String str2, String str3, String str4) {
        try {
            context.createPackageContext(str, 4);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(str2, 3).edit();
        edit.putString(str3, str4);
        return edit.commit();
    }

    public static Object get(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        return null;
    }

    public static Map<String, ?> getAll(Context context) {
        return context.getSharedPreferences(FILE_NAME, 0).getAll();
    }

    public static String getDefaultFilePath() {
        File file = new File(Environment.getExternalStorageDirectory(), "getDefaultFilePath.txt");
        return file.exists() ? file.getAbsolutePath() : "";
    }

    public static String getSdCardPath() {
        return isSdCardExist() ? Environment.getExternalStorageDirectory().getAbsolutePath() : "";
    }

    public static String getWingSP(Context context, String str, String str2, String str3) {
        try {
            context.createPackageContext(str, 4);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return context.getSharedPreferences(str2, 7).getString(str3, "0");
    }

    public static boolean isSdCardExist() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static void put(Context context, String str, Object obj) {
        SharedPreferences.Editor edit = context.getSharedPreferences(FILE_NAME, 0).edit();
        if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        } else {
            edit.putString(str, obj.toString());
        }
        SharedPreferencesCompat.apply(edit);
    }

    public static boolean putInt(Context context, String str, String str2, String str3, int i) {
        try {
            context.createPackageContext(str, 4);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(str2, 3).edit();
        edit.putInt(str3, i);
        return edit.commit();
    }

    public static String readFromConfigFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(Environment.getExternalStorageDirectory(), "config.txt"));
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str = new String(bArr);
            Log.d("BLE", "result = " + str);
            return str;
        } catch (Exception e) {
            Log.e("BLE", e.getMessage());
            return "";
        }
    }

    public static String readValueFromWing(Context context, String str) {
        try {
            return context.createPackageContext("com.picovr.wing", 2).getSharedPreferences("bluetooth", 5).getString(str, null);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("BLE", e.getMessage());
            return null;
        }
    }

    public static void remove(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences(FILE_NAME, 0).edit();
        edit.remove(str);
        SharedPreferencesCompat.apply(edit);
    }

    public static void writeToConfigFile(String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(Environment.getExternalStorageDirectory(), "config.txt"));
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
            Log.d("BLE", "writeToConfigFile success");
        } catch (Exception e) {
            Log.e("BLE", e.getMessage());
        }
    }
}
