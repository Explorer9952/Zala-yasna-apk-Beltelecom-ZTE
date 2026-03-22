package com.picovr.picovrlib;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.unity3d.player.UnityPlayer;

/* loaded from: classes.dex */
public class BatteryReceiver extends BroadcastReceiver {
    public static final String TAG = "BatteryReceiver";
    static BatteryReceiver receiver = new BatteryReceiver();
    static boolean registeredReceiver = false;
    static Activity activity = null;
    static String unityObjectName = "";

    public static native void nativeConsoleCommand(long j, String str);

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
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        activity2.registerReceiver(receiver, intentFilter);
        registeredReceiver = true;
    }

    public static void stopReceiver(Activity activity2) {
        if (registeredReceiver) {
            unityObjectName = null;
            activity2.unregisterReceiver(receiver);
            registeredReceiver = false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
            int intExtra = (intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100);
            String str = unityObjectName;
            if (str != null && !str.equals("")) {
                String str2 = unityObjectName;
                StringBuilder sb = new StringBuilder();
                sb.append(intExtra);
                UnityPlayer.UnitySendMessage(str2, "setBattery", sb.toString());
                return;
            }
            UnityPlayer.UnitySendMessage(unityObjectName, "setBattery", "N/A");
        }
    }
}
