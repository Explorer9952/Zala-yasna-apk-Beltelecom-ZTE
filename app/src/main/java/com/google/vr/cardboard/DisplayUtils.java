package com.google.vr.cardboard;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.appevents.codeless.internal.Constants;
import com.google.vrtoolkit.cardboard.proto.nano.Phone;

/* loaded from: classes.dex */
public class DisplayUtils {
    public static final String EXTERNAL_DISPLAY_RESOURCE_NAME = "display_manager_hdmi_display_name";

    public static Display getDefaultDisplay(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    public static DisplayMetrics getDisplayMetrics(Display display) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            display.getRealMetrics(displayMetrics);
        } else {
            display.getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public static DisplayMetrics getDisplayMetricsWithOverride(Display display, Phone.PhoneParams phoneParams) {
        DisplayMetrics displayMetrics = getDisplayMetrics(display);
        if (phoneParams != null) {
            if (phoneParams.hasXPpi()) {
                displayMetrics.xdpi = phoneParams.getXPpi();
            }
            if (phoneParams.hasYPpi()) {
                displayMetrics.ydpi = phoneParams.getYPpi();
            }
        }
        return displayMetrics;
    }

    public static String getExternalDisplayName(Context context) {
        Resources resources = context.getResources();
        try {
            return resources.getString(resources.getIdentifier(EXTERNAL_DISPLAY_RESOURCE_NAME, "string", Constants.PLATFORM));
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static boolean hasExternalDisplay(Context context) {
        String externalDisplayName;
        if (Build.VERSION.SDK_INT <= 16 || (externalDisplayName = getExternalDisplayName(context)) == null) {
            return false;
        }
        for (Display display : ((DisplayManager) context.getSystemService("display")).getDisplays()) {
            if (display.getName().equals(externalDisplayName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSameDisplay(Display display, Display display2) {
        if (display == display2) {
            return true;
        }
        if (display == null || display2 == null || display.getDisplayId() != display2.getDisplayId() || display.getFlags() != display2.getFlags() || display.isValid() != display2.isValid() || !display.getName().equals(display2.getName())) {
            return false;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        display2.getMetrics(displayMetrics2);
        return displayMetrics.equals(displayMetrics2);
    }
}
