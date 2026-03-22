package com.google.vr.cardboard;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice;
import com.google.vrtoolkit.cardboard.proto.nano.Phone;

@UsedByNative
/* loaded from: classes.dex */
public class VrParamsProviderJni {
    private static final String TAG = "VrParamsProviderJni";
    private static volatile DisplayMetrics displayMetricsOverride;

    private static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = displayMetricsOverride;
        return displayMetrics != null ? displayMetrics : DisplayUtils.getDisplayMetrics(((WindowManager) context.getSystemService("window")).getDefaultDisplay());
    }

    private static native void nativeUpdateNativePhoneParamsPointer(long j, int i, int i2, float f, float f2);

    @UsedByNative
    private static byte[] readDeviceParams(Context context) {
        CardboardDevice.DeviceParams readDeviceParams = VrParamsProviderFactory.create(context).readDeviceParams();
        if (readDeviceParams == null) {
            return null;
        }
        return MessageNano.toByteArray(readDeviceParams);
    }

    @UsedByNative
    private static void readPhoneParams(Context context, long j) {
        if (context == null) {
            Log.w(TAG, "Missing context for phone params lookup. Results may be invalid.");
            updateNativePhoneParamsPointer(j, Resources.getSystem().getDisplayMetrics());
            return;
        }
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        Phone.PhoneParams readPhoneParams = VrParamsProviderFactory.create(context).readPhoneParams();
        if (readPhoneParams != null) {
            if (readPhoneParams.hasXPpi()) {
                displayMetrics.xdpi = readPhoneParams.getXPpi();
            }
            if (readPhoneParams.hasYPpi()) {
                displayMetrics.ydpi = readPhoneParams.getYPpi();
            }
        }
        updateNativePhoneParamsPointer(j, displayMetrics);
    }

    public static void setDisplayOverride(Display display) {
        displayMetricsOverride = display != null ? DisplayUtils.getDisplayMetrics(display) : null;
    }

    private static void updateNativePhoneParamsPointer(long j, DisplayMetrics displayMetrics) {
        nativeUpdateNativePhoneParamsPointer(j, displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.xdpi, displayMetrics.ydpi);
    }

    @UsedByNative
    private static boolean writeDeviceParams(Context context, byte[] bArr) {
        CardboardDevice.DeviceParams deviceParams;
        VrParamsProvider create = VrParamsProviderFactory.create(context);
        if (bArr != null) {
            try {
                deviceParams = (CardboardDevice.DeviceParams) MessageNano.mergeFrom(new CardboardDevice.DeviceParams(), bArr);
            } catch (InvalidProtocolBufferNanoException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 31);
                sb.append("Error parsing protocol buffer: ");
                sb.append(valueOf);
                Log.w(TAG, sb.toString());
                return false;
            }
        } else {
            deviceParams = null;
        }
        return create.writeDeviceParams(deviceParams);
    }
}
