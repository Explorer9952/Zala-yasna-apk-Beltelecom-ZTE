package android.os.picovr;

import java.util.Map;

/* loaded from: classes.dex */
public abstract class PicoManager {
    public static final String DATA_HAPTICTHEME_DIALPAD = "data_haptictheme_dialpad";
    public static final String DATA_HAPTICTHEME_GALLERY = "data_haptictheme_gallery";
    public static final String DATA_HAPTICTHEME_LAUNCHER = "data_haptictheme_launcher";
    public static final String DATA_HAPTICTHEME_LONGPRESS = "data_haptictheme_longpress";
    public static final String DATA_HAPTICTHEME_MULTI_TOUCH = "data_haptictheme_multi_touch";
    public static final String DATA_HAPTICTHEME_ROTATE = "data_haptictheme_rotate";
    public static final String DATA_HAPTICTHEME_SCROLL = "data_haptictheme_scroll";
    public static final String DATA_HAPTICTHEME_SIP = "data_haptictheme_SIP";
    public static final String DATA_HAPTICTHEME_VIRTUALKEY = "data_haptictheme_virtualkey";
    public static final String DATA_HAPTIC_A2H = "haptic_A2H_data";
    public static final String DATA_HAPTIC_VIBRATE = "haptic_vibrate_data";
    public static final int HAPTICS_ALL = 3;
    public static final int HAPTICS_HAPTICTHEME_DIALPAD = 2;
    public static final int HAPTICS_HAPTICTHEME_GALLERY = 8;
    public static final int HAPTICS_HAPTICTHEME_LAUNCHER = 3;
    public static final int HAPTICS_HAPTICTHEME_LOCKSCREEN = 9;
    public static final int HAPTICS_HAPTICTHEME_LONGPRESS = 4;
    public static final int HAPTICS_HAPTICTHEME_MULTITOUCH = 11;
    public static final int HAPTICS_HAPTICTHEME_ROTATE = 7;
    public static final int HAPTICS_HAPTICTHEME_SCROLLING = 12;
    public static final int HAPTICS_HAPTICTHEME_SIP = 1;
    public static final int HAPTICS_HAPTICTHEME_TRY_UNLOCK = 10;
    public static final int HAPTICS_HAPTICTHEME_VIRTUALKEY = 5;
    public static final int HAPTICS_LEFT = 1;
    public static final int HAPTICS_RIGHT = 2;
    public static final int MIP4_MOUSE = 1;
    public static final int MIP4_TOUCH_TABLET = 0;

    public abstract void enableTouchPad(boolean z);

    public abstract String getDeviceProp(int i);

    public abstract String getDevicePropForUser(int i);

    public abstract int getHidSensorUser();

    public abstract Map getHmdParameters(String str);

    public abstract String[] getRingHapticsName();

    public abstract String getRingHapticsValue(int i);

    public abstract String[] getRingHapticsValues();

    public abstract Map getScreenParameters(String str);

    public abstract int getSystemRunLevel(int i);

    public abstract int getThreadRunCore(int i);

    public abstract int getTouchPadStatus();

    public abstract void playEffectSeqBuff(byte[] bArr, int i, int i2);

    public abstract void playEffectSequence(String str, int i);

    public abstract void playPatternRTP(int i, int i2, int i3, int i4, int i5);

    public abstract void playRTPSeqBuff(byte[] bArr, int i, int i2);

    public abstract void playRTPSequence(String str, int i);

    public abstract void playRingHaptics(int i, int i2);

    public abstract void playRingSeq(int i, int i2);

    public abstract void playTimedEffect(int i, int i2);

    public abstract void playeffect(int i, int i2);

    public abstract void playeffectforce(int i, int i2);

    public abstract boolean requestHidSensor(int i);

    public abstract void setAudioHapticEnabled(boolean z, int i);

    public abstract boolean setDeviceProp(int i, String str);

    public abstract boolean setDevicePropForUser(int i, String str);

    public abstract boolean setSystemRunLevel(int i, int i2);

    public abstract boolean setThreadRunCore(int i, int i2);

    public abstract void stopPlayingEffect(int i);

    public abstract void switchTouchType(int i);

    public abstract boolean updateHmdInfo(String[] strArr);

    public abstract boolean updateHmdPsensorStatus(int i);
}
