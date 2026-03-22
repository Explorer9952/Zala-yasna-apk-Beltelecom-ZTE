package com.google.vr.cardboard;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.view.Window;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

/* loaded from: classes.dex */
public class AndroidNCompat {
    private static final String ACTION_VR_LISTENER_SETTINGS = "android.settings.VR_LISTENER_SETTINGS";
    private static final boolean DEBUG = false;
    private static final String DEFAULT_VR_MODE_CLASS = "com.google.vr.vrcore.common.VrCoreListenerService";
    private static final String DEFAULT_VR_MODE_PACKAGE = "com.google.vr.vrcore";
    private static final String ENABLED_VR_LISTENERS = "enabled_vr_listeners";
    public static final int FLAG_VR_MODE_ENABLE_FALLBACK = 1;
    private static final int PACKAGE_NOT_ENABLED = -2;
    private static final int PACKAGE_NOT_PRESENT = -1;
    private static final int SUCCESS = 0;
    private static final String TAG = "AndroidNCompat";
    private static boolean sIsAtLeastNOverride = false;
    private static boolean sIsVrReadyOverride = false;

    private AndroidNCompat() {
    }

    private static int checkForVrCorePresence(Context context) {
        boolean z;
        Iterator<ApplicationInfo> it2 = context.getPackageManager().getInstalledApplications(0).iterator();
        while (true) {
            if (!it2.hasNext()) {
                z = false;
                break;
            }
            if (it2.next().packageName.equals("com.google.vr.vrcore")) {
                z = true;
                break;
            }
        }
        if (!z) {
            return -1;
        }
        String string = Settings.Secure.getString(context.getContentResolver(), ENABLED_VR_LISTENERS);
        return (string == null || !string.contains(new ComponentName("com.google.vr.vrcore", DEFAULT_VR_MODE_CLASS).flattenToString())) ? -2 : 0;
    }

