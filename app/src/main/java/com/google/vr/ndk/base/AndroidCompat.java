package com.google.vr.ndk.base;

import android.app.Activity;
import com.google.vr.cardboard.AndroidNCompat;

/* loaded from: classes.dex */
public final class AndroidCompat {
    private AndroidCompat() {
    }

    public static void setSustainedPerformanceMode(Activity activity, boolean z) {
        AndroidNCompat.setSustainedPerformanceMode(activity, z);
    }

    public static void setVrModeEnabled(Activity activity, boolean z) {
        AndroidNCompat.setVrModeEnabled(activity, z);
    }
}
