package com.picovr.picovrlib;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.unity3d.player.UnityPlayer;

/* loaded from: classes.dex */
public class AudioReceiver extends BroadcastReceiver {
    public static final String TAG = "BatteryReceiver";
    static AudioReceiver receiver = new AudioReceiver();
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
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
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
        if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
            int streamVolume = ((AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO)).getStreamVolume(3);
            String str = unityObjectName;
            if (str != null && !str.equals("")) {
                UnityPlayer.UnitySendMessage(unityObjectName, "setAudio", new StringBuilder(String.valueOf(streamVolume)).toString());
            } else {
                UnityPlayer.UnitySendMessage(unityObjectName, "setAudio", "N/A");
            }
        }
    }
}
