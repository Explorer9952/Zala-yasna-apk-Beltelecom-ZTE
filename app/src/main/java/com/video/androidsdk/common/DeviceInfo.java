package com.video.androidsdk.common;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/* loaded from: classes.dex */
public class DeviceInfo {
    private static volatile Display display = null;
    private static volatile DisplayMetrics displayMetrics = null;
    private static int orientation = -1;

    public static Display getDisplay(Context context) {
        int i = context.getResources().getConfiguration().orientation;
        if (display == null || i != orientation) {
            display = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            orientation = i;
        }
        return display;
    }

    public static synchronized DisplayMetrics getDisplayMetrix(Context context) {
        DisplayMetrics displayMetrics2;
        synchronized (DeviceInfo.class) {
            int i = context.getResources().getConfiguration().orientation;
            if (displayMetrics == null || i != orientation) {
                displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                orientation = i;
            }
            displayMetrics2 = displayMetrics;
        }
        return displayMetrics2;
    }
}
