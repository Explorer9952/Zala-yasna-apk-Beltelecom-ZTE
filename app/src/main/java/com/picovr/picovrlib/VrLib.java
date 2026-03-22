package com.picovr.picovrlib;

import android.app.Activity;
import android.app.IVRManagerPico;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.os.IBinder;
import android.os.ServiceManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Choreographer;
import android.view.Display;
import com.google.android.exoplayer2.util.MimeTypes;
import com.picovr.picovrlib.service.ILite2Manager;
import com.picovr.picovrlib.service.Lite2ManagerProxy;
import com.tencent.mm.sdk.platformtools.Util;
import com.zte.ucs.tvcall.Commons;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes.dex */
public class VrLib implements Choreographer.FrameCallback, AudioManager.OnAudioFocusChangeListener {
    public static final String INTENT_KEY_CMD = "intent_cmd";
    public static final String INTENT_KEY_FROM_PKG = "intent_pkg";
    public static final int PRIMARY_EXTERNAL_STORAGE_IDX = 0;
    public static final int SECONDARY_EXTERNAL_STORAGE_IDX = 1;
    public static final String TAG = "VrLib";
    public static Choreographer choreographerInstance;
    public static VrLib handler = new VrLib();
    public static String MOUNT_HANDLED_INTENT = "com.picovr.mount_handled";
    private static ILite2Manager Lite2Manager = null;
    static int[] defaultClockLevels = {-1, -1, -1, -1};
    static int[] defaultClockFreq = {-1, -1};
    public static HeadsetReceiver headsetReceiver = null;
    public static IntentFilter headsetFilter = null;
    public static BatteryReceiver batteryReceiver = null;
    public static IntentFilter batteryFilter = null;
    public static WifiReceiver wifiReceiver = null;
    public static IntentFilter wifiFilter = null;
    public static OvrPhoneStateListener phoneListener = null;
    public static VolumeReceiver volumeReceiver = null;
    public static IntentFilter volumeFilter = null;
    private static String currentLanguage = null;
    private long lastVsyncNano = -1;
    private int fps = 0;

    /* loaded from: classes.dex */
    private static class HeadsetReceiver extends BroadcastReceiver {
        public Activity act;

