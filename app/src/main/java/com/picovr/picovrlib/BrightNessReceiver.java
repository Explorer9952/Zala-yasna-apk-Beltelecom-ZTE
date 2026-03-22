package com.picovr.picovrlib;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;

/* loaded from: classes.dex */
public class BrightNessReceiver {
    static ContentObserver BrightnessMode = null;
    public static final String TAG = "BrightNessReceiver";
    static Activity activity = null;
    static boolean registeredReceiver = false;
    static String unityObjectName = "";

    public static boolean isAutoBrightness(ContentResolver contentResolver) {
        try {
            return Settings.System.getInt(contentResolver, "screen_brightness_mode") == 1;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void startReceiver(Activity activity2, String str) {
        if (unityObjectName == null) {
            Log.i("berton", "这个地方是个null");
        } else {
            Log.i("berton", "这个地方是个  " + unityObjectName);
        }
        unityObjectName = str;
        activity = activity2;
        if (registeredReceiver) {
            return;
        }
        BrightnessMode = new ContentObserver(new Handler()) { // from class: com.picovr.picovrlib.BrightNessReceiver.1
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                Log.i("berton", "监听到了亮度发生了变化=======111111111=======");
                if (!BrightNessReceiver.isAutoBrightness(BrightNessReceiver.activity.getContentResolver())) {
                    Log.i("berton", "监听到了亮度发生了变化====2222222222==========");
                } else {
                    Log.i("berton", "监听到了亮度发生了变化======333333========");
                }
            }
        };
        activity.getContentResolver().registerContentObserver(Settings.System.getUriFor("screen_brightness"), true, BrightnessMode);
        registeredReceiver = true;
    }

    public static void stopReceiver(Activity activity2) {
        if (registeredReceiver) {
            unityObjectName = null;
            activity.getContentResolver().unregisterContentObserver(BrightnessMode);
        }
    }
}
