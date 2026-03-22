package com.picovr.picovrlib.ble;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class MySPUtils {
    private static final String FILE_NAME = "ble";

    public static String getString(Context context, String str) {
        return context.getSharedPreferences(FILE_NAME, 0).getString(str, null);
    }

    public static void setString(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(FILE_NAME, 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }
}
