package com.picovr.picovrlib;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: classes.dex */
public class ConsoleReceiver extends BroadcastReceiver {
    public static String CONSOLE_INTENT = "picovr.console";
    public static String CONSOLE_STRING_EXTRA = "cmd";
    public static final String TAG = "PvrConsole";
    static ConsoleReceiver receiver = new ConsoleReceiver();
    static boolean registeredReceiver = false;
    static Activity activity = null;

    public static native void nativeConsoleCommand(long j, String str);

    public static void startReceiver(Activity activity2) {
        activity = activity2;
        if (registeredReceiver) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(CONSOLE_INTENT);
        activity2.registerReceiver(receiver, intentFilter);
        registeredReceiver = true;
    }

    public static void stopReceiver(Activity activity2) {
        if (registeredReceiver) {
            activity2.unregisterReceiver(receiver);
            registeredReceiver = false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(CONSOLE_INTENT)) {
            Activity activity2 = activity;
            if (activity2 instanceof VrActivity) {
                nativeConsoleCommand(((VrActivity) activity2).appPtr, intent.getStringExtra(CONSOLE_STRING_EXTRA));
            } else {
                nativeConsoleCommand(0L, intent.getStringExtra(CONSOLE_STRING_EXTRA));
            }
        }
    }
}
