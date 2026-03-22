package android.app;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public interface IVRManagerPico {
    public static final String VR_BRIGHTNESS = "bright";
    public static final String VR_COMFORT_VIEW = "comfortable_view";
    public static final String VR_DO_NOT_DISTURB = "do_not_disturb_mode";
    public static final String VR_MANAGER = "vr_not_use_it";
    public static final String VR_OPTION_IPD = "ipd";

    int GetPowerLevelState();

    int[] SetVrClocks(String str, int i, int i2);

    Bitmap compositeSystemNotifications();

    boolean demoteProcessThread(String str, int i, int i2, int i3);

    boolean elevateProcessThread(String str, int i, int i2, int i3);

    String getOption(String str);

    String getSystemOption(String str);

    boolean isActive();

    boolean relFreq(String str);

    void reportApplicationInVR(String str, boolean z);

    int[] return2EnableFreqLev();

    boolean setFreq(String str, int i, int i2);

    void setOption(String str, String str2);

    void setSystemOption(String str, String str2);

    boolean setThreadSchedFifo(String str, int i, int i2, int i3);

    String vrManagerVersion();

    String vrOVRVersion();
}
