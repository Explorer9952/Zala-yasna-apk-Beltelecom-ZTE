package com.picovr.picovrlib;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: classes.dex */
public class DockReceiver extends BroadcastReceiver {
    public static final String TAG = "DockReceiver";
    static DockReceiver receiver = new DockReceiver();
    static boolean registeredDockReceiver = false;
    public static String HMT_DISCONNECT = "com.samsung.intent.action.HMT_DISCONNECTED";
    public static String HMT_CONNECT = "com.samsung.intent.action.HMT_CONNECTED";

    public static native void nativeDockEvent(int i);

    public static void startDockReceiver(Activity activity) {
        if (registeredDockReceiver) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(HMT_DISCONNECT);
        intentFilter.addAction(HMT_CONNECT);
        activity.registerReceiver(receiver, intentFilter);
        registeredDockReceiver = true;
    }

    public static void stopDockReceiver(Activity activity) {
        if (registeredDockReceiver) {
            activity.unregisterReceiver(receiver);
            registeredDockReceiver = false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(HMT_DISCONNECT)) {
            nativeDockEvent(0);
        } else if (intent.getAction().equals(HMT_CONNECT)) {
            nativeDockEvent(1);
        }
    }
}