    private static boolean handleVrCoreAbsence(final Context context, int i) {
        int i2;
        int i3;
        DialogInterface.OnClickListener onClickListener;
        if (i == -1) {
            i2 = R.string.dialog_vr_core_not_installed;
            i3 = R.string.go_to_playstore_button;
            onClickListener = new DialogInterface.OnClickListener() { // from class: com.google.vr.cardboard.AndroidNCompat.1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("market://details?id=com.google.vr.vrcore"));
                    intent.setPackage("com.android.vending");
                    try {
                        context.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        Log.e(AndroidNCompat.TAG, "Google Play Services is not installed, unable to download VrCore.");
                    }
                }
            };
        } else {
            if (i != -2) {
                return true;
            }
            i2 = R.string.dialog_vr_core_not_enabled;
            i3 = R.string.go_to_vr_listeners_settings_button;
            onClickListener = new DialogInterface.OnClickListener() { // from class: com.google.vr.cardboard.AndroidNCompat.2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    context.startActivity(new Intent(AndroidNCompat.ACTION_VR_LISTENER_SETTINGS));
                }
            };
        }
        showWarningDialog(context, i2, i3, onClickListener);
        return false;
    }

    private static boolean isAtLeastN() {
        return sIsAtLeastNOverride || "N".equals(Build.VERSION.CODENAME) || Build.VERSION.SDK_INT > 23;
    }

    public static boolean isVrReady(Context context) {
        if (!isAtLeastN()) {
            return false;
        }
        if (sIsVrReadyOverride) {
            return true;
        }
        if (Build.MANUFACTURER.equals("Huawei") && Build.DEVICE.equals("angler") && Build.MODEL.equals("Nexus 6P") && Build.HARDWARE.equals("angler")) {
            try {
                try {
                    return context.getPackageManager().hasSystemFeature((String) PackageManager.class.getDeclaredField("FEATURE_VR_MODE_HIGH_PERFORMANCE").get(null));
                } catch (ExceptionInInitializerError | IllegalAccessException | IllegalArgumentException e) {
                    String str = TAG;
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 32);
                    sb.append("Failed to check system feature: ");
                    sb.append(valueOf);
                    Log.w(str, sb.toString());
                    return false;
                }
            } catch (NoSuchFieldException | SecurityException e2) {
                String str2 = TAG;
                String valueOf2 = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 55);
                sb2.append("Failed to load FEATURE_VR_MODE_HIGH_PERFORMANCE field: ");
                sb2.append(valueOf2);
                Log.e(str2, sb2.toString());
            }
        }
        return false;
    }

    public static void setIsAtLeastNForTesting(boolean z) {
        sIsAtLeastNOverride = z;
    }

    public static void setIsVrReadyForTesting(boolean z) {
        sIsVrReadyOverride = z;
    }

    public static void setSustainedPerformanceMode(Activity activity, boolean z) {
        if (isAtLeastN()) {
            Window window = activity.getWindow();
            if (window == null) {
                Log.e(TAG, "Activity does not have a window");
                return;
            }
            try {
                try {
                    Window.class.getMethod("setSustainedPerformanceMode", Boolean.TYPE).invoke(window, Boolean.valueOf(z));
                } catch (IllegalAccessException e) {
                    e = e;
                    String str = TAG;
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 42);
                    sb.append("Failed to set sustained performance mode: ");
                    sb.append(valueOf);
                    Log.w(str, sb.toString());
                } catch (RuntimeException e2) {
                    e = e2;
                    String str2 = TAG;
                    String valueOf2 = String.valueOf(e);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 42);
                    sb2.append("Failed to set sustained performance mode: ");
                    sb2.append(valueOf2);
                    Log.w(str2, sb2.toString());
                } catch (InvocationTargetException e3) {
                    String str3 = TAG;
                    Throwable cause = e3.getCause();
                    Throwable th = e3;
                    if (cause != null) {
                        th = e3.getCause();
                    }
                    String valueOf3 = String.valueOf(th);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 42);
                    sb3.append("Failed to set sustained performance mode: ");
                    sb3.append(valueOf3);
                    Log.w(str3, sb3.toString());
                }
            } catch (NoSuchMethodException | RuntimeException e4) {
                String str4 = TAG;
                String valueOf4 = String.valueOf(e4);
                StringBuilder sb4 = new StringBuilder(String.valueOf(valueOf4).length() + 58);
                sb4.append("Failed to load Window.setSustainedPerformanceMode method: ");
                sb4.append(valueOf4);
                Log.e(str4, sb4.toString());
            }
        }
    }

    public static boolean setVrModeEnabled(Activity activity, boolean z) {
        return setVrModeEnabled(activity, z, 1);
    }

    public static boolean setVrModeEnabled(Activity activity, boolean z, int i) {
        String str;
        String sb;
        if (!isAtLeastN()) {
            return false;
        }
        try {
            try {
                Activity.class.getMethod("setVrModeEnabled", Boolean.TYPE, ComponentName.class).invoke(activity, Boolean.valueOf(z), new ComponentName("com.google.vr.vrcore", DEFAULT_VR_MODE_CLASS));
                return true;
            } catch (IllegalAccessException e) {
                e = e;
                String str2 = TAG;
                String valueOf = String.valueOf(e);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 23);
                sb2.append("Failed to set VR mode: ");
                sb2.append(valueOf);
                Log.w(str2, sb2.toString());
                return false;
            } catch (RuntimeException e2) {
                e = e2;
                String str22 = TAG;
                String valueOf2 = String.valueOf(e);
                StringBuilder sb22 = new StringBuilder(String.valueOf(valueOf2).length() + 23);
                sb22.append("Failed to set VR mode: ");
                sb22.append(valueOf2);
                Log.w(str22, sb22.toString());
                return false;
            } catch (InvocationTargetException e3) {
                if (e3.getCause() instanceof PackageManager.NameNotFoundException) {
                    String str3 = TAG;
                    String valueOf3 = String.valueOf(e3.getCause());
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 25);
                    sb3.append("No VR service component: ");
                    sb3.append(valueOf3);
                    Log.w(str3, sb3.toString());
                    if ((i & 1) != 0 && handleVrCoreAbsence(activity, checkForVrCorePresence(activity))) {
                        str = TAG;
                        sb = "Failed to handle missing VrCore package.";
                    }
                    return false;
                }
                str = TAG;
                Throwable cause = e3.getCause();
                Throwable th = e3;
                if (cause != null) {
                    th = e3.getCause();
                }
                String valueOf4 = String.valueOf(th);
                StringBuilder sb4 = new StringBuilder(String.valueOf(valueOf4).length() + 23);
                sb4.append("Failed to set VR mode: ");
                sb4.append(valueOf4);
                sb = sb4.toString();
                Log.w(str, sb);
                return false;
            }
        } catch (NoSuchMethodException | RuntimeException e4) {
            String str4 = TAG;
            String valueOf5 = String.valueOf(e4);
            StringBuilder sb5 = new StringBuilder(String.valueOf(valueOf5).length() + 49);
            sb5.append("Failed to load Activity.setVrModeEnabled method: ");
            sb5.append(valueOf5);
            Log.e(str4, sb5.toString());
            return false;
        }
    }

    private static void showWarningDialog(Context context, int i, int i2, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(i).setTitle(R.string.dialog_title_warning).setPositiveButton(i2, onClickListener).setNegativeButton(R.string.cancel_button, new DialogInterface.OnClickListener() { // from class: com.google.vr.cardboard.AndroidNCompat.3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
            }
        });
        builder.create().show();
    }
}
