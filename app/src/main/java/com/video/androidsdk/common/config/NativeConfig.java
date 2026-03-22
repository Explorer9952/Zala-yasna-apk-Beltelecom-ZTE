package com.video.androidsdk.common.config;

import com.video.androidsdk.common.util.TimeUtil;

/* loaded from: classes.dex */
public class NativeConfig {
    private static NativeConfig mInstance;
    private final String LOG_TAG = NativeConfig.class.getSimpleName();

    private void configureDST() {
        new DSTConfigurator(ConfigMgr.readPropertie("ZoneOffset"), ConfigMgr.readPropertie("ZoneID"), ConfigMgr.readPropertie("TimeOffset"), ConfigMgr.readPropertie("SummerStartTime"), ConfigMgr.readPropertie("SummerEndTime")).setDSTRules();
    }

    private void configureLocale() {
        TimeUtil.setLanguage(ConfigMgr.readPropertie("LocaleLang"));
    }

    public static NativeConfig getInstance() {
        if (mInstance == null) {
            mInstance = new NativeConfig();
        }
        return mInstance;
    }

    public void configure() {
        configureDST();
        configureLocale();
    }
}
