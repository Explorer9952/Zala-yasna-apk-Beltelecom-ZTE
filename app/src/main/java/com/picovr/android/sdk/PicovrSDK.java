package com.picovr.android.sdk;

/* loaded from: classes.dex */
public class PicovrSDK {

    /* loaded from: classes.dex */
    public enum DeviceTypes {
        UNKONWN,
        SAMSUNG_GEARVR2,
        PICOVR_I,
        SAMSUNG_GEARVR1,
        ANTVR_JT1,
        MOJING_2,
        MOJING_3,
        FALCON,
        PICO1S;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static DeviceTypes[] valuesCustom() {
            DeviceTypes[] valuesCustom = values();
            int length = valuesCustom.length;
            DeviceTypes[] deviceTypesArr = new DeviceTypes[length];
            System.arraycopy(valuesCustom, 0, deviceTypesArr, 0, length);
            return deviceTypesArr;
        }
    }

    static {
        System.loadLibrary("PicoPlugin");
    }

    public static native void changeHeadwear(int i);

    public static int getPsensor() {
        return getPsensorState();
    }

    public static native int getPsensorState();

    public static native String[] gethmdVersioninfo();

    public static native void setPupillaryPoint(boolean z);
}