        private HeadsetReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            this.act.runOnUiThread(new Runnable() { // from class: com.picovr.picovrlib.VrLib.HeadsetReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    if (intent.hasExtra("state")) {
                        VrLib.nativeHeadsetEvent(intent.getIntExtra("state", 0));
                    }
                }
            });
        }

        /* synthetic */ HeadsetReceiver(HeadsetReceiver headsetReceiver) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private static class OvrPhoneStateListener extends PhoneStateListener {
        private OvrPhoneStateListener() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState serviceState) {
            super.onServiceStateChanged(serviceState);
            VrLib.nativeCellularStateEvent(serviceState.getState());
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            int i = 0;
            try {
                Method method = signalStrength.getClass().getMethod("getLevel", new Class[0]);
                method.setAccessible(true);
                i = ((Integer) method.invoke(signalStrength, new Object[0])).intValue();
            } catch (Exception unused) {
            }
            VrLib.nativeCellularSignalEvent(i);
        }

        /* synthetic */ OvrPhoneStateListener(OvrPhoneStateListener ovrPhoneStateListener) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private static class VolumeReceiver extends BroadcastReceiver {
        public Activity act;

        private VolumeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            this.act.runOnUiThread(new Runnable() { // from class: com.picovr.picovrlib.VrLib.VolumeReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    int intValue = ((Integer) intent.getExtras().get("android.media.EXTRA_VOLUME_STREAM_TYPE")).intValue();
                    int intValue2 = ((Integer) intent.getExtras().get("android.media.EXTRA_VOLUME_STREAM_VALUE")).intValue();
                    if (intValue == 3) {
                        VrLib.nativeVolumeEvent(intValue2);
                    }
                }
            });
        }

        /* synthetic */ VolumeReceiver(VolumeReceiver volumeReceiver) {
            this();
        }
    }

    public static void broadcastIntent(Activity activity, String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(str);
        if (str2 != null && !str2.isEmpty() && str3 != null && !str3.isEmpty()) {
            intent.setComponent(new ComponentName(str2, str3));
        }
        if (str5.length() > 0) {
            intent.setData(Uri.parse(str5));
        }
        intent.putExtra(INTENT_KEY_CMD, str4);
        intent.putExtra(INTENT_KEY_FROM_PKG, activity.getApplicationContext().getPackageName());
        activity.sendBroadcast(intent);
    }

    public static void enableComfortViewMode(Activity activity, boolean z) {
        IVRManagerPico iVRManagerPico = (IVRManagerPico) activity.getSystemService(IVRManagerPico.VR_MANAGER);
        if (iVRManagerPico == null) {
            return;
        }
        iVRManagerPico.setSystemOption(IVRManagerPico.VR_COMFORT_VIEW, z ? "1" : "0");
    }

    public static void finishAffinityOnUiThread(final Activity activity) {
        activity.runOnUiThread(new Runnable() { // from class: com.picovr.picovrlib.VrLib.7
            @Override // java.lang.Runnable
            public void run() {
                activity.finishAffinity();
                activity.overridePendingTransition(0, 0);
            }
        });
    }

    public static void finishOnUiThread(final Activity activity) {
        activity.runOnUiThread(new Runnable() { // from class: com.picovr.picovrlib.VrLib.6
            @Override // java.lang.Runnable
            public void run() {
                activity.finish();
                activity.overridePendingTransition(0, 0);
            }
        });
    }

    public static int[] getAvailableFreqLevels(Activity activity) {
        IVRManagerPico iVRManagerPico = (IVRManagerPico) activity.getSystemService(IVRManagerPico.VR_MANAGER);
        if (iVRManagerPico == null) {
            return defaultClockLevels;
        }
        try {
            int[] return2EnableFreqLev = iVRManagerPico.return2EnableFreqLev();
            for (int i = 0; i < return2EnableFreqLev.length; i++) {
            }
            return return2EnableFreqLev;
        } catch (NoSuchMethodError unused) {
            return defaultClockLevels;
        }
    }

    public static boolean getBluetoothEnabled(Activity activity) {
        return Settings.Global.getInt(activity.getContentResolver(), "bluetooth_on", 0) != 0;
    }

    public static boolean getComfortViewModeEnabled(Activity activity) {
        IVRManagerPico iVRManagerPico = (IVRManagerPico) activity.getSystemService(IVRManagerPico.VR_MANAGER);
        if (iVRManagerPico == null) {
            return false;
        }
        return iVRManagerPico.getSystemOption(IVRManagerPico.VR_COMFORT_VIEW).equals("1");
    }

    public static String getCommandStringFromIntent(Intent intent) {
        String stringExtra;
        return (intent == null || (stringExtra = intent.getStringExtra(INTENT_KEY_CMD)) == null) ? "" : stringExtra;
    }

    public static String getCurrentLanguage() {
        String str = currentLanguage;
        if (str == null || str.isEmpty()) {
            currentLanguage = Locale.getDefault().getLanguage();
        }
        return currentLanguage;
    }

    public static float getDisplayHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return (displayMetrics.heightPixels / displayMetrics.ydpi) * 0.0254f;
    }

    public static int getDisplayHeightPixels(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        try {
            defaultDisplay.getRealMetrics(displayMetrics);
        } catch (NoSuchMethodError unused) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static float getDisplayWidth(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return (displayMetrics.widthPixels / displayMetrics.xdpi) * 0.0254f;
    }

    public static int getDisplayWidthPixels(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        try {
            defaultDisplay.getRealMetrics(displayMetrics);
        } catch (NoSuchMethodError unused) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    public static boolean getDoNotDisturbMode(Activity activity) {
        IVRManagerPico iVRManagerPico = (IVRManagerPico) activity.getSystemService(IVRManagerPico.VR_MANAGER);
        if (iVRManagerPico == null) {
            return false;
        }
        return iVRManagerPico.getSystemOption(IVRManagerPico.VR_DO_NOT_DISTURB).equals("1");
    }

    public static String getExternalStorageCacheDirAtIdx(Activity activity, int i) {
        File[] externalCacheDirs;
        return (activity == null || (externalCacheDirs = activity.getExternalCacheDirs()) == null || externalCacheDirs.length <= i || externalCacheDirs[i] == null) ? "" : toFolderPathFormat(externalCacheDirs[i].getPath());
    }

    public static String getExternalStorageDirectory() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static String getExternalStorageFilesDirAtIdx(Activity activity, int i) {
        File[] externalFilesDirs;
        return (activity == null || (externalFilesDirs = activity.getExternalFilesDirs(null)) == null || externalFilesDirs.length <= i || externalFilesDirs[i] == null) ? "" : toFolderPathFormat(externalFilesDirs[i].getPath());
    }

    public static long getInternalCacheMemoryInBytes(Activity activity) {
        if (activity != null) {
            return new StatFs(getInternalStorageCacheDir(activity)).getAvailableBytes();
        }
        return 0L;
    }

    public static String getInternalStorageCacheDir(Activity activity) {
        return activity != null ? toFolderPathFormat(activity.getCacheDir().getPath()) : "";
    }

    public static String getInternalStorageFilesDir(Activity activity) {
        return activity != null ? toFolderPathFormat(activity.getFilesDir().getPath()) : "";
    }

    public static String getInternalStorageRootDir() {
        return toFolderPathFormat(Environment.getDataDirectory().getPath());
    }

    public static ILite2Manager getLite2Manager() {
        if (Lite2Manager == null) {
            IBinder service = ServiceManager.getService(ILite2Manager.LITE2_MANAGER);
            if (service == null) {
                return null;
            }
            Lite2Manager = new Lite2ManagerProxy(service);
        }
        return Lite2Manager;
    }

    public static String getPackageStringFromIntent(Intent intent) {
        String stringExtra;
        return (intent == null || (stringExtra = intent.getStringExtra(INTENT_KEY_FROM_PKG)) == null) ? "" : stringExtra;
    }

    public static int getPowerLevelState(Activity activity) {
        IVRManagerPico iVRManagerPico = (IVRManagerPico) activity.getSystemService(IVRManagerPico.VR_MANAGER);
        if (iVRManagerPico == null) {
            return 0;
        }
        try {
            return iVRManagerPico.GetPowerLevelState();
        } catch (NoSuchMethodError unused) {
            return 0;
        }
    }

    public static String getPrimaryExternalStorageCacheDir(Activity activity) {
        return getExternalStorageCacheDirAtIdx(activity, 0);
    }

    public static String getPrimaryExternalStorageFilesDir(Activity activity) {
        return getExternalStorageFilesDirAtIdx(activity, 0);
    }

    public static String getPrimaryExternalStorageRootDir(Activity activity) {
        return toFolderPathFormat(Environment.getExternalStorageDirectory().getPath());
    }

    private static int getScreenMode(Activity activity) {
        try {
            return Settings.System.getInt(activity.getContentResolver(), "screen_brightness_mode");
        } catch (Exception unused) {
            return 1;
        }
    }

    public static String getSecondaryExternalStorageCacheDir(Activity activity) {
        return getExternalStorageCacheDirAtIdx(activity, 1);
    }

    public static String getSecondaryExternalStorageFilesDir(Activity activity) {
        return getExternalStorageFilesDirAtIdx(activity, 1);
    }

    public static String getSecondaryExternalStorageRootDir() {
        return "/storage/extSdCard/";
    }

    public static int getSystemBrightness(Activity activity) {
        IVRManagerPico iVRManagerPico = (IVRManagerPico) activity.getSystemService(IVRManagerPico.VR_MANAGER);
        if (iVRManagerPico == null) {
            return 50;
        }
        return Integer.parseInt(iVRManagerPico.getSystemOption(IVRManagerPico.VR_BRIGHTNESS));
    }

    public static int getSystemBrightnessLite2(Activity activity) {
        try {
            return Settings.System.getInt(activity.getContentResolver(), "screen_brightness");
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String getUriStringFromIntent(Intent intent) {
        Uri data;
        String uri;
        return (intent == null || (data = intent.getData()) == null || (uri = data.toString()) == null) ? "" : uri;
    }

    public static boolean isActivityInPackage(Activity activity, String str, String str2) {
        PackageInfo packageInfo;
        try {
            packageInfo = activity.getPackageManager().getPackageInfo(str, 1);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageInfo == null || packageInfo.activities == null) {
            return false;
        }
        for (int i = 0; i < packageInfo.activities.length; i++) {
            if (packageInfo.activities[i] != null && packageInfo.activities[i].name.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAirplaneModeEnabled(Activity activity) {
        return Settings.Global.getInt(activity.getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    public static boolean isDeveloperMode(Activity activity) {
        return Settings.Global.getInt(activity.getContentResolver(), "vrmode_developer_mode", 0) != 0;
    }

    public static boolean isHybridApp(Activity activity) {
        try {
            return activity.getPackageManager().getApplicationInfo(activity.getPackageName(), Commons.MSG_MCSP_INIT_SUCCESS).metaData.getString("com.samsung.android.vr.application.mode").equals("dual");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public static boolean isLandscapeApp(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        return rotation == 1 || rotation == 3;
    }

    public static boolean isTime24HourFormat(Activity activity) {
        String string = Settings.System.getString(activity.getContentResolver(), "time_12_24");
        return (string == null || string.isEmpty() || string.equals("12")) ? false : true;
    }

    public static boolean isWifiConnected(Activity activity) {
        return ((ConnectivityManager) activity.getSystemService("connectivity")).getNetworkInfo(1).isConnected();
    }

    public static void logApplicationName(Activity activity) {
        activity.getApplicationContext().getString(activity.getApplicationContext().getApplicationInfo().labelRes);
    }

    public static void logApplicationVersion(Activity activity) {
        PackageManager packageManager = activity.getApplicationContext().getPackageManager();
        if (packageManager != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(activity.getApplicationContext().getPackageName(), 0);
                String str = packageInfo.versionName;
                int i = packageInfo.versionCode;
                ApplicationInfo applicationInfo = activity.getPackageManager().getApplicationInfo(activity.getApplicationContext().getPackageName(), Commons.MSG_MCSP_INIT_SUCCESS);
                if (applicationInfo == null || applicationInfo.metaData == null) {
                    return;
                }
                applicationInfo.metaData.getString("internalVersionName", "<none>");
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }

    public static void logApplicationVrType(Activity activity) {
        PackageManager packageManager = activity.getApplicationContext().getPackageManager();
        if (packageManager != null) {
            try {
                packageManager.getPackageInfo(activity.getApplicationContext().getPackageName(), 0);
                ApplicationInfo applicationInfo = activity.getPackageManager().getApplicationInfo(activity.getApplicationContext().getPackageName(), Commons.MSG_MCSP_INIT_SUCCESS);
                if (applicationInfo == null || applicationInfo.metaData == null) {
                    return;
                }
                applicationInfo.metaData.getString("com.samsung.android.vr.application.mode", "<none>");
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }

    public static native void nativeBatteryEvent(int i, int i2, int i3);

    public static native void nativeCellularSignalEvent(int i);

    public static native void nativeCellularStateEvent(int i);

    public static native void nativeHeadsetEvent(int i);

    public static native void nativeVolumeEvent(int i);

    public static native void nativeVsync(long j);

    public static native void nativeWifiEvent(int i, int i2);

    public static void notifyMountHandled(Activity activity) {
        activity.sendBroadcast(new Intent(MOUNT_HANDLED_INTENT));
    }

    public static boolean packageIsInstalled(Activity activity, String str) {
        try {
            activity.getPackageManager().getPackageInfo(str, Commons.MSG_MCSP_INIT_SUCCESS);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void releaseAudioFocus(Activity activity) {
        ((AudioManager) activity.getSystemService(MimeTypes.BASE_TYPE_AUDIO)).abandonAudioFocus(handler);
    }

    public static void releaseSystemPerformanceStatic(Activity activity) {
        IVRManagerPico iVRManagerPico = (IVRManagerPico) activity.getSystemService(IVRManagerPico.VR_MANAGER);
        if (iVRManagerPico == null) {
            return;
        }
        iVRManagerPico.relFreq(activity.getPackageName());
    }

    public static void requestAudioFocus(Activity activity) {
        ((AudioManager) activity.getSystemService(MimeTypes.BASE_TYPE_AUDIO)).requestAudioFocus(handler, 3, 1);
    }

    private static void saveScreenBrightness(Activity activity, int i) {
        try {
            Settings.System.putInt(activity.getContentResolver(), "screen_brightness", i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendIntent(Activity activity, Intent intent) {
        try {
            intent.addFlags(65536);
            activity.startActivity(intent);
            activity.overridePendingTransition(0, 0);
        } catch (ActivityNotFoundException | Exception unused) {
        }
    }

    public static void sendIntentFromNative(Activity activity, String str, String str2, String str3, String str4, String str5) {
        if ("com.android.launcher3.Launcher".equals(str3)) {
            activity.finish();
            return;
        }
        Intent intent = new Intent(str);
        if (str2 != null && !str2.isEmpty() && str3 != null && !str3.isEmpty()) {
            intent.setComponent(new ComponentName(str2, str3));
        }
        if (str5.length() > 0) {
            intent.setData(Uri.parse(str5));
        }
        intent.putExtra(INTENT_KEY_CMD, str4);
        intent.putExtra(INTENT_KEY_FROM_PKG, activity.getApplicationContext().getPackageName());
        sendIntent(activity, intent);
    }

    public static void sendLaunchIntent(Activity activity, String str, String str2, String str3) {
        Intent launchIntentForPackage = activity.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return;
        }
        launchIntentForPackage.putExtra(INTENT_KEY_CMD, str2);
        launchIntentForPackage.putExtra(INTENT_KEY_FROM_PKG, activity.getApplicationContext().getPackageName());
        if (str3.length() > 0) {
            launchIntentForPackage.setData(Uri.parse(str3));
        }
        sendIntent(activity, launchIntentForPackage);
    }

    static void sendMessageToService(int i) {
        if (getLite2Manager() != null) {
            getLite2Manager().sendMessage(i);
        }
    }

    public static void setActivityWindowFullscreen(final Activity activity) {
        activity.runOnUiThread(new Runnable() { // from class: com.picovr.picovrlib.VrLib.1
            @Override // java.lang.Runnable
            public void run() {
                activity.getWindow().addFlags(Util.BYTE_OF_KB);
            }
        });
    }

    public static void setCurrentLanguage(String str) {
        currentLanguage = str;
    }

    public static void setDoNotDisturbMode(Activity activity, boolean z) {
        IVRManagerPico iVRManagerPico = (IVRManagerPico) activity.getSystemService(IVRManagerPico.VR_MANAGER);
        if (iVRManagerPico == null) {
            return;
        }
        iVRManagerPico.setSystemOption(IVRManagerPico.VR_DO_NOT_DISTURB, z ? "1" : "0");
        iVRManagerPico.getSystemOption(IVRManagerPico.VR_DO_NOT_DISTURB);
    }

    public static int setSchedFifoStatic(Activity activity, int i, int i2) {
        getLite2Manager();
        return 1;
    }

    private static void setScreenMode(Activity activity, int i) {
        try {
            Settings.System.putInt(activity.getContentResolver(), "screen_brightness_mode", i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setSystemBrightness(Activity activity, int i) {
        IVRManagerPico iVRManagerPico = (IVRManagerPico) activity.getSystemService(IVRManagerPico.VR_MANAGER);
        if (iVRManagerPico == null) {
            return;
        }
        iVRManagerPico.setSystemOption(IVRManagerPico.VR_BRIGHTNESS, Integer.toString(i));
    }

    public static void setSystemBrightnessLite2(Activity activity, int i) {
        if (getScreenMode(activity) == 1) {
            setScreenMode(activity, 0);
        }
        saveScreenBrightness(activity, i);
    }

    public static int[] setSystemPerformanceStatic(Activity activity, int i, int i2) {
        IVRManagerPico iVRManagerPico = (IVRManagerPico) activity.getSystemService(IVRManagerPico.VR_MANAGER);
        if (iVRManagerPico == null) {
            return defaultClockFreq;
        }
        try {
            int[] SetVrClocks = iVRManagerPico.SetVrClocks(activity.getPackageName(), i, i2);
            for (int i3 = 0; i3 < SetVrClocks.length; i3++) {
            }
            return SetVrClocks;
        } catch (NoSuchMethodError unused) {
            int[] iArr = new int[4];
            iVRManagerPico.setFreq(activity.getPackageName(), i, i2);
            return iArr;
        }
    }

    public static void startBatteryReceiver(Activity activity) {
        if (batteryFilter == null) {
            batteryFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        }
        if (batteryReceiver == null) {
            batteryReceiver = new BatteryReceiver(null);
        }
        BatteryReceiver batteryReceiver2 = batteryReceiver;
        batteryReceiver2.act = activity;
        activity.registerReceiver(batteryReceiver2, batteryFilter);
        int i = 0;
        if (activity.getIntent().getBooleanExtra("present", false)) {
            int intExtra = activity.getIntent().getIntExtra("status", 0);
            int intExtra2 = activity.getIntent().getIntExtra("level", -1);
            int intExtra3 = activity.getIntent().getIntExtra("scale", -1);
            int intExtra4 = activity.getIntent().getIntExtra("temperature", 0);
            if (intExtra2 >= 0 && intExtra3 > 0) {
                i = (intExtra2 * 100) / intExtra3;
            }
            nativeBatteryEvent(intExtra, i, intExtra4);
        }
    }

    public static void startCellularReceiver(final Activity activity) {
        activity.runOnUiThread(new Thread() { // from class: com.picovr.picovrlib.VrLib.4
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                TelephonyManager telephonyManager = (TelephonyManager) activity.getSystemService("phone");
                if (VrLib.phoneListener == null) {
                    VrLib.phoneListener = new OvrPhoneStateListener(null);
                }
                telephonyManager.listen(VrLib.phoneListener, 257);
            }
        });
    }

    public static void startHeadsetReceiver(Activity activity) {
        if (headsetFilter == null) {
            headsetFilter = new IntentFilter("android.intent.action.HEADSET_PLUG");
        }
        if (headsetReceiver == null) {
            headsetReceiver = new HeadsetReceiver(null);
        }
        HeadsetReceiver headsetReceiver2 = headsetReceiver;
        headsetReceiver2.act = activity;
        activity.registerReceiver(headsetReceiver2, headsetFilter);
        nativeHeadsetEvent(activity.getIntent().getIntExtra("state", 0));
    }

    public static void startReceivers(Activity activity) {
        startBatteryReceiver(activity);
    }

    public static void startVolumeReceiver(Activity activity) {
        if (volumeFilter == null) {
            IntentFilter intentFilter = new IntentFilter();
            volumeFilter = intentFilter;
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        }
        if (volumeReceiver == null) {
            volumeReceiver = new VolumeReceiver(null);
        }
        VolumeReceiver volumeReceiver2 = volumeReceiver;
        volumeReceiver2.act = activity;
        activity.registerReceiver(volumeReceiver2, volumeFilter);
        ((AudioManager) activity.getSystemService(MimeTypes.BASE_TYPE_AUDIO)).getStreamVolume(3);
    }

    public static void startVsync(Activity activity) {
        activity.runOnUiThread(new Thread() { // from class: com.picovr.picovrlib.VrLib.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Choreographer choreographer = Choreographer.getInstance();
                VrLib.choreographerInstance = choreographer;
                choreographer.removeFrameCallback(VrLib.handler);
                VrLib.choreographerInstance.postFrameCallback(VrLib.handler);
            }
        });
    }

    public static void startWifiReceiver(Activity activity) {
        if (wifiFilter == null) {
            IntentFilter intentFilter = new IntentFilter();
            wifiFilter = intentFilter;
            intentFilter.addAction("android.net.wifi.RSSI_CHANGED");
            wifiFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        }
        if (wifiReceiver == null) {
            wifiReceiver = new WifiReceiver(null);
        }
        WifiReceiver wifiReceiver2 = wifiReceiver;
        wifiReceiver2.act = activity;
        activity.registerReceiver(wifiReceiver2, wifiFilter);
    }

    public static void stopBatteryReceiver(Activity activity) {
        activity.unregisterReceiver(batteryReceiver);
    }

    public static void stopCellularReceiver(final Activity activity) {
        activity.runOnUiThread(new Thread() { // from class: com.picovr.picovrlib.VrLib.5
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                ((TelephonyManager) activity.getSystemService("phone")).listen(VrLib.phoneListener, 0);
            }
        });
    }

    public static void stopHeadsetReceiver(Activity activity) {
        activity.unregisterReceiver(headsetReceiver);
    }

    public static void stopReceivers(Activity activity) {
        stopBatteryReceiver(activity);
    }

    public static void stopVolumeReceiver(Activity activity) {
        activity.unregisterReceiver(volumeReceiver);
    }

    public static void stopVsync(Activity activity) {
        activity.runOnUiThread(new Thread() { // from class: com.picovr.picovrlib.VrLib.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                VrLib.choreographerInstance.removeFrameCallback(VrLib.handler);
            }
        });
    }

    public static void stopWifiReceiver(Activity activity) {
        activity.unregisterReceiver(wifiReceiver);
    }

    public static String toFolderPathFormat(String str) {
        if (str == null || str.length() == 0) {
            return "/";
        }
        if (str.charAt(str.length() - 1) == '/') {
            return str;
        }
        return String.valueOf(str) + "/";
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        this.fps++;
        if (this.lastVsyncNano < 0) {
            this.lastVsyncNano = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - this.lastVsyncNano > 1000) {
            this.lastVsyncNano = System.currentTimeMillis();
            this.fps = 0;
        }
        nativeVsync(j);
        choreographerInstance.postFrameCallback(this);
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
    }

    /* loaded from: classes.dex */
    private static class WifiReceiver extends BroadcastReceiver {
        public Activity act;
        public int wifiLevel;
        public int wifiState;

        private WifiReceiver() {
            this.wifiLevel = 0;
            this.wifiState = 0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            this.act.runOnUiThread(new Runnable() { // from class: com.picovr.picovrlib.VrLib.WifiReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    if (intent.getAction() == "android.net.wifi.RSSI_CHANGED") {
                        int intExtra = intent.getIntExtra("newRssi", 0);
                        WifiReceiver.this.wifiLevel = WifiManager.calculateSignalLevel(intExtra, 5);
                        WifiReceiver wifiReceiver = WifiReceiver.this;
                        VrLib.nativeWifiEvent(wifiReceiver.wifiState, wifiReceiver.wifiLevel);
                        return;
                    }
                    if (intent.getAction() == "android.net.wifi.WIFI_STATE_CHANGED") {
                        WifiReceiver.this.wifiState = intent.getIntExtra("wifi_state", 0);
                        WifiReceiver wifiReceiver2 = WifiReceiver.this;
                        VrLib.nativeWifiEvent(wifiReceiver2.wifiState, wifiReceiver2.wifiLevel);
                    }
                }
            });
        }

        /* synthetic */ WifiReceiver(WifiReceiver wifiReceiver) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class BatteryReceiver extends BroadcastReceiver {
        public Activity act;
        public int batteryLevel;
        public int batteryStatus;
        public int batteryTemperature;

        private BatteryReceiver() {
            this.batteryLevel = 0;
            this.batteryStatus = 0;
            this.batteryTemperature = 0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            this.act.runOnUiThread(new Runnable() { // from class: com.picovr.picovrlib.VrLib.BatteryReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    int i = 0;
                    if (intent.getBooleanExtra("present", false)) {
                        int intExtra = intent.getIntExtra("status", 0);
                        int intExtra2 = intent.getIntExtra("level", -1);
                        int intExtra3 = intent.getIntExtra("scale", -1);
                        int intExtra4 = intent.getIntExtra("temperature", 0);
                        if (intExtra2 >= 0 && intExtra3 > 0) {
                            i = (intExtra2 * 100) / intExtra3;
                        }
                        BatteryReceiver batteryReceiver = BatteryReceiver.this;
                        if (intExtra == batteryReceiver.batteryStatus && i == batteryReceiver.batteryLevel && intExtra4 == batteryReceiver.batteryTemperature) {
                            return;
                        }
                        BatteryReceiver batteryReceiver2 = BatteryReceiver.this;
                        batteryReceiver2.batteryStatus = intExtra;
                        batteryReceiver2.batteryLevel = i;
                        batteryReceiver2.batteryTemperature = intExtra4;
                        VrLib.nativeBatteryEvent(intExtra, i, intExtra4);
                    }
                }
            });
        }

        /* synthetic */ BatteryReceiver(BatteryReceiver batteryReceiver) {
            this();
        }
    }
}
