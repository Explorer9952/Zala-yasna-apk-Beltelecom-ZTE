package com.google.vr.cardboard;

import android.net.Uri;

/* loaded from: classes.dex */
public class VrSettingsProviderContract {
    public static final String DAYDREAM_SETUP_COMPLETED = "daydream_setup";
    public static final String DEVICE_PARAMS_SETTING = "device_params";
    public static final String NFC_PARAMS_SETTING = "nfc_params";
    public static final String PHONE_PARAMS_SETTING = "phone_params";
    public static final String PROVIDER_INTENT_ACTION = "android.content.action.VR_SETTINGS_PROVIDER";
    public static final String SDK_CONFIGURATION_PARAMS_SETTING = "sdk_configuration_params";
    public static final String SETTING_VALUE_KEY = "value";
    public static final String VRCORE_AUTHORITY = "com.google.vr.vrcore.settings";

    public static Uri createUri(String str, String str2) {
        StringBuilder sb = new StringBuilder("content://".length() + 1 + String.valueOf(str).length() + String.valueOf(str2).length());
        sb.append("content://");
        sb.append(str);
        sb.append("/");
        sb.append(str2);
        return Uri.parse(sb.toString());
    }
}
