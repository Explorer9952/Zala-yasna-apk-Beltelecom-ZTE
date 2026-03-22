package com.picovr.picovrlib;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: classes.dex */
public class ProximityReceiver extends BroadcastReceiver {
    public static String MOUNT_HANDLED_INTENT = "com.picovr.mount_handled";
    public static String PROXIMITY_SENSOR_INTENT = "android.intent.action.proximity_sensor";
    static ProximityReceiver Receiver = new ProximityReceiver();
    static boolean RegisteredReceiver = false;
    public static String SYSTEM_ACTIVITY_INTENT = "com.picovr.system_activity";
    public static final String TAG = "VrLib";

    public static native void nativeMountHandled();

    public static native void nativeProximitySensor(int i);

    public static native void nativeSystemActivityIntent(Context context, String str, String str2, String str3);

    public static void startReceiver(Activity activity) {
        if (RegisteredReceiver) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PROXIMITY_SENSOR_INTENT);
        intentFilter.addAction(MOUNT_HANDLED_INTENT);
        intentFilter.addAction(SYSTEM_ACTIVITY_INTENT);
        activity.registerReceiver(Receiver, intentFilter);
        RegisteredReceiver = true;
    }

    public static void stopReceiver(Activity activity) {
        if (RegisteredReceiver) {
            activity.unregisterReceiver(Receiver);
            RegisteredReceiver = false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(PROXIMITY_SENSOR_INTENT)) {
            nativeProximitySensor(Integer.parseInt(intent.getType()));
        } else if (intent.getAction().equals(MOUNT_HANDLED_INTENT)) {
            nativeMountHandled();
        } else if (intent.getAction().equals(SYSTEM_ACTIVITY_INTENT)) {
            nativeSystemActivityIntent(context, VrLib.getPackageStringFromIntent(intent), VrLib.getCommandStringFromIntent(intent), VrLib.getUriStringFromIntent(intent));
        }
    }
}
