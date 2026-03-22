package com.google.vr.cardboard;

import android.os.Build;
import android.util.Log;
import com.google.protobuf.nano.MessageNano;
import com.google.vrtoolkit.cardboard.proto.nano.Phone;
import com.video.androidsdk.player.render.IRender;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class PhoneParams {
    private static final boolean DEBUG = false;
    private static final List PPI_OVERRIDES = Arrays.asList(new PpiOverride("Micromax", null, "4560MMX", null, IRender.PROJECTION_MODE_BULLET_TIME_9, IRender.PROJECTION_MODE_BULLET_TIME_9), new PpiOverride("HTC", "endeavoru", "HTC One X", null, 312, 312), new PpiOverride("samsung", null, "SM-G920P", null, 575, 575), new PpiOverride("samsung", null, "SM-G930", null, 581, 580), new PpiOverride("samsung", null, "SM-G9300", null, 581, 580), new PpiOverride("samsung", null, "SM-G930A", null, 581, 580), new PpiOverride("samsung", null, "SM-G930F", null, 581, 580), new PpiOverride("samsung", null, "SM-G930P", null, 581, 580), new PpiOverride("samsung", null, "SM-G930R4", null, 581, 580), new PpiOverride("samsung", null, "SM-G930T", null, 581, 580), new PpiOverride("samsung", null, "SM-G930V", null, 581, 580), new PpiOverride("samsung", null, "SM-G930W8", null, 581, 580), new PpiOverride("samsung", null, "SM-N915FY", null, 541, 541), new PpiOverride("samsung", null, "SM-N915A", null, 541, 541), new PpiOverride("samsung", null, "SM-N915T", null, 541, 541), new PpiOverride("samsung", null, "SM-N915K", null, 541, 541), new PpiOverride("samsung", null, "SM-N915T", null, 541, 541), new PpiOverride("samsung", null, "SM-N915G", null, 541, 541), new PpiOverride("samsung", null, "SM-N915D", null, 541, 541), new PpiOverride("BLU", "BLU", "Studio 5.0 HD LTE", "qcom", 294, 294), new PpiOverride("OnePlus", "A0001", "A0001", "bacon", 401, 401), new PpiOverride("THL", "THL", "thl 5000", "mt6592", 441, 441));
    private static final String TAG = "PhoneParams";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PpiOverride {
        String device;
        String hardware;
        String manufacturer;
        String model;
        int xPpi;
        int yPpi;

        PpiOverride(String str, String str2, String str3, String str4, int i, int i2) {
            this.manufacturer = str;
            this.device = str2;
            this.model = str3;
            this.hardware = str4;
            this.xPpi = i;
            this.yPpi = i2;
        }

        boolean isMatching(String str, String str2, String str3, String str4) {
            String str5 = this.manufacturer;
            if (str5 != null && !str5.equals(str)) {
                return false;
            }
            String str6 = this.device;
            if (str6 != null && !str6.equals(str2)) {
                return false;
            }
            String str7 = this.model;
            if (str7 != null && !str7.equals(str3)) {
                return false;
            }
            String str8 = this.hardware;
            return str8 == null || str8.equals(str4);
        }
    }

    private PhoneParams() {
    }

    public static Phone.PhoneParams getPpiOverride() {
        Phone.PhoneParams phoneParams = new Phone.PhoneParams();
        if (getPpiOverride(PPI_OVERRIDES, Build.MANUFACTURER, Build.DEVICE, Build.MODEL, Build.HARDWARE, phoneParams)) {
            return phoneParams;
        }
        return null;
    }

    static boolean getPpiOverride(List list, String str, String str2, String str3, String str4, Phone.PhoneParams phoneParams) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            PpiOverride ppiOverride = (PpiOverride) it2.next();
            if (ppiOverride.isMatching(str, str2, str3, str4)) {
                Log.d(TAG, String.format("Found override: {MANUFACTURER=%s, DEVICE=%s, MODEL=%s, HARDWARE=%s} : x_ppi=%d, y_ppi=%d", ppiOverride.manufacturer, ppiOverride.device, ppiOverride.model, ppiOverride.hardware, Integer.valueOf(ppiOverride.xPpi), Integer.valueOf(ppiOverride.yPpi)));
                phoneParams.setXPpi(ppiOverride.xPpi);
                phoneParams.setYPpi(ppiOverride.yPpi);
                return true;
            }
        }
        return false;
    }

    public static void registerOverrides() {
        registerOverridesInternal(PPI_OVERRIDES, Build.MANUFACTURER, Build.DEVICE, Build.MODEL, Build.HARDWARE);
    }

    static void registerOverridesInternal(List list, String str, String str2, String str3, String str4) {
        Phone.PhoneParams readPhoneParamsFromExternalStorage = ConfigUtils.readPhoneParamsFromExternalStorage();
        Phone.PhoneParams phoneParams = readPhoneParamsFromExternalStorage == null ? new Phone.PhoneParams() : readPhoneParamsFromExternalStorage.mo6clone();
        if (!getPpiOverride(list, str, str2, str3, str4, phoneParams) || MessageNano.messageNanoEquals(readPhoneParamsFromExternalStorage, phoneParams)) {
            return;
        }
        Log.i(TAG, "Applying phone param override.");
        ConfigUtils.writePhoneParamsToExternalStorage(phoneParams);
    }
}
